package com.huawei.cloud.base.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.util.e */
/* loaded from: classes.dex */
public final class C4634e {
    /* renamed from: a */
    public static long m28406a(InputStream inputStream, OutputStream outputStream) throws IOException {
        C4627a0.m28391d(inputStream);
        C4627a0.m28391d(outputStream);
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += i10;
        }
    }

    /* renamed from: b */
    public static InputStream m28407b(InputStream inputStream, long j10) {
        return new a(inputStream, j10);
    }

    /* renamed from: com.huawei.cloud.base.util.e$a */
    public static final class a extends FilterInputStream {

        /* renamed from: a */
        public long f21269a;

        /* renamed from: b */
        public long f21270b;

        public a(InputStream inputStream, long j10) {
            super(inputStream);
            this.f21270b = -1L;
            C4627a0.m28391d(inputStream);
            C4627a0.m28389b(j10 >= 0, "limit must be non-negative");
            this.f21269a = j10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f21269a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.f21270b = this.f21269a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f21269a == 0) {
                return -1;
            }
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 != -1) {
                this.f21269a--;
            }
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f21270b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f21269a = this.f21270b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j10, this.f21269a));
            this.f21269a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            long j10 = this.f21269a;
            if (j10 == 0) {
                return -1;
            }
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, (int) Math.min(i11, j10));
            if (i12 != -1) {
                this.f21269a -= i12;
            }
            return i12;
        }
    }
}
