package p237du;

import gu.C10053g;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* renamed from: du.b */
/* loaded from: classes5.dex */
public abstract class AbstractC9309b {

    /* renamed from: a */
    public static final String f46671a = "PBKDF2";

    /* renamed from: a */
    public static byte[] m58614a(char[] cArr, byte[] bArr, int i10, int i11, boolean z10) {
        if (cArr == null || cArr.length <= 0) {
            C10053g.m62491c(f46671a, "pbkdf password is empty.");
            return new byte[0];
        }
        if (bArr == null || bArr.length <= 0) {
            C10053g.m62491c(f46671a, "pbkdf salt is empty.");
            return new byte[0];
        }
        if (bArr.length < 16) {
            C10053g.m62491c(f46671a, "pbkdf salt parameter length is not enough, length must be more than 16.");
            return new byte[0];
        }
        if (i10 < 1000) {
            C10053g.m62491c(f46671a, "pbkdf iterations parameter count is less than 1000.");
            return new byte[0];
        }
        if (i11 >= 256) {
            return m58616c(cArr, bArr, i10, i11, z10);
        }
        C10053g.m62491c(f46671a, "pbkdf bytes parameter count is less than 256.");
        return new byte[0];
    }

    /* renamed from: b */
    public static byte[] m58615b(char[] cArr, byte[] bArr, int i10, int i11) {
        return m58614a(cArr, bArr, i10, i11, false);
    }

    /* renamed from: c */
    public static byte[] m58616c(char[] cArr, byte[] bArr, int i10, int i11, boolean z10) {
        try {
            return (z10 ? SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256") : SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")).generateSecret(new PBEKeySpec(cArr, bArr, i10, i11)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e10) {
            C10053g.m62491c(f46671a, "pbkdf exception : " + e10.getMessage());
            return new byte[0];
        }
    }
}
