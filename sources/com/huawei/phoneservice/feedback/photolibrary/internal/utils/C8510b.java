package com.huawei.phoneservice.feedback.photolibrary.internal.utils;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import p692uw.C13267j;

/* renamed from: com.huawei.phoneservice.feedback.photolibrary.internal.utils.b */
/* loaded from: classes5.dex */
public final class C8510b {

    /* renamed from: a */
    public static final C8510b f39691a = new C8510b();

    /* renamed from: a */
    public static final void m52864a(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        HwColumnSystem hwColumnSystem = new HwColumnSystem(context);
        hwColumnSystem.setColumnType(1);
        FaqUiUtils.setViewLayoutParams(view, hwColumnSystem.getMinColumnWidth());
    }

    /* renamed from: b */
    public static final boolean m52865b(EditText editText) {
        int height;
        C13267j.m79677e(editText, "editText");
        int scrollY = editText.getScrollY();
        Layout layout = editText.getLayout();
        if (layout == null || (height = layout.getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom())) == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }
}
