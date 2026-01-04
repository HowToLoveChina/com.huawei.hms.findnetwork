package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* renamed from: com.google.android.material.internal.j */
/* loaded from: classes.dex */
public final class C1779j {

    /* renamed from: a */
    public final ArrayList<b> f8374a = new ArrayList<>();

    /* renamed from: b */
    public b f8375b = null;

    /* renamed from: c */
    public ValueAnimator f8376c = null;

    /* renamed from: d */
    public final Animator.AnimatorListener f8377d = new a();

    /* renamed from: com.google.android.material.internal.j$a */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1779j c1779j = C1779j.this;
            if (c1779j.f8376c == animator) {
                c1779j.f8376c = null;
            }
        }
    }

    /* renamed from: com.google.android.material.internal.j$b */
    public static class b {

        /* renamed from: a */
        public final int[] f8379a;

        /* renamed from: b */
        public final ValueAnimator f8380b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f8379a = iArr;
            this.f8380b = valueAnimator;
        }
    }

    /* renamed from: a */
    public void m10742a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f8377d);
        this.f8374a.add(bVar);
    }
}
