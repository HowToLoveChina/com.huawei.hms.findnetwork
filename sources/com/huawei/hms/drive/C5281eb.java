package com.huawei.hms.drive;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* renamed from: com.huawei.hms.drive.eb */
/* loaded from: classes8.dex */
public class C5281eb {
    /* renamed from: a */
    private static byte[] m31712a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    /* renamed from: b */
    public static String m31713b(byte[] bArr) {
        return m31710a(bArr, StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    public static byte[] m31711a(String str) {
        return m31712a(str, StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    private static String m31710a(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    /* renamed from: a */
    public static String m31709a(byte[] bArr) {
        return m31710a(bArr, StandardCharsets.US_ASCII);
    }
}
