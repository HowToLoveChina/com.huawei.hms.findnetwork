package pt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mt.C11518e;
import p533ot.C12026a;
import p590qt.C12410r;

/* renamed from: pt.i */
/* loaded from: classes5.dex */
public class C12219i {
    /* renamed from: a */
    public static void m73402a(List<C11518e> list, List<C11518e> list2, double d10) {
        if (list == null || list.isEmpty() || list2 == null) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos == null or empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            Iterator<C11518e> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Math.sqrt(C12026a.m72157b(it.next(), list2.get(i10))) < d10) {
                        arrayList.add(Integer.valueOf(i10));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            list.add(list2.get(((Integer) it2.next()).intValue()));
        }
    }

    /* renamed from: b */
    public static void m73403b(List<C11518e> list, List<C11518e> list2) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos == null or empty");
            return;
        }
        C11518e.m68728u(list);
        ArrayList arrayList = new ArrayList();
        for (C11518e c11518e : list) {
            if (arrayList.size() < 2) {
                arrayList.add(c11518e);
            } else {
                long jM68739b = ((C11518e) arrayList.get(arrayList.size() - 1)).m68730j().m68739b();
                long jM68739b2 = c11518e.m68730j().m68739b();
                double dSqrt = Math.sqrt(C12026a.m72157b((C11518e) arrayList.get(arrayList.size() - 1), c11518e));
                if (jM68739b - jM68739b2 > 120000 || dSqrt > 100.0d) {
                    arrayList.add(c11518e);
                } else if (list2 != null) {
                    list2.add(c11518e);
                }
            }
        }
        list.clear();
        list.addAll(arrayList);
    }
}
