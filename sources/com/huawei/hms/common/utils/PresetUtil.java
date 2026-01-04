package com.huawei.hms.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.List;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class PresetUtil {
    public static String getSystemAppPackage(Context context, Intent intent) {
        String str;
        if (context != null && intent != null) {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities.size() == 0) {
                return "";
            }
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (str = activityInfo.packageName) != null && (isSystemApp(context, str) || isPrivApp(context, str))) {
                    return str;
                }
            }
        }
        return "";
    }

    public static boolean isPrivApp(Context context, String str) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, IllegalArgumentException {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        if (context == null) {
            C12836o.m77099d("PresetUtil", "Invalid context.", true);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("PresetUtil", "Invalid pkgName.", true);
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e10) {
            C12836o.m77099d("PresetUtil", "getPrivAppFlag err for " + str + ":" + e10.getMessage(), true);
            packageInfo = null;
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            C12836o.m77097b("PresetUtil", "Get pkg application null:" + str, true);
            return false;
        }
        try {
            final Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.common.utils.PresetUtil.1
                @Override // java.security.PrivilegedAction
                public Object run() throws SecurityException {
                    field.setAccessible(true);
                    return null;
                }
            });
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                C12836o.m77097b("PresetUtil", "Get privFlag instance error.", true);
                return false;
            }
            int iIntValue = ((Integer) obj).intValue();
            C12836o.m77096a("PresetUtil", "privFlag of " + str + " is:" + iIntValue, true);
            return (iIntValue & 8) != 0;
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            C12836o.m77099d("PresetUtil", "getPrivAppFlag err for " + str + ":" + e11.getMessage(), true);
            return false;
        }
    }

    public static boolean isSystemApp(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        boolean z10 = false;
        if (context == null) {
            C12836o.m77099d("PresetUtil", "Invalid context.", true);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b("PresetUtil", "Invalid pkgName.", true);
            return false;
        }
        C12836o.m77096a("PresetUtil", "pkgName: " + str, true);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e10) {
            C12836o.m77099d("PresetUtil", "getSystemApp flag error for " + str + ":" + e10.getMessage(), true);
            packageInfo = null;
        }
        if (packageInfo != null && (packageInfo.applicationInfo.flags & 1) != 0) {
            z10 = true;
        }
        C12836o.m77096a("PresetUtil", "isSystemApp: " + z10, true);
        return z10;
    }
}
