package p243e0;

/* renamed from: e0.d */
/* loaded from: classes.dex */
public class C9369d<F, S> {

    /* renamed from: a */
    public final F f46769a;

    /* renamed from: b */
    public final S f46770b;

    public C9369d(F f10, S s10) {
        this.f46769a = f10;
        this.f46770b = s10;
    }

    /* renamed from: a */
    public static <A, B> C9369d<A, B> m58736a(A a10, B b10) {
        return new C9369d<>(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C9369d)) {
            return false;
        }
        C9369d c9369d = (C9369d) obj;
        return C9368c.m58729a(c9369d.f46769a, this.f46769a) && C9368c.m58729a(c9369d.f46770b, this.f46770b);
    }

    public int hashCode() {
        F f10 = this.f46769a;
        int iHashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f46770b;
        return iHashCode ^ (s10 != null ? s10.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f46769a + " " + this.f46770b + "}";
    }
}
