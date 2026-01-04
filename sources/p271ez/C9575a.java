package p271ez;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ez.a */
/* loaded from: classes9.dex */
public final class C9575a {

    /* renamed from: ez.a$a */
    public static class a<T> implements Iterator<T> {

        /* renamed from: a */
        public final T[] f47671a;

        /* renamed from: b */
        public int f47672b = 0;

        public a(T[] tArr) {
            this.f47671a = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47672b < this.f47671a.length;
        }

        @Override // java.util.Iterator
        public T next() {
            int i10 = this.f47672b;
            T[] tArr = this.f47671a;
            if (i10 != tArr.length) {
                this.f47672b = i10 + 1;
                return tArr[i10];
            }
            throw new NoSuchElementException("Out of elements: " + this.f47672b);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    /* renamed from: a */
    public static boolean m59758a(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    /* renamed from: b */
    public static byte[] m59759b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    /* renamed from: c */
    public static byte[] m59760c(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return m59759b(bArr2);
        }
        if (bArr2 == null) {
            return m59759b(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: d */
    public static byte[] m59761d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return m59760c(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return m59760c(bArr, bArr3);
        }
        if (bArr3 == null) {
            return m59760c(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return bArr4;
    }

    /* renamed from: e */
    public static void m59762e(byte[] bArr, byte b10) {
        Arrays.fill(bArr, b10);
    }

    /* renamed from: f */
    public static int m59763f(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * 257) ^ bArr[length];
        }
    }

    /* renamed from: g */
    public static int m59764g(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            return 0;
        }
        int i12 = i11 + 1;
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12;
            }
            i12 = (i12 * 257) ^ bArr[i10 + i11];
        }
    }

    /* renamed from: h */
    public static byte[] m59765h(byte[] bArr, byte b10) {
        if (bArr == null) {
            return new byte[]{b10};
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 1, length);
        bArr2[0] = b10;
        return bArr2;
    }
}
