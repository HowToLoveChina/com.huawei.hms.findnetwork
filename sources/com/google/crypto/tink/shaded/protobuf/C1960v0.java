package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.C1908e;
import com.google.crypto.tink.shaded.protobuf.C1930l0;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.crypto.tink.shaded.protobuf.v0 */
/* loaded from: classes.dex */
public final class C1960v0<T> implements InterfaceC1919h1<T> {

    /* renamed from: r */
    public static final int[] f9325r = new int[0];

    /* renamed from: s */
    public static final Unsafe f9326s = C1952s1.m12145B();

    /* renamed from: a */
    public final int[] f9327a;

    /* renamed from: b */
    public final Object[] f9328b;

    /* renamed from: c */
    public final int f9329c;

    /* renamed from: d */
    public final int f9330d;

    /* renamed from: e */
    public final InterfaceC1951s0 f9331e;

    /* renamed from: f */
    public final boolean f9332f;

    /* renamed from: g */
    public final boolean f9333g;

    /* renamed from: h */
    public final boolean f9334h;

    /* renamed from: i */
    public final boolean f9335i;

    /* renamed from: j */
    public final int[] f9336j;

    /* renamed from: k */
    public final int f9337k;

    /* renamed from: l */
    public final int f9338l;

    /* renamed from: m */
    public final InterfaceC1965x0 f9339m;

    /* renamed from: n */
    public final AbstractC1921i0 f9340n;

    /* renamed from: o */
    public final AbstractC1940o1<?, ?> f9341o;

    /* renamed from: p */
    public final AbstractC1947r<?> f9342p;

    /* renamed from: q */
    public final InterfaceC1936n0 f9343q;

    public C1960v0(int[] iArr, Object[] objArr, int i10, int i11, InterfaceC1951s0 interfaceC1951s0, boolean z10, boolean z11, int[] iArr2, int i12, int i13, InterfaceC1965x0 interfaceC1965x0, AbstractC1921i0 abstractC1921i0, AbstractC1940o1<?, ?> abstractC1940o1, AbstractC1947r<?> abstractC1947r, InterfaceC1936n0 interfaceC1936n0) {
        this.f9327a = iArr;
        this.f9328b = objArr;
        this.f9329c = i10;
        this.f9330d = i11;
        this.f9333g = interfaceC1951s0 instanceof AbstractC1968z;
        this.f9334h = z10;
        this.f9332f = abstractC1947r != null && abstractC1947r.mo12125e(interfaceC1951s0);
        this.f9335i = z11;
        this.f9336j = iArr2;
        this.f9337k = i12;
        this.f9338l = i13;
        this.f9339m = interfaceC1965x0;
        this.f9340n = abstractC1921i0;
        this.f9341o = abstractC1940o1;
        this.f9342p = abstractC1947r;
        this.f9331e = interfaceC1951s0;
        this.f9343q = interfaceC1936n0;
    }

    /* renamed from: A */
    public static boolean m12291A(int i10) {
        return (i10 & 536870912) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D */
    public static boolean m12292D(Object obj, int i10, InterfaceC1919h1 interfaceC1919h1) {
        return interfaceC1919h1.mo11669c(C1952s1.m12144A(obj, m12299U(i10)));
    }

    /* renamed from: I */
    public static boolean m12293I(int i10) {
        return (i10 & HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK) != 0;
    }

    /* renamed from: J */
    public static List<?> m12294J(Object obj, long j10) {
        return (List) C1952s1.m12144A(obj, j10);
    }

    /* renamed from: K */
    public static <T> long m12295K(T t10, long j10) {
        return C1952s1.m12185y(t10, j10);
    }

    /* renamed from: Q */
    public static <T> C1960v0<T> m12296Q(Class<T> cls, InterfaceC1945q0 interfaceC1945q0, InterfaceC1965x0 interfaceC1965x0, AbstractC1921i0 abstractC1921i0, AbstractC1940o1<?, ?> abstractC1940o1, AbstractC1947r<?> abstractC1947r, InterfaceC1936n0 interfaceC1936n0) {
        return interfaceC1945q0 instanceof C1913f1 ? m12298S((C1913f1) interfaceC1945q0, interfaceC1965x0, abstractC1921i0, abstractC1940o1, abstractC1947r, interfaceC1936n0) : m12297R((C1931l1) interfaceC1945q0, interfaceC1965x0, abstractC1921i0, abstractC1940o1, abstractC1947r, interfaceC1936n0);
    }

    /* renamed from: R */
    public static <T> C1960v0<T> m12297R(C1931l1 c1931l1, InterfaceC1965x0 interfaceC1965x0, AbstractC1921i0 abstractC1921i0, AbstractC1940o1<?, ?> abstractC1940o1, AbstractC1947r<?> abstractC1947r, InterfaceC1936n0 interfaceC1936n0) {
        boolean z10 = c1931l1.mo11641c() == EnumC1904c1.PROTO3;
        C1956u[] c1956uArrM11977e = c1931l1.m11977e();
        if (c1956uArrM11977e.length != 0) {
            C1956u c1956u = c1956uArrM11977e[0];
            throw null;
        }
        int length = c1956uArrM11977e.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (c1956uArrM11977e.length > 0) {
            C1956u c1956u2 = c1956uArrM11977e[0];
            throw null;
        }
        int[] iArrM11976d = c1931l1.m11976d();
        if (iArrM11976d == null) {
            iArrM11976d = f9325r;
        }
        if (c1956uArrM11977e.length > 0) {
            C1956u c1956u3 = c1956uArrM11977e[0];
            throw null;
        }
        int[] iArr2 = f9325r;
        int[] iArr3 = f9325r;
        int[] iArr4 = new int[iArrM11976d.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrM11976d, 0, iArr4, 0, iArrM11976d.length);
        System.arraycopy(iArr2, 0, iArr4, iArrM11976d.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrM11976d.length + iArr2.length, iArr3.length);
        return new C1960v0<>(iArr, objArr, 0, 0, c1931l1.mo11640b(), z10, true, iArr4, iArrM11976d.length, iArrM11976d.length + iArr2.length, interfaceC1965x0, abstractC1921i0, abstractC1940o1, abstractC1947r, interfaceC1936n0);
    }

    /* JADX WARN: Removed duplicated region for block: B:340:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x03a0  */
    /* renamed from: S */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.crypto.tink.shaded.protobuf.C1960v0<T> m12298S(com.google.crypto.tink.shaded.protobuf.C1913f1 r35, com.google.crypto.tink.shaded.protobuf.InterfaceC1965x0 r36, com.google.crypto.tink.shaded.protobuf.AbstractC1921i0 r37, com.google.crypto.tink.shaded.protobuf.AbstractC1940o1<?, ?> r38, com.google.crypto.tink.shaded.protobuf.AbstractC1947r<?> r39, com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0 r40) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12298S(com.google.crypto.tink.shaded.protobuf.f1, com.google.crypto.tink.shaded.protobuf.x0, com.google.crypto.tink.shaded.protobuf.i0, com.google.crypto.tink.shaded.protobuf.o1, com.google.crypto.tink.shaded.protobuf.r, com.google.crypto.tink.shaded.protobuf.n0):com.google.crypto.tink.shaded.protobuf.v0");
    }

    /* renamed from: U */
    public static long m12299U(int i10) {
        return i10 & 1048575;
    }

    /* renamed from: V */
    public static <T> boolean m12300V(T t10, long j10) {
        return ((Boolean) C1952s1.m12144A(t10, j10)).booleanValue();
    }

    /* renamed from: W */
    public static <T> double m12301W(T t10, long j10) {
        return ((Double) C1952s1.m12144A(t10, j10)).doubleValue();
    }

    /* renamed from: X */
    public static <T> float m12302X(T t10, long j10) {
        return ((Float) C1952s1.m12144A(t10, j10)).floatValue();
    }

    /* renamed from: Y */
    public static <T> int m12303Y(T t10, long j10) {
        return ((Integer) C1952s1.m12144A(t10, j10)).intValue();
    }

    /* renamed from: Z */
    public static <T> long m12304Z(T t10, long j10) {
        return ((Long) C1952s1.m12144A(t10, j10)).longValue();
    }

    /* renamed from: l */
    public static <T> boolean m12305l(T t10, long j10) {
        return C1952s1.m12176p(t10, j10);
    }

    /* renamed from: m0 */
    public static Field m12306m0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* renamed from: n */
    public static <T> double m12307n(T t10, long j10) {
        return C1952s1.m12182v(t10, j10);
    }

    /* renamed from: q0 */
    public static int m12308q0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    /* renamed from: r */
    public static <T> float m12309r(T t10, long j10) {
        return C1952s1.m12183w(t10, j10);
    }

    /* renamed from: v */
    public static C1943p1 m12310v(Object obj) {
        AbstractC1968z abstractC1968z = (AbstractC1968z) obj;
        C1943p1 c1943p1 = abstractC1968z.unknownFields;
        if (c1943p1 != C1943p1.m12088e()) {
            return c1943p1;
        }
        C1943p1 c1943p1M12092l = C1943p1.m12092l();
        abstractC1968z.unknownFields = c1943p1M12092l;
        return c1943p1M12092l;
    }

    /* renamed from: z */
    public static <T> int m12311z(T t10, long j10) {
        return C1952s1.m12184x(t10, j10);
    }

    /* renamed from: B */
    public final boolean m12312B(T t10, int i10) {
        if (!this.f9334h) {
            int iM12331h0 = m12331h0(i10);
            return (C1952s1.m12184x(t10, (long) (iM12331h0 & 1048575)) & (1 << (iM12331h0 >>> 20))) != 0;
        }
        int iM12344r0 = m12344r0(i10);
        long jM12299U = m12299U(iM12344r0);
        switch (m12308q0(iM12344r0)) {
            case 0:
                return C1952s1.m12182v(t10, jM12299U) != 0.0d;
            case 1:
                return C1952s1.m12183w(t10, jM12299U) != 0.0f;
            case 2:
                return C1952s1.m12185y(t10, jM12299U) != 0;
            case 3:
                return C1952s1.m12185y(t10, jM12299U) != 0;
            case 4:
                return C1952s1.m12184x(t10, jM12299U) != 0;
            case 5:
                return C1952s1.m12185y(t10, jM12299U) != 0;
            case 6:
                return C1952s1.m12184x(t10, jM12299U) != 0;
            case 7:
                return C1952s1.m12176p(t10, jM12299U);
            case 8:
                Object objM12144A = C1952s1.m12144A(t10, jM12299U);
                if (objM12144A instanceof String) {
                    return !((String) objM12144A).isEmpty();
                }
                if (objM12144A instanceof AbstractC1920i) {
                    return !AbstractC1920i.f9147b.equals(objM12144A);
                }
                throw new IllegalArgumentException();
            case 9:
                return C1952s1.m12144A(t10, jM12299U) != null;
            case 10:
                return !AbstractC1920i.f9147b.equals(C1952s1.m12144A(t10, jM12299U));
            case 11:
                return C1952s1.m12184x(t10, jM12299U) != 0;
            case 12:
                return C1952s1.m12184x(t10, jM12299U) != 0;
            case 13:
                return C1952s1.m12184x(t10, jM12299U) != 0;
            case 14:
                return C1952s1.m12185y(t10, jM12299U) != 0;
            case 15:
                return C1952s1.m12184x(t10, jM12299U) != 0;
            case 16:
                return C1952s1.m12185y(t10, jM12299U) != 0;
            case 17:
                return C1952s1.m12144A(t10, jM12299U) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: C */
    public final boolean m12313C(T t10, int i10, int i11, int i12) {
        return this.f9334h ? m12312B(t10, i10) : (i11 & i12) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: E */
    public final <N> boolean m12314E(Object obj, int i10, int i11) {
        List list = (List) C1952s1.m12144A(obj, m12299U(i10));
        if (list.isEmpty()) {
            return true;
        }
        InterfaceC1919h1 interfaceC1919h1M12349u = m12349u(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!interfaceC1919h1M12349u.mo11669c(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: F */
    public final boolean m12315F(T t10, int i10, int i11) {
        if (this.f9343q.mo12056h(C1952s1.m12144A(t10, m12299U(i10))).isEmpty()) {
            return true;
        }
        this.f9343q.mo12051c(m12347t(i11));
        throw null;
    }

    /* renamed from: G */
    public final boolean m12316G(T t10, T t11, int i10) {
        long jM12331h0 = m12331h0(i10) & 1048575;
        return C1952s1.m12184x(t10, jM12331h0) == C1952s1.m12184x(t11, jM12331h0);
    }

    /* renamed from: H */
    public final boolean m12317H(T t10, int i10, int i11) {
        return C1952s1.m12184x(t10, (long) (m12331h0(i11) & 1048575)) == i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:401:0x007b, code lost:
    
        r0 = r16.f9337k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x007f, code lost:
    
        if (r0 >= r16.f9338l) goto L726;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0081, code lost:
    
        r13 = m12341p(r19, r16.f9336j[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x008c, code lost:
    
        if (r13 == null) goto L730;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x008e, code lost:
    
        r17.mo12074o(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0091, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:730:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <UT, UB, ET extends com.google.crypto.tink.shaded.protobuf.C1959v.b<ET>> void m12318L(com.google.crypto.tink.shaded.protobuf.AbstractC1940o1<UT, UB> r17, com.google.crypto.tink.shaded.protobuf.AbstractC1947r<ET> r18, T r19, com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1 r20, com.google.crypto.tink.shaded.protobuf.C1944q r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12318L(com.google.crypto.tink.shaded.protobuf.o1, com.google.crypto.tink.shaded.protobuf.r, java.lang.Object, com.google.crypto.tink.shaded.protobuf.g1, com.google.crypto.tink.shaded.protobuf.q):void");
    }

    /* renamed from: M */
    public final <K, V> void m12319M(Object obj, int i10, Object obj2, C1944q c1944q, InterfaceC1916g1 interfaceC1916g1) throws IOException {
        long jM12299U = m12299U(m12344r0(i10));
        Object objM12144A = C1952s1.m12144A(obj, jM12299U);
        if (objM12144A == null) {
            objM12144A = this.f9343q.mo12053e(obj2);
            C1952s1.m12158O(obj, jM12299U, objM12144A);
        } else if (this.f9343q.mo12055g(objM12144A)) {
            Object objMo12053e = this.f9343q.mo12053e(obj2);
            this.f9343q.mo12049a(objMo12053e, objM12144A);
            C1952s1.m12158O(obj, jM12299U, objMo12053e);
            objM12144A = objMo12053e;
        }
        Map<?, ?> mapMo12052d = this.f9343q.mo12052d(objM12144A);
        this.f9343q.mo12051c(obj2);
        interfaceC1916g1.mo11580K(mapMo12052d, null, c1944q);
    }

    /* renamed from: N */
    public final void m12320N(T t10, T t11, int i10) {
        long jM12299U = m12299U(m12344r0(i10));
        if (m12312B(t11, i10)) {
            Object objM12144A = C1952s1.m12144A(t10, jM12299U);
            Object objM12144A2 = C1952s1.m12144A(t11, jM12299U);
            if (objM12144A != null && objM12144A2 != null) {
                C1952s1.m12158O(t10, jM12299U, C1900b0.m11493h(objM12144A, objM12144A2));
                m12338n0(t10, i10);
            } else if (objM12144A2 != null) {
                C1952s1.m12158O(t10, jM12299U, objM12144A2);
                m12338n0(t10, i10);
            }
        }
    }

    /* renamed from: O */
    public final void m12321O(T t10, T t11, int i10) {
        int iM12344r0 = m12344r0(i10);
        int iM12323T = m12323T(i10);
        long jM12299U = m12299U(iM12344r0);
        if (m12317H(t11, iM12323T, i10)) {
            Object objM12144A = C1952s1.m12144A(t10, jM12299U);
            Object objM12144A2 = C1952s1.m12144A(t11, jM12299U);
            if (objM12144A != null && objM12144A2 != null) {
                C1952s1.m12158O(t10, jM12299U, C1900b0.m11493h(objM12144A, objM12144A2));
                m12340o0(t10, iM12323T, i10);
            } else if (objM12144A2 != null) {
                C1952s1.m12158O(t10, jM12299U, objM12144A2);
                m12340o0(t10, iM12323T, i10);
            }
        }
    }

    /* renamed from: P */
    public final void m12322P(T t10, T t11, int i10) {
        int iM12344r0 = m12344r0(i10);
        long jM12299U = m12299U(iM12344r0);
        int iM12323T = m12323T(i10);
        switch (m12308q0(iM12344r0)) {
            case 0:
                if (m12312B(t11, i10)) {
                    C1952s1.m12154K(t10, jM12299U, C1952s1.m12182v(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 1:
                if (m12312B(t11, i10)) {
                    C1952s1.m12155L(t10, jM12299U, C1952s1.m12183w(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 2:
                if (m12312B(t11, i10)) {
                    C1952s1.m12157N(t10, jM12299U, C1952s1.m12185y(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 3:
                if (m12312B(t11, i10)) {
                    C1952s1.m12157N(t10, jM12299U, C1952s1.m12185y(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 4:
                if (m12312B(t11, i10)) {
                    C1952s1.m12156M(t10, jM12299U, C1952s1.m12184x(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 5:
                if (m12312B(t11, i10)) {
                    C1952s1.m12157N(t10, jM12299U, C1952s1.m12185y(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 6:
                if (m12312B(t11, i10)) {
                    C1952s1.m12156M(t10, jM12299U, C1952s1.m12184x(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 7:
                if (m12312B(t11, i10)) {
                    C1952s1.m12148E(t10, jM12299U, C1952s1.m12176p(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 8:
                if (m12312B(t11, i10)) {
                    C1952s1.m12158O(t10, jM12299U, C1952s1.m12144A(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 9:
                m12320N(t10, t11, i10);
                break;
            case 10:
                if (m12312B(t11, i10)) {
                    C1952s1.m12158O(t10, jM12299U, C1952s1.m12144A(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 11:
                if (m12312B(t11, i10)) {
                    C1952s1.m12156M(t10, jM12299U, C1952s1.m12184x(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 12:
                if (m12312B(t11, i10)) {
                    C1952s1.m12156M(t10, jM12299U, C1952s1.m12184x(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 13:
                if (m12312B(t11, i10)) {
                    C1952s1.m12156M(t10, jM12299U, C1952s1.m12184x(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 14:
                if (m12312B(t11, i10)) {
                    C1952s1.m12157N(t10, jM12299U, C1952s1.m12185y(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 15:
                if (m12312B(t11, i10)) {
                    C1952s1.m12156M(t10, jM12299U, C1952s1.m12184x(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 16:
                if (m12312B(t11, i10)) {
                    C1952s1.m12157N(t10, jM12299U, C1952s1.m12185y(t11, jM12299U));
                    m12338n0(t10, i10);
                    break;
                }
                break;
            case 17:
                m12320N(t10, t11, i10);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f9340n.mo11713d(t10, t11, jM12299U);
                break;
            case 50:
                C1925j1.m11778F(this.f9343q, t10, t11, jM12299U);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (m12317H(t11, iM12323T, i10)) {
                    C1952s1.m12158O(t10, jM12299U, C1952s1.m12144A(t11, jM12299U));
                    m12340o0(t10, iM12323T, i10);
                    break;
                }
                break;
            case 60:
                m12321O(t10, t11, i10);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (m12317H(t11, iM12323T, i10)) {
                    C1952s1.m12158O(t10, jM12299U, C1952s1.m12144A(t11, jM12299U));
                    m12340o0(t10, iM12323T, i10);
                    break;
                }
                break;
            case 68:
                m12321O(t10, t11, i10);
                break;
        }
    }

    /* renamed from: T */
    public final int m12323T(int i10) {
        return this.f9327a[i10];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: a */
    public void mo11667a(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.f9327a.length; i10 += 3) {
            m12322P(t10, t11, i10);
        }
        C1925j1.m11779G(this.f9341o, t10, t11);
        if (this.f9332f) {
            C1925j1.m11777E(this.f9342p, t10, t11);
        }
    }

    /* renamed from: a0 */
    public final <K, V> int m12324a0(T t10, byte[] bArr, int i10, int i11, int i12, long j10, C1908e.b bVar) throws IOException {
        Unsafe unsafe = f9326s;
        Object objM12347t = m12347t(i12);
        Object object = unsafe.getObject(t10, j10);
        if (this.f9343q.mo12055g(object)) {
            Object objMo12053e = this.f9343q.mo12053e(objM12347t);
            this.f9343q.mo12049a(objMo12053e, object);
            unsafe.putObject(t10, j10, objMo12053e);
            object = objMo12053e;
        }
        this.f9343q.mo12051c(objM12347t);
        return m12337m(bArr, i10, i11, null, this.f9343q.mo12052d(object), bVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: b */
    public void mo11668b(T t10) {
        int i10;
        int i11 = this.f9337k;
        while (true) {
            i10 = this.f9338l;
            if (i11 >= i10) {
                break;
            }
            long jM12299U = m12299U(m12344r0(this.f9336j[i11]));
            Object objM12144A = C1952s1.m12144A(t10, jM12299U);
            if (objM12144A != null) {
                C1952s1.m12158O(t10, jM12299U, this.f9343q.mo12050b(objM12144A));
            }
            i11++;
        }
        int length = this.f9336j.length;
        while (i10 < length) {
            this.f9340n.mo11712c(t10, this.f9336j[i10]);
            i10++;
        }
        this.f9341o.mo12069j(t10);
        if (this.f9332f) {
            this.f9342p.mo12126f(t10);
        }
    }

    /* renamed from: b0 */
    public final int m12325b0(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, C1908e.b bVar) throws IOException {
        Unsafe unsafe = f9326s;
        long j11 = this.f9327a[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 == 1) {
                    unsafe.putObject(t10, j10, Double.valueOf(C1908e.m11538d(bArr, i10)));
                    int i18 = i10 + 8;
                    unsafe.putInt(t10, j11, i13);
                    return i18;
                }
                break;
            case 52:
                if (i14 == 5) {
                    unsafe.putObject(t10, j10, Float.valueOf(C1908e.m11546l(bArr, i10)));
                    int i19 = i10 + 4;
                    unsafe.putInt(t10, j11, i13);
                    return i19;
                }
                break;
            case 53:
            case 54:
                if (i14 == 0) {
                    int iM11532L = C1908e.m11532L(bArr, i10, bVar);
                    unsafe.putObject(t10, j10, Long.valueOf(bVar.f9116b));
                    unsafe.putInt(t10, j11, i13);
                    return iM11532L;
                }
                break;
            case 55:
            case 62:
                if (i14 == 0) {
                    int iM11529I = C1908e.m11529I(bArr, i10, bVar);
                    unsafe.putObject(t10, j10, Integer.valueOf(bVar.f9115a));
                    unsafe.putInt(t10, j11, i13);
                    return iM11529I;
                }
                break;
            case 56:
            case 65:
                if (i14 == 1) {
                    unsafe.putObject(t10, j10, Long.valueOf(C1908e.m11544j(bArr, i10)));
                    int i20 = i10 + 8;
                    unsafe.putInt(t10, j11, i13);
                    return i20;
                }
                break;
            case 57:
            case 64:
                if (i14 == 5) {
                    unsafe.putObject(t10, j10, Integer.valueOf(C1908e.m11542h(bArr, i10)));
                    int i21 = i10 + 4;
                    unsafe.putInt(t10, j11, i13);
                    return i21;
                }
                break;
            case 58:
                if (i14 == 0) {
                    int iM11532L2 = C1908e.m11532L(bArr, i10, bVar);
                    unsafe.putObject(t10, j10, Boolean.valueOf(bVar.f9116b != 0));
                    unsafe.putInt(t10, j11, i13);
                    return iM11532L2;
                }
                break;
            case 59:
                if (i14 == 2) {
                    int iM11529I2 = C1908e.m11529I(bArr, i10, bVar);
                    int i22 = bVar.f9115a;
                    if (i22 == 0) {
                        unsafe.putObject(t10, j10, "");
                    } else {
                        if ((i15 & 536870912) != 0 && !C1955t1.m12223n(bArr, iM11529I2, iM11529I2 + i22)) {
                            throw C1903c0.m11504d();
                        }
                        unsafe.putObject(t10, j10, new String(bArr, iM11529I2, i22, C1900b0.f9085a));
                        iM11529I2 += i22;
                    }
                    unsafe.putInt(t10, j11, i13);
                    return iM11529I2;
                }
                break;
            case 60:
                if (i14 == 2) {
                    int iM11550p = C1908e.m11550p(m12349u(i17), bArr, i10, i11, bVar);
                    Object object = unsafe.getInt(t10, j11) == i13 ? unsafe.getObject(t10, j10) : null;
                    if (object == null) {
                        unsafe.putObject(t10, j10, bVar.f9117c);
                    } else {
                        unsafe.putObject(t10, j10, C1900b0.m11493h(object, bVar.f9117c));
                    }
                    unsafe.putInt(t10, j11, i13);
                    return iM11550p;
                }
                break;
            case 61:
                if (i14 == 2) {
                    int iM11536b = C1908e.m11536b(bArr, i10, bVar);
                    unsafe.putObject(t10, j10, bVar.f9117c);
                    unsafe.putInt(t10, j11, i13);
                    return iM11536b;
                }
                break;
            case 63:
                if (i14 == 0) {
                    int iM11529I3 = C1908e.m11529I(bArr, i10, bVar);
                    int i23 = bVar.f9115a;
                    C1900b0.e eVarM12345s = m12345s(i17);
                    if (eVarM12345s == null || eVarM12345s.m11498a(i23)) {
                        unsafe.putObject(t10, j10, Integer.valueOf(i23));
                        unsafe.putInt(t10, j11, i13);
                    } else {
                        m12310v(t10).m12100n(i12, Long.valueOf(i23));
                    }
                    return iM11529I3;
                }
                break;
            case 66:
                if (i14 == 0) {
                    int iM11529I4 = C1908e.m11529I(bArr, i10, bVar);
                    unsafe.putObject(t10, j10, Integer.valueOf(AbstractC1923j.m11719b(bVar.f9115a)));
                    unsafe.putInt(t10, j11, i13);
                    return iM11529I4;
                }
                break;
            case 67:
                if (i14 == 0) {
                    int iM11532L3 = C1908e.m11532L(bArr, i10, bVar);
                    unsafe.putObject(t10, j10, Long.valueOf(AbstractC1923j.m11720c(bVar.f9116b)));
                    unsafe.putInt(t10, j11, i13);
                    return iM11532L3;
                }
                break;
            case 68:
                if (i14 == 3) {
                    int iM11548n = C1908e.m11548n(m12349u(i17), bArr, i10, i11, (i12 & (-8)) | 4, bVar);
                    Object object2 = unsafe.getInt(t10, j11) == i13 ? unsafe.getObject(t10, j10) : null;
                    if (object2 == null) {
                        unsafe.putObject(t10, j10, bVar.f9117c);
                    } else {
                        unsafe.putObject(t10, j10, C1900b0.m11493h(object2, bVar.f9117c));
                    }
                    unsafe.putInt(t10, j11, i13);
                    return iM11548n;
                }
                break;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0078  */
    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo11669c(T r13) {
        /*
            r12 = this;
            r0 = -1
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r12.f9337k
            r5 = 1
            if (r2 >= r4) goto L94
            int[] r4 = r12.f9336j
            r4 = r4[r2]
            int r6 = r12.m12323T(r4)
            int r7 = r12.m12344r0(r4)
            boolean r8 = r12.f9334h
            if (r8 != 0) goto L31
            int[] r8 = r12.f9327a
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r0) goto L32
            sun.misc.Unsafe r0 = com.google.crypto.tink.shaded.protobuf.C1960v0.f9326s
            long r10 = (long) r9
            int r3 = r0.getInt(r13, r10)
            r0 = r9
            goto L32
        L31:
            r5 = r1
        L32:
            boolean r8 = m12293I(r7)
            if (r8 == 0) goto L3f
            boolean r8 = r12.m12313C(r13, r4, r3, r5)
            if (r8 != 0) goto L3f
            return r1
        L3f:
            int r8 = m12308q0(r7)
            r9 = 9
            if (r8 == r9) goto L7f
            r9 = 17
            if (r8 == r9) goto L7f
            r5 = 27
            if (r8 == r5) goto L78
            r5 = 60
            if (r8 == r5) goto L67
            r5 = 68
            if (r8 == r5) goto L67
            r5 = 49
            if (r8 == r5) goto L78
            r5 = 50
            if (r8 == r5) goto L60
            goto L90
        L60:
            boolean r4 = r12.m12315F(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L67:
            boolean r5 = r12.m12317H(r13, r6, r4)
            if (r5 == 0) goto L90
            com.google.crypto.tink.shaded.protobuf.h1 r4 = r12.m12349u(r4)
            boolean r4 = m12292D(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L78:
            boolean r4 = r12.m12314E(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L7f:
            boolean r5 = r12.m12313C(r13, r4, r3, r5)
            if (r5 == 0) goto L90
            com.google.crypto.tink.shaded.protobuf.h1 r4 = r12.m12349u(r4)
            boolean r4 = m12292D(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L90:
            int r2 = r2 + 1
            goto L4
        L94:
            boolean r0 = r12.f9332f
            if (r0 == 0) goto La5
            com.google.crypto.tink.shaded.protobuf.r<?> r12 = r12.f9342p
            com.google.crypto.tink.shaded.protobuf.v r12 = r12.mo12123c(r13)
            boolean r12 = r12.m12278o()
            if (r12 != 0) goto La5
            return r1
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.mo11669c(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:341:0x0351, code lost:
    
        if (r0 != r11) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0353, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r9 = r35;
        r1 = r17;
        r7 = r19;
        r2 = r20;
        r6 = r22;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x036d, code lost:
    
        r2 = r0;
        r8 = r25;
        r0 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x03a1, code lost:
    
        if (r0 != r15) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x03c4, code lost:
    
        if (r0 != r15) goto L342;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:247:0x008d. Please report as an issue. */
    /* renamed from: c0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m12326c0(T r30, byte[] r31, int r32, int r33, int r34, com.google.crypto.tink.shaded.protobuf.C1908e.b r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12326c0(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: d */
    public void mo11670d(T t10, byte[] bArr, int i10, int i11, C1908e.b bVar) throws IOException {
        if (this.f9334h) {
            m12327d0(t10, bArr, i10, i11, bVar);
        } else {
            m12326c0(t10, bArr, i10, i11, 0, bVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:235:0x01dd, code lost:
    
        if (r0 != r15) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x01f3, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x021f, code lost:
    
        if (r0 != r15) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x023e, code lost:
    
        if (r0 != r15) goto L236;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:163:0x005d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* renamed from: d0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m12327d0(T r28, byte[] r29, int r30, int r31, com.google.crypto.tink.shaded.protobuf.C1908e.b r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12327d0(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: e */
    public void mo11671e(T t10, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        if (interfaceC1961v1.mo12006k() == InterfaceC1961v1.a.DESCENDING) {
            m12350u0(t10, interfaceC1961v1);
        } else if (this.f9334h) {
            m12348t0(t10, interfaceC1961v1);
        } else {
            m12346s0(t10, interfaceC1961v1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e0 */
    public final int m12328e0(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, C1908e.b bVar) throws IOException {
        int iM11530J;
        Unsafe unsafe = f9326s;
        C1900b0.i iVarMo11479v = (C1900b0.i) unsafe.getObject(t10, j11);
        if (!iVarMo11479v.mo11499b0()) {
            int size = iVarMo11479v.size();
            iVarMo11479v = iVarMo11479v.mo11479v(size == 0 ? 10 : size * 2);
            unsafe.putObject(t10, j11, iVarMo11479v);
        }
        switch (i16) {
            case 18:
            case 35:
                if (i14 == 2) {
                    return C1908e.m11553s(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 1) {
                    return C1908e.m11539e(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 19:
            case 36:
                if (i14 == 2) {
                    return C1908e.m11556v(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 5) {
                    return C1908e.m11547m(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i14 == 2) {
                    return C1908e.m11560z(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 0) {
                    return C1908e.m11533M(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i14 == 2) {
                    return C1908e.m11559y(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 0) {
                    return C1908e.m11530J(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i14 == 2) {
                    return C1908e.m11555u(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 1) {
                    return C1908e.m11545k(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i14 == 2) {
                    return C1908e.m11554t(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 5) {
                    return C1908e.m11543i(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 25:
            case 42:
                if (i14 == 2) {
                    return C1908e.m11552r(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 0) {
                    return C1908e.m11535a(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 26:
                if (i14 == 2) {
                    return (j10 & 536870912) == 0 ? C1908e.m11524D(i12, bArr, i10, i11, iVarMo11479v, bVar) : C1908e.m11525E(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 27:
                if (i14 == 2) {
                    return C1908e.m11551q(m12349u(i15), i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 28:
                if (i14 == 2) {
                    return C1908e.m11537c(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 30:
            case 44:
                if (i14 == 2) {
                    iM11530J = C1908e.m11559y(bArr, i10, iVarMo11479v, bVar);
                } else if (i14 == 0) {
                    iM11530J = C1908e.m11530J(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                AbstractC1968z abstractC1968z = (AbstractC1968z) t10;
                C1943p1 c1943p1 = abstractC1968z.unknownFields;
                if (c1943p1 == C1943p1.m12088e()) {
                    c1943p1 = null;
                }
                C1943p1 c1943p12 = (C1943p1) C1925j1.m11773A(i13, iVarMo11479v, m12345s(i15), c1943p1, this.f9341o);
                if (c1943p12 != null) {
                    abstractC1968z.unknownFields = c1943p12;
                }
                return iM11530J;
            case 33:
            case 47:
                if (i14 == 2) {
                    return C1908e.m11557w(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 0) {
                    return C1908e.m11521A(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 34:
            case 48:
                if (i14 == 2) {
                    return C1908e.m11558x(bArr, i10, iVarMo11479v, bVar);
                }
                if (i14 == 0) {
                    return C1908e.m11522B(i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
            case 49:
                if (i14 == 3) {
                    return C1908e.m11549o(m12349u(i15), i12, bArr, i10, i11, iVarMo11479v, bVar);
                }
                break;
        }
        return i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: f */
    public void mo11672f(T t10, InterfaceC1916g1 interfaceC1916g1, C1944q c1944q) throws IOException {
        c1944q.getClass();
        m12318L(this.f9341o, this.f9342p, t10, interfaceC1916g1, c1944q);
    }

    /* renamed from: f0 */
    public final int m12329f0(int i10) {
        if (i10 < this.f9329c || i10 > this.f9330d) {
            return -1;
        }
        return m12342p0(i10, 0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: g */
    public boolean mo11673g(T t10, T t11) {
        int length = this.f9327a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!m12339o(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.f9341o.mo12066g(t10).equals(this.f9341o.mo12066g(t11))) {
            return false;
        }
        if (this.f9332f) {
            return this.f9342p.mo12123c(t10).equals(this.f9342p.mo12123c(t11));
        }
        return true;
    }

    /* renamed from: g0 */
    public final int m12330g0(int i10, int i11) {
        if (i10 < this.f9329c || i10 > this.f9330d) {
            return -1;
        }
        return m12342p0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: h */
    public int mo11674h(T t10) {
        return this.f9334h ? m12354x(t10) : m12352w(t10);
    }

    /* renamed from: h0 */
    public final int m12331h0(int i10) {
        return this.f9327a[i10 + 2];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: i */
    public T mo11675i() {
        return (T) this.f9339m.mo12375a(this.f9331e);
    }

    /* renamed from: i0 */
    public final <E> void m12332i0(Object obj, long j10, InterfaceC1916g1 interfaceC1916g1, InterfaceC1919h1<E> interfaceC1919h1, C1944q c1944q) throws IOException {
        interfaceC1916g1.mo11582M(this.f9340n.mo11714e(obj, j10), interfaceC1919h1, c1944q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: j */
    public int mo11676j(T t10) {
        int i10;
        int iM11491f;
        int length = this.f9327a.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iM12344r0 = m12344r0(i12);
            int iM12323T = m12323T(i12);
            long jM12299U = m12299U(iM12344r0);
            int iHashCode = 37;
            switch (m12308q0(iM12344r0)) {
                case 0:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11491f(Double.doubleToLongBits(C1952s1.m12182v(t10, jM12299U)));
                    i11 = i10 + iM11491f;
                    break;
                case 1:
                    i10 = i11 * 53;
                    iM11491f = Float.floatToIntBits(C1952s1.m12183w(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 2:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11491f(C1952s1.m12185y(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 3:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11491f(C1952s1.m12185y(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 4:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12184x(t10, jM12299U);
                    i11 = i10 + iM11491f;
                    break;
                case 5:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11491f(C1952s1.m12185y(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 6:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12184x(t10, jM12299U);
                    i11 = i10 + iM11491f;
                    break;
                case 7:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11488c(C1952s1.m12176p(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 8:
                    i10 = i11 * 53;
                    iM11491f = ((String) C1952s1.m12144A(t10, jM12299U)).hashCode();
                    i11 = i10 + iM11491f;
                    break;
                case 9:
                    Object objM12144A = C1952s1.m12144A(t10, jM12299U);
                    if (objM12144A != null) {
                        iHashCode = objM12144A.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12144A(t10, jM12299U).hashCode();
                    i11 = i10 + iM11491f;
                    break;
                case 11:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12184x(t10, jM12299U);
                    i11 = i10 + iM11491f;
                    break;
                case 12:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12184x(t10, jM12299U);
                    i11 = i10 + iM11491f;
                    break;
                case 13:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12184x(t10, jM12299U);
                    i11 = i10 + iM11491f;
                    break;
                case 14:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11491f(C1952s1.m12185y(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 15:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12184x(t10, jM12299U);
                    i11 = i10 + iM11491f;
                    break;
                case 16:
                    i10 = i11 * 53;
                    iM11491f = C1900b0.m11491f(C1952s1.m12185y(t10, jM12299U));
                    i11 = i10 + iM11491f;
                    break;
                case 17:
                    Object objM12144A2 = C1952s1.m12144A(t10, jM12299U);
                    if (objM12144A2 != null) {
                        iHashCode = objM12144A2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12144A(t10, jM12299U).hashCode();
                    i11 = i10 + iM11491f;
                    break;
                case 50:
                    i10 = i11 * 53;
                    iM11491f = C1952s1.m12144A(t10, jM12299U).hashCode();
                    i11 = i10 + iM11491f;
                    break;
                case 51:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11491f(Double.doubleToLongBits(m12301W(t10, jM12299U)));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = Float.floatToIntBits(m12302X(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11491f(m12304Z(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11491f(m12304Z(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = m12303Y(t10, jM12299U);
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11491f(m12304Z(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = m12303Y(t10, jM12299U);
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11488c(m12300V(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = ((String) C1952s1.m12144A(t10, jM12299U)).hashCode();
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1952s1.m12144A(t10, jM12299U).hashCode();
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1952s1.m12144A(t10, jM12299U).hashCode();
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = m12303Y(t10, jM12299U);
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = m12303Y(t10, jM12299U);
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = m12303Y(t10, jM12299U);
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11491f(m12304Z(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = m12303Y(t10, jM12299U);
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1900b0.m11491f(m12304Z(t10, jM12299U));
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (m12317H(t10, iM12323T, i12)) {
                        i10 = i11 * 53;
                        iM11491f = C1952s1.m12144A(t10, jM12299U).hashCode();
                        i11 = i10 + iM11491f;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i11 * 53) + this.f9341o.mo12066g(t10).hashCode();
        return this.f9332f ? (iHashCode2 * 53) + this.f9342p.mo12123c(t10).hashCode() : iHashCode2;
    }

    /* renamed from: j0 */
    public final <E> void m12333j0(Object obj, int i10, InterfaceC1916g1 interfaceC1916g1, InterfaceC1919h1<E> interfaceC1919h1, C1944q c1944q) throws IOException {
        interfaceC1916g1.mo11609h(this.f9340n.mo11714e(obj, m12299U(i10)), interfaceC1919h1, c1944q);
    }

    /* renamed from: k */
    public final boolean m12334k(T t10, T t11, int i10) {
        return m12312B(t10, i10) == m12312B(t11, i10);
    }

    /* renamed from: k0 */
    public final void m12335k0(Object obj, int i10, InterfaceC1916g1 interfaceC1916g1) throws IOException {
        if (m12291A(i10)) {
            C1952s1.m12158O(obj, m12299U(i10), interfaceC1916g1.mo11584O());
        } else if (this.f9333g) {
            C1952s1.m12158O(obj, m12299U(i10), interfaceC1916g1.mo11633z());
        } else {
            C1952s1.m12158O(obj, m12299U(i10), interfaceC1916g1.mo11574E());
        }
    }

    /* renamed from: l0 */
    public final void m12336l0(Object obj, int i10, InterfaceC1916g1 interfaceC1916g1) throws IOException {
        if (m12291A(i10)) {
            interfaceC1916g1.mo11573D(this.f9340n.mo11714e(obj, m12299U(i10)));
        } else {
            interfaceC1916g1.mo11572C(this.f9340n.mo11714e(obj, m12299U(i10)));
        }
    }

    /* renamed from: m */
    public final <K, V> int m12337m(byte[] bArr, int i10, int i11, C1930l0.a<K, V> aVar, Map<K, V> map, C1908e.b bVar) throws IOException {
        int iM11529I = C1908e.m11529I(bArr, i10, bVar);
        int i12 = bVar.f9115a;
        if (i12 < 0 || i12 > i11 - iM11529I) {
            throw C1903c0.m11510l();
        }
        throw null;
    }

    /* renamed from: n0 */
    public final void m12338n0(T t10, int i10) {
        if (this.f9334h) {
            return;
        }
        int iM12331h0 = m12331h0(i10);
        long j10 = iM12331h0 & 1048575;
        C1952s1.m12156M(t10, j10, C1952s1.m12184x(t10, j10) | (1 << (iM12331h0 >>> 20)));
    }

    /* renamed from: o */
    public final boolean m12339o(T t10, T t11, int i10) {
        int iM12344r0 = m12344r0(i10);
        long jM12299U = m12299U(iM12344r0);
        switch (m12308q0(iM12344r0)) {
            case 0:
                if (m12334k(t10, t11, i10) && Double.doubleToLongBits(C1952s1.m12182v(t10, jM12299U)) == Double.doubleToLongBits(C1952s1.m12182v(t11, jM12299U))) {
                    break;
                }
                break;
            case 1:
                if (m12334k(t10, t11, i10) && Float.floatToIntBits(C1952s1.m12183w(t10, jM12299U)) == Float.floatToIntBits(C1952s1.m12183w(t11, jM12299U))) {
                    break;
                }
                break;
            case 2:
                if (m12334k(t10, t11, i10) && C1952s1.m12185y(t10, jM12299U) == C1952s1.m12185y(t11, jM12299U)) {
                    break;
                }
                break;
            case 3:
                if (m12334k(t10, t11, i10) && C1952s1.m12185y(t10, jM12299U) == C1952s1.m12185y(t11, jM12299U)) {
                    break;
                }
                break;
            case 4:
                if (m12334k(t10, t11, i10) && C1952s1.m12184x(t10, jM12299U) == C1952s1.m12184x(t11, jM12299U)) {
                    break;
                }
                break;
            case 5:
                if (m12334k(t10, t11, i10) && C1952s1.m12185y(t10, jM12299U) == C1952s1.m12185y(t11, jM12299U)) {
                    break;
                }
                break;
            case 6:
                if (m12334k(t10, t11, i10) && C1952s1.m12184x(t10, jM12299U) == C1952s1.m12184x(t11, jM12299U)) {
                    break;
                }
                break;
            case 7:
                if (m12334k(t10, t11, i10) && C1952s1.m12176p(t10, jM12299U) == C1952s1.m12176p(t11, jM12299U)) {
                    break;
                }
                break;
            case 8:
                if (m12334k(t10, t11, i10) && C1925j1.m11783K(C1952s1.m12144A(t10, jM12299U), C1952s1.m12144A(t11, jM12299U))) {
                    break;
                }
                break;
            case 9:
                if (m12334k(t10, t11, i10) && C1925j1.m11783K(C1952s1.m12144A(t10, jM12299U), C1952s1.m12144A(t11, jM12299U))) {
                    break;
                }
                break;
            case 10:
                if (m12334k(t10, t11, i10) && C1925j1.m11783K(C1952s1.m12144A(t10, jM12299U), C1952s1.m12144A(t11, jM12299U))) {
                    break;
                }
                break;
            case 11:
                if (m12334k(t10, t11, i10) && C1952s1.m12184x(t10, jM12299U) == C1952s1.m12184x(t11, jM12299U)) {
                    break;
                }
                break;
            case 12:
                if (m12334k(t10, t11, i10) && C1952s1.m12184x(t10, jM12299U) == C1952s1.m12184x(t11, jM12299U)) {
                    break;
                }
                break;
            case 13:
                if (m12334k(t10, t11, i10) && C1952s1.m12184x(t10, jM12299U) == C1952s1.m12184x(t11, jM12299U)) {
                    break;
                }
                break;
            case 14:
                if (m12334k(t10, t11, i10) && C1952s1.m12185y(t10, jM12299U) == C1952s1.m12185y(t11, jM12299U)) {
                    break;
                }
                break;
            case 15:
                if (m12334k(t10, t11, i10) && C1952s1.m12184x(t10, jM12299U) == C1952s1.m12184x(t11, jM12299U)) {
                    break;
                }
                break;
            case 16:
                if (m12334k(t10, t11, i10) && C1952s1.m12185y(t10, jM12299U) == C1952s1.m12185y(t11, jM12299U)) {
                    break;
                }
                break;
            case 17:
                if (m12334k(t10, t11, i10) && C1925j1.m11783K(C1952s1.m12144A(t10, jM12299U), C1952s1.m12144A(t11, jM12299U))) {
                    break;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (m12316G(t10, t11, i10) && C1925j1.m11783K(C1952s1.m12144A(t10, jM12299U), C1952s1.m12144A(t11, jM12299U))) {
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: o0 */
    public final void m12340o0(T t10, int i10, int i11) {
        C1952s1.m12156M(t10, m12331h0(i11) & 1048575, i10);
    }

    /* renamed from: p */
    public final <UT, UB> UB m12341p(Object obj, int i10, UB ub2, AbstractC1940o1<UT, UB> abstractC1940o1) {
        C1900b0.e eVarM12345s;
        int iM12323T = m12323T(i10);
        Object objM12144A = C1952s1.m12144A(obj, m12299U(m12344r0(i10)));
        return (objM12144A == null || (eVarM12345s = m12345s(i10)) == null) ? ub2 : (UB) m12343q(i10, iM12323T, this.f9343q.mo12052d(objM12144A), eVarM12345s, ub2, abstractC1940o1);
    }

    /* renamed from: p0 */
    public final int m12342p0(int i10, int i11) {
        int length = (this.f9327a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int iM12323T = m12323T(i13);
            if (i10 == iM12323T) {
                return i13;
            }
            if (i10 < iM12323T) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* renamed from: q */
    public final <K, V, UT, UB> UB m12343q(int i10, int i11, Map<K, V> map, C1900b0.e eVar, UB ub2, AbstractC1940o1<UT, UB> abstractC1940o1) {
        this.f9343q.mo12051c(m12347t(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.m11498a(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = abstractC1940o1.mo12073n();
                }
                AbstractC1920i.h hVarM11685n = AbstractC1920i.m11685n(C1930l0.m11972b(null, next.getKey(), next.getValue()));
                try {
                    C1930l0.m11973d(hVarM11685n.m11708b(), null, next.getKey(), next.getValue());
                    abstractC1940o1.mo12063d(ub2, i11, hVarM11685n.m11707a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    /* renamed from: r0 */
    public final int m12344r0(int i10) {
        return this.f9327a[i10 + 1];
    }

    /* renamed from: s */
    public final C1900b0.e m12345s(int i10) {
        return (C1900b0.e) this.f9328b[((i10 / 3) * 2) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:252:0x0021  */
    /* renamed from: s0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12346s0(T r18, com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1 r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12346s0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.v1):void");
    }

    /* renamed from: t */
    public final Object m12347t(int i10) {
        return this.f9328b[(i10 / 3) * 2];
    }

    /* JADX WARN: Removed duplicated region for block: B:297:0x001c  */
    /* renamed from: t0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12348t0(T r13, com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1 r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12348t0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.v1):void");
    }

    /* renamed from: u */
    public final InterfaceC1919h1 m12349u(int i10) {
        int i11 = (i10 / 3) * 2;
        InterfaceC1919h1 interfaceC1919h1 = (InterfaceC1919h1) this.f9328b[i11];
        if (interfaceC1919h1 != null) {
            return interfaceC1919h1;
        }
        InterfaceC1919h1<T> interfaceC1919h1M11519d = C1907d1.m11516a().m11519d((Class) this.f9328b[i11 + 1]);
        this.f9328b[i11] = interfaceC1919h1M11519d;
        return interfaceC1919h1M11519d;
    }

    /* JADX WARN: Removed duplicated region for block: B:296:0x0021  */
    /* renamed from: u0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12350u0(T r11, com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1 r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1960v0.m12350u0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.v1):void");
    }

    /* renamed from: v0 */
    public final <K, V> void m12351v0(InterfaceC1961v1 interfaceC1961v1, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            this.f9343q.mo12051c(m12347t(i11));
            interfaceC1961v1.mo12004i(i10, null, this.f9343q.mo12056h(obj));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: w */
    public final int m12352w(T t10) {
        int i10;
        int i11;
        int iM11908i;
        int iM11901d;
        int iM11883K;
        boolean z10;
        int iM11809f;
        int iM11812i;
        int iM11893U;
        int iM11895W;
        Unsafe unsafe = f9326s;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < this.f9327a.length) {
            int iM12344r0 = m12344r0(i13);
            int iM12323T = m12323T(i13);
            int iM12308q0 = m12308q0(iM12344r0);
            if (iM12308q0 <= 17) {
                i10 = this.f9327a[i13 + 2];
                int i16 = 1048575 & i10;
                int i17 = 1 << (i10 >>> 20);
                if (i16 != i12) {
                    i15 = unsafe.getInt(t10, i16);
                    i12 = i16;
                }
                i11 = i17;
            } else {
                i10 = (!this.f9335i || iM12308q0 < EnumC1962w.f9361O.m12357b() || iM12308q0 > EnumC1962w.f9374b0.m12357b()) ? 0 : this.f9327a[i13 + 2] & 1048575;
                i11 = 0;
            }
            long jM12299U = m12299U(iM12344r0);
            int i18 = i12;
            switch (iM12308q0) {
                case 0:
                    if ((i15 & i11) == 0) {
                        break;
                    } else {
                        iM11908i = AbstractC1929l.m11908i(iM12323T, 0.0d);
                        i14 += iM11908i;
                        break;
                    }
                case 1:
                    if ((i15 & i11) == 0) {
                        break;
                    } else {
                        iM11908i = AbstractC1929l.m11916q(iM12323T, 0.0f);
                        i14 += iM11908i;
                        break;
                    }
                case 2:
                    if ((i15 & i11) == 0) {
                        break;
                    } else {
                        iM11908i = AbstractC1929l.m11923x(iM12323T, unsafe.getLong(t10, jM12299U));
                        i14 += iM11908i;
                        break;
                    }
                case 3:
                    if ((i15 & i11) == 0) {
                        break;
                    } else {
                        iM11908i = AbstractC1929l.m11896X(iM12323T, unsafe.getLong(t10, jM12299U));
                        i14 += iM11908i;
                        break;
                    }
                case 4:
                    if ((i15 & i11) == 0) {
                        break;
                    } else {
                        iM11908i = AbstractC1929l.m11921v(iM12323T, unsafe.getInt(t10, jM12299U));
                        i14 += iM11908i;
                        break;
                    }
                case 5:
                    if ((i15 & i11) == 0) {
                        break;
                    } else {
                        iM11908i = AbstractC1929l.m11914o(iM12323T, 0L);
                        i14 += iM11908i;
                        break;
                    }
                case 6:
                    if ((i15 & i11) != 0) {
                        iM11908i = AbstractC1929l.m11912m(iM12323T, 0);
                        i14 += iM11908i;
                        break;
                    }
                    break;
                case 7:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11901d(iM12323T, true);
                        i14 += iM11901d;
                    }
                    break;
                case 8:
                    if ((i15 & i11) != 0) {
                        Object object = unsafe.getObject(t10, jM12299U);
                        iM11901d = object instanceof AbstractC1920i ? AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) object) : AbstractC1929l.m11891S(iM12323T, (String) object);
                        i14 += iM11901d;
                    }
                    break;
                case 9:
                    if ((i15 & i11) != 0) {
                        iM11901d = C1925j1.m11818o(iM12323T, unsafe.getObject(t10, jM12299U), m12349u(i13));
                        i14 += iM11901d;
                    }
                    break;
                case 10:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) unsafe.getObject(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 11:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11894V(iM12323T, unsafe.getInt(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 12:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11910k(iM12323T, unsafe.getInt(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 13:
                    if ((i15 & i11) != 0) {
                        iM11883K = AbstractC1929l.m11883K(iM12323T, 0);
                        i14 += iM11883K;
                    }
                    break;
                case 14:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11885M(iM12323T, 0L);
                        i14 += iM11901d;
                    }
                    break;
                case 15:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11887O(iM12323T, unsafe.getInt(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 16:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11889Q(iM12323T, unsafe.getLong(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 17:
                    if ((i15 & i11) != 0) {
                        iM11901d = AbstractC1929l.m11918s(iM12323T, (InterfaceC1951s0) unsafe.getObject(t10, jM12299U), m12349u(i13));
                        i14 += iM11901d;
                    }
                    break;
                case 18:
                    iM11901d = C1925j1.m11811h(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11901d;
                    break;
                case 19:
                    z10 = false;
                    iM11809f = C1925j1.m11809f(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 20:
                    z10 = false;
                    iM11809f = C1925j1.m11816m(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 21:
                    z10 = false;
                    iM11809f = C1925j1.m11827x(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 22:
                    z10 = false;
                    iM11809f = C1925j1.m11814k(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 23:
                    z10 = false;
                    iM11809f = C1925j1.m11811h(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 24:
                    z10 = false;
                    iM11809f = C1925j1.m11809f(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 25:
                    z10 = false;
                    iM11809f = C1925j1.m11799a(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 26:
                    iM11901d = C1925j1.m11824u(iM12323T, (List) unsafe.getObject(t10, jM12299U));
                    i14 += iM11901d;
                    break;
                case 27:
                    iM11901d = C1925j1.m11819p(iM12323T, (List) unsafe.getObject(t10, jM12299U), m12349u(i13));
                    i14 += iM11901d;
                    break;
                case 28:
                    iM11901d = C1925j1.m11803c(iM12323T, (List) unsafe.getObject(t10, jM12299U));
                    i14 += iM11901d;
                    break;
                case 29:
                    iM11901d = C1925j1.m11825v(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11901d;
                    break;
                case 30:
                    z10 = false;
                    iM11809f = C1925j1.m11805d(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 31:
                    z10 = false;
                    iM11809f = C1925j1.m11809f(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 32:
                    z10 = false;
                    iM11809f = C1925j1.m11811h(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 33:
                    z10 = false;
                    iM11809f = C1925j1.m11820q(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 34:
                    z10 = false;
                    iM11809f = C1925j1.m11822s(iM12323T, (List) unsafe.getObject(t10, jM12299U), false);
                    i14 += iM11809f;
                    break;
                case 35:
                    iM11812i = C1925j1.m11812i((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 36:
                    iM11812i = C1925j1.m11810g((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 37:
                    iM11812i = C1925j1.m11817n((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 38:
                    iM11812i = C1925j1.m11828y((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 39:
                    iM11812i = C1925j1.m11815l((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 40:
                    iM11812i = C1925j1.m11812i((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 41:
                    iM11812i = C1925j1.m11810g((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 42:
                    iM11812i = C1925j1.m11801b((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 43:
                    iM11812i = C1925j1.m11826w((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 44:
                    iM11812i = C1925j1.m11807e((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 45:
                    iM11812i = C1925j1.m11810g((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 46:
                    iM11812i = C1925j1.m11812i((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 47:
                    iM11812i = C1925j1.m11821r((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 48:
                    iM11812i = C1925j1.m11823t((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i > 0) {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i10, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11883K = iM11893U + iM11895W + iM11812i;
                        i14 += iM11883K;
                    }
                    break;
                case 49:
                    iM11901d = C1925j1.m11813j(iM12323T, (List) unsafe.getObject(t10, jM12299U), m12349u(i13));
                    i14 += iM11901d;
                    break;
                case 50:
                    iM11901d = this.f9343q.mo12054f(iM12323T, unsafe.getObject(t10, jM12299U), m12347t(i13));
                    i14 += iM11901d;
                    break;
                case 51:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11908i(iM12323T, 0.0d);
                        i14 += iM11901d;
                    }
                    break;
                case 52:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11916q(iM12323T, 0.0f);
                        i14 += iM11901d;
                    }
                    break;
                case 53:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11923x(iM12323T, m12304Z(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 54:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11896X(iM12323T, m12304Z(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 55:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11921v(iM12323T, m12303Y(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 56:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11914o(iM12323T, 0L);
                        i14 += iM11901d;
                    }
                    break;
                case 57:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11883K = AbstractC1929l.m11912m(iM12323T, 0);
                        i14 += iM11883K;
                    }
                    break;
                case 58:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11901d(iM12323T, true);
                        i14 += iM11901d;
                    }
                    break;
                case 59:
                    if (m12317H(t10, iM12323T, i13)) {
                        Object object2 = unsafe.getObject(t10, jM12299U);
                        iM11901d = object2 instanceof AbstractC1920i ? AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) object2) : AbstractC1929l.m11891S(iM12323T, (String) object2);
                        i14 += iM11901d;
                    }
                    break;
                case 60:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = C1925j1.m11818o(iM12323T, unsafe.getObject(t10, jM12299U), m12349u(i13));
                        i14 += iM11901d;
                    }
                    break;
                case 61:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) unsafe.getObject(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 62:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11894V(iM12323T, m12303Y(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 63:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11910k(iM12323T, m12303Y(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 64:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11883K = AbstractC1929l.m11883K(iM12323T, 0);
                        i14 += iM11883K;
                    }
                    break;
                case 65:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11885M(iM12323T, 0L);
                        i14 += iM11901d;
                    }
                    break;
                case 66:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11887O(iM12323T, m12303Y(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 67:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11889Q(iM12323T, m12304Z(t10, jM12299U));
                        i14 += iM11901d;
                    }
                    break;
                case 68:
                    if (m12317H(t10, iM12323T, i13)) {
                        iM11901d = AbstractC1929l.m11918s(iM12323T, (InterfaceC1951s0) unsafe.getObject(t10, jM12299U), m12349u(i13));
                        i14 += iM11901d;
                    }
                    break;
            }
            i13 += 3;
            i12 = i18;
        }
        int iM12356y = i14 + m12356y(this.f9341o, t10);
        return this.f9332f ? iM12356y + this.f9342p.mo12123c(t10).m12275l() : iM12356y;
    }

    /* renamed from: w0 */
    public final void m12353w0(int i10, Object obj, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        if (obj instanceof String) {
            interfaceC1961v1.mo12008m(i10, (String) obj);
        } else {
            interfaceC1961v1.mo11981C(i10, (AbstractC1920i) obj);
        }
    }

    /* renamed from: x */
    public final int m12354x(T t10) {
        int iM11908i;
        int iM11812i;
        int iM11893U;
        int iM11895W;
        Unsafe unsafe = f9326s;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f9327a.length; i11 += 3) {
            int iM12344r0 = m12344r0(i11);
            int iM12308q0 = m12308q0(iM12344r0);
            int iM12323T = m12323T(i11);
            long jM12299U = m12299U(iM12344r0);
            int i12 = (iM12308q0 < EnumC1962w.f9361O.m12357b() || iM12308q0 > EnumC1962w.f9374b0.m12357b()) ? 0 : this.f9327a[i11 + 2] & 1048575;
            switch (iM12308q0) {
                case 0:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11908i(iM12323T, 0.0d);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11916q(iM12323T, 0.0f);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11923x(iM12323T, C1952s1.m12185y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11896X(iM12323T, C1952s1.m12185y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11921v(iM12323T, C1952s1.m12184x(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11914o(iM12323T, 0L);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11912m(iM12323T, 0);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11901d(iM12323T, true);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (m12312B(t10, i11)) {
                        Object objM12144A = C1952s1.m12144A(t10, jM12299U);
                        iM11908i = objM12144A instanceof AbstractC1920i ? AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) objM12144A) : AbstractC1929l.m11891S(iM12323T, (String) objM12144A);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (m12312B(t10, i11)) {
                        iM11908i = C1925j1.m11818o(iM12323T, C1952s1.m12144A(t10, jM12299U), m12349u(i11));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) C1952s1.m12144A(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11894V(iM12323T, C1952s1.m12184x(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11910k(iM12323T, C1952s1.m12184x(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11883K(iM12323T, 0);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11885M(iM12323T, 0L);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11887O(iM12323T, C1952s1.m12184x(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11889Q(iM12323T, C1952s1.m12185y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (m12312B(t10, i11)) {
                        iM11908i = AbstractC1929l.m11918s(iM12323T, (InterfaceC1951s0) C1952s1.m12144A(t10, jM12299U), m12349u(i11));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iM11908i = C1925j1.m11811h(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 19:
                    iM11908i = C1925j1.m11809f(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 20:
                    iM11908i = C1925j1.m11816m(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 21:
                    iM11908i = C1925j1.m11827x(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 22:
                    iM11908i = C1925j1.m11814k(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 23:
                    iM11908i = C1925j1.m11811h(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 24:
                    iM11908i = C1925j1.m11809f(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 25:
                    iM11908i = C1925j1.m11799a(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 26:
                    iM11908i = C1925j1.m11824u(iM12323T, m12294J(t10, jM12299U));
                    i10 += iM11908i;
                    break;
                case 27:
                    iM11908i = C1925j1.m11819p(iM12323T, m12294J(t10, jM12299U), m12349u(i11));
                    i10 += iM11908i;
                    break;
                case 28:
                    iM11908i = C1925j1.m11803c(iM12323T, m12294J(t10, jM12299U));
                    i10 += iM11908i;
                    break;
                case 29:
                    iM11908i = C1925j1.m11825v(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 30:
                    iM11908i = C1925j1.m11805d(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 31:
                    iM11908i = C1925j1.m11809f(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 32:
                    iM11908i = C1925j1.m11811h(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 33:
                    iM11908i = C1925j1.m11820q(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 34:
                    iM11908i = C1925j1.m11822s(iM12323T, m12294J(t10, jM12299U), false);
                    i10 += iM11908i;
                    break;
                case 35:
                    iM11812i = C1925j1.m11812i((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 36:
                    iM11812i = C1925j1.m11810g((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 37:
                    iM11812i = C1925j1.m11817n((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 38:
                    iM11812i = C1925j1.m11828y((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 39:
                    iM11812i = C1925j1.m11815l((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 40:
                    iM11812i = C1925j1.m11812i((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 41:
                    iM11812i = C1925j1.m11810g((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 42:
                    iM11812i = C1925j1.m11801b((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 43:
                    iM11812i = C1925j1.m11826w((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 44:
                    iM11812i = C1925j1.m11807e((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 45:
                    iM11812i = C1925j1.m11810g((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 46:
                    iM11812i = C1925j1.m11812i((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 47:
                    iM11812i = C1925j1.m11821r((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 48:
                    iM11812i = C1925j1.m11823t((List) unsafe.getObject(t10, jM12299U));
                    if (iM11812i <= 0) {
                        break;
                    } else {
                        if (this.f9335i) {
                            unsafe.putInt(t10, i12, iM11812i);
                        }
                        iM11893U = AbstractC1929l.m11893U(iM12323T);
                        iM11895W = AbstractC1929l.m11895W(iM11812i);
                        iM11908i = iM11893U + iM11895W + iM11812i;
                        i10 += iM11908i;
                        break;
                    }
                case 49:
                    iM11908i = C1925j1.m11813j(iM12323T, m12294J(t10, jM12299U), m12349u(i11));
                    i10 += iM11908i;
                    break;
                case 50:
                    iM11908i = this.f9343q.mo12054f(iM12323T, C1952s1.m12144A(t10, jM12299U), m12347t(i11));
                    i10 += iM11908i;
                    break;
                case 51:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11908i(iM12323T, 0.0d);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11916q(iM12323T, 0.0f);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11923x(iM12323T, m12304Z(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11896X(iM12323T, m12304Z(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11921v(iM12323T, m12303Y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11914o(iM12323T, 0L);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11912m(iM12323T, 0);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11901d(iM12323T, true);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (m12317H(t10, iM12323T, i11)) {
                        Object objM12144A2 = C1952s1.m12144A(t10, jM12299U);
                        iM11908i = objM12144A2 instanceof AbstractC1920i ? AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) objM12144A2) : AbstractC1929l.m11891S(iM12323T, (String) objM12144A2);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = C1925j1.m11818o(iM12323T, C1952s1.m12144A(t10, jM12299U), m12349u(i11));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11906g(iM12323T, (AbstractC1920i) C1952s1.m12144A(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11894V(iM12323T, m12303Y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11910k(iM12323T, m12303Y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11883K(iM12323T, 0);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11885M(iM12323T, 0L);
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11887O(iM12323T, m12303Y(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11889Q(iM12323T, m12304Z(t10, jM12299U));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (m12317H(t10, iM12323T, i11)) {
                        iM11908i = AbstractC1929l.m11918s(iM12323T, (InterfaceC1951s0) C1952s1.m12144A(t10, jM12299U), m12349u(i11));
                        i10 += iM11908i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i10 + m12356y(this.f9341o, t10);
    }

    /* renamed from: x0 */
    public final <UT, UB> void m12355x0(AbstractC1940o1<UT, UB> abstractC1940o1, T t10, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        abstractC1940o1.mo12079t(abstractC1940o1.mo12066g(t10), interfaceC1961v1);
    }

    /* renamed from: y */
    public final <UT, UB> int m12356y(AbstractC1940o1<UT, UB> abstractC1940o1, T t10) {
        return abstractC1940o1.mo12067h(abstractC1940o1.mo12066g(t10));
    }
}
