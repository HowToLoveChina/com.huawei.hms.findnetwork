package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l */
    public Paint f2931l;

    /* renamed from: m */
    public MotionLayout f2932m;

    /* renamed from: n */
    public float[] f2933n;

    /* renamed from: o */
    public Matrix f2934o;

    /* renamed from: p */
    public int f2935p;

    /* renamed from: q */
    public int f2936q;

    /* renamed from: r */
    public float f2937r;

    public MotionTelltales(Context context) {
        super(context);
        this.f2931l = new Paint();
        this.f2933n = new float[2];
        this.f2934o = new Matrix();
        this.f2935p = 0;
        this.f2936q = -65281;
        this.f2937r = 0.25f;
        m3554a(context, null);
    }

    /* renamed from: a */
    public final void m3554a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.f2936q = typedArrayObtainStyledAttributes.getColor(index, this.f2936q);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.f2935p = typedArrayObtainStyledAttributes.getInt(index, this.f2935p);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.f2937r = typedArrayObtainStyledAttributes.getFloat(index, this.f2937r);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2931l.setColor(this.f2936q);
        this.f2931l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f2934o);
        if (this.f2932m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f2932m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i10 = 0; i10 < 5; i10++) {
            float f10 = fArr[i10];
            for (int i11 = 0; i11 < 5; i11++) {
                float f11 = fArr[i11];
                this.f2932m.m3316W(this, f11, f10, this.f2933n, this.f2935p);
                this.f2934o.mapVectors(this.f2933n);
                float f12 = width * f11;
                float f13 = height * f10;
                float[] fArr2 = this.f2933n;
                float f14 = fArr2[0];
                float f15 = this.f2937r;
                float f16 = f13 - (fArr2[1] * f15);
                this.f2934o.mapVectors(fArr2);
                canvas.drawLine(f12, f13, f12 - (f14 * f15), f16, this.f2931l);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f2869f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2931l = new Paint();
        this.f2933n = new float[2];
        this.f2934o = new Matrix();
        this.f2935p = 0;
        this.f2936q = -65281;
        this.f2937r = 0.25f;
        m3554a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2931l = new Paint();
        this.f2933n = new float[2];
        this.f2934o = new Matrix();
        this.f2935p = 0;
        this.f2936q = -65281;
        this.f2937r = 0.25f;
        m3554a(context, attributeSet);
    }
}
