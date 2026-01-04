package p618rm;

import dm.C9215i0;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import pl.C12161c;
import pl.C12164f;

/* renamed from: rm.o */
/* loaded from: classes6.dex */
public class C12577o {

    /* renamed from: a */
    public List<C12161c> f57936a = new ArrayList();

    /* renamed from: b */
    public int f57937b;

    public C12577o(int i10) {
        this.f57937b = i10;
    }

    /* renamed from: a */
    public void m75562a(C12161c c12161c, String str, boolean z10, C9215i0 c9215i0) throws C9721b {
        if (c12161c != null) {
            this.f57936a.add(c12161c);
        }
        if ((z10 || this.f57936a.size() > 100) && !this.f57936a.isEmpty()) {
            if (c9215i0 != null) {
                c9215i0.m59511j();
            }
            new C12164f(str, this.f57936a.get(0).m72974c(), 0, this.f57937b).batchReplace(this.f57936a);
            this.f57936a.clear();
        }
    }
}
