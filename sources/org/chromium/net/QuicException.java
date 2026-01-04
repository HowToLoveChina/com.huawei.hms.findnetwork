package org.chromium.net;

/* loaded from: classes9.dex */
public abstract class QuicException extends NetworkException {
    public QuicException(String str, Throwable th2) {
        super(str, th2);
    }

    public abstract int getQuicDetailedErrorCode();
}
