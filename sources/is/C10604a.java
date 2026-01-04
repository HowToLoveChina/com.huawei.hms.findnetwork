package is;

import as.C1016d;
import es.C9545j;
import es.C9546k;
import java.util.Iterator;
import java.util.Map;
import p404js.C10913b;
import p531or.C11991a;
import p819yq.C14035a;
import p819yq.C14036b;
import p852zq.AbstractC14365f;
import p852zq.C14360a;
import p852zq.C14366g;
import p852zq.C14368i;
import pr.AbstractC12208a;

/* renamed from: is.a */
/* loaded from: classes8.dex */
public final class C10604a extends AbstractC12208a {
    @Override // pr.AbstractC12208a
    /* renamed from: c */
    public final void mo65017c() {
        boolean zM59603d = C9545j.m59603d(C11991a.m72145a());
        boolean zM59614h = C9546k.m59614h(C11991a.m72145a());
        if (!zM59603d) {
            C14036b.m84189d().m84194f(null);
        }
        if (zM59603d && zM59614h) {
            C1016d.m6186f("LocationAvailabilityObserver", "available,resume scan and get location");
            C10913b.m65957f().m65960a();
        } else {
            C1016d.m6186f("LocationAvailabilityObserver", "unAvailable,stop scan and get location");
            C10913b.m65957f().m65961b();
        }
        Iterator<Map.Entry<String, C14035a>> it = C14036b.m84189d().m84193e().entrySet().iterator();
        while (it.hasNext()) {
            AbstractC14365f abstractC14365fM84187g = it.next().getValue().m84187g();
            if (abstractC14365fM84187g != null) {
                if ((abstractC14365fM84187g instanceof C14360a) || (abstractC14365fM84187g instanceof C14368i) || (abstractC14365fM84187g instanceof C14366g)) {
                    abstractC14365fM84187g.m85554i(zM59603d);
                } else {
                    abstractC14365fM84187g.m85554i(zM59603d && zM59614h);
                }
            }
        }
    }
}
