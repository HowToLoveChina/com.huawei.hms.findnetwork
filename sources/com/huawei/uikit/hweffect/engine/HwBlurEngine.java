package com.huawei.uikit.hweffect.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class HwBlurEngine {

    /* renamed from: A */
    private static final Method f42775A;

    /* renamed from: B */
    private static final Method f42776B;
    public static final int BLURTYPE_DARK = 2;
    public static final int BLURTYPE_DEFAULT = 1;
    public static final int BLURTYPE_LIGHT = 3;
    public static final int BLURTYPE_LIGHT_WITH_GRAY = 4;

    /* renamed from: C */
    private static final Method f42777C;

    /* renamed from: D */
    private static final Method f42778D;

    /* renamed from: E */
    private static Object f42779E = null;

    /* renamed from: F */
    private static HwBlurEngine f42780F = new HwBlurEngine();

    /* renamed from: a */
    private static final String f42781a = "HwBlurEngine";

    /* renamed from: b */
    private static final String f42782b = "huawei.android.widget.effect.engine.HwBlurEngine";

    /* renamed from: c */
    private static final String f42783c = "huawei.android.widget.effect.engine.HwBlurEngine$BlurType";

    /* renamed from: d */
    private static final Method f42784d;

    /* renamed from: e */
    private static final Method f42785e;

    /* renamed from: f */
    private static final Method f42786f;

    /* renamed from: g */
    private static final Method f42787g;

    /* renamed from: h */
    private static final Method f42788h;

    /* renamed from: i */
    private static final Method f42789i;

    /* renamed from: j */
    private static final Method f42790j;

    /* renamed from: k */
    private static final Method f42791k;

    /* renamed from: l */
    private static final Method f42792l;

    /* renamed from: m */
    private static final Method f42793m;

    /* renamed from: n */
    private static final Method f42794n;

    /* renamed from: o */
    private static final Method f42795o;

    /* renamed from: p */
    private static final Method f42796p;

    /* renamed from: q */
    private static final Method f42797q;

    /* renamed from: r */
    private static final Method f42798r;

    /* renamed from: s */
    private static final Method f42799s;

    /* renamed from: t */
    private static final Method f42800t;

    /* renamed from: u */
    private static final Method f42801u;

    /* renamed from: v */
    private static final Method f42802v;

    /* renamed from: w */
    private static final Method f42803w;

    /* renamed from: x */
    private static final Method f42804x;

    /* renamed from: y */
    private static final Method f42805y;

    /* renamed from: z */
    private static final Method f42806z;

    static {
        Class<?> cls;
        try {
            cls = Class.forName(f42783c);
        } catch (ClassNotFoundException unused) {
            Log.e(f42781a, "BlurType class not found");
            cls = null;
        }
        f42784d = HwReflectUtil.getMethod("getInstance", (Class[]) null, f42782b);
        f42785e = HwReflectUtil.getMethod("getInstance", new Class[]{View.class, cls}, f42782b);
        f42786f = HwReflectUtil.getMethod("isEnable", (Class[]) null, f42782b);
        Class cls2 = Boolean.TYPE;
        f42787g = HwReflectUtil.getMethod("setGlobalEnable", new Class[]{cls2}, f42782b);
        f42788h = HwReflectUtil.getMethod("setEnable", new Class[]{cls2}, f42782b);
        f42789i = HwReflectUtil.getMethod("onAttachedToWindow", (Class[]) null, f42782b);
        f42790j = HwReflectUtil.getMethod("onDetachedFromWindow", (Class[]) null, f42782b);
        f42791k = HwReflectUtil.getMethod("draw", new Class[]{Canvas.class}, f42782b);
        f42792l = HwReflectUtil.getMethod("draw", new Class[]{Canvas.class, View.class}, f42782b);
        f42793m = HwReflectUtil.getMethod("setBlurEnable", new Class[]{cls2}, f42782b);
        f42794n = HwReflectUtil.getMethod("isBlurEnable", (Class[]) null, f42782b);
        f42795o = HwReflectUtil.getMethod("isShowHwBlur", (Class[]) null, f42782b);
        f42796p = HwReflectUtil.getMethod("isShowHwBlur", new Class[]{View.class}, f42782b);
        f42797q = HwReflectUtil.getMethod("onWindowVisibilityChanged", new Class[]{View.class, cls2, cls2}, f42782b);
        f42798r = HwReflectUtil.getMethod("onWindowVisibilityChanged", new Class[]{View.class, cls2}, f42782b);
        f42799s = HwReflectUtil.getMethod("onWindowFocusChanged", new Class[]{View.class, cls2, cls2}, f42782b);
        Class cls3 = Integer.TYPE;
        f42800t = HwReflectUtil.getMethod("blur", new Class[]{View.class, cls3, cls3}, f42782b);
        f42801u = HwReflectUtil.getMethod("blur", new Class[]{Bitmap.class, cls3, cls3}, f42782b);
        f42802v = HwReflectUtil.getMethod("addBlurTargetView", new Class[]{View.class, cls}, f42782b);
        f42803w = HwReflectUtil.getMethod("removeBlurTargetView", new Class[]{View.class}, f42782b);
        f42804x = HwReflectUtil.getMethod("isDrawingViewSelf", (Class[]) null, f42782b);
        f42805y = HwReflectUtil.getMethod("setTargetViewCornerRadius", new Class[]{View.class, cls3}, f42782b);
        f42806z = HwReflectUtil.getMethod("setTargetViewBlurEnable", new Class[]{View.class, cls2}, f42782b);
        f42775A = HwReflectUtil.getMethod("setTargetViewOverlayColor", new Class[]{View.class, cls3}, f42782b);
        f42776B = HwReflectUtil.getMethod("isShowBlur", new Class[]{Context.class}, f42782b);
        f42777C = HwReflectUtil.getMethod("isThemeSupportedBlurEffect", new Class[]{Context.class}, f42782b);
        f42778D = HwReflectUtil.getMethod("isSettingEnabledBlurEffect", new Class[]{Context.class}, f42782b);
    }

    /* renamed from: a */
    private static Object m54670a(int i10) {
        try {
            Object[] enumConstants = Class.forName(f42783c).getEnumConstants();
            int i11 = i10 - 1;
            if (enumConstants != null && i11 >= 0 && i11 < enumConstants.length) {
                return enumConstants[i11];
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    public static Bitmap blur(View view, int i10, int i11) {
        Method method = f42800t;
        if (method != null) {
            Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{view, Integer.valueOf(i10), Integer.valueOf(i11)});
            if (objInvokeMethod instanceof Bitmap) {
                return (Bitmap) objInvokeMethod;
            }
        }
        return null;
    }

    @Deprecated
    public static synchronized HwBlurEngine getInstance(View view, int i10) {
        try {
            Method method = f42785e;
            if (method != null && f42779E == null) {
                f42779E = HwReflectUtil.invokeMethod(null, method, new Object[]{view, m54670a(i10)});
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f42780F;
    }

    @Deprecated
    public static boolean isEnable() {
        Method method = f42786f;
        if (method == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(method));
    }

    @Deprecated
    public static void setGlobalEnable(boolean z10) {
        Method method = f42787g;
        if (method != null) {
            HwReflectUtil.invokeMethod(null, method, new Object[]{Boolean.valueOf(z10)});
        }
    }

    public void addBlurTargetView(View view, int i10) {
        Method method;
        if (f42779E == null || (method = f42802v) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(f42779E, method, new Object[]{view, m54670a(i10)});
    }

    @Deprecated
    public void draw(Canvas canvas) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42791k) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{canvas});
    }

    public boolean isBlurEnable() {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42794n) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method));
    }

    public boolean isDrawingViewSelf() {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42804x) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method));
    }

    public boolean isSettingEnabledBlurEffect(Context context) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42778D) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method, new Object[]{context}));
    }

    public boolean isShowBlur(Context context) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42776B) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method, new Object[]{context}));
    }

    public boolean isShowHwBlur() {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42795o) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method));
    }

    public boolean isThemeSupportedBlurEffect(Context context) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42777C) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method, new Object[]{context}));
    }

    @Deprecated
    public void onAttachedToWindow() {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42789i) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method);
    }

    @Deprecated
    public void onDetachedFromWindow() {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42790j) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method);
    }

    @Deprecated
    public void onWindowFocusChanged(View view, boolean z10, boolean z11) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42799s) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view, Boolean.valueOf(z10), Boolean.valueOf(z11)});
    }

    public void onWindowVisibilityChanged(View view, boolean z10, boolean z11) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42797q) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view, Boolean.valueOf(z10), Boolean.valueOf(z11)});
    }

    public void removeBlurTargetView(View view) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42803w) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view});
    }

    public void setBlurEnable(boolean z10) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42793m) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{Boolean.valueOf(z10)});
    }

    @Deprecated
    public void setEnable(boolean z10) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42788h) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{Boolean.valueOf(z10)});
    }

    public void setTargetViewBlurEnable(View view, boolean z10) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42806z) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view, Boolean.valueOf(z10)});
    }

    public void setTargetViewCornerRadius(View view, int i10) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42805y) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view, Integer.valueOf(i10)});
    }

    public void setTargetViewOverlayColor(View view, int i10) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42775A) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view, Integer.valueOf(i10)});
    }

    public void draw(Canvas canvas, View view) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42792l) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{canvas, view});
    }

    public boolean isShowHwBlur(View view) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42796p) == null) {
            return false;
        }
        return m54671a(HwReflectUtil.invokeMethod(obj, method, new Object[]{view}));
    }

    public void onWindowVisibilityChanged(View view, boolean z10) {
        Method method;
        Object obj = f42779E;
        if (obj == null || (method = f42798r) == null) {
            return;
        }
        HwReflectUtil.invokeMethod(obj, method, new Object[]{view, Boolean.valueOf(z10)});
    }

    /* renamed from: a */
    private static boolean m54671a(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static Bitmap blur(Bitmap bitmap, int i10, int i11) {
        Method method = f42801u;
        if (method != null) {
            Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{bitmap, Integer.valueOf(i10), Integer.valueOf(i11)});
            if (objInvokeMethod instanceof Bitmap) {
                return (Bitmap) objInvokeMethod;
            }
        }
        return null;
    }

    public static synchronized HwBlurEngine getInstance() {
        try {
            Method method = f42784d;
            if (method != null && f42779E == null) {
                f42779E = HwReflectUtil.invokeMethod(method);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f42780F;
    }
}
