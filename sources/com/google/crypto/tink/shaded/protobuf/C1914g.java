package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.g */
/* loaded from: classes.dex */
public final class C1914g extends AbstractC1902c<Boolean> implements C1900b0.a, RandomAccess, InterfaceC1901b1 {

    /* renamed from: d */
    public static final C1914g f9141d;

    /* renamed from: b */
    public boolean[] f9142b;

    /* renamed from: c */
    public int f9143c;

    static {
        C1914g c1914g = new C1914g(new boolean[0], 0);
        f9141d = c1914g;
        c1914g.mo11500s();
    }

    public C1914g() {
        this(new boolean[10], 0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        m11501a();
        C1900b0.m11486a(collection);
        if (!(collection instanceof C1914g)) {
            return super.addAll(collection);
        }
        C1914g c1914g = (C1914g) collection;
        int i10 = c1914g.f9143c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f9143c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.f9142b;
        if (i12 > zArr.length) {
            this.f9142b = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(c1914g.f9142b, 0, this.f9142b, this.f9143c, c1914g.f9143c);
        this.f9143c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Boolean bool) {
        m11646d(i10, bool.booleanValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        m11647e(bool.booleanValue());
        return true;
    }

    /* renamed from: d */
    public final void m11646d(int i10, boolean z10) {
        int i11;
        m11501a();
        if (i10 < 0 || i10 > (i11 = this.f9143c)) {
            throw new IndexOutOfBoundsException(m11651i(i10));
        }
        boolean[] zArr = this.f9142b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f9142b, i10, zArr2, i10 + 1, this.f9143c - i10);
            this.f9142b = zArr2;
        }
        this.f9142b[i10] = z10;
        this.f9143c++;
        ((AbstractList) this).modCount++;
    }

    /* renamed from: e */
    public void m11647e(boolean z10) {
        m11501a();
        int i10 = this.f9143c;
        boolean[] zArr = this.f9142b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f9142b = zArr2;
        }
        boolean[] zArr3 = this.f9142b;
        int i11 = this.f9143c;
        this.f9143c = i11 + 1;
        zArr3[i11] = z10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1914g)) {
            return super.equals(obj);
        }
        C1914g c1914g = (C1914g) obj;
        if (this.f9143c != c1914g.f9143c) {
            return false;
        }
        boolean[] zArr = c1914g.f9142b;
        for (int i10 = 0; i10 < this.f9143c; i10++) {
            if (this.f9142b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final void m11648f(int i10) {
        if (i10 < 0 || i10 >= this.f9143c) {
            throw new IndexOutOfBoundsException(m11651i(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i10) {
        return Boolean.valueOf(m11650h(i10));
    }

    /* renamed from: h */
    public boolean m11650h(int i10) {
        m11648f(i10);
        return this.f9142b[i10];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iM11488c = 1;
        for (int i10 = 0; i10 < this.f9143c; i10++) {
            iM11488c = (iM11488c * 31) + C1900b0.m11488c(this.f9142b[i10]);
        }
        return iM11488c;
    }

    /* renamed from: i */
    public final String m11651i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f9143c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1900b0.a mo11479v(int i10) {
        if (i10 >= this.f9143c) {
            return new C1914g(Arrays.copyOf(this.f9142b, i10), this.f9143c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i10) {
        m11501a();
        m11648f(i10);
        boolean[] zArr = this.f9142b;
        boolean z10 = zArr[i10];
        if (i10 < this.f9143c - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.f9143c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(m11655m(i10, bool.booleanValue()));
    }

    /* renamed from: m */
    public boolean m11655m(int i10, boolean z10) {
        m11501a();
        m11648f(i10);
        boolean[] zArr = this.f9142b;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        m11501a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f9142b;
        System.arraycopy(zArr, i11, zArr, i10, this.f9143c - i11);
        this.f9143c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9143c;
    }

    public C1914g(boolean[] zArr, int i10) {
        this.f9142b = zArr;
        this.f9143c = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        m11501a();
        for (int i10 = 0; i10 < this.f9143c; i10++) {
            if (obj.equals(Boolean.valueOf(this.f9142b[i10]))) {
                boolean[] zArr = this.f9142b;
                System.arraycopy(zArr, i10 + 1, zArr, i10, (this.f9143c - i10) - 1);
                this.f9143c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
