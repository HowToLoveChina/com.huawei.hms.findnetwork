package ng;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.hiar.ARImageMetadata;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p809yg.C13981a;

/* renamed from: ng.g */
/* loaded from: classes4.dex */
public class C11700g {
    /* renamed from: c */
    public static void m69772c(Window window) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m69775f(window, "addHwFlags");
    }

    /* renamed from: d */
    public static void m69773d(Activity activity) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (activity == null) {
            C13981a.m83988e("ScreenShotUtil", "window is null!");
            return;
        }
        try {
            final Method declaredMethod = Window.class.getDeclaredMethod("addPrivateFlags", Integer.TYPE);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: ng.f
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return C11700g.m69776g(declaredMethod);
                }
            });
            declaredMethod.invoke(activity.getWindow(), Integer.valueOf(ARImageMetadata.LENS_APERTURE));
            C13981a.m83987d("ScreenShotUtil", "addPrivateFlags");
        } catch (Exception e10) {
            C13981a.m83988e("ScreenShotUtil", "addPrivateFlags exception: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public static void m69774e(Window window) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m69775f(window, "clearHwFlags");
    }

    /* renamed from: f */
    public static void m69775f(Window window, String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (window == null) {
            C13981a.m83988e("ScreenShotUtil", "window is null!");
            return;
        }
        try {
            C13981a.m83989i("ScreenShotUtil", "invokeScreenShot flags:" + str);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            Object objNewInstance = cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes);
            Method method = cls.getMethod(str, Integer.TYPE);
            method.invoke(objNewInstance, 4096);
            method.invoke(objNewInstance, 8192);
            window.clearFlags(0);
        } catch (Exception unused) {
            C13981a.m83988e("ScreenShotUtil", "invokeScreenShot exception");
        }
    }

    /* renamed from: g */
    public static /* synthetic */ Object m69776g(Method method) throws SecurityException {
        method.setAccessible(true);
        return null;
    }

    /* renamed from: h */
    public static /* synthetic */ Object m69777h(Field field) throws SecurityException {
        field.setAccessible(true);
        return null;
    }

    /* renamed from: i */
    public static void m69778i(Activity activity) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (activity == null) {
            C13981a.m83988e("ScreenShotUtil", "window is null!");
            return;
        }
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            final Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("privateFlags");
            AccessController.doPrivileged(new PrivilegedAction() { // from class: ng.e
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return C11700g.m69777h(declaredField);
                }
            });
            declaredField.setInt(attributes, declaredField.getInt(attributes) & (-524289));
            window.setAttributes(attributes);
            C13981a.m83987d("ScreenShotUtil", "removePrivateFlags");
        } catch (Exception e10) {
            C13981a.m83988e("ScreenShotUtil", "removePrivateFlags exception: " + e10.getMessage());
        }
    }
}
