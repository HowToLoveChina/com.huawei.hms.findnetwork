package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes4.dex */
public class BadgeHelper extends View {

    /* renamed from: a */
    public int f39233a;

    /* renamed from: b */
    public final RectF f39234b;

    /* renamed from: c */
    public int f39235c;

    /* renamed from: d */
    public int f39236d;

    public BadgeHelper(Context context) {
        super(context);
        this.f39234b = new RectF();
    }

    public int getBadgeNumber() {
        return this.f39233a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f39234b;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.bottom = getHeight();
        this.f39234b.right = getWidth();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13 = this.f39235c;
        if (i13 <= 0 || (i12 = this.f39236d) <= 0) {
            throw new IllegalStateException("如果你自定义了小红点的宽高,就不能设置其宽高小于0!");
        }
        setMeasuredDimension(i13, i12);
    }

    public void setBadgeNumber(int i10) {
        this.f39233a = i10;
        setVisibility(i10 == 0 ? 4 : 0);
        invalidate();
    }
}
