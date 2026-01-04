package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5880c9;
import com.huawei.hms.network.embedded.C6101t7;
import com.huawei.hms.network.embedded.C6117ua;
import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.C6129v9;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
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

/* renamed from: com.huawei.hms.network.embedded.y8 */
/* loaded from: classes8.dex */
public final class C6167y8 extends C6129v9.j implements InterfaceC6165y6 {

    /* renamed from: A */
    public static final int f29146A = 4;

    /* renamed from: B */
    public static final long f29147B = 1000000000;

    /* renamed from: C */
    public static final int f29148C = 1000;

    /* renamed from: D */
    public static final /* synthetic */ boolean f29149D = true;

    /* renamed from: y */
    public static final String f29150y = "throw with null exception";

    /* renamed from: z */
    public static final int f29151z = 21;

    /* renamed from: b */
    public final C6180z8 f29152b;

    /* renamed from: c */
    public C6153x7 f29153c;

    /* renamed from: d */
    public Socket f29154d;

    /* renamed from: e */
    public Socket f29155e;

    /* renamed from: f */
    public C5958i7 f29156f;

    /* renamed from: g */
    public EnumC6075r7 f29157g;

    /* renamed from: h */
    public C6129v9 f29158h;

    /* renamed from: i */
    public InterfaceC5896db f29159i;

    /* renamed from: j */
    public InterfaceC5882cb f29160j;

    /* renamed from: k */
    public boolean f29161k;

    /* renamed from: l */
    public int f29162l;

    /* renamed from: m */
    public int f29163m;

    /* renamed from: n */
    public int f29164n;

    /* renamed from: o */
    public int f29165o = 1;

    /* renamed from: p */
    public final List<Reference<C5894d9>> f29166p = new ArrayList();

    /* renamed from: q */
    public long f29167q = Long.MAX_VALUE;

    /* renamed from: r */
    public C5880c9.a f29168r = null;

    /* renamed from: s */
    public C6089s8 f29169s = null;

    /* renamed from: t */
    public C6153x7 f29170t = null;

    /* renamed from: u */
    public long f29171u = 0;

    /* renamed from: v */
    public int f29172v = 0;

    /* renamed from: w */
    public int f29173w = 0;

    /* renamed from: x */
    public long f29174x = 0;

    /* renamed from: com.huawei.hms.network.embedded.y8$a */
    public class a extends C6117ua.f {

        /* renamed from: d */
        public final /* synthetic */ C6128v8 f29175d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, InterfaceC5896db interfaceC5896db, InterfaceC5882cb interfaceC5882cb, C6128v8 c6128v8) {
            super(z10, interfaceC5896db, interfaceC5882cb);
            this.f29175d = c6128v8;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f29175d.m35615a(-1L, true, true, null);
        }
    }

    public C6167y8(C6180z8 c6180z8, C6153x7 c6153x7) {
        this.f29152b = c6180z8;
        this.f29153c = c6153x7;
    }

    /* renamed from: i */
    private C6101t7 m35851i() throws IOException {
        C6101t7 c6101t7M35436a = new C6101t7.a().m35425a(this.f29153c.m35787a().m34990l()).m35431a("CONNECT", (AbstractC6114u7) null).m35440b(FeedbackWebConstants.HOST, C5920f8.m34233a(this.f29153c.m35787a().m34990l(), true)).m35440b("Proxy-Connection", "Keep-Alive").m35440b("User-Agent", C5933g8.m34314a()).m35436a();
        C6101t7 c6101t7Mo35065b = this.f29153c.m35787a().m34986h().mo35065b(this.f29153c, new C6127v7.a().m35600a(c6101t7M35436a).m35599a(EnumC6075r7.HTTP_1_1).m35595a(ErrorCode.ERROR_CODE_NO_SDKVERSION).m35603a("Preemptive Authenticate").m35602a(C5920f8.f26772d).m35607b(-1L).m35596a(-1L).m35610b("Proxy-Authenticate", "OkHttp-Preemptive").m35605a());
        return c6101t7Mo35065b != null ? c6101t7Mo35065b : c6101t7M35436a;
    }

    /* renamed from: a */
    public InterfaceC5934g9 m35852a(C6062q7 c6062q7, InterfaceC6023n7.a aVar) throws SocketException {
        C6129v9 c6129v9 = this.f29158h;
        if (c6129v9 != null) {
            return new C6142w9(c6062q7, this, aVar, c6129v9);
        }
        this.f29155e.setSoTimeout(aVar.mo34625c());
        C5855ac c5855acTimeout = this.f29159i.timeout();
        long jMo34625c = aVar.mo34625c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c5855acTimeout.timeout(jMo34625c, timeUnit);
        this.f29160j.timeout().timeout(aVar.mo34623b(), timeUnit);
        return new C6051p9(c6062q7, this, this.f29159i, this.f29160j);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6165y6
    /* renamed from: b */
    public C6153x7 mo35837b() {
        return this.f29153c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6165y6
    /* renamed from: c */
    public Socket mo35838c() {
        return this.f29155e;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6165y6
    /* renamed from: d */
    public EnumC6075r7 mo35839d() {
        return this.f29157g;
    }

    /* renamed from: e */
    public void m35861e() {
        C6089s8 c6089s8 = this.f29169s;
        if (c6089s8 != null) {
            c6089s8.mo35153a();
        }
        C5920f8.m34251a(this.f29154d);
    }

    /* renamed from: f */
    public C5880c9.a m35862f() {
        return this.f29168r;
    }

    /* renamed from: g */
    public boolean m35863g() {
        return this.f29158h != null;
    }

    /* renamed from: h */
    public void m35864h() {
        if (!f29149D && Thread.holdsLock(this.f29152b)) {
            throw new AssertionError();
        }
        synchronized (this.f29152b) {
            this.f29161k = true;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f29153c.m35787a().m34990l().m34797h());
        sb2.append(":");
        sb2.append(this.f29153c.m35787a().m34990l().m34803n());
        sb2.append(", proxy=");
        sb2.append(this.f29153c.m35788b());
        sb2.append(" hostAddress=");
        sb2.append(this.f29153c.m35790d());
        sb2.append(" cipherSuite=");
        C5958i7 c5958i7 = this.f29156f;
        sb2.append(c5958i7 != null ? c5958i7.m34388a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f29157g);
        sb2.append('}');
        return sb2.toString();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6165y6
    /* renamed from: a */
    public C5958i7 mo35836a() {
        return this.f29156f;
    }

    /* renamed from: a */
    private C6101t7 m35843a(int i10, int i11, C6101t7 c6101t7, C6010m7 c6010m7) throws IOException {
        String str = "CONNECT " + C5920f8.m34233a(c6010m7, true) + " HTTP/1.1";
        while (true) {
            C6051p9 c6051p9 = new C6051p9(null, null, this.f29159i, this.f29160j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f29159i.timeout().timeout(i10, timeUnit);
            this.f29160j.timeout().timeout(i11, timeUnit);
            c6051p9.m35037a(c6101t7.m35417e(), str);
            c6051p9.mo34322c();
            C6127v7 c6127v7M35605a = c6051p9.mo34316a(false).m35600a(c6101t7).m35605a();
            c6051p9.m35038c(c6127v7M35605a);
            int iM35589w = c6127v7M35605a.m35589w();
            if (iM35589w == 200) {
                if (this.f29159i.mo33966g().mo33971i() && this.f29160j.mo33924a().mo33971i()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM35589w != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c6127v7M35605a.m35589w());
            }
            C6101t7 c6101t7Mo35065b = this.f29153c.m35787a().m34986h().mo35065b(this.f29153c, c6127v7M35605a);
            if (c6101t7Mo35065b == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(c6127v7M35605a.m35582b("Connection"))) {
                return c6101t7Mo35065b;
            }
            c6101t7 = c6101t7Mo35065b;
        }
    }

    /* renamed from: a */
    public C6117ua.f m35853a(C6128v8 c6128v8) throws SocketException {
        this.f29155e.setSoTimeout(0);
        m35864h();
        return new a(true, this.f29159i, this.f29160j, c6128v8);
    }

    /* renamed from: a */
    public static C6167y8 m35844a(C6180z8 c6180z8, C6153x7 c6153x7, Socket socket, long j10) {
        C6167y8 c6167y8 = new C6167y8(c6180z8, c6153x7);
        c6167y8.f29155e = socket;
        c6167y8.f29167q = j10;
        return c6167y8;
    }

    /* renamed from: a */
    private void m35845a(int i10) throws IOException {
        this.f29155e.setSoTimeout(0);
        C6129v9 c6129v9M35681a = new C6129v9.h(true).m35680a(this.f29155e, this.f29153c.m35787a().m34990l().m34797h(), this.f29159i, this.f29160j).m35678a(this).m35676a(i10).m35681a();
        this.f29158h = c6129v9M35681a;
        c6129v9M35681a.m35673w();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00f6 A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m35854a(int r15, int r16, int r17, int r18, int r19, boolean r20, com.huawei.hms.network.embedded.InterfaceC6100t6 r21, com.huawei.hms.network.embedded.AbstractC5932g7 r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6167y8.m35854a(int, int, int, int, int, boolean, com.huawei.hms.network.embedded.t6, com.huawei.hms.network.embedded.g7):void");
    }

    /* renamed from: a */
    private void m35846a(int i10, int i11, int i12, int i13, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) throws IOException {
        C6101t7 c6101t7M35851i = m35851i();
        C6010m7 c6010m7M35423k = c6101t7M35851i.m35423k();
        for (int i14 = 0; i14 < 21; i14++) {
            m35847a(i10, i11, i13, interfaceC6100t6, abstractC5932g7);
            c6101t7M35851i = m35843a(i11, i12, c6101t7M35851i, c6010m7M35423k);
            if (c6101t7M35851i == null) {
                return;
            }
            C5920f8.m34251a(this.f29154d);
            this.f29154d = null;
            this.f29160j = null;
            this.f29159i = null;
            abstractC5932g7.connectEnd(interfaceC6100t6, this.f29153c.m35790d(), this.f29153c.m35788b(), null);
        }
    }

    /* renamed from: a */
    private void m35847a(int i10, int i11, int i12, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) throws IOException {
        long jCurrentTimeMillis;
        C6153x7 c6153x7M34069e;
        C6153x7 c6153x7 = this.f29170t;
        if (c6153x7 == null) {
            c6153x7 = this.f29153c;
        }
        Proxy proxyM35788b = c6153x7.m35788b();
        C6048p6 c6048p6M35787a = c6153x7.m35787a();
        if (this.f29169s == null || this.f29170t != null) {
            this.f29154d = (proxyM35788b.type() == Proxy.Type.DIRECT || proxyM35788b.type() == Proxy.Type.HTTP) ? c6048p6M35787a.m34988j().createSocket() : new Socket(proxyM35788b);
            abstractC5932g7.connectStart(interfaceC6100t6, this.f29153c.m35790d(), proxyM35788b);
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f29154d.setSoTimeout(i11);
            this.f29154d.setTrafficClass(i12);
            try {
                C6013ma.m34863f().mo34333a(this.f29154d, c6153x7.m35790d(), i10);
            } catch (ConnectException e10) {
                ConnectException connectException = new ConnectException("Failed to connect to " + c6153x7.m35790d());
                connectException.initCause(e10);
                throw connectException;
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f29154d = this.f29169s.mo35152a(i10, c6048p6M35787a.m34988j(), proxyM35788b, interfaceC6100t6, abstractC5932g7);
            if (this.f29169s.f28226l != null && (c6153x7M34069e = this.f29168r.m34069e()) != null) {
                this.f29168r.m34066b(new C6153x7(c6153x7M34069e.m35787a(), c6153x7M34069e.m35788b(), this.f29169s.f28226l));
            }
            C5880c9.a aVar = this.f29168r;
            if (aVar != null) {
                aVar.m34063a(this.f29169s.mo35155b());
                Socket socket = this.f29154d;
                if (socket != null) {
                    this.f29168r.m34062a((InetSocketAddress) socket.getRemoteSocketAddress());
                }
            }
            if (this.f29154d == null) {
                throw new ConnectException("Failed to connect to host " + this.f29153c.m35787a().m34990l().m34797h());
            }
            C6153x7 c6153x72 = new C6153x7(this.f29153c.m35787a(), this.f29153c.m35788b(), (InetSocketAddress) this.f29154d.getRemoteSocketAddress());
            this.f29170t = c6153x72;
            this.f29153c = c6153x72;
            this.f29154d.setSoTimeout(i11);
            this.f29154d.setTrafficClass(i12);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f29171u = jCurrentTimeMillis2;
        if (i11 != 0) {
            this.f29173w = ((int) ((jCurrentTimeMillis2 * 4) + 1000)) / i11;
        }
        try {
            this.f29159i = C6040ob.m34934a(C6040ob.m34945b(this.f29154d));
            this.f29160j = C6040ob.m34933a(C6040ob.m34939a(this.f29154d));
        } catch (NullPointerException e11) {
            if (f29150y.equals(e11.getMessage())) {
                throw new IOException(e11);
            }
        }
    }

    /* renamed from: a */
    public void m35855a(C5880c9.a aVar) {
        this.f29168r = aVar;
    }

    /* renamed from: a */
    private void m35848a(C6115u8 c6115u8) throws Throwable {
        C6048p6 c6048p6M35787a = this.f29153c.m35787a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) c6048p6M35787a.m34989k().createSocket(this.f29154d, c6048p6M35787a.m34990l().m34797h(), c6048p6M35787a.m34990l().m34803n(), true);
                try {
                    String strM34982d = c6048p6M35787a.m34982d();
                    if (strM34982d != null && strM34982d.length() != 0) {
                        strM34982d = C6010m7.m34781f(c6048p6M35787a.m34990l().m34808s() + "://" + strM34982d).m34797h();
                    }
                    if (strM34982d == null || strM34982d.length() == 0) {
                        strM34982d = c6048p6M35787a.m34990l().m34797h();
                    }
                    C5850a7 c5850a7M35509a = c6115u8.m35509a(sSLSocket2);
                    if (c5850a7M35509a.m33817c()) {
                        C6013ma.m34863f().mo34271a(sSLSocket2, strM34982d, c6048p6M35787a.m34984f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    C5958i7 c5958i7M34386a = C5958i7.m34386a(session);
                    if (c6048p6M35787a.m34983e().verify(strM34982d, session)) {
                        c6048p6M35787a.m34977a().m35566a(c6048p6M35787a.m34990l().m34797h(), c5958i7M34386a.m34391d());
                        String strMo34272b = c5850a7M35509a.m33817c() ? C6013ma.m34863f().mo34272b(sSLSocket2) : null;
                        this.f29155e = sSLSocket2;
                        this.f29159i = C6040ob.m34934a(C6040ob.m34945b(sSLSocket2));
                        this.f29160j = C6040ob.m34933a(C6040ob.m34939a(this.f29155e));
                        this.f29156f = c5958i7M34386a;
                        this.f29157g = strMo34272b != null ? EnumC6075r7.m35227a(strMo34272b) : EnumC6075r7.HTTP_1_1;
                        C6013ma.m34863f().mo34551a(sSLSocket2);
                        return;
                    }
                    List<Certificate> listM34391d = c5958i7M34386a.m34391d();
                    if (listM34391d.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + c6048p6M35787a.m34990l().m34797h() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) listM34391d.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + strM34982d + " not verified:\n    certificate: " + C6126v6.m35562a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + C6091sa.m35305a(x509Certificate));
                } catch (AssertionError e10) {
                    e = e10;
                    if (!C5920f8.m34254a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        C6013ma.m34863f().mo34551a(sSLSocket);
                    }
                    C5920f8.m34251a((Socket) sSLSocket);
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
    private void m35849a(C6115u8 c6115u8, int i10, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) throws Throwable {
        if (this.f29153c.m35787a().m34989k() != null) {
            abstractC5932g7.secureConnectStart(interfaceC6100t6);
            m35848a(c6115u8);
            abstractC5932g7.secureConnectEnd(interfaceC6100t6, this.f29156f);
            if (this.f29157g == EnumC6075r7.HTTP_2) {
                m35845a(i10);
                return;
            }
            return;
        }
        List<EnumC6075r7> listM34984f = this.f29153c.m35787a().m34984f();
        EnumC6075r7 enumC6075r7 = EnumC6075r7.H2_PRIOR_KNOWLEDGE;
        if (!listM34984f.contains(enumC6075r7)) {
            this.f29155e = this.f29154d;
            this.f29157g = EnumC6075r7.HTTP_1_1;
        } else {
            this.f29155e = this.f29154d;
            this.f29157g = enumC6075r7;
            m35845a(i10);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6129v9.j
    /* renamed from: a */
    public void mo35682a(C6129v9 c6129v9) {
        synchronized (this.f29152b) {
            this.f29165o = c6129v9.m35670t();
        }
    }

    @Override // com.huawei.hms.network.embedded.C6129v9.j
    /* renamed from: a */
    public void mo35683a(C6168y9 c6168y9) throws IOException {
        c6168y9.m35872a(EnumC6077r9.REFUSED_STREAM, (IOException) null);
    }

    /* renamed from: a */
    public void m35856a(IOException iOException) {
        if (!f29149D && Thread.holdsLock(this.f29152b)) {
            throw new AssertionError();
        }
        synchronized (this.f29152b) {
            try {
                if (iOException instanceof C5895da) {
                    EnumC6077r9 enumC6077r9 = ((C5895da) iOException).f26668a;
                    if (enumC6077r9 == EnumC6077r9.REFUSED_STREAM) {
                        int i10 = this.f29164n + 1;
                        this.f29164n = i10;
                        if (i10 > 1) {
                            this.f29161k = true;
                            this.f29162l++;
                        }
                    } else if (enumC6077r9 != EnumC6077r9.CANCEL) {
                        this.f29161k = true;
                        this.f29162l++;
                    }
                } else if (!m35863g() || (iOException instanceof C6064q9)) {
                    this.f29161k = true;
                    if (this.f29163m == 0) {
                        if (iOException != null) {
                            this.f29152b.m35927a(this.f29153c, iOException);
                        }
                        this.f29162l++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m35857a(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        if (copyOnWriteArrayList != null) {
            this.f29169s = C6076r8.m35229a(copyOnWriteArrayList, i10, i11);
        }
    }

    /* renamed from: a */
    public boolean m35858a(C6010m7 c6010m7) {
        if (c6010m7.m34803n() != this.f29153c.m35787a().m34990l().m34803n()) {
            return false;
        }
        if (c6010m7.m34797h().equals(this.f29153c.m35787a().m34990l().m34797h())) {
            return true;
        }
        return this.f29156f != null && C6091sa.f28246a.m35310a(c6010m7.m34797h(), (X509Certificate) this.f29156f.m34391d().get(0));
    }

    /* renamed from: a */
    public boolean m35859a(C6048p6 c6048p6, List<C6153x7> list) {
        if (this.f29166p.size() >= this.f29165o || this.f29161k || !AbstractC5879c8.f26567a.mo34050a(this.f29153c.m35787a(), c6048p6)) {
            return false;
        }
        if (c6048p6.m34990l().m34797h().equals(mo35837b().m35787a().m34990l().m34797h())) {
            return true;
        }
        if (this.f29158h == null || list == null || !m35850a(list) || c6048p6.m34983e() != C6091sa.f28246a || !m35858a(c6048p6.m34990l())) {
            return false;
        }
        try {
            c6048p6.m34977a().m35566a(c6048p6.m34990l().m34797h(), mo35836a().m34391d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m35850a(List<C6153x7> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            C6153x7 c6153x7 = list.get(i10);
            Proxy.Type type = c6153x7.m35788b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f29153c.m35788b().type() == type2 && this.f29153c.m35790d().equals(c6153x7.m35790d())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m35860a(boolean z10) throws SocketException {
        if (this.f29155e.isClosed() || this.f29155e.isInputShutdown() || this.f29155e.isOutputShutdown()) {
            return false;
        }
        C6129v9 c6129v9 = this.f29158h;
        if (c6129v9 != null) {
            return c6129v9.m35667j(System.nanoTime());
        }
        if (z10) {
            try {
                int soTimeout = this.f29155e.getSoTimeout();
                try {
                    this.f29155e.setSoTimeout(1);
                    return !this.f29159i.mo33971i();
                } finally {
                    this.f29155e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }
}
