package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.huawei.openalliance.p169ad.constant.ErrorCode;

/* loaded from: classes3.dex */
public class FixedSpeedCustomScroller extends Scroller {
    private int mDuration;

    public FixedSpeedCustomScroller(Context context) {
        super(context);
        this.mDuration = ErrorCode.ERROR_NATIVE_AD_NO;
    }

    public int getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(int i10) {
        this.mDuration = i10;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        super.startScroll(i10, i11, i12, i13, this.mDuration);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13) {
        super.startScroll(i10, i11, i12, i13, this.mDuration);
    }

    public FixedSpeedCustomScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = ErrorCode.ERROR_NATIVE_AD_NO;
    }
}
