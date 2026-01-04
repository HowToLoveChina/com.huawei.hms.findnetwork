package p692uw;

/* renamed from: uw.l */
/* loaded from: classes9.dex */
public final class C13269l implements InterfaceC13261d {

    /* renamed from: a */
    public final Class<?> f59976a;

    /* renamed from: b */
    public final String f59977b;

    public C13269l(Class<?> cls, String str) {
        C13267j.m79677e(cls, "jClass");
        C13267j.m79677e(str, "moduleName");
        this.f59976a = cls;
        this.f59977b = str;
    }

    @Override // p692uw.InterfaceC13261d
    /* renamed from: a */
    public Class<?> mo79668a() {
        return this.f59976a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C13269l) && C13267j.m79673a(mo79668a(), ((C13269l) obj).mo79668a());
    }

    public int hashCode() {
        return mo79668a().hashCode();
    }

    public String toString() {
        return mo79668a().toString() + " (Kotlin reflection is not available)";
    }
}
