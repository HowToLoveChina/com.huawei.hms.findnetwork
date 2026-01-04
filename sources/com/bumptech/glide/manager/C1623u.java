package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import p542p2.InterfaceC12082i;
import p630s2.C12677l;

/* renamed from: com.bumptech.glide.manager.u */
/* loaded from: classes.dex */
public final class C1623u implements InterfaceC1615m {

    /* renamed from: a */
    public final Set<InterfaceC12082i<?>> f7158a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: i */
    public void m9243i() {
        this.f7158a.clear();
    }

    /* renamed from: j */
    public List<InterfaceC12082i<?>> m9244j() {
        return C12677l.m76286i(this.f7158a);
    }

    /* renamed from: k */
    public void m9245k(InterfaceC12082i<?> interfaceC12082i) {
        this.f7158a.add(interfaceC12082i);
    }

    /* renamed from: l */
    public void m9246l(InterfaceC12082i<?> interfaceC12082i) {
        this.f7158a.remove(interfaceC12082i);
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onDestroy() {
        Iterator it = C12677l.m76286i(this.f7158a).iterator();
        while (it.hasNext()) {
            ((InterfaceC12082i) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onStart() {
        Iterator it = C12677l.m76286i(this.f7158a).iterator();
        while (it.hasNext()) {
            ((InterfaceC12082i) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onStop() {
        Iterator it = C12677l.m76286i(this.f7158a).iterator();
        while (it.hasNext()) {
            ((InterfaceC12082i) it.next()).onStop();
        }
    }
}
