package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.os.LocaleList;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.d */
/* loaded from: classes2.dex */
public class C2396d {

    /* renamed from: a */
    public static final String f11477a = "d";

    /* renamed from: a */
    public static String m14990a(Context context) {
        String language = LocaleList.getDefault().get(0).getLanguage();
        C9419a.m59080f(f11477a, "locale:" + language);
        return language;
    }

    /* renamed from: b */
    public static Context m14991b(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    /* renamed from: c */
    public static boolean m14992c(Context context) {
        try {
            C2400h.m15002b().m15003a(context);
        } catch (Exception e10) {
            C9419a.m59082h(f11477a, "update configuration failed", e10);
        }
        new LanguageInstaller(context).m14977l();
        return true;
    }
}
