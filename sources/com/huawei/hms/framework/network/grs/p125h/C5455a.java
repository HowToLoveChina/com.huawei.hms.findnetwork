package com.huawei.hms.framework.network.grs.p125h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

/* renamed from: com.huawei.hms.framework.network.grs.h.a */
/* loaded from: classes8.dex */
public class C5455a {
    /* renamed from: a */
    public static String m32319a() {
        return "8.0.1.309";
    }

    /* renamed from: b */
    public static String m32322b(Context context, String str, String str2) {
        return m32321a(context, str, str2);
    }

    /* renamed from: a */
    public static String m32320a(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            Logger.m32146w("AgentUtil", "", e10);
            return "";
        }
    }

    /* renamed from: a */
    public static String m32321a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", m32319a());
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String strM32320a = m32320a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = strM32320a;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = m32319a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale, str5, objArr);
    }
}
