package p302fz;

import java.io.ByteArrayOutputStream;
import p271ez.C9580f;

/* renamed from: fz.c */
/* loaded from: classes9.dex */
public class C9811c {

    /* renamed from: a */
    public static final C9812d f48232a = new C9812d();

    /* renamed from: a */
    public static byte[] m60984a(String str) {
        try {
            return f48232a.m60988a(str, 0, str.length());
        } catch (Exception e10) {
            throw new C9809a("exception decoding Hex string: " + e10.getMessage(), e10);
        }
    }

    /* renamed from: b */
    public static byte[] m60985b(byte[] bArr, int i10, int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f48232a.m60989b(bArr, i10, i11, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            throw new C9810b("exception encoding Hex string: " + e10.getMessage(), e10);
        }
    }

    /* renamed from: c */
    public static String m60986c(byte[] bArr) {
        return m60987d(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public static String m60987d(byte[] bArr, int i10, int i11) {
        return C9580f.m59778b(m60985b(bArr, i10, i11));
    }
}
