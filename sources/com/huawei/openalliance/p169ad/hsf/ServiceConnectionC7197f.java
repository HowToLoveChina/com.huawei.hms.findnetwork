package com.huawei.openalliance.p169ad.hsf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.hsf.AbstractC7196e;
import com.huawei.openalliance.p169ad.hsf.InterfaceC7193b;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.openalliance.ad.hsf.f */
/* loaded from: classes2.dex */
public class ServiceConnectionC7197f extends AbstractC7196e implements ServiceConnection {

    /* renamed from: a */
    private final Context f33123a;

    /* renamed from: b */
    private final AbstractC7196e.a f33124b;

    /* renamed from: d */
    private volatile InterfaceC7193b f33126d;

    /* renamed from: c */
    private final List<PPSHsfService> f33125c = new ArrayList();

    /* renamed from: e */
    private AtomicInteger f33127e = new AtomicInteger(1);

    public ServiceConnectionC7197f(Context context, AbstractC7196e.a aVar) {
        this.f33123a = context;
        this.f33124b = aVar;
    }

    /* renamed from: a */
    private static int m43871a(int i10) {
        if (i10 != -2) {
            return i10 != 0 ? 4 : 0;
        }
        return 8;
    }

    /* renamed from: b */
    private void m43873b(String str) {
        String str2;
        try {
            Intent intent = new Intent("com.huawei.android.hsf.service.CoreService");
            intent.setPackage(str);
            if (!C6982bz.m41152b(this.f33123a)) {
                String strM48435e = C7830i.m48435e(this.f33123a, str);
                boolean zIsEmpty = TextUtils.isEmpty(strM48435e);
                AbstractC7185ho.m43821b("PPSHsfApiImpl", "is sign empty: %s", Boolean.valueOf(zIsEmpty));
                if (!zIsEmpty && !WhiteListPkgList.isTrustApp(this.f33123a, str, strM48435e)) {
                    return;
                }
            }
            boolean zBindService = this.f33123a.bindService(intent, this, 1);
            AbstractC7185ho.m43821b("PPSHsfApiImpl", "bindCoreService: %s", Boolean.valueOf(zBindService));
            if (zBindService) {
                return;
            }
            this.f33127e.set(1);
            this.f33124b.mo43857b(5);
        } catch (SecurityException unused) {
            str2 = "bindService SecurityException";
            AbstractC7185ho.m43823c("PPSHsfApiImpl", str2);
            this.f33127e.set(1);
            this.f33124b.mo43857b(5);
        } catch (Exception e10) {
            str2 = "bindService " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("PPSHsfApiImpl", str2);
            this.f33127e.set(1);
            this.f33124b.mo43857b(5);
        }
    }

    /* renamed from: c */
    public final Context m43875c() {
        return this.f33123a;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f33126d = InterfaceC7193b.a.m43864a(iBinder);
            if (this.f33126d != null && "com.huawei.hsf.internal.CoreService".equals(componentName.getClassName())) {
                int iM43872a = m43872a(this.f33126d);
                if (iM43872a == 0) {
                    this.f33127e.set(3);
                    this.f33124b.mo43854a();
                    return;
                } else {
                    this.f33127e.set(1);
                    this.f33124b.mo43857b(iM43872a);
                    this.f33123a.unbindService(this);
                    return;
                }
            }
            AbstractC7185ho.m43826d("PPSHsfApiImpl", "Maybe mCoreService is null or illegal.");
            this.f33123a.unbindService(this);
            this.f33127e.set(1);
            this.f33124b.mo43857b(4);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSHsfApiImpl", "PPSHsfApi Service, service error: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f33127e.set(1);
        synchronized (this.f33125c) {
            this.f33125c.clear();
        }
        this.f33126d = null;
        this.f33124b.mo43855a(1);
    }

    /* renamed from: a */
    private int m43872a(InterfaceC7193b interfaceC7193b) {
        int iM43871a;
        if (interfaceC7193b == null) {
            return 4;
        }
        try {
            synchronized (this.f33125c) {
                this.f33125c.clear();
                iM43871a = m43871a(interfaceC7193b.mo43863a(this.f33123a.getPackageName(), this.f33125c));
            }
            return iM43871a;
        } catch (RemoteException unused) {
            AbstractC7185ho.m43826d("PPSHsfApiImpl", "Failed to call remote interface for querying the HSF services.");
            return 4;
        }
    }

    @Override // com.huawei.openalliance.p169ad.hsf.AbstractC7196e
    /* renamed from: b */
    public boolean mo43870b() {
        return this.f33127e.get() == 3;
    }

    @Override // com.huawei.openalliance.p169ad.hsf.InterfaceC7198g
    /* renamed from: a */
    public PPSHsfService mo43874a(String str) {
        PPSHsfService pPSHsfService = null;
        if (this.f33127e.get() != 3) {
            return null;
        }
        synchronized (this.f33125c) {
            try {
                for (PPSHsfService pPSHsfService2 : this.f33125c) {
                    if (str.equals(pPSHsfService2.m43842a())) {
                        pPSHsfService = pPSHsfService2;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return pPSHsfService;
    }

    @Override // com.huawei.openalliance.p169ad.hsf.AbstractC7196e
    /* renamed from: a */
    public void mo43869a() {
        if (this.f33127e.get() != 1) {
            if (this.f33127e.get() == 3) {
                this.f33124b.mo43854a();
                return;
            }
            return;
        }
        Context contextM43875c = m43875c();
        String str = Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE;
        PackageInfo packageInfoM48427b = C7830i.m48427b(contextM43875c, Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE);
        if (packageInfoM48427b == null) {
            Context contextM43875c2 = m43875c();
            str = Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE_NEW;
            packageInfoM48427b = C7830i.m48427b(contextM43875c2, Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE_NEW);
        }
        if (packageInfoM48427b == null) {
            this.f33124b.mo43857b(1);
        } else {
            this.f33127e.set(2);
            m43873b(str);
        }
    }
}
