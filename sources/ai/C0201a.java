package ai;

import ci.C1441b;
import java.util.ArrayList;
import java.util.List;
import p844zh.C14301a;

/* renamed from: ai.a */
/* loaded from: classes4.dex */
public class C0201a {
    /* renamed from: a */
    public String m1114a(List<C14301a> list) {
        List<C14301a> listM1115b = m1115b(m1116c(m1117d(m1118e(list))));
        String strM85174e = "";
        if (listM1115b.size() > 0) {
            int iM85175f = 0;
            for (C14301a c14301a : listM1115b) {
                if (c14301a.m85175f() >= iM85175f) {
                    iM85175f = c14301a.m85175f();
                    strM85174e = c14301a.m85174e();
                }
            }
        }
        return strM85174e;
    }

    /* renamed from: b */
    public final List<C14301a> m1115b(List<C14301a> list) {
        ArrayList arrayList = new ArrayList();
        int iM85171b = 0;
        for (C14301a c14301a : list) {
            if (c14301a.m85171b() > iM85171b) {
                arrayList.clear();
                iM85171b = c14301a.m85171b();
            } else if (c14301a.m85171b() != iM85171b) {
                C1441b.f6211b.m8286c("OptimizationCenter", "condition Low level");
            }
            arrayList.add(c14301a);
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    /* renamed from: c */
    public final List<C14301a> m1116c(List<C14301a> list) {
        ArrayList arrayList = new ArrayList();
        for (C14301a c14301a : list) {
            if (c14301a.m85170a() == 0) {
                arrayList.add(c14301a);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    /* renamed from: d */
    public final List<C14301a> m1117d(List<C14301a> list) {
        ArrayList arrayList = new ArrayList();
        for (C14301a c14301a : list) {
            if (c14301a.m85172c() == 1) {
                arrayList.add(c14301a);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    /* renamed from: e */
    public final List<C14301a> m1118e(List<C14301a> list) {
        ArrayList arrayList = new ArrayList();
        for (C14301a c14301a : list) {
            if (c14301a.m85173d() > -1) {
                arrayList.add(c14301a);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }
}
