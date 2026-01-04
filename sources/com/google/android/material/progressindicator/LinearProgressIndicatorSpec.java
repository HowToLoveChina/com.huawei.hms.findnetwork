package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p246e3.AbstractC9394b;

/* loaded from: classes.dex */
public final class LinearProgressIndicatorSpec extends AbstractC9394b {

    /* renamed from: g */
    public int f8550g;

    /* renamed from: h */
    public int f8551h;

    /* renamed from: i */
    public boolean f8552i;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    @Override // p246e3.AbstractC9394b
    /* renamed from: e */
    public void mo10893e() {
        if (this.f8550g == 0) {
            if (this.f46919b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f46920c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, LinearProgressIndicator.f8549p);
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.LinearProgressIndicator, R$attr.linearProgressIndicatorStyle, LinearProgressIndicator.f8549p, new int[0]);
        this.f8550g = typedArrayM10770h.getInt(R$styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f8551h = typedArrayM10770h.getInt(R$styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        typedArrayM10770h.recycle();
        mo10893e();
        this.f8552i = this.f8551h == 1;
    }
}
