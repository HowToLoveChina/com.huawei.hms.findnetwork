package p462lx;

import com.huawei.hms.network.embedded.C6144wb;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import p376ix.C10631a;
import p409jx.EnumC10954c;
import p502nx.EnumC11766f;
import p594qx.C12424c;
import p594qx.C12426e;

/* renamed from: lx.h */
/* loaded from: classes9.dex */
public class C11362h extends OutputStream implements InterfaceC11361g {

    /* renamed from: a */
    public RandomAccessFile f53070a;

    /* renamed from: b */
    public long f53071b;

    /* renamed from: c */
    public File f53072c;

    /* renamed from: d */
    public int f53073d;

    /* renamed from: e */
    public long f53074e;

    /* renamed from: f */
    public C12426e f53075f;

    public C11362h(File file) throws C10631a, FileNotFoundException {
        this(file, -1L);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f53070a.close();
    }

    /* renamed from: d */
    public boolean m68181d(int i10) throws C10631a {
        if (i10 < 0) {
            throw new C10631a("negative buffersize for checkBufferSizeAndStartNextSplitFile");
        }
        if (m68183v(i10)) {
            return false;
        }
        try {
            m68187z();
            this.f53074e = 0L;
            return true;
        } catch (IOException e10) {
            throw new C10631a(e10);
        }
    }

    @Override // p462lx.InterfaceC11361g
    /* renamed from: s */
    public int mo68173s() {
        return this.f53073d;
    }

    public void seek(long j10) throws IOException {
        this.f53070a.seek(j10);
    }

    @Override // p462lx.InterfaceC11361g
    /* renamed from: t */
    public long mo68174t() throws IOException {
        return this.f53070a.getFilePointer();
    }

    /* renamed from: u */
    public long m68182u() {
        return this.f53071b;
    }

    /* renamed from: v */
    public final boolean m68183v(int i10) {
        long j10 = this.f53071b;
        return j10 < C6144wb.f28903a || this.f53074e + ((long) i10) <= j10;
    }

    /* renamed from: w */
    public final boolean m68184w(byte[] bArr) {
        int iM74597b = this.f53075f.m74597b(bArr);
        for (EnumC10954c enumC10954c : EnumC10954c.values()) {
            if (enumC10954c != EnumC10954c.SPLIT_ZIP && enumC10954c.m66102b() == iM74597b) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }

    /* renamed from: x */
    public boolean m68185x() {
        return this.f53071b != -1;
    }

    /* renamed from: y */
    public int m68186y(int i10) throws IOException {
        return this.f53070a.skipBytes(i10);
    }

    /* renamed from: z */
    public final void m68187z() throws IOException {
        String str;
        String strM74587o = C12424c.m74587o(this.f53072c.getName());
        String absolutePath = this.f53072c.getAbsolutePath();
        if (this.f53072c.getParent() == null) {
            str = "";
        } else {
            str = this.f53072c.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.f53073d + 1);
        if (this.f53073d >= 9) {
            str2 = ".z" + (this.f53073d + 1);
        }
        File file = new File(str + strM74587o + str2);
        this.f53070a.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        }
        if (!this.f53072c.renameTo(file)) {
            throw new IOException("cannot rename newly created split file");
        }
        this.f53072c = new File(absolutePath);
        this.f53070a = new RandomAccessFile(this.f53072c, EnumC11766f.WRITE.m70095b());
        this.f53073d++;
    }

    public C11362h(File file, long j10) throws C10631a, FileNotFoundException {
        this.f53075f = new C12426e();
        if (j10 >= 0 && j10 < C6144wb.f28903a) {
            throw new C10631a("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.f53070a = new RandomAccessFile(file, EnumC11766f.WRITE.m70095b());
        this.f53071b = j10;
        this.f53072c = file;
        this.f53073d = 0;
        this.f53074e = 0L;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 <= 0) {
            return;
        }
        long j10 = this.f53071b;
        if (j10 == -1) {
            this.f53070a.write(bArr, i10, i11);
            this.f53074e += i11;
            return;
        }
        long j11 = this.f53074e;
        if (j11 >= j10) {
            m68187z();
            this.f53070a.write(bArr, i10, i11);
            this.f53074e = i11;
            return;
        }
        long j12 = i11;
        if (j11 + j12 > j10) {
            if (m68184w(bArr)) {
                m68187z();
                this.f53070a.write(bArr, i10, i11);
                this.f53074e = j12;
                return;
            }
            this.f53070a.write(bArr, i10, (int) (this.f53071b - this.f53074e));
            m68187z();
            RandomAccessFile randomAccessFile = this.f53070a;
            long j13 = this.f53071b;
            long j14 = this.f53074e;
            randomAccessFile.write(bArr, i10 + ((int) (j13 - j14)), (int) (j12 - (j13 - j14)));
            this.f53074e = j12 - (this.f53071b - this.f53074e);
            return;
        }
        this.f53070a.write(bArr, i10, i11);
        this.f53074e += j12;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
