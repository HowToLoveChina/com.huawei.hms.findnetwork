package p507o2;

import p507o2.InterfaceC11791d;

/* renamed from: o2.a */
/* loaded from: classes.dex */
public final class C11788a implements InterfaceC11791d, InterfaceC11790c {

    /* renamed from: a */
    public final Object f54610a;

    /* renamed from: b */
    public final InterfaceC11791d f54611b;

    /* renamed from: c */
    public volatile InterfaceC11790c f54612c;

    /* renamed from: d */
    public volatile InterfaceC11790c f54613d;

    /* renamed from: e */
    public InterfaceC11791d.a f54614e;

    /* renamed from: f */
    public InterfaceC11791d.a f54615f;

    public C11788a(Object obj, InterfaceC11791d interfaceC11791d) {
        InterfaceC11791d.a aVar = InterfaceC11791d.a.CLEARED;
        this.f54614e = aVar;
        this.f54615f = aVar;
        this.f54610a = obj;
        this.f54611b = interfaceC11791d;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: a */
    public void mo70264a(InterfaceC11790c interfaceC11790c) {
        synchronized (this.f54610a) {
            try {
                if (interfaceC11790c.equals(this.f54612c)) {
                    this.f54614e = InterfaceC11791d.a.SUCCESS;
                } else if (interfaceC11790c.equals(this.f54613d)) {
                    this.f54615f = InterfaceC11791d.a.SUCCESS;
                }
                InterfaceC11791d interfaceC11791d = this.f54611b;
                if (interfaceC11791d != null) {
                    interfaceC11791d.mo70264a(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p507o2.InterfaceC11791d, p507o2.InterfaceC11790c
    /* renamed from: b */
    public boolean mo70265b() {
        boolean z10;
        synchronized (this.f54610a) {
            try {
                z10 = this.f54612c.mo70265b() || this.f54613d.mo70265b();
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: c */
    public boolean mo70266c(InterfaceC11790c interfaceC11790c) {
        boolean z10;
        synchronized (this.f54610a) {
            try {
                z10 = m70276m() && interfaceC11790c.equals(this.f54612c);
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11790c
    public void clear() {
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d.a aVar = InterfaceC11791d.a.CLEARED;
                this.f54614e = aVar;
                this.f54612c.clear();
                if (this.f54615f != aVar) {
                    this.f54615f = aVar;
                    this.f54613d.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [o2.d] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // p507o2.InterfaceC11791d
    /* renamed from: d */
    public InterfaceC11791d mo70267d() {
        ?? Mo70267d;
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d interfaceC11791d = this.f54611b;
                this = this;
                if (interfaceC11791d != null) {
                    Mo70267d = interfaceC11791d.mo70267d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return Mo70267d;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: e */
    public boolean mo70268e(InterfaceC11790c interfaceC11790c) {
        boolean zM70278o;
        synchronized (this.f54610a) {
            zM70278o = m70278o();
        }
        return zM70278o;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: f */
    public boolean mo70269f() {
        boolean z10;
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d.a aVar = this.f54614e;
                InterfaceC11791d.a aVar2 = InterfaceC11791d.a.CLEARED;
                z10 = aVar == aVar2 && this.f54615f == aVar2;
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: g */
    public boolean mo70270g(InterfaceC11790c interfaceC11790c) {
        boolean z10;
        synchronized (this.f54610a) {
            try {
                z10 = m70277n() && m70275l(interfaceC11790c);
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: h */
    public boolean mo70271h(InterfaceC11790c interfaceC11790c) {
        if (!(interfaceC11790c instanceof C11788a)) {
            return false;
        }
        C11788a c11788a = (C11788a) interfaceC11790c;
        return this.f54612c.mo70271h(c11788a.f54612c) && this.f54613d.mo70271h(c11788a.f54613d);
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: i */
    public void mo70272i() {
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d.a aVar = this.f54614e;
                InterfaceC11791d.a aVar2 = InterfaceC11791d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f54614e = aVar2;
                    this.f54612c.mo70272i();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p507o2.InterfaceC11790c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d.a aVar = this.f54614e;
                InterfaceC11791d.a aVar2 = InterfaceC11791d.a.RUNNING;
                z10 = aVar == aVar2 || this.f54615f == aVar2;
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: j */
    public void mo70273j(InterfaceC11790c interfaceC11790c) {
        synchronized (this.f54610a) {
            try {
                if (interfaceC11790c.equals(this.f54613d)) {
                    this.f54615f = InterfaceC11791d.a.FAILED;
                    InterfaceC11791d interfaceC11791d = this.f54611b;
                    if (interfaceC11791d != null) {
                        interfaceC11791d.mo70273j(this);
                    }
                    return;
                }
                this.f54614e = InterfaceC11791d.a.FAILED;
                InterfaceC11791d.a aVar = this.f54615f;
                InterfaceC11791d.a aVar2 = InterfaceC11791d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f54615f = aVar2;
                    this.f54613d.mo70272i();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: k */
    public boolean mo70274k() {
        boolean z10;
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d.a aVar = this.f54614e;
                InterfaceC11791d.a aVar2 = InterfaceC11791d.a.SUCCESS;
                z10 = aVar == aVar2 || this.f54615f == aVar2;
            } finally {
            }
        }
        return z10;
    }

    /* renamed from: l */
    public final boolean m70275l(InterfaceC11790c interfaceC11790c) {
        InterfaceC11791d.a aVar;
        InterfaceC11791d.a aVar2 = this.f54614e;
        InterfaceC11791d.a aVar3 = InterfaceC11791d.a.FAILED;
        return aVar2 != aVar3 ? interfaceC11790c.equals(this.f54612c) : interfaceC11790c.equals(this.f54613d) && ((aVar = this.f54615f) == InterfaceC11791d.a.SUCCESS || aVar == aVar3);
    }

    /* renamed from: m */
    public final boolean m70276m() {
        InterfaceC11791d interfaceC11791d = this.f54611b;
        return interfaceC11791d == null || interfaceC11791d.mo70266c(this);
    }

    /* renamed from: n */
    public final boolean m70277n() {
        InterfaceC11791d interfaceC11791d = this.f54611b;
        return interfaceC11791d == null || interfaceC11791d.mo70270g(this);
    }

    /* renamed from: o */
    public final boolean m70278o() {
        InterfaceC11791d interfaceC11791d = this.f54611b;
        return interfaceC11791d == null || interfaceC11791d.mo70268e(this);
    }

    /* renamed from: p */
    public void m70279p(InterfaceC11790c interfaceC11790c, InterfaceC11790c interfaceC11790c2) {
        this.f54612c = interfaceC11790c;
        this.f54613d = interfaceC11790c2;
    }

    @Override // p507o2.InterfaceC11790c
    public void pause() {
        synchronized (this.f54610a) {
            try {
                InterfaceC11791d.a aVar = this.f54614e;
                InterfaceC11791d.a aVar2 = InterfaceC11791d.a.RUNNING;
                if (aVar == aVar2) {
                    this.f54614e = InterfaceC11791d.a.PAUSED;
                    this.f54612c.pause();
                }
                if (this.f54615f == aVar2) {
                    this.f54615f = InterfaceC11791d.a.PAUSED;
                    this.f54613d.pause();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
