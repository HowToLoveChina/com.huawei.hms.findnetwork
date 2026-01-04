package za;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p514o9.C11839m;

/* renamed from: za.a */
/* loaded from: classes3.dex */
public class C14164a {
    /* renamed from: a */
    public static String m85022a(byte[] bArr) {
        if (bArr == null) {
            C11839m.m70688i("Hash", "toHex byteArray is null");
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
    public static String m85023b(String str, byte[] bArr) throws Exception {
        return new String(m85025d(2, bArr, m85026e(str.substring(0, 32))).doFinal(m85026e(str.substring(32))), "UTF8");
    }

    /* renamed from: c */
    public static String m85024c(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException, IOException {
        return m85022a(bArr2) + m85022a(m85025d(1, bArr, bArr2).doFinal(str.getBytes("utf-8")));
    }

    /* renamed from: d */
    public static Cipher m85025d(int i10, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i10, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    /* renamed from: e */
    public static byte[] m85026e(String str) throws NumberFormatException {
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
                C11839m.m70689w("Hash", "parseInt error " + e10.toString());
                i10 = 0;
            }
            bArr[i12] = (byte) i10;
        }
        return bArr;
    }

    /* renamed from: f */
    public static String m85027f(String str, String str2) throws GeneralSecurityException, IOException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(m85026e(str2), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        return m85022a(mac.doFinal(str.getBytes("utf-8")));
    }
}
