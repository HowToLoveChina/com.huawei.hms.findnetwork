package com.huawei.hms.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* loaded from: classes8.dex */
public class SystemUtils {
    public static final String PRODUCT_BRAND = "ro.product.brand";
    public static final String PRODUCT_HONOR = "HONOR";
    public static final String PRODUCT_HUAWEI = "HUAWEI";
    public static final String UNKNOWN = "unknown";

    /* renamed from: a */
    private static String m30559a() {
        return getSystemProperties("ro.product.locale", "");
    }

    /* renamed from: b */
    private static String m30560b() {
        return getSystemProperties(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties("ro.build.version.release", "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static String getManufacturer() {
        return getSystemProperties("ro.product.manufacturer", "unknown");
    }

    public static long getMegabyte(double d10) {
        return (long) (d10 * 1000.0d * 1000.0d);
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? "" : activeNetworkInfo.getTypeName();
    }

    public static String getPhoneModel() {
        return getSystemProperties("ro.product.model", "unknown");
    }

    public static String getSystemProperties(String str, String str2) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m36986e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    @Deprecated
    public static boolean isChinaROM() {
        String strM30560b = m30560b();
        if (!TextUtils.isEmpty(strM30560b)) {
            return "cn".equalsIgnoreCase(strM30560b);
        }
        String strM30559a = m30559a();
        if (!TextUtils.isEmpty(strM30559a)) {
            return strM30559a.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (TextUtils.isEmpty(localCountry)) {
            return false;
        }
        return "cn".equalsIgnoreCase(localCountry);
    }

    public static boolean isEMUI() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("is Emui :");
        int i10 = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb2.append(i10);
        HMSLog.m36988i("SystemUtils", sb2.toString());
        return i10 > 0;
    }

    public static boolean isHuawei() throws ClassNotFoundException {
        String systemProperties = getSystemProperties(PRODUCT_BRAND, "unknown");
        return "HUAWEI".equalsIgnoreCase(systemProperties) || "HONOR".equalsIgnoreCase(systemProperties);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSystemApp(android.content.Context r3, java.lang.String r4) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r0 = 0
            java.lang.String r1 = "SystemUtils"
            if (r3 != 0) goto Lb
            java.lang.String r3 = "isSystemApp context is null"
            com.huawei.hms.support.log.HMSLog.m36989w(r1, r3)
            return r0
        Lb:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.RuntimeException -> L16 android.util.AndroidException -> L18
            r2 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r2)     // Catch: java.lang.RuntimeException -> L16 android.util.AndroidException -> L18
            goto L44
        L16:
            r3 = move-exception
            goto L1a
        L18:
            r3 = move-exception
            goto L2f
        L1a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "isSystemApp RuntimeException:"
            r4.append(r2)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.hms.support.log.HMSLog.m36986e(r1, r3)
            goto L43
        L2f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "isSystemApp Exception: "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.hms.support.log.HMSLog.m36986e(r1, r3)
        L43:
            r3 = 0
        L44:
            if (r3 == 0) goto L4f
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo
            int r3 = r3.flags
            r4 = 1
            r3 = r3 & r4
            if (r3 <= 0) goto L4f
            r0 = r4
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.android.SystemUtils.isSystemApp(android.content.Context, java.lang.String):boolean");
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
