package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import p246e3.C9397e;
import p246e3.C9401i;
import p246e3.C9403k;
import p246e3.C9404l;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: p */
    public static final int f8549p = R$style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    /* renamed from: s */
    private void m10894s() {
        setIndeterminateDrawable(C9401i.m58929t(getContext(), (LinearProgressIndicatorSpec) this.f8527a));
        setProgressDrawable(C9397e.m58894v(getContext(), (LinearProgressIndicatorSpec) this.f8527a));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f8527a).f8550g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f8527a).f8551h;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: o */
    public void mo10888o(int i10, boolean z10) {
        S s10 = this.f8527a;
        if (s10 != 0 && ((LinearProgressIndicatorSpec) s10).f8550g == 0 && isIndeterminate()) {
            return;
        }
        super.mo10888o(i10, z10);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        S s10 = this.f8527a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s10;
        boolean z11 = true;
        if (((LinearProgressIndicatorSpec) s10).f8551h != 1 && ((C9603h0.m59832A(this) != 1 || ((LinearProgressIndicatorSpec) this.f8527a).f8551h != 2) && (C9603h0.m59832A(this) != 0 || ((LinearProgressIndicatorSpec) this.f8527a).f8551h != 3))) {
            z11 = false;
        }
        linearProgressIndicatorSpec.f8552i = z11;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = i10 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i11 - (getPaddingTop() + getPaddingBottom());
        C9401i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        C9397e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public LinearProgressIndicatorSpec mo10882i(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i10) {
        if (((LinearProgressIndicatorSpec) this.f8527a).f8550g == i10) {
            return;
        }
        if (m10890q() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s10 = this.f8527a;
        ((LinearProgressIndicatorSpec) s10).f8550g = i10;
        ((LinearProgressIndicatorSpec) s10).mo10893e();
        if (i10 == 0) {
            getIndeterminateDrawable().m58932w(new C9403k((LinearProgressIndicatorSpec) this.f8527a));
        } else {
            getIndeterminateDrawable().m58932w(new C9404l(getContext(), (LinearProgressIndicatorSpec) this.f8527a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f8527a).mo10893e();
    }

    public void setIndicatorDirection(int i10) {
        S s10 = this.f8527a;
        ((LinearProgressIndicatorSpec) s10).f8551h = i10;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s10;
        boolean z10 = true;
        if (i10 != 1 && ((C9603h0.m59832A(this) != 1 || ((LinearProgressIndicatorSpec) this.f8527a).f8551h != 2) && (C9603h0.m59832A(this) != 0 || i10 != 3))) {
            z10 = false;
        }
        linearProgressIndicatorSpec.f8552i = z10;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i10) {
        super.setTrackCornerRadius(i10);
        ((LinearProgressIndicatorSpec) this.f8527a).mo10893e();
        invalidate();
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f8549p);
        m10894s();
    }
}
