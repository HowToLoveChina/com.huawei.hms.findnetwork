package com.huawei.android.remotecontrol.tag.p092ui.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.huawei.android.remotecontrol.sdk.R$styleable;
import p514o9.C11842p;

/* loaded from: classes4.dex */
public class SingleBlueView extends View {
    private static final int ANIMATION_DURATION = 2000;
    private static final String BLUE_WAVE_COLOR = "#6C91FD";
    private static final int CENTER_OFFSET = 90;
    public static final int COLOR_LEFT = -11492890;
    public static final int COLOR_RIGHT = -11827726;
    private static final int DEFAULT_MAX_RADIUS = 540;
    private static final int DEFAULT_MIN_RADIUS = 160;
    private static final float STROKE_WIDTH = 1.5f;
    private final float centerOffsetValue;
    private boolean control;
    private int currentMaxRadius;
    private final float finalDiameter;
    private int maxRadius;
    private int minRadius;
    private ValueAnimator outerAnimator;
    private Paint outerPaint;
    private float outerRadius;

    public SingleBlueView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.outerRadius = 0.0f;
        this.control = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MyCircleWave);
            this.maxRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMaxRadius, 540.0f));
            this.minRadius = (int) C11842p.m70844o(context, (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.MyCircleWave_MyCircleWaveMinRadius, 160.0f));
        }
        this.centerOffsetValue = C11842p.m70844o(context, 90);
        int iM70758Q = C11842p.m70758Q(context);
        int iM70752O = C11842p.m70752O(context);
        this.finalDiameter = (int) Math.sqrt((iM70758Q * iM70758Q) + (iM70752O * iM70752O));
    }

    private void initOuterAnimator(int i10, int i11) {
        Paint paint = new Paint();
        this.outerPaint = paint;
        paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), -11492890, -11827726, Shader.TileMode.REPEAT));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        this.outerAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        this.outerAnimator.setDuration(RippleView.SINGLE_RIPPLE_TIME);
        this.outerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6199a.lambda$initOuterAnimator$0(valueAnimator);
            }
        });
        this.outerAnimator.setRepeatCount(0);
        this.outerAnimator.setFloatValues(new float[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initOuterAnimator$0(ValueAnimator valueAnimator) {
        this.outerRadius = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    public void initOuterAnimatorFullScreen() {
        int iMax = Math.max(this.currentMaxRadius, this.minRadius);
        int iMax2 = Math.max((int) this.finalDiameter, this.minRadius);
        this.currentMaxRadius = iMax2;
        initOuterAnimator(iMax, iMax2);
    }

    public void initOuterAnimatorWithPercent(float f10) {
        int iMax = Math.max(this.currentMaxRadius, this.minRadius);
        int iMax2 = Math.max((int) (this.maxRadius * f10), this.minRadius);
        this.currentMaxRadius = iMax2;
        initOuterAnimator(iMax, iMax2);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.outerPaint.setStrokeWidth(STROKE_WIDTH);
        this.outerPaint.setAntiAlias(true);
        this.outerPaint.setDither(true);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerRadius, this.outerPaint);
    }

    public void start() {
        if (!this.control) {
            this.outerAnimator.start();
            this.control = true;
        }
        invalidate();
    }

    public void stop() {
        if (this.control) {
            this.outerAnimator.cancel();
        }
        this.outerRadius = 0.0f;
        this.control = false;
        invalidate();
    }
}
