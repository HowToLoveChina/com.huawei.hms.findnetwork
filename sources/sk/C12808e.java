package sk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.hihonor.android.view.WindowManagerEx;
import com.huawei.android.view.WindowManagerEx;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0219i;
import p399jk.AbstractC10896a;

/* renamed from: sk.e */
/* loaded from: classes6.dex */
public class C12808e {

    /* renamed from: a */
    public static int f58507a;

    /* renamed from: a */
    public static void m76822a(Activity activity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        View decorView;
        if (C0219i.m1463a() < 21 || activity == null) {
            return;
        }
        m76824c(activity);
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC12807d());
    }

    /* renamed from: b */
    public static int m76823b() {
        return f58507a;
    }

    /* renamed from: c */
    public static void m76824c(Activity activity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (activity == null) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (C0209d.m1277l1()) {
                WindowManagerEx.LayoutParamsEx layoutParamsEx = new WindowManagerEx.LayoutParamsEx(attributes);
                layoutParamsEx.getClass().getMethod("setDisplaySideMode", Integer.TYPE).invoke(layoutParamsEx, 1);
            } else {
                WindowManagerEx.LayoutParamsEx layoutParamsEx2 = new WindowManagerEx.LayoutParamsEx(attributes);
                layoutParamsEx2.getClass().getMethod("setDisplaySideMode", Integer.TYPE).invoke(layoutParamsEx2, 1);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SideRegionUtil", "hasNotchInHuawei exception:" + e10.toString());
        }
    }

    /* renamed from: d */
    public static void m76825d(int i10) {
        f58507a = i10;
    }

    /* renamed from: e */
    public static void m76826e(View view) {
        try {
            if (C0219i.m1463a() < 21 || view == null) {
                return;
            }
            view.setPadding(m76823b(), 0, m76823b(), 0);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SideRegionUtil", "setViewSidePadding exception: " + e10.toString());
        }
    }

    /* renamed from: f */
    public static void m76827f(Context context, View view) {
        try {
            if (C0219i.m1463a() >= 21 && context != null) {
                int iM76811b = C12806c.m76811b(context);
                if (1 == iM76811b) {
                    AbstractC10896a.m65885d("SideRegionUtil", "ROTATION_90");
                } else if (3 == iM76811b) {
                    AbstractC10896a.m65885d("SideRegionUtil", "ROTATION_270");
                } else {
                    AbstractC10896a.m65885d("SideRegionUtil", "portrait");
                    m76826e(view);
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SideRegionUtil", "onApplyWindowInsets exception: " + e10.toString());
        }
    }
}
