package ly;

import java.nio.charset.StandardCharsets;

/* renamed from: ly.a */
/* loaded from: classes9.dex */
public class C11367a {
    /* renamed from: a */
    public static boolean m68205a(byte[] bArr, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m68206b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13, boolean z10) {
        int iMin = Math.min(i11, i13);
        for (int i14 = 0; i14 < iMin; i14++) {
            if (bArr[i10 + i14] != bArr2[i12 + i14]) {
                return false;
            }
        }
        if (i11 == i13) {
            return true;
        }
        if (!z10) {
            return false;
        }
        if (i11 > i13) {
            while (i13 < i11) {
                if (bArr[i10 + i13] != 0) {
                    return false;
                }
                i13++;
            }
        } else {
            while (i11 < i13) {
                if (bArr2[i12 + i11] != 0) {
                    return false;
                }
                i11++;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m68207c(String str, byte[] bArr, int i10, int i11) {
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        return m68206b(bytes, 0, bytes.length, bArr, i10, i11, false);
    }
}
