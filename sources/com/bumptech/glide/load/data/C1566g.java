package com.bumptech.glide.load.data;

import com.google.flatbuffers.reflection.BaseType;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.data.g */
/* loaded from: classes.dex */
public final class C1566g extends FilterInputStream {

    /* renamed from: c */
    public static final byte[] f6949c;

    /* renamed from: d */
    public static final int f6950d;

    /* renamed from: e */
    public static final int f6951e;

    /* renamed from: a */
    public final byte f6952a;

    /* renamed from: b */
    public int f6953b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, BaseType.Vector64, 0, 2, 0, 0, 0, 1, 0};
        f6949c = bArr;
        int length = bArr.length;
        f6950d = length;
        f6951e = length + 2;
    }

    public C1566g(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 >= -1 && i10 <= 8) {
            this.f6952a = (byte) i10;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10;
        int i11 = this.f6953b;
        int i12 = (i11 < 2 || i11 > (i10 = f6951e)) ? super.read() : i11 == i10 ? this.f6952a : f6949c[i11 - 2] & 255;
        if (i12 != -1) {
            this.f6953b++;
        }
        return i12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long jSkip = super.skip(j10);
        if (jSkip > 0) {
            this.f6953b = (int) (this.f6953b + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f6953b;
        int i14 = f6951e;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f6952a;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int iMin = Math.min(i14 - i13, i11);
            System.arraycopy(f6949c, this.f6953b - 2, bArr, i10, iMin);
            i12 = iMin;
        }
        if (i12 > 0) {
            this.f6953b += i12;
        }
        return i12;
    }
}
