package p612rg;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import p013ah.AbstractC0199d;

/* renamed from: rg.b */
/* loaded from: classes4.dex */
public final class C12509b {
    /* renamed from: a */
    public static byte[] m75101a(String str, byte[] bArr, int i10) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return C12508a.m75097c(AbstractC0199d.m1100a(str), 0, bArr, i10);
    }

    /* renamed from: b */
    public static String m75102b(byte[] bArr, int i10, byte[] bArr2, int i11) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return AbstractC0199d.m1101b(C12508a.m75098d(bArr, i10, bArr2, i11), 0);
    }
}
