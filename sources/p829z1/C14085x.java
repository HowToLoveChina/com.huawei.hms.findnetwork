package p829z1;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import p003a2.InterfaceC0007b;
import p630s2.C12673h;
import p630s2.C12677l;
import p759x1.C13684i;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13688m;

/* renamed from: z1.x */
/* loaded from: classes.dex */
public final class C14085x implements InterfaceC13681f {

    /* renamed from: j */
    public static final C12673h<Class<?>, byte[]> f63064j = new C12673h<>(50);

    /* renamed from: b */
    public final InterfaceC0007b f63065b;

    /* renamed from: c */
    public final InterfaceC13681f f63066c;

    /* renamed from: d */
    public final InterfaceC13681f f63067d;

    /* renamed from: e */
    public final int f63068e;

    /* renamed from: f */
    public final int f63069f;

    /* renamed from: g */
    public final Class<?> f63070g;

    /* renamed from: h */
    public final C13684i f63071h;

    /* renamed from: i */
    public final InterfaceC13688m<?> f63072i;

    public C14085x(InterfaceC0007b interfaceC0007b, InterfaceC13681f interfaceC13681f, InterfaceC13681f interfaceC13681f2, int i10, int i11, InterfaceC13688m<?> interfaceC13688m, Class<?> cls, C13684i c13684i) {
        this.f63065b = interfaceC0007b;
        this.f63066c = interfaceC13681f;
        this.f63067d = interfaceC13681f2;
        this.f63068e = i10;
        this.f63069f = i11;
        this.f63072i = interfaceC13688m;
        this.f63070g = cls;
        this.f63071h = c13684i;
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f63065b.mo9b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f63068e).putInt(this.f63069f).array();
        this.f63067d.mo56817a(messageDigest);
        this.f63066c.mo56817a(messageDigest);
        messageDigest.update(bArr);
        InterfaceC13688m<?> interfaceC13688m = this.f63072i;
        if (interfaceC13688m != null) {
            interfaceC13688m.mo56817a(messageDigest);
        }
        this.f63071h.mo56817a(messageDigest);
        messageDigest.update(m84422c());
        this.f63065b.put(bArr);
    }

    /* renamed from: c */
    public final byte[] m84422c() {
        C12673h<Class<?>, byte[]> c12673h = f63064j;
        byte[] bArrM76265f = c12673h.m76265f(this.f63070g);
        if (bArrM76265f != null) {
            return bArrM76265f;
        }
        byte[] bytes = this.f63070g.getName().getBytes(InterfaceC13681f.f61610a);
        c12673h.m76267j(this.f63070g, bytes);
        return bytes;
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (!(obj instanceof C14085x)) {
            return false;
        }
        C14085x c14085x = (C14085x) obj;
        return this.f63069f == c14085x.f63069f && this.f63068e == c14085x.f63068e && C12677l.m76280c(this.f63072i, c14085x.f63072i) && this.f63070g.equals(c14085x.f63070g) && this.f63066c.equals(c14085x.f63066c) && this.f63067d.equals(c14085x.f63067d) && this.f63071h.equals(c14085x.f63071h);
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        int iHashCode = (((((this.f63066c.hashCode() * 31) + this.f63067d.hashCode()) * 31) + this.f63068e) * 31) + this.f63069f;
        InterfaceC13688m<?> interfaceC13688m = this.f63072i;
        if (interfaceC13688m != null) {
            iHashCode = (iHashCode * 31) + interfaceC13688m.hashCode();
        }
        return (((iHashCode * 31) + this.f63070g.hashCode()) * 31) + this.f63071h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f63066c + ", signature=" + this.f63067d + ", width=" + this.f63068e + ", height=" + this.f63069f + ", decodedResourceClass=" + this.f63070g + ", transformation='" + this.f63072i + "', options=" + this.f63071h + '}';
    }
}
