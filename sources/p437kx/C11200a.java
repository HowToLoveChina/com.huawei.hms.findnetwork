package p437kx;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import p502nx.EnumC11766f;
import p594qx.C12424c;

/* renamed from: kx.a */
/* loaded from: classes9.dex */
public class C11200a extends RandomAccessFile {

    /* renamed from: a */
    public long f52519a;

    /* renamed from: b */
    public File[] f52520b;

    /* renamed from: c */
    public RandomAccessFile f52521c;

    /* renamed from: d */
    public byte[] f52522d;

    /* renamed from: e */
    public int f52523e;

    /* renamed from: f */
    public String f52524f;

    public C11200a(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.f52522d = new byte[1];
        this.f52523e = 0;
        super.close();
        if (EnumC11766f.WRITE.m70095b().equals(str)) {
            throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
        }
        m67209b(fileArr);
        this.f52521c = new RandomAccessFile(file, str);
        this.f52520b = fileArr;
        this.f52519a = file.length();
        this.f52524f = str;
    }

    /* renamed from: b */
    public final void m67209b(File[] fileArr) throws IOException {
        int i10 = 1;
        for (File file : fileArr) {
            String strM74580h = C12424c.m74580h(file);
            try {
                if (i10 != Integer.parseInt(strM74580h)) {
                    throw new IOException("Split file number " + i10 + " does not exist");
                }
                i10++;
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + strM74580h + " expected of format: .001, .002, etc");
            }
        }
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.f52521c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        super.close();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() throws IOException {
        return this.f52521c.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long length() throws IOException {
        return this.f52521c.length();
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        if (read(this.f52522d) == -1) {
            return -1;
        }
        return this.f52522d[0] & 255;
    }

    /* renamed from: s */
    public void m67210s() throws IOException {
        m67211t(this.f52520b.length - 1);
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j10) throws IOException {
        int i10 = (int) (j10 / this.f52519a);
        if (i10 != this.f52523e) {
            m67211t(i10);
        }
        this.f52521c.seek(j10 - (i10 * this.f52519a));
    }

    /* renamed from: t */
    public final void m67211t(int i10) throws IOException {
        if (this.f52523e == i10) {
            return;
        }
        if (i10 > this.f52520b.length - 1) {
            throw new IOException("split counter greater than number of split files");
        }
        RandomAccessFile randomAccessFile = this.f52521c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.f52521c = new RandomAccessFile(this.f52520b[i10], this.f52524f);
        this.f52523e = i10;
    }

    /* renamed from: u */
    public void m67212u(long j10) throws IOException {
        this.f52521c.seek(j10);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i10) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f52521c.read(bArr, i10, i11);
        if (i12 != -1) {
            return i12;
        }
        int i13 = this.f52523e;
        if (i13 == this.f52520b.length - 1) {
            return -1;
        }
        m67211t(i13 + 1);
        return read(bArr, i10, i11);
    }
}
