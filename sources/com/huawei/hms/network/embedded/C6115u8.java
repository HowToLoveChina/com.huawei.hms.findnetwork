package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.network.embedded.u8 */
/* loaded from: classes8.dex */
public final class C6115u8 {

    /* renamed from: a */
    public final List<C5850a7> f28520a;

    /* renamed from: b */
    public int f28521b = 0;

    /* renamed from: c */
    public boolean f28522c;

    /* renamed from: d */
    public boolean f28523d;

    public C6115u8(List<C5850a7> list) {
        this.f28520a = list;
    }

    /* renamed from: b */
    private boolean m35508b(SSLSocket sSLSocket) {
        for (int i10 = this.f28521b; i10 < this.f28520a.size(); i10++) {
            if (this.f28520a.get(i10).m33815a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public C5850a7 m35509a(SSLSocket sSLSocket) throws IOException {
        C5850a7 c5850a7;
        int i10 = this.f28521b;
        int size = this.f28520a.size();
        while (true) {
            if (i10 >= size) {
                c5850a7 = null;
                break;
            }
            c5850a7 = this.f28520a.get(i10);
            i10++;
            if (c5850a7.m33815a(sSLSocket)) {
                this.f28521b = i10;
                break;
            }
        }
        if (c5850a7 != null) {
            this.f28522c = m35508b(sSLSocket);
            AbstractC5879c8.f26567a.mo34046a(c5850a7, sSLSocket, this.f28523d);
            return c5850a7;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f28523d + ", modes=" + this.f28520a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: a */
    public boolean m35510a(IOException iOException) {
        this.f28523d = true;
        if (!this.f28522c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
