package al;

import cl.InterfaceC1446a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import je.C10782d;
import p036bl.C1251b;
import p230dl.C9168d;
import p261el.C9500a;
import p514o9.C11839m;

/* renamed from: al.g */
/* loaded from: classes6.dex */
public class C0248g {

    /* renamed from: a */
    public static final Map<Integer, List<Integer>> f875a;

    /* renamed from: b */
    public static final List<Integer> f876b;

    static {
        HashMap map = new HashMap();
        f875a = map;
        List<Integer> listAsList = Arrays.asList(1, 0);
        f876b = listAsList;
        map.put(0, listAsList);
        map.put(1, Arrays.asList(0, 1));
    }

    /* renamed from: c */
    public static /* synthetic */ int m1692c(List list, InterfaceC1446a interfaceC1446a, InterfaceC1446a interfaceC1446a2) {
        if (list == null) {
            list = f876b;
        }
        return list.indexOf(Integer.valueOf(interfaceC1446a.getChannel())) - list.indexOf(Integer.valueOf(interfaceC1446a2.getChannel()));
    }

    /* renamed from: d */
    public static /* synthetic */ boolean m1693d(String str, long j10, boolean z10, boolean z11, InterfaceC1446a interfaceC1446a) {
        return interfaceC1446a.mo7490b(str, j10, z10, z11);
    }

    /* renamed from: e */
    public static List<InterfaceC1446a> m1694e(final String str, final long j10, final boolean z10, final boolean z11) {
        int iM59437a = C9500a.m59437a("adRequestOrder", 0);
        boolean zM65645l = C10782d.m65634a().m65645l();
        final List<Integer> orDefault = f875a.getOrDefault(Integer.valueOf(iM59437a), f876b);
        List<InterfaceC1446a> list = (List) Stream.of((Object[]) new InterfaceC1446a[]{new C9168d(zM65645l), new C1251b(zM65645l)}).sorted(new Comparator() { // from class: al.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0248g.m1692c(orDefault, (InterfaceC1446a) obj, (InterfaceC1446a) obj2);
            }
        }).filter(new Predicate() { // from class: al.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C0248g.m1693d(str, j10, z10, z11, (InterfaceC1446a) obj);
            }
        }).collect(Collectors.toList());
        C11839m.m70688i("ProcessorOrchestrator", "mashupProcessor appId: " + str + " localVer: " + j10 + " isRefurbishment: " + z10 + " tempBackup: " + z11 + " orderKey: " + iM59437a + " processor: " + list.stream().filter(new Predicate() { // from class: al.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((InterfaceC1446a) obj);
            }
        }).map(new Function() { // from class: al.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InterfaceC1446a) obj).getChannel());
            }
        }).collect(Collectors.toList()));
        return list;
    }
}
