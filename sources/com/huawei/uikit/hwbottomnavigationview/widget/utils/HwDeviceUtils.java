package com.huawei.uikit.hwbottomnavigationview.widget.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Size;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class HwDeviceUtils {

    /* renamed from: a */
    private static final String f41547a = "HwDeviceUtils";

    /* renamed from: b */
    private static final int f41548b = 9;

    /* renamed from: c */
    private static final int f41549c = 8;

    /* renamed from: d */
    private static final float f41550d = 0.875f;

    /* renamed from: e */
    private static final String f41551e = "ro.config.hw_fold_disp";

    /* renamed from: f */
    private static final int f41552f = 100;

    /* renamed from: g */
    private static final int f41553g = 3;

    /* renamed from: a */
    private static boolean m54057a(Size size) {
        return size.getHeight() > 0 && Float.compare(((float) size.getWidth()) / ((float) size.getHeight()), f41550d) >= 0;
    }

    public static boolean isDualDisplayFoldDevice() {
        String[] strArrSplit = m54056a(f41551e, "").split(",");
        try {
            if (strArrSplit.length == 9) {
                return Integer.parseInt(strArrSplit[8]) == 1;
            }
            return false;
        } catch (NumberFormatException unused) {
            Log.e(f41547a, "NumberFormatException!");
            return false;
        }
    }

    public static boolean isFoldable() {
        return (m54056a(f41551e, "").isEmpty() && m54056a("persist.sys.fold.disp.size", "").isEmpty()) ? false : true;
    }

    public static boolean isTablet() {
        return m54056a("ro.build.characteristics", "") != null && m54056a("ro.build.characteristics", "").equalsIgnoreCase("tablet");
    }

    public static boolean isTripleFoldDevice() {
        String[] strArrSplit = m54056a(f41551e, "").split(",");
        try {
            if (strArrSplit.length == 9) {
                if (Integer.parseInt(strArrSplit[8]) / 100 == 3) {
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(f41547a, "number format Exception");
        }
        return false;
    }

    public static boolean isWideScreenPhone(Context context) {
        return m54057a(m54055a(context));
    }

    /* renamed from: a */
    private static Size m54055a(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        if (point.y < point.x) {
            return new Size(point.y, point.x);
        }
        return new Size(point.x, point.y);
    }

    /* renamed from: a */
    private static String m54056a(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            return objInvoke instanceof String ? (String) objInvoke : str2;
        } catch (ClassNotFoundException e10) {
            Log.w(f41547a, "getProperty() : Get property failed. classNotFoundException:" + e10.getMessage());
            return str2;
        } catch (IllegalAccessException e11) {
            Log.w(f41547a, "getProperty() : Get property failed. illegalAccessException:" + e11.getMessage());
            return str2;
        } catch (NoSuchMethodException e12) {
            Log.w(f41547a, "getProperty() : Get property failed. noSuchMethodException:" + e12.getMessage());
            return str2;
        } catch (InvocationTargetException e13) {
            Log.w(f41547a, "getProperty() : Get property failed. invocationTargetException:" + e13.getMessage());
            return str2;
        }
    }
}
