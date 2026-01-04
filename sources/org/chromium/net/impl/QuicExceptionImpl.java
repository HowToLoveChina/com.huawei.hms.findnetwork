package org.chromium.net.impl;

import org.chromium.net.QuicException;

/* loaded from: classes9.dex */
public class QuicExceptionImpl extends QuicException {
    private final NetworkExceptionImpl mNetworkException;
    private final int mQuicDetailedErrorCode;

    public QuicExceptionImpl(String str, int i10, int i11, int i12) {
        super(str, null);
        this.mNetworkException = new NetworkExceptionImpl(str, i10, i11);
        this.mQuicDetailedErrorCode = i12;
    }

    @Override // org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mNetworkException.getCronetInternalErrorCode();
    }

    @Override // org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mNetworkException.getErrorCode();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mNetworkException.getMessage() + ", QuicDetailedErrorCode=" + this.mQuicDetailedErrorCode;
    }

    @Override // org.chromium.net.QuicException
    public int getQuicDetailedErrorCode() {
        return this.mQuicDetailedErrorCode;
    }

    @Override // org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        return this.mNetworkException.immediatelyRetryable();
    }
}
