package cw;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import p857zv.Exception_C14389c;

/* renamed from: cw.c */
/* loaded from: classes9.dex */
public class C8958c {
    /* renamed from: a */
    public static byte[] m56709a(String str, int i10) throws Exception_C14389c {
        if (str == null) {
            return new byte[0];
        }
        try {
            return Base64.decode(str, i10);
        } catch (Exception unused) {
            throw new Exception_C14389c(1005L, "base64 decode error");
        }
    }

    /* renamed from: b */
    public static String m56710b(String str, int i10) throws Exception_C14389c {
        if (str == null) {
            return "";
        }
        try {
            return new String(Base64.decode(str, i10), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            throw new Exception_C14389c(1005L, "base64 decode to string error");
        }
    }

    /* renamed from: c */
    public static String m56711c(byte[] bArr, int i10) throws Exception_C14389c {
        if (bArr == null) {
            throw new Exception_C14389c(1005L, "base64 encodeToString error: data is null");
        }
        try {
            return Base64.encodeToString(bArr, i10);
        } catch (Exception unused) {
            throw new Exception_C14389c(1005L, "base64 encodeToString error");
        }
    }
}
