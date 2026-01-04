package p405jt;

import android.content.Context;
import com.huawei.openplatform.abl.log.C8265c;
import com.huawei.openplatform.abl.log.C8266l;

/* renamed from: jt.a */
/* loaded from: classes2.dex */
public abstract class AbstractC10915a {

    /* renamed from: a */
    public static AbstractC10919e f51792a;

    /* renamed from: a */
    public static void m65969a(String str, String str2) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51629c(str, str2);
        }
    }

    /* renamed from: b */
    public static void m65970b(String str, String str2) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51631f(str, str2);
        }
    }

    /* renamed from: c */
    public static void m65971c(String str, String str2, Object... objArr) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51632g(str, str2, objArr);
        }
    }

    /* renamed from: d */
    public static void m65972d(String str, String str2) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51633i(str, str2);
        }
    }

    /* renamed from: e */
    public static void m65973e(String str, String str2, Object... objArr) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51634j(str, str2, objArr);
        }
    }

    /* renamed from: f */
    public static void m65974f(Context context, C10917c c10917c) {
        if (c10917c == null) {
            return;
        }
        if (c10917c.m65988h()) {
            f51792a = new C8266l(context).m51641m(c10917c.m65986f());
        } else {
            f51792a = new C8265c(context);
        }
        f51792a.mo51640d(c10917c);
    }

    /* renamed from: g */
    public static boolean m65975g() {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            return abstractC10919e.mo51630e();
        }
        return false;
    }

    /* renamed from: h */
    public static void m65976h(int i10, String str, String str2, Throwable th2) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.m65996a(i10, str, str2, th2);
        }
    }

    /* renamed from: i */
    public static void m65977i(int i10, Throwable th2) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.m65997b(i10, th2);
        }
    }

    /* renamed from: j */
    public static void m65978j(String str, String str2) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51635k(str, str2);
        }
    }

    /* renamed from: k */
    public static void m65979k(String str, String str2, Object... objArr) {
        AbstractC10919e abstractC10919e = f51792a;
        if (abstractC10919e != null) {
            abstractC10919e.mo51636l(str, str2, objArr);
        }
    }
}
