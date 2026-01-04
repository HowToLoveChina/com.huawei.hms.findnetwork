package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
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
import okhttp3.AbstractC11953t;
import okhttp3.C11922g0;
import okhttp3.C11945l;
import okhttp3.C11955v;
import okhttp3.internal.connection.C11932f;
import okhttp3.internal.connection.C11937k;
import p661tx.InterfaceC13100c;
import p791xx.C13893h;
import p825yx.C14056a;
import p858zx.AbstractC14402c;
import p858zx.C14403d;
import sx.AbstractC12871a;
import sx.C12875e;

/* renamed from: okhttp3.b0 */
/* loaded from: classes9.dex */
public class C11912b0 implements Cloneable {

    /* renamed from: D */
    public static final List<EnumC11914c0> f55167D = C12875e.m77264u(EnumC11914c0.HTTP_2, EnumC11914c0.HTTP_1_1);

    /* renamed from: E */
    public static final List<C11946m> f55168E = C12875e.m77264u(C11946m.f55611h, C11946m.f55613j);

    /* renamed from: A */
    public final int f55169A;

    /* renamed from: B */
    public final int f55170B;

    /* renamed from: C */
    public final d f55171C;

    /* renamed from: a */
    public final C11949p f55172a;

    /* renamed from: b */
    public final Proxy f55173b;

    /* renamed from: c */
    public final List<EnumC11914c0> f55174c;

    /* renamed from: d */
    public final List<C11946m> f55175d;

    /* renamed from: e */
    public final List<InterfaceC11959z> f55176e;

    /* renamed from: f */
    public final List<InterfaceC11959z> f55177f;

    /* renamed from: g */
    public final AbstractC11953t.b f55178g;

    /* renamed from: h */
    public final ProxySelector f55179h;

    /* renamed from: i */
    public final InterfaceC11948o f55180i;

    /* renamed from: j */
    public final SocketFactory f55181j;

    /* renamed from: k */
    public final SSLSocketFactory f55182k;

    /* renamed from: l */
    public final AbstractC14402c f55183l;

    /* renamed from: m */
    public final HostnameVerifier f55184m;

    /* renamed from: n */
    public final C11923h f55185n;

    /* renamed from: o */
    public final InterfaceC11915d f55186o;

    /* renamed from: p */
    public final InterfaceC11915d f55187p;

    /* renamed from: q */
    public final C11945l f55188q;

    /* renamed from: r */
    public final InterfaceC11951r f55189r;

    /* renamed from: s */
    public final boolean f55190s;

    /* renamed from: t */
    public final boolean f55191t;

    /* renamed from: u */
    public final boolean f55192u;

    /* renamed from: v */
    public final int f55193v;

    /* renamed from: w */
    public final int f55194w;

    /* renamed from: x */
    public final int f55195x;

    /* renamed from: y */
    public final int f55196y;

    /* renamed from: z */
    public final int f55197z;

    /* renamed from: okhttp3.b0$a */
    public class a extends AbstractC12871a {
        @Override // sx.AbstractC12871a
        /* renamed from: a */
        public void mo71496a(C11955v.a aVar, String str) {
            aVar.m71862b(str);
        }

        @Override // sx.AbstractC12871a
        /* renamed from: b */
        public void mo71497b(C11955v.a aVar, String str, String str2) {
            aVar.m71863c(str, str2);
        }

        @Override // sx.AbstractC12871a
        /* renamed from: c */
        public void mo71498c(C11946m c11946m, SSLSocket sSLSocket, boolean z10) {
            c11946m.m71798a(sSLSocket, z10);
        }

        @Override // sx.AbstractC12871a
        /* renamed from: d */
        public int mo71499d(C11922g0.a aVar) {
            return aVar.f55308c;
        }

        @Override // sx.AbstractC12871a
        /* renamed from: e */
        public boolean mo71500e(C11911b c11911b, C11911b c11911b2) {
            return c11911b.m71451d(c11911b2);
        }

        @Override // sx.AbstractC12871a
        /* renamed from: f */
        public C11932f mo71501f(C11922g0 c11922g0) {
            return c11922g0.f55304m;
        }

        @Override // sx.AbstractC12871a
        /* renamed from: g */
        public void mo71502g(C11922g0.a aVar, C11932f c11932f) {
            aVar.m71613k(c11932f);
        }

        @Override // sx.AbstractC12871a
        /* renamed from: h */
        public C11937k mo71503h(C11945l c11945l) {
            return c11945l.delegate;
        }
    }

    /* renamed from: okhttp3.b0$b */
    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55198a;

        static {
            int[] iArr = new int[EnumC11914c0.values().length];
            f55198a = iArr;
            try {
                iArr[EnumC11914c0.HTTP_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55198a[EnumC11914c0.HTTP_1_0.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f55198a[EnumC11914c0.HTTP_1_1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f55198a[EnumC11914c0.SPDY_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: okhttp3.b0$d */
    public class d implements C11945l.a {
        public d() {
        }

        @Override // okhttp3.C11945l.a
        /* renamed from: a */
        public void mo71523a(String str, int i10, String str2) {
            C11912b0.this.f55172a.mo71835l(str, i10, str2);
        }

        public /* synthetic */ d(C11912b0 c11912b0, a aVar) {
            this();
        }
    }

    static {
        AbstractC12871a.f58633a = new a();
    }

    public C11912b0() {
        this(new c());
    }

    /* renamed from: A */
    public static SSLSocketFactory m71462A(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextMo83254m = C13893h.m83291l().mo83254m();
            sSLContextMo83254m.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextMo83254m.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS", e10);
        }
    }

    /* renamed from: B */
    public int m71463B() {
        return this.f55197z;
    }

    /* renamed from: C */
    public List<EnumC11914c0> m71464C() {
        return this.f55174c;
    }

    /* renamed from: D */
    public Proxy m71465D() {
        return this.f55173b;
    }

    /* renamed from: E */
    public InterfaceC11915d m71466E() {
        return this.f55186o;
    }

    /* renamed from: F */
    public ProxySelector m71467F() {
        return this.f55179h;
    }

    /* renamed from: G */
    public int m71468G() {
        return this.f55195x;
    }

    /* renamed from: H */
    public boolean m71469H() {
        return this.f55192u;
    }

    /* renamed from: J */
    public SocketFactory m71470J() {
        return this.f55181j;
    }

    /* renamed from: K */
    public SSLSocketFactory m71471K() {
        return this.f55182k;
    }

    /* renamed from: L */
    public int m71472L() {
        return this.f55196y;
    }

    /* renamed from: a */
    public void m71473a(String str, int i10, String str2) {
        this.f55172a.mo71826a(str, i10, str2);
    }

    /* renamed from: c */
    public InterfaceC11915d m71474c() {
        return this.f55187p;
    }

    /* renamed from: d */
    public int m71475d() {
        return this.f55193v;
    }

    /* renamed from: f */
    public C11923h m71476f() {
        return this.f55185n;
    }

    /* renamed from: g */
    public int m71477g() {
        return this.f55194w;
    }

    /* renamed from: i */
    public int m71478i() {
        return this.f55169A;
    }

    /* renamed from: j */
    public C11945l m71479j() {
        return this.f55188q;
    }

    /* renamed from: k */
    public List<C11946m> m71480k() {
        return this.f55175d;
    }

    /* renamed from: l */
    public InterfaceC11948o m71481l() {
        return this.f55180i;
    }

    /* renamed from: m */
    public C11949p m71482m() {
        return this.f55172a;
    }

    /* renamed from: n */
    public InterfaceC11951r m71483n() {
        return this.f55189r;
    }

    /* renamed from: o */
    public AbstractC11953t.b m71484o() {
        return this.f55178g;
    }

    /* renamed from: p */
    public boolean m71485p() {
        return this.f55191t;
    }

    /* renamed from: q */
    public boolean m71486q() {
        return this.f55190s;
    }

    /* renamed from: r */
    public int m71487r() {
        return this.f55170B;
    }

    /* renamed from: s */
    public HostnameVerifier m71488s() {
        return this.f55184m;
    }

    /* renamed from: t */
    public int m71489t(String str, int i10, String str2) {
        return this.f55188q.m71796b(str, i10, str2);
    }

    /* renamed from: u */
    public List<InterfaceC11959z> m71490u() {
        return this.f55176e;
    }

    /* renamed from: v */
    public InterfaceC13100c m71491v() {
        return null;
    }

    /* renamed from: w */
    public boolean m71492w(String str, int i10, String str2) {
        return this.f55188q.m71797c(str, i10, str2);
    }

    /* renamed from: x */
    public List<InterfaceC11959z> m71493x() {
        return this.f55177f;
    }

    /* renamed from: y */
    public c m71494y() {
        return new c(this);
    }

    /* renamed from: z */
    public InterfaceC11919f m71495z(C11918e0 c11918e0) {
        return C11916d0.m71529g(this, c11918e0, false);
    }

    public C11912b0(c cVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z10;
        this.f55171C = new d(this, null);
        this.f55172a = cVar.f55201a;
        this.f55173b = cVar.f55202b;
        this.f55174c = cVar.f55203c;
        List<C11946m> list = cVar.f55204d;
        this.f55175d = list;
        this.f55176e = C12875e.m77263t(cVar.f55205e);
        this.f55177f = C12875e.m77263t(cVar.f55206f);
        this.f55178g = cVar.f55207g;
        this.f55179h = cVar.f55208h;
        this.f55180i = cVar.f55209i;
        this.f55181j = cVar.f55210j;
        Iterator<C11946m> it = list.iterator();
        loop0: while (true) {
            z10 = false;
            while (it.hasNext()) {
                z10 = (z10 || it.next().m71801d()) ? true : z10;
            }
        }
        SSLSocketFactory sSLSocketFactory = cVar.f55211k;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager x509TrustManagerM77234E = C12875e.m77234E();
            this.f55182k = m71462A(x509TrustManagerM77234E);
            this.f55183l = AbstractC14402c.m85631b(x509TrustManagerM77234E);
        } else {
            this.f55182k = sSLSocketFactory;
            this.f55183l = cVar.f55212l;
        }
        if (this.f55182k != null) {
            C13893h.m83291l().mo83274f(this.f55182k);
        }
        this.f55184m = cVar.f55213m;
        this.f55185n = cVar.f55214n.m71627f(this.f55183l);
        this.f55186o = cVar.f55215o;
        this.f55187p = cVar.f55216p;
        C11945l c11945l = cVar.f55217q;
        this.f55188q = c11945l;
        this.f55189r = cVar.f55218r;
        this.f55190s = cVar.f55219s;
        this.f55191t = cVar.f55220t;
        this.f55192u = cVar.f55221u;
        this.f55193v = cVar.f55222v;
        this.f55194w = cVar.f55223w;
        this.f55195x = cVar.f55224x;
        this.f55196y = cVar.f55225y;
        this.f55197z = cVar.f55226z;
        this.f55170B = cVar.f55200B;
        if (this.f55176e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f55176e);
        }
        if (!this.f55177f.contains(null)) {
            this.f55169A = cVar.f55199A;
            c11945l.m71795a(this.f55171C);
        } else {
            throw new IllegalStateException("Null network interceptor: " + this.f55177f);
        }
    }

    /* renamed from: okhttp3.b0$c */
    public static final class c {

        /* renamed from: A */
        public int f55199A;

        /* renamed from: B */
        public int f55200B;

        /* renamed from: a */
        public C11949p f55201a;

        /* renamed from: b */
        public Proxy f55202b;

        /* renamed from: c */
        public List<EnumC11914c0> f55203c;

        /* renamed from: d */
        public List<C11946m> f55204d;

        /* renamed from: e */
        public final List<InterfaceC11959z> f55205e;

        /* renamed from: f */
        public final List<InterfaceC11959z> f55206f;

        /* renamed from: g */
        public AbstractC11953t.b f55207g;

        /* renamed from: h */
        public ProxySelector f55208h;

        /* renamed from: i */
        public InterfaceC11948o f55209i;

        /* renamed from: j */
        public SocketFactory f55210j;

        /* renamed from: k */
        public SSLSocketFactory f55211k;

        /* renamed from: l */
        public AbstractC14402c f55212l;

        /* renamed from: m */
        public HostnameVerifier f55213m;

        /* renamed from: n */
        public C11923h f55214n;

        /* renamed from: o */
        public InterfaceC11915d f55215o;

        /* renamed from: p */
        public InterfaceC11915d f55216p;

        /* renamed from: q */
        public C11945l f55217q;

        /* renamed from: r */
        public InterfaceC11951r f55218r;

        /* renamed from: s */
        public boolean f55219s;

        /* renamed from: t */
        public boolean f55220t;

        /* renamed from: u */
        public boolean f55221u;

        /* renamed from: v */
        public int f55222v;

        /* renamed from: w */
        public int f55223w;

        /* renamed from: x */
        public int f55224x;

        /* renamed from: y */
        public int f55225y;

        /* renamed from: z */
        public int f55226z;

        public c() {
            this.f55205e = new ArrayList();
            this.f55206f = new ArrayList();
            this.f55201a = new C11949p();
            this.f55203c = C11912b0.f55167D;
            this.f55204d = C11912b0.f55168E;
            this.f55207g = AbstractC11953t.factory(AbstractC11953t.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f55208h = proxySelector;
            if (proxySelector == null) {
                this.f55208h = new C14056a();
            }
            this.f55209i = InterfaceC11948o.f55635a;
            this.f55210j = SocketFactory.getDefault();
            this.f55213m = C14403d.f63771a;
            this.f55214n = C11923h.f55319c;
            InterfaceC11915d interfaceC11915d = InterfaceC11915d.f55236a;
            this.f55215o = interfaceC11915d;
            this.f55216p = interfaceC11915d;
            this.f55217q = new C11945l();
            this.f55218r = InterfaceC11951r.f55643d;
            this.f55219s = true;
            this.f55220t = true;
            this.f55221u = true;
            this.f55222v = 0;
            this.f55223w = 10000;
            this.f55224x = 10000;
            this.f55225y = 10000;
            this.f55226z = 0;
            this.f55200B = 0;
            this.f55199A = 200;
        }

        /* renamed from: a */
        public c m71504a(InterfaceC11959z interfaceC11959z) {
            if (interfaceC11959z == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f55205e.add(interfaceC11959z);
            return this;
        }

        /* renamed from: b */
        public C11912b0 m71505b() {
            return new C11912b0(this);
        }

        /* renamed from: c */
        public c m71506c(long j10, TimeUnit timeUnit) {
            this.f55222v = C12875e.m77248e("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: d */
        public c m71507d(long j10, TimeUnit timeUnit) {
            this.f55223w = C12875e.m77248e("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: e */
        public c m71508e(C11945l c11945l) {
            if (c11945l == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f55217q = c11945l;
            return this;
        }

        /* renamed from: f */
        public C11949p m71509f(EnumC11914c0 enumC11914c0) {
            int i10 = b.f55198a[enumC11914c0.ordinal()];
            if (i10 == 1) {
                return new C11956w();
            }
            if (i10 == 2 || i10 == 3 || i10 == 4) {
                return new C11949p();
            }
            throw new IllegalArgumentException("there is no dispatcher fit for the protocol " + enumC11914c0.toString());
        }

        /* renamed from: g */
        public c m71510g(C11949p c11949p) {
            if (c11949p == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f55201a = c11949p;
            return this;
        }

        /* renamed from: h */
        public c m71511h(InterfaceC11951r interfaceC11951r) {
            if (interfaceC11951r == null) {
                throw new NullPointerException("dns == null");
            }
            this.f55218r = interfaceC11951r;
            return this;
        }

        /* renamed from: i */
        public c m71512i(AbstractC11953t abstractC11953t) {
            if (abstractC11953t == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.f55207g = AbstractC11953t.factory(abstractC11953t);
            return this;
        }

        /* renamed from: j */
        public c m71513j(boolean z10) {
            this.f55220t = z10;
            return this;
        }

        /* renamed from: k */
        public c m71514k(boolean z10) {
            this.f55219s = z10;
            return this;
        }

        /* renamed from: l */
        public c m71515l(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.f55213m = hostnameVerifier;
            return this;
        }

        /* renamed from: m */
        public c m71516m(long j10, TimeUnit timeUnit) {
            this.f55226z = C12875e.m77248e("interval", j10, timeUnit);
            return this;
        }

        /* renamed from: n */
        public c m71517n(List<EnumC11914c0> list) {
            ArrayList arrayList = new ArrayList(list);
            EnumC11914c0 enumC11914c0 = EnumC11914c0.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(enumC11914c0) && !arrayList.contains(EnumC11914c0.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(enumC11914c0) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(EnumC11914c0.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(EnumC11914c0.SPDY_3);
            this.f55203c = Collections.unmodifiableList(arrayList);
            return this;
        }

        /* renamed from: o */
        public c m71518o(Proxy proxy) {
            this.f55202b = proxy;
            return this;
        }

        /* renamed from: p */
        public c m71519p(long j10, TimeUnit timeUnit) {
            this.f55224x = C12875e.m77248e("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: q */
        public c m71520q(boolean z10) {
            this.f55221u = z10;
            return this;
        }

        /* renamed from: r */
        public c m71521r(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f55211k = sSLSocketFactory;
            this.f55212l = AbstractC14402c.m85631b(x509TrustManager);
            return this;
        }

        /* renamed from: s */
        public c m71522s(long j10, TimeUnit timeUnit) {
            this.f55225y = C12875e.m77248e("timeout", j10, timeUnit);
            return this;
        }

        public c(C11912b0 c11912b0) {
            ArrayList arrayList = new ArrayList();
            this.f55205e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f55206f = arrayList2;
            this.f55201a = c11912b0.f55172a;
            this.f55202b = c11912b0.f55173b;
            this.f55203c = c11912b0.f55174c;
            this.f55204d = c11912b0.f55175d;
            arrayList.addAll(c11912b0.f55176e);
            arrayList2.addAll(c11912b0.f55177f);
            this.f55207g = c11912b0.f55178g;
            this.f55208h = c11912b0.f55179h;
            this.f55209i = c11912b0.f55180i;
            this.f55210j = c11912b0.f55181j;
            this.f55211k = c11912b0.f55182k;
            this.f55212l = c11912b0.f55183l;
            this.f55213m = c11912b0.f55184m;
            this.f55214n = c11912b0.f55185n;
            this.f55215o = c11912b0.f55186o;
            this.f55216p = c11912b0.f55187p;
            this.f55217q = c11912b0.f55188q;
            this.f55218r = c11912b0.f55189r;
            this.f55219s = c11912b0.f55190s;
            this.f55220t = c11912b0.f55191t;
            this.f55221u = c11912b0.f55192u;
            this.f55222v = c11912b0.f55193v;
            this.f55223w = c11912b0.f55194w;
            this.f55224x = c11912b0.f55195x;
            this.f55225y = c11912b0.f55196y;
            this.f55226z = c11912b0.f55197z;
            this.f55199A = c11912b0.f55169A;
            this.f55200B = c11912b0.f55170B;
        }
    }
}
