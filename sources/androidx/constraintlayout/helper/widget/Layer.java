package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import p561q.C12258e;

/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {

    /* renamed from: A */
    public boolean f2529A;

    /* renamed from: j */
    public float f2530j;

    /* renamed from: k */
    public float f2531k;

    /* renamed from: l */
    public float f2532l;

    /* renamed from: m */
    public ConstraintLayout f2533m;

    /* renamed from: n */
    public float f2534n;

    /* renamed from: o */
    public float f2535o;

    /* renamed from: p */
    public float f2536p;

    /* renamed from: q */
    public float f2537q;

    /* renamed from: r */
    public float f2538r;

    /* renamed from: s */
    public float f2539s;

    /* renamed from: t */
    public float f2540t;

    /* renamed from: u */
    public float f2541u;

    /* renamed from: v */
    public boolean f2542v;

    /* renamed from: w */
    public View[] f2543w;

    /* renamed from: x */
    public float f2544x;

    /* renamed from: y */
    public float f2545y;

    /* renamed from: z */
    public boolean f2546z;

    public Layer(Context context) {
        super(context);
        this.f2530j = Float.NaN;
        this.f2531k = Float.NaN;
        this.f2532l = Float.NaN;
        this.f2534n = 1.0f;
        this.f2535o = 1.0f;
        this.f2536p = Float.NaN;
        this.f2537q = Float.NaN;
        this.f2538r = Float.NaN;
        this.f2539s = Float.NaN;
        this.f2540t = Float.NaN;
        this.f2541u = Float.NaN;
        this.f2542v = true;
        this.f2543w = null;
        this.f2544x = 0.0f;
        this.f2545y = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: j */
    public void mo3256j(ConstraintLayout constraintLayout) {
        m3560i(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        this.f2945e = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f2546z = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f2529A = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        this.f2533m = (ConstraintLayout) getParent();
        if (this.f2546z || this.f2529A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i10 = 0; i10 < this.f2942b; i10++) {
                View viewById = this.f2533m.getViewById(this.f2941a[i10]);
                if (viewById != null) {
                    if (this.f2546z) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f2529A && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: r */
    public void mo3257r(ConstraintLayout constraintLayout) {
        m3260y();
        this.f2536p = Float.NaN;
        this.f2537q = Float.NaN;
        C12258e c12258eM3569b = ((ConstraintLayout.LayoutParams) getLayoutParams()).m3569b();
        c12258eM3569b.m73638p1(0);
        c12258eM3569b.m73579Q0(0);
        m3259x();
        layout(((int) this.f2540t) - getPaddingLeft(), ((int) this.f2541u) - getPaddingTop(), ((int) this.f2538r) + getPaddingRight(), ((int) this.f2539s) + getPaddingBottom());
        m3261z();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        m3559h();
    }

    @Override // android.view.View
    public void setPivotX(float f10) {
        this.f2530j = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setPivotY(float f10) {
        this.f2531k = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        this.f2532l = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        this.f2534n = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        this.f2535o = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        this.f2544x = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        this.f2545y = f10;
        m3261z();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        m3559h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: t */
    public void mo3258t(ConstraintLayout constraintLayout) {
        this.f2533m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f2532l = rotation;
        } else {
            if (Float.isNaN(this.f2532l)) {
                return;
            }
            this.f2532l = rotation;
        }
    }

    /* renamed from: x */
    public void m3259x() {
        if (this.f2533m == null) {
            return;
        }
        if (this.f2542v || Float.isNaN(this.f2536p) || Float.isNaN(this.f2537q)) {
            if (!Float.isNaN(this.f2530j) && !Float.isNaN(this.f2531k)) {
                this.f2537q = this.f2531k;
                this.f2536p = this.f2530j;
                return;
            }
            View[] viewArrM3564n = m3564n(this.f2533m);
            int left = viewArrM3564n[0].getLeft();
            int top = viewArrM3564n[0].getTop();
            int right = viewArrM3564n[0].getRight();
            int bottom = viewArrM3564n[0].getBottom();
            for (int i10 = 0; i10 < this.f2942b; i10++) {
                View view = viewArrM3564n[i10];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f2538r = right;
            this.f2539s = bottom;
            this.f2540t = left;
            this.f2541u = top;
            if (Float.isNaN(this.f2530j)) {
                this.f2536p = (left + right) / 2;
            } else {
                this.f2536p = this.f2530j;
            }
            if (Float.isNaN(this.f2531k)) {
                this.f2537q = (top + bottom) / 2;
            } else {
                this.f2537q = this.f2531k;
            }
        }
    }

    /* renamed from: y */
    public final void m3260y() {
        int i10;
        if (this.f2533m == null || (i10 = this.f2942b) == 0) {
            return;
        }
        View[] viewArr = this.f2543w;
        if (viewArr == null || viewArr.length != i10) {
            this.f2543w = new View[i10];
        }
        for (int i11 = 0; i11 < this.f2942b; i11++) {
            this.f2543w[i11] = this.f2533m.getViewById(this.f2941a[i11]);
        }
    }

    /* renamed from: z */
    public final void m3261z() {
        if (this.f2533m == null) {
            return;
        }
        if (this.f2543w == null) {
            m3260y();
        }
        m3259x();
        double radians = Float.isNaN(this.f2532l) ? 0.0d : Math.toRadians(this.f2532l);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f10 = this.f2534n;
        float f11 = f10 * fCos;
        float f12 = this.f2535o;
        float f13 = (-f12) * fSin;
        float f14 = f10 * fSin;
        float f15 = f12 * fCos;
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            View view = this.f2543w[i10];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f16 = left - this.f2536p;
            float f17 = top - this.f2537q;
            float f18 = (((f11 * f16) + (f13 * f17)) - f16) + this.f2544x;
            float f19 = (((f16 * f14) + (f15 * f17)) - f17) + this.f2545y;
            view.setTranslationX(f18);
            view.setTranslationY(f19);
            view.setScaleY(this.f2535o);
            view.setScaleX(this.f2534n);
            if (!Float.isNaN(this.f2532l)) {
                view.setRotation(this.f2532l);
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2530j = Float.NaN;
        this.f2531k = Float.NaN;
        this.f2532l = Float.NaN;
        this.f2534n = 1.0f;
        this.f2535o = 1.0f;
        this.f2536p = Float.NaN;
        this.f2537q = Float.NaN;
        this.f2538r = Float.NaN;
        this.f2539s = Float.NaN;
        this.f2540t = Float.NaN;
        this.f2541u = Float.NaN;
        this.f2542v = true;
        this.f2543w = null;
        this.f2544x = 0.0f;
        this.f2545y = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2530j = Float.NaN;
        this.f2531k = Float.NaN;
        this.f2532l = Float.NaN;
        this.f2534n = 1.0f;
        this.f2535o = 1.0f;
        this.f2536p = Float.NaN;
        this.f2537q = Float.NaN;
        this.f2538r = Float.NaN;
        this.f2539s = Float.NaN;
        this.f2540t = Float.NaN;
        this.f2541u = Float.NaN;
        this.f2542v = true;
        this.f2543w = null;
        this.f2544x = 0.0f;
        this.f2545y = 0.0f;
    }
}
