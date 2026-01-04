package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import p273f0.C9603h0;
import p273f0.C9620q;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a */
    public int f8219a;

    /* renamed from: b */
    public int f8220b;

    /* renamed from: c */
    public boolean f8221c;

    /* renamed from: d */
    public int f8222d;

    public FlowLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static int m10551a(int i10, int i11, int i12) {
        return i11 != Integer.MIN_VALUE ? i11 != 1073741824 ? i12 : i10 : Math.min(i12, i10);
    }

    /* renamed from: b */
    public int m10552b(View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    /* renamed from: c */
    public boolean mo10030c() {
        return this.f8221c;
    }

    /* renamed from: d */
    public final void m10553d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.f8219a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.f8220b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.f8220b;
    }

    public int getLineSpacing() {
        return this.f8219a;
    }

    public int getRowCount() {
        return this.f8222d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iM60123a;
        int iM60124b;
        if (getChildCount() == 0) {
            this.f8222d = 0;
            return;
        }
        this.f8222d = 1;
        boolean z11 = C9603h0.m59832A(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = (i12 - i10) - paddingLeft;
        int measuredWidth = paddingRight;
        int i15 = paddingTop;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iM60124b = C9620q.m60124b(marginLayoutParams);
                    iM60123a = C9620q.m60123a(marginLayoutParams);
                } else {
                    iM60123a = 0;
                    iM60124b = 0;
                }
                int measuredWidth2 = measuredWidth + iM60124b + childAt.getMeasuredWidth();
                if (!this.f8221c && measuredWidth2 > i14) {
                    i15 = this.f8219a + paddingTop;
                    this.f8222d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f8222d - 1));
                int i17 = measuredWidth + iM60124b;
                int measuredWidth3 = childAt.getMeasuredWidth() + i17;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z11) {
                    childAt.layout(i14 - measuredWidth3, i15, (i14 - measuredWidth) - iM60124b, measuredHeight);
                } else {
                    childAt.layout(i17, i15, measuredWidth3, measuredHeight);
                }
                measuredWidth += iM60124b + iM60123a + childAt.getMeasuredWidth() + this.f8220b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i12 = marginLayoutParams.leftMargin;
                    i13 = marginLayoutParams.rightMargin;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = paddingLeft2;
                if (paddingLeft2 + i12 + childAt.getMeasuredWidth() <= paddingRight || mo10030c()) {
                    paddingLeft = i18;
                } else {
                    paddingLeft = getPaddingLeft();
                    i15 = this.f8219a + paddingTop;
                }
                int measuredWidth = paddingLeft + i12 + childAt.getMeasuredWidth();
                int measuredHeight = i15 + childAt.getMeasuredHeight();
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i12 + i13 + childAt.getMeasuredWidth() + this.f8220b;
                if (i17 == getChildCount() - 1) {
                    i16 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(m10551a(size, mode, i16 + getPaddingRight()), m10551a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i10) {
        this.f8220b = i10;
    }

    public void setLineSpacing(int i10) {
        this.f8219a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f8221c = z10;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8221c = false;
        m10553d(context, attributeSet);
    }
}
