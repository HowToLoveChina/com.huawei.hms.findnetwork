package p759x1;

import java.security.MessageDigest;
import p438l.C11207a;
import p630s2.C12667b;

/* renamed from: x1.i */
/* loaded from: classes.dex */
public final class C13684i implements InterfaceC13681f {

    /* renamed from: b */
    public final C11207a<C13683h<?>, Object> f61617b = new C12667b();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public static <T> void m82283f(C13683h<T> c13683h, Object obj, MessageDigest messageDigest) {
        c13683h.m82282g(obj, messageDigest);
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f61617b.size(); i10++) {
            m82283f(this.f61617b.m67331i(i10), this.f61617b.m67335m(i10), messageDigest);
        }
    }

    /* renamed from: c */
    public <T> T m82284c(C13683h<T> c13683h) {
        return this.f61617b.containsKey(c13683h) ? (T) this.f61617b.get(c13683h) : c13683h.m82280c();
    }

    /* renamed from: d */
    public void m82285d(C13684i c13684i) {
        this.f61617b.mo67332j(c13684i.f61617b);
    }

    /* renamed from: e */
    public <T> C13684i m82286e(C13683h<T> c13683h, T t10) {
        this.f61617b.put(c13683h, t10);
        return this;
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (obj instanceof C13684i) {
            return this.f61617b.equals(((C13684i) obj).f61617b);
        }
        return false;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return this.f61617b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f61617b + '}';
    }
}
