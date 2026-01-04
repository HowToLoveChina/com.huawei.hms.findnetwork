package p275f2;

import p630s2.C12676k;
import p829z1.InterfaceC14083v;

/* renamed from: f2.b */
/* loaded from: classes.dex */
public class C9645b<T> implements InterfaceC14083v<T> {

    /* renamed from: a */
    public final T f47778a;

    public C9645b(T t10) {
        this.f47778a = (T) C12676k.m76276d(t10);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public void mo60254a() {
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<T> mo60255c() {
        return (Class<T>) this.f47778a.getClass();
    }

    @Override // p829z1.InterfaceC14083v
    public final T get() {
        return this.f47778a;
    }

    @Override // p829z1.InterfaceC14083v
    public final int getSize() {
        return 1;
    }
}
