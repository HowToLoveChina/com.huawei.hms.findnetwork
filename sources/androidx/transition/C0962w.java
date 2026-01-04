package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: androidx.transition.w */
/* loaded from: classes.dex */
public class C0962w implements InterfaceC0963x {

    /* renamed from: a */
    public final ViewGroupOverlay f4904a;

    public C0962w(ViewGroup viewGroup) {
        this.f4904a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.InterfaceC0930a0
    /* renamed from: a */
    public void mo5781a(Drawable drawable) {
        this.f4904a.add(drawable);
    }

    @Override // androidx.transition.InterfaceC0930a0
    /* renamed from: b */
    public void mo5782b(Drawable drawable) {
        this.f4904a.remove(drawable);
    }

    @Override // androidx.transition.InterfaceC0963x
    /* renamed from: c */
    public void mo5842c(View view) {
        this.f4904a.add(view);
    }

    @Override // androidx.transition.InterfaceC0963x
    /* renamed from: d */
    public void mo5843d(View view) {
        this.f4904a.remove(view);
    }
}
