package org.chromium.net.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;
import org.chromium.net.CronetException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;

/* loaded from: classes9.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    private final Collection<Object> mAnnotations;
    private final CronetException mException;
    private final int mFinishedReason;
    private final RequestFinishedInfo.Metrics mMetrics;
    private final UrlResponseInfo mResponseInfo;
    private final String mUrl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    public RequestFinishedInfoImpl(String str, Collection<Object> collection, RequestFinishedInfo.Metrics metrics, int i10, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.mUrl = str;
        this.mAnnotations = collection;
        this.mMetrics = metrics;
        this.mFinishedReason = i10;
        this.mResponseInfo = urlResponseInfo;
        this.mException = cronetException;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public Collection<Object> getAnnotations() {
        Collection<Object> collection = this.mAnnotations;
        return collection == null ? Collections.emptyList() : collection;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public CronetException getException() {
        return this.mException;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public int getFinishedReason() {
        return this.mFinishedReason;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public RequestFinishedInfo.Metrics getMetrics() {
        return this.mMetrics;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public UrlResponseInfo getResponseInfo() {
        return this.mResponseInfo;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public String getUrl() {
        return this.mUrl;
    }
}
