package com.huawei.phoneservice.faq.widget;

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
import com.huawei.phoneservice.faq.R$color;
import com.huawei.phoneservice.faq.R$dimen;
import com.huawei.phoneservice.faq.R$drawable;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.phoneservice.faq.widget.FaqFootOverScrollListView;

/* loaded from: classes4.dex */
public class FaqNoMoreDrawable extends Drawable implements FaqFootOverScrollListView.InterfaceC8425a {

    /* renamed from: a */
    public Paint f39303a;

    /* renamed from: b */
    public Context f39304b;

    /* renamed from: c */
    public TextPaint f39305c;

    /* renamed from: d */
    public float f39306d;

    /* renamed from: e */
    public float f39307e;

    /* renamed from: f */
    public String f39308f;

    /* renamed from: g */
    public float f39309g;

    /* renamed from: h */
    public float f39310h;

    /* renamed from: i */
    public float f39311i;

    /* renamed from: j */
    public float f39312j;

    /* renamed from: k */
    public int f39313k;

    /* renamed from: l */
    public Drawable f39314l;

    /* renamed from: m */
    public float f39315m;

    /* renamed from: n */
    public int f39316n;

    /* renamed from: o */
    public float f39317o;

    /* renamed from: p */
    public float f39318p;

    /* renamed from: q */
    public float f39319q;

    /* renamed from: r */
    public float f39320r;

    /* renamed from: s */
    public float f39321s;

    /* renamed from: t */
    public float f39322t;

    /* renamed from: u */
    public float f39323u;

    /* renamed from: v */
    public boolean f39324v;

    public FaqNoMoreDrawable(Context context) throws Resources.NotFoundException {
        this.f39304b = context;
        this.f39312j = context.getResources().getDimension(R$dimen.recommend_manual_nomoredate_line_height);
        Paint paint = new Paint(1);
        this.f39303a = paint;
        paint.setStrokeWidth(this.f39312j);
        this.f39303a.setColor(context.getResources().getColor(R$color.faq_sdk_list_item_hint_text_color_normal));
        TextPaint textPaint = new TextPaint();
        this.f39305c = textPaint;
        textPaint.setColor(context.getResources().getColor(R$color.faq_sdk_label_assist_text_color_normal));
        this.f39305c.setAntiAlias(true);
        this.f39305c.setTextSize(context.getResources().getDimension(R$dimen.recommend_manual_nomoredate_txt_font_size));
        Resources resources = context.getResources();
        int i10 = R$dimen.recommend_manual_nomoredate_img_size;
        this.f39306d = resources.getDimension(i10) + (context.getResources().getDimension(R$dimen.recommend_manual_nomoredate_img_margin_top_bottom) * 2.0f);
        this.f39313k = context.getResources().getColor(R$color.faq_sdk_grid_divider_color);
        this.f39314l = context.getResources().getDrawable(R$drawable.faq_ic_smile_gray);
        float dimension = context.getResources().getDimension(i10);
        this.f39315m = dimension;
        int i11 = (int) dimension;
        this.f39314l.setBounds(0, 0, i11, i11);
        this.f39309g = context.getResources().getDimension(R$dimen.recommend_manual_nomoredate_img_margin_start_end);
        this.f39307e = context.getResources().getDimension(R$dimen.recommend_manual_nomoredate_txt_margin_start);
        this.f39311i = context.getResources().getDimension(R$dimen.recommend_manual_nomoredate_line_width);
        String string = context.getResources().getString(R$string.faq_nomore_data);
        this.f39308f = string;
        this.f39310h = this.f39305c.measureText(string);
        this.f39324v = FaqUiUtils.isRtlLayout(context);
        this.f39316n = FaqCommonUtils.getScreenHeight(context);
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqFootOverScrollListView.InterfaceC8425a
    /* renamed from: a */
    public void mo52449a(int i10, int i11, int i12, int i13) {
        Resources resources;
        int i14;
        if (i11 > 0) {
            this.f39316n = i11;
        }
        if (this.f39304b.getResources().getConfiguration().orientation == 1) {
            resources = this.f39304b.getResources();
            i14 = R$dimen.recommend_manual_nomoredate_line_width;
        } else {
            resources = this.f39304b.getResources();
            i14 = R$dimen.recommend_manual_nomoredate_line_width_pad;
        }
        this.f39311i = resources.getDimension(i14);
    }

    /* renamed from: b */
    public final void m52453b(int i10) {
        float f10 = this.f39315m;
        float f11 = this.f39307e + f10;
        float f12 = this.f39310h;
        float f13 = i10 / 2.0f;
        float f14 = (f11 + f12) / 2.0f;
        float f15 = this.f39309g;
        float f16 = (f13 - f14) - f15;
        this.f39318p = f16;
        float f17 = this.f39306d / 2.0f;
        float f18 = f17 - (this.f39312j / 2.0f);
        this.f39319q = f18;
        float f19 = f13 + f14 + f15;
        this.f39320r = f19;
        this.f39321s = f18;
        if (this.f39324v) {
            this.f39322t = (f19 - f15) - f10;
            this.f39317o = f16 + f15;
        } else {
            this.f39322t = f16 + f15;
            this.f39317o = (f19 - f15) - f12;
        }
        this.f39323u = f17 - (f10 / 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        m52453b(bounds.width());
        float fMax = Math.max(this.f39316n, bounds.top);
        canvas.save();
        bounds.top = (int) fMax;
        canvas.clipRect(bounds);
        canvas.drawColor(this.f39313k);
        canvas.translate(0.0f, fMax);
        float f10 = this.f39318p;
        float f11 = f10 - this.f39311i;
        float f12 = this.f39319q;
        canvas.drawLine(f11, f12, f10, f12, this.f39303a);
        float f13 = this.f39320r;
        float f14 = this.f39321s;
        canvas.drawLine(f13, f14, f13 + this.f39311i, f14, this.f39303a);
        canvas.translate(this.f39322t, this.f39323u);
        this.f39314l.draw(canvas);
        canvas.translate(-this.f39322t, -this.f39323u);
        StaticLayout staticLayout = new StaticLayout(this.f39308f, this.f39305c, (int) this.f39310h, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        float height = (this.f39306d / 2.0f) - (staticLayout.getHeight() / 2.0f);
        canvas.translate(this.f39317o, height);
        staticLayout.draw(canvas);
        canvas.translate(-this.f39317o, -height);
        canvas.translate(0.0f, -fMax);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f39306d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f39306d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f39303a.setAlpha(i10);
        this.f39305c.setAlpha(i10);
        this.f39314l.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f39303a.setColorFilter(colorFilter);
        this.f39305c.setColorFilter(colorFilter);
        this.f39314l.setColorFilter(colorFilter);
    }
}
