package com.huawei.hms.common.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class AccountPickerEmuiUtil {

    /* renamed from: a */
    private static int f23556a = -1;

    /* renamed from: b */
    private static int f23557b;

    public static class ReflectionUtils {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static Object m30754b() throws NoSuchFieldException, SecurityException {
            Class<?> cls = getClass(EmuiUtil.BUILDEX_VERSION);
            if (cls == null || TextUtils.isEmpty(EmuiUtil.EMUI_SDK_INT)) {
                return null;
            }
            try {
                Field declaredField = cls.getDeclaredField(EmuiUtil.EMUI_SDK_INT);
                AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                return declaredField.get(cls);
            } catch (IllegalAccessException unused) {
                C12836o.m77098c("ReflectionUtils", "IllegalAccessException", true);
                return null;
            } catch (IllegalArgumentException unused2) {
                C12836o.m77098c("ReflectionUtils", "IllegalArgumentException", true);
                return null;
            } catch (NoSuchFieldException unused3) {
                C12836o.m77098c("ReflectionUtils", "NoSuchFieldException", true);
                return null;
            } catch (SecurityException unused4) {
                C12836o.m77097b("ReflectionUtils", "not security int method", true);
                return null;
            }
        }

        public static Class<?> getClass(String str) {
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
    }

    static {
        m30750a();
    }

    /* renamed from: a */
    private static void m30750a() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
        int iM30752c = m30752c();
        f23557b = iM30752c;
        if (iM30752c >= 17) {
            f23556a = 90;
        }
        if (iM30752c >= 11) {
            f23556a = 50;
        } else if (iM30752c >= 10) {
            f23556a = 41;
        } else if (iM30752c >= 9) {
            f23556a = 40;
        } else if (iM30752c >= 8) {
            f23556a = 31;
        } else if (iM30752c >= 7) {
            f23556a = 30;
        }
        if (f23556a == -1) {
            m30751b();
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: b */
    private static void m30751b() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f23556a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    f23556a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    f23556a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    f23556a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f23556a = 50;
                }
            }
        } catch (RuntimeException unused) {
            C12836o.m77099d("AccountPickerEmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            C12836o.m77099d("AccountPickerEmuiUtil", "getEmuiType Exception.", true);
        }
    }

    /* renamed from: c */
    private static int m30752c() throws NoSuchFieldException, SecurityException {
        Object objM30754b = ReflectionUtils.m30754b();
        if (objM30754b != null) {
            try {
                f23557b = ((Integer) objM30754b).intValue();
            } catch (ClassCastException unused) {
                C12836o.m77099d("AccountPickerEmuiUtil", "EMUIVersionCode is not a number", true);
            }
        }
        return f23557b;
    }

    public static boolean isAboveEMUI100() {
        return f23557b >= 21;
    }
}
