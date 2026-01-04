package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.AbstractC0791h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p321h.C10073a;
import p352i.C10380a;
import p352i.C10381b;

/* renamed from: androidx.lifecycle.m */
/* loaded from: classes.dex */
public class C0797m extends AbstractC0791h {

    /* renamed from: b */
    public C10380a<InterfaceC0795k, a> f4175b;

    /* renamed from: c */
    public AbstractC0791h.c f4176c;

    /* renamed from: d */
    public final WeakReference<InterfaceC0796l> f4177d;

    /* renamed from: e */
    public int f4178e;

    /* renamed from: f */
    public boolean f4179f;

    /* renamed from: g */
    public boolean f4180g;

    /* renamed from: h */
    public ArrayList<AbstractC0791h.c> f4181h;

    /* renamed from: i */
    public final boolean f4182i;

    /* renamed from: androidx.lifecycle.m$a */
    public static class a {

        /* renamed from: a */
        public AbstractC0791h.c f4183a;

        /* renamed from: b */
        public InterfaceC0794j f4184b;

        public a(InterfaceC0795k interfaceC0795k, AbstractC0791h.c cVar) {
            this.f4184b = C0799o.m4976f(interfaceC0795k);
            this.f4183a = cVar;
        }

        /* renamed from: a */
        public void m4970a(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            AbstractC0791h.c cVarM4953e = bVar.m4953e();
            this.f4183a = C0797m.m4957k(this.f4183a, cVarM4953e);
            this.f4184b.mo1925d(interfaceC0796l, bVar);
            this.f4183a = cVarM4953e;
        }
    }

    public C0797m(InterfaceC0796l interfaceC0796l) {
        this(interfaceC0796l, true);
    }

    /* renamed from: k */
    public static AbstractC0791h.c m4957k(AbstractC0791h.c cVar, AbstractC0791h.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    @Override // androidx.lifecycle.AbstractC0791h
    /* renamed from: a */
    public void mo4948a(InterfaceC0795k interfaceC0795k) {
        InterfaceC0796l interfaceC0796l;
        m4960f("addObserver");
        AbstractC0791h.c cVar = this.f4176c;
        AbstractC0791h.c cVar2 = AbstractC0791h.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = AbstractC0791h.c.INITIALIZED;
        }
        a aVar = new a(interfaceC0795k, cVar2);
        if (this.f4175b.mo63816g(interfaceC0795k, aVar) == null && (interfaceC0796l = this.f4177d.get()) != null) {
            boolean z10 = this.f4178e != 0 || this.f4179f;
            AbstractC0791h.c cVarM4959e = m4959e(interfaceC0795k);
            this.f4178e++;
            while (aVar.f4183a.compareTo(cVarM4959e) < 0 && this.f4175b.contains(interfaceC0795k)) {
                m4967n(aVar.f4183a);
                AbstractC0791h.b bVarM4952f = AbstractC0791h.b.m4952f(aVar.f4183a);
                if (bVarM4952f == null) {
                    throw new IllegalStateException("no event up from " + aVar.f4183a);
                }
                aVar.m4970a(interfaceC0796l, bVarM4952f);
                m4966m();
                cVarM4959e = m4959e(interfaceC0795k);
            }
            if (!z10) {
                m4969p();
            }
            this.f4178e--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0791h
    /* renamed from: b */
    public AbstractC0791h.c mo4949b() {
        return this.f4176c;
    }

    @Override // androidx.lifecycle.AbstractC0791h
    /* renamed from: c */
    public void mo4950c(InterfaceC0795k interfaceC0795k) {
        m4960f("removeObserver");
        this.f4175b.mo63817h(interfaceC0795k);
    }

    /* renamed from: d */
    public final void m4958d(InterfaceC0796l interfaceC0796l) {
        Iterator<Map.Entry<InterfaceC0795k, a>> itM63819a = this.f4175b.m63819a();
        while (itM63819a.hasNext() && !this.f4180g) {
            Map.Entry<InterfaceC0795k, a> next = itM63819a.next();
            a value = next.getValue();
            while (value.f4183a.compareTo(this.f4176c) > 0 && !this.f4180g && this.f4175b.contains(next.getKey())) {
                AbstractC0791h.b bVarM4951b = AbstractC0791h.b.m4951b(value.f4183a);
                if (bVarM4951b == null) {
                    throw new IllegalStateException("no event down from " + value.f4183a);
                }
                m4967n(bVarM4951b.m4953e());
                value.m4970a(interfaceC0796l, bVarM4951b);
                m4966m();
            }
        }
    }

    /* renamed from: e */
    public final AbstractC0791h.c m4959e(InterfaceC0795k interfaceC0795k) {
        Map.Entry<InterfaceC0795k, a> entryM63818i = this.f4175b.m63818i(interfaceC0795k);
        AbstractC0791h.c cVar = null;
        AbstractC0791h.c cVar2 = entryM63818i != null ? entryM63818i.getValue().f4183a : null;
        if (!this.f4181h.isEmpty()) {
            cVar = this.f4181h.get(r0.size() - 1);
        }
        return m4957k(m4957k(this.f4176c, cVar2), cVar);
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: f */
    public final void m4960f(String str) {
        if (!this.f4182i || C10073a.m62696d().mo62698b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    /* renamed from: g */
    public final void m4961g(InterfaceC0796l interfaceC0796l) {
        C10381b<InterfaceC0795k, a>.d dVarM63821d = this.f4175b.m63821d();
        while (dVarM63821d.hasNext() && !this.f4180g) {
            Map.Entry next = dVarM63821d.next();
            a aVar = (a) next.getValue();
            while (aVar.f4183a.compareTo(this.f4176c) < 0 && !this.f4180g && this.f4175b.contains((InterfaceC0795k) next.getKey())) {
                m4967n(aVar.f4183a);
                AbstractC0791h.b bVarM4952f = AbstractC0791h.b.m4952f(aVar.f4183a);
                if (bVarM4952f == null) {
                    throw new IllegalStateException("no event up from " + aVar.f4183a);
                }
                aVar.m4970a(interfaceC0796l, bVarM4952f);
                m4966m();
            }
        }
    }

    /* renamed from: h */
    public void m4962h(AbstractC0791h.b bVar) {
        m4960f("handleLifecycleEvent");
        m4965l(bVar.m4953e());
    }

    /* renamed from: i */
    public final boolean m4963i() {
        if (this.f4175b.size() == 0) {
            return true;
        }
        AbstractC0791h.c cVar = this.f4175b.m63820b().getValue().f4183a;
        AbstractC0791h.c cVar2 = this.f4175b.m63822e().getValue().f4183a;
        return cVar == cVar2 && this.f4176c == cVar2;
    }

    @Deprecated
    /* renamed from: j */
    public void m4964j(AbstractC0791h.c cVar) {
        m4960f("markState");
        m4968o(cVar);
    }

    /* renamed from: l */
    public final void m4965l(AbstractC0791h.c cVar) {
        AbstractC0791h.c cVar2 = this.f4176c;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 == AbstractC0791h.c.INITIALIZED && cVar == AbstractC0791h.c.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f4176c);
        }
        this.f4176c = cVar;
        if (this.f4179f || this.f4178e != 0) {
            this.f4180g = true;
            return;
        }
        this.f4179f = true;
        m4969p();
        this.f4179f = false;
        if (this.f4176c == AbstractC0791h.c.DESTROYED) {
            this.f4175b = new C10380a<>();
        }
    }

    /* renamed from: m */
    public final void m4966m() {
        this.f4181h.remove(r1.size() - 1);
    }

    /* renamed from: n */
    public final void m4967n(AbstractC0791h.c cVar) {
        this.f4181h.add(cVar);
    }

    /* renamed from: o */
    public void m4968o(AbstractC0791h.c cVar) {
        m4960f("setCurrentState");
        m4965l(cVar);
    }

    /* renamed from: p */
    public final void m4969p() {
        InterfaceC0796l interfaceC0796l = this.f4177d.get();
        if (interfaceC0796l == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!m4963i()) {
            this.f4180g = false;
            if (this.f4176c.compareTo(this.f4175b.m63820b().getValue().f4183a) < 0) {
                m4958d(interfaceC0796l);
            }
            Map.Entry<InterfaceC0795k, a> entryM63822e = this.f4175b.m63822e();
            if (!this.f4180g && entryM63822e != null && this.f4176c.compareTo(entryM63822e.getValue().f4183a) > 0) {
                m4961g(interfaceC0796l);
            }
        }
        this.f4180g = false;
    }

    public C0797m(InterfaceC0796l interfaceC0796l, boolean z10) {
        this.f4175b = new C10380a<>();
        this.f4178e = 0;
        this.f4179f = false;
        this.f4180g = false;
        this.f4181h = new ArrayList<>();
        this.f4177d = new WeakReference<>(interfaceC0796l);
        this.f4176c = AbstractC0791h.c.INITIALIZED;
        this.f4182i = z10;
    }
}
