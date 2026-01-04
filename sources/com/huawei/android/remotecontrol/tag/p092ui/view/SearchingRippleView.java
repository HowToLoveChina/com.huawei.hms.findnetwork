package com.huawei.android.remotecontrol.tag.p092ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.util.AttributeSet;
import com.huawei.android.remotecontrol.sdk.R$styleable;
import p514o9.C11842p;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class SearchingRippleView extends RippleView {
    private static final String TAG = "SearchingRippleView";
    private int innerAlpha;
    private ValueAnimator innerAnimator;
    private float innerCoreRadius;
    private Paint innerPaint;
    private RadialGradient innerRadial;
    private int middleAlpha;
    private ValueAnimator middleAnimator;
    private float middleCoreRadius;
    private Paint middlePaint;
    private RadialGradient middleRadial;

    public SearchingRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.middleAlpha = 0;
        this.middleCoreRadius = 0.0f;
        this.innerAlpha = 0;
        this.innerCoreRadius = 0.0f;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MyCircleWave);
            int i10 = R$styleable.MyCircleWave_MyCircleWaveColor;
            if (typedArrayObtainStyledAttributes.getString(i10) == null) {
                this.mColor = -1;
            } else {
                this.mColor = Color.parseColor(typedArrayObtainStyledAttributes.getString(i10));
            }
            this.mType = typedArrayObtainStyledAttributes.getInt(R$styleable.MyCircleWave_CircleType, 0);
            this.maxRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMaxRadius, 540.0f));
            this.minRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMinRadius, 120.0f));
        }
        init();
    }

    private void init() {
        this.outerPaint = new Paint();
        this.middlePaint = new Paint();
        this.innerPaint = new Paint();
        this.outerPaint.setColor(this.mColor);
        this.middlePaint.setColor(this.mColor);
        this.innerPaint.setColor(this.mColor);
        int i10 = this.maxRadius;
        int i11 = this.minRadius;
        float f10 = ((((i10 - i11) * 1.0f) * 3500.0f) / 2000.0f) + i11;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i11, f10);
        this.innerAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(RippleView.ONE_PERIOD_TIME);
        this.innerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6196a.lambda$init$0(valueAnimator);
            }
        });
        this.innerAnimator.setRepeatCount(-1);
        this.innerAnimator.setRepeatMode(1);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.minRadius, f10);
        this.middleAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setDuration(RippleView.ONE_PERIOD_TIME);
        this.middleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6197a.lambda$init$1(valueAnimator);
            }
        });
        this.middleAnimator.setRepeatCount(-1);
        this.middleAnimator.setRepeatMode(1);
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(this.minRadius, f10);
        this.outerAnimator = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(RippleView.ONE_PERIOD_TIME);
        this.outerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6198a.lambda$init$2(valueAnimator);
            }
        });
        this.outerAnimator.setRepeatCount(-1);
        this.outerAnimator.setRepeatMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ValueAnimator valueAnimator) {
        this.innerAlpha = calcAlpha(valueAnimator);
        float fCalcRadius = calcRadius(valueAnimator);
        this.innerCoreRadius = fCalcRadius;
        this.innerRadial = getRadialGradient(fCalcRadius);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(ValueAnimator valueAnimator) {
        this.middleAlpha = calcAlpha(valueAnimator);
        float fCalcRadius = calcRadius(valueAnimator);
        this.middleCoreRadius = fCalcRadius;
        this.middleRadial = getRadialGradient(fCalcRadius);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(ValueAnimator valueAnimator) {
        this.outerAlpha = calcAlpha(valueAnimator);
        float fCalcRadius = calcRadius(valueAnimator);
        this.outerCoreRadius = fCalcRadius;
        this.outerRadial = getRadialGradient(fCalcRadius);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.mType;
        if (i10 == 0) {
            this.outerPaint.setAlpha(this.outerAlpha);
            this.middlePaint.setAlpha(this.middleAlpha);
            this.innerPaint.setAlpha(this.innerAlpha);
            this.outerPaint.setStrokeWidth(1.5f);
            this.middlePaint.setStrokeWidth(1.5f);
            this.innerPaint.setStrokeWidth(1.5f);
            Paint paint = this.outerPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            this.middlePaint.setStyle(style);
            this.innerPaint.setStyle(style);
            this.outerPaint.setAntiAlias(true);
            this.middlePaint.setAntiAlias(true);
            this.innerPaint.setAntiAlias(true);
            this.outerPaint.setDither(true);
            this.middlePaint.setDither(true);
            this.innerPaint.setDither(true);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerCoreRadius, this.outerPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.middleCoreRadius, this.middlePaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.innerCoreRadius, this.innerPaint);
            return;
        }
        if (i10 == 1) {
            this.outerPaint.setShader(this.outerRadial);
            this.middlePaint.setShader(this.middleRadial);
            this.innerPaint.setShader(this.innerRadial);
            this.outerPaint.setAlpha(this.outerAlpha);
            this.middlePaint.setAlpha(this.middleAlpha);
            this.innerPaint.setAlpha(this.innerAlpha);
            this.outerPaint.setStrokeWidth(1.5f);
            this.middlePaint.setStrokeWidth(1.5f);
            this.innerPaint.setStrokeWidth(1.5f);
            this.outerPaint.setAntiAlias(true);
            this.middlePaint.setAntiAlias(true);
            this.innerPaint.setAntiAlias(true);
            this.outerPaint.setDither(true);
            this.middlePaint.setDither(true);
            this.innerPaint.setDither(true);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerCoreRadius, this.outerPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.middleCoreRadius, this.middlePaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.innerCoreRadius, this.innerPaint);
        }
    }

    public void start() {
        if (!this.control) {
            this.outerAnimator.setStartDelay(1000L);
            this.outerAnimator.start();
            this.middleAnimator.setStartDelay(1500L);
            this.middleAnimator.start();
            this.innerAnimator.setStartDelay(RippleView.SINGLE_RIPPLE_TIME);
            this.innerAnimator.start();
            this.control = true;
        }
        invalidate();
    }

    public void stop() {
        if (this.control) {
            try {
                this.outerAnimator.cancel();
                this.middleAnimator.cancel();
                this.innerAnimator.cancel();
            } catch (Exception unused) {
                C13981a.m83988e(TAG, "Exception");
            }
        }
        this.control = false;
        this.outerAlpha = 0;
        this.middleAlpha = 0;
        this.innerAlpha = 0;
        this.outerCoreRadius = 0.0f;
        this.middleCoreRadius = 0.0f;
        this.innerCoreRadius = 0.0f;
        invalidate();
    }
}
