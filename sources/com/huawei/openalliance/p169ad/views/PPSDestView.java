package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSDestView extends FrameLayout implements InterfaceC7403lm {
    @OuterVisible
    public PPSDestView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    @OuterVisible
    public PPSDestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @OuterVisible
    public PPSDestView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @OuterVisible
    public PPSDestView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
