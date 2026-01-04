package com.huawei.updatesdk.p177a.p178a.p183d.p184i;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.android.app.PackageManagerEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.system.BuildEx;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.C8781c;
import com.huawei.updatesdk.p177a.p178a.p183d.C8784f;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p201h.C8833a;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.updatesdk.a.a.d.i.c */
/* loaded from: classes9.dex */
public class C8789c {

    /* renamed from: e */
    private static int f45089e = -1;

    /* renamed from: a */
    private int f45095a;

    /* renamed from: b */
    private int f45096b;

    /* renamed from: c */
    private int f45097c;

    /* renamed from: f */
    private static C8789c f45090f = new C8789c();

    /* renamed from: g */
    private static String f45091g = null;

    /* renamed from: d */
    public static final String f45088d = m56089a(SystemUtils.PRODUCT_BRAND, "");

    /* renamed from: h */
    public static final boolean f45092h = m56095a("hw_sc.product.useBrandCust", false);

    /* renamed from: i */
    public static final int f45093i = m56086a(SystemProperties.HW_SC_BUILD_OS_API_VERSION, 0);

    /* renamed from: j */
    public static final String f45094j = m56108h();

    private C8789c() {
        this.f45095a = 0;
        if (m56086a("ro.maple.enable", 0) == 1) {
            this.f45095a = 1;
        }
        this.f45096b = m56086a("ro.build.version.ark", 0);
        this.f45097c = m56086a("ro.kernel.evox", 0);
    }

    /* renamed from: d */
    public static String m56100d() {
        try {
            Object obj = Class.forName("com.huawei.system.BuildEx").getField("DISPLAY").get(null);
            return obj == null ? Build.DISPLAY : obj.toString();
        } catch (Throwable unused) {
            return Build.DISPLAY;
        }
    }

    /* renamed from: e */
    public static int m56102e() {
        int i10 = f45089e;
        if (i10 >= 0) {
            return i10;
        }
        Context contextM56133a = C8793a.m56132c().m56133a();
        f45089e = m56115k(contextM56133a) ? 1 : m56117l(contextM56133a) ? 2 : m56109h(contextM56133a) ? 3 : m56118m() ? 4 : m56110i(contextM56133a) ? 7 : 0;
        return f45089e;
    }

    /* renamed from: f */
    public static int m56104f(Context context) {
        try {
            return Integer.parseInt(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionCode + "");
        } catch (Exception unused) {
            return 1;
        }
    }

    /* renamed from: g */
    public static String m56106g() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        String script = locale.getScript();
        if (TextUtils.isEmpty(script) && TextUtils.isEmpty(variant)) {
            return language + "_" + country;
        }
        return language + "_" + script + "_" + country + "_" + variant;
    }

    /* renamed from: h */
    private static String m56108h() {
        try {
            return BuildEx.getOsBrand();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: i */
    private static boolean m56110i(Context context) {
        return context.getPackageManager().hasSystemFeature("com.huawei.software.features.car");
    }

    /* renamed from: j */
    public static int m56112j() {
        return m56089a("ro.product.cpu.abi", "").contains("arm64") ? 2 : 1;
    }

    /* renamed from: k */
    public static String m56114k() {
        String language;
        String script;
        String country;
        Locale locale = Locale.getDefault();
        if (locale != null) {
            language = locale.getLanguage();
            script = locale.getScript();
            country = locale.getCountry();
        } else {
            language = FaqConstants.DEFAULT_ISO_LANGUAGE;
            script = "";
            country = "US";
        }
        if (TextUtils.isEmpty(script)) {
            return language + "_" + country;
        }
        return language + "_" + script + "_" + country;
    }

    /* renamed from: l */
    public static boolean m56116l() {
        return C8833a.m56305f().m56308a() > 0 || C8833a.m56305f().m56309b() > 0;
    }

    /* renamed from: m */
    private static boolean m56118m() {
        return m56094a("com.huawei.software.features.kidpad");
    }

    /* renamed from: a */
    public int m56119a() {
        return this.f45095a;
    }

    /* renamed from: b */
    public int m56121b() {
        return this.f45096b;
    }

    /* renamed from: c */
    public int m56122c() {
        return this.f45097c;
    }

    /* renamed from: a */
    public static int m56086a(String str, int i10) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i10))).intValue();
        } catch (Throwable th2) {
            C8777a.m56027a("DeviceUtil", "Exception while getting system property: ", th2);
            return i10;
        }
    }

    /* renamed from: b */
    private static DisplayMetrics m56097b(Context context) {
        Display defaultDisplay;
        Object systemService = context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: c */
    public static List<String> m56099c(Context context) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        for (int i10 = 0; i10 < locales.size(); i10++) {
            String language = locales.get(i10).getLanguage();
            if (!TextUtils.isEmpty(language) && !arrayList.contains(language)) {
                arrayList.add(language);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static String m56101d(Context context) {
        DisplayMetrics displayMetricsM56097b = m56097b(context);
        if (displayMetricsM56097b == null) {
            return "";
        }
        return String.valueOf(displayMetricsM56097b.widthPixels) + "_" + String.valueOf(displayMetricsM56097b.heightPixels);
    }

    /* renamed from: e */
    public static String m56103e(Context context) {
        DisplayMetrics displayMetricsM56097b = m56097b(context);
        return displayMetricsM56097b != null ? String.valueOf(displayMetricsM56097b.densityDpi) : "";
    }

    /* renamed from: f */
    public static C8789c m56105f() {
        return f45090f;
    }

    /* renamed from: g */
    public static String m56107g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName + "";
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: h */
    private static boolean m56109h(Context context) {
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
        return !zHasSystemFeature ? C8834b.m56324d(context, "com.huawei.appmarket.car.bmw") != null : zHasSystemFeature;
    }

    /* renamed from: i */
    public static String[] m56111i() {
        String[] strArr = Build.SUPPORTED_ABIS;
        return strArr == null ? new String[0] : strArr;
    }

    /* renamed from: j */
    public static boolean m56113j(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.gsf.login", 16);
            packageManager.getPackageInfo("com.google.android.gsf", 16);
            return (packageManager.getPackageInfo(Constants.GMS_PGK, 16).applicationInfo.flags & 1) != 0;
        } catch (Exception e10) {
            C8777a.m56030d("DeviceUtil", e10.getMessage());
            return false;
        }
    }

    /* renamed from: k */
    private static boolean m56115k(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        C8774a.m56009b("DeviceUtil", "UI mode: " + uiModeManager.getCurrentModeType());
        return uiModeManager.getCurrentModeType() == 4;
    }

    /* renamed from: l */
    private static boolean m56117l(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    /* renamed from: a */
    public static String m56087a(Context context) {
        if (f45091g == null) {
            ArrayList arrayList = new ArrayList();
            m56091a(context, arrayList);
            m56092a(arrayList);
            f45091g = C8784f.m56056a(arrayList, ",");
        }
        return f45091g;
    }

    /* renamed from: b */
    public static String m56098b(Context context, String str) {
        String strM56088a = m56088a(context, str);
        int i10 = 0;
        int i11 = 0;
        while (i10 < strM56088a.length() && i11 < 3) {
            if (strM56088a.charAt(i10) == '.') {
                i11++;
            }
            i10++;
        }
        return 3 == i11 ? strM56088a.substring(0, i10 - 1) : strM56088a;
    }

    /* renamed from: a */
    public static String m56088a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 16).versionName + "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m56089a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th2) {
            C8777a.m56027a("DeviceUtil", "Exception while getting system property: ", th2);
            return str2;
        }
    }

    /* renamed from: a */
    public static List<String> m56090a(List<String> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!m56096a(str, strArr)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m56091a(Context context, List<String> list) {
        m56093a(context.getPackageManager().getSystemAvailableFeatures(), list);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0044 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #0 {all -> 0x003e, blocks: (B:40:0x001e, B:46:0x0039, B:52:0x0044, B:54:0x0059, B:43:0x002d), top: B:58:0x001e }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m56120a(android.view.Window r6) {
        /*
            r5 = this;
            com.huawei.updatesdk.b.h.a r5 = com.huawei.updatesdk.p191b.p201h.C8833a.m56305f()
            int r5 = r5.m56308a()
            r0 = 21
            if (r5 >= r0) goto L16
            com.huawei.updatesdk.b.h.a r5 = com.huawei.updatesdk.p191b.p201h.C8833a.m56305f()
            int r5 = r5.m56309b()
            if (r5 <= 0) goto L18
        L16:
            if (r6 != 0) goto L19
        L18:
            return
        L19:
            android.view.WindowManager$LayoutParams r5 = r6.getAttributes()
            r6 = 1
            r5.layoutInDisplayCutoutMode = r6     // Catch: java.lang.Throwable -> L3e
            com.huawei.updatesdk.b.h.a r0 = com.huawei.updatesdk.p191b.p201h.C8833a.m56305f()     // Catch: java.lang.Throwable -> L3e
            int r0 = r0.m56308a()     // Catch: java.lang.Throwable -> L3e
            if (r0 <= 0) goto L2d
            java.lang.String r0 = "com.huawei.android.view.WindowManagerEx$LayoutParamsEx"
            goto L39
        L2d:
            com.huawei.updatesdk.b.h.a r0 = com.huawei.updatesdk.p191b.p201h.C8833a.m56305f()     // Catch: java.lang.Throwable -> L3e
            int r0 = r0.m56309b()     // Catch: java.lang.Throwable -> L3e
            if (r0 <= 0) goto L40
            java.lang.String r0 = "com.hihonor.android.view.WindowManagerEx$LayoutParamsEx"
        L39:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L3e
            goto L41
        L3e:
            r5 = move-exception
            goto L6f
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L44
            return
        L44:
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> L3e
            java.lang.Class<android.view.WindowManager$LayoutParams> r2 = android.view.WindowManager.LayoutParams.class
            r3 = 0
            r1[r3] = r2     // Catch: java.lang.Throwable -> L3e
            java.lang.reflect.Constructor r1 = r0.getConstructor(r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r5 = r1.newInstance(r5)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = "setDisplaySideMode"
            java.lang.Class[] r2 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> L3e
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L3e
            r2[r3] = r4     // Catch: java.lang.Throwable -> L3e
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L3e
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L3e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L3e
            r1[r3] = r6     // Catch: java.lang.Throwable -> L3e
            r0.invoke(r5, r1)     // Catch: java.lang.Throwable -> L3e
            goto L89
        L6f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "setWindowDisplaySideMode exception: "
            r6.append(r0)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "DeviceUtil"
            com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a.m56028b(r6, r5)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c.m56120a(android.view.Window):void");
    }

    /* renamed from: a */
    private static void m56092a(List<String> list) {
        try {
            m56093a(PackageManagerEx.getHwSystemAvailableFeatures(), list);
        } catch (Throwable th2) {
            C8777a.m56029c("DeviceUtil", "initHwDeviceFeatures: " + th2.getMessage());
        }
    }

    /* renamed from: a */
    private static void m56093a(FeatureInfo[] featureInfoArr, List<String> list) {
        if (featureInfoArr != null) {
            for (FeatureInfo featureInfo : featureInfoArr) {
                String str = featureInfo.name;
                if (str != null) {
                    list.add(C8781c.m56037a(str));
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m56094a(String str) {
        try {
            return PackageManagerEx.hasHwSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m56095a(String str, boolean z10) {
        try {
            return ((Boolean) Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z10))).booleanValue();
        } catch (Throwable th2) {
            C8777a.m56027a("DeviceUtil", "Exception while getting system property: ", th2);
            return z10;
        }
    }

    /* renamed from: a */
    public static boolean m56096a(String str, String[] strArr) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (String str2 : strArr) {
            if (str2.startsWith("config.")) {
                i10 = 1;
            } else if (!str2.contains(".config.")) {
                i11++;
            }
            if (str2.endsWith("config." + str)) {
                i12++;
            }
        }
        return i10 + i11 == i12;
    }
}
