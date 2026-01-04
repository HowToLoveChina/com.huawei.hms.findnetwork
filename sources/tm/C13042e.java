package tm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;

/* renamed from: tm.e */
/* loaded from: classes6.dex */
public class C13042e {

    /* renamed from: c */
    public static String f59369c;

    /* renamed from: d */
    @SuppressLint({"StaticFieldLeak"})
    public static C13042e f59370d;

    /* renamed from: e */
    public static final Object f59371e = new Object();

    /* renamed from: a */
    public SharedPreferences f59372a;

    /* renamed from: b */
    public Context f59373b;

    public C13042e(Context context) {
        this.f59373b = context;
        this.f59372a = C0214f0.m1382b(context, "phone_finder_grs_urls", 0);
    }

    /* renamed from: c */
    public static C13042e m78685c() {
        C13042e c13042e;
        synchronized (f59371e) {
            try {
                C13042e c13042e2 = f59370d;
                if (c13042e2 == null || c13042e2.f59373b == null || c13042e2.f59372a == null) {
                    f59370d = new C13042e(C0213f.m1377a());
                }
                c13042e = f59370d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13042e;
    }

    /* renamed from: e */
    public static void m78686e(String str) {
        f59369c = str;
    }

    /* renamed from: a */
    public void m78687a() {
        if (this.f59372a != null) {
            AbstractC10896a.m65887i("PhoneFinderGrsSpManager", "clear PhoneFinderGrsSp");
            this.f59372a.edit().clear().apply();
        }
    }

    /* renamed from: b */
    public String m78688b(String str) {
        return this.f59372a.getString(str, "");
    }

    /* renamed from: d */
    public boolean m78689d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.f59372a.edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }
}
