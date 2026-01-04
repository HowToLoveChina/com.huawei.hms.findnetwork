package p689ut;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mt.C11518e;
import p590qt.C12410r;

/* renamed from: ut.e */
/* loaded from: classes5.dex */
public class C13252e {

    /* renamed from: a */
    public final List<Integer> f59943a = new ArrayList();

    public C13252e(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f59943a.add(0);
        }
    }

    /* renamed from: c */
    public static String m79638c(C11518e c11518e, Map<String, Integer> map) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{\"index\": ");
        sb2.append(c11518e.m68732l());
        sb2.append(", \"broadcastTime\": ");
        sb2.append(c11518e.m68730j().m68739b());
        sb2.append(", \"timeStamp\": \"");
        sb2.append(simpleDateFormat.format(new Date(c11518e.m68730j().m68739b())));
        sb2.append("\"");
        sb2.append(", \"rssi\": ");
        sb2.append(c11518e.m68730j().m68738a());
        sb2.append(", \"confidence\": ");
        sb2.append(c11518e.m68731k());
        if (c11518e.m68734n().m68753m()) {
            sb2.append(", \"posX\": ");
            sb2.append(c11518e.m68734n().m68750j());
            sb2.append(", \"posY\": ");
            sb2.append(c11518e.m68734n().m68747g());
        }
        sb2.append(", \"accuracy\": ");
        sb2.append(c11518e.m68734n().m68741a());
        sb2.append(", \"speed\": ");
        sb2.append(c11518e.m68734n().m68751k());
        sb2.append(", \"bearing\": ");
        sb2.append(c11518e.m68734n().m68742b());
        sb2.append(", \"locationType\": ");
        sb2.append(c11518e.m68734n().m68749i());
        sb2.append(", \"locationSourceType\": ");
        sb2.append(c11518e.m68734n().m68748h());
        sb2.append(", \"indoor\": ");
        sb2.append(c11518e.m68734n().m68754n());
        sb2.append(", \"floor\": ");
        sb2.append(c11518e.m68734n().m68744d());
        sb2.append(", \"floorAcc\": ");
        sb2.append(c11518e.m68734n().m68745e());
        sb2.append(", \"bid\": ");
        sb2.append(map.getOrDefault(c11518e.m68734n().m68743c(), 0));
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: d */
    public static /* synthetic */ boolean m79639d(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* renamed from: g */
    public static Map<String, Integer> m79640g(List<C11518e> list) {
        Set set = (Set) list.stream().map(new Function() { // from class: ut.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C13252e.m79643j((C11518e) obj);
            }
        }).filter(new Predicate() { // from class: ut.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C13252e.m79639d((String) obj);
            }
        }).collect(Collectors.toSet());
        HashMap map = new HashMap();
        Iterator it = set.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            map.put((String) it.next(), Integer.valueOf(i10));
            i10++;
        }
        return map;
    }

    /* renamed from: h */
    public static void m79641h(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos is empty");
            return;
        }
        Map<String, Integer> mapM79640g = m79640g(list);
        Iterator<C11518e> it = list.iterator();
        while (it.hasNext()) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", m79638c(it.next(), mapM79640g));
        }
    }

    /* renamed from: i */
    public static void m79642i(String str, List<C11518e> list) {
        if (str == null) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "prompt is null");
            return;
        }
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", str + ". Info is empty");
            return;
        }
        List list2 = (List) list.stream().map(new Function() { // from class: ut.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((C11518e) obj).m68732l());
            }
        }).collect(Collectors.toList());
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", str + ". Id = " + list2);
    }

    /* renamed from: j */
    public static /* synthetic */ String m79643j(C11518e c11518e) {
        return c11518e.m68734n().m68743c();
    }

    /* renamed from: e */
    public List<Integer> m79644e() {
        return this.f59943a;
    }

    /* renamed from: f */
    public void m79645f(String str, List<C11518e> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<C11518e> it = list.iterator();
        while (it.hasNext()) {
            int iM68732l = it.next().m68732l();
            if (iM68732l >= 0 && iM68732l < this.f59943a.size()) {
                List<Integer> list2 = this.f59943a;
                list2.set(iM68732l, Integer.valueOf(list2.get(iM68732l).intValue() + 1));
            }
        }
        m79642i(str + " (Recorded)", list);
    }
}
