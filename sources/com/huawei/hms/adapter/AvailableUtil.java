package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.adapter.p116ui.UpdateAdapter;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AgHmsUpdateState;

/* loaded from: classes8.dex */
public class AvailableUtil {

    /* renamed from: a */
    private static final Object f23080a = new Object();

    /* renamed from: b */
    private static boolean f23081b = false;

    /* renamed from: c */
    private static boolean f23082c = false;

    /* renamed from: com.huawei.hms.adapter.AvailableUtil$a */
    public class RunnableC5052a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f23083a;

        public RunnableC5052a(Context context) {
            this.f23083a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m36988i("AvailableUtil", "enter asyncCheckHmsV3UpdateInfo");
            if (AvailableUtil.isInstallerLibExist(this.f23083a)) {
                UpdateAdapter.invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "checkHmsUpdateInfo", new Object[]{this.f23083a});
                HMSLog.m36988i("AvailableUtil", "quit asyncCheckHmsV3UpdateInfo");
            } else {
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                HMSLog.m36986e("AvailableUtil", "asyncCheckHmsV3UpdateInfo installer is not exist");
            }
        }
    }

    public static void asyncCheckHmsUpdateInfo(Context context) {
        if (HmsCheckedState.UNCHECKED != AgHmsUpdateState.getInstance().getCheckedState()) {
            HMSLog.m36988i("AvailableUtil", "asyncCheckHmsUpdateInfo, not need to check");
        } else {
            new Thread(new RunnableC5052a(context), "Thread-asyncCheckHmsV3UpdateInfo").start();
        }
    }

    public static boolean isInstallerLibExist(Context context) {
        Bundle bundle;
        Object obj;
        boolean z10;
        if (f23081b) {
            HMSLog.m36988i("AvailableUtil", "installerInit exist: " + f23082c);
            return f23082c;
        }
        synchronized (f23080a) {
            if (!f23081b) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.m36986e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z10 = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.m36986e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                    }
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("availableHMSCoreInstaller")) != null && String.valueOf(obj).equalsIgnoreCase("yes")) {
                            HMSLog.m36988i("AvailableUtil", "available exist: true");
                            z10 = true;
                        }
                    } catch (AndroidException unused2) {
                        HMSLog.m36986e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                    } catch (RuntimeException e10) {
                        HMSLog.m36987e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e10);
                    }
                    z10 = false;
                }
                f23082c = z10;
                f23081b = true;
            }
        }
        HMSLog.m36988i("AvailableUtil", "available exist: " + f23082c);
        return f23082c;
    }
}
