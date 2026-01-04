package p640sq;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* renamed from: sq.s */
/* loaded from: classes8.dex */
public class C12840s {
    /* renamed from: a */
    public static Class<?> m77117a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!EmuiUtil.BUILDEX_VERSION.equals(str) && !EmuiUtil.IMMERSION_STYLE.equals(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            C12836o.m77098c("ReflectionUtils", "className not found:", true);
            return null;
        }
    }

    /* renamed from: b */
    public static Object m77118b(String str, String str2) throws NoSuchFieldException, SecurityException {
        Class<?> clsM77117a = m77117a(str);
        if (clsM77117a == null || TextUtils.isEmpty(str2) || !EmuiUtil.BUILDEX_VERSION.equals(str) || !EmuiUtil.EMUI_SDK_INT.equals(str2)) {
            return null;
        }
        try {
            Field declaredField = clsM77117a.getDeclaredField(str2);
            AccessibleObject.setAccessible(new Field[]{declaredField}, true);
            return declaredField.get(clsM77117a);
        } catch (IllegalAccessException unused) {
            C12836o.m77098c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
            return null;
        } catch (IllegalArgumentException unused2) {
            C12836o.m77098c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
            return null;
        } catch (NoSuchFieldException unused3) {
            C12836o.m77098c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
            return null;
        } catch (SecurityException unused4) {
            C12836o.m77097b("ReflectionUtils", "not security int method getStaticFieldObj", true);
            return null;
        }
    }
}
