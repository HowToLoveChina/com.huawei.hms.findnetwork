package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: a */
    public ValueAnimator f9008a;

    /* renamed from: b */
    public boolean f9009b;

    /* renamed from: c */
    public float f9010c;

    /* renamed from: d */
    public float f9011d;

    /* renamed from: e */
    public boolean f9012e;

    /* renamed from: f */
    public int f9013f;

    /* renamed from: g */
    public final List<InterfaceC1877c> f9014g;

    /* renamed from: h */
    public final int f9015h;

    /* renamed from: i */
    public final float f9016i;

    /* renamed from: j */
    public final Paint f9017j;

    /* renamed from: k */
    public final RectF f9018k;

    /* renamed from: l */
    public final int f9019l;

    /* renamed from: m */
    public float f9020m;

    /* renamed from: n */
    public boolean f9021n;

    /* renamed from: o */
    public double f9022o;

    /* renamed from: p */
    public int f9023p;

    /* renamed from: com.google.android.material.timepicker.ClockHandView$a */
    public class C1875a implements ValueAnimator.AnimatorUpdateListener {
        public C1875a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m11409m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* renamed from: com.google.android.material.timepicker.ClockHandView$b */
    public class C1876b extends AnimatorListenerAdapter {
        public C1876b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* renamed from: com.google.android.material.timepicker.ClockHandView$c */
    public interface InterfaceC1877c {
        /* renamed from: a */
        void mo11391a(float f10, boolean z10);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public void m11398b(InterfaceC1877c interfaceC1877c) {
        this.f9014g.add(interfaceC1877c);
    }

    /* renamed from: c */
    public final void m11399c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.f9023p * ((float) Math.cos(this.f9022o))) + width;
        float f10 = height;
        float fSin = (this.f9023p * ((float) Math.sin(this.f9022o))) + f10;
        this.f9017j.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f9015h, this.f9017j);
        double dSin = Math.sin(this.f9022o);
        double dCos = Math.cos(this.f9022o);
        this.f9017j.setStrokeWidth(this.f9019l);
        canvas.drawLine(width, f10, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f9017j);
        canvas.drawCircle(width, f10, this.f9016i, this.f9017j);
    }

    /* renamed from: d */
    public RectF m11400d() {
        return this.f9018k;
    }

    /* renamed from: e */
    public final int m11401e(float f10, float f11) {
        int degrees = (int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)));
        int i10 = degrees + 90;
        return i10 < 0 ? degrees + 450 : i10;
    }

    /* renamed from: f */
    public float m11402f() {
        return this.f9020m;
    }

    /* renamed from: g */
    public int m11403g() {
        return this.f9015h;
    }

    /* renamed from: h */
    public final Pair<Float, Float> m11404h(float f10) {
        float fM11402f = m11402f();
        if (Math.abs(fM11402f - f10) > 180.0f) {
            if (fM11402f > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (fM11402f < 180.0f && f10 > 180.0f) {
                fM11402f += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(fM11402f), Float.valueOf(f10));
    }

    /* renamed from: i */
    public final boolean m11405i(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        float fM11401e = m11401e(f10, f11);
        boolean z13 = false;
        boolean z14 = m11402f() != fM11401e;
        if (z11 && z14) {
            return true;
        }
        if (!z14 && !z10) {
            return false;
        }
        if (z12 && this.f9009b) {
            z13 = true;
        }
        m11408l(fM11401e, z13);
        return true;
    }

    /* renamed from: j */
    public void m11406j(int i10) {
        this.f9023p = i10;
        invalidate();
    }

    /* renamed from: k */
    public void m11407k(float f10) {
        m11408l(f10, false);
    }

    /* renamed from: l */
    public void m11408l(float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f9008a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            m11409m(f10, false);
            return;
        }
        Pair<Float, Float> pairM11404h = m11404h(f10);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairM11404h.first).floatValue(), ((Float) pairM11404h.second).floatValue());
        this.f9008a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f9008a.addUpdateListener(new C1875a());
        this.f9008a.addListener(new C1876b());
        this.f9008a.start();
    }

    /* renamed from: m */
    public final void m11409m(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f9020m = f11;
        this.f9022o = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f9023p * ((float) Math.cos(this.f9022o)));
        float fSin = height + (this.f9023p * ((float) Math.sin(this.f9022o)));
        RectF rectF = this.f9018k;
        int i10 = this.f9015h;
        rectF.set(width - i10, fSin - i10, width + i10, fSin + i10);
        Iterator<InterfaceC1877c> it = this.f9014g.iterator();
        while (it.hasNext()) {
            it.next().mo11391a(f11, z10);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m11399c(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m11407k(m11402f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f9010c = x10;
            this.f9011d = y10;
            this.f9012e = true;
            this.f9021n = false;
            z10 = true;
            z11 = false;
            z12 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i10 = (int) (x10 - this.f9010c);
            int i11 = (int) (y10 - this.f9011d);
            this.f9012e = (i10 * i10) + (i11 * i11) > this.f9013f;
            z11 = this.f9021n;
            z12 = actionMasked == 1;
            z10 = false;
        } else {
            z11 = false;
            z10 = false;
            z12 = false;
        }
        this.f9021n |= m11405i(x10, y10, z11, z10, z12);
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9014g = new ArrayList();
        Paint paint = new Paint();
        this.f9017j = paint;
        this.f9018k = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i10, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.f9023p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f9015h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        this.f9019l = getResources().getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f9016i = r6.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        m11407k(0.0f);
        this.f9013f = ViewConfiguration.get(context).getScaledTouchSlop();
        C9603h0.m59833A0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
