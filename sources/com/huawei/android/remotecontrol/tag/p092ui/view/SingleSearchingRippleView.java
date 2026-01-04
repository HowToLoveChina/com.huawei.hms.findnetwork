package com.huawei.android.remotecontrol.tag.p092ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.huawei.android.remotecontrol.sdk.R$styleable;
import p514o9.C11842p;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class SingleSearchingRippleView extends RippleView {
    private static final int DEFAULT_MAX_RADIUS = 440;
    private static final int DEFAULT_MIN_RADIUS = 180;
    private static final int START_DELAY = 1000;
    private static final float STROKE_WIDTH = 1.5f;
    private static final String TAG = "SingleSearchingRippleView";

    public SingleSearchingRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MyCircleWave);
            int i10 = R$styleable.MyCircleWave_MyCircleWaveColor;
            if (typedArrayObtainStyledAttributes.getString(i10) == null) {
                this.mColor = -1;
            } else {
                this.mColor = Color.parseColor(typedArrayObtainStyledAttributes.getString(i10));
            }
            this.mType = typedArrayObtainStyledAttributes.getInt(R$styleable.MyCircleWave_CircleType, 0);
            this.maxRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMaxRadius, 440.0f));
            this.minRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMinRadius, 180.0f));
        }
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.outerPaint = paint;
        paint.setColor(this.mColor);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.minRadius, this.maxRadius);
        this.outerAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(RippleView.ONE_PERIOD_TIME);
        this.outerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6200a.lambda$init$0(valueAnimator);
            }
        });
        this.outerAnimator.setRepeatCount(-1);
        this.outerAnimator.setRepeatMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ValueAnimator valueAnimator) {
        this.outerAlpha = calcAlpha(valueAnimator);
        float fCalcRadius = calcRadius(valueAnimator);
        this.outerCoreRadius = fCalcRadius;
        this.outerRadial = getRadialGradient(fCalcRadius);
        invalidate();
    }

    public double getMaxOpacity() {
        return this.maxOpacity;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.mType;
        if (i10 == 0) {
            this.outerPaint.setAlpha(this.outerAlpha);
            this.outerPaint.setStrokeWidth(STROKE_WIDTH);
            this.outerPaint.setStyle(Paint.Style.STROKE);
            this.outerPaint.setAntiAlias(true);
            this.outerPaint.setDither(true);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerCoreRadius, this.outerPaint);
            return;
        }
        if (i10 == 1) {
            this.outerPaint.setShader(this.outerRadial);
            this.outerPaint.setAlpha(this.outerAlpha);
            this.outerPaint.setStrokeWidth(STROKE_WIDTH);
            this.outerPaint.setAntiAlias(true);
            this.outerPaint.setDither(true);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerCoreRadius, this.outerPaint);
        }
    }

    public void setMaxOpacity(double d10) {
        this.maxOpacity = d10;
    }

    public void start() {
        ValueAnimator valueAnimator;
        if (!this.control && (valueAnimator = this.outerAnimator) != null) {
            valueAnimator.setStartDelay(1000L);
            this.outerAnimator.start();
            this.control = true;
        }
        invalidate();
    }

    public void stop() {
        ValueAnimator valueAnimator;
        if (this.control && (valueAnimator = this.outerAnimator) != null) {
            try {
                valueAnimator.cancel();
            } catch (Exception unused) {
                C13981a.m83988e(TAG, "Exception");
            }
        }
        this.control = false;
        this.outerAlpha = 0;
        this.outerCoreRadius = 0.0f;
        invalidate();
    }
}
