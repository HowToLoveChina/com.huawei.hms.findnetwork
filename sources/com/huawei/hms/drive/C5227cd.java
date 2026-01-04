package com.huawei.hms.drive;

import com.huawei.hms.drive.C5201bf;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.C5231ch;
import com.huawei.hms.drive.C5252da;
import com.huawei.hms.drive.InterfaceC5196ba;
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
import p022ay.C1050a0;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;

/* renamed from: com.huawei.hms.drive.cd */
/* loaded from: classes8.dex */
public final class C5227cd extends C5252da.c implements InterfaceC5181an {

    /* renamed from: l */
    static final /* synthetic */ boolean f24133l = true;

    /* renamed from: a */
    public final C5228ce f24134a;

    /* renamed from: b */
    public boolean f24135b;

    /* renamed from: c */
    int f24136c;

    /* renamed from: d */
    int f24137d;

    /* renamed from: n */
    private C5205bj f24145n;

    /* renamed from: o */
    private Socket f24146o;

    /* renamed from: p */
    private Socket f24147p;

    /* renamed from: q */
    private C5189av f24148q;

    /* renamed from: r */
    private EnumC5199bd f24149r;

    /* renamed from: s */
    private C5252da f24150s;

    /* renamed from: t */
    private InterfaceC1056f f24151t;

    /* renamed from: u */
    private InterfaceC1055e f24152u;

    /* renamed from: v */
    private int f24153v;

    /* renamed from: e */
    public int f24138e = 1;

    /* renamed from: f */
    public final List<Reference<C5232ci>> f24139f = new ArrayList();

    /* renamed from: g */
    long f24140g = Long.MAX_VALUE;

    /* renamed from: w */
    private C5231ch.a f24154w = null;

    /* renamed from: x */
    private C5219bx f24155x = null;

    /* renamed from: y */
    private C5205bj f24156y = null;

    /* renamed from: h */
    long f24141h = 0;

    /* renamed from: i */
    int f24142i = 0;

    /* renamed from: j */
    int f24143j = 0;

    /* renamed from: k */
    public long f24144k = 0;

    public C5227cd(C5228ce c5228ce, C5205bj c5205bj) {
        this.f24134a = c5228ce;
        this.f24145n = c5205bj;
    }

    /* renamed from: h */
    private C5201bf m31314h() throws IOException {
        C5201bf c5201bfM31123a = new C5201bf.a().m31119a(this.f24145n.m31162a().m30808b()).m31121a("CONNECT", (AbstractC5202bg) null).m31122a(FeedbackWebConstants.HOST, C5210bo.m31178a(this.f24145n.m31162a().m30808b(), true)).m31122a("Proxy-Connection", "Keep-Alive").m31122a("User-Agent", C5211bp.m31211a()).m31123a();
        C5201bf c5201bfAuthenticate = this.f24145n.m31162a().m30811e().authenticate(this.f24145n, new C5203bh.a().m31146a(c5201bfM31123a).m31145a(EnumC5199bd.HTTP_1_1).m31141a(ErrorCode.ERROR_CODE_NO_SDKVERSION).m31149a("Preemptive Authenticate").m31148a(C5210bo.f23991d).m31142a(-1L).m31153b(-1L).m31150a("Proxy-Authenticate", "OkHttp-Preemptive").m31151a());
        return c5201bfAuthenticate != null ? c5201bfAuthenticate : c5201bfM31123a;
    }

    /* renamed from: a */
    public void m31316a() {
        if (!f24133l && Thread.holdsLock(this.f24134a)) {
            throw new AssertionError();
        }
        synchronized (this.f24134a) {
            this.f24135b = true;
        }
    }

    /* renamed from: b */
    public C5231ch.a m31326b() {
        return this.f24154w;
    }

    /* renamed from: c */
    public C5205bj m31327c() {
        return this.f24145n;
    }

    /* renamed from: d */
    public void m31328d() throws IOException {
        C5219bx c5219bx = this.f24155x;
        if (c5219bx != null) {
            c5219bx.mo31253b();
        }
        C5210bo.m31193a(this.f24146o);
    }

    /* renamed from: e */
    public Socket m31329e() {
        return this.f24147p;
    }

    /* renamed from: f */
    public C5189av m31330f() {
        return this.f24148q;
    }

    /* renamed from: g */
    public boolean m31331g() {
        return this.f24150s != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f24145n.m31162a().m30808b().m30970f());
        sb2.append(":");
        sb2.append(this.f24145n.m31162a().m30808b().m30971g());
        sb2.append(", proxy=");
        sb2.append(this.f24145n.m31163b());
        sb2.append(" hostAddress=");
        sb2.append(this.f24145n.m31164c());
        sb2.append(" cipherSuite=");
        C5189av c5189av = this.f24148q;
        sb2.append(c5189av != null ? c5189av.m30915a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f24149r);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: a */
    public void m31322a(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        if (copyOnWriteArrayList != null) {
            this.f24155x = C5218bw.m31263a(copyOnWriteArrayList, i10, i11);
        }
    }

    /* renamed from: a */
    public void m31318a(C5231ch.a aVar) {
        this.f24154w = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00fa A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m31317a(int r15, int r16, int r17, int r18, int r19, boolean r20, com.huawei.hms.drive.InterfaceC5177aj r21, com.huawei.hms.drive.AbstractC5188au r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5227cd.m31317a(int, int, int, int, int, boolean, com.huawei.hms.drive.aj, com.huawei.hms.drive.au):void");
    }

    /* renamed from: a */
    private void m31309a(int i10, int i11, int i12, int i13, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) throws IOException {
        C5201bf c5201bfM31314h = m31314h();
        C5193az c5193azM31107a = c5201bfM31314h.m31107a();
        for (int i14 = 0; i14 < 21; i14++) {
            m31310a(i10, i11, i13, interfaceC5177aj, abstractC5188au);
            c5201bfM31314h = m31307a(i11, i12, c5201bfM31314h, c5193azM31107a);
            if (c5201bfM31314h == null) {
                return;
            }
            C5210bo.m31193a(this.f24146o);
            this.f24146o = null;
            this.f24152u = null;
            this.f24151t = null;
            abstractC5188au.m30901a(interfaceC5177aj, this.f24145n.m31164c(), this.f24145n.m31163b(), null);
        }
    }

    /* renamed from: a */
    private void m31310a(int i10, int i11, int i12, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) throws IOException {
        long jCurrentTimeMillis;
        C5205bj c5205bjM31374g;
        C5205bj c5205bj = this.f24156y;
        if (c5205bj == null) {
            c5205bj = this.f24145n;
        }
        Proxy proxyM31163b = c5205bj.m31163b();
        C5173af c5173afM31162a = c5205bj.m31162a();
        if (this.f24155x != null && this.f24156y == null) {
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f24146o = this.f24155x.mo31250a(i10, c5173afM31162a.m30810d(), proxyM31163b, interfaceC5177aj, abstractC5188au);
            if (this.f24155x.f24073d != null && (c5205bjM31374g = this.f24154w.m31374g()) != null) {
                this.f24154w.m31369b(new C5205bj(c5205bjM31374g.m31162a(), c5205bjM31374g.m31163b(), this.f24155x.f24073d));
            }
            C5231ch.a aVar = this.f24154w;
            if (aVar != null) {
                aVar.m31366a(this.f24155x.mo31251a());
                Socket socket = this.f24146o;
                if (socket != null) {
                    this.f24154w.m31365a((InetSocketAddress) socket.getRemoteSocketAddress());
                }
            }
            if (this.f24146o != null) {
                C5205bj c5205bj2 = new C5205bj(this.f24145n.m31162a(), this.f24145n.m31163b(), (InetSocketAddress) this.f24146o.getRemoteSocketAddress());
                this.f24156y = c5205bj2;
                this.f24145n = c5205bj2;
                this.f24146o.setSoTimeout(i11);
                this.f24146o.setTrafficClass(i12);
            } else {
                throw new ConnectException("Failed to connect to host " + this.f24145n.m31162a().m30808b().m30970f());
            }
        } else {
            this.f24146o = (proxyM31163b.type() == Proxy.Type.DIRECT || proxyM31163b.type() == Proxy.Type.HTTP) ? c5173afM31162a.m30810d().createSocket() : new Socket(proxyM31163b);
            abstractC5188au.m30900a(interfaceC5177aj, this.f24145n.m31164c(), proxyM31163b);
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f24146o.setSoTimeout(i11);
            this.f24146o.setTrafficClass(i12);
            try {
                C5269dr.m31692e().mo31658a(this.f24146o, c5205bj.m31164c(), i10);
            } catch (ConnectException e10) {
                ConnectException connectException = new ConnectException("Failed to connect to " + c5205bj.m31164c());
                connectException.initCause(e10);
                throw connectException;
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f24141h = jCurrentTimeMillis2;
        if (i11 != 0) {
            this.f24143j = ((int) ((jCurrentTimeMillis2 * 4) + 1000)) / i11;
        }
        try {
            this.f24151t = C1064n.m6403b(C1064n.m6408g(this.f24146o));
            this.f24152u = C1064n.m6402a(C1064n.m6405d(this.f24146o));
        } catch (NullPointerException e11) {
            if (C6167y8.f29150y.equals(e11.getMessage())) {
                throw new IOException(e11);
            }
        }
    }

    /* renamed from: a */
    private void m31312a(C5221bz c5221bz, int i10, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) throws Throwable {
        if (this.f24145n.m31162a().m30816j() == null) {
            List<EnumC5199bd> listM30812f = this.f24145n.m31162a().m30812f();
            EnumC5199bd enumC5199bd = EnumC5199bd.H2_PRIOR_KNOWLEDGE;
            if (listM30812f.contains(enumC5199bd)) {
                this.f24147p = this.f24146o;
                this.f24149r = enumC5199bd;
                m31308a(i10);
                return;
            } else {
                this.f24147p = this.f24146o;
                this.f24149r = EnumC5199bd.HTTP_1_1;
                return;
            }
        }
        abstractC5188au.m30903b(interfaceC5177aj);
        m31311a(c5221bz);
        abstractC5188au.m30894a(interfaceC5177aj, this.f24148q);
        if (this.f24149r == EnumC5199bd.HTTP_2) {
            m31308a(i10);
        }
    }

    /* renamed from: a */
    private void m31308a(int i10) throws IOException {
        this.f24147p.setSoTimeout(0);
        C5252da c5252daM31551a = new C5252da.a(true).m31550a(this.f24147p, this.f24145n.m31162a().m30808b().m30970f(), this.f24151t, this.f24152u).m31549a(this).m31548a(i10).m31551a();
        this.f24150s = c5252daM31551a;
        c5252daM31551a.m31544c();
    }

    /* renamed from: a */
    private void m31311a(C5221bz c5221bz) throws Throwable {
        EnumC5199bd enumC5199bdM31091a;
        C5173af c5173afM31162a = this.f24145n.m31162a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) c5173afM31162a.m30816j().createSocket(this.f24146o, c5173afM31162a.m30808b().m30970f(), c5173afM31162a.m30808b().m30971g(), true);
                try {
                    String strM30805a = c5173afM31162a.m30805a();
                    if (strM30805a != null && strM30805a.length() != 0) {
                        strM30805a = C5193az.m30962e(c5173afM31162a.m30808b().m30964b() + "://" + strM30805a).m30970f();
                    }
                    if (strM30805a == null || strM30805a.length() == 0) {
                        strM30805a = c5173afM31162a.m30808b().m30970f();
                    }
                    C5183ap c5183apM31277a = c5221bz.m31277a(sSLSocket2);
                    if (c5183apM31277a.m30861d()) {
                        C5269dr.m31692e().mo31648a(sSLSocket2, strM30805a, c5173afM31162a.m30812f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    C5189av c5189avM30913a = C5189av.m30913a(session);
                    if (!c5173afM31162a.m30817k().verify(strM30805a, session)) {
                        List<Certificate> listM30916b = c5189avM30913a.m30916b();
                        if (!listM30916b.isEmpty()) {
                            X509Certificate x509Certificate = (X509Certificate) listM30916b.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + strM30805a + " not verified:\n    certificate: " + C5179al.m30839a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + C5275dx.m31703a(x509Certificate));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + c5173afM31162a.m30808b().m30970f() + " not verified (no certificates)");
                    }
                    c5173afM31162a.m30818l().m30843a(c5173afM31162a.m30808b().m30970f(), c5189avM30913a.m30916b());
                    String strMo31647a = c5183apM31277a.m30861d() ? C5269dr.m31692e().mo31647a(sSLSocket2) : null;
                    this.f24147p = sSLSocket2;
                    this.f24151t = C1064n.m6403b(C1064n.m6408g(sSLSocket2));
                    this.f24152u = C1064n.m6402a(C1064n.m6405d(this.f24147p));
                    this.f24148q = c5189avM30913a;
                    if (strMo31647a != null) {
                        enumC5199bdM31091a = EnumC5199bd.m31091a(strMo31647a);
                    } else {
                        enumC5199bdM31091a = EnumC5199bd.HTTP_1_1;
                    }
                    this.f24149r = enumC5199bdM31091a;
                    C5269dr.m31692e().mo31678b(sSLSocket2);
                } catch (AssertionError e10) {
                    e = e10;
                    if (!C5210bo.m31196a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        C5269dr.m31692e().mo31678b(sSLSocket);
                    }
                    C5210bo.m31193a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (AssertionError e11) {
            e = e11;
        }
    }

    /* renamed from: a */
    private C5201bf m31307a(int i10, int i11, C5201bf c5201bf, C5193az c5193az) throws IOException {
        String str = "CONNECT " + C5210bo.m31178a(c5193az, true) + " HTTP/1.1";
        while (true) {
            C5244cu c5244cu = new C5244cu(null, null, this.f24151t, this.f24152u);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f24151t.timeout().timeout(i10, timeUnit);
            this.f24152u.timeout().timeout(i11, timeUnit);
            c5244cu.m31451a(c5201bf.m31110c(), str);
            c5244cu.mo31403c();
            C5203bh c5203bhM31151a = c5244cu.mo31398a(false).m31146a(c5201bf).m31151a();
            c5244cu.m31452c(c5203bhM31151a);
            int iM31129b = c5203bhM31151a.m31129b();
            if (iM31129b == 200) {
                if (this.f24151t.mo6324L().mo6325M() && this.f24152u.mo6323K().mo6325M()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM31129b == 407) {
                C5201bf c5201bfAuthenticate = this.f24145n.m31162a().m30811e().authenticate(this.f24145n, c5203bhM31151a);
                if (c5201bfAuthenticate != null) {
                    if ("close".equalsIgnoreCase(c5203bhM31151a.m31127a("Connection"))) {
                        return c5201bfAuthenticate;
                    }
                    c5201bf = c5201bfAuthenticate;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + c5203bhM31151a.m31129b());
            }
        }
    }

    /* renamed from: a */
    public boolean m31323a(C5173af c5173af, List<C5205bj> list) {
        if (this.f24139f.size() >= this.f24138e || this.f24135b || !AbstractC5207bl.f23983a.mo31079a(this.f24145n.m31162a(), c5173af)) {
            return false;
        }
        if (c5173af.m30808b().m30970f().equals(m31327c().m31162a().m30808b().m30970f())) {
            return true;
        }
        if (this.f24150s == null || list == null || !m31313a(list) || c5173af.m30817k() != C5275dx.f24503a || !m31324a(c5173af.m30808b())) {
            return false;
        }
        try {
            c5173af.m30818l().m30843a(c5173af.m30808b().m30970f(), m31330f().m30916b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m31313a(List<C5205bj> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            C5205bj c5205bj = list.get(i10);
            Proxy.Type type = c5205bj.m31163b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f24145n.m31163b().type() == type2 && this.f24145n.m31164c().equals(c5205bj.m31164c())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m31324a(C5193az c5193az) {
        if (c5193az.m30971g() != this.f24145n.m31162a().m30808b().m30971g()) {
            return false;
        }
        if (c5193az.m30970f().equals(this.f24145n.m31162a().m30808b().m30970f())) {
            return true;
        }
        return this.f24148q != null && C5275dx.f24503a.m31708a(c5193az.m30970f(), (X509Certificate) this.f24148q.m30916b().get(0));
    }

    /* renamed from: a */
    public InterfaceC5235cl m31315a(C5198bc c5198bc, InterfaceC5196ba.a aVar) throws SocketException {
        if (this.f24150s != null) {
            return new C5253db(c5198bc, this, aVar, this.f24150s);
        }
        this.f24147p.setSoTimeout(aVar.mo31034c());
        C1050a0 c1050a0Timeout = this.f24151t.timeout();
        long jMo31034c = aVar.mo31034c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c1050a0Timeout.timeout(jMo31034c, timeUnit);
        this.f24152u.timeout().timeout(aVar.mo31035d(), timeUnit);
        return new C5244cu(c5198bc, this, this.f24151t, this.f24152u);
    }

    /* renamed from: a */
    public boolean m31325a(boolean z10) throws SocketException {
        if (this.f24147p.isClosed() || this.f24147p.isInputShutdown() || this.f24147p.isOutputShutdown()) {
            return false;
        }
        C5252da c5252da = this.f24150s;
        if (c5252da != null) {
            return c5252da.m31543b(System.nanoTime());
        }
        if (z10) {
            try {
                int soTimeout = this.f24147p.getSoTimeout();
                try {
                    this.f24147p.setSoTimeout(1);
                    return !this.f24151t.mo6325M();
                } finally {
                    this.f24147p.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.hms.drive.C5252da.c
    /* renamed from: a */
    public void mo31320a(C5255dd c5255dd) throws IOException {
        c5255dd.m31587a(EnumC5246cw.REFUSED_STREAM, (IOException) null);
    }

    @Override // com.huawei.hms.drive.C5252da.c
    /* renamed from: a */
    public void mo31319a(C5252da c5252da) {
        synchronized (this.f24134a) {
            this.f24138e = c5252da.m31525a();
        }
    }

    /* renamed from: a */
    public void m31321a(IOException iOException) {
        if (!f24133l && Thread.holdsLock(this.f24134a)) {
            throw new AssertionError();
        }
        synchronized (this.f24134a) {
            try {
                if (iOException instanceof C5260di) {
                    EnumC5246cw enumC5246cw = ((C5260di) iOException).f24449a;
                    if (enumC5246cw == EnumC5246cw.REFUSED_STREAM) {
                        int i10 = this.f24153v + 1;
                        this.f24153v = i10;
                        if (i10 > 1) {
                            this.f24135b = true;
                            this.f24136c++;
                        }
                    } else if (enumC5246cw != EnumC5246cw.CANCEL) {
                        this.f24135b = true;
                        this.f24136c++;
                    }
                } else if (!m31331g() || (iOException instanceof C5245cv)) {
                    this.f24135b = true;
                    if (this.f24137d == 0) {
                        if (iOException != null) {
                            this.f24134a.m31343a(this.f24145n, iOException);
                        }
                        this.f24136c++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
