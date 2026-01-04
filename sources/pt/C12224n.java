package pt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import mt.C11518e;
import p533ot.C12026a;
import p590qt.C12410r;

/* renamed from: pt.n */
/* loaded from: classes5.dex */
public class C12224n {
    /* renamed from: b */
    public static void m73412b(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos == null or empty");
            return;
        }
        C11518e.m68728u(list);
        List list2 = (List) list.stream().map(new Function() { // from class: pt.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12224n.m73413c((C11518e) obj);
            }
        }).collect(Collectors.toList());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            if (i10 == 0 || Math.sqrt(C12026a.m72160e((double[]) list2.get(i10), (double[]) arrayList.get(arrayList.size() - 1))) > 20.0d) {
                arrayList.add(list2.get(i10));
                arrayList2.add(Integer.valueOf(i10));
            }
        }
        if (arrayList.size() < 5) {
            return;
        }
        int i11 = 2;
        int i12 = 0;
        for (int i13 = 2; i12 < arrayList.size() - i13; i13 = 2) {
            double d10 = ((double[]) arrayList.get(i12))[0];
            int i14 = i12 + 1;
            double d11 = ((double[]) arrayList.get(i14))[0];
            int i15 = i12 + 2;
            double d12 = ((double[]) arrayList.get(i15))[0];
            double d13 = ((double[]) arrayList.get(i12))[1];
            double d14 = ((double[]) arrayList.get(i14))[1];
            if (((d11 - d10) * (d12 - d11)) + ((d14 - d13) * (((double[]) arrayList.get(i15))[1] - d14)) > 0.0d) {
                i11++;
            } else {
                int i16 = i15 - i11;
                double dSqrt = Math.sqrt(C12026a.m72160e((double[]) arrayList.get(i14), (double[]) arrayList.get(i16)));
                if (i11 >= 5 && dSqrt > 100.0d) {
                    list.subList(((Integer) arrayList2.get(i16)).intValue() + 1, list.size()).clear();
                    return;
                }
                i11 = 2;
            }
            i12 = i14;
        }
        double dSqrt2 = Math.sqrt(C12026a.m72160e((double[]) arrayList.get(arrayList.size() - 1), (double[]) arrayList.get(arrayList.size() - i11)));
        if (i11 < 5 || dSqrt2 <= 100.0d) {
            return;
        }
        list.subList(((Integer) arrayList2.get(arrayList.size() - i11)).intValue() + 1, list.size()).clear();
    }

    /* renamed from: c */
    public static /* synthetic */ double[] m73413c(C11518e c11518e) {
        return new double[]{c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g()};
    }
}
