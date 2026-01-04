package ma;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ma.a */
/* loaded from: classes3.dex */
public class C11434a {
    /* renamed from: a */
    public static void m68488a(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, int i12, int i13) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(bArr2, 16), "AES");
        if (i11 + i13 + 32 < i10) {
            int i14 = ((i13 + 15) / 16) * 16;
            if (i11 < 16) {
                cipher.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(bArr3, 16)));
                System.arraycopy(cipher.update(bArr, 0, i14 + 32), i11, bArr4, i12, i13);
                return;
            } else {
                int i15 = (i11 / 16) * 16;
                cipher.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOfRange(bArr, i15 - 16, i15)));
                System.arraycopy(cipher.update(bArr, i15, i14 + 32), i11 - i15, bArr4, i12, i13);
                return;
            }
        }
        if (i11 < 16) {
            cipher.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(bArr3, 16)));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            System.arraycopy(bArrDoFinal, i11, bArr4, i12, Math.min(i13, bArrDoFinal.length - i11));
        } else {
            int i16 = (i11 / 16) * 16;
            cipher.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOfRange(bArr, i16 - 16, i16)));
            byte[] bArrDoFinal2 = cipher.doFinal(bArr, i16, bArr.length - i16);
            System.arraycopy(bArrDoFinal2, i11 - i16, bArr4, i12, Math.min(i13, (bArrDoFinal2.length - i11) + i16));
        }
    }
}
