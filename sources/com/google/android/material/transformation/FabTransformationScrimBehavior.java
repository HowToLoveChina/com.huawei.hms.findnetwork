package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import p666u2.C13111b;
import p666u2.C13118i;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c */
    public final C13118i f9075c;

    /* renamed from: d */
    public final C13118i f9076d;

    /* renamed from: com.google.android.material.transformation.FabTransformationScrimBehavior$a */
    public class C1895a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f9077a;

        /* renamed from: b */
        public final /* synthetic */ View f9078b;

        public C1895a(boolean z10, View view) {
            this.f9077a = z10;
            this.f9078b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f9077a) {
                return;
            }
            this.f9078b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f9077a) {
                this.f9078b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f9075c = new C13118i(75L, 150L);
        this.f9076d = new C13118i(0L, 150L);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: D */
    public boolean mo3726D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.mo3726D(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /* renamed from: J */
    public AnimatorSet mo11431J(View view, View view2, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        m11454K(view2, z10, z11, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        C13111b.m78887a(animatorSet, arrayList);
        animatorSet.addListener(new C1895a(z10, view2));
        return animatorSet;
    }

    /* renamed from: K */
    public final void m11454K(View view, boolean z10, boolean z11, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        C13118i c13118i = z10 ? this.f9075c : this.f9076d;
        if (z10) {
            if (!z11) {
                view.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        c13118i.m78911a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: e */
    public boolean mo3731e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9075c = new C13118i(75L, 150L);
        this.f9076d = new C13118i(0L, 150L);
    }
}
