package com.huawei.android.hicloud.album.service.logic.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.request.response.LockAndVersionResponse;
import com.huawei.android.hicloud.album.service.p075vo.Stat;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p009a8.C0070h;
import p009a8.C0075m;
import p015ak.C0213f;
import p015ak.C0219i;
import p031b7.C1120a;
import p031b7.C1136q;
import p032b8.C1143a;
import p032b8.C1144b;
import p032b8.C1145c;
import p572qb.C12297a;
import p635s7.C12761z;

/* loaded from: classes2.dex */
public class SyncSessionManager {

    /* renamed from: A */
    public boolean f11560A;

    /* renamed from: a */
    public final Map<String, C2432c> f11561a;

    /* renamed from: b */
    public final Map<String, C0075m> f11562b;

    /* renamed from: c */
    public final LruCache<String, Integer> f11563c;

    /* renamed from: d */
    public final LruCache<String, Integer> f11564d;

    /* renamed from: e */
    public final LruCache<String, Integer> f11565e;

    /* renamed from: f */
    public final LruCache<String, Integer> f11566f;

    /* renamed from: g */
    public final LruCache<String, Integer> f11567g;

    /* renamed from: h */
    public String f11568h;

    /* renamed from: i */
    public String f11569i;

    /* renamed from: j */
    public String f11570j;

    /* renamed from: k */
    public Stat f11571k;

    /* renamed from: l */
    public String f11572l;

    /* renamed from: m */
    public HashMap<String, String> f11573m;

    /* renamed from: n */
    public Map<String, Long> f11574n;

    /* renamed from: o */
    public Map<String, Map<String, Long>> f11575o;

    /* renamed from: p */
    public int f11576p;

    /* renamed from: q */
    public final ReadWriteLock f11577q;

    /* renamed from: r */
    public final ReentrantLock f11578r;

    /* renamed from: s */
    public long f11579s;

    /* renamed from: t */
    public long f11580t;

    /* renamed from: u */
    public int f11581u;

    /* renamed from: v */
    public boolean f11582v;

    /* renamed from: w */
    public long f11583w;

    /* renamed from: x */
    public boolean f11584x;

    /* renamed from: y */
    public int f11585y;

    /* renamed from: z */
    public boolean f11586z;

    public interface ErrorType {
    }

    public interface ReportType {
    }

    public interface UpType {
    }

    /* renamed from: com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager$b */
    public static class C2431b {

        /* renamed from: a */
        public static final SyncSessionManager f11587a = new SyncSessionManager();
    }

    /* renamed from: com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager$c */
    public static class C2432c {

        /* renamed from: a */
        public int f11588a = 1;

        /* renamed from: b */
        public long f11589b;

        /* renamed from: c */
        public long f11590c;

        public C2432c() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f11589b = jCurrentTimeMillis;
            this.f11590c = jCurrentTimeMillis;
        }

        /* renamed from: b */
        public void m15204b() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f11589b > 1800000) {
                this.f11589b = jCurrentTimeMillis;
                this.f11588a = 0;
            }
        }

        /* renamed from: c */
        public int m15205c() {
            return this.f11588a;
        }

        /* renamed from: d */
        public final void m15206d() {
            this.f11588a++;
            this.f11590c = System.currentTimeMillis();
        }
    }

    public /* synthetic */ SyncSessionManager(C2430a c2430a) {
        this();
    }

    /* renamed from: t */
    public static SyncSessionManager m15153t() {
        return C2431b.f11587a;
    }

    /* renamed from: A */
    public int m15154A() {
        return this.f11585y;
    }

    /* renamed from: B */
    public synchronized boolean m15155B(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            String str4 = str + "_" + str2 + "_" + str3;
            if (!this.f11561a.containsKey(str4)) {
                return false;
            }
            C2432c c2432c = this.f11561a.get(str4);
            if (c2432c != null) {
                c2432c.m15204b();
                if (c2432c.m15205c() > 10) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: C */
    public boolean m15156C() {
        return this.f11584x;
    }

    /* renamed from: D */
    public synchronized boolean m15157D(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            String str4 = str + "_" + str2 + "_" + str3;
            if (!this.f11561a.containsKey(str4)) {
                return false;
            }
            C2432c c2432c = this.f11561a.get(str4);
            if (c2432c != null) {
                c2432c.m15204b();
                if (c2432c.m15205c() >= 1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: E */
    public boolean m15158E() {
        return this.f11585y == 45;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0036  */
    /* renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m15159F() {
        /*
            r5 = this;
            java.util.concurrent.locks.ReadWriteLock r0 = r5.f11577q
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.lock()
            int r0 = r5.f11581u     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            android.content.Context r0 = p015ak.C0213f.m1377a()     // Catch: java.lang.Throwable -> L18
            int r0 = p031b7.C1136q.b.m6989A(r0)     // Catch: java.lang.Throwable -> L18
            r5.f11581u = r0     // Catch: java.lang.Throwable -> L18
            goto L1a
        L18:
            r0 = move-exception
            goto L41
        L1a:
            boolean r0 = r5.f11582v     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L36
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L18
            long r2 = r5.f11580t     // Catch: java.lang.Throwable -> L18
            long r0 = r0 - r2
            float r0 = (float) r0     // Catch: java.lang.Throwable -> L18
            int r1 = r5.f11581u     // Catch: java.lang.Throwable -> L18
            long r1 = (long) r1
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            float r1 = (float) r1
            r2 = 1069547520(0x3fc00000, float:1.5)
            float r1 = r1 * r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L36
            r0 = 1
            goto L37
        L36:
            r0 = 0
        L37:
            java.util.concurrent.locks.ReadWriteLock r5 = r5.f11577q
            java.util.concurrent.locks.Lock r5 = r5.readLock()
            r5.unlock()
            return r0
        L41:
            java.util.concurrent.locks.ReadWriteLock r5 = r5.f11577q
            java.util.concurrent.locks.Lock r5 = r5.readLock()
            r5.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager.m15159F():boolean");
    }

    /* renamed from: G */
    public boolean m15160G(String str) {
        int i10;
        C1120a.m6677i("SyncSessionManager", "isMsgError isSendMessageDelayed sessionId: " + str + ", currentSessionID: " + m15201z() + ", currentMsgExceptionCount: " + this.f11576p);
        if (TextUtils.isEmpty(str)) {
            C1120a.m6678w("SyncSessionManager", "isSendMessageDelayed sessionId is empty");
            return false;
        }
        if (!str.equals(m15201z()) || (i10 = this.f11576p) > 3) {
            return false;
        }
        this.f11576p = i10 + 1;
        return true;
    }

    /* renamed from: H */
    public boolean m15161H() {
        return this.f11560A;
    }

    /* renamed from: I */
    public boolean m15162I() {
        return !TextUtils.isEmpty(m15153t().m15201z());
    }

    /* renamed from: J */
    public boolean m15163J() {
        return this.f11586z;
    }

    /* renamed from: K */
    public synchronized void m15164K(int i10) {
        C1120a.m6675d("SyncSessionManager", "keepBusinessAlive");
        m15182f(i10);
        this.f11583w = System.currentTimeMillis();
    }

    /* renamed from: L */
    public final void m15165L(CallbackHandler callbackHandler) throws Exception {
        C1120a.m6675d("SyncSessionManager", "start request lockToken");
        LockAndVersionResponse lockAndVersionResponseM80113o = new C12761z(C0213f.m1377a(), m15153t().m15201z()).m80113o(LockAndVersionResponse.class);
        int code = lockAndVersionResponseM80113o.getCode();
        if (code == 0) {
            m15170Q(lockAndVersionResponseM80113o.getSyncLockToken(), true);
            this.f11581u = lockAndVersionResponseM80113o.getInterval();
            C1136q.b.m7010K0(C0213f.m1377a(), lockAndVersionResponseM80113o.getInterval());
        } else if (code != 34) {
            this.f11579s = System.currentTimeMillis();
            C1120a.m6676e("SyncSessionManager", "get lockToken error");
        } else {
            this.f11579s = System.currentTimeMillis();
            callbackHandler.sendMessage(9103, new Bundle());
            C1120a.m6676e("SyncSessionManager", "get lockToken return 34");
        }
    }

    /* renamed from: M */
    public void m15166M(String str, Integer num, int i10) {
        LruCache<String, Integer> lruCacheM15191o = m15191o(i10);
        if (lruCacheM15191o != null && num != null) {
            lruCacheM15191o.put(str, num);
            return;
        }
        C1120a.m6676e("SyncSessionManager", "setCacheUpCount upType invalid: " + i10 + ", value: " + num);
    }

    /* renamed from: N */
    public void m15167N(String str) {
        this.f11570j = str;
    }

    /* renamed from: O */
    public synchronized void m15168O(Stat stat) {
        this.f11571k = stat;
    }

    /* renamed from: P */
    public void m15169P(boolean z10) {
        this.f11584x = z10;
    }

    /* renamed from: Q */
    public boolean m15170Q(String str, boolean z10) {
        C1120a.m6677i("SyncSessionManager", "setLockToken: " + str + " Valid: " + z10);
        this.f11577q.writeLock().lock();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (z10) {
                    this.f11569i = str;
                    this.f11582v = true;
                    this.f11580t = System.currentTimeMillis();
                } else if (str.equals(this.f11569i)) {
                    this.f11569i = "";
                    this.f11582v = false;
                } else {
                    C1120a.m6677i("SyncSessionManager", "invalid lockToken is not equals to currentLockToken");
                }
                this.f11577q.writeLock().unlock();
                return true;
            }
            this.f11577q.writeLock().unlock();
            return false;
        } catch (Throwable th2) {
            this.f11577q.writeLock().unlock();
            throw th2;
        }
    }

    /* renamed from: R */
    public void m15171R(String str) {
        this.f11572l = str;
    }

    /* renamed from: S */
    public synchronized void m15172S(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11562b.clear();
        this.f11562b.put(str, new C0075m());
        this.f11568h = str;
        this.f11571k = null;
    }

    /* renamed from: T */
    public void m15173T(boolean z10) {
        C1120a.m6677i("SyncSessionManager", "setSpaceFull: " + z10);
        this.f11560A = z10;
    }

    /* renamed from: U */
    public void m15174U(int i10) {
        this.f11585y = i10;
    }

    /* renamed from: V */
    public void m15175V(boolean z10) {
        C1120a.m6677i("SyncSessionManager", "setVFCExecuted: " + z10);
        this.f11586z = z10;
    }

    /* renamed from: W */
    public void m15176W() {
        C1120a.m6677i("SyncSessionManager", "updateLockTokenTime");
        this.f11580t = System.currentTimeMillis();
    }

    /* renamed from: a */
    public synchronized void m15177a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String str4 = str + "_" + str2 + "_" + str3;
                C1120a.m6676e("SyncSessionManager", "addFail: " + str4);
                if (this.f11561a.size() > 1000) {
                    this.f11561a.clear();
                }
                if (this.f11561a.containsKey(str4)) {
                    this.f11561a.get(str4).m15206d();
                } else {
                    this.f11561a.put(str4, new C2432c());
                }
            }
        } finally {
        }
    }

    /* renamed from: b */
    public synchronized void m15178b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f11562b.containsKey(str)) {
            this.f11562b.get(str).m617c(str2);
        }
    }

    /* renamed from: c */
    public synchronized void m15179c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f11562b.containsKey(str)) {
            this.f11562b.get(str).m618d(str2);
        }
    }

    /* renamed from: d */
    public final void m15180d() {
        C12297a.m73908c().m73909a("user-download_apply", new C1144b());
    }

    /* renamed from: e */
    public final void m15181e() {
        if (C0070h.m527v().m539L()) {
            C1143a c1143a = new C1143a();
            C12297a.m73908c().m73915h("user-sync_apply");
            C12297a.m73908c().m73909a("auto-album-sync_apply", c1143a);
        } else {
            C1145c c1145c = new C1145c();
            C12297a.m73908c().m73915h("auto-album-sync_apply");
            C12297a.m73908c().m73909a("user-sync_apply", c1145c);
        }
    }

    /* renamed from: f */
    public final void m15182f(int i10) {
        String str;
        if (i10 == 1 || i10 == 3) {
            str = C0070h.m527v().m539L() ? "auto-album-sync_apply" : "user-sync_apply";
        } else if (i10 != 2) {
            return;
        } else {
            str = "user-download_apply";
        }
        if ((System.currentTimeMillis() - m15196u() > 600000 || C12297a.m73908c().m73913f(str)) && C0219i.f814b) {
            if (i10 == 1) {
                m15181e();
                return;
            }
            if (i10 == 2) {
                m15180d();
                return;
            }
            if (i10 != 3) {
                return;
            }
            if (DownloadPhotoBase.m14411f()) {
                m15180d();
            }
            if (m15162I()) {
                m15181e();
            }
        }
    }

    /* renamed from: g */
    public synchronized void m15183g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11562b.remove(str);
        if (str.equals(this.f11568h)) {
            this.f11568h = "";
            this.f11576p = 0;
        }
    }

    /* renamed from: h */
    public synchronized void m15184h() {
        this.f11568h = "";
        this.f11576p = 0;
        this.f11571k = null;
        m15186j();
        m15185i();
        this.f11562b.clear();
        this.f11561a.clear();
        m15187k();
        this.f11584x = false;
    }

    /* renamed from: i */
    public synchronized void m15185i() {
        this.f11563c.evictAll();
        this.f11564d.evictAll();
        this.f11565e.evictAll();
        this.f11566f.evictAll();
    }

    /* renamed from: j */
    public synchronized void m15186j() {
        this.f11567g.evictAll();
    }

    /* renamed from: k */
    public void m15187k() {
        m15170Q(m15192p(), false);
    }

    /* renamed from: l */
    public HashMap<String, String> m15188l() {
        return this.f11573m;
    }

    /* renamed from: m */
    public Map<String, Map<String, Long>> m15189m() {
        return this.f11575o;
    }

    /* renamed from: n */
    public Map<String, Long> m15190n() {
        return this.f11574n;
    }

    /* renamed from: o */
    public final LruCache<String, Integer> m15191o(int i10) {
        if (i10 == 1) {
            return this.f11563c;
        }
        if (i10 == 2) {
            return this.f11564d;
        }
        if (i10 == 3) {
            return this.f11565e;
        }
        if (i10 == 4) {
            return this.f11566f;
        }
        if (i10 != 5) {
            return null;
        }
        return this.f11567g;
    }

    /* renamed from: p */
    public String m15192p() {
        return this.f11569i;
    }

    /* renamed from: q */
    public Integer m15193q(String str, int i10) {
        LruCache<String, Integer> lruCacheM15191o = m15191o(i10);
        if (lruCacheM15191o != null) {
            return lruCacheM15191o.get(str);
        }
        C1120a.m6676e("SyncSessionManager", "getCacheUpCount upType invalid: " + i10);
        return null;
    }

    /* renamed from: r */
    public String m15194r() {
        return this.f11570j;
    }

    /* renamed from: s */
    public synchronized Stat m15195s() {
        return this.f11571k;
    }

    /* renamed from: u */
    public synchronized long m15196u() {
        C1120a.m6675d("SyncSessionManager", "getKeepBusinessAlive:" + this.f11583w);
        return this.f11583w;
    }

    /* renamed from: v */
    public String m15197v(CallbackHandler callbackHandler) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f11579s;
        if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < 60000) {
            return this.f11569i;
        }
        if (m15159F()) {
            C1120a.m6675d("SyncSessionManager", "get lockToken old");
        } else {
            this.f11578r.lock();
            try {
                try {
                    if (!m15159F()) {
                        m15165L(callbackHandler);
                    }
                } catch (Exception e10) {
                    C1120a.m6676e("SyncSessionManager", "get lockToken exception:" + e10.toString());
                }
            } finally {
                this.f11578r.unlock();
            }
        }
        return this.f11569i;
    }

    /* renamed from: w */
    public synchronized String m15198w(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!this.f11562b.containsKey(str)) {
            return "";
        }
        return this.f11562b.get(str).m615a();
    }

    /* renamed from: x */
    public String m15199x() {
        return this.f11572l;
    }

    /* renamed from: y */
    public synchronized String m15200y(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!this.f11562b.containsKey(str)) {
            return "";
        }
        return this.f11562b.get(str).m616b();
    }

    /* renamed from: z */
    public synchronized String m15201z() {
        return this.f11568h;
    }

    public SyncSessionManager() {
        this.f11561a = new HashMap();
        this.f11562b = new HashMap();
        this.f11563c = new LruCache<>(500);
        this.f11564d = new LruCache<>(500);
        this.f11565e = new LruCache<>(500);
        this.f11566f = new LruCache<>(500);
        this.f11567g = new LruCache<>(1000);
        this.f11573m = new HashMap<>();
        this.f11574n = new ConcurrentHashMap();
        this.f11575o = new ConcurrentHashMap();
        this.f11576p = 0;
        this.f11577q = new ReentrantReadWriteLock();
        this.f11578r = new ReentrantLock();
        this.f11580t = 0L;
        this.f11581u = 0;
        this.f11582v = false;
        this.f11583w = 0L;
        this.f11584x = false;
        this.f11560A = false;
    }
}
