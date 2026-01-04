package com.huawei.uikit.hwadvancednumberpicker.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Locale;

/* loaded from: classes7.dex */
public class HwLanguageUtils {
    public static boolean isChineseLanguage(Context context) {
        if (context == null) {
            return false;
        }
        return "zh".equals(context.getResources().getConfiguration().locale.getLanguage());
    }

    public static boolean isChineseLanguageAndRegion(Context context) {
        return context != null && isChineseLanguage(context) && isChineseRegion(context);
    }

    public static boolean isChineseRegion(Context context) {
        if (context == null) {
            return false;
        }
        String country = context.getResources().getConfiguration().locale.getCountry();
        return "CN".equals(country) || "HK".equals(country) || "MO".equals(country) || "TW".equals(country);
    }

    public static boolean isRtlLayout(View view) {
        return view != null && view.getLayoutDirection() == 1;
    }

    public static boolean isRtlLocale(View view) {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || view == null) {
            return false;
        }
        return (language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG)) || isRtlLayout(view);
    }
}
