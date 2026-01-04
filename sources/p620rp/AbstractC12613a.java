package p620rp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;

/* renamed from: rp.a */
/* loaded from: classes8.dex */
public abstract class AbstractC12613a {

    /* renamed from: a */
    public SharedPreferences f58031a;

    public AbstractC12613a(String str, boolean z10) {
        this.f58031a = null;
        Context contextM1377a = C0213f.m1377a();
        this.f58031a = (z10 ? C0214f0.m1383c(contextM1377a, str) : contextM1377a).getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public void m76112a() {
        this.f58031a.edit().clear().apply();
    }

    /* renamed from: b */
    public String m76113b(String str, String str2) {
        try {
            return this.f58031a.getString(str, str2);
        } catch (Exception unused) {
            AbstractC10896a.m65886e("BaseSpManager", "catch Exception when get String key");
            return str2;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: c */
    public boolean m76114c(String str, String str2) {
        return this.f58031a.edit().putString(str, str2).commit();
    }

    /* renamed from: d */
    public void m76115d(String str) {
        this.f58031a.edit().remove(str).apply();
    }
}
