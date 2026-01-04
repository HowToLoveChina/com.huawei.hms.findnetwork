package p302fz;

/* renamed from: fz.b */
/* loaded from: classes9.dex */
public class C9810b extends IllegalStateException {

    /* renamed from: a */
    public Throwable f48231a;

    public C9810b(String str, Throwable th2) {
        super(str);
        this.f48231a = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f48231a;
    }
}
