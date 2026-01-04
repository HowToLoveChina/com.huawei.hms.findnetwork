package com.huawei.uikit.hwgraphiceffect.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class HwShadowEngine {
    public static final int DARK_STYLE = 1;
    public static final int FLOATING_SHADOW_SIZE_L = 6;
    public static final int FLOATING_SHADOW_SIZE_M = 5;
    public static final int FLOATING_SHADOW_SIZE_S = 4;
    public static final int LIGHT_STYLE = 0;
    public static final int SHADOW_SIZE_L = 3;
    public static final int SHADOW_SIZE_M = 2;
    public static final int SHADOW_SIZE_S = 1;
    public static final int SHADOW_SIZE_XS = 0;
    public static final int TRANSLUCENT_STYLE = 2;

    /* renamed from: g */
    private static final String f42840g = "HwShadowEngine";

    /* renamed from: h */
    private static final int f42841h = -1;

    /* renamed from: i */
    private static final String f42842i = "android.view.View";

    /* renamed from: j */
    private static final Method f42843j;

    /* renamed from: k */
    private static final Method f42844k;

    /* renamed from: a */
    private Context f42845a;

    /* renamed from: b */
    private View f42846b;

    /* renamed from: c */
    private boolean f42847c;

    /* renamed from: d */
    private int f42848d;

    /* renamed from: e */
    private int f42849e;

    /* renamed from: f */
    private int f42850f;

    static {
        Class cls = Integer.TYPE;
        f42843j = m54679a("setShadowStyle", new Class[]{cls, cls, cls}, f42842i);
        f42844k = m54679a("setShadowClip", new Class[]{Boolean.TYPE}, f42842i);
    }

    public HwShadowEngine(Context context, View view) {
        this(context, view, 0, 0);
    }

    /* renamed from: a */
    private void m54680a(int i10) {
        if (i10 < 0 || i10 > 6) {
            return;
        }
        this.f42848d = i10;
    }

    /* renamed from: b */
    private void m54681b(int i10) {
        if (i10 < 0 || i10 > 2) {
            return;
        }
        this.f42849e = i10;
    }

    /* renamed from: c */
    private void m54683c() {
        int i10 = this.f42849e;
        if (i10 == 2) {
            this.f42850f = 2;
        } else if (i10 == 1 || m54682b()) {
            this.f42850f = 1;
        } else {
            this.f42850f = 0;
        }
    }

    public int getShadowSize() {
        return this.f42848d;
    }

    public int getShadowStyle() {
        return this.f42849e;
    }

    public boolean isShadowEnabled() {
        return this.f42847c;
    }

    public void refreshShadowEffects() {
        View view;
        m54683c();
        Method method = f42843j;
        if (method == null || (view = this.f42846b) == null) {
            Log.w(f42840g, "Method or target view is null!");
        } else if (this.f42847c) {
            m54678a(view, method, new Object[]{Integer.valueOf(this.f42848d), Integer.valueOf(this.f42850f), Integer.valueOf(m54677a())});
        } else {
            m54678a(view, method, new Object[]{-1, -1, -1});
        }
    }

    public void setInsideShadowClip(boolean z10) {
        View view;
        Method method = f42844k;
        if (method == null || (view = this.f42846b) == null) {
            Log.w(f42840g, "Method or target view is null!");
        } else {
            m54678a(view, method, new Object[]{Boolean.valueOf(z10)});
        }
    }

    public void setShadowEnabled(boolean z10) {
        if (this.f42847c != z10) {
            this.f42847c = z10;
            refreshShadowEffects();
        }
    }

    public void setShadowSize(int i10) {
        m54680a(i10);
    }

    public void setShadowStyle(int i10) {
        m54681b(i10);
    }

    public HwShadowEngine(Context context, View view, int i10, int i11) {
        this.f42847c = false;
        this.f42848d = 0;
        this.f42849e = 0;
        this.f42850f = 0;
        this.f42845a = context;
        this.f42846b = view;
        m54680a(i10);
        m54681b(i11);
    }

    /* renamed from: a */
    private static Method m54679a(String str, Class[] clsArr, String str2) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = Class.forName(str2).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (ClassNotFoundException unused) {
            Log.e(f42840g, "ClassNotFoundException in reflect call " + str);
            return null;
        } catch (NoSuchMethodException unused2) {
            Log.e(f42840g, "there is no " + str + " method");
            return null;
        }
    }

    /* renamed from: b */
    private boolean m54682b() {
        return (this.f42845a.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* renamed from: a */
    private Object m54678a(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            Log.e(f42840g, "IllegalAccessException in reflect call " + method.getName());
            return null;
        } catch (InvocationTargetException unused2) {
            Log.e(f42840g, "InvocationTargetException in reflect call " + method.getName());
            return null;
        }
    }

    /* renamed from: a */
    private int m54677a() {
        return this.f42845a.getResources().getConfiguration().uiMode & 15;
    }
}
