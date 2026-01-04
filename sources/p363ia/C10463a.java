package p363ia;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.cloud.base.util.C4633d0;
import fk.C9721b;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p015ak.C0213f;
import p340hi.C10209a;
import p514o9.C11839m;
import p681uj.C13195l;
import p709vj.C13452e;
import tm.C13040c;

/* renamed from: ia.a */
/* loaded from: classes3.dex */
public class C10463a {

    /* renamed from: e */
    public static final Object f50436e = new Object();

    /* renamed from: f */
    public static final Object f50437f = new Object();

    /* renamed from: g */
    public static volatile Handler f50438g;

    /* renamed from: a */
    public DriveExpand.Builder f50439a;

    /* renamed from: b */
    public ReadWriteLock f50440b;

    /* renamed from: c */
    public long f50441c;

    /* renamed from: d */
    public volatile String f50442d;

    /* renamed from: ia.a$a */
    public class a implements C10209a.b {
        public a() {
        }

        @Override // p340hi.C10209a.b
        /* renamed from: a */
        public String mo7274a() {
            C10463a c10463a = C10463a.this;
            return c10463a.m64285h(c10463a.f50442d);
        }
    }

    /* renamed from: ia.a$b */
    public static class b {

        /* renamed from: a */
        public static C10463a f50444a = new C10463a(null);
    }

    public /* synthetic */ C10463a(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C10463a m64279e() {
        return b.f50444a;
    }

    /* renamed from: b */
    public final boolean m64280b() {
        return System.currentTimeMillis() - this.f50441c > 60000;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0065 A[DONT_GENERATE, PHI: r0
  0x0065: PHI (r0v3 java.lang.String) = 
  (r0v1 java.lang.String)
  (r0v2 java.lang.String)
  (r0v4 java.lang.String)
  (r0v4 java.lang.String)
  (r0v4 java.lang.String)
 binds: [B:41:0x0030, B:42:0x004b, B:30:0x0016, B:32:0x0021, B:33:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m64281c(boolean r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            uj.l r1 = p681uj.C13195l.m79272J()     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r2 = "com.huawei.hidisk.foldersync"
            java.lang.String r3 = "DriveExpand"
            java.lang.String r4 = ""
            java.lang.String r0 = r1.m79290C(r2, r3, r4)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r1 = r5.f50442d     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            if (r1 != 0) goto L65
            r5.f50442d = r0     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r1 = "DriveExpandBuilderManager"
            java.lang.String r2 = "currentAccessToken has been updated."
            p514o9.C11839m.m70688i(r1, r2)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            if (r6 == 0) goto L65
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            r5.f50441c = r1     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            goto L65
        L2a:
            r6 = move-exception
            goto L67
        L2c:
            r6 = move-exception
            goto L30
        L2e:
            r6 = move-exception
            goto L4b
        L30:
            java.lang.String r1 = "DriveExpandBuilderManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r3 = "getAccessToken HmsSTInvalidException: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L2a
            r2.append(r6)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L2a
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L2a
            goto L65
        L4b:
            java.lang.String r1 = "DriveExpandBuilderManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r3 = "getAccessToken HmsException: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L2a
            r2.append(r6)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L2a
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L2a
        L65:
            monitor-exit(r5)
            return r0
        L67:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p363ia.C10463a.m64281c(boolean):java.lang.String");
    }

    /* renamed from: d */
    public DriveExpand m64282d() {
        String strM78633Y;
        if (m64283f().getLooper() == Looper.myLooper()) {
            C11839m.m70689w("DriveExpandBuilderManager", "getDriveExpand methods cannot be called from the UI thread.");
            return null;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70689w("DriveExpandBuilderManager", "getDriveExpand methods cannot be called before account login.");
            return null;
        }
        try {
            strM78633Y = C13040c.m78609F().m78633Y();
        } catch (C9721b e10) {
            C11839m.m70687e("DriveExpandBuilderManager", "drive get url error " + e10.toString());
            strM78633Y = null;
        }
        if (TextUtils.isEmpty(strM78633Y)) {
            C11839m.m70687e("DriveExpandBuilderManager", "drive url is empty");
            return null;
        }
        synchronized (f50436e) {
            try {
                if (this.f50439a != null) {
                    C11839m.m70688i("DriveExpandBuilderManager", "get cache driveExpandBuilder");
                    this.f50439a.setRootUrl(strM78633Y);
                    return this.f50439a.build();
                }
                C11839m.m70688i("DriveExpandBuilderManager", "driveExpandBuilder is null");
                DriveExpand.Builder builderM64284g = m64284g();
                this.f50439a = builderM64284g;
                if (builderM64284g == null) {
                    return null;
                }
                builderM64284g.setRootUrl(strM78633Y);
                if (C1443a.f6214b.booleanValue()) {
                    this.f50439a.setLogLevel(3);
                } else {
                    this.f50439a.setLogLevel(4);
                }
                return this.f50439a.build();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final Handler m64283f() {
        Handler handler;
        if (f50438g != null) {
            return f50438g;
        }
        synchronized (f50437f) {
            try {
                if (f50438g == null) {
                    f50438g = new Handler(Looper.getMainLooper());
                }
                handler = f50438g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    /* renamed from: g */
    public final DriveExpand.Builder m64284g() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("DriveExpandBuilderManager", "context is null when building drive");
            return null;
        }
        String strM64281c = m64281c(false);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (!C4633d0.m28404a(strM80971t0) && !C4633d0.m28404a(strM64281c)) {
            return new DriveExpand.Builder(new C10209a.c(strM80971t0, new a()).m63363b().m63360j(strM64281c), contextM1377a);
        }
        C11839m.m70687e("DriveExpandBuilderManager", "userId or accessToken is null when building driveExpand");
        return null;
    }

    /* renamed from: h */
    public synchronized String m64285h(String str) {
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f50442d)) {
            C11839m.m70688i("DriveExpandBuilderManager", "last accessToken is empty and currentAccessToken has been got value");
            return m64281c(true);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f50442d) && !str.equals(this.f50442d)) {
            C11839m.m70688i("DriveExpandBuilderManager", "currentAccessToken has been updated success");
            return m64281c(true);
        }
        if (m64280b()) {
            C13195l.m79272J().m79325o0(str);
            C11839m.m70688i("DriveExpandBuilderManager", "setAtInValid");
        }
        return m64281c(true);
    }

    /* renamed from: i */
    public void m64286i() {
        C11839m.m70688i("DriveExpandBuilderManager", "release start");
        this.f50442d = "";
        if (this.f50439a != null) {
            synchronized (f50436e) {
                try {
                    if (this.f50439a != null) {
                        C11839m.m70688i("DriveExpandBuilderManager", "clear driveExpandBuilder");
                        this.f50439a = null;
                    }
                } finally {
                }
            }
        }
        C11839m.m70688i("DriveExpandBuilderManager", "release end");
    }

    public C10463a() {
        this.f50440b = new ReentrantReadWriteLock();
        this.f50441c = 0L;
        this.f50442d = "";
    }
}
