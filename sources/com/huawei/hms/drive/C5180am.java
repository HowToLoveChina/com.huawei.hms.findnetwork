package com.huawei.hms.drive;

import com.baidu.location.BDLocation;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.drive.am */
/* loaded from: classes8.dex */
public final class C5180am {

    /* renamed from: bq */
    final String f23736bq;

    /* renamed from: a */
    static final Comparator<String> f23641a = new Comparator() { // from class: com.huawei.hms.drive.b0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C5180am.m30846a((String) obj, (String) obj2);
        }
    };

    /* renamed from: br */
    private static final Map<String, C5180am> f23711br = new LinkedHashMap();

    /* renamed from: b */
    public static final C5180am f23694b = m30848a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: c */
    public static final C5180am f23712c = m30848a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: d */
    public static final C5180am f23713d = m30848a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: e */
    public static final C5180am f23714e = m30848a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: f */
    public static final C5180am f23715f = m30848a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: g */
    public static final C5180am f23716g = m30848a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: h */
    public static final C5180am f23717h = m30848a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: i */
    public static final C5180am f23718i = m30848a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: j */
    public static final C5180am f23719j = m30848a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: k */
    public static final C5180am f23720k = m30848a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: l */
    public static final C5180am f23721l = m30848a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: m */
    public static final C5180am f23722m = m30848a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: n */
    public static final C5180am f23723n = m30848a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: o */
    public static final C5180am f23724o = m30848a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: p */
    public static final C5180am f23725p = m30848a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: q */
    public static final C5180am f23726q = m30848a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: r */
    public static final C5180am f23727r = m30848a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: s */
    public static final C5180am f23728s = m30848a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: t */
    public static final C5180am f23729t = m30848a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: u */
    public static final C5180am f23730u = m30848a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: v */
    public static final C5180am f23731v = m30848a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: w */
    public static final C5180am f23732w = m30848a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: x */
    public static final C5180am f23733x = m30848a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: y */
    public static final C5180am f23734y = m30848a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: z */
    public static final C5180am f23735z = m30848a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: A */
    public static final C5180am f23615A = m30848a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: B */
    public static final C5180am f23616B = m30848a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: C */
    public static final C5180am f23617C = m30848a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: D */
    public static final C5180am f23618D = m30848a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: E */
    public static final C5180am f23619E = m30848a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: F */
    public static final C5180am f23620F = m30848a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: G */
    public static final C5180am f23621G = m30848a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: H */
    public static final C5180am f23622H = m30848a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: I */
    public static final C5180am f23623I = m30848a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: J */
    public static final C5180am f23624J = m30848a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: K */
    public static final C5180am f23625K = m30848a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: L */
    public static final C5180am f23626L = m30848a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: M */
    public static final C5180am f23627M = m30848a("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: N */
    public static final C5180am f23628N = m30848a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: O */
    public static final C5180am f23629O = m30848a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: P */
    public static final C5180am f23630P = m30848a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: Q */
    public static final C5180am f23631Q = m30848a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: R */
    public static final C5180am f23632R = m30848a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: S */
    public static final C5180am f23633S = m30848a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: T */
    public static final C5180am f23634T = m30848a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: U */
    public static final C5180am f23635U = m30848a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: V */
    public static final C5180am f23636V = m30848a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: W */
    public static final C5180am f23637W = m30848a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: X */
    public static final C5180am f23638X = m30848a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: Y */
    public static final C5180am f23639Y = m30848a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", SyncType.AUTO_SYNC_RECORD);

    /* renamed from: Z */
    public static final C5180am f23640Z = m30848a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", SyncType.RISK_MANAGEMENT_MANUALLY);

    /* renamed from: aa */
    public static final C5180am f23668aa = m30848a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", SyncType.AUTO_SYNC_PHONE_MANAGER);

    /* renamed from: ab */
    public static final C5180am f23669ab = m30848a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: ac */
    public static final C5180am f23670ac = m30848a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: ad */
    public static final C5180am f23671ad = m30848a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: ae */
    public static final C5180am f23672ae = m30848a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: af */
    public static final C5180am f23673af = m30848a("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: ag */
    public static final C5180am f23674ag = m30848a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: ah */
    public static final C5180am f23675ah = m30848a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: ai */
    public static final C5180am f23676ai = m30848a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: aj */
    public static final C5180am f23677aj = m30848a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: ak */
    public static final C5180am f23678ak = m30848a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: al */
    public static final C5180am f23679al = m30848a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: am */
    public static final C5180am f23680am = m30848a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: an */
    public static final C5180am f23681an = m30848a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", BDLocation.TypeServerError);

    /* renamed from: ao */
    public static final C5180am f23682ao = m30848a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);

    /* renamed from: ap */
    public static final C5180am f23683ap = m30848a("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: aq */
    public static final C5180am f23684aq = m30848a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: ar */
    public static final C5180am f23685ar = m30848a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: as */
    public static final C5180am f23686as = m30848a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: at */
    public static final C5180am f23687at = m30848a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: au */
    public static final C5180am f23688au = m30848a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: av */
    public static final C5180am f23689av = m30848a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: aw */
    public static final C5180am f23690aw = m30848a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: ax */
    public static final C5180am f23691ax = m30848a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: ay */
    public static final C5180am f23692ay = m30848a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: az */
    public static final C5180am f23693az = m30848a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: aA */
    public static final C5180am f23642aA = m30848a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: aB */
    public static final C5180am f23643aB = m30848a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: aC */
    public static final C5180am f23644aC = m30848a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: aD */
    public static final C5180am f23645aD = m30848a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: aE */
    public static final C5180am f23646aE = m30848a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: aF */
    public static final C5180am f23647aF = m30848a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: aG */
    public static final C5180am f23648aG = m30848a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: aH */
    public static final C5180am f23649aH = m30848a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: aI */
    public static final C5180am f23650aI = m30848a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: aJ */
    public static final C5180am f23651aJ = m30848a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: aK */
    public static final C5180am f23652aK = m30848a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: aL */
    public static final C5180am f23653aL = m30848a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: aM */
    public static final C5180am f23654aM = m30848a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: aN */
    public static final C5180am f23655aN = m30848a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: aO */
    public static final C5180am f23656aO = m30848a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: aP */
    public static final C5180am f23657aP = m30848a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: aQ */
    public static final C5180am f23658aQ = m30848a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: aR */
    public static final C5180am f23659aR = m30848a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: aS */
    public static final C5180am f23660aS = m30848a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: aT */
    public static final C5180am f23661aT = m30848a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: aU */
    public static final C5180am f23662aU = m30848a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: aV */
    public static final C5180am f23663aV = m30848a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: aW */
    public static final C5180am f23664aW = m30848a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: aX */
    public static final C5180am f23665aX = m30848a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: aY */
    public static final C5180am f23666aY = m30848a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: aZ */
    public static final C5180am f23667aZ = m30848a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: ba */
    public static final C5180am f23695ba = m30848a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: bb */
    public static final C5180am f23696bb = m30848a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: bc */
    public static final C5180am f23697bc = m30848a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: bd */
    public static final C5180am f23698bd = m30848a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: be */
    public static final C5180am f23699be = m30848a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: bf */
    public static final C5180am f23700bf = m30848a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: bg */
    public static final C5180am f23701bg = m30848a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: bh */
    public static final C5180am f23702bh = m30848a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: bi */
    public static final C5180am f23703bi = m30848a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: bj */
    public static final C5180am f23704bj = m30848a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: bk */
    public static final C5180am f23705bk = m30848a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: bl */
    public static final C5180am f23706bl = m30848a("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: bm */
    public static final C5180am f23707bm = m30848a("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: bn */
    public static final C5180am f23708bn = m30848a("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: bo */
    public static final C5180am f23709bo = m30848a("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: bp */
    public static final C5180am f23710bp = m30848a("TLS_AES_128_CCM_8_SHA256", 4869);

    private C5180am(String str) {
        str.getClass();
        this.f23736bq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m30846a(String str, String str2) {
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

    public String toString() {
        return this.f23736bq;
    }

    /* renamed from: b */
    private static String m30851b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    /* renamed from: a */
    public static synchronized C5180am m30847a(String str) {
        C5180am c5180am;
        try {
            Map<String, C5180am> map = f23711br;
            c5180am = map.get(str);
            if (c5180am == null) {
                c5180am = map.get(m30851b(str));
                if (c5180am == null) {
                    c5180am = new C5180am(str);
                }
                map.put(str, c5180am);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return c5180am;
    }

    /* renamed from: a */
    public static List<C5180am> m30849a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m30847a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private static C5180am m30848a(String str, int i10) {
        C5180am c5180am = new C5180am(str);
        f23711br.put(str, c5180am);
        return c5180am;
    }
}
