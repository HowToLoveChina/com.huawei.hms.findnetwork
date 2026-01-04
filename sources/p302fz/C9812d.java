package p302fz;

import com.google.flatbuffers.reflection.BaseType;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: fz.d */
/* loaded from: classes9.dex */
public class C9812d {

    /* renamed from: a */
    public final byte[] f48233a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    public final byte[] f48234b = new byte[128];

    public C9812d() {
        m60991d();
    }

    /* renamed from: a */
    public byte[] m60988a(String str, int i10, int i11) throws IOException {
        if (str == null) {
            throw new NullPointerException("'str' cannot be null");
        }
        if (i10 < 0 || i11 < 0 || i10 > str.length() - i11) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i11 & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int i12 = i11 >>> 1;
        byte[] bArr = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i10 + 1;
            byte b10 = this.f48234b[str.charAt(i10)];
            i10 += 2;
            int i15 = (b10 << 4) | this.f48234b[str.charAt(i14)];
            if (i15 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bArr[i13] = (byte) i15;
        }
        return bArr;
    }

    /* renamed from: b */
    public int m60989b(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        if (i11 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(36, i12);
            outputStream.write(bArr2, 0, m60990c(bArr, i10, iMin, bArr2, 0));
            i10 += iMin;
            i12 -= iMin;
        }
        return i11 * 2;
    }

    /* renamed from: c */
    public int m60990c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IOException {
        int i13 = i11 + i10;
        int i14 = i12;
        while (i10 < i13) {
            int i15 = i10 + 1;
            byte b10 = bArr[i10];
            int i16 = i14 + 1;
            byte[] bArr3 = this.f48233a;
            bArr2[i14] = bArr3[(b10 & 255) >>> 4];
            i14 += 2;
            bArr2[i16] = bArr3[b10 & BaseType.Obj];
            i10 = i15;
        }
        return i14 - i12;
    }

    /* renamed from: d */
    public void m60991d() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f48234b;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = this.f48233a;
            if (i10 >= bArr2.length) {
                byte[] bArr3 = this.f48234b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.f48234b[bArr2[i10]] = (byte) i10;
            i10++;
        }
    }
}
