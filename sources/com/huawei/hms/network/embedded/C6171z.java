package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.exception.NetworkCanceledException;
import com.huawei.hms.network.exception.NetworkInternalException;
import com.huawei.hms.network.exception.NetworkTimeoutException;
import com.huawei.hms.network.exception.NetworkUnsupportedException;
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

/* renamed from: com.huawei.hms.network.embedded.z */
/* loaded from: classes8.dex */
public class C6171z {

    /* renamed from: a */
    public static final String f29206a = "ErrorCodeUtil";

    /* renamed from: b */
    public static final int f29207b = 0;

    /* renamed from: c */
    public static final int f29208c = -1;

    /* renamed from: d */
    public static final int f29209d = 2;

    /* renamed from: e */
    public static final int f29210e = 3;

    /* renamed from: f */
    public static final int f29211f = 4;

    /* renamed from: g */
    public static final int f29212g = 5;

    /* renamed from: h */
    public static final int f29213h = 6;

    /* renamed from: i */
    public static final int f29214i = 7;

    /* renamed from: j */
    public static final int f29215j = 8;

    /* renamed from: k */
    public static final int f29216k = 9;

    /* renamed from: l */
    public static final int f29217l = 10;

    /* renamed from: m */
    public static final int f29218m = 11;

    /* renamed from: n */
    public static final int f29219n = 12;

    /* renamed from: o */
    public static final int f29220o = 13;

    /* renamed from: p */
    public static final int f29221p = 14;

    /* renamed from: a */
    public static int m35897a(int i10) {
        return i10 == 404 ? 8 : 0;
    }

    /* renamed from: a */
    public static int m35898a(IOException iOException) {
        if (iOException instanceof PortUnreachableException) {
            return 2;
        }
        if ((iOException instanceof ConnectException) || (iOException instanceof HttpRetryException)) {
            return 3;
        }
        if (iOException instanceof SocketTimeoutException) {
            return 4;
        }
        if (iOException instanceof UnknownHostException) {
            return 5;
        }
        if (iOException instanceof NoRouteToHostException) {
            return 6;
        }
        if (iOException instanceof UnknownServiceException) {
            return 7;
        }
        if (iOException instanceof ProtocolException) {
            return 9;
        }
        if (iOException instanceof SSLKeyException) {
            return 11;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return 12;
        }
        if (iOException instanceof SSLProtocolException) {
            return 13;
        }
        if (iOException instanceof SSLHandshakeException) {
            return 14;
        }
        if (iOException instanceof SSLException) {
            return 10;
        }
        Logger.m32147w("ErrorCodeUtil", "Request failed with %s", iOException.getClass().getName());
        return -1;
    }

    /* renamed from: a */
    public static int m35899a(Exception exc) {
        return exc instanceof NetworkCanceledException ? ExceptionCode.CANCEL : exc instanceof NetworkTimeoutException ? ExceptionCode.NETWORK_TIMEOUT : exc instanceof NetworkUnsupportedException ? ExceptionCode.NETWORK_UNSUPPORTED : exc instanceof NetworkInternalException ? ExceptionCode.CRASH_EXCEPTION : ExceptionCode.getErrorCodeFromException(exc);
    }
}
