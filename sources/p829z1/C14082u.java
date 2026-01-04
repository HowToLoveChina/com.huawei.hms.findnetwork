package p829z1;

import p243e0.InterfaceC9370e;
import p630s2.C12676k;
import p645t2.AbstractC12922c;
import p645t2.C12920a;

/* renamed from: z1.u */
/* loaded from: classes.dex */
public final class C14082u<Z> implements InterfaceC14083v<Z>, C12920a.f {

    /* renamed from: e */
    public static final InterfaceC9370e<C14082u<?>> f63049e = C12920a.m77569d(20, new a());

    /* renamed from: a */
    public final AbstractC12922c f63050a = AbstractC12922c.m77581a();

    /* renamed from: b */
    public InterfaceC14083v<Z> f63051b;

    /* renamed from: c */
    public boolean f63052c;

    /* renamed from: d */
    public boolean f63053d;

    /* renamed from: z1.u$a */
    public class a implements C12920a.d<C14082u<?>> {
        @Override // p645t2.C12920a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C14082u<?> mo6551a() {
            return new C14082u<>();
        }
    }

    /* renamed from: d */
    public static <Z> C14082u<Z> m84416d(InterfaceC14083v<Z> interfaceC14083v) {
        C14082u<Z> c14082u = (C14082u) C12676k.m76276d(f63049e.mo58738b());
        c14082u.m84418b(interfaceC14083v);
        return c14082u;
    }

    /* renamed from: e */
    private void m84417e() {
        this.f63051b = null;
        f63049e.mo58737a(this);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public synchronized void mo60254a() {
        this.f63050a.mo77583c();
        this.f63053d = true;
        if (!this.f63052c) {
            this.f63051b.mo60254a();
            m84417e();
        }
    }

    /* renamed from: b */
    public final void m84418b(InterfaceC14083v<Z> interfaceC14083v) {
        this.f63053d = false;
        this.f63052c = true;
        this.f63051b = interfaceC14083v;
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<Z> mo60255c() {
        return this.f63051b.mo60255c();
    }

    /* renamed from: f */
    public synchronized void m84419f() {
        this.f63050a.mo77583c();
        if (!this.f63052c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f63052c = false;
        if (this.f63053d) {
            mo60254a();
        }
    }

    @Override // p829z1.InterfaceC14083v
    public Z get() {
        return this.f63051b.get();
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return this.f63051b.getSize();
    }

    @Override // p645t2.C12920a.f
    /* renamed from: i */
    public AbstractC12922c mo6553i() {
        return this.f63050a;
    }
}
