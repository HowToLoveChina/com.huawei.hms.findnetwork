package org.chromium.net.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.ExperimentalBidirectionalStream;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;

/* loaded from: classes9.dex */
public abstract class CronetEngineBase extends ExperimentalCronetEngine {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Idempotency {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    public abstract ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i10, boolean z10, Collection<Object> collection, boolean z11, int i11, boolean z12, int i12);

    public abstract UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i10, Collection<Object> collection, boolean z10, boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, RequestFinishedInfo.Listener listener, int i13);

    @Override // org.chromium.net.ExperimentalCronetEngine, org.chromium.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return new UrlRequestBuilderImpl(str, callback, executor, this);
    }
}
