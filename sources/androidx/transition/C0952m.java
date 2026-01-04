package androidx.transition;

import android.view.ViewGroup;

/* renamed from: androidx.transition.m */
/* loaded from: classes.dex */
public class C0952m {

    /* renamed from: a */
    public ViewGroup f4860a;

    /* renamed from: b */
    public Runnable f4861b;

    /* renamed from: b */
    public static C0952m m5826b(ViewGroup viewGroup) {
        return (C0952m) viewGroup.getTag(R$id.transition_current_scene);
    }

    /* renamed from: c */
    public static void m5827c(ViewGroup viewGroup, C0952m c0952m) {
        viewGroup.setTag(R$id.transition_current_scene, c0952m);
    }

    /* renamed from: a */
    public void m5828a() {
        Runnable runnable;
        if (m5826b(this.f4860a) != this || (runnable = this.f4861b) == null) {
            return;
        }
        runnable.run();
    }
}
