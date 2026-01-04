package p590qt;

import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import mt.C11518e;
import mt.C11522i;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p244e1.C9381e;
import p533ot.C12027b;
import p689ut.C13252e;

/* renamed from: qt.o */
/* loaded from: classes5.dex */
public class C12407o {
    /* renamed from: A */
    public static double m74480A(List<C11518e> list) {
        return list.stream().mapToInt(new ToIntFunction() { // from class: qt.h
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return C12407o.m74515y((C11518e) obj);
            }
        }).average().orElse(0.0d);
    }

    /* renamed from: B */
    public static /* synthetic */ String m74481B(C11518e c11518e) {
        return c11518e.m68734n().m68743c();
    }

    /* renamed from: C */
    public static /* synthetic */ Integer m74482C(C11518e c11518e) {
        return Integer.valueOf(c11518e.m68734n().m68744d());
    }

    /* renamed from: D */
    public static <T> boolean m74483D(List<T> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(list.get(0))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: E */
    public static <T> T m74484E(List<T> list) {
        T t10 = (T) null;
        if (list != null && !list.isEmpty()) {
            HashMap map = new HashMap();
            for (T t11 : list) {
                map.put(t11, Integer.valueOf(((Integer) map.getOrDefault(t11, 0)).intValue() + 1));
            }
            int iIntValue = 2;
            for (Map.Entry entry : map.entrySet()) {
                if (((Integer) entry.getValue()).intValue() >= iIntValue) {
                    t10 = (T) entry.getKey();
                    iIntValue = ((Integer) entry.getValue()).intValue();
                }
            }
        }
        return t10;
    }

    /* renamed from: F */
    public static /* synthetic */ boolean m74485F(C11518e c11518e) {
        return c11518e.m68731k() >= 0.8d;
    }

    /* renamed from: G */
    public static String m74486G(List<C11518e> list) {
        HashMap map = new HashMap();
        Iterator<C11518e> it = list.iterator();
        while (it.hasNext()) {
            String strM68746f = it.next().m68734n().m68746f();
            if (strM68746f != null && !strM68746f.isEmpty()) {
                try {
                    C9381e c9381eM58768o = AbstractC9377a.m58768o(strM68746f);
                    if (c9381eM58768o != null) {
                        m74506p(map, c9381eM58768o, "floorName");
                    }
                } catch (C9380d unused) {
                    C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "floorInfo JSONException");
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map2.put(entry.getKey(), m74484E((List) entry.getValue()));
        }
        C9381e c9381e = new C9381e();
        c9381e.putAll(map2);
        return c9381e.mo58779c();
    }

    /* renamed from: H */
    public static /* synthetic */ boolean m74487H(C11518e c11518e) {
        return c11518e.m68734n().m68745e() >= 30;
    }

    /* renamed from: I */
    public static /* synthetic */ boolean m74488I(C11518e c11518e) {
        return c11518e.m68734n().m68744d() != -100;
    }

    /* renamed from: J */
    public static /* synthetic */ boolean m74489J(C11518e c11518e) {
        return (c11518e.m68734n().m68743c() == null || c11518e.m68734n().m68743c().equals("null")) ? false : true;
    }

    /* renamed from: K */
    public static /* synthetic */ boolean m74490K(C11518e c11518e) {
        return c11518e.m68730j().m68738a() < -85;
    }

    /* renamed from: n */
    public static /* synthetic */ List m74504n(String str) {
        return new ArrayList();
    }

    /* renamed from: o */
    public static List<C11518e> m74505o(final C11522i c11522i, List<C11518e> list) {
        return (List) list.stream().filter(new Predicate() { // from class: qt.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74489J((C11518e) obj);
            }
        }).filter(new Predicate() { // from class: qt.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74488I((C11518e) obj);
            }
        }).filter(new Predicate() { // from class: qt.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74487H((C11518e) obj);
            }
        }).filter(new Predicate() { // from class: qt.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74485F((C11518e) obj);
            }
        }).filter(new Predicate() { // from class: qt.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74512v(c11522i, (C11518e) obj);
            }
        }).filter(new Predicate() { // from class: qt.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74511u(c11522i, (C11518e) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: p */
    public static void m74506p(Map<String, List<String>> map, C9381e c9381e, String str) {
        String strM58794N = c9381e.m58794N(str);
        if (strM58794N != null) {
            map.computeIfAbsent(str, new Function() { // from class: qt.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C12407o.m74504n((String) obj);
                }
            }).add(strM58794N);
        }
    }

    /* renamed from: q */
    public static void m74507q(C11522i c11522i, List<C11518e> list, String str, int i10) {
        c11522i.m68782r(1);
        c11522i.m68776l(str);
        c11522i.m68779o(i10);
        c11522i.m68780p((int) m74480A(list));
        c11522i.m68781q(m74486G(list));
    }

    /* renamed from: r */
    public static void m74508r(C11522i c11522i, List<C11518e> list, C13252e c13252e) {
        final String str = (String) m74484E(m74516z(list));
        if (str == null) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "selectMostOccurrences buildingId==null");
            return;
        }
        list.removeIf(new Predicate() { // from class: qt.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74510t(str, (C11518e) obj);
            }
        });
        c13252e.m79645f("In the same building", list);
        final Integer num = (Integer) m74484E(m74514x(list));
        if (num == null) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "selectMostOccurrences floor==null");
            return;
        }
        list.removeIf(new Predicate() { // from class: qt.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12407o.m74509s(num, (C11518e) obj);
            }
        });
        c13252e.m79645f("On the same floor", list);
        m74507q(c11522i, list, str, num.intValue());
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m74509s(Integer num, C11518e c11518e) {
        return num.intValue() != c11518e.m68734n().m68744d();
    }

    /* renamed from: t */
    public static /* synthetic */ boolean m74510t(String str, C11518e c11518e) {
        return !str.equals(c11518e.m68734n().m68743c());
    }

    /* renamed from: u */
    public static /* synthetic */ boolean m74511u(C11522i c11522i, C11518e c11518e) {
        return Math.abs(c11522i.m68772h() - c11518e.m68730j().m68739b()) < AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL;
    }

    /* renamed from: v */
    public static /* synthetic */ boolean m74512v(C11522i c11522i, C11518e c11518e) {
        return C12027b.m72165c(new double[]{c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g()}, new double[]{c11522i.m68771g(), c11522i.m68770f()}) < 100.0d;
    }

    /* renamed from: w */
    public static void m74513w(C11522i c11522i, List<C11518e> list) {
        if (c11522i == null || list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "Res or infos == null or empty");
            return;
        }
        List<C11518e> listM74505o = m74505o(c11522i, list);
        if (listM74505o.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "IndoorInfos is empty");
            return;
        }
        C13252e c13252e = new C13252e(list.size());
        c13252e.m79645f("After filter indoor info", listM74505o);
        if (listM74505o.size() < 3 || !m74483D(m74516z(listM74505o)) || !m74483D(m74514x(listM74505o))) {
            listM74505o.removeIf(new Predicate() { // from class: qt.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C12407o.m74490K((C11518e) obj);
                }
            });
            c13252e.m79645f("After filter rssi", listM74505o);
            m74508r(c11522i, listM74505o, c13252e);
            c11522i.m68773i().m68790e(c13252e.m79644e());
            return;
        }
        String strM68743c = listM74505o.get(0).m68734n().m68743c();
        int iM68744d = listM74505o.get(0).m68734n().m68744d();
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "infos have the same buildingId and floor");
        c11522i.m68773i().m68790e(c13252e.m79644e());
        m74507q(c11522i, listM74505o, strM68743c, iM68744d);
    }

    /* renamed from: x */
    public static List<Integer> m74514x(List<C11518e> list) {
        return (List) list.stream().map(new Function() { // from class: qt.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12407o.m74482C((C11518e) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: y */
    public static /* synthetic */ int m74515y(C11518e c11518e) {
        return c11518e.m68734n().m68745e();
    }

    /* renamed from: z */
    public static List<String> m74516z(List<C11518e> list) {
        return (List) list.stream().map(new Function() { // from class: qt.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12407o.m74481B((C11518e) obj);
            }
        }).collect(Collectors.toList());
    }
}
