package com.huawei.android.remotecontrol.nearlink.p090ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;
import p514o9.C11842p;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class NearLinkCircle extends View {

    /* renamed from: a */
    public Paint f19965a;

    /* renamed from: b */
    public Paint f19966b;

    /* renamed from: c */
    public RectF f19967c;

    /* renamed from: d */
    public RectF f19968d;

    /* renamed from: e */
    public float f19969e;

    /* renamed from: f */
    public float f19970f;

    /* renamed from: g */
    public final int f19971g;

    /* renamed from: h */
    public final long f19972h;

    /* renamed from: i */
    public final float f19973i;

    /* renamed from: j */
    public final float f19974j;

    /* renamed from: k */
    public final int f19975k;

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.component.NearLinkCircle$a */
    public class C4361a extends TimerTask {

        /* renamed from: a */
        public final /* synthetic */ int[] f19976a;

        /* renamed from: b */
        public final /* synthetic */ Timer f19977b;

        /* renamed from: c */
        public final /* synthetic */ float f19978c;

        /* renamed from: d */
        public final /* synthetic */ float f19979d;

        public C4361a(int[] iArr, Timer timer, float f10, float f11) {
            this.f19976a = iArr;
            this.f19977b = timer;
            this.f19978c = f10;
            this.f19979d = f11;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int[] iArr = this.f19976a;
            int i10 = iArr[0] + 1;
            iArr[0] = i10;
            if (NearLinkCircle.this.m26375f(i10)) {
                this.f19977b.cancel();
            } else {
                NearLinkCircle.this.m26372c(this.f19978c, this.f19979d);
                NearLinkCircle.this.invalidate();
            }
        }
    }

    public NearLinkCircle(Context context) {
        super(context);
        this.f19969e = 0.0f;
        this.f19970f = 0.0f;
        this.f19971g = 3;
        this.f19972h = 50L;
        this.f19973i = C11842p.m70844o(getContext(), 260);
        this.f19974j = C11842p.m70844o(getContext(), 16);
        this.f19975k = -12566466;
        m26374e();
    }

    /* renamed from: c */
    public final void m26372c(float f10, float f11) {
        C13981a.m83989i("NearlinkCircle", "changeAngle  loopX: " + f10 + "loopY:" + f11);
        this.f19969e = new BigDecimal((double) (f10 + this.f19969e)).setScale(1, 4).floatValue();
        this.f19970f = new BigDecimal((double) (f11 + this.f19970f)).setScale(1, 4).floatValue();
    }

    /* renamed from: d */
    public void m26373d(float f10, float f11) {
        C13981a.m83989i("NearlinkCircle", "angle  newStartAngle: " + f10 + "newEndAngle:" + f11);
        if (new BigDecimal(f10).setScale(1, 4).floatValue() == new BigDecimal(this.f19969e).setScale(1, 4).floatValue() && new BigDecimal(f11 + f10).setScale(1, 4).floatValue() == new BigDecimal(this.f19970f).setScale(1, 4).floatValue()) {
            C13981a.m83989i("NearlinkCircle", "angle no different");
            return;
        }
        float fFloatValue = new BigDecimal((f10 - this.f19969e) / 3.0f).setScale(1, 4).floatValue();
        float fFloatValue2 = new BigDecimal((f11 - this.f19970f) / 3.0f).setScale(1, 4).floatValue();
        Timer timer = new Timer();
        timer.schedule(new C4361a(new int[]{0}, timer, fFloatValue, fFloatValue2), 0L, 50L);
    }

    /* renamed from: e */
    public final void m26374e() {
        Paint paint = new Paint();
        this.f19965a = paint;
        paint.setAntiAlias(true);
        this.f19965a.setColor(-1);
        Paint paint2 = new Paint();
        this.f19966b = paint2;
        paint2.setAntiAlias(true);
        this.f19966b.setColor(-12566466);
        RectF rectF = new RectF();
        this.f19968d = rectF;
        float f10 = this.f19974j;
        float f11 = this.f19973i;
        rectF.set(f10, f10, f11 - f10, f11 - f10);
        RectF rectF2 = new RectF();
        this.f19967c = rectF2;
        float f12 = this.f19973i;
        rectF2.set(0.0f, 0.0f, f12, f12);
    }

    /* renamed from: f */
    public final boolean m26375f(int i10) {
        return i10 > 3;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        C13981a.m83989i("NearlinkCircle", "getInnerCircleShader  this.lastStartAngle: " + this.f19969e + "this.lastEndAngle:" + this.f19970f);
        super.onDraw(canvas);
        canvas.drawArc(this.f19967c, this.f19969e, this.f19970f, true, this.f19965a);
        canvas.drawArc(this.f19968d, this.f19969e, this.f19970f, true, this.f19966b);
    }

    public NearLinkCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19969e = 0.0f;
        this.f19970f = 0.0f;
        this.f19971g = 3;
        this.f19972h = 50L;
        this.f19973i = C11842p.m70844o(getContext(), 260);
        this.f19974j = C11842p.m70844o(getContext(), 16);
        this.f19975k = -12566466;
        m26374e();
    }

    public NearLinkCircle(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19969e = 0.0f;
        this.f19970f = 0.0f;
        this.f19971g = 3;
        this.f19972h = 50L;
        this.f19973i = C11842p.m70844o(getContext(), 260);
        this.f19974j = C11842p.m70844o(getContext(), 16);
        this.f19975k = -12566466;
        m26374e();
    }
}
