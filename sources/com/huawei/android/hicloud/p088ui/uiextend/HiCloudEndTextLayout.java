package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class HiCloudEndTextLayout extends RelativeLayout {
    private Context mContext;
    private boolean mSupportMinWidth;

    public HiCloudEndTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportMinWidth = true;
        this.mContext = context;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mSupportMinWidth) {
            if ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) {
                setMinimumWidth(C11842p.m70764S());
            } else {
                setMinimumWidth(C11842p.m70888z());
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setSupportMinWidth(boolean z10) {
        this.mSupportMinWidth = z10;
    }
}
