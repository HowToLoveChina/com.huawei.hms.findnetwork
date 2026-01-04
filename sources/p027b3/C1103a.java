package p027b3;

import android.animation.Animator;

/* renamed from: b3.a */
/* loaded from: classes.dex */
public class C1103a {

    /* renamed from: a */
    public Animator f5235a;

    /* renamed from: a */
    public void m6554a() {
        Animator animator = this.f5235a;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: b */
    public void m6555b() {
        this.f5235a = null;
    }

    /* renamed from: c */
    public void m6556c(Animator animator) {
        m6554a();
        this.f5235a = animator;
    }
}
