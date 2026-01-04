package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class NotchFitRelativeLayout extends RelativeLayout implements InterfaceC12805b {
    private Context mContext;

    public NotchFitRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.mContext;
        int iM70789a0 = (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.mContext);
        if (C11829c.m70556Y0(this.mContext)) {
            setPadding(0, 0, iM70789a0, 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.mContext;
        int iM70789a0 = context != null ? C11842p.m70789a0(context) : 0;
        if (C11829c.m70556Y0(this.mContext)) {
            setPadding(iM70789a0, 0, 0, 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }
}
