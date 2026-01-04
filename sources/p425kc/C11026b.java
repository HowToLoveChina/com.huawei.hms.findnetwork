package p425kc;

import android.text.TextUtils;
import fk.C9721b;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import p782xo.C13842a;

/* renamed from: kc.b */
/* loaded from: classes3.dex */
public class C11026b {
    /* renamed from: a */
    public static byte[] m66470a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, C9721b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr2 == null || bArr2.length != 16 || bArr3 == null || bArr3.length != 16) {
            throw new C9721b(4002, "key or iv error", "decryptPayload");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e10) {
            throw new C9721b(4005, "decryptPayload error " + e10.getMessage(), "decryptPayload");
        }
    }

    /* renamed from: b */
    public static byte[] m66471b(byte[] bArr, Key key) throws GeneralSecurityException {
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("OAEP");
        algorithmParameters.init(new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT));
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        cipher.init(1, key, algorithmParameters);
        return cipher.doFinal(bArr);
    }

    /* renamed from: c */
    public static byte[] m66472c(byte[] bArr) throws C9721b {
        try {
            String strM83034m = C13842a.m83010i().m83034m("rsa_key_common_trust_circle_modulus");
            if (TextUtils.isEmpty(strM83034m)) {
                throw new C9721b(4004, "modulus key is empty");
            }
            String strM83034m2 = C13842a.m83010i().m83034m("rsa_key_common_trust_circle_exponent");
            if (TextUtils.isEmpty(strM83034m2)) {
                throw new C9721b(4004, "exponent key is empty");
            }
            return m66471b(bArr, m66473d(strM83034m, strM83034m2));
        } catch (GeneralSecurityException e10) {
            throw new C9721b(4004, "encrypt by public key error " + e10.getMessage(), "encryptUsingPublicKey");
        }
    }

    /* renamed from: d */
    public static RSAPublicKey m66473d(String str, String str2) throws GeneralSecurityException {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(str, 16), new BigInteger(str2, 16)));
    }
}
