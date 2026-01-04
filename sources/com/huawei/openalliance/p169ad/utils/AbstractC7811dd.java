package com.huawei.openalliance.p169ad.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C6985cb;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7000cq;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.views.InterfaceC8069ad;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.utils.dd */
/* loaded from: classes2.dex */
public abstract class AbstractC7811dd {

    /* renamed from: com.huawei.openalliance.ad.utils.dd$1 */
    public static class AnonymousClass1 implements View.OnApplyWindowInsetsListener {

        /* renamed from: b */
        final /* synthetic */ View f36084b;

        public AnonymousClass1(View view) {
            view = view;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            String str;
            View view2;
            try {
                Rect rectMo41200a = interfaceC7000cq.mo41200a(windowInsets);
                if (rectMo41200a != null && (view2 = view) != null) {
                    view2.setPadding(rectMo41200a.left, 0, rectMo41200a.right, 0);
                }
            } catch (NoSuchMethodError unused) {
                str = "initOnApplyWindowInsets NoSuchMethodError getDisplaySideRegion";
                AbstractC7185ho.m43823c("SystemUtil", str);
                return windowInsets;
            } catch (Throwable th2) {
                str = "initOnApplyWindowInsets error:" + th2.getClass().getSimpleName();
                AbstractC7185ho.m43823c("SystemUtil", str);
                return windowInsets;
            }
            return windowInsets;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.dd$2 */
    public static class AnonymousClass2 implements View.OnApplyWindowInsetsListener {

        /* renamed from: b */
        final /* synthetic */ InterfaceC8069ad f36086b;

        public AnonymousClass2(InterfaceC8069ad interfaceC8069ad) {
            interfaceC8069ad = interfaceC8069ad;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            String str;
            InterfaceC8069ad interfaceC8069ad;
            try {
                Rect rectMo41200a = interfaceC7000cq.mo41200a(windowInsets);
                if (AbstractC7185ho.m43819a()) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(rectMo41200a == null ? 0 : rectMo41200a.right);
                    AbstractC7185ho.m43818a("SystemUtil", "got safe padding: %s", objArr);
                }
                if (rectMo41200a != null && (interfaceC8069ad = interfaceC8069ad) != null) {
                    interfaceC8069ad.mo38783a(rectMo41200a.right);
                }
            } catch (NoSuchMethodError unused) {
                str = "getRingScreenSafePadding NoSuchMethodError getDisplaySideRegion";
                AbstractC7185ho.m43823c("SystemUtil", str);
                return windowInsets;
            } catch (Throwable th2) {
                str = "getRingScreenSafePadding error:" + th2.getClass().getSimpleName();
                AbstractC7185ho.m43823c("SystemUtil", str);
                return windowInsets;
            }
            return windowInsets;
        }
    }

    /* renamed from: A */
    public static void m48274A(Context context) {
        if (context != null) {
            try {
                if (context instanceof Activity) {
                    Window window = ((Activity) context).getWindow();
                    if (window == null) {
                        AbstractC7185ho.m43820b("SystemUtil", "window is null");
                        return;
                    } else {
                        window.getDecorView().setSystemUiVisibility((window.getDecorView().getSystemUiVisibility() & (-5)) | 7936);
                        return;
                    }
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("SystemUtil", "showContentInNaviBar err: %s", th2.getClass().getSimpleName());
                return;
            }
        }
        AbstractC7185ho.m43820b("SystemUtil", "para err");
    }

    /* renamed from: B */
    public static boolean m48275B(Context context) {
        if (context != null) {
            try {
                if (!AbstractC7806cz.m48165b(context.getPackageName())) {
                    String packageName = context.getPackageName();
                    if (m48289a("hw_sc.build.platform.version") == null) {
                        return true;
                    }
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    Class<?> cls = Class.forName("com.huawei.android.app.AppOpsManagerEx");
                    Class<?> cls2 = Integer.TYPE;
                    Method method = cls.getMethod("checkHwOpNoThrow", AppOpsManager.class, cls2, cls2, String.class);
                    if (method == null) {
                        AbstractC7185ho.m43823c("SystemUtil", "judgeHwOpIsAllow, method is null.");
                        return true;
                    }
                    Integer num = (Integer) method.invoke(cls, appOpsManager, 100002, Integer.valueOf(m48284a(context, packageName)), packageName);
                    int iIntValue = num.intValue();
                    boolean z10 = iIntValue == 0 || iIntValue == 3;
                    AbstractC7185ho.m43821b("SystemUtil", "judgeHwOpIsAllow, result is %s, per is %s", num, Boolean.valueOf(z10));
                    return z10;
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("SystemUtil", "JudgeHwOpIsAllow err: %s", th2.getClass().getSimpleName());
                return true;
            }
        }
        AbstractC7185ho.m43823c("SystemUtil", "judgeHwOpIsAllow, param is invalid");
        return true;
    }

    /* renamed from: C */
    private static boolean m48276C(Context context) {
        if (context == null) {
            return false;
        }
        boolean z10 = true;
        if (C6982bz.m41152b(context)) {
            int iM48258u = AbstractC7807d.m48258u(context);
            AbstractC7185ho.m43818a("SystemUtil", "isGesture: %s", Integer.valueOf(iM48258u));
            if (iM48258u != 0) {
                return false;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", OsType.ANDROID);
            boolean z11 = identifier > 0 ? resources.getBoolean(identifier) : false;
            String strM48289a = m48289a("qemu.hw.mainkeys");
            if ("1".equals(strM48289a)) {
                z10 = false;
            } else if (!"0".equals(strM48289a)) {
                z10 = z11;
            }
            if (m48277D(context)) {
                AbstractC7185ho.m43817a("SystemUtil", "is gesture");
                return false;
            }
        }
        return z10;
    }

    /* renamed from: D */
    private static boolean m48277D(Context context) {
        String[] strArr = {"force_fsg_nav_bar", "navigation_gesture_on", Constants.NAVIGATIONBAR_IS_MIN, "hide_navigationbar_enable", "force_fsg_nav_bar", "navigation_gesture_on", Constants.NAVIGATIONBAR_IS_MIN, "hide_navigationbar_enable"};
        ContentResolver contentResolver = context.getContentResolver();
        for (int i10 = 0; i10 < 8; i10++) {
            if (Settings.Global.getInt(contentResolver, strArr[i10], 0) != 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: E */
    private static boolean m48278E(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i11 - displayMetrics2.widthPixels > 0 || i10 - displayMetrics2.heightPixels > 0;
    }

    /* renamed from: F */
    private static boolean m48279F(Context context) {
        String strM48538b = C7845x.m48538b();
        int iIndexOf = strM48538b.indexOf("-");
        if (iIndexOf != -1) {
            strM48538b = strM48538b.substring(0, iIndexOf + 1);
        }
        AbstractC7185ho.m43818a("SystemUtil", "Current model is %s", strM48538b);
        String strMo43070b = C7124fh.m43316b(context).mo43070b(ConfigMapKeys.TRIFOLD_PHONE_MODEL, Constants.DEFAULT_MODEL);
        AbstractC7185ho.m43818a("SystemUtil", "modelStr is %s", strMo43070b);
        return Arrays.asList(strMo43070b.split(",")).contains(strM48538b);
    }

    /* renamed from: G */
    private static int m48280G(Context context) {
        if (context == null) {
            return 1;
        }
        Object systemService = context.getSystemService("uimode");
        if (systemService instanceof UiModeManager) {
            return ((UiModeManager) systemService).getNightMode();
        }
        return 1;
    }

    /* renamed from: H */
    private static String m48281H(Context context) {
        String lowerCase = context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.getDefault());
        AbstractC7185ho.m43820b("SystemUtil", " languageStr:" + lowerCase);
        return lowerCase;
    }

    /* renamed from: I */
    private static String m48282I(Context context) {
        String lowerCase = context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
        AbstractC7185ho.m43820b("SystemUtil", " countryStr:" + lowerCase);
        return lowerCase;
    }

    /* renamed from: a */
    public static int m48283a(int i10, boolean z10) {
        return z10 ? i10 > 2 ? C6849R.drawable.hiad_template_sound_off : m48287a(false, z10) : i10 > 2 ? C6849R.drawable.hiad_template_sound : m48287a(false, z10);
    }

    /* renamed from: b */
    private static int m48305b(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 9;
        }
        return i10 == 3 ? 8 : 1;
    }

    /* renamed from: c */
    private static int m48314c(int i10) {
        return (i10 == 1 || i10 == 2) ? 9 : 1;
    }

    /* renamed from: d */
    private static int m48319d(int i10) {
        return (i10 == 2 || i10 == 3) ? 8 : 0;
    }

    /* renamed from: e */
    public static String m48323e() {
        return Application.getProcessName();
    }

    /* renamed from: f */
    public static int m48326f(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", OsType.ANDROID)) > 0 && m48276C(context) && m48278E(context)) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: g */
    public static int m48329g(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", OsType.ANDROID)) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @TargetApi(28)
    /* renamed from: h */
    public static void m48331h(Context context) {
        String str;
        String strM48323e = m48323e();
        AbstractC7185ho.m43820b("SystemUtil", "setWebDataDir processName: " + strM48323e);
        try {
            if (TextUtils.isEmpty(strM48323e) || strM48323e.equals(context.getPackageName())) {
                return;
            }
            WebView.setDataDirectorySuffix(strM48323e);
        } catch (IllegalStateException unused) {
            str = "setDataDirectorySuffix already initialized";
            AbstractC7185ho.m43826d("SystemUtil", str);
        } catch (Exception unused2) {
            str = "setDataDirectorySuffix Exception";
            AbstractC7185ho.m43826d("SystemUtil", str);
        }
    }

    /* renamed from: i */
    public static boolean m48333i(Context context) {
        StringBuilder sb2;
        String str;
        try {
        } catch (Settings.SettingNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "isNotchEnable error:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43820b("SystemUtil", sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "isNotchEnable Throwable:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43820b("SystemUtil", sb2.toString());
        }
        return Settings.Secure.getInt(context.getContentResolver(), "display_notch_status") == 0;
    }

    /* renamed from: j */
    public static int m48334j(Context context) {
        int iM48329g = m48329g(context);
        if (iM48329g > 0) {
            return iM48329g / 2;
        }
        return 36;
    }

    /* renamed from: k */
    public static int m48335k(Context context) {
        Display defaultDisplay;
        if (context == null) {
            return 1;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            AbstractC7185ho.m43826d("SystemUtil", "Failed to get display orientation info.");
            return context.getResources().getConfiguration().orientation == 2 ? 0 : 1;
        }
        int rotation = defaultDisplay.getRotation();
        return m48279F(context) ? m48285a(windowManager, rotation) : m48305b(rotation);
    }

    /* renamed from: l */
    public static boolean m48336l(Context context) {
        return m48298a(m48335k(context));
    }

    /* renamed from: m */
    public static boolean m48337m(Context context) {
        try {
            return C6985cb.m41166a(context).mo41205b();
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("SystemUtil", "isInMultiWindowMode " + th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m48338n(Context context) {
        if (context == null) {
            return false;
        }
        return !m48339o(context);
    }

    /* renamed from: o */
    public static boolean m48339o(Context context) {
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10);
            AbstractC7185ho.m43817a("SystemUtil", "context.getPackageName: %s " + context.getPackageName());
            if (runningTasks != null && runningTasks.size() > 0) {
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
                if (runningTaskInfo != null && (componentName = runningTaskInfo.topActivity) != null) {
                    boolean zEquals = componentName.getPackageName().equals(context.getPackageName());
                    AbstractC7185ho.m43818a("SystemUtil", "topActivity name is %s , packageName is %", runningTaskInfo.topActivity.getClassName(), runningTaskInfo.topActivity.getPackageName());
                    if (!zEquals) {
                        return false;
                    }
                    String string = runningTaskInfo.toString();
                    AbstractC7185ho.m43817a("SystemUtil", "taskInfoStr : %s " + string);
                    if (string.contains("isVisible=true")) {
                        return true;
                    }
                    if (string.contains("isVisible=false")) {
                        return false;
                    }
                    return zEquals;
                }
                AbstractC7185ho.m43823c("SystemUtil", "topActivity is null");
            }
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SystemUtil", "judge Foreground err, %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: p */
    public static boolean m48340p(Context context) {
        return false;
    }

    /* renamed from: q */
    public static boolean m48341q(Context context) {
        return context != null && Constants.DARK_THEME_COLOR.equalsIgnoreCase(m48343s(context));
    }

    /* renamed from: r */
    public static boolean m48342r(Context context) {
        return m48280G(context) == 2 || m48341q(context);
    }

    /* renamed from: s */
    public static String m48343s(Context context) throws Resources.NotFoundException {
        if (context == null) {
            return null;
        }
        try {
            int color = context.getResources().getColor(C6849R.color.hiad_dark_mode_tag_color);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("#");
            String hexString = Integer.toHexString(Color.alpha(color));
            String hexString2 = Integer.toHexString(Color.red(color));
            String hexString3 = Integer.toHexString(Color.green(color));
            String hexString4 = Integer.toHexString(Color.blue(color));
            String strM48306b = m48306b(hexString);
            String strM48306b2 = m48306b(hexString2);
            String strM48306b3 = m48306b(hexString3);
            String strM48306b4 = m48306b(hexString4);
            stringBuffer.append(strM48306b);
            stringBuffer.append(strM48306b2);
            stringBuffer.append(strM48306b3);
            stringBuffer.append(strM48306b4);
            AbstractC7185ho.m43818a("SystemUtil", " color=%s", stringBuffer.toString());
            return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
        } catch (Exception e10) {
            AbstractC7185ho.m43820b("SystemUtil", "catch theme color exception:" + e10.getClass().getName());
            return null;
        }
    }

    /* renamed from: t */
    public static String m48344t(Context context) {
        return context.getResources().getConfiguration().locale.getScript();
    }

    /* renamed from: u */
    public static String m48345u(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(m48344t(context))) {
                return m48281H(context) + "-" + m48282I(context).toUpperCase(Locale.getDefault());
            }
            return m48281H(context) + "-" + m48344t(context) + "-" + m48282I(context).toUpperCase(Locale.getDefault());
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("SystemUtil", " getLanguageCode error");
            return "";
        }
    }

    /* renamed from: v */
    public static boolean m48346v(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SystemUtil", "canInstallPackage exception %s", th2.getClass().getSimpleName());
            return true;
        }
    }

    /* renamed from: w */
    public static int m48347w(Context context) {
        String str;
        if (!C6982bz.m41148a(context).mo41189r()) {
            return 0;
        }
        try {
            return 1 - Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state");
        } catch (Settings.SettingNotFoundException unused) {
            str = "get pureModeState error, setting not found.";
            AbstractC7185ho.m43826d("SystemUtil", str);
            return 0;
        } catch (Throwable unused2) {
            str = "get pureModeState error.";
            AbstractC7185ho.m43826d("SystemUtil", str);
            return 0;
        }
    }

    /* renamed from: x */
    public static boolean m48348x(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC7784cd.m47887a(context, Constants.POST_NOTIFICATIONS);
        }
        return true;
    }

    /* renamed from: y */
    public static int m48349y(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("SystemUtil", "getMultiWindowDragBarHeight " + th2.getClass().getSimpleName());
            return 0;
        }
    }

    /* renamed from: z */
    public static Activity m48350z(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    /* renamed from: a */
    public static int m48284a(Context context, String str) {
        if (context == null || AbstractC7806cz.m48165b(str)) {
            return -1;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return -1;
            }
            return packageManager.getApplicationInfo(str, 0).uid;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SystemUtil", "getUidByPackageName err: %s", th2.getClass().getSimpleName());
            return -1;
        }
    }

    /* renamed from: b */
    private static String m48306b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() != 1) {
            return str;
        }
        return "0" + str;
    }

    /* renamed from: c */
    public static boolean m48315c() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    /* renamed from: d */
    public static Activity m48320d(View view) {
        if (view == null) {
            return null;
        }
        return m48350z(view.getContext());
    }

    /* renamed from: e */
    public static String m48324e(Context context) {
        String str;
        if (context == null) {
            str = "getLocalCountry context is null";
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simCountryIso = telephonyManager.getSimCountryIso();
                return TextUtils.isEmpty(simCountryIso) ? "" : simCountryIso.toUpperCase(Locale.ENGLISH);
            }
            str = "getLocalCountry tm is null";
        }
        AbstractC7185ho.m43820b("SystemUtil", str);
        return "";
    }

    /* renamed from: f */
    public static long m48327f() {
        try {
            return SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Throwable th2) {
            AbstractC7185ho.m43820b("SystemUtil", "elapsedRealtimeMillis " + th2.getClass().getSimpleName());
            return 0L;
        }
    }

    /* renamed from: g */
    public static boolean m48330g() {
        String strM48289a = m48289a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP);
        if (!TextUtils.isEmpty(strM48289a)) {
            return "cn".equalsIgnoreCase(strM48289a);
        }
        String strM48289a2 = m48289a("ro.product.locale");
        if (!TextUtils.isEmpty(strM48289a2)) {
            return strM48289a2.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String strM48322d = m48322d();
        if (TextUtils.isEmpty(strM48322d)) {
            return false;
        }
        return "cn".equalsIgnoreCase(strM48322d);
    }

    /* renamed from: h */
    public static boolean m48332h() {
        return m48315c() && !Constants.URDU_LANG.equalsIgnoreCase(Locale.getDefault().getLanguage());
    }

    /* renamed from: a */
    private static int m48285a(WindowManager windowManager, int i10) {
        return Math.abs(windowManager.getDefaultDisplay().getWidth()) < Math.abs(windowManager.getDefaultDisplay().getHeight()) ? m48314c(i10) : m48319d(i10);
    }

    /* renamed from: b */
    public static void m48307b(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, i10);
            activity.getWindow().setAttributes(attributes);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("SystemUtil", "setLayoutMode error");
        }
    }

    /* renamed from: c */
    public static boolean m48316c(Activity activity) {
        ComponentName componentName;
        if (activity == null) {
            AbstractC7185ho.m43817a("SystemUtil", "activity is null, not foreground");
            return false;
        }
        try {
            List<ActivityManager.RunningTaskInfo> listM47547a = AbstractC7741ao.m47547a((ActivityManager) activity.getSystemService("activity"));
            if (listM47547a == null || listM47547a.size() <= 0) {
                AbstractC7185ho.m43817a("SystemUtil", "taskInfoList is empty, not foreground");
                return false;
            }
            ActivityManager.RunningTaskInfo runningTaskInfo = listM47547a.get(0);
            if (runningTaskInfo != null && (componentName = runningTaskInfo.topActivity) != null) {
                if (!componentName.getPackageName().equals(activity.getPackageName())) {
                    return false;
                }
                AbstractC7185ho.m43818a("SystemUtil", "topActivity: %s, checkActivity: %s", runningTaskInfo.topActivity.getClassName(), activity.getClass().getName());
                return AbstractC7806cz.m48173e(runningTaskInfo.topActivity.getClassName(), activity.getClass().getName());
            }
            AbstractC7185ho.m43817a("SystemUtil", "taskInfo is null, not foreground");
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SystemUtil", "isActivityForeground ex: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: d */
    public static Context m48321d(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
            return identifier > 0 ? new ContextThemeWrapper(context, identifier) : context;
        } catch (RuntimeException unused) {
            AbstractC7185ho.m43823c("SystemUtil", "getEMUIAppContext exception");
            return context;
        }
    }

    /* renamed from: e */
    public static String m48325e(View view) {
        int[] iArrM48328f = m48328f(view);
        return String.format("%s,%s", Integer.valueOf(iArrM48328f[0]), Integer.valueOf(iArrM48328f[1]));
    }

    /* renamed from: f */
    private static int[] m48328f(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    /* renamed from: a */
    public static int m48286a(boolean z10) {
        return m48287a(false, z10);
    }

    /* renamed from: b */
    public static boolean m48308b() {
        return true;
    }

    /* renamed from: c */
    public static boolean m48317c(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.isFinishing() || activity.isDestroyed();
    }

    /* renamed from: d */
    public static String m48322d() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    /* renamed from: a */
    public static int m48287a(boolean z10, boolean z11) {
        return z11 ? z10 ? C6849R.drawable.hiad_linked_voice_off : C6849R.drawable.hiad_video_mute : z10 ? C6849R.drawable.hiad_linked_voice_on : C6849R.drawable.hiad_video_unmute;
    }

    /* renamed from: b */
    public static boolean m48309b(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return C6985cb.m41166a(activity.getApplicationContext()).mo41204a(activity);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("SystemUtil", "isFreedomWindowMode error");
            return false;
        }
    }

    /* renamed from: c */
    public static int[] m48318c(View view) {
        return !m48302a(view) ? new int[0] : new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    /* renamed from: a */
    public static String m48288a(InterfaceC7337jk interfaceC7337jk) {
        int[] iArrM48313b = m48313b(interfaceC7337jk);
        return String.format("%s,%s", Integer.valueOf(iArrM48313b[0]), Integer.valueOf(iArrM48313b[1]));
    }

    /* renamed from: b */
    public static boolean m48310b(Context context) {
        KeyguardManager keyguardManager;
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    /* renamed from: a */
    public static String m48289a(String str) {
        StringBuilder sb2;
        String str2;
        Class<?> cls;
        try {
            try {
                cls = Class.forName(AbstractC7807d.m48232d() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
            } catch (RuntimeException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str2 = "getSystemProperties RuntimeException:";
                sb2.append(str2);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("SystemUtil", sb2.toString());
                return null;
            } catch (Throwable th2) {
                e = th2;
                sb2 = new StringBuilder();
                str2 = "getSystemProperties Exception:";
                sb2.append(str2);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("SystemUtil", sb2.toString());
                return null;
            }
        } catch (ClassNotFoundException unused) {
            cls = Class.forName("android.os.SystemProperties");
        }
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    /* renamed from: b */
    public static boolean m48311b(Context context, Intent intent) {
        try {
            return !AbstractC7760bg.m47767a(context.getPackageManager().queryIntentActivities(intent, 0));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SystemUtil", "isIntentAvailable: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static void m48290a(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        try {
            activity.setRequestedOrientation(i10);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("SystemUtil", "set Requested Orientation Exception: " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public static int[] m48312b(View view) {
        if (!m48302a(view)) {
            return new int[0];
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    /* renamed from: a */
    public static void m48291a(Activity activity, Context context) {
        if (context == null || activity == null) {
            AbstractC7185ho.m43823c("SystemUtil", "para is null");
            return;
        }
        Activity activityM48350z = m48350z(context);
        if (activityM48350z == null) {
            AbstractC7185ho.m43823c("SystemUtil", "parent activity is null");
            return;
        }
        Window window = activityM48350z.getWindow();
        Window window2 = activity.getWindow();
        if (window == null || window2 == null) {
            AbstractC7185ho.m43823c("SystemUtil", "window is null");
            return;
        }
        WindowManager.LayoutParams attributes = window2.getAttributes();
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        attributes.flags = attributes2.flags;
        if (!WhiteListPkgList.isHwBrowserPkgName(context.getPackageName())) {
            attributes.flags |= HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK;
        }
        attributes.layoutInDisplayCutoutMode = attributes2.layoutInDisplayCutoutMode;
        window2.setAttributes(attributes);
        window2.setNavigationBarColor(window.getNavigationBarColor());
        View decorView = window.getDecorView();
        View decorView2 = window2.getDecorView();
        if (decorView == null || decorView2 == null) {
            AbstractC7185ho.m43823c("SystemUtil", "decorView is null");
        } else {
            decorView2.setSystemUiVisibility(decorView.getSystemUiVisibility());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private static int[] m48313b(InterfaceC7337jk interfaceC7337jk) {
        return m48328f(interfaceC7337jk instanceof View ? (View) interfaceC7337jk : null);
    }

    /* renamed from: a */
    public static void m48292a(Activity activity, InterfaceC8069ad interfaceC8069ad) {
        if (activity == null || !C6982bz.m41152b(activity)) {
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            AbstractC7185ho.m43823c("SystemUtil", "get safe padding, window is null");
            return;
        }
        try {
            InterfaceC7000cq interfaceC7000cqM41166a = C6985cb.m41166a(activity);
            interfaceC7000cqM41166a.mo41203a(window.getAttributes());
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.dd.2

                /* renamed from: b */
                final /* synthetic */ InterfaceC8069ad f36086b;

                public AnonymousClass2(InterfaceC8069ad interfaceC8069ad2) {
                    interfaceC8069ad = interfaceC8069ad2;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    String str;
                    InterfaceC8069ad interfaceC8069ad2;
                    try {
                        Rect rectMo41200a = interfaceC7000cq.mo41200a(windowInsets);
                        if (AbstractC7185ho.m43819a()) {
                            Object[] objArr = new Object[1];
                            objArr[0] = Integer.valueOf(rectMo41200a == null ? 0 : rectMo41200a.right);
                            AbstractC7185ho.m43818a("SystemUtil", "got safe padding: %s", objArr);
                        }
                        if (rectMo41200a != null && (interfaceC8069ad2 = interfaceC8069ad) != null) {
                            interfaceC8069ad2.mo38783a(rectMo41200a.right);
                        }
                    } catch (NoSuchMethodError unused) {
                        str = "getRingScreenSafePadding NoSuchMethodError getDisplaySideRegion";
                        AbstractC7185ho.m43823c("SystemUtil", str);
                        return windowInsets;
                    } catch (Throwable th2) {
                        str = "getRingScreenSafePadding error:" + th2.getClass().getSimpleName();
                        AbstractC7185ho.m43823c("SystemUtil", str);
                        return windowInsets;
                    }
                    return windowInsets;
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SystemUtil", "getSafePadding ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m48293a(Context context, int i10, View view) {
        if (context == null || view == null) {
            return;
        }
        try {
            if (C6982bz.m41148a(context).mo41171a(context) || !m48298a(i10)) {
                return;
            }
            int iM47583h = AbstractC7741ao.m47583h(context);
            AbstractC7185ho.m43821b("SystemUtil", "top:%s", Integer.valueOf(iM47583h));
            view.setPadding(0, iM47583h, 0, 0);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("SystemUtil", "adaptStatusBar error:" + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m48294a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("SystemUtil", "start activity error");
        }
    }

    /* renamed from: a */
    public static void m48295a(View view, Activity activity) {
        String str;
        String str2;
        if (activity == null) {
            str2 = "has no activity";
        } else if (!C6982bz.m41152b(activity)) {
            str2 = "not huawei phone";
        } else if (view == null) {
            str2 = "has no rootview";
        } else if (m48309b(activity)) {
            str2 = "freedom window";
        } else {
            Window window = activity.getWindow();
            if (window != null) {
                try {
                    InterfaceC7000cq interfaceC7000cqM41166a = C6985cb.m41166a(activity);
                    interfaceC7000cqM41166a.mo41203a(window.getAttributes());
                    window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.dd.1

                        /* renamed from: b */
                        final /* synthetic */ View f36084b;

                        public AnonymousClass1(View view2) {
                            view = view2;
                        }

                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                            String str3;
                            View view22;
                            try {
                                Rect rectMo41200a = interfaceC7000cq.mo41200a(windowInsets);
                                if (rectMo41200a != null && (view22 = view) != null) {
                                    view22.setPadding(rectMo41200a.left, 0, rectMo41200a.right, 0);
                                }
                            } catch (NoSuchMethodError unused) {
                                str3 = "initOnApplyWindowInsets NoSuchMethodError getDisplaySideRegion";
                                AbstractC7185ho.m43823c("SystemUtil", str3);
                                return windowInsets;
                            } catch (Throwable th2) {
                                str3 = "initOnApplyWindowInsets error:" + th2.getClass().getSimpleName();
                                AbstractC7185ho.m43823c("SystemUtil", str3);
                                return windowInsets;
                            }
                            return windowInsets;
                        }
                    });
                    return;
                } catch (NoSuchMethodError unused) {
                    str = "adaptRingScreen NoSuchMethodError setDisplaySideMode";
                    AbstractC7185ho.m43823c("SystemUtil", str);
                    return;
                } catch (Throwable th2) {
                    str = "adaptRingScreen error:" + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("SystemUtil", str);
                    return;
                }
            }
            str2 = "has no window";
        }
        AbstractC7185ho.m43823c("SystemUtil", str2);
    }

    /* renamed from: a */
    public static void m48296a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setScaleX(m48315c() ? -1.0f : 1.0f);
    }

    /* renamed from: a */
    public static boolean m48297a() {
        return true;
    }

    /* renamed from: a */
    public static boolean m48298a(int i10) {
        return 1 == i10 || 9 == i10;
    }

    /* renamed from: a */
    public static boolean m48299a(int i10, int i11, int i12, int i13, int i14) {
        return Math.abs(i10 - i12) > i14 || Math.abs(i11 - i13) > i14;
    }

    /* renamed from: a */
    public static boolean m48300a(Activity activity) {
        return m48337m(activity) && !m48309b(activity);
    }

    /* renamed from: a */
    public static boolean m48301a(Context context) {
        PowerManager powerManager;
        if (context != null && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
            try {
                return powerManager.isInteractive();
            } catch (Exception unused) {
                AbstractC7185ho.m43823c("SystemUtil", "isScreenInteractive has exception");
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m48302a(View view) {
        return view != null && view.getVisibility() == 0;
    }

    /* renamed from: a */
    public static boolean m48303a(View view, int i10) {
        return C7822do.m48383a(view, i10, 300, 0);
    }

    /* renamed from: a */
    public static boolean m48304a(View view, boolean z10) {
        int i10 = z10 ? 0 : 8;
        if (view == null || view.getVisibility() == i10) {
            return false;
        }
        view.setVisibility(i10);
        return true;
    }
}
