package p015ak;

import com.huawei.android.os.BuildEx;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import p015ak.C0224k0;

/* renamed from: ak.i */
/* loaded from: classes6.dex */
public class C0219i {

    /* renamed from: a */
    public static int f813a;

    /* renamed from: b */
    public static final boolean f814b;

    static {
        f814b = C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 17;
    }

    /* renamed from: a */
    public static int m1463a() {
        int i10 = f813a;
        if (i10 != 0) {
            return i10;
        }
        int iM1575d = C0224k0.a.m1575d("ro.build.hw_emui_api_level", 0);
        f813a = iM1575d;
        return iM1575d;
    }

    /* renamed from: b */
    public static boolean m1464b() {
        return m1463a() >= 27;
    }

    /* renamed from: c */
    public static boolean m1465c() {
        return m1463a() >= 30;
    }

    /* renamed from: d */
    public static boolean m1466d() {
        return m1463a() >= 31;
    }

    /* renamed from: e */
    public static boolean m1467e() {
        return "demo".equalsIgnoreCase(C0224k0.a.m1573b(CountryCodeBean.VENDOR_SYSTEMPROP, "")) || "demo".equalsIgnoreCase(C0224k0.a.m1573b(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP, ""));
    }
}
