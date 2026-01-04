package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: p */
    public Drawable f8223p;

    /* renamed from: q */
    public final Rect f8224q;

    /* renamed from: r */
    public final Rect f8225r;

    /* renamed from: s */
    public int f8226s;

    /* renamed from: t */
    public boolean f8227t;

    /* renamed from: u */
    public boolean f8228u;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f8223p;
        if (drawable != null) {
            if (this.f8228u) {
                this.f8228u = false;
                Rect rect = this.f8224q;
                Rect rect2 = this.f8225r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f8227t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f8226s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f8223p;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8223p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f8223p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f8223p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f8226s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8223p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f8228u = z10 | this.f8228u;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f8228u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f8223p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f8223p);
            }
            this.f8223p = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f8226s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f8226s != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f8226s = i10;
            if (i10 == 119 && this.f8223p != null) {
                this.f8223p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8223p;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8224q = new Rect();
        this.f8225r = new Rect();
        this.f8226s = 119;
        this.f8227t = true;
        this.f8228u = false;
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.ForegroundLinearLayout, i10, 0, new int[0]);
        this.f8226s = typedArrayM10770h.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.f8226s);
        Drawable drawable = typedArrayM10770h.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f8227t = typedArrayM10770h.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayM10770h.recycle();
    }
}
