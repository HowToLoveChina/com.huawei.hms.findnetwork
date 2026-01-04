package com.huawei.uikit.hwadvancednumberpicker.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes7.dex */
public class HwUtils18V9 {

    /* renamed from: a */
    private static final String f41057a = "HwUtils18V9";

    /* renamed from: b */
    private static final int f41058b = 2;

    private HwUtils18V9() {
    }

    public static boolean isScreenEighteenNine(Context context) {
        if (context == null) {
            Log.e(f41057a, "isScreenEighteenVNine context is null");
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i10 / i11 >= 2 : i11 / i10 >= 2;
    }
}
