package com.huawei.hms.hatool;

import android.util.Base64;
import com.huawei.openalliance.p169ad.constant.Constants;
import gu.C10049c;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.huawei.hms.hatool.h0 */
/* loaded from: classes8.dex */
public class C5535h0 {
    /* renamed from: a */
    public static String m32560a(String str, String str2) {
        try {
            return m32561a(str, str2.getBytes(Constants.UTF_8));
        } catch (UnsupportedEncodingException unused) {
            C5571v.m32792c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    /* renamed from: a */
    public static String m32561a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            C5571v.m32797f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return C10049c.m62476a(m32563a(bArr, m32562a(Base64.decode(str, 0))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            C5571v.m32797f("hmsSdk", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            C5571v.m32797f("hmsSdk", str2);
            return "";
        }
    }

    /* renamed from: a */
    private static PublicKey m32562a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    /* renamed from: a */
    private static byte[] m32563a(byte[] bArr, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String str;
        try {
            if (publicKey == null) {
                throw new UnsupportedEncodingException("The loaded public key is null");
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (UnsupportedEncodingException unused) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            C5571v.m32797f("hmsSdk", str);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str = "rsaEncrypt(): init - Invalid key!";
            C5571v.m32797f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            C5571v.m32797f("hmsSdk", str);
            return new byte[0];
        } catch (BadPaddingException unused4) {
            str = "rsaEncrypt():False filling parameters!";
            C5571v.m32797f("hmsSdk", str);
            return new byte[0];
        } catch (IllegalBlockSizeException unused5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            C5571v.m32797f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchPaddingException unused6) {
            str = "rsaEncrypt():  No such filling parameters ";
            C5571v.m32797f("hmsSdk", str);
            return new byte[0];
        }
    }
}
