package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
/* renamed from: com.huawei.hms.hatool.d */
/* loaded from: classes8.dex */
public class C5522d {
    /* renamed from: a */
    public static long m32475a(Context context, String str, String str2, long j10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C5571v.m32797f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j10;
        }
        SharedPreferences sharedPreferencesM32479b = m32479b(context, str);
        return sharedPreferencesM32479b != null ? sharedPreferencesM32479b.getLong(str2, j10) : j10;
    }

    /* renamed from: b */
    private static SharedPreferences m32479b(Context context, String str) {
        return context.getSharedPreferences(m32482c(context, str), 0);
    }

    /* renamed from: c */
    public static String m32482c(Context context, String str) {
        String packageName = context.getPackageName();
        String strM32439n = AbstractC5515a1.m32439n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(strM32439n)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + strM32439n;
    }

    /* renamed from: a */
    public static String m32476a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C5571v.m32797f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences sharedPreferencesM32479b = m32479b(context, str);
        return sharedPreferencesM32479b != null ? sharedPreferencesM32479b.getString(str2, str3) : str3;
    }

    /* renamed from: b */
    public static void m32480b(Context context, String str, String str2, long j10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C5571v.m32797f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences sharedPreferencesM32479b = m32479b(context, str);
        if (sharedPreferencesM32479b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM32479b.edit();
            editorEdit.putLong(str2, j10);
            editorEdit.commit();
        }
    }

    /* renamed from: a */
    public static Map<String, ?> m32477a(Context context, String str) {
        return m32479b(context, str).getAll();
    }

    /* renamed from: b */
    public static void m32481b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C5571v.m32796e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences sharedPreferencesM32479b = m32479b(context, str);
        if (sharedPreferencesM32479b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM32479b.edit();
            editorEdit.putString(str2, str3);
            editorEdit.commit();
        }
    }

    /* renamed from: a */
    public static void m32478a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else {
            if (strArr != null) {
                SharedPreferences sharedPreferencesM32479b = m32479b(context, str);
                if (sharedPreferencesM32479b != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesM32479b.edit();
                    if (strArr.length == 0) {
                        editorEdit.clear();
                        editorEdit.commit();
                        return;
                    }
                    for (String str3 : strArr) {
                        if (sharedPreferencesM32479b.contains(str3)) {
                            editorEdit.remove(str3);
                            editorEdit.commit();
                        }
                    }
                    return;
                }
                return;
            }
            str2 = "clearData(): No data need to be deleted,keys is null";
        }
        C5571v.m32797f("hmsSdk", str2);
    }
}
