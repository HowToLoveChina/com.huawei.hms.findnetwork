package com.huawei.hicloud.cloudbackup.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.hicloud.cloudbackup.service.ICoreCallback;
import com.huawei.hicloud.cloudbackup.service.ICoreService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p430kl.C11061a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: com.huawei.hicloud.cloudbackup.service.a */
/* loaded from: classes6.dex */
public class C4877a {

    /* renamed from: g */
    public static final C4877a f22300g = new C4877a();

    /* renamed from: h */
    public static final Object f22301h = new Object();

    /* renamed from: a */
    public ICoreService f22302a;

    /* renamed from: b */
    public ServiceConnection f22303b;

    /* renamed from: c */
    public final List<Handler> f22304c = new ArrayList();

    /* renamed from: d */
    public boolean f22305d = false;

    /* renamed from: e */
    public boolean f22306e = false;

    /* renamed from: f */
    public ICoreCallback f22307f = new a();

    /* renamed from: com.huawei.hicloud.cloudbackup.service.a$a */
    public class a extends ICoreCallback.AbstractBinderC4874a {
        public a() {
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreCallback
        public void callback(int i10, int i11, int i12, Bundle bundle) throws RemoteException {
            for (Handler handler : C4877a.this.f22304c) {
                if (handler != null) {
                    handler.handleMessage(Message.obtain(null, i10, i11, i12, bundle));
                }
            }
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.service.a$b */
    public class b implements ServiceConnection {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f22309a;

        public b(CountDownLatch countDownLatch) {
            this.f22309a = countDownLatch;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C11839m.m70688i("CloudBackupCoreServiceManager", "cloud backup service bind isSuccess.");
            try {
                try {
                    if (C4877a.this.f22305d) {
                        C11839m.m70687e("CloudBackupCoreServiceManager", " service already connect.");
                    } else {
                        C4877a.this.f22302a = ICoreService.AbstractBinderC4876a.m29273a(iBinder);
                        C4877a.this.f22302a.registerCallback(C4877a.this.f22307f);
                        C11839m.m70688i("CloudBackupCoreServiceManager", " register callback isSuccess.");
                        C4877a.this.f22305d = true;
                    }
                } catch (RemoteException unused) {
                    C4877a.this.f22305d = false;
                }
                this.f22309a.countDown();
            } catch (Throwable th2) {
                this.f22309a.countDown();
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C11839m.m70687e("CloudBackupCoreServiceManager", "backup service disconnected.");
            C4877a.this.f22305d = false;
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.service.a$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f22311a;

        /* renamed from: b */
        public final /* synthetic */ String f22312b;

        /* renamed from: c */
        public final /* synthetic */ int f22313c;

        /* renamed from: d */
        public final /* synthetic */ int f22314d;

        public c(String str, String str2, int i10, int i11) {
            this.f22311a = str;
            this.f22312b = str2;
            this.f22313c = i10;
            this.f22314d = i11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C4877a.this.m29282h("restore")) {
                try {
                    C11839m.m70688i("CloudBackupCoreServiceManager", "service restore result: " + C4877a.this.f22302a.restore(this.f22311a, this.f22312b, this.f22313c, this.f22314d));
                } catch (RemoteException e10) {
                    C11839m.m70689w("CloudBackupCoreServiceManager", "restore remote exception: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.service.a$d */
    public class d extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f22316a;

        /* renamed from: b */
        public final /* synthetic */ String f22317b;

        /* renamed from: c */
        public final /* synthetic */ String f22318c;

        /* renamed from: d */
        public final /* synthetic */ int f22319d;

        /* renamed from: e */
        public final /* synthetic */ String f22320e;

        /* renamed from: f */
        public final /* synthetic */ String f22321f;

        public d(String str, String str2, String str3, int i10, String str4, String str5) {
            this.f22316a = str;
            this.f22317b = str2;
            this.f22318c = str3;
            this.f22319d = i10;
            this.f22320e = str4;
            this.f22321f = str5;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C4877a.this.m29282h("restore")) {
                try {
                    C11839m.m70688i("CloudBackupCoreServiceManager", "service restoreV3 result: " + C4877a.this.f22302a.restoreV3(this.f22316a, this.f22317b, this.f22318c, this.f22319d, this.f22320e, this.f22321f));
                } catch (RemoteException e10) {
                    C11839m.m70689w("CloudBackupCoreServiceManager", "restoreV3 remote exception: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.service.a$e */
    public class e extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ boolean f22323a;

        /* renamed from: b */
        public final /* synthetic */ boolean f22324b;

        /* renamed from: c */
        public final /* synthetic */ boolean f22325c;

        public e(boolean z10, boolean z11, boolean z12) {
            this.f22323a = z10;
            this.f22324b = z11;
            this.f22325c = z12;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C4877a.this.m29282h("restoreRetry")) {
                try {
                    int iRestoreRetry = C4877a.this.f22302a.restoreRetry(this.f22323a, this.f22324b, this.f22325c);
                    C11839m.m70688i("CloudBackupCoreServiceManager", "service restoreRetry result: " + iRestoreRetry);
                    if (iRestoreRetry == 0) {
                        CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33000));
                    }
                } catch (RemoteException e10) {
                    C11839m.m70689w("CloudBackupCoreServiceManager", "restoreRetry remote exception: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.service.a$f */
    public class f extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ boolean f22327a;

        /* renamed from: b */
        public final /* synthetic */ boolean f22328b;

        /* renamed from: c */
        public final /* synthetic */ boolean f22329c;

        public f(boolean z10, boolean z11, boolean z12) {
            this.f22327a = z10;
            this.f22328b = z11;
            this.f22329c = z12;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C4877a.this.m29282h("restoreRetry")) {
                try {
                    int iRestoreRetryV3 = C4877a.this.f22302a.restoreRetryV3(this.f22327a, this.f22328b, this.f22329c);
                    C11839m.m70688i("CloudBackupCoreServiceManager", "service restoreRetryV3 result: " + iRestoreRetryV3);
                    if (iRestoreRetryV3 == 0) {
                        CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33000));
                    }
                } catch (RemoteException e10) {
                    C11839m.m70689w("CloudBackupCoreServiceManager", "restoreRetryV3 remote exception: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: i */
    public static C4877a m29281i() {
        return f22300g;
    }

    /* renamed from: h */
    public final boolean m29282h(String str) {
        synchronized (f22301h) {
            try {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (this.f22305d) {
                    countDownLatch.countDown();
                } else {
                    m29283j(countDownLatch);
                    Context contextM1377a = C0213f.m1377a();
                    ComponentName componentName = new ComponentName(contextM1377a.getPackageName(), CloudBackupCoreService.class.getName());
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    intent.setAction("com.huawei.hicloud.cloudbackup.service.action");
                    if (!contextM1377a.bindService(intent, this.f22303b, 1)) {
                        countDownLatch.countDown();
                        C11839m.m70687e("CloudBackupCoreServiceManager", "bind cloud backup service failed." + str);
                        return false;
                    }
                }
                try {
                    if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
                        C11839m.m70686d("CloudBackupCoreServiceManager", "doBindService await false");
                    }
                } catch (InterruptedException e10) {
                    C11839m.m70689w("CloudBackupCoreServiceManager", "bind service wait interrupted." + e10);
                }
                if (!this.f22305d) {
                    return false;
                }
                if (this.f22302a != null) {
                    return true;
                }
                C11839m.m70689w("CloudBackupCoreServiceManager", "cloud backup service is null.");
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    public final void m29283j(CountDownLatch countDownLatch) {
        this.f22303b = new b(countDownLatch);
    }

    /* renamed from: k */
    public void m29284k(String str, String str2, int i10, int i11) {
        if (i11 == 1) {
            C11061a.m66672b(str, str2, i10, i11);
        } else {
            C12515a.m75110o().m75172d(new c(str, str2, i10, i11));
        }
    }

    /* renamed from: l */
    public void m29285l(boolean z10, boolean z11, boolean z12) {
        C12515a.m75110o().m75172d(new e(z10, z11, z12));
    }

    /* renamed from: m */
    public void m29286m(boolean z10, boolean z11, boolean z12) {
        C12515a.m75110o().m75172d(new f(z10, z11, z12));
    }

    /* renamed from: n */
    public void m29287n(String str, String str2, String str3, int i10, String str4, String str5) {
        if (i10 == 1) {
            C11061a.m66675e(str, str2, str3, i10, str4, str5);
        } else {
            C12515a.m75110o().m75172d(new d(str, str2, str3, i10, str4, str5));
        }
    }

    /* renamed from: o */
    public void m29288o() {
        this.f22304c.clear();
        if (this.f22305d && this.f22302a != null) {
            try {
                C11839m.m70688i("CloudBackupCoreServiceManager", "unbind cloud backup service.");
                this.f22302a.unregisterCallback(this.f22307f);
                if (this.f22303b != null) {
                    C0213f.m1377a().unbindService(this.f22303b);
                    this.f22305d = false;
                    if (this.f22306e) {
                        this.f22306e = false;
                    }
                    C11839m.m70688i("CloudBackupCoreServiceManager", "unbind cloud backup service isSuccess.");
                }
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupCoreServiceManager", "unregisterCallback error" + e10);
            }
        }
    }
}
