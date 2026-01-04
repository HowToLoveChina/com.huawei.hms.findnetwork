package p660tu;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.wearengine.C8885c;
import com.huawei.wearengine.C8887d;
import com.huawei.wearengine.DeviceManager;
import com.huawei.wearengine.device.Device;
import java.lang.ref.WeakReference;
import java.util.List;
import p558pu.C12227b;
import p558pu.InterfaceC12228c;
import p752wu.C13640b;
import su.C12860b;

/* renamed from: tu.b */
/* loaded from: classes9.dex */
public class C13072b implements DeviceManager, InterfaceC12228c {

    /* renamed from: d */
    public static volatile C13072b f59480d;

    /* renamed from: b */
    public final Object f59482b = new Object();

    /* renamed from: c */
    public IBinder.DeathRecipient f59483c = new a();

    /* renamed from: a */
    public DeviceManager f59481a = null;

    /* renamed from: tu.b$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (C13072b.this.f59481a != null) {
                C13072b.this.f59481a.asBinder().unlinkToDeath(C13072b.this.f59483c, 0);
                C13072b.this.f59481a = null;
            }
        }
    }

    public C13072b() {
        m78844i();
    }

    /* renamed from: h */
    public static C13072b m78843h() {
        if (f59480d == null) {
            synchronized (C13072b.class) {
                try {
                    if (f59480d == null) {
                        f59480d = new C13072b();
                    }
                } finally {
                }
            }
        }
        return f59480d;
    }

    /* renamed from: i */
    private void m78844i() {
        C8887d.m56508r().m56515f(new C8885c(new WeakReference(this)));
    }

    /* renamed from: k */
    private void m78845k(String str) {
        synchronized (this.f59482b) {
            try {
                if (this.f59481a == null) {
                    if (TextUtils.isEmpty(str)) {
                        C8887d.m56508r().m56523t();
                    } else {
                        C8887d.m56508r().m56520m(str);
                    }
                    m78846j();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // p558pu.InterfaceC12228c
    /* renamed from: g */
    public void mo73422g() {
        this.f59481a = null;
    }

    @Override // com.huawei.wearengine.DeviceManager
    public List<Device> getBondedDeviceEx() {
        try {
            m78845k(null);
            DeviceManager deviceManager = this.f59481a;
            if (deviceManager != null) {
                return deviceManager.getBondedDeviceEx();
            }
            throw new C12227b(6);
        } catch (RemoteException unused) {
            C12860b.m77197a("DeviceServiceProxy", "getBondedDeviceEx RemoteException");
            throw new C12227b(12);
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    @Override // com.huawei.wearengine.DeviceManager
    public List<Device> getBondedDevices() {
        try {
            m78845k("getBondedDevices");
            if (this.f59481a != null) {
                return C13640b.m82013c("device_get_bonded_device_ex") ? getBondedDeviceEx() : this.f59481a.getBondedDevices();
            }
            throw new C12227b(6);
        } catch (RemoteException unused) {
            C12860b.m77197a("DeviceServiceProxy", "getBondedDevices RemoteException");
            throw new C12227b(12);
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    @Override // com.huawei.wearengine.DeviceManager
    public boolean hasAvailableDevices() {
        try {
            m78845k("hasAvailableDevices");
            DeviceManager deviceManager = this.f59481a;
            if (deviceManager != null) {
                return deviceManager.hasAvailableDevices();
            }
            throw new C12227b(6);
        } catch (RemoteException unused) {
            C12860b.m77197a("DeviceServiceProxy", "hasAvailableDevices RemoteException");
            throw new C12227b(12);
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        } catch (C12227b e11) {
            if (e11.m73421c() == 16) {
                return false;
            }
            throw e11;
        }
    }

    /* renamed from: j */
    public final void m78846j() throws RemoteException {
        IBinder iBinderM56513a = C8887d.m56508r().m56513a(1);
        if (iBinderM56513a == null) {
            throw new C12227b(2);
        }
        DeviceManager deviceManagerM56493a = DeviceManager.AbstractBinderC8877a.m56493a(iBinderM56513a);
        this.f59481a = deviceManagerM56493a;
        deviceManagerM56493a.asBinder().linkToDeath(this.f59483c, 0);
    }
}
