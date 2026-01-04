package com.huawei.phoneservice.faq.base.tracker;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class FaqTrack {

    /* renamed from: a */
    public static WeakReference<Context> f38679a;

    /* renamed from: b */
    public static String f38680b;

    /* renamed from: c */
    public static String f38681c;

    /* renamed from: a */
    public static String m51800a(Context context) throws Throwable {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e10) {
            FaqLogger.m51840e("Track", e10.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public static void m51801b(Context context, boolean z10) {
        m51802c(context, z10);
    }

    /* renamed from: c */
    public static void m51802c(Context context, boolean z10) {
        f38679a = new WeakReference<>(context.getApplicationContext());
    }

    @Keep
    public static void event(String str, String str2, String str3) throws Throwable {
        String str4;
        Context context;
        String str5 = "";
        if ("性能监控".equals(str) || "接口异常监控".equals(str) || "DEBUG_INFO".equals(str)) {
            str4 = "";
        } else {
            if (TextUtils.isEmpty(f38680b)) {
                str4 = "";
            } else {
                str4 = "+" + f38680b;
            }
            if (!TextUtils.isEmpty(f38681c)) {
                str4 = str4 + "+" + f38681c;
            }
        }
        if ("DEBUG_INFO".equals(str)) {
            WeakReference<Context> weakReference = f38679a;
            if (weakReference != null && weakReference.get() != null && (context = f38679a.get()) != null) {
                str5 = "" + m51800a(context) + "+";
            }
            if (!TextUtils.isEmpty(f38680b)) {
                str5 = str5 + f38680b + "+";
            }
            if (!TextUtils.isEmpty(f38681c)) {
                str5 = str5 + f38681c + "+";
            }
        }
        HiAnalyticsUtils.m51804b(str + str4, str5 + str2, str3);
    }

    @Keep
    public static void setCountryAndLanguage(String str, String str2) {
        f38680b = str;
        f38681c = str2;
    }
}
