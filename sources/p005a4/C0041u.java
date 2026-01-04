package p005a4;

import java.security.SecureRandom;

/* renamed from: a4.u */
/* loaded from: classes.dex */
public final class C0041u {

    /* renamed from: a */
    public static final ThreadLocal<SecureRandom> f106a = new a();

    /* renamed from: a4.u$a */
    public class a extends ThreadLocal<SecureRandom> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SecureRandom initialValue() {
            return C0041u.m160b();
        }
    }

    /* renamed from: b */
    public static SecureRandom m160b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    /* renamed from: c */
    public static byte[] m161c(int i10) {
        byte[] bArr = new byte[i10];
        f106a.get().nextBytes(bArr);
        return bArr;
    }
}
