package com.huawei.appgallery.coreservice;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.api.ConnectConfig;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import com.huawei.appgallery.coreservice.internal.service.installhiapp.GuideInstallAppGallery;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.appmarket.framework.coreservice.DataHolder;
import com.huawei.appmarket.framework.coreservice.InterfaceC4584a;
import com.huawei.appmarket.framework.coreservice.InterfaceC4585b;
import com.huawei.appmarket.framework.coreservice.Status;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import p257eh.AbstractC9489k;
import p257eh.C9480b;
import p257eh.C9482d;
import p257eh.C9490l;
import p257eh.C9491m;
import p257eh.InterfaceC9481c;

/* renamed from: com.huawei.appgallery.coreservice.e */
/* loaded from: classes4.dex */
public class ServiceConnectionC4564e implements InterfaceC9481c, ServiceConnection {

    /* renamed from: i */
    public static AtomicInteger f20976i = new AtomicInteger(0);

    /* renamed from: a */
    public String f20977a;

    /* renamed from: b */
    public final Context f20978b;

    /* renamed from: d */
    public InterfaceC4585b f20980d;

    /* renamed from: g */
    public ConnectConfig f20983g;

    /* renamed from: c */
    public final Set<ApiClient.ConnectionCallback> f20979c = new HashSet();

    /* renamed from: e */
    public boolean f20981e = false;

    /* renamed from: f */
    public final AtomicInteger f20982f = new AtomicInteger();

    /* renamed from: h */
    public final ApiClient.ConnectionCallback f20984h = new a();

    /* renamed from: com.huawei.appgallery.coreservice.e$a */
    public class a implements ApiClient.ConnectionCallback {
        public a() {
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnected() {
            C9490l.m59349a("InnerApiClientImpl", "ConnectionCallback : onConnected()");
            Iterator it = ServiceConnectionC4564e.this.f20979c.iterator();
            while (it.hasNext()) {
                ((ApiClient.ConnectionCallback) it.next()).onConnected();
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionFailed(IConnectionResult iConnectionResult) {
            C9490l.m59349a("InnerApiClientImpl", "OnConnectionFailedListener : onConnectionFailed()");
            Iterator it = ServiceConnectionC4564e.this.f20979c.iterator();
            while (it.hasNext()) {
                ((ApiClient.ConnectionCallback) it.next()).onConnectionFailed(iConnectionResult);
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionSuspended(int i10) {
            C9490l.m59349a("InnerApiClientImpl", "ConnectionCallback : onConnectionSuspended()");
            Iterator it = ServiceConnectionC4564e.this.f20979c.iterator();
            while (it.hasNext()) {
                ((ApiClient.ConnectionCallback) it.next()).onConnectionSuspended(i10);
            }
        }
    }

    /* renamed from: com.huawei.appgallery.coreservice.e$b */
    public static class b implements Runnable {

        /* renamed from: a */
        public WeakReference<ServiceConnectionC4564e> f20986a;

        /* renamed from: b */
        public int f20987b;

        public b(ServiceConnectionC4564e serviceConnectionC4564e, int i10) {
            this.f20987b = i10;
            this.f20986a = new WeakReference<>(serviceConnectionC4564e);
        }

        @Override // java.lang.Runnable
        public void run() {
            ServiceConnectionC4564e serviceConnectionC4564e;
            WeakReference<ServiceConnectionC4564e> weakReference = this.f20986a;
            if (weakReference == null || (serviceConnectionC4564e = weakReference.get()) == null) {
                C9490l.m59352d("InnerApiClientImpl", "innerApiClient already null");
                return;
            }
            int i10 = this.f20987b;
            if (i10 != 1) {
                if (i10 == 2) {
                    serviceConnectionC4564e.m28052q();
                }
            } else {
                C9490l.m59352d("InnerApiClientImpl", "delay bind core service");
                try {
                    if (serviceConnectionC4564e.m28050o()) {
                        return;
                    }
                } catch (SecurityException e10) {
                    C9490l.m59350b("InnerApiClientImpl", "bindCoreService Execption", e10);
                }
                serviceConnectionC4564e.m28051p();
            }
        }
    }

    public ServiceConnectionC4564e(Context context) {
        this.f20978b = context;
    }

    /* renamed from: h */
    public static String m28037h(Context context) {
        String str;
        try {
            return new ServiceVerifyKit.C4580a().m28096e(context).m28098g(new Intent("com.huawei.appmarket.service.intent.ACTION_CORE_SERVICE"), ServiceVerifyKit.C4580a.a.SERVICE).m28092a("com.huawei.appmarket", "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212").m28092a("com.huawei.appmarket", "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F").m28093b();
        } catch (RuntimeException unused) {
            str = "get market pkg RuntimeException!";
            C9490l.m59351c("InnerApiClientImpl", str);
            return "";
        } catch (Exception unused2) {
            str = "get market pkg Exception!";
            C9490l.m59351c("InnerApiClientImpl", str);
            return "";
        }
    }

    /* renamed from: k */
    public static C9480b m28039k(Context context) {
        return new C9480b(4, GuideInstallAppGallery.m28058a(context));
    }

    @Override // p257eh.InterfaceC9481c
    /* renamed from: a */
    public void mo28042a(DataHolder dataHolder, InterfaceC4584a.a aVar) {
        try {
            InterfaceC4585b interfaceC4585b = this.f20980d;
            if (interfaceC4585b != null) {
                interfaceC4585b.mo28119a(dataHolder, aVar);
            } else if (aVar != null) {
                m28046f(aVar, "mTransportService is null");
            }
        } catch (RemoteException unused) {
            m28046f(aVar, "asyncCall RemoteExecption");
        }
    }

    /* renamed from: b */
    public String m28043b(Context context) {
        String str;
        try {
            return new ServiceVerifyKit.C4580a().m28096e(context).m28098g(new Intent(this.f20983g.getConnectServiceAction()), ServiceVerifyKit.C4580a.a.SERVICE).m28094c(this.f20983g.getAppSignCertchain()).m28095d(this.f20983g.getAppFingerprintSignature()).m28093b();
        } catch (RuntimeException unused) {
            str = "get market pkg RuntimeException!";
            C9490l.m59351c("InnerApiClientImpl", str);
            return "";
        } catch (Exception unused2) {
            str = "get market pkg Exception!";
            C9490l.m59351c("InnerApiClientImpl", str);
            return "";
        }
    }

    /* renamed from: d */
    public void m28044d() {
        C9490l.m59352d("InnerApiClientImpl", "disconnect()");
        this.f20982f.decrementAndGet();
        m28053r();
    }

    /* renamed from: e */
    public void m28045e(ConnectConfig connectConfig) {
        this.f20983g = connectConfig;
    }

    /* renamed from: f */
    public final void m28046f(InterfaceC4584a.a aVar, String str) {
        C9490l.m59351c("InnerApiClientImpl", "call Failed:" + str);
        try {
            aVar.call(new Status(4));
        } catch (RemoteException unused) {
            C9490l.m59351c("InnerApiClientImpl", str);
        }
    }

    /* renamed from: g */
    public void m28047g(Set<ApiClient.ConnectionCallback> set) {
        C9490l.m59352d("InnerApiClientImpl", "connect()");
        this.f20982f.incrementAndGet();
        this.f20981e = true;
        this.f20979c.addAll(set);
        if (m28054s()) {
            try {
                if (m28050o()) {
                    C9490l.m59352d("InnerApiClientImpl", "bind success!");
                    return;
                }
            } catch (SecurityException e10) {
                C9490l.m59350b("InnerApiClientImpl", "bind Execption", e10);
            }
            C9491m.m59354a(new b(this, 2), 200L);
        }
    }

    /* renamed from: i */
    public boolean m28048i() {
        InterfaceC4585b interfaceC4585b = this.f20980d;
        return interfaceC4585b != null && interfaceC4585b.asBinder().isBinderAlive();
    }

    /* renamed from: m */
    public boolean m28049m() {
        return this.f20981e;
    }

    /* renamed from: o */
    public final boolean m28050o() {
        if (TextUtils.isEmpty(this.f20977a)) {
            return false;
        }
        Intent intentM59331a = C9482d.m59331a(this.f20977a, this.f20983g);
        intentM59331a.putExtra("mediaPkg", this.f20978b.getPackageName());
        intentM59331a.putExtra(ParamConstants.Param.SDK_VERSION, 9);
        intentM59331a.setIdentifier(this.f20978b.getPackageName() + "-" + f20976i.getAndIncrement());
        return this.f20978b.bindService(intentM59331a, this, 1);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C9490l.m59352d("InnerApiClientImpl", "Enter onServiceConnected.");
        this.f20980d = InterfaceC4585b.a.m28121h(iBinder);
        this.f20984h.onConnected();
        this.f20981e = false;
        if (this.f20982f.get() <= 0) {
            C9490l.m59352d("InnerApiClientImpl", "service expect to unbind");
            m28053r();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C9490l.m59352d("InnerApiClientImpl", "Enter onServiceDisconnected.");
        this.f20980d = null;
        this.f20981e = false;
        this.f20984h.onConnectionSuspended(1);
    }

    /* renamed from: p */
    public final void m28051p() {
        this.f20981e = false;
        this.f20984h.onConnectionFailed(new C9480b(2));
    }

    /* renamed from: q */
    public final void m28052q() {
        try {
            C9490l.m59352d("InnerApiClientImpl", "start transparent activity");
            Intent intent = new Intent();
            intent.setAction("com.huawei.appmarket.intent.coreservice.LAUNCH_APP");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(this.f20977a);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            this.f20978b.startActivity(intent);
            C9491m.m59354a(new b(this, 1), 200L);
        } catch (ActivityNotFoundException unused) {
            C9490l.m59351c("InnerApiClientImpl", "transparent activity not found!");
            m28051p();
        }
    }

    /* renamed from: r */
    public final void m28053r() {
        this.f20981e = false;
        try {
            if (m28048i()) {
                this.f20978b.unbindService(this);
            } else {
                C9490l.m59352d("InnerApiClientImpl", "service does not connected");
            }
            this.f20980d = null;
        } catch (IllegalArgumentException e10) {
            C9490l.m59351c("InnerApiClientImpl", e10.toString());
        }
    }

    /* renamed from: s */
    public final boolean m28054s() {
        this.f20977a = this.f20983g != null ? m28043b(this.f20978b) : m28037h(this.f20978b);
        if (TextUtils.isEmpty(this.f20977a)) {
            C9490l.m59351c("InnerApiClientImpl", "can not found AppGallery or invalid sign");
            this.f20981e = false;
            ConnectConfig connectConfig = this.f20983g;
            this.f20984h.onConnectionFailed(new C9480b(4, connectConfig != null ? GuideInstallAppGallery.m28059b(this.f20978b, connectConfig, this.f20977a) : GuideInstallAppGallery.m28058a(this.f20978b)));
            return false;
        }
        try {
            if (AbstractC9489k.m59348a(this.f20978b.getPackageManager().getPackageInfo(this.f20977a, 128))) {
                return true;
            }
            C9490l.m59351c("InnerApiClientImpl", "unsupport agd");
            this.f20981e = false;
            ConnectConfig connectConfig2 = this.f20983g;
            this.f20984h.onConnectionFailed(new C9480b(7, connectConfig2 != null ? GuideInstallAppGallery.m28059b(this.f20978b, connectConfig2, this.f20977a) : GuideInstallAppGallery.m28058a(this.f20978b)));
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C9490l.m59351c("InnerApiClientImpl", "can not found AppGallery");
            this.f20981e = false;
            ConnectConfig connectConfig3 = this.f20983g;
            this.f20984h.onConnectionFailed(new C9480b(4, connectConfig3 != null ? GuideInstallAppGallery.m28059b(this.f20978b, connectConfig3, this.f20977a) : GuideInstallAppGallery.m28058a(this.f20978b)));
            return false;
        }
    }
}
