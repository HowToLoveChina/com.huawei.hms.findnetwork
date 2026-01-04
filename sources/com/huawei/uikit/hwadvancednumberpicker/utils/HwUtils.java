package com.huawei.uikit.hwadvancednumberpicker.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.uikit.hwadvancednumberpicker.C8692R;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import java.text.NumberFormat;
import java.util.Locale;
import org.json.JSONException;
import p506o1.C11787b;

/* loaded from: classes7.dex */
public class HwUtils {

    /* renamed from: a */
    private static final String f41052a = "HwChinese-medium";

    /* renamed from: e */
    private static final float f41056e = 0.5f;

    /* renamed from: c */
    private static final Typeface f41054c = Typeface.create("HwChinese-medium", 0);

    /* renamed from: b */
    private static final String f41053b = "sans-serif";

    /* renamed from: d */
    private static final Typeface f41055d = Typeface.create(f41053b, 0);

    private HwUtils() {
    }

    /* renamed from: a */
    private static Activity m53787a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m53787a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String formatNumberWithLocale(int i10) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.getDefault());
        numberInstance.setGroupingUsed(false);
        return numberInstance.format(i10);
    }

    public static Typeface getMediumTypeface() {
        return f41054c;
    }

    public static Typeface getRegularTypeface() {
        return f41055d;
    }

    public static boolean isAppInMultiWindow(Context context) {
        Activity activityM53787a;
        if (context == null || (activityM53787a = m53787a(context)) == null) {
            return false;
        }
        return activityM53787a.isInMultiWindowMode();
    }

    public static boolean isLanguageFromPackage() {
        String language = Locale.getDefault().getLanguage();
        return "ta".equals(language) || "as".equals(language) || "sw".equals(language);
    }

    public static boolean isLanguageInMy(Context context) {
        if (context == null || context.getResources() == null) {
            return false;
        }
        Configuration configuration = context.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        String country = configuration.locale.getCountry();
        if ("my".equals(language)) {
            return "MM".equals(country) || "ZG".equals(country);
        }
        return false;
    }

    public static float px2dip(Context context, float f10) {
        return (f10 / context.getResources().getDisplayMetrics().density) + f41056e;
    }

    public static void setTypeface(Typeface typeface, Paint paint) {
        if (paint != null) {
            paint.setTypeface(typeface);
        }
    }

    public static void vibrator(String str, long j10) throws JSONException {
        String newAmpFreq = HwVibrateUtil.getNewAmpFreq(str, j10);
        if (TextUtils.isEmpty(newAmpFreq)) {
            return;
        }
        Log.i("RichTapVibrate", "The timeSpan when play haptic : " + SystemClock.uptimeMillis());
        C11787b.m70255e().m70259i(newAmpFreq, 0);
    }

    public static Typeface getMediumTypeface(Context context) {
        return Typeface.create(context.getResources().getString(C8692R.string.emui_text_font_family_medium), 0);
    }

    public static Typeface getRegularTypeface(Context context) {
        return Typeface.create(context.getResources().getString(C8692R.string.emui_text_font_family_regular), 0);
    }
}
