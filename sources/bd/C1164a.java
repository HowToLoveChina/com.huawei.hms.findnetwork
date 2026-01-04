package bd;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.service.C5009e0;
import fk.C9722c;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p015ak.C0213f;
import p255ed.C9453i;
import p340hi.C10209a;
import p514o9.C11839m;
import p681uj.C13195l;
import p709vj.C13452e;

/* renamed from: bd.a */
/* loaded from: classes3.dex */
public class C1164a {

    /* renamed from: e */
    public static final Object f5464e = new Object();

    /* renamed from: f */
    public static final Object f5465f = new Object();

    /* renamed from: g */
    public static volatile Handler f5466g;

    /* renamed from: a */
    public C9453i.a f5467a;

    /* renamed from: b */
    public ReadWriteLock f5468b;

    /* renamed from: c */
    public long f5469c;

    /* renamed from: d */
    public volatile String f5470d;

    /* renamed from: bd.a$a */
    public class a implements C10209a.b {

        /* renamed from: a */
        public final /* synthetic */ String f5471a;

        public a(String str) {
            this.f5471a = str;
        }

        @Override // p340hi.C10209a.b
        /* renamed from: a */
        public String mo7274a() {
            C1164a c1164a = C1164a.this;
            return c1164a.m7272i(this.f5471a, c1164a.f5470d);
        }
    }

    /* renamed from: bd.a$b */
    public static class b {

        /* renamed from: a */
        public static C1164a f5473a = new C1164a(null);
    }

    public /* synthetic */ C1164a(a aVar) {
        this();
    }

    /* renamed from: f */
    public static C1164a m7265f() {
        return b.f5473a;
    }

    /* renamed from: b */
    public final boolean m7266b() {
        return System.currentTimeMillis() - this.f5469c > 60000;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c A[DONT_GENERATE, PHI: r0
  0x006c: PHI (r0v3 java.lang.String) = 
  (r0v1 java.lang.String)
  (r0v2 java.lang.String)
  (r0v4 java.lang.String)
  (r0v4 java.lang.String)
  (r0v4 java.lang.String)
 binds: [B:16:0x002e, B:17:0x0052, B:5:0x0014, B:7:0x001f, B:8:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m7267c(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            uj.l r1 = p681uj.C13195l.m79272J()     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            java.lang.String r2 = "com.huawei.hidisk.contact"
            java.lang.String r3 = "CloudSync"
            java.lang.String r0 = r1.m79290C(r2, r3, r5)     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            java.lang.String r5 = r4.f5470d     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            if (r5 != 0) goto L6c
            r4.f5470d = r0     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            java.lang.String r5 = "CloudSyncBuilderManager"
            java.lang.String r1 = "currentAccessToken has been updated."
            p514o9.C11839m.m70688i(r5, r1)     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            if (r6 == 0) goto L6c
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            r4.f5469c = r5     // Catch: java.lang.Throwable -> L28 p681uj.C13199p -> L2a p681uj.C13194k -> L2c
            goto L6c
        L28:
            r5 = move-exception
            goto L6e
        L2a:
            r5 = move-exception
            goto L2e
        L2c:
            r5 = move-exception
            goto L52
        L2e:
            java.lang.String r6 = "CloudSyncBuilderManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r1.<init>()     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "getAccessToken HmsSTInvalidException: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L28
            r1.append(r5)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L28
            p514o9.C11839m.m70687e(r6, r5)     // Catch: java.lang.Throwable -> L28
            uj.l r5 = p681uj.C13195l.m79272J()     // Catch: java.lang.Throwable -> L28
            java.lang.String r6 = r4.f5470d     // Catch: java.lang.Throwable -> L28
            r5.m79325o0(r6)     // Catch: java.lang.Throwable -> L28
            goto L6c
        L52:
            java.lang.String r6 = "CloudSyncBuilderManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r1.<init>()     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "getAccessToken HmsException: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L28
            r1.append(r5)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L28
            p514o9.C11839m.m70687e(r6, r5)     // Catch: java.lang.Throwable -> L28
        L6c:
            monitor-exit(r4)
            return r0
        L6e:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.C1164a.m7267c(java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: d */
    public C9453i m7268d(String str) throws C9722c {
        if (m7270g().getLooper() == Looper.myLooper()) {
            C11839m.m70689w("CloudSyncBuilderManager", "getCloudSync methods cannot be called from the UI thread.");
            throw new C9722c(2230, "getCloudSync current thread is ui thread", "", "get_cloud_sync");
        }
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70689w("CloudSyncBuilderManager", "getCloudSync methods cannot be called before account login.");
            throw new C9722c(2231, "getCloudSync is not login", "", "get_cloud_sync");
        }
        String strM17956A = DriveSyncUtil.m17956A();
        if (TextUtils.isEmpty(strM17956A)) {
            C11839m.m70687e("CloudSyncBuilderManager", "cloudSync drive url is empty");
            throw new C9722c(2234, "getCloudSync driveUrl is empty", "", "get_cloud_sync");
        }
        synchronized (f5464e) {
            try {
                C9453i.a aVar = this.f5467a;
                if (aVar != null) {
                    aVar.setRootUrl(strM17956A);
                    return this.f5467a.build();
                }
                C9453i.a aVarM7271h = m7271h(str);
                this.f5467a = aVarM7271h;
                if (aVarM7271h == null) {
                    throw new C9722c(2236, "getCloudSync driveBuilder is null", "", "get_cloud_sync");
                }
                aVarM7271h.setRootUrl(strM17956A);
                if (C1443a.f6214b.booleanValue()) {
                    this.f5467a.setLogLevel(3);
                } else {
                    this.f5467a.setLogLevel(4);
                }
                return this.f5467a.build();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public String m7269e() {
        this.f5468b.readLock().lock();
        try {
            return this.f5470d;
        } finally {
            this.f5468b.readLock().unlock();
        }
    }

    /* renamed from: g */
    public final Handler m7270g() {
        Handler handler;
        if (f5466g != null) {
            return f5466g;
        }
        synchronized (f5465f) {
            try {
                if (f5466g == null) {
                    f5466g = new Handler(Looper.getMainLooper());
                }
                handler = f5466g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    /* renamed from: h */
    public final C9453i.a m7271h(String str) throws C9722c {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CloudSyncBuilderManager", "context is null when building drive");
            return null;
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (C4633d0.m28404a(strM80971t0)) {
            C11839m.m70687e("CloudSyncBuilderManager", "userId is null when building CloudSync");
            throw new C9722c(2235, "userId is null", "", "get_cloud_sync");
        }
        String strM7267c = m7267c(str, false);
        if (!C4633d0.m28404a(strM7267c)) {
            return new C9453i.a(new C10209a.c(strM80971t0, new a(str)).m63363b().m63360j(strM7267c), contextM1377a);
        }
        C11839m.m70687e("CloudSyncBuilderManager", "accessToken is null when building CloudSync");
        throw new C9722c(2269, "accessToken is null", "", "get_cloud_sync");
    }

    /* renamed from: i */
    public synchronized String m7272i(String str, String str2) {
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70688i("CloudSyncBuilderManager", "refreshAccessToken aready st invalid, return old accessToken");
            return this.f5470d;
        }
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.f5470d)) {
            C11839m.m70688i("CloudSyncBuilderManager", "last accessToken is empty and currentAccessToken has been got value");
            return m7267c(str, true);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.f5470d) && !str2.equals(this.f5470d)) {
            C11839m.m70688i("CloudSyncBuilderManager", "currentAccessToken has been updated success");
            return m7267c(str, true);
        }
        String strM30050f = C5009e0.m30044e().m30050f();
        if (C13195l.m79272J().m79308X() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strM30050f) && !str2.equals(strM30050f)) {
            C11839m.m70688i("CloudSyncBuilderManager", "smsAccessToken has been updated success");
            return m7267c(str, true);
        }
        if (m7266b()) {
            C13195l.m79272J().m79325o0(str2);
            C11839m.m70688i("CloudSyncBuilderManager", "setAtInValid");
        }
        return m7267c(str, true);
    }

    /* renamed from: j */
    public void m7273j() {
        C11839m.m70688i("CloudSyncBuilderManager", "releaseDriveBuilder start");
        this.f5470d = "";
        if (this.f5467a != null) {
            synchronized (f5464e) {
                try {
                    if (this.f5467a != null) {
                        this.f5467a = null;
                    }
                } finally {
                }
            }
        }
        C11839m.m70688i("CloudSyncBuilderManager", "releaseDriveBuilder end");
    }

    public C1164a() {
        this.f5468b = new ReentrantReadWriteLock();
        this.f5469c = 0L;
        this.f5470d = "";
    }
}
