package p711vl;

import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0214f0;

/* renamed from: vl.c */
/* loaded from: classes6.dex */
public class C13463c {

    /* renamed from: a */
    public Context f60640a;

    /* renamed from: b */
    public SharedPreferences f60641b;

    /* renamed from: vl.c$b */
    public static class b {

        /* renamed from: a */
        public static C13463c f60642a = new C13463c();
    }

    /* renamed from: c */
    public static C13463c m81022c(Context context) {
        if (b.f60642a.f60641b == null || b.f60642a.f60640a == null) {
            b.f60642a.m81026e(context);
        }
        return b.f60642a;
    }

    /* renamed from: a */
    public void m81023a() {
        SharedPreferences sharedPreferences = this.f60641b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public boolean m81024b(String str) {
        SharedPreferences sharedPreferences = this.f60641b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    /* renamed from: d */
    public long m81025d(String str) {
        SharedPreferences sharedPreferences = this.f60641b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0L);
        }
        return 0L;
    }

    /* renamed from: e */
    public final void m81026e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f60640a = applicationContext;
        this.f60641b = C0214f0.m1382b(applicationContext, "cloudbackupreport", 0);
    }

    /* renamed from: f */
    public void m81027f(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60641b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z10);
            editorEdit.commit();
        }
    }

    /* renamed from: g */
    public void m81028g(String str, long j10) {
        SharedPreferences sharedPreferences = this.f60641b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(str, j10);
            editorEdit.commit();
        }
    }

    public C13463c() {
        this.f60640a = null;
        this.f60641b = null;
    }
}
