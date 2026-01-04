package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p666u2.C13110a;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    public int f7498a;

    /* renamed from: b */
    public int f7499b;

    /* renamed from: c */
    public int f7500c;

    /* renamed from: d */
    public ViewPropertyAnimator f7501d;

    /* renamed from: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$a */
    public class C1654a extends AnimatorListenerAdapter {
        public C1654a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f7501d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f7498a = 0;
        this.f7499b = 2;
        this.f7500c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: A */
    public boolean mo3723A(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    /* renamed from: F */
    public final void m9706F(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f7501d = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new C1654a());
    }

    /* renamed from: G */
    public boolean m9707G() {
        return this.f7499b == 1;
    }

    /* renamed from: H */
    public boolean m9708H() {
        return this.f7499b == 2;
    }

    /* renamed from: I */
    public void m9709I(V v10, int i10) {
        this.f7500c = i10;
        if (this.f7499b == 1) {
            v10.setTranslationY(this.f7498a + i10);
        }
    }

    /* renamed from: J */
    public void m9710J(V v10) {
        m9711K(v10, true);
    }

    /* renamed from: K */
    public void m9711K(V v10, boolean z10) {
        if (m9707G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f7501d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        this.f7499b = 1;
        int i10 = this.f7498a + this.f7500c;
        if (z10) {
            m9706F(v10, i10, 175L, C13110a.f59599c);
        } else {
            v10.setTranslationY(i10);
        }
    }

    /* renamed from: L */
    public void m9712L(V v10) {
        m9713M(v10, true);
    }

    /* renamed from: M */
    public void m9713M(V v10, boolean z10) {
        if (m9708H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f7501d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        this.f7499b = 2;
        if (z10) {
            m9706F(v10, 0, 225L, C13110a.f59600d);
        } else {
            v10.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: l */
    public boolean mo3738l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        this.f7498a = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        return super.mo3738l(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: t */
    public void mo3746t(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            m9710J(v10);
        } else if (i11 < 0) {
            m9712L(v10);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7498a = 0;
        this.f7499b = 2;
        this.f7500c = 0;
    }
}
