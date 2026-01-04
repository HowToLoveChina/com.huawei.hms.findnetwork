package p234dr;

import as.C1016d;
import com.huawei.secure.android.common.util.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: dr.a */
/* loaded from: classes8.dex */
public final class C9295a {
    /* renamed from: a */
    public static String m58593a(byte[] bArr, String str) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        String str2;
        byte[] bArrDoFinal;
        byte[] bArrEncode;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
        try {
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            try {
                mac.init(secretKeySpec);
                bArrDoFinal = mac.doFinal(str.getBytes(StandardCharsets.UTF_8));
            } catch (InvalidKeyException unused) {
                str2 = "InvalidKeyException";
                C1016d.m6183c("HmacUtil", str2);
                bArrDoFinal = null;
                if (bArrDoFinal == null) {
                    return null;
                }
                return new String(bArrEncode, StandardCharsets.UTF_8);
            }
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "NoSuchAlgorithmException";
        }
        if (bArrDoFinal == null && (bArrEncode = SafeBase64.encode(bArrDoFinal, 2)) != null) {
            return new String(bArrEncode, StandardCharsets.UTF_8);
        }
        return null;
    }
}
