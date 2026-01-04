package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class MaxWidthTextView extends TextView {
    private Context mContext;

    public MaxWidthTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        if ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) {
            setMaxWidth(C11842p.m70785Z());
        } else {
            setMaxWidth(C11842p.m70813g0());
        }
    }
}
