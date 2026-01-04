package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p243e0.InterfaceC9366a;

/* renamed from: androidx.activity.g */
/* loaded from: classes.dex */
public abstract class AbstractC0333g {

    /* renamed from: a */
    public boolean f1112a;

    /* renamed from: b */
    public CopyOnWriteArrayList<InterfaceC0327a> f1113b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public InterfaceC9366a<Boolean> f1114c;

    public AbstractC0333g(boolean z10) {
        this.f1112a = z10;
    }

    /* renamed from: a */
    public void m1947a(InterfaceC0327a interfaceC0327a) {
        this.f1113b.add(interfaceC0327a);
    }

    /* renamed from: b */
    public abstract void mo1948b();

    /* renamed from: c */
    public final boolean m1949c() {
        return this.f1112a;
    }

    /* renamed from: d */
    public final void m1950d() {
        Iterator<InterfaceC0327a> it = this.f1113b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* renamed from: e */
    public void m1951e(InterfaceC0327a interfaceC0327a) {
        this.f1113b.remove(interfaceC0327a);
    }

    /* renamed from: f */
    public final void m1952f(boolean z10) {
        this.f1112a = z10;
        InterfaceC9366a<Boolean> interfaceC9366a = this.f1114c;
        if (interfaceC9366a != null) {
            interfaceC9366a.accept(Boolean.valueOf(z10));
        }
    }

    /* renamed from: g */
    public void m1953g(InterfaceC9366a<Boolean> interfaceC9366a) {
        this.f1114c = interfaceC9366a;
    }
}
