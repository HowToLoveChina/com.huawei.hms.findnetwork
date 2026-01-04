package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import java.util.Locale;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.h */
/* loaded from: classes2.dex */
public class C2400h {

    /* renamed from: a */
    public static final String f11485a = "h";

    /* renamed from: b */
    public static volatile C2400h f11486b;

    /* renamed from: b */
    public static C2400h m15002b() {
        if (f11486b == null) {
            synchronized (C2400h.class) {
                try {
                    if (f11486b == null) {
                        f11486b = new C2400h();
                    }
                } finally {
                }
            }
        }
        return f11486b;
    }

    /* renamed from: a */
    public void m15003a(Context context) {
        if (context == null) {
            C9419a.m59076b(f11485a, "context is null in applySysPreferredLocaleToConfig()!");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Locale localeM15004c = m15004c();
        C9419a.m59080f(f11485a, "Set to preferred locale: " + localeM15004c);
        Configuration configuration = applicationContext.getResources().getConfiguration();
        configuration.setLocale(localeM15004c);
        applicationContext.getResources().updateConfiguration(configuration, applicationContext.getResources().getDisplayMetrics());
    }

    /* renamed from: c */
    public Locale m15004c() {
        return LocaleList.getDefault().get(0);
    }
}
