package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

/* loaded from: classes2.dex */
public class AutoScaleSizeRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private Float f36316a;

    /* renamed from: b */
    private final RectF f36317b;

    /* renamed from: c */
    private float f36318c;

    /* renamed from: d */
    private Path f36319d;

    /* renamed from: e */
    private boolean f36320e;

    public AutoScaleSizeRelativeLayout(Context context) {
        super(context);
        this.f36317b = new RectF();
        this.f36318c = 0.0f;
        this.f36320e = true;
        m48723a(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private int m48721a(int i10, float f10) {
        if (f10 <= 0.0f) {
            return 0;
        }
        return mo48725p() ? (int) Math.ceil((i10 * 1.0f) / f10) : (int) ((i10 * 1.0f) / f10);
    }

    /* renamed from: b */
    private int m48724b(int i10, float f10) {
        return mo48725p() ? (int) Math.ceil(f10 * i10) : (int) (f10 * i10);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (canvas == null) {
                AbstractC7185ho.m43823c("AutoScaleSizeRl", "canvas null");
                return;
            }
            if (this.f36318c > 0.01f) {
                canvas.clipPath(this.f36319d);
            }
            super.draw(canvas);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AutoScaleSizeRl", "draw err: %s", th2.getClass().getSimpleName());
        }
    }

    public float getRatio() {
        Float f10 = this.f36316a;
        if (f10 != null) {
            return f10.floatValue();
        }
        return 0.0f;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        try {
            super.onLayout(z10, i10, i11, i12, i13);
            this.f36317b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            m48722a();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AutoScaleSizeRl", "onLayout err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iM48721a;
        try {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (!this.f36320e && layoutParams != null && layoutParams.width == -1 && layoutParams.height == -1) {
                super.onMeasure(i10, i11);
                return;
            }
            Float f10 = this.f36316a;
            if (f10 != null && f10.floatValue() > 0.01f) {
                int size = View.MeasureSpec.getSize(i10);
                int size2 = View.MeasureSpec.getSize(i11);
                if (View.MeasureSpec.getMode(i11) == 1073741824 || (size > 0 && size2 > 0)) {
                    if ((size * 1.0f) / size2 > this.f36316a.floatValue()) {
                        size = m48724b(size2, this.f36316a.floatValue());
                    } else {
                        size2 = m48721a(size, this.f36316a.floatValue());
                    }
                    iM48721a = size2;
                } else {
                    iM48721a = m48721a(size, this.f36316a.floatValue());
                }
                i10 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i11 = View.MeasureSpec.makeMeasureSpec(iM48721a, 1073741824);
            }
            super.onMeasure(i10, i11);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AutoScaleSizeRl", "onMeasure err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: p */
    public boolean mo48725p() {
        return false;
    }

    @OuterVisible
    public void setRatio(Float f10) {
        this.f36316a = f10;
    }

    @OuterVisible
    public void setRectCornerRadius(float f10) {
        this.f36318c = f10;
        m48722a();
        postInvalidate();
    }

    public void setUseRatioInMatchParentMode(boolean z10) {
        this.f36320e = z10;
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36317b = new RectF();
        this.f36318c = 0.0f;
        this.f36320e = true;
        m48723a(context, attributeSet);
    }

    /* renamed from: a */
    private void m48722a() {
        this.f36319d.reset();
        Path path = this.f36319d;
        RectF rectF = this.f36317b;
        float f10 = this.f36318c;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36317b = new RectF();
        this.f36318c = 0.0f;
        this.f36320e = true;
        m48723a(context, attributeSet);
    }

    /* renamed from: a */
    private void m48723a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.f36318c = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.f36319d = new Path();
    }

    @TargetApi(21)
    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36317b = new RectF();
        this.f36318c = 0.0f;
        this.f36320e = true;
        m48723a(context, attributeSet);
    }
}
