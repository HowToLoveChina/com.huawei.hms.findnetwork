package com.huawei.android.p069cg.request.threadpool;

import android.text.TextUtils;
import ck.C1444b;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p031b7.C1120a;

/* renamed from: com.huawei.android.cg.request.threadpool.m */
/* loaded from: classes2.dex */
public class C2332m {

    /* renamed from: p0 */
    public static C2332m f11062p0;

    /* renamed from: a0 */
    public volatile ExecutorService f11090a0;

    /* renamed from: c0 */
    public Vector<AbstractC2329j> f11094c0;

    /* renamed from: a */
    public ExecutorService f11089a = null;

    /* renamed from: b */
    public ExecutorService f11091b = null;

    /* renamed from: c */
    public Vector<Map<String, Object>> f11093c = null;

    /* renamed from: d */
    public Vector<Map<String, Object>> f11095d = null;

    /* renamed from: e */
    public ExecutorService f11097e = null;

    /* renamed from: f */
    public ExecutorService f11099f = null;

    /* renamed from: g */
    public Vector<Map<String, Object>> f11101g = null;

    /* renamed from: h */
    public Vector<Map<String, Object>> f11103h = null;

    /* renamed from: i */
    public ExecutorService f11105i = null;

    /* renamed from: j */
    public ExecutorService f11107j = null;

    /* renamed from: k */
    public Vector<Map<String, Object>> f11109k = null;

    /* renamed from: l */
    public Vector<Map<String, Object>> f11111l = null;

    /* renamed from: m */
    public ExecutorService f11113m = null;

    /* renamed from: n */
    public ExecutorService f11115n = null;

    /* renamed from: o */
    public Vector<Map<String, Object>> f11117o = null;

    /* renamed from: p */
    public Vector<Map<String, Object>> f11119p = null;

    /* renamed from: q */
    public ExecutorService f11120q = null;

    /* renamed from: r */
    public ExecutorService f11121r = null;

    /* renamed from: s */
    public Vector<Map<String, Object>> f11122s = null;

    /* renamed from: t */
    public Vector<Map<String, Object>> f11123t = null;

    /* renamed from: u */
    public ExecutorService f11124u = null;

    /* renamed from: v */
    public ExecutorService f11125v = null;

    /* renamed from: w */
    public Vector<Map<String, Object>> f11126w = null;

    /* renamed from: x */
    public Vector<Map<String, Object>> f11127x = null;

    /* renamed from: y */
    public ExecutorService f11128y = null;

    /* renamed from: z */
    public ExecutorService f11129z = null;

    /* renamed from: A */
    public Vector<Map<String, Object>> f11063A = null;

    /* renamed from: B */
    public Vector<Map<String, Object>> f11064B = null;

    /* renamed from: C */
    public ExecutorService f11065C = null;

    /* renamed from: D */
    public ExecutorService f11066D = null;

    /* renamed from: E */
    public Vector<Map<String, Object>> f11067E = null;

    /* renamed from: F */
    public Vector<Map<String, Object>> f11068F = null;

    /* renamed from: G */
    public ExecutorService f11069G = null;

    /* renamed from: H */
    public ExecutorService f11070H = null;

    /* renamed from: I */
    public Vector<Map<String, Object>> f11071I = null;

    /* renamed from: J */
    public Vector<Map<String, Object>> f11072J = null;

    /* renamed from: K */
    public ExecutorService f11073K = null;

    /* renamed from: L */
    public ExecutorService f11074L = null;

    /* renamed from: M */
    public Vector<Map<String, Object>> f11075M = null;

    /* renamed from: N */
    public Vector<Map<String, Object>> f11076N = null;

    /* renamed from: O */
    public ExecutorService f11077O = null;

    /* renamed from: P */
    public ExecutorService f11078P = null;

    /* renamed from: Q */
    public Vector<Map<String, Object>> f11079Q = null;

    /* renamed from: R */
    public Vector<Map<String, Object>> f11080R = null;

    /* renamed from: S */
    public ExecutorService f11081S = null;

    /* renamed from: T */
    public ExecutorService f11082T = null;

    /* renamed from: U */
    public Vector<Map<String, Object>> f11083U = null;

    /* renamed from: V */
    public Vector<Map<String, Object>> f11084V = null;

    /* renamed from: W */
    public ExecutorService f11085W = null;

    /* renamed from: X */
    public ExecutorService f11086X = null;

    /* renamed from: Y */
    public Vector<Map<String, Object>> f11087Y = null;

    /* renamed from: Z */
    public Vector<Map<String, Object>> f11088Z = null;

    /* renamed from: b0 */
    public boolean f11092b0 = false;

    /* renamed from: d0 */
    public ExecutorService f11096d0 = null;

    /* renamed from: e0 */
    public ExecutorService f11098e0 = null;

    /* renamed from: f0 */
    public Vector<Map<String, Object>> f11100f0 = null;

    /* renamed from: g0 */
    public Vector<Map<String, Object>> f11102g0 = null;

    /* renamed from: h0 */
    public ExecutorService f11104h0 = null;

    /* renamed from: i0 */
    public ExecutorService f11106i0 = null;

    /* renamed from: j0 */
    public Vector<Map<String, Object>> f11108j0 = null;

    /* renamed from: k0 */
    public Vector<Map<String, Object>> f11110k0 = null;

    /* renamed from: l0 */
    public ExecutorService f11112l0 = null;

    /* renamed from: m0 */
    public ExecutorService f11114m0 = null;

    /* renamed from: n0 */
    public Vector<Map<String, Object>> f11116n0 = null;

    /* renamed from: o0 */
    public Vector<Map<String, Object>> f11118o0 = null;

    /* renamed from: com.huawei.android.cg.request.threadpool.m$a */
    public class a implements Comparator<Map<String, Object>> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map<String, Object> map, Map<String, Object> map2) {
            Object obj = map.get("FIXED_HANDLECALLABLE_TIME_STAMP_KEY");
            long jLongValue = obj != null ? ((Long) obj).longValue() : 0L;
            Object obj2 = map2.get("FIXED_HANDLECALLABLE_TIME_STAMP_KEY");
            return (int) ((obj2 != null ? ((Long) obj2).longValue() : 0L) - jLongValue);
        }
    }

    public C2332m() {
        this.f11090a0 = null;
        this.f11094c0 = null;
        this.f11094c0 = new Vector<>();
        this.f11090a0 = Executors.newSingleThreadExecutor();
        synchronized (this) {
            m14639e();
            m14641f();
            m14642g();
            m14643h();
            m14644i();
            m14645j();
            m14646k();
            m14647l();
        }
    }

    /* renamed from: B */
    public static int m14604B() {
        if (CloudAlbumSettings.m14363h().m14376l() || CloudAlbumSettings.m14363h().m14378n()) {
            return C1444b.m8294C();
        }
        return 6;
    }

    /* renamed from: a */
    public static void m14605a(Vector<Map<String, Object>> vector, int i10, boolean z10, boolean z11) {
        Iterator<Map<String, Object>> it;
        if (vector != null) {
            synchronized (vector) {
                try {
                    it = vector.iterator();
                } catch (Exception e10) {
                    C1120a.m6676e("ThreadPoolDownManager", "clearCallableList err: " + e10.toString());
                } finally {
                }
                while (it.hasNext()) {
                    Map<String, Object> next = it.next();
                    AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) next.get("FIXED_BASECALLABLE_KEY");
                    AbstractC2324e abstractC2324e = (AbstractC2324e) next.get("FIXED_HANDLECALLABLE_KEY");
                    if (abstractCallableC2320a != null) {
                        if (((FileInfo) abstractCallableC2320a.getCallParam()) != null) {
                            if ((!TextUtils.isEmpty(r3.getShareId())) != z10) {
                            }
                        } else if (!z10) {
                            return;
                        }
                        abstractCallableC2320a.cancel(i10);
                        if (abstractC2324e != null) {
                            HashMap map = new HashMap();
                            map.put("code", "1");
                            map.put("DownloadFailReason", Integer.valueOf(i10));
                            map.put("NeedCallback", Boolean.valueOf(z11));
                            abstractC2324e.handle(map);
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static Comparator<Map<String, Object>> m14606c() {
        return new a();
    }

    /* renamed from: d */
    public static synchronized void m14607d() {
        if (f11062p0 == null) {
            f11062p0 = new C2332m();
        }
    }

    /* renamed from: s */
    public static C2332m m14608s() {
        if (f11062p0 == null) {
            m14607d();
        }
        return f11062p0;
    }

    /* renamed from: A */
    public synchronized Vector<Map<String, Object>> m14609A() {
        return this.f11100f0;
    }

    /* renamed from: C */
    public synchronized Vector<Map<String, Object>> m14610C() {
        return this.f11111l;
    }

    /* renamed from: D */
    public synchronized Vector<Map<String, Object>> m14611D() {
        return this.f11109k;
    }

    /* renamed from: E */
    public final boolean m14612E(ExecutorService executorService, ExecutorService executorService2, int i10) {
        return (executorService == null || executorService.isShutdown() || executorService2 == null || executorService2.isShutdown()) && (i10 == 0 || i10 == 2);
    }

    /* renamed from: F */
    public final synchronized void m14613F(ExecutorService executorService) {
        try {
            executorService.shutdownNow();
        } catch (Exception e10) {
            C1120a.m6676e("ThreadPoolDownManager", "poolShutdownNow exception: " + e10.toString());
        }
    }

    /* renamed from: G */
    public synchronized void m14614G() {
        Collections.sort(this.f11093c, m14606c());
    }

    /* renamed from: H */
    public synchronized void m14615H() {
        Collections.sort(this.f11101g, m14606c());
    }

    /* renamed from: I */
    public synchronized void m14616I(int i10) {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            C1120a.m6675d("ThreadPoolDownManager", "start begin: " + jCurrentTimeMillis);
            if (this.f11092b0 && (i10 == 0 || i10 == 1)) {
                if (this.f11090a0.isShutdown()) {
                    this.f11090a0 = Executors.newSingleThreadExecutor();
                }
                this.f11094c0.clear();
                this.f11092b0 = false;
            }
            synchronized (this) {
                m14617J(i10);
                m14618K(i10);
                m14619L(i10);
                m14620M(i10);
                m14621N(i10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        C1120a.m6675d("ThreadPoolDownManager", "start end: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: J */
    public final void m14617J(int i10) {
        if ((this.f11089a.isShutdown() || this.f11091b.isShutdown()) && (i10 == 0 || i10 == 2)) {
            this.f11089a = Executors.newFixedThreadPool(1);
            this.f11091b = Executors.newFixedThreadPool(1);
        }
        if (this.f11097e.isShutdown() || this.f11099f.isShutdown()) {
            if (i10 == 0 || i10 == 2) {
                this.f11097e = Executors.newFixedThreadPool(m14604B());
                this.f11099f = Executors.newFixedThreadPool(m14604B());
            }
        }
    }

    /* renamed from: K */
    public final void m14618K(int i10) {
        if ((this.f11105i.isShutdown() || this.f11107j.isShutdown()) && (i10 == 0 || i10 == 2)) {
            this.f11105i = Executors.newFixedThreadPool(C1444b.m8296b());
            this.f11107j = Executors.newFixedThreadPool(C1444b.m8296b());
        }
        if ((this.f11113m.isShutdown() || this.f11115n.isShutdown()) && (i10 == 0 || i10 == 2)) {
            this.f11113m = Executors.newFixedThreadPool(C1444b.m8295a());
            this.f11115n = Executors.newFixedThreadPool(C1444b.m8295a());
        }
        if (this.f11120q.isShutdown() || this.f11121r.isShutdown()) {
            if (i10 == 0 || i10 == 2) {
                this.f11120q = Executors.newFixedThreadPool(1);
                this.f11121r = Executors.newFixedThreadPool(1);
            }
        }
    }

    /* renamed from: L */
    public final void m14619L(int i10) {
        if ((this.f11124u.isShutdown() || this.f11125v.isShutdown()) && (i10 == 0 || i10 == 2)) {
            this.f11124u = Executors.newFixedThreadPool(1);
            this.f11125v = Executors.newFixedThreadPool(1);
        }
        if (this.f11128y.isShutdown() || this.f11129z.isShutdown()) {
            if (i10 == 0 || i10 == 2) {
                this.f11128y = Executors.newFixedThreadPool(1);
                this.f11129z = Executors.newFixedThreadPool(1);
            }
        }
    }

    /* renamed from: M */
    public final void m14620M(int i10) {
        if (m14612E(this.f11069G, this.f11070H, i10)) {
            this.f11069G = Executors.newFixedThreadPool(1);
            this.f11070H = Executors.newFixedThreadPool(1);
        }
        if (m14612E(this.f11073K, this.f11074L, i10)) {
            this.f11073K = Executors.newFixedThreadPool(1);
            this.f11074L = Executors.newFixedThreadPool(1);
        }
        if (m14612E(this.f11077O, this.f11078P, i10)) {
            this.f11077O = Executors.newFixedThreadPool(1);
            this.f11078P = Executors.newFixedThreadPool(1);
        }
        if (m14612E(this.f11081S, this.f11082T, i10)) {
            this.f11081S = Executors.newFixedThreadPool(1);
            this.f11082T = Executors.newFixedThreadPool(1);
        }
    }

    /* renamed from: N */
    public final void m14621N(int i10) {
        if ((this.f11065C.isShutdown() || this.f11066D.isShutdown()) && (i10 == 0 || i10 == 2)) {
            this.f11065C = Executors.newFixedThreadPool(1);
            this.f11066D = Executors.newFixedThreadPool(1);
        }
        if (this.f11085W.isShutdown() || this.f11086X.isShutdown()) {
            if (i10 == 0 || i10 == 2) {
                this.f11085W = Executors.newFixedThreadPool(6);
                this.f11086X = Executors.newFixedThreadPool(6);
            }
        }
    }

    /* renamed from: O */
    public synchronized void m14622O(int i10, int i11, boolean z10, boolean z11) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C1120a.m6675d("ThreadPoolDownManager", "stopNow begin: " + jCurrentTimeMillis);
            if (i10 == 0 || i10 == 2) {
                m14605a(this.f11093c, i11, z10, z11);
                m14605a(this.f11095d, i11, z10, z11);
                m14605a(this.f11101g, i11, z10, z11);
                m14605a(this.f11103h, i11, z10, z11);
                m14605a(this.f11117o, i11, z10, z11);
                m14605a(this.f11119p, i11, z10, z11);
                m14605a(this.f11063A, i11, z10, z11);
                m14605a(this.f11064B, i11, z10, z11);
                m14605a(this.f11071I, i11, z10, z11);
                m14605a(this.f11072J, i11, z10, z11);
                m14605a(this.f11075M, i11, z10, z11);
                m14605a(this.f11076N, i11, z10, z11);
                m14613F(this.f11089a);
                m14613F(this.f11091b);
                m14613F(this.f11097e);
                m14613F(this.f11099f);
                m14613F(this.f11113m);
                m14613F(this.f11115n);
                m14613F(this.f11128y);
                m14613F(this.f11129z);
                m14613F(this.f11069G);
                m14613F(this.f11070H);
                m14613F(this.f11073K);
                m14613F(this.f11074L);
            } else if (i10 == 3) {
                m14605a(this.f11093c, i11, z10, z11);
                m14605a(this.f11095d, i11, z10, z11);
                m14605a(this.f11101g, i11, z10, z11);
                m14605a(this.f11103h, i11, z10, z11);
                m14605a(this.f11063A, i11, z10, z11);
                m14605a(this.f11064B, i11, z10, z11);
                m14605a(this.f11071I, i11, z10, z11);
                m14605a(this.f11072J, i11, z10, z11);
                m14613F(this.f11089a);
                m14613F(this.f11091b);
                m14613F(this.f11097e);
                m14613F(this.f11099f);
                m14613F(this.f11128y);
                m14613F(this.f11129z);
                m14613F(this.f11069G);
                m14613F(this.f11070H);
            }
            m14635b(i10);
            C1120a.m6675d("ThreadPoolDownManager", "stopNow end: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: P */
    public synchronized boolean m14623P(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11128y, this.f11129z, this.f11063A, this.f11064B, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: Q */
    public synchronized boolean m14624Q(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11069G, this.f11070H, this.f11071I, this.f11072J, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: R */
    public synchronized boolean m14625R(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11073K, this.f11074L, this.f11075M, this.f11076N, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: S */
    public synchronized boolean m14626S(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11081S, this.f11082T, this.f11083U, this.f11084V, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: T */
    public synchronized boolean m14627T(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11085W, this.f11086X, this.f11087Y, this.f11088Z, abstractCallableC2320a, abstractC2324e, z10, true);
    }

    /* renamed from: U */
    public synchronized boolean m14628U(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11065C, this.f11066D, this.f11067E, this.f11068F, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: V */
    public synchronized boolean m14629V(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11113m, this.f11115n, this.f11117o, this.f11119p, abstractCallableC2320a, abstractC2324e, z10, true);
    }

    /* renamed from: W */
    public synchronized boolean m14630W(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11105i, this.f11107j, this.f11109k, this.f11111l, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: X */
    public synchronized boolean m14631X(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11104h0, this.f11106i0, this.f11108j0, this.f11110k0, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: Y */
    public synchronized boolean m14632Y(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11112l0, this.f11114m0, this.f11116n0, this.f11118o0, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: Z */
    public synchronized boolean m14633Z(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11089a, this.f11091b, this.f11093c, this.f11095d, abstractCallableC2320a, abstractC2324e, z10, true);
    }

    /* renamed from: a0 */
    public synchronized boolean m14634a0(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11097e, this.f11099f, this.f11101g, this.f11103h, abstractCallableC2320a, abstractC2324e, z10, true);
    }

    /* renamed from: b */
    public final void m14635b(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f11092b0 = true;
            m14613F(this.f11090a0);
            this.f11094c0.clear();
        }
    }

    /* renamed from: b0 */
    public synchronized boolean m14636b0(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10, long j10) {
        return m14638d0(this.f11097e, this.f11099f, this.f11101g, this.f11103h, abstractCallableC2320a, abstractC2324e, z10, j10, true);
    }

    /* renamed from: c0 */
    public synchronized boolean m14637c0(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        return m14640e0(this.f11096d0, this.f11098e0, this.f11100f0, this.f11102g0, abstractCallableC2320a, abstractC2324e, z10, false);
    }

    /* renamed from: d0 */
    public final synchronized boolean m14638d0(ExecutorService executorService, ExecutorService executorService2, Vector<Map<String, Object>> vector, Vector<Map<String, Object>> vector2, AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10, long j10, boolean z11) {
        try {
            if (!executorService.isShutdown() && !executorService2.isShutdown()) {
                abstractCallableC2320a.setThreadType(2);
                abstractCallableC2320a.setPriority(z10);
                abstractCallableC2320a.setFixedThreadPoolList(vector);
                abstractCallableC2320a.setFixedThreadPoolExecutedList(vector2);
                C2327h c2327h = new C2327h();
                c2327h.put("FIXED_BASECALLABLE_KEY", abstractCallableC2320a);
                c2327h.put("FIXED_HANDLECALLABLE_KEY", abstractC2324e);
                c2327h.put("FIXED_HANDLECALLABLE_TIME_STAMP_KEY", Long.valueOf(j10));
                if (z10) {
                    vector.add(0, c2327h);
                } else {
                    vector.add(c2327h);
                }
                if (z11) {
                    DownloadPhotoBase.m14406a(c2327h);
                }
                if (executorService2.submit(new CallableC2322c(executorService2, executorService, vector, vector2, 0L)) != null) {
                    return true;
                }
                C1120a.m6675d("ThreadPoolDownManager", "future fail");
                return false;
            }
            C1120a.m6676e("ThreadPoolDownManager", "threadpool is down");
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public final void m14639e() {
        if (this.f11089a == null) {
            this.f11089a = Executors.newFixedThreadPool(1);
        }
        if (this.f11091b == null) {
            this.f11091b = Executors.newFixedThreadPool(1);
        }
        if (this.f11093c == null) {
            this.f11093c = new Vector<>();
            this.f11095d = new Vector<>();
        }
        if (this.f11097e == null) {
            this.f11097e = Executors.newFixedThreadPool(m14604B());
        }
        if (this.f11099f == null) {
            this.f11099f = Executors.newFixedThreadPool(m14604B());
        }
        if (this.f11101g == null) {
            this.f11101g = new Vector<>();
            this.f11103h = new Vector<>();
        }
    }

    /* renamed from: e0 */
    public final synchronized boolean m14640e0(ExecutorService executorService, ExecutorService executorService2, Vector<Map<String, Object>> vector, Vector<Map<String, Object>> vector2, AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10, boolean z11) {
        return m14638d0(executorService, executorService2, vector, vector2, abstractCallableC2320a, abstractC2324e, z10, 0L, z11);
    }

    /* renamed from: f */
    public final void m14641f() {
        if (this.f11105i == null) {
            this.f11105i = Executors.newFixedThreadPool(C1444b.m8296b());
        }
        if (this.f11107j == null) {
            this.f11107j = Executors.newFixedThreadPool(C1444b.m8296b());
        }
        if (this.f11109k == null) {
            this.f11109k = new Vector<>();
            this.f11111l = new Vector<>();
        }
        if (this.f11113m == null) {
            this.f11113m = Executors.newFixedThreadPool(C1444b.m8295a());
        }
        if (this.f11115n == null) {
            this.f11115n = Executors.newFixedThreadPool(C1444b.m8295a());
        }
        if (this.f11117o == null) {
            this.f11117o = new Vector<>();
            this.f11119p = new Vector<>();
        }
        if (this.f11120q == null) {
            this.f11120q = Executors.newFixedThreadPool(1);
        }
        if (this.f11121r == null) {
            this.f11121r = Executors.newFixedThreadPool(1);
        }
        if (this.f11122s == null) {
            this.f11122s = new Vector<>();
            this.f11123t = new Vector<>();
        }
    }

    /* renamed from: g */
    public final void m14642g() {
        if (this.f11124u == null) {
            this.f11124u = Executors.newFixedThreadPool(1);
        }
        if (this.f11125v == null) {
            this.f11125v = Executors.newFixedThreadPool(1);
        }
        if (this.f11126w == null) {
            this.f11126w = new Vector<>();
            this.f11127x = new Vector<>();
        }
        if (this.f11128y == null) {
            this.f11128y = Executors.newFixedThreadPool(1);
        }
        if (this.f11129z == null) {
            this.f11129z = Executors.newFixedThreadPool(1);
        }
        if (this.f11063A == null) {
            this.f11063A = new Vector<>();
            this.f11064B = new Vector<>();
        }
        if (this.f11065C == null) {
            this.f11065C = Executors.newFixedThreadPool(1);
        }
        if (this.f11066D == null) {
            this.f11066D = Executors.newFixedThreadPool(1);
        }
        if (this.f11067E == null) {
            this.f11067E = new Vector<>();
            this.f11068F = new Vector<>();
        }
    }

    /* renamed from: h */
    public final void m14643h() {
        if (this.f11069G == null) {
            this.f11069G = Executors.newFixedThreadPool(1);
        }
        if (this.f11070H == null) {
            this.f11070H = Executors.newFixedThreadPool(1);
        }
        if (this.f11071I == null) {
            this.f11071I = new Vector<>();
            this.f11072J = new Vector<>();
        }
        if (this.f11073K == null) {
            this.f11073K = Executors.newFixedThreadPool(1);
        }
        if (this.f11074L == null) {
            this.f11074L = Executors.newFixedThreadPool(1);
        }
        if (this.f11075M == null) {
            this.f11075M = new Vector<>();
            this.f11076N = new Vector<>();
        }
        if (this.f11077O == null) {
            this.f11077O = Executors.newFixedThreadPool(1);
        }
        if (this.f11078P == null) {
            this.f11078P = Executors.newFixedThreadPool(1);
        }
        if (this.f11079Q == null) {
            this.f11079Q = new Vector<>();
            this.f11080R = new Vector<>();
        }
        if (this.f11081S == null) {
            this.f11081S = Executors.newFixedThreadPool(1);
        }
        if (this.f11082T == null) {
            this.f11082T = Executors.newFixedThreadPool(1);
        }
        if (this.f11083U == null) {
            this.f11083U = new Vector<>();
            this.f11084V = new Vector<>();
        }
    }

    /* renamed from: i */
    public final void m14644i() {
        if (this.f11085W == null) {
            this.f11085W = Executors.newFixedThreadPool(6);
        }
        if (this.f11086X == null) {
            this.f11086X = Executors.newFixedThreadPool(6);
        }
        if (this.f11087Y == null) {
            this.f11087Y = new Vector<>();
            this.f11088Z = new Vector<>();
        }
    }

    /* renamed from: j */
    public final void m14645j() {
        if (this.f11096d0 == null) {
            this.f11096d0 = Executors.newFixedThreadPool(C1444b.m8296b());
        }
        if (this.f11098e0 == null) {
            this.f11098e0 = Executors.newFixedThreadPool(C1444b.m8296b());
        }
        if (this.f11100f0 == null) {
            this.f11100f0 = new Vector<>();
            this.f11102g0 = new Vector<>();
        }
    }

    /* renamed from: k */
    public final void m14646k() {
        if (this.f11104h0 == null) {
            this.f11104h0 = Executors.newFixedThreadPool(C1444b.m8295a());
        }
        if (this.f11106i0 == null) {
            this.f11106i0 = Executors.newFixedThreadPool(C1444b.m8295a());
        }
        if (this.f11108j0 == null) {
            this.f11108j0 = new Vector<>();
            this.f11110k0 = new Vector<>();
        }
    }

    /* renamed from: l */
    public final void m14647l() {
        if (this.f11112l0 == null) {
            this.f11112l0 = Executors.newFixedThreadPool(1);
        }
        if (this.f11114m0 == null) {
            this.f11114m0 = Executors.newFixedThreadPool(1);
        }
        if (this.f11116n0 == null) {
            this.f11116n0 = new Vector<>();
            this.f11118o0 = new Vector<>();
        }
    }

    /* renamed from: m */
    public synchronized Vector<Map<String, Object>> m14648m() {
        return this.f11088Z;
    }

    /* renamed from: n */
    public synchronized Vector<Map<String, Object>> m14649n() {
        return this.f11087Y;
    }

    /* renamed from: o */
    public synchronized Vector<Map<String, Object>> m14650o() {
        return this.f11119p;
    }

    /* renamed from: p */
    public synchronized Vector<Map<String, Object>> m14651p() {
        return this.f11117o;
    }

    /* renamed from: q */
    public synchronized Vector<Map<String, Object>> m14652q() {
        return this.f11103h;
    }

    /* renamed from: r */
    public synchronized Vector<Map<String, Object>> m14653r() {
        return this.f11101g;
    }

    /* renamed from: t */
    public synchronized Vector<Map<String, Object>> m14654t() {
        return this.f11095d;
    }

    /* renamed from: u */
    public synchronized Vector<Map<String, Object>> m14655u() {
        return this.f11093c;
    }

    /* renamed from: v */
    public synchronized Vector<Map<String, Object>> m14656v() {
        return this.f11110k0;
    }

    /* renamed from: w */
    public synchronized Vector<Map<String, Object>> m14657w() {
        return this.f11108j0;
    }

    /* renamed from: x */
    public synchronized Vector<Map<String, Object>> m14658x() {
        return this.f11118o0;
    }

    /* renamed from: y */
    public synchronized Vector<Map<String, Object>> m14659y() {
        return this.f11116n0;
    }

    /* renamed from: z */
    public synchronized Vector<Map<String, Object>> m14660z() {
        return this.f11102g0;
    }
}
