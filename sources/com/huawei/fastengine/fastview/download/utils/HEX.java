package com.huawei.fastengine.fastview.download.utils;

import com.google.flatbuffers.reflection.BaseType;

/* loaded from: classes5.dex */
public final class HEX {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z10) {
        return new String(encodeHex(bArr, z10));
    }

    public static char[] encodeHex(byte[] bArr, boolean z10) {
        return encodeHex(bArr, z10 ? DIGITS_UPPER : DIGITS_LOWER);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
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
}
