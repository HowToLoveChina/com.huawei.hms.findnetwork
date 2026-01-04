package com.huawei.uikit.hwdatepicker.utils;

import android.app.Activity;
import android.util.Log;

/* loaded from: classes7.dex */
public class HwDatePickerUtils {
    public static final int MAX_YEAR = 5000;
    public static final int MIN_YEAR = 1;

    /* renamed from: a */
    private static final int f42147a = 5;

    /* renamed from: b */
    private static final String f42148b = "DatePickerUtils";
    public static final int[] DAYS_OF_MONTH_WESTERN = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final String[] WEEK_DAYS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    private HwDatePickerUtils() {
    }

    public static String[] getDisplayStrings(int i10, String[] strArr, String[] strArr2, String[] strArr3) {
        int i11 = 0;
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        if (strArr2 == null) {
            return new String[0];
        }
        if (strArr3 == null) {
            return new String[0];
        }
        String[] strArr4 = (String[]) strArr.clone();
        if (i10 < 5) {
            int length = strArr2.length;
            while (true) {
                length--;
                if (length <= strArr2.length - 5) {
                    break;
                }
                strArr4[(strArr.length - 1) - i11] = strArr2[length];
                i11++;
            }
        } else if (i10 <= strArr.length - 5) {
            Log.e(f42148b, "error index");
        } else if (strArr3.length >= 5 && strArr4.length >= 5) {
            System.arraycopy(strArr3, 0, strArr4, 0, 5);
        }
        return strArr4;
    }

    public static boolean isMultiWindowActivity(Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity.isInMultiWindowMode();
    }
}
