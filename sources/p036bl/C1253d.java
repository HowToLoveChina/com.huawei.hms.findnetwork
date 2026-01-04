package p036bl;

import cl.EnumC1448c;
import cl.InterfaceC1450e;
import gl.C9968i;
import java.util.HashMap;
import java.util.concurrent.Callable;
import je.C10790h;
import p514o9.C11839m;
import p780xm.C13834f;

/* renamed from: bl.d */
/* loaded from: classes6.dex */
public class C1253d implements InterfaceC1450e {
    /* renamed from: b */
    public static /* synthetic */ Object m7503b() throws Exception {
        C11839m.m70688i("AGRestoreFinalizerProcessor", "Agd ads event supplementary report.");
        C10790h.m65667o();
        C9968i.m61832h().m61835f();
        C10790h.m65666n(new HashMap());
        return null;
    }

    @Override // cl.InterfaceC1450e
    public void finalize() {
        C11839m.m70688i("AGRestoreFinalizerProcessor", "finalize");
        C13834f.m82974k(new Callable() { // from class: bl.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C1253d.m7503b();
            }
        }, null);
    }

    @Override // cl.InterfaceC1450e
    public EnumC1448c identity() {
        return EnumC1448c.AGD;
    }
}
