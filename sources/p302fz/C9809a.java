package p302fz;

/* renamed from: fz.a */
/* loaded from: classes9.dex */
public class C9809a extends IllegalStateException {

    /* renamed from: a */
    public Throwable f48230a;

    public C9809a(String str, Throwable th2) {
        super(str);
        this.f48230a = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f48230a;
    }
}
