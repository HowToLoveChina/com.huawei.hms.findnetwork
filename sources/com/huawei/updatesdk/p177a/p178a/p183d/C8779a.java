package com.huawei.updatesdk.p177a.p178a.p183d;

import com.huawei.hms.network.embedded.C5929g4;

/* renamed from: com.huawei.updatesdk.a.a.d.a */
/* loaded from: classes9.dex */
public class C8779a {

    /* renamed from: a */
    private static final char[] f45071a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', C5929g4.f26852n, '='};

    /* renamed from: a */
    public static String m56032a(byte[] bArr) {
        return m56033a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static String m56033a(byte[] bArr, int i10) {
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
            char[] cArr2 = f45071a;
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
        return String.valueOf(cArr);
    }
}
