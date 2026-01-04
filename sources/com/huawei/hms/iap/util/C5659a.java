package com.huawei.hms.iap.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.iap.util.a */
/* loaded from: classes8.dex */
public class C5659a {
    /* renamed from: a */
    private static boolean m33011a() throws ClassNotFoundException {
        try {
            Class.forName("com.huawei.hms.iapfull.pay.PayActivity");
            return true;
        } catch (ClassNotFoundException e10) {
            HMSLog.m36989w("FullSdkUtils", "className not found" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m33018b(Context context, String str) {
        String str2;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 16384) != null;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "isAppInstalled NameNotFoundException:" + str;
            HMSLog.m36989w("FullSdkUtils", str2);
            return false;
        } catch (RuntimeException e10) {
            str2 = "isAppInstalled RuntimeException:" + e10.getMessage();
            HMSLog.m36989w("FullSdkUtils", str2);
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m33012a(Context context) {
        if (context == null) {
            HMSLog.m36986e("FullSdkUtils", "context is null");
            return false;
        }
        if (m33018b(context, "com.huawei.hwid") || m33018b(context, "com.huawei.hms") || m33018b(context, "com.huawei.hwid.tv")) {
            HMSLog.m36988i("FullSdkUtils", "isHMSCoreInstalled true");
            return true;
        }
        HMSLog.m36989w("FullSdkUtils", "isHMSCoreInstalled false");
        return false;
    }

    /* renamed from: b */
    private static boolean m33019b(String str) {
        try {
            return "fullsdk".equals(new JSONObject(new JSONObject(str).optString("accountInfo")).optString("routeMode"));
        } catch (JSONException unused) {
            HMSLog.m36986e("FullSdkUtils", "isRouteToFullSDK: JSONException");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m33013a(Context context, String str) {
        String str2;
        if (!m33011a()) {
            str2 = "canUseFullSdk no fullsdk";
        } else {
            if (m33016a(str)) {
                if (!m33019b(str)) {
                    return !m33012a(context);
                }
                HMSLog.m36988i("FullSdkUtils", "canUseFullSdk route to fullsdk");
                return true;
            }
            str2 = "canUseFullSdk no reserved account info";
        }
        HMSLog.m36988i("FullSdkUtils", str2);
        return false;
    }

    /* renamed from: b */
    private static boolean m33020b(String str, String str2) {
        if (m33011a()) {
            return IapFullAPIFactory.isCountryAndCurrencySupport(str, str2);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m33014a(Context context, String str, String str2) {
        return !m33012a(context) && m33016a(str) && m33017a(str, str2);
    }

    /* renamed from: a */
    public static boolean m33015a(Context context, String str, String str2, String str3, String str4) {
        return !m33012a(context) && m33016a(str) && (m33017a(str, str4) || m33020b(str2, str3));
    }

    /* renamed from: a */
    private static boolean m33016a(String str) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m36988i("FullSdkUtils", "reservedInfor is null!");
            return false;
        }
        try {
        } catch (JSONException unused) {
            HMSLog.m36986e("FullSdkUtils", "getAccountInfo: JSONException");
        }
        return new JSONObject(str).has("accountInfo");
    }

    /* renamed from: a */
    private static boolean m33017a(String str, String str2) {
        if (m33011a()) {
            return IapFullAPIFactory.isWebPaySupport(str, str2);
        }
        return false;
    }
}
