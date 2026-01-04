package p681uj;

/* renamed from: uj.k */
/* loaded from: classes5.dex */
public class C13194k extends Exception {
    private static final long serialVersionUID = -5629067007691168403L;

    /* renamed from: a */
    public int f59739a;

    public C13194k(int i10, String str) {
        super(str);
        this.f59739a = i10;
    }

    /* renamed from: b */
    public int m79269b() {
        return this.f59739a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "HmsException: code = " + this.f59739a + ", message = " + getMessage();
    }
}
