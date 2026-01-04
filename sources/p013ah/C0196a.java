package p013ah;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p525ok.C11908a;
import p809yg.C13981a;

/* renamed from: ah.a */
/* loaded from: classes4.dex */
public final class C0196a {
    /* renamed from: a */
    public static byte[] m1092a(byte[] bArr, int i10, byte[] bArr2, int i11) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return m1093b(bArr, i10, bArr2, i11, 1);
    }

    /* renamed from: b */
    public static byte[] m1093b(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        if (i10 <= 0 || i10 > bArr.length) {
            i10 = bArr.length;
        }
        if (i11 <= 0 || i11 > bArr2.length) {
            i11 = bArr2.length;
        }
        if (i11 > 16) {
            i11 = 16;
        }
        byte[] bArr3 = new byte[16];
        for (int i13 = 0; i13 < 16; i13++) {
            bArr3[i13] = 0;
        }
        for (int i14 = 0; i14 < i11; i14++) {
            bArr3[i14] = bArr2[i14];
        }
        return m1095d(bArr, i10, i12, bArr3);
    }

    /* renamed from: c */
    public static void m1094c(byte[] bArr) throws NoSuchAlgorithmException {
        C11908a.m71442a().nextBytes(bArr);
    }

    /* renamed from: d */
    public static byte[] m1095d(byte[] bArr, int i10, int i11, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        int i12;
        int i13;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr3 = new byte[16];
        if (i11 == 0) {
            m1094c(bArr3);
            i12 = 1;
            i13 = 0;
        } else {
            for (int i14 = 0; i14 < 16 && i14 < bArr.length; i14++) {
                bArr3[i14] = bArr[i14];
            }
            i12 = 2;
            i13 = 16;
        }
        try {
            cipher.init(i12, new SecretKeySpec(bArr2, 0, 16, "AES"), new IvParameterSpec(bArr3));
        } catch (InvalidAlgorithmParameterException e10) {
            C13981a.m83988e("Aes128Cbc", "InvalidAlgorithmParameterException" + e10.getMessage());
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr, i13, i10 - i13);
        if (i11 != 0) {
            return bArrDoFinal;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArrDoFinal.length + 16);
        System.arraycopy(bArrDoFinal, 0, bArrCopyOf, 16, bArrDoFinal.length);
        return bArrCopyOf;
    }
}
