package com.huawei.hms.videokit.player;

import android.content.Context;
import java.util.Locale;

/* renamed from: com.huawei.hms.videokit.player.k0 */
/* loaded from: classes8.dex */
public final class C6583k0 {
    /* renamed from: a */
    public static String m37457a(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return "";
        }
        Locale locale = context.getResources().getConfiguration().locale;
        return m37459b(locale) + '_' + m37458a(locale);
    }

    /* renamed from: b */
    private static String m37459b(Locale locale) {
        String language = locale.getLanguage();
        if (language != null && language.length() > 2) {
            language = C6600t0.m37673a(language, 0, 2);
        }
        return language == null ? "" : language.trim();
    }

    /* renamed from: a */
    private static String m37458a(Locale locale) {
        String country = locale.getCountry();
        if (country != null && country.length() > 2) {
            country = C6600t0.m37673a(country, 0, 2);
        }
        return country == null ? "" : country.trim();
    }
}
