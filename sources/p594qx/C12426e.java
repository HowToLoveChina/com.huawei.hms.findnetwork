package p594qx;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* renamed from: qx.e */
/* loaded from: classes9.dex */
public class C12426e {

    /* renamed from: a */
    public final byte[] f57267a = new byte[2];

    /* renamed from: b */
    public final byte[] f57268b = new byte[4];

    /* renamed from: c */
    public final byte[] f57269c = new byte[8];

    /* renamed from: a */
    public int m74596a(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f57268b);
        return m74597b(this.f57268b);
    }

    /* renamed from: b */
    public int m74597b(byte[] bArr) {
        return m74598c(bArr, 0);
    }

    /* renamed from: c */
    public int m74598c(byte[] bArr, int i10) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((((bArr[i10 + 3] & 255) << 8) | (bArr[i10 + 2] & 255)) << 16);
    }

    /* renamed from: d */
    public long m74599d(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f57269c);
        return m74601f(this.f57269c, 0);
    }

    /* renamed from: e */
    public long m74600e(RandomAccessFile randomAccessFile, int i10) throws IOException {
        m74604i(this.f57269c);
        randomAccessFile.readFully(this.f57269c, 0, i10);
        return m74601f(this.f57269c, 0);
    }

    /* renamed from: f */
    public long m74601f(byte[] bArr, int i10) {
        if (bArr.length - i10 < 8) {
            m74604i(this.f57269c);
        }
        System.arraycopy(bArr, i10, this.f57269c, 0, Math.min(bArr.length - i10, 8));
        byte[] bArr2 = this.f57269c;
        return ((((((((((((((bArr2[7] & 255) << 8) | (bArr2[6] & 255)) << 8) | (bArr2[5] & 255)) << 8) | (bArr2[4] & 255)) << 8) | (bArr2[3] & 255)) << 8) | (bArr2[2] & 255)) << 8) | (bArr2[1] & 255)) << 8) | (bArr2[0] & 255);
    }

    /* renamed from: g */
    public int m74602g(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f57267a);
        return m74603h(this.f57267a, 0);
    }

    /* renamed from: h */
    public int m74603h(byte[] bArr, int i10) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8);
    }

    /* renamed from: i */
    public final void m74604i(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }

    /* renamed from: j */
    public void m74605j(OutputStream outputStream, int i10) throws IOException {
        m74606k(this.f57268b, 0, i10);
        outputStream.write(this.f57268b);
    }

    /* renamed from: k */
    public void m74606k(byte[] bArr, int i10, int i11) {
        bArr[i10 + 3] = (byte) (i11 >>> 24);
        bArr[i10 + 2] = (byte) (i11 >>> 16);
        bArr[i10 + 1] = (byte) (i11 >>> 8);
        bArr[i10] = (byte) (i11 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: l */
    public void m74607l(OutputStream outputStream, long j10) throws IOException {
        m74608m(this.f57269c, 0, j10);
        outputStream.write(this.f57269c);
    }

    /* renamed from: m */
    public void m74608m(byte[] bArr, int i10, long j10) {
        bArr[i10 + 7] = (byte) (j10 >>> 56);
        bArr[i10 + 6] = (byte) (j10 >>> 48);
        bArr[i10 + 5] = (byte) (j10 >>> 40);
        bArr[i10 + 4] = (byte) (j10 >>> 32);
        bArr[i10 + 3] = (byte) (j10 >>> 24);
        bArr[i10 + 2] = (byte) (j10 >>> 16);
        bArr[i10 + 1] = (byte) (j10 >>> 8);
        bArr[i10] = (byte) (j10 & 255);
    }

    /* renamed from: n */
    public void m74609n(OutputStream outputStream, int i10) throws IOException {
        m74610o(this.f57267a, 0, i10);
        outputStream.write(this.f57267a);
    }

    /* renamed from: o */
    public void m74610o(byte[] bArr, int i10, int i11) {
        bArr[i10 + 1] = (byte) (i11 >>> 8);
        bArr[i10] = (byte) (i11 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }
}
