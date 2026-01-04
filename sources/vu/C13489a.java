package vu;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.C8885c;
import com.huawei.wearengine.C8887d;
import com.huawei.wearengine.P2pManager;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.p2p.IdentityInfo;
import com.huawei.wearengine.p2p.MessageParcel;
import com.huawei.wearengine.p2p.MessageParcelExtra;
import com.huawei.wearengine.p2p.P2pPingCallback;
import com.huawei.wearengine.p2p.P2pSendCallback;
import com.huawei.wearengine.p2p.ReceiverCallback;
import java.lang.ref.WeakReference;
import p558pu.C12227b;
import p558pu.InterfaceC12228c;
import p752wu.C13640b;
import su.C12860b;

/* renamed from: vu.a */
/* loaded from: classes9.dex */
public class C13489a implements P2pManager, InterfaceC12228c {

    /* renamed from: d */
    public static volatile C13489a f60722d;

    /* renamed from: b */
    public final Object f60724b = new Object();

    /* renamed from: c */
    public IBinder.DeathRecipient f60725c = new a();

    /* renamed from: a */
    public P2pManager f60723a = null;

    /* renamed from: vu.a$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (C13489a.this.f60723a != null) {
                C13489a.this.f60723a.asBinder().unlinkToDeath(C13489a.this.f60725c, 0);
                C13489a.this.f60723a = null;
            }
        }
    }

    public C13489a() {
        m81176i();
    }

    /* renamed from: h */
    public static C13489a m81175h() {
        if (f60722d == null) {
            synchronized (C13489a.class) {
                try {
                    if (f60722d == null) {
                        f60722d = new C13489a();
                    }
                } finally {
                }
            }
        }
        return f60722d;
    }

    /* renamed from: i */
    private void m81176i() {
        C8887d.m56508r().m56515f(new C8885c(new WeakReference(this)));
    }

    /* renamed from: j */
    private void m81177j() {
        synchronized (this.f60724b) {
            try {
                if (this.f60723a == null) {
                    C8887d.m56508r().m56523t();
                    IBinder iBinderM56513a = C8887d.m56508r().m56513a(2);
                    if (iBinderM56513a == null) {
                        throw new C12227b(2);
                    }
                    P2pManager p2pManagerM56496a = P2pManager.AbstractBinderC8880a.m56496a(iBinderM56513a);
                    this.f60723a = p2pManagerM56496a;
                    p2pManagerM56496a.asBinder().linkToDeath(this.f60725c, 0);
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
        this.f60723a = null;
    }

    @Override // com.huawei.wearengine.P2pManager
    public int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback) {
        try {
            m81177j();
            P2pManager p2pManager = this.f60723a;
            if (p2pManager != null) {
                return p2pManager.ping(device, str, str2, p2pPingCallback);
            }
            return 6;
        } catch (RemoteException unused) {
            C12860b.m77197a("P2pServiceProxy", "ping RemoteException");
            return 12;
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    @Override // com.huawei.wearengine.P2pManager
    public int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i10) {
        try {
            m81177j();
            P2pManager p2pManager = this.f60723a;
            if (p2pManager != null) {
                return p2pManager.registerReceiver(device, identityInfo, identityInfo2, receiverCallback, i10);
            }
            return 6;
        } catch (RemoteException unused) {
            C12860b.m77197a("P2pServiceProxy", "registerReceiver RemoteException");
            return 12;
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    @Override // com.huawei.wearengine.P2pManager
    public int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
        try {
            m81177j();
            P2pManager p2pManager = this.f60723a;
            if (p2pManager != null) {
                return p2pManager.send(device, messageParcel, identityInfo, identityInfo2, p2pSendCallback);
            }
            return 6;
        } catch (RemoteException unused) {
            C12860b.m77197a("P2pServiceProxy", "send RemoteException");
            return 12;
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    @Override // com.huawei.wearengine.P2pManager
    public int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
        try {
            m81177j();
            if (!C13640b.m82013c("p2p_send_extra")) {
                C12860b.m77205i("P2pServiceProxy", "sendExtra health not support");
                return 14;
            }
            P2pManager p2pManager = this.f60723a;
            if (p2pManager != null) {
                return p2pManager.sendExtra(device, messageParcelExtra, identityInfo, identityInfo2, p2pSendCallback);
            }
            return 6;
        } catch (RemoteException unused) {
            C12860b.m77197a("P2pServiceProxy", "send RemoteException");
            return 12;
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }

    @Override // com.huawei.wearengine.P2pManager
    public int unregisterReceiver(ReceiverCallback receiverCallback, int i10) {
        try {
            m81177j();
            P2pManager p2pManager = this.f60723a;
            if (p2pManager != null) {
                return p2pManager.unregisterReceiver(receiverCallback, i10);
            }
            return 6;
        } catch (RemoteException unused) {
            C12860b.m77197a("P2pServiceProxy", "unregisterReceiver RemoteException");
            return 12;
        } catch (IllegalStateException e10) {
            throw C12227b.m73420b(e10);
        }
    }
}
