package p711vl;

import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0214f0;

/* renamed from: vl.b */
/* loaded from: classes6.dex */
public class C13462b {

    /* renamed from: b */
    public static final C13462b f60638b = new C13462b();

    /* renamed from: a */
    public SharedPreferences f60639a;

    /* renamed from: c */
    public static C13462b m81015c() {
        return f60638b;
    }

    /* renamed from: a */
    public void m81016a() {
        SharedPreferences sharedPreferences = this.f60639a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    /* renamed from: b */
    public boolean m81017b(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60639a;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    /* renamed from: d */
    public String m81018d(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60639a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* renamed from: e */
    public void m81019e(Context context) {
        this.f60639a = C0214f0.m1382b(context, "cloudBackupSubscribeNotification", 0);
    }

    /* renamed from: f */
    public void m81020f(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60639a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z10).apply();
        }
    }

    /* renamed from: g */
    public void m81021g(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60639a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }
}
