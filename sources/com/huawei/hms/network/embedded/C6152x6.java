package com.huawei.hms.network.embedded;

import com.baidu.location.BDLocation;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hms.network.embedded.C6152x6;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.x6 */
/* loaded from: classes8.dex */
public final class C6152x6 {

    /* renamed from: a */
    public final String f29072a;

    /* renamed from: b */
    public static final Comparator<String> f29005b = new Comparator() { // from class: gq.h
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C6152x6.m35781a((String) obj, (String) obj2);
        }
    };

    /* renamed from: c */
    public static final Map<String, C6152x6> f29008c = new LinkedHashMap();

    /* renamed from: d */
    public static final C6152x6 f29011d = m35783a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: e */
    public static final C6152x6 f29014e = m35783a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: f */
    public static final C6152x6 f29017f = m35783a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: g */
    public static final C6152x6 f29020g = m35783a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: h */
    public static final C6152x6 f29023h = m35783a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: i */
    public static final C6152x6 f29026i = m35783a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: j */
    public static final C6152x6 f29029j = m35783a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: k */
    public static final C6152x6 f29032k = m35783a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: l */
    public static final C6152x6 f29035l = m35783a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: m */
    public static final C6152x6 f29038m = m35783a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: n */
    public static final C6152x6 f29041n = m35783a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: o */
    public static final C6152x6 f29044o = m35783a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: p */
    public static final C6152x6 f29047p = m35783a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: q */
    public static final C6152x6 f29050q = m35783a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: r */
    public static final C6152x6 f29053r = m35783a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: s */
    public static final C6152x6 f29056s = m35783a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: t */
    public static final C6152x6 f29058t = m35783a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: u */
    public static final C6152x6 f29060u = m35783a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: v */
    public static final C6152x6 f29062v = m35783a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: w */
    public static final C6152x6 f29064w = m35783a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: x */
    public static final C6152x6 f29066x = m35783a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: y */
    public static final C6152x6 f29068y = m35783a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: z */
    public static final C6152x6 f29070z = m35783a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: A */
    public static final C6152x6 f28951A = m35783a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: B */
    public static final C6152x6 f28953B = m35783a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: C */
    public static final C6152x6 f28955C = m35783a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: D */
    public static final C6152x6 f28957D = m35783a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: E */
    public static final C6152x6 f28959E = m35783a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: F */
    public static final C6152x6 f28961F = m35783a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: G */
    public static final C6152x6 f28963G = m35783a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: H */
    public static final C6152x6 f28965H = m35783a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: I */
    public static final C6152x6 f28967I = m35783a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: J */
    public static final C6152x6 f28969J = m35783a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: K */
    public static final C6152x6 f28971K = m35783a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: L */
    public static final C6152x6 f28973L = m35783a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: M */
    public static final C6152x6 f28975M = m35783a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: N */
    public static final C6152x6 f28977N = m35783a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: O */
    public static final C6152x6 f28979O = m35783a("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: P */
    public static final C6152x6 f28981P = m35783a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: Q */
    public static final C6152x6 f28983Q = m35783a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: R */
    public static final C6152x6 f28985R = m35783a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: S */
    public static final C6152x6 f28987S = m35783a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: T */
    public static final C6152x6 f28989T = m35783a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: U */
    public static final C6152x6 f28991U = m35783a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: V */
    public static final C6152x6 f28993V = m35783a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: W */
    public static final C6152x6 f28995W = m35783a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: X */
    public static final C6152x6 f28997X = m35783a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: Y */
    public static final C6152x6 f28999Y = m35783a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: Z */
    public static final C6152x6 f29001Z = m35783a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: a0 */
    public static final C6152x6 f29003a0 = m35783a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", SyncType.AUTO_SYNC_RECORD);

    /* renamed from: b0 */
    public static final C6152x6 f29006b0 = m35783a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", SyncType.RISK_MANAGEMENT_MANUALLY);

    /* renamed from: c0 */
    public static final C6152x6 f29009c0 = m35783a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", SyncType.AUTO_SYNC_PHONE_MANAGER);

    /* renamed from: d0 */
    public static final C6152x6 f29012d0 = m35783a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: e0 */
    public static final C6152x6 f29015e0 = m35783a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: f0 */
    public static final C6152x6 f29018f0 = m35783a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: g0 */
    public static final C6152x6 f29021g0 = m35783a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: h0 */
    public static final C6152x6 f29024h0 = m35783a("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: i0 */
    public static final C6152x6 f29027i0 = m35783a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: j0 */
    public static final C6152x6 f29030j0 = m35783a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: k0 */
    public static final C6152x6 f29033k0 = m35783a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: l0 */
    public static final C6152x6 f29036l0 = m35783a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: m0 */
    public static final C6152x6 f29039m0 = m35783a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: n0 */
    public static final C6152x6 f29042n0 = m35783a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: o0 */
    public static final C6152x6 f29045o0 = m35783a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: p0 */
    public static final C6152x6 f29048p0 = m35783a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", BDLocation.TypeServerError);

    /* renamed from: q0 */
    public static final C6152x6 f29051q0 = m35783a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);

    /* renamed from: r0 */
    public static final C6152x6 f29054r0 = m35783a("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: s0 */
    public static final C6152x6 f29057s0 = m35783a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: t0 */
    public static final C6152x6 f29059t0 = m35783a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: u0 */
    public static final C6152x6 f29061u0 = m35783a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: v0 */
    public static final C6152x6 f29063v0 = m35783a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: w0 */
    public static final C6152x6 f29065w0 = m35783a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: x0 */
    public static final C6152x6 f29067x0 = m35783a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: y0 */
    public static final C6152x6 f29069y0 = m35783a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: z0 */
    public static final C6152x6 f29071z0 = m35783a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: A0 */
    public static final C6152x6 f28952A0 = m35783a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: B0 */
    public static final C6152x6 f28954B0 = m35783a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: C0 */
    public static final C6152x6 f28956C0 = m35783a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: D0 */
    public static final C6152x6 f28958D0 = m35783a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: E0 */
    public static final C6152x6 f28960E0 = m35783a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: F0 */
    public static final C6152x6 f28962F0 = m35783a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: G0 */
    public static final C6152x6 f28964G0 = m35783a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: H0 */
    public static final C6152x6 f28966H0 = m35783a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: I0 */
    public static final C6152x6 f28968I0 = m35783a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: J0 */
    public static final C6152x6 f28970J0 = m35783a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: K0 */
    public static final C6152x6 f28972K0 = m35783a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: L0 */
    public static final C6152x6 f28974L0 = m35783a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: M0 */
    public static final C6152x6 f28976M0 = m35783a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: N0 */
    public static final C6152x6 f28978N0 = m35783a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: O0 */
    public static final C6152x6 f28980O0 = m35783a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: P0 */
    public static final C6152x6 f28982P0 = m35783a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: Q0 */
    public static final C6152x6 f28984Q0 = m35783a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: R0 */
    public static final C6152x6 f28986R0 = m35783a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: S0 */
    public static final C6152x6 f28988S0 = m35783a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: T0 */
    public static final C6152x6 f28990T0 = m35783a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: U0 */
    public static final C6152x6 f28992U0 = m35783a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: V0 */
    public static final C6152x6 f28994V0 = m35783a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: W0 */
    public static final C6152x6 f28996W0 = m35783a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: X0 */
    public static final C6152x6 f28998X0 = m35783a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: Y0 */
    public static final C6152x6 f29000Y0 = m35783a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: Z0 */
    public static final C6152x6 f29002Z0 = m35783a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: a1 */
    public static final C6152x6 f29004a1 = m35783a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b1 */
    public static final C6152x6 f29007b1 = m35783a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c1 */
    public static final C6152x6 f29010c1 = m35783a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d1 */
    public static final C6152x6 f29013d1 = m35783a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e1 */
    public static final C6152x6 f29016e1 = m35783a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f1 */
    public static final C6152x6 f29019f1 = m35783a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g1 */
    public static final C6152x6 f29022g1 = m35783a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h1 */
    public static final C6152x6 f29025h1 = m35783a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i1 */
    public static final C6152x6 f29028i1 = m35783a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j1 */
    public static final C6152x6 f29031j1 = m35783a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k1 */
    public static final C6152x6 f29034k1 = m35783a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l1 */
    public static final C6152x6 f29037l1 = m35783a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: m1 */
    public static final C6152x6 f29040m1 = m35783a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: n1 */
    public static final C6152x6 f29043n1 = m35783a("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: o1 */
    public static final C6152x6 f29046o1 = m35783a("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: p1 */
    public static final C6152x6 f29049p1 = m35783a("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: q1 */
    public static final C6152x6 f29052q1 = m35783a("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: r1 */
    public static final C6152x6 f29055r1 = m35783a("TLS_AES_128_CCM_8_SHA256", 4869);

    public C6152x6(String str) {
        str.getClass();
        this.f29072a = str;
    }

    /* renamed from: a */
    public static /* synthetic */ int m35781a(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i10 = 4; i10 < iMin; i10++) {
            char cCharAt = str.charAt(i10);
            char cCharAt2 = str2.charAt(i10);
            if (cCharAt != cCharAt2) {
                return cCharAt < cCharAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    /* renamed from: b */
    public static String m35785b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String toString() {
        return this.f29072a;
    }

    /* renamed from: a */
    public static synchronized C6152x6 m35782a(String str) {
        C6152x6 c6152x6;
        try {
            Map<String, C6152x6> map = f29008c;
            c6152x6 = map.get(str);
            if (c6152x6 == null) {
                c6152x6 = map.get(m35785b(str));
                if (c6152x6 == null) {
                    c6152x6 = new C6152x6(str);
                }
                map.put(str, c6152x6);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return c6152x6;
    }

    /* renamed from: a */
    public static C6152x6 m35783a(String str, int i10) {
        C6152x6 c6152x6 = new C6152x6(str);
        f29008c.put(str, c6152x6);
        return c6152x6;
    }

    /* renamed from: a */
    public String m35786a() {
        return this.f29072a;
    }

    /* renamed from: a */
    public static List<C6152x6> m35784a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m35782a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
