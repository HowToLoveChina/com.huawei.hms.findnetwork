package okhttp3.internal.connection;

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
import okhttp3.C11946m;
import sx.AbstractC12871a;

/* renamed from: okhttp3.internal.connection.e */
/* loaded from: classes9.dex */
public final class C11931e {

    /* renamed from: a */
    public final List<C11946m> f55375a;

    /* renamed from: b */
    public int f55376b = 0;

    /* renamed from: c */
    public boolean f55377c;

    /* renamed from: d */
    public boolean f55378d;

    public C11931e(List<C11946m> list) {
        this.f55375a = list;
    }

    /* renamed from: a */
    public C11946m m71678a(SSLSocket sSLSocket) throws IOException {
        C11946m c11946m;
        int i10 = this.f55376b;
        int size = this.f55375a.size();
        while (true) {
            if (i10 >= size) {
                c11946m = null;
                break;
            }
            c11946m = this.f55375a.get(i10);
            if (c11946m.m71800c(sSLSocket)) {
                this.f55376b = i10 + 1;
                break;
            }
            i10++;
        }
        if (c11946m != null) {
            this.f55377c = m71680c(sSLSocket);
            AbstractC12871a.f58633a.mo71498c(c11946m, sSLSocket, this.f55378d);
            return c11946m;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f55378d + ", modes=" + this.f55375a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: b */
    public boolean m71679b(IOException iOException) {
        this.f55378d = true;
        if (!this.f55377c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }

    /* renamed from: c */
    public final boolean m71680c(SSLSocket sSLSocket) {
        for (int i10 = this.f55376b; i10 < this.f55375a.size(); i10++) {
            if (this.f55375a.get(i10).m71800c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
