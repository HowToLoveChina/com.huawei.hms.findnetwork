package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1785p;
import p273f0.C9603h0;
import p356i3.C10427h;
import p356i3.C10428i;
import p416k3.C10981a;
import p757x.C13669a;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: b0 */
    public static final int f7438b0 = R$style.Widget_MaterialComponents_Toolbar;

    /* renamed from: c0 */
    public static final ImageView.ScaleType[] f7439c0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: T */
    public Integer f7440T;

    /* renamed from: U */
    public boolean f7441U;

    /* renamed from: V */
    public boolean f7442V;

    /* renamed from: W */
    public ImageView.ScaleType f7443W;

    /* renamed from: a0 */
    public Boolean f7444a0;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    /* renamed from: X */
    private Drawable m9594X(Drawable drawable) {
        if (drawable == null || this.f7440T == null) {
            return drawable;
        }
        Drawable drawableM82231l = C13669a.m82231l(drawable.mutate());
        C13669a.m82227h(drawableM82231l, this.f7440T.intValue());
        return drawableM82231l;
    }

    /* renamed from: T */
    public final Pair<Integer, Integer> m9595T(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    /* renamed from: U */
    public final void m9596U(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            C10427h c10427h = new C10427h();
            c10427h.m64002b0(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            c10427h.m63992Q(context);
            c10427h.m64001a0(C9603h0.m59913v(this));
            C9603h0.m59910t0(this, c10427h);
        }
    }

    /* renamed from: V */
    public final void m9597V(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i10 += iMax;
            i11 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i10, view.getTop(), i11, view.getBottom());
    }

    /* renamed from: W */
    public final void m9598W() {
        if (this.f7441U || this.f7442V) {
            TextView textViewM10776e = C1785p.m10776e(this);
            TextView textViewM10774c = C1785p.m10774c(this);
            if (textViewM10776e == null && textViewM10774c == null) {
                return;
            }
            Pair<Integer, Integer> pairM9595T = m9595T(textViewM10776e, textViewM10774c);
            if (this.f7441U && textViewM10776e != null) {
                m9597V(textViewM10776e, pairM9595T);
            }
            if (!this.f7442V || textViewM10774c == null) {
                return;
            }
            m9597V(textViewM10774c, pairM9595T);
        }
    }

    /* renamed from: Y */
    public final void m9599Y() {
        ImageView imageViewM10773b = C1785p.m10773b(this);
        if (imageViewM10773b != null) {
            Boolean bool = this.f7444a0;
            if (bool != null) {
                imageViewM10773b.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f7443W;
            if (scaleType != null) {
                imageViewM10773b.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f7443W;
    }

    public Integer getNavigationIconTint() {
        return this.f7440T;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64043e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m9598W();
        m9599Y();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        C10428i.m64042d(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f7444a0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f7444a0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f7443W != scaleType) {
            this.f7443W = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(m9594X(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f7440T = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f7442V != z10) {
            this.f7442V = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f7441U != z10) {
            this.f7441U = z10;
            requestLayout();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7438b0;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.MaterialToolbar, i10, i11, new int[0]);
        int i12 = R$styleable.MaterialToolbar_navigationIconTint;
        if (typedArrayM10770h.hasValue(i12)) {
            setNavigationIconTint(typedArrayM10770h.getColor(i12, -1));
        }
        this.f7441U = typedArrayM10770h.getBoolean(R$styleable.MaterialToolbar_titleCentered, false);
        this.f7442V = typedArrayM10770h.getBoolean(R$styleable.MaterialToolbar_subtitleCentered, false);
        int i13 = typedArrayM10770h.getInt(R$styleable.MaterialToolbar_logoScaleType, -1);
        if (i13 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f7439c0;
            if (i13 < scaleTypeArr.length) {
                this.f7443W = scaleTypeArr[i13];
            }
        }
        int i14 = R$styleable.MaterialToolbar_logoAdjustViewBounds;
        if (typedArrayM10770h.hasValue(i14)) {
            this.f7444a0 = Boolean.valueOf(typedArrayM10770h.getBoolean(i14, false));
        }
        typedArrayM10770h.recycle();
        m9596U(context2);
    }
}
