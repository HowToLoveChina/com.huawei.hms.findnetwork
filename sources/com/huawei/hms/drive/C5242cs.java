package com.huawei.hms.drive;

import com.huawei.hms.drive.C5201bf;
import com.huawei.hms.drive.InterfaceC5196ba;
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

/* renamed from: com.huawei.hms.drive.cs */
/* loaded from: classes8.dex */
public final class C5242cs implements InterfaceC5196ba {

    /* renamed from: a */
    private final C5198bc f24227a;

    public C5242cs(C5198bc c5198bc) {
        this.f24227a = c5198bc;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba
    /* renamed from: a */
    public C5203bh mo31030a(InterfaceC5196ba.a aVar) throws IOException {
        C5224ca c5224caMo31073a;
        C5201bf c5201bfM31428a;
        C5201bf c5201bfMo31031a = aVar.mo31031a();
        C5239cp c5239cp = (C5239cp) aVar;
        C5232ci c5232ciM31422e = c5239cp.m31422e();
        StringBuffer stringBuffer = new StringBuffer("{");
        int i10 = 0;
        C5203bh c5203bh = null;
        while (true) {
            c5232ciM31422e.m31382a(c5201bfMo31031a);
            if (c5232ciM31422e.m31391i()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    C5203bh c5203bhM31421a = c5239cp.m31421a(c5201bfMo31031a, c5232ciM31422e, null);
                    if (c5203bh != null) {
                        c5203bhM31421a = c5203bhM31421a.m31134g().m31156c(c5203bh.m31134g().m31148a((AbstractC5204bi) null).m31151a()).m31151a();
                    }
                    c5203bh = c5203bhM31421a;
                    c5224caMo31073a = AbstractC5207bl.f23983a.mo31073a(c5203bh);
                    c5201bfM31428a = m31428a(c5203bh, c5224caMo31073a != null ? c5224caMo31073a.m31281a().m31327c() : null);
                } catch (C5230cg e10) {
                    if (!m31430a(e10.m31353b(), c5232ciM31422e, false, c5201bfMo31031a)) {
                        throw e10.m31351a();
                    }
                } catch (IOException e11) {
                    if (!m31430a(e11, c5232ciM31422e, true ^ (e11 instanceof C5245cv), c5201bfMo31031a)) {
                        throw e11;
                    }
                }
                if (c5201bfM31428a == null) {
                    if (c5224caMo31073a != null && c5224caMo31073a.m31287b()) {
                        c5232ciM31422e.m31384b();
                    }
                    if (stringBuffer.length() <= 1) {
                        return c5203bh;
                    }
                    StringBuffer stringBufferDelete = stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
                    stringBufferDelete.append("}");
                    return c5203bh.m31134g().m31155b(C6096t2.f28331c0, stringBufferDelete.toString()).m31151a();
                }
                AbstractC5202bg abstractC5202bgM31111d = c5201bfM31428a.m31111d();
                if (abstractC5202bgM31111d != null && abstractC5202bgM31111d.isOneShot()) {
                    return c5203bh;
                }
                C5210bo.m31191a(c5203bh.m31133f());
                if (c5232ciM31422e.m31389g()) {
                    c5224caMo31073a.m31293h();
                }
                i10++;
                if (i10 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i10);
                }
                if (c5203bh.m31129b() >= 300 && c5203bh.m31129b() < 400) {
                    stringBuffer.append(c5201bfM31428a.m31107a().m30970f());
                    stringBuffer.append("=");
                    stringBuffer.append(c5203bh.m31129b());
                    stringBuffer.append(", ");
                }
                c5201bfMo31031a = c5201bfM31428a;
            } finally {
                c5232ciM31422e.m31387e();
            }
        }
    }

    /* renamed from: a */
    private boolean m31430a(IOException iOException, C5232ci c5232ci, boolean z10, C5201bf c5201bf) {
        if (c5232ci.m31393k() != null && c5232ci.m31394l() != null) {
            c5232ci.m31394l().m31373f();
        }
        if (this.f24227a.m31066u()) {
            return !(z10 && m31429a(iOException, c5201bf)) && m31431a(iOException, z10) && c5232ci.m31388f();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m31429a(IOException iOException, C5201bf c5201bf) {
        AbstractC5202bg abstractC5202bgM31111d = c5201bf.m31111d();
        return (abstractC5202bgM31111d != null && abstractC5202bgM31111d.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    /* renamed from: a */
    private boolean m31431a(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: a */
    private C5201bf m31428a(C5203bh c5203bh, C5205bj c5205bj) throws IOException {
        String strM31127a;
        C5193az c5193azM30965c;
        Proxy proxyM31051f;
        if (c5203bh != null) {
            int iM31129b = c5203bh.m31129b();
            String strM31109b = c5203bh.m31126a().m31109b();
            if (iM31129b == 307 || iM31129b == 308) {
                if (!strM31109b.equals("GET") && !strM31109b.equals("HEAD")) {
                    return null;
                }
            } else {
                if (iM31129b == 401) {
                    return this.f24227a.m31060o().authenticate(c5205bj, c5203bh);
                }
                if (iM31129b == 503) {
                    if ((c5203bh.m31135h() == null || c5203bh.m31135h().m31129b() != 503) && m31427a(c5203bh, Integer.MAX_VALUE) == 0) {
                        return c5203bh.m31126a();
                    }
                    return null;
                }
                if (iM31129b == 407) {
                    if (c5205bj != null) {
                        proxyM31051f = c5205bj.m31163b();
                    } else {
                        proxyM31051f = this.f24227a.m31051f();
                    }
                    if (proxyM31051f.type() == Proxy.Type.HTTP) {
                        return this.f24227a.m31061p().authenticate(c5205bj, c5203bh);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iM31129b == 408) {
                    if (!this.f24227a.m31066u()) {
                        return null;
                    }
                    AbstractC5202bg abstractC5202bgM31111d = c5203bh.m31126a().m31111d();
                    if (abstractC5202bgM31111d != null && abstractC5202bgM31111d.isOneShot()) {
                        return null;
                    }
                    if ((c5203bh.m31135h() == null || c5203bh.m31135h().m31129b() != 408) && m31427a(c5203bh, 0) <= 0) {
                        return c5203bh.m31126a();
                    }
                    return null;
                }
                switch (iM31129b) {
                    case 300:
                    case LocationRequest.PRIORITY_MAG_POSITION /* 301 */:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f24227a.m31064s() || (strM31127a = c5203bh.m31127a(ActivityRecognitionConstants.LOCATION_MODULE)) == null || (c5193azM30965c = c5203bh.m31126a().m31107a().m30965c(strM31127a)) == null) {
                return null;
            }
            if (!c5193azM30965c.m30964b().equals(c5203bh.m31126a().m31107a().m30964b()) && !this.f24227a.m31063r()) {
                return null;
            }
            C5201bf.a aVarM31114g = c5203bh.m31126a().m31114g();
            if (C5238co.m31418c(strM31109b)) {
                boolean zM31419d = C5238co.m31419d(strM31109b);
                if (C5238co.m31420e(strM31109b)) {
                    aVarM31114g.m31121a("GET", (AbstractC5202bg) null);
                } else {
                    aVarM31114g.m31121a(strM31109b, zM31419d ? c5203bh.m31126a().m31111d() : null);
                }
                if (!zM31419d) {
                    aVarM31114g.m31124b("Transfer-Encoding");
                    aVarM31114g.m31124b("Content-Length");
                    aVarM31114g.m31124b("Content-Type");
                }
            }
            if (!C5210bo.m31195a(c5203bh.m31126a().m31107a(), c5193azM30965c)) {
                aVarM31114g.m31124b(FeedbackWebConstants.AUTHORIZATION);
            }
            return aVarM31114g.m31119a(c5193azM30965c).m31123a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private int m31427a(C5203bh c5203bh, int i10) {
        String strM31127a = c5203bh.m31127a(C6055q0.f27799f);
        if (strM31127a == null) {
            return i10;
        }
        if (strM31127a.matches("\\d+")) {
            return Integer.valueOf(strM31127a).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
