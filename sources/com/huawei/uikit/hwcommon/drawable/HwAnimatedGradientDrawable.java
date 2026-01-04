package com.huawei.uikit.hwcommon.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import androidx.annotation.Keep;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* loaded from: classes7.dex */
public class HwAnimatedGradientDrawable extends GradientDrawable {

    /* renamed from: A */
    private static final float f42038A = 1.0f;

    /* renamed from: l */
    private static final String f42039l = "HwAnimatedGradientDrawable";

    /* renamed from: m */
    private static final float f42040m = 0.9f;

    /* renamed from: n */
    private static final float f42041n = 1.0f;

    /* renamed from: o */
    private static final float f42042o = 0.0f;

    /* renamed from: p */
    private static final float f42043p = 1.0f;

    /* renamed from: q */
    private static final float f42044q = 12.0f;

    /* renamed from: r */
    private static final float f42045r = 4.0f;

    /* renamed from: s */
    private static final int f42046s = 201326592;

    /* renamed from: t */
    private static final float f42047t = 0.5f;

    /* renamed from: u */
    private static final long f42048u = 100;

    /* renamed from: v */
    private static final int f42049v = 255;

    /* renamed from: w */
    private static final float f42050w = 1.0E-7f;

    /* renamed from: x */
    private static final float f42051x = 0.2f;

    /* renamed from: y */
    private static final float f42052y = 0.0f;

    /* renamed from: z */
    private static final float f42053z = 0.4f;

    /* renamed from: a */
    private TimeInterpolator f42054a;

    /* renamed from: b */
    private Animator f42055b;

    /* renamed from: c */
    private Animator f42056c;

    /* renamed from: d */
    private boolean f42057d;

    /* renamed from: e */
    private float f42058e;

    /* renamed from: f */
    private float f42059f;

    /* renamed from: g */
    private float f42060g;

    /* renamed from: h */
    private float f42061h;

    /* renamed from: i */
    private float f42062i;

    /* renamed from: j */
    private float f42063j;

    /* renamed from: k */
    private boolean f42064k;

    public HwAnimatedGradientDrawable(int i10, float f10, float f11) {
        this.f42054a = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        m54210a(i10, f10, f11);
    }

    /* renamed from: a */
    private void m54210a(int i10, float f10, float f11) {
        setShape(0);
        setColor(i10);
        setCornerRadius(f11);
        this.f42063j = f11;
        this.f42057d = false;
        this.f42058e = f10;
        this.f42061h = 0.0f;
        this.f42059f = 1.0f;
        this.f42060g = 0.9f;
        this.f42064k = false;
    }

    /* renamed from: b */
    private void m54212b() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rectAlpha", this.f42058e);
        objectAnimatorOfFloat.setDuration(f42048u);
        objectAnimatorOfFloat.setInterpolator(this.f42054a);
        if (this.f42063j > 0.0f || this.f42064k) {
            ObjectAnimator objectAnimatorOfFloat2 = getRectAlpha() < f42050w ? ObjectAnimator.ofFloat(this, "rectScale", this.f42060g, this.f42059f) : ObjectAnimator.ofFloat(this, "rectScale", this.f42059f);
            objectAnimatorOfFloat2.setDuration(f42048u);
            objectAnimatorOfFloat2.setInterpolator(this.f42054a);
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } else {
            setRectScale(1.0f);
            animatorSet.play(objectAnimatorOfFloat);
        }
        this.f42055b = animatorSet;
        animatorSet.start();
    }

    /* renamed from: c */
    private void m54213c() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rectAlpha", 0.0f);
        objectAnimatorOfFloat.setDuration(f42048u);
        objectAnimatorOfFloat.setInterpolator(this.f42054a);
        animatorSet.playTogether(objectAnimatorOfFloat);
        this.f42056c = animatorSet;
        animatorSet.start();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f10 = this.f42061h;
        if (f10 < f42050w) {
            return;
        }
        float f11 = this.f42062i;
        setAlpha((int) (f10 * 255.0f));
        canvas.save();
        canvas.scale(f11, f11, canvas.getWidth() * f42047t, canvas.getHeight() * f42047t);
        super.draw(canvas);
        canvas.restore();
    }

    public float getMaxRectAlpha() {
        return this.f42058e;
    }

    public float getMaxRectScale() {
        return this.f42059f;
    }

    public float getMinRectScale() {
        return this.f42060g;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRect(getBounds());
        outline.setAlpha(0.0f);
    }

    public float getRectAlpha() {
        return this.f42061h;
    }

    public float getRectScale() {
        return this.f42062i;
    }

    public boolean isForceDoScaleAnim() {
        return this.f42064k;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z11 = true;
            } else if (i10 == 16842919) {
                z12 = true;
            } else {
                Log.i(f42039l, "State = " + i10);
            }
        }
        if (z11 && z12) {
            z10 = true;
        }
        m54211a(z10);
        return true;
    }

    public void setForceDoScaleAnim(boolean z10) {
        this.f42064k = z10;
    }

    public void setMaxRectAlpha(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f42058e = f10;
    }

    public void setMaxRectScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f42059f = f10;
    }

    public void setMinRectScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f42060g = f10;
    }

    @Keep
    public void setRectAlpha(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f42061h = f10;
        invalidateSelf();
    }

    @Keep
    public void setRectScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f42062i = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (!z10) {
            m54209a();
        } else if (!visible) {
            Log.i(f42039l, "isChanged = " + visible + ".");
        } else if (this.f42057d) {
            this.f42061h = this.f42058e;
            this.f42062i = this.f42059f;
        } else {
            this.f42061h = 0.0f;
        }
        return visible;
    }

    public HwAnimatedGradientDrawable() {
        this(f42046s, 1.0f, f42044q);
    }

    public HwAnimatedGradientDrawable(Context context) {
        this(f42046s, 1.0f, context);
    }

    public HwAnimatedGradientDrawable(int i10, float f10, Context context) {
        this(i10, f10, f42045r, context);
    }

    public HwAnimatedGradientDrawable(int i10, float f10, float f11, Context context) {
        this.f42054a = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        if (context != null) {
            m54210a(i10, f10, f11 * context.getResources().getDisplayMetrics().density);
        } else {
            m54210a(i10, f10, f42044q);
        }
    }

    /* renamed from: a */
    private void m54211a(boolean z10) {
        if (this.f42057d != z10) {
            this.f42057d = z10;
            if (z10) {
                Animator animator = this.f42055b;
                if (animator == null || !animator.isRunning()) {
                    Animator animator2 = this.f42056c;
                    if (animator2 != null && animator2.isRunning()) {
                        this.f42056c.cancel();
                    }
                    m54212b();
                    return;
                }
                return;
            }
            Animator animator3 = this.f42056c;
            if (animator3 == null || !animator3.isRunning()) {
                Animator animator4 = this.f42055b;
                if (animator4 != null && animator4.isRunning()) {
                    this.f42055b.cancel();
                }
                m54213c();
            }
        }
    }

    /* renamed from: a */
    private void m54209a() {
        Animator animator = this.f42055b;
        if (animator != null && animator.isRunning()) {
            this.f42055b.end();
            Log.i(f42039l, "clearEffect: mEnterAnim is not null.");
        }
        Animator animator2 = this.f42056c;
        if (animator2 != null && animator2.isRunning()) {
            this.f42056c.end();
            Log.i(f42039l, "clearEffect: mExitAnim is not null.");
        }
        this.f42055b = null;
        this.f42056c = null;
        this.f42057d = false;
        this.f42061h = 0.0f;
        invalidateSelf();
    }
}
