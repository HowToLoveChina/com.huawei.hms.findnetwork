package com.huawei.phoneservice.faq.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.huawei.phoneservice.faq.base.R$color;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;

/* renamed from: com.huawei.phoneservice.faq.utils.g */
/* loaded from: classes4.dex */
public class C8417g {
    /* renamed from: a */
    public static int m52395a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static void m52396b(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        HwColumnSystem hwColumnSystem = new HwColumnSystem(context);
        hwColumnSystem.setColumnType(1);
        FaqUiUtils.setViewLayoutParams(view, hwColumnSystem.getMinColumnWidth());
    }

    /* renamed from: c */
    public static boolean m52397c(Context context) {
        return context != null && Color.parseColor("#000000") == context.getResources().getColor(R$color.faq_sdk_online_them);
    }

    /* renamed from: d */
    public static int m52398d(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
