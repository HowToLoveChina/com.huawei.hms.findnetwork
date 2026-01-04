package com.bumptech.glide.manager;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import p507o2.InterfaceC11790c;
import p630s2.C12677l;

/* renamed from: com.bumptech.glide.manager.r */
/* loaded from: classes.dex */
public class C1620r {

    /* renamed from: a */
    public final Set<InterfaceC11790c> f7134a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    public final Set<InterfaceC11790c> f7135b = new HashSet();

    /* renamed from: c */
    public boolean f7136c;

    /* renamed from: a */
    public boolean m9213a(InterfaceC11790c interfaceC11790c) {
        boolean z10 = true;
        if (interfaceC11790c == null) {
            return true;
        }
        boolean zRemove = this.f7134a.remove(interfaceC11790c);
        if (!this.f7135b.remove(interfaceC11790c) && !zRemove) {
            z10 = false;
        }
        if (z10) {
            interfaceC11790c.clear();
        }
        return z10;
    }

    /* renamed from: b */
    public void m9214b() {
        Iterator it = C12677l.m76286i(this.f7134a).iterator();
        while (it.hasNext()) {
            m9213a((InterfaceC11790c) it.next());
        }
        this.f7135b.clear();
    }

    /* renamed from: c */
    public void m9215c() {
        this.f7136c = true;
        for (InterfaceC11790c interfaceC11790c : C12677l.m76286i(this.f7134a)) {
            if (interfaceC11790c.isRunning() || interfaceC11790c.mo70274k()) {
                interfaceC11790c.clear();
                this.f7135b.add(interfaceC11790c);
            }
        }
    }

    /* renamed from: d */
    public void m9216d() {
        this.f7136c = true;
        for (InterfaceC11790c interfaceC11790c : C12677l.m76286i(this.f7134a)) {
            if (interfaceC11790c.isRunning()) {
                interfaceC11790c.pause();
                this.f7135b.add(interfaceC11790c);
            }
        }
    }

    /* renamed from: e */
    public void m9217e() {
        for (InterfaceC11790c interfaceC11790c : C12677l.m76286i(this.f7134a)) {
            if (!interfaceC11790c.mo70274k() && !interfaceC11790c.mo70269f()) {
                interfaceC11790c.clear();
                if (this.f7136c) {
                    this.f7135b.add(interfaceC11790c);
                } else {
                    interfaceC11790c.mo70272i();
                }
            }
        }
    }

    /* renamed from: f */
    public void m9218f() {
        this.f7136c = false;
        for (InterfaceC11790c interfaceC11790c : C12677l.m76286i(this.f7134a)) {
            if (!interfaceC11790c.mo70274k() && !interfaceC11790c.isRunning()) {
                interfaceC11790c.mo70272i();
            }
        }
        this.f7135b.clear();
    }

    /* renamed from: g */
    public void m9219g(InterfaceC11790c interfaceC11790c) {
        this.f7134a.add(interfaceC11790c);
        if (!this.f7136c) {
            interfaceC11790c.mo70272i();
            return;
        }
        interfaceC11790c.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f7135b.add(interfaceC11790c);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f7134a.size() + ", isPaused=" + this.f7136c + "}";
    }
}
