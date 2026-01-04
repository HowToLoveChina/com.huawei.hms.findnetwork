package p640sq;

import android.app.ActionBar;
import com.huawei.android.app.ActionBarEx;
import com.huawei.hms.framework.common.EmuiUtil;

/* renamed from: sq.h */
/* loaded from: classes8.dex */
public class C12829h {

    /* renamed from: a */
    public static int f58577a = -1;

    /* renamed from: b */
    public static boolean f58578b = false;

    /* renamed from: c */
    public static int f58579c;

    static {
        m77064i();
    }

    /* renamed from: a */
    public static boolean m77056a() {
        return f58579c >= 21;
    }

    /* renamed from: b */
    public static boolean m77057b() {
        return f58579c >= 17;
    }

    /* renamed from: c */
    public static boolean m77058c() {
        return f58577a == 50;
    }

    /* renamed from: d */
    public static boolean m77059d() {
        return f58577a == 60;
    }

    /* renamed from: e */
    public static boolean m77060e() {
        return f58577a == 81;
    }

    /* renamed from: f */
    public static boolean m77061f() {
        return true;
    }

    /* renamed from: g */
    public static boolean m77062g() {
        return true;
    }

    /* renamed from: h */
    public static void m77063h() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f58577a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    f58577a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    f58577a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    f58577a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f58577a = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    f58577a = 60;
                }
            }
        } catch (RuntimeException unused) {
            C12836o.m77099d("EmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            C12836o.m77099d("EmuiUtil", "getEmuiType Exception.", true);
        }
    }

    /* renamed from: i */
    public static void m77064i() throws ClassNotFoundException {
        f58579c = m77065j();
        C12836o.m77097b("EmuiUtil", "getEmuiType emuiVersionCode=" + f58579c, true);
        int i10 = f58579c;
        if (i10 >= 15) {
            f58577a = 81;
        } else if (i10 >= 14) {
            f58577a = 60;
        } else if (i10 >= 11) {
            f58577a = 50;
        } else if (i10 >= 10) {
            f58577a = 41;
        } else if (i10 >= 9) {
            f58577a = 40;
        } else if (i10 >= 8) {
            f58577a = 31;
        } else if (i10 >= 7) {
            f58577a = 30;
        }
        if (f58577a == -1) {
            m77063h();
        }
        f58578b = m77066k();
        C12836o.m77096a("EmuiUtil", " init emui version is" + f58577a + ", hasActionBarEx=" + f58578b, true);
    }

    /* renamed from: j */
    public static int m77065j() throws NoSuchFieldException, SecurityException {
        int iIntValue;
        Object objM77118b = C12840s.m77118b(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (objM77118b != null) {
            try {
                iIntValue = ((Integer) objM77118b).intValue();
            } catch (ClassCastException unused) {
                C12836o.m77099d("EmuiUtil", "getEMUIVersionCode is not a number", true);
            }
        } else {
            iIntValue = 0;
        }
        C12836o.m77097b("EmuiUtil", "the emui version code is::" + iIntValue, true);
        return iIntValue;
    }

    /* renamed from: k */
    public static boolean m77066k() {
        boolean z10 = true;
        try {
            if (f58577a != -1) {
                ActionBarEx.getDragAnimationStage((ActionBar) null);
            } else {
                z10 = false;
            }
            return z10;
        } catch (Exception unused) {
            C12836o.m77099d("EmuiUtil", "ActionBarEx class not found: ", true);
            return false;
        }
    }
}
