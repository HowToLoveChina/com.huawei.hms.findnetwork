package com.huawei.hms.videokit.player;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.secure.android.common.util.SafeString;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.videokit.player.t0 */
/* loaded from: classes8.dex */
public final class C6600t0 {

    /* renamed from: a */
    private static final HashSet<String> f30678a = new HashSet<>(Arrays.asList(Constants.AR_CACHE, "fa", "iw", Constants.URDU_LANG, "ug"));

    /* renamed from: a */
    public static int m37664a(int i10, int i11) {
        if (i11 <= i10) {
            return 0;
        }
        try {
            return m37691h().nextInt(i11 - i10) + i10;
        } catch (Exception e10) {
            C6550c1.m37258a(Utils.TAG, "getNum e:", e10);
            return 0;
        }
    }

    /* renamed from: b */
    public static String m37678b() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        return simpleDateFormat.format(date);
    }

    /* renamed from: c */
    public static long m37681c() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: d */
    public static int m37684d() {
        int iM37667a = m37667a("ro.build.hw_emui_api_level", 0);
        return iM37667a == 0 ? m37667a("ro.build.magic_api_level", 0) : iM37667a;
    }

    /* renamed from: e */
    public static int m37686e(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", OsType.ANDROID)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: f */
    public static long m37688f() {
        return System.currentTimeMillis();
    }

    /* renamed from: g */
    public static String m37690g() {
        return m37674a("ro.product.model", "");
    }

    /* renamed from: h */
    public static SecureRandom m37691h() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e10) {
            C6550c1.m37258a(Utils.TAG, "no such algorithm exception :", e10);
            return new SecureRandom();
        }
    }

    /* renamed from: i */
    public static String m37692i() {
        String strM37690g = m37690g();
        return m37683c(strM37690g) ? "UNKNOW" : strM37690g;
    }

    /* renamed from: j */
    public static boolean m37693j() {
        try {
            Method methodM37677a = m37677a("android.os.SystemProperties", "get", String.class, String.class);
            Object objM37670a = m37670a(methodM37677a, (Object) null, "ro.config.hw_notch_size", null);
            if (objM37670a == null) {
                objM37670a = m37670a(methodM37677a, (Object) null, "msc.config.notch_size", null);
            }
            if (objM37670a instanceof String) {
                if (!m37683c((String) objM37670a)) {
                    return true;
                }
            }
            return false;
        } catch (NoClassDefFoundError unused) {
            C6550c1.m37262b(Utils.TAG, "hasNotchInScreen is not found");
            return false;
        }
    }

    /* renamed from: k */
    public static boolean m37694k() {
        return m37684d() >= 20;
    }

    /* renamed from: l */
    public static boolean m37695l() {
        return f30678a.contains(Locale.getDefault().getLanguage());
    }

    /* renamed from: a */
    public static int m37665a(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static String m37679b(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException e10) {
            e = e10;
            str = "getAppName NameNotFoundException:";
            C6550c1.m37258a(Utils.TAG, str, e);
            return "";
        } catch (Exception e11) {
            e = e11;
            str = "getAppName e:";
            C6550c1.m37258a(Utils.TAG, str, e);
            return "";
        }
    }

    /* renamed from: c */
    public static String m37682c(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e = e10;
            str = "getAppVersionName:";
            C6550c1.m37258a(Utils.TAG, str, e);
            return "";
        } catch (Exception e11) {
            e = e11;
            str = "getAppVersionName Exception:";
            C6550c1.m37258a(Utils.TAG, str, e);
            return "";
        }
    }

    /* renamed from: d */
    public static String m37685d(Context context) {
        try {
            return Application.getProcessName() != null ? Application.getProcessName() : "";
        } catch (Exception e10) {
            C6550c1.m37258a(Utils.TAG, "getCurProcessName e:", e10);
            return "";
        }
    }

    /* renamed from: e */
    public static String m37687e() {
        String strM37674a = m37674a("ro.build.version.emui", "");
        return TextUtils.isEmpty(strM37674a) ? m37674a("ro.build.version.magic", "") : strM37674a;
    }

    /* renamed from: f */
    public static boolean m37689f(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 1;
    }

    /* renamed from: a */
    public static int m37666a(Context context, int i10) {
        if (context == null) {
            return 0;
        }
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static boolean m37680b(String str) {
        return str == null || str.length() == 0 || "".equals(str.trim());
    }

    /* renamed from: c */
    public static boolean m37683c(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: a */
    private static int m37667a(String str, int i10) {
        Object objM37670a = m37670a(m37677a("android.os.SystemProperties", "getInt", String.class, Integer.TYPE), (Object) null, str, Integer.valueOf(i10));
        return objM37670a instanceof Integer ? ((Integer) objM37670a).intValue() : i10;
    }

    /* renamed from: a */
    public static <T> T m37668a(Context context, String str, Class<T> cls) {
        if (!TextUtils.isEmpty(str) && cls != null && context != null) {
            T t10 = (T) context.getSystemService(str);
            if (cls.isInstance(t10)) {
                return t10;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Object m37669a(String str, String str2, Class<?>[] clsArr, Object... objArr) throws ClassNotFoundException {
        String str3;
        if (str == null || TextUtils.isEmpty(str2)) {
            C6550c1.m37265d(Utils.TAG, "invoke param className or methodName can not be null!");
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            return m37670a(cls.getMethod(str2, clsArr), cls.newInstance(), objArr);
        } catch (ClassNotFoundException e10) {
            e = e10;
            str3 = "ClassNotFoundException";
            C6550c1.m37258a(Utils.TAG, str3, e);
            return null;
        } catch (IllegalAccessException e11) {
            e = e11;
            str3 = "IllegalAccessException";
            C6550c1.m37258a(Utils.TAG, str3, e);
            return null;
        } catch (InstantiationException e12) {
            e = e12;
            str3 = "InstantiationException";
            C6550c1.m37258a(Utils.TAG, str3, e);
            return null;
        } catch (NoSuchMethodException e13) {
            e = e13;
            str3 = "NoSuchMethodException";
            C6550c1.m37258a(Utils.TAG, str3, e);
            return null;
        }
    }

    /* renamed from: a */
    public static Object m37670a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            C6550c1.m37265d(Utils.TAG, "invoke param method can not be null!");
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e10) {
            C6550c1.m37258a(Utils.TAG, method + " invoke ", e10);
            return null;
        }
    }

    /* renamed from: a */
    public static String m37671a() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: a */
    public static String m37672a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("spId");
        } catch (Exception e10) {
            C6550c1.m37258a(Utils.TAG, "get spId error :", e10);
            return "";
        }
    }

    /* renamed from: a */
    public static String m37673a(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return SafeString.substring(str, i10, i11);
        } catch (IndexOutOfBoundsException unused) {
            return str;
        }
    }

    /* renamed from: a */
    private static String m37674a(String str, String str2) {
        Object objM37670a = m37670a(m37677a("android.os.SystemProperties", "get", String.class, String.class), (Object) null, str, str2);
        return objM37670a instanceof String ? (String) objM37670a : str2;
    }

    /* renamed from: a */
    public static String m37675a(String str, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (IllegalFormatException unused) {
            C6550c1.m37262b(Utils.TAG, "format IllegalFormatException happened.");
            return null;
        } catch (Exception e10) {
            C6550c1.m37258a(Utils.TAG, "format e:", e10);
            return null;
        }
    }

    /* renamed from: a */
    public static String m37676a(Thread thread, Throwable th2) {
        if (thread != null && th2 != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[EXCEPTION]" + System.lineSeparator());
                stringBuffer.append("Thread ID:");
                stringBuffer.append(thread.getId());
                stringBuffer.append(System.lineSeparator());
                stringBuffer.append("Thread Name:");
                stringBuffer.append(thread.getName());
                stringBuffer.append(System.lineSeparator());
                String strM37253a = C6550c1.m37253a(th2);
                if (strM37253a == null) {
                    strM37253a = th2.getMessage();
                }
                if (strM37253a != null) {
                    stringBuffer.append("Name:");
                    stringBuffer.append(strM37253a);
                    stringBuffer.append(System.lineSeparator());
                }
                stringBuffer.append("Reason:");
                stringBuffer.append(th2.toString());
                stringBuffer.append(System.lineSeparator());
                StackTraceElement[] stackTrace = th2.getStackTrace();
                if (stackTrace.length > 0) {
                    for (int i10 = 0; i10 < stackTrace.length; i10++) {
                        stringBuffer.append("Stack " + i10 + ":");
                        stringBuffer.append(stackTrace[i10].toString());
                        stringBuffer.append(System.lineSeparator());
                    }
                }
                Throwable cause = th2;
                while (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                if (cause != th2) {
                    StackTraceElement[] stackTrace2 = cause.getStackTrace();
                    if (stackTrace2.length > 0) {
                        stringBuffer.append("Caused by:");
                        stringBuffer.append(cause.toString());
                        stringBuffer.append(System.lineSeparator());
                        for (int i11 = 0; i11 < stackTrace2.length; i11++) {
                            stringBuffer.append("Stack " + i11 + ":");
                            stringBuffer.append(stackTrace2[i11].toString());
                            stringBuffer.append(System.lineSeparator());
                        }
                    }
                }
                return stringBuffer.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* renamed from: a */
    public static Method m37677a(String str, String str2, Class... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C6550c1.m37265d(Utils.TAG, "getMethod param className or methodname can not be null!");
            return null;
        }
        try {
            return Class.forName(str).getMethod(str2, clsArr);
        } catch (ClassNotFoundException | NoSuchMethodException | Exception e10) {
            C6550c1.m37258a(Utils.TAG, "getMethod:", e10);
            return null;
        }
    }
}
