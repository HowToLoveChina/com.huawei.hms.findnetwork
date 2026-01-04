package com.huawei.android.remotecontrol.tag.p092ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p514o9.C11842p;

/* loaded from: classes4.dex */
public class CircleRing extends View {
    private static final long ARC_PERIOD = 3800;
    private static final long CIRCLE_PERIOD = 1000;
    public static final String TAG = "CircleRing";
    private int alphaFirstArc;
    private int alphaSecondArc;
    private int alphaThirdArc;
    private ValueAnimator animatorArc;
    private ValueAnimator animatorCircle;
    private final Context context;
    private boolean control;
    private float endAngle;
    private Paint paint;
    private Paint paintFirstArc;
    private Paint paintSecondArc;
    private Paint paintThirdArc;
    private RectF rectF;
    private RectF rectFFirstArc;
    private RectF rectFSecondArc;
    private RectF rectFThirdArc;

    public CircleRing(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alphaFirstArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.alphaSecondArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.alphaThirdArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.endAngle = 0.0f;
        this.control = false;
        this.context = context;
        initParams();
    }

    private void initParams() {
        this.rectF = new RectF(C11842p.m70844o(this.context, 3), C11842p.m70844o(this.context, 3), C11842p.m70844o(this.context, 55), C11842p.m70844o(this.context, 55));
        this.rectFFirstArc = new RectF(C11842p.m70844o(this.context, 23), C11842p.m70844o(this.context, 25), C11842p.m70844o(this.context, 31), C11842p.m70844o(this.context, 33));
        this.rectFSecondArc = new RectF(C11842p.m70844o(this.context, 17), C11842p.m70844o(this.context, 19), C11842p.m70844o(this.context, 37), C11842p.m70844o(this.context, 39));
        this.rectFThirdArc = new RectF(C11842p.m70844o(this.context, 11), C11842p.m70844o(this.context, 13), C11842p.m70844o(this.context, 43), C11842p.m70844o(this.context, 45));
        float fM70844o = C11842p.m70844o(this.context, 4);
        float fM70844o2 = C11842p.m70844o(this.context, 2);
        Paint paint = new Paint();
        this.paint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.paint.setColor(this.context.getColor(R$color.color_30_percent_white));
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setStrokeWidth(fM70844o);
        Paint paint2 = new Paint();
        this.paintFirstArc = paint2;
        paint2.setStyle(style);
        this.paintFirstArc.setColor(-1);
        this.paintFirstArc.setAntiAlias(true);
        this.paintFirstArc.setDither(true);
        this.paintFirstArc.setStrokeWidth(fM70844o2);
        Paint paint3 = new Paint();
        this.paintSecondArc = paint3;
        paint3.setStyle(style);
        this.paintSecondArc.setColor(-1);
        this.paintSecondArc.setAntiAlias(true);
        this.paintSecondArc.setDither(true);
        this.paintSecondArc.setStrokeWidth(fM70844o2);
        Paint paint4 = new Paint();
        this.paintThirdArc = paint4;
        paint4.setStyle(style);
        this.paintThirdArc.setColor(-1);
        this.paintThirdArc.setAntiAlias(true);
        this.paintThirdArc.setDither(true);
        this.paintThirdArc.setStrokeWidth(fM70844o2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.animatorCircle = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.animatorCircle.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6191a.lambda$initParams$0(valueAnimator);
            }
        });
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 3800);
        this.animatorArc = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(ARC_PERIOD);
        this.animatorArc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cg.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6192a.lambda$initParams$1(valueAnimator);
            }
        });
        this.animatorArc.setRepeatCount(-1);
        this.animatorArc.setRepeatMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initParams$0(ValueAnimator valueAnimator) {
        this.endAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initParams$1(ValueAnimator valueAnimator) {
        calculateAlphaValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2() {
        if (this.control) {
            this.animatorArc.start();
        }
    }

    public void calculateAlphaValue(int i10) {
        if (i10 < 500) {
            this.alphaFirstArc = (int) (((500 - i10) / 500.0f) * 255.0f);
        } else if (i10 < 1000) {
            this.alphaFirstArc = (int) (((i10 - 500) / 500.0f) * 255.0f);
        } else if (i10 < 1500) {
            this.alphaFirstArc = (int) (((1500 - i10) / 500.0f) * 255.0f);
        } else if (i10 < 2000) {
            this.alphaFirstArc = (int) (((i10 - 1500) / 500.0f) * 255.0f);
        } else {
            this.alphaFirstArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        }
        if (i10 < 900) {
            this.alphaSecondArc = (int) (((900 - i10) / 900.0f) * 255.0f);
        } else if (i10 < 1400) {
            this.alphaSecondArc = (int) (((i10 - 900) / 500.0f) * 255.0f);
        } else if (i10 < 1900) {
            this.alphaSecondArc = (int) (((1900 - i10) / 500.0f) * 255.0f);
        } else if (i10 < 2400) {
            this.alphaSecondArc = (int) (((i10 - 1900) / 500.0f) * 255.0f);
        } else {
            this.alphaSecondArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        }
        if (i10 < 1300) {
            this.alphaThirdArc = (int) (((PlayerConstants.ErrorCode.DRM_FAILED - i10) / 1300.0f) * 255.0f);
            return;
        }
        if (i10 < 1800) {
            this.alphaThirdArc = (int) (((i10 - PlayerConstants.ErrorCode.DRM_FAILED) / 500.0f) * 255.0f);
            return;
        }
        if (i10 < 2300) {
            this.alphaThirdArc = (int) (((2300 - i10) / 500.0f) * 255.0f);
        } else if (i10 < 2800) {
            this.alphaThirdArc = (int) (((i10 - 2300) / 500.0f) * 255.0f);
        } else {
            this.alphaThirdArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10 = this.endAngle;
        if (f10 > 0.0f) {
            canvas.drawArc(this.rectF, -90.0f, -f10, false, this.paint);
        }
        this.paintFirstArc.setAlpha(this.alphaFirstArc);
        this.paintSecondArc.setAlpha(this.alphaSecondArc);
        this.paintThirdArc.setAlpha(this.alphaThirdArc);
        canvas.drawArc(this.rectFFirstArc, -40.0f, 80.0f, false, this.paintFirstArc);
        canvas.drawArc(this.rectFSecondArc, -40.0f, 80.0f, false, this.paintSecondArc);
        canvas.drawArc(this.rectFThirdArc, -40.0f, 80.0f, false, this.paintThirdArc);
        super.onDraw(canvas);
    }

    public void start() {
        if (this.control) {
            return;
        }
        this.control = true;
        this.animatorCircle.start();
        postDelayed(new Runnable() { // from class: cg.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f6190a.lambda$start$2();
            }
        }, 1000L);
    }

    public void stop() {
        if (this.control) {
            this.control = false;
            this.endAngle = 0.0f;
            this.alphaFirstArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.alphaSecondArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.alphaThirdArc = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.animatorCircle.cancel();
            this.animatorArc.cancel();
            invalidate();
        }
    }
}
