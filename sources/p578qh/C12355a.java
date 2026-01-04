package p578qh;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.HashMap;
import java.util.Map;
import th.C13012a;

/* renamed from: qh.a */
/* loaded from: classes4.dex */
public class C12355a {

    /* renamed from: a */
    public static Map<String, Object> f57156a = new HashMap();

    /* renamed from: a */
    public static int m74361a(Context context) {
        if (m74370j(context)) {
            return 1;
        }
        if (m74372l(context)) {
            return 2;
        }
        return m74374n(context) ? 7 : 0;
    }

    /* renamed from: b */
    public static String m74362b() {
        return C12359e.m74386b(SystemUtils.PRODUCT_BRAND);
    }

    /* renamed from: c */
    public static DisplayMetrics m74363c(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: d */
    public static String m74364d() {
        return String.valueOf(Build.DISPLAY);
    }

    /* renamed from: e */
    public static int m74365e() throws ClassNotFoundException {
        int iM74385a;
        try {
            iM74385a = Build.VERSION.MAGIC_SDK_INT;
        } catch (Error | Exception unused) {
            iM74385a = C12359e.m74385a("ro.build.magic_api_level", 0);
        }
        C13012a.m78318d("DeviceUtil", "magicApiLevel:" + iM74385a);
        return iM74385a;
    }

    /* renamed from: f */
    public static String m74366f(Context context) {
        String str = (String) f57156a.get("RESOLUTION");
        if (str != null) {
            return str;
        }
        m74375o(context);
        return (String) f57156a.get("RESOLUTION");
    }

    /* renamed from: g */
    public static String m74367g() {
        String strM74387c;
        try {
            strM74387c = com.hihonor.android.os.Build.MAGIC_VERSION;
        } catch (Error | Exception unused) {
            strM74387c = C12359e.m74387c("ro.build.version.magic", "");
        }
        C13012a.m78318d("DeviceUtil", "magicVer:" + strM74387c);
        return strM74387c;
    }

    /* renamed from: h */
    public static String m74368h(Context context) {
        String str = (String) f57156a.get("DPI");
        if (str != null) {
            return str;
        }
        m74375o(context);
        return (String) f57156a.get("DPI");
    }

    /* renamed from: i */
    public static String m74369i() {
        String strM74386b = C12359e.m74386b("ro.product.hw_model");
        if (TextUtils.isEmpty(strM74386b)) {
            strM74386b = C12359e.m74386b("ro.product.hn_model");
            if (TextUtils.isEmpty(strM74386b)) {
                strM74386b = android.os.Build.MODEL;
            }
        }
        C13012a.m78318d("DeviceUtil", "phoneType:" + strM74386b);
        return strM74386b;
    }

    /* renamed from: j */
    public static boolean m74370j(Context context) {
        String str;
        if (context == null) {
            str = "isTelevision: context is null!";
        } else {
            Resources resources = context.getResources();
            if (resources != null) {
                return (resources.getConfiguration().uiMode & 15) == 4;
            }
            str = "isTelevision: resource is null!";
        }
        C13012a.m78317c("DeviceUtil", str);
        return false;
    }

    /* renamed from: k */
    public static int m74371k() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: l */
    public static boolean m74372l(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    /* renamed from: m */
    public static int m74373m() {
        Integer num = (Integer) f57156a.get("SystemBit");
        if (num != null) {
            return num.intValue();
        }
        Integer numValueOf = Integer.valueOf(C12359e.m74387c("ro.product.cpu.abi", "").contains("arm64") ? 2 : 1);
        f57156a.put("SystemBit", numValueOf);
        return numValueOf.intValue();
    }

    /* renamed from: n */
    public static boolean m74374n(Context context) {
        return context.getPackageManager().hasSystemFeature("com.huawei.software.features.car");
    }

    /* renamed from: o */
    public static void m74375o(Context context) {
        DisplayMetrics displayMetricsM74363c = m74363c(context);
        if (displayMetricsM74363c != null) {
            f57156a.put("DPI", String.valueOf(displayMetricsM74363c.densityDpi));
            String strValueOf = String.valueOf(displayMetricsM74363c.widthPixels);
            String strValueOf2 = String.valueOf(displayMetricsM74363c.heightPixels);
            f57156a.put("RESOLUTION", strValueOf + "_" + strValueOf2);
        }
    }

    /* renamed from: p */
    public static boolean m74376p() {
        String str;
        try {
            return C12359e.m74388d("hw_sc.product.useBrandCust", false);
        } catch (RuntimeException unused) {
            str = "get isUseBrandCust fail: RuntimeException";
            C13012a.m78318d("DeviceUtil", str);
            return false;
        } catch (Exception unused2) {
            str = "get isUseBrandCust fail: Exception";
            C13012a.m78318d("DeviceUtil", str);
            return false;
        }
    }
}
