package com.huawei.phoneservice.feedback.photolibrary.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.phoneservice.faq.base.util.FaqLogger;

/* loaded from: classes5.dex */
public class BadgeHelper extends View {

    /* renamed from: a */
    public float f39692a;

    /* renamed from: b */
    public Paint f39693b;

    /* renamed from: c */
    public int f39694c;

    /* renamed from: d */
    public final RectF f39695d;

    /* renamed from: e */
    public int f39696e;

    /* renamed from: f */
    public int f39697f;

    /* renamed from: g */
    public int f39698g;

    /* renamed from: h */
    public boolean f39699h;

    public BadgeHelper(Context context) {
        super(context);
        this.f39695d = new RectF();
        this.f39696e = -2936293;
    }

    /* renamed from: a */
    public BadgeHelper m52866a(View view) {
        m52869d();
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view == null) {
            return this;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            m52870e(view, viewGroup, iIndexOfChild);
            this.f39699h = true;
        } else if (view.getParent() == null) {
            throw new IllegalStateException("目标View不能没有父布局!");
        }
        setVisibility(this.f39694c == 0 ? 4 : 0);
        return this;
    }

    /* renamed from: b */
    public BadgeHelper m52867b(boolean z10) {
        return m52868c(z10, false);
    }

    /* renamed from: c */
    public BadgeHelper m52868c(boolean z10, boolean z11) throws Throwable {
        if (!z10 && z11) {
            FaqLogger.m51852w("BadgeHelper", "只有重叠模式isOverlap=true时，设置mIgnoreTargetPadding才生效");
        }
        return this;
    }

    /* renamed from: d */
    public final void m52869d() {
        this.f39692a = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f39693b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f39693b.setFlags(1);
        this.f39693b.setColor(this.f39696e);
        this.f39698g = Math.round(this.f39692a * 7.0f);
        this.f39697f = Math.round(this.f39692a * 7.0f);
    }

    /* renamed from: e */
    public final void m52870e(View view, ViewGroup viewGroup, int i10) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        frameLayout.setLayoutParams(layoutParams);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        viewGroup.addView(frameLayout, i10, layoutParams);
        frameLayout.addView(view);
        frameLayout.addView(this);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams2.gravity = 8388661;
        setLayoutParams(layoutParams2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f39695d;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.f39695d.bottom = getHeight();
        canvas.drawRoundRect(this.f39695d, getWidth() / 2.0f, getWidth() / 2.0f, this.f39693b);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13 = this.f39697f;
        if (i13 <= 0 || (i12 = this.f39698g) <= 0) {
            throw new IllegalStateException("如果你自定义了小红点的宽高,就不能设置其宽高小于0!");
        }
        setMeasuredDimension(i13, i12);
    }

    public void setBadgeNumber(int i10) {
        this.f39694c = i10;
        if (this.f39699h) {
            setVisibility(i10 == 0 ? 4 : 0);
            invalidate();
        }
    }
}
