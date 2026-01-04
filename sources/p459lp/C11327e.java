package p459lp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;

/* renamed from: lp.e */
/* loaded from: classes7.dex */
public class C11327e {

    /* renamed from: a */
    public static SharedPreferences f53018a;

    /* renamed from: a */
    public static synchronized void m68058a() {
        try {
            if (f53018a == null) {
                f53018a = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            }
            f53018a.edit().clear().commit();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public static synchronized void m68059b(String str) {
        AbstractC10896a.m65887i("GeneralConfigSpUtil", "clearDownloadSpValue, configPoint is: " + str);
        m68065h(str, -1L);
        m68071n(str, 0L);
        m68067j(str, "");
        m68068k(str, "");
        m68070m(str, 0);
        m68069l(str, "");
        m68072o(str, 0L);
    }

    /* renamed from: c */
    public static synchronized boolean m68060c(String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && f53018a != null) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            f53018a = sharedPreferencesM1382b;
            return sharedPreferencesM1382b.getBoolean(str, z10);
        }
        return false;
    }

    /* renamed from: d */
    public static synchronized String m68061d(String str) {
        try {
            if (f53018a == null) {
                f53018a = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f53018a.getString(str + "_etag", "");
    }

    /* renamed from: e */
    public static synchronized int m68062e(String str) {
        try {
            if (f53018a == null) {
                f53018a = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f53018a.getInt(str + "_local_built_in_version_v2", 0);
    }

    /* renamed from: f */
    public static synchronized long m68063f(String str) {
        try {
            if (f53018a == null) {
                f53018a = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f53018a.getLong(str + "_localVersion", 0L);
    }

    /* renamed from: g */
    public static synchronized long m68064g(String str) {
        try {
            if (f53018a == null) {
                f53018a = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f53018a.getLong(str + "_temp_version_from_getVersion", 0L);
    }

    /* renamed from: h */
    public static synchronized boolean m68065h(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = str + "_accessTime";
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putLong(str2, j10).commit();
    }

    /* renamed from: i */
    public static synchronized void m68066i(String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && f53018a != null) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
            f53018a = sharedPreferencesM1382b;
            sharedPreferencesM1382b.edit().putBoolean(str, z10).commit();
        }
    }

    /* renamed from: j */
    public static synchronized boolean m68067j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str3 = str + "_etag";
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putString(str3, str2).commit();
    }

    /* renamed from: k */
    public static synchronized boolean m68068k(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str3 = str + "_hash";
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putString(str3, str2).commit();
    }

    /* renamed from: l */
    public static synchronized boolean m68069l(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str3 = str + "_home_country";
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putString(str3, str2).commit();
    }

    /* renamed from: m */
    public static synchronized boolean m68070m(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AbstractC10896a.m65887i("GeneralConfigSpUtil", "setLocalBuiltInVersion, configPoint: " + str + ", builtInVersion: " + i10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_local_built_in_version_v2");
        String string = sb2.toString();
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putInt(string, i10).commit();
    }

    /* renamed from: n */
    public static synchronized boolean m68071n(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = str + "_localVersion";
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putLong(str2, j10).commit();
    }

    /* renamed from: o */
    public static synchronized boolean m68072o(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = str + "_temp_version_from_getVersion";
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "config_service_download_sp", 0);
        f53018a = sharedPreferencesM1382b;
        return sharedPreferencesM1382b.edit().putLong(str2, j10).commit();
    }
}
