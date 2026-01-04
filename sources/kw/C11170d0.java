package kw;

import java.util.Collections;
import java.util.Map;
import p408jw.C10944j;
import p692uw.C13267j;

/* renamed from: kw.d0 */
/* loaded from: classes9.dex */
public class C11170d0 extends C11168c0 {
    /* renamed from: a */
    public static int m67131a(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m67132b(C10944j<? extends K, ? extends V> c10944j) {
        C13267j.m79677e(c10944j, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(c10944j.m66068d(), c10944j.m66069e());
        C13267j.m79676d(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m67133c(Map<? extends K, ? extends V> map) {
        C13267j.m79677e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C13267j.m79676d(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
