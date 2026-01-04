package p015ak;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import p399jk.AbstractC10896a;

/* renamed from: ak.y */
/* loaded from: classes6.dex */
public class C0240y {
    /* renamed from: a */
    public static String m1679a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        if (context == null) {
            AbstractC10896a.m65886e("PackageUtil", "getMetaName context is null");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            AbstractC10896a.m65886e("PackageUtil", "getMetaName pm is null");
            return "";
        }
        Object obj = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 128);
            if (packageInfo == null) {
                AbstractC10896a.m65886e("PackageUtil", "getMetaName packageInfo is null!");
            } else {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    obj = applicationInfo.metaData.get(str2);
                }
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            AbstractC10896a.m65886e("PackageUtil", "getPackageInfo exception!");
        }
        return obj != null ? obj.toString() : "";
    }

    /* renamed from: b */
    public static String m1680b(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return "1100";
        }
    }

    /* renamed from: c */
    public static String m1681c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 16384).versionName;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return "";
    }

    /* renamed from: d */
    public static boolean m1682d(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null) {
            AbstractC10896a.m65886e("PackageUtil", "isApkExist context == null");
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            AbstractC10896a.m65886e("PackageUtil", "isApkExist NameNotFoundException");
            return false;
        }
    }
}
