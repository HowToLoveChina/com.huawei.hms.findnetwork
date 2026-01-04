package p036bl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* renamed from: bl.j */
/* loaded from: classes6.dex */
public class C1259j {

    /* renamed from: a */
    public static final Map<Integer, List<Integer>> f5690a;

    /* renamed from: b */
    public static final Map<Integer, List<Integer>> f5691b;

    static {
        HashMap map = new HashMap();
        f5690a = map;
        HashMap map2 = new HashMap();
        f5691b = map2;
        map.put(0, Arrays.asList(6, -1));
        map.put(1, Arrays.asList(3, 5, 8));
        map.put(2, Arrays.asList(0, 1, 2, 4, 7, 10));
        map.put(3, Collections.singletonList(4));
        map2.put(4, Collections.singletonList(0));
        map2.put(5, Collections.singletonList(1));
        map2.put(6, Collections.singletonList(2));
        map2.put(7, Arrays.asList(-1, -2));
    }

    /* renamed from: c */
    public static int m7507c(final int i10) {
        return ((Integer) f5690a.entrySet().stream().filter(new Predicate() { // from class: bl.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C1259j.m7509e(i10, (Map.Entry) obj);
            }
        }).findAny().filter(new C1256g()).map(new C1257h()).orElse(-1)).intValue();
    }

    /* renamed from: d */
    public static int m7508d(final int i10) {
        return ((Integer) f5691b.entrySet().stream().filter(new Predicate() { // from class: bl.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C1259j.m7510f(i10, (Map.Entry) obj);
            }
        }).findAny().filter(new C1256g()).map(new C1257h()).orElse(-1)).intValue();
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m7509e(int i10, Map.Entry entry) {
        return ((List) entry.getValue()).contains(Integer.valueOf(i10));
    }

    /* renamed from: f */
    public static /* synthetic */ boolean m7510f(int i10, Map.Entry entry) {
        return ((List) entry.getValue()).contains(Integer.valueOf(i10));
    }
}
