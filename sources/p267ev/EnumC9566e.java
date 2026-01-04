package p267ev;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ev.e */
/* loaded from: classes9.dex */
public enum EnumC9566e {
    UNKNOWN("UNKNOWN", "UNKNOWN"),
    ECDSA("EC", "SHA256WithECDSA"),
    RSA_SHA256("RSA_SHA256", "SHA256WithRSA"),
    RSA_SHA256_PSS("RSA_SHA256_PSS", "SHA256withRSA/PSS"),
    HMAC_SHA256("HmacSHA256", "HmacSHA256");


    /* renamed from: h */
    public static final Map<String, String> f47492h = new HashMap();

    /* renamed from: i */
    public static final Map<String, EnumC9566e> f47493i = new HashMap();

    /* renamed from: a */
    public final String f47495a;

    /* renamed from: b */
    public final String f47496b;

    static {
        Iterator it = EnumSet.allOf(EnumC9566e.class).iterator();
        while (it.hasNext()) {
            EnumC9566e enumC9566e = (EnumC9566e) it.next();
            f47492h.put(enumC9566e.f47495a, enumC9566e.f47496b);
        }
        Map<String, EnumC9566e> map = f47493i;
        map.put("EC", ECDSA);
        map.put("RSA", RSA_SHA256);
        map.put("HMAC", HMAC_SHA256);
    }

    EnumC9566e(String str, String str2) {
        this.f47495a = str;
        this.f47496b = str2;
    }

    /* renamed from: b */
    public static EnumC9566e m59694b(String str) {
        return f47493i.get(str);
    }

    /* renamed from: e */
    public String m59695e() {
        return this.f47496b;
    }
}
