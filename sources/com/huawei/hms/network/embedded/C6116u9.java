package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.u9 */
/* loaded from: classes8.dex */
public final class C6116u9 {

    /* renamed from: b */
    public static final int f28525b = 16384;

    /* renamed from: c */
    public static final byte f28526c = 0;

    /* renamed from: d */
    public static final byte f28527d = 1;

    /* renamed from: e */
    public static final byte f28528e = 2;

    /* renamed from: f */
    public static final byte f28529f = 3;

    /* renamed from: g */
    public static final byte f28530g = 4;

    /* renamed from: h */
    public static final byte f28531h = 5;

    /* renamed from: i */
    public static final byte f28532i = 6;

    /* renamed from: j */
    public static final byte f28533j = 7;

    /* renamed from: k */
    public static final byte f28534k = 8;

    /* renamed from: l */
    public static final byte f28535l = 9;

    /* renamed from: m */
    public static final byte f28536m = 0;

    /* renamed from: n */
    public static final byte f28537n = 1;

    /* renamed from: o */
    public static final byte f28538o = 1;

    /* renamed from: p */
    public static final byte f28539p = 4;

    /* renamed from: q */
    public static final byte f28540q = 4;

    /* renamed from: r */
    public static final byte f28541r = 8;

    /* renamed from: s */
    public static final byte f28542s = 32;

    /* renamed from: t */
    public static final byte f28543t = 32;

    /* renamed from: a */
    public static final C5910eb f28524a = C5910eb.m34157d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: u */
    public static final String[] f28544u = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: v */
    public static final String[] f28545v = new String[64];

    /* renamed from: w */
    public static final String[] f28546w = new String[256];

    static {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = f28546w;
            if (i11 >= strArr.length) {
                break;
            }
            strArr[i11] = C5920f8.m34236a("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
            i11++;
        }
        String[] strArr2 = f28545v;
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
            String[] strArr3 = f28545v;
            int i16 = i15 | i14;
            strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
            strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f28545v;
            if (i10 >= strArr4.length) {
                return;
            }
            if (strArr4[i10] == null) {
                strArr4[i10] = f28546w[i10];
            }
            i10++;
        }
    }

    /* renamed from: a */
    public static IllegalArgumentException m35511a(String str, Object... objArr) {
        throw new IllegalArgumentException(C5920f8.m34236a(str, objArr));
    }

    /* renamed from: b */
    public static IOException m35514b(String str, Object... objArr) throws IOException {
        throw new IOException(C5920f8.m34236a(str, objArr));
    }

    /* renamed from: a */
    public static String m35512a(byte b10, byte b11) {
        if (b11 == 0) {
            return "";
        }
        if (b10 != 2 && b10 != 3) {
            if (b10 == 4 || b10 == 6) {
                return b11 == 1 ? "ACK" : f28546w[b11];
            }
            if (b10 != 7 && b10 != 8) {
                String[] strArr = f28545v;
                String str = b11 < strArr.length ? strArr[b11] : f28546w[b11];
                return (b10 != 5 || (b11 & 4) == 0) ? (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f28546w[b11];
    }

    /* renamed from: a */
    public static String m35513a(boolean z10, int i10, int i11, byte b10, byte b11) {
        String[] strArr = f28544u;
        String strM34236a = b10 < strArr.length ? strArr[b10] : C5920f8.m34236a("0x%02x", Byte.valueOf(b10));
        String strM35512a = m35512a(b10, b11);
        Object[] objArr = new Object[5];
        objArr[0] = z10 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i10);
        objArr[2] = Integer.valueOf(i11);
        objArr[3] = strM34236a;
        objArr[4] = strM35512a;
        return C5920f8.m34236a("%s 0x%08x %5d %-13s %s", objArr);
    }
}
