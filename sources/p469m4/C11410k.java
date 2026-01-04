package p469m4;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: m4.k */
/* loaded from: classes.dex */
public class C11410k {
    /* renamed from: a */
    public static SecretKey m68352a(C11404e c11404e) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (c11404e == null || !c11404e.m68334a()) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        Log.d("AGC_Keys", "build aes key, iterationCount:" + c11404e.m68340g());
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance(c11404e.m68339f()).generateSecret(new PBEKeySpec(C11400a.m68317c(m68356e(C11400a.m68316b(c11404e.m68335b()), C11400a.m68316b(c11404e.m68336c()), C11400a.m68316b(c11404e.m68337d()))).toCharArray(), C11400a.m68316b(c11404e.m68338e()), c11404e.m68340g(), c11404e.m68341h() * 8));
        Log.d("AGC_Keys", "build aes key end");
        return new SecretKeySpec(secretKeyGenerateSecret.getEncoded(), "AES");
    }

    /* renamed from: b */
    public static byte[] m68353b(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(bArrCopyOfRange));
        return cipher.doFinal(bArr, bArrCopyOfRange.length + 1, (bArr.length - bArrCopyOfRange.length) - 1);
    }

    /* renamed from: c */
    public static byte[] m68354c(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null.");
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (i10 < 0) {
                bArr[i11] = (byte) (bArr[i11] << (-i10));
            } else {
                bArr[i11] = (byte) (bArr[i11] >> i10);
            }
        }
        return bArr;
    }

    /* renamed from: d */
    public static byte[] m68355d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    /* renamed from: e */
    public static byte[] m68356e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m68355d(m68354c(m68355d(m68354c(bArr, -4), bArr2), 6), bArr3);
    }
}
