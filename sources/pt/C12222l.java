package pt;

import java.util.List;
import java.util.function.Predicate;
import mt.C11518e;
import p533ot.C12026a;
import p533ot.C12030e;
import p590qt.C12410r;

/* renamed from: pt.l */
/* loaded from: classes5.dex */
public class C12222l {
    /* renamed from: b */
    public static boolean m73408b(List<C11518e> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos is null or empty");
        return false;
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m73409c(double[] dArr, C11518e c11518e) {
        return Math.sqrt(C12026a.m72159d(c11518e, dArr)) >= 75.0d;
    }

    /* renamed from: d */
    public static void m73410d(List<C11518e> list) {
        if (m73408b(list)) {
            List<C11518e> listM72173h = C12030e.m72173h(list);
            if (C12030e.m72169d(listM72173h)) {
                final double[] dArrM72161f = C12026a.m72161f(listM72173h);
                list.removeIf(new Predicate() { // from class: pt.k
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C12222l.m73409c(dArrM72161f, (C11518e) obj);
                    }
                });
            }
        }
    }
}
