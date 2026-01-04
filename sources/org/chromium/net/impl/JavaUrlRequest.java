package org.chromium.net.impl;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.util.Log;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.net.CronetException;
import org.chromium.net.InlineExecutionProhibitedException;
import org.chromium.net.ThreadStatsUid;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.chromium.net.impl.JavaUrlRequestUtils;
import org.chromium.net.impl.VersionSafeCallbacks;

@TargetApi(14)
/* loaded from: classes9.dex */
final class JavaUrlRequest extends UrlRequestBase {
    private static final int DEFAULT_CHUNK_LENGTH = 8192;
    private static final String TAG = "JavaUrlRequest";
    private static final String USER_AGENT = "User-Agent";
    private static final String X_ANDROID = "X-Android";
    private static final String X_ANDROID_SELECTED_TRANSPORT = "X-Android-Selected-Transport";
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private ReadableByteChannel mResponseChannel;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;
    private final Map<String, String> mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final List<String> mUrlChain = new ArrayList();
    private final AtomicInteger mState = new AtomicInteger(0);
    private final AtomicBoolean mUploadProviderClosed = new AtomicBoolean(false);
    private volatile int mAdditionalStatusDetails = -1;

    public final class AsyncUrlRequestCallback {
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;

        public AsyncUrlRequestCallback(UrlRequest.Callback callback, Executor executor) {
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(callback);
            if (JavaUrlRequest.this.mAllowDirectExecutor) {
                this.mUserExecutor = executor;
                this.mFallbackExecutor = null;
            } else {
                this.mUserExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(executor);
                this.mFallbackExecutor = executor;
            }
        }

        public void execute(JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
            try {
                this.mUserExecutor.execute(JavaUrlRequest.this.userErrorSetting(checkedRunnable));
            } catch (RejectedExecutionException e10) {
                JavaUrlRequest.this.enterErrorState(new CronetExceptionImpl("Exception posting task to executor", e10));
            }
        }

        public void onCanceled(final UrlResponseInfo urlResponseInfo) {
            JavaUrlRequest.this.closeResponseChannel();
            this.mUserExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback asyncUrlRequestCallback = AsyncUrlRequestCallback.this;
                        asyncUrlRequestCallback.mCallback.onCanceled(JavaUrlRequest.this, urlResponseInfo);
                    } catch (Exception e10) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onCanceled method", e10);
                    }
                }
            });
        }

        public void onFailed(final UrlResponseInfo urlResponseInfo, final CronetException cronetException) {
            JavaUrlRequest.this.closeResponseChannel();
            Runnable runnable = new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback asyncUrlRequestCallback = AsyncUrlRequestCallback.this;
                        asyncUrlRequestCallback.mCallback.onFailed(JavaUrlRequest.this, urlResponseInfo, cronetException);
                    } catch (Exception e10) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onFailed method", e10);
                    }
                }
            };
            try {
                this.mUserExecutor.execute(runnable);
            } catch (InlineExecutionProhibitedException unused) {
                Executor executor = this.mFallbackExecutor;
                if (executor != null) {
                    executor.execute(runnable);
                }
            }
        }

        public void onReadCompleted(final UrlResponseInfo urlResponseInfo, final ByteBuffer byteBuffer) {
            execute(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.4
                @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    if (JavaUrlRequest.this.mState.compareAndSet(5, 4)) {
                        AsyncUrlRequestCallback asyncUrlRequestCallback = AsyncUrlRequestCallback.this;
                        asyncUrlRequestCallback.mCallback.onReadCompleted(JavaUrlRequest.this, urlResponseInfo, byteBuffer);
                    }
                }
            });
        }

        public void onRedirectReceived(final UrlResponseInfo urlResponseInfo, final String str) {
            execute(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.2
                @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    AsyncUrlRequestCallback asyncUrlRequestCallback = AsyncUrlRequestCallback.this;
                    asyncUrlRequestCallback.mCallback.onRedirectReceived(JavaUrlRequest.this, urlResponseInfo, str);
                }
            });
        }

        public void onResponseStarted(UrlResponseInfo urlResponseInfo) {
            execute(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.3
                @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    if (JavaUrlRequest.this.mState.compareAndSet(1, 4)) {
                        AsyncUrlRequestCallback asyncUrlRequestCallback = AsyncUrlRequestCallback.this;
                        VersionSafeCallbacks.UrlRequestCallback urlRequestCallback = asyncUrlRequestCallback.mCallback;
                        JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                        urlRequestCallback.onResponseStarted(javaUrlRequest, javaUrlRequest.mUrlResponseInfo);
                    }
                }
            });
        }

        public void onSucceeded(final UrlResponseInfo urlResponseInfo) {
            this.mUserExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback asyncUrlRequestCallback = AsyncUrlRequestCallback.this;
                        asyncUrlRequestCallback.mCallback.onSucceeded(JavaUrlRequest.this, urlResponseInfo);
                    } catch (Exception e10) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onSucceeded method", e10);
                    }
                }
            });
        }

        public void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, final int i10) {
            this.mUserExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    urlRequestStatusListener.onStatus(i10);
                }
            });
        }
    }

    public final class OutputStreamDataSink extends JavaUploadDataSinkBase {
        private WritableByteChannel mOutputChannel;
        private final AtomicBoolean mOutputChannelClosed;
        private final HttpURLConnection mUrlConnection;
        private OutputStream mUrlConnectionOutputStream;

        public OutputStreamDataSink(Executor executor, Executor executor2, HttpURLConnection httpURLConnection, VersionSafeCallbacks.UploadDataProviderWrapper uploadDataProviderWrapper) {
            super(executor, executor2, uploadDataProviderWrapper);
            this.mOutputChannelClosed = new AtomicBoolean(false);
            this.mUrlConnection = httpURLConnection;
        }

        public void closeOutputChannel() throws IOException {
            if (this.mOutputChannel == null || !this.mOutputChannelClosed.compareAndSet(false, true)) {
                return;
            }
            this.mOutputChannel.close();
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public void finish() throws IOException {
            closeOutputChannel();
            JavaUrlRequest.this.fireGetHeaders();
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
            return JavaUrlRequest.this.errorSetting(checkedRunnable);
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
            return JavaUrlRequest.this.uploadErrorSetting(checkedRunnable);
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public void initializeRead() throws IOException {
            if (this.mOutputChannel == null) {
                JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                this.mUrlConnection.setDoOutput(true);
                this.mUrlConnection.connect();
                JavaUrlRequest.this.mAdditionalStatusDetails = 12;
                OutputStream outputStream = this.mUrlConnection.getOutputStream();
                this.mUrlConnectionOutputStream = outputStream;
                this.mOutputChannel = Channels.newChannel(outputStream);
            }
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public void initializeStart(long j10) {
            if (j10 > 0 && j10 <= 2147483647L) {
                this.mUrlConnection.setFixedLengthStreamingMode((int) j10);
            } else if (j10 > 2147483647L) {
                this.mUrlConnection.setFixedLengthStreamingMode(j10);
            } else {
                this.mUrlConnection.setChunkedStreamingMode(8192);
            }
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public int processSuccessfulRead(ByteBuffer byteBuffer) throws IOException {
            int iWrite = 0;
            while (byteBuffer.hasRemaining()) {
                iWrite += this.mOutputChannel.write(byteBuffer);
            }
            this.mUrlConnectionOutputStream.flush();
            return iWrite;
        }

        @Override // org.chromium.net.impl.JavaUploadDataSinkBase
        public void processUploadError(Throwable th2) {
            JavaUrlRequest.this.enterUploadErrorState(th2);
        }
    }

    public static final class SerializingExecutor implements Executor {
        private boolean mRunning;
        private final Executor mUnderlyingExecutor;
        private final Runnable mRunTasks = new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.SerializingExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SerializingExecutor.this.mTaskQueue) {
                    try {
                        if (SerializingExecutor.this.mRunning) {
                            return;
                        }
                        Runnable runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                        SerializingExecutor.this.mRunning = runnable != null;
                        while (runnable != null) {
                            try {
                                runnable.run();
                                synchronized (SerializingExecutor.this.mTaskQueue) {
                                    runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                                    SerializingExecutor.this.mRunning = runnable != null;
                                }
                            } catch (Throwable th2) {
                                synchronized (SerializingExecutor.this.mTaskQueue) {
                                    SerializingExecutor.this.mRunning = false;
                                    try {
                                        SerializingExecutor.this.mUnderlyingExecutor.execute(SerializingExecutor.this.mRunTasks);
                                    } catch (RejectedExecutionException unused) {
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        };
        private final ArrayDeque<Runnable> mTaskQueue = new ArrayDeque<>();

        public SerializingExecutor(Executor executor) {
            this.mUnderlyingExecutor = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            synchronized (this.mTaskQueue) {
                this.mTaskQueue.addLast(runnable);
                try {
                    this.mUnderlyingExecutor.execute(this.mRunTasks);
                } catch (RejectedExecutionException unused) {
                    this.mTaskQueue.removeLast();
                }
            }
        }
    }

    public JavaUrlRequest(UrlRequest.Callback callback, final Executor executor, Executor executor2, String str, String str2, boolean z10, boolean z11, int i10, final boolean z12, final int i11) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        if (executor2 == null) {
            throw new NullPointerException("userExecutor is required");
        }
        this.mAllowDirectExecutor = z10;
        this.mCallbackAsync = new AsyncUrlRequestCallback(callback, executor2);
        final int threadStatsTag = z11 ? i10 : TrafficStats.getThreadStatsTag();
        this.mExecutor = new SerializingExecutor(new Executor() { // from class: org.chromium.net.impl.JavaUrlRequest.1
            @Override // java.util.concurrent.Executor
            public void execute(final Runnable runnable) {
                executor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        int threadStatsTag2 = TrafficStats.getThreadStatsTag();
                        TrafficStats.setThreadStatsTag(threadStatsTag);
                        ExecutorC120011 executorC120011 = ExecutorC120011.this;
                        if (z12) {
                            ThreadStatsUid.set(i11);
                        }
                        try {
                            runnable.run();
                        } finally {
                            if (z12) {
                                ThreadStatsUid.clear();
                            }
                            TrafficStats.setThreadStatsTag(threadStatsTag2);
                        }
                    }
                });
            }
        });
        this.mCurrentUrl = str;
        this.mUserAgent = str2;
    }

    private void checkNotStarted() {
        int i10 = this.mState.get();
        if (i10 == 0) {
            return;
        }
        throw new IllegalStateException("Request is already started. State is: " + i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeResponseChannel() {
        this.mExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.13
            @Override // java.lang.Runnable
            public void run() throws IOException {
                if (JavaUrlRequest.this.mResponseChannel != null) {
                    try {
                        JavaUrlRequest.this.mResponseChannel.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    JavaUrlRequest.this.mResponseChannel = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterCronetErrorState(Throwable th2) {
        enterErrorState(new CronetExceptionImpl("System error", th2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterErrorState(CronetException cronetException) {
        if (setTerminalState(6)) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onFailed(this.mUrlResponseInfo, cronetException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterUploadErrorState(Throwable th2) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", th2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterUserErrorState(Throwable th2) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", th2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable errorSetting(final JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th2) {
                    JavaUrlRequest.this.enterCronetErrorState(th2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireCloseUploadDataProvider() {
        if (this.mUploadDataProvider == null || !this.mUploadProviderClosed.compareAndSet(false, true)) {
            return;
        }
        try {
            this.mUploadExecutor.execute(uploadErrorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.5
                @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    JavaUrlRequest.this.mUploadDataProvider.close();
                }
            }));
        } catch (RejectedExecutionException e10) {
            Log.e(TAG, "Exception when closing uploadDataProvider", e10);
        }
    }

    private void fireDisconnect() {
        this.mExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.12
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mOutputStreamDataSink != null) {
                    try {
                        JavaUrlRequest.this.mOutputStreamDataSink.closeOutputChannel();
                    } catch (IOException e10) {
                        Log.e(JavaUrlRequest.TAG, "Exception when closing OutputChannel", e10);
                    }
                }
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireGetHeaders() {
        this.mAdditionalStatusDetails = 13;
        this.mExecutor.execute(errorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.4
            @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
            public void run() throws Exception {
                List<String> list;
                if (JavaUrlRequest.this.mCurrentUrlConnection == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                String headerField = "http/1.1";
                int i10 = 0;
                while (true) {
                    String headerFieldKey = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderFieldKey(i10);
                    if (headerFieldKey == null) {
                        break;
                    }
                    if (JavaUrlRequest.X_ANDROID_SELECTED_TRANSPORT.equalsIgnoreCase(headerFieldKey)) {
                        headerField = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i10);
                    }
                    if (!headerFieldKey.startsWith(JavaUrlRequest.X_ANDROID)) {
                        arrayList.add(new AbstractMap.SimpleEntry(headerFieldKey, JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i10)));
                    }
                    i10++;
                }
                int responseCode = JavaUrlRequest.this.mCurrentUrlConnection.getResponseCode();
                JavaUrlRequest.this.mUrlResponseInfo = new UrlResponseInfoImpl(new ArrayList(JavaUrlRequest.this.mUrlChain), responseCode, JavaUrlRequest.this.mCurrentUrlConnection.getResponseMessage(), Collections.unmodifiableList(arrayList), false, headerField, "", 0L);
                if (responseCode >= 300 && responseCode < 400 && (list = JavaUrlRequest.this.mUrlResponseInfo.getAllHeaders().get(JsbMapKeyNames.H5_LOC)) != null) {
                    JavaUrlRequest.this.fireRedirectReceived(list.get(0));
                    return;
                }
                JavaUrlRequest.this.fireCloseUploadDataProvider();
                if (responseCode < 400) {
                    JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                    javaUrlRequest.mResponseChannel = InputStreamChannel.wrap(javaUrlRequest.mCurrentUrlConnection.getInputStream());
                    JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                } else {
                    InputStream errorStream = JavaUrlRequest.this.mCurrentUrlConnection.getErrorStream();
                    JavaUrlRequest.this.mResponseChannel = errorStream == null ? null : InputStreamChannel.wrap(errorStream);
                    JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOpenConnection() {
        this.mExecutor.execute(errorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.7
            @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
            public void run() throws Exception {
                if (JavaUrlRequest.this.mState.get() == 8) {
                    return;
                }
                URL url = new URL(JavaUrlRequest.this.mCurrentUrl);
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
                JavaUrlRequest.this.mCurrentUrlConnection = (HttpURLConnection) url.openConnection();
                JavaUrlRequest.this.mCurrentUrlConnection.setInstanceFollowRedirects(false);
                if (!JavaUrlRequest.this.mRequestHeaders.containsKey(JavaUrlRequest.USER_AGENT)) {
                    JavaUrlRequest.this.mRequestHeaders.put(JavaUrlRequest.USER_AGENT, JavaUrlRequest.this.mUserAgent);
                }
                for (Map.Entry entry : JavaUrlRequest.this.mRequestHeaders.entrySet()) {
                    JavaUrlRequest.this.mCurrentUrlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (JavaUrlRequest.this.mInitialMethod == null) {
                    JavaUrlRequest.this.mInitialMethod = "GET";
                }
                JavaUrlRequest.this.mCurrentUrlConnection.setRequestMethod(JavaUrlRequest.this.mInitialMethod);
                if (JavaUrlRequest.this.mUploadDataProvider != null) {
                    JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                    javaUrlRequest.mOutputStreamDataSink = javaUrlRequest.new OutputStreamDataSink(javaUrlRequest.mUploadExecutor, JavaUrlRequest.this.mExecutor, JavaUrlRequest.this.mCurrentUrlConnection, JavaUrlRequest.this.mUploadDataProvider);
                    JavaUrlRequest.this.mOutputStreamDataSink.start(JavaUrlRequest.this.mUrlChain.size() == 1);
                } else {
                    JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                    JavaUrlRequest.this.mCurrentUrlConnection.connect();
                    JavaUrlRequest.this.fireGetHeaders();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRedirectReceived(final String str) {
        transitionStates(1, 2, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                javaUrlRequest.mPendingRedirectUrl = URI.create(javaUrlRequest.mCurrentUrl).resolve(str).toString();
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mPendingRedirectUrl);
                JavaUrlRequest.this.transitionStates(2, 3, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JavaUrlRequest.this.mCallbackAsync.onRedirectReceived(JavaUrlRequest.this.mUrlResponseInfo, JavaUrlRequest.this.mPendingRedirectUrl);
                    }
                });
            }
        });
    }

    private boolean isValidHeaderName(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != ',' && cCharAt != '/' && cCharAt != '{' && cCharAt != '}') {
                switch (cCharAt) {
                    case '\'':
                    case '(':
                    case ')':
                        break;
                    default:
                        switch (cCharAt) {
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                                break;
                            default:
                                switch (cCharAt) {
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                    default:
                                        if (Character.isISOControl(cCharAt) || Character.isWhitespace(cCharAt)) {
                                            break;
                                        }
                                        break;
                                }
                        }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processReadResult(int i10, ByteBuffer byteBuffer) throws IOException {
        if (i10 != -1) {
            this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, byteBuffer);
            return;
        }
        ReadableByteChannel readableByteChannel = this.mResponseChannel;
        if (readableByteChannel != null) {
            readableByteChannel.close();
        }
        if (this.mState.compareAndSet(5, 7)) {
            fireDisconnect();
            this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        }
    }

    private boolean setTerminalState(int i10) {
        int i11;
        do {
            i11 = this.mState.get();
            if (i11 == 0) {
                throw new IllegalStateException("Can't enter error state before start");
            }
            if (i11 == 6 || i11 == 7 || i11 == 8) {
                return false;
            }
        } while (!this.mState.compareAndSet(i11, i10));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionStates(int i10, int i11, Runnable runnable) {
        if (this.mState.compareAndSet(i10, i11)) {
            runnable.run();
            return;
        }
        int i12 = this.mState.get();
        if (i12 == 8 || i12 == 6) {
            return;
        }
        throw new IllegalStateException("Invalid state transition - expected " + i10 + " but was " + i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable uploadErrorSetting(final JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th2) {
                    JavaUrlRequest.this.enterUploadErrorState(th2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable userErrorSetting(final JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th2) {
                    JavaUrlRequest.this.enterUserErrorState(th2);
                }
            }
        };
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (isValidHeaderName(str) && !str2.contains("\r\n")) {
            if (this.mRequestHeaders.containsKey(str)) {
                this.mRequestHeaders.remove(str);
            }
            this.mRequestHeaders.put(str, str2);
        } else {
            throw new IllegalArgumentException("Invalid header " + str + "=" + str2);
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void cancel() {
        int andSet = this.mState.getAndSet(8);
        if (andSet == 1 || andSet == 2 || andSet == 3 || andSet == 4 || andSet == 5) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void followRedirect() {
        transitionStates(3, 1, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                javaUrlRequest.mCurrentUrl = javaUrlRequest.mPendingRedirectUrl;
                JavaUrlRequest.this.mPendingRedirectUrl = null;
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    @Override // org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener statusListener) {
        int i10 = this.mState.get();
        int i11 = this.mAdditionalStatusDetails;
        switch (i10) {
            case 0:
            case 6:
            case 7:
            case 8:
                i11 = -1;
                break;
            case 1:
                break;
            case 2:
            case 3:
            case 4:
                i11 = 0;
                break;
            case 5:
                i11 = 14;
                break;
            default:
                throw new IllegalStateException("Switch is exhaustive: " + i10);
        }
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(statusListener), i11);
    }

    @Override // org.chromium.net.UrlRequest
    public boolean isDone() {
        int i10 = this.mState.get();
        return i10 == 7 || i10 == 6 || i10 == 8;
    }

    @Override // org.chromium.net.UrlRequest
    public void read(final ByteBuffer byteBuffer) {
        Preconditions.checkDirect(byteBuffer);
        Preconditions.checkHasRemaining(byteBuffer);
        transitionStates(4, 5, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.11
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.11.1
                    @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                    public void run() throws Exception {
                        int i10 = JavaUrlRequest.this.mResponseChannel == null ? -1 : JavaUrlRequest.this.mResponseChannel.read(byteBuffer);
                        RunnableC1200311 runnableC1200311 = RunnableC1200311.this;
                        JavaUrlRequest.this.processReadResult(i10, byteBuffer);
                    }
                }));
            }
        });
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        if ("OPTIONS".equalsIgnoreCase(str) || "GET".equalsIgnoreCase(str) || "HEAD".equalsIgnoreCase(str) || "POST".equalsIgnoreCase(str) || "PUT".equalsIgnoreCase(str) || "DELETE".equalsIgnoreCase(str) || "TRACE".equalsIgnoreCase(str) || RequestMethod.PATCH.equalsIgnoreCase(str)) {
            this.mInitialMethod = str;
            return;
        }
        throw new IllegalArgumentException("Invalid http method " + str);
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (!this.mRequestHeaders.containsKey("Content-Type")) {
            throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
        }
        checkNotStarted();
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(uploadDataProvider);
        if (this.mAllowDirectExecutor) {
            this.mUploadExecutor = executor;
        } else {
            this.mUploadExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(executor);
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void start() {
        this.mAdditionalStatusDetails = 10;
        transitionStates(0, 1, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mCurrentUrl);
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }
}
