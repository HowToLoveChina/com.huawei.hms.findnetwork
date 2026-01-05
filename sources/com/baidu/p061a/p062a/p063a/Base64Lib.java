package com.baidu.p061a.p062a.p063a;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.UnsupportedEncodingException;

/* renamed from: com.baidu.a.a.a.a */
/* loaded from: classes.dex */
public final class Base64Lib {

    /* renamed from: a */
    private static final byte[] f6512a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64Lib() {
    }

    /* renamed from: a */
    public static String Base64Encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[length + (length / 76) + 3];
        int length2 = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length2; i12 += 3) {
            byte[] bArr3 = f6512a;
            bArr2[i10] = bArr3[(bArr[i12] & 255) >> 2];
            int i13 = i12 + 1;
            bArr2[i10 + 1] = bArr3[((bArr[i12] & 3) << 4) | ((bArr[i13] & 255) >> 4)];
            int i14 = i12 + 2;
            bArr2[i10 + 2] = bArr3[((bArr[i13] & BaseType.Obj) << 2) | ((bArr[i14] & 255) >> 6)];
            int i15 = i10 + 4;
            bArr2[i10 + 3] = bArr3[bArr[i14] & 63];
            if ((i15 - i11) % 76 != 0 || i15 == 0) {
                i10 = i15;
            } else {
                i10 += 5;
                bArr2[i15] = 10;
                i11++;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            byte[] bArr4 = f6512a;
            bArr2[i10] = bArr4[(bArr[length2] & 255) >> 2];
            bArr2[i10 + 1] = bArr4[(bArr[length2] & 3) << 4];
            int i16 = i10 + 3;
            bArr2[i10 + 2] = 61;
            i10 += 4;
            bArr2[i16] = 61;
        } else if (length3 == 2) {
            byte[] bArr5 = f6512a;
            bArr2[i10] = bArr5[(bArr[length2] & 255) >> 2];
            int i17 = (bArr[length2] & 3) << 4;
            int i18 = length2 + 1;
            bArr2[i10 + 1] = bArr5[((bArr[i18] & 255) >> 4) | i17];
            int i19 = i10 + 3;
            bArr2[i10 + 2] = bArr5[(bArr[i18] & BaseType.Obj) << 2];
            i10 += 4;
            bArr2[i19] = 61;
        }
        return new String(bArr2, 0, i10, str);
    }

    /* renamed from: a */
    public static byte[] Base64Decode(byte[] bArr) {
        return Base64Decode(bArr, bArr.length);
    }

    /* renamed from: a */
    public static byte[] Base64Decode(byte[] bArr, int i10) {
        byte b10;
        int i11;
        int i12 = (i10 / 4) * 3;
        if (i12 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i12];
        int i13 = i10;
        int i14 = 0;
        while (true) {
            byte b11 = bArr[i13 - 1];
            b10 = 10;
            if (b11 != 10 && b11 != 13 && b11 != 32 && b11 != 9) {
                if (b11 != 61) {
                    break;
                }
                i14++;
            }
            i13--;
        }
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i15 < i13) {
            byte b12 = bArr[i15];
            if (b12 != b10 && b12 != 13 && b12 != 32 && b12 != 9) {
                if (b12 >= 65 && b12 <= 90) {
                    i11 = b12 - 65;
                } else if (b12 >= 97 && b12 <= 122) {
                    i11 = b12 - 71;
                } else if (b12 >= 48 && b12 <= 57) {
                    i11 = b12 + 4;
                } else if (b12 == 43) {
                    i11 = 62;
                } else {
                    if (b12 != 47) {
                        return null;
                    }
                    i11 = 63;
                }
                i16 = ((byte) i11) | (i16 << 6);
                if (i18 % 4 == 3) {
                    bArr2[i17] = (byte) ((16711680 & i16) >> 16);
                    int i19 = i17 + 2;
                    bArr2[i17 + 1] = (byte) ((65280 & i16) >> 8);
                    i17 += 3;
                    bArr2[i19] = (byte) (i16 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                }
                i18++;
            }
            i15++;
            b10 = 10;
        }
        if (i14 > 0) {
            int i20 = i16 << (i14 * 6);
            int i21 = i17 + 1;
            bArr2[i17] = (byte) ((i20 & 16711680) >> 16);
            if (i14 == 1) {
                i17 += 2;
                bArr2[i21] = (byte) ((i20 & 65280) >> 8);
            } else {
                i17 = i21;
            }
        }
        byte[] bArr3 = new byte[i17];
        System.arraycopy(bArr2, 0, bArr3, 0, i17);
        return bArr3;
    }
}
