package com.huawei.openalliance.p169ad.utils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* renamed from: com.huawei.openalliance.ad.utils.ac */
/* loaded from: classes2.dex */
public class C7729ac {
    /* renamed from: a */
    public static int m47431a(int i10) {
        return i10 == 404 ? 8 : 0;
    }

    /* renamed from: a */
    public static boolean m47432a(IOException iOException) {
        if (iOException == null) {
            return false;
        }
        int i10 = 0;
        for (IOException cause = iOException; cause != null && i10 < 10; cause = cause.getCause()) {
            if (m47433a((Throwable) cause)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m47433a(Throwable th2) {
        if (th2 == null) {
            return false;
        }
        return (th2 instanceof PortUnreachableException) || (th2 instanceof ConnectException) || (th2 instanceof HttpRetryException) || (th2 instanceof SocketTimeoutException) || (th2 instanceof UnknownHostException) || (th2 instanceof NoRouteToHostException) || (th2 instanceof UnknownServiceException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLKeyException) || (th2 instanceof SSLPeerUnverifiedException) || (th2 instanceof SSLProtocolException) || (th2 instanceof SSLHandshakeException) || (th2 instanceof SSLException);
    }
}
