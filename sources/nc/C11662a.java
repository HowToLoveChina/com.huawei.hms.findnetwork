package nc;

import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0214f0;

/* renamed from: nc.a */
/* loaded from: classes3.dex */
public class C11662a {

    /* renamed from: a */
    public Context f54101a;

    /* renamed from: b */
    public SharedPreferences f54102b;

    /* renamed from: nc.a$b */
    public static class b {

        /* renamed from: a */
        public static C11662a f54103a = new C11662a();
    }

    /* renamed from: c */
    public static C11662a m69650c(Context context) {
        if (b.f54103a.f54102b == null || b.f54103a.f54101a == null) {
            b.f54103a.m69653d(context);
        }
        return b.f54103a;
    }

    /* renamed from: a */
    public void m69651a() {
        SharedPreferences sharedPreferences = this.f54102b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public boolean m69652b(String str) {
        SharedPreferences sharedPreferences = this.f54102b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    /* renamed from: d */
    public final void m69653d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f54101a = applicationContext;
        this.f54102b = C0214f0.m1382b(applicationContext, "cloudsyncregister", 0);
    }

    /* renamed from: e */
    public void m69654e(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f54102b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z10);
            editorEdit.commit();
        }
    }

    public C11662a() {
        this.f54101a = null;
        this.f54102b = null;
    }
}
