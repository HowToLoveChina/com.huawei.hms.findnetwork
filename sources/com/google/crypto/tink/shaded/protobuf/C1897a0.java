package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.a0 */
/* loaded from: classes.dex */
public final class C1897a0 extends AbstractC1902c<Integer> implements C1900b0.g, RandomAccess, InterfaceC1901b1 {

    /* renamed from: d */
    public static final C1897a0 f9081d;

    /* renamed from: b */
    public int[] f9082b;

    /* renamed from: c */
    public int f9083c;

    static {
        C1897a0 c1897a0 = new C1897a0(new int[0], 0);
        f9081d = c1897a0;
        c1897a0.mo11500s();
    }

    public C1897a0() {
        this(new int[10], 0);
    }

    /* renamed from: f */
    private void m11467f(int i10) {
        if (i10 < 0 || i10 >= this.f9083c) {
            throw new IndexOutOfBoundsException(m11468i(i10));
        }
    }

    /* renamed from: i */
    private String m11468i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f9083c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        m11501a();
        C1900b0.m11486a(collection);
        if (!(collection instanceof C1897a0)) {
            return super.addAll(collection);
        }
        C1897a0 c1897a0 = (C1897a0) collection;
        int i10 = c1897a0.f9083c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f9083c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f9082b;
        if (i12 > iArr.length) {
            this.f9082b = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(c1897a0.f9082b, 0, this.f9082b, this.f9083c, c1897a0.f9083c);
        this.f9083c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Integer num) {
        m11472e(i10, num.intValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        m11471d(num.intValue());
        return true;
    }

    /* renamed from: d */
    public void m11471d(int i10) {
        m11501a();
        int i11 = this.f9083c;
        int[] iArr = this.f9082b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f9082b = iArr2;
        }
        int[] iArr3 = this.f9082b;
        int i12 = this.f9083c;
        this.f9083c = i12 + 1;
        iArr3[i12] = i10;
    }

    /* renamed from: e */
    public final void m11472e(int i10, int i11) {
        int i12;
        m11501a();
        if (i10 < 0 || i10 > (i12 = this.f9083c)) {
            throw new IndexOutOfBoundsException(m11468i(i10));
        }
        int[] iArr = this.f9082b;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f9082b, i10, iArr2, i10 + 1, this.f9083c - i10);
            this.f9082b = iArr2;
        }
        this.f9082b[i10] = i11;
        this.f9083c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1897a0)) {
            return super.equals(obj);
        }
        C1897a0 c1897a0 = (C1897a0) obj;
        if (this.f9083c != c1897a0.f9083c) {
            return false;
        }
        int[] iArr = c1897a0.f9082b;
        for (int i10 = 0; i10 < this.f9083c; i10++) {
            if (this.f9082b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Integer get(int i10) {
        return Integer.valueOf(m11474h(i10));
    }

    /* renamed from: h */
    public int m11474h(int i10) {
        m11467f(i10);
        return this.f9082b[i10];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f9083c; i11++) {
            i10 = (i10 * 31) + this.f9082b[i11];
        }
        return i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1900b0.g mo11479v(int i10) {
        if (i10 >= this.f9083c) {
            return new C1897a0(Arrays.copyOf(this.f9082b, i10), this.f9083c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i10) {
        m11501a();
        m11467f(i10);
        int[] iArr = this.f9082b;
        int i11 = iArr[i10];
        if (i10 < this.f9083c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f9083c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Integer set(int i10, Integer num) {
        return Integer.valueOf(m11478m(i10, num.intValue()));
    }

    /* renamed from: m */
    public int m11478m(int i10, int i11) {
        m11501a();
        m11467f(i10);
        int[] iArr = this.f9082b;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        m11501a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f9082b;
        System.arraycopy(iArr, i11, iArr, i10, this.f9083c - i11);
        this.f9083c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9083c;
    }

    public C1897a0(int[] iArr, int i10) {
        this.f9082b = iArr;
        this.f9083c = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        m11501a();
        for (int i10 = 0; i10 < this.f9083c; i10++) {
            if (obj.equals(Integer.valueOf(this.f9082b[i10]))) {
                int[] iArr = this.f9082b;
                System.arraycopy(iArr, i10 + 1, iArr, i10, (this.f9083c - i10) - 1);
                this.f9083c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
