package ru;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.wearengine.C8885c;
import com.huawei.wearengine.C8887d;
import com.huawei.wearengine.WearEngineManager;
import java.lang.ref.WeakReference;
import p558pu.C12227b;
import p558pu.InterfaceC12228c;
import su.C12860b;

/* renamed from: ru.c */
/* loaded from: classes9.dex */
public class C12629c implements WearEngineManager, InterfaceC12228c {

    /* renamed from: b */
    public boolean f58070b = false;

    /* renamed from: c */
    public final Object f58071c = new Object();

    /* renamed from: d */
    public IBinder.DeathRecipient f58072d = new a();

    /* renamed from: a */
    public volatile WearEngineManager f58069a = null;

    /* renamed from: ru.c$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (C12629c.this.f58069a != null) {
                C12629c.this.f58069a.asBinder().unlinkToDeath(C12629c.this.f58072d, 0);
                C12629c.this.f58069a = null;
            }
        }
    }

    public C12629c() {
        m76156h();
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // p558pu.InterfaceC12228c
    /* renamed from: g */
    public void mo73422g() {
        this.f58069a = null;
    }

    /* renamed from: h */
    public final void m76156h() {
        C8887d.m56508r().m56515f(new C8885c(new WeakReference(this)));
    }

    /* renamed from: i */
    public final void m76157i() throws RemoteException {
        IBinder iBinderM56513a = C8887d.m56508r().m56513a(6);
        if (iBinderM56513a == null) {
            throw new C12227b(2);
        }
        this.f58069a = WearEngineManager.AbstractBinderC8881a.m56497a(iBinderM56513a);
        this.f58069a.asBinder().linkToDeath(this.f58072d, 0);
    }

    /* renamed from: j */
    public final void m76158j(String str) {
        synchronized (this.f58071c) {
            try {
                if (this.f58069a == null) {
                    if (TextUtils.isEmpty(str)) {
                        C8887d.m56508r().m56523t();
                    } else {
                        C8887d.m56508r().m56520m(str);
                    }
                    m76157i();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.wearengine.WearEngineManager
    public int releaseConnection() {
        String str;
        try {
            try {
                try {
                    m76158j(null);
                    if (this.f58069a == null) {
                        throw new C12227b(6);
                    }
                    int iReleaseConnection = this.f58069a.releaseConnection();
                    if (iReleaseConnection != 0) {
                        C12860b.m77197a("WearEngineProxy", "releaseConnection failed, ret: " + iReleaseConnection);
                        str = "releaseConnection, result: " + C8887d.m56508r().m56522p();
                    } else {
                        iReleaseConnection = C8887d.m56508r().m56522p();
                        str = "releaseConnection, result: " + iReleaseConnection;
                    }
                    C12860b.m77203g("WearEngineProxy", str);
                    return iReleaseConnection;
                } catch (RemoteException unused) {
                    C12860b.m77197a("WearEngineProxy", "releaseConnection RemoteException");
                    throw new C12227b(12);
                }
            } catch (IllegalStateException e10) {
                throw C12227b.m73420b(e10);
            }
        } catch (Throwable th2) {
            C12860b.m77203g("WearEngineProxy", "releaseConnection, result: " + C8887d.m56508r().m56522p());
            throw th2;
        }
    }
}
