package com.huawei.android.hicloud.p088ui.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;

/* loaded from: classes3.dex */
public class CheckMarkView extends View {

    /* renamed from: a */
    public Paint f19374a;

    /* renamed from: b */
    public Path f19375b;

    /* renamed from: c */
    public PathMeasure f19376c;

    /* renamed from: d */
    public int f19377d;

    /* renamed from: e */
    public int f19378e;

    /* renamed from: f */
    public float f19379f;

    /* renamed from: g */
    public ValueAnimator f19380g;

    /* renamed from: h */
    public float f19381h;

    /* renamed from: com.huawei.android.hicloud.ui.views.CheckMarkView$a */
    public class C4284a implements ValueAnimator.AnimatorUpdateListener {
        public C4284a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CheckMarkView.this.f19381h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CheckMarkView.this.invalidate();
        }
    }

    public CheckMarkView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public final void m25687b() {
        Paint paint = new Paint();
        this.f19374a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f19374a.setAntiAlias(true);
        this.f19374a.setStrokeCap(Paint.Cap.ROUND);
        this.f19374a.setStrokeJoin(Paint.Join.ROUND);
        this.f19374a.setStrokeWidth(getResources().getDimension(R$dimen.bc_space_2));
        this.f19374a.setColor(-1);
        this.f19375b = new Path();
        this.f19376c = new PathMeasure();
    }

    /* renamed from: c */
    public final void m25688c() {
        Path path = new Path();
        path.moveTo((this.f19377d * 0.8f) / 4.0f, this.f19378e / 2.0f);
        path.lineTo((this.f19377d * 0.8f) / 2.0f, (this.f19378e * 2.8f) / 4.0f);
        path.lineTo((this.f19377d * 3.1f) / 4.0f, this.f19378e * 0.33f);
        this.f19376c.setPath(path, false);
        this.f19379f = this.f19376c.getLength();
    }

    /* renamed from: d */
    public void m25689d() {
        ValueAnimator valueAnimator = this.f19380g;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        this.f19381h = 0.0f;
        invalidate();
    }

    /* renamed from: e */
    public void m25690e() {
        this.f19374a.setStrokeWidth(getResources().getDimension(R$dimen.bc_space_4));
        this.f19374a.setColor(getResources().getColor(R$color.color_5188FF));
    }

    /* renamed from: f */
    public void m25691f() {
        this.f19374a.setColor(getResources().getColor(R$color.color_0A59F7));
    }

    /* renamed from: g */
    public void m25692g() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f19380g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(400L);
        this.f19381h = 100.0f;
        invalidate();
    }

    /* renamed from: h */
    public void m25693h() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f19380g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(400L);
        this.f19380g.addUpdateListener(new C4284a());
        this.f19380g.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.f19379f * this.f19381h;
        this.f19375b.reset();
        this.f19375b.moveTo(0.0f, 0.0f);
        this.f19376c.getSegment(0.0f, f10, this.f19375b, true);
        canvas.drawPath(this.f19375b, this.f19374a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f19377d = i10;
        this.f19378e = i11;
        m25688c();
    }

    public CheckMarkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckMarkView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25687b();
    }
}
