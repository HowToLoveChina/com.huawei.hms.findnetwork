package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: androidx.transition.z */
/* loaded from: classes.dex */
public class C0965z implements InterfaceC0930a0 {

    /* renamed from: a */
    public final ViewOverlay f4905a;

    public C0965z(View view) {
        this.f4905a = view.getOverlay();
    }

    @Override // androidx.transition.InterfaceC0930a0
    /* renamed from: a */
    public void mo5781a(Drawable drawable) {
        this.f4905a.add(drawable);
    }

    @Override // androidx.transition.InterfaceC0930a0
    /* renamed from: b */
    public void mo5782b(Drawable drawable) {
        this.f4905a.remove(drawable);
    }
}
