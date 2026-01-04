package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b */
    public AnimatorSet f9054b;

    /* renamed from: com.google.android.material.transformation.ExpandableTransformationBehavior$a */
    public class C1889a extends AnimatorListenerAdapter {
        public C1889a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f9054b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    /* renamed from: H */
    public boolean mo11429H(View view, View view2, boolean z10, boolean z11) {
        AnimatorSet animatorSet = this.f9054b;
        boolean z12 = animatorSet != null;
        if (z12) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetMo11431J = mo11431J(view, view2, z10, z12);
        this.f9054b = animatorSetMo11431J;
        animatorSetMo11431J.addListener(new C1889a());
        this.f9054b.start();
        if (!z11) {
            this.f9054b.end();
        }
        return true;
    }

    /* renamed from: J */
    public abstract AnimatorSet mo11431J(View view, View view2, boolean z10, boolean z11);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
