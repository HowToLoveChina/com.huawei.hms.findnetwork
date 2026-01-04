package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import p246e3.C9397e;
import p246e3.C9401i;

/* loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: p */
    public static final int f8545p = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f8527a).f8548i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f8527a).f8547h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f8527a).f8546g;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public CircularProgressIndicatorSpec mo10882i(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    /* renamed from: s */
    public final void m10892s() {
        setIndeterminateDrawable(C9401i.m58928s(getContext(), (CircularProgressIndicatorSpec) this.f8527a));
        setProgressDrawable(C9397e.m58893u(getContext(), (CircularProgressIndicatorSpec) this.f8527a));
    }

    public void setIndicatorDirection(int i10) {
        ((CircularProgressIndicatorSpec) this.f8527a).f8548i = i10;
        invalidate();
    }

    public void setIndicatorInset(int i10) {
        S s10 = this.f8527a;
        if (((CircularProgressIndicatorSpec) s10).f8547h != i10) {
            ((CircularProgressIndicatorSpec) s10).f8547h = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        int iMax = Math.max(i10, getTrackThickness() * 2);
        S s10 = this.f8527a;
        if (((CircularProgressIndicatorSpec) s10).f8546g != iMax) {
            ((CircularProgressIndicatorSpec) s10).f8546g = iMax;
            ((CircularProgressIndicatorSpec) s10).mo10893e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((CircularProgressIndicatorSpec) this.f8527a).mo10893e();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f8545p);
        m10892s();
    }
}
