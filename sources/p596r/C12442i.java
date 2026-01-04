package p596r;

import java.util.ArrayList;
import p561q.C12258e;
import p561q.C12261h;
import p561q.C12263j;

/* renamed from: r.i */
/* loaded from: classes.dex */
public class C12442i {
    /* renamed from: a */
    public static C12448o m74670a(C12258e c12258e, int i10, ArrayList<C12448o> arrayList, C12448o c12448o) {
        int iM73770x1;
        int i11 = i10 == 0 ? c12258e.f56739S0 : c12258e.f56741T0;
        if (i11 != -1 && (c12448o == null || i11 != c12448o.m74685c())) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                C12448o c12448o2 = arrayList.get(i12);
                if (c12448o2.m74685c() == i11) {
                    if (c12448o != null) {
                        c12448o.m74689g(i10, c12448o2);
                        arrayList.remove(c12448o);
                    }
                    c12448o = c12448o2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return c12448o;
        }
        if (c12448o == null) {
            if ((c12258e instanceof C12263j) && (iM73770x1 = ((C12263j) c12258e).m73770x1(i10)) != -1) {
                int i13 = 0;
                while (true) {
                    if (i13 >= arrayList.size()) {
                        break;
                    }
                    C12448o c12448o3 = arrayList.get(i13);
                    if (c12448o3.m74685c() == iM73770x1) {
                        c12448o = c12448o3;
                        break;
                    }
                    i13++;
                }
            }
            if (c12448o == null) {
                c12448o = new C12448o(i10);
            }
            arrayList.add(c12448o);
        }
        if (c12448o.m74683a(c12258e)) {
            if (c12258e instanceof C12261h) {
                C12261h c12261h = (C12261h) c12258e;
                c12261h.m73762w1().m73526c(c12261h.m73763x1() == 0 ? 1 : 0, arrayList, c12448o);
            }
            if (i10 == 0) {
                c12258e.f56739S0 = c12448o.m74685c();
                c12258e.f56734Q.m73526c(i10, arrayList, c12448o);
                c12258e.f56738S.m73526c(i10, arrayList, c12448o);
            } else {
                c12258e.f56741T0 = c12448o.m74685c();
                c12258e.f56736R.m73526c(i10, arrayList, c12448o);
                c12258e.f56742U.m73526c(i10, arrayList, c12448o);
                c12258e.f56740T.m73526c(i10, arrayList, c12448o);
            }
            c12258e.f56745X.m73526c(i10, arrayList, c12448o);
        }
        return c12448o;
    }

    /* renamed from: b */
    public static C12448o m74671b(ArrayList<C12448o> arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            C12448o c12448o = arrayList.get(i11);
            if (i10 == c12448o.m74685c()) {
                return c12448o;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:418:0x0348  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m74672c(p561q.C12259f r16, p596r.C12435b.b r17) {
        /*
            Method dump skipped, instructions count: 921
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p596r.C12442i.m74672c(q.f, r.b$b):boolean");
    }

    /* renamed from: d */
    public static boolean m74673d(C12258e.b bVar, C12258e.b bVar2, C12258e.b bVar3, C12258e.b bVar4) {
        C12258e.b bVar5;
        C12258e.b bVar6;
        C12258e.b bVar7 = C12258e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = C12258e.b.WRAP_CONTENT) || (bVar3 == C12258e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = C12258e.b.WRAP_CONTENT) || (bVar4 == C12258e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
