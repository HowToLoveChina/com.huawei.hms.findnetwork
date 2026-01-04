package com.huawei.uikit.hwresources.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;

/* loaded from: classes4.dex */
public class AuxiliaryHelper {

    /* renamed from: a */
    private static final float f43989a = 8.0f;

    public static float getFontSize(Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    public static boolean isAuxiliaryDevice(Context context) {
        return HwWidgetInstantiator.getCurrentType(context) == 1;
    }

    public static boolean isMultiWindowActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return ((Activity) context).isInMultiWindowMode();
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return false;
    }

    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static boolean pointInView(Rect rect, float f10, float f11) {
        return rect != null && Float.compare(f10, -8.0f) >= 0 && Float.compare(f11, -8.0f) >= 0 && Float.compare(f10, ((float) (rect.right - rect.left)) + 8.0f) == -1 && Float.compare(f11, ((float) (rect.bottom - rect.top)) + 8.0f) == -1;
    }
}
