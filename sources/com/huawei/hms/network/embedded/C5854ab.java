package com.huawei.hms.network.embedded;

import com.google.flatbuffers.reflection.BaseType;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.hms.network.embedded.ab */
/* loaded from: classes8.dex */
public final class C5854ab {

    /* renamed from: a */
    public static final byte[] f26378a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    public static final byte[] f26379b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: a */
    public static String m33836a(byte[] bArr) {
        return m33837a(bArr, f26378a);
    }

    /* renamed from: b */
    public static String m33839b(byte[] bArr) {
        return m33837a(bArr, f26379b);
    }

    /* renamed from: a */
    public static String m33837a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 3) {
            bArr3[i10] = bArr2[(bArr[i11] & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i10 + 1] = bArr2[((bArr[i11] & 3) << 4) | ((bArr[i12] & 255) >> 4)];
            int i13 = i10 + 3;
            int i14 = (bArr[i12] & BaseType.Obj) << 2;
            int i15 = i11 + 2;
            bArr3[i10 + 2] = bArr2[i14 | ((bArr[i15] & 255) >> 6)];
            i10 += 4;
            bArr3[i13] = bArr2[bArr[i15] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            bArr3[i10 + 1] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i10 + 2] = 61;
            bArr3[i10 + 3] = 61;
        } else if (length2 == 2) {
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            int i16 = (bArr[length] & 3) << 4;
            int i17 = length + 1;
            bArr3[i10 + 1] = bArr2[((bArr[i17] & 255) >> 4) | i16];
            bArr3[i10 + 2] = bArr2[(bArr[i17] & BaseType.Obj) << 2];
            bArr3[i10 + 3] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: a */
    public static byte[] m33838a(String str) {
        int i10;
        char cCharAt;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char cCharAt2 = str.charAt(i15);
            if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                i10 = cCharAt2 - 'A';
            } else if (cCharAt2 >= 'a' && cCharAt2 <= 'z') {
                i10 = cCharAt2 - 'G';
            } else if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                i10 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i10 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i10 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i14 = (i14 << 6) | ((byte) i10);
            i12++;
            if (i12 % 4 == 0) {
                bArr[i13] = (byte) (i14 >> 16);
                int i16 = i13 + 2;
                bArr[i13 + 1] = (byte) (i14 >> 8);
                i13 += 3;
                bArr[i16] = (byte) i14;
            }
        }
        int i17 = i12 % 4;
        if (i17 == 1) {
            return null;
        }
        if (i17 == 2) {
            bArr[i13] = (byte) ((i14 << 12) >> 16);
            i13++;
        } else if (i17 == 3) {
            int i18 = i14 << 6;
            int i19 = i13 + 1;
            bArr[i13] = (byte) (i18 >> 16);
            i13 += 2;
            bArr[i19] = (byte) (i18 >> 8);
        }
        if (i13 == i11) {
            return bArr;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, 0, bArr2, 0, i13);
        return bArr2;
    }
}
