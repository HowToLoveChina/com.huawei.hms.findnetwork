package cw;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: cw.b */
/* loaded from: classes9.dex */
public class C8957b {

    /* renamed from: a */
    public static SharedPreferences f45462a;

    /* renamed from: a */
    public static synchronized SharedPreferences m56702a(Context context) {
        try {
            if (f45462a == null) {
                f45462a = context.createDeviceProtectedStorageContext().getSharedPreferences("ucs.sdk", 0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f45462a;
    }

    /* renamed from: b */
    public static int m56703b(String str, int i10, Context context) {
        return m56702a(context).getInt(str, i10);
    }

    /* renamed from: c */
    public static long m56704c(String str, long j10, Context context) {
        return m56702a(context).getLong(str, j10);
    }

    /* renamed from: d */
    public static String m56705d(String str, String str2, Context context) {
        return m56702a(context).getString(str, str2);
    }

    /* renamed from: e */
    public static void m56706e(String str, int i10, Context context) {
        m56702a(context).edit().putInt(str, i10).apply();
    }

    /* renamed from: f */
    public static void m56707f(String str, long j10, Context context) {
        m56702a(context).edit().putLong(str, j10).apply();
    }

    /* renamed from: g */
    public static void m56708g(String str, String str2, Context context) {
        m56702a(context).edit().putString(str, str2).apply();
    }
}
