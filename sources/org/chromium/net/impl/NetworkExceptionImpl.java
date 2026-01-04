package org.chromium.net.impl;

import org.chromium.net.NetworkException;

/* loaded from: classes9.dex */
public class NetworkExceptionImpl extends NetworkException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final int mCronetInternalErrorCode;
    protected final int mErrorCode;

    public NetworkExceptionImpl(String str, int i10, int i11) {
        super(str, null);
        this.mErrorCode = i10;
        this.mCronetInternalErrorCode = i11;
    }

    @Override // org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    @Override // org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(super.getMessage());
        sb2.append(", ErrorCode=");
        sb2.append(this.mErrorCode);
        if (this.mCronetInternalErrorCode != 0) {
            sb2.append(", InternalErrorCode=");
            sb2.append(this.mCronetInternalErrorCode);
        }
        sb2.append(", Retryable=");
        sb2.append(immediatelyRetryable());
        return sb2.toString();
    }

    @Override // org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int i10 = this.mErrorCode;
        return i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 8;
    }
}
