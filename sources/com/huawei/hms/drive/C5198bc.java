package com.huawei.hms.drive;

import com.huawei.hms.drive.AbstractC5188au;
import com.huawei.hms.drive.C5182ao;
import com.huawei.hms.drive.C5190aw;
import com.huawei.hms.drive.C5203bh;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.drive.bc */
/* loaded from: classes8.dex */
public class C5198bc implements Cloneable {

    /* renamed from: a */
    static final List<EnumC5199bd> f23838a = C5210bo.m31186a(EnumC5199bd.HTTP_2, EnumC5199bd.HTTP_1_1);

    /* renamed from: b */
    static final List<C5183ap> f23839b = C5210bo.m31186a(C5183ap.f23739b, C5183ap.f23741d);

    /* renamed from: A */
    final int f23840A;

    /* renamed from: B */
    final int f23841B;

    /* renamed from: C */
    final int f23842C;

    /* renamed from: D */
    final int f23843D;

    /* renamed from: E */
    final int f23844E;

    /* renamed from: F */
    final int f23845F;

    /* renamed from: G */
    final b f23846G;

    /* renamed from: c */
    final C5186as f23847c;

    /* renamed from: d */
    final Proxy f23848d;

    /* renamed from: e */
    final List<EnumC5199bd> f23849e;

    /* renamed from: f */
    final List<C5183ap> f23850f;

    /* renamed from: g */
    final List<InterfaceC5196ba> f23851g;

    /* renamed from: h */
    final List<InterfaceC5196ba> f23852h;

    /* renamed from: i */
    final AbstractC5188au.a f23853i;

    /* renamed from: j */
    final ProxySelector f23854j;

    /* renamed from: k */
    final InterfaceC5185ar f23855k;

    /* renamed from: l */
    final C5175ah f23856l;

    /* renamed from: m */
    final InterfaceC5216bu f23857m;

    /* renamed from: n */
    final SocketFactory f23858n;

    /* renamed from: o */
    final SSLSocketFactory f23859o;

    /* renamed from: p */
    final AbstractC5274dw f23860p;

    /* renamed from: q */
    final HostnameVerifier f23861q;

    /* renamed from: r */
    final C5179al f23862r;

    /* renamed from: s */
    final InterfaceC5174ag f23863s;

    /* renamed from: t */
    final InterfaceC5174ag f23864t;

    /* renamed from: u */
    final C5182ao f23865u;

    /* renamed from: v */
    final InterfaceC5187at f23866v;

    /* renamed from: w */
    final boolean f23867w;

    /* renamed from: x */
    final boolean f23868x;

    /* renamed from: y */
    final boolean f23869y;

    /* renamed from: z */
    final int f23870z;

    /* renamed from: com.huawei.hms.drive.bc$1 */
    public class AnonymousClass1 extends AbstractC5207bl {
        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public void mo31076a(C5190aw.a aVar, String str) {
            aVar.m30928a(str);
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public void mo31077a(C5190aw.a aVar, String str, String str2) {
            aVar.m30932b(str, str2);
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public C5228ce mo31074a(C5182ao c5182ao) {
            return c5182ao.f23737a;
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public boolean mo31079a(C5173af c5173af, C5173af c5173af2) {
            return c5173af.m30807a(c5173af2);
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public int mo31072a(C5203bh.a aVar) {
            return aVar.f23959c;
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public void mo31075a(C5183ap c5183ap, SSLSocket sSLSocket, boolean z10) {
            c5183ap.m30856a(sSLSocket, z10);
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public void mo31078a(C5203bh.a aVar, C5224ca c5224ca) {
            aVar.m31152a(c5224ca);
        }

        @Override // com.huawei.hms.drive.AbstractC5207bl
        /* renamed from: a */
        public C5224ca mo31073a(C5203bh c5203bh) {
            return c5203bh.f23955m;
        }
    }

    /* renamed from: com.huawei.hms.drive.bc$a */
    public static final class a {

        /* renamed from: A */
        int f23871A;

        /* renamed from: B */
        int f23872B;

        /* renamed from: C */
        int f23873C;

        /* renamed from: D */
        int f23874D;

        /* renamed from: b */
        Proxy f23876b;

        /* renamed from: h */
        ProxySelector f23882h;

        /* renamed from: i */
        InterfaceC5185ar f23883i;

        /* renamed from: j */
        C5175ah f23884j;

        /* renamed from: k */
        InterfaceC5216bu f23885k;

        /* renamed from: l */
        SocketFactory f23886l;

        /* renamed from: m */
        SSLSocketFactory f23887m;

        /* renamed from: n */
        AbstractC5274dw f23888n;

        /* renamed from: o */
        HostnameVerifier f23889o;

        /* renamed from: p */
        C5179al f23890p;

        /* renamed from: q */
        InterfaceC5174ag f23891q;

        /* renamed from: r */
        InterfaceC5174ag f23892r;

        /* renamed from: s */
        C5182ao f23893s;

        /* renamed from: t */
        InterfaceC5187at f23894t;

        /* renamed from: u */
        boolean f23895u;

        /* renamed from: v */
        boolean f23896v;

        /* renamed from: w */
        boolean f23897w;

        /* renamed from: x */
        int f23898x;

        /* renamed from: y */
        int f23899y;

        /* renamed from: z */
        int f23900z;

        /* renamed from: e */
        final List<InterfaceC5196ba> f23879e = new ArrayList();

        /* renamed from: f */
        final List<InterfaceC5196ba> f23880f = new ArrayList();

        /* renamed from: a */
        C5186as f23875a = new C5186as();

        /* renamed from: c */
        List<EnumC5199bd> f23877c = C5198bc.f23838a;

        /* renamed from: d */
        List<C5183ap> f23878d = C5198bc.f23839b;

        /* renamed from: g */
        AbstractC5188au.a f23881g = AbstractC5188au.m30888a(AbstractC5188au.f23775a);

        public a() {
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f23882h = proxySelector;
            if (proxySelector == null) {
                this.f23882h = new C5270ds();
            }
            this.f23883i = InterfaceC5185ar.f23765a;
            this.f23886l = SocketFactory.getDefault();
            this.f23889o = C5275dx.f24503a;
            this.f23890p = C5179al.f23607a;
            InterfaceC5174ag interfaceC5174ag = InterfaceC5174ag.f23581a;
            this.f23891q = interfaceC5174ag;
            this.f23892r = interfaceC5174ag;
            this.f23893s = new C5182ao();
            this.f23894t = InterfaceC5187at.f23774a;
            this.f23895u = true;
            this.f23896v = true;
            this.f23897w = true;
            this.f23898x = 0;
            this.f23899y = 10000;
            this.f23900z = 10000;
            this.f23871A = 10000;
            this.f23872B = 0;
            this.f23874D = 0;
            this.f23873C = 200;
        }

        /* renamed from: a */
        public a m31080a(long j10, TimeUnit timeUnit) {
            this.f23899y = C5210bo.m31176a("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: b */
        public a m31087b(long j10, TimeUnit timeUnit) {
            this.f23900z = C5210bo.m31176a("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: c */
        public a m31089c(long j10, TimeUnit timeUnit) {
            this.f23871A = C5210bo.m31176a("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: d */
        public a m31090d(long j10, TimeUnit timeUnit) {
            this.f23872B = C5210bo.m31176a("interval", j10, timeUnit);
            return this;
        }

        /* renamed from: a */
        public a m31084a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f23887m = sSLSocketFactory;
            this.f23888n = AbstractC5274dw.m31702a(x509TrustManager);
            return this;
        }

        /* renamed from: b */
        public a m31088b(boolean z10) {
            this.f23896v = z10;
            return this;
        }

        /* renamed from: a */
        public a m31083a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.f23889o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        /* renamed from: a */
        public a m31081a(C5182ao c5182ao) {
            if (c5182ao != null) {
                this.f23893s = c5182ao;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        /* renamed from: a */
        public a m31085a(boolean z10) {
            this.f23895u = z10;
            return this;
        }

        /* renamed from: a */
        public a m31082a(C5186as c5186as) {
            if (c5186as != null) {
                this.f23875a = c5186as;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        /* renamed from: a */
        public C5198bc m31086a() {
            return new C5198bc(this);
        }
    }

    /* renamed from: com.huawei.hms.drive.bc$b */
    public class b implements C5182ao.a {
        private b() {
        }

        @Override // com.huawei.hms.drive.C5182ao.a
        /* renamed from: a */
        public void mo30854a(String str, int i10, String str2) {
            C5198bc.this.f23847c.mo30804b(str, i10, str2);
        }

        public /* synthetic */ b(C5198bc c5198bc, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        AbstractC5207bl.f23983a = new AbstractC5207bl() { // from class: com.huawei.hms.drive.bc.1
            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public void mo31076a(C5190aw.a aVar, String str) {
                aVar.m30928a(str);
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public void mo31077a(C5190aw.a aVar, String str, String str2) {
                aVar.m30932b(str, str2);
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public C5228ce mo31074a(C5182ao c5182ao) {
                return c5182ao.f23737a;
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public boolean mo31079a(C5173af c5173af, C5173af c5173af2) {
                return c5173af.m30807a(c5173af2);
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public int mo31072a(C5203bh.a aVar) {
                return aVar.f23959c;
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public void mo31075a(C5183ap c5183ap, SSLSocket sSLSocket, boolean z10) {
                c5183ap.m30856a(sSLSocket, z10);
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public void mo31078a(C5203bh.a aVar, C5224ca c5224ca) {
                aVar.m31152a(c5224ca);
            }

            @Override // com.huawei.hms.drive.AbstractC5207bl
            /* renamed from: a */
            public C5224ca mo31073a(C5203bh c5203bh) {
                return c5203bh.f23955m;
            }
        };
    }

    public C5198bc() {
        this(new a());
    }

    /* renamed from: a */
    private static SSLSocketFactory m31040a(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextMo31660b = C5269dr.m31692e().mo31660b();
            sSLContextMo31660b.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextMo31660b.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS", e10);
        }
    }

    /* renamed from: A */
    public List<InterfaceC5196ba> m31041A() {
        return this.f23852h;
    }

    /* renamed from: B */
    public AbstractC5188au.a m31042B() {
        return this.f23853i;
    }

    /* renamed from: b */
    public int m31046b() {
        return this.f23840A;
    }

    /* renamed from: c */
    public int m31048c() {
        return this.f23841B;
    }

    /* renamed from: d */
    public int m31049d() {
        return this.f23842C;
    }

    /* renamed from: e */
    public int m31050e() {
        return this.f23843D;
    }

    /* renamed from: f */
    public Proxy m31051f() {
        return this.f23848d;
    }

    /* renamed from: g */
    public ProxySelector m31052g() {
        return this.f23854j;
    }

    /* renamed from: h */
    public InterfaceC5185ar m31053h() {
        return this.f23855k;
    }

    /* renamed from: i */
    public InterfaceC5216bu m31054i() {
        C5175ah c5175ah = this.f23856l;
        return c5175ah != null ? c5175ah.f23582a : this.f23857m;
    }

    /* renamed from: j */
    public InterfaceC5187at m31055j() {
        return this.f23866v;
    }

    /* renamed from: k */
    public SocketFactory m31056k() {
        return this.f23858n;
    }

    /* renamed from: l */
    public SSLSocketFactory m31057l() {
        return this.f23859o;
    }

    /* renamed from: m */
    public HostnameVerifier m31058m() {
        return this.f23861q;
    }

    /* renamed from: n */
    public C5179al m31059n() {
        return this.f23862r;
    }

    /* renamed from: o */
    public InterfaceC5174ag m31060o() {
        return this.f23864t;
    }

    /* renamed from: p */
    public InterfaceC5174ag m31061p() {
        return this.f23863s;
    }

    /* renamed from: q */
    public C5182ao m31062q() {
        return this.f23865u;
    }

    /* renamed from: r */
    public boolean m31063r() {
        return this.f23867w;
    }

    /* renamed from: s */
    public boolean m31064s() {
        return this.f23868x;
    }

    /* renamed from: t */
    public int m31065t() {
        return this.f23845F;
    }

    /* renamed from: u */
    public boolean m31066u() {
        return this.f23869y;
    }

    /* renamed from: v */
    public C5186as m31067v() {
        return this.f23847c;
    }

    /* renamed from: w */
    public List<EnumC5199bd> m31068w() {
        return this.f23849e;
    }

    /* renamed from: x */
    public List<C5183ap> m31069x() {
        return this.f23850f;
    }

    /* renamed from: y */
    public int m31070y() {
        return this.f23844E;
    }

    /* renamed from: z */
    public List<InterfaceC5196ba> m31071z() {
        return this.f23851g;
    }

    public C5198bc(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z10;
        this.f23846G = new b();
        this.f23847c = aVar.f23875a;
        this.f23848d = aVar.f23876b;
        this.f23849e = aVar.f23877c;
        List<C5183ap> list = aVar.f23878d;
        this.f23850f = list;
        this.f23851g = C5210bo.m31185a(aVar.f23879e);
        this.f23852h = C5210bo.m31185a(aVar.f23880f);
        this.f23853i = aVar.f23881g;
        this.f23854j = aVar.f23882h;
        this.f23855k = aVar.f23883i;
        this.f23856l = aVar.f23884j;
        this.f23857m = aVar.f23885k;
        this.f23858n = aVar.f23886l;
        Iterator<C5183ap> it = list.iterator();
        loop0: while (true) {
            z10 = false;
            while (it.hasNext()) {
                z10 = (z10 || it.next().m30857a()) ? true : z10;
            }
        }
        SSLSocketFactory sSLSocketFactory = aVar.f23887m;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager x509TrustManagerM31189a = C5210bo.m31189a();
            this.f23859o = m31040a(x509TrustManagerM31189a);
            this.f23860p = AbstractC5274dw.m31702a(x509TrustManagerM31189a);
        } else {
            this.f23859o = sSLSocketFactory;
            this.f23860p = aVar.f23888n;
        }
        if (this.f23859o != null) {
            C5269dr.m31692e().mo31676a(this.f23859o);
        }
        this.f23861q = aVar.f23889o;
        this.f23862r = aVar.f23890p.m30841a(this.f23860p);
        this.f23863s = aVar.f23891q;
        this.f23864t = aVar.f23892r;
        C5182ao c5182ao = aVar.f23893s;
        this.f23865u = c5182ao;
        this.f23866v = aVar.f23894t;
        this.f23867w = aVar.f23895u;
        this.f23868x = aVar.f23896v;
        this.f23869y = aVar.f23897w;
        this.f23870z = aVar.f23898x;
        this.f23840A = aVar.f23899y;
        this.f23841B = aVar.f23900z;
        this.f23842C = aVar.f23871A;
        this.f23843D = aVar.f23872B;
        this.f23845F = aVar.f23874D;
        if (this.f23851g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f23851g);
        }
        if (!this.f23852h.contains(null)) {
            this.f23844E = aVar.f23873C;
            c5182ao.m30853a(this.f23846G);
        } else {
            throw new IllegalStateException("Null network interceptor: " + this.f23852h);
        }
    }

    /* renamed from: b */
    public int m31047b(String str, int i10, String str2) {
        return this.f23865u.m30852a(str, i10, str2);
    }

    /* renamed from: a */
    public int m31043a() {
        return this.f23870z;
    }

    /* renamed from: a */
    public void m31045a(String str, int i10, String str2) {
        this.f23847c.mo30802a(str, i10, str2);
    }

    /* renamed from: a */
    public InterfaceC5177aj m31044a(C5201bf c5201bf) {
        return C5200be.m31092a(this, c5201bf, false);
    }
}
