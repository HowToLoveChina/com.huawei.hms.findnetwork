package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: androidx.transition.a */
/* loaded from: classes.dex */
public class C0929a {
    /* renamed from: a */
    public static void m5778a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    /* renamed from: b */
    public static void m5779b(Animator animator) {
        animator.pause();
    }

    /* renamed from: c */
    public static void m5780c(Animator animator) {
        animator.resume();
    }
}
