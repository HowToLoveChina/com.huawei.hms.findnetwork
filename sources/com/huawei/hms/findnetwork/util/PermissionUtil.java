package com.huawei.hms.findnetwork.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class PermissionUtil {
    public static boolean checkAppHavePermission(Context context, String str, String[] strArr) {
        if (context == null || TextUtils.isEmpty(str) || strArr == null) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        for (String str2 : strArr) {
            if (packageManager.checkPermission(str2, str) != 0) {
                return false;
            }
        }
        return true;
    }
}
