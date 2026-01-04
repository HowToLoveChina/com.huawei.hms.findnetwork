package p438l;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: l.g */
/* loaded from: classes.dex */
public class C11213g<K, V> {

    /* renamed from: d */
    public static Object[] f52639d;

    /* renamed from: e */
    public static int f52640e;

    /* renamed from: f */
    public static Object[] f52641f;

    /* renamed from: g */
    public static int f52642g;

    /* renamed from: a */
    public int[] f52643a;

    /* renamed from: b */
    public Object[] f52644b;

    /* renamed from: c */
    public int f52645c;

    public C11213g() {
        this.f52643a = C11209c.f52608a;
        this.f52644b = C11209c.f52610c;
        this.f52645c = 0;
    }

    /* renamed from: b */
    public static int m67323b(int[] iArr, int i10, int i11) {
        try {
            return C11209c.m67287a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: d */
    public static void m67324d(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (C11213g.class) {
                try {
                    if (f52642g < 10) {
                        objArr[0] = f52641f;
                        objArr[1] = iArr;
                        for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f52641f = objArr;
                        f52642g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C11213g.class) {
                try {
                    if (f52640e < 10) {
                        objArr[0] = f52639d;
                        objArr[1] = iArr;
                        for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f52639d = objArr;
                        f52640e++;
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public final void m67325a(int i10) {
        if (i10 == 8) {
            synchronized (C11213g.class) {
                try {
                    Object[] objArr = f52641f;
                    if (objArr != null) {
                        this.f52644b = objArr;
                        f52641f = (Object[]) objArr[0];
                        this.f52643a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f52642g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i10 == 4) {
            synchronized (C11213g.class) {
                try {
                    Object[] objArr2 = f52639d;
                    if (objArr2 != null) {
                        this.f52644b = objArr2;
                        f52639d = (Object[]) objArr2[0];
                        this.f52643a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f52640e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f52643a = new int[i10];
        this.f52644b = new Object[i10 << 1];
    }

    /* renamed from: c */
    public void m67326c(int i10) {
        int i11 = this.f52645c;
        int[] iArr = this.f52643a;
        if (iArr.length < i10) {
            Object[] objArr = this.f52644b;
            m67325a(i10);
            if (this.f52645c > 0) {
                System.arraycopy(iArr, 0, this.f52643a, 0, i11);
                System.arraycopy(objArr, 0, this.f52644b, 0, i11 << 1);
            }
            m67324d(iArr, objArr, i11);
        }
        if (this.f52645c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f52645c;
        if (i10 > 0) {
            int[] iArr = this.f52643a;
            Object[] objArr = this.f52644b;
            this.f52643a = C11209c.f52608a;
            this.f52644b = C11209c.f52610c;
            this.f52645c = 0;
            m67324d(iArr, objArr, i10);
        }
        if (this.f52645c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m67328f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m67330h(obj) >= 0;
    }

    /* renamed from: e */
    public int m67327e(Object obj, int i10) {
        int i11 = this.f52645c;
        if (i11 == 0) {
            return -1;
        }
        int iM67323b = m67323b(this.f52643a, i11, i10);
        if (iM67323b < 0 || obj.equals(this.f52644b[iM67323b << 1])) {
            return iM67323b;
        }
        int i12 = iM67323b + 1;
        while (i12 < i11 && this.f52643a[i12] == i10) {
            if (obj.equals(this.f52644b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iM67323b - 1; i13 >= 0 && this.f52643a[i13] == i10; i13--) {
            if (obj.equals(this.f52644b[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11213g) {
            C11213g c11213g = (C11213g) obj;
            if (size() != c11213g.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f52645c; i10++) {
                try {
                    K kM67331i = m67331i(i10);
                    V vM67335m = m67335m(i10);
                    Object obj2 = c11213g.get(kM67331i);
                    if (vM67335m == null) {
                        if (obj2 != null || !c11213g.containsKey(kM67331i)) {
                            return false;
                        }
                    } else if (!vM67335m.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f52645c; i11++) {
                try {
                    K kM67331i2 = m67331i(i11);
                    V vM67335m2 = m67335m(i11);
                    Object obj3 = map.get(kM67331i2);
                    if (vM67335m2 == null) {
                        if (obj3 != null || !map.containsKey(kM67331i2)) {
                            return false;
                        }
                    } else if (!vM67335m2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int m67328f(Object obj) {
        return obj == null ? m67329g() : m67327e(obj, obj.hashCode());
    }

    /* renamed from: g */
    public int m67329g() {
        int i10 = this.f52645c;
        if (i10 == 0) {
            return -1;
        }
        int iM67323b = m67323b(this.f52643a, i10, 0);
        if (iM67323b < 0 || this.f52644b[iM67323b << 1] == null) {
            return iM67323b;
        }
        int i11 = iM67323b + 1;
        while (i11 < i10 && this.f52643a[i11] == 0) {
            if (this.f52644b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iM67323b - 1; i12 >= 0 && this.f52643a[i12] == 0; i12--) {
            if (this.f52644b[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v10) {
        int iM67328f = m67328f(obj);
        return iM67328f >= 0 ? (V) this.f52644b[(iM67328f << 1) + 1] : v10;
    }

    /* renamed from: h */
    public int m67330h(Object obj) {
        int i10 = this.f52645c * 2;
        Object[] objArr = this.f52644b;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f52643a;
        Object[] objArr = this.f52644b;
        int i10 = this.f52645c;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    /* renamed from: i */
    public K m67331i(int i10) {
        return (K) this.f52644b[i10 << 1];
    }

    public boolean isEmpty() {
        return this.f52645c <= 0;
    }

    /* renamed from: j */
    public void mo67332j(C11213g<? extends K, ? extends V> c11213g) {
        int i10 = c11213g.f52645c;
        m67326c(this.f52645c + i10);
        if (this.f52645c != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(c11213g.m67331i(i11), c11213g.m67335m(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(c11213g.f52643a, 0, this.f52643a, 0, i10);
            System.arraycopy(c11213g.f52644b, 0, this.f52644b, 0, i10 << 1);
            this.f52645c = i10;
        }
    }

    /* renamed from: k */
    public V mo67333k(int i10) {
        Object[] objArr = this.f52644b;
        int i11 = i10 << 1;
        V v10 = (V) objArr[i11 + 1];
        int i12 = this.f52645c;
        int i13 = 0;
        if (i12 <= 1) {
            m67324d(this.f52643a, objArr, i12);
            this.f52643a = C11209c.f52608a;
            this.f52644b = C11209c.f52610c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.f52643a;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.f52644b;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.f52644b;
                int i17 = i14 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                m67325a(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.f52645c) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f52643a, 0, i10);
                    System.arraycopy(objArr, 0, this.f52644b, 0, i11);
                }
                if (i10 < i14) {
                    int i18 = i10 + 1;
                    int i19 = i14 - i10;
                    System.arraycopy(iArr, i18, this.f52643a, i10, i19);
                    System.arraycopy(objArr, i18 << 1, this.f52644b, i11, i19 << 1);
                }
            }
            i13 = i14;
        }
        if (i12 != this.f52645c) {
            throw new ConcurrentModificationException();
        }
        this.f52645c = i13;
        return v10;
    }

    /* renamed from: l */
    public V mo67334l(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f52644b;
        V v11 = (V) objArr[i11];
        objArr[i11] = v10;
        return v11;
    }

    /* renamed from: m */
    public V m67335m(int i10) {
        return (V) this.f52644b[(i10 << 1) + 1];
    }

    public V put(K k10, V v10) {
        int i10;
        int iM67327e;
        int i11 = this.f52645c;
        if (k10 == null) {
            iM67327e = m67329g();
            i10 = 0;
        } else {
            int iHashCode = k10.hashCode();
            i10 = iHashCode;
            iM67327e = m67327e(k10, iHashCode);
        }
        if (iM67327e >= 0) {
            int i12 = (iM67327e << 1) + 1;
            Object[] objArr = this.f52644b;
            V v11 = (V) objArr[i12];
            objArr[i12] = v10;
            return v11;
        }
        int i13 = ~iM67327e;
        int[] iArr = this.f52643a;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            Object[] objArr2 = this.f52644b;
            m67325a(i14);
            if (i11 != this.f52645c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f52643a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f52644b, 0, objArr2.length);
            }
            m67324d(iArr, objArr2, i11);
        }
        if (i13 < i11) {
            int[] iArr3 = this.f52643a;
            int i15 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i15, i11 - i13);
            Object[] objArr3 = this.f52644b;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.f52645c - i13) << 1);
        }
        int i16 = this.f52645c;
        if (i11 == i16) {
            int[] iArr4 = this.f52643a;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.f52644b;
                int i17 = i13 << 1;
                objArr4[i17] = k10;
                objArr4[i17 + 1] = v10;
                this.f52645c = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        return v11 == null ? put(k10, v10) : v11;
    }

    public V remove(Object obj) {
        int iM67328f = m67328f(obj);
        if (iM67328f >= 0) {
            return mo67333k(iM67328f);
        }
        return null;
    }

    public V replace(K k10, V v10) {
        int iM67328f = m67328f(k10);
        if (iM67328f >= 0) {
            return mo67334l(iM67328f, v10);
        }
        return null;
    }

    public int size() {
        return this.f52645c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f52645c * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f52645c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            K kM67331i = m67331i(i10);
            if (kM67331i != this) {
                sb2.append(kM67331i);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vM67335m = m67335m(i10);
            if (vM67335m != this) {
                sb2.append(vM67335m);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int iM67328f = m67328f(obj);
        if (iM67328f < 0) {
            return false;
        }
        V vM67335m = m67335m(iM67328f);
        if (obj2 != vM67335m && (obj2 == null || !obj2.equals(vM67335m))) {
            return false;
        }
        mo67333k(iM67328f);
        return true;
    }

    public boolean replace(K k10, V v10, V v11) {
        int iM67328f = m67328f(k10);
        if (iM67328f < 0) {
            return false;
        }
        V vM67335m = m67335m(iM67328f);
        if (vM67335m != v10 && (v10 == null || !v10.equals(vM67335m))) {
            return false;
        }
        mo67334l(iM67328f, v11);
        return true;
    }

    public C11213g(int i10) {
        if (i10 == 0) {
            this.f52643a = C11209c.f52608a;
            this.f52644b = C11209c.f52610c;
        } else {
            m67325a(i10);
        }
        this.f52645c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11213g(C11213g<K, V> c11213g) {
        this();
        if (c11213g != 0) {
            mo67332j(c11213g);
        }
    }
}
