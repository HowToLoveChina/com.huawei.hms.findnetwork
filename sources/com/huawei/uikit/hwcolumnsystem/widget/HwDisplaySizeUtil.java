package com.huawei.uikit.hwcolumnsystem.widget;

import android.graphics.Rect;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class HwDisplaySizeUtil {

    /* renamed from: a */
    private static final String f41818a = "HwDisplaySizeUtil";

    /* renamed from: b */
    private static final String f41819b = "com.huawei.android.view.ExtDisplaySizeUtilEx";

    /* renamed from: c */
    private static final String f41820c = "getDisplaySafeInsets";

    /* renamed from: d */
    private static final String f41821d = "com.huawei.android.app.WindowManagerEx";

    /* renamed from: e */
    private static final String f41822e = "getDisplaySideSafeInsets";

    private HwDisplaySizeUtil() {
    }

    /* renamed from: a */
    private static Rect m54146a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        try {
            objInvoke = Class.forName(f41821d).getMethod(f41822e, new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException unused) {
            Log.e(f41818a, "getDisplaySideSafeInsets: class not found");
        } catch (IllegalAccessException unused2) {
            Log.e(f41818a, "getDisplaySideSafeInsets: illegal access exception");
        } catch (NoSuchMethodException unused3) {
            Log.e(f41818a, "getDisplaySideSafeInsets: method not found");
        } catch (InvocationTargetException unused4) {
            Log.e(f41818a, "getDisplaySideSafeInsets: invocation target exception");
        }
        if (objInvoke instanceof Rect) {
            return (Rect) objInvoke;
        }
        Log.e(f41818a, "getDisplaySideSafeInsets: object is not Rect");
        return null;
    }

    /* renamed from: b */
    private static Rect m54147b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        try {
            objInvoke = Class.forName(f41819b).getMethod(f41820c, new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException unused) {
            Log.e(f41818a, "getDisplaySafeInsets: class not found");
        } catch (IllegalAccessException unused2) {
            Log.e(f41818a, "getDisplaySafeInsets: illegal access exception");
        } catch (NoSuchMethodException unused3) {
            Log.e(f41818a, "getDisplaySafeInsets: method not found");
        } catch (InvocationTargetException unused4) {
            Log.e(f41818a, "getDisplaySafeInsets: invocation target exception");
        }
        if (objInvoke instanceof Rect) {
            return (Rect) objInvoke;
        }
        Log.e(f41818a, "getDisplaySafeInsets: object is not Rect");
        return new Rect();
    }

    public static Rect getDisplaySafeInsets() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Rect rectM54146a = m54146a();
        return rectM54146a == null ? m54147b() : rectM54146a;
    }
}
