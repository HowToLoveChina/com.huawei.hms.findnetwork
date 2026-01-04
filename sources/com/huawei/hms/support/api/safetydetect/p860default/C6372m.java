package com.huawei.hms.support.api.safetydetect.p860default;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.m */
/* loaded from: classes8.dex */
public class C6372m {

    /* renamed from: a */
    private static final String f29892a = "m";

    /* renamed from: a */
    private static synchronized Key m36741a(String str) {
        KeyGenerator keyGenerator;
        try {
            Log.i(f29892a, "Generate aes key.");
            keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setDigests("SHA-256", "SHA-384", "SHA-512").setKeySize(256).setRandomizedEncryptionRequired(false).setBlockModes("GCM").setEncryptionPaddings("NoPadding", "PKCS7Padding").build());
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | ProviderException e10) {
            Log.e(f29892a, "Android key store encrypt device token sk failed " + e10.getMessage());
            throw new C6378s("Generate aes key error. " + e10.getMessage());
        }
        return keyGenerator.generateKey();
    }

    /* renamed from: b */
    public static byte[] m36743b(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key == null) {
                key = m36741a(str);
            }
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, key, new GCMParameterSpec(128, C6360d.m36730a(str2)));
            return cipher.doFinal(bArr);
        } catch (C6378s | IOException | InvalidAlgorithmParameterException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            Log.e(f29892a, "Android key store aes encrypt error. " + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: a */
    public static byte[] m36742a(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key == null) {
                return new byte[0];
            }
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, key, new GCMParameterSpec(128, C6360d.m36730a(str2)));
            return cipher.doFinal(bArr);
        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            Log.e(f29892a, "Android key store aes decrypt error. " + e10.getMessage());
            return new byte[0];
        }
    }
}
