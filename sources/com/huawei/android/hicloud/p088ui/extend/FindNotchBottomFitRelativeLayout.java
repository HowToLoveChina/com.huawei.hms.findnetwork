package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;

/* loaded from: classes3.dex */
public class FindNotchBottomFitRelativeLayout extends NotchBottomFitRelativeLayout {
    public FindNotchBottomFitRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.NotchBottomFitRelativeLayout, sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }
}
