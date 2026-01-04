package pt;

import java.util.List;
import mt.C11518e;
import p590qt.C12410r;

/* renamed from: pt.c */
/* loaded from: classes5.dex */
public class C12213c {
    /* renamed from: a */
    public static void m73386a(List<C11518e> list, int i10, double d10) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos == null or is empty");
            return;
        }
        if (i10 < 1) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "minItems can't less than 1");
            return;
        }
        C11518e.m68725r(list);
        while (list.size() > i10 && list.get(list.size() - 1).m68731k() < d10) {
            list.remove(list.size() - 1);
        }
        C11518e.m68727t(list);
    }
}
