package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* renamed from: androidx.transition.j0 */
/* loaded from: classes.dex */
public class C0948j0 implements InterfaceC0950k0 {

    /* renamed from: a */
    public final WindowId f4858a;

    public C0948j0(View view) {
        this.f4858a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0948j0) && ((C0948j0) obj).f4858a.equals(this.f4858a);
    }

    public int hashCode() {
        return this.f4858a.hashCode();
    }
}
