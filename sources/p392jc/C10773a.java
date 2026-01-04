package p392jc;

import com.huawei.hicloud.request.userk.bean.EncryptBaseReq;
import fk.C9721b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import p514o9.C11839m;
import p525ok.C11908a;

/* renamed from: jc.a */
/* loaded from: classes3.dex */
public class C10773a {
    /* renamed from: a */
    public KeyPair m65601a(byte[] bArr) throws C9721b, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr);
            C11839m.m70686d("ECDHCryptor", "generateECKeyPair:SDK_INT more than 28");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(x509EncodedKeySpec)).getParams(), C11908a.m71442a());
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e10) {
            throw new C9721b(4005, "Fail to generateECKeyPair " + e10.getMessage(), "generateECKeyPair");
        }
    }

    /* renamed from: b */
    public byte[] m65602b(byte[] bArr, PrivateKey privateKey) throws C9721b {
        return m65603c(m65604d(bArr), privateKey);
    }

    /* renamed from: c */
    public final byte[] m65603c(PublicKey publicKey, PrivateKey privateKey) throws IllegalStateException, C9721b, NoSuchAlgorithmException, InvalidKeyException {
        try {
            C11839m.m70686d("ECDHCryptor", "generateSharedkey:SDK_INT more than 28");
            KeyAgreement keyAgreement = KeyAgreement.getInstance(EncryptBaseReq.TYPE_ECDH);
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(publicKey, true);
            return keyAgreement.generateSecret();
        } catch (Exception e10) {
            throw new C9721b(4005, "Fail to generateECKeyPair " + e10.getMessage(), "generateSharedkey");
        }
    }

    /* renamed from: d */
    public final PublicKey m65604d(byte[] bArr) throws C9721b {
        try {
            return KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Exception e10) {
            throw new C9721b(4005, "Fail to getPublicKeyFromByte " + e10.getMessage(), "getPublicKeyFromByte");
        }
    }
}
