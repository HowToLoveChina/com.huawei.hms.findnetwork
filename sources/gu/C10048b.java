package gu;

import android.util.Base64;
import bz.C1364g;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import p756wy.C13666a;

/* renamed from: gu.b */
/* loaded from: classes5.dex */
public class C10048b {

    /* renamed from: a */
    public static boolean f49015a = true;

    /* renamed from: b */
    public static boolean f49016b = true;

    /* renamed from: a */
    public static SecureRandom m62469a() throws NoSuchAlgorithmException {
        SecureRandom secureRandom;
        C10053g.m62490b("EncryptUtil", "generateSecureRandomNew ");
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            C10053g.m62491c("EncryptUtil", "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                C10053g.m62491c("EncryptUtil", "NoSuchAlgorithmException");
                return secureRandom;
            } catch (Throwable th2) {
                if (f49016b) {
                    C10053g.m62491c("EncryptUtil", "exception : " + th2.getMessage() + " , you should implementation bcprov-jdk15on library");
                    f49016b = false;
                }
                return secureRandom;
            }
        }
        C13666a c13666a = new C13666a();
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        return new C1364g(secureRandom, true).m7863b(384).m7862a(c13666a, 256, bArr, false);
    }

    /* renamed from: b */
    public static byte[] m62470b(int i10) throws NoSuchAlgorithmException {
        SecureRandom secureRandomM62469a = m62469a();
        if (secureRandomM62469a == null) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[i10];
            secureRandomM62469a.nextBytes(bArr);
            return bArr;
        } catch (NullPointerException e10) {
            C10053g.m62491c("EncryptUtil", "secureRandom nextBytes error is : " + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: c */
    public static SecureRandom m62471c() {
        if (f49015a) {
            return m62469a();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            C10053g.m62491c("EncryptUtil", "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    /* renamed from: d */
    public static byte[] m62472d(int i10) throws NoSuchAlgorithmException {
        SecureRandom secureRandom;
        if (f49015a) {
            return m62470b(i10);
        }
        byte[] bArr = new byte[i10];
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            C10053g.m62491c("EncryptUtil", "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                C10053g.m62491c("EncryptUtil", "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e10) {
                C10053g.m62491c("EncryptUtil", "getSecureRandomBytes getInstance: exception : " + e10.getMessage());
                return new byte[0];
            }
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    /* renamed from: e */
    public static String m62473e(int i10) {
        return C10049c.m62476a(m62472d(i10));
    }

    /* renamed from: f */
    public static RSAPublicKey m62474f(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e10) {
                C10053g.m62491c("EncryptUtil", "load Key Exception:" + e10.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            C10053g.m62491c("EncryptUtil", "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e11) {
            C10053g.m62491c("EncryptUtil", "base64 decode Exception" + e11.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public static void m62475g(boolean z10) {
        C10053g.m62492d("EncryptUtil", "setBouncycastleFlag: " + z10);
        f49015a = z10;
    }
}
