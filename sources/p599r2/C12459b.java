package p599r2;

import java.security.MessageDigest;
import p630s2.C12676k;
import p759x1.InterfaceC13681f;

/* renamed from: r2.b */
/* loaded from: classes.dex */
public final class C12459b implements InterfaceC13681f {

    /* renamed from: b */
    public final Object f57387b;

    public C12459b(Object obj) {
        this.f57387b = C12676k.m76276d(obj);
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        messageDigest.update(this.f57387b.toString().getBytes(InterfaceC13681f.f61610a));
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (obj instanceof C12459b) {
            return this.f57387b.equals(((C12459b) obj).f57387b);
        }
        return false;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return this.f57387b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f57387b + '}';
    }
}
