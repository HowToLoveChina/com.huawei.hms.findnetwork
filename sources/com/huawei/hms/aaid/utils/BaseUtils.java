package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.AbstractC6267e;
import com.huawei.hms.opendevice.AbstractC6272j;
import com.huawei.hms.opendevice.C6271i;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;

/* loaded from: classes8.dex */
public class BaseUtils {
    private BaseUtils() {
    }

    public static void clearSubjectIds(Context context) {
        C6271i.m36434a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String str) {
        C6271i.m36434a(context).m36440c(str);
    }

    public static void deleteAllTokenCache(Context context) {
        C6271i.m36434a(context).m36436a();
    }

    public static void deleteCacheData(Context context, String str) {
        C6271i.m36434a(context).removeKey(str);
    }

    public static String getCacheData(Context context, String str, boolean z10) {
        return z10 ? C6271i.m36434a(context).m36435a(str) : C6271i.m36434a(context).getString(str);
    }

    public static String getLocalToken(Context context, String str) {
        return C6271i.m36434a(context).m36438b(str);
    }

    public static boolean getProxyInit(Context context) {
        return C6271i.m36434a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context context) {
        String string = C6271i.m36434a(context).getString("subjectId");
        return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
    }

    public static void initSecret(Context context) {
        AbstractC6272j.m36441a(context);
    }

    public static boolean isMainProc(Context context) throws IOException {
        String strM36419a = AbstractC6267e.m36419a(context);
        String str = context.getApplicationInfo().processName;
        HMSLog.m36988i("BaseUtils", "main process name: " + str + ", current process name: " + strM36419a);
        return str.equals(strM36419a);
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z10) {
        return z10 ? C6271i.m36434a(context).m36437a(str, str2) : C6271i.m36434a(context).saveString(str, str2);
    }

    public static void saveProxyInit(Context context, boolean z10) {
        C6271i.m36434a(context).saveBoolean("_proxy_init", z10);
    }

    public static void saveToken(Context context, String str, String str2) {
        C6271i.m36434a(context).m36439b(str, str2);
    }
}
