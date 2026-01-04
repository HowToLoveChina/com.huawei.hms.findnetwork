package org.chromium.net.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.chromium.net.ApiVersion;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkQualityConnectionStatsListener;
import org.chromium.net.NetworkQualityRttListener;
import org.chromium.net.NetworkQualityThroughputListener;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* loaded from: classes9.dex */
public class VersionSafeCallbacks {

    public static final class BidirectionalStreamCallback extends BidirectionalStream.Callback {
        private final BidirectionalStream.Callback mWrappedCallback;

        public BidirectionalStreamCallback(BidirectionalStream.Callback callback) {
            this.mWrappedCallback = callback;
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onCanceled(bidirectionalStream, urlResponseInfo);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            this.mWrappedCallback.onFailed(bidirectionalStream, urlResponseInfo, cronetException);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z10) {
            this.mWrappedCallback.onReadCompleted(bidirectionalStream, urlResponseInfo, byteBuffer, z10);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onResponseHeadersReceived(bidirectionalStream, urlResponseInfo);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onResponseTrailersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlResponseInfo.HeaderBlock headerBlock) {
            this.mWrappedCallback.onResponseTrailersReceived(bidirectionalStream, urlResponseInfo, headerBlock);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream bidirectionalStream) {
            this.mWrappedCallback.onStreamReady(bidirectionalStream);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onSucceeded(bidirectionalStream, urlResponseInfo);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z10) {
            this.mWrappedCallback.onWriteCompleted(bidirectionalStream, urlResponseInfo, byteBuffer, z10);
        }
    }

    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        public LibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
            this.mWrappedLoader = libraryLoader;
        }

        @Override // org.chromium.net.CronetEngine.Builder.LibraryLoader
        public void loadLibrary(String str) {
            this.mWrappedLoader.loadLibrary(str);
        }
    }

    public static final class NetworkQualityConnectionStatsListenerWrapper {
        private final NetworkQualityConnectionStatsListenerProxy mWrappedListener;

        public NetworkQualityConnectionStatsListenerWrapper(NetworkQualityConnectionStatsListener networkQualityConnectionStatsListener) {
            if (SafeApi.apiAvailable()) {
                this.mWrappedListener = new NetworkQualityConnectionStatsListenerProxy(networkQualityConnectionStatsListener);
            } else {
                this.mWrappedListener = null;
            }
        }

        public boolean equals(Object obj) {
            NetworkQualityConnectionStatsListenerProxy networkQualityConnectionStatsListenerProxy = this.mWrappedListener;
            if (networkQualityConnectionStatsListenerProxy == null || obj == null || !(obj instanceof NetworkQualityConnectionStatsListenerWrapper)) {
                return false;
            }
            return networkQualityConnectionStatsListenerProxy.equals(((NetworkQualityConnectionStatsListenerWrapper) obj).mWrappedListener);
        }

        public Executor getExecutor() {
            NetworkQualityConnectionStatsListenerProxy networkQualityConnectionStatsListenerProxy = this.mWrappedListener;
            if (networkQualityConnectionStatsListenerProxy != null) {
                return networkQualityConnectionStatsListenerProxy.getExecutor();
            }
            return null;
        }

        public int hashCode() {
            NetworkQualityConnectionStatsListenerProxy networkQualityConnectionStatsListenerProxy = this.mWrappedListener;
            if (networkQualityConnectionStatsListenerProxy != null) {
                return networkQualityConnectionStatsListenerProxy.hashCode();
            }
            return 16711935;
        }

        public void onQuicStatsObservation(String str, int i10) {
            NetworkQualityConnectionStatsListenerProxy networkQualityConnectionStatsListenerProxy = this.mWrappedListener;
            if (networkQualityConnectionStatsListenerProxy != null) {
                networkQualityConnectionStatsListenerProxy.onQuicStatsObservation(str, i10);
            }
        }
    }

    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        public NetworkQualityRttListenerWrapper(NetworkQualityRttListener networkQualityRttListener) {
            super(networkQualityRttListener.getExecutor());
            this.mWrappedListener = networkQualityRttListener;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof NetworkQualityRttListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) obj).mWrappedListener);
        }

        @Override // org.chromium.net.NetworkQualityRttListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        @Override // org.chromium.net.NetworkQualityRttListener
        public void onRttObservation(int i10, long j10, int i11) {
            this.mWrappedListener.onRttObservation(i10, j10, i11);
        }
    }

    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        public NetworkQualityThroughputListenerWrapper(NetworkQualityThroughputListener networkQualityThroughputListener) {
            super(networkQualityThroughputListener.getExecutor());
            this.mWrappedListener = networkQualityThroughputListener;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof NetworkQualityThroughputListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) obj).mWrappedListener);
        }

        @Override // org.chromium.net.NetworkQualityThroughputListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        @Override // org.chromium.net.NetworkQualityThroughputListener
        public void onThroughputObservation(int i10, long j10, int i11) {
            this.mWrappedListener.onThroughputObservation(i10, j10, i11);
        }
    }

    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener listener) {
            super(listener.getExecutor());
            this.mWrappedListener = listener;
        }

        @Override // org.chromium.net.RequestFinishedInfo.Listener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        @Override // org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
            this.mWrappedListener.onRequestFinished(requestFinishedInfo);
        }
    }

    public static final class SafeApi {
        public static boolean apiAvailable() {
            return ImplVersion.getApiLevel() <= ApiVersion.getMaximumAvailableApiLevel();
        }
    }

    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        public UploadDataProviderWrapper(UploadDataProvider uploadDataProvider) {
            this.mWrappedProvider = uploadDataProvider;
        }

        @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mWrappedProvider.close();
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return this.mWrappedProvider.getLength();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
            this.mWrappedProvider.read(uploadDataSink, byteBuffer);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) throws IOException {
            this.mWrappedProvider.rewind(uploadDataSink);
        }
    }

    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback callback) {
            this.mWrappedCallback = callback;
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onCanceled(urlRequest, urlResponseInfo);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            this.mWrappedCallback.onFailed(urlRequest, urlResponseInfo, cronetException);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
            this.mWrappedCallback.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
            this.mWrappedCallback.onRedirectReceived(urlRequest, urlResponseInfo, str);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
            this.mWrappedCallback.onResponseStarted(urlRequest, urlResponseInfo);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onSucceeded(urlRequest, urlResponseInfo);
        }
    }

    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener statusListener) {
            this.mWrappedListener = statusListener;
        }

        @Override // org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int i10) {
            this.mWrappedListener.onStatus(i10);
        }
    }
}
