package com.huawei.openalliance.p169ad.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class PPSCircleProgressBar extends View {

    /* renamed from: a */
    private final byte[] f36617a;

    /* renamed from: b */
    private int f36618b;

    /* renamed from: c */
    private float f36619c;

    /* renamed from: d */
    private int f36620d;

    /* renamed from: e */
    private int f36621e;

    /* renamed from: f */
    private int f36622f;

    /* renamed from: g */
    private float f36623g;

    /* renamed from: h */
    private float f36624h;

    /* renamed from: i */
    private int f36625i;

    /* renamed from: j */
    private float f36626j;

    /* renamed from: k */
    private int f36627k;

    /* renamed from: l */
    private Paint f36628l;

    /* renamed from: m */
    private String f36629m;

    /* renamed from: n */
    private Rect f36630n;

    /* renamed from: o */
    private int f36631o;

    /* renamed from: p */
    private ValueAnimator f36632p;

    /* renamed from: com.huawei.openalliance.ad.views.PPSCircleProgressBar$a */
    public enum EnumC7936a {
        LEFT(0, 180.0f),
        TOP(1, 270.0f),
        RIGHT(2, 0.0f),
        BOTTOM(3, 90.0f);


        /* renamed from: e */
        private final int f36639e;

        /* renamed from: f */
        private final float f36640f;

        EnumC7936a(int i10, float f10) {
            this.f36639e = i10;
            this.f36640f = f10;
        }

        /* renamed from: c */
        public static float m49037c(int i10) {
            EnumC7936a enumC7936aM49036b = m49036b(i10);
            if (enumC7936aM49036b == null) {
                return 0.0f;
            }
            return enumC7936aM49036b.m49040b();
        }

        /* renamed from: a */
        public int m49038a() {
            return this.f36639e;
        }

        /* renamed from: b */
        public float m49040b() {
            return this.f36640f;
        }

        /* renamed from: b */
        public static EnumC7936a m49036b(int i10) {
            for (EnumC7936a enumC7936a : values()) {
                if (enumC7936a.m49039a(i10)) {
                    return enumC7936a;
                }
            }
            return RIGHT;
        }

        /* renamed from: a */
        public boolean m49039a(int i10) {
            return this.f36639e == i10;
        }
    }

    public PPSCircleProgressBar(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m49033b(float f10) {
        synchronized (this.f36617a) {
            m49034c(f10);
        }
    }

    /* renamed from: c */
    private void m49034c(float f10) {
        synchronized (this.f36617a) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f36626j, f10);
            this.f36632p = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSCircleProgressBar.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PPSCircleProgressBar.this.f36626j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PPSCircleProgressBar.this.postInvalidate();
                }
            });
            this.f36632p.setDuration(1000L);
            this.f36632p.setInterpolator(new LinearInterpolator());
            this.f36632p.start();
        }
    }

    private int getPaddingSize() {
        int paddingStart = getPaddingStart();
        if (paddingStart <= 0) {
            paddingStart = getPaddingLeft();
        }
        int paddingEnd = getPaddingEnd();
        if (paddingEnd <= 0) {
            paddingEnd = getPaddingRight();
        }
        return paddingStart + paddingEnd;
    }

    private int getProgressBarSize() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        return width <= 0 ? layoutParams.width : width;
    }

    public String getCurrentText() {
        String str;
        synchronized (this.f36617a) {
            try {
                str = TextUtils.isEmpty(this.f36629m) ? "" : this.f36629m;
            } finally {
            }
        }
        return str;
    }

    public int getInnerColor() {
        int i10;
        synchronized (this.f36617a) {
            i10 = this.f36620d;
        }
        return i10;
    }

    public int getMaxProgress() {
        int i10;
        synchronized (this.f36617a) {
            i10 = this.f36625i;
        }
        return i10;
    }

    public int getOuterColor() {
        int i10;
        synchronized (this.f36617a) {
            i10 = this.f36618b;
        }
        return i10;
    }

    public float getOuterRadius() {
        float f10;
        synchronized (this.f36617a) {
            f10 = this.f36619c;
        }
        return f10;
    }

    public float getProgress() {
        float f10;
        synchronized (this.f36617a) {
            f10 = this.f36626j;
        }
        return f10;
    }

    public float getProgressWidth() {
        float f10;
        synchronized (this.f36617a) {
            f10 = this.f36624h;
        }
        return f10;
    }

    public int getStartPoint() {
        int i10;
        synchronized (this.f36617a) {
            i10 = this.f36627k;
        }
        return i10;
    }

    public int getTextColor() {
        int i10;
        synchronized (this.f36617a) {
            i10 = this.f36622f;
        }
        return i10;
    }

    public float getTextSize() {
        float f10;
        synchronized (this.f36617a) {
            f10 = this.f36623g;
        }
        return f10;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.f36617a) {
            try {
                super.onDraw(canvas);
                int width = getWidth() / 2;
                this.f36628l.setColor(this.f36621e);
                Paint paint = this.f36628l;
                Paint.Style style = Paint.Style.FILL;
                paint.setStyle(style);
                this.f36628l.setAntiAlias(true);
                float f10 = width;
                canvas.drawCircle(f10, f10, this.f36619c, this.f36628l);
                this.f36628l.setColor(this.f36620d);
                this.f36628l.setStyle(Paint.Style.STROKE);
                this.f36628l.setStrokeWidth(this.f36624h);
                this.f36628l.setAntiAlias(true);
                canvas.drawCircle(f10, f10, this.f36619c, this.f36628l);
                this.f36628l.setColor(this.f36618b);
                float f11 = this.f36619c;
                canvas.drawArc(new RectF(f10 - f11, f10 - f11, f10 + f11, f10 + f11), EnumC7936a.m49037c(this.f36627k), (this.f36626j / this.f36625i) * 360.0f, false, this.f36628l);
                this.f36630n = new Rect();
                this.f36628l.setColor(this.f36622f);
                this.f36628l.setStyle(style);
                this.f36628l.setTextSize(m49027a(this.f36629m, this.f36623g));
                this.f36628l.setStrokeWidth(0.0f);
                String currentText = getCurrentText();
                this.f36629m = currentText;
                this.f36628l.getTextBounds(currentText, 0, currentText.length(), this.f36630n);
                this.f36628l.setTextAlign(Paint.Align.LEFT);
                Paint.FontMetricsInt fontMetricsInt = this.f36628l.getFontMetricsInt();
                int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
                int i10 = fontMetricsInt.top;
                canvas.drawText(this.f36629m, (getMeasuredWidth() / 2) - (this.f36630n.width() / 2), ((measuredHeight + i10) / 2) - i10, this.f36628l);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("PPSCircleProgressBar", "onDraw error.");
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        synchronized (this.f36617a) {
            try {
                int size = View.MeasureSpec.getSize(i10);
                if (View.MeasureSpec.getMode(i10) != 1073741824) {
                    size = (int) ((this.f36619c * 2.0f) + this.f36624h);
                }
                int size2 = View.MeasureSpec.getSize(i11);
                if (View.MeasureSpec.getMode(i11) != 1073741824) {
                    size2 = (int) ((this.f36619c * 2.0f) + this.f36624h);
                }
                setMeasuredDimension(size, size2);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("PPSCircleProgressBar", "onMeasure error.");
            }
        }
    }

    public void setCurrentText(String str) {
        synchronized (this.f36617a) {
            this.f36629m = str;
        }
    }

    public void setInnerColor(int i10) {
        synchronized (this.f36617a) {
            this.f36620d = i10;
        }
    }

    public void setMaxProgress(int i10) {
        synchronized (this.f36617a) {
            this.f36625i = i10;
        }
    }

    public void setOuterColor(int i10) {
        synchronized (this.f36617a) {
            this.f36618b = i10;
        }
    }

    public void setOuterRadius(float f10) {
        synchronized (this.f36617a) {
            this.f36619c = f10;
        }
    }

    public void setProgress(float f10) {
        synchronized (this.f36617a) {
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            int i10 = this.f36625i;
            if (f10 > i10) {
                f10 = i10;
            }
            m49033b(f10);
        }
    }

    public void setProgressWidth(float f10) {
        synchronized (this.f36617a) {
            this.f36624h = f10;
        }
    }

    public void setStartPoint(int i10) {
        synchronized (this.f36617a) {
            this.f36627k = i10;
        }
    }

    public void setTextColor(int i10) {
        synchronized (this.f36617a) {
            this.f36622f = i10;
        }
    }

    public void setTextSize(float f10) {
        synchronized (this.f36617a) {
            this.f36623g = f10;
        }
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36617a = new byte[0];
        m49031a(context, attributeSet);
        m49029a();
    }

    /* renamed from: a */
    private float m49027a(CharSequence charSequence, float f10) {
        int paddingSize = getPaddingSize();
        int progressBarSize = getProgressBarSize();
        int iM47570d = AbstractC7741ao.m47570d(getContext(), f10);
        while (iM47570d > 10 && !m49032a(charSequence, iM47570d, paddingSize, progressBarSize)) {
            iM47570d--;
        }
        if (iM47570d <= 10 && !m49032a(charSequence, iM47570d, paddingSize, progressBarSize)) {
            this.f36629m = (String) m49028a(this.f36629m, this.f36630n.width() + getPaddingSize(), getProgressBarSize());
            this.f36628l.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f36630n);
        }
        float fM47565c = AbstractC7741ao.m47565c(getContext(), iM47570d);
        m49030a(fM47565c);
        AbstractC7185ho.m43818a("PPSCircleProgressBar", "getRightTextSize, currentSpSize: %s ", Float.valueOf(fM47565c));
        return fM47565c;
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet);
        m49031a(context, attributeSet);
        m49029a();
    }

    /* renamed from: a */
    private CharSequence m49028a(CharSequence charSequence, int i10, int i11) {
        int length = getCurrentText().length();
        int iCeil = (int) Math.ceil(((i10 - i11) / this.f36630n.width()) * length);
        int iCeil2 = (int) Math.ceil((this.f36631o * length) / this.f36630n.width());
        int i12 = length - iCeil;
        if (i12 - iCeil2 <= 0) {
            return i12 > 0 ? charSequence.toString().substring(0, i12) : charSequence;
        }
        return charSequence.toString().substring(0, length - (iCeil + iCeil2)) + "...";
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet);
        m49031a(context, attributeSet);
        m49029a();
    }

    /* renamed from: a */
    private void m49029a() {
        m49030a(this.f36623g);
    }

    /* renamed from: a */
    private void m49030a(float f10) {
        Paint paint = new Paint();
        paint.setTextSize(f10);
        Rect rect = new Rect();
        paint.getTextBounds("...", 0, 3, rect);
        this.f36631o = rect.width();
    }

    /* renamed from: a */
    public void m49035a(float f10, String str) {
        setCurrentText(str);
        setProgress(f10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.content.res.TypedArray] */
    /* renamed from: a */
    private void m49031a(Context context, AttributeSet attributeSet) {
        Resources resources;
        synchronized (this.f36617a) {
            if (attributeSet != 0) {
                try {
                    attributeSet = context.obtainStyledAttributes(attributeSet, C6849R.styleable.hiad_circle);
                    try {
                        resources = getResources();
                    } catch (UnsupportedOperationException unused) {
                        AbstractC7185ho.m43823c("PPSCircleProgressBar", "initButtonAttr UnsupportedOperationException");
                        attributeSet.recycle();
                        this.f36628l = new Paint();
                    } catch (RuntimeException unused2) {
                        AbstractC7185ho.m43823c("PPSCircleProgressBar", "initButtonAttr RuntimeException");
                        attributeSet.recycle();
                        this.f36628l = new Paint();
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43823c("PPSCircleProgressBar", "initButtonAttr error: " + th2.getClass().getSimpleName());
                        attributeSet.recycle();
                        this.f36628l = new Paint();
                    }
                    if (resources == null) {
                        AbstractC7185ho.m43823c("PPSCircleProgressBar", "init attr, resource is null");
                        attributeSet.recycle();
                        return;
                    }
                    this.f36618b = attributeSet.getColor(C6849R.styleable.hiad_circle_progress_outerColor, resources.getColor(C6849R.color.hiad_circle_outer));
                    this.f36619c = attributeSet.getDimension(C6849R.styleable.hiad_circle_progress_outerRadius, resources.getDimension(C6849R.dimen.hiad_24_dp));
                    this.f36620d = attributeSet.getColor(C6849R.styleable.hiad_circle_progress_innerColor, resources.getColor(C6849R.color.hiad_circle_inner));
                    this.f36622f = attributeSet.getColor(C6849R.styleable.hiad_circle_progress_textColor, resources.getColor(C6849R.color.hiad_circle_text));
                    this.f36621e = attributeSet.getColor(C6849R.styleable.hiad_circle_progress_fillColor, resources.getColor(C6849R.color.hiad_circle_fill));
                    this.f36623g = attributeSet.getDimension(C6849R.styleable.hiad_circle_progress_textSize, AbstractC7741ao.m47565c(context, 18.0f));
                    this.f36624h = attributeSet.getDimension(C6849R.styleable.hiad_circle_progress_progressWidth, AbstractC7741ao.m47535a(context, 2.0f));
                    this.f36626j = attributeSet.getFloat(C6849R.styleable.hiad_circle_progress_progress, 0.0f);
                    this.f36625i = attributeSet.getInt(C6849R.styleable.hiad_circle_progress_maxProgress, 100);
                    this.f36627k = attributeSet.getInt(C6849R.styleable.hiad_circle_progress_startPoint, EnumC7936a.BOTTOM.m49038a());
                    attributeSet.recycle();
                    this.f36628l = new Paint();
                } catch (Throwable th3) {
                    attributeSet.recycle();
                    throw th3;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m49032a(CharSequence charSequence, int i10, int i11, int i12) {
        float fM47565c = AbstractC7741ao.m47565c(getContext(), i10);
        if (i12 < 0) {
            return true;
        }
        this.f36628l.setTextSize(fM47565c);
        this.f36628l.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f36630n);
        return this.f36630n.width() + i11 <= i12;
    }
}
