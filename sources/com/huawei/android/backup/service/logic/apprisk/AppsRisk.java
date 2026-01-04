package com.huawei.android.backup.service.logic.apprisk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.packageinstaller.aidl.AppInfo;
import com.android.packageinstaller.aidl.IQueryAppsRiskService;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AppsRisk {

    /* renamed from: a */
    public Context f9589a;

    /* renamed from: b */
    public IQueryAppsRiskService f9590b = null;

    /* renamed from: c */
    public int f9591c = 0;

    /* renamed from: d */
    public ServiceConnection f9592d = new ServiceConnectionC2125a();

    /* renamed from: com.huawei.android.backup.service.logic.apprisk.AppsRisk$a */
    public class ServiceConnectionC2125a implements ServiceConnection {
        public ServiceConnectionC2125a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2111d.m12653i("AppsRisk", "apprisk service is connected");
            AppsRisk.this.f9590b = IQueryAppsRiskService.AbstractBinderC1514a.m8616a(iBinder);
            AppsRisk.this.f9591c = 1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C2111d.m12653i("AppsRisk", "apprisk service is disconnected");
            AppsRisk.this.f9590b = null;
            AppsRisk.this.f9591c = -1;
        }
    }

    public AppsRisk(Context context) {
        this.f9589a = null;
        this.f9589a = context;
    }

    /* renamed from: c */
    public final boolean m12757c() {
        C2111d.m12646b("AppsRisk", "start to bind to apkInstaller service");
        if (this.f9589a == null) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(Constants.SYSTEM_PKG_INSTALLER);
            intent.setAction("com.android.packageinstaller.aidl.action.QUERY_APPS_RISK");
            return this.f9589a.bindService(intent, this.f9592d, 1);
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("AppsRisk", "bindToService IllegalArgumentException ERROR!");
            return false;
        } catch (SecurityException unused2) {
            C2111d.m12648d("AppsRisk", "bindToService SecurityException");
            return false;
        }
    }

    /* renamed from: d */
    public void m12758d() {
        this.f9591c = 0;
        m12761g();
    }

    /* renamed from: e */
    public Map<String, Integer> m12759e(List<AppInfo> list) {
        HashMap map = new HashMap();
        IQueryAppsRiskService iQueryAppsRiskService = this.f9590b;
        if (iQueryAppsRiskService == null) {
            return map;
        }
        try {
            return iQueryAppsRiskService.getAppsRiskEx(list, false);
        } catch (RemoteException unused) {
            C2111d.m12648d("AppsRisk", "getAppsRisk failed.");
            return map;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        com.huawei.android.backup.filelogic.utils.C2111d.m12648d("AppsRisk", "initAppsRisk timeout.");
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12760f() throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.lang.String r0 = "AppsRisk"
            boolean r1 = r7.m12757c()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r2
        Lb:
            int r3 = r7.f9591c
            r4 = 1
            if (r3 != 0) goto L29
            r5 = 100
            java.lang.Thread.sleep(r5)     // Catch: java.lang.InterruptedException -> L24
            int r1 = r1 + r4
            r3 = 50
            if (r1 != r3) goto Lb
            int r3 = r7.f9591c     // Catch: java.lang.InterruptedException -> L24
            if (r3 != 0) goto Lb
            java.lang.String r1 = "initAppsRisk timeout."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.InterruptedException -> L24
            goto L29
        L24:
            java.lang.String r1 = "initAppsRisk InterruptedException."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)
        L29:
            int r7 = r7.f9591c
            if (r7 != r4) goto L2e
            r2 = r4
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.apprisk.AppsRisk.m12760f():boolean");
    }

    /* renamed from: g */
    public final void m12761g() {
        Context context;
        if (this.f9590b == null || (context = this.f9589a) == null) {
            return;
        }
        try {
            context.unbindService(this.f9592d);
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("AppsRisk", "unbindToService IllegalArgumentException");
        }
    }
}
