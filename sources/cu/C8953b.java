package cu;

import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import gu.C10053g;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: cu.b */
/* loaded from: classes5.dex */
public class C8953b {
    /* renamed from: a */
    public static Cipher m56694a(byte[] bArr, byte[] bArr2, int i10, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null || bArr.length < 16 || !AesGcm.isBuildVersionHigherThan19()) {
            C10053g.m62491c("CipherUtil", "gcm encrypt param is not right");
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(i10, secretKeySpec, "AES/GCM/NoPadding".equals(str) ? AesGcm.getGcmAlgorithmParams(bArr2) : new IvParameterSpec(bArr2));
            return cipher;
        } catch (GeneralSecurityException e10) {
            C10053g.m62491c("CipherUtil", "GCM encrypt data error" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static Cipher m56695b(byte[] bArr, byte[] bArr2, int i10) {
        if (bArr2 != null && bArr2.length >= 12) {
            return m56694a(bArr, bArr2, i10, "AES/GCM/NoPadding");
        }
        C10053g.m62491c("CipherUtil", "gcm iv param is not right");
        return null;
    }

    /* renamed from: c */
    public static Cipher m56696c(byte[] bArr, byte[] bArr2) {
        return m56695b(bArr, bArr2, 1);
    }
}
