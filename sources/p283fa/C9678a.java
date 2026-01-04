package p283fa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.service.C5009e0;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p340hi.C10209a;
import p514o9.C11839m;
import p681uj.C13195l;
import p709vj.C13452e;
import p804ya.C13924a;

/* renamed from: fa.a */
/* loaded from: classes3.dex */
public class C9678a {

    /* renamed from: d */
    public static final Object f47875d = new Object();

    /* renamed from: e */
    public static final Object f47876e = new Object();

    /* renamed from: f */
    public static volatile Handler f47877f;

    /* renamed from: a */
    public volatile C13924a.a f47878a;

    /* renamed from: b */
    public long f47879b;

    /* renamed from: c */
    public String f47880c;

    /* renamed from: fa.a$a */
    public class a implements C10209a.b {
        public a() {
        }

        @Override // p340hi.C10209a.b
        /* renamed from: a */
        public String mo7274a() {
            C9678a c9678a = C9678a.this;
            return c9678a.m60448h(c9678a.f47880c);
        }
    }

    /* renamed from: fa.a$b */
    public static class b {

        /* renamed from: a */
        public static C9678a f47882a = new C9678a(null);
    }

    public /* synthetic */ C9678a(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C9678a m60442e() {
        return b.f47882a;
    }

    /* renamed from: b */
    public final boolean m60443b() {
        return System.currentTimeMillis() - this.f47879b > 60000;
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
    public final synchronized java.lang.String m60444c(boolean r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            uj.l r1 = p681uj.C13195l.m79272J()     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r2 = "com.huawei.hidisk.foldersync"
            java.lang.String r3 = "DriveBuilder"
            java.lang.String r4 = ""
            java.lang.String r0 = r1.m79290C(r2, r3, r4)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r1 = r5.f47880c     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            if (r1 != 0) goto L65
            r5.f47880c = r0     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r1 = "CloudPhotoBuilderManager"
            java.lang.String r2 = "currentAccessToken has been updated."
            p031b7.C1120a.m6677i(r1, r2)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            if (r6 == 0) goto L65
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            r5.f47879b = r1     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
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
            java.lang.String r1 = "CloudPhotoBuilderManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r3 = "getAccessToken HmsSTInvalidException: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L2a
            r2.append(r6)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L2a
            p031b7.C1120a.m6676e(r1, r6)     // Catch: java.lang.Throwable -> L2a
            goto L65
        L4b:
            java.lang.String r1 = "CloudPhotoBuilderManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r3 = "getAccessToken HmsException: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L2a
            r2.append(r6)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L2a
            p031b7.C1120a.m6676e(r1, r6)     // Catch: java.lang.Throwable -> L2a
        L65:
            monitor-exit(r5)
            return r0
        L67:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p283fa.C9678a.m60444c(boolean):java.lang.String");
    }

    /* renamed from: d */
    public C13924a m60445d() {
        if (m60446f().getLooper() == Looper.myLooper()) {
            C1120a.m6678w("CloudPhotoBuilderManager", "getCloudPhoto methods cannot be called from the UI thread.");
            return null;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C1120a.m6678w("CloudPhotoBuilderManager", "getCloudPhoto methods cannot be called before account login.");
            return null;
        }
        String strM6774e0 = C1122c.m6774e0();
        if (TextUtils.isEmpty(strM6774e0)) {
            C1120a.m6676e("CloudPhotoBuilderManager", "cloudPhoto drive url is empty");
            return null;
        }
        synchronized (f47875d) {
            try {
                if (this.f47878a != null) {
                    this.f47878a.setRootUrl(strM6774e0);
                    return this.f47878a.build();
                }
                this.f47878a = m60447g();
                if (this.f47878a == null) {
                    return null;
                }
                this.f47878a.setRootUrl(strM6774e0);
                if (C1443a.f6214b.booleanValue()) {
                    this.f47878a.setLogLevel(3);
                } else {
                    this.f47878a.setLogLevel(4);
                }
                return this.f47878a.build();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final Handler m60446f() {
        Handler handler;
        if (f47877f != null) {
            return f47877f;
        }
        synchronized (f47876e) {
            try {
                if (f47877f == null) {
                    f47877f = new Handler(Looper.getMainLooper());
                }
                handler = f47877f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    /* renamed from: g */
    public final C13924a.a m60447g() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1120a.m6676e("CloudPhotoBuilderManager", "context is null when building drive");
            return null;
        }
        String strM60444c = m60444c(false);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (C4633d0.m28404a(strM80971t0) || C4633d0.m28404a(strM60444c)) {
            C1120a.m6676e("CloudPhotoBuilderManager", "userId or accessToken is null when building CloudPhoto");
            return null;
        }
        C13924a.a aVar = new C13924a.a(new C10209a.c(strM80971t0, new a()).m63363b().m63360j(strM60444c), contextM1377a);
        aVar.setTimeOutSeconds(50);
        return aVar;
    }

    /* renamed from: h */
    public synchronized String m60448h(String str) {
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f47880c)) {
            C1120a.m6677i("CloudPhotoBuilderManager", "last accessToken is empty and currentAccessToken has been got value");
            return m60444c(true);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f47880c) && !str.equals(this.f47880c)) {
            C1120a.m6677i("CloudPhotoBuilderManager", "currentAccessToken has been updated success");
            return m60444c(true);
        }
        String strM30050f = C5009e0.m30044e().m30050f();
        if (C13195l.m79272J().m79308X() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(strM30050f) && !str.equals(strM30050f)) {
            C11839m.m70688i("CloudPhotoBuilderManager", "smsAccessToken has been updated success");
            return m60444c(true);
        }
        if (m60443b()) {
            C13195l.m79272J().m79325o0(str);
            C1120a.m6677i("CloudPhotoBuilderManager", "setAtInValid");
        }
        return m60444c(true);
    }

    /* renamed from: i */
    public void m60449i() {
        C1120a.m6677i("CloudPhotoBuilderManager", "releaseDriveBuilder start");
        if (this.f47878a != null) {
            synchronized (f47875d) {
                try {
                    if (this.f47878a != null) {
                        this.f47878a = null;
                    }
                } finally {
                }
            }
        }
        C1120a.m6677i("CloudPhotoBuilderManager", "releaseDriveBuilder end");
    }

    public C9678a() {
        this.f47879b = 0L;
        this.f47880c = "";
    }
}
