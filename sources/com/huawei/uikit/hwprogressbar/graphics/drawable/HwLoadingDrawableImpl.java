package com.huawei.uikit.hwprogressbar.graphics.drawable;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* loaded from: classes2.dex */
public class HwLoadingDrawableImpl extends BitmapDrawable implements Animatable {

    /* renamed from: A */
    private static final float f43060A = 0.6944444f;

    /* renamed from: B */
    private static final int f43061B = 255;

    /* renamed from: C */
    private static final int f43062C = 127;

    /* renamed from: D */
    private static final int f43063D = 30;

    /* renamed from: E */
    private static final int f43064E = 360;

    /* renamed from: F */
    private static final int f43065F = 12;

    /* renamed from: G */
    private static final int f43066G = 5;

    /* renamed from: H */
    private static final int f43067H = 1;

    /* renamed from: I */
    private static final int f43068I = 0;

    /* renamed from: J */
    private static final int f43069J = 128;

    /* renamed from: k */
    private static final String f43070k = "HwLoadingDrawableImpl";

    /* renamed from: l */
    private static final int f43071l = 250;

    /* renamed from: m */
    private static final int f43072m = -10066330;

    /* renamed from: n */
    private static final int f43073n = 1000;

    /* renamed from: o */
    private static final float f43074o = 60.0f;

    /* renamed from: p */
    private static final float f43075p = 0.0f;

    /* renamed from: q */
    private static final float f43076q = 10.0f;

    /* renamed from: r */
    private static final float f43077r = 33.076923f;

    /* renamed from: s */
    private static final float f43078s = 60.0f;

    /* renamed from: t */
    private static final float f43079t = 23.076923f;

    /* renamed from: u */
    private static final float f43080u = 0.0f;

    /* renamed from: v */
    private static final float f43081v = 0.0f;

    /* renamed from: w */
    private static final float f43082w = 2.0f;

    /* renamed from: x */
    private static final int f43083x = 60;

    /* renamed from: y */
    private static final float f43084y = 0.0f;

    /* renamed from: z */
    private static final float f43085z = 0.1f;

    /* renamed from: a */
    private int f43086a;

    /* renamed from: b */
    private float f43087b;

    /* renamed from: c */
    private ValueAnimator f43088c;

    /* renamed from: d */
    private Paint f43089d;

    /* renamed from: e */
    private float f43090e;

    /* renamed from: f */
    private float f43091f;

    /* renamed from: g */
    private float f43092g;

    /* renamed from: h */
    private float f43093h;

    /* renamed from: i */
    private float f43094i;

    /* renamed from: j */
    private Interpolator f43095j;

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {
        public bzrwd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            HwLoadingDrawableImpl.this.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public HwLoadingDrawableImpl(Resources resources, int i10) {
        this(resources, i10, f43072m);
    }

    /* renamed from: a */
    private static Bitmap m54746a(int i10) {
        if (i10 > 250) {
            i10 = 250;
        } else if (i10 <= 0) {
            i10 = 1;
        }
        return Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
    }

    /* renamed from: b */
    private void m54748b(int i10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f43088c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.f43088c.setRepeatCount(-1);
        this.f43088c.setInterpolator(new LinearInterpolator());
        Paint paint = new Paint();
        this.f43089d = paint;
        this.f43091f = 0.0f;
        this.f43092g = 0.0f;
        this.f43086a = i10;
        paint.setColor(i10);
        this.f43089d.setAntiAlias(true);
        this.f43088c.addUpdateListener(new bzrwd());
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.w(f43070k, "draw: canvas is null");
            return;
        }
        this.f43089d.setColor(this.f43086a);
        if (this.f43087b * 60.0f >= 60.0f) {
            this.f43087b = 0.0f;
        }
        canvas.save();
        for (int i10 = 0; i10 < 12; i10++) {
            float f10 = (this.f43087b * 60.0f) + (i10 * 5);
            this.f43089d.setAlpha(((int) m54744a(f10, false)) + 127);
            canvas.drawCircle(this.f43093h, this.f43094i, this.f43090e + (((float) m54744a(f10, true)) * this.f43090e), this.f43089d);
            canvas.rotate(-30.0f, this.f43091f, this.f43092g);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f43088c;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m54747b();
    }

    public void setColor(int i10) {
        this.f43086a = i10;
    }

    public void setDuration(int i10) {
        this.f43088c.setDuration(i10);
    }

    @Keep
    public void setProgress(float f10) {
        this.f43087b = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator valueAnimator = this.f43088c;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.f43088c.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.f43088c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f43088c.end();
    }

    public HwLoadingDrawableImpl(Resources resources, int i10, int i11) {
        super(resources, m54746a(i10));
        this.f43087b = 0.0f;
        this.f43095j = new HwCubicBezierInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        m54748b(i11);
    }

    /* renamed from: a */
    private float m54745a() {
        Rect bounds = getBounds();
        float f10 = (bounds.left + bounds.right) / 2.0f;
        this.f43091f = f10;
        float f11 = (bounds.top + bounds.bottom) / 2.0f;
        this.f43092g = f11;
        return f10 < f11 ? f10 : f11;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private double m54744a(float r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1114636288(0x42700000, float:60.0)
            float r4 = r4 % r0
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r2 = 1092616192(0x41200000, float:10.0)
            if (r1 < 0) goto L1a
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L1a
            android.view.animation.Interpolator r3 = r3.f43095j
            r0 = 1036831949(0x3dcccccd, float:0.1)
            float r4 = r4 * r0
            float r3 = r3.getInterpolation(r4)
        L18:
            double r3 = (double) r3
            goto L4b
        L1a:
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r2 = 1107578565(0x42044ec5, float:33.076923)
            if (r1 < 0) goto L37
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L37
            android.view.animation.Interpolator r3 = r3.f43095j
            r0 = -1120829877(0xffffffffbd317e4b, float:-0.043333333)
            float r4 = r4 * r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 + r0
            r0 = 1054727646(0x3eddddde, float:0.43333334)
            float r4 = r4 + r0
            float r3 = r3.getInterpolation(r4)
            goto L18
        L37:
            int r3 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r1 = 0
            if (r3 < 0) goto L43
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r3 >= 0) goto L43
        L41:
            r3 = r1
            goto L4b
        L43:
            java.lang.String r3 = "HwLoadingDrawableImpl"
            java.lang.String r4 = "invalid tempFrame"
            android.util.Log.w(r3, r4)
            goto L41
        L4b:
            if (r5 == 0) goto L4e
            return r3
        L4e:
            r0 = 4638707616191610880(0x4060000000000000, double:128.0)
            double r3 = r3 * r0
            int r3 = (int) r3
            double r3 = (double) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwprogressbar.graphics.drawable.HwLoadingDrawableImpl.m54744a(float, boolean):double");
    }

    /* renamed from: b */
    private void m54747b() {
        float fM54745a = m54745a() * f43060A;
        this.f43090e = 0.1f * fM54745a;
        this.f43093h = this.f43091f;
        this.f43094i = this.f43092g - fM54745a;
    }
}
