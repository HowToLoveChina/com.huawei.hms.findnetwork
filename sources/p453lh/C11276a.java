package p453lh;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: lh.a */
/* loaded from: classes4.dex */
public class C11276a {

    /* renamed from: d */
    public static final Object f52909d = new Object();

    /* renamed from: e */
    public static volatile C11276a f52910e;

    /* renamed from: a */
    public String f52911a;

    /* renamed from: b */
    public long f52912b;

    /* renamed from: c */
    public SharedPreferences f52913c;

    public C11276a(Context context) {
        try {
            this.f52913c = context.createDeviceProtectedStorageContext().getSharedPreferences("MarketHomeCountry.DataStorage", 0);
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "getSharedPreference error");
        }
    }

    /* renamed from: a */
    public static C11276a m67671a(Context context) {
        if (f52910e == null) {
            synchronized (f52909d) {
                try {
                    if (f52910e == null) {
                        f52910e = new C11276a(context);
                    }
                } finally {
                }
            }
        }
        return f52910e;
    }

    /* renamed from: b */
    public void m67672b() {
        try {
            SharedPreferences.Editor editorEdit = this.f52913c.edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "clear error");
        }
    }

    /* renamed from: c */
    public void m67673c(long j10) {
        try {
            this.f52913c.edit().putLong("effectiveduration", j10).commit();
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "setEffectiveDuration, putLong error");
        }
    }

    /* renamed from: d */
    public void m67674d(String str) {
        try {
            this.f52913c.edit().putString("homeCountryInProvider", str).commit();
            this.f52913c.edit().putLong("providerUpdateTime", System.currentTimeMillis()).commit();
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "setHomeCountryInProvider, putString error");
        }
    }

    /* renamed from: e */
    public long m67675e() {
        try {
            return this.f52913c.getLong("effectiveduration", 47839000L);
        } catch (Exception unused) {
            return 47839000L;
        }
    }

    /* renamed from: f */
    public void m67676f(String str) {
        this.f52911a = str;
        this.f52912b = str != null ? System.currentTimeMillis() : 0L;
    }

    /* renamed from: g */
    public String m67677g() {
        return this.f52913c.getString("homeCountryInProvider", null);
    }

    /* renamed from: h */
    public long m67678h() {
        try {
            return this.f52913c.getLong("providerUpdateTime", 0L);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: i */
    public String m67679i() {
        return this.f52911a;
    }

    /* renamed from: j */
    public long m67680j() {
        return this.f52912b;
    }
}
