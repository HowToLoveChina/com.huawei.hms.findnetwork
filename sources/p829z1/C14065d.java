package p829z1;

import java.security.MessageDigest;
import p759x1.InterfaceC13681f;

/* renamed from: z1.d */
/* loaded from: classes.dex */
public final class C14065d implements InterfaceC13681f {

    /* renamed from: b */
    public final InterfaceC13681f f62872b;

    /* renamed from: c */
    public final InterfaceC13681f f62873c;

    public C14065d(InterfaceC13681f interfaceC13681f, InterfaceC13681f interfaceC13681f2) {
        this.f62872b = interfaceC13681f;
        this.f62873c = interfaceC13681f2;
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        this.f62872b.mo56817a(messageDigest);
        this.f62873c.mo56817a(messageDigest);
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (!(obj instanceof C14065d)) {
            return false;
        }
        C14065d c14065d = (C14065d) obj;
        return this.f62872b.equals(c14065d.f62872b) && this.f62873c.equals(c14065d.f62873c);
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return (this.f62872b.hashCode() * 31) + this.f62873c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f62872b + ", signature=" + this.f62873c + '}';
    }
}
