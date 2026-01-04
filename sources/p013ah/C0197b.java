package p013ah;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: ah.b */
/* loaded from: classes4.dex */
public final class C0197b {
    /* renamed from: a */
    public static byte[] m1096a(String str, byte[] bArr, int i10) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return C0196a.m1092a(AbstractC0199d.m1100a(str), 0, bArr, i10);
    }
}
