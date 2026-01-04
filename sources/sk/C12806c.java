package sk;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hicloud.base.p103ui.CustomOnApplyWindowInsetsListener;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p399jk.AbstractC10896a;

/* renamed from: sk.c */
/* loaded from: classes6.dex */
public class C12806c {
    /* renamed from: a */
    public static boolean m76810a(Context context) {
        if (context == null) {
            return false;
        }
        int i10 = Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0);
        AbstractC10896a.m65887i("NotchUtils", "DISPLAY_NOTCH_STATUS :" + i10);
        return i10 == 0;
    }

    /* renamed from: b */
    public static int m76811b(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    /* renamed from: c */
    public static int[] m76812c(Context context) {
        int[] iArr = {0, 0};
        if (context == null) {
            AbstractC10896a.m65887i("NotchUtils", "hasNotchInScreen()---context = null ");
            return iArr;
        }
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class<?> clsLoadClass = C0209d.m1277l1() ? classLoader.loadClass("com.hihonor.android.util.HwNotchSizeUtil") : classLoader.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            iArr = (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
        } catch (ClassNotFoundException e10) {
            AbstractC10896a.m65886e("NotchUtils", "ClassNotFoundException ! " + e10.getMessage());
        } catch (NoSuchMethodException e11) {
            AbstractC10896a.m65886e("NotchUtils", "NoSuchMethodException! " + e11.getMessage());
        } catch (Exception e12) {
            AbstractC10896a.m65886e("NotchUtils", "getNotchSize fail! " + e12.getMessage());
        }
        AbstractC10896a.m65887i("NotchUtils", "getNotchSize = " + iArr.length);
        return iArr;
    }

    /* renamed from: d */
    public static int m76813d(WindowInsets windowInsets) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.view.DisplayCutout");
            Object objInvoke = windowInsets.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(windowInsets, new Object[0]);
            if (objInvoke != null) {
                return ((Integer) cls.getDeclaredMethod("getSafeInsetLeft", new Class[0]).invoke(objInvoke, new Object[0])).intValue();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65885d("NotchUtils", "Exception: " + e10.toString());
        }
        return 0;
    }

    /* renamed from: e */
    public static int m76814e(WindowInsets windowInsets) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.view.DisplayCutout");
            Object objInvoke = windowInsets.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(windowInsets, new Object[0]);
            if (objInvoke != null) {
                return ((Integer) cls.getDeclaredMethod("getSafeInsetRight", new Class[0]).invoke(objInvoke, new Object[0])).intValue();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65885d("NotchUtils", "Exception: " + e10.toString());
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x004d  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m76815f(android.content.Context r5) {
        /*
            java.lang.String r0 = "NotchUtils"
            r1 = 0
            if (r5 != 0) goto Ld
            java.lang.String r5 = "hasNotchInHuawei exception: context is null."
            p399jk.AbstractC10896a.m65886e(r0, r5)     // Catch: java.lang.Exception -> Lb
            return r1
        Lb:
            r5 = move-exception
            goto L54
        Ld:
            java.lang.ClassLoader r2 = r5.getClassLoader()     // Catch: java.lang.Exception -> Lb
            boolean r3 = p015ak.C0209d.m1277l1()     // Catch: java.lang.Exception -> Lb
            if (r3 == 0) goto L1e
            java.lang.String r3 = "com.hihonor.android.util.HwNotchSizeUtil"
            java.lang.Class r2 = r2.loadClass(r3)     // Catch: java.lang.Exception -> Lb
            goto L24
        L1e:
            java.lang.String r3 = "com.huawei.android.util.HwNotchSizeUtil"
            java.lang.Class r2 = r2.loadClass(r3)     // Catch: java.lang.Exception -> Lb
        L24:
            java.lang.String r3 = "hasNotchInScreen"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> Lb
            java.lang.reflect.Method r3 = r2.getMethod(r3, r4)     // Catch: java.lang.Exception -> Lb
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> Lb
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Exception -> Lb
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Exception -> Lb
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> Lb
            r3 = 1
            if (r2 == 0) goto L4d
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L4a
            java.lang.String r4 = "display_notch_status"
            int r5 = android.provider.Settings.Secure.getInt(r5, r4, r1)     // Catch: java.lang.Exception -> L4a
            if (r5 != 0) goto L48
            goto L4d
        L48:
            r5 = r1
            goto L4e
        L4a:
            r5 = move-exception
            r1 = r2
            goto L54
        L4d:
            r5 = r3
        L4e:
            if (r2 == 0) goto L6c
            if (r5 == 0) goto L6c
            r1 = r3
            goto L6c
        L54:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "hasNotchInHuawei exception:"
            r2.append(r3)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            p399jk.AbstractC10896a.m65886e(r0, r5)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sk.C12806c.m76815f(android.content.Context):boolean");
    }

    /* renamed from: g */
    public static boolean m76816g(Context context) {
        boolean zBooleanValue = false;
        if (context == null) {
            AbstractC10896a.m65887i("NotchUtils", "hasNotchInScreen()---context = null ");
            return false;
        }
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class<?> clsLoadClass = C0209d.m1277l1() ? classLoader.loadClass("com.hihonor.android.util.HwNotchSizeUtil") : classLoader.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            zBooleanValue = ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e10) {
            AbstractC10896a.m65886e("NotchUtils", "ClassNotFoundException ! " + e10.getMessage());
        } catch (NoSuchMethodException e11) {
            AbstractC10896a.m65886e("NotchUtils", "NoSuchMethodException! " + e11.getMessage());
        } catch (Exception e12) {
            AbstractC10896a.m65886e("NotchUtils", "hasNotchInScreen fail! " + e12.getMessage());
        }
        AbstractC10896a.m65887i("NotchUtils", "hasNotchInScreen = " + zBooleanValue);
        return zBooleanValue;
    }

    /* renamed from: h */
    public static void m76817h(Context context, List<View> list) {
        if (context == null || list == null || C0219i.m1463a() < 17 || !m76815f(context)) {
            return;
        }
        m76821l(context, list);
        m76820k(context, list);
    }

    /* renamed from: i */
    public static boolean m76818i(Context context) {
        if (context == null) {
            return false;
        }
        int i10 = Settings.Global.getInt(context.getContentResolver(), Constants.NAVIGATIONBAR_IS_MIN, 0);
        AbstractC10896a.m65886e("NotchUtils", "onChange value1:" + i10);
        return i10 == 1;
    }

    /* renamed from: j */
    public static boolean m76819j(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i10 = activity.getWindow().getAttributes().flags;
        return (i10 & (-1025)) == i10;
    }

    /* renamed from: k */
    public static void m76820k(Context context, List<View> list) {
        if (list == null || context == null) {
            return;
        }
        for (KeyEvent.Callback callback : list) {
            if (callback != null && (callback instanceof InterfaceC12805b)) {
                InterfaceC12805b interfaceC12805b = (InterfaceC12805b) callback;
                int iM76811b = m76811b(context);
                if (iM76811b == 1) {
                    interfaceC12805b.onRotation90(null);
                } else if (iM76811b == 3) {
                    interfaceC12805b.onRotation270(null);
                } else if (2 == iM76811b) {
                    interfaceC12805b.onRotation180(null);
                } else {
                    interfaceC12805b.onRotationPortrait(null);
                }
            }
        }
    }

    /* renamed from: l */
    public static void m76821l(Context context, List<View> list) {
        if (list == null) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnApplyWindowInsetsListener(new CustomOnApplyWindowInsetsListener(context));
            }
        }
    }
}
