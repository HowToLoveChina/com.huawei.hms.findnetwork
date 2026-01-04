package p546p6;

import android.os.SystemClock;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;
import p764x6.C13717i;

/* renamed from: p6.s */
/* loaded from: classes2.dex */
public class C12106s {

    /* renamed from: a */
    public long f56137a;

    /* renamed from: b */
    public volatile Lock f56138b;

    /* renamed from: c */
    public Map<EnumC12107t, Date> f56139c;

    /* renamed from: d */
    public C12104q f56140d;

    /* renamed from: e */
    public volatile boolean f56141e;

    /* renamed from: p6.s$b */
    public static class b {

        /* renamed from: a */
        public static C12106s f56142a = new C12106s();
    }

    /* renamed from: c */
    public static C12106s m72509c() {
        return b.f56142a;
    }

    /* renamed from: a */
    public final void m72510a() {
        C1120a.m6677i("LockManager", "checkLockIsExpire: " + this.f56137a);
        if (System.currentTimeMillis() - this.f56137a > this.f56138b.getLockInterval().intValue() * 2 * 1000) {
            m72517i();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [kk.c] */
    /* JADX WARN: Type inference failed for: r2v6, types: [kk.c] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v7, types: [x6.i] */
    /* renamed from: b */
    public final synchronized void m72511b() {
        C1120a.m6677i("LockManager", "executeReleaseLock");
        ?? M1377a = "0:1";
        String message = "OK";
        ?? M6755Z0 = C1122c.m6755Z0("04001");
        boolean z10 = false;
        z10 = false;
        Lock lock = null;
        lock = null;
        try {
            try {
                try {
                    new C13717i().m82458l(this.f56138b.getSessionId(), M6755Z0, this.f56141e);
                    this.f56137a = 0L;
                    this.f56138b = null;
                    this.f56140d.m72495c();
                    this.f56141e = false;
                    ?? M80971t0 = C13452e.m80781L().m80971t0();
                    C11060c c11060cM66626a = C11058a.m66626a(M6755Z0, "Locks.delete", M80971t0);
                    c11060cM66626a.m66665u("0:1");
                    c11060cM66626a.m66635A("OK");
                    M1377a = C0213f.m1377a();
                    M6755Z0 = c11060cM66626a;
                    z10 = "Locks.delete";
                    lock = M80971t0;
                } catch (IOException e10) {
                    message = e10.getMessage();
                    C1120a.m6676e("LockManager", "executeReleaseLock error: " + e10.toString());
                    this.f56137a = 0L;
                    this.f56138b = null;
                    this.f56140d.m72495c();
                    this.f56141e = false;
                    ?? M80971t02 = C13452e.m80781L().m80971t0();
                    C11060c c11060cM66626a2 = C11058a.m66626a(M6755Z0, "Locks.delete", M80971t02);
                    c11060cM66626a2.m66665u("101_4313:1");
                    c11060cM66626a2.m66635A(message);
                    M1377a = C0213f.m1377a();
                    M6755Z0 = c11060cM66626a2;
                    z10 = "Locks.delete";
                    lock = M80971t02;
                }
            } catch (C9721b e11) {
                String str = "101_" + e11.m60659c() + ":1";
                message = e11.getMessage();
                C1120a.m6676e("LockManager", "executeReleaseLock CException: " + e11.toString());
                this.f56137a = 0L;
                this.f56138b = null;
                this.f56140d.m72495c();
                this.f56141e = false;
                ?? M80971t03 = C13452e.m80781L().m80971t0();
                C11060c c11060cM66626a3 = C11058a.m66626a(M6755Z0, "Locks.delete", M80971t03);
                c11060cM66626a3.m66665u(str);
                c11060cM66626a3.m66635A(message);
                M1377a = C0213f.m1377a();
                M6755Z0 = c11060cM66626a3;
                z10 = "Locks.delete";
                lock = M80971t03;
            }
            C13622a.m81968n(M1377a, M6755Z0);
        } finally {
        }
    }

    /* renamed from: d */
    public synchronized Lock m72512d(boolean z10) {
        try {
            if (this.f56138b == null) {
                return null;
            }
            m72510a();
            if (z10) {
                this.f56141e = true;
            }
            return this.f56138b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public synchronized Lock m72513e(EnumC12107t enumC12107t, boolean z10) throws Exception {
        C1120a.m6677i("LockManager", "getLockToken: " + enumC12107t);
        if (this.f56138b != null) {
            this.f56139c.put(enumC12107t, new Date());
            m72510a();
            if (z10) {
                this.f56141e = true;
            }
            return this.f56138b;
        }
        String strM6755Z0 = C1122c.m6755Z0("04001");
        try {
            try {
                this.f56138b = new C13717i().m82461o(strM6755Z0);
                this.f56140d.m72500h(this.f56138b.getSessionId());
                this.f56140d.m72497e(this.f56138b.getLockInterval().intValue() * 1000);
                this.f56139c.put(enumC12107t, new Date());
                this.f56137a = System.currentTimeMillis();
                if (z10) {
                    this.f56141e = true;
                }
                Lock lock = this.f56138b;
                C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Locks.get", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A("OK");
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                return lock;
            } catch (C9721b e10) {
                String str = "101_" + e10.m60659c() + ":1";
                e10.getMessage();
                C1120a.m6676e("LockManager", "getLock CException: " + e10.toString());
                throw e10;
            } catch (IOException e11) {
                e11.getMessage();
                C1120a.m6676e("LockManager", "getLock IOException: " + e11.toString());
                throw e11;
            }
        } catch (Throwable th2) {
            C11060c c11060cM66626a2 = C11058a.m66626a(strM6755Z0, "Locks.get", C13452e.m80781L().m80971t0());
            c11060cM66626a2.m66665u("0:1");
            c11060cM66626a2.m66635A("OK");
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a2);
            throw th2;
        }
    }

    /* renamed from: f */
    public int m72514f(String str, String str2, String str3) {
        int iM60659c;
        String string;
        String string2 = "OK";
        try {
            try {
                try {
                    SyncSessionManager.m15153t().m15175V(true);
                    new C13717i().m82464r(str, str2);
                    m72521m();
                    return 0;
                } catch (C4616s e10) {
                    string2 = e10.toString();
                    int iM28322f = e10.m28322f();
                    int iM6802l0 = C1122c.m6802l0(e10);
                    C1120a.m6676e("LockManager", "getVFCLock httpResponseException statusCode: " + iM28322f + ", detailCode: " + iM6802l0);
                    if (iM28322f != 503 || iM6802l0 != 5032) {
                        C11060c c11060cM66626a = C11058a.m66626a(str3, "Lock.vfc.get", C13452e.m80781L().m80971t0());
                        c11060cM66626a.m66665u(String.valueOf(iM28322f));
                        c11060cM66626a.m66635A(string2);
                        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                        return iM28322f;
                    }
                    C4609l c4609lM28321e = e10.m28321e();
                    if (c4609lM28321e != null) {
                        Object obj = c4609lM28321e.get("x-hw-sync-interval");
                        try {
                            if (obj instanceof ArrayList) {
                                m72522n(Integer.valueOf((String) ((ArrayList) obj).get(0)).intValue());
                            } else {
                                C1120a.m6678w("LockManager", "getVFCLock syncInterval class not ArrayList: " + obj.getClass());
                            }
                        } catch (Exception e11) {
                            C1120a.m6676e("LockManager", "getVFCLock updateControlData error: " + e11);
                        }
                    }
                    C11060c c11060cM66626a2 = C11058a.m66626a(str3, "Lock.vfc.get", C13452e.m80781L().m80971t0());
                    c11060cM66626a2.m66665u(String.valueOf(iM6802l0));
                    c11060cM66626a2.m66635A(string2);
                    C13622a.m81968n(C0213f.m1377a(), c11060cM66626a2);
                    return iM6802l0;
                } catch (C9721b e12) {
                    C1120a.m6676e("LockManager", "getVFCLock CException: " + e12);
                    iM60659c = e12.m60659c();
                    string = e12.toString();
                    C11060c c11060cM66626a3 = C11058a.m66626a(str3, "Lock.vfc.get", C13452e.m80781L().m80971t0());
                    c11060cM66626a3.m66665u(String.valueOf(iM60659c));
                    c11060cM66626a3.m66635A(string);
                    C13622a.m81968n(C0213f.m1377a(), c11060cM66626a3);
                    return iM60659c;
                }
            } catch (IOException e13) {
                C1120a.m6676e("LockManager", "getVFCLock IOException: " + e13);
                iM60659c = 4313;
                string = e13.toString();
                C11060c c11060cM66626a32 = C11058a.m66626a(str3, "Lock.vfc.get", C13452e.m80781L().m80971t0());
                c11060cM66626a32.m66665u(String.valueOf(iM60659c));
                c11060cM66626a32.m66635A(string);
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a32);
                return iM60659c;
            }
        } finally {
            C11060c c11060cM66626a4 = C11058a.m66626a(str3, "Lock.vfc.get", C13452e.m80781L().m80971t0());
            c11060cM66626a4.m66665u(String.valueOf(0));
            c11060cM66626a4.m66635A(string2);
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m72515g() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<p6.t, java.util.Date> r0 = r2.f56139c     // Catch: java.lang.Throwable -> L18
            p6.t r1 = p546p6.EnumC12107t.GENERAL_SYNC_SDK     // Catch: java.lang.Throwable -> L18
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            java.util.Map<p6.t, java.util.Date> r0 = r2.f56139c     // Catch: java.lang.Throwable -> L18
            p6.t r1 = p546p6.EnumC12107t.SHARE_SYNC_SDK     // Catch: java.lang.Throwable -> L18
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L16
            goto L1a
        L16:
            r0 = 0
            goto L1b
        L18:
            r0 = move-exception
            goto L1d
        L1a:
            r0 = 1
        L1b:
            monitor-exit(r2)
            return r0
        L1d:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p546p6.C12106s.m72515g():boolean");
    }

    /* renamed from: h */
    public synchronized void m72516h() {
        C1120a.m6677i("LockManager", "refreshKeepLockTime");
        this.f56137a = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6, types: [kk.c] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: i */
    public final synchronized void m72517i() {
        C1120a.m6677i("LockManager", "refreshLock");
        String strM1377a = "0:1";
        String message = "OK";
        String strM6755Z0 = C1122c.m6755Z0("04001");
        try {
            try {
                try {
                    this.f56140d.m72495c();
                    this.f56138b = new C13717i().m82461o(strM6755Z0);
                    this.f56140d.m72500h(this.f56138b.getSessionId());
                    this.f56140d.m72497e(this.f56138b.getLockInterval().intValue() * 1000);
                    this.f56137a = System.currentTimeMillis();
                    C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
                    c11060cM66626a.m66665u("0:1");
                    c11060cM66626a.m66635A("OK");
                    strM1377a = C0213f.m1377a();
                    strM6755Z0 = c11060cM66626a;
                } catch (IOException e10) {
                    message = e10.getMessage();
                    C1120a.m6676e("LockManager", "refreshLock error: " + e10.toString());
                    C11060c c11060cM66626a2 = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
                    c11060cM66626a2.m66665u("101_4313:1");
                    c11060cM66626a2.m66635A(message);
                    strM1377a = C0213f.m1377a();
                    strM6755Z0 = c11060cM66626a2;
                }
            } catch (C9721b e11) {
                String str = "101_" + e11.m60659c() + ":1";
                message = e11.getMessage();
                C1120a.m6676e("LockManager", "refreshLock CException: " + e11.toString());
                C11060c c11060cM66626a3 = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a3.m66665u(str);
                c11060cM66626a3.m66635A(message);
                strM1377a = C0213f.m1377a();
                strM6755Z0 = c11060cM66626a3;
            }
            C13622a.m81968n(strM1377a, strM6755Z0);
        } catch (Throwable th2) {
            C11060c c11060cM66626a4 = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
            c11060cM66626a4.m66665u(strM1377a);
            c11060cM66626a4.m66635A(message);
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a4);
            throw th2;
        }
    }

    /* renamed from: j */
    public synchronized void m72518j(Lock lock) {
        C1120a.m6677i("LockManager", "refreshLock ");
        this.f56137a = System.currentTimeMillis();
        this.f56138b = lock;
    }

    /* renamed from: k */
    public synchronized void m72519k() {
        C1120a.m6677i("LockManager", "releaseLock");
        this.f56139c.clear();
        if (this.f56138b != null) {
            m72511b();
        }
    }

    /* renamed from: l */
    public synchronized void m72520l(EnumC12107t enumC12107t) {
        C1120a.m6677i("LockManager", "releaseLock taskType: " + enumC12107t);
        if (this.f56139c.isEmpty()) {
            C1120a.m6678w("LockManager", "releaseLock taskMap isEmpty");
            return;
        }
        this.f56139c.remove(enumC12107t);
        if (this.f56139c.isEmpty() && this.f56138b != null) {
            m72511b();
        }
    }

    /* renamed from: m */
    public void m72521m() {
        C1120a.m6677i("LockManager", "resetControlData");
        C1136q.m6943A(0L);
        C1136q.m6949G(0);
        C1136q.m6950H(0);
    }

    /* renamed from: n */
    public final void m72522n(int i10) {
        C1120a.m6677i("LockManager", "updateControlData syncInterval: " + i10);
        C1136q.m6943A(SystemClock.elapsedRealtime());
        C1136q.m6959Q();
        C1136q.m6950H(i10);
    }

    public C12106s() {
        this.f56139c = new HashMap();
        this.f56140d = new C12104q();
        this.f56141e = false;
    }
}
