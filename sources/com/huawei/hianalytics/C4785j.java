package com.huawei.hianalytics;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.android.os.Build;
import com.huawei.hianalytics.C4785j;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DaoManager;
import com.huawei.hianalytics.core.transport.TransportHandlerFactory;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.util.SafeBase64;
import eu.C9560a;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.j */
/* loaded from: classes5.dex */
public class C4785j {

    /* renamed from: a */
    public static String f21833a;

    /* renamed from: a */
    public static long m28896a(String str, String str2, long j10) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            return j10;
        }
        SharedPreferences sharedPreferencesM28898a = m28898a(str);
        return sharedPreferencesM28898a != null ? sharedPreferencesM28898a.getLong(str2, j10) : j10;
    }

    /* renamed from: b */
    public static String m28930b(Context context) {
        String packageName;
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(m28944d())) {
            return m28944d();
        }
        try {
            packageName = Application.getProcessName();
        } catch (Exception unused) {
            HiLog.m28808e("HAUtils", "get process name error");
            packageName = context.getPackageName();
        }
        return TextUtils.isEmpty(packageName) ? "" : packageName;
    }

    /* renamed from: c */
    public static String m28941c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String strM28933b = m28933b("android.os.SystemProperties", str, str2);
        if (TextUtils.isEmpty(strM28933b)) {
            return m28933b(m28947e() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx", str, str2);
        }
        return strM28933b;
    }

    /* renamed from: d */
    public static String m28944d() {
        String str = C4782i.m28891a().m28893a().f21863o;
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public static boolean m28947e() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th2) {
            HiLog.m28808e("DeviceUtil", "isHonor6UpPhone error:" + th2.getClass());
            return false;
        }
    }

    /* renamed from: f */
    public static String m28948f() {
        try {
            return (String) (m28947e() ? Class.forName("com.hihonor.android.os.Build").getMethod("getUDID", new Class[0]) : Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0])).invoke(null, new Object[0]);
        } catch (Exception unused) {
            HiLog.m28808e("DeviceIdUtils", "getUDID failed");
            return "";
        }
    }

    /* renamed from: g */
    public static boolean m28950g() {
        return System.currentTimeMillis() - m28896a("global_v2", "lastMetricReportTime", 0L) < C4811w.m29047a().f21958a;
    }

    /* renamed from: h */
    public static boolean m28951h() {
        String strM28941c = m28941c("ro.build.characteristics", "");
        return "default".equals(strM28941c) || "tablet".equals(strM28941c);
    }

    /* renamed from: a */
    public static SharedPreferences m28897a(Context context, String str) {
        try {
            return context.getSharedPreferences(str, 0);
        } catch (Exception unused) {
            HiLog.m28808e("SharedPreUtils", "getSharedPreferences Exception");
            return null;
        }
    }

    /* renamed from: b */
    public static String m28931b(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /* renamed from: c */
    public static boolean m28943c(Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return true;
        }
        try {
            return powerManager.isInteractive();
        } catch (Exception unused) {
            HiLog.m28812w("DeviceUtil", "isScreenInteractive has exception");
            return true;
        }
    }

    /* renamed from: d */
    public static boolean m28945d() {
        C4790l c4790lM28893a = C4782i.m28891a().m28893a();
        if (TextUtils.isEmpty(c4790lM28893a.f21870v)) {
            c4790lM28893a.f21870v = m28941c("ro.build.hw_emui_api_level", "");
        }
        try {
            return Integer.parseInt(c4790lM28893a.f21870v) >= 29;
        } catch (Exception unused) {
            HiLog.m28812w("DeviceUtil", "Exception");
            return false;
        }
    }

    /* renamed from: e */
    public static String m28946e() {
        return C4782i.m28891a().m28893a().f21868t;
    }

    /* renamed from: f */
    public static boolean m28949f() {
        C4790l c4790lM28893a = C4782i.m28891a().m28893a();
        if (TextUtils.isEmpty(c4790lM28893a.f21869u)) {
            c4790lM28893a.f21869u = m28941c("hw_sc.build.platform.version", "");
        }
        return (TextUtils.isEmpty(c4790lM28893a.f21869u) ^ true) || m28942c();
    }

    /* renamed from: a */
    public static SharedPreferences m28898a(String str) {
        Context appContext = EnvUtils.getAppContext();
        if (appContext != null) {
            return m28897a(appContext, m28904a(appContext, str));
        }
        HiLog.m28808e("SharedPreUtils", "context is null");
        return null;
    }

    /* renamed from: b */
    public static boolean m28935b() {
        String strM28933b = m28933b("com.huawei.android.os.SystemPropertiesEx", CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
        if (!TextUtils.isEmpty(strM28933b)) {
            return "cn".equalsIgnoreCase(strM28933b);
        }
        String strM28933b2 = m28933b("com.huawei.android.os.SystemPropertiesEx", "ro.product.locale", "");
        if (!TextUtils.isEmpty(strM28933b2)) {
            return strM28933b2.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String country = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(country)) {
            return false;
        }
        return "cn".equalsIgnoreCase(country);
    }

    /* renamed from: c */
    public static String m28939c() {
        return C4782i.m28891a().m28893a().f21854f;
    }

    /* renamed from: a */
    public static Pair<String, Boolean> m28899a(Context context) {
        if (context == null) {
            return new Pair<>("", Boolean.FALSE);
        }
        ContentResolver contentResolver = context.getContentResolver();
        return new Pair<>(Settings.Global.getString(contentResolver, "pps_oaid"), Boolean.valueOf(Boolean.parseBoolean(Settings.Global.getString(contentResolver, "pps_track_limit"))));
    }

    @SuppressLint({"WrongConstant", "MissingPermission"})
    /* renamed from: b */
    public static boolean m28936b(Context context) {
        NetworkCapabilities networkCapabilities;
        if (!m28923a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            HiLog.m28811sw("DeviceUtil", "no network permission!");
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                if (!networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(3) && !networkCapabilities.hasTransport(7) && !networkCapabilities.hasTransport(4)) {
                    if (!networkCapabilities.hasCapability(16)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
            HiLog.m28808e("DeviceUtil", "cannot get network state, ensure permission in the manifest");
        }
        return false;
    }

    /* renamed from: c */
    public static synchronized String m28940c(Context context) {
        try {
            String str = C4782i.m28891a().m28893a().f21858j;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String string = "";
            if (context == null) {
                HiLog.m28808e("SharedPreUtils", "context is null");
                string = "";
            } else if (TextUtils.isEmpty("uuid") || TextUtils.isEmpty("global_v2")) {
                HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            } else {
                SharedPreferences sharedPreferencesM28897a = m28897a(context, m28904a(context, "global_v2"));
                if (sharedPreferencesM28897a != null) {
                    string = sharedPreferencesM28897a.getString("uuid", "");
                }
            }
            if (!TextUtils.isEmpty(string) && string.length() > 32) {
                String strM59677f = C9560a.m59677f("HiAnalytics_Sdk_Uuid_Sp_Key", string);
                if (!TextUtils.isEmpty(strM59677f)) {
                    m28914a(context, "global_v2", "uuid", strM59677f);
                    string = strM59677f;
                }
            }
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString().replace("-", "");
                C4782i.m28891a().m28893a().f21858j = string;
                m28914a(context, "global_v2", "uuid", string);
            } else {
                C4782i.m28891a().m28893a().f21858j = string;
            }
            return string;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public static C4728a1 m28900a(String str, String str2) {
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(str);
        if (c4750e1M28892a != null) {
            return c4750e1M28892a.m28826a(str2);
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m28937b(Context context, String str) {
        File file = new File(context.getFilesDir(), "../shared_prefs/" + m28904a(context, str) + ".xml");
        if (file.exists() && file.delete()) {
            HiLog.m28812w("SharedPreUtils", "delete sp file");
        }
        return file.exists() && file.delete();
    }

    /* renamed from: a */
    public static C4731b1 m28901a(String str, String str2) {
        C4728a1 c4728a1M28826a;
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(str);
        if (c4750e1M28892a == null || (c4728a1M28826a = c4750e1M28892a.m28826a(str2)) == null) {
            return null;
        }
        return c4728a1M28826a.m28744a();
    }

    /* renamed from: b */
    public static boolean m28938b(String str, String str2, String str3) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (TextUtils.isEmpty(str3)) {
                HiLog.m28809i("RUtils", "url is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JsbMapKeyNames.H5_USER_ID, "");
            jSONObject.put("userAttribute", new JSONObject());
            Response responseExecute = TransportHandlerFactory.create(str3, null, jSONObject.toString().getBytes(StandardCharsets.UTF_8), 1).execute();
            if (responseExecute.getHttpCode() != 200) {
                return false;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(responseExecute.getContent()).optJSONObject("result");
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("featureConfigValues")) != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                        if (jSONObjectOptJSONObject2 != null && TextUtils.equals(jSONObjectOptJSONObject2.optString("paramKey"), str2)) {
                            String strOptString = jSONObjectOptJSONObject2.optString("paramValue");
                            if (TextUtils.isEmpty(strOptString)) {
                                return false;
                            }
                            m28918a("global_v2", str, strOptString);
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable th2) {
            HiLog.m28809i("RUtils", "requestConfig fail: " + th2.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static String m28902a() {
        String property = System.getProperty("debug.huawei.hianalytics.app.url");
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        HiLog.m28809i("DeviceUtil", "hianalytics debugMode url is empty");
        return "";
    }

    /* renamed from: a */
    public static String m28903a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            HiLog.m28808e("DeviceUtil", "get app version error");
            return "";
        }
    }

    /* renamed from: a */
    public static String m28906a(String str) {
        String strM28908a = m28908a("global_v2", str, "");
        if (!TextUtils.isEmpty(strM28908a)) {
            return strM28908a;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        m28918a("global_v2", str, strReplace);
        return strReplace;
    }

    /* renamed from: b */
    public static String m28929b() {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            List<ActivityManager.RunningTaskInfo> listMo28829a = C4789k0.m28957a().mo28829a(1);
            String label = (listMo28829a == null || listMo28829a.isEmpty() || (runningTaskInfo = listMo28829a.get(0)) == null) ? "" : runningTaskInfo.taskDescription.getLabel();
            if (TextUtils.isEmpty(label)) {
                CharSequence charSequenceLoadLabel = C4789k0.m28957a().mo28827a().loadLabel(EnvUtils.getAppContext().getPackageManager());
                if (!(charSequenceLoadLabel instanceof String)) {
                    return "";
                }
                label = (String) charSequenceLoadLabel;
            }
            return label;
        } catch (Throwable th2) {
            HiLog.m28809i("DcUtil", "getLabel ex: " + th2.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public static String m28908a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            return str3;
        }
        SharedPreferences sharedPreferencesM28898a = m28898a(str);
        return sharedPreferencesM28898a != null ? sharedPreferencesM28898a.getString(str2, str3) : str3;
    }

    /* renamed from: a */
    public static LinkedHashMap<String, String> m28909a(Map<String, String> map, int i10, long j10, long j11, String str) {
        String str2;
        String str3;
        if (map == null || map.isEmpty()) {
            str2 = "headers is empty";
        } else {
            if (map.size() <= i10) {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (TextUtils.isEmpty(key) || key.length() > j10) {
                        str3 = "key check failure";
                        HiLog.m28812w("ParamCheckUtils", str3);
                    } else {
                        if (TextUtils.isEmpty(str) || key.startsWith(str)) {
                            if (TextUtils.isEmpty(entry.getValue()) || r3.length() > j11) {
                                str3 = "value check failure";
                            } else {
                                linkedHashMap.put(key, entry.getValue());
                            }
                        } else {
                            str3 = "key is not starts with x_";
                        }
                        HiLog.m28812w("ParamCheckUtils", str3);
                    }
                }
                return linkedHashMap;
            }
            str2 = "map size is too big";
        }
        HiLog.m28812w("ParamCheckUtils", str2);
        return null;
    }

    /* renamed from: a */
    public static void m28914a(Context context, String str, String str2, String str3) {
        String str4;
        if (context == null) {
            str4 = "context is null";
        } else {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                SharedPreferences sharedPreferencesM28897a = m28897a(context, m28904a(context, str));
                if (sharedPreferencesM28897a != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesM28897a.edit();
                    editorEdit.putString(str2, str3);
                    editorEdit.commit();
                    return;
                }
                return;
            }
            str4 = "spName or spKey is empty";
        }
        HiLog.m28808e("SharedPreUtils", str4);
    }

    /* renamed from: c */
    public static boolean m28942c() {
        C4790l c4790lM28893a = C4782i.m28891a().m28893a();
        if (TextUtils.isEmpty(c4790lM28893a.f21846a)) {
            c4790lM28893a.f21846a = m28941c("ro.build.version.emui", "");
        }
        return !TextUtils.isEmpty(c4790lM28893a.f21846a);
    }

    /* renamed from: a */
    public static void m28917a(String str, String str2, long j10) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            return;
        }
        SharedPreferences sharedPreferencesM28898a = m28898a(str);
        if (sharedPreferencesM28898a != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM28898a.edit();
            editorEdit.putLong(str2, j10);
            editorEdit.commit();
        }
    }

    /* renamed from: b */
    public static String m28932b(String str, String str2) {
        String strM28908a;
        C4728a1 c4728a1M28900a = m28900a(str, str2);
        if (c4728a1M28900a == null || !c4728a1M28900a.f21632c) {
            return "";
        }
        C4728a1 c4728a1M28900a2 = m28900a(str, str2);
        String str3 = c4728a1M28900a2 != null ? c4728a1M28900a2.f21622a : "";
        if (TextUtils.isEmpty(str3)) {
            strM28908a = m28908a("global_v2", str, "");
            if (TextUtils.isEmpty(strM28908a)) {
                str3 = strM28908a;
                strM28908a = str3;
            } else {
                if (strM28908a.length() > 32) {
                    String strM59677f = C9560a.m59677f("HiAnalytics_Sdk_Uuid_Sp_Key", strM28908a);
                    if (!TextUtils.isEmpty(strM59677f)) {
                        m28918a("global_v2", str, strM59677f);
                        strM28908a = strM59677f;
                    }
                }
                C4728a1 c4728a1M28900a3 = m28900a(str, str2);
                if (c4728a1M28900a3 != null) {
                    c4728a1M28900a3.f21622a = strM28908a;
                }
            }
        } else {
            strM28908a = str3;
        }
        return TextUtils.isEmpty(strM28908a) ? m28940c(EnvUtils.getAppContext()) : strM28908a;
    }

    /* renamed from: a */
    public static void m28918a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            return;
        }
        SharedPreferences sharedPreferencesM28898a = m28898a(str);
        if (sharedPreferencesM28898a != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM28898a.edit();
            editorEdit.putString(str2, str3);
            editorEdit.commit();
        }
    }

    /* renamed from: a */
    public static void m28919a(List<String> list, List<String> list2) {
        if (!list.isEmpty()) {
            C4794n.m28969a(EnvUtils.getAppContext()).deleteMcInfo(list);
        }
        if (list2.isEmpty()) {
            return;
        }
        C4794n.m28969a(EnvUtils.getAppContext()).deleteMcTag(list2);
    }

    /* renamed from: a */
    public static boolean m28921a(long j10) {
        return System.currentTimeMillis() - j10 >= TimeUnit.DAYS.toMillis(7L);
    }

    /* renamed from: a */
    public static boolean m28922a(Context context) {
        if (context == null) {
            return false;
        }
        return TextUtils.equals(context.getPackageName(), System.getProperty("debug.huawei.hianalytics.app"));
    }

    /* renamed from: a */
    public static boolean m28925a(String str, String str2, int i10) {
        StringBuilder sb2;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            sb2 = new StringBuilder();
            str3 = "parameter is empty: ";
        } else {
            if (str2.length() <= i10) {
                return true;
            }
            sb2 = new StringBuilder();
            str3 = "parameter length error: ";
        }
        sb2.append(str3);
        sb2.append(str);
        HiLog.m28812w("ParamCheckUtils", sb2.toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m28926a(String str, String str2, String str3) {
        StringBuilder sb2;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            sb2 = new StringBuilder();
            str4 = "parameter is null. parameter:";
        } else {
            if (Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            }
            sb2 = new StringBuilder();
            str4 = "check parameter failure! parameter:";
        }
        sb2.append(str4);
        sb2.append(str);
        HiLog.m28812w("ParamCheckUtils", sb2.toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m28927a(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            return z10;
        }
        SharedPreferences sharedPreferencesM28898a = m28898a(str);
        return sharedPreferencesM28898a != null ? sharedPreferencesM28898a.getBoolean(str2, z10) : z10;
    }

    /* renamed from: a */
    public static boolean m28928a(Map<String, String> map) {
        String str;
        if (map == null || map.isEmpty()) {
            str = "onEvent size empty";
        } else if (map.size() != 1 || (map.get("constants") == null && map.get("_constants") == null)) {
            try {
                if (map.size() <= 2048 && map.toString().length() <= 204800) {
                    return true;
                }
                HiLog.m28812w("ParamCheckUtils", "map data is too big. size: " + map.size() + ", length: " + map.toString().length());
                return false;
            } catch (Exception unused) {
                str = "checkMap failed";
            }
        } else {
            str = "the key can't be constants or _constants";
        }
        HiLog.m28812w("ParamCheckUtils", str);
        return false;
    }

    /* renamed from: b */
    public static String m28933b(String str, String str2, String str3) {
        Object objInvoke = null;
        try {
            objInvoke = Class.forName(str).getMethod("get", String.class, String.class).invoke(null, str2, str3);
        } catch (Throwable unused) {
            HiLog.m28808e("DeviceUtil", "invokeStaticFun fail");
        }
        return objInvoke != null ? (String) objInvoke : str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x005e A[Catch: JSONException -> 0x0065, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0065, blocks: (B:36:0x0009, B:38:0x0010, B:40:0x0017, B:42:0x001e, B:44:0x0025, B:53:0x0041, B:59:0x0054, B:60:0x005a, B:54:0x0047, B:57:0x004e, B:61:0x005e), top: B:65:0x0009 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject m28911a(com.huawei.hianalytics.C4813x r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) throws org.json.JSONException {
        /*
            java.lang.String r0 = "MRUtils"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "mc_duration"
            java.lang.String r3 = r5.f21983e     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "play_start_time"
            long r3 = r5.f21975a     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "play_duration"
            long r3 = r5.f21978b     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "favorite_state"
            int r3 = r5.f21974a     // Catch: org.json.JSONException -> L65
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L65
            java.lang.String r2 = "package_name"
            java.lang.String r5 = r5.f21985g     // Catch: org.json.JSONException -> L65
            r1.put(r2, r5)     // Catch: org.json.JSONException -> L65
            r1.put(r6, r7)     // Catch: org.json.JSONException -> L65
            com.huawei.hianalytics.w r5 = com.huawei.hianalytics.C4811w.m29047a()     // Catch: org.json.JSONException -> L65
            int r5 = r5.f21957a     // Catch: org.json.JSONException -> L65
            r6 = 1
            if (r5 == r6) goto L5e
            r6 = 2
            java.lang.String r7 = "uuid_metric_info"
            if (r5 == r6) goto L4e
            r6 = 3
            if (r5 == r6) goto L47
            r6 = 4
            if (r5 == r6) goto L54
            java.lang.String r5 = "error idFlag"
            com.huawei.hianalytics.core.log.HiLog.m28812w(r0, r5)     // Catch: org.json.JSONException -> L65
            goto L6a
        L47:
            boolean r5 = android.text.TextUtils.equals(r7, r8)     // Catch: org.json.JSONException -> L65
            if (r5 != 0) goto L5e
            goto L54
        L4e:
            boolean r5 = android.text.TextUtils.equals(r7, r8)     // Catch: org.json.JSONException -> L65
            if (r5 == 0) goto L5e
        L54:
            java.lang.String r5 = m28948f()     // Catch: org.json.JSONException -> L65
            java.lang.String r6 = "udid"
        L5a:
            r1.put(r6, r5)     // Catch: org.json.JSONException -> L65
            goto L6a
        L5e:
            java.lang.String r5 = m28906a(r8)     // Catch: org.json.JSONException -> L65
            java.lang.String r6 = "uuid"
            goto L5a
        L65:
            java.lang.String r5 = "BMID JSONException"
            com.huawei.hianalytics.core.log.HiLog.m28812w(r0, r5)
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4785j.m28911a(com.huawei.hianalytics.x, java.lang.String, java.lang.String, java.lang.String):org.json.JSONObject");
    }

    /* renamed from: b */
    public static void m28934b() {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_metric_mc");
        if (instanceByTag == null) {
            HiLog.m28812w("MRUtils", "metric instance is null");
            return;
        }
        String strM28908a = m28908a("global_v2", "sdkReportUrl", "");
        if (!TextUtils.isEmpty(strM28908a)) {
            C4782i.m28891a().m28892a("ha_metric_mc").f21711b.f21631c = strM28908a;
        }
        instanceByTag.onReport(0);
        m28917a("global_v2", "lastMetricReportTime", System.currentTimeMillis());
    }

    /* renamed from: a */
    public static boolean m28920a() throws NumberFormatException {
        String strM28908a = C4782i.m28891a().m28893a().f21866r;
        if (TextUtils.isEmpty(strM28908a)) {
            strM28908a = m28908a("Privacy_MY", "public_key_time_interval", "");
            C4782i.m28891a().m28893a().f21866r = strM28908a;
        }
        String strM28908a2 = C4782i.m28891a().m28893a().f21867s;
        if (TextUtils.isEmpty(strM28908a2)) {
            strM28908a2 = m28908a("Privacy_MY", "public_key_time_last", "");
            C4782i.m28891a().m28893a().f21867s = strM28908a2;
        }
        if (!TextUtils.isEmpty(strM28908a) && !TextUtils.isEmpty(strM28908a2)) {
            try {
                if (System.currentTimeMillis() - Long.parseLong(strM28908a2) <= Integer.parseInt(strM28908a)) {
                    return false;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m28923a(Context context, String str) {
        if (context == null) {
            return false;
        }
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        if (context.checkPermission(str, callingPid, callingUid) == -1) {
            return false;
        }
        String strPermissionToOp = AppOpsManager.permissionToOp(str);
        if (strPermissionToOp != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(callingUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return false;
                }
                packageName = packagesForUid[0];
            }
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            if (appOpsManager == null || appOpsManager.noteProxyOpNoThrow(strPermissionToOp, packageName) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m28912a() {
        C4747d1 c4747d1M28955a;
        C4747d1 c4747d1M28954a = C4788k.m28953a().m28954a("ha_metric_mc");
        if (c4747d1M28954a == null) {
            c4747d1M28955a = new C4747d1("ha_metric_mc");
            if (c4747d1M28955a.f21702a == null) {
                HiLog.m28808e("HACU", "metric instance is null, create failed");
                return;
            }
            HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("Analytics_Kit_Tag");
            String collectUrl = instanceByTag == null ? "" : instanceByTag.getCollectUrl();
            if (TextUtils.isEmpty(collectUrl)) {
                return;
            }
            c4747d1M28955a.m28825b(new HiAnalyticsConfig.Builder().setCollectURL(collectUrl).setAutoReportThresholdSize(100).build());
            C4747d1 c4747d1M28955a2 = C4788k.m28953a().m28955a("ha_metric_mc", c4747d1M28955a);
            if (c4747d1M28955a2 != null) {
                c4747d1M28955a = c4747d1M28955a2;
            }
        } else {
            c4747d1M28955a = C4788k.m28953a().m28955a("ha_metric_mc", c4747d1M28954a);
        }
        if (c4747d1M28955a == null) {
            HiLog.m28808e("HACU", "metricInstance is null");
        } else {
            c4747d1M28955a.setAppid("com.huawei.hianalytics");
        }
    }

    /* renamed from: a */
    public static String m28907a(String str, String str2) {
        C4728a1 c4728a1M28900a = m28900a(str, str2);
        return c4728a1M28900a != null ? c4728a1M28900a.f21634d : "";
    }

    /* renamed from: a */
    public static String m28904a(Context context, String str) {
        String packageName = C4782i.m28891a().m28893a().f21862n;
        if (TextUtils.isEmpty(packageName)) {
            packageName = context.getPackageName();
        }
        return "hianalytics_" + str + "_" + packageName;
    }

    /* renamed from: a */
    public static long m28895a(Context context, String str) {
        String str2 = m28904a(context, str) + ".xml";
        return new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
    }

    /* renamed from: a */
    public static boolean m28924a(String str) {
        if (!C4803s.m29018a().f21926c || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Iterator<Pattern> it = C4803s.m29018a().f21917a.iterator();
            while (it.hasNext()) {
                if (it.next().matcher(str).matches()) {
                    return true;
                }
            }
        } catch (Throwable th2) {
            HiLog.m28809i("DcUtil", "isLiteAppPage fail: " + th2.getMessage());
        }
        return false;
    }

    /* renamed from: a */
    public static void m28916a(String str, HiAnalyticsConfig hiAnalyticsConfig) {
        C4747d1 c4747d1M28954a = C4788k.m28953a().m28954a("ha_metric_mc");
        if (c4747d1M28954a == null) {
            return;
        }
        c4747d1M28954a.f21702a.clearCacheDataByTag();
        DaoManager.getInstance().deleteAllInfo();
        c4747d1M28954a.m28825b(new HiAnalyticsConfig.Builder().setCollectURL(str).setHttpHeader(hiAnalyticsConfig.f21900a.f21623a).setAutoReportThresholdSize(100).build());
    }

    /* renamed from: a */
    public static String m28905a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        Object obj;
        String str3 = "Unknown";
        C4728a1 c4728a1M28900a = m28900a(str, str2);
        if (!TextUtils.isEmpty(c4728a1M28900a != null ? c4728a1M28900a.f21627b : "")) {
            C4728a1 c4728a1M28900a2 = m28900a(str, str2);
            return c4728a1M28900a2 != null ? c4728a1M28900a2.f21627b : "";
        }
        C4790l c4790lM28893a = C4782i.m28891a().m28893a();
        if (TextUtils.isEmpty(c4790lM28893a.f21861m)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("CHANNEL")) != null) {
                    String string = obj.toString();
                    if (string.length() <= 256) {
                        str3 = string;
                    }
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                HiLog.m28808e("DeviceIdUtils", "get channel error");
            }
            c4790lM28893a.f21861m = m28925a(FaqConstants.FAQ_CHANNEL, str3, 256) ? str3 : "";
        }
        return c4790lM28893a.f21861m;
    }

    /* renamed from: a */
    public static void m28913a(int i10, final HiAnalyticsConfig hiAnalyticsConfig) {
        if (hiAnalyticsConfig == null || hiAnalyticsConfig.f21900a == null || i10 != 0) {
            return;
        }
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("Analytics_Kit_Tag");
        final String collectUrl = instanceByTag == null ? "" : instanceByTag.getCollectUrl();
        if (TextUtils.isEmpty(collectUrl)) {
            return;
        }
        TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.c
            @Override // java.lang.Runnable
            public final void run() {
                C4785j.m28916a(collectUrl, hiAnalyticsConfig);
            }
        });
    }

    /* renamed from: a */
    public static List<String> m28910a(List<String> list) throws JSONException {
        String string;
        String str = C4811w.m29047a().f21959a;
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(it.next()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Music", jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("flowId", "");
            jSONObject2.put("bId", "");
            jSONObject2.put("uuId", UUID.randomUUID().toString());
            jSONObject2.put("dataFormat", "1");
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("scenarioId", "music101");
            jSONObject3.put("content", jSONArray2);
            String strM28931b = m28931b(SafeBase64.encodeToString(jSONObject3.toString().getBytes(StandardCharsets.UTF_8), 0));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("data", strM28931b);
            jSONObject4.put("version", "1.0");
            jSONObject4.put("meta", jSONObject2);
            string = jSONObject4.toString();
        } catch (JSONException e10) {
            HiLog.m28808e("RUtils", "JsonException" + e10.getMessage());
            string = "";
        }
        Charset charset = StandardCharsets.UTF_8;
        Response responseExecute = TransportHandlerFactory.create(str + "/tag/v1/service", null, string.getBytes(charset), 1).execute();
        ArrayList arrayList = new ArrayList();
        if (responseExecute.getHttpCode() == 200) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(responseExecute.getContent()).optJSONObject("result");
                if (jSONObjectOptJSONObject == null) {
                    HiLog.m28808e("RUtils", "result is null!");
                } else if (jSONObjectOptJSONObject.optInt("code", -1) != 0) {
                    HiLog.m28809i("RUtils", "request failed");
                } else {
                    String strOptString = jSONObjectOptJSONObject.optString("content");
                    if (TextUtils.isEmpty(strOptString)) {
                        HiLog.m28807d("RUtils", "content is null");
                    } else {
                        JSONArray jSONArrayOptJSONArray = new JSONArray(new String(SafeBase64.decode(m28931b(strOptString), 0), charset)).optJSONObject(0).optJSONArray("Music");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                                JSONObject jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i10);
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("item_id", jSONObject5.optString("item_id", ""));
                                jSONObject6.put("content_code", jSONObject5.optString("content_code", ""));
                                jSONObject6.put("metric_tag", new JSONObject(jSONObject5.optString("tag_info", "")).optString("tag", ""));
                                arrayList.add(jSONObject6.toString());
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
                HiLog.m28812w("RUtils", "HR JsonException");
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x00f8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m28915a(android.database.sqlite.SQLiteDatabase r14) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4785j.m28915a(android.database.sqlite.SQLiteDatabase):void");
    }
}
