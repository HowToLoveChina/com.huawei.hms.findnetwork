package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;

/* loaded from: classes3.dex */
public class NotchFitOOBENavLinearLayout extends NotchFitLinearLayout {
    public NotchFitOOBENavLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout, sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }
}
