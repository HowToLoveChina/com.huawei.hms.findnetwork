package com.huawei.android.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;

/* renamed from: com.huawei.android.brotli.dec.i */
/* loaded from: classes.dex */
public class C2169i {

    /* renamed from: a */
    public static final byte[] f9863a = new byte[1024];

    /* renamed from: b */
    public static final int[] f9864b = new int[1024];

    /* renamed from: a */
    public static void m13272a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* renamed from: b */
    public static void m13273b(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(bArr, i11, bArr, i10, i12 - i11);
    }

    /* renamed from: c */
    public static void m13274c(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            int iMin = Math.min(i10 + 1024, i11) - i10;
            System.arraycopy(f9863a, 0, bArr, i10, iMin);
            i10 += iMin;
        }
    }

    /* renamed from: d */
    public static void m13275d(int[] iArr, int i10, int i11) {
        while (i10 < i11) {
            int iMin = Math.min(i10 + 1024, i11) - i10;
            System.arraycopy(f9864b, 0, iArr, i10, iMin);
            i10 += iMin;
        }
    }

    /* renamed from: e */
    public static void m13276e(Buffer buffer) {
        buffer.flip();
    }

    /* renamed from: f */
    public static int m13277f(InputStream inputStream, byte[] bArr, int i10, int i11) {
        try {
            return inputStream.read(bArr, i10, i11);
        } catch (IOException e10) {
            throw new C2163c("Failed to read input", e10);
        }
    }

    /* renamed from: g */
    public static byte[] m13278g(String str) {
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }
}
