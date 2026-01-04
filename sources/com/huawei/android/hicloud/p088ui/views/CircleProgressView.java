package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes3.dex */
public class CircleProgressView extends View {

    /* renamed from: a */
    public Paint f19383a;

    /* renamed from: b */
    public Paint f19384b;

    /* renamed from: c */
    public Paint f19385c;

    /* renamed from: d */
    public boolean f19386d;

    /* renamed from: e */
    public RectF f19387e;

    /* renamed from: f */
    public int f19388f;

    /* renamed from: g */
    public CircleProgressListener f19389g;

    public interface CircleProgressListener {
        void onSuccess();
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m25694a() {
        Paint paint = new Paint();
        this.f19383a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f19383a.setAntiAlias(true);
        Paint paint2 = this.f19383a;
        Resources resources = getResources();
        int i10 = R$dimen.progressbar_align_textview_margin;
        paint2.setStrokeWidth(resources.getDimension(i10));
        this.f19383a.setColor(getResources().getColor(R$color.bc_black_dark_mode));
        Paint paint3 = new Paint();
        this.f19384b = paint3;
        paint3.setStyle(style);
        Paint paint4 = this.f19384b;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint4.setStrokeCap(cap);
        this.f19384b.setAntiAlias(true);
        this.f19384b.setStrokeWidth(getResources().getDimension(i10));
        Paint paint5 = this.f19384b;
        Resources resources2 = getResources();
        int i11 = R$color.bc_circle_progress_color;
        paint5.setColor(resources2.getColor(i11));
        this.f19384b.setFilterBitmap(true);
        Paint paint6 = new Paint();
        this.f19385c = paint6;
        paint6.setStyle(style);
        this.f19385c.setStrokeCap(cap);
        this.f19385c.setStrokeWidth(getResources().getDimension(i10));
        this.f19385c.setColor(getResources().getColor(i11));
        this.f19385c.setAntiAlias(true);
        this.f19385c.setFilterBitmap(true);
        this.f19386d = false;
    }

    /* renamed from: b */
    public void m25695b() {
        setProgress(0);
        this.f19386d = false;
    }

    public CircleProgressListener getProgressListener() {
        return this.f19389g;
    }

    public int getmProgress() {
        return this.f19388f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f19387e, 270.0f, 360.0f, false, this.f19383a);
        canvas.drawArc(this.f19387e, 270.0f, (this.f19388f * NotifyConstants.NegFeedback.DEFAULT_LIMIT) / 100.0f, false, this.f19384b);
        if (this.f19388f == 100) {
            canvas.drawArc(this.f19387e, 270.0f, 360.0f, false, this.f19385c);
            CircleProgressListener circleProgressListener = this.f19389g;
            if (circleProgressListener == null || this.f19386d) {
                return;
            }
            circleProgressListener.onSuccess();
            this.f19386d = true;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int strokeWidth = ((int) ((measuredWidth > measuredHeight ? measuredHeight : measuredWidth) - this.f19384b.getStrokeWidth())) - 2;
        this.f19387e = new RectF(getPaddingLeft() + 1 + ((measuredWidth - strokeWidth) / 2), getPaddingTop() + 1 + ((measuredHeight - strokeWidth) / 2), r1 + strokeWidth, r5 + strokeWidth);
    }

    public void setProgress(int i10) {
        if (i10 > 100) {
            return;
        }
        this.f19388f = i10;
        invalidate();
    }

    public void setProgressListener(CircleProgressListener circleProgressListener) {
        this.f19389g = circleProgressListener;
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19386d = false;
        m25694a();
    }
}
