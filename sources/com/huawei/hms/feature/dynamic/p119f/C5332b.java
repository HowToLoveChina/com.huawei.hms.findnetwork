package com.huawei.hms.feature.dynamic.p119f;

import com.google.flatbuffers.reflection.BaseType;

/* renamed from: com.huawei.hms.feature.dynamic.f.b */
/* loaded from: classes8.dex */
public final class C5332b {

    /* renamed from: a */
    public static final char[] f24714a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final char[] f24715b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static char[] m31888a(byte[] bArr) {
        return m31889a(bArr, false);
    }

    /* renamed from: b */
    public static String m31891b(byte[] bArr, boolean z10) {
        return new String(m31889a(bArr, z10));
    }

    /* renamed from: a */
    public static char[] m31889a(byte[] bArr, boolean z10) {
        return m31890a(bArr, z10 ? f24715b : f24714a);
    }

    /* renamed from: a */
    public static char[] m31890a(byte[] bArr, char[] cArr) {
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
