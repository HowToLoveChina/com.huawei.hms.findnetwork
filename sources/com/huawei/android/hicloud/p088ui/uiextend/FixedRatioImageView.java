package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class FixedRatioImageView extends HiCloudRoundRectImageView {
    private static final float PICTURE_RATIO = 0.35714287f;
    private Context mContext;

    public FixedRatioImageView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.round((View.MeasureSpec.getSize(i10) - (this.mContext != null ? ((int) C11842p.m70844o(r3, 12)) * 2 : 0)) * PICTURE_RATIO), 1073741824);
        setMeasuredDimension(i10, iMakeMeasureSpec);
        super.onMeasure(i10, iMakeMeasureSpec);
    }

    public FixedRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mContext = context;
    }
}
