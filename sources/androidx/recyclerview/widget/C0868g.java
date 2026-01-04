package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p273f0.C9603h0;

/* renamed from: androidx.recyclerview.widget.g */
/* loaded from: classes.dex */
public class C0868g extends RecyclerView.AbstractC0845o implements RecyclerView.InterfaceC0849s {

    /* renamed from: K0 */
    public static final int[] f4562K0 = {R.attr.state_pressed};

    /* renamed from: L0 */
    public static final int[] f4563L0 = new int[0];

    /* renamed from: G0 */
    public final ValueAnimator f4570G0;

    /* renamed from: H0 */
    public int f4571H0;

    /* renamed from: I0 */
    public final Runnable f4572I0;

    /* renamed from: J0 */
    public final RecyclerView.AbstractC0850t f4573J0;

    /* renamed from: h0 */
    public final int f4574h0;

    /* renamed from: i0 */
    public final int f4575i0;

    /* renamed from: j0 */
    public final StateListDrawable f4576j0;

    /* renamed from: k0 */
    public final Drawable f4577k0;

    /* renamed from: l0 */
    public final int f4578l0;

    /* renamed from: m0 */
    public final int f4579m0;

    /* renamed from: n0 */
    public final StateListDrawable f4580n0;

    /* renamed from: o0 */
    public final Drawable f4581o0;

    /* renamed from: p0 */
    public final int f4582p0;

    /* renamed from: q0 */
    public final int f4583q0;

    /* renamed from: r0 */
    public int f4584r0;

    /* renamed from: s0 */
    public int f4585s0;

    /* renamed from: t0 */
    public float f4586t0;

    /* renamed from: u0 */
    public int f4587u0;

    /* renamed from: v0 */
    public int f4588v0;

    /* renamed from: w0 */
    public float f4589w0;

    /* renamed from: z0 */
    public RecyclerView f4592z0;

    /* renamed from: x0 */
    public int f4590x0 = 0;

    /* renamed from: y0 */
    public int f4591y0 = 0;

    /* renamed from: A0 */
    public boolean f4564A0 = false;

    /* renamed from: B0 */
    public boolean f4565B0 = false;

    /* renamed from: C0 */
    public int f4566C0 = 0;

    /* renamed from: D0 */
    public int f4567D0 = 0;

    /* renamed from: E0 */
    public final int[] f4568E0 = new int[2];

    /* renamed from: F0 */
    public final int[] f4569F0 = new int[2];

    /* renamed from: androidx.recyclerview.widget.g$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0868g.this.m5518u(500);
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$b */
    public class b extends RecyclerView.AbstractC0850t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            C0868g.this.m5510F(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$c */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f4595a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4595a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4595a) {
                this.f4595a = false;
                return;
            }
            if (((Float) C0868g.this.f4570G0.getAnimatedValue()).floatValue() == 0.0f) {
                C0868g c0868g = C0868g.this;
                c0868g.f4571H0 = 0;
                c0868g.m5507C(0);
            } else {
                C0868g c0868g2 = C0868g.this;
                c0868g2.f4571H0 = 2;
                c0868g2.m5523z();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$d */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C0868g.this.f4576j0.setAlpha(iFloatValue);
            C0868g.this.f4577k0.setAlpha(iFloatValue);
            C0868g.this.m5523z();
        }
    }

    public C0868g(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4570G0 = valueAnimatorOfFloat;
        this.f4571H0 = 0;
        this.f4572I0 = new a();
        this.f4573J0 = new b();
        this.f4576j0 = stateListDrawable;
        this.f4577k0 = drawable;
        this.f4580n0 = stateListDrawable2;
        this.f4581o0 = drawable2;
        this.f4578l0 = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f4579m0 = Math.max(i10, drawable.getIntrinsicWidth());
        this.f4582p0 = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f4583q0 = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f4574h0 = i11;
        this.f4575i0 = i12;
        stateListDrawable.setAlpha(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        drawable.setAlpha(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        attachToRecyclerView(recyclerView);
    }

    /* renamed from: A */
    public final void m5505A(int i10) {
        m5512o();
        this.f4592z0.postDelayed(this.f4572I0, i10);
    }

    /* renamed from: B */
    public final int m5506B(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    /* renamed from: C */
    public void m5507C(int i10) {
        if (i10 == 2 && this.f4566C0 != 2) {
            this.f4576j0.setState(f4562K0);
            m5512o();
        }
        if (i10 == 0) {
            m5523z();
        } else {
            m5509E();
        }
        if (this.f4566C0 == 2 && i10 != 2) {
            this.f4576j0.setState(f4563L0);
            m5505A(1200);
        } else if (i10 == 1) {
            m5505A(1500);
        }
        this.f4566C0 = i10;
    }

    /* renamed from: D */
    public final void m5508D() {
        this.f4592z0.addItemDecoration(this);
        this.f4592z0.addOnItemTouchListener(this);
        this.f4592z0.addOnScrollListener(this.f4573J0);
    }

    /* renamed from: E */
    public void m5509E() {
        int i10 = this.f4571H0;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f4570G0.cancel();
            }
        }
        this.f4571H0 = 1;
        ValueAnimator valueAnimator = this.f4570G0;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f4570G0.setDuration(500L);
        this.f4570G0.setStartDelay(0L);
        this.f4570G0.start();
    }

    /* renamed from: F */
    public void m5510F(int i10, int i11) {
        int iComputeVerticalScrollRange = this.f4592z0.computeVerticalScrollRange();
        int i12 = this.f4591y0;
        this.f4564A0 = iComputeVerticalScrollRange - i12 > 0 && i12 >= this.f4574h0;
        int iComputeHorizontalScrollRange = this.f4592z0.computeHorizontalScrollRange();
        int i13 = this.f4590x0;
        boolean z10 = iComputeHorizontalScrollRange - i13 > 0 && i13 >= this.f4574h0;
        this.f4565B0 = z10;
        boolean z11 = this.f4564A0;
        if (!z11 && !z10) {
            if (this.f4566C0 != 0) {
                m5507C(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i12;
            this.f4585s0 = (int) ((f10 * (i11 + (f10 / 2.0f))) / iComputeVerticalScrollRange);
            this.f4584r0 = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
        }
        if (this.f4565B0) {
            float f11 = i13;
            this.f4588v0 = (int) ((f11 * (i10 + (f11 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f4587u0 = Math.min(i13, (i13 * i13) / iComputeHorizontalScrollRange);
        }
        int i14 = this.f4566C0;
        if (i14 == 0 || i14 == 1) {
            m5507C(1);
        }
    }

    /* renamed from: G */
    public final void m5511G(float f10) {
        int[] iArrM5517t = m5517t();
        float fMax = Math.max(iArrM5517t[0], Math.min(iArrM5517t[1], f10));
        if (Math.abs(this.f4585s0 - fMax) < 2.0f) {
            return;
        }
        int iM5506B = m5506B(this.f4586t0, fMax, iArrM5517t, this.f4592z0.computeVerticalScrollRange(), this.f4592z0.computeVerticalScrollOffset(), this.f4591y0);
        if (iM5506B != 0) {
            this.f4592z0.scrollBy(0, iM5506B);
        }
        this.f4586t0 = fMax;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4592z0;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m5513p();
        }
        this.f4592z0 = recyclerView;
        if (recyclerView != null) {
            m5508D();
        }
    }

    /* renamed from: o */
    public final void m5512o() {
        this.f4592z0.removeCallbacks(this.f4572I0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        if (this.f4590x0 != this.f4592z0.getWidth() || this.f4591y0 != this.f4592z0.getHeight()) {
            this.f4590x0 = this.f4592z0.getWidth();
            this.f4591y0 = this.f4592z0.getHeight();
            m5507C(0);
        } else if (this.f4571H0 != 0) {
            if (this.f4564A0) {
                m5515r(canvas);
            }
            if (this.f4565B0) {
                m5514q(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f4566C0;
        if (i10 == 1) {
            boolean zM5522y = m5522y(motionEvent.getX(), motionEvent.getY());
            boolean zM5521x = m5521x(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zM5522y && !zM5521x) {
                return false;
            }
            if (zM5521x) {
                this.f4567D0 = 1;
                this.f4589w0 = (int) motionEvent.getX();
            } else if (zM5522y) {
                this.f4567D0 = 2;
                this.f4586t0 = (int) motionEvent.getY();
            }
            m5507C(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f4566C0 == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zM5522y = m5522y(motionEvent.getX(), motionEvent.getY());
            boolean zM5521x = m5521x(motionEvent.getX(), motionEvent.getY());
            if (zM5522y || zM5521x) {
                if (zM5521x) {
                    this.f4567D0 = 1;
                    this.f4589w0 = (int) motionEvent.getX();
                } else if (zM5522y) {
                    this.f4567D0 = 2;
                    this.f4586t0 = (int) motionEvent.getY();
                }
                m5507C(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f4566C0 == 2) {
            this.f4586t0 = 0.0f;
            this.f4589w0 = 0.0f;
            m5507C(1);
            this.f4567D0 = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f4566C0 == 2) {
            m5509E();
            if (this.f4567D0 == 1) {
                m5519v(motionEvent.getX());
            }
            if (this.f4567D0 == 2) {
                m5511G(motionEvent.getY());
            }
        }
    }

    /* renamed from: p */
    public final void m5513p() {
        this.f4592z0.removeItemDecoration(this);
        this.f4592z0.removeOnItemTouchListener(this);
        this.f4592z0.removeOnScrollListener(this.f4573J0);
        m5512o();
    }

    /* renamed from: q */
    public final void m5514q(Canvas canvas) {
        int i10 = this.f4591y0;
        int i11 = this.f4582p0;
        int i12 = this.f4588v0;
        int i13 = this.f4587u0;
        this.f4580n0.setBounds(0, 0, i13, i11);
        this.f4581o0.setBounds(0, 0, this.f4590x0, this.f4583q0);
        canvas.translate(0.0f, i10 - i11);
        this.f4581o0.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f4580n0.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    /* renamed from: r */
    public final void m5515r(Canvas canvas) {
        int i10 = this.f4590x0;
        int i11 = this.f4578l0;
        int i12 = i10 - i11;
        int i13 = this.f4585s0;
        int i14 = this.f4584r0;
        int i15 = i13 - (i14 / 2);
        this.f4576j0.setBounds(0, 0, i11, i14);
        this.f4577k0.setBounds(0, 0, this.f4579m0, this.f4591y0);
        if (!m5520w()) {
            canvas.translate(i12, 0.0f);
            this.f4577k0.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f4576j0.draw(canvas);
            canvas.translate(-i12, -i15);
            return;
        }
        this.f4577k0.draw(canvas);
        canvas.translate(this.f4578l0, i15);
        canvas.scale(-1.0f, 1.0f);
        this.f4576j0.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f4578l0, -i15);
    }

    /* renamed from: s */
    public final int[] m5516s() {
        int[] iArr = this.f4569F0;
        int i10 = this.f4575i0;
        iArr[0] = i10;
        iArr[1] = this.f4590x0 - i10;
        return iArr;
    }

    /* renamed from: t */
    public final int[] m5517t() {
        int[] iArr = this.f4568E0;
        int i10 = this.f4575i0;
        iArr[0] = i10;
        iArr[1] = this.f4591y0 - i10;
        return iArr;
    }

    /* renamed from: u */
    public void m5518u(int i10) {
        int i11 = this.f4571H0;
        if (i11 == 1) {
            this.f4570G0.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.f4571H0 = 3;
        ValueAnimator valueAnimator = this.f4570G0;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f4570G0.setDuration(i10);
        this.f4570G0.start();
    }

    /* renamed from: v */
    public final void m5519v(float f10) {
        int[] iArrM5516s = m5516s();
        float fMax = Math.max(iArrM5516s[0], Math.min(iArrM5516s[1], f10));
        if (Math.abs(this.f4588v0 - fMax) < 2.0f) {
            return;
        }
        int iM5506B = m5506B(this.f4589w0, fMax, iArrM5516s, this.f4592z0.computeHorizontalScrollRange(), this.f4592z0.computeHorizontalScrollOffset(), this.f4590x0);
        if (iM5506B != 0) {
            this.f4592z0.scrollBy(iM5506B, 0);
        }
        this.f4589w0 = fMax;
    }

    /* renamed from: w */
    public final boolean m5520w() {
        return C9603h0.m59832A(this.f4592z0) == 1;
    }

    /* renamed from: x */
    public boolean m5521x(float f10, float f11) {
        if (f11 >= this.f4591y0 - this.f4582p0) {
            int i10 = this.f4588v0;
            int i11 = this.f4587u0;
            if (f10 >= i10 - (i11 / 2) && f10 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: y */
    public boolean m5522y(float f10, float f11) {
        if (!m5520w() ? f10 >= this.f4590x0 - this.f4578l0 : f10 <= this.f4578l0) {
            int i10 = this.f4585s0;
            int i11 = this.f4584r0;
            if (f11 >= i10 - (i11 / 2) && f11 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: z */
    public void m5523z() {
        this.f4592z0.invalidate();
    }
}
