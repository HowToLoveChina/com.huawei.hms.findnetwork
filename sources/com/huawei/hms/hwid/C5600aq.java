package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* renamed from: com.huawei.hms.hwid.aq */
/* loaded from: classes8.dex */
public class C5600aq {

    /* renamed from: a */
    private static int f25352a = -1;

    /* renamed from: b */
    private static int f25353b;

    static {
        m32903b();
    }

    /* renamed from: a */
    public static boolean m32902a() {
        return f25353b >= 21;
    }

    /* renamed from: b */
    private static void m32903b() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
        int iM32905d = m32905d();
        f25353b = iM32905d;
        if (iM32905d >= 17) {
            f25352a = 90;
        }
        if (iM32905d >= 11) {
            f25352a = 50;
        } else if (iM32905d >= 10) {
            f25352a = 41;
        } else if (iM32905d >= 9) {
            f25352a = 40;
        } else if (iM32905d >= 8) {
            f25352a = 31;
        } else if (iM32905d >= 7) {
            f25352a = 30;
        }
        if (f25352a == -1) {
            m32904c();
        }
    }

    /* renamed from: c */
    private static void m32904c() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f25352a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    f25352a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    f25352a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    f25352a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f25352a = 50;
                }
            }
        } catch (RuntimeException unused) {
            C5602as.m32912d("EmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            C5602as.m32912d("EmuiUtil", "getEmuiType Exception.", true);
        }
    }

    /* renamed from: d */
    private static int m32905d() throws NoSuchFieldException, SecurityException {
        Object objM32907a = a.m32907a(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (objM32907a != null) {
            try {
                f25353b = ((Integer) objM32907a).intValue();
            } catch (ClassCastException unused) {
                C5602as.m32912d("EmuiUtil", "getEMUIVersionCode is not a number", true);
            }
        }
        return f25353b;
    }

    /* renamed from: com.huawei.hms.hwid.aq$a */
    public static class a {
        /* renamed from: a */
        public static Class<?> m32906a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!EmuiUtil.BUILDEX_VERSION.equals(str) && !EmuiUtil.IMMERSION_STYLE.equals(str)) {
                return null;
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        /* renamed from: a */
        public static Object m32907a(String str, String str2) throws NoSuchFieldException, SecurityException {
            Class<?> clsM32906a = m32906a(str);
            if (clsM32906a == null || TextUtils.isEmpty(str2) || !EmuiUtil.BUILDEX_VERSION.equals(str) || !EmuiUtil.EMUI_SDK_INT.equals(str2)) {
                return null;
            }
            try {
                Field declaredField = clsM32906a.getDeclaredField(str2);
                AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                return declaredField.get(clsM32906a);
            } catch (IllegalAccessException unused) {
                C5602as.m32911c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
                return null;
            } catch (IllegalArgumentException unused2) {
                C5602as.m32911c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
                return null;
            } catch (NoSuchFieldException unused3) {
                C5602as.m32911c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
                return null;
            } catch (SecurityException unused4) {
                C5602as.m32910b("ReflectionUtils", "not security int method getStaticFieldObj", true);
                return null;
            }
        }
    }
}
