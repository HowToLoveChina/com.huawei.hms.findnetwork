package mk;

/* renamed from: mk.a */
/* loaded from: classes6.dex */
public final class C11475a {

    /* renamed from: a */
    public static final byte[] f53382a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    public static final byte[] f53383b = new byte[128];

    static {
        for (int i10 = 0; i10 < 128; i10++) {
            f53383b[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            f53383b[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            f53383b[i12] = (byte) (i12 - 71);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            f53383b[i13] = (byte) (i13 + 4);
        }
        byte[] bArr = f53383b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    /* renamed from: a */
    public static byte[] m68618a(byte[] bArr) {
        int i10 = 0;
        if (bArr == null) {
            return new byte[0];
        }
        int length = bArr.length % 3;
        byte[] bArr2 = length == 0 ? new byte[(bArr.length * 4) / 3] : new byte[((bArr.length / 3) + 1) * 4];
        int length2 = bArr.length - length;
        int i11 = 0;
        while (i10 < length2) {
            int i12 = bArr[i10] & 255;
            int i13 = bArr[i10 + 1] & 255;
            byte b10 = bArr[i10 + 2];
            byte[] bArr3 = f53382a;
            bArr2[i11] = bArr3[(i12 >>> 2) & 63];
            bArr2[i11 + 1] = bArr3[((i12 << 4) | (i13 >>> 4)) & 63];
            bArr2[i11 + 2] = bArr3[((i13 << 2) | ((b10 & 255) >>> 6)) & 63];
            bArr2[i11 + 3] = bArr3[b10 & 63];
            i10 += 3;
            i11 += 4;
        }
        if (length == 1) {
            int i14 = bArr[bArr.length - 1] & 255;
            int length3 = bArr2.length - 4;
            byte[] bArr4 = f53382a;
            bArr2[length3] = bArr4[(i14 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr4[(i14 << 4) & 63];
            bArr2[bArr2.length - 2] = 61;
            bArr2[bArr2.length - 1] = 61;
        } else if (length == 2) {
            int i15 = bArr[bArr.length - 2] & 255;
            int i16 = bArr[bArr.length - 1] & 255;
            int length4 = bArr2.length - 4;
            byte[] bArr5 = f53382a;
            bArr2[length4] = bArr5[(i15 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr5[((i15 << 4) | (i16 >>> 4)) & 63];
            bArr2[bArr2.length - 2] = bArr5[(i16 << 2) & 63];
            bArr2[bArr2.length - 1] = 61;
        }
        return bArr2;
    }
}
