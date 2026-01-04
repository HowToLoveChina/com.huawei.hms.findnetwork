package com.huawei.fastengine.fastview.download.utils;

import android.app.Activity;
import android.content.Context;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public abstract class ActivityUtil {
    private static final int ANDROID_4_2 = 17;
    private static final String TAG = "ActivityUtil";

    public static boolean isActivityDestroyed(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        FastViewLogUtils.m28728w(TAG, "activity has bean finished, cannot instance:");
        return true;
    }
}
