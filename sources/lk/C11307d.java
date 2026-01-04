package lk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;

/* renamed from: lk.d */
/* loaded from: classes6.dex */
public class C11307d {
    /* renamed from: a */
    public static byte[] m67872a(String str, byte[] bArr, int i10) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr.length <= 16) {
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "decrypt, Decrypt source data is invalid.");
            return new byte[0];
        }
        byte[] bArr2 = new byte[0];
        try {
            SecretKey secretKeyM67876e = m67876e(str, i10);
            if (secretKeyM67876e == null) {
                return new byte[0];
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeyM67876e, new IvParameterSpec(bArrCopyOf));
            return cipher.doFinal(bArr, 16, bArr.length - 16);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "decrypt, Decrypt exception " + e10.toString());
            return bArr2;
        }
    }

    /* renamed from: b */
    public static byte[] m67873b(String str, byte[] bArr, int i10, StringBuilder sb2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr.length <= 16) {
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "Decrypt source data is invalid.");
            return new byte[0];
        }
        byte[] bArr2 = new byte[0];
        try {
            SecretKey secretKeyM67876e = m67876e(str, i10);
            if (secretKeyM67876e == null) {
                return new byte[0];
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeyM67876e, new IvParameterSpec(bArrCopyOf));
            return cipher.doFinal(bArr, 16, bArr.length - 16);
        } catch (Exception e10) {
            String str2 = "Decrypt exception: " + e10.toString();
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", str2);
            if (sb2 == null) {
                return bArr2;
            }
            sb2.append(str2);
            return bArr2;
        }
    }

    /* renamed from: c */
    public static byte[] m67874c(String str, byte[] bArr, int i10) {
        return m67875d(str, bArr, i10, null);
    }

    /* renamed from: d */
    public static byte[] m67875d(String str, byte[] bArr, int i10, StringBuilder sb2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = new byte[0];
        if (bArr == null || bArr.length == 0) {
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "encrypt source data is invalid.");
            return new byte[0];
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            SecretKey secretKeyM67876e = m67876e(str, i10);
            if (secretKeyM67876e == null) {
                return new byte[0];
            }
            cipher.init(1, secretKeyM67876e);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv2 = cipher.getIV();
            if (iv2 != null && iv2.length == 16) {
                byte[] bArrCopyOf = Arrays.copyOf(iv2, iv2.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv2.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "IV is invalid.");
            return new byte[0];
        } catch (Exception e10) {
            String str2 = "Encrypt exception: " + e10.toString();
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", str2);
            if (sb2 == null) {
                return bArr2;
            }
            sb2.append(str2);
            return bArr2;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    /* renamed from: e */
    public static SecretKey m67876e(String str, int i10) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                return (SecretKey) key;
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(i10).build());
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            C0209d.m1294p2(C0213f.m1377a(), "keystore_generate_key", 1);
            AbstractC10896a.m65887i("KeyStoreEncryptAndDecrypt_base", "generateKey, generate new Key");
            return secretKeyGenerateKey;
        } catch (UnrecoverableKeyException e10) {
            Throwable cause = e10.getCause();
            if (cause == null) {
                return null;
            }
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "Generate key exception, UnrecoverableKeyException: " + cause.getMessage());
            return null;
        } catch (Exception e11) {
            AbstractC10896a.m65886e("KeyStoreEncryptAndDecrypt_base", "Generate key exception " + e11.toString());
            return null;
        }
    }
}
