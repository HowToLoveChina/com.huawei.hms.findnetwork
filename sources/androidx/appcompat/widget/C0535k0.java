package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p273f0.C9603h0;

/* renamed from: androidx.appcompat.widget.k0 */
/* loaded from: classes.dex */
public class C0535k0 {

    /* renamed from: a */
    public static Method f2368a;

    /* renamed from: b */
    public static final boolean f2369b = true;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f2368a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f2368a.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    /* renamed from: a */
    public static void m3055a(View view, Rect rect, Rect rect2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f2368a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e10) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e10);
            }
        }
    }

    /* renamed from: b */
    public static boolean m3056b(View view) {
        return C9603h0.m59832A(view) == 1;
    }

    /* renamed from: c */
    public static void m3057c(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e11) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11);
        }
    }
}
