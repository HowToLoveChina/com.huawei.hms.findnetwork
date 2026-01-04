package p546p6;

import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import fk.C9721b;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;
import p764x6.C13717i;

/* renamed from: p6.a */
/* loaded from: classes2.dex */
public class C12088a {

    /* renamed from: a */
    public long f55920a;

    /* renamed from: b */
    public Lock f55921b;

    /* renamed from: c */
    public Map<c, Date> f55922c;

    /* renamed from: d */
    public C12104q f55923d;

    /* renamed from: e */
    public volatile boolean f55924e;

    /* renamed from: p6.a$b */
    public static class b {

        /* renamed from: a */
        public static C12088a f55925a = new C12088a();
    }

    /* renamed from: p6.a$c */
    public enum c {
        ALBUM_CLIENT_SHARE_CREATE_ALBUM,
        ALBUM_CLIENT_SHARE_DELETE_ALBUM,
        ALBUM_CLIENT_SHARE_UPDATE_ALBUM,
        ALBUM_CLIENT_SYNC,
        SHARE_PHOTO_UPLOAD,
        SHARE_PHOTO_UPLOAD_GET_BATCH
    }

    public /* synthetic */ C12088a(a aVar) {
        this();
    }

    /* renamed from: c */
    public static C12088a m72266c() {
        return b.f55925a;
    }

    /* renamed from: a */
    public final void m72267a() {
        C1120a.m6677i("AlbumClientLockManager", "checkLockIsExpire: " + this.f55920a);
        if (System.currentTimeMillis() - this.f55920a > this.f55921b.getLockInterval().intValue() * 2 * 1000) {
            m72272g();
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
    public final synchronized void m72268b() {
        C1120a.m6677i("AlbumClientLockManager", "executeReleaseLock");
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
                    new C13717i().m82459m(this.f55921b.getSessionId(), M6755Z0, this.f55924e);
                    this.f55920a = 0L;
                    this.f55921b = null;
                    this.f55923d.m72495c();
                    this.f55924e = false;
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
                    C1120a.m6676e("AlbumClientLockManager", "executeReleaseLock error: " + e10.toString());
                    this.f55920a = 0L;
                    this.f55921b = null;
                    this.f55923d.m72495c();
                    this.f55924e = false;
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
                C1120a.m6676e("AlbumClientLockManager", "executeReleaseLock CException: " + e11.toString());
                this.f55920a = 0L;
                this.f55921b = null;
                this.f55923d.m72495c();
                this.f55924e = false;
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
    public synchronized Lock m72269d(boolean z10) {
        try {
            if (this.f55921b == null) {
                return null;
            }
            m72267a();
            if (z10) {
                this.f55924e = true;
            }
            return this.f55921b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public synchronized Lock m72270e(c cVar, boolean z10) throws Exception {
        C1120a.m6677i("AlbumClientLockManager", "getLockToken: " + cVar);
        if (this.f55921b != null) {
            this.f55922c.put(cVar, new Date());
            m72267a();
            if (z10) {
                this.f55924e = true;
            }
            return this.f55921b;
        }
        String strM6755Z0 = C1122c.m6755Z0("04001");
        try {
            try {
                Lock lockM82462p = new C13717i().m82462p(strM6755Z0);
                this.f55921b = lockM82462p;
                this.f55923d.m72500h(lockM82462p.getSessionId());
                this.f55923d.m72498f(this.f55921b.getLockInterval().intValue() * 1000);
                this.f55922c.put(cVar, new Date());
                this.f55920a = System.currentTimeMillis();
                if (z10) {
                    this.f55924e = true;
                }
                Lock lock = this.f55921b;
                C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Locks.get", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A("OK");
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                return lock;
            } catch (C9721b e10) {
                String str = "101_" + e10.m60659c() + ":1";
                e10.getMessage();
                C1120a.m6676e("AlbumClientLockManager", "getLock CException: " + e10);
                throw e10;
            } catch (IOException e11) {
                e11.getMessage();
                C1120a.m6676e("AlbumClientLockManager", "getLock IOException: " + e11);
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
    public synchronized void m72271f() {
        C1120a.m6677i("AlbumClientLockManager", "refreshKeepLockTime");
        this.f55920a = System.currentTimeMillis();
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
    /* renamed from: g */
    public final synchronized void m72272g() {
        C1120a.m6677i("AlbumClientLockManager", "refreshLock");
        String strM1377a = "0:1";
        String message = "OK";
        String strM6755Z0 = C1122c.m6755Z0("04001");
        try {
            try {
                this.f55923d.m72495c();
                Lock lockM82462p = new C13717i().m82462p(strM6755Z0);
                this.f55921b = lockM82462p;
                this.f55923d.m72500h(lockM82462p.getSessionId());
                this.f55923d.m72498f(this.f55921b.getLockInterval().intValue() * 1000);
                this.f55920a = System.currentTimeMillis();
                C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A("OK");
                strM1377a = C0213f.m1377a();
                strM6755Z0 = c11060cM66626a;
            } catch (C9721b e10) {
                String str = "101_" + e10.m60659c() + ":1";
                message = e10.getMessage();
                C1120a.m6676e("AlbumClientLockManager", "refreshLock CException: " + e10);
                C11060c c11060cM66626a2 = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a2.m66665u(str);
                c11060cM66626a2.m66635A(message);
                strM1377a = C0213f.m1377a();
                strM6755Z0 = c11060cM66626a2;
            } catch (IOException e11) {
                message = e11.getMessage();
                C1120a.m6676e("AlbumClientLockManager", "refreshLock error: " + e11);
                C11060c c11060cM66626a3 = C11058a.m66626a(strM6755Z0, "Locks.get.refresh", C13452e.m80781L().m80971t0());
                c11060cM66626a3.m66665u("101_4313:1");
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

    /* renamed from: h */
    public synchronized void m72273h(Lock lock) {
        C1120a.m6677i("AlbumClientLockManager", "refreshLock ");
        this.f55920a = System.currentTimeMillis();
        this.f55921b = lock;
    }

    /* renamed from: i */
    public synchronized void m72274i() {
        C1120a.m6677i("AlbumClientLockManager", "releaseLock");
        this.f55922c.clear();
        if (this.f55921b != null) {
            m72268b();
        }
    }

    /* renamed from: j */
    public synchronized void m72275j(c cVar) {
        C1120a.m6677i("AlbumClientLockManager", "releaseLock taskType: " + cVar);
        if (this.f55922c.isEmpty()) {
            C1120a.m6678w("AlbumClientLockManager", "releaseLock taskMap isEmpty");
            return;
        }
        this.f55922c.remove(cVar);
        if (this.f55922c.isEmpty() && this.f55921b != null) {
            m72268b();
        }
    }

    public C12088a() {
        this.f55922c = new HashMap();
        this.f55923d = new C12104q();
        this.f55924e = false;
    }
}
