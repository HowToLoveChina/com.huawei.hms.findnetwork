package p454lj;

import android.util.Base64;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeBase64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* renamed from: lj.o */
/* loaded from: classes5.dex */
public class C11292o {
    /* renamed from: a */
    public static String m67756a(String str, String str2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (str != null && str2 != null) {
            try {
                PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(SafeBase64.decode(str, 2)));
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(1, publicKeyGeneratePublic, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT));
                return Base64.encodeToString(cipher.doFinal(str2.getBytes(Constants.UTF_8)), 2);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
