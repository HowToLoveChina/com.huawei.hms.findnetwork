package p040bx;

import mw.InterfaceC11539f;

/* renamed from: bx.c0 */
/* loaded from: classes9.dex */
public final class C1300c0 extends RuntimeException {

    /* renamed from: a */
    public final InterfaceC11539f f5791a;

    public C1300c0(InterfaceC11539f interfaceC11539f) {
        this.f5791a = interfaceC11539f;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f5791a.toString();
    }
}
