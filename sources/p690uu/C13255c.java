package p690uu;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.C8885c;
import com.huawei.wearengine.C8887d;
import com.huawei.wearengine.MonitorManager;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorData;
import com.huawei.wearengine.monitor.MonitorItem;
import java.lang.ref.WeakReference;
import p558pu.C12227b;
import p558pu.InterfaceC12228c;
import p752wu.C13640b;
import su.C12860b;

/* renamed from: uu.c */
/* loaded from: classes9.dex */
public class C13255c implements MonitorManager, InterfaceC12228c {

    /* renamed from: b */
    public final Object f59950b = new Object();

    /* renamed from: c */
    public IBinder.DeathRecipient f59951c = new a();

    /* renamed from: a */
    public MonitorManager f59949a = null;

    /* renamed from: uu.c$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (C13255c.this.f59949a != null) {
                C13255c.this.f59949a.asBinder().unlinkToDeath(C13255c.this.f59951c, 0);
                C13255c.this.f59949a = null;
            }
        }
    }

    public C13255c() {
        m79653h();
    }

    /* renamed from: h */
    private void m79653h() {
        C8887d.m56508r().m56515f(new C8885c(new WeakReference(this)));
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    /* renamed from: d */
    public final boolean m79654d(MonitorItem monitorItem) {
        if (!monitorItem.m56557a().equals(MonitorItem.f45316k.m56557a()) || C13640b.m82013c("powerMode")) {
            return C13640b.m82013c("monitor_query");
        }
        return false;
    }

    @Override // p558pu.InterfaceC12228c
    /* renamed from: g */
    public void mo73422g() {
        this.f59949a = null;
    }

    /* renamed from: i */
    public final void m79655i() {
        synchronized (this.f59950b) {
            try {
                if (this.f59949a == null) {
                    C8887d.m56508r().m56523t();
                    IBinder iBinderM56513a = C8887d.m56508r().m56513a(3);
                    if (iBinderM56513a == null) {
                        throw new C12227b(2);
                    }
                    MonitorManager monitorManagerM56495a = MonitorManager.AbstractBinderC8879a.m56495a(iBinderM56513a);
                    this.f59949a = monitorManagerM56495a;
                    monitorManagerM56495a.asBinder().linkToDeath(this.f59951c, 0);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.wearengine.MonitorManager
    public MonitorData query(Device device, MonitorItem monitorItem) {
        try {
            m79655i();
            if (this.f59949a == null) {
                throw new C12227b(6);
            }
            if (m79654d(monitorItem)) {
                return this.f59949a.query(device, monitorItem);
            }
            C12860b.m77197a("MonitorServiceProxy", "query Health version is low");
            throw new C12227b(14);
        } catch (RemoteException unused) {
            C12860b.m77197a("MonitorServiceProxy", "send RemoteException");
            throw new C12227b(12);
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }
}
