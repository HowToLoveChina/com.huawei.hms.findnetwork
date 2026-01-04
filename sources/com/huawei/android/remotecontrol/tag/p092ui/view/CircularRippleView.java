package com.huawei.android.remotecontrol.tag.p092ui.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.huawei.android.remotecontrol.sdk.R$styleable;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p514o9.C11842p;

/* loaded from: classes4.dex */
public class CircularRippleView extends View {
    private Paint centerPaint;
    private boolean control;
    private Integer innerAlpha;
    private ValueAnimator innerAnimator;
    private Paint innerPaint;
    private float innerRadius;
    private int mColor;
    private int maxRadius;
    private int minRadius;
    private Integer outerAlpha;
    private ValueAnimator outerAnimator;
    private Paint outerPaint;
    private float outerRadius;

    public CircularRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Integer numValueOf = Integer.valueOf(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        this.outerAlpha = numValueOf;
        this.innerAlpha = numValueOf;
        this.outerRadius = 0.0f;
        this.innerRadius = 0.0f;
        this.control = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MyCircleWave);
            int i10 = R$styleable.MyCircleWave_MyCircleWaveColor;
            if (typedArrayObtainStyledAttributes.getString(i10) == null) {
                this.mColor = -1;
            } else {
                this.mColor = Color.parseColor(typedArrayObtainStyledAttributes.getString(i10));
            }
            this.maxRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMaxRadius, 90.0f));
            this.minRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMinRadius, 25.0f));
        }
        init();
    }

    private void init() {
        this.outerPaint = new Paint();
        this.innerPaint = new Paint();
        this.centerPaint = new Paint();
        this.outerPaint.setColor(this.mColor);
        this.innerPaint.setColor(this.mColor);
        this.centerPaint.setColor(-1);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.minRadius, this.maxRadius);
        this.innerAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        this.innerAnimator.setDuration(1500L);
        this.innerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6193a.lambda$init$0(valueAnimator);
            }
        });
        this.innerAnimator.setRepeatCount(-1);
        this.innerAnimator.setRepeatMode(1);
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(this.minRadius, this.maxRadius);
        this.outerAnimator = valueAnimatorOfInt2;
        valueAnimatorOfInt2.setInterpolator(new DecelerateInterpolator());
        this.outerAnimator.setDuration(1500L);
        this.outerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6194a.lambda$init$1(valueAnimator);
            }
        });
        this.outerAnimator.setRepeatCount(-1);
        this.outerAnimator.setRepeatMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ValueAnimator valueAnimator) {
        this.innerAlpha = Integer.valueOf((int) ((1.0f - valueAnimator.getAnimatedFraction()) * 66.0f));
        this.innerRadius = ((Integer) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(ValueAnimator valueAnimator) {
        this.outerAlpha = Integer.valueOf((int) ((1.0f - valueAnimator.getAnimatedFraction()) * 66.0f));
        this.outerRadius = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.outerPaint.setAlpha(this.outerAlpha.intValue());
        this.innerPaint.setAlpha(this.innerAlpha.intValue());
        this.outerPaint.setStrokeWidth(1.5f);
        this.innerPaint.setStrokeWidth(1.5f);
        this.centerPaint.setStrokeWidth(1.5f);
        this.outerPaint.setAntiAlias(true);
        this.innerPaint.setAntiAlias(true);
        this.centerPaint.setAntiAlias(true);
        this.outerPaint.setDither(true);
        this.innerPaint.setDither(true);
        this.centerPaint.setDither(true);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, C11842p.m70840n(getContext(), 18), this.centerPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerRadius, this.outerPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.innerRadius, this.innerPaint);
    }

    public void start() {
        if (!this.control) {
            this.outerAnimator.start();
            this.innerAnimator.setStartDelay(500L);
            this.innerAnimator.start();
            this.control = true;
        }
        invalidate();
    }

    public void stop() {
        if (this.control) {
            this.outerAnimator.cancel();
            this.innerAnimator.cancel();
        }
        this.outerAlpha = 0;
        this.innerAlpha = 0;
        this.outerRadius = 0.0f;
        this.innerRadius = 0.0f;
        this.control = false;
        invalidate();
    }
}
