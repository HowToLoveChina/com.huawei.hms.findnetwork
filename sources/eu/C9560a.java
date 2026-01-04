package eu;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import gu.C10049c;
import gu.C10053g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* renamed from: eu.a */
/* loaded from: classes5.dex */
public class C9560a {

    /* renamed from: a */
    public static Map<String, SecretKey> f47475a = new ConcurrentHashMap();

    /* renamed from: a */
    public static SecretKey m59672a(String str, Boolean bool) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, C9561b, NoSuchProviderException, InvalidAlgorithmParameterException {
        C10053g.m62492d("GCMKS", "load key");
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                return (SecretKey) key;
            }
            if (!bool.booleanValue()) {
                return null;
            }
            C10053g.m62492d("GCMKS", "generate key");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
            return keyGenerator.generateKey();
        } catch (IOException e10) {
            C10053g.m62491c("GCMKS", "IOException : " + e10.getMessage());
            throw new C9561b("IOException : " + e10.getMessage());
        } catch (InvalidAlgorithmParameterException e11) {
            C10053g.m62491c("GCMKS", "InvalidAlgorithmParameterException : " + e11.getMessage());
            throw new C9561b("InvalidAlgorithmParameterException : " + e11.getMessage());
        } catch (KeyStoreException e12) {
            C10053g.m62491c("GCMKS", "KeyStoreException : " + e12.getMessage());
            throw new C9561b("KeyStoreException : " + e12.getMessage());
        } catch (NoSuchAlgorithmException e13) {
            C10053g.m62491c("GCMKS", "NoSuchAlgorithmException : " + e13.getMessage());
            throw new C9561b("NoSuchAlgorithmException : " + e13.getMessage());
        } catch (NoSuchProviderException e14) {
            C10053g.m62491c("GCMKS", "NoSuchProviderException : " + e14.getMessage());
            throw new C9561b("NoSuchProviderException : " + e14.getMessage());
        } catch (UnrecoverableKeyException e15) {
            C10053g.m62491c("GCMKS", "UnrecoverableKeyException : " + e15.getMessage());
            throw new C9561b("UnrecoverableKeyException : " + e15.getMessage());
        } catch (CertificateException e16) {
            C10053g.m62491c("GCMKS", "CertificateException : " + e16.getMessage());
            throw new C9561b("CertificateException : " + e16.getMessage());
        } catch (Exception e17) {
            C10053g.m62491c("GCMKS", "Exception: " + e17.getMessage());
            throw new C9561b("Exception : " + e17.getMessage());
        }
    }

    /* renamed from: b */
    public static boolean m59673b() {
        return true;
    }

    /* renamed from: c */
    public static byte[] m59674c(SecretKey secretKey, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, C9561b, InvalidAlgorithmParameterException {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArrCopyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e10) {
            C10053g.m62491c("GCMKS", "InvalidAlgorithmParameterException : " + e10.getMessage());
            throw new C9561b("InvalidAlgorithmParameterException : " + e10.getMessage());
        } catch (InvalidKeyException e11) {
            C10053g.m62491c("GCMKS", "InvalidKeyException : " + e11.getMessage());
            throw new C9561b("InvalidKeyException : " + e11.getMessage());
        } catch (NoSuchAlgorithmException e12) {
            C10053g.m62491c("GCMKS", "NoSuchAlgorithmException : " + e12.getMessage());
            throw new C9561b("NoSuchAlgorithmException : " + e12.getMessage());
        } catch (BadPaddingException e13) {
            C10053g.m62491c("GCMKS", "BadPaddingException : " + e13.getMessage());
            throw new C9561b("BadPaddingException : " + e13.getMessage());
        } catch (IllegalBlockSizeException e14) {
            C10053g.m62491c("GCMKS", "IllegalBlockSizeException : " + e14.getMessage());
            throw new C9561b("IllegalBlockSizeException : " + e14.getMessage());
        } catch (NoSuchPaddingException e15) {
            C10053g.m62491c("GCMKS", "NoSuchPaddingException : " + e15.getMessage());
            throw new C9561b("NoSuchPaddingException : " + e15.getMessage());
        } catch (Exception e16) {
            C10053g.m62491c("GCMKS", "Exception: " + e16.getMessage());
            throw new C9561b("Exception: " + e16.getMessage());
        }
    }

    /* renamed from: d */
    public static SecretKey m59675d(String str, Boolean bool) throws C9561b {
        if (TextUtils.isEmpty(str)) {
            throw new C9561b("alias is null");
        }
        if (f47475a.get(str) == null) {
            synchronized (C9560a.class) {
                try {
                    if (f47475a.get(str) == null) {
                        SecretKey secretKeyM59672a = m59672a(str, bool);
                        if (secretKeyM59672a == null) {
                            throw new C9561b("AES GCM is decrypt,but alias is null");
                        }
                        f47475a.put(str, secretKeyM59672a);
                    }
                } finally {
                }
            }
        }
        return f47475a.get(str);
    }

    /* renamed from: e */
    public static byte[] m59676e(SecretKey secretKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, C9561b {
        byte[] bArr2 = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv2 = cipher.getIV();
            if (iv2 != null && iv2.length == 12) {
                byte[] bArrCopyOf = Arrays.copyOf(iv2, iv2.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv2.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            C10053g.m62491c("GCMKS", "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e10) {
            C10053g.m62491c("GCMKS", "InvalidKeyException : " + e10.getMessage());
            throw new C9561b("InvalidKeyException : " + e10.getMessage());
        } catch (NoSuchAlgorithmException e11) {
            C10053g.m62491c("GCMKS", "NoSuchAlgorithmException : " + e11.getMessage());
            throw new C9561b("NoSuchAlgorithmException : " + e11.getMessage());
        } catch (BadPaddingException e12) {
            C10053g.m62491c("GCMKS", "BadPaddingException : " + e12.getMessage());
            throw new C9561b("BadPaddingException : " + e12.getMessage());
        } catch (IllegalBlockSizeException e13) {
            C10053g.m62491c("GCMKS", "IllegalBlockSizeException : " + e13.getMessage());
            throw new C9561b("IllegalBlockSizeException : " + e13.getMessage());
        } catch (NoSuchPaddingException e14) {
            C10053g.m62491c("GCMKS", "NoSuchPaddingException : " + e14.getMessage());
            throw new C9561b("NoSuchPaddingException : " + e14.getMessage());
        } catch (Exception e15) {
            C10053g.m62491c("GCMKS", "Exception: " + e15.getMessage());
            throw new C9561b("Exception : " + e15.getMessage());
        }
    }

    /* renamed from: f */
    public static String m59677f(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C10053g.m62491c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(m59678g(str, C10049c.m62477b(str2)), Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("GCMKS", "decrypt: UnsupportedEncodingException : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: g */
    public static byte[] m59678g(String str, byte[] bArr) {
        SecretKey secretKeyM59675d;
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C10053g.m62491c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (!m59673b()) {
            C10053g.m62491c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            C10053g.m62491c("GCMKS", "Decrypt source data is invalid.");
            return bArr2;
        }
        try {
            secretKeyM59675d = m59675d(str, Boolean.FALSE);
        } catch (C9561b e10) {
            C10053g.m62491c("GCMKS", "e : " + e10.getMessage());
            secretKeyM59675d = null;
        }
        return secretKeyM59675d == null ? bArr2 : m59679h(secretKeyM59675d, bArr);
    }

    /* renamed from: h */
    public static byte[] m59679h(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            C10053g.m62491c("GCMKS", "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            C10053g.m62491c("GCMKS", "content is null");
            return bArr2;
        }
        if (!m59673b()) {
            C10053g.m62491c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            C10053g.m62491c("GCMKS", "Decrypt source data is invalid.");
            return bArr2;
        }
        try {
            return m59674c(secretKey, bArr);
        } catch (C9561b e10) {
            C10053g.m62491c("GCMKS", "e : " + e10.getMessage());
            return bArr2;
        }
    }

    /* renamed from: i */
    public static String m59680i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C10053g.m62491c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return C10049c.m62476a(m59681j(str, str2.getBytes(Constants.UTF_8)));
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("GCMKS", "encrypt: UnsupportedEncodingException : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: j */
    public static byte[] m59681j(String str, byte[] bArr) {
        SecretKey secretKeyM59675d;
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C10053g.m62491c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (!m59673b()) {
            C10053g.m62491c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        try {
            secretKeyM59675d = m59675d(str, Boolean.TRUE);
        } catch (C9561b e10) {
            C10053g.m62491c("GCMKS", "e : " + e10.getMessage());
            secretKeyM59675d = null;
        }
        return secretKeyM59675d == null ? bArr2 : m59682k(secretKeyM59675d, bArr);
    }

    /* renamed from: k */
    public static byte[] m59682k(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            C10053g.m62491c("GCMKS", "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            C10053g.m62491c("GCMKS", "secret key is null");
            return bArr2;
        }
        if (!m59673b()) {
            C10053g.m62491c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        try {
            return m59676e(secretKey, bArr);
        } catch (C9561b e10) {
            C10053g.m62491c("GCMKS", "e : " + e10.getMessage());
            return bArr2;
        }
    }
}
