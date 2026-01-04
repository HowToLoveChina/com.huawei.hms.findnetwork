package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: d */
    public float f2875d;

    /* renamed from: e */
    public float f2876e;

    /* renamed from: f */
    public Path f2877f;

    /* renamed from: g */
    public ViewOutlineProvider f2878g;

    /* renamed from: h */
    public RectF f2879h;

    /* renamed from: androidx.constraintlayout.utils.widget.MotionButton$a */
    public class C0575a extends ViewOutlineProvider {
        public C0575a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.f2875d) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.MotionButton$b */
    public class C0576b extends ViewOutlineProvider {
        public C0576b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f2876e);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.f2875d = 0.0f;
        this.f2876e = Float.NaN;
        m3542c(context, null);
    }

    /* renamed from: c */
    private void m3542c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f2876e;
    }

    public float getRoundPercent() {
        return this.f2875d;
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f2876e = f10;
            float f11 = this.f2875d;
            this.f2875d = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f2876e != f10;
        this.f2876e = f10;
        if (f10 != 0.0f) {
            if (this.f2877f == null) {
                this.f2877f = new Path();
            }
            if (this.f2879h == null) {
                this.f2879h = new RectF();
            }
            if (this.f2878g == null) {
                C0576b c0576b = new C0576b();
                this.f2878g = c0576b;
                setOutlineProvider(c0576b);
            }
            setClipToOutline(true);
            this.f2879h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2877f.reset();
            Path path = this.f2877f;
            RectF rectF = this.f2879h;
            float f12 = this.f2876e;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f2875d != f10;
        this.f2875d = f10;
        if (f10 != 0.0f) {
            if (this.f2877f == null) {
                this.f2877f = new Path();
            }
            if (this.f2879h == null) {
                this.f2879h = new RectF();
            }
            if (this.f2878g == null) {
                C0575a c0575a = new C0575a();
                this.f2878g = c0575a;
                setOutlineProvider(c0575a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2875d) / 2.0f;
            this.f2879h.set(0.0f, 0.0f, width, height);
            this.f2877f.reset();
            this.f2877f.addRoundRect(this.f2879h, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2875d = 0.0f;
        this.f2876e = Float.NaN;
        m3542c(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2875d = 0.0f;
        this.f2876e = Float.NaN;
        m3542c(context, attributeSet);
    }
}
