package kotlinx.coroutines.internal;

import java.util.List;
import p040bx.AbstractC1301c1;
import p408jw.C10938d;

/* renamed from: kotlinx.coroutines.internal.o */
/* loaded from: classes9.dex */
public final class C11098o {
    /* renamed from: a */
    public static final C11099p m66794a(Throwable th2, String str) throws Throwable {
        if (th2 != null) {
            throw th2;
        }
        m66797d();
        throw new C10938d();
    }

    /* renamed from: b */
    public static /* synthetic */ C11099p m66795b(Throwable th2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return m66794a(th2, str);
    }

    /* renamed from: c */
    public static final boolean m66796c(AbstractC1301c1 abstractC1301c1) {
        return abstractC1301c1.mo7738z() instanceof C11099p;
    }

    /* renamed from: d */
    public static final Void m66797d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    /* renamed from: e */
    public static final AbstractC1301c1 m66798e(InterfaceC11096m interfaceC11096m, List<? extends InterfaceC11096m> list) {
        try {
            return interfaceC11096m.createDispatcher(list);
        } catch (Throwable th2) {
            return m66794a(th2, interfaceC11096m.hintOnError());
        }
    }
}
