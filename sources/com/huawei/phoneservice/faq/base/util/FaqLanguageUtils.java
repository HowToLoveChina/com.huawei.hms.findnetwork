package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class FaqLanguageUtils {
    /* renamed from: a */
    public static String m51831a() {
        return Resources.getSystem().getConfiguration().getLocales().get(0).getLanguage();
    }

    @Keep
    public static Context changeAppLanguage(Context context, String str, String str2, Configuration configuration) {
        if (TextUtils.isEmpty(str)) {
            return context;
        }
        String[] strArrSplit = str.split("-");
        String str3 = strArrSplit[0];
        if (strArrSplit.length > 1) {
            str2 = strArrSplit[1];
        }
        Locale locale = new Locale(str3, str2);
        Resources resources = context.getResources();
        Configuration configuration2 = resources.getConfiguration();
        LocaleList localeList = new LocaleList(locale);
        LocaleList.setDefault(localeList);
        configuration2.setLocales(localeList);
        if (configuration != null) {
            configuration2.orientation = configuration.orientation;
        }
        resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
        return context.createConfigurationContext(configuration2);
    }

    @Keep
    public static String getLanguage() {
        return m51831a() + "-" + getSystemCountry().toLowerCase(Locale.ENGLISH);
    }

    @Keep
    public static String getSystemCountry() {
        return Resources.getSystem().getConfiguration().getLocales().get(0).getCountry();
    }
}
