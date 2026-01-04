package com.huawei.wearengine;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.BinderService;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import p558pu.C12227b;
import p558pu.RunnableC12229d;
import p558pu.RunnableC12230e;
import p752wu.C13640b;
import p752wu.C13641c;
import ru.InterfaceC12627a;
import su.C12860b;

/* renamed from: com.huawei.wearengine.d */
/* loaded from: classes9.dex */
public class C8887d {

    /* renamed from: i */
    public static final Object f45272i = new Object();

    /* renamed from: j */
    public static final Object f45273j = new Object();

    /* renamed from: k */
    public static volatile C8887d f45274k;

    /* renamed from: d */
    public volatile InterfaceC12627a f45278d;

    /* renamed from: e */
    public volatile InterfaceC12627a f45279e;

    /* renamed from: a */
    public BinderService f45275a = null;

    /* renamed from: b */
    public List<b> f45276b = new CopyOnWriteArrayList();

    /* renamed from: c */
    public AtomicBoolean f45277c = new AtomicBoolean(false);

    /* renamed from: f */
    public ExecutorService f45280f = Executors.newSingleThreadExecutor();

    /* renamed from: g */
    public boolean f45281g = false;

    /* renamed from: h */
    public ServiceConnection f45282h = new a();

    /* renamed from: com.huawei.wearengine.d$a */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C8887d.this.f45275a = BinderService.AbstractBinderC8875a.m56491a(iBinder);
            C8887d.this.f45277c.getAndSet(true);
            C8887d.m56506o(C8887d.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C8887d.this.f45275a = null;
            C8887d.this.f45277c.getAndSet(false);
            synchronized (C8887d.f45273j) {
                C8887d.this.f45281g = true;
                C8887d.f45273j.notifyAll();
            }
            C8887d.m56507q(C8887d.this);
        }
    }

    /* renamed from: com.huawei.wearengine.d$b */
    public interface b {
        /* renamed from: a */
        void mo56499a();
    }

    /* renamed from: l */
    public static void m56505l(C8887d c8887d) {
        if (c8887d.f45278d != null) {
            c8887d.f45278d.mo76148b();
        }
        if (c8887d.f45279e != null) {
            c8887d.f45279e.mo76148b();
        }
    }

    /* renamed from: o */
    public static void m56506o(C8887d c8887d) {
        c8887d.f45280f.submit(new RunnableC12229d(c8887d));
    }

    /* renamed from: q */
    public static void m56507q(C8887d c8887d) {
        c8887d.f45280f.submit(new RunnableC12230e(c8887d));
    }

    /* renamed from: r */
    public static C8887d m56508r() {
        if (f45274k == null) {
            synchronized (C8887d.class) {
                try {
                    if (f45274k == null) {
                        f45274k = new C8887d();
                    }
                } finally {
                }
            }
        }
        return f45274k;
    }

    /* renamed from: s */
    public static void m56509s(C8887d c8887d) {
        if (c8887d.f45275a == null) {
            C12860b.m77205i("WearEngineClientInner", "checkPermissionIdentity mBinderService is null.");
            return;
        }
        BinderC8884b binderC8884b = new BinderC8884b(c8887d);
        Context contextM82014a = C13641c.m82014a();
        try {
            c8887d.f45275a.checkPermissionIdentity(C13641c.m82014a().getPackageName(), contextM82014a != null ? contextM82014a.getSharedPreferences("WearEngine_Permission_Identify_Store", 0).getString("WearEnginePermissionIdentity", "") : "", binderC8884b);
        } catch (RemoteException unused) {
            C12860b.m77197a("WearEngineClientInner", "clearPermissionData failed");
        }
    }

    /* renamed from: u */
    public static void m56510u(C8887d c8887d) {
        if (c8887d.f45275a != null) {
            BinderC8882a binderC8882a = new BinderC8882a(c8887d);
            try {
                c8887d.f45275a.registerToken(C13641c.m82014a().getPackageName(), binderC8882a);
            } catch (RemoteException unused) {
                C12860b.m77205i("WearEngineClientInner", "setClientToken failed");
            }
        }
    }

    /* renamed from: v */
    public static void m56511v(C8887d c8887d) throws PackageManager.NameNotFoundException {
        String str;
        c8887d.getClass();
        C12860b.m77203g("WearEngineClientInner", "exchangeApiLevel enter");
        if (c8887d.f45275a != null) {
            try {
                int iExchangeApiLevel = c8887d.f45275a.exchangeApiLevel(C13640b.m82011a());
                C12860b.m77203g("WearEngineClientInner", "exchangeApiLevel serviceApiLevel:" + iExchangeApiLevel);
                C13640b.m82012b(iExchangeApiLevel);
                return;
            } catch (RemoteException unused) {
                str = "exchangeApiLevel failed";
            }
        } else {
            str = "exchangeApiLevel mBinderService is null";
        }
        C12860b.m77205i("WearEngineClientInner", str);
    }

    /* renamed from: w */
    public static void m56512w(C8887d c8887d) {
        if (c8887d.f45278d != null) {
            c8887d.f45278d.mo76147a();
        }
        if (c8887d.f45279e != null) {
            c8887d.f45279e.mo76147a();
        }
    }

    /* renamed from: a */
    public IBinder m56513a(int i10) {
        if (this.f45275a != null) {
            try {
                return this.f45275a.getBinder(i10);
            } catch (RemoteException unused) {
                C12860b.m77205i("WearEngineClientInner", "queryBinder query failed");
                this.f45277c.getAndSet(false);
            }
        }
        C12860b.m77205i("WearEngineClientInner", "queryBinder failed something happened");
        return null;
    }

    /* renamed from: e */
    public final void m56514e(Uri uri) {
        PackageManager packageManager = C13641c.m82014a().getPackageManager();
        if (packageManager == null) {
            C12860b.m77197a("WearEngineClientInner", "verifyAppIdentity packageManager is null");
            throw new C12227b(12);
        }
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            C12860b.m77197a("WearEngineClientInner", "verifyAppIdentity providerInfo is null");
            return;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            C12860b.m77197a("WearEngineClientInner", "verifyAppIdentity packageManager is null");
            throw new C12227b(12);
        }
        String str = applicationInfo.packageName;
        C12860b.m77203g("WearEngineClientInner", "verifyAppIdentity provider service's package name is : " + str);
        if (str == null) {
            throw new C12227b(12);
        }
        if (!C13641c.m82021h(str)) {
            throw new C12227b(2);
        }
    }

    /* renamed from: f */
    public void m56515f(b bVar) {
        this.f45276b.add(bVar);
    }

    /* renamed from: g */
    public final void m56516g(String str, String str2) {
        if (Boolean.TRUE.toString().equals(str2)) {
            return;
        }
        if (str.equals("getBondedDevices") || str.equals("getAllBondedDevices") || str.equals("getCommonDevice")) {
            throw new C12227b(4);
        }
        if (str.equals("hasAvailableDevices")) {
            throw new C12227b(16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m56517i(java.lang.String r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "WearEngineClientInner"
            r1 = 1
            r2 = 0
            r10.m56521n()     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b
            java.lang.String r3 = "content://com.huawei.healthcloud.health.provider/wear_device_state/wearEngine"
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b
            r10.m56514e(r5)     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b
            android.content.Context r3 = p752wu.C13641c.m82014a()     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b
            android.content.ContentProviderClient r3 = r3.acquireUnstableContentProviderClient(r5)     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b
            if (r3 != 0) goto L2b
            java.lang.String r10 = "isAllowBindService contentProviderClient is null"
            su.C12860b.m77197a(r0, r10)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c
            if (r3 == 0) goto L28
            r3.close()
        L28:
            return r1
        L29:
            r10 = move-exception
            goto L8c
        L2b:
            r8 = 0
            r9 = 0
            r6 = 0
            r4 = r3
            r7 = r11
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            if (r2 == 0) goto L6d
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            if (r4 == 0) goto L6d
            java.lang.String r4 = "isAllowBindService"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            r5 = -1
            if (r4 != r5) goto L51
            java.lang.String r4 = "isAllowBindService columnIndex = -1"
            su.C12860b.m77205i(r0, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            goto L55
        L51:
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
        L55:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            java.lang.String r6 = "isAllowBindService = "
            r5.append(r6)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            r5.append(r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            su.C12860b.m77203g(r0, r5)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            r10.m56516g(r11, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
            goto L72
        L6d:
            java.lang.String r10 = "isAllowedBindService cursor is null or no result"
            su.C12860b.m77197a(r0, r10)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c java.lang.Throwable -> L7c
        L72:
            if (r2 == 0) goto L88
            r2.close()
            goto L88
        L78:
            r10 = move-exception
            r3 = r2
            goto L8c
        L7b:
            r3 = r2
        L7c:
            java.lang.String r10 = "isAllowedBindService query exception"
            su.C12860b.m77197a(r0, r10)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L86
            r2.close()
        L86:
            if (r3 == 0) goto L8b
        L88:
            r3.close()
        L8b:
            return r1
        L8c:
            if (r2 == 0) goto L91
            r2.close()
        L91:
            if (r3 == 0) goto L96
            r3.close()
        L96:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.C8887d.m56517i(java.lang.String):boolean");
    }

    /* renamed from: j */
    public final Intent m56518j(String str, String str2) {
        PackageManager packageManager = C13641c.m82014a().getPackageManager();
        if (packageManager == null) {
            C12860b.m77197a("WearEngineClientInner", "createExplicitIntent getPackageManager is null");
            throw new C12227b(12);
        }
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setClassName(str, str2);
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            C12860b.m77205i("WearEngineClientInner", "createExplicitIntent implicitIntent List are null");
            return null;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        String str3 = serviceInfo.packageName;
        String str4 = serviceInfo.name;
        if (!C13641c.m82021h(str3)) {
            C12860b.m77197a("WearEngineClientInner", "createExplicitIntent verifyAppIdentity failed");
            return null;
        }
        ComponentName componentName = new ComponentName(str3, str4);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    /* renamed from: k */
    public final void m56519k() {
        synchronized (f45272i) {
            try {
                Intent intentM56518j = m56518j("com.huawei.health", "com.huawei.wearengine.service.WearEngineExtendService");
                if (intentM56518j == null && (intentM56518j = m56518j("com.huawei.health", "com.huawei.wearengine.service.WearEngineService")) == null) {
                    throw new C12227b(2);
                }
                synchronized (f45273j) {
                    this.f45281g = false;
                    if (!C13641c.m82014a().bindService(intentM56518j, this.f45282h, Build.VERSION.SDK_INT >= 34 ? 549 : 37)) {
                        C12860b.m77197a("WearEngineClientInner", "bindToService do not has permission");
                        throw new C12227b(15);
                    }
                    while (!this.f45281g) {
                        try {
                            f45273j.wait(30000L);
                            this.f45281g = true;
                        } catch (InterruptedException unused) {
                            C12860b.m77197a("WearEngineClientInner", "bindToService wait error");
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public void m56520m(String str) {
        synchronized (f45272i) {
            try {
                if (this.f45275a != null) {
                    return;
                }
                if (m56517i(str)) {
                    m56519k();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public final void m56521n() {
        if (C13641c.m82014a() != null) {
            return;
        }
        C12860b.m77197a("WearEngineClientInner", "context is null");
        throw new C12227b(12);
    }

    /* renamed from: p */
    public int m56522p() {
        synchronized (f45272i) {
            try {
                if (this.f45277c.get()) {
                    C12860b.m77203g("WearEngineClientInner", "begin unbind WearEngineService");
                    try {
                        C13641c.m82014a().unbindService(this.f45282h);
                        this.f45277c.getAndSet(false);
                        this.f45275a = null;
                        Iterator<b> it = this.f45276b.iterator();
                        while (it.hasNext()) {
                            it.next().mo56499a();
                        }
                    } catch (IllegalArgumentException unused) {
                        C12860b.m77197a("WearEngineClientInner", "unBindService catch IllegalArgumentException");
                        return 12;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return 0;
    }

    /* renamed from: t */
    public void m56523t() {
        synchronized (f45272i) {
            try {
                if (this.f45275a != null) {
                    return;
                }
                m56519k();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
