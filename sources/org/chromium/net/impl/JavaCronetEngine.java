package org.chromium.net.impl;

import android.os.Process;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.ExperimentalBidirectionalStream;
import org.chromium.net.NetworkQualityRttListener;
import org.chromium.net.NetworkQualityThroughputListener;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;

/* loaded from: classes9.dex */
public final class JavaCronetEngine extends CronetEngineBase {
    private final ExecutorService mExecutorService;
    private final String mUserAgent;

    /* renamed from: org.chromium.net.impl.JavaCronetEngine$1 */
    public class ThreadFactoryC119951 implements ThreadFactory {
        final /* synthetic */ int val$threadPriority;

        /* renamed from: org.chromium.net.impl.JavaCronetEngine$1$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ Runnable val$r;

            public AnonymousClass1(Runnable runnable) {
                runnable = runnable;
            }

            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Thread.currentThread().setName("JavaCronetEngine");
                Process.setThreadPriority(i);
                runnable.run();
            }
        }

        public ThreadFactoryC119951(int i10) {
            i = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return Executors.defaultThreadFactory().newThread(new Runnable() { // from class: org.chromium.net.impl.JavaCronetEngine.1.1
                final /* synthetic */ Runnable val$r;

                public AnonymousClass1(Runnable runnable2) {
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() throws SecurityException, IllegalArgumentException {
                    Thread.currentThread().setName("JavaCronetEngine");
                    Process.setThreadPriority(i);
                    runnable.run();
                }
            });
        }
    }

    /* renamed from: org.chromium.net.impl.JavaCronetEngine$2 */
    public class C119962 implements URLStreamHandlerFactory {
        public C119962() {
        }

        @Override // java.net.URLStreamHandlerFactory
        public URLStreamHandler createURLStreamHandler(String str) {
            return null;
        }
    }

    public JavaCronetEngine(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        int iThreadPriority = cronetEngineBuilderImpl.threadPriority(9);
        this.mUserAgent = cronetEngineBuilderImpl.getUserAgent();
        this.mExecutorService = new ThreadPoolExecutor(10, 20, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: org.chromium.net.impl.JavaCronetEngine.1
            final /* synthetic */ int val$threadPriority;

            /* renamed from: org.chromium.net.impl.JavaCronetEngine$1$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ Runnable val$r;

                public AnonymousClass1(Runnable runnable2) {
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() throws SecurityException, IllegalArgumentException {
                    Thread.currentThread().setName("JavaCronetEngine");
                    Process.setThreadPriority(i);
                    runnable.run();
                }
            }

            public ThreadFactoryC119951(int iThreadPriority2) {
                i = iThreadPriority2;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable2) {
                return Executors.defaultThreadFactory().newThread(new Runnable() { // from class: org.chromium.net.impl.JavaCronetEngine.1.1
                    final /* synthetic */ Runnable val$r;

                    public AnonymousClass1(Runnable runnable22) {
                        runnable = runnable22;
                    }

                    @Override // java.lang.Runnable
                    public void run() throws SecurityException, IllegalArgumentException {
                        Thread.currentThread().setName("JavaCronetEngine");
                        Process.setThreadPriority(i);
                        runnable.run();
                    }
                });
            }
        });
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean z10, boolean z11, boolean z12) {
    }

    @Override // org.chromium.net.impl.CronetEngineBase
    public ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i10, boolean z10, Collection<Object> collection, boolean z11, int i11, boolean z12, int i12) {
        throw new UnsupportedOperationException("Can't create a bidi stream - httpurlconnection doesn't have those APIs");
    }

    @Override // org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i10, Collection<Object> collection, boolean z10, boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, RequestFinishedInfo.Listener listener, int i13) {
        return new JavaUrlRequest(callback, this.mExecutorService, executor, str, this.mUserAgent, z12, z13, i11, z14, i12);
    }

    @Override // org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new URLStreamHandlerFactory() { // from class: org.chromium.net.impl.JavaCronetEngine.2
            public C119962() {
            }

            @Override // java.net.URLStreamHandlerFactory
            public URLStreamHandler createURLStreamHandler(String str) {
                return null;
            }
        };
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        return -1;
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        return 0;
    }

    @Override // org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return new byte[0];
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        return -1;
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        return -1;
    }

    @Override // org.chromium.net.CronetEngine
    public String getVersionString() {
        return "CronetHttpURLConnection/" + ImplVersion.getCronetVersionWithLastChange();
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        throw new UnsupportedOperationException("The bidirectional stream API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // org.chromium.net.impl.CronetEngineBase, org.chromium.net.ExperimentalCronetEngine, org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return super.newUrlRequestBuilder(str, callback, executor);
    }

    @Override // org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url) throws IOException {
        return url.openConnection();
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void shutdown() {
        this.mExecutorService.shutdown();
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void startNetLogToDisk(String str, boolean z10, int i10) {
    }

    @Override // org.chromium.net.CronetEngine
    public void startNetLogToFile(String str, boolean z10) {
    }

    @Override // org.chromium.net.CronetEngine
    public void stopNetLog() {
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        return url.openConnection(proxy);
    }
}
