package p216d4;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p384j4.AbstractC10707f;
import p405jt.AbstractC10915a;

/* renamed from: d4.k0 */
/* loaded from: classes.dex */
public abstract class AbstractC9019k0 {
    /* renamed from: a */
    public static String m56932a(String str) {
        if (AbstractC10707f.m65379d(str)) {
            return "";
        }
        try {
            return AbstractC9012h.m56889a(m56933b(str.getBytes(Constants.UTF_8)));
        } catch (Exception unused) {
            AbstractC10915a.m65970b("Sha256Util", "get hex sha256 error");
            return "";
        }
    }

    /* renamed from: b */
    public static byte[] m56933b(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            AbstractC10915a.m65970b("Sha256Util", "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
