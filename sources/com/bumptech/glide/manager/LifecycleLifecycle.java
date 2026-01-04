package com.bumptech.glide.manager;

import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0795k;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.InterfaceC0803s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p630s2.C12677l;

/* loaded from: classes.dex */
final class LifecycleLifecycle implements InterfaceC1614l, InterfaceC0795k {

    /* renamed from: a */
    public final Set<InterfaceC1615m> f7102a = new HashSet();

    /* renamed from: b */
    public final AbstractC0791h f7103b;

    public LifecycleLifecycle(AbstractC0791h abstractC0791h) {
        this.f7103b = abstractC0791h;
        abstractC0791h.mo4948a(this);
    }

    @Override // com.bumptech.glide.manager.InterfaceC1614l
    /* renamed from: e */
    public void mo9170e(InterfaceC1615m interfaceC1615m) {
        this.f7102a.add(interfaceC1615m);
        if (this.f7103b.mo4949b() == AbstractC0791h.c.DESTROYED) {
            interfaceC1615m.onDestroy();
        } else if (this.f7103b.mo4949b().m4954b(AbstractC0791h.c.STARTED)) {
            interfaceC1615m.onStart();
        } else {
            interfaceC1615m.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1614l
    /* renamed from: f */
    public void mo9171f(InterfaceC1615m interfaceC1615m) {
        this.f7102a.remove(interfaceC1615m);
    }

    @InterfaceC0803s(AbstractC0791h.b.ON_DESTROY)
    public void onDestroy(InterfaceC0796l interfaceC0796l) {
        Iterator it = C12677l.m76286i(this.f7102a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1615m) it.next()).onDestroy();
        }
        interfaceC0796l.mo1915g().mo4950c(this);
    }

    @InterfaceC0803s(AbstractC0791h.b.ON_START)
    public void onStart(InterfaceC0796l interfaceC0796l) {
        Iterator it = C12677l.m76286i(this.f7102a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1615m) it.next()).onStart();
        }
    }

    @InterfaceC0803s(AbstractC0791h.b.ON_STOP)
    public void onStop(InterfaceC0796l interfaceC0796l) {
        Iterator it = C12677l.m76286i(this.f7102a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1615m) it.next()).onStop();
        }
    }
}
