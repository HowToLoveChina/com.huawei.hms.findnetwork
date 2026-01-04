package p438l;

/* renamed from: l.d */
/* loaded from: classes.dex */
public class C11210d<E> implements Cloneable {

    /* renamed from: e */
    public static final Object f52611e = new Object();

    /* renamed from: a */
    public boolean f52612a;

    /* renamed from: b */
    public long[] f52613b;

    /* renamed from: c */
    public Object[] f52614c;

    /* renamed from: d */
    public int f52615d;

    public C11210d() {
        this(10);
    }

    /* renamed from: c */
    public void m67293c() {
        int i10 = this.f52615d;
        Object[] objArr = this.f52614c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f52615d = 0;
        this.f52612a = false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C11210d<E> clone() {
        try {
            C11210d<E> c11210d = (C11210d) super.clone();
            c11210d.f52613b = (long[]) this.f52613b.clone();
            c11210d.f52614c = (Object[]) this.f52614c.clone();
            return c11210d;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: f */
    public final void m67295f() {
        int i10 = this.f52615d;
        long[] jArr = this.f52613b;
        Object[] objArr = this.f52614c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f52611e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f52612a = false;
        this.f52615d = i11;
    }

    /* renamed from: g */
    public E m67296g(long j10) {
        return m67297i(j10, null);
    }

    /* renamed from: i */
    public E m67297i(long j10, E e10) {
        E e11;
        int iM67288b = C11209c.m67288b(this.f52613b, this.f52615d, j10);
        return (iM67288b < 0 || (e11 = (E) this.f52614c[iM67288b]) == f52611e) ? e10 : e11;
    }

    /* renamed from: j */
    public int m67298j(long j10) {
        if (this.f52612a) {
            m67295f();
        }
        return C11209c.m67288b(this.f52613b, this.f52615d, j10);
    }

    /* renamed from: k */
    public long m67299k(int i10) {
        if (this.f52612a) {
            m67295f();
        }
        return this.f52613b[i10];
    }

    /* renamed from: l */
    public void m67300l(long j10, E e10) {
        int iM67288b = C11209c.m67288b(this.f52613b, this.f52615d, j10);
        if (iM67288b >= 0) {
            this.f52614c[iM67288b] = e10;
            return;
        }
        int i10 = ~iM67288b;
        int i11 = this.f52615d;
        if (i10 < i11) {
            Object[] objArr = this.f52614c;
            if (objArr[i10] == f52611e) {
                this.f52613b[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f52612a && i11 >= this.f52613b.length) {
            m67295f();
            i10 = ~C11209c.m67288b(this.f52613b, this.f52615d, j10);
        }
        int i12 = this.f52615d;
        if (i12 >= this.f52613b.length) {
            int iM67292f = C11209c.m67292f(i12 + 1);
            long[] jArr = new long[iM67292f];
            Object[] objArr2 = new Object[iM67292f];
            long[] jArr2 = this.f52613b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f52614c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f52613b = jArr;
            this.f52614c = objArr2;
        }
        int i13 = this.f52615d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f52613b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f52614c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f52615d - i10);
        }
        this.f52613b[i10] = j10;
        this.f52614c[i10] = e10;
        this.f52615d++;
    }

    /* renamed from: m */
    public void m67301m(long j10) {
        int iM67288b = C11209c.m67288b(this.f52613b, this.f52615d, j10);
        if (iM67288b >= 0) {
            Object[] objArr = this.f52614c;
            Object obj = objArr[iM67288b];
            Object obj2 = f52611e;
            if (obj != obj2) {
                objArr[iM67288b] = obj2;
                this.f52612a = true;
            }
        }
    }

    /* renamed from: n */
    public void m67302n(int i10) {
        Object[] objArr = this.f52614c;
        Object obj = objArr[i10];
        Object obj2 = f52611e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f52612a = true;
        }
    }

    /* renamed from: o */
    public int m67303o() {
        if (this.f52612a) {
            m67295f();
        }
        return this.f52615d;
    }

    /* renamed from: p */
    public E m67304p(int i10) {
        if (this.f52612a) {
            m67295f();
        }
        return (E) this.f52614c[i10];
    }

    public String toString() {
        if (m67303o() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f52615d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f52615d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(m67299k(i10));
            sb2.append('=');
            E eM67304p = m67304p(i10);
            if (eM67304p != this) {
                sb2.append(eM67304p);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public C11210d(int i10) {
        this.f52612a = false;
        if (i10 == 0) {
            this.f52613b = C11209c.f52609b;
            this.f52614c = C11209c.f52610c;
        } else {
            int iM67292f = C11209c.m67292f(i10);
            this.f52613b = new long[iM67292f];
            this.f52614c = new Object[iM67292f];
        }
    }
}
