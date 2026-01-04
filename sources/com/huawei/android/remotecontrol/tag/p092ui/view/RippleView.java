package com.huawei.android.remotecontrol.tag.p092ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes4.dex */
public class RippleView extends View {
    public static final long COLOR_CHANGE_TIME = 400;
    public static final int HOLLOWED = 0;
    public static final long ONE_PERIOD_TIME = 3500;
    public static final long SINGLE_RIPPLE_TIME = 2000;
    public static final int SOLID = 1;
    public boolean control;
    public int mColor;
    public int mType;
    public double maxOpacity;
    public int maxRadius;
    public int minRadius;
    public int outerAlpha;
    public ValueAnimator outerAnimator;
    public float outerCoreRadius;
    public Paint outerPaint;
    public RadialGradient outerRadial;
    public static final float[] POSITION = {0.0f, 0.75f, 0.9f, 1.0f};
    public static final int[] COLORS = {16777215, 134217727, -1711276033, -637534209};

    public RippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.outerAlpha = 0;
        this.outerCoreRadius = 0.0f;
        this.control = false;
        this.maxOpacity = 0.1d;
    }

    public int calcAlpha(ValueAnimator valueAnimator) {
        double d10;
        double d11;
        long currentPlayTime = valueAnimator.getCurrentPlayTime() % ONE_PERIOD_TIME;
        double d12 = this.maxOpacity;
        double d13 = d12 / 400.0d;
        if (currentPlayTime < 400) {
            d10 = d13 * 255.0d;
            d11 = currentPlayTime;
        } else {
            if (currentPlayTime <= 1600) {
                return (int) (d12 * 255.0d);
            }
            if (currentPlayTime > SINGLE_RIPPLE_TIME) {
                return 0;
            }
            d10 = d13 * 255.0d;
            d11 = SINGLE_RIPPLE_TIME - currentPlayTime;
        }
        return (int) (d10 * d11);
    }

    public float calcRadius(ValueAnimator valueAnimator) {
        if (valueAnimator.getCurrentPlayTime() % ONE_PERIOD_TIME <= SINGLE_RIPPLE_TIME) {
            return ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
        return 0.0f;
    }

    public RadialGradient getRadialGradient(float f10) {
        if (f10 == 0.0f) {
            return null;
        }
        return new RadialGradient(getWidth() / 2.0f, getHeight() / 2.0f, f10, COLORS, POSITION, Shader.TileMode.CLAMP);
    }
}
