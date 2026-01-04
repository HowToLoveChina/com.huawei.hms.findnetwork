package p546p6;

import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import fk.C9721b;
import java.io.IOException;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;
import p764x6.C13717i;

/* renamed from: p6.v */
/* loaded from: classes2.dex */
public class C12109v {

    /* renamed from: a */
    public long f56161a;

    /* renamed from: b */
    public Lock f56162b;

    /* renamed from: c */
    public C12104q f56163c;

    /* renamed from: p6.v$b */
    public static class b {

        /* renamed from: a */
        public static C12109v f56164a = new C12109v();
    }

    /* renamed from: c */
    public static C12109v m72524c() {
        return b.f56164a;
    }

    /* renamed from: a */
    public final void m72525a() {
        C1120a.m6677i("RefundLockManager", "checkLockIsExpire: " + this.f56161a);
        if (System.currentTimeMillis() - this.f56161a > this.f56162b.getLockInterval().intValue() * 2 * 1000) {
            m72529f();
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
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v7, types: [x6.i] */
    /* renamed from: b */
    public final synchronized void m72526b() {
        C1120a.m6677i("RefundLockManager", "executeReleaseLock");
        ?? M1377a = "0:1";
        String message = "OK";
        ?? M6755Z0 = C1122c.m6755Z0("04021");
        Lock lock = null;
        long j10 = 0;
        try {
            try {
                new C13717i().m82460n(this.f56162b.getSessionId(), M6755Z0);
                this.f56161a = 0L;
                this.f56162b = null;
                this.f56163c.m72495c();
                ?? M80971t0 = C13452e.m80781L().m80971t0();
                C11060c c11060cM66626a = C11058a.m66626a(M6755Z0, "Refund.Locks.delete", M80971t0);
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A("OK");
                M1377a = C0213f.m1377a();
                M6755Z0 = c11060cM66626a;
                lock = "Refund.Locks.delete";
                j10 = M80971t0;
            } catch (C9721b e10) {
                String str = "101_" + e10.m60659c() + ":1";
                message = e10.getMessage();
                C1120a.m6676e("RefundLockManager", "executeReleaseLock CException: " + e10.toString());
                this.f56161a = 0L;
                this.f56162b = null;
                this.f56163c.m72495c();
                ?? M80971t02 = C13452e.m80781L().m80971t0();
                C11060c c11060cM66626a2 = C11058a.m66626a(M6755Z0, "Refund.Locks.delete", M80971t02);
                c11060cM66626a2.m66665u(str);
                c11060cM66626a2.m66635A(message);
                M1377a = C0213f.m1377a();
                M6755Z0 = c11060cM66626a2;
                lock = "Refund.Locks.delete";
                j10 = M80971t02;
            } catch (IOException e11) {
                message = e11.getMessage();
                C1120a.m6676e("RefundLockManager", "executeReleaseLock error: " + e11.toString());
                this.f56161a = 0L;
                this.f56162b = null;
                this.f56163c.m72495c();
                ?? M80971t03 = C13452e.m80781L().m80971t0();
                C11060c c11060cM66626a3 = C11058a.m66626a(M6755Z0, "Refund.Locks.delete", M80971t03);
                c11060cM66626a3.m66665u("101_4313:1");
                c11060cM66626a3.m66635A(message);
                M1377a = C0213f.m1377a();
                M6755Z0 = c11060cM66626a3;
                lock = "Refund.Locks.delete";
                j10 = M80971t03;
            }
            C13622a.m81968n(M1377a, M6755Z0);
        } catch (Throwable th2) {
            this.f56161a = j10;
            this.f56162b = lock;
            this.f56163c.m72495c();
            ?? M66626a = C11058a.m66626a(M6755Z0, "Refund.Locks.delete", C13452e.m80781L().m80971t0());
            M66626a.m66665u(M1377a);
            M66626a.m66635A(message);
            C13622a.m81968n(C0213f.m1377a(), M66626a);
            throw th2;
        }
    }

    /* renamed from: d */
    public synchronized Lock m72527d() {
        C1120a.m6677i("RefundLockManager", "getLockToken");
        if (this.f56162b != null) {
            m72525a();
            return this.f56162b;
        }
        String strM6755Z0 = C1122c.m6755Z0("04021");
        try {
            try {
                try {
                    Lock lockM82463q = new C13717i().m82463q(strM6755Z0);
                    this.f56162b = lockM82463q;
                    this.f56163c.m72500h(lockM82463q.getSessionId());
                    this.f56163c.m72499g(this.f56162b.getLockInterval().intValue() * 1000);
                    this.f56161a = System.currentTimeMillis();
                    return this.f56162b;
                } catch (IOException e10) {
                    String message = e10.getMessage();
                    C1120a.m6676e("RefundLockManager", "getLock IOException: " + e10.toString());
                    C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Refund.Locks.get", C13452e.m80781L().m80971t0());
                    c11060cM66626a.m66665u("101_4313:1");
                    c11060cM66626a.m66635A(message);
                    C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                    return null;
                }
            } catch (C9721b e11) {
                String str = "101_" + e11.m60659c() + ":1";
                String message2 = e11.getMessage();
                C1120a.m6676e("RefundLockManager", "getLock CException: " + e11.toString());
                C11060c c11060cM66626a2 = C11058a.m66626a(strM6755Z0, "Refund.Locks.get", C13452e.m80781L().m80971t0());
                c11060cM66626a2.m66665u(str);
                c11060cM66626a2.m66635A(message2);
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a2);
                return null;
            }
        } finally {
            C11060c c11060cM66626a3 = C11058a.m66626a(strM6755Z0, "Refund.Locks.get", C13452e.m80781L().m80971t0());
            c11060cM66626a3.m66665u("0:1");
            c11060cM66626a3.m66635A("OK");
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a3);
        }
    }

    /* renamed from: e */
    public synchronized void m72528e() {
        C1120a.m6677i("RefundLockManager", "refreshKeepLockTime");
        this.f56161a = System.currentTimeMillis();
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
    /* renamed from: f */
    public final synchronized void m72529f() {
        C1120a.m6677i("RefundLockManager", "refreshLock");
        String strM1377a = "0:1";
        String message = "OK";
        String strM6755Z0 = C1122c.m6755Z0("04021");
        try {
            try {
                this.f56163c.m72495c();
                Lock lockM82463q = new C13717i().m82463q(strM6755Z0);
                this.f56162b = lockM82463q;
                this.f56163c.m72500h(lockM82463q.getSessionId());
                this.f56163c.m72499g(this.f56162b.getLockInterval().intValue() * 1000);
                this.f56161a = System.currentTimeMillis();
                C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Refund.Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A("OK");
                strM1377a = C0213f.m1377a();
                strM6755Z0 = c11060cM66626a;
            } catch (C9721b e10) {
                String str = "101_" + e10.m60659c() + ":1";
                message = e10.getMessage();
                C1120a.m6676e("RefundLockManager", "refreshLock CException: " + e10.toString());
                C11060c c11060cM66626a2 = C11058a.m66626a(strM6755Z0, "Refund.Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a2.m66665u(str);
                c11060cM66626a2.m66635A(message);
                strM1377a = C0213f.m1377a();
                strM6755Z0 = c11060cM66626a2;
            } catch (IOException e11) {
                message = e11.getMessage();
                C1120a.m6676e("RefundLockManager", "refreshLock error: " + e11.toString());
                C11060c c11060cM66626a3 = C11058a.m66626a(strM6755Z0, "Refund.Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a3.m66665u("101_4313:1");
                c11060cM66626a3.m66635A(message);
                strM1377a = C0213f.m1377a();
                strM6755Z0 = c11060cM66626a3;
            }
            C13622a.m81968n(strM1377a, strM6755Z0);
        } catch (Throwable th2) {
            C11060c c11060cM66626a4 = C11058a.m66626a(strM6755Z0, "Refund.Locks.get.refresh", C13452e.m80781L().m80971t0());
            c11060cM66626a4.m66665u(strM1377a);
            c11060cM66626a4.m66635A(message);
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a4);
            throw th2;
        }
    }

    /* renamed from: g */
    public synchronized void m72530g(Lock lock) {
        C1120a.m6677i("RefundLockManager", "refreshLock");
        this.f56161a = System.currentTimeMillis();
        this.f56162b = lock;
    }

    /* renamed from: h */
    public synchronized void m72531h() {
        C1120a.m6677i("RefundLockManager", "releaseLock");
        if (this.f56162b != null) {
            m72526b();
        }
    }

    public C12109v() {
        this.f56163c = new C12104q();
    }
}
