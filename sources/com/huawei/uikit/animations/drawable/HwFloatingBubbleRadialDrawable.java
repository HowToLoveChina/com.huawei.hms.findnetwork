package com.huawei.uikit.animations.drawable;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class HwFloatingBubbleRadialDrawable extends Drawable {
    public static final float DISAPPEAR_SCALE = 0.3f;

    /* renamed from: n */
    private static final String f40735n = "HwFloatingBubbleRadialDrawable";

    /* renamed from: o */
    private static final int f40736o = 300;

    /* renamed from: p */
    private static final int f40737p = 5;

    /* renamed from: q */
    private static final int f40738q = -1;

    /* renamed from: r */
    private static final float f40739r = 1.2f;

    /* renamed from: s */
    private static final float f40740s = 0.5f;

    /* renamed from: t */
    private static final int f40741t = 25;

    /* renamed from: u */
    private static final int f40742u = 255;

    /* renamed from: v */
    private static final int[] f40743v = {-1, -394759, -1315861, -1973269, -2038542};

    /* renamed from: w */
    private static final int[] f40744w = {-8741633, -11108097, -14855696, -16762657, -16435250};

    /* renamed from: x */
    private static final float[] f40745x = {0.0f, 0.3f, 0.6f, 0.8f, 1.0f};

    /* renamed from: a */
    private final Paint f40746a;

    /* renamed from: b */
    private boolean f40747b;

    /* renamed from: c */
    private ValueAnimator f40748c;

    /* renamed from: d */
    private final ArgbEvaluator f40749d;

    /* renamed from: e */
    private final int[] f40750e;

    /* renamed from: f */
    private final int[] f40751f;

    /* renamed from: g */
    private final int[] f40752g;

    /* renamed from: h */
    private final float[] f40753h;

    /* renamed from: i */
    private int f40754i;

    /* renamed from: j */
    private int f40755j;

    /* renamed from: k */
    private int f40756k;

    /* renamed from: l */
    private float f40757l;

    /* renamed from: m */
    private boolean f40758m;

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int[] f40759a;

        /* renamed from: b */
        final /* synthetic */ int[] f40760b;

        public bzrwd(int[] iArr, int[] iArr2) {
            this.f40759a = iArr;
            this.f40760b = iArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w(HwFloatingBubbleRadialDrawable.f40735n, "onAnimationUpdate: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i10 = 0; i10 < HwFloatingBubbleRadialDrawable.this.f40751f.length; i10++) {
                HwFloatingBubbleRadialDrawable.this.f40751f[i10] = ((Integer) HwFloatingBubbleRadialDrawable.this.f40749d.evaluate(fFloatValue, Integer.valueOf(this.f40759a[i10]), Integer.valueOf(this.f40760b[i10]))).intValue();
            }
            HwFloatingBubbleRadialDrawable.this.invalidateSelf();
        }
    }

    public HwFloatingBubbleRadialDrawable(boolean z10) {
        this(null, null, null, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float fWidth = bounds.width() * f40740s;
        float[] fArr = {(this.f40754i * f40740s) - (this.f40755j + (bounds.width() * f40740s)), 0.0f - (this.f40756k + (bounds.height() * f40740s))};
        float fSqrt = (float) Math.sqrt((r3 * r3) + (r6 * r6));
        float fMin = (Math.min(fSqrt / ((float) Math.sqrt((r4 * r4) + 0.0f)), 1.0f) * fWidth) / fSqrt;
        float[] fArr2 = {fArr[0] * fMin, fMin * fArr[1]};
        float fCenterX = bounds.centerX() + fArr2[0];
        float fCenterY = bounds.centerY() + fArr2[1];
        float f10 = fArr2[0];
        float fSqrt2 = ((float) Math.sqrt((f10 * f10) + (r7 * r7))) + fWidth;
        this.f40746a.setShader(new RadialGradient(fCenterX, fCenterY, fSqrt2, this.f40751f, this.f40753h, Shader.TileMode.CLAMP));
        if (Float.compare(this.f40757l, 1.0f) == -1) {
            this.f40746a.setAlpha((int) (this.f40757l * 255.0f));
            if (this.f40758m) {
                this.f40746a.setMaskFilter(new BlurMaskFilter((1.0f - this.f40757l) * 25.0f, BlurMaskFilter.Blur.INNER));
            }
        } else {
            this.f40746a.setAlpha(255);
            if (this.f40758m) {
                this.f40746a.setMaskFilter(null);
            }
        }
        try {
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), fWidth, this.f40746a);
        } catch (IllegalArgumentException unused) {
            Log.w(f40735n, "draw: bounds=" + bounds.toString() + " mParentWidth=" + this.f40754i + ", mLeft=" + this.f40755j + ", mTop=" + this.f40756k);
            Log.e(f40735n, "draw failed: cx=" + bounds.centerX() + ", cy=" + bounds.centerY() + ", radius=" + fWidth + ", Shader(cx=" + fCenterX + ", cy=" + fCenterY + ", radius=" + fSqrt2 + ", colors=" + Arrays.toString(this.f40751f) + ", stops=" + Arrays.toString(this.f40753h) + ")");
        }
    }

    public float getBgAlphaScale() {
        return this.f40757l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (iArr[i10] == 16842913) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10 == this.f40747b) {
            return false;
        }
        this.f40747b = z10;
        ValueAnimator valueAnimator = this.f40748c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f40748c.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f40748c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f40748c.setDuration(300L);
        this.f40748c.addUpdateListener(new bzrwd(Arrays.copyOf(this.f40751f, 5), this.f40747b ? Arrays.copyOf(this.f40752g, 5) : Arrays.copyOf(this.f40750e, 5)));
        this.f40748c.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setParams(int i10, int i11, int i12, float f10) {
        float fMax = Float.compare(f10, f40739r) == -1 ? Math.max(((f10 - f40739r) * 1.111111f) + 1.0f, 0.0f) : 1.0f;
        boolean z10 = Float.compare(fMax, this.f40757l) == 0;
        if (this.f40754i == i10 && this.f40755j == i11 && this.f40756k == i12 && z10) {
            return;
        }
        this.f40754i = i10;
        this.f40755j = i11;
        this.f40756k = i12;
        this.f40757l = fMax;
        invalidateSelf();
    }

    public void setParentWidth(int i10) {
        this.f40754i = i10;
    }

    public void setPosition(int i10, int i11) {
        this.f40755j = i10;
        this.f40756k = i11;
        invalidateSelf();
    }

    public void setViewScale(float f10) {
        if (Float.compare(f10, f40739r) != -1) {
            this.f40757l = 1.0f;
            return;
        }
        float f11 = ((f10 - f40739r) * 1.111111f) + 1.0f;
        this.f40757l = f11;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.f40757l = f11;
    }

    public HwFloatingBubbleRadialDrawable(int[] iArr, int[] iArr2, float[] fArr, boolean z10) {
        this(iArr, iArr2, fArr, z10, true);
    }

    public HwFloatingBubbleRadialDrawable(int[] iArr, int[] iArr2, float[] fArr, boolean z10, boolean z11) {
        Paint paint = new Paint();
        this.f40746a = paint;
        this.f40747b = false;
        this.f40749d = new ArgbEvaluator();
        if (iArr != null && iArr.length == 5) {
            this.f40750e = iArr;
        } else {
            this.f40750e = f40743v;
        }
        if (iArr2 != null && iArr2.length == 5) {
            this.f40752g = iArr2;
        } else {
            this.f40752g = f40744w;
        }
        if (fArr != null && fArr.length == 5) {
            this.f40753h = fArr;
        } else {
            this.f40753h = f40745x;
        }
        if (z10) {
            this.f40751f = Arrays.copyOf(this.f40752g, 5);
        } else {
            this.f40751f = Arrays.copyOf(this.f40750e, 5);
        }
        this.f40758m = z11;
        paint.setAntiAlias(true);
    }
}
