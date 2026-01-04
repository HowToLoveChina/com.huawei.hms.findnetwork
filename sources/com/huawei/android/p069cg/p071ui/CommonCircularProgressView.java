package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$styleable;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.math.BigDecimal;
import java.text.NumberFormat;
import p031b7.C1120a;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class CommonCircularProgressView extends View {

    /* renamed from: a */
    public Paint f11158a;

    /* renamed from: b */
    public Paint f11159b;

    /* renamed from: c */
    public RectF f11160c;

    /* renamed from: d */
    public int[] f11161d;

    /* renamed from: e */
    public Bitmap f11162e;

    /* renamed from: f */
    public volatile int f11163f;

    public CommonCircularProgressView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static String m14683a(int i10) {
        try {
            return NumberFormat.getPercentInstance().format(new BigDecimal(i10).divide(new BigDecimal(100)).doubleValue());
        } catch (Exception unused) {
            C11839m.m70687e("CommonCircularProgressView", "getLocaleFormatNum params invalid error");
            return "";
        }
    }

    public int getProgress() {
        return this.f11163f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f11160c, 0.0f, 360.0f, false, this.f11158a);
        canvas.drawArc(this.f11160c, 275.0f, (this.f11163f * NotifyConstants.NegFeedback.DEFAULT_LIMIT) / 100.0f, false, this.f11159b);
        Paint paint = new Paint();
        C1120a.m6677i("CommonCircularProgressView", "mProgress = " + this.f11163f);
        if (this.f11163f >= 0) {
            paint.setColor(getResources().getColor(R$color.emui_black));
            String strM14683a = m14683a(this.f11163f);
            paint.setTextSize(50.0f);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(strM14683a, (getWidth() / 2) - (paint.measureText(strM14683a) / 2.0f), (getHeight() / 2) - ((fontMetricsInt.bottom + fontMetricsInt.top) / 2), paint);
        }
        if (this.f11162e != null) {
            canvas.drawBitmap(this.f11162e, ((int) this.f11160c.centerX()) - (this.f11162e.getWidth() / 2), ((int) this.f11160c.centerY()) - (this.f11162e.getHeight() / 2), new Paint());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int strokeWidth = (int) ((measuredWidth > measuredHeight ? measuredHeight : measuredWidth) - (this.f11158a.getStrokeWidth() > this.f11159b.getStrokeWidth() ? this.f11158a.getStrokeWidth() : this.f11159b.getStrokeWidth()));
        this.f11160c = new RectF(getPaddingLeft() + ((measuredWidth - strokeWidth) / 2), getPaddingTop() + ((measuredHeight - strokeWidth) / 2), r1 + strokeWidth, r9 + strokeWidth);
        int[] iArr = this.f11161d;
        if (iArr == null || iArr.length <= 1) {
            return;
        }
        this.f11159b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.f11161d, (float[]) null, Shader.TileMode.MIRROR));
    }

    public void setBackColor(int i10) {
        this.f11158a.setColor(ContextCompat.getColor(getContext(), i10));
        invalidate();
    }

    public synchronized void setProgress(int i10) {
        this.f11163f = i10;
        invalidate();
    }

    public void setProgressColor(int i10) {
        this.f11159b.setColor(ContextCompat.getColor(getContext(), i10));
        this.f11159b.setShader(null);
        invalidate();
    }

    public CommonCircularProgressView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircularProgressView);
        Paint paint = new Paint();
        this.f11158a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = this.f11158a;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        this.f11158a.setAntiAlias(true);
        this.f11158a.setDither(true);
        this.f11158a.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(R$styleable.CircularProgressView_backWidth, 5.0f));
        this.f11158a.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.CircularProgressView_backColor, getResources().getColor(R$color.circular_progress_bac)));
        Paint paint3 = new Paint();
        this.f11159b = paint3;
        paint3.setStyle(style);
        this.f11159b.setStrokeCap(cap);
        this.f11159b.setAntiAlias(true);
        this.f11159b.setDither(true);
        this.f11159b.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(R$styleable.CircularProgressView_progWidth, 10.0f));
        this.f11159b.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.CircularProgressView_progColor, getResources().getColor(R$color.circular_progress_pro)));
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.CircularProgressView_progStartColor, -1);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.CircularProgressView_progFirstColor, -1);
        if (color == -1 || color2 == -1) {
            this.f11161d = null;
        } else {
            this.f11161d = new int[]{color, color2};
        }
        this.f11163f = typedArrayObtainStyledAttributes.getInteger(R$styleable.CircularProgressView_progress, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.CircularProgressView_backImg);
        if (drawable instanceof BitmapDrawable) {
            this.f11162e = ((BitmapDrawable) drawable).getBitmap();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public CommonCircularProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
