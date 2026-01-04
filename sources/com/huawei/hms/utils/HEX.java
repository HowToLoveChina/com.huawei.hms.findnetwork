package com.huawei.hms.utils;

import com.google.flatbuffers.reflection.BaseType;

/* loaded from: classes8.dex */
public final class HEX {

    /* renamed from: a */
    private static final char[] f30161a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final char[] f30162b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    /* renamed from: a */
    private static char[] m37006a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return new char[0];
        }
        char[] cArr2 = new char[bArr.length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 & 240) >>> 4];
            i10 += 2;
            cArr2[i11] = cArr[b10 & BaseType.Obj];
        }
        return cArr2;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z10) {
        return new String(encodeHex(bArr, z10));
    }

    public static char[] encodeHex(byte[] bArr, boolean z10) {
        return m37006a(bArr, z10 ? f30162b : f30161a);
    }
}
