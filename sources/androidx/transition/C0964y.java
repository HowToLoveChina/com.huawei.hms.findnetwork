package androidx.transition;

import android.view.ViewGroup;

/* renamed from: androidx.transition.y */
/* loaded from: classes.dex */
public class C0964y {
    /* renamed from: a */
    public static int m5844a(ViewGroup viewGroup, int i10) {
        return viewGroup.getChildDrawingOrder(i10);
    }

    /* renamed from: b */
    public static InterfaceC0963x m5845b(ViewGroup viewGroup) {
        return new C0962w(viewGroup);
    }

    /* renamed from: c */
    public static void m5846c(ViewGroup viewGroup, boolean z10) {
        viewGroup.suppressLayout(z10);
    }
}
