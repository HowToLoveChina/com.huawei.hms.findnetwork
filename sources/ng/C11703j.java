package ng;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Window;
import android.webkit.WebView;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeBase64;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0219i;
import p783xp.C13843a;
import p809yg.C13981a;

/* renamed from: ng.j */
/* loaded from: classes4.dex */
public class C11703j {
    /* renamed from: a */
    public static void m69805a(Activity activity, boolean z10) {
        if (activity == null) {
            C13981a.m83988e("WapCommonUtil", "window null");
        } else if (z10) {
            C11700g.m69773d(activity);
        } else {
            C11700g.m69778i(activity);
        }
    }

    /* renamed from: b */
    public static String m69806b(Uri uri) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        try {
            Iterator<String> it = uri.getQueryParameterNames().iterator();
            while (it.hasNext()) {
                builderBuildUpon.appendQueryParameter(it.next(), "");
            }
            return builderBuildUpon.build().toString();
        } catch (Exception unused) {
            C13981a.m83988e("WapCommonUtil", "UnsupportedOperationException occurred");
            return "";
        }
    }

    /* renamed from: c */
    public static String m69807c(String str) {
        if (str != null && str.length() != 0) {
            String strM69806b = m69806b(Uri.parse(str));
            if (!TextUtils.isEmpty(strM69806b)) {
                return strM69806b;
            }
        }
        return str;
    }

    /* renamed from: d */
    public static String m69808d(int i10, int i11, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i10);
            jSONObject.put("tabLocation", i11);
            jSONObject.put("id", str);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("WapCommonUtil", "JsonException");
            return "";
        }
    }

    /* renamed from: e */
    public static String m69809e(int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i10);
            jSONObject.put("id", str);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("WapCommonUtil", "JsonException");
            return "";
        }
    }

    /* renamed from: f */
    public static String m69810f(Locale locale, String str) {
        if ("zh".equals(str)) {
            String languageTag = locale.toLanguageTag();
            return TextUtils.isEmpty(languageTag) ? FeedbackConst.SDK.EMUI_LANGUAGE : languageTag.toLowerCase(Locale.ENGLISH);
        }
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return str.toLowerCase(Locale.ENGLISH);
        }
        StringBuilder sb2 = new StringBuilder();
        Locale locale2 = Locale.ENGLISH;
        sb2.append(str.toLowerCase(locale2));
        sb2.append("-");
        sb2.append(country.toLowerCase(locale2));
        return sb2.toString();
    }

    /* renamed from: g */
    public static String m69811g(String str) {
        try {
            return new URL(str).getPath();
        } catch (Exception e10) {
            C13981a.m83988e("WapCommonUtil", "parse url error:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: h */
    public static String m69812h() {
        String strM1164E = C0209d.m1164E();
        if (TextUtils.isEmpty(strM1164E)) {
            strM1164E = "HUAWEI";
        }
        return strM1164E.toUpperCase(Locale.getDefault());
    }

    /* renamed from: i */
    public static String m69813i() {
        String strM1323x = C0209d.m1323x();
        C13981a.m83987d("WapCommonUtil", "romVersion is:" + strM1323x);
        if (TextUtils.isEmpty(strM1323x)) {
            strM1323x = Build.DISPLAY;
        }
        return strM1323x.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "");
    }

    /* renamed from: j */
    public static String m69814j() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            C13981a.m83988e("WapCommonUtil", "getStdLanguageCode, getDefault locale failed");
            return FeedbackConst.SDK.EMUI_LANGUAGE;
        }
        String language = locale.getLanguage();
        if (!TextUtils.isEmpty(language)) {
            return m69810f(locale, language);
        }
        C13981a.m83988e("WapCommonUtil", "getStdLanguageCode, getLanguage failed");
        return FeedbackConst.SDK.EMUI_LANGUAGE;
    }

    /* renamed from: k */
    public static boolean m69815k(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            C13981a.m83990w("WapCommonUtil", str + " not install");
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: l */
    public static boolean m69816l(Context context) {
        if (context == null) {
            C13981a.m83988e("WapCommonUtil", "isDarkModeCompat context null");
            return false;
        }
        try {
        } catch (Exception e10) {
            C13981a.m83988e("WapCommonUtil", "getDarkMode exception:" + e10.getMessage());
        }
        if (21 >= C0219i.m1463a()) {
            C13981a.m83989i("WapCommonUtil", "dark mode is not support");
            return false;
        }
        PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
        if (currentWebViewPackage != null && !"com.google.android.webview".equals(currentWebViewPackage.packageName)) {
            if (C0219i.m1463a() >= 21) {
                return m69818n(context);
            }
            return false;
        }
        C13981a.m83989i("WapCommonUtil", "webview is not support dark");
        return false;
    }

    /* renamed from: m */
    public static boolean m69817m(Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        try {
            return powerManager.isInteractive();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m69818n(Context context) {
        Resources resources;
        Configuration configuration;
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            z = (configuration.uiMode & 48) == 32;
            C13981a.m83989i("WapCommonUtil", "isDarkModeCompat isNightMode:" + z);
        }
        return z;
    }

    /* renamed from: o */
    public static void m69819o(Context context, String str) {
        C13981a.m83989i("WapCommonUtil", "jumpMarketDownloadApp, packageName: " + str);
        if (context == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("WapCommonUtil", "jumpMarketDownloadApp fail");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent("com.huawei.appmarket.intent.action.AppDetail"));
        C0209d.m1302r2(safeIntent, C13843a.m83090l());
        safeIntent.putExtra("APP_PACKAGENAME", str);
        try {
            context.startActivity(safeIntent);
        } catch (Exception e10) {
            C13981a.m83988e("WapCommonUtil", "jumpMarketDownloadApp error: " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public static void m69820p(Activity activity, String str) {
        if (activity == null || str == null) {
            return;
        }
        C13981a.m83989i("WapCommonUtil", "jump to third app");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            activity.startActivityIfNeeded(intent, -1);
        } catch (ActivityNotFoundException unused) {
            C13981a.m83988e("WapCommonUtil", "ActivityNotFoundException:" + m69807c(str));
        }
    }

    /* renamed from: q */
    public static Map<String, String> m69821q(String str, String str2) throws UnsupportedEncodingException {
        int i10;
        String strSubstring;
        HashMap map = new HashMap(3);
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("WapCommonUtil", "paramUrl is empty");
            return new HashMap();
        }
        int i11 = 0;
        while (true) {
            int iIndexOf = str.indexOf("&", i11);
            int i12 = iIndexOf + 1;
            if (i12 > 0) {
                strSubstring = str.substring(i11, iIndexOf);
                i10 = i12;
            } else {
                i10 = i11;
                strSubstring = str.substring(i11);
            }
            String[] strArrSplit = strSubstring.split("=");
            String str3 = strArrSplit[0];
            String strDecode = strArrSplit.length == 1 ? "" : strArrSplit[1];
            try {
                strDecode = URLDecoder.decode(strDecode, str2);
            } catch (Exception unused) {
                C13981a.m83990w("WapCommonUtil", "decode value fail");
            }
            map.put(str3, strDecode);
            if (i12 <= 0) {
                return map;
            }
            i11 = i10;
        }
    }

    /* renamed from: r */
    public static Map<String, String> m69822r(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("WapCommonUtil", "wapUrl is empty");
            return new HashMap();
        }
        HashMap map = new HashMap(3);
        int iIndexOf = str.trim().indexOf(Constants.QUESTION_STR);
        if (iIndexOf == -1) {
            iIndexOf = str.length();
            C13981a.m83990w("WapCommonUtil", "wapUrl has not params");
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = iIndexOf < str.length() ? str.substring(iIndexOf + 1, str.length()) : "";
        String[] strArrSplit = strSubstring.split("//");
        if (strArrSplit.length < 2) {
            C13981a.m83988e("WapCommonUtil", "wapUrl action is empty");
            return new HashMap();
        }
        map.put(Constants.CONTENT_SERVER_REALM, strArrSplit[1]);
        Map<String, String> mapM69821q = m69821q(strSubstring2, "utf-8");
        if (mapM69821q.size() > 0) {
            map.putAll(mapM69821q);
        }
        return map;
    }

    /* renamed from: s */
    public static String m69823s(String str, String str2) {
        if (C11702i.m69797m(str)) {
            return "";
        }
        if (str != null && str.startsWith("phonefinder:")) {
            return "";
        }
        String strM69811g = m69811g(str);
        if (!TextUtils.isEmpty(strM69811g)) {
            if (strM69811g.startsWith("/CAS/mobile/atLogin.html") || strM69811g.startsWith("/CAS/logout") || strM69811g.startsWith("/findDevice/wapLogoutToLoginPage")) {
                return "";
            }
            if ((strM69811g.startsWith("/AMW/portal/agreements/userAgreement") || strM69811g.startsWith("/AMW/portal/agreements/accPrivacyStatement")) && TextUtils.isEmpty(StringUtil.filterInvisibleStr(str2))) {
                return " ";
            }
        }
        return (str2 == null || !(str2.equals(str) || str2.startsWith("http") || str2.startsWith("https"))) ? str2 : "";
    }

    /* renamed from: t */
    public static String m69824t(String str) {
        int port;
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            port = Uri.parse(str).getPort();
        } catch (Exception e10) {
            C13981a.m83988e("WapCommonUtil", e10.getMessage());
            port = -1;
        }
        if (port < 0) {
            return str;
        }
        String str2 = ":" + port;
        return str.contains(str2) ? str.replace(str2, "") : str;
    }

    /* renamed from: u */
    public static void m69825u(Context context, boolean z10) {
        if (context == null) {
            C13981a.m83988e("WapCommonUtil", "setNet context is null");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent());
        if (z10) {
            safeIntent.setFlags(ARImageMetadata.LENS_APERTURE);
        }
        safeIntent.setAction("android.settings.WIRELESS_SETTINGS");
        safeIntent.putExtra("use_emui_ui", true);
        try {
            context.startActivity(safeIntent);
        } catch (ActivityNotFoundException unused) {
            C13981a.m83988e("WapCommonUtil", "startActivity: setNet failed");
        }
    }

    /* renamed from: v */
    public static void m69826v(Window window, boolean z10) {
        if (window == null) {
            C13981a.m83988e("WapCommonUtil", "window null");
            return;
        }
        if (z10) {
            if ((window.getAttributes().flags & 8192) != 0) {
                C13981a.m83989i("WapCommonUtil", "flag already set secure");
                return;
            } else {
                window.addFlags(8192);
                C11700g.m69772c(window);
                return;
            }
        }
        if ((window.getAttributes().flags & 8192) == 0) {
            C13981a.m83989i("WapCommonUtil", "flag already set not secure");
        } else {
            window.clearFlags(8192);
            C11700g.m69774e(window);
        }
    }

    /* renamed from: w */
    public static String m69827w(String str) {
        return TextUtils.isEmpty(str) ? str : SafeBase64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 2);
    }
}
