package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.complexutil.C2783d;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class OOBEMarginRelativeLayout extends RelativeLayout {
    private static final int DIMEN_16_DP = 16;
    private static final int DIMEN_20_DP = 20;
    private static final String TAG = "OOBENavButton";

    public OOBEMarginRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void initMarginSide(Context context) {
        if (context == null) {
            return;
        }
        C11842p.m70823i2(this, C11842p.m70844o(context, C2783d.m16107S() ? 16 : 20));
    }
}
