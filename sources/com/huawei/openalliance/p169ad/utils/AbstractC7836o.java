package com.huawei.openalliance.p169ad.utils;

/* renamed from: com.huawei.openalliance.ad.utils.o */
/* loaded from: classes2.dex */
public abstract class AbstractC7836o {

    /* renamed from: a */
    private static final char[] f36135a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    /* renamed from: b */
    private static byte[] f36136b = new byte[256];

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            f36136b[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            f36136b[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            f36136b[i12] = (byte) (i12 - 71);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            f36136b[i13] = (byte) (i13 + 4);
        }
        byte[] bArr = f36136b;
        bArr[43] = 62;
        bArr[45] = 63;
    }

    /* renamed from: a */
    public static String m48492a(byte[] bArr) {
        return m48493a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static String m48493a(byte[] bArr, int i10) {
        boolean z10;
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
            char[] cArr2 = f36135a;
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
