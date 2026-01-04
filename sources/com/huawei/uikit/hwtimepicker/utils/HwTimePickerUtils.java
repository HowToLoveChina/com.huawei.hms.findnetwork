package com.huawei.uikit.hwtimepicker.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes5.dex */
public class HwTimePickerUtils {
    public static final int DIALOG_MARGIN = 24;

    private HwTimePickerUtils() {
    }

    public static boolean isMultiWindowActivity(Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity.isInMultiWindowMode();
    }

    public static void updateSpinnerAreaRect(Rect rect, View view, int i10) {
        if (rect == null || view == null) {
            return;
        }
        rect.set(view.getLeft() + i10, view.getTop(), view.getRight() + i10, view.getBottom());
    }
}
