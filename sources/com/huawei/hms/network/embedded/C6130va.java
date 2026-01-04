package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5868bb;

/* renamed from: com.huawei.hms.network.embedded.va */
/* loaded from: classes8.dex */
public final class C6130va {

    /* renamed from: a */
    public static final String f28774a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b */
    public static final int f28775b = 128;

    /* renamed from: c */
    public static final int f28776c = 64;

    /* renamed from: d */
    public static final int f28777d = 32;

    /* renamed from: e */
    public static final int f28778e = 16;

    /* renamed from: f */
    public static final int f28779f = 15;

    /* renamed from: g */
    public static final int f28780g = 8;

    /* renamed from: h */
    public static final int f28781h = 128;

    /* renamed from: i */
    public static final int f28782i = 127;

    /* renamed from: j */
    public static final int f28783j = 0;

    /* renamed from: k */
    public static final int f28784k = 1;

    /* renamed from: l */
    public static final int f28785l = 2;

    /* renamed from: m */
    public static final int f28786m = 8;

    /* renamed from: n */
    public static final int f28787n = 9;

    /* renamed from: o */
    public static final int f28788o = 10;

    /* renamed from: p */
    public static final long f28789p = 125;

    /* renamed from: q */
    public static final long f28790q = 123;

    /* renamed from: r */
    public static final int f28791r = 126;

    /* renamed from: s */
    public static final long f28792s = 65535;

    /* renamed from: t */
    public static final int f28793t = 127;

    /* renamed from: u */
    public static final int f28794u = 1001;

    /* renamed from: v */
    public static final int f28795v = 1005;

    public C6130va() {
        throw new AssertionError("No instances.");
    }

    /* renamed from: a */
    public static String m35696a(int i10) {
        StringBuilder sb2;
        if (i10 < 1000 || i10 >= 5000) {
            sb2 = new StringBuilder();
            sb2.append("Code must be in range [1000,5000): ");
            sb2.append(i10);
        } else {
            if ((i10 < 1004 || i10 > 1006) && (i10 < 1012 || i10 > 2999)) {
                return null;
            }
            sb2 = new StringBuilder();
            sb2.append("Code ");
            sb2.append(i10);
            sb2.append(" is reserved and may not be used.");
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static void m35699b(int i10) {
        String strM35696a = m35696a(i10);
        if (strM35696a != null) {
            throw new IllegalArgumentException(strM35696a);
        }
    }

    /* renamed from: a */
    public static String m35697a(String str) {
        return C5910eb.m34157d(str + f28774a).mo34188g().mo34175b();
    }

    /* renamed from: a */
    public static void m35698a(C5868bb.c cVar, byte[] bArr) {
        int length = bArr.length;
        int i10 = 0;
        do {
            byte[] bArr2 = cVar.f26531e;
            int i11 = cVar.f26532f;
            int i12 = cVar.f26533g;
            while (i11 < i12) {
                int i13 = i10 % length;
                bArr2[i11] = (byte) (bArr2[i11] ^ bArr[i13]);
                i11++;
                i10 = i13 + 1;
            }
        } while (cVar.m33994s() != -1);
    }
}
