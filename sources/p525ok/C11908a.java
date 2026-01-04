package p525ok;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: ok.a */
/* loaded from: classes6.dex */
public class C11908a {
    /* renamed from: a */
    public static SecureRandom m71442a() throws NoSuchAlgorithmException {
        return SecureRandom.getInstanceStrong();
    }

    /* renamed from: b */
    public static byte[] m71443b(int i10) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[i10];
        m71442a().nextBytes(bArr);
        return bArr;
    }
}
