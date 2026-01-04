package ga;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p031b7.C1120a;

/* renamed from: ga.c */
/* loaded from: classes3.dex */
public class C9900c {
    /* renamed from: a */
    public static String m61473a(byte[] bArr) {
        if (bArr == null) {
            C1120a.m6677i("Hash", "toHex byteArray is null");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (Integer.toHexString(i10).length() == 1) {
                sb2.append("0");
                sb2.append(Integer.toHexString(i10));
            } else {
                sb2.append(Integer.toHexString(i10));
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m61474b(String str, byte[] bArr) throws Exception {
        return new String(m61476d(2, bArr, m61477e(str.substring(0, 32))).doFinal(m61477e(str.substring(32))), "UTF8");
    }

    /* renamed from: c */
    public static String m61475c(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException, IOException {
        return m61473a(bArr2) + m61473a(m61476d(1, bArr, bArr2).doFinal(str.getBytes("utf-8")));
    }

    /* renamed from: d */
    public static Cipher m61476d(int i10, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i10, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    /* renamed from: e */
    public static byte[] m61477e(String str) throws NumberFormatException {
        int i10;
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        int i11 = length / 2;
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 != i11; i12++) {
            int i13 = i12 * 2;
            try {
                i10 = Integer.parseInt(str.substring(i13, i13 + 2), 16);
            } catch (NumberFormatException e10) {
                C1120a.m6678w("Hash", "parseInt error " + e10.toString());
                i10 = 0;
            }
            bArr[i12] = (byte) i10;
        }
        return bArr;
    }

    /* renamed from: f */
    public static String m61478f(String str, String str2) throws GeneralSecurityException, IOException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(m61477e(str2), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        return m61473a(mac.doFinal(str.getBytes("utf-8")));
    }
}
