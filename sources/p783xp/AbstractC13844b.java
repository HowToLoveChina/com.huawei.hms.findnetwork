package p783xp;

import java.security.NoSuchAlgorithmException;
import p525ok.C11908a;

/* renamed from: xp.b */
/* loaded from: classes8.dex */
public abstract class AbstractC13844b {
    /* renamed from: a */
    public static String m83105a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m83106b() throws NoSuchAlgorithmException {
        byte[] bArr = new byte[16];
        C11908a.m71442a().nextBytes(bArr);
        return m83105a(bArr);
    }
}
