package kotlinx.coroutines.scheduling;

/* renamed from: kotlinx.coroutines.scheduling.c */
/* loaded from: classes9.dex */
public final class C11112c extends C11115f {

    /* renamed from: h */
    public static final C11112c f52371h = new C11112c();

    public C11112c() {
        super(C11121l.f52383b, C11121l.f52384c, C11121l.f52385d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // p040bx.AbstractC1344t
    public String toString() {
        return "Dispatchers.Default";
    }
}
