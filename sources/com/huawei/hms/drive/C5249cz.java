package com.huawei.hms.drive;

import java.io.IOException;
import p022ay.C1057g;

/* renamed from: com.huawei.hms.drive.cz */
/* loaded from: classes8.dex */
public final class C5249cz {

    /* renamed from: a */
    static final C1057g f24297a = C1057g.m6364k("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: d */
    private static final String[] f24300d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: b */
    static final String[] f24298b = new String[64];

    /* renamed from: c */
    static final String[] f24299c = new String[256];

    static {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = f24299c;
            if (i11 >= strArr.length) {
                break;
            }
            strArr[i11] = C5210bo.m31181a("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
            i11++;
        }
        String[] strArr2 = f24298b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i12 = iArr[0];
        strArr2[i12 | 8] = strArr2[i12] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i13 = 0; i13 < 3; i13++) {
            int i14 = iArr2[i13];
            int i15 = iArr[0];
            String[] strArr3 = f24298b;
            int i16 = i15 | i14;
            strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
            strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f24298b;
            if (i10 >= strArr4.length) {
                return;
            }
            if (strArr4[i10] == null) {
                strArr4[i10] = f24299c[i10];
            }
            i10++;
        }
    }

    private C5249cz() {
    }

    /* renamed from: a */
    public static IllegalArgumentException m31483a(String str, Object... objArr) {
        throw new IllegalArgumentException(C5210bo.m31181a(str, objArr));
    }

    /* renamed from: b */
    public static IOException m31486b(String str, Object... objArr) throws IOException {
        throw new IOException(C5210bo.m31181a(str, objArr));
    }

    /* renamed from: a */
    public static String m31485a(boolean z10, int i10, int i11, byte b10, byte b11) {
        String[] strArr = f24300d;
        String strM31181a = b10 < strArr.length ? strArr[b10] : C5210bo.m31181a("0x%02x", Byte.valueOf(b10));
        String strM31484a = m31484a(b10, b11);
        Object[] objArr = new Object[5];
        objArr[0] = z10 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i10);
        objArr[2] = Integer.valueOf(i11);
        objArr[3] = strM31181a;
        objArr[4] = strM31484a;
        return C5210bo.m31181a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    public static String m31484a(byte b10, byte b11) {
        if (b11 == 0) {
            return "";
        }
        if (b10 != 2 && b10 != 3) {
            if (b10 == 4 || b10 == 6) {
                return b11 == 1 ? "ACK" : f24299c[b11];
            }
            if (b10 != 7 && b10 != 8) {
                String[] strArr = f24298b;
                String str = b11 < strArr.length ? strArr[b11] : f24299c[b11];
                if (b10 != 5 || (b11 & 4) == 0) {
                    return (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f24299c[b11];
    }
}
