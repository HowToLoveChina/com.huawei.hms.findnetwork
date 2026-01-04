package com.huawei.uikit.hwcommon.utils;

import android.provider.Settings;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class HwVibrateUtil {

    /* renamed from: A */
    private static Object f42093A = null;

    /* renamed from: B */
    private static Method f42094B = null;

    /* renamed from: C */
    private static Method f42095C = null;

    /* renamed from: D */
    private static Method f42096D = null;

    /* renamed from: E */
    private static Method f42097E = null;

    /* renamed from: F */
    private static Class<?> f42098F = null;

    /* renamed from: G */
    private static Class<?> f42099G = null;

    /* renamed from: H */
    private static Class<?> f42100H = null;
    public static final String HAPTIC_TIME_SCROLL_VIBRATOR = "haptic.control.time_scroll";
    public static final int HWVIBRATE_CROWN_STRENGTH1 = 10;
    public static final int HWVIBRATE_CROWN_STRENGTH2 = 11;
    public static final int HWVIBRATE_CROWN_STRENGTH3 = 12;
    public static final int HWVIBRATE_LONG_PRESS = 0;
    public static final int HWVIBRATE_LONG_PRESS1 = 8;
    public static final int HWVIBRATE_LONG_PRESS2 = 9;
    public static final int HWVIBRATE_SLIDE_TYPE1 = 2;
    public static final int HWVIBRATE_SLIDE_TYPE2 = 3;
    public static final int HWVIBRATE_SLIDE_TYPE3 = 4;
    public static final int HWVIBRATE_SLIDE_TYPE4 = 5;
    public static final int HWVIBRATE_SLIDE_TYPE5 = 6;
    public static final int HWVIBRATE_SLIDE_TYPE6 = 7;
    public static final int HWVIBRATE_THRESHOLD = 1;

    /* renamed from: I */
    private static boolean f42101I = false;

    /* renamed from: J */
    private static Map<Integer, String> f42102J = new HashMap();

    /* renamed from: K */
    private static Map<Integer, String> f42103K = new HashMap();

    /* renamed from: L */
    private static List<Integer> f42104L = new ArrayList(10);

    /* renamed from: a */
    private static final String f42105a = "HwVibrateUtil";

    /* renamed from: b */
    private static final String f42106b = "haptic.common.long_press";

    /* renamed from: c */
    private static final String f42107c = "haptic.common.long_press1";

    /* renamed from: d */
    private static final String f42108d = "haptic.common.long_press2";

    /* renamed from: e */
    private static final String f42109e = "haptic.common.threshold";

    /* renamed from: f */
    private static final String f42110f = "haptic.slide.type1";

    /* renamed from: g */
    private static final String f42111g = "haptic.slide.type2";

    /* renamed from: h */
    private static final String f42112h = "haptic.slide.type3";

    /* renamed from: i */
    private static final String f42113i = "haptic.slide.type4";

    /* renamed from: j */
    private static final String f42114j = "haptic.slide.type5";

    /* renamed from: k */
    private static final String f42115k = "haptic.slide.type6";

    /* renamed from: l */
    private static final String f42116l = "watchhaptic.crown.strength1";

    /* renamed from: m */
    private static final String f42117m = "watchhaptic.crown.strength2";

    /* renamed from: n */
    private static final String f42118n = "watchhaptic.crown.strength3";

    /* renamed from: o */
    private static final String f42119o = "com.huawei.android.os.VibratorEx";

    /* renamed from: p */
    private static final String f42120p = "com.huawei.android.view.ViewEx";

    /* renamed from: q */
    private static final String f42121q = "com.huawei.android.view.HapticFeedbackConstantsEx";

    /* renamed from: r */
    private static final String f42122r = "class com.huawei.android.os.VibratorEx";

    /* renamed from: s */
    private static final String f42123s = "PatternList";

    /* renamed from: t */
    private static final String f42124t = "Pattern";

    /* renamed from: u */
    private static final String f42125u = "Event";

    /* renamed from: v */
    private static final String f42126v = "Parameters";

    /* renamed from: w */
    private static final String f42127w = "Intensity";

    /* renamed from: x */
    private static final String f42128x = "Frequency";

    /* renamed from: y */
    private static final int f42129y = 80;

    /* renamed from: z */
    private static final int f42130z = 0;

    static {
        try {
            f42102J.put(0, f42106b);
            f42102J.put(1, f42109e);
            f42102J.put(2, f42110f);
            f42102J.put(3, f42111g);
            f42102J.put(4, f42112h);
            f42102J.put(5, f42113i);
            f42102J.put(6, f42114j);
            f42102J.put(7, f42115k);
            f42102J.put(8, f42107c);
            f42102J.put(9, f42108d);
            f42102J.put(10, f42116l);
            f42102J.put(11, f42117m);
            f42102J.put(12, f42118n);
            f42103K.put(0, f42106b);
            f42103K.put(1, f42109e);
            f42103K.put(2, HAPTIC_TIME_SCROLL_VIBRATOR);
            f42103K.put(3, HAPTIC_TIME_SCROLL_VIBRATOR);
            f42103K.put(4, HAPTIC_TIME_SCROLL_VIBRATOR);
            f42103K.put(5, HAPTIC_TIME_SCROLL_VIBRATOR);
            f42103K.put(6, HAPTIC_TIME_SCROLL_VIBRATOR);
            f42103K.put(7, f42115k);
            f42103K.put(8, f42107c);
            f42103K.put(9, f42108d);
            f42103K.put(10, f42116l);
            f42103K.put(11, f42117m);
            f42103K.put(12, f42118n);
            Class<?> cls = Class.forName(f42119o);
            f42098F = cls;
            if (f42122r.equals(cls.toString())) {
                f42093A = f42098F.newInstance();
                f42094B = f42098F.getMethod("isSupportHwVibrator", String.class);
                f42095C = f42098F.getMethod("setHwVibrator", String.class);
                f42096D = f42098F.getMethod("stopHwVibrator", String.class);
                f42099G = Class.forName(f42120p);
                f42100H = Class.forName(f42121q);
                Class<?> cls2 = f42099G;
                Class<?> cls3 = Integer.TYPE;
                f42097E = cls2.getMethod("performHwHapticFeedback", View.class, cls3, cls3);
                f42104L.add(0, Integer.valueOf(m54216a("HW_LONG_PRESS")));
                f42104L.add(1, Integer.valueOf(m54216a("HW_THRESHOLD")));
                f42104L.add(2, Integer.valueOf(m54216a("HW_SLIDE_1")));
                f42104L.add(3, Integer.valueOf(m54216a("HW_SLIDE_2")));
                f42104L.add(4, Integer.valueOf(m54216a("HW_SLIDE_3")));
                f42104L.add(5, Integer.valueOf(m54216a("HW_SLIDE_4")));
                f42104L.add(6, Integer.valueOf(m54216a("HW_SLIDE_5")));
                f42104L.add(7, Integer.valueOf(m54216a("HW_SLIDE_6")));
                f42104L.add(8, Integer.valueOf(m54216a("HW_LONG_PRESS1")));
                f42104L.add(9, Integer.valueOf(m54216a("HW_LONG_PRESS2")));
            } else {
                f42101I = true;
                Log.e(f42105a, "fail to reflect, class is proguard.");
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            Log.e(f42105a, "class init failed.");
        } catch (Exception unused2) {
            Log.e(f42105a, "Another exception failed.");
        }
    }

    private HwVibrateUtil() {
    }

    /* renamed from: a */
    private static int m54216a(String str) {
        if (f42101I || f42100H == null) {
            return 0;
        }
        return m54218b(str);
    }

    /* renamed from: b */
    private static int m54218b(String str) throws IllegalAccessException, IllegalArgumentException {
        try {
            Object obj = f42100H.getField(str).get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.e(f42105a, "get field failed.");
            return 0;
        }
    }

    /* renamed from: c */
    private static boolean m54219c(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        Method method = f42094B;
        if (method == null || (obj = f42093A) == null) {
            return false;
        }
        try {
            Object objInvoke = method.invoke(obj, str);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(f42105a, "Call isSupportHwVibrator exception.");
            return false;
        }
    }

    public static String getNewAmpFreq(String str, long j10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONArray(f42123s).getJSONObject(0).getJSONArray(f42124t).getJSONObject(0).getJSONObject("Event").getJSONObject(f42126v);
            jSONObject2.put(f42127w, j10);
            jSONObject2.put(f42128x, 80);
            return jSONObject.toString();
        } catch (JSONException unused) {
            Log.w(f42105a, "Json parse error or file not exist.");
            return "";
        }
    }

    public static boolean isVibratorSwitchOn(View view) {
        return Settings.System.getInt(view.getContext().getContentResolver(), "haptic_feedback_enabled", 0) != 0;
    }

    public static boolean stopVibrator(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f42101I || f42093A == null || f42096D == null || !m54219c(str)) {
            return false;
        }
        try {
            f42096D.invoke(f42093A, str);
            return true;
        } catch (IllegalAccessException unused) {
            Log.e(f42105a, "Call stopVibrateEx IllegalAccessException Exception.");
            return false;
        } catch (InvocationTargetException unused2) {
            Log.e(f42105a, "Call stopVibrateEx InvocationTargetException Exception.");
            return false;
        }
    }

    public static boolean vibrator(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f42101I || str == null || f42093A == null || f42095C == null || !m54219c(str)) {
            return false;
        }
        try {
            f42095C.invoke(f42093A, str);
            return true;
        } catch (IllegalAccessException unused) {
            Log.e(f42105a, "Call doVibrateEx IllegalAccessException Exception.");
            return false;
        } catch (InvocationTargetException unused2) {
            Log.e(f42105a, "Call doVibrateEx InvocationTargetException Exception.");
            return false;
        }
    }

    public static boolean vibratorEx(View view, int i10, int i11) {
        if (f42104L.size() != 0 && m54217a(view, i10, i11)) {
            return true;
        }
        if (Settings.System.getInt(view.getContext().getContentResolver(), "haptic_feedback_enabled", 0) == 0) {
            return false;
        }
        return vibrator(f42103K.get(Integer.valueOf(i10)));
    }

    /* renamed from: a */
    private static boolean m54217a(View view, int i10, int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f42097E == null || i10 >= f42104L.size() || i10 < 0 || !m54219c(f42102J.get(Integer.valueOf(i10)))) {
            return false;
        }
        try {
            f42097E.invoke(null, view, f42104L.get(i10), Integer.valueOf(i11));
            return true;
        } catch (IllegalAccessException unused) {
            Log.e(f42105a, "Call doViewEx IllegalAccessException Exception.");
            return false;
        } catch (InvocationTargetException unused2) {
            Log.e(f42105a, "Call doViewEx InvocationTargetException Exception.");
            return false;
        }
    }

    public static boolean vibrator(View view, int i10, int i11) {
        if (f42104L.size() == 0 || !m54217a(view, i10, i11)) {
            return vibrator(f42103K.get(Integer.valueOf(i10)));
        }
        return true;
    }
}
