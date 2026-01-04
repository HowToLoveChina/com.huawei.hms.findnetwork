package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.j0 */
/* loaded from: classes.dex */
public final class C1924j0 extends AbstractC1902c<Long> implements C1900b0.h, RandomAccess, InterfaceC1901b1 {

    /* renamed from: d */
    public static final C1924j0 f9176d;

    /* renamed from: b */
    public long[] f9177b;

    /* renamed from: c */
    public int f9178c;

    static {
        C1924j0 c1924j0 = new C1924j0(new long[0], 0);
        f9176d = c1924j0;
        c1924j0.mo11500s();
    }

    public C1924j0() {
        this(new long[10], 0);
    }

    /* renamed from: f */
    private void m11761f(int i10) {
        if (i10 < 0 || i10 >= this.f9178c) {
            throw new IndexOutOfBoundsException(m11762i(i10));
        }
    }

    /* renamed from: i */
    private String m11762i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f9178c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        m11501a();
        C1900b0.m11486a(collection);
        if (!(collection instanceof C1924j0)) {
            return super.addAll(collection);
        }
        C1924j0 c1924j0 = (C1924j0) collection;
        int i10 = c1924j0.f9178c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f9178c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f9177b;
        if (i12 > jArr.length) {
            this.f9177b = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(c1924j0.f9177b, 0, this.f9177b, this.f9178c, c1924j0.f9178c);
        this.f9178c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Long l10) {
        m11765d(i10, l10.longValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l10) {
        m11766e(l10.longValue());
        return true;
    }

    /* renamed from: d */
    public final void m11765d(int i10, long j10) {
        int i11;
        m11501a();
        if (i10 < 0 || i10 > (i11 = this.f9178c)) {
            throw new IndexOutOfBoundsException(m11762i(i10));
        }
        long[] jArr = this.f9177b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f9177b, i10, jArr2, i10 + 1, this.f9178c - i10);
            this.f9177b = jArr2;
        }
        this.f9177b[i10] = j10;
        this.f9178c++;
        ((AbstractList) this).modCount++;
    }

    /* renamed from: e */
    public void m11766e(long j10) {
        m11501a();
        int i10 = this.f9178c;
        long[] jArr = this.f9177b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f9177b = jArr2;
        }
        long[] jArr3 = this.f9177b;
        int i11 = this.f9178c;
        this.f9178c = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1924j0)) {
            return super.equals(obj);
        }
        C1924j0 c1924j0 = (C1924j0) obj;
        if (this.f9178c != c1924j0.f9178c) {
            return false;
        }
        long[] jArr = c1924j0.f9177b;
        for (int i10 = 0; i10 < this.f9178c; i10++) {
            if (this.f9177b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Long get(int i10) {
        return Long.valueOf(m11768h(i10));
    }

    /* renamed from: h */
    public long m11768h(int i10) {
        m11761f(i10);
        return this.f9177b[i10];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iM11491f = 1;
        for (int i10 = 0; i10 < this.f9178c; i10++) {
            iM11491f = (iM11491f * 31) + C1900b0.m11491f(this.f9177b[i10]);
        }
        return iM11491f;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1900b0.h mo11479v(int i10) {
        if (i10 >= this.f9178c) {
            return new C1924j0(Arrays.copyOf(this.f9177b, i10), this.f9178c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Long remove(int i10) {
        m11501a();
        m11761f(i10);
        long[] jArr = this.f9177b;
        long j10 = jArr[i10];
        if (i10 < this.f9178c - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f9178c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Long set(int i10, Long l10) {
        return Long.valueOf(m11772m(i10, l10.longValue()));
    }

    /* renamed from: m */
    public long m11772m(int i10, long j10) {
        m11501a();
        m11761f(i10);
        long[] jArr = this.f9177b;
        long j11 = jArr[i10];
        jArr[i10] = j10;
        return j11;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        m11501a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f9177b;
        System.arraycopy(jArr, i11, jArr, i10, this.f9178c - i11);
        this.f9178c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9178c;
    }

    public C1924j0(long[] jArr, int i10) {
        this.f9177b = jArr;
        this.f9178c = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        m11501a();
        for (int i10 = 0; i10 < this.f9178c; i10++) {
            if (obj.equals(Long.valueOf(this.f9177b[i10]))) {
                long[] jArr = this.f9177b;
                System.arraycopy(jArr, i10 + 1, jArr, i10, (this.f9178c - i10) - 1);
                this.f9178c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
