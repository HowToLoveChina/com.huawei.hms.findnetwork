package p630s2;

/* renamed from: s2.j */
/* loaded from: classes.dex */
public class C12675j {

    /* renamed from: a */
    public Class<?> f58185a;

    /* renamed from: b */
    public Class<?> f58186b;

    /* renamed from: c */
    public Class<?> f58187c;

    public C12675j() {
    }

    /* renamed from: a */
    public void m76272a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f58185a = cls;
        this.f58186b = cls2;
        this.f58187c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C12675j c12675j = (C12675j) obj;
        return this.f58185a.equals(c12675j.f58185a) && this.f58186b.equals(c12675j.f58186b) && C12677l.m76280c(this.f58187c, c12675j.f58187c);
    }

    public int hashCode() {
        int iHashCode = ((this.f58185a.hashCode() * 31) + this.f58186b.hashCode()) * 31;
        Class<?> cls = this.f58187c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f58185a + ", second=" + this.f58186b + '}';
    }

    public C12675j(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        m76272a(cls, cls2, cls3);
    }
}
