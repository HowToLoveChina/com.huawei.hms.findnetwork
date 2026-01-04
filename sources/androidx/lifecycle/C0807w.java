package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0782c0;
import p597r0.AbstractC12450a;
import p597r0.C12452c;
import p692uw.AbstractC13268k;
import p692uw.C13267j;
import p692uw.C13274q;
import p724w0.C13512b;
import p724w0.InterfaceC13514d;
import tw.InterfaceC13086l;

/* renamed from: androidx.lifecycle.w */
/* loaded from: classes.dex */
public final class C0807w {

    /* renamed from: a */
    public static final AbstractC12450a.b<InterfaceC13514d> f4207a = new b();

    /* renamed from: b */
    public static final AbstractC12450a.b<InterfaceC0788f0> f4208b = new c();

    /* renamed from: c */
    public static final AbstractC12450a.b<Bundle> f4209c = new a();

    /* renamed from: androidx.lifecycle.w$a */
    public static final class a implements AbstractC12450a.b<Bundle> {
    }

    /* renamed from: androidx.lifecycle.w$b */
    public static final class b implements AbstractC12450a.b<InterfaceC13514d> {
    }

    /* renamed from: androidx.lifecycle.w$c */
    public static final class c implements AbstractC12450a.b<InterfaceC0788f0> {
    }

    /* renamed from: androidx.lifecycle.w$d */
    public static final class d extends AbstractC13268k implements InterfaceC13086l<AbstractC12450a, C0809y> {

        /* renamed from: b */
        public static final d f4210b = new d();

        public d() {
            super(1);
        }

        @Override // tw.InterfaceC13086l
        /* renamed from: e */
        public final C0809y mo5000c(AbstractC12450a abstractC12450a) {
            C13267j.m79677e(abstractC12450a, "$this$initializer");
            return new C0809y();
        }
    }

    /* renamed from: a */
    public static final C0806v m4995a(AbstractC12450a abstractC12450a) {
        C13267j.m79677e(abstractC12450a, "<this>");
        InterfaceC13514d interfaceC13514d = (InterfaceC13514d) abstractC12450a.mo74704a(f4207a);
        if (interfaceC13514d == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        InterfaceC0788f0 interfaceC0788f0 = (InterfaceC0788f0) abstractC12450a.mo74704a(f4208b);
        if (interfaceC0788f0 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) abstractC12450a.mo74704a(f4209c);
        String str = (String) abstractC12450a.mo74704a(C0782c0.c.f4162d);
        if (str != null) {
            return m4996b(interfaceC13514d, interfaceC0788f0, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    /* renamed from: b */
    public static final C0806v m4996b(InterfaceC13514d interfaceC13514d, InterfaceC0788f0 interfaceC0788f0, String str, Bundle bundle) {
        C0808x c0808xM4998d = m4998d(interfaceC13514d);
        C0809y c0809yM4999e = m4999e(interfaceC0788f0);
        C0806v c0806v = c0809yM4999e.m5007f().get(str);
        if (c0806v != null) {
            return c0806v;
        }
        C0806v c0806vM4993a = C0806v.f4200f.m4993a(c0808xM4998d.m5002b(str), bundle);
        c0809yM4999e.m5007f().put(str, c0806vM4993a);
        return c0806vM4993a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public static final <T extends InterfaceC13514d & InterfaceC0788f0> void m4997c(T t10) {
        C13267j.m79677e(t10, "<this>");
        AbstractC0791h.c cVarMo4949b = t10.mo1915g().mo4949b();
        C13267j.m79676d(cVarMo4949b, "lifecycle.currentState");
        if (cVarMo4949b != AbstractC0791h.c.INITIALIZED && cVarMo4949b != AbstractC0791h.c.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t10.mo1909J().m81263c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            C0808x c0808x = new C0808x(t10.mo1909J(), t10);
            t10.mo1909J().m81267h("androidx.lifecycle.internal.SavedStateHandlesProvider", c0808x);
            t10.mo1915g().mo4948a(new SavedStateHandleAttacher(c0808x));
        }
    }

    /* renamed from: d */
    public static final C0808x m4998d(InterfaceC13514d interfaceC13514d) {
        C13267j.m79677e(interfaceC13514d, "<this>");
        C13512b.c cVarM81263c = interfaceC13514d.mo1909J().m81263c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        C0808x c0808x = cVarM81263c instanceof C0808x ? (C0808x) cVarM81263c : null;
        if (c0808x != null) {
            return c0808x;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    /* renamed from: e */
    public static final C0809y m4999e(InterfaceC0788f0 interfaceC0788f0) {
        C13267j.m79677e(interfaceC0788f0, "<this>");
        C12452c c12452c = new C12452c();
        c12452c.m74706a(C13274q.m79691a(C0809y.class), d.f4210b);
        return (C0809y) new C0782c0(interfaceC0788f0, c12452c.m74707b()).m4930b("androidx.lifecycle.internal.SavedStateHandlesVM", C0809y.class);
    }
}
