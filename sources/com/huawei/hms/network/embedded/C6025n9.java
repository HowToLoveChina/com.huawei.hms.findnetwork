package com.huawei.hms.network.embedded;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.embedded.C6101t7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
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

/* renamed from: com.huawei.hms.network.embedded.n9 */
/* loaded from: classes8.dex */
public final class C6025n9 implements InterfaceC6023n7 {

    /* renamed from: b */
    public static final int f27592b = 20;

    /* renamed from: a */
    public final C6062q7 f27593a;

    public C6025n9(C6062q7 c6062q7) {
        this.f27593a = c6062q7;
    }

    /* renamed from: a */
    private int m34903a(C6127v7 c6127v7, int i10) {
        String strM35582b = c6127v7.m35582b(C6055q0.f27799f);
        if (strM35582b == null) {
            return i10;
        }
        if (strM35582b.matches("\\d+")) {
            return Integer.valueOf(strM35582b).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
    public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
        C6128v8 c6128v8Mo34044a;
        C6101t7 c6101t7M34904a;
        C6101t7 c6101t7Request = aVar.request();
        C5986k9 c5986k9 = (C5986k9) aVar;
        C5894d9 c5894d9M34629f = c5986k9.m34629f();
        StringBuffer stringBuffer = new StringBuffer("{");
        int i10 = 0;
        C6127v7 c6127v7 = null;
        while (true) {
            c5894d9M34629f.prepareToConnect(c6101t7Request);
            if (c5894d9M34629f.isCanceled()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    C6127v7 c6127v7M34621a = c5986k9.m34621a(c6101t7Request, c5894d9M34629f, null);
                    if (c6127v7 != null) {
                        c6127v7M34621a = c6127v7M34621a.m35574D().m35611c(c6127v7.m35574D().m35602a((AbstractC6140w7) null).m35605a()).m35605a();
                    }
                    c6127v7 = c6127v7M34621a;
                    c6128v8Mo34044a = AbstractC5879c8.f26567a.mo34044a(c6127v7);
                    c6101t7M34904a = m34904a(c6127v7, c6128v8Mo34044a != null ? c6128v8Mo34044a.m35619b().mo35837b() : null);
                } catch (C5866b9 e10) {
                    if (!m34905a(e10.m33903b(), c5894d9M34629f, false, c6101t7Request)) {
                        throw e10.m33901a();
                    }
                } catch (IOException e11) {
                    if (!m34905a(e11, c5894d9M34629f, true ^ (e11 instanceof C6064q9), c6101t7Request)) {
                        throw e11;
                    }
                }
                if (c6101t7M34904a == null) {
                    if (c6128v8Mo34044a != null && c6128v8Mo34044a.m35624f()) {
                        c5894d9M34629f.timeoutEarlyExit();
                    }
                    if (stringBuffer.length() <= 1) {
                        return c6127v7;
                    }
                    StringBuffer stringBufferDelete = stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
                    stringBufferDelete.append("}");
                    return c6127v7.m35574D().m35604a(C6096t2.f28331c0, stringBufferDelete.toString()).m35605a();
                }
                AbstractC6114u7 abstractC6114u7M35413b = c6101t7M34904a.m35413b();
                if (abstractC6114u7M35413b != null && abstractC6114u7M35413b.isOneShot()) {
                    return c6127v7;
                }
                C5920f8.m34248a(c6127v7.m35585s());
                if (c5894d9M34629f.hasExchange()) {
                    c6128v8Mo34044a.m35621c();
                }
                i10++;
                if (i10 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i10);
                }
                if (c6127v7.m35589w() >= 300 && c6127v7.m35589w() < 400) {
                    stringBuffer.append(c6101t7M34904a.m35423k().m34797h());
                    stringBuffer.append("=");
                    stringBuffer.append(c6127v7.m35589w());
                    stringBuffer.append(", ");
                }
                c6101t7Request = c6101t7M34904a;
            } finally {
                c5894d9M34629f.exchangeDoneDueToException();
            }
        }
    }

    /* renamed from: a */
    private C6101t7 m34904a(C6127v7 c6127v7, C6153x7 c6153x7) throws IOException {
        String strM35582b;
        C6010m7 c6010m7M34792d;
        if (c6127v7 == null) {
            throw new IllegalStateException();
        }
        int iM35589w = c6127v7.m35589w();
        String strM35420h = c6127v7.m35578H().m35420h();
        if (iM35589w == 307 || iM35589w == 308) {
            if (!strM35420h.equals("GET") && !strM35420h.equals("HEAD")) {
                return null;
            }
        } else {
            if (iM35589w == 401) {
                return this.f27593a.m35072a().mo35065b(c6153x7, c6127v7);
            }
            if (iM35589w == 503) {
                if ((c6127v7.m35575E() == null || c6127v7.m35575E().m35589w() != 503) && m34903a(c6127v7, Integer.MAX_VALUE) == 0) {
                    return c6127v7.m35578H();
                }
                return null;
            }
            if (iM35589w == 407) {
                if ((c6153x7 != null ? c6153x7.m35788b() : this.f27593a.m35099w()).type() == Proxy.Type.HTTP) {
                    return this.f27593a.m35100x().mo35065b(c6153x7, c6127v7);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iM35589w == 408) {
                if (!this.f27593a.m35068A()) {
                    return null;
                }
                AbstractC6114u7 abstractC6114u7M35413b = c6127v7.m35578H().m35413b();
                if (abstractC6114u7M35413b != null && abstractC6114u7M35413b.isOneShot()) {
                    return null;
                }
                if ((c6127v7.m35575E() == null || c6127v7.m35575E().m35589w() != 408) && m34903a(c6127v7, 0) <= 0) {
                    return c6127v7.m35578H();
                }
                return null;
            }
            switch (iM35589w) {
                case 300:
                case LocationRequest.PRIORITY_MAG_POSITION /* 301 */:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f27593a.m35089m() || (strM35582b = c6127v7.m35582b(ActivityRecognitionConstants.LOCATION_MODULE)) == null || (c6010m7M34792d = c6127v7.m35578H().m35423k().m34792d(strM35582b)) == null) {
            return null;
        }
        if (!c6010m7M34792d.m34808s().equals(c6127v7.m35578H().m35423k().m34808s()) && !this.f27593a.m35090n()) {
            return null;
        }
        C6101t7.a aVarM35421i = c6127v7.m35578H().m35421i();
        if (C5973j9.m34546b(strM35420h)) {
            boolean zM34548d = C5973j9.m34548d(strM35420h);
            if (C5973j9.m34547c(strM35420h)) {
                aVarM35421i.m35431a("GET", (AbstractC6114u7) null);
            } else {
                aVarM35421i.m35431a(strM35420h, zM34548d ? c6127v7.m35578H().m35413b() : null);
            }
            if (!zM34548d) {
                aVarM35421i.m35439b("Transfer-Encoding");
                aVarM35421i.m35439b("Content-Length");
                aVarM35421i.m35439b("Content-Type");
            }
        }
        if (!C5920f8.m34252a(c6127v7.m35578H().m35423k(), c6010m7M34792d)) {
            aVarM35421i.m35439b(FeedbackWebConstants.AUTHORIZATION);
        }
        return aVarM35421i.m35425a(c6010m7M34792d).m35436a();
    }

    /* renamed from: a */
    private boolean m34905a(IOException iOException, C5894d9 c5894d9, boolean z10, C6101t7 c6101t7) {
        if (c5894d9.getExchangeFinder() != null && c5894d9.getSelection() != null) {
            c5894d9.getSelection().m34072h();
        }
        if (this.f27593a.m35068A()) {
            return !(z10 && m34906a(iOException, c6101t7)) && m34907a(iOException, z10) && c5894d9.canRetry();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m34906a(IOException iOException, C6101t7 c6101t7) {
        AbstractC6114u7 abstractC6114u7M35413b = c6101t7.m35413b();
        return (abstractC6114u7M35413b != null && abstractC6114u7M35413b.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    /* renamed from: a */
    private boolean m34907a(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }
}
