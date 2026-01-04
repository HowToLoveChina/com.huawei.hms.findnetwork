package p297fu;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.p169ad.constant.Constants;
import gu.C10053g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: fu.a */
/* loaded from: classes5.dex */
public abstract class AbstractC9773a {
    /* renamed from: a */
    public static String m60808a(String str, PublicKey publicKey) {
        if (TextUtils.isEmpty(str) || publicKey == null) {
            C10053g.m62491c("RSAEncrypt", "content or PublicKey is null");
            return "";
        }
        try {
            if (m60810c((RSAPublicKey) publicKey)) {
                return Base64.encodeToString(m60809b(str.getBytes(Constants.UTF_8), publicKey), 0);
            }
            C10053g.m62491c("RSAEncrypt", "PublicKey length is too short");
            return "";
        } catch (UnsupportedEncodingException unused) {
            C10053g.m62491c("RSAEncrypt", "encrypt: UnsupportedEncodingException");
            return "";
        } catch (ClassCastException unused2) {
            C10053g.m62491c("RSAEncrypt", "encrypt: ClassCastException");
            return "";
        } catch (Exception e10) {
            C10053g.m62491c("RSAEncrypt", "exception : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public static byte[] m60809b(byte[] bArr, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null) {
            C10053g.m62491c("RSAEncrypt", "content or PublicKey is null");
            return bArr2;
        }
        try {
            if (!m60810c((RSAPublicKey) publicKey)) {
                C10053g.m62491c("RSAEncrypt", "publicKey length is too short");
                return bArr2;
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (ClassCastException unused) {
            C10053g.m62491c("RSAEncrypt", "RSA encrypt encrypt: ClassCastException");
            return bArr2;
        } catch (GeneralSecurityException e10) {
            C10053g.m62491c("RSAEncrypt", "RSA encrypt exception : " + e10.getMessage());
            return bArr2;
        }
    }

    /* renamed from: c */
    public static boolean m60810c(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }
}
