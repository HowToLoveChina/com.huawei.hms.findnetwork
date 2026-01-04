package kw;

import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p408jw.C10944j;
import p692uw.C13267j;

/* renamed from: kw.e0 */
/* loaded from: classes9.dex */
public class C11172e0 extends C11170d0 {
    /* renamed from: d */
    public static <K, V> Map<K, V> m67135d() {
        C11197x c11197x = C11197x.f52517a;
        C13267j.m79675c(c11197x, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c11197x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public static final <K, V> Map<K, V> m67136e(Map<K, ? extends V> map) {
        C13267j.m79677e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : C11170d0.m67133c(map) : m67135d();
    }

    /* renamed from: f */
    public static final <K, V> void m67137f(Map<? super K, ? super V> map, Iterable<? extends C10944j<? extends K, ? extends V>> iterable) {
        C13267j.m79677e(map, "<this>");
        C13267j.m79677e(iterable, "pairs");
        for (C10944j<? extends K, ? extends V> c10944j : iterable) {
            map.put(c10944j.m66066b(), c10944j.m66067c());
        }
    }

    /* renamed from: g */
    public static <K, V> Map<K, V> m67138g(Iterable<? extends C10944j<? extends K, ? extends V>> iterable) {
        C13267j.m79677e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m67136e(m67139h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m67135d();
        }
        if (size != 1) {
            return m67139h(iterable, new LinkedHashMap(C11170d0.m67131a(collection.size())));
        }
        return C11170d0.m67132b(iterable instanceof List ? (C10944j<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    /* renamed from: h */
    public static final <K, V, M extends Map<? super K, ? super V>> M m67139h(Iterable<? extends C10944j<? extends K, ? extends V>> iterable, M m10) {
        C13267j.m79677e(iterable, "<this>");
        C13267j.m79677e(m10, JsbMapKeyNames.H5_CLICK_DEST);
        m67137f(m10, iterable);
        return m10;
    }

    /* renamed from: i */
    public static <K, V> Map<K, V> m67140i(Map<? extends K, ? extends V> map) {
        C13267j.m79677e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? m67141j(map) : C11170d0.m67133c(map) : m67135d();
    }

    /* renamed from: j */
    public static final <K, V> Map<K, V> m67141j(Map<? extends K, ? extends V> map) {
        C13267j.m79677e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
