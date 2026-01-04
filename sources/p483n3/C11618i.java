package p483n3;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import p468m3.C11396b;
import p468m3.C11397c;
import p565q3.C12277a;

/* renamed from: n3.i */
/* loaded from: classes.dex */
public class C11618i<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: j */
    public static final Object f53933j = new Object();

    /* renamed from: a */
    public transient Object f53934a;

    /* renamed from: b */
    public transient int[] f53935b;

    /* renamed from: c */
    public transient Object[] f53936c;

    /* renamed from: d */
    public transient Object[] f53937d;

    /* renamed from: e */
    public transient int f53938e;

    /* renamed from: f */
    public transient int f53939f;

    /* renamed from: g */
    public transient Set<K> f53940g;

    /* renamed from: h */
    public transient Set<Map.Entry<K, V>> f53941h;

    /* renamed from: i */
    public transient Collection<V> f53942i;

    /* renamed from: n3.i$a */
    public class a extends C11618i<K, V>.e<K> {
        public a() {
            super(C11618i.this, null);
        }

        @Override // p483n3.C11618i.e
        /* renamed from: c */
        public K mo69452c(int i10) {
            return (K) C11618i.this.m69425J(i10);
        }
    }

    /* renamed from: n3.i$b */
    public class b extends C11618i<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(C11618i.this, null);
        }

        @Override // p483n3.C11618i.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> mo69452c(int i10) {
            return new g(i10);
        }
    }

    /* renamed from: n3.i$c */
    public class c extends C11618i<K, V>.e<V> {
        public c() {
            super(C11618i.this, null);
        }

        @Override // p483n3.C11618i.e
        /* renamed from: c */
        public V mo69452c(int i10) {
            return (V) C11618i.this.m69441Z(i10);
        }
    }

    /* renamed from: n3.i$d */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C11618i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> mapM69451z = C11618i.this.m69451z();
            if (mapM69451z != null) {
                return mapM69451z.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iM69422G = C11618i.this.m69422G(entry.getKey());
            return iM69422G != -1 && C11396b.m68302a(C11618i.this.m69441Z(iM69422G), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return C11618i.this.m69417B();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapM69451z = C11618i.this.m69451z();
            if (mapM69451z != null) {
                return mapM69451z.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (C11618i.this.m69428M()) {
                return false;
            }
            int iM69420E = C11618i.this.m69420E();
            int iM69462f = C11619j.m69462f(entry.getKey(), entry.getValue(), iM69420E, C11618i.this.m69432Q(), C11618i.this.m69430O(), C11618i.this.m69431P(), C11618i.this.m69433R());
            if (iM69462f == -1) {
                return false;
            }
            C11618i.this.m69427L(iM69462f, iM69420E);
            C11618i.m69405f(C11618i.this);
            C11618i.this.m69421F();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C11618i.this.size();
        }
    }

    /* renamed from: n3.i$f */
    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C11618i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C11618i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return C11618i.this.m69426K();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapM69451z = C11618i.this.m69451z();
            return mapM69451z != null ? mapM69451z.keySet().remove(obj) : C11618i.this.m69429N(obj) != C11618i.f53933j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C11618i.this.size();
        }
    }

    /* renamed from: n3.i$g */
    public final class g extends AbstractC11612c<K, V> {

        /* renamed from: a */
        public final K f53952a;

        /* renamed from: b */
        public int f53953b;

        public g(int i10) {
            this.f53952a = (K) C11618i.this.m69425J(i10);
            this.f53953b = i10;
        }

        /* renamed from: b */
        public final void m69456b() {
            int i10 = this.f53953b;
            if (i10 == -1 || i10 >= C11618i.this.size() || !C11396b.m68302a(this.f53952a, C11618i.this.m69425J(this.f53953b))) {
                this.f53953b = C11618i.this.m69422G(this.f53952a);
            }
        }

        @Override // p483n3.AbstractC11612c, java.util.Map.Entry
        public K getKey() {
            return this.f53952a;
        }

        @Override // p483n3.AbstractC11612c, java.util.Map.Entry
        public V getValue() {
            Map<K, V> mapM69451z = C11618i.this.m69451z();
            if (mapM69451z != null) {
                return (V) C11627r.m69486a(mapM69451z.get(this.f53952a));
            }
            m69456b();
            int i10 = this.f53953b;
            return i10 == -1 ? (V) C11627r.m69487b() : (V) C11618i.this.m69441Z(i10);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            Map<K, V> mapM69451z = C11618i.this.m69451z();
            if (mapM69451z != null) {
                return (V) C11627r.m69486a(mapM69451z.put(this.f53952a, v10));
            }
            m69456b();
            int i10 = this.f53953b;
            if (i10 == -1) {
                C11618i.this.put(this.f53952a, v10);
                return (V) C11627r.m69487b();
            }
            V v11 = (V) C11618i.this.m69441Z(i10);
            C11618i.this.m69440Y(this.f53953b, v10);
            return v11;
        }
    }

    /* renamed from: n3.i$h */
    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            C11618i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return C11618i.this.m69442a0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return C11618i.this.size();
        }
    }

    public C11618i() {
        m69423H(3);
    }

    /* renamed from: f */
    public static /* synthetic */ int m69405f(C11618i c11618i) {
        int i10 = c11618i.f53939f;
        c11618i.f53939f = i10 - 1;
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i10 = objectInputStream.readInt();
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("Invalid size: ");
            sb2.append(i10);
            throw new InvalidObjectException(sb2.toString());
        }
        m69423H(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* renamed from: t */
    public static <K, V> C11618i<K, V> m69414t() {
        return new C11618i<>();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itM69417B = m69417B();
        while (itM69417B.hasNext()) {
            Map.Entry<K, V> next = itM69417B.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    /* renamed from: y */
    public static <K, V> C11618i<K, V> m69415y(int i10) {
        return new C11618i<>(i10);
    }

    /* renamed from: A */
    public final int m69416A(int i10) {
        return m69430O()[i10];
    }

    /* renamed from: B */
    public Iterator<Map.Entry<K, V>> m69417B() {
        Map<K, V> mapM69451z = m69451z();
        return mapM69451z != null ? mapM69451z.entrySet().iterator() : new b();
    }

    /* renamed from: C */
    public int m69418C() {
        return isEmpty() ? -1 : 0;
    }

    /* renamed from: D */
    public int m69419D(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f53939f) {
            return i11;
        }
        return -1;
    }

    /* renamed from: E */
    public final int m69420E() {
        return (1 << (this.f53938e & 31)) - 1;
    }

    /* renamed from: F */
    public void m69421F() {
        this.f53938e += 32;
    }

    /* renamed from: G */
    public final int m69422G(Object obj) {
        if (m69428M()) {
            return -1;
        }
        int iM69469c = C11620k.m69469c(obj);
        int iM69420E = m69420E();
        int iM69464h = C11619j.m69464h(m69432Q(), iM69469c & iM69420E);
        if (iM69464h == 0) {
            return -1;
        }
        int iM69458b = C11619j.m69458b(iM69469c, iM69420E);
        do {
            int i10 = iM69464h - 1;
            int iM69416A = m69416A(i10);
            if (C11619j.m69458b(iM69416A, iM69420E) == iM69458b && C11396b.m68302a(obj, m69425J(i10))) {
                return i10;
            }
            iM69464h = C11619j.m69459c(iM69416A, iM69420E);
        } while (iM69464h != 0);
        return -1;
    }

    /* renamed from: H */
    public void m69423H(int i10) {
        C11397c.m68305b(i10 >= 0, "Expected size must be >= 0");
        this.f53938e = C12277a.m73802b(i10, 1, 1073741823);
    }

    /* renamed from: I */
    public void m69424I(int i10, K k10, V v10, int i11, int i12) {
        m69437V(i10, C11619j.m69460d(i11, 0, i12));
        m69439X(i10, k10);
        m69440Y(i10, v10);
    }

    /* renamed from: J */
    public final K m69425J(int i10) {
        return (K) m69431P()[i10];
    }

    /* renamed from: K */
    public Iterator<K> m69426K() {
        Map<K, V> mapM69451z = m69451z();
        return mapM69451z != null ? mapM69451z.keySet().iterator() : new a();
    }

    /* renamed from: L */
    public void m69427L(int i10, int i11) {
        Object objM69432Q = m69432Q();
        int[] iArrM69430O = m69430O();
        Object[] objArrM69431P = m69431P();
        Object[] objArrM69433R = m69433R();
        int size = size();
        int i12 = size - 1;
        if (i10 >= i12) {
            objArrM69431P[i10] = null;
            objArrM69433R[i10] = null;
            iArrM69430O[i10] = 0;
            return;
        }
        Object obj = objArrM69431P[i12];
        objArrM69431P[i10] = obj;
        objArrM69433R[i10] = objArrM69433R[i12];
        objArrM69431P[i12] = null;
        objArrM69433R[i12] = null;
        iArrM69430O[i10] = iArrM69430O[i12];
        iArrM69430O[i12] = 0;
        int iM69469c = C11620k.m69469c(obj) & i11;
        int iM69464h = C11619j.m69464h(objM69432Q, iM69469c);
        if (iM69464h == size) {
            C11619j.m69465i(objM69432Q, iM69469c, i10 + 1);
            return;
        }
        while (true) {
            int i13 = iM69464h - 1;
            int i14 = iArrM69430O[i13];
            int iM69459c = C11619j.m69459c(i14, i11);
            if (iM69459c == size) {
                iArrM69430O[i13] = C11619j.m69460d(i14, i10 + 1, i11);
                return;
            }
            iM69464h = iM69459c;
        }
    }

    /* renamed from: M */
    public boolean m69428M() {
        return this.f53934a == null;
    }

    /* renamed from: N */
    public final Object m69429N(Object obj) {
        if (m69428M()) {
            return f53933j;
        }
        int iM69420E = m69420E();
        int iM69462f = C11619j.m69462f(obj, null, iM69420E, m69432Q(), m69430O(), m69431P(), null);
        if (iM69462f == -1) {
            return f53933j;
        }
        V vM69441Z = m69441Z(iM69462f);
        m69427L(iM69462f, iM69420E);
        this.f53939f--;
        m69421F();
        return vM69441Z;
    }

    /* renamed from: O */
    public final int[] m69430O() {
        int[] iArr = this.f53935b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* renamed from: P */
    public final Object[] m69431P() {
        Object[] objArr = this.f53936c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* renamed from: Q */
    public final Object m69432Q() {
        Object obj = this.f53934a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* renamed from: R */
    public final Object[] m69433R() {
        Object[] objArr = this.f53937d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* renamed from: S */
    public void m69434S(int i10) {
        this.f53935b = Arrays.copyOf(m69430O(), i10);
        this.f53936c = Arrays.copyOf(m69431P(), i10);
        this.f53937d = Arrays.copyOf(m69433R(), i10);
    }

    /* renamed from: T */
    public final void m69435T(int i10) {
        int iMin;
        int length = m69430O().length;
        if (i10 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        m69434S(iMin);
    }

    /* renamed from: U */
    public final int m69436U(int i10, int i11, int i12, int i13) {
        Object objM69457a = C11619j.m69457a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            C11619j.m69465i(objM69457a, i12 & i14, i13 + 1);
        }
        Object objM69432Q = m69432Q();
        int[] iArrM69430O = m69430O();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iM69464h = C11619j.m69464h(objM69432Q, i15);
            while (iM69464h != 0) {
                int i16 = iM69464h - 1;
                int i17 = iArrM69430O[i16];
                int iM69458b = C11619j.m69458b(i17, i10) | i15;
                int i18 = iM69458b & i14;
                int iM69464h2 = C11619j.m69464h(objM69457a, i18);
                C11619j.m69465i(objM69457a, i18, iM69464h);
                iArrM69430O[i16] = C11619j.m69460d(iM69458b, iM69464h2, i14);
                iM69464h = C11619j.m69459c(i17, i10);
            }
        }
        this.f53934a = objM69457a;
        m69438W(i14);
        return i14;
    }

    /* renamed from: V */
    public final void m69437V(int i10, int i11) {
        m69430O()[i10] = i11;
    }

    /* renamed from: W */
    public final void m69438W(int i10) {
        this.f53938e = C11619j.m69460d(this.f53938e, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    /* renamed from: X */
    public final void m69439X(int i10, K k10) {
        m69431P()[i10] = k10;
    }

    /* renamed from: Y */
    public final void m69440Y(int i10, V v10) {
        m69433R()[i10] = v10;
    }

    /* renamed from: Z */
    public final V m69441Z(int i10) {
        return (V) m69433R()[i10];
    }

    /* renamed from: a0 */
    public Iterator<V> m69442a0() {
        Map<K, V> mapM69451z = m69451z();
        return mapM69451z != null ? mapM69451z.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (m69428M()) {
            return;
        }
        m69421F();
        Map<K, V> mapM69451z = m69451z();
        if (mapM69451z != null) {
            this.f53938e = C12277a.m73802b(size(), 3, 1073741823);
            mapM69451z.clear();
            this.f53934a = null;
            this.f53939f = 0;
            return;
        }
        Arrays.fill(m69431P(), 0, this.f53939f, (Object) null);
        Arrays.fill(m69433R(), 0, this.f53939f, (Object) null);
        C11619j.m69463g(m69432Q());
        Arrays.fill(m69430O(), 0, this.f53939f, 0);
        this.f53939f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapM69451z = m69451z();
        return mapM69451z != null ? mapM69451z.containsKey(obj) : m69422G(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapM69451z = m69451z();
        if (mapM69451z != null) {
            return mapM69451z.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f53939f; i10++) {
            if (C11396b.m68302a(obj, m69441Z(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f53941h;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setM69447u = m69447u();
        this.f53941h = setM69447u;
        return setM69447u;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapM69451z = m69451z();
        if (mapM69451z != null) {
            return mapM69451z.get(obj);
        }
        int iM69422G = m69422G(obj);
        if (iM69422G == -1) {
            return null;
        }
        m69443p(iM69422G);
        return m69441Z(iM69422G);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f53940g;
        if (set != null) {
            return set;
        }
        Set<K> setM69449w = m69449w();
        this.f53940g = setM69449w;
        return setM69449w;
    }

    /* renamed from: p */
    public void m69443p(int i10) {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        int iM69436U;
        int i10;
        if (m69428M()) {
            m69445r();
        }
        Map<K, V> mapM69451z = m69451z();
        if (mapM69451z != null) {
            return mapM69451z.put(k10, v10);
        }
        int[] iArrM69430O = m69430O();
        Object[] objArrM69431P = m69431P();
        Object[] objArrM69433R = m69433R();
        int i11 = this.f53939f;
        int i12 = i11 + 1;
        int iM69469c = C11620k.m69469c(k10);
        int iM69420E = m69420E();
        int i13 = iM69469c & iM69420E;
        int iM69464h = C11619j.m69464h(m69432Q(), i13);
        if (iM69464h != 0) {
            int iM69458b = C11619j.m69458b(iM69469c, iM69420E);
            int i14 = 0;
            while (true) {
                int i15 = iM69464h - 1;
                int i16 = iArrM69430O[i15];
                if (C11619j.m69458b(i16, iM69420E) == iM69458b && C11396b.m68302a(k10, objArrM69431P[i15])) {
                    V v11 = (V) objArrM69433R[i15];
                    objArrM69433R[i15] = v10;
                    m69443p(i15);
                    return v11;
                }
                int iM69459c = C11619j.m69459c(i16, iM69420E);
                i14++;
                if (iM69459c != 0) {
                    iM69464h = iM69459c;
                } else {
                    if (i14 >= 9) {
                        return m69446s().put(k10, v10);
                    }
                    if (i12 > iM69420E) {
                        iM69436U = m69436U(iM69420E, C11619j.m69461e(iM69420E), iM69469c, i11);
                    } else {
                        iArrM69430O[i15] = C11619j.m69460d(i16, i12, iM69420E);
                    }
                }
            }
            i10 = iM69420E;
        } else if (i12 > iM69420E) {
            iM69436U = m69436U(iM69420E, C11619j.m69461e(iM69420E), iM69469c, i11);
            i10 = iM69436U;
        } else {
            C11619j.m69465i(m69432Q(), i13, i12);
            i10 = iM69420E;
        }
        m69435T(i12);
        m69424I(i11, k10, v10, iM69469c, i10);
        this.f53939f = i12;
        m69421F();
        return null;
    }

    /* renamed from: q */
    public int m69444q(int i10, int i11) {
        return i10 - 1;
    }

    /* renamed from: r */
    public int m69445r() {
        C11397c.m68311h(m69428M(), "Arrays already allocated");
        int i10 = this.f53938e;
        int iM69466j = C11619j.m69466j(i10);
        this.f53934a = C11619j.m69457a(iM69466j);
        m69438W(iM69466j - 1);
        this.f53935b = new int[i10];
        this.f53936c = new Object[i10];
        this.f53937d = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapM69451z = m69451z();
        if (mapM69451z != null) {
            return mapM69451z.remove(obj);
        }
        V v10 = (V) m69429N(obj);
        if (v10 == f53933j) {
            return null;
        }
        return v10;
    }

    /* renamed from: s */
    public Map<K, V> m69446s() {
        Map<K, V> mapM69448v = m69448v(m69420E() + 1);
        int iM69418C = m69418C();
        while (iM69418C >= 0) {
            mapM69448v.put(m69425J(iM69418C), m69441Z(iM69418C));
            iM69418C = m69419D(iM69418C);
        }
        this.f53934a = mapM69448v;
        this.f53935b = null;
        this.f53936c = null;
        this.f53937d = null;
        m69421F();
        return mapM69448v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapM69451z = m69451z();
        return mapM69451z != null ? mapM69451z.size() : this.f53939f;
    }

    /* renamed from: u */
    public Set<Map.Entry<K, V>> m69447u() {
        return new d();
    }

    /* renamed from: v */
    public Map<K, V> m69448v(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f53942i;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionM69450x = m69450x();
        this.f53942i = collectionM69450x;
        return collectionM69450x;
    }

    /* renamed from: w */
    public Set<K> m69449w() {
        return new f();
    }

    /* renamed from: x */
    public Collection<V> m69450x() {
        return new h();
    }

    /* renamed from: z */
    public Map<K, V> m69451z() {
        Object obj = this.f53934a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public C11618i(int i10) {
        m69423H(i10);
    }

    /* renamed from: n3.i$e */
    public abstract class e<T> implements Iterator<T> {

        /* renamed from: a */
        public int f53947a;

        /* renamed from: b */
        public int f53948b;

        /* renamed from: c */
        public int f53949c;

        public e() {
            this.f53947a = C11618i.this.f53938e;
            this.f53948b = C11618i.this.m69418C();
            this.f53949c = -1;
        }

        /* renamed from: b */
        public final void m69454b() {
            if (C11618i.this.f53938e != this.f53947a) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: c */
        public abstract T mo69452c(int i10);

        /* renamed from: d */
        public void m69455d() {
            this.f53947a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f53948b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            m69454b();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f53948b;
            this.f53949c = i10;
            T tMo69452c = mo69452c(i10);
            this.f53948b = C11618i.this.m69419D(this.f53948b);
            return tMo69452c;
        }

        @Override // java.util.Iterator
        public void remove() {
            m69454b();
            C11616g.m69399b(this.f53949c >= 0);
            m69455d();
            C11618i c11618i = C11618i.this;
            c11618i.remove(c11618i.m69425J(this.f53949c));
            this.f53948b = C11618i.this.m69444q(this.f53948b, this.f53949c);
            this.f53949c = -1;
        }

        public /* synthetic */ e(C11618i c11618i, a aVar) {
            this();
        }
    }
}
