package com.huawei.cloud.pay.p098ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import p454lj.C11296s;

/* loaded from: classes5.dex */
public class HiCloudEndTextLayout extends RelativeLayout {

    /* renamed from: a */
    public Context f21469a;

    public HiCloudEndTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21469a = context;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        setMinimumWidth(C11296s.m67841y(this.f21469a) / 3);
        super.onMeasure(i10, i11);
    }
}
