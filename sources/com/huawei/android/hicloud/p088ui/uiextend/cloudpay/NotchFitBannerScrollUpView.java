package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import p514o9.C11842p;
import sk.C12806c;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class NotchFitBannerScrollUpView extends BannerScrollUpView implements InterfaceC12805b {
    private Context mContext;

    public NotchFitBannerScrollUpView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContext = context;
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.mContext;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.mContext), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.mContext;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }

    public NotchFitBannerScrollUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public NotchFitBannerScrollUpView(Context context) {
        super(context);
        this.mContext = context;
    }
}
