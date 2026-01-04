package com.huawei.phoneservice.feedback.mvp.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.phoneservice.feedback.R$color;
import com.huawei.phoneservice.feedback.R$dimen;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackFootOverScrollListView;

/* loaded from: classes5.dex */
public class FeedbackNoMoreDrawable extends Drawable implements FeedbackFootOverScrollListView.InterfaceC8491a {

    /* renamed from: a */
    public Context f39615a;

    /* renamed from: b */
    public Paint f39616b;

    /* renamed from: c */
    public TextPaint f39617c;

    /* renamed from: d */
    public float f39618d;

    /* renamed from: e */
    public String f39619e;

    /* renamed from: f */
    public float f39620f;

    /* renamed from: g */
    public float f39621g;

    /* renamed from: h */
    public float f39622h;

    /* renamed from: i */
    public Drawable f39623i;

    /* renamed from: j */
    public float f39624j;

    /* renamed from: k */
    public float f39625k;

    /* renamed from: l */
    public float f39626l;

    /* renamed from: m */
    public float f39627m;

    /* renamed from: n */
    public float f39628n;

    /* renamed from: o */
    public float f39629o;

    /* renamed from: p */
    public float f39630p;

    /* renamed from: q */
    public float f39631q;

    /* renamed from: r */
    public float f39632r;

    /* renamed from: s */
    public float f39633s;

    /* renamed from: t */
    public boolean f39634t;

    /* renamed from: u */
    public int f39635u;

    public FeedbackNoMoreDrawable(Context context) throws Resources.NotFoundException {
        this.f39615a = context;
        this.f39626l = context.getResources().getDimension(R$dimen.feedback_sdk_nomoredate_line_height);
        Paint paint = new Paint(1);
        this.f39616b = paint;
        paint.setStrokeWidth(this.f39626l);
        this.f39616b.setColor(context.getResources().getColor(R$color.feedback_sdk_list_item_hint_text_color_normal));
        TextPaint textPaint = new TextPaint();
        this.f39617c = textPaint;
        textPaint.setColor(context.getResources().getColor(R$color.feedback_sdk_label_assist_text_color_normal));
        this.f39617c.setAntiAlias(true);
        this.f39617c.setTextSize(context.getResources().getDimension(R$dimen.feedback_sdk_nomoredate_txt_font_size));
        Resources resources = context.getResources();
        int i10 = R$dimen.feedback_sdk_nomoredate_img_size;
        this.f39618d = resources.getDimension(i10) + (context.getResources().getDimension(R$dimen.feedback_sdk_nomoredate_img_margin_top_bottom) * 2.0f);
        this.f39623i = context.getResources().getDrawable(R$drawable.feedback_ic_smile_gray);
        float dimension = context.getResources().getDimension(i10);
        this.f39624j = dimension;
        int i11 = (int) dimension;
        this.f39623i.setBounds(0, 0, i11, i11);
        this.f39621g = context.getResources().getDimension(R$dimen.feedback_sdk_nomoredate_img_margin_start_end);
        this.f39620f = context.getResources().getDimension(R$dimen.feedback_sdk_nomoredate_txt_margin_start);
        this.f39625k = context.getResources().getDimension(R$dimen.feedback_sdk_nomoredate_line_width);
        String string = context.getResources().getString(R$string.feedback_sdk_nomore_data);
        this.f39619e = string;
        this.f39622h = this.f39617c.measureText(string);
        this.f39634t = FaqUiUtils.isRtlLayout(context);
        this.f39635u = FaqCommonUtils.getScreenHeight(context);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackFootOverScrollListView.InterfaceC8491a
    /* renamed from: a */
    public void mo52752a(int i10, int i11, int i12, int i13) {
        Resources resources;
        int i14;
        if (i11 > 0) {
            this.f39635u = i11;
        }
        if (this.f39615a.getResources().getConfiguration().orientation == 1) {
            resources = this.f39615a.getResources();
            i14 = R$dimen.feedback_sdk_nomoredate_line_width;
        } else {
            resources = this.f39615a.getResources();
            i14 = R$dimen.feedback_sdk_nomoredate_line_width_pad;
        }
        this.f39625k = resources.getDimension(i14);
    }

    /* renamed from: b */
    public final void m52753b(int i10) {
        float f10 = this.f39624j;
        float f11 = this.f39620f + f10;
        float f12 = this.f39622h;
        float f13 = i10 / 2.0f;
        float f14 = (f11 + f12) / 2.0f;
        float f15 = this.f39621g;
        float f16 = (f13 - f14) - f15;
        this.f39627m = f16;
        float f17 = this.f39618d / 2.0f;
        float f18 = f17 - (this.f39626l / 2.0f);
        this.f39628n = f18;
        float f19 = f13 + f14 + f15;
        this.f39629o = f19;
        this.f39630p = f18;
        if (this.f39634t) {
            this.f39631q = (f19 - f15) - f10;
            this.f39633s = f16 + f15;
        } else {
            this.f39631q = f16 + f15;
            this.f39633s = (f19 - f15) - f12;
        }
        this.f39632r = f17 - (f10 / 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        m52753b(bounds.width());
        float fMax = Math.max(this.f39635u, bounds.top);
        canvas.save();
        bounds.top = (int) fMax;
        canvas.clipRect(bounds);
        canvas.translate(0.0f, fMax);
        float f10 = this.f39627m;
        float f11 = f10 - this.f39625k;
        float f12 = this.f39628n;
        canvas.drawLine(f11, f12, f10, f12, this.f39616b);
        float f13 = this.f39629o;
        float f14 = this.f39630p;
        canvas.drawLine(f13, f14, f13 + this.f39625k, f14, this.f39616b);
        canvas.translate(this.f39631q, this.f39632r);
        this.f39623i.draw(canvas);
        canvas.translate(-this.f39631q, -this.f39632r);
        StaticLayout staticLayout = new StaticLayout(this.f39619e, this.f39617c, (int) this.f39622h, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        float height = (this.f39618d / 2.0f) - (staticLayout.getHeight() / 2.0f);
        canvas.translate(this.f39633s, height);
        staticLayout.draw(canvas);
        canvas.translate(-this.f39633s, -height);
        canvas.translate(0.0f, -fMax);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f39618d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f39618d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f39616b.setAlpha(i10);
        this.f39617c.setAlpha(i10);
        this.f39623i.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f39616b.setColorFilter(colorFilter);
        this.f39617c.setColorFilter(colorFilter);
        this.f39623i.setColorFilter(colorFilter);
    }
}
