package p040bx;

import java.util.concurrent.CancellationException;
import p692uw.C13267j;

/* renamed from: bx.v0 */
/* loaded from: classes9.dex */
public final class C1349v0 extends CancellationException {

    /* renamed from: a */
    public final InterfaceC1347u0 f5849a;

    public C1349v0(String str, Throwable th2, InterfaceC1347u0 interfaceC1347u0) {
        super(str);
        this.f5849a = interfaceC1347u0;
        if (th2 != null) {
            initCause(th2);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C1349v0) {
                C1349v0 c1349v0 = (C1349v0) obj;
                if (!C13267j.m79673a(c1349v0.getMessage(), getMessage()) || !C13267j.m79673a(c1349v0.f5849a, this.f5849a) || !C13267j.m79673a(c1349v0.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        C13267j.m79674b(message);
        int iHashCode = ((message.hashCode() * 31) + this.f5849a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f5849a;
    }
}
