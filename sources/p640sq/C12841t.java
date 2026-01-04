package p640sq;

import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: sq.t */
/* loaded from: classes8.dex */
public class C12841t {
    /* renamed from: a */
    public static void m77119a(Window window) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m77120b(window, "addHwFlags");
    }

    /* renamed from: b */
    public static void m77120b(Window window, String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            C12836o.m77097b("ScreenShotUtils", "invokeScreenShot flags==" + str, true);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            Object objNewInstance = cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes);
            Method method = cls.getMethod(str, Integer.TYPE);
            method.invoke(objNewInstance, 4096);
            method.invoke(objNewInstance, 8192);
            window.clearFlags(0);
        } catch (ClassNotFoundException e10) {
            C12836o.m77099d("ScreenShotUtils", "ClassNotFoundException--" + e10.getClass().getSimpleName(), true);
        } catch (IllegalAccessException e11) {
            C12836o.m77099d("ScreenShotUtils", "IllegalAccessException--" + e11.getClass().getSimpleName(), true);
        } catch (InstantiationException e12) {
            C12836o.m77099d("ScreenShotUtils", "InstantiationException--" + e12.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e13) {
            C12836o.m77099d("ScreenShotUtils", "NoSuchMethodException--" + e13.getClass().getSimpleName(), true);
        } catch (InvocationTargetException e14) {
            C12836o.m77099d("ScreenShotUtils", "InvocationTargetException--" + e14.getClass().getSimpleName(), true);
        } catch (Exception e15) {
            C12836o.m77099d("ScreenShotUtils", "Exception--" + e15.getClass().getSimpleName(), true);
        } catch (NoClassDefFoundError e16) {
            C12836o.m77099d("ScreenShotUtils", "NoClassDefFoundError--" + e16.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: c */
    public static void m77121c(Window window) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m77120b(window, "clearHwFlags");
    }
}
