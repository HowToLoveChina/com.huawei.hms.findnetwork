package p402jq;

import android.annotation.SuppressLint;
import gu.C10048b;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: jq.b */
/* loaded from: classes8.dex */
public class C10909b {
    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    public static String m65950a() {
        C10048b.m62475g(true);
        String strM62473e = C10048b.m62473e(8);
        return AbstractC10910c.m65954b(strM62473e.getBytes(Charset.defaultCharset()), strM62473e.length());
    }

    /* renamed from: b */
    public static String m65951b(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strM65950a = m65950a();
        return strM65950a + ":" + AbstractC10910c.m65953a(C10908a.m65949a(bArr, AbstractC10910c.m65955c(strM65950a), m65952c(bArr2, 0)));
    }

    /* renamed from: c */
    public static SecretKeySpec m65952c(byte[] bArr, int i10) {
        if (i10 <= 0 || i10 > bArr.length) {
            i10 = bArr.length;
        }
        if (i10 > 16) {
            i10 = 16;
        }
        byte[] bArr2 = new byte[16];
        for (int i11 = 0; i11 < 16; i11++) {
            bArr2[i11] = 0;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = bArr[i12];
        }
        return new SecretKeySpec(bArr2, 0, 16, "AES/CBC/PKCS5Padding");
    }
}
