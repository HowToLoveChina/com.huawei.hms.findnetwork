package com.huawei.uikit.phone.hwhorizontalscrollview.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwGenericEventDetector;

/* loaded from: classes9.dex */
public class HwHorizontalScrollView extends com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView {
    public HwHorizontalScrollView(Context context) {
        this(context, null);
    }

    public HwHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView
    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    public HwHorizontalScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
