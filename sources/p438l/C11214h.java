package p438l;

/* renamed from: l.h */
/* loaded from: classes.dex */
public class C11214h<E> implements Cloneable {

    /* renamed from: e */
    public static final Object f52646e = new Object();

    /* renamed from: a */
    public boolean f52647a;

    /* renamed from: b */
    public int[] f52648b;

    /* renamed from: c */
    public Object[] f52649c;

    /* renamed from: d */
    public int f52650d;

    public C11214h() {
        this(10);
    }

    /* renamed from: a */
    public void m67336a(int i10, E e10) {
        int i11 = this.f52650d;
        if (i11 != 0 && i10 <= this.f52648b[i11 - 1]) {
            m67344l(i10, e10);
            return;
        }
        if (this.f52647a && i11 >= this.f52648b.length) {
            m67339f();
        }
        int i12 = this.f52650d;
        if (i12 >= this.f52648b.length) {
            int iM67291e = C11209c.m67291e(i12 + 1);
            int[] iArr = new int[iM67291e];
            Object[] objArr = new Object[iM67291e];
            int[] iArr2 = this.f52648b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f52649c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f52648b = iArr;
            this.f52649c = objArr;
        }
        this.f52648b[i12] = i10;
        this.f52649c[i12] = e10;
        this.f52650d = i12 + 1;
    }

    /* renamed from: c */
    public void m67337c() {
        int i10 = this.f52650d;
        Object[] objArr = this.f52649c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f52650d = 0;
        this.f52647a = false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C11214h<E> clone() {
        try {
            C11214h<E> c11214h = (C11214h) super.clone();
            c11214h.f52648b = (int[]) this.f52648b.clone();
            c11214h.f52649c = (Object[]) this.f52649c.clone();
            return c11214h;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: f */
    public final void m67339f() {
        int i10 = this.f52650d;
        int[] iArr = this.f52648b;
        Object[] objArr = this.f52649c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f52646e) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f52647a = false;
        this.f52650d = i11;
    }

    /* renamed from: g */
    public E m67340g(int i10) {
        return m67341i(i10, null);
    }

    /* renamed from: i */
    public E m67341i(int i10, E e10) {
        E e11;
        int iM67287a = C11209c.m67287a(this.f52648b, this.f52650d, i10);
        return (iM67287a < 0 || (e11 = (E) this.f52649c[iM67287a]) == f52646e) ? e10 : e11;
    }

    /* renamed from: j */
    public int m67342j(E e10) {
        if (this.f52647a) {
            m67339f();
        }
        for (int i10 = 0; i10 < this.f52650d; i10++) {
            if (this.f52649c[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: k */
    public int m67343k(int i10) {
        if (this.f52647a) {
            m67339f();
        }
        return this.f52648b[i10];
    }

    /* renamed from: l */
    public void m67344l(int i10, E e10) {
        int iM67287a = C11209c.m67287a(this.f52648b, this.f52650d, i10);
        if (iM67287a >= 0) {
            this.f52649c[iM67287a] = e10;
            return;
        }
        int i11 = ~iM67287a;
        int i12 = this.f52650d;
        if (i11 < i12) {
            Object[] objArr = this.f52649c;
            if (objArr[i11] == f52646e) {
                this.f52648b[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (this.f52647a && i12 >= this.f52648b.length) {
            m67339f();
            i11 = ~C11209c.m67287a(this.f52648b, this.f52650d, i10);
        }
        int i13 = this.f52650d;
        if (i13 >= this.f52648b.length) {
            int iM67291e = C11209c.m67291e(i13 + 1);
            int[] iArr = new int[iM67291e];
            Object[] objArr2 = new Object[iM67291e];
            int[] iArr2 = this.f52648b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f52649c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f52648b = iArr;
            this.f52649c = objArr2;
        }
        int i14 = this.f52650d;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.f52648b;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.f52649c;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f52650d - i11);
        }
        this.f52648b[i11] = i10;
        this.f52649c[i11] = e10;
        this.f52650d++;
    }

    /* renamed from: m */
    public void m67345m(int i10) {
        Object[] objArr = this.f52649c;
        Object obj = objArr[i10];
        Object obj2 = f52646e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f52647a = true;
        }
    }

    /* renamed from: n */
    public int m67346n() {
        if (this.f52647a) {
            m67339f();
        }
        return this.f52650d;
    }

    /* renamed from: o */
    public E m67347o(int i10) {
        if (this.f52647a) {
            m67339f();
        }
        return (E) this.f52649c[i10];
    }

    public String toString() {
        if (m67346n() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f52650d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f52650d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(m67343k(i10));
            sb2.append('=');
            E eM67347o = m67347o(i10);
            if (eM67347o != this) {
                sb2.append(eM67347o);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public C11214h(int i10) {
        this.f52647a = false;
        if (i10 == 0) {
            this.f52648b = C11209c.f52608a;
            this.f52649c = C11209c.f52610c;
        } else {
            int iM67291e = C11209c.m67291e(i10);
            this.f52648b = new int[iM67291e];
            this.f52649c = new Object[iM67291e];
        }
    }
}
