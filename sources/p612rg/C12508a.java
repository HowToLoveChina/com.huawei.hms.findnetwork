package p612rg;

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

/* renamed from: rg.a */
/* loaded from: classes4.dex */
public final class C12508a {
    /* renamed from: a */
    public static boolean m75095a(int i10, byte[] bArr) {
        return i10 <= 0 || i10 > bArr.length;
    }

    /* renamed from: b */
    public static boolean m75096b(byte[] bArr, byte[] bArr2) {
        return bArr == null || bArr2 == null;
    }

    /* renamed from: c */
    public static byte[] m75097c(byte[] bArr, int i10, byte[] bArr2, int i11) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return m75099e(bArr, i10, bArr2, i11, 1);
    }

    /* renamed from: d */
    public static byte[] m75098d(byte[] bArr, int i10, byte[] bArr2, int i11) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return m75099e(bArr, i10, bArr2, i11, 0);
    }

    /* renamed from: e */
    public static byte[] m75099e(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        int i13;
        int i14;
        if (m75096b(bArr, bArr2)) {
            return new byte[0];
        }
        if (m75095a(i10, bArr)) {
            i10 = bArr.length;
        }
        if (i11 <= 0 || i11 > bArr2.length) {
            i11 = bArr2.length;
        }
        if (i11 > 16) {
            i11 = 16;
        }
        byte[] bArr3 = new byte[16];
        for (int i15 = 0; i15 < 16; i15++) {
            bArr3[i15] = 0;
        }
        for (int i16 = 0; i16 < i11; i16++) {
            bArr3[i16] = bArr2[i16];
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr4 = new byte[16];
        if (i12 == 0) {
            m75100f(bArr4);
            i13 = 1;
            i14 = 0;
        } else {
            for (int i17 = 0; i17 < 16 && i17 < bArr.length; i17++) {
                bArr4[i17] = bArr[i17];
            }
            i13 = 2;
            i14 = 16;
        }
        try {
            cipher.init(i13, new SecretKeySpec(bArr3, 0, 16, "AES"), new IvParameterSpec(bArr4));
        } catch (InvalidAlgorithmParameterException e10) {
            C13981a.m83988e("Aes128Cbc", "InvalidAlgorithmParameterException" + e10.getMessage());
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr, i14, i10 - i14);
        if (i12 != 0) {
            return bArrDoFinal;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArrDoFinal.length + 16);
        System.arraycopy(bArrDoFinal, 0, bArrCopyOf, 16, bArrDoFinal.length);
        return bArrCopyOf;
    }

    /* renamed from: f */
    public static void m75100f(byte[] bArr) throws NoSuchAlgorithmException {
        C11908a.m71442a().nextBytes(bArr);
    }
}
