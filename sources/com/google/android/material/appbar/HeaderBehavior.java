package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p273f0.C9603h0;
import p827z.C14059a;

/* loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: d */
    public Runnable f7424d;

    /* renamed from: e */
    public OverScroller f7425e;

    /* renamed from: f */
    public boolean f7426f;

    /* renamed from: g */
    public int f7427g;

    /* renamed from: h */
    public int f7428h;

    /* renamed from: i */
    public int f7429i;

    /* renamed from: j */
    public VelocityTracker f7430j;

    /* renamed from: com.google.android.material.appbar.HeaderBehavior$a */
    public class RunnableC1648a implements Runnable {

        /* renamed from: a */
        public final CoordinatorLayout f7431a;

        /* renamed from: b */
        public final V f7432b;

        public RunnableC1648a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f7431a = coordinatorLayout;
            this.f7432b = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f7432b == null || (overScroller = HeaderBehavior.this.f7425e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.mo9505N(this.f7431a, this.f7432b);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.m9586P(this.f7431a, this.f7432b, headerBehavior.f7425e.getCurrY());
            C9603h0.m59886h0(this.f7432b, this);
        }
    }

    public HeaderBehavior() {
        this.f7427g = -1;
        this.f7429i = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo3726D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f7427g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f7428h = r12
            goto L4c
        L2d:
            int r0 = r11.f7427g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f7428h
            int r7 = r1 - r0
            r11.f7428h = r0
            int r8 = r11.mo9502K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.m9585O(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f7430j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f7430j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f7430j
            int r4 = r11.f7427g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.mo9503L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.m9584J(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f7426f = r3
            r11.f7427g = r1
            android.view.VelocityTracker r13 = r11.f7430j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f7430j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f7430j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r11 = r11.f7426f
            if (r11 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.mo3726D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: H */
    public boolean mo9501H(V v10) {
        return false;
    }

    /* renamed from: I */
    public final void m9583I() {
        if (this.f7430j == null) {
            this.f7430j = VelocityTracker.obtain();
        }
    }

    /* renamed from: J */
    public final boolean m9584J(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f7424d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f7424d = null;
        }
        if (this.f7425e == null) {
            this.f7425e = new OverScroller(v10.getContext());
        }
        this.f7425e.fling(0, mo9540E(), 0, Math.round(f10), 0, 0, i10, i11);
        if (!this.f7425e.computeScrollOffset()) {
            mo9505N(coordinatorLayout, v10);
            return false;
        }
        RunnableC1648a runnableC1648a = new RunnableC1648a(coordinatorLayout, v10);
        this.f7424d = runnableC1648a;
        C9603h0.m59886h0(v10, runnableC1648a);
        return true;
    }

    /* renamed from: K */
    public int mo9502K(V v10) {
        return -v10.getHeight();
    }

    /* renamed from: L */
    public int mo9503L(V v10) {
        return v10.getHeight();
    }

    /* renamed from: M */
    public int mo9504M() {
        return mo9540E();
    }

    /* renamed from: N */
    public void mo9505N(CoordinatorLayout coordinatorLayout, V v10) {
    }

    /* renamed from: O */
    public final int m9585O(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return mo9506Q(coordinatorLayout, v10, mo9504M() - i10, i11, i12);
    }

    /* renamed from: P */
    public int m9586P(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return mo9506Q(coordinatorLayout, v10, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: Q */
    public int mo9506Q(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int iM84263b;
        int iMo9540E = mo9540E();
        if (i11 == 0 || iMo9540E < i11 || iMo9540E > i12 || iMo9540E == (iM84263b = C14059a.m84263b(i10, i11, i12))) {
            return 0;
        }
        mo9541G(iM84263b);
        return iMo9540E - iM84263b;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: k */
    public boolean mo3737k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f7429i < 0) {
            this.f7429i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f7426f) {
            int i10 = this.f7427g;
            if (i10 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f7428h) > this.f7429i) {
                this.f7428h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f7427g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = mo9501H(v10) && coordinatorLayout.m3691F(v10, x10, y11);
            this.f7426f = z10;
            if (z10) {
                this.f7428h = y11;
                this.f7427g = motionEvent.getPointerId(0);
                m9583I();
                OverScroller overScroller = this.f7425e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f7425e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f7430j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7427g = -1;
        this.f7429i = -1;
    }
}
