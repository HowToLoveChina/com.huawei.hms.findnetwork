package com.huawei.hicloud.base.slice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class LimitedInputStream extends InputStream {
    private int count;
    private FileInputStream fin;
    private long limit;
    private long offset;

    public LimitedInputStream(FileInputStream fileInputStream, long j10, long j11) throws IOException {
        this.fin = fileInputStream;
        this.limit = j11;
        this.offset = j10;
        fileInputStream.getChannel().position(j10);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fin.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i10;
        if (this.count >= this.limit || (i10 = this.fin.read()) == -1) {
            return -1;
        }
        this.count++;
        return i10;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.count = 0;
        this.fin.getChannel().position(this.offset);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.count;
        long j10 = i12;
        long j11 = this.limit;
        if (j10 >= j11) {
            return -1;
        }
        long j12 = j11 - i12;
        if (j12 < i11) {
            i11 = (int) j12;
        }
        int i13 = this.fin.read(bArr, i10, i11);
        if (i13 == -1) {
            return -1;
        }
        this.count += i13;
        return i13;
    }
}
