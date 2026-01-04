package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import java.io.IOException;
import p417k4.AbstractC10984c;
import p417k4.C10986e;

/* loaded from: classes8.dex */
public class AGCUtils {
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m30720a(android.content.Context r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Get "
            java.lang.String r1 = "AGCUtils"
            java.lang.String r2 = ""
            r3 = 0
            k4.e r4 = new k4.e     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            r4.<init>()     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            android.content.res.Resources r5 = r7.getResources()     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            java.lang.String r6 = "agconnect-services.json"
            java.io.InputStream r3 = r5.open(r6)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            r4.m66359b(r3)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            k4.d r7 = r4.m66358a(r7)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            java.lang.String r7 = r7.mo66356b(r8)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L2a
            goto L63
        L26:
            r7 = move-exception
            goto L87
        L28:
            r7 = move-exception
            goto L2c
        L2a:
            r7 = move-exception
            goto L48
        L2c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r4.<init>()     // Catch: java.lang.Throwable -> L26
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = " with AGConnectServicesConfig failed: "
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r7)     // Catch: java.lang.Throwable -> L26
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L26
            com.huawei.hms.support.log.HMSLog.m36986e(r1, r7)     // Catch: java.lang.Throwable -> L26
        L46:
            r7 = r2
            goto L63
        L48:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r4.<init>()     // Catch: java.lang.Throwable -> L26
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = " failed: "
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r7)     // Catch: java.lang.Throwable -> L26
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L26
            com.huawei.hms.support.log.HMSLog.m36986e(r1, r7)     // Catch: java.lang.Throwable -> L26
            goto L46
        L63:
            com.huawei.hms.utils.IOUtils.closeQuietly(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L6d
            return r7
        L6d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "The "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r8 = " is null."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.huawei.hms.support.log.HMSLog.m36986e(r1, r7)
            return r2
        L87:
            com.huawei.hms.utils.IOUtils.closeQuietly(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.AGCUtils.m30720a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private static String m30721b(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m36986e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("com.huawei.hms.client.cpid")) == null) {
                HMSLog.m36988i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            String strValueOf = String.valueOf(obj);
            return strValueOf.startsWith("cpid=") ? strValueOf.substring(5) : strValueOf;
        } catch (AndroidException unused) {
            HMSLog.m36986e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e10) {
            HMSLog.m36987e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e10);
            return "";
        }
    }

    /* renamed from: c */
    private static boolean m30722c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) throws IOException {
        String strMo66356b;
        if (context == null) {
            HMSLog.m36989w("AGCUtils", "getAppId context is null");
            return "";
        }
        if (m30722c(context)) {
            strMo66356b = m30720a(context, "client/app_id");
            if (!TextUtils.isEmpty(strMo66356b)) {
                return strMo66356b;
            }
        } else {
            strMo66356b = null;
        }
        try {
            AbstractC10984c abstractC10984cM66351c = AbstractC10984c.m66351c();
            if (abstractC10984cM66351c.mo66353b() != context) {
                abstractC10984cM66351c = AbstractC10984c.m66350a(new C10986e().m66358a(context));
            }
            strMo66356b = abstractC10984cM66351c.mo66354d().mo66356b("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.m36986e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(strMo66356b)) {
            return strMo66356b;
        }
        String strM30719a = m30719a(context);
        return !TextUtils.isEmpty(strM30719a) ? strM30719a : m30720a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        String strMo66356b;
        if (context == null) {
            HMSLog.m36989w("AGCUtils", "getCpId context is null");
            return "";
        }
        if (m30722c(context)) {
            return m30720a(context, "client/cp_id");
        }
        try {
            AbstractC10984c abstractC10984cM66351c = AbstractC10984c.m66351c();
            if (abstractC10984cM66351c.mo66353b() != context) {
                abstractC10984cM66351c = AbstractC10984c.m66350a(new C10986e().m66358a(context));
            }
            strMo66356b = abstractC10984cM66351c.mo66354d().mo66356b("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.m36986e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            strMo66356b = null;
        }
        if (!TextUtils.isEmpty(strMo66356b)) {
            return strMo66356b;
        }
        String strM30721b = m30721b(context);
        return !TextUtils.isEmpty(strM30721b) ? strM30721b : m30720a(context, "client/cp_id");
    }

    /* renamed from: a */
    private static String m30719a(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m36986e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("com.huawei.hms.client.appid")) != null) {
                String strValueOf = String.valueOf(obj);
                return strValueOf.startsWith("appid=") ? strValueOf.substring(6) : strValueOf;
            }
            HMSLog.m36986e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (AndroidException unused) {
            HMSLog.m36986e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e10) {
            HMSLog.m36987e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e10);
            return "";
        }
    }
}
