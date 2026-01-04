package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class TitleEndLayout extends RelativeLayout {
    private Context mContext;

    public TitleEndLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) {
            setMinimumWidth(C11842p.m70779X());
        } else {
            setMinimumWidth(C11842p.m70801d0());
        }
        super.onMeasure(i10, i11);
    }
}
