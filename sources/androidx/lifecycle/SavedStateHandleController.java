package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;
import p724w0.C13512b;

/* loaded from: classes.dex */
final class SavedStateHandleController implements InterfaceC0794j {

    /* renamed from: a */
    public final String f4134a;

    /* renamed from: b */
    public boolean f4135b = false;

    /* renamed from: c */
    public final C0806v f4136c;

    public SavedStateHandleController(String str, C0806v c0806v) {
        this.f4134a = str;
        this.f4136c = c0806v;
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        if (bVar == AbstractC0791h.b.ON_DESTROY) {
            this.f4135b = false;
            interfaceC0796l.mo1915g().mo4950c(this);
        }
    }

    /* renamed from: e */
    public void m4908e(C13512b c13512b, AbstractC0791h abstractC0791h) {
        if (this.f4135b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f4135b = true;
        abstractC0791h.mo4948a(this);
        c13512b.m81267h(this.f4134a, this.f4136c.m4991d());
    }

    /* renamed from: f */
    public C0806v m4909f() {
        return this.f4136c;
    }

    /* renamed from: g */
    public boolean m4910g() {
        return this.f4135b;
    }
}
