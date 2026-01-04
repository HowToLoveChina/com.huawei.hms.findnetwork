package okhttp3;

import com.baidu.location.BDLocation;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: okhttp3.j */
/* loaded from: classes9.dex */
public final class C11942j {

    /* renamed from: a */
    public final String f55600a;

    /* renamed from: b */
    public static final Comparator<String> f55533b = new Comparator() { // from class: okhttp3.i
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C11942j.m71789f((String) obj, (String) obj2);
        }
    };

    /* renamed from: c */
    public static final Map<String, C11942j> f55536c = new LinkedHashMap();

    /* renamed from: d */
    public static final C11942j f55539d = m71788d("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: e */
    public static final C11942j f55542e = m71788d("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: f */
    public static final C11942j f55545f = m71788d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: g */
    public static final C11942j f55548g = m71788d("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: h */
    public static final C11942j f55551h = m71788d("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: i */
    public static final C11942j f55554i = m71788d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: j */
    public static final C11942j f55557j = m71788d("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: k */
    public static final C11942j f55560k = m71788d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: l */
    public static final C11942j f55563l = m71788d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: m */
    public static final C11942j f55566m = m71788d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: n */
    public static final C11942j f55569n = m71788d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: o */
    public static final C11942j f55572o = m71788d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: p */
    public static final C11942j f55575p = m71788d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: q */
    public static final C11942j f55578q = m71788d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: r */
    public static final C11942j f55581r = m71788d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: s */
    public static final C11942j f55584s = m71788d("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: t */
    public static final C11942j f55586t = m71788d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: u */
    public static final C11942j f55588u = m71788d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: v */
    public static final C11942j f55590v = m71788d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: w */
    public static final C11942j f55592w = m71788d("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: x */
    public static final C11942j f55594x = m71788d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: y */
    public static final C11942j f55596y = m71788d("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: z */
    public static final C11942j f55598z = m71788d("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: A */
    public static final C11942j f55479A = m71788d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: B */
    public static final C11942j f55481B = m71788d("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: C */
    public static final C11942j f55483C = m71788d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: D */
    public static final C11942j f55485D = m71788d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: E */
    public static final C11942j f55487E = m71788d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: F */
    public static final C11942j f55489F = m71788d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: G */
    public static final C11942j f55491G = m71788d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: H */
    public static final C11942j f55493H = m71788d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: I */
    public static final C11942j f55495I = m71788d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: J */
    public static final C11942j f55497J = m71788d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: K */
    public static final C11942j f55499K = m71788d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: L */
    public static final C11942j f55501L = m71788d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: M */
    public static final C11942j f55503M = m71788d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: N */
    public static final C11942j f55505N = m71788d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: O */
    public static final C11942j f55507O = m71788d("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: P */
    public static final C11942j f55509P = m71788d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: Q */
    public static final C11942j f55511Q = m71788d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: R */
    public static final C11942j f55513R = m71788d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: S */
    public static final C11942j f55515S = m71788d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: T */
    public static final C11942j f55517T = m71788d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: U */
    public static final C11942j f55519U = m71788d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: V */
    public static final C11942j f55521V = m71788d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: W */
    public static final C11942j f55523W = m71788d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: X */
    public static final C11942j f55525X = m71788d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: Y */
    public static final C11942j f55527Y = m71788d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: Z */
    public static final C11942j f55529Z = m71788d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: a0 */
    public static final C11942j f55531a0 = m71788d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", SyncType.AUTO_SYNC_RECORD);

    /* renamed from: b0 */
    public static final C11942j f55534b0 = m71788d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", SyncType.RISK_MANAGEMENT_MANUALLY);

    /* renamed from: c0 */
    public static final C11942j f55537c0 = m71788d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", SyncType.AUTO_SYNC_PHONE_MANAGER);

    /* renamed from: d0 */
    public static final C11942j f55540d0 = m71788d("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: e0 */
    public static final C11942j f55543e0 = m71788d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: f0 */
    public static final C11942j f55546f0 = m71788d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: g0 */
    public static final C11942j f55549g0 = m71788d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: h0 */
    public static final C11942j f55552h0 = m71788d("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: i0 */
    public static final C11942j f55555i0 = m71788d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: j0 */
    public static final C11942j f55558j0 = m71788d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: k0 */
    public static final C11942j f55561k0 = m71788d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: l0 */
    public static final C11942j f55564l0 = m71788d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: m0 */
    public static final C11942j f55567m0 = m71788d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: n0 */
    public static final C11942j f55570n0 = m71788d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: o0 */
    public static final C11942j f55573o0 = m71788d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: p0 */
    public static final C11942j f55576p0 = m71788d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", BDLocation.TypeServerError);

    /* renamed from: q0 */
    public static final C11942j f55579q0 = m71788d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);

    /* renamed from: r0 */
    public static final C11942j f55582r0 = m71788d("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: s0 */
    public static final C11942j f55585s0 = m71788d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: t0 */
    public static final C11942j f55587t0 = m71788d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: u0 */
    public static final C11942j f55589u0 = m71788d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: v0 */
    public static final C11942j f55591v0 = m71788d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: w0 */
    public static final C11942j f55593w0 = m71788d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: x0 */
    public static final C11942j f55595x0 = m71788d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: y0 */
    public static final C11942j f55597y0 = m71788d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: z0 */
    public static final C11942j f55599z0 = m71788d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: A0 */
    public static final C11942j f55480A0 = m71788d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: B0 */
    public static final C11942j f55482B0 = m71788d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: C0 */
    public static final C11942j f55484C0 = m71788d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: D0 */
    public static final C11942j f55486D0 = m71788d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: E0 */
    public static final C11942j f55488E0 = m71788d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: F0 */
    public static final C11942j f55490F0 = m71788d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: G0 */
    public static final C11942j f55492G0 = m71788d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: H0 */
    public static final C11942j f55494H0 = m71788d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: I0 */
    public static final C11942j f55496I0 = m71788d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: J0 */
    public static final C11942j f55498J0 = m71788d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: K0 */
    public static final C11942j f55500K0 = m71788d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: L0 */
    public static final C11942j f55502L0 = m71788d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: M0 */
    public static final C11942j f55504M0 = m71788d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: N0 */
    public static final C11942j f55506N0 = m71788d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: O0 */
    public static final C11942j f55508O0 = m71788d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: P0 */
    public static final C11942j f55510P0 = m71788d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: Q0 */
    public static final C11942j f55512Q0 = m71788d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: R0 */
    public static final C11942j f55514R0 = m71788d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: S0 */
    public static final C11942j f55516S0 = m71788d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: T0 */
    public static final C11942j f55518T0 = m71788d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: U0 */
    public static final C11942j f55520U0 = m71788d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: V0 */
    public static final C11942j f55522V0 = m71788d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: W0 */
    public static final C11942j f55524W0 = m71788d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: X0 */
    public static final C11942j f55526X0 = m71788d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: Y0 */
    public static final C11942j f55528Y0 = m71788d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: Z0 */
    public static final C11942j f55530Z0 = m71788d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: a1 */
    public static final C11942j f55532a1 = m71788d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b1 */
    public static final C11942j f55535b1 = m71788d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c1 */
    public static final C11942j f55538c1 = m71788d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d1 */
    public static final C11942j f55541d1 = m71788d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e1 */
    public static final C11942j f55544e1 = m71788d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f1 */
    public static final C11942j f55547f1 = m71788d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g1 */
    public static final C11942j f55550g1 = m71788d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h1 */
    public static final C11942j f55553h1 = m71788d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i1 */
    public static final C11942j f55556i1 = m71788d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j1 */
    public static final C11942j f55559j1 = m71788d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k1 */
    public static final C11942j f55562k1 = m71788d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l1 */
    public static final C11942j f55565l1 = m71788d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: m1 */
    public static final C11942j f55568m1 = m71788d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: n1 */
    public static final C11942j f55571n1 = m71788d("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: o1 */
    public static final C11942j f55574o1 = m71788d("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: p1 */
    public static final C11942j f55577p1 = m71788d("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: q1 */
    public static final C11942j f55580q1 = m71788d("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: r1 */
    public static final C11942j f55583r1 = m71788d("TLS_AES_128_CCM_8_SHA256", 4869);

    public C11942j(String str) {
        str.getClass();
        this.f55600a = str;
    }

    /* renamed from: b */
    public static synchronized C11942j m71786b(String str) {
        C11942j c11942j;
        try {
            Map<String, C11942j> map = f55536c;
            c11942j = map.get(str);
            if (c11942j == null) {
                c11942j = map.get(m71790g(str));
                if (c11942j == null) {
                    c11942j = new C11942j(str);
                }
                map.put(str, c11942j);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return c11942j;
    }

    /* renamed from: c */
    public static List<C11942j> m71787c(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m71786b(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: d */
    public static C11942j m71788d(String str, int i10) {
        C11942j c11942j = new C11942j(str);
        f55536c.put(str, c11942j);
        return c11942j;
    }

    /* renamed from: f */
    public static /* synthetic */ int m71789f(String str, String str2) {
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

    /* renamed from: g */
    public static String m71790g(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    /* renamed from: e */
    public String m71791e() {
        return this.f55600a;
    }

    public String toString() {
        return this.f55600a;
    }
}
