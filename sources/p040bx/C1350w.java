package p040bx;

import java.lang.reflect.InvocationTargetException;
import mw.InterfaceC11539f;
import p408jw.C10936b;

/* renamed from: bx.w */
/* loaded from: classes9.dex */
public final class C1350w {
    /* renamed from: a */
    public static final void m7841a(InterfaceC11539f interfaceC11539f, Throwable th2) {
        try {
            InterfaceC1346u interfaceC1346u = (InterfaceC1346u) interfaceC11539f.get(InterfaceC1346u.f5844f2);
            if (interfaceC1346u == null) {
                C1348v.m7840a(interfaceC11539f, th2);
            } else {
                interfaceC1346u.handleException(interfaceC11539f, th2);
            }
        } catch (Throwable th3) {
            C1348v.m7840a(interfaceC11539f, m7842b(th2, th3));
        }
    }

    /* renamed from: b */
    public static final Throwable m7842b(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        C10936b.m66063a(runtimeException, th2);
        return runtimeException;
    }
}
