package pt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mt.C11518e;
import p590qt.C12410r;

/* renamed from: pt.o */
/* loaded from: classes5.dex */
public class C12225o {
    /* renamed from: a */
    public static void m73414a(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos == null or empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (C11518e c11518e : list) {
            String strM68733m = c11518e.m68733m();
            if (strM68733m == null || strM68733m.equals("") || strM68733m.equals("0")) {
                arrayList.add(c11518e);
            } else {
                if (!map.containsKey(c11518e.m68733m())) {
                    map.put(c11518e.m68733m(), new ArrayList());
                }
                ((List) map.get(c11518e.m68733m())).add(c11518e);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list2 = (List) entry.getValue();
            if (list2.size() > 1) {
                C11518e.m68726s(list2);
                C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "kindTransID %s, num: %d", entry.getKey(), Integer.valueOf(list2.size())));
            }
            arrayList.add(list2.get(0));
        }
        list.clear();
        list.addAll(arrayList);
    }
}
