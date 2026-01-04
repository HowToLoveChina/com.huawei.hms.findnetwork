package vn;

import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;

/* renamed from: vn.b */
/* loaded from: classes6.dex */
public class C13470b {

    /* renamed from: vn.b$a */
    public static class a {

        /* renamed from: a */
        public static C13470b f60677a = new C13470b();
    }

    /* renamed from: a */
    public static C13470b m81125a() {
        return a.f60677a;
    }

    /* renamed from: b */
    public boolean m81126b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("DataAnalyzeSwitch", "context is null");
            return false;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM1377a, "sp_data_analyze", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("clientLogReport", false);
        }
        AbstractC10896a.m65886e("DataAnalyzeSwitch", "sp is null");
        return false;
    }
}
