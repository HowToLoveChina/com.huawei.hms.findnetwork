package com.huawei.fastengine.fastview.download.utils;

import android.content.Context;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public abstract class PackageManagerUtils {
    private static final String TAG = "PkgManageUtils";
    private static int isSystemApp = -1;

    public static boolean checkPermission(Context context, String str) {
        FastViewLogUtils.m28726i(TAG, "install checkPermission: start: ");
        int iCheckPermission = context.getPackageManager().checkPermission(str, context.getPackageName());
        if (iCheckPermission == 0) {
            return true;
        }
        FastViewLogUtils.m28724e(TAG, "no this permission, result = " + iCheckPermission);
        return false;
    }

    public static boolean hasInstallPermission(Context context) {
        return checkPermission(context, "android.permission.INSTALL_PACKAGES");
    }

    public static boolean systemApp(Context context) {
        FastViewLogUtils.m28726i(TAG, "install systemApp: " + isSystemApp);
        if (-1 == isSystemApp) {
            if (hasInstallPermission(context)) {
                isSystemApp = 1;
            } else {
                isSystemApp = 0;
            }
        }
        return isSystemApp == 1;
    }
}
