package pt;

import java.util.List;
import mt.C11518e;
import p533ot.C12026a;
import p590qt.C12410r;

/* renamed from: pt.j */
/* loaded from: classes5.dex */
public class C12220j {
    /* renamed from: a */
    public static int m73404a(List<C11518e> list, double[] dArr) {
        double d10 = 0.0d;
        int i10 = -1;
        for (int i11 = 0; i11 < list.size(); i11++) {
            double dSqrt = Math.sqrt(C12026a.m72159d(list.get(i11), dArr));
            if (dSqrt > d10) {
                i10 = i11;
                d10 = dSqrt;
            }
        }
        return i10;
    }

    /* renamed from: b */
    public static boolean m73405b(List<C11518e> list, int i10) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos is null or empty");
            return false;
        }
        if (i10 >= 1) {
            return true;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "minItems can't less than 1");
        return false;
    }

    /* renamed from: c */
    public static void m73406c(List<C11518e> list, int i10, double d10) {
        if (m73405b(list, i10)) {
            while (list.size() > i10 && C12026a.m72162g(list) > d10) {
                list.remove(m73404a(list, C12026a.m72161f(list)));
            }
        }
    }
}
