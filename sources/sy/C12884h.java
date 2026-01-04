package sy;

/* renamed from: sy.h */
/* loaded from: classes9.dex */
public class C12884h extends IllegalStateException {

    /* renamed from: a */
    public Throwable f58667a;

    public C12884h(String str, Throwable th2) {
        super(str);
        this.f58667a = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f58667a;
    }
}
