package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Keep;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes4.dex */
public class FaqTahitiUtils {
    /* renamed from: a */
    public static DisplayMetrics m51880a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /* renamed from: b */
    public static boolean m51881b() throws Throwable {
        try {
            return HwFoldScreenManagerEx.isFoldable();
        } catch (Throwable unused) {
            FaqLogger.m51840e("FaqTahitiUtils", "get device foldAble error");
            return false;
        }
    }

    @Keep
    public static boolean isPadOrTahiti(Context context) {
        if (isTahiti(context)) {
            return true;
        }
        return FaqCommonUtils.isPad();
    }

    @Keep
    public static boolean isTahiti(Context context) throws Throwable {
        try {
            if (!m51881b()) {
                return false;
            }
            if (HwFoldScreenManagerEx.getDisplayMode() != 1) {
                return HwFoldScreenManagerEx.getDisplayMode() == 7;
            }
            return true;
        } catch (Throwable unused) {
            boolean z10 = context == null || context.getResources() == null || context.getResources().getConfiguration() == null;
            FaqLogger.m51840e("FaqTahitiUtils", "isPadOrTahitiDevice isNull:" + z10);
            if (z10) {
                return false;
            }
            float f10 = m51880a(context).widthPixels;
            float f11 = m51880a(context).heightPixels;
            return ((double) (Math.max(f10, f11) / Math.min(f10, f11))) < 1.33d && context.getResources().getConfiguration().smallestScreenWidthDp > 533;
        }
    }

    @Keep
    public static void setDefaultMargin(Activity activity, int[] iArr, int i10) {
        if (iArr == null || activity == null) {
            return;
        }
        int dimension = (int) activity.getResources().getDimension(i10);
        for (int i11 : iArr) {
            View viewFindViewById = activity.findViewById(i11);
            if (viewFindViewById != null) {
                setMargins(viewFindViewById, dimension, dimension);
            }
        }
    }

    @Keep
    public static void setMargins(View view, int i10, int i11) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.getMarginStart() != 0) {
                marginLayoutParams.setMarginStart(i10);
            }
            if (marginLayoutParams.getMarginEnd() != 0) {
                marginLayoutParams.setMarginEnd(i11);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Keep
    public static void setWidth(View view, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.width = i10;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
