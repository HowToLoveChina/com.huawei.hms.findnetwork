package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.huawei.phoneservice.feedback.R$layout;

/* loaded from: classes5.dex */
public class PermissionTipView extends RelativeLayout {
    public PermissionTipView(Context context) {
        super(context);
        m53155a(context);
    }

    /* renamed from: a */
    public final void m53155a(Context context) {
        LayoutInflater.from(context).inflate(R$layout.feedback_sdk_widget_permission_tip, this);
    }

    public PermissionTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m53155a(context);
    }

    public PermissionTipView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m53155a(context);
    }
}
