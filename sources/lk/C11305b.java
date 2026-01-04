package lk;

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
import p399jk.AbstractC10896a;
import p525ok.C11908a;

/* renamed from: lk.b */
/* loaded from: classes6.dex */
public final class C11305b {
    /* renamed from: a */
    public static byte[] m67867a(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return m67868b(bArr, bArr2, 1);
    }

    /* renamed from: b */
    public static byte[] m67868b(byte[] bArr, byte[] bArr2, int i10) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        int i11;
        int i12;
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length2 > 16) {
            length2 = 16;
        }
        byte[] bArr3 = new byte[16];
        for (int i13 = 0; i13 < 16; i13++) {
            bArr3[i13] = 0;
        }
        for (int i14 = 0; i14 < length2; i14++) {
            bArr3[i14] = bArr2[i14];
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr4 = new byte[16];
        if (i10 == 0) {
            C11908a.m71442a().nextBytes(bArr4);
            i11 = 1;
            i12 = 0;
        } else {
            for (int i15 = 0; i15 < 16 && i15 < bArr.length; i15++) {
                bArr4[i15] = bArr[i15];
            }
            i11 = 2;
            i12 = 16;
        }
        try {
            cipher.init(i11, new SecretKeySpec(bArr3, 0, 16, "AES"), new IvParameterSpec(bArr4));
        } catch (InvalidAlgorithmParameterException e10) {
            AbstractC10896a.m65886e("Aes128Cbc", e10.getMessage());
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr, i12, length - i12);
        if (i10 != 0) {
            return bArrDoFinal;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArrDoFinal.length + 16);
        System.arraycopy(bArrDoFinal, 0, bArrCopyOf, 16, bArrDoFinal.length);
        return bArrCopyOf;
    }
}
