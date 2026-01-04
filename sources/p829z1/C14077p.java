package p829z1;

import p630s2.C12676k;
import p759x1.InterfaceC13681f;

/* renamed from: z1.p */
/* loaded from: classes.dex */
public class C14077p<Z> implements InterfaceC14083v<Z> {

    /* renamed from: a */
    public final boolean f63027a;

    /* renamed from: b */
    public final boolean f63028b;

    /* renamed from: c */
    public final InterfaceC14083v<Z> f63029c;

    /* renamed from: d */
    public final a f63030d;

    /* renamed from: e */
    public final InterfaceC13681f f63031e;

    /* renamed from: f */
    public int f63032f;

    /* renamed from: g */
    public boolean f63033g;

    /* renamed from: z1.p$a */
    public interface a {
        /* renamed from: c */
        void mo84358c(InterfaceC13681f interfaceC13681f, C14077p<?> c14077p);
    }

    public C14077p(InterfaceC14083v<Z> interfaceC14083v, boolean z10, boolean z11, InterfaceC13681f interfaceC13681f, a aVar) {
        this.f63029c = (InterfaceC14083v) C12676k.m76276d(interfaceC14083v);
        this.f63027a = z10;
        this.f63028b = z11;
        this.f63031e = interfaceC13681f;
        this.f63030d = (a) C12676k.m76276d(aVar);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public synchronized void mo60254a() {
        if (this.f63032f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f63033g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f63033g = true;
        if (this.f63028b) {
            this.f63029c.mo60254a();
        }
    }

    /* renamed from: b */
    public synchronized void m84394b() {
        if (this.f63033g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f63032f++;
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<Z> mo60255c() {
        return this.f63029c.mo60255c();
    }

    /* renamed from: d */
    public InterfaceC14083v<Z> m84395d() {
        return this.f63029c;
    }

    /* renamed from: e */
    public boolean m84396e() {
        return this.f63027a;
    }

    /* renamed from: f */
    public void m84397f() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f63032f;
            if (i10 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i11 = i10 - 1;
            this.f63032f = i11;
            if (i11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            this.f63030d.mo84358c(this.f63031e, this);
        }
    }

    @Override // p829z1.InterfaceC14083v
    public Z get() {
        return this.f63029c.get();
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return this.f63029c.getSize();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f63027a + ", listener=" + this.f63030d + ", key=" + this.f63031e + ", acquired=" + this.f63032f + ", isRecycled=" + this.f63033g + ", resource=" + this.f63029c + '}';
    }
}
