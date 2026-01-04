package okhttp3.internal.connection;

import com.huawei.hms.network.embedded.C6167y8;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.AbstractC11953t;
import okhttp3.C11911b;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11923h;
import okhttp3.C11926i0;
import okhttp3.C11946m;
import okhttp3.C11954u;
import okhttp3.C11958y;
import okhttp3.EnumC11914c0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11944k;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11940n;
import p022ay.C1050a0;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;
import p693ux.InterfaceC13278c;
import p721vx.C13500a;
import p755wx.C13652a;
import p755wx.C13657f;
import p755wx.C13658g;
import p755wx.C13660i;
import p755wx.C13665n;
import p755wx.EnumC13653b;
import p791xx.C13893h;
import p858zx.C14403d;
import sx.AbstractC12871a;
import sx.C12875e;
import sx.C12876f;

/* renamed from: okhttp3.internal.connection.i */
/* loaded from: classes9.dex */
public final class C11935i extends C13657f.j implements InterfaceC11944k {

    /* renamed from: b */
    public final C11937k f55408b;

    /* renamed from: c */
    public C11926i0 f55409c;

    /* renamed from: d */
    public Socket f55410d;

    /* renamed from: e */
    public Socket f55411e;

    /* renamed from: f */
    public C11954u f55412f;

    /* renamed from: g */
    public EnumC11914c0 f55413g;

    /* renamed from: h */
    public C13657f f55414h;

    /* renamed from: i */
    public InterfaceC1056f f55415i;

    /* renamed from: j */
    public InterfaceC1055e f55416j;

    /* renamed from: k */
    public boolean f55417k;

    /* renamed from: l */
    public int f55418l;

    /* renamed from: m */
    public int f55419m;

    /* renamed from: n */
    public int f55420n;

    /* renamed from: o */
    public int f55421o = 1;

    /* renamed from: p */
    public final List<Reference<C11941o>> f55422p = new ArrayList();

    /* renamed from: q */
    public long f55423q = Long.MAX_VALUE;

    /* renamed from: r */
    public C11940n.a f55424r = null;

    /* renamed from: s */
    public C11929c f55425s = null;

    /* renamed from: t */
    public C11926i0 f55426t = null;

    /* renamed from: u */
    public long f55427u = 0;

    /* renamed from: v */
    public int f55428v = 0;

    /* renamed from: w */
    public int f55429w = 0;

    /* renamed from: x */
    public long f55430x = 0;

    public C11935i(C11937k c11937k, C11926i0 c11926i0) {
        this.f55408b = c11937k;
        this.f55409c = c11926i0;
    }

    @Override // okhttp3.InterfaceC11944k
    /* renamed from: a */
    public C11926i0 mo71709a() {
        return this.f55409c;
    }

    @Override // p755wx.C13657f.j
    /* renamed from: b */
    public void mo71710b(C13657f c13657f) {
        synchronized (this.f55408b) {
            this.f55421o = c13657f.m82083A();
        }
    }

    @Override // p755wx.C13657f.j
    /* renamed from: c */
    public void mo71711c(C13660i c13660i) throws IOException {
        c13660i.m82144d(EnumC13653b.REFUSED_STREAM, null);
    }

    /* renamed from: d */
    public void m71712d() throws IOException {
        C11929c c11929c = this.f55425s;
        if (c11929c != null) {
            c11929c.mo71644b();
        }
        C12875e.m77251h(this.f55410d);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00fa A[ORIG_RETURN, RETURN] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m71713e(int r15, int r16, int r17, int r18, int r19, boolean r20, okhttp3.InterfaceC11919f r21, okhttp3.AbstractC11953t r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C11935i.m71713e(int, int, int, int, int, boolean, okhttp3.f, okhttp3.t):void");
    }

    /* renamed from: f */
    public final void m71714f(int i10, int i11, int i12, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) throws IOException {
        long jCurrentTimeMillis;
        C11926i0 c11926i0M71771e;
        C11926i0 c11926i0 = this.f55426t;
        if (c11926i0 == null) {
            c11926i0 = this.f55409c;
        }
        Proxy proxyM71639b = c11926i0.m71639b();
        C11911b c11911bM71638a = c11926i0.m71638a();
        if (this.f55425s == null || this.f55426t != null) {
            this.f55410d = (proxyM71639b.type() == Proxy.Type.DIRECT || proxyM71639b.type() == Proxy.Type.HTTP) ? c11911bM71638a.m71459l().createSocket() : new Socket(proxyM71639b);
            abstractC11953t.connectStart(interfaceC11919f, this.f55409c.m71641d(), proxyM71639b);
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f55410d.setSoTimeout(i11);
            this.f55410d.setTrafficClass(i12);
            try {
                C13893h.m83291l().mo83253h(this.f55410d, c11926i0.m71641d(), i10);
            } catch (ConnectException e10) {
                ConnectException connectException = new ConnectException("Failed to connect to " + c11926i0.m71641d());
                connectException.initCause(e10);
                throw connectException;
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f55410d = this.f55425s.mo71648h(i10, c11911bM71638a.m71459l(), proxyM71639b, interfaceC11919f, abstractC11953t);
            if (this.f55425s.f55368l != null && (c11926i0M71771e = this.f55424r.m71771e()) != null) {
                this.f55424r.m71777k(new C11926i0(c11926i0M71771e.m71638a(), c11926i0M71771e.m71639b(), this.f55425s.f55368l));
            }
            C11940n.a aVar = this.f55424r;
            if (aVar != null) {
                aVar.m71778l(this.f55425s.mo71647f());
                Socket socket = this.f55410d;
                if (socket != null) {
                    this.f55424r.m71776j((InetSocketAddress) socket.getRemoteSocketAddress());
                }
            }
            if (this.f55410d == null) {
                throw new ConnectException("Failed to connect to host " + this.f55409c.m71638a().m71461n().m71904l());
            }
            C11926i0 c11926i02 = new C11926i0(this.f55409c.m71638a(), this.f55409c.m71639b(), (InetSocketAddress) this.f55410d.getRemoteSocketAddress());
            this.f55426t = c11926i02;
            this.f55409c = c11926i02;
            this.f55410d.setSoTimeout(i11);
            this.f55410d.setTrafficClass(i12);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f55427u = jCurrentTimeMillis2;
        if (i11 != 0) {
            this.f55429w = ((int) ((jCurrentTimeMillis2 * 4) + 1000)) / i11;
        }
        try {
            this.f55415i = C1064n.m6403b(C1064n.m6408g(this.f55410d));
            this.f55416j = C1064n.m6402a(C1064n.m6405d(this.f55410d));
        } catch (NullPointerException e11) {
            if (C6167y8.f29150y.equals(e11.getMessage())) {
                throw new IOException(e11);
            }
        }
    }

    /* renamed from: g */
    public final void m71715g(C11931e c11931e) throws Throwable {
        C11911b c11911bM71638a = this.f55409c.m71638a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) c11911bM71638a.m71460m().createSocket(this.f55410d, c11911bM71638a.m71461n().m71904l(), c11911bM71638a.m71461n().m71909w(), true);
                try {
                    String strM71452e = c11911bM71638a.m71452e();
                    if (strM71452e != null && strM71452e.length() != 0) {
                        strM71452e = C11958y.m71887k(c11911bM71638a.m71461n().m71896B() + "://" + strM71452e).m71904l();
                    }
                    if (strM71452e == null || strM71452e.length() == 0) {
                        strM71452e = c11911bM71638a.m71461n().m71904l();
                    }
                    C11946m c11946mM71678a = c11931e.m71678a(sSLSocket2);
                    if (c11946mM71678a.m71803f()) {
                        C13893h.m83291l().mo83244g(sSLSocket2, strM71452e, c11911bM71638a.m71454g());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    C11954u c11954uM71843b = C11954u.m71843b(session);
                    if (c11911bM71638a.m71453f().verify(strM71452e, session)) {
                        c11911bM71638a.m71448a().m71625a(c11911bM71638a.m71461n().m71904l(), c11954uM71843b.m71846d());
                        String strMo83245n = c11946mM71678a.m71803f() ? C13893h.m83291l().mo83245n(sSLSocket2) : null;
                        this.f55411e = sSLSocket2;
                        this.f55415i = C1064n.m6403b(C1064n.m6408g(sSLSocket2));
                        this.f55416j = C1064n.m6402a(C1064n.m6405d(this.f55411e));
                        this.f55412f = c11954uM71843b;
                        this.f55413g = strMo83245n != null ? EnumC11914c0.m71525b(strMo83245n) : EnumC11914c0.HTTP_1_1;
                        C13893h.m83291l().mo83277a(sSLSocket2);
                        return;
                    }
                    List<Certificate> listM71846d = c11954uM71843b.m71846d();
                    if (listM71846d.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + c11911bM71638a.m71461n().m71904l() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) listM71846d.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + strM71452e + " not verified:\n    certificate: " + C11923h.m71622c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + C14403d.m85632a(x509Certificate));
                } catch (AssertionError e10) {
                    e = e10;
                    if (!C12875e.m77230A(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        C13893h.m83291l().mo83277a(sSLSocket);
                    }
                    C12875e.m77251h(sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (AssertionError e11) {
            e = e11;
        }
    }

    /* renamed from: h */
    public final void m71716h(int i10, int i11, int i12, int i13, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) throws IOException {
        C11918e0 c11918e0M71718j = m71718j();
        C11958y c11958yM71573m = c11918e0M71718j.m71573m();
        for (int i14 = 0; i14 < 21; i14++) {
            m71714f(i10, i11, i13, interfaceC11919f, abstractC11953t);
            c11918e0M71718j = m71717i(i11, i12, c11918e0M71718j, c11958yM71573m);
            if (c11918e0M71718j == null) {
                return;
            }
            C12875e.m77251h(this.f55410d);
            this.f55410d = null;
            this.f55416j = null;
            this.f55415i = null;
            abstractC11953t.connectEnd(interfaceC11919f, this.f55409c.m71641d(), this.f55409c.m71639b(), null);
        }
    }

    /* renamed from: i */
    public final C11918e0 m71717i(int i10, int i11, C11918e0 c11918e0, C11958y c11958y) throws IOException {
        String str = "CONNECT " + C12875e.m77262s(c11958y, true) + " HTTP/1.1";
        while (true) {
            C13500a c13500a = new C13500a(null, null, this.f55415i, this.f55416j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f55415i.timeout().timeout(i10, timeUnit);
            this.f55416j.timeout().timeout(i11, timeUnit);
            c13500a.m81204B(c11918e0.m71566f(), str);
            c13500a.mo79701a();
            C11922g0 c11922g0M71605c = c13500a.mo79704d(false).m71620r(c11918e0).m71605c();
            c13500a.m81203A(c11922g0M71605c);
            int iM71597u = c11922g0M71605c.m71597u();
            if (iM71597u == 200) {
                if (this.f55415i.mo6324L().mo6325M() && this.f55416j.mo6323K().mo6325M()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM71597u != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c11922g0M71605c.m71597u());
            }
            C11918e0 c11918e0Mo71524c = this.f55409c.m71638a().m71456i().mo71524c(this.f55409c, c11922g0M71605c);
            if (c11918e0Mo71524c == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(c11922g0M71605c.m71599w("Connection"))) {
                return c11918e0Mo71524c;
            }
            c11918e0 = c11918e0Mo71524c;
        }
    }

    /* renamed from: j */
    public final C11918e0 m71718j() throws IOException {
        C11918e0 c11918e0M71575b = new C11918e0.a().m71588o(this.f55409c.m71638a().m71461n()).m71580g("CONNECT", null).m71578e(FeedbackWebConstants.HOST, C12875e.m77262s(this.f55409c.m71638a().m71461n(), true)).m71578e("Proxy-Connection", "Keep-Alive").m71578e("User-Agent", C12876f.m77270a()).m71575b();
        C11918e0 c11918e0Mo71524c = this.f55409c.m71638a().m71456i().mo71524c(this.f55409c, new C11922g0.a().m71620r(c11918e0M71575b).m71617o(EnumC11914c0.HTTP_1_1).m71609g(ErrorCode.ERROR_CODE_NO_SDKVERSION).m71614l("Preemptive Authenticate").m71604b(C12875e.f58643d).m71621s(-1L).m71618p(-1L).m71611i("Proxy-Authenticate", "OkHttp-Preemptive").m71605c());
        return c11918e0Mo71524c != null ? c11918e0Mo71524c : c11918e0M71575b;
    }

    /* renamed from: k */
    public final void m71719k(C11931e c11931e, int i10, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) throws Throwable {
        if (this.f55409c.m71638a().m71460m() != null) {
            abstractC11953t.secureConnectStart(interfaceC11919f);
            m71715g(c11931e);
            abstractC11953t.secureConnectEnd(interfaceC11919f, this.f55412f);
            if (this.f55413g == EnumC11914c0.HTTP_2) {
                m71732x(i10);
                return;
            }
            return;
        }
        List<EnumC11914c0> listM71454g = this.f55409c.m71638a().m71454g();
        EnumC11914c0 enumC11914c0 = EnumC11914c0.H2_PRIOR_KNOWLEDGE;
        if (!listM71454g.contains(enumC11914c0)) {
            this.f55411e = this.f55410d;
            this.f55413g = EnumC11914c0.HTTP_1_1;
        } else {
            this.f55411e = this.f55410d;
            this.f55413g = enumC11914c0;
            m71732x(i10);
        }
    }

    /* renamed from: l */
    public C11940n.a m71720l() {
        return this.f55424r;
    }

    /* renamed from: m */
    public C11954u m71721m() {
        return this.f55412f;
    }

    /* renamed from: n */
    public boolean m71722n(C11911b c11911b, List<C11926i0> list) {
        if (this.f55422p.size() >= this.f55421o || this.f55417k || !AbstractC12871a.f58633a.mo71500e(this.f55409c.m71638a(), c11911b)) {
            return false;
        }
        if (c11911b.m71461n().m71904l().equals(mo71709a().m71638a().m71461n().m71904l())) {
            return true;
        }
        if (this.f55414h == null || list == null || !m71729u(list) || c11911b.m71453f() != C14403d.f63771a || !m71733y(c11911b.m71461n())) {
            return false;
        }
        try {
            c11911b.m71448a().m71625a(c11911b.m71461n().m71904l(), m71721m().m71846d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: o */
    public boolean m71723o(boolean z10) throws SocketException {
        if (this.f55411e.isClosed() || this.f55411e.isInputShutdown() || this.f55411e.isOutputShutdown()) {
            return false;
        }
        C13657f c13657f = this.f55414h;
        if (c13657f != null) {
            return c13657f.m82107z(System.nanoTime());
        }
        if (z10) {
            try {
                int soTimeout = this.f55411e.getSoTimeout();
                try {
                    this.f55411e.setSoTimeout(1);
                    return !this.f55415i.mo6325M();
                } finally {
                    this.f55411e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    public boolean m71724p() {
        return this.f55414h != null;
    }

    /* renamed from: q */
    public InterfaceC13278c m71725q(C11912b0 c11912b0, InterfaceC11959z.a aVar) throws SocketException {
        if (this.f55414h != null) {
            return new C13658g(c11912b0, this, aVar, this.f55414h);
        }
        this.f55411e.setSoTimeout(aVar.mo71932a());
        C1050a0 c1050a0Timeout = this.f55415i.timeout();
        long jMo71932a = aVar.mo71932a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c1050a0Timeout.timeout(jMo71932a, timeUnit);
        this.f55416j.timeout().timeout(aVar.mo71933b(), timeUnit);
        return new C13500a(c11912b0, this, this.f55415i, this.f55416j);
    }

    /* renamed from: r */
    public void m71726r() {
        synchronized (this.f55408b) {
            this.f55417k = true;
        }
    }

    /* renamed from: s */
    public void m71727s(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        if (copyOnWriteArrayList != null) {
            this.f55425s = C11928b.m71663a(copyOnWriteArrayList, i10, i11);
        }
    }

    /* renamed from: t */
    public EnumC11914c0 m71728t() {
        return this.f55413g;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f55409c.m71638a().m71461n().m71904l());
        sb2.append(":");
        sb2.append(this.f55409c.m71638a().m71461n().m71909w());
        sb2.append(", proxy=");
        sb2.append(this.f55409c.m71639b());
        sb2.append(" hostAddress=");
        sb2.append(this.f55409c.m71641d());
        sb2.append(" cipherSuite=");
        C11954u c11954u = this.f55412f;
        sb2.append(c11954u != null ? c11954u.m71844a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f55413g);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: u */
    public final boolean m71729u(List<C11926i0> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            C11926i0 c11926i0 = list.get(i10);
            Proxy.Type type = c11926i0.m71639b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f55409c.m71639b().type() == type2 && this.f55409c.m71641d().equals(c11926i0.m71641d())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: v */
    public void m71730v(C11940n.a aVar) {
        this.f55424r = aVar;
    }

    /* renamed from: w */
    public Socket m71731w() {
        return this.f55411e;
    }

    /* renamed from: x */
    public final void m71732x(int i10) throws IOException {
        this.f55411e.setSoTimeout(0);
        C13657f c13657fM82108a = new C13657f.h(true).m82111d(this.f55411e, this.f55409c.m71638a().m71461n().m71904l(), this.f55415i, this.f55416j).m82109b(this).m82110c(i10).m82108a();
        this.f55414h = c13657fM82108a;
        c13657fM82108a.m82095Y();
    }

    /* renamed from: y */
    public boolean m71733y(C11958y c11958y) {
        if (c11958y.m71909w() != this.f55409c.m71638a().m71461n().m71909w()) {
            return false;
        }
        if (c11958y.m71904l().equals(this.f55409c.m71638a().m71461n().m71904l())) {
            return true;
        }
        return this.f55412f != null && C14403d.f63771a.m85634c(c11958y.m71904l(), (X509Certificate) this.f55412f.m71846d().get(0));
    }

    /* renamed from: z */
    public void m71734z(IOException iOException) {
        synchronized (this.f55408b) {
            try {
                if (iOException instanceof C13665n) {
                    EnumC13653b enumC13653b = ((C13665n) iOException).f61541a;
                    if (enumC13653b == EnumC13653b.REFUSED_STREAM) {
                        int i10 = this.f55420n + 1;
                        this.f55420n = i10;
                        if (i10 > 1) {
                            this.f55417k = true;
                            this.f55418l++;
                        }
                    } else if (enumC13653b != EnumC13653b.CANCEL) {
                        this.f55417k = true;
                        this.f55418l++;
                    }
                } else if (!m71724p() || (iOException instanceof C13652a)) {
                    this.f55417k = true;
                    if (this.f55419m == 0) {
                        if (iOException != null) {
                            this.f55408b.m71739e(this.f55409c, iOException);
                        }
                        this.f55418l++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
