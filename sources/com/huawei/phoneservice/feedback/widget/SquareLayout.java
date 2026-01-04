package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes5.dex */
public final class SquareLayout extends RelativeLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SquareLayout(Context context) {
        this(context, null, 0, 6, null);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SquareLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
    }

    public /* synthetic */ SquareLayout(Context context, AttributeSet attributeSet, int i10, int i11, C13264g c13264g) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
