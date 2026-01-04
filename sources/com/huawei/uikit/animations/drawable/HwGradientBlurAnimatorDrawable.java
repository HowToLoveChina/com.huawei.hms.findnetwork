package com.huawei.uikit.animations.drawable;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class HwGradientBlurAnimatorDrawable extends Drawable {

    /* renamed from: n */
    private static final String f40762n = "HwGradientBlurAnimatorDrawable";

    /* renamed from: o */
    private static final int f40763o = 25;

    /* renamed from: p */
    private static final int f40764p = 2;

    /* renamed from: q */
    private static final int f40765q = 300;

    /* renamed from: r */
    private static final int f40766r = -1;

    /* renamed from: a */
    private final int f40767a;

    /* renamed from: b */
    private int[] f40768b;

    /* renamed from: c */
    private int f40769c;

    /* renamed from: d */
    private int f40770d;

    /* renamed from: e */
    private int[] f40771e;

    /* renamed from: f */
    private int f40772f;

    /* renamed from: g */
    private int[] f40773g;

    /* renamed from: h */
    private Paint f40774h;

    /* renamed from: i */
    private Paint f40775i;

    /* renamed from: j */
    private float[] f40776j;

    /* renamed from: k */
    private boolean f40777k;

    /* renamed from: l */
    private ArgbEvaluator f40778l;

    /* renamed from: m */
    private ValueAnimator f40779m;

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int[] f40780a;

        /* renamed from: b */
        final /* synthetic */ int[] f40781b;

        /* renamed from: c */
        final /* synthetic */ int f40782c;

        /* renamed from: d */
        final /* synthetic */ int f40783d;

        public bzrwd(int[] iArr, int[] iArr2, int i10, int i11) {
            this.f40780a = iArr;
            this.f40781b = iArr2;
            this.f40782c = i10;
            this.f40783d = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.d(HwGradientBlurAnimatorDrawable.f40762n, "onAnimationUpdate: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            HwGradientBlurAnimatorDrawable.this.f40773g[0] = ((Integer) HwGradientBlurAnimatorDrawable.this.f40778l.evaluate(fFloatValue, Integer.valueOf(this.f40780a[0]), Integer.valueOf(this.f40781b[0]))).intValue();
            HwGradientBlurAnimatorDrawable.this.f40773g[1] = ((Integer) HwGradientBlurAnimatorDrawable.this.f40778l.evaluate(fFloatValue, Integer.valueOf(this.f40780a[1]), Integer.valueOf(this.f40781b[1]))).intValue();
            HwGradientBlurAnimatorDrawable hwGradientBlurAnimatorDrawable = HwGradientBlurAnimatorDrawable.this;
            hwGradientBlurAnimatorDrawable.f40772f = ((Integer) hwGradientBlurAnimatorDrawable.f40778l.evaluate(fFloatValue, Integer.valueOf(this.f40782c), Integer.valueOf(this.f40783d))).intValue();
            HwGradientBlurAnimatorDrawable.this.invalidateSelf();
        }
    }

    public HwGradientBlurAnimatorDrawable(int i10, int[] iArr, int i11, int[] iArr2) {
        this(i10, iArr, i11, iArr2, 25);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10 = this.f40772f;
        if (i10 != 0 && this.f40769c > 0) {
            this.f40774h.setColor(i10);
            canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), getBounds().width() >> 1, this.f40774h);
        }
        Rect bounds = getBounds();
        this.f40775i.setShader(new LinearGradient(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f40773g, this.f40776j, Shader.TileMode.CLAMP));
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), getBounds().width() >> 1, this.f40775i);
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
    public void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int[] iArrCopyOf;
        int i10;
        boolean z10 = false;
        for (int i11 : iArr) {
            if (i11 == 16842913) {
                z10 = true;
            }
        }
        if (z10 == this.f40777k) {
            return false;
        }
        this.f40777k = z10;
        ValueAnimator valueAnimator = this.f40779m;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f40779m.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f40779m = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f40779m.setDuration(300L);
        int[] iArrCopyOf2 = Arrays.copyOf(this.f40773g, 2);
        int i12 = this.f40772f;
        if (this.f40777k) {
            iArrCopyOf = Arrays.copyOf(this.f40768b, 2);
            i10 = this.f40767a;
        } else {
            iArrCopyOf = Arrays.copyOf(this.f40771e, 2);
            i10 = this.f40770d;
        }
        this.f40779m.addUpdateListener(new bzrwd(iArrCopyOf2, iArrCopyOf, i12, i10));
        this.f40779m.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f40774h.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public HwGradientBlurAnimatorDrawable(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        this(i10, iArr, i11, iArr2, i12, false);
    }

    public HwGradientBlurAnimatorDrawable(int i10, int[] iArr, int i11, int[] iArr2, int i12, boolean z10) {
        this.f40774h = new Paint();
        this.f40775i = new Paint();
        this.f40776j = new float[]{0.0f, 1.0f};
        this.f40777k = false;
        this.f40778l = new ArgbEvaluator();
        if (iArr.length == 2 && iArr2.length == 2) {
            this.f40771e = iArr;
            this.f40768b = iArr2;
        } else {
            m53627a();
        }
        if (z10) {
            this.f40773g = Arrays.copyOf(this.f40768b, 2);
        } else {
            this.f40773g = Arrays.copyOf(this.f40771e, 2);
        }
        this.f40770d = i10;
        this.f40767a = i11;
        this.f40772f = z10 ? i11 : i10;
        this.f40769c = i12 < 0 ? 0 : i12;
        this.f40774h.setAntiAlias(true);
        if (this.f40769c > 0) {
            this.f40774h.setMaskFilter(new BlurMaskFilter(this.f40769c, BlurMaskFilter.Blur.OUTER));
        }
        this.f40775i.setAntiAlias(true);
        this.f40775i.setStyle(Paint.Style.FILL);
    }

    /* renamed from: a */
    private void m53627a() {
        this.f40771e = new int[]{-1, -1};
        this.f40768b = new int[]{-1, -1};
    }
}
