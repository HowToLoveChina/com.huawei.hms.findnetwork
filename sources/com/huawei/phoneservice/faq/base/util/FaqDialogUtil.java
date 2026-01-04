package com.huawei.phoneservice.faq.base.util;

import android.app.Dialog;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.Keep;

/* loaded from: classes4.dex */
public class FaqDialogUtil {
    /* renamed from: a */
    public static void m51827a(Dialog dialog) {
        if (dialog == null || dialog.getWindow() == null || FaqCommonUtils.isPad()) {
            return;
        }
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        WindowManager windowManager = dialog.getWindow().getWindowManager();
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        attributes.width = Math.min(point.x, point.y);
        dialog.getWindow().setAttributes(attributes);
    }

    @Keep
    public static void showDialog(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }

    @Keep
    public static void showDialog1(Dialog dialog) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
        m51827a(dialog);
    }
}
