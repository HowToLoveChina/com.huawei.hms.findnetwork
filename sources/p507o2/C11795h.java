package p507o2;

import p507o2.InterfaceC11791d;

/* renamed from: o2.h */
/* loaded from: classes.dex */
public class C11795h implements InterfaceC11791d, InterfaceC11790c {

    /* renamed from: a */
    public final InterfaceC11791d f54661a;

    /* renamed from: b */
    public final Object f54662b;

    /* renamed from: c */
    public volatile InterfaceC11790c f54663c;

    /* renamed from: d */
    public volatile InterfaceC11790c f54664d;

    /* renamed from: e */
    public InterfaceC11791d.a f54665e;

    /* renamed from: f */
    public InterfaceC11791d.a f54666f;

    /* renamed from: g */
    public boolean f54667g;

    public C11795h(Object obj, InterfaceC11791d interfaceC11791d) {
        InterfaceC11791d.a aVar = InterfaceC11791d.a.CLEARED;
        this.f54665e = aVar;
        this.f54666f = aVar;
        this.f54662b = obj;
        this.f54661a = interfaceC11791d;
    }

    /* renamed from: l */
    private boolean m70305l() {
        InterfaceC11791d interfaceC11791d = this.f54661a;
        return interfaceC11791d == null || interfaceC11791d.mo70266c(this);
    }

    /* renamed from: m */
    private boolean m70306m() {
        InterfaceC11791d interfaceC11791d = this.f54661a;
        return interfaceC11791d == null || interfaceC11791d.mo70270g(this);
    }

    /* renamed from: n */
    private boolean m70307n() {
        InterfaceC11791d interfaceC11791d = this.f54661a;
        return interfaceC11791d == null || interfaceC11791d.mo70268e(this);
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: a */
    public void mo70264a(InterfaceC11790c interfaceC11790c) {
        synchronized (this.f54662b) {
            try {
                if (interfaceC11790c.equals(this.f54664d)) {
                    this.f54666f = InterfaceC11791d.a.SUCCESS;
                    return;
                }
                this.f54665e = InterfaceC11791d.a.SUCCESS;
                InterfaceC11791d interfaceC11791d = this.f54661a;
                if (interfaceC11791d != null) {
                    interfaceC11791d.mo70264a(this);
                }
                if (!this.f54666f.m70281b()) {
                    this.f54664d.clear();
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
        synchronized (this.f54662b) {
            try {
                z10 = this.f54664d.mo70265b() || this.f54663c.mo70265b();
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: c */
    public boolean mo70266c(InterfaceC11790c interfaceC11790c) {
        boolean z10;
        synchronized (this.f54662b) {
            try {
                z10 = m70305l() && interfaceC11790c.equals(this.f54663c) && this.f54665e != InterfaceC11791d.a.PAUSED;
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11790c
    public void clear() {
        synchronized (this.f54662b) {
            this.f54667g = false;
            InterfaceC11791d.a aVar = InterfaceC11791d.a.CLEARED;
            this.f54665e = aVar;
            this.f54666f = aVar;
            this.f54664d.clear();
            this.f54663c.clear();
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
        synchronized (this.f54662b) {
            try {
                InterfaceC11791d interfaceC11791d = this.f54661a;
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
        boolean z10;
        synchronized (this.f54662b) {
            try {
                z10 = m70307n() && (interfaceC11790c.equals(this.f54663c) || this.f54665e != InterfaceC11791d.a.SUCCESS);
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: f */
    public boolean mo70269f() {
        boolean z10;
        synchronized (this.f54662b) {
            z10 = this.f54665e == InterfaceC11791d.a.CLEARED;
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: g */
    public boolean mo70270g(InterfaceC11790c interfaceC11790c) {
        boolean z10;
        synchronized (this.f54662b) {
            try {
                z10 = m70306m() && interfaceC11790c.equals(this.f54663c) && !mo70265b();
            } finally {
            }
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: h */
    public boolean mo70271h(InterfaceC11790c interfaceC11790c) {
        if (!(interfaceC11790c instanceof C11795h)) {
            return false;
        }
        C11795h c11795h = (C11795h) interfaceC11790c;
        if (this.f54663c == null) {
            if (c11795h.f54663c != null) {
                return false;
            }
        } else if (!this.f54663c.mo70271h(c11795h.f54663c)) {
            return false;
        }
        if (this.f54664d == null) {
            if (c11795h.f54664d != null) {
                return false;
            }
        } else if (!this.f54664d.mo70271h(c11795h.f54664d)) {
            return false;
        }
        return true;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: i */
    public void mo70272i() {
        synchronized (this.f54662b) {
            try {
                this.f54667g = true;
                try {
                    if (this.f54665e != InterfaceC11791d.a.SUCCESS) {
                        InterfaceC11791d.a aVar = this.f54666f;
                        InterfaceC11791d.a aVar2 = InterfaceC11791d.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f54666f = aVar2;
                            this.f54664d.mo70272i();
                        }
                    }
                    if (this.f54667g) {
                        InterfaceC11791d.a aVar3 = this.f54665e;
                        InterfaceC11791d.a aVar4 = InterfaceC11791d.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.f54665e = aVar4;
                            this.f54663c.mo70272i();
                        }
                    }
                    this.f54667g = false;
                } catch (Throwable th2) {
                    this.f54667g = false;
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // p507o2.InterfaceC11790c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f54662b) {
            z10 = this.f54665e == InterfaceC11791d.a.RUNNING;
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11791d
    /* renamed from: j */
    public void mo70273j(InterfaceC11790c interfaceC11790c) {
        synchronized (this.f54662b) {
            try {
                if (!interfaceC11790c.equals(this.f54663c)) {
                    this.f54666f = InterfaceC11791d.a.FAILED;
                    return;
                }
                this.f54665e = InterfaceC11791d.a.FAILED;
                InterfaceC11791d interfaceC11791d = this.f54661a;
                if (interfaceC11791d != null) {
                    interfaceC11791d.mo70273j(this);
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
        synchronized (this.f54662b) {
            z10 = this.f54665e == InterfaceC11791d.a.SUCCESS;
        }
        return z10;
    }

    /* renamed from: o */
    public void m70308o(InterfaceC11790c interfaceC11790c, InterfaceC11790c interfaceC11790c2) {
        this.f54663c = interfaceC11790c;
        this.f54664d = interfaceC11790c2;
    }

    @Override // p507o2.InterfaceC11790c
    public void pause() {
        synchronized (this.f54662b) {
            try {
                if (!this.f54666f.m70281b()) {
                    this.f54666f = InterfaceC11791d.a.PAUSED;
                    this.f54664d.pause();
                }
                if (!this.f54665e.m70281b()) {
                    this.f54665e = InterfaceC11791d.a.PAUSED;
                    this.f54663c.pause();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
