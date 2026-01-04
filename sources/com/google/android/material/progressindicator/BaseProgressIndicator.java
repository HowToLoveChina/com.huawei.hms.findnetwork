package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import java.util.Arrays;
import p002a1.AbstractC0002a;
import p246e3.AbstractC9394b;
import p246e3.AbstractC9398f;
import p246e3.AbstractC9399g;
import p246e3.C9393a;
import p246e3.C9397e;
import p246e3.C9401i;
import p273f0.C9603h0;
import p416k3.C10981a;
import p760x2.C13689a;

/* loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends AbstractC9394b> extends ProgressBar {

    /* renamed from: o */
    public static final int f8526o = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a */
    public S f8527a;

    /* renamed from: b */
    public int f8528b;

    /* renamed from: c */
    public boolean f8529c;

    /* renamed from: d */
    public boolean f8530d;

    /* renamed from: e */
    public final int f8531e;

    /* renamed from: f */
    public final int f8532f;

    /* renamed from: g */
    public long f8533g;

    /* renamed from: h */
    public C9393a f8534h;

    /* renamed from: i */
    public boolean f8535i;

    /* renamed from: j */
    public int f8536j;

    /* renamed from: k */
    public final Runnable f8537k;

    /* renamed from: l */
    public final Runnable f8538l;

    /* renamed from: m */
    public final AbstractC0002a f8539m;

    /* renamed from: n */
    public final AbstractC0002a f8540n;

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$a */
    public class RunnableC1806a implements Runnable {
        public RunnableC1806a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.m10884k();
        }
    }

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$b */
    public class RunnableC1807b implements Runnable {
        public RunnableC1807b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.m10883j();
            BaseProgressIndicator.this.f8533g = -1L;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$c */
    public class C1808c extends AbstractC0002a {
        public C1808c() {
        }

        @Override // p002a1.AbstractC0002a
        /* renamed from: a */
        public void mo2a(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.mo10888o(baseProgressIndicator.f8528b, BaseProgressIndicator.this.f8529c);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$d */
    public class C1809d extends AbstractC0002a {
        public C1809d() {
        }

        @Override // p002a1.AbstractC0002a
        /* renamed from: a */
        public void mo2a(Drawable drawable) {
            super.mo2a(drawable);
            if (BaseProgressIndicator.this.f8535i) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.f8536j);
        }
    }

    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(C10981a.m66348c(context, attributeSet, i10, f8526o), attributeSet, i10);
        this.f8533g = -1L;
        this.f8535i = false;
        this.f8536j = 4;
        this.f8537k = new RunnableC1806a();
        this.f8538l = new RunnableC1807b();
        this.f8539m = new C1808c();
        this.f8540n = new C1809d();
        Context context2 = getContext();
        this.f8527a = (S) mo10882i(context2, attributeSet);
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f8531e = typedArrayM10770h.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f8532f = Math.min(typedArrayM10770h.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayM10770h.recycle();
        this.f8534h = new C9393a();
        this.f8530d = true;
    }

    private AbstractC9399g<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().m58931v();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().m58903w();
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f8527a.f46923f;
    }

    public int[] getIndicatorColor() {
        return this.f8527a.f46920c;
    }

    public int getShowAnimationBehavior() {
        return this.f8527a.f46922e;
    }

    public int getTrackColor() {
        return this.f8527a.f46921d;
    }

    public int getTrackCornerRadius() {
        return this.f8527a.f46919b;
    }

    public int getTrackThickness() {
        return this.f8527a.f46918a;
    }

    /* renamed from: h */
    public void m10881h(boolean z10) {
        if (this.f8530d) {
            ((AbstractC9398f) getCurrentDrawable()).mo58900p(m10890q(), false, z10);
        }
    }

    /* renamed from: i */
    public abstract S mo10882i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    /* renamed from: j */
    public final void m10883j() {
        ((AbstractC9398f) getCurrentDrawable()).mo58900p(false, false, true);
        if (m10886m()) {
            setVisibility(4);
        }
    }

    /* renamed from: k */
    public final void m10884k() {
        if (this.f8532f > 0) {
            this.f8533g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    /* renamed from: l */
    public boolean m10885l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    /* renamed from: m */
    public final boolean m10886m() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    /* renamed from: n */
    public final void m10887n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m58930u().mo58875d(this.f8539m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().mo58899l(this.f8540n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().mo58899l(this.f8540n);
        }
    }

    /* renamed from: o */
    public void mo10888o(int i10, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i10);
            if (getProgressDrawable() == null || z10) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f8528b = i10;
            this.f8529c = z10;
            this.f8535i = true;
            if (!getIndeterminateDrawable().isVisible() || this.f8534h.m58855a(getContext().getContentResolver()) == 0.0f) {
                this.f8539m.mo2a(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().m58930u().mo58876f();
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m10887n();
        if (m10890q()) {
            m10884k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f8538l);
        removeCallbacks(this.f8537k);
        ((AbstractC9398f) getCurrentDrawable()).mo58896h();
        m10889p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        try {
            super.onMeasure(i10, i11);
            AbstractC9399g<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            int iMo58864e = currentDrawingDelegate.mo58864e();
            int iMo58863d = currentDrawingDelegate.mo58863d();
            setMeasuredDimension(iMo58864e < 0 ? getMeasuredWidth() : iMo58864e + getPaddingLeft() + getPaddingRight(), iMo58863d < 0 ? getMeasuredHeight() : iMo58863d + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        m10881h(i10 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        m10881h(false);
    }

    /* renamed from: p */
    public final void m10889p() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().mo58902r(this.f8540n);
            getIndeterminateDrawable().m58930u().mo58878h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().mo58902r(this.f8540n);
        }
    }

    /* renamed from: q */
    public boolean m10890q() {
        return C9603h0.m59863S(this) && getWindowVisibility() == 0 && m10885l();
    }

    public void setAnimatorDurationScaleProvider(C9393a c9393a) {
        this.f8534h = c9393a;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f46952c = c9393a;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f46952c = c9393a;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f8527a.f46923f = i10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        try {
            if (z10 == isIndeterminate()) {
                return;
            }
            AbstractC9398f abstractC9398f = (AbstractC9398f) getCurrentDrawable();
            if (abstractC9398f != null) {
                abstractC9398f.mo58896h();
            }
            super.setIndeterminate(z10);
            AbstractC9398f abstractC9398f2 = (AbstractC9398f) getCurrentDrawable();
            if (abstractC9398f2 != null) {
                abstractC9398f2.mo58900p(m10890q(), false, false);
            }
            if ((abstractC9398f2 instanceof C9401i) && m10890q()) {
                ((C9401i) abstractC9398f2).m58930u().mo58877g();
            }
            this.f8535i = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof C9401i)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((AbstractC9398f) drawable).mo58896h();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{C13689a.m82288b(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f8527a.f46920c = iArr;
        getIndeterminateDrawable().m58930u().mo58874c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        if (isIndeterminate()) {
            return;
        }
        mo10888o(i10, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof C9397e)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            C9397e c9397e = (C9397e) drawable;
            c9397e.mo58896h();
            super.setProgressDrawable(c9397e);
            c9397e.m58895A(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.f8527a.f46922e = i10;
        invalidate();
    }

    public void setTrackColor(int i10) {
        S s10 = this.f8527a;
        if (s10.f46921d != i10) {
            s10.f46921d = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i10) {
        S s10 = this.f8527a;
        if (s10.f46919b != i10) {
            s10.f46919b = Math.min(i10, s10.f46918a / 2);
        }
    }

    public void setTrackThickness(int i10) {
        S s10 = this.f8527a;
        if (s10.f46918a != i10) {
            s10.f46918a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 != 0 && i10 != 4 && i10 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f8536j = i10;
    }

    @Override // android.widget.ProgressBar
    public C9401i<S> getIndeterminateDrawable() {
        return (C9401i) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public C9397e<S> getProgressDrawable() {
        return (C9397e) super.getProgressDrawable();
    }
}
