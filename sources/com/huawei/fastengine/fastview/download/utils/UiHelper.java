package com.huawei.fastengine.fastview.download.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes5.dex */
public final class UiHelper {
    public static final String TAG = "UiHelper";
    private static DisplayMetrics mDisplayMetrics;

    private UiHelper() {
    }

    public static int dp2px(Context context, int i10) {
        WindowManager windowManager;
        if (mDisplayMetrics == null) {
            mDisplayMetrics = new DisplayMetrics();
            if (context != null) {
                Object systemService = context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
                if (systemService instanceof WindowManager) {
                    windowManager = (WindowManager) systemService;
                } else {
                    FastViewLogUtils.m28724e(TAG, "get windowManager failed!");
                    windowManager = null;
                }
                if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                    windowManager.getDefaultDisplay().getMetrics(mDisplayMetrics);
                }
            }
        }
        return (int) (i10 * mDisplayMetrics.density);
    }
}
