package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.C1959v;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.j1 */
/* loaded from: classes.dex */
public final class C1925j1 {

    /* renamed from: a */
    public static final Class<?> f9179a = m11774B();

    /* renamed from: b */
    public static final AbstractC1940o1<?, ?> f9180b = m11775C(false);

    /* renamed from: c */
    public static final AbstractC1940o1<?, ?> f9181c = m11775C(true);

    /* renamed from: d */
    public static final AbstractC1940o1<?, ?> f9182d = new C1946q1();

    /* renamed from: A */
    public static <UT, UB> UB m11773A(int i10, List<Integer> list, C1900b0.e eVar, UB ub2, AbstractC1940o1<UT, UB> abstractC1940o1) {
        if (eVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = list.get(i12);
                int iIntValue = num.intValue();
                if (eVar.m11498a(iIntValue)) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    ub2 = (UB) m11784L(i10, iIntValue, ub2, abstractC1940o1);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!eVar.m11498a(iIntValue2)) {
                    ub2 = (UB) m11784L(i10, iIntValue2, ub2, abstractC1940o1);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    /* renamed from: B */
    public static Class<?> m11774B() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: C */
    public static AbstractC1940o1<?, ?> m11775C(boolean z10) {
        try {
            Class<?> clsM11776D = m11776D();
            if (clsM11776D == null) {
                return null;
            }
            return (AbstractC1940o1) clsM11776D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: D */
    public static Class<?> m11776D() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: E */
    public static <T, FT extends C1959v.b<FT>> void m11777E(AbstractC1947r<FT> abstractC1947r, T t10, T t11) {
        C1959v<T> c1959vMo12123c = abstractC1947r.mo12123c(t11);
        if (c1959vMo12123c.m12276m()) {
            return;
        }
        abstractC1947r.mo12124d(t10).m12281t(c1959vMo12123c);
    }

    /* renamed from: F */
    public static <T> void m11778F(InterfaceC1936n0 interfaceC1936n0, T t10, T t11, long j10) {
        C1952s1.m12158O(t10, j10, interfaceC1936n0.mo12049a(C1952s1.m12144A(t10, j10), C1952s1.m12144A(t11, j10)));
    }

    /* renamed from: G */
    public static <T, UT, UB> void m11779G(AbstractC1940o1<UT, UB> abstractC1940o1, T t10, T t11) {
        abstractC1940o1.mo12075p(t10, abstractC1940o1.mo12070k(abstractC1940o1.mo12066g(t10), abstractC1940o1.mo12066g(t11)));
    }

    /* renamed from: H */
    public static AbstractC1940o1<?, ?> m11780H() {
        return f9180b;
    }

    /* renamed from: I */
    public static AbstractC1940o1<?, ?> m11781I() {
        return f9181c;
    }

    /* renamed from: J */
    public static void m11782J(Class<?> cls) {
        Class<?> cls2;
        if (!AbstractC1968z.class.isAssignableFrom(cls) && (cls2 = f9179a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* renamed from: K */
    public static boolean m11783K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: L */
    public static <UT, UB> UB m11784L(int i10, int i11, UB ub2, AbstractC1940o1<UT, UB> abstractC1940o1) {
        if (ub2 == null) {
            ub2 = abstractC1940o1.mo12073n();
        }
        abstractC1940o1.mo12064e(ub2, i10, i11);
        return ub2;
    }

    /* renamed from: M */
    public static AbstractC1940o1<?, ?> m11785M() {
        return f9182d;
    }

    /* renamed from: N */
    public static void m11786N(int i10, List<Boolean> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11980B(i10, list, z10);
    }

    /* renamed from: O */
    public static void m11787O(int i10, List<AbstractC1920i> list, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11993O(i10, list);
    }

    /* renamed from: P */
    public static void m11788P(int i10, List<Double> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11991M(i10, list, z10);
    }

    /* renamed from: Q */
    public static void m11789Q(int i10, List<Integer> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11990L(i10, list, z10);
    }

    /* renamed from: R */
    public static void m11790R(int i10, List<Integer> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11979A(i10, list, z10);
    }

    /* renamed from: S */
    public static void m11791S(int i10, List<Long> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12019x(i10, list, z10);
    }

    /* renamed from: T */
    public static void m11792T(int i10, List<Float> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11996a(i10, list, z10);
    }

    /* renamed from: U */
    public static void m11793U(int i10, List<?> list, InterfaceC1961v1 interfaceC1961v1, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12011p(i10, list, interfaceC1919h1);
    }

    /* renamed from: V */
    public static void m11794V(int i10, List<Integer> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12012q(i10, list, z10);
    }

    /* renamed from: W */
    public static void m11795W(int i10, List<Long> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11989K(i10, list, z10);
    }

    /* renamed from: X */
    public static void m11796X(int i10, List<?> list, InterfaceC1961v1 interfaceC1961v1, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12015t(i10, list, interfaceC1919h1);
    }

    /* renamed from: Y */
    public static void m11797Y(int i10, List<Integer> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12020y(i10, list, z10);
    }

    /* renamed from: Z */
    public static void m11798Z(int i10, List<Long> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12001f(i10, list, z10);
    }

    /* renamed from: a */
    public static int m11799a(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(size) : size * AbstractC1929l.m11901d(i10, true);
    }

    /* renamed from: a0 */
    public static void m11800a0(int i10, List<Integer> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11987I(i10, list, z10);
    }

    /* renamed from: b */
    public static int m11801b(List<?> list) {
        return list.size();
    }

    /* renamed from: b0 */
    public static void m11802b0(int i10, List<Long> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11983E(i10, list, z10);
    }

    /* renamed from: c */
    public static int m11803c(int i10, List<AbstractC1920i> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11893U = size * AbstractC1929l.m11893U(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iM11893U += AbstractC1929l.m11907h(list.get(i11));
        }
        return iM11893U;
    }

    /* renamed from: c0 */
    public static void m11804c0(int i10, List<String> list, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12007l(i10, list);
    }

    /* renamed from: d */
    public static int m11805d(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11807e = m11807e(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11807e) : iM11807e + (size * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: d0 */
    public static void m11806d0(int i10, List<Integer> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo11982D(i10, list, z10);
    }

    /* renamed from: e */
    public static int m11807e(List<Integer> list) {
        int iM11911l;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1897a0) {
            C1897a0 c1897a0 = (C1897a0) list;
            iM11911l = 0;
            while (i10 < size) {
                iM11911l += AbstractC1929l.m11911l(c1897a0.m11474h(i10));
                i10++;
            }
        } else {
            iM11911l = 0;
            while (i10 < size) {
                iM11911l += AbstractC1929l.m11911l(list.get(i10).intValue());
                i10++;
            }
        }
        return iM11911l;
    }

    /* renamed from: e0 */
    public static void m11808e0(int i10, List<Long> list, InterfaceC1961v1 interfaceC1961v1, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC1961v1.mo12003h(i10, list, z10);
    }

    /* renamed from: f */
    public static int m11809f(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(size * 4) : size * AbstractC1929l.m11912m(i10, 0);
    }

    /* renamed from: g */
    public static int m11810g(List<?> list) {
        return list.size() * 4;
    }

    /* renamed from: h */
    public static int m11811h(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(size * 8) : size * AbstractC1929l.m11914o(i10, 0L);
    }

    /* renamed from: i */
    public static int m11812i(List<?> list) {
        return list.size() * 8;
    }

    /* renamed from: j */
    public static int m11813j(int i10, List<InterfaceC1951s0> list, InterfaceC1919h1 interfaceC1919h1) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11918s = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iM11918s += AbstractC1929l.m11918s(i10, list.get(i11), interfaceC1919h1);
        }
        return iM11918s;
    }

    /* renamed from: k */
    public static int m11814k(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11815l = m11815l(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11815l) : iM11815l + (size * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: l */
    public static int m11815l(List<Integer> list) {
        int iM11922w;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1897a0) {
            C1897a0 c1897a0 = (C1897a0) list;
            iM11922w = 0;
            while (i10 < size) {
                iM11922w += AbstractC1929l.m11922w(c1897a0.m11474h(i10));
                i10++;
            }
        } else {
            iM11922w = 0;
            while (i10 < size) {
                iM11922w += AbstractC1929l.m11922w(list.get(i10).intValue());
                i10++;
            }
        }
        return iM11922w;
    }

    /* renamed from: m */
    public static int m11816m(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int iM11817n = m11817n(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11817n) : iM11817n + (list.size() * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: n */
    public static int m11817n(List<Long> list) {
        int iM11924y;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1924j0) {
            C1924j0 c1924j0 = (C1924j0) list;
            iM11924y = 0;
            while (i10 < size) {
                iM11924y += AbstractC1929l.m11924y(c1924j0.m11768h(i10));
                i10++;
            }
        } else {
            iM11924y = 0;
            while (i10 < size) {
                iM11924y += AbstractC1929l.m11924y(list.get(i10).longValue());
                i10++;
            }
        }
        return iM11924y;
    }

    /* renamed from: o */
    public static int m11818o(int i10, Object obj, InterfaceC1919h1 interfaceC1919h1) {
        return obj instanceof C1912f0 ? AbstractC1929l.m11873A(i10, (C1912f0) obj) : AbstractC1929l.m11878F(i10, (InterfaceC1951s0) obj, interfaceC1919h1);
    }

    /* renamed from: p */
    public static int m11819p(int i10, List<?> list, InterfaceC1919h1 interfaceC1919h1) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11893U = AbstractC1929l.m11893U(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            iM11893U += obj instanceof C1912f0 ? AbstractC1929l.m11874B((C1912f0) obj) : AbstractC1929l.m11880H((InterfaceC1951s0) obj, interfaceC1919h1);
        }
        return iM11893U;
    }

    /* renamed from: q */
    public static int m11820q(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11821r = m11821r(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11821r) : iM11821r + (size * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: r */
    public static int m11821r(List<Integer> list) {
        int iM11888P;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1897a0) {
            C1897a0 c1897a0 = (C1897a0) list;
            iM11888P = 0;
            while (i10 < size) {
                iM11888P += AbstractC1929l.m11888P(c1897a0.m11474h(i10));
                i10++;
            }
        } else {
            iM11888P = 0;
            while (i10 < size) {
                iM11888P += AbstractC1929l.m11888P(list.get(i10).intValue());
                i10++;
            }
        }
        return iM11888P;
    }

    /* renamed from: s */
    public static int m11822s(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11823t = m11823t(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11823t) : iM11823t + (size * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: t */
    public static int m11823t(List<Long> list) {
        int iM11890R;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1924j0) {
            C1924j0 c1924j0 = (C1924j0) list;
            iM11890R = 0;
            while (i10 < size) {
                iM11890R += AbstractC1929l.m11890R(c1924j0.m11768h(i10));
                i10++;
            }
        } else {
            iM11890R = 0;
            while (i10 < size) {
                iM11890R += AbstractC1929l.m11890R(list.get(i10).longValue());
                i10++;
            }
        }
        return iM11890R;
    }

    /* renamed from: u */
    public static int m11824u(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iM11893U = AbstractC1929l.m11893U(i10) * size;
        if (list instanceof InterfaceC1918h0) {
            InterfaceC1918h0 interfaceC1918h0 = (InterfaceC1918h0) list;
            while (i11 < size) {
                Object objMo11660a0 = interfaceC1918h0.mo11660a0(i11);
                iM11893U += objMo11660a0 instanceof AbstractC1920i ? AbstractC1929l.m11907h((AbstractC1920i) objMo11660a0) : AbstractC1929l.m11892T((String) objMo11660a0);
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                iM11893U += obj instanceof AbstractC1920i ? AbstractC1929l.m11907h((AbstractC1920i) obj) : AbstractC1929l.m11892T((String) obj);
                i11++;
            }
        }
        return iM11893U;
    }

    /* renamed from: v */
    public static int m11825v(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11826w = m11826w(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11826w) : iM11826w + (size * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: w */
    public static int m11826w(List<Integer> list) {
        int iM11895W;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1897a0) {
            C1897a0 c1897a0 = (C1897a0) list;
            iM11895W = 0;
            while (i10 < size) {
                iM11895W += AbstractC1929l.m11895W(c1897a0.m11474h(i10));
                i10++;
            }
        } else {
            iM11895W = 0;
            while (i10 < size) {
                iM11895W += AbstractC1929l.m11895W(list.get(i10).intValue());
                i10++;
            }
        }
        return iM11895W;
    }

    /* renamed from: x */
    public static int m11827x(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM11828y = m11828y(list);
        return z10 ? AbstractC1929l.m11893U(i10) + AbstractC1929l.m11875C(iM11828y) : iM11828y + (size * AbstractC1929l.m11893U(i10));
    }

    /* renamed from: y */
    public static int m11828y(List<Long> list) {
        int iM11897Y;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1924j0) {
            C1924j0 c1924j0 = (C1924j0) list;
            iM11897Y = 0;
            while (i10 < size) {
                iM11897Y += AbstractC1929l.m11897Y(c1924j0.m11768h(i10));
                i10++;
            }
        } else {
            iM11897Y = 0;
            while (i10 < size) {
                iM11897Y += AbstractC1929l.m11897Y(list.get(i10).longValue());
                i10++;
            }
        }
        return iM11897Y;
    }

    /* renamed from: z */
    public static <UT, UB> UB m11829z(int i10, List<Integer> list, C1900b0.d<?> dVar, UB ub2, AbstractC1940o1<UT, UB> abstractC1940o1) {
        if (dVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = list.get(i12);
                int iIntValue = num.intValue();
                if (dVar.mo11497a(iIntValue) != null) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    ub2 = (UB) m11784L(i10, iIntValue, ub2, abstractC1940o1);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (dVar.mo11497a(iIntValue2) == null) {
                    ub2 = (UB) m11784L(i10, iIntValue2, ub2, abstractC1940o1);
                    it.remove();
                }
            }
        }
        return ub2;
    }
}
