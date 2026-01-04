package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements InterfaceC0794j {

    /* renamed from: a */
    public final /* synthetic */ Handler f4963a;

    /* renamed from: b */
    public final /* synthetic */ Runnable f4964b;

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        if (bVar == AbstractC0791h.b.ON_DESTROY) {
            this.f4963a.removeCallbacks(this.f4964b);
            interfaceC0796l.mo1915g().mo4950c(this);
        }
    }
}
