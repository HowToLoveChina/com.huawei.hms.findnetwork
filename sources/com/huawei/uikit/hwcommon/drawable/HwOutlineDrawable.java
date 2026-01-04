package com.huawei.uikit.hwcommon.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.huawei.uikit.hwcommon.C8709R;

@TargetApi(26)
/* loaded from: classes7.dex */
public class HwOutlineDrawable extends DrawableWrapper {

    /* renamed from: n */
    private static final String f42071n = "HwOutlineDrawable";

    /* renamed from: o */
    private static final int f42072o = -16744961;

    /* renamed from: p */
    private static final int f42073p = 4;

    /* renamed from: q */
    private static final int f42074q = 255;

    /* renamed from: r */
    private static final int f42075r = 4;

    /* renamed from: s */
    private static final float f42076s = 2.0f;

    /* renamed from: t */
    private static final float f42077t = 0.5f;

    /* renamed from: u */
    private static final float f42078u = Float.NEGATIVE_INFINITY;

    /* renamed from: a */
    private int f42079a;

    /* renamed from: b */
    private int f42080b;

    /* renamed from: c */
    private int f42081c;

    /* renamed from: d */
    private int f42082d;

    /* renamed from: e */
    private boolean f42083e;

    /* renamed from: f */
    private float f42084f;

    /* renamed from: g */
    private float f42085g;

    /* renamed from: h */
    private float f42086h;

    /* renamed from: i */
    private Rect f42087i;

    /* renamed from: j */
    private Rect f42088j;

    /* renamed from: k */
    private View f42089k;

    /* renamed from: l */
    private Paint f42090l;

    /* renamed from: m */
    private Path f42091m;

    public HwOutlineDrawable(Context context, Drawable drawable, View view, boolean z10) {
        super(drawable instanceof HwDrawableWrapper ? ((HwDrawableWrapper) drawable).getDrawable() : drawable);
        this.f42079a = -16744961;
        this.f42082d = 0;
        this.f42084f = f42078u;
        this.f42085g = f42078u;
        this.f42087i = new Rect(0, 0, 0, 0);
        this.f42088j = new Rect(0, 0, 0, 0);
        this.f42090l = new Paint();
        this.f42091m = new Path();
        if (context != null) {
            Resources resources = context.getResources();
            this.f42086h = resources.getDisplayMetrics().density;
            this.f42079a = resources.getColor(C8709R.color.emui_accent, null);
        }
        this.f42089k = view;
        this.f42083e = z10;
        this.f42081c = z10 ? (int) ((this.f42086h * 4.0f) + f42077t) : 0;
        this.f42080b = (int) ((this.f42086h * 4.0f) + f42077t);
        this.f42090l.setStrokeJoin(Paint.Join.ROUND);
        this.f42090l.setStrokeCap(Paint.Cap.ROUND);
        this.f42090l.setAntiAlias(true);
        this.f42090l.setStyle(Paint.Style.STROKE);
        this.f42090l.setColor(this.f42079a);
        this.f42090l.setShader(null);
        this.f42090l.setStrokeWidth(this.f42080b);
        this.f42090l.setAlpha(255);
    }

    /* renamed from: a */
    private void m54215a(ViewOutlineProvider viewOutlineProvider, View view, int i10, Rect rect, Path path) {
        if (viewOutlineProvider == null || view == null || path == null || rect == null) {
            return;
        }
        Outline outline = new Outline();
        viewOutlineProvider.getOutline(view, outline);
        float radius = outline.getRadius();
        if (!Float.isInfinite(this.f42084f)) {
            radius = this.f42084f;
        }
        Rect rect2 = new Rect();
        outline.getRect(rect2);
        int i11 = rect2.left;
        Rect rect3 = this.f42087i;
        rect2.left = i11 + rect3.left;
        rect2.top += rect3.top;
        rect2.right += rect3.right;
        rect2.bottom += rect3.bottom;
        Rect rect4 = new Rect(rect2.left - i10, rect2.top - i10, rect2.right + i10, rect2.bottom + i10);
        if (rect4.equals(rect) && i10 == this.f42082d && radius == this.f42085g) {
            return;
        }
        RectF rectF = new RectF(rect4.left, rect4.top, rect4.right, rect4.bottom);
        float f10 = Float.compare(radius, 0.0f) == 0 ? radius : i10 + radius;
        path.reset();
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        rect.left = rect4.left;
        rect.top = rect4.top;
        rect.right = rect4.right;
        rect.bottom = rect4.bottom;
        this.f42082d = i10;
        this.f42085g = radius;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f42089k == null || this.f42079a == 0 || !isDrawOutline()) {
            return;
        }
        m54214a(canvas);
    }

    public boolean isDrawOutline() {
        return true;
    }

    public void setOffsetRect(Rect rect) {
        if (rect == null) {
            return;
        }
        Rect rect2 = this.f42087i;
        rect2.left = rect.left;
        rect2.right = rect.right;
        rect2.top = rect.top;
        rect2.bottom = rect.bottom;
    }

    public void setOutlineColor(int i10) {
        this.f42079a = i10;
    }

    public void setOutlineDistance(int i10) {
        this.f42081c = i10;
    }

    public void setOutlineRadius(float f10) {
        this.f42084f = f10;
    }

    public void setOutlineWidth(int i10) {
        this.f42080b = i10;
    }

    /* renamed from: a */
    private void m54214a(Canvas canvas) {
        int i10 = (int) (this.f42081c + (this.f42080b / 2.0f) + f42077t);
        m54215a(this.f42089k.getOutlineProvider(), this.f42089k, this.f42083e ? i10 : -i10, this.f42088j, this.f42091m);
        canvas.translate(this.f42089k.getScrollX(), this.f42089k.getScrollY());
        Rect rect = this.f42088j;
        int iSaveLayerAlpha = canvas.saveLayerAlpha(rect.left - i10, rect.top - i10, rect.right + i10, rect.bottom + i10, 255);
        this.f42090l.setColor(this.f42079a);
        this.f42090l.setStrokeWidth(this.f42080b);
        canvas.drawPath(this.f42091m, this.f42090l);
        canvas.restoreToCount(iSaveLayerAlpha);
        canvas.translate(-this.f42089k.getScrollX(), -this.f42089k.getScrollY());
    }
}
