package p438l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: l.b */
/* loaded from: classes.dex */
public final class C11208b<E> implements Collection<E>, Set<E> {

    /* renamed from: e */
    public static final int[] f52597e = new int[0];

    /* renamed from: f */
    public static final Object[] f52598f = new Object[0];

    /* renamed from: g */
    public static Object[] f52599g;

    /* renamed from: h */
    public static int f52600h;

    /* renamed from: i */
    public static Object[] f52601i;

    /* renamed from: j */
    public static int f52602j;

    /* renamed from: a */
    public int[] f52603a;

    /* renamed from: b */
    public Object[] f52604b;

    /* renamed from: c */
    public int f52605c;

    /* renamed from: d */
    public AbstractC11212f<E, E> f52606d;

    /* renamed from: l.b$a */
    public class a extends AbstractC11212f<E, E> {
        public a() {
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: a */
        public void mo67270a() {
            C11208b.this.clear();
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: b */
        public Object mo67271b(int i10, int i11) {
            return C11208b.this.f52604b[i10];
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: c */
        public Map<E, E> mo67272c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: d */
        public int mo67273d() {
            return C11208b.this.f52605c;
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: e */
        public int mo67274e(Object obj) {
            return C11208b.this.indexOf(obj);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: f */
        public int mo67275f(Object obj) {
            return C11208b.this.indexOf(obj);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: g */
        public void mo67276g(E e10, E e11) {
            C11208b.this.add(e10);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: h */
        public void mo67277h(int i10) {
            C11208b.this.m67285g(i10);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: i */
        public E mo67278i(int i10, E e10) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public C11208b() {
        this(0);
    }

    /* renamed from: c */
    public static void m67279c(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (C11208b.class) {
                try {
                    if (f52602j < 10) {
                        objArr[0] = f52601i;
                        objArr[1] = iArr;
                        for (int i11 = i10 - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f52601i = objArr;
                        f52602j++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C11208b.class) {
                try {
                    if (f52600h < 10) {
                        objArr[0] = f52599g;
                        objArr[1] = iArr;
                        for (int i12 = i10 - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f52599g = objArr;
                        f52600h++;
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public final void m67280a(int i10) {
        if (i10 == 8) {
            synchronized (C11208b.class) {
                try {
                    Object[] objArr = f52601i;
                    if (objArr != null) {
                        this.f52604b = objArr;
                        f52601i = (Object[]) objArr[0];
                        this.f52603a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f52602j--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i10 == 4) {
            synchronized (C11208b.class) {
                try {
                    Object[] objArr2 = f52599g;
                    if (objArr2 != null) {
                        this.f52604b = objArr2;
                        f52599g = (Object[]) objArr2[0];
                        this.f52603a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f52600h--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f52603a = new int[i10];
        this.f52604b = new Object[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i10;
        int iM67283e;
        if (e10 == null) {
            iM67283e = m67284f();
            i10 = 0;
        } else {
            int iHashCode = e10.hashCode();
            i10 = iHashCode;
            iM67283e = m67283e(e10, iHashCode);
        }
        if (iM67283e >= 0) {
            return false;
        }
        int i11 = ~iM67283e;
        int i12 = this.f52605c;
        int[] iArr = this.f52603a;
        if (i12 >= iArr.length) {
            int i13 = 8;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f52604b;
            m67280a(i13);
            int[] iArr2 = this.f52603a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f52604b, 0, objArr.length);
            }
            m67279c(iArr, objArr, this.f52605c);
        }
        int i14 = this.f52605c;
        if (i11 < i14) {
            int[] iArr3 = this.f52603a;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f52604b;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f52605c - i11);
        }
        this.f52603a[i11] = i10;
        this.f52604b[i11] = e10;
        this.f52605c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        m67281b(this.f52605c + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    /* renamed from: b */
    public void m67281b(int i10) {
        int[] iArr = this.f52603a;
        if (iArr.length < i10) {
            Object[] objArr = this.f52604b;
            m67280a(i10);
            int i11 = this.f52605c;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f52603a, 0, i11);
                System.arraycopy(objArr, 0, this.f52604b, 0, this.f52605c);
            }
            m67279c(iArr, objArr, this.f52605c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f52605c;
        if (i10 != 0) {
            m67279c(this.f52603a, this.f52604b, i10);
            this.f52603a = f52597e;
            this.f52604b = f52598f;
            this.f52605c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final AbstractC11212f<E, E> m67282d() {
        if (this.f52606d == null) {
            this.f52606d = new a();
        }
        return this.f52606d;
    }

    /* renamed from: e */
    public final int m67283e(Object obj, int i10) {
        int i11 = this.f52605c;
        if (i11 == 0) {
            return -1;
        }
        int iM67287a = C11209c.m67287a(this.f52603a, i11, i10);
        if (iM67287a < 0 || obj.equals(this.f52604b[iM67287a])) {
            return iM67287a;
        }
        int i12 = iM67287a + 1;
        while (i12 < i11 && this.f52603a[i12] == i10) {
            if (obj.equals(this.f52604b[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iM67287a - 1; i13 >= 0 && this.f52603a[i13] == i10; i13--) {
            if (obj.equals(this.f52604b[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f52605c; i10++) {
                try {
                    if (!set.contains(m67286h(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final int m67284f() {
        int i10 = this.f52605c;
        if (i10 == 0) {
            return -1;
        }
        int iM67287a = C11209c.m67287a(this.f52603a, i10, 0);
        if (iM67287a < 0 || this.f52604b[iM67287a] == null) {
            return iM67287a;
        }
        int i11 = iM67287a + 1;
        while (i11 < i10 && this.f52603a[i11] == 0) {
            if (this.f52604b[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iM67287a - 1; i12 >= 0 && this.f52603a[i12] == 0; i12--) {
            if (this.f52604b[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    /* renamed from: g */
    public E m67285g(int i10) {
        Object[] objArr = this.f52604b;
        E e10 = (E) objArr[i10];
        int i11 = this.f52605c;
        if (i11 <= 1) {
            m67279c(this.f52603a, objArr, i11);
            this.f52603a = f52597e;
            this.f52604b = f52598f;
            this.f52605c = 0;
        } else {
            int[] iArr = this.f52603a;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i12 = i11 - 1;
                this.f52605c = i12;
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                    Object[] objArr2 = this.f52604b;
                    System.arraycopy(objArr2, i13, objArr2, i10, this.f52605c - i10);
                }
                this.f52604b[this.f52605c] = null;
            } else {
                m67280a(i11 > 8 ? i11 + (i11 >> 1) : 8);
                this.f52605c--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f52603a, 0, i10);
                    System.arraycopy(objArr, 0, this.f52604b, 0, i10);
                }
                int i14 = this.f52605c;
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    System.arraycopy(iArr, i15, this.f52603a, i10, i14 - i10);
                    System.arraycopy(objArr, i15, this.f52604b, i10, this.f52605c - i10);
                }
            }
        }
        return e10;
    }

    /* renamed from: h */
    public E m67286h(int i10) {
        return (E) this.f52604b[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f52603a;
        int i10 = this.f52605c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? m67284f() : m67283e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f52605c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return m67282d().m67317m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        m67285g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f52605c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f52604b[i10])) {
                m67285g(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f52605c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f52605c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f52604b, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f52605c * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f52605c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E eM67286h = m67286h(i10);
            if (eM67286h != this) {
                sb2.append(eM67286h);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public C11208b(int i10) {
        if (i10 == 0) {
            this.f52603a = f52597e;
            this.f52604b = f52598f;
        } else {
            m67280a(i10);
        }
        this.f52605c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f52605c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f52605c));
        }
        System.arraycopy(this.f52604b, 0, tArr, 0, this.f52605c);
        int length = tArr.length;
        int i10 = this.f52605c;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11208b(Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
