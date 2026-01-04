package com.huawei.fastengine.fastview.util;

import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public class FastViewUtils {
    private static final String TAG = "FastViewUtils";

    public static int parseInt(Object obj, int i10) {
        if (obj == null) {
            return i10;
        }
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (NumberFormatException unused) {
            FastViewLogUtils.m28724e(TAG, "parseInt exception:" + obj);
            return i10;
        }
    }
}
