package com.huawei.hms.support.log.common;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;

/* loaded from: classes8.dex */
public final class Base64 {

    /* renamed from: a */
    private static final char[] f30119a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', C5929g4.f26852n, '='};

    /* renamed from: b */
    private static final byte[] f30120b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, BaseType.Float, BaseType.Double, 13, BaseType.Vector, BaseType.Obj, BaseType.Union, BaseType.Array, BaseType.Vector64, BaseType.MaxBaseType, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.f29565i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private Base64() {
    }

    /* renamed from: a */
    private static int m36990a(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt > 255 || f30120b[cCharAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return new byte[0];
        }
        int iM36990a = m36990a(str);
        int i10 = (iM36990a / 4) * 3;
        int i11 = iM36990a % 4;
        if (i11 == 3) {
            i10 += 2;
        }
        if (i11 == 2) {
            i10++;
        }
        byte[] bArr = new byte[i10];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char cCharAt = str.charAt(i15);
            byte b10 = cCharAt > 255 ? (byte) -1 : f30120b[cCharAt];
            if (b10 >= 0) {
                int i16 = i14 + 6;
                i13 = (i13 << 6) | b10;
                if (i16 >= 8) {
                    i14 -= 2;
                    bArr[i12] = (byte) (255 & (i13 >> i14));
                    i12++;
                } else {
                    i14 = i16;
                }
            }
        }
        return i12 != i10 ? new byte[0] : bArr;
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? "" : encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i10) {
        boolean z10;
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[((i10 + 2) / 3) * 4];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = (bArr[i11] & 255) << 8;
            int i14 = i11 + 1;
            boolean z11 = true;
            if (i14 < i10) {
                i13 |= bArr[i14] & 255;
                z10 = true;
            } else {
                z10 = false;
            }
            int i15 = i13 << 8;
            int i16 = i11 + 2;
            if (i16 < i10) {
                i15 |= bArr[i16] & 255;
            } else {
                z11 = false;
            }
            int i17 = i12 + 3;
            char[] cArr2 = f30119a;
            int i18 = 64;
            cArr[i17] = cArr2[z11 ? i15 & 63 : 64];
            int i19 = i15 >> 6;
            int i20 = i12 + 2;
            if (z10) {
                i18 = i19 & 63;
            }
            cArr[i20] = cArr2[i18];
            cArr[i12 + 1] = cArr2[(i15 >> 12) & 63];
            cArr[i12] = cArr2[(i15 >> 18) & 63];
            i11 += 3;
            i12 += 4;
        }
        return new String(cArr);
    }
}
