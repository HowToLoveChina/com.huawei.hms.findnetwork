package p591qu;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.AuthManager;
import com.huawei.wearengine.C8885c;
import com.huawei.wearengine.C8887d;
import com.huawei.wearengine.auth.Permission;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p558pu.C12227b;
import p558pu.InterfaceC12228c;
import p752wu.C13640b;
import su.C12860b;

/* renamed from: qu.b */
/* loaded from: classes9.dex */
public class C12416b implements InterfaceC12228c {

    /* renamed from: e */
    public static volatile C12416b f57245e;

    /* renamed from: b */
    public final Object f57247b = new Object();

    /* renamed from: c */
    public final String[] f57248c = {Permission.f45266e.m56498a(), Permission.f45267f.m56498a(), Permission.f45268g.m56498a()};

    /* renamed from: d */
    public IBinder.DeathRecipient f57249d = new a();

    /* renamed from: a */
    public volatile AuthManager f57246a = null;

    /* renamed from: qu.b$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (C12416b.this.f57246a != null) {
                C12416b.this.f57246a.asBinder().unlinkToDeath(C12416b.this.f57249d, 0);
                C12416b.m74553b(C12416b.this, null);
            }
        }
    }

    public C12416b() {
        m74557f();
    }

    /* renamed from: b */
    public static /* synthetic */ AuthManager m74553b(C12416b c12416b, AuthManager authManager) {
        c12416b.f57246a = null;
        return null;
    }

    /* renamed from: c */
    public static C12416b m74554c() {
        if (f57245e == null) {
            synchronized (C12416b.class) {
                try {
                    if (f57245e == null) {
                        f57245e = new C12416b();
                    }
                } finally {
                }
            }
        }
        return f57245e;
    }

    /* renamed from: d */
    public boolean m74556d(Permission permission) {
        try {
            m74559i();
            if (!m74558h(new Permission[]{permission})) {
                throw new C12227b(14);
            }
            if (this.f57246a != null) {
                return this.f57246a.checkPermission(permission);
            }
            throw new C12227b(6);
        } catch (RemoteException unused) {
            C12860b.m77197a("AuthServiceProxy", "checkPermission RemoteException");
            throw new C12227b(12);
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    /* renamed from: f */
    public final void m74557f() {
        C8887d.m56508r().m56515f(new C8885c(new WeakReference(this)));
    }

    @Override // p558pu.InterfaceC12228c
    /* renamed from: g */
    public void mo73422g() {
        this.f57246a = null;
    }

    /* renamed from: h */
    public final boolean m74558h(Permission[] permissionArr) {
        C12860b.m77201e(permissionArr, "isSupportPermissions permissions can not be null.");
        for (Permission permission : permissionArr) {
            C12860b.m77201e(permission, "isSupportPermissions permission can not be null.");
            if (Arrays.asList(this.f57248c).contains(permission.m56498a()) && !C13640b.m82013c(permission.m56498a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public final void m74559i() {
        synchronized (this.f57247b) {
            try {
                if (this.f57246a == null) {
                    C8887d.m56508r().m56523t();
                    IBinder iBinderM56513a = C8887d.m56508r().m56513a(5);
                    if (iBinderM56513a == null) {
                        C12860b.m77205i("AuthServiceProxy", "binder == null");
                        throw new C12227b(2);
                    }
                    this.f57246a = AuthManager.AbstractBinderC8873a.m56488a(iBinderM56513a);
                    this.f57246a.asBinder().linkToDeath(this.f57249d, 0);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
