package p640sq;

import gu.C10048b;
import java.security.SecureRandom;
import java.util.UUID;

/* renamed from: sq.u */
/* loaded from: classes8.dex */
public final class C12842u {
    /* renamed from: a */
    public static SecureRandom m77122a() {
        C12836o.m77097b("SecureRandomFactory", "getSecureRandom", true);
        return C10048b.m62471c();
    }

    /* renamed from: b */
    public static String m77123b() {
        try {
            byte[] bArr = new byte[18];
            C10048b.m62471c().nextBytes(bArr);
            return C12826e.m77026a(bArr);
        } catch (Exception e10) {
            C12836o.m77099d("SecureRandomFactory", "Exception:" + e10.getClass().getSimpleName(), true);
            return UUID.randomUUID().toString();
        }
    }
}
