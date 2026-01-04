package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.x */
/* loaded from: classes.dex */
public final class C1964x extends AbstractC1902c<Float> implements C1900b0.f, RandomAccess, InterfaceC1901b1 {

    /* renamed from: d */
    public static final C1964x f9418d;

    /* renamed from: b */
    public float[] f9419b;

    /* renamed from: c */
    public int f9420c;

    static {
        C1964x c1964x = new C1964x(new float[0], 0);
        f9418d = c1964x;
        c1964x.mo11500s();
    }

    public C1964x() {
        this(new float[10], 0);
    }

    /* renamed from: f */
    private void m12363f(int i10) {
        if (i10 < 0 || i10 >= this.f9420c) {
            throw new IndexOutOfBoundsException(m12364i(i10));
        }
    }

    /* renamed from: i */
    private String m12364i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f9420c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        m11501a();
        C1900b0.m11486a(collection);
        if (!(collection instanceof C1964x)) {
            return super.addAll(collection);
        }
        C1964x c1964x = (C1964x) collection;
        int i10 = c1964x.f9420c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f9420c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.f9419b;
        if (i12 > fArr.length) {
            this.f9419b = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(c1964x.f9419b, 0, this.f9419b, this.f9420c, c1964x.f9420c);
        this.f9420c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Float f10) {
        m12368e(i10, f10.floatValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f10) {
        m12367d(f10.floatValue());
        return true;
    }

    /* renamed from: d */
    public void m12367d(float f10) {
        m11501a();
        int i10 = this.f9420c;
        float[] fArr = this.f9419b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f9419b = fArr2;
        }
        float[] fArr3 = this.f9419b;
        int i11 = this.f9420c;
        this.f9420c = i11 + 1;
        fArr3[i11] = f10;
    }

    /* renamed from: e */
    public final void m12368e(int i10, float f10) {
        int i11;
        m11501a();
        if (i10 < 0 || i10 > (i11 = this.f9420c)) {
            throw new IndexOutOfBoundsException(m12364i(i10));
        }
        float[] fArr = this.f9419b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f9419b, i10, fArr2, i10 + 1, this.f9420c - i10);
            this.f9419b = fArr2;
        }
        this.f9419b[i10] = f10;
        this.f9420c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1964x)) {
            return super.equals(obj);
        }
        C1964x c1964x = (C1964x) obj;
        if (this.f9420c != c1964x.f9420c) {
            return false;
        }
        float[] fArr = c1964x.f9419b;
        for (int i10 = 0; i10 < this.f9420c; i10++) {
            if (Float.floatToIntBits(this.f9419b[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Float get(int i10) {
        return Float.valueOf(m12370h(i10));
    }

    /* renamed from: h */
    public float m12370h(int i10) {
        m12363f(i10);
        return this.f9419b[i10];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.f9420c; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f9419b[i10]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1900b0.f mo11479v(int i10) {
        if (i10 >= this.f9420c) {
            return new C1964x(Arrays.copyOf(this.f9419b, i10), this.f9420c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Float remove(int i10) {
        m11501a();
        m12363f(i10);
        float[] fArr = this.f9419b;
        float f10 = fArr[i10];
        if (i10 < this.f9420c - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.f9420c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Float set(int i10, Float f10) {
        return Float.valueOf(m12374m(i10, f10.floatValue()));
    }

    /* renamed from: m */
    public float m12374m(int i10, float f10) {
        m11501a();
        m12363f(i10);
        float[] fArr = this.f9419b;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        m11501a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f9419b;
        System.arraycopy(fArr, i11, fArr, i10, this.f9420c - i11);
        this.f9420c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9420c;
    }

    public C1964x(float[] fArr, int i10) {
        this.f9419b = fArr;
        this.f9420c = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        m11501a();
        for (int i10 = 0; i10 < this.f9420c; i10++) {
            if (obj.equals(Float.valueOf(this.f9419b[i10]))) {
                float[] fArr = this.f9419b;
                System.arraycopy(fArr, i10 + 1, fArr, i10, (this.f9420c - i10) - 1);
                this.f9420c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
