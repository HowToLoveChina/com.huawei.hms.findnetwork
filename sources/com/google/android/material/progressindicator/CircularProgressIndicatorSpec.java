package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p246e3.AbstractC9394b;
import p276f3.C9649c;

/* loaded from: classes.dex */
public final class CircularProgressIndicatorSpec extends AbstractC9394b {

    /* renamed from: g */
    public int f8546g;

    /* renamed from: h */
    public int f8547h;

    /* renamed from: i */
    public int f8548i;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    @Override // p246e3.AbstractC9394b
    /* renamed from: e */
    public void mo10893e() {
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, CircularProgressIndicator.f8545p);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.CircularProgressIndicator, i10, i11, new int[0]);
        this.f8546g = Math.max(C9649c.m60268d(context, typedArrayM10770h, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f46918a * 2);
        this.f8547h = C9649c.m60268d(context, typedArrayM10770h, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f8548i = typedArrayM10770h.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayM10770h.recycle();
        mo10893e();
    }
}
