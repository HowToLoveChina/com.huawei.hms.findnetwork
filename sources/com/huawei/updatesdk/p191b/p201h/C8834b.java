package com.huawei.updatesdk.p191b.p201h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.download.utils.PackageUtils;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8782d;
import com.huawei.updatesdk.p177a.p178a.p183d.C8783e;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p197d.C8819d;
import com.huawei.updatesdk.p191b.p200g.C8832c;
import java.io.File;
import java.lang.reflect.Field;

/* renamed from: com.huawei.updatesdk.b.h.b */
/* loaded from: classes9.dex */
public class C8834b {

    /* renamed from: a */
    private static Integer f45181a = null;

    /* renamed from: b */
    private static boolean f45182b = false;

    /* renamed from: c */
    private static boolean f45183c = false;

    /* renamed from: d */
    private static Field f45184d;

    /* renamed from: com.huawei.updatesdk.b.h.b$b */
    public static class b implements Runnable {
        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            C8777a.m56026a("PackageManagerRunnable", "PackageManagerRunnable run!!!!");
            AbstractC8782d.m56040a(new File(C8819d.m56261b()));
        }
    }

    /* renamed from: a */
    private static int m56311a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(str2)) {
                return bundle.getInt(str2);
            }
        } catch (Exception e10) {
            C8774a.m56008a(PackageUtils.TAG, "getAgMetaData " + str2 + ": " + e10.toString());
        }
        return -1;
    }

    /* renamed from: b */
    public static int m56318b(String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageInfo packageInfo = C8793a.m56132c().m56133a().getPackageManager().getPackageInfo(str, 128);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("com.huawei.maple.flag")) ? 0 : 1;
        } catch (Exception unused) {
            C8777a.m56030d(PackageUtils.TAG, "getMapleStatus not found: " + str);
            return 0;
        }
    }

    /* renamed from: c */
    public static int m56322c(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            C8774a.m56009b(PackageUtils.TAG, "getMetaDataServiceType invalid arguments.");
            return -1;
        }
        int iM56311a = m56311a(context, str, "ag_service_type");
        C8774a.m56009b(PackageUtils.TAG, "UpdateSDK ag_service_type = " + iM56311a);
        return iM56311a;
    }

    /* renamed from: d */
    public static PackageInfo m56324d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 2097280);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: e */
    public static PackageInfo m56325e(Context context, String str) {
        PackageInfo packageInfoM56313a = m56313a(str, context);
        if (packageInfoM56313a == null) {
            packageInfoM56313a = new PackageInfo();
            packageInfoM56313a.packageName = str;
            packageInfoM56313a.versionName = "1.0";
            packageInfoM56313a.versionCode = 1;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            applicationInfo.targetSdkVersion = 19;
            packageInfoM56313a.applicationInfo = applicationInfo;
        }
        return C8783e.m56045a(packageInfoM56313a);
    }

    /* renamed from: f */
    public static int m56326f(Context context, String str) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            C8774a.m56009b(PackageUtils.TAG, "pkgName: " + str + ", versionCode: " + packageInfo.versionCode + ", versionName: " + packageInfo.versionName);
            return packageInfo.versionCode;
        } catch (Exception e10) {
            C8777a.m56030d(PackageUtils.TAG, "getVersioncode:" + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: g */
    public static boolean m56327g(Context context, String str) {
        return m56326f(context, str) > 0;
    }

    /* renamed from: h */
    public static boolean m56328h(Context context, String str) throws PackageManager.NameNotFoundException {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "isMetaDataSupport invalid arguments.";
        } else {
            int iM56311a = m56311a(context, str, "appgallery_support_function");
            C8774a.m56009b(PackageUtils.TAG, "UpdateSDK ag_support_function = " + iM56311a);
            if (iM56311a == -1) {
                iM56311a = 0;
            }
            z = (iM56311a & 2) == 2;
            str2 = "UpdateSDK isMetaDataSupport = " + z;
        }
        C8774a.m56009b(PackageUtils.TAG, str2);
        return z;
    }

    /* renamed from: i */
    public static boolean m56329i(Context context, String str) {
        return m56326f(context, str) >= 70203000 && m56330j(context, str);
    }

    /* renamed from: j */
    private static boolean m56330j(Context context, String str) {
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage(str);
        try {
            return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
        } catch (Exception e10) {
            C8774a.m56009b(PackageUtils.TAG, "isSupportToHiApp: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static int m56312a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if ((applicationInfo.flags & 1) == 0) {
            return 0;
        }
        return m56316a(applicationInfo) ? 1 : 2;
    }

    /* renamed from: b */
    private static Object m56319b(Context context, String str, String str2) {
        PackageInfo packageInfoM56324d;
        try {
            packageInfoM56324d = m56324d(context, str);
        } catch (Exception e10) {
            C8774a.m56008a(PackageUtils.TAG, "getAppMetaData " + str2 + ": " + e10.getMessage());
        }
        if (packageInfoM56324d == null) {
            C8774a.m56009b(PackageUtils.TAG, "getAppMetaData no packageInfo: " + str);
            return null;
        }
        ApplicationInfo applicationInfo = packageInfoM56324d.applicationInfo;
        if (applicationInfo == null) {
            C8774a.m56009b(PackageUtils.TAG, "getAppMetaData no applicationInfo: " + str);
            return null;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && bundle.containsKey(str2)) {
            return bundle.get(str2);
        }
        return null;
    }

    /* renamed from: c */
    public static Integer m56323c() throws ClassNotFoundException {
        String string;
        StringBuilder sb2;
        String str;
        if (f45182b) {
            return f45181a;
        }
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            f45181a = Integer.valueOf(cls.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(cls));
        } catch (ClassNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "isDelApp error ClassNotFoundException:";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            C8777a.m56026a(PackageUtils.TAG, string);
            f45182b = true;
            return f45181a;
        } catch (IllegalAccessException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "isDelApp error IllegalAccessException:";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            C8777a.m56026a(PackageUtils.TAG, string);
            f45182b = true;
            return f45181a;
        } catch (IllegalArgumentException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "isDelApp error IllegalArgumentException:";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            C8777a.m56026a(PackageUtils.TAG, string);
            f45182b = true;
            return f45181a;
        } catch (NoSuchFieldException e13) {
            e = e13;
            sb2 = new StringBuilder();
            str = "isDelApp error NoSuchFieldException:";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            C8777a.m56026a(PackageUtils.TAG, string);
            f45182b = true;
            return f45181a;
        } catch (Exception e14) {
            string = e14.toString();
            C8777a.m56026a(PackageUtils.TAG, string);
            f45182b = true;
            return f45181a;
        }
        f45182b = true;
        return f45181a;
    }

    /* renamed from: a */
    public static PackageInfo m56313a(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (Exception unused) {
            C8777a.m56030d(PackageUtils.TAG, "not found: " + str);
            return null;
        }
    }

    /* renamed from: b */
    public static String m56320b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C8774a.m56009b(PackageUtils.TAG, "getMetaDataDistRule invalid arguments.");
            return "";
        }
        Object objM56319b = m56319b(context, str, "ag_dist_rule");
        C8774a.m56009b(PackageUtils.TAG, "UpdateSDK ag_dist_rule = " + objM56319b);
        return objM56319b instanceof String ? (String) objM56319b : "";
    }

    /* renamed from: a */
    public static String m56314a(Context context, String str) {
        String installerPackageName;
        try {
            installerPackageName = context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            C8774a.m56009b(PackageUtils.TAG, "can not find installer pkg." + str);
            installerPackageName = null;
        }
        C8777a.m56029c(PackageUtils.TAG, "installer pkg: " + installerPackageName);
        return installerPackageName;
    }

    /* renamed from: b */
    public static Field m56321b() {
        if (f45183c) {
            return f45184d;
        }
        try {
            f45184d = ApplicationInfo.class.getField("hwFlags");
        } catch (NoSuchFieldException unused) {
            C8777a.m56026a(PackageUtils.TAG, "can not find hwFlags");
        }
        f45183c = true;
        return f45184d;
    }

    /* renamed from: a */
    public static void m56315a() {
        C8832c.f45172a.execute(new b());
    }

    /* renamed from: a */
    private static boolean m56316a(ApplicationInfo applicationInfo) throws ClassNotFoundException {
        StringBuilder sb2;
        int i10 = applicationInfo.flags;
        Integer numM56323c = m56323c();
        if (numM56323c != null && (i10 & numM56323c.intValue()) != 0) {
            return true;
        }
        Field fieldM56321b = m56321b();
        if (fieldM56321b == null) {
            return false;
        }
        try {
            return (fieldM56321b.getInt(applicationInfo) & 33554432) != 0;
        } catch (IllegalAccessException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("can not get hwflags");
            sb2.append(e.getMessage());
            C8777a.m56026a(PackageUtils.TAG, sb2.toString());
            return false;
        } catch (IllegalArgumentException e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append("can not get hwflags");
            sb2.append(e.getMessage());
            C8777a.m56026a(PackageUtils.TAG, sb2.toString());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m56317a(String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Context contextM56133a = C8793a.m56132c().m56133a();
        Uri uri = Uri.parse("content://" + str + ".commondata/item/7");
        if (!C8836d.m56341a(contextM56133a, uri, str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contextM56133a.getContentResolver().query(uri, null, str, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    z10 = Boolean.parseBoolean(cursorQuery.getString(0));
                }
            } catch (Exception e10) {
                C8774a.m56008a(PackageUtils.TAG, "getAgreeProtocolStatus : " + e10.getMessage());
            }
            return z10;
        } finally {
            C8836d.m56339a(cursorQuery);
        }
    }
}
