package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.bz */
/* loaded from: classes8.dex */
final class C5221bz {

    /* renamed from: a */
    private final List<C5183ap> f24088a;

    /* renamed from: b */
    private int f24089b = 0;

    /* renamed from: c */
    private boolean f24090c;

    /* renamed from: d */
    private boolean f24091d;

    public C5221bz(List<C5183ap> list) {
        this.f24088a = list;
    }

    /* renamed from: b */
    private boolean m31276b(SSLSocket sSLSocket) {
        for (int i10 = this.f24089b; i10 < this.f24088a.size(); i10++) {
            if (this.f24088a.get(i10).m30858a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public C5183ap m31277a(SSLSocket sSLSocket) throws IOException {
        C5183ap c5183ap;
        int i10 = this.f24089b;
        int size = this.f24088a.size();
        while (true) {
            if (i10 >= size) {
                c5183ap = null;
                break;
            }
            c5183ap = this.f24088a.get(i10);
            if (c5183ap.m30858a(sSLSocket)) {
                this.f24089b = i10 + 1;
                break;
            }
            i10++;
        }
        if (c5183ap != null) {
            this.f24090c = m31276b(sSLSocket);
            AbstractC5207bl.f23983a.mo31075a(c5183ap, sSLSocket, this.f24091d);
            return c5183ap;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f24091d + ", modes=" + this.f24088a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: a */
    public boolean m31278a(IOException iOException) {
        this.f24091d = true;
        if (!this.f24090c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
