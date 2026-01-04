package p829z1;

import java.security.MessageDigest;
import java.util.Map;
import p630s2.C12676k;
import p759x1.C13684i;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13688m;

/* renamed from: z1.n */
/* loaded from: classes.dex */
public class C14075n implements InterfaceC13681f {

    /* renamed from: b */
    public final Object f63018b;

    /* renamed from: c */
    public final int f63019c;

    /* renamed from: d */
    public final int f63020d;

    /* renamed from: e */
    public final Class<?> f63021e;

    /* renamed from: f */
    public final Class<?> f63022f;

    /* renamed from: g */
    public final InterfaceC13681f f63023g;

    /* renamed from: h */
    public final Map<Class<?>, InterfaceC13688m<?>> f63024h;

    /* renamed from: i */
    public final C13684i f63025i;

    /* renamed from: j */
    public int f63026j;

    public C14075n(Object obj, InterfaceC13681f interfaceC13681f, int i10, int i11, Map<Class<?>, InterfaceC13688m<?>> map, Class<?> cls, Class<?> cls2, C13684i c13684i) {
        this.f63018b = C12676k.m76276d(obj);
        this.f63023g = (InterfaceC13681f) C12676k.m76277e(interfaceC13681f, "Signature must not be null");
        this.f63019c = i10;
        this.f63020d = i11;
        this.f63024h = (Map) C12676k.m76276d(map);
        this.f63021e = (Class) C12676k.m76277e(cls, "Resource class must not be null");
        this.f63022f = (Class) C12676k.m76277e(cls2, "Transcode class must not be null");
        this.f63025i = (C13684i) C12676k.m76276d(c13684i);
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (!(obj instanceof C14075n)) {
            return false;
        }
        C14075n c14075n = (C14075n) obj;
        return this.f63018b.equals(c14075n.f63018b) && this.f63023g.equals(c14075n.f63023g) && this.f63020d == c14075n.f63020d && this.f63019c == c14075n.f63019c && this.f63024h.equals(c14075n.f63024h) && this.f63021e.equals(c14075n.f63021e) && this.f63022f.equals(c14075n.f63022f) && this.f63025i.equals(c14075n.f63025i);
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        if (this.f63026j == 0) {
            int iHashCode = this.f63018b.hashCode();
            this.f63026j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f63023g.hashCode()) * 31) + this.f63019c) * 31) + this.f63020d;
            this.f63026j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f63024h.hashCode();
            this.f63026j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f63021e.hashCode();
            this.f63026j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f63022f.hashCode();
            this.f63026j = iHashCode5;
            this.f63026j = (iHashCode5 * 31) + this.f63025i.hashCode();
        }
        return this.f63026j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f63018b + ", width=" + this.f63019c + ", height=" + this.f63020d + ", resourceClass=" + this.f63021e + ", transcodeClass=" + this.f63022f + ", signature=" + this.f63023g + ", hashCode=" + this.f63026j + ", transformations=" + this.f63024h + ", options=" + this.f63025i + '}';
    }
}
