package p052cb;

/* renamed from: cb.i */
/* loaded from: classes3.dex */
public class C1412i extends Exception {

    /* renamed from: a */
    public int f6047a;

    /* renamed from: b */
    public String f6048b;

    public C1412i(int i10, String str) {
        super(str);
        this.f6047a = i10;
        this.f6048b = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f6048b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "FamilyShareException{code=" + this.f6047a + ", message='" + this.f6048b + "'}";
    }
}
