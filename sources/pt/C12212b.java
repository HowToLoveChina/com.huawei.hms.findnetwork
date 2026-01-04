package pt;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import mt.C11518e;
import p533ot.C12030e;
import p590qt.C12410r;
import p689ut.C13252e;
import pt.C12218h;
import tt.C13069b;

/* renamed from: pt.b */
/* loaded from: classes5.dex */
public class C12212b {
    /* renamed from: b */
    public static void m73383b(List<C11518e> list, C13252e c13252e) {
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "Gnss Ratio = %f", Double.valueOf(C12030e.m72174i(list))));
        if (C12030e.m72175j(list)) {
            C12222l.m73410d(list);
            c13252e.m79645f("Filter by GNSS position offset", list);
            C12220j.m73406c(list, Math.max(10, (int) (list.size() * 0.5d)), 15.0d);
            c13252e.m79645f("Filter by GNSS distance", list);
        }
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m73384c(long j10, C11518e c11518e) {
        return j10 - c11518e.m68730j().m68739b() > 21600000;
    }

    /* renamed from: d */
    public static List<C11518e> m73385d(List<C11518e> list, C13252e c13252e) throws C13069b {
        if (list == null || list.isEmpty() || c13252e == null) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos is null or empty");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        C13252e.m79642i("Before filter", arrayList);
        final long jM68739b = arrayList.get(arrayList.size() - 1).m68730j().m68739b();
        arrayList.removeIf(new Predicate() { // from class: pt.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12212b.m73384c(jM68739b, (C11518e) obj);
            }
        });
        c13252e.m79645f("Filter by timeStamp", arrayList);
        C12225o.m73414a(arrayList);
        c13252e.m79645f("Filter by kindTransID", arrayList);
        C12213c.m73386a(arrayList, Math.max(15, (int) (arrayList.size() * 0.5d)), 0.6d);
        c13252e.m79645f("Filter by confidence", arrayList);
        ArrayList arrayList2 = new ArrayList();
        C12219i.m73403b(arrayList, arrayList2);
        c13252e.m79645f("Filter by dense filter", arrayList);
        C12218h.m73401o(arrayList, C12218h.a.FILTER_DYNAMIC);
        c13252e.m79645f("Filter by DBScan stage 1", arrayList);
        C12218h.m73401o(arrayList, C12218h.a.FILTER_STATIC);
        c13252e.m79645f("Filter by DBScan stage 2", arrayList);
        C12219i.m73402a(arrayList, arrayList2, 60.0d);
        c13252e.m79645f("Add by dense filter", arrayList);
        C12224n.m73412b(arrayList);
        c13252e.m79645f("Filter by same direction", arrayList);
        m73383b(arrayList, c13252e);
        C11518e.m68727t(arrayList);
        return arrayList;
    }
}
