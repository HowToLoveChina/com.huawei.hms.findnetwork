package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.InterfaceC1711c;

/* renamed from: com.google.android.material.circularreveal.a */
/* loaded from: classes.dex */
public final class C1709a {

    /* renamed from: com.google.android.material.circularreveal.a$a */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1711c f7853a;

        public a(InterfaceC1711c interfaceC1711c) {
            this.f7853a = interfaceC1711c;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7853a.mo10175b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f7853a.mo10174a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static Animator m10178a(InterfaceC1711c interfaceC1711c, float f10, float f11, float f12) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(interfaceC1711c, (Property<InterfaceC1711c, V>) InterfaceC1711c.c.f7866a, (TypeEvaluator) InterfaceC1711c.b.f7864b, (Object[]) new InterfaceC1711c.e[]{new InterfaceC1711c.e(f10, f11, f12)});
        InterfaceC1711c.e revealInfo = interfaceC1711c.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) interfaceC1711c, (int) f10, (int) f11, revealInfo.f7870c, f12);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    /* renamed from: b */
    public static Animator.AnimatorListener m10179b(InterfaceC1711c interfaceC1711c) {
        return new a(interfaceC1711c);
    }
}
