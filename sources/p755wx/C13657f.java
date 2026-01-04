package p755wx;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p022ay.C1054d;
import p022ay.C1057g;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;
import p755wx.C13659h;
import p791xx.C13893h;
import sx.AbstractRunnableC12872b;
import sx.C12875e;

/* renamed from: wx.f */
/* loaded from: classes9.dex */
public final class C13657f implements Closeable {

    /* renamed from: z */
    public static final ExecutorService f61410z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C12875e.m77239J("OkHttp Http2Connection", true));

    /* renamed from: a */
    public final boolean f61411a;

    /* renamed from: b */
    public final j f61412b;

    /* renamed from: d */
    public final String f61414d;

    /* renamed from: e */
    public int f61415e;

    /* renamed from: f */
    public int f61416f;

    /* renamed from: g */
    public boolean f61417g;

    /* renamed from: h */
    public final ScheduledExecutorService f61418h;

    /* renamed from: i */
    public final ExecutorService f61419i;

    /* renamed from: j */
    public final InterfaceC13663l f61420j;

    /* renamed from: s */
    public long f61429s;

    /* renamed from: u */
    public final C13664m f61431u;

    /* renamed from: v */
    public final Socket f61432v;

    /* renamed from: w */
    public final C13661j f61433w;

    /* renamed from: x */
    public final l f61434x;

    /* renamed from: y */
    public final Set<Integer> f61435y;

    /* renamed from: c */
    public final Map<Integer, C13660i> f61413c = new LinkedHashMap();

    /* renamed from: k */
    public long f61421k = 0;

    /* renamed from: l */
    public long f61422l = 0;

    /* renamed from: m */
    public long f61423m = 0;

    /* renamed from: n */
    public long f61424n = 0;

    /* renamed from: o */
    public long f61425o = 0;

    /* renamed from: p */
    public long f61426p = 0;

    /* renamed from: q */
    public long f61427q = 0;

    /* renamed from: r */
    public long f61428r = 0;

    /* renamed from: t */
    public C13664m f61430t = new C13664m();

    /* renamed from: wx.f$a */
    public class a extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final /* synthetic */ int f61436b;

        /* renamed from: c */
        public final /* synthetic */ EnumC13653b f61437c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i10, EnumC13653b enumC13653b) {
            super(str, objArr);
            this.f61436b = i10;
            this.f61437c = enumC13653b;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() throws IOException {
            try {
                C13657f.this.m82101i0(this.f61436b, this.f61437c);
            } catch (IOException e10) {
                C13657f.this.m82105x(e10);
            }
        }
    }

    /* renamed from: wx.f$b */
    public class b extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final /* synthetic */ int f61439b;

        /* renamed from: c */
        public final /* synthetic */ long f61440c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i10, long j10) {
            super(str, objArr);
            this.f61439b = i10;
            this.f61440c = j10;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() throws IOException {
            try {
                C13657f.this.f61433w.m82168D(this.f61439b, this.f61440c);
            } catch (IOException e10) {
                C13657f.this.m82105x(e10);
            }
        }
    }

    /* renamed from: wx.f$c */
    public class c extends AbstractRunnableC12872b {
        public c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() throws IOException {
            C13657f.this.m82100g0(false, 2, 0);
        }
    }

    /* renamed from: wx.f$d */
    public class d extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final /* synthetic */ int f61443b;

        /* renamed from: c */
        public final /* synthetic */ List f61444c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i10, List list) {
            super(str, objArr);
            this.f61443b = i10;
            this.f61444c = list;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() {
            if (C13657f.this.f61420j.mo82186b(this.f61443b, this.f61444c)) {
                try {
                    C13657f.this.f61433w.m82166B(this.f61443b, EnumC13653b.CANCEL);
                    synchronized (C13657f.this) {
                        C13657f.this.f61435y.remove(Integer.valueOf(this.f61443b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: wx.f$e */
    public class e extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final /* synthetic */ int f61446b;

        /* renamed from: c */
        public final /* synthetic */ List f61447c;

        /* renamed from: d */
        public final /* synthetic */ boolean f61448d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Object[] objArr, int i10, List list, boolean z10) {
            super(str, objArr);
            this.f61446b = i10;
            this.f61447c = list;
            this.f61448d = z10;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() {
            boolean zMo82187c = C13657f.this.f61420j.mo82187c(this.f61446b, this.f61447c, this.f61448d);
            if (zMo82187c) {
                try {
                    C13657f.this.f61433w.m82166B(this.f61446b, EnumC13653b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zMo82187c || this.f61448d) {
                synchronized (C13657f.this) {
                    C13657f.this.f61435y.remove(Integer.valueOf(this.f61446b));
                }
            }
        }
    }

    /* renamed from: wx.f$f */
    public class f extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final /* synthetic */ int f61450b;

        /* renamed from: c */
        public final /* synthetic */ C1054d f61451c;

        /* renamed from: d */
        public final /* synthetic */ int f61452d;

        /* renamed from: e */
        public final /* synthetic */ boolean f61453e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i10, C1054d c1054d, int i11, boolean z10) {
            super(str, objArr);
            this.f61450b = i10;
            this.f61451c = c1054d;
            this.f61452d = i11;
            this.f61453e = z10;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() {
            try {
                boolean zMo82188d = C13657f.this.f61420j.mo82188d(this.f61450b, this.f61451c, this.f61452d, this.f61453e);
                if (zMo82188d) {
                    C13657f.this.f61433w.m82166B(this.f61450b, EnumC13653b.CANCEL);
                }
                if (zMo82188d || this.f61453e) {
                    synchronized (C13657f.this) {
                        C13657f.this.f61435y.remove(Integer.valueOf(this.f61450b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: wx.f$g */
    public class g extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final /* synthetic */ int f61455b;

        /* renamed from: c */
        public final /* synthetic */ EnumC13653b f61456c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i10, EnumC13653b enumC13653b) {
            super(str, objArr);
            this.f61455b = i10;
            this.f61456c = enumC13653b;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() {
            C13657f.this.f61420j.mo82185a(this.f61455b, this.f61456c);
            synchronized (C13657f.this) {
                C13657f.this.f61435y.remove(Integer.valueOf(this.f61455b));
            }
        }
    }

    /* renamed from: wx.f$h */
    public static class h {

        /* renamed from: a */
        public Socket f61458a;

        /* renamed from: b */
        public String f61459b;

        /* renamed from: c */
        public InterfaceC1056f f61460c;

        /* renamed from: d */
        public InterfaceC1055e f61461d;

        /* renamed from: e */
        public j f61462e = j.f61467a;

        /* renamed from: f */
        public InterfaceC13663l f61463f = InterfaceC13663l.f61538a;

        /* renamed from: g */
        public boolean f61464g;

        /* renamed from: h */
        public int f61465h;

        public h(boolean z10) {
            this.f61464g = z10;
        }

        /* renamed from: a */
        public C13657f m82108a() {
            return new C13657f(this);
        }

        /* renamed from: b */
        public h m82109b(j jVar) {
            this.f61462e = jVar;
            return this;
        }

        /* renamed from: c */
        public h m82110c(int i10) {
            this.f61465h = i10;
            return this;
        }

        /* renamed from: d */
        public h m82111d(Socket socket, String str, InterfaceC1056f interfaceC1056f, InterfaceC1055e interfaceC1055e) {
            this.f61458a = socket;
            this.f61459b = str;
            this.f61460c = interfaceC1056f;
            this.f61461d = interfaceC1055e;
            return this;
        }
    }

    /* renamed from: wx.f$i */
    public final class i extends AbstractRunnableC12872b {
        public i() {
            super("OkHttp %s ping", C13657f.this.f61414d);
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() throws IOException {
            boolean z10;
            synchronized (C13657f.this) {
                if (C13657f.this.f61422l < C13657f.this.f61421k) {
                    z10 = true;
                } else {
                    C13657f.m82076f(C13657f.this);
                    z10 = false;
                }
            }
            if (z10) {
                C13657f.this.m82105x(null);
            } else {
                C13657f.this.m82100g0(false, 1, 0);
            }
        }
    }

    /* renamed from: wx.f$j */
    public static abstract class j {

        /* renamed from: a */
        public static final j f61467a = new a();

        /* renamed from: wx.f$j$a */
        public class a extends j {
            @Override // p755wx.C13657f.j
            /* renamed from: c */
            public void mo71711c(C13660i c13660i) throws IOException {
                c13660i.m82144d(EnumC13653b.REFUSED_STREAM, null);
            }
        }

        /* renamed from: b */
        public void mo71710b(C13657f c13657f) {
        }

        /* renamed from: c */
        public abstract void mo71711c(C13660i c13660i) throws IOException;
    }

    /* renamed from: wx.f$k */
    public final class k extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final boolean f61468b;

        /* renamed from: c */
        public final int f61469c;

        /* renamed from: d */
        public final int f61470d;

        public k(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", C13657f.this.f61414d, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f61468b = z10;
            this.f61469c = i10;
            this.f61470d = i11;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() throws IOException {
            C13657f.this.m82100g0(this.f61468b, this.f61469c, this.f61470d);
        }
    }

    /* renamed from: wx.f$l */
    public class l extends AbstractRunnableC12872b implements C13659h.b {

        /* renamed from: b */
        public final C13659h f61472b;

        /* renamed from: wx.f$l$a */
        public class a extends AbstractRunnableC12872b {

            /* renamed from: b */
            public final /* synthetic */ C13660i f61474b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, C13660i c13660i) {
                super(str, objArr);
                this.f61474b = c13660i;
            }

            @Override // sx.AbstractRunnableC12872b
            /* renamed from: l */
            public void mo71536l() {
                try {
                    C13657f.this.f61412b.mo71711c(this.f61474b);
                } catch (IOException e10) {
                    C13893h.m83291l().mo83257s(4, "Http2Connection.Listener failure for " + C13657f.this.f61414d, e10);
                    try {
                        this.f61474b.m82144d(EnumC13653b.PROTOCOL_ERROR, e10);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: wx.f$l$b */
        public class b extends AbstractRunnableC12872b {

            /* renamed from: b */
            public final /* synthetic */ boolean f61476b;

            /* renamed from: c */
            public final /* synthetic */ C13664m f61477c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object[] objArr, boolean z10, C13664m c13664m) {
                super(str, objArr);
                this.f61476b = z10;
                this.f61477c = c13664m;
            }

            @Override // sx.AbstractRunnableC12872b
            /* renamed from: l */
            public void mo71536l() {
                l.this.m82122m(this.f61476b, this.f61477c);
            }
        }

        /* renamed from: wx.f$l$c */
        public class c extends AbstractRunnableC12872b {
            public c(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // sx.AbstractRunnableC12872b
            /* renamed from: l */
            public void mo71536l() {
                C13657f c13657f = C13657f.this;
                c13657f.f61412b.mo71710b(c13657f);
            }
        }

        public l(C13659h c13659h) {
            super("OkHttp %s", C13657f.this.f61414d);
            this.f61472b = c13659h;
        }

        @Override // p755wx.C13659h.b
        /* renamed from: a */
        public void mo82112a() {
        }

        @Override // p755wx.C13659h.b
        /* renamed from: c */
        public void mo82113c(boolean z10, int i10, int i11, List<C13654c> list) {
            if (C13657f.this.m82091I(i10)) {
                C13657f.this.m82088F(i10, list, z10);
                return;
            }
            synchronized (C13657f.this) {
                try {
                    C13660i c13660iM82106y = C13657f.this.m82106y(i10);
                    if (c13660iM82106y != null) {
                        c13660iM82106y.m82154n(C12875e.m77241L(list), z10);
                        return;
                    }
                    if (C13657f.this.f61417g) {
                        return;
                    }
                    C13657f c13657f = C13657f.this;
                    if (i10 <= c13657f.f61415e) {
                        return;
                    }
                    if (i10 % 2 == c13657f.f61416f % 2) {
                        return;
                    }
                    C13660i c13660i = new C13660i(i10, C13657f.this, false, z10, C12875e.m77241L(list));
                    C13657f c13657f2 = C13657f.this;
                    c13657f2.f61415e = i10;
                    c13657f2.f61413c.put(Integer.valueOf(i10), c13660i);
                    C13657f.f61410z.execute(new a("OkHttp %s stream %d", new Object[]{C13657f.this.f61414d, Integer.valueOf(i10)}, c13660i));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // p755wx.C13659h.b
        /* renamed from: d */
        public void mo82114d(int i10, EnumC13653b enumC13653b) {
            if (C13657f.this.m82091I(i10)) {
                C13657f.this.m82090H(i10, enumC13653b);
                return;
            }
            C13660i c13660iM82092J = C13657f.this.m82092J(i10);
            if (c13660iM82092J != null) {
                c13660iM82092J.m82155o(enumC13653b);
            }
        }

        @Override // p755wx.C13659h.b
        /* renamed from: e */
        public void mo82115e(boolean z10, C13664m c13664m) {
            try {
                C13657f.this.f61418h.execute(new b("OkHttp %s ACK Settings", new Object[]{C13657f.this.f61414d}, z10, c13664m));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // p755wx.C13659h.b
        /* renamed from: f */
        public void mo82116f(int i10, long j10) {
            if (i10 == 0) {
                synchronized (C13657f.this) {
                    C13657f c13657f = C13657f.this;
                    c13657f.f61429s += j10;
                    c13657f.notifyAll();
                }
                return;
            }
            C13660i c13660iM82106y = C13657f.this.m82106y(i10);
            if (c13660iM82106y != null) {
                synchronized (c13660iM82106y) {
                    c13660iM82106y.m82141a(j10);
                }
            }
        }

        @Override // p755wx.C13659h.b
        /* renamed from: g */
        public void mo82117g(boolean z10, int i10, int i11) {
            if (!z10) {
                try {
                    C13657f.this.f61418h.execute(C13657f.this.new k(true, i10, i11));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (C13657f.this) {
                try {
                    if (i10 == 1) {
                        C13657f.m82074d(C13657f.this);
                    } else if (i10 == 2) {
                        C13657f.m82081u(C13657f.this);
                    } else if (i10 == 3) {
                        C13657f.m82082v(C13657f.this);
                        C13657f.this.notifyAll();
                    }
                } finally {
                }
            }
        }

        @Override // p755wx.C13659h.b
        /* renamed from: h */
        public void mo82118h(int i10, int i11, int i12, boolean z10) {
        }

        @Override // p755wx.C13659h.b
        /* renamed from: i */
        public void mo82119i(int i10, int i11, List<C13654c> list) {
            C13657f.this.m82089G(i11, list);
        }

        @Override // p755wx.C13659h.b
        /* renamed from: j */
        public void mo82120j(boolean z10, int i10, InterfaceC1056f interfaceC1056f, int i11) throws IOException {
            if (C13657f.this.m82091I(i10)) {
                C13657f.this.m82086D(i10, interfaceC1056f, i11, z10);
                return;
            }
            C13660i c13660iM82106y = C13657f.this.m82106y(i10);
            if (c13660iM82106y == null) {
                C13657f.this.m82102j0(i10, EnumC13653b.PROTOCOL_ERROR);
                long j10 = i11;
                C13657f.this.m82097a0(j10);
                interfaceC1056f.skip(j10);
                return;
            }
            c13660iM82106y.m82153m(interfaceC1056f, i11);
            if (z10) {
                c13660iM82106y.m82154n(C12875e.f58642c, true);
            }
        }

        @Override // p755wx.C13659h.b
        /* renamed from: k */
        public void mo82121k(int i10, EnumC13653b enumC13653b, C1057g c1057g) {
            C13660i[] c13660iArr;
            c1057g.m6370E();
            synchronized (C13657f.this) {
                c13660iArr = (C13660i[]) C13657f.this.f61413c.values().toArray(new C13660i[C13657f.this.f61413c.size()]);
                C13657f.this.f61417g = true;
            }
            for (C13660i c13660i : c13660iArr) {
                if (c13660i.m82147g() > i10 && c13660i.m82150j()) {
                    c13660i.m82155o(EnumC13653b.REFUSED_STREAM);
                    C13657f.this.m82092J(c13660i.m82147g());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable, wx.h] */
        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() throws Throwable {
            EnumC13653b enumC13653b;
            EnumC13653b enumC13653b2;
            EnumC13653b enumC13653b3 = EnumC13653b.INTERNAL_ERROR;
            IOException iOException = null;
            iOException = null;
            iOException = null;
            try {
                try {
                    this.f61472b.m82128d(this);
                    while (this.f61472b.m82127c(false, this)) {
                    }
                    enumC13653b2 = EnumC13653b.NO_ERROR;
                } catch (IOException e10) {
                    e = e10;
                } catch (NullPointerException e11) {
                    e = e11;
                    enumC13653b2 = enumC13653b3;
                } catch (Throwable th2) {
                    th = th2;
                    enumC13653b = enumC13653b3;
                    C13657f.this.m82104w(enumC13653b, enumC13653b3, iOException);
                    C12875e.m77250g(this.f61472b);
                    throw th;
                }
                try {
                    enumC13653b3 = EnumC13653b.CANCEL;
                    C13657f.this.m82104w(enumC13653b2, enumC13653b3, null);
                    enumC13653b = enumC13653b2;
                } catch (IOException e12) {
                    e = e12;
                    enumC13653b3 = EnumC13653b.PROTOCOL_ERROR;
                    C13657f c13657f = C13657f.this;
                    c13657f.m82104w(enumC13653b3, enumC13653b3, e);
                    iOException = e;
                    enumC13653b = c13657f;
                    this = this.f61472b;
                    C12875e.m77250g(this);
                } catch (NullPointerException e13) {
                    e = e13;
                    C13893h.m83291l().mo83257s(5, e.getMessage(), e);
                    IOException iOException2 = new IOException(e);
                    C13657f c13657f2 = C13657f.this;
                    c13657f2.m82104w(enumC13653b2, enumC13653b3, iOException2);
                    iOException = c13657f2;
                    enumC13653b = enumC13653b2;
                    this = this.f61472b;
                    C12875e.m77250g(this);
                }
                this = this.f61472b;
                C12875e.m77250g(this);
            } catch (Throwable th3) {
                th = th3;
                C13657f.this.m82104w(enumC13653b, enumC13653b3, iOException);
                C12875e.m77250g(this.f61472b);
                throw th;
            }
        }

        /* renamed from: m */
        public void m82122m(boolean z10, C13664m c13664m) {
            C13660i[] c13660iArr;
            long j10;
            synchronized (C13657f.this.f61433w) {
                synchronized (C13657f.this) {
                    try {
                        int iM82192d = C13657f.this.f61431u.m82192d();
                        if (z10) {
                            C13657f.this.f61431u.m82189a();
                        }
                        C13657f.this.f61431u.m82196h(c13664m);
                        int iM82192d2 = C13657f.this.f61431u.m82192d();
                        c13660iArr = null;
                        if (iM82192d2 == -1 || iM82192d2 == iM82192d) {
                            j10 = 0;
                        } else {
                            j10 = iM82192d2 - iM82192d;
                            if (!C13657f.this.f61413c.isEmpty()) {
                                c13660iArr = (C13660i[]) C13657f.this.f61413c.values().toArray(new C13660i[C13657f.this.f61413c.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    C13657f c13657f = C13657f.this;
                    c13657f.f61433w.m82170b(c13657f.f61431u);
                } catch (IOException e10) {
                    C13657f.this.m82105x(e10);
                }
            }
            if (c13660iArr != null) {
                for (C13660i c13660i : c13660iArr) {
                    synchronized (c13660i) {
                        c13660i.m82141a(j10);
                    }
                }
            }
            C13657f.f61410z.execute(new c("OkHttp %s settings", C13657f.this.f61414d));
        }
    }

    public C13657f(h hVar) {
        C13664m c13664m = new C13664m();
        this.f61431u = c13664m;
        this.f61435y = new LinkedHashSet();
        this.f61420j = hVar.f61463f;
        boolean z10 = hVar.f61464g;
        this.f61411a = z10;
        this.f61412b = hVar.f61462e;
        int i10 = z10 ? 1 : 2;
        this.f61416f = i10;
        if (z10) {
            this.f61416f = i10 + 2;
        }
        if (z10) {
            this.f61430t.m82197i(7, 16777216);
        }
        String str = hVar.f61459b;
        this.f61414d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C12875e.m77239J(C12875e.m77260q("OkHttp %s Writer", str), false));
        this.f61418h = scheduledThreadPoolExecutor;
        if (hVar.f61465h != 0) {
            i iVar = new i();
            int i11 = hVar.f61465h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i11, i11, TimeUnit.MILLISECONDS);
        }
        this.f61419i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C12875e.m77239J(C12875e.m77260q("OkHttp %s Push Observer", str), true));
        c13664m.m82197i(7, 65535);
        c13664m.m82197i(5, 16384);
        this.f61429s = c13664m.m82192d();
        this.f61432v = hVar.f61458a;
        this.f61433w = new C13661j(hVar.f61461d, z10);
        this.f61434x = new l(new C13659h(hVar.f61460c, z10));
    }

    /* renamed from: d */
    public static /* synthetic */ long m82074d(C13657f c13657f) {
        long j10 = c13657f.f61422l;
        c13657f.f61422l = 1 + j10;
        return j10;
    }

    /* renamed from: f */
    public static /* synthetic */ long m82076f(C13657f c13657f) {
        long j10 = c13657f.f61421k;
        c13657f.f61421k = 1 + j10;
        return j10;
    }

    /* renamed from: u */
    public static /* synthetic */ long m82081u(C13657f c13657f) {
        long j10 = c13657f.f61424n;
        c13657f.f61424n = 1 + j10;
        return j10;
    }

    /* renamed from: v */
    public static /* synthetic */ long m82082v(C13657f c13657f) {
        long j10 = c13657f.f61426p;
        c13657f.f61426p = 1 + j10;
        return j10;
    }

    /* renamed from: A */
    public synchronized int m82083A() {
        return this.f61431u.m82193e(Integer.MAX_VALUE);
    }

    /* renamed from: B */
    public final C13660i m82084B(int i10, List<C13654c> list, boolean z10) throws IOException {
        int i11;
        C13660i c13660i;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.f61433w) {
            try {
                synchronized (this) {
                    try {
                        if (this.f61416f > 1073741823) {
                            m82094X(EnumC13653b.REFUSED_STREAM);
                        }
                        if (this.f61417g) {
                            throw new C13652a();
                        }
                        i11 = this.f61416f;
                        this.f61416f = i11 + 2;
                        c13660i = new C13660i(i11, this, z12, false, null);
                        z11 = !z10 || this.f61429s == 0 || c13660i.f61500b == 0;
                        if (c13660i.m82151k()) {
                            this.f61413c.put(Integer.valueOf(i11), c13660i);
                        }
                    } finally {
                    }
                }
                if (i10 == 0) {
                    this.f61433w.m82176x(z12, i11, list);
                } else {
                    if (this.f61411a) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.f61433w.m82165A(i10, i11, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            this.f61433w.flush();
        }
        return c13660i;
    }

    /* renamed from: C */
    public C13660i m82085C(List<C13654c> list, boolean z10) throws IOException {
        return m82084B(0, list, z10);
    }

    /* renamed from: D */
    public void m82086D(int i10, InterfaceC1056f interfaceC1056f, int i11, boolean z10) throws IOException {
        C1054d c1054d = new C1054d();
        long j10 = i11;
        interfaceC1056f.mo6357w0(j10);
        interfaceC1056f.read(c1054d, j10);
        if (c1054d.m6322J() == j10) {
            m82087E(new f("OkHttp %s Push Data[%s]", new Object[]{this.f61414d, Integer.valueOf(i10)}, i10, c1054d, i11, z10));
            return;
        }
        throw new IOException(c1054d.m6322J() + " != " + i11);
    }

    /* renamed from: E */
    public final synchronized void m82087E(AbstractRunnableC12872b abstractRunnableC12872b) {
        if (!this.f61417g) {
            this.f61419i.execute(abstractRunnableC12872b);
        }
    }

    /* renamed from: F */
    public void m82088F(int i10, List<C13654c> list, boolean z10) {
        try {
            m82087E(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f61414d, Integer.valueOf(i10)}, i10, list, z10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: G */
    public void m82089G(int i10, List<C13654c> list) {
        synchronized (this) {
            try {
                if (this.f61435y.contains(Integer.valueOf(i10))) {
                    m82102j0(i10, EnumC13653b.PROTOCOL_ERROR);
                    return;
                }
                this.f61435y.add(Integer.valueOf(i10));
                try {
                    m82087E(new d("OkHttp %s Push Request[%s]", new Object[]{this.f61414d, Integer.valueOf(i10)}, i10, list));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: H */
    public void m82090H(int i10, EnumC13653b enumC13653b) {
        m82087E(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f61414d, Integer.valueOf(i10)}, i10, enumC13653b));
    }

    /* renamed from: I */
    public boolean m82091I(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    /* renamed from: J */
    public synchronized C13660i m82092J(int i10) {
        C13660i c13660iRemove;
        c13660iRemove = this.f61413c.remove(Integer.valueOf(i10));
        notifyAll();
        return c13660iRemove;
    }

    /* renamed from: V */
    public void m82093V() {
        synchronized (this) {
            try {
                long j10 = this.f61424n;
                long j11 = this.f61423m;
                if (j10 < j11) {
                    return;
                }
                this.f61423m = j11 + 1;
                this.f61427q = System.nanoTime() + 1000000000;
                try {
                    this.f61418h.execute(new c("OkHttp %s ping", this.f61414d));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: X */
    public void m82094X(EnumC13653b enumC13653b) throws IOException {
        synchronized (this.f61433w) {
            synchronized (this) {
                if (this.f61417g) {
                    return;
                }
                this.f61417g = true;
                this.f61433w.m82175w(this.f61415e, enumC13653b, C12875e.f58640a);
            }
        }
    }

    /* renamed from: Y */
    public void m82095Y() throws IOException {
        m82096Z(true);
    }

    /* renamed from: Z */
    public void m82096Z(boolean z10) throws IOException {
        if (z10) {
            this.f61433w.m82171s();
            this.f61433w.m82167C(this.f61430t);
            if (this.f61430t.m82192d() != 65535) {
                this.f61433w.m82168D(0, r5 - 65535);
            }
        }
        new Thread(this.f61434x).start();
    }

    /* renamed from: a0 */
    public synchronized void m82097a0(long j10) {
        long j11 = this.f61428r + j10;
        this.f61428r = j11;
        if (j11 >= this.f61430t.m82192d() / 2) {
            m82103m0(0, this.f61428r);
            this.f61428r = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f61433w.m82177y());
        r6 = r2;
        r8.f61429s -= r6;
     */
    /* renamed from: b0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m82098b0(int r9, boolean r10, p022ay.C1054d r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            wx.j r8 = r8.f61433w
            r8.m82172t(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.f61429s     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map<java.lang.Integer, wx.i> r2 = r8.f61413c     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            wx.j r4 = r8.f61433w     // Catch: java.lang.Throwable -> L28
            int r4 = r4.m82177y()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f61429s     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f61429s = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            wx.j r4 = r8.f61433w
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.m82172t(r5, r9, r11, r2)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p755wx.C13657f.m82098b0(int, boolean, ay.d, long):void");
    }

    /* renamed from: c0 */
    public void m82099c0(int i10, boolean z10, List<C13654c> list) throws IOException {
        this.f61433w.m82176x(z10, i10, list);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m82104w(EnumC13653b.NO_ERROR, EnumC13653b.CANCEL, null);
    }

    public void flush() throws IOException {
        this.f61433w.flush();
    }

    /* renamed from: g0 */
    public void m82100g0(boolean z10, int i10, int i11) throws IOException {
        try {
            this.f61433w.m82178z(z10, i10, i11);
        } catch (IOException e10) {
            m82105x(e10);
        }
    }

    /* renamed from: i0 */
    public void m82101i0(int i10, EnumC13653b enumC13653b) throws IOException {
        this.f61433w.m82166B(i10, enumC13653b);
    }

    /* renamed from: j0 */
    public void m82102j0(int i10, EnumC13653b enumC13653b) {
        try {
            this.f61418h.execute(new a("OkHttp %s stream %d", new Object[]{this.f61414d, Integer.valueOf(i10)}, i10, enumC13653b));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: m0 */
    public void m82103m0(int i10, long j10) {
        try {
            this.f61418h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f61414d, Integer.valueOf(i10)}, i10, j10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: w */
    public void m82104w(EnumC13653b enumC13653b, EnumC13653b enumC13653b2, IOException iOException) throws IOException {
        C13660i[] c13660iArr;
        try {
            m82094X(enumC13653b);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f61413c.isEmpty()) {
                    c13660iArr = null;
                } else {
                    c13660iArr = (C13660i[]) this.f61413c.values().toArray(new C13660i[this.f61413c.size()]);
                    this.f61413c.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c13660iArr != null) {
            for (C13660i c13660i : c13660iArr) {
                try {
                    c13660i.m82144d(enumC13653b2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f61433w.close();
        } catch (IOException unused3) {
        }
        try {
            this.f61432v.close();
        } catch (IOException unused4) {
        }
        this.f61418h.shutdown();
        this.f61419i.shutdown();
    }

    /* renamed from: x */
    public final void m82105x(IOException iOException) throws IOException {
        EnumC13653b enumC13653b = EnumC13653b.PROTOCOL_ERROR;
        m82104w(enumC13653b, enumC13653b, iOException);
    }

    /* renamed from: y */
    public synchronized C13660i m82106y(int i10) {
        return this.f61413c.get(Integer.valueOf(i10));
    }

    /* renamed from: z */
    public synchronized boolean m82107z(long j10) {
        if (this.f61417g) {
            return false;
        }
        if (this.f61424n < this.f61423m) {
            if (j10 >= this.f61427q) {
                return false;
            }
        }
        return true;
    }
}
