package p405jt;

import android.content.Context;
import android.os.Build;
import p434kt.AbstractC11150d;
import p434kt.AbstractC11152f;
import p434kt.C11148b;

/* renamed from: jt.e */
/* loaded from: classes2.dex */
public abstract class AbstractC10919e {

    /* renamed from: a */
    public Context f51803a;

    /* renamed from: b */
    public C10922h f51804b = new C10922h();

    /* renamed from: a */
    public void m65996a(int i10, String str, String str2, Throwable th2) {
        this.f51804b.m66017b(i10, str, str2, th2);
    }

    /* renamed from: b */
    public void m65997b(int i10, Throwable th2) {
        this.f51804b.m66018c(i10, "", th2);
    }

    /* renamed from: c */
    public abstract void mo51629c(String str, String str2);

    /* renamed from: d */
    public void mo51640d(C10917c c10917c) {
        if (c10917c == null) {
            return;
        }
        m65998h(c10917c);
        AbstractC11152f.m67069a(this.f51803a);
        this.f51804b.m66020e(c10917c);
        this.f51804b.m66019d(c10917c.m65982b(), "\n============================================================================\n====== " + c10917c.m65985e() + "\n====== Brand: " + Build.BRAND + " Model: " + C11148b.m67059a() + " Release: " + Build.VERSION.RELEASE + " API: " + Build.VERSION.SDK_INT + "\n============================================================================");
    }

    /* renamed from: e */
    public abstract boolean mo51630e();

    /* renamed from: f */
    public abstract void mo51631f(String str, String str2);

    /* renamed from: g */
    public abstract void mo51632g(String str, String str2, Object... objArr);

    /* renamed from: h */
    public void m65998h(C10917c c10917c) {
        if (c10917c == null) {
            return;
        }
        if ((c10917c.m65988h() || c10917c.m65989i()) && AbstractC11150d.m67064a("com.huawei.hms.support.log.KitLog")) {
            C10921g.m66006a().m66007b(this.f51803a, c10917c.m65983c(), c10917c.m65982b());
        }
    }

    /* renamed from: i */
    public abstract void mo51633i(String str, String str2);

    /* renamed from: j */
    public abstract void mo51634j(String str, String str2, Object... objArr);

    /* renamed from: k */
    public abstract void mo51635k(String str, String str2);

    /* renamed from: l */
    public abstract void mo51636l(String str, String str2, Object... objArr);
}
