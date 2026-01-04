package p454lj;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import mk.C11477c;
import p054cj.C1442a;

/* renamed from: lj.e */
/* loaded from: classes5.dex */
public class C11282e {

    /* renamed from: c */
    public static C11282e f52920c;

    /* renamed from: a */
    public SharedPreferences f52921a;

    /* renamed from: b */
    public SharedPreferences.Editor f52922b;

    public C11282e(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CloudPay_SP", 0);
            this.f52921a = sharedPreferences;
            this.f52922b = sharedPreferences.edit();
        }
    }

    /* renamed from: b */
    public static synchronized C11282e m67709b(Context context) {
        try {
            if (f52920c == null && context != null) {
                f52920c = new C11282e(context.getApplicationContext());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f52920c;
    }

    /* renamed from: a */
    public void m67710a() {
        try {
            SharedPreferences.Editor editor = this.f52922b;
            if (editor == null) {
                return;
            }
            editor.clear().commit();
        } catch (Exception unused) {
            C1442a.m8289e("CloudPayPreferenceUtil", "clear exception");
        }
    }

    /* renamed from: c */
    public String m67711c(String str) {
        try {
            SharedPreferences sharedPreferences = this.f52921a;
            if (sharedPreferences == null) {
                return "";
            }
            String string = sharedPreferences.getString(str, "");
            return TextUtils.isEmpty(string) ? "" : C11477c.m68631a(string);
        } catch (Exception e10) {
            C1442a.m8289e("CloudPayPreferenceUtil", "getServierReponse exception : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: d */
    public String m67712d(String str) {
        try {
            SharedPreferences sharedPreferences = this.f52921a;
            return sharedPreferences == null ? "" : sharedPreferences.getString(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: e */
    public long m67713e(String str) {
        try {
            SharedPreferences sharedPreferences = this.f52921a;
            if (sharedPreferences == null) {
                return 0L;
            }
            return sharedPreferences.getLong(str, 0L);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: f */
    public void m67714f(String str, Boolean bool) {
        try {
            SharedPreferences.Editor editor = this.f52922b;
            if (editor == null) {
                return;
            }
            editor.putBoolean(str, bool.booleanValue()).commit();
        } catch (Exception unused) {
            C1442a.m8289e("CloudPayPreferenceUtil", "saveBooleanParam exception");
        }
    }

    /* renamed from: g */
    public void m67715g(String str, long j10) {
        try {
            SharedPreferences.Editor editor = this.f52922b;
            if (editor == null) {
                return;
            }
            editor.putLong(str, j10).commit();
        } catch (Exception unused) {
            C1442a.m8289e("CloudPayPreferenceUtil", "saveLongParam exception");
        }
    }

    /* renamed from: h */
    public void m67716h(String str, String str2) {
        try {
            if (this.f52922b == null) {
                return;
            }
            this.f52922b.putString(str, C11477c.m68634d(str2)).commit();
        } catch (Exception e10) {
            C1442a.m8289e("CloudPayPreferenceUtil", "saveServerResponse exception : " + e10.getMessage());
        }
    }

    /* renamed from: i */
    public void m67717i(String str, String str2) {
        try {
            SharedPreferences.Editor editor = this.f52922b;
            if (editor == null) {
                return;
            }
            editor.putString(str, str2).commit();
        } catch (Exception unused) {
            C1442a.m8289e("CloudPayPreferenceUtil", "saveStringParam exception");
        }
    }
}
