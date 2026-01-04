package com.huawei.uikit.hweffect.engine;

import android.graphics.Canvas;
import android.util.Log;
import android.view.ViewGroup;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class HwShadowEngine {
    public static final int SHADOWTYPE_LARGE = 3;
    public static final int SHADOWTYPE_MEDIUM = 2;
    public static final int SHADOWTYPE_SMALL = 1;
    public static final int SHADOWTYPE_XLARGE = 4;

    /* renamed from: b */
    private static final String f42807b = "HwShadowEngine";

    /* renamed from: d */
    private static final String f42809d = "huawei.android.widget.effect.engine.HwShadowEngine$ShadowType";

    /* renamed from: a */
    private Object f42814a;

    /* renamed from: c */
    private static final String f42808c = "huawei.android.widget.effect.engine.HwShadowEngine";

    /* renamed from: e */
    private static final Method f42810e = HwReflectUtil.getMethod("isDeviceSupport", (Class[]) null, f42808c);

    /* renamed from: f */
    private static final Method f42811f = HwReflectUtil.getMethod("setEnable", new Class[]{Boolean.TYPE}, f42808c);

    /* renamed from: g */
    private static final Method f42812g = HwReflectUtil.getMethod("isEnable", (Class[]) null, f42808c);

    /* renamed from: h */
    private static final Method f42813h = HwReflectUtil.getMethod("renderShadow", new Class[]{Canvas.class}, f42808c);

    public HwShadowEngine(ViewGroup viewGroup) {
        this(viewGroup, 2);
    }

    /* renamed from: a */
    private static boolean m54672a(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static boolean isDeviceSupport() {
        Method method = f42810e;
        if (method == null) {
            return false;
        }
        return m54672a(HwReflectUtil.invokeMethod(method));
    }

    public boolean isEnable() {
        Object obj;
        Method method = f42812g;
        if (method == null || (obj = this.f42814a) == null) {
            return false;
        }
        return m54672a(HwReflectUtil.invokeMethod(obj, method));
    }

    public void renderShadow(Canvas canvas) {
        Object obj;
        Method method = f42813h;
        if (method == null || (obj = this.f42814a) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{canvas});
    }

    public void setEnable(boolean z10) {
        Object obj;
        Method method = f42811f;
        if (method == null || (obj = this.f42814a) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{Boolean.valueOf(z10)});
    }

    public HwShadowEngine(ViewGroup viewGroup, int i10) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> cls;
        Object obj = null;
        try {
            cls = Class.forName(f42809d);
            try {
                Object[] enumConstants = cls.getEnumConstants();
                int i11 = i10 - 1;
                if (enumConstants != null && i11 >= 0 && i11 < enumConstants.length) {
                    obj = enumConstants[i11];
                }
            } catch (ClassNotFoundException unused) {
                Log.e(f42807b, "ShadowType class not found");
                if (cls != null) {
                    return;
                } else {
                    return;
                }
            }
        } catch (ClassNotFoundException unused2) {
            cls = null;
        }
        if (cls != null || obj == null) {
            return;
        }
        try {
            Constructor<?> constructor = Class.forName(f42808c).getConstructor(ViewGroup.class, cls);
            constructor.setAccessible(true);
            this.f42814a = constructor.newInstance(viewGroup, obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused3) {
            Log.e(f42807b, "HwShadowEngine init failed");
        }
    }
}
