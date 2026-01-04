package p829z1;

import java.util.HashMap;
import java.util.Map;
import p759x1.InterfaceC13681f;

/* renamed from: z1.s */
/* loaded from: classes.dex */
public final class C14080s {

    /* renamed from: a */
    public final Map<InterfaceC13681f, C14073l<?>> f63043a = new HashMap();

    /* renamed from: b */
    public final Map<InterfaceC13681f, C14073l<?>> f63044b = new HashMap();

    /* renamed from: a */
    public C14073l<?> m84410a(InterfaceC13681f interfaceC13681f, boolean z10) {
        return m84411b(z10).get(interfaceC13681f);
    }

    /* renamed from: b */
    public final Map<InterfaceC13681f, C14073l<?>> m84411b(boolean z10) {
        return z10 ? this.f63044b : this.f63043a;
    }

    /* renamed from: c */
    public void m84412c(InterfaceC13681f interfaceC13681f, C14073l<?> c14073l) {
        m84411b(c14073l.m84384p()).put(interfaceC13681f, c14073l);
    }

    /* renamed from: d */
    public void m84413d(InterfaceC13681f interfaceC13681f, C14073l<?> c14073l) {
        Map<InterfaceC13681f, C14073l<?>> mapM84411b = m84411b(c14073l.m84384p());
        if (c14073l.equals(mapM84411b.get(interfaceC13681f))) {
            mapM84411b.remove(interfaceC13681f);
        }
    }
}
