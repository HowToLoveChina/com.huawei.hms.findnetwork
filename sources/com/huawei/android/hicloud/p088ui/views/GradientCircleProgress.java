package com.huawei.android.hicloud.p088ui.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import aq.C1011a;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Locale;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class GradientCircleProgress extends View {

    /* renamed from: A */
    public LinearGradient f19464A;

    /* renamed from: B */
    public String f19465B;

    /* renamed from: C */
    public boolean f19466C;

    /* renamed from: a */
    public final Paint f19467a;

    /* renamed from: b */
    public final Paint f19468b;

    /* renamed from: c */
    public final Paint f19469c;

    /* renamed from: d */
    public final Paint f19470d;

    /* renamed from: e */
    public int f19471e;

    /* renamed from: f */
    public int f19472f;

    /* renamed from: g */
    public float f19473g;

    /* renamed from: h */
    public int f19474h;

    /* renamed from: i */
    public int f19475i;

    /* renamed from: j */
    public int f19476j;

    /* renamed from: k */
    public int f19477k;

    /* renamed from: l */
    public float f19478l;

    /* renamed from: m */
    public int f19479m;

    /* renamed from: n */
    public float f19480n;

    /* renamed from: o */
    public int f19481o;

    /* renamed from: p */
    public int f19482p;

    /* renamed from: q */
    public float f19483q;

    /* renamed from: r */
    public float f19484r;

    /* renamed from: s */
    public float f19485s;

    /* renamed from: t */
    public float f19486t;

    /* renamed from: u */
    public float f19487u;

    /* renamed from: v */
    public RectF f19488v;

    /* renamed from: w */
    public int f19489w;

    /* renamed from: x */
    public int f19490x;

    /* renamed from: y */
    public SweepGradient f19491y;

    /* renamed from: z */
    public SweepGradient f19492z;

    public GradientCircleProgress(Context context) {
        this(context, null);
    }

    private int getPercent() {
        int i10 = this.f19481o;
        if (i10 <= 0) {
            return 0;
        }
        return (this.f19482p * 100) / i10;
    }

    /* renamed from: b */
    public final int m25767b(int i10) {
        int i11 = this.f19481o;
        if (i11 <= 0) {
            return 0;
        }
        return (i10 * NotifyConstants.NegFeedback.DEFAULT_LIMIT) / i11;
    }

    /* renamed from: c */
    public final void m25768c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GradientCircleProgress);
        this.f19471e = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientCircleProgress_gcp_circleColor, context.getColor(R$color.storage_progress_circle_bg));
        int i10 = R$styleable.GradientCircleProgress_gcp_progressColor;
        int i11 = R$color.storage_progress_circle_start;
        this.f19472f = typedArrayObtainStyledAttributes.getColor(i10, context.getColor(i11));
        this.f19473g = typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientCircleProgress_gcp_progressWidth, 12.0f);
        this.f19474h = typedArrayObtainStyledAttributes.getInt(R$styleable.GradientCircleProgress_gcp_startAngle, -90);
        this.f19475i = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientCircleProgress_gcp_startColor, context.getColor(i11));
        this.f19476j = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientCircleProgress_gcp_endColor, context.getColor(R$color.storage_progress_circle_end));
        this.f19481o = typedArrayObtainStyledAttributes.getInteger(R$styleable.GradientCircleProgress_gcp_max, 100);
        this.f19482p = typedArrayObtainStyledAttributes.getInteger(R$styleable.GradientCircleProgress_gcp_progress, 0);
        this.f19477k = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientCircleProgress_gcp_textColor, context.getColor(R$color.emui_color_text_primary));
        this.f19478l = typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientCircleProgress_gcp_textSize, 10.0f);
        this.f19479m = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientCircleProgress_gcp_symbolColor, context.getColor(R$color.emui_color_text_secondary));
        this.f19480n = typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientCircleProgress_gcp_symbolSize, 4.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f19489w = context.getColor(R$color.storage_progress_circle_full_start);
        this.f19490x = context.getColor(R$color.storage_progress_circle_full_end);
        this.f19465B = C1011a.m6161a();
        this.f19466C = m25769d();
        Paint paint = this.f19468b;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f19468b.setStrokeWidth(10.0f);
        this.f19468b.setAntiAlias(true);
        Paint paint2 = this.f19468b;
        Typeface typeface = Typeface.DEFAULT;
        paint2.setTypeface(typeface);
        this.f19469c.setStyle(style);
        this.f19469c.setStrokeWidth(10.0f);
        this.f19469c.setAntiAlias(true);
        this.f19469c.setTypeface(typeface);
    }

    /* renamed from: d */
    public final boolean m25769d() {
        return Locale.getDefault().getLanguage().contains(Constants.AR_CACHE);
    }

    /* renamed from: e */
    public final /* synthetic */ void m25770e(ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            int iIntValue = ((Integer) animatedValue).intValue();
            int i10 = this.f19482p;
            if (iIntValue > i10) {
                this.f19483q = 1.0f;
            } else if (i10 <= 0) {
                this.f19483q = 0.0f;
            } else {
                this.f19483q = iIntValue / i10;
            }
            C11839m.m70686d("GradientCircleProgress", "value: " + iIntValue + ", progressValue: " + this.f19483q);
            postInvalidate();
        }
    }

    /* renamed from: f */
    public final void m25771f() {
        C11839m.m70686d("GradientCircleProgress", "setProgress: " + this.f19482p);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.f19482p);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: de.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f45850a.m25770e(valueAnimator);
            }
        });
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        int i10 = this.f19482p;
        if (i10 < 3) {
            valueAnimatorOfInt.setDuration(0L);
        } else if (i10 < 10) {
            valueAnimatorOfInt.setDuration(500L);
        } else {
            valueAnimatorOfInt.setDuration(1000L);
        }
        valueAnimatorOfInt.start();
    }

    public int getMax() {
        return Math.max(this.f19481o, 0);
    }

    public int getProgress() {
        return this.f19482p;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint = this.f19467a;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f19467a.setStrokeWidth(this.f19473g);
        this.f19467a.setAntiAlias(true);
        this.f19467a.setColor(this.f19471e);
        canvas.drawCircle(this.f19484r, this.f19485s, this.f19487u, this.f19467a);
        this.f19468b.setColor(this.f19477k);
        this.f19468b.setTextSize(this.f19478l);
        this.f19469c.setColor(this.f19479m);
        this.f19469c.setTextSize(this.f19480n);
        String strM6163c = C1011a.m6163c(Integer.valueOf((int) (getPercent() * this.f19483q)));
        String str = strM6163c + this.f19465B;
        float fMeasureText = this.f19468b.measureText(strM6163c);
        float fMeasureText2 = this.f19468b.measureText(str);
        if (this.f19466C) {
            canvas.drawText(strM6163c, ((this.f19484r - (fMeasureText2 / 2.0f)) * 1.1f) + this.f19469c.measureText(this.f19465B), this.f19485s * 1.14f, this.f19468b);
        } else {
            canvas.drawText(strM6163c, (this.f19484r - (fMeasureText2 / 2.0f)) * 1.1f, this.f19485s * 1.14f, this.f19468b);
        }
        if (this.f19466C) {
            canvas.drawText(this.f19465B, (this.f19484r - (fMeasureText2 / 2.0f)) * 1.1f, this.f19485s * 1.14f, this.f19469c);
        } else {
            canvas.drawText(this.f19465B, ((this.f19484r - (fMeasureText2 / 2.0f)) * 1.1f) + fMeasureText, this.f19485s * 1.14f, this.f19469c);
        }
        canvas.save();
        int i10 = this.f19482p;
        if (i10 == this.f19481o) {
            canvas.rotate(this.f19474h, this.f19484r, this.f19485s);
            this.f19470d.setStyle(style);
            this.f19470d.setStrokeCap(Paint.Cap.ROUND);
            this.f19470d.setStrokeWidth(this.f19473g);
            this.f19470d.setAntiAlias(true);
            this.f19470d.setColor(this.f19472f);
            if (this.f19464A == null) {
                RectF rectF = this.f19488v;
                float f10 = rectF.right;
                float f11 = rectF.bottom;
                this.f19464A = new LinearGradient(f10, f11, 0.0f, f11, this.f19489w, this.f19490x, Shader.TileMode.MIRROR);
            }
            this.f19470d.setShader(this.f19464A);
            canvas.drawArc(this.f19488v, 0.0f, this.f19483q * 360.0f, false, this.f19470d);
        } else {
            int iM25767b = m25767b(i10);
            int i11 = this.f19482p;
            if (i11 < 10) {
                if (this.f19491y == null) {
                    float f12 = this.f19484r;
                    float f13 = this.f19485s;
                    int i12 = this.f19475i;
                    this.f19491y = new SweepGradient(f12, f13, i12, i12);
                }
                this.f19470d.setShader(this.f19491y);
            } else {
                if (i11 > 97) {
                    iM25767b = m25767b(97);
                } else if (i11 >= 50 && i11 <= 55) {
                    iM25767b = m25767b(i11 + 2);
                }
                if (this.f19492z == null) {
                    this.f19492z = new SweepGradient(this.f19484r, this.f19485s, this.f19475i, this.f19476j);
                }
                this.f19470d.setShader(this.f19492z);
                i11 = 15;
            }
            canvas.rotate(this.f19474h - i11, this.f19484r, this.f19485s);
            this.f19470d.setStyle(style);
            this.f19470d.setStrokeCap(Paint.Cap.ROUND);
            this.f19470d.setStrokeWidth(this.f19473g);
            this.f19470d.setAntiAlias(true);
            this.f19470d.setColor(this.f19472f);
            canvas.drawArc(this.f19488v, i11, (iM25767b - i11) * this.f19483q, false, this.f19470d);
            canvas.rotate(-(this.f19474h - i11), this.f19484r, this.f19485s);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f19484r = i10 / 2.0f;
        this.f19485s = i11 / 2.0f;
        float fMin = Math.min(i10, i11) / 2.0f;
        this.f19486t = fMin;
        this.f19487u = fMin - this.f19473g;
        float f10 = this.f19484r;
        float f11 = this.f19487u;
        float f12 = this.f19485s;
        this.f19488v = new RectF(f10 - f11, f12 - f11, f10 + f11, f12 + f11);
        float f13 = this.f19487u;
        this.f19478l = f13 / 1.8f;
        this.f19480n = f13 / 3.0f;
    }

    public void setMax(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f19481o = i10;
    }

    public void setProgress(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.f19481o;
        if (i10 > i11) {
            i10 = i11;
        }
        if (i10 != i11) {
            if (this.f19491y == null) {
                float f10 = this.f19484r;
                float f11 = this.f19485s;
                int i12 = this.f19475i;
                this.f19491y = new SweepGradient(f10, f11, i12, i12);
            }
            if (this.f19492z == null) {
                this.f19492z = new SweepGradient(this.f19484r, this.f19485s, this.f19475i, this.f19476j);
            }
        } else if (this.f19464A == null) {
            RectF rectF = this.f19488v;
            float f12 = rectF.right;
            float f13 = rectF.bottom;
            this.f19464A = new LinearGradient(f12, f13, 0.0f, f13, this.f19489w, this.f19490x, Shader.TileMode.MIRROR);
        }
        this.f19482p = i10;
        m25771f();
    }

    public GradientCircleProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientCircleProgress(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19467a = new Paint();
        this.f19468b = new Paint();
        this.f19469c = new Paint();
        this.f19470d = new Paint();
        m25768c(context, attributeSet);
    }
}
