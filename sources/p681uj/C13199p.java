package p681uj;

/* renamed from: uj.p */
/* loaded from: classes5.dex */
public class C13199p extends Exception {

    /* renamed from: a */
    public int f59829a;

    public C13199p(int i10, String str) {
        super(str);
        this.f59829a = i10;
    }

    /* renamed from: b */
    public int m79390b() {
        return this.f59829a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "HmsSTInvalidException: code = " + this.f59829a + ", message = " + getMessage();
    }
}
