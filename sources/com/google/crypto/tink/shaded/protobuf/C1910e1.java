package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.e1 */
/* loaded from: classes.dex */
public final class C1910e1<E> extends AbstractC1902c<E> implements RandomAccess {

    /* renamed from: d */
    public static final C1910e1<Object> f9122d;

    /* renamed from: b */
    public E[] f9123b;

    /* renamed from: c */
    public int f9124c;

    static {
        C1910e1<Object> c1910e1 = new C1910e1<>(new Object[0], 0);
        f9122d = c1910e1;
        c1910e1.mo11500s();
    }

    public C1910e1(E[] eArr, int i10) {
        this.f9123b = eArr;
        this.f9124c = i10;
    }

    /* renamed from: b */
    public static <E> E[] m11564b(int i10) {
        return (E[]) new Object[i10];
    }

    /* renamed from: c */
    public static <E> C1910e1<E> m11565c() {
        return (C1910e1<E>) f9122d;
    }

    /* renamed from: d */
    private void m11566d(int i10) {
        if (i10 < 0 || i10 >= this.f9124c) {
            throw new IndexOutOfBoundsException(m11567e(i10));
        }
    }

    /* renamed from: e */
    private String m11567e(int i10) {
        return "Index:" + i10 + ", Size:" + this.f9124c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        m11501a();
        int i10 = this.f9124c;
        E[] eArr = this.f9123b;
        if (i10 == eArr.length) {
            this.f9123b = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f9123b;
        int i11 = this.f9124c;
        this.f9124c = i11 + 1;
        eArr2[i11] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C1910e1<E> mo11479v(int i10) {
        if (i10 >= this.f9124c) {
            return new C1910e1<>(Arrays.copyOf(this.f9123b, i10), this.f9124c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        m11566d(i10);
        return this.f9123b[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        m11501a();
        m11566d(i10);
        E[] eArr = this.f9123b;
        E e10 = eArr[i10];
        if (i10 < this.f9124c - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.f9124c--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        m11501a();
        m11566d(i10);
        E[] eArr = this.f9123b;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9124c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        int i11;
        m11501a();
        if (i10 >= 0 && i10 <= (i11 = this.f9124c)) {
            E[] eArr = this.f9123b;
            if (i11 < eArr.length) {
                System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
            } else {
                E[] eArr2 = (E[]) m11564b(((i11 * 3) / 2) + 1);
                System.arraycopy(this.f9123b, 0, eArr2, 0, i10);
                System.arraycopy(this.f9123b, i10, eArr2, i10 + 1, this.f9124c - i10);
                this.f9123b = eArr2;
            }
            this.f9123b[i10] = e10;
            this.f9124c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m11567e(i10));
    }
}
