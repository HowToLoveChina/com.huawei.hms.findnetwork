package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a */
    public C0585c f3035a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: c */
    public final void m3578c() {
        Log.v("Constraints", " ################# init");
    }

    public C0585c getConstraintSet() {
        if (this.f3035a == null) {
            this.f3035a = new C0585c();
        }
        this.f3035a.m3639r(this);
        return this.f3035a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3578c();
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m3578c();
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {

        /* renamed from: A0 */
        public float f3036A0;

        /* renamed from: B0 */
        public float f3037B0;

        /* renamed from: C0 */
        public float f3038C0;

        /* renamed from: D0 */
        public float f3039D0;

        /* renamed from: E0 */
        public float f3040E0;

        /* renamed from: F0 */
        public float f3041F0;

        /* renamed from: G0 */
        public float f3042G0;

        /* renamed from: H0 */
        public float f3043H0;

        /* renamed from: I0 */
        public float f3044I0;

        /* renamed from: J0 */
        public float f3045J0;

        /* renamed from: x0 */
        public float f3046x0;

        /* renamed from: y0 */
        public boolean f3047y0;

        /* renamed from: z0 */
        public float f3048z0;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f3046x0 = 1.0f;
            this.f3047y0 = false;
            this.f3048z0 = 0.0f;
            this.f3036A0 = 0.0f;
            this.f3037B0 = 0.0f;
            this.f3038C0 = 0.0f;
            this.f3039D0 = 1.0f;
            this.f3040E0 = 1.0f;
            this.f3041F0 = 0.0f;
            this.f3042G0 = 0.0f;
            this.f3043H0 = 0.0f;
            this.f3044I0 = 0.0f;
            this.f3045J0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3046x0 = 1.0f;
            this.f3047y0 = false;
            this.f3048z0 = 0.0f;
            this.f3036A0 = 0.0f;
            this.f3037B0 = 0.0f;
            this.f3038C0 = 0.0f;
            this.f3039D0 = 1.0f;
            this.f3040E0 = 1.0f;
            this.f3041F0 = 0.0f;
            this.f3042G0 = 0.0f;
            this.f3043H0 = 0.0f;
            this.f3044I0 = 0.0f;
            this.f3045J0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintSet_android_alpha) {
                    this.f3046x0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3046x0);
                } else if (index == R$styleable.ConstraintSet_android_elevation) {
                    this.f3048z0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3048z0);
                    this.f3047y0 = true;
                } else if (index == R$styleable.ConstraintSet_android_rotationX) {
                    this.f3037B0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3037B0);
                } else if (index == R$styleable.ConstraintSet_android_rotationY) {
                    this.f3038C0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3038C0);
                } else if (index == R$styleable.ConstraintSet_android_rotation) {
                    this.f3036A0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3036A0);
                } else if (index == R$styleable.ConstraintSet_android_scaleX) {
                    this.f3039D0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3039D0);
                } else if (index == R$styleable.ConstraintSet_android_scaleY) {
                    this.f3040E0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3040E0);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotX) {
                    this.f3041F0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3041F0);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotY) {
                    this.f3042G0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3042G0);
                } else if (index == R$styleable.ConstraintSet_android_translationX) {
                    this.f3043H0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3043H0);
                } else if (index == R$styleable.ConstraintSet_android_translationY) {
                    this.f3044I0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3044I0);
                } else if (index == R$styleable.ConstraintSet_android_translationZ) {
                    this.f3045J0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3045J0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
