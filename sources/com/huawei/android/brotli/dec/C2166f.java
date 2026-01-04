package com.huawei.android.brotli.dec;

/* renamed from: com.huawei.android.brotli.dec.f */
/* loaded from: classes.dex */
public class C2166f {
    /* renamed from: a */
    public static void m13266a(int[] iArr, int i10, int i11, int[] iArr2, int i12) {
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int iM13267b = 0;
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr2[i13];
            iArr4[i14] = iArr4[i14] + 1;
        }
        iArr5[1] = 0;
        int i15 = 1;
        while (i15 < 15) {
            int i16 = i15 + 1;
            iArr5[i16] = iArr5[i15] + iArr4[i15];
            i15 = i16;
        }
        for (int i17 = 0; i17 < i12; i17++) {
            int i18 = iArr2[i17];
            if (i18 != 0) {
                int i19 = iArr5[i18];
                iArr5[i18] = i19 + 1;
                iArr3[i19] = i17;
            }
        }
        int i20 = 1 << i11;
        if (iArr5[15] == 1) {
            for (int i21 = 0; i21 < i20; i21++) {
                iArr[i10 + i21] = iArr3[0];
            }
            return;
        }
        int i22 = 2;
        int i23 = 2;
        int i24 = 0;
        int i25 = 1;
        while (i25 <= i11) {
            while (iArr4[i25] > 0) {
                m13269d(iArr, i10 + iM13267b, i23, i20, iArr3[i24] | (i25 << 16));
                iM13267b = m13267b(iM13267b, i25);
                iArr4[i25] = iArr4[i25] - 1;
                i24++;
            }
            i25++;
            i23 <<= 1;
        }
        int i26 = i20 - 1;
        int i27 = i11 + 1;
        int i28 = -1;
        int i29 = i10;
        while (i27 <= 15) {
            while (iArr4[i27] > 0) {
                int i30 = iM13267b & i26;
                if (i30 != i28) {
                    i29 += i20;
                    int iM13268c = m13268c(iArr4, i27, i11);
                    iArr[i10 + i30] = ((iM13268c + i11) << 16) | ((i29 - i10) - i30);
                    i20 = 1 << iM13268c;
                    i28 = i30;
                }
                m13269d(iArr, (iM13267b >> i11) + i29, i22, i20, ((i27 - i11) << 16) | iArr3[i24]);
                iM13267b = m13267b(iM13267b, i27);
                iArr4[i27] = iArr4[i27] - 1;
                i24++;
            }
            i27++;
            i22 <<= 1;
        }
    }

    /* renamed from: b */
    public static int m13267b(int i10, int i11) {
        int i12 = 1 << (i11 - 1);
        while ((i10 & i12) != 0) {
            i12 >>= 1;
        }
        return (i10 & (i12 - 1)) + i12;
    }

    /* renamed from: c */
    public static int m13268c(int[] iArr, int i10, int i11) {
        int i12;
        int i13 = 1 << (i10 - i11);
        while (i10 < 15 && (i12 = i13 - iArr[i10]) > 0) {
            i10++;
            i13 = i12 << 1;
        }
        return i10 - i11;
    }

    /* renamed from: d */
    public static void m13269d(int[] iArr, int i10, int i11, int i12, int i13) {
        do {
            i12 -= i11;
            iArr[i10 + i12] = i13;
        } while (i12 > 0);
    }
}
