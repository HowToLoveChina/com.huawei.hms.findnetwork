package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.n */
/* loaded from: classes.dex */
public final class C1935n extends AbstractC1902c<Double> implements C1900b0.b, RandomAccess, InterfaceC1901b1 {

    /* renamed from: d */
    public static final C1935n f9229d;

    /* renamed from: b */
    public double[] f9230b;

    /* renamed from: c */
    public int f9231c;

    static {
        C1935n c1935n = new C1935n(new double[0], 0);
        f9229d = c1935n;
        c1935n.mo11500s();
    }

    public C1935n() {
        this(new double[10], 0);
    }

    /* renamed from: f */
    private void m12037f(int i10) {
        if (i10 < 0 || i10 >= this.f9231c) {
            throw new IndexOutOfBoundsException(m12038i(i10));
        }
    }

    /* renamed from: i */
    private String m12038i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f9231c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        m11501a();
        C1900b0.m11486a(collection);
        if (!(collection instanceof C1935n)) {
            return super.addAll(collection);
        }
        C1935n c1935n = (C1935n) collection;
        int i10 = c1935n.f9231c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f9231c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.f9230b;
        if (i12 > dArr.length) {
            this.f9230b = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy(c1935n.f9230b, 0, this.f9230b, this.f9231c, c1935n.f9231c);
        this.f9231c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Double d10) {
        m12042e(i10, d10.doubleValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d10) {
        m12041d(d10.doubleValue());
        return true;
    }

    /* renamed from: d */
    public void m12041d(double d10) {
        m11501a();
        int i10 = this.f9231c;
        double[] dArr = this.f9230b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f9230b = dArr2;
        }
        double[] dArr3 = this.f9230b;
        int i11 = this.f9231c;
        this.f9231c = i11 + 1;
        dArr3[i11] = d10;
    }

    /* renamed from: e */
    public final void m12042e(int i10, double d10) {
        int i11;
        m11501a();
        if (i10 < 0 || i10 > (i11 = this.f9231c)) {
            throw new IndexOutOfBoundsException(m12038i(i10));
        }
        double[] dArr = this.f9230b;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.f9230b, i10, dArr2, i10 + 1, this.f9231c - i10);
            this.f9230b = dArr2;
        }
        this.f9230b[i10] = d10;
        this.f9231c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1935n)) {
            return super.equals(obj);
        }
        C1935n c1935n = (C1935n) obj;
        if (this.f9231c != c1935n.f9231c) {
            return false;
        }
        double[] dArr = c1935n.f9230b;
        for (int i10 = 0; i10 < this.f9231c; i10++) {
            if (Double.doubleToLongBits(this.f9230b[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Double get(int i10) {
        return Double.valueOf(m12044h(i10));
    }

    /* renamed from: h */
    public double m12044h(int i10) {
        m12037f(i10);
        return this.f9230b[i10];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iM11491f = 1;
        for (int i10 = 0; i10 < this.f9231c; i10++) {
            iM11491f = (iM11491f * 31) + C1900b0.m11491f(Double.doubleToLongBits(this.f9230b[i10]));
        }
        return iM11491f;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1900b0.b mo11479v(int i10) {
        if (i10 >= this.f9231c) {
            return new C1935n(Arrays.copyOf(this.f9230b, i10), this.f9231c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Double remove(int i10) {
        m11501a();
        m12037f(i10);
        double[] dArr = this.f9230b;
        double d10 = dArr[i10];
        if (i10 < this.f9231c - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.f9231c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Double set(int i10, Double d10) {
        return Double.valueOf(m12048m(i10, d10.doubleValue()));
    }

    /* renamed from: m */
    public double m12048m(int i10, double d10) {
        m11501a();
        m12037f(i10);
        double[] dArr = this.f9230b;
        double d11 = dArr[i10];
        dArr[i10] = d10;
        return d11;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        m11501a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f9230b;
        System.arraycopy(dArr, i11, dArr, i10, this.f9231c - i11);
        this.f9231c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9231c;
    }

    public C1935n(double[] dArr, int i10) {
        this.f9230b = dArr;
        this.f9231c = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        m11501a();
        for (int i10 = 0; i10 < this.f9231c; i10++) {
            if (obj.equals(Double.valueOf(this.f9230b[i10]))) {
                double[] dArr = this.f9230b;
                System.arraycopy(dArr, i10 + 1, dArr, i10, (this.f9231c - i10) - 1);
                this.f9231c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
