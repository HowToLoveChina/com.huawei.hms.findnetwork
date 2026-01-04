package com.huawei.openalliance.p169ad.utils;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.Arrays;

/* renamed from: com.huawei.openalliance.ad.utils.cd */
/* loaded from: classes2.dex */
public abstract class AbstractC7784cd {
    /* renamed from: a */
    private static int m47883a(Context context, String str, String str2, int i10, int i11) {
        String strPermissionToOp;
        try {
            if (-1 == context.checkPermission(str, i10, i11)) {
                return -1;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((applicationInfo != null && applicationInfo.targetSdkVersion > 23) || (strPermissionToOp = AppOpsManager.permissionToOp(str)) == null) {
                return 0;
            }
            if (TextUtils.isEmpty(str2)) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
                if (AbstractC7760bg.m47769a(packagesForUid)) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, str2) != 0 ? -2 : 0;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("PermissionUtil", "validatePermission " + th2.getClass().getSimpleName());
            return -1;
        }
    }

    /* renamed from: b */
    public static boolean m47889b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (!AbstractC7760bg.m47769a(strArr)) {
                    return Arrays.asList(strArr).contains(str);
                }
            } catch (Throwable unused) {
                AbstractC7185ho.m43817a("PermissionUtil", "get permission error");
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m47884a(Activity activity, String[] strArr, int i10) {
        if (m47885a()) {
            activity.requestPermissions(strArr, i10);
        }
    }

    /* renamed from: a */
    private static boolean m47885a() {
        return true;
    }

    /* renamed from: a */
    public static boolean m47886a(Context context) {
        return m47887a(context, Build.VERSION.SDK_INT > 30 ? "android.permission.BLUETOOTH_CONNECT" : "android.permission.BLUETOOTH");
    }

    /* renamed from: a */
    public static boolean m47887a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return m47883a(context, str, context.getPackageName(), Process.myPid(), Process.myUid()) == 0;
        }
        AbstractC7185ho.m43820b("PermissionUtil", "hasPermission Invalid Input Param");
        return false;
    }

    /* renamed from: a */
    public static boolean m47888a(Context context, String[] strArr) {
        boolean z10 = true;
        for (String str : strArr) {
            if (!m47887a(context, str)) {
                z10 = false;
            }
        }
        return z10;
    }
}
