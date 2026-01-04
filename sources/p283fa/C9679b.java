package p283fa;

import android.content.Context;
import android.text.TextUtils;
import bb.C1160a;
import ck.C1443a;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.service.C5009e0;
import p012ab.C0086a;
import p015ak.C0213f;
import p340hi.C10209a;
import p514o9.C11839m;
import p681uj.C13195l;
import p709vj.C13452e;

/* renamed from: fa.b */
/* loaded from: classes3.dex */
public class C9679b {

    /* renamed from: d */
    public static final String f47883d = "b";

    /* renamed from: e */
    public static final Object f47884e = new Object();

    /* renamed from: a */
    public C0086a.a f47885a;

    /* renamed from: b */
    public long f47886b;

    /* renamed from: c */
    public String f47887c;

    /* renamed from: fa.b$a */
    public class a implements C10209a.b {
        public a() {
        }

        @Override // p340hi.C10209a.b
        /* renamed from: a */
        public String mo7274a() {
            C9679b c9679b = C9679b.this;
            return c9679b.m60457g(c9679b.f47887c);
        }
    }

    /* renamed from: fa.b$b */
    public static class b {

        /* renamed from: a */
        public static C9679b f47889a = new C9679b(null);
    }

    public /* synthetic */ C9679b(a aVar) {
        this();
    }

    /* renamed from: d */
    public static C9679b m60452d() {
        return b.f47889a;
    }

    /* renamed from: b */
    public final boolean m60453b() {
        return System.currentTimeMillis() - this.f47886b > 60000;
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
    public final synchronized java.lang.String m60454c(boolean r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            uj.l r1 = p681uj.C13195l.m79272J()     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r2 = "com.huawei.hidisk.foldersync"
            java.lang.String r3 = "UserDrive"
            java.lang.String r4 = ""
            java.lang.String r0 = r1.m79290C(r2, r3, r4)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r1 = r5.f47887c     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            if (r1 != 0) goto L65
            r5.f47887c = r0     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r1 = p283fa.C9679b.f47883d     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            java.lang.String r2 = "currentAccessToken has been updated."
            p514o9.C11839m.m70688i(r1, r2)     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            if (r6 == 0) goto L65
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
            r5.f47886b = r1     // Catch: java.lang.Throwable -> L2a p681uj.C13199p -> L2c p681uj.C13194k -> L2e
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
            java.lang.String r1 = p283fa.C9679b.f47883d     // Catch: java.lang.Throwable -> L2a
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
            java.lang.String r1 = p283fa.C9679b.f47883d     // Catch: java.lang.Throwable -> L2a
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
        throw new UnsupportedOperationException("Method not decompiled: p283fa.C9679b.m60454c(boolean):java.lang.String");
    }

    /* renamed from: e */
    public C0086a m60455e() {
        String strM7252c = C1160a.m7252c();
        if (TextUtils.isEmpty(strM7252c)) {
            C11839m.m70687e(f47883d, "cloudPhoto drive user url is empty");
            return null;
        }
        synchronized (f47884e) {
            try {
                C0086a.a aVar = this.f47885a;
                if (aVar != null) {
                    aVar.setRootUrl(strM7252c);
                    return this.f47885a.build();
                }
                C0086a.a aVarM60456f = m60456f();
                this.f47885a = aVarM60456f;
                if (aVarM60456f == null) {
                    return null;
                }
                aVarM60456f.setRootUrl(strM7252c);
                if (C1443a.f6214b.booleanValue()) {
                    this.f47885a.setLogLevel(3);
                } else {
                    this.f47885a.setLogLevel(4);
                }
                return this.f47885a.build();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final C0086a.a m60456f() {
        String str = f47883d;
        C11839m.m70686d(str, "initUserBuilder");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e(str, "context is null when building drive");
            return null;
        }
        String strM60454c = m60454c(false);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (!C4633d0.m28404a(strM80971t0) && !C4633d0.m28404a(strM60454c)) {
            return new C0086a.a(new C10209a.c(strM80971t0, new a()).m63363b().m63360j(strM60454c), contextM1377a);
        }
        C11839m.m70687e(str, "userId or accessToken is null when building CloudPhoto");
        return null;
    }

    /* renamed from: g */
    public synchronized String m60457g(String str) {
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f47887c)) {
            C11839m.m70688i(f47883d, "last accessToken is empty and currentAccessToken has been got value");
            return m60454c(true);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f47887c) && !str.equals(this.f47887c)) {
            C11839m.m70688i(f47883d, "currentAccessToken has been updated success");
            return m60454c(true);
        }
        String strM30050f = C5009e0.m30044e().m30050f();
        if (C13195l.m79272J().m79308X() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(strM30050f) && !str.equals(strM30050f)) {
            C11839m.m70688i(f47883d, "smsAccessToken has been updated success");
            return m60454c(true);
        }
        if (m60453b()) {
            C13195l.m79272J().m79325o0(str);
            C11839m.m70688i(f47883d, "setAtInValid");
        }
        return m60454c(true);
    }

    /* renamed from: h */
    public void m60458h() {
        String str = f47883d;
        C11839m.m70688i(str, "releaseUserBuilder start");
        if (this.f47885a != null) {
            synchronized (f47884e) {
                try {
                    if (this.f47885a != null) {
                        this.f47885a = null;
                    }
                } finally {
                }
            }
        }
        C11839m.m70688i(str, "releaseUserBuilder end");
    }

    public C9679b() {
        this.f47886b = 0L;
        this.f47887c = "";
    }
}
