package p425kc;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import p514o9.C11839m;

/* renamed from: kc.a */
/* loaded from: classes3.dex */
public class C11025a {
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m66466a(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p425kc.C11025a.m66466a(java.lang.String, java.lang.String):byte[]");
    }

    /* renamed from: b */
    public static String m66467b(String str, byte[] bArr) throws InvalidKeyException, IOException {
        try {
            KeyStore keyStoreM66468c = m66468c(str);
            if (keyStoreM66468c == null) {
                C11839m.m70686d("KeyStoreUtil", "mKeystore is empty");
                return null;
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStoreM66468c.getEntry(str, null);
            if (privateKeyEntry == null) {
                C11839m.m70686d("KeyStoreUtil", "privateKeyEntry is empty");
                return null;
            }
            PublicKey publicKey = privateKeyEntry.getCertificate().getPublicKey();
            if (bArr == null) {
                C11839m.m70686d("KeyStoreUtil", "encrypt initialText is empty");
                return null;
            }
            Provider provider = Security.getProvider("AndroidKeyStoreBCWorkaround");
            Cipher cipher = provider != null ? Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", provider) : Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKey);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
            cipherOutputStream.write(bArr);
            cipherOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e10) {
            C11839m.m70686d("KeyStoreUtil", "encrypt Exception " + e10.getMessage() + " occured");
            return null;
        }
    }

    /* renamed from: c */
    public static KeyStore m66468c(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStoreM66469d;
        KeyStore keyStore = null;
        try {
            keyStoreM66469d = m66469d();
        } catch (Exception e10) {
            e = e10;
        }
        try {
            if (keyStoreM66469d == null) {
                C11839m.m70688i("KeyStoreUtil", "mKeystore is null");
                return null;
            }
            if (keyStoreM66469d.containsAlias(str)) {
                return keyStoreM66469d;
            }
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(3072).build());
            keyPairGenerator.generateKeyPair();
            return keyStoreM66469d;
        } catch (Exception e11) {
            e = e11;
            keyStore = keyStoreM66469d;
            C11839m.m70686d("KeyStoreUtil", "generateKey Exception " + e.getMessage() + " occured");
            return keyStore;
        }
    }

    /* renamed from: d */
    public static KeyStore m66469d() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore;
        Object e10;
        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");
        } catch (IOException | GeneralSecurityException e11) {
            keyStore = null;
            e10 = e11;
        }
        try {
            keyStore.load(null);
        } catch (IOException | GeneralSecurityException e12) {
            e10 = e12;
            C11839m.m70689w("KeyStoreUtil", "KeyStore load error " + e10.toString());
            return keyStore;
        }
        return keyStore;
    }
}
