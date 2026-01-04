package com.huawei.uikit.hwadvancednumberpicker.utils;

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
    private static final String f41045a = "HwDeviceUtils";

    /* renamed from: b */
    private static final float f41046b = 0.875f;

    /* renamed from: c */
    private static final String f41047c = "ro.config.hw_fold_disp";

    /* renamed from: d */
    private static final int f41048d = 9;

    /* renamed from: e */
    private static final int f41049e = 8;

    /* renamed from: f */
    private static final int f41050f = 3;

    /* renamed from: g */
    private static final int f41051g = 100;

    /* renamed from: a */
    private static boolean m53786a(Size size) {
        return size != null && Float.compare(((float) size.getWidth()) / ((float) size.getHeight()), f41046b) >= 0;
    }

    public static boolean isTablet() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String strM53785a = m53785a("ro.build.characteristics", "default");
        return strM53785a != null && strM53785a.equalsIgnoreCase("tablet");
    }

    public static boolean isTripleFoldDevice() {
        String[] strArrSplit = m53785a(f41047c, "").split(",");
        try {
            if (strArrSplit.length == 9) {
                if (Integer.parseInt(strArrSplit[8]) / 100 == 3) {
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(f41045a, "number format Exception");
        }
        return false;
    }

    public static boolean isWideScreenPhone(Context context) {
        return m53786a(m53784a(context));
    }

    /* renamed from: a */
    private static Size m53784a(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        if (point.y < point.x) {
            return new Size(point.y, point.x);
        }
        return new Size(point.x, point.y);
    }

    /* renamed from: a */
    private static String m53785a(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            return objInvoke instanceof String ? (String) objInvoke : str2;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            Log.w(f41045a, "getProperty() : Get property failed.");
            return str2;
        }
    }
}
