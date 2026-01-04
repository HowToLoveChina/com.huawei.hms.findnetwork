package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p273f0.C9603h0;
import p276f3.C9649c;
import p356i3.C10427h;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: f */
    public static final int f8050f = R$style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: a */
    public final C10427h f8051a;

    /* renamed from: b */
    public int f8052b;

    /* renamed from: c */
    public int f8053c;

    /* renamed from: d */
    public int f8054d;

    /* renamed from: e */
    public int f8055e;

    public MaterialDivider(Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.f8053c;
    }

    public int getDividerInsetEnd() {
        return this.f8055e;
    }

    public int getDividerInsetStart() {
        return this.f8054d;
    }

    public int getDividerThickness() {
        return this.f8052b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int i10;
        super.onDraw(canvas);
        boolean z10 = C9603h0.m59832A(this) == 1;
        int i11 = z10 ? this.f8055e : this.f8054d;
        if (z10) {
            width = getWidth();
            i10 = this.f8054d;
        } else {
            width = getWidth();
            i10 = this.f8055e;
        }
        this.f8051a.setBounds(i11, 0, width - i10, getBottom() - getTop());
        this.f8051a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f8052b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f8053c != i10) {
            this.f8053c = i10;
            this.f8051a.m64002b0(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f8055e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f8054d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f8052b != i10) {
            this.f8052b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8050f;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        this.f8051a = new C10427h();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.MaterialDivider, i10, i11, new int[0]);
        this.f8052b = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R$dimen.material_divider_thickness));
        this.f8054d = typedArrayM10770h.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetStart, 0);
        this.f8055e = typedArrayM10770h.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(C9649c.m60265a(context2, typedArrayM10770h, R$styleable.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayM10770h.recycle();
    }
}
