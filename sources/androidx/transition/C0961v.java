package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* renamed from: androidx.transition.v */
/* loaded from: classes.dex */
public class C0961v {

    /* renamed from: androidx.transition.v$a */
    public static class a extends AnimatorListenerAdapter implements Transition.InterfaceC0923f {

        /* renamed from: a */
        public final View f4895a;

        /* renamed from: b */
        public final View f4896b;

        /* renamed from: c */
        public final int f4897c;

        /* renamed from: d */
        public final int f4898d;

        /* renamed from: e */
        public int[] f4899e;

        /* renamed from: f */
        public float f4900f;

        /* renamed from: g */
        public float f4901g;

        /* renamed from: h */
        public final float f4902h;

        /* renamed from: i */
        public final float f4903i;

        public a(View view, View view2, int i10, int i11, float f10, float f11) {
            this.f4896b = view;
            this.f4895a = view2;
            this.f4897c = i10 - Math.round(view.getTranslationX());
            this.f4898d = i11 - Math.round(view.getTranslationY());
            this.f4902h = f10;
            this.f4903i = f11;
            int i12 = R$id.transition_position;
            int[] iArr = (int[]) view2.getTag(i12);
            this.f4899e = iArr;
            if (iArr != null) {
                view2.setTag(i12, null);
            }
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: a */
        public void mo5755a(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: b */
        public void mo5636b(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            this.f4896b.setTranslationX(this.f4902h);
            this.f4896b.setTranslationY(this.f4903i);
            transition.mo5721V(this);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: d */
        public void mo5638d(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: e */
        public void mo5639e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f4899e == null) {
                this.f4899e = new int[2];
            }
            this.f4899e[0] = Math.round(this.f4897c + this.f4896b.getTranslationX());
            this.f4899e[1] = Math.round(this.f4898d + this.f4896b.getTranslationY());
            this.f4895a.setTag(R$id.transition_position, this.f4899e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f4900f = this.f4896b.getTranslationX();
            this.f4901g = this.f4896b.getTranslationY();
            this.f4896b.setTranslationX(this.f4902h);
            this.f4896b.setTranslationY(this.f4903i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f4896b.setTranslationX(this.f4900f);
            this.f4896b.setTranslationY(this.f4901g);
        }
    }

    /* renamed from: a */
    public static Animator m5841a(View view, C0959t c0959t, int i10, int i11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, Transition transition) {
        float f14;
        float f15;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) c0959t.f4889b.getTag(R$id.transition_position)) != null) {
            f14 = (r7[0] - i10) + translationX;
            f15 = (r7[1] - i11) + translationY;
        } else {
            f14 = f10;
            f15 = f11;
        }
        int iRound = Math.round(f14 - translationX) + i10;
        int iRound2 = i11 + Math.round(f15 - translationY);
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        if (f14 == f12 && f15 == f13) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f14, f12), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f15, f13));
        a aVar = new a(view, c0959t.f4889b, iRound, iRound2, translationX, translationY);
        transition.mo5726a(aVar);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        C0929a.m5778a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
