package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import p630s2.C12677l;

/* renamed from: com.bumptech.glide.manager.a */
/* loaded from: classes.dex */
public class C1603a implements InterfaceC1614l {

    /* renamed from: a */
    public final Set<InterfaceC1615m> f7111a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    public boolean f7112b;

    /* renamed from: c */
    public boolean f7113c;

    /* renamed from: a */
    public void m9185a() {
        this.f7113c = true;
        Iterator it = C12677l.m76286i(this.f7111a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1615m) it.next()).onDestroy();
        }
    }

    /* renamed from: b */
    public void m9186b() {
        this.f7112b = true;
        Iterator it = C12677l.m76286i(this.f7111a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1615m) it.next()).onStart();
        }
    }

    /* renamed from: c */
    public void m9187c() {
        this.f7112b = false;
        Iterator it = C12677l.m76286i(this.f7111a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1615m) it.next()).onStop();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1614l
    /* renamed from: e */
    public void mo9170e(InterfaceC1615m interfaceC1615m) {
        this.f7111a.add(interfaceC1615m);
        if (this.f7113c) {
            interfaceC1615m.onDestroy();
        } else if (this.f7112b) {
            interfaceC1615m.onStart();
        } else {
            interfaceC1615m.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1614l
    /* renamed from: f */
    public void mo9171f(InterfaceC1615m interfaceC1615m) {
        this.f7111a.remove(interfaceC1615m);
    }
}
