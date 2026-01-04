package p687uq;

import java.lang.reflect.Field;
import p640sq.C12836o;
import p687uq.InterfaceC13237b;

/* renamed from: uq.c */
/* loaded from: classes8.dex */
public class C13238c {

    /* renamed from: a */
    public final String f59914a;

    /* renamed from: b */
    public InterfaceC13237b f59915b;

    /* renamed from: c */
    public InterfaceC13237b.a f59916c;

    /* renamed from: uq.c$b */
    public static class b {

        /* renamed from: a */
        public static C13238c f59917a = new C13238c();
    }

    /* renamed from: a */
    public static C13238c m79615a() {
        return b.f59917a;
    }

    /* renamed from: b */
    public final void m79616b(InterfaceC13237b.a aVar) {
        this.f59916c = aVar;
    }

    /* renamed from: c */
    public boolean m79617c() {
        InterfaceC13237b.a aVar = this.f59916c;
        if (aVar == InterfaceC13237b.a.MODE_SUPPORT_UNKNOWN) {
            try {
                if (m79620f()) {
                    m79616b(InterfaceC13237b.a.MODE_SUPPORT_MTK_GEMINI);
                    return true;
                }
                if (m79619e()) {
                    m79616b(InterfaceC13237b.a.MODE_SUPPORT_HW_GEMINI);
                    return true;
                }
                m79616b(InterfaceC13237b.a.MODE_NOT_SUPPORT_GEMINI);
            } catch (Error e10) {
                C12836o.m77096a(this.f59914a, "" + e10.getClass().getSimpleName(), true);
            } catch (Exception e11) {
                C12836o.m77096a(this.f59914a, " " + e11.getClass().getSimpleName(), true);
            }
        } else if (aVar == InterfaceC13237b.a.MODE_SUPPORT_HW_GEMINI || aVar == InterfaceC13237b.a.MODE_SUPPORT_MTK_GEMINI) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public InterfaceC13237b m79618d() {
        if (this.f59916c == InterfaceC13237b.a.MODE_SUPPORT_MTK_GEMINI) {
            this.f59915b = C13240e.m79623c();
        } else {
            this.f59915b = C13239d.m79621c();
        }
        return this.f59915b;
    }

    /* renamed from: e */
    public boolean m79619e() {
        boolean zBooleanValue = false;
        try {
            Object objM79622d = C13239d.m79622d();
            if (objM79622d != null) {
                zBooleanValue = ((Boolean) objM79622d.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(objM79622d, new Object[0])).booleanValue();
            }
        } catch (Error e10) {
            C12836o.m77096a(this.f59914a, "108isMultiSimEnabled()" + e10.getClass().getSimpleName(), true);
        } catch (Exception e11) {
            C12836o.m77096a(this.f59914a, "isMultiSimEnabled()?" + e11.getClass().getSimpleName(), true);
        }
        C12836o.m77096a(this.f59914a, "isHwGeminiSupport1" + zBooleanValue, true);
        return zBooleanValue;
    }

    /* renamed from: f */
    public final boolean m79620f() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        boolean z10;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z10 = declaredField.getBoolean(null);
        } catch (Error e10) {
            C12836o.m77096a(this.f59914a, "FeatureOption.MTK_GEMINI_SUPPORT" + e10.getClass().getSimpleName(), true);
            z10 = false;
            C12836o.m77096a(this.f59914a, "isMtkGeminiSupport" + z10, true);
            return z10;
        } catch (Exception e11) {
            C12836o.m77096a(this.f59914a, "FeatureOption.MTK_GEMINI_SUPPORT" + e11.getClass().getSimpleName(), true);
            z10 = false;
            C12836o.m77096a(this.f59914a, "isMtkGeminiSupport" + z10, true);
            return z10;
        }
        C12836o.m77096a(this.f59914a, "isMtkGeminiSupport" + z10, true);
        return z10;
    }

    public C13238c() {
        this.f59914a = C13238c.class.getSimpleName();
        this.f59916c = InterfaceC13237b.a.MODE_SUPPORT_UNKNOWN;
    }
}
