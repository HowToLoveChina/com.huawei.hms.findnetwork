package com.huawei.android.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.android.brotli.dec.b */
/* loaded from: classes.dex */
public class C2162b extends InputStream {

    /* renamed from: a */
    public byte[] f9782a;

    /* renamed from: b */
    public int f9783b;

    /* renamed from: c */
    public int f9784c;

    /* renamed from: d */
    public final C2167g f9785d;

    public C2162b(InputStream inputStream) throws IOException {
        this(inputStream, 256);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C2165e.m13242c(this.f9785d);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f9784c >= this.f9783b) {
            byte[] bArr = this.f9782a;
            int i10 = read(bArr, 0, bArr.length);
            this.f9783b = i10;
            this.f9784c = 0;
            if (i10 == -1) {
                return -1;
            }
        }
        byte[] bArr2 = this.f9782a;
        int i11 = this.f9784c;
        this.f9784c = i11 + 1;
        return bArr2[i11] & 255;
    }

    public C2162b(InputStream inputStream, int i10) throws IOException {
        C2167g c2167g = new C2167g();
        this.f9785d = c2167g;
        if (i10 <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i10);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.f9782a = new byte[i10];
        this.f9783b = 0;
        this.f9784c = 0;
        try {
            C2165e.m13254o(c2167g, inputStream);
        } catch (C2163c e10) {
            throw new IOException("Brotli decoder initialization failed", e10);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i10 < 0) {
            throw new IllegalArgumentException("Bad offset: " + i10);
        }
        if (i11 >= 0) {
            int i12 = i10 + i11;
            if (i12 > bArr.length) {
                throw new IllegalArgumentException("Buffer overflow: " + i12 + " > " + bArr.length);
            }
            if (i11 == 0) {
                return 0;
            }
            int iMax = Math.max(this.f9783b - this.f9784c, 0);
            if (iMax != 0) {
                iMax = Math.min(iMax, i11);
                System.arraycopy(this.f9782a, this.f9784c, bArr, i10, iMax);
                this.f9784c += iMax;
                i10 += iMax;
                i11 -= iMax;
                if (i11 == 0) {
                    return iMax;
                }
            }
            try {
                C2167g c2167g = this.f9785d;
                c2167g.f9835e = bArr;
                c2167g.f9828a0 = i10;
                c2167g.f9830b0 = i11;
                c2167g.f9832c0 = 0;
                C2165e.m13253n(c2167g);
                int i13 = this.f9785d.f9832c0;
                if (i13 == 0) {
                    return -1;
                }
                return i13 + iMax;
            } catch (C2163c e10) {
                throw new IOException("Brotli stream decoding failed", e10);
            }
        }
        throw new IllegalArgumentException("Bad length: " + i11);
    }
}
