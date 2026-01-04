package ci;

import android.util.Log;

/* renamed from: ci.b */
/* loaded from: classes4.dex */
public class C1441b {

    /* renamed from: b */
    public static final C1441b f6211b = new C1441b();

    /* renamed from: a */
    public boolean f6212a;

    public C1441b() throws ClassNotFoundException {
        try {
            Class.forName("com.huawei.appgallery.log.LogAdaptor");
            this.f6212a = true;
        } catch (ClassNotFoundException unused) {
            this.f6212a = false;
        }
    }

    /* renamed from: a */
    public void m8284a(String str, String str2) {
        if (this.f6212a) {
            C1440a.f6210a.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* renamed from: b */
    public void m8285b(String str, String str2, Throwable th2) {
        if (this.f6212a) {
            C1440a.f6210a.e(str, str2, th2);
        } else {
            Log.e(str, str2, th2);
        }
    }

    /* renamed from: c */
    public void m8286c(String str, String str2) {
        if (this.f6212a) {
            C1440a.f6210a.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    /* renamed from: d */
    public void m8287d(String str, String str2) {
        if (this.f6212a) {
            C1440a.f6210a.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }
}
