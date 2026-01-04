package p693ux;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.embedded.C6055q0;
import com.huawei.hms.network.embedded.C6096t2;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11926i0;
import okhttp3.C11958y;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11932f;
import okhttp3.internal.connection.C11939m;
import okhttp3.internal.connection.C11941o;
import p755wx.C13652a;
import sx.AbstractC12871a;
import sx.C12875e;

/* renamed from: ux.j */
/* loaded from: classes9.dex */
public final class C13285j implements InterfaceC11959z {

    /* renamed from: a */
    public final C11912b0 f60001a;

    public C13285j(C11912b0 c11912b0) {
        this.f60001a = c11912b0;
    }

    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public C11922g0 mo71677a(InterfaceC11959z.a aVar) throws IOException {
        C11932f c11932fMo71501f;
        C11918e0 c11918e0M79730b;
        C11918e0 c11918e0Request = aVar.request();
        C13282g c13282g = (C13282g) aVar;
        C11941o c11941oM79726g = c13282g.m79726g();
        StringBuffer stringBuffer = new StringBuffer("{");
        int i10 = 0;
        C11922g0 c11922g0 = null;
        while (true) {
            c11941oM79726g.prepareToConnect(c11918e0Request);
            if (c11941oM79726g.isCanceled()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    C11922g0 c11922g0M79725f = c13282g.m79725f(c11918e0Request, c11941oM79726g, null);
                    if (c11922g0 != null) {
                        c11922g0M79725f = c11922g0M79725f.m71589A().m71616n(c11922g0.m71589A().m71604b(null).m71605c()).m71605c();
                    }
                    c11922g0 = c11922g0M79725f;
                    c11932fMo71501f = AbstractC12871a.f58633a.mo71501f(c11922g0);
                    c11918e0M79730b = m79730b(c11922g0, c11932fMo71501f != null ? c11932fMo71501f.m71683c().mo71709a() : null);
                } catch (IOException e10) {
                    if (!m79732d(e10, c11941oM79726g, true ^ (e10 instanceof C13652a), c11918e0Request)) {
                        throw e10;
                    }
                } catch (C11939m e11) {
                    if (!m79732d(e11.m71757d(), c11941oM79726g, false, c11918e0Request)) {
                        throw e11.m71756c();
                    }
                }
                if (c11918e0M79730b == null) {
                    if (c11932fMo71501f != null && c11932fMo71501f.m71688h()) {
                        c11941oM79726g.timeoutEarlyExit();
                    }
                    if (stringBuffer.length() <= 1) {
                        return c11922g0;
                    }
                    StringBuffer stringBufferDelete = stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
                    stringBufferDelete.append("}");
                    return c11922g0.m71589A().m71603a(C6096t2.f28331c0, stringBufferDelete.toString()).m71605c();
                }
                AbstractC11920f0 abstractC11920f0M71562b = c11918e0M79730b.m71562b();
                if (abstractC11920f0M71562b != null && abstractC11920f0M71562b.isOneShot()) {
                    return c11922g0;
                }
                C12875e.m77250g(c11922g0.m71595s());
                if (c11941oM79726g.hasExchange()) {
                    c11932fMo71501f.m71685e();
                }
                i10++;
                if (i10 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i10);
                }
                if (c11922g0.m71597u() >= 300 && c11922g0.m71597u() < 400) {
                    stringBuffer.append(c11918e0M79730b.m71573m().m71904l());
                    stringBuffer.append("=");
                    stringBuffer.append(c11922g0.m71597u());
                    stringBuffer.append(", ");
                }
                c11918e0Request = c11918e0M79730b;
            } finally {
                c11941oM79726g.exchangeDoneDueToException();
            }
        }
    }

    /* renamed from: b */
    public final C11918e0 m79730b(C11922g0 c11922g0, C11926i0 c11926i0) throws IOException {
        String strM71599w;
        C11958y c11958yM71895A;
        if (c11922g0 == null) {
            throw new IllegalStateException();
        }
        int iM71597u = c11922g0.m71597u();
        String strM71569i = c11922g0.m71593E().m71569i();
        if (iM71597u == 307 || iM71597u == 308) {
            if (!strM71569i.equals("GET") && !strM71569i.equals("HEAD")) {
                return null;
            }
        } else {
            if (iM71597u == 401) {
                return this.f60001a.m71474c().mo71524c(c11926i0, c11922g0);
            }
            if (iM71597u == 503) {
                if ((c11922g0.m71590B() == null || c11922g0.m71590B().m71597u() != 503) && m79734f(c11922g0, Integer.MAX_VALUE) == 0) {
                    return c11922g0.m71593E();
                }
                return null;
            }
            if (iM71597u == 407) {
                if ((c11926i0 != null ? c11926i0.m71639b() : this.f60001a.m71465D()).type() == Proxy.Type.HTTP) {
                    return this.f60001a.m71466E().mo71524c(c11926i0, c11922g0);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iM71597u == 408) {
                if (!this.f60001a.m71469H()) {
                    return null;
                }
                AbstractC11920f0 abstractC11920f0M71562b = c11922g0.m71593E().m71562b();
                if (abstractC11920f0M71562b != null && abstractC11920f0M71562b.isOneShot()) {
                    return null;
                }
                if ((c11922g0.m71590B() == null || c11922g0.m71590B().m71597u() != 408) && m79734f(c11922g0, 0) <= 0) {
                    return c11922g0.m71593E();
                }
                return null;
            }
            switch (iM71597u) {
                case 300:
                case LocationRequest.PRIORITY_MAG_POSITION /* 301 */:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f60001a.m71485p() || (strM71599w = c11922g0.m71599w(ActivityRecognitionConstants.LOCATION_MODULE)) == null || (c11958yM71895A = c11922g0.m71593E().m71573m().m71895A(strM71599w)) == null) {
            return null;
        }
        if (!c11958yM71895A.m71896B().equals(c11922g0.m71593E().m71573m().m71896B()) && !this.f60001a.m71486q()) {
            return null;
        }
        C11918e0.a aVarM71570j = c11922g0.m71593E().m71570j();
        if (C13281f.m79720a(strM71569i)) {
            boolean zM79722c = C13281f.m79722c(strM71569i);
            if (C13281f.m79721b(strM71569i)) {
                aVarM71570j.m71580g("GET", null);
            } else {
                aVarM71570j.m71580g(strM71569i, zM79722c ? c11922g0.m71593E().m71562b() : null);
            }
            if (!zM79722c) {
                aVarM71570j.m71583j("Transfer-Encoding");
                aVarM71570j.m71583j("Content-Length");
                aVarM71570j.m71583j("Content-Type");
            }
        }
        if (!C12875e.m77235F(c11922g0.m71593E().m71573m(), c11958yM71895A)) {
            aVarM71570j.m71583j(FeedbackWebConstants.AUTHORIZATION);
        }
        return aVarM71570j.m71588o(c11958yM71895A).m71575b();
    }

    /* renamed from: c */
    public final boolean m79731c(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: d */
    public final boolean m79732d(IOException iOException, C11941o c11941o, boolean z10, C11918e0 c11918e0) {
        if (c11941o.getExchangeFinder() != null && c11941o.getSelection() != null) {
            c11941o.getSelection().m71774h();
        }
        if (this.f60001a.m71469H()) {
            return !(z10 && m79733e(iOException, c11918e0)) && m79731c(iOException, z10) && c11941o.canRetry();
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m79733e(IOException iOException, C11918e0 c11918e0) {
        AbstractC11920f0 abstractC11920f0M71562b = c11918e0.m71562b();
        return (abstractC11920f0M71562b != null && abstractC11920f0M71562b.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    /* renamed from: f */
    public final int m79734f(C11922g0 c11922g0, int i10) {
        String strM71599w = c11922g0.m71599w(C6055q0.f27799f);
        if (strM71599w == null) {
            return i10;
        }
        if (strM71599w.matches("\\d+")) {
            return Integer.valueOf(strM71599w).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
