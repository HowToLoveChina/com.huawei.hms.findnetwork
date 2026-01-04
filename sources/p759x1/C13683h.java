package p759x1;

import java.security.MessageDigest;
import p630s2.C12676k;

/* renamed from: x1.h */
/* loaded from: classes.dex */
public final class C13683h<T> {

    /* renamed from: e */
    public static final b<Object> f61612e = new a();

    /* renamed from: a */
    public final T f61613a;

    /* renamed from: b */
    public final b<T> f61614b;

    /* renamed from: c */
    public final String f61615c;

    /* renamed from: d */
    public volatile byte[] f61616d;

    /* renamed from: x1.h$a */
    public class a implements b<Object> {
        @Override // p759x1.C13683h.b
        /* renamed from: a */
        public void mo9148a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* renamed from: x1.h$b */
    public interface b<T> {
        /* renamed from: a */
        void mo9148a(byte[] bArr, T t10, MessageDigest messageDigest);
    }

    public C13683h(String str, T t10, b<T> bVar) {
        this.f61615c = C12676k.m76274b(str);
        this.f61613a = t10;
        this.f61614b = (b) C12676k.m76276d(bVar);
    }

    /* renamed from: a */
    public static <T> C13683h<T> m82276a(String str, T t10, b<T> bVar) {
        return new C13683h<>(str, t10, bVar);
    }

    /* renamed from: b */
    public static <T> b<T> m82277b() {
        return (b<T>) f61612e;
    }

    /* renamed from: e */
    public static <T> C13683h<T> m82278e(String str) {
        return new C13683h<>(str, null, m82277b());
    }

    /* renamed from: f */
    public static <T> C13683h<T> m82279f(String str, T t10) {
        return new C13683h<>(str, t10, m82277b());
    }

    /* renamed from: c */
    public T m82280c() {
        return this.f61613a;
    }

    /* renamed from: d */
    public final byte[] m82281d() {
        if (this.f61616d == null) {
            this.f61616d = this.f61615c.getBytes(InterfaceC13681f.f61610a);
        }
        return this.f61616d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13683h) {
            return this.f61615c.equals(((C13683h) obj).f61615c);
        }
        return false;
    }

    /* renamed from: g */
    public void m82282g(T t10, MessageDigest messageDigest) {
        this.f61614b.mo9148a(m82281d(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f61615c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f61615c + "'}";
    }
}
