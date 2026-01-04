package p782xo;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;
import p713vo.C13475c;
import p746wn.C13622a;
import p817yo.C14029a;
import p817yo.C14030b;
import p817yo.C14031c;
import p817yo.C14032d;
import p817yo.C14033e;

/* renamed from: xo.a */
/* loaded from: classes6.dex */
public class C13842a {

    /* renamed from: a */
    public long f62084a;

    /* renamed from: b */
    public String f62085b;

    /* renamed from: c */
    public String f62086c;

    /* renamed from: d */
    public String f62087d;

    /* renamed from: e */
    public String f62088e;

    /* renamed from: f */
    public String f62089f;

    /* renamed from: g */
    public String f62090g;

    /* renamed from: xo.a$b */
    public static class b {

        /* renamed from: a */
        public static C13842a f62091a = new C13842a();
    }

    /* renamed from: i */
    public static C13842a m83010i() {
        return b.f62091a;
    }

    /* renamed from: A */
    public final synchronized String m83011A() {
        if (m83040s(this.f62087d, "local", "hmacsha256_key_common_string")) {
            return this.f62087d;
        }
        return m83047z();
    }

    /* renamed from: B */
    public final void m83012B() {
        C12515a.m75110o().m75175e(new C14031c(), true);
    }

    /* renamed from: C */
    public final synchronized String m83013C() {
        if (!TextUtils.isEmpty(this.f62089f)) {
            return this.f62089f;
        }
        String strM81153q = new C13475c(C11058a.m66627b("07025")).m81153q(100, 7);
        if (TextUtils.isEmpty(strM81153q)) {
            C11839m.m70687e("QueryKeyManager", "ByNow obtain exponent key fail");
            return "";
        }
        this.f62089f = strM81153q;
        m83019I("rsa_key_common_trust_circle_exponent", strM81153q);
        return strM81153q;
    }

    /* renamed from: D */
    public final void m83014D() {
        C12515a.m75110o().m75175e(new C14032d(), true);
    }

    /* renamed from: E */
    public final synchronized String m83015E() {
        if (!TextUtils.isEmpty(this.f62088e)) {
            return this.f62088e;
        }
        String strM81153q = new C13475c(C11058a.m66627b("07025")).m81153q(100, 6);
        if (TextUtils.isEmpty(strM81153q)) {
            C11839m.m70687e("QueryKeyManager", "ByNow obtain modulus key fail");
            return "";
        }
        this.f62088e = strM81153q;
        m83019I("rsa_key_common_trust_circle_modulus", strM81153q);
        return strM81153q;
    }

    /* renamed from: F */
    public final void m83016F() {
        C12515a.m75110o().m75175e(new C14033e(), true);
    }

    /* renamed from: G */
    public void m83017G(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return;
        }
        C0212e0.m1374x(contextM1377a, "query_key", str);
        C0212e0.m1375y(contextM1377a, "query_key", str);
        m83026d();
    }

    /* renamed from: H */
    public void m83018H(String str, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(this.f62090g, "QueryKeyCompareSHA256", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reportInfo", str);
        linkedHashMap.put("spKey", str2);
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: I */
    public void m83019I(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70687e("QueryKeyManager", "key is empty");
        }
        String strM1593f = C0227m.m1593f(str2);
        if (TextUtils.isEmpty(strM1593f)) {
            C11839m.m70687e("QueryKeyManager", "set key compute SHA256 error");
            m83018H("set key compute SHA256 error", str);
            return;
        }
        String strM68634d = C11477c.m68634d(strM1593f);
        if (TextUtils.isEmpty(strM68634d)) {
            C11839m.m70687e("QueryKeyManager", "set key SHA256 keystore error");
            m83018H("set key SHA256 keystore error", str);
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return;
        }
        str.hashCode();
        switch (str) {
            case "rsa_key_common_trust_circle_exponent":
                C0212e0.m1373w(contextM1377a, "query_key", str, C11477c.m68634d(str2));
                C0212e0.m1373w(contextM1377a, "query_key", "rsa_key_common_trust_circle_exponent_sha256", strM68634d);
                C11839m.m70688i("QueryKeyManager", "set exponent key");
                break;
            case "hmacsha256_key_common_file":
                C0212e0.m1366p(contextM1377a, "query_key", "is_hmacsha256_key_common_file_length_256", true);
                C0212e0.m1373w(contextM1377a, "query_key", str, C11477c.m68634d(str2));
                C0212e0.m1373w(contextM1377a, "query_key", "hmacsha256_key_common_file_sha256", strM68634d);
                C11839m.m70688i("QueryKeyManager", "set file key");
                break;
            case "cbc_key_common_accountandbackup":
                C0212e0.m1366p(contextM1377a, "query_key", "is_cbc_key_common_accountandbackup_length_256", true);
                C0212e0.m1373w(contextM1377a, "query_key", str, C11477c.m68634d(str2));
                C0212e0.m1373w(contextM1377a, "query_key", "cbc_key_common_accountandbackup_SHA256", strM68634d);
                C11839m.m70688i("QueryKeyManager", "set common account and backup key");
                break;
            case "rsa_key_common_trust_circle_modulus":
                C0212e0.m1373w(contextM1377a, "query_key", str, C11477c.m68634d(str2));
                C0212e0.m1373w(contextM1377a, "query_key", "rsa_key_common_trust_circle_modulus_sha256", strM68634d);
                C11839m.m70688i("QueryKeyManager", "set modulus key");
                break;
            case "hmacsha256_key_common_string":
                C0212e0.m1366p(contextM1377a, "query_key", "is_hmacsha256_key_common_string_length_256", true);
                C0212e0.m1373w(contextM1377a, "query_key", str, C11477c.m68634d(str2));
                C0212e0.m1373w(contextM1377a, "query_key", "hmacsha256_key_common_string_sha256", strM68634d);
                C11839m.m70688i("QueryKeyManager", "set string key");
                break;
            default:
                C11839m.m70687e("QueryKeyManager", "setKeyToSP bad branch");
                break;
        }
    }

    /* renamed from: J */
    public void m83020J() {
        this.f62084a = System.currentTimeMillis();
        C11839m.m70688i("QueryKeyManager", "query key fail, time: " + this.f62084a);
    }

    /* renamed from: K */
    public void m83021K(String str) {
        this.f62089f = str;
    }

    /* renamed from: L */
    public void m83022L(String str) {
        this.f62088e = str;
    }

    /* renamed from: a */
    public void m83023a() {
        if (!m83035n()) {
            C11839m.m70688i("QueryKeyManager", "common account and backup key is empty, start to obtain");
            m83032k("cbc_key_common_accountandbackup");
        }
        if (!m83036o()) {
            C11839m.m70688i("QueryKeyManager", "file key is empty, start to obtain");
            m83032k("hmacsha256_key_common_file");
        }
        if (!m83037p()) {
            C11839m.m70688i("QueryKeyManager", "string key is empty, start to obtain");
            m83032k("hmacsha256_key_common_string");
        }
        if (TextUtils.isEmpty(m83033l("rsa_key_common_trust_circle_modulus"))) {
            C11839m.m70688i("QueryKeyManager", "modulus key is empty, start to obtain");
            m83032k("rsa_key_common_trust_circle_modulus");
        }
        if (TextUtils.isEmpty(m83033l("rsa_key_common_trust_circle_exponent"))) {
            C11839m.m70688i("QueryKeyManager", "exponent key is empty, start to obtain");
            m83032k("rsa_key_common_trust_circle_exponent");
        }
    }

    /* renamed from: b */
    public final void m83024b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() % 2 == 0) {
            return;
        }
        String str3 = "local sp key length is error, length is: " + str2.length();
        C11839m.m70687e("QueryKeyManager", str3);
        m83018H(str3, str);
    }

    /* renamed from: c */
    public boolean m83025c() {
        return System.currentTimeMillis() - this.f62084a > 30000;
    }

    /* renamed from: d */
    public void m83026d() {
        this.f62084a = 0L;
    }

    /* renamed from: e */
    public void m83027e() {
        this.f62085b = "";
        this.f62086c = "";
        this.f62087d = "";
        this.f62088e = "";
        this.f62089f = "";
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return;
        }
        C0212e0.m1352b(contextM1377a, "query_key");
        C0212e0.m1353c("query_key");
        m83026d();
    }

    /* renamed from: f */
    public final String m83028f() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return "";
        }
        String strM1364n = C0212e0.m1364n(contextM1377a, "query_key", "cbc_key_common_accountandbackup", "");
        if (TextUtils.isEmpty(strM1364n)) {
            C11839m.m70688i("QueryKeyManager", "common account and backup key in sp is empty");
            return "";
        }
        if (!C0212e0.m1355e(contextM1377a, "query_key", "is_cbc_key_common_accountandbackup_length_256", false)) {
            C11839m.m70688i("QueryKeyManager", "common account and backup key length 128");
            String strM68633c = C11477c.m68633c(strM1364n);
            m83019I("cbc_key_common_accountandbackup", strM68633c);
            return strM68633c;
        }
        String strM1364n2 = C0212e0.m1364n(contextM1377a, "query_key", "cbc_key_common_accountandbackup_SHA256", "");
        if (TextUtils.isEmpty(strM1364n2)) {
            C11839m.m70689w("QueryKeyManager", "sp common account and backup key SHA256 is empty");
            return "";
        }
        String strM68631a = C11477c.m68631a(strM1364n);
        if (TextUtils.isEmpty(strM68631a)) {
            C11839m.m70687e("QueryKeyManager", "sp common account and backup key keystore error");
            m83018H("sp common account and backup key keystore error", "cbc_key_common_accountandbackup");
            return "";
        }
        String strM68631a2 = C11477c.m68631a(strM1364n2);
        if (TextUtils.isEmpty(strM68631a2)) {
            C11839m.m70687e("QueryKeyManager", "sp common account and backup key SHA256 keystore error");
            m83018H("sp common account and backup key SHA256 keystore error", "cbc_key_common_accountandbackup");
            return "";
        }
        String strM1593f = C0227m.m1593f(strM68631a);
        if (TextUtils.isEmpty(strM1593f)) {
            C11839m.m70687e("QueryKeyManager", "sp common account and backup key SHA256 compute error");
            m83018H("sp common account and backup key SHA256 compute error", "cbc_key_common_accountandbackup");
            return "";
        }
        m83024b("cbc_key_common_accountandbackup", strM68631a);
        if (strM68631a2.equals(strM1593f)) {
            C11839m.m70688i("QueryKeyManager", "get common account and backup key success");
            return strM68631a;
        }
        C11839m.m70687e("QueryKeyManager", "get common account and backup key compare SHA256 fail");
        m83018H("get common account and backup key compare SHA256 fail", "cbc_key_common_accountandbackup");
        return "";
    }

    /* renamed from: g */
    public final String m83029g() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return "";
        }
        String strM1364n = C0212e0.m1364n(contextM1377a, "query_key", "hmacsha256_key_common_file", "");
        if (TextUtils.isEmpty(strM1364n)) {
            C11839m.m70688i("QueryKeyManager", "file key in sp is empty");
            return "";
        }
        if (!C0212e0.m1355e(contextM1377a, "query_key", "is_hmacsha256_key_common_file_length_256", false)) {
            C11839m.m70688i("QueryKeyManager", "file key length 128");
            String strM68633c = C11477c.m68633c(strM1364n);
            m83019I("hmacsha256_key_common_file", strM68633c);
            return strM68633c;
        }
        String strM1364n2 = C0212e0.m1364n(contextM1377a, "query_key", "hmacsha256_key_common_file_sha256", "");
        if (TextUtils.isEmpty(strM1364n2)) {
            C11839m.m70689w("QueryKeyManager", "sp file key SHA256 is empty");
            return "";
        }
        String strM68631a = C11477c.m68631a(strM1364n);
        if (TextUtils.isEmpty(strM68631a)) {
            C11839m.m70687e("QueryKeyManager", "sp file key keystore error");
            m83018H("sp file key keystore error", "hmacsha256_key_common_file");
            return "";
        }
        String strM68631a2 = C11477c.m68631a(strM1364n2);
        if (TextUtils.isEmpty(strM68631a2)) {
            C11839m.m70687e("QueryKeyManager", "sp file key SHA256 keystore error");
            m83018H("sp file key SHA256 keystore error", "hmacsha256_key_common_file");
            return "";
        }
        String strM1593f = C0227m.m1593f(strM68631a);
        if (TextUtils.isEmpty(strM1593f)) {
            C11839m.m70687e("QueryKeyManager", "sp file key SHA256 compute error");
            m83018H("sp file key SHA256 compute error", "hmacsha256_key_common_file");
            return "";
        }
        m83024b("hmacsha256_key_common_file", strM68631a);
        if (strM68631a2.equals(strM1593f)) {
            C11839m.m70688i("QueryKeyManager", "get file key success");
            return strM68631a;
        }
        C11839m.m70687e("QueryKeyManager", "get file key compare SHA256 fail");
        m83018H("get file key compare SHA256 fail", "hmacsha256_key_common_file");
        return "";
    }

    /* renamed from: h */
    public final String m83030h() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return "";
        }
        String strM1364n = C0212e0.m1364n(contextM1377a, "query_key", "hmacsha256_key_common_string", "");
        if (TextUtils.isEmpty(strM1364n)) {
            C11839m.m70688i("QueryKeyManager", "string key in sp is empty");
            return "";
        }
        if (!C0212e0.m1355e(contextM1377a, "query_key", "is_hmacsha256_key_common_string_length_256", false)) {
            C11839m.m70688i("QueryKeyManager", "string key length 128");
            String strM68633c = C11477c.m68633c(strM1364n);
            m83019I("hmacsha256_key_common_string", strM68633c);
            return strM68633c;
        }
        String strM1364n2 = C0212e0.m1364n(contextM1377a, "query_key", "hmacsha256_key_common_string_sha256", "");
        if (TextUtils.isEmpty(strM1364n2)) {
            C11839m.m70689w("QueryKeyManager", "sp string key SHA256 is empty");
            return "";
        }
        String strM68631a = C11477c.m68631a(strM1364n);
        if (TextUtils.isEmpty(strM68631a)) {
            C11839m.m70687e("QueryKeyManager", "sp string key keystore error");
            m83018H("sp string key keystore error", "hmacsha256_key_common_string");
            return "";
        }
        String strM68631a2 = C11477c.m68631a(strM1364n2);
        if (TextUtils.isEmpty(strM68631a2)) {
            C11839m.m70687e("QueryKeyManager", "sp string key SHA256 keystore error");
            m83018H("sp string key SHA256 keystore error", "hmacsha256_key_common_string");
            return "";
        }
        String strM1593f = C0227m.m1593f(strM68631a);
        if (TextUtils.isEmpty(strM1593f)) {
            C11839m.m70687e("QueryKeyManager", "sp string key SHA256 compute error");
            m83018H("sp string key SHA256 compute error", "hmacsha256_key_common_string");
            return "";
        }
        m83024b("hmacsha256_key_common_string_sha256", strM68631a);
        if (strM68631a2.equals(strM1593f)) {
            C11839m.m70688i("QueryKeyManager", "get string key success");
            return strM68631a;
        }
        C11839m.m70687e("QueryKeyManager", "get string key compare SHA256 fail");
        m83018H("get string key compare SHA256 fail", "hmacsha256_key_common_string");
        return "";
    }

    /* renamed from: j */
    public final String m83031j(String str) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i("QueryKeyManager", "ByNow user not login.");
            return "";
        }
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C11839m.m70688i("QueryKeyManager", "ByNow no network");
            return "";
        }
        str.hashCode();
        switch (str) {
            case "rsa_key_common_trust_circle_exponent":
                C11839m.m70688i("QueryKeyManager", "ByNow obtain exponent key");
                break;
            case "hmacsha256_key_common_file":
                C11839m.m70688i("QueryKeyManager", "ByNow obtain file key");
                break;
            case "cbc_key_common_accountandbackup":
                C11839m.m70688i("QueryKeyManager", "ByNow obtain common account and backup key");
                break;
            case "rsa_key_common_trust_circle_modulus":
                C11839m.m70688i("QueryKeyManager", "ByNow obtain modulus key");
                break;
            case "hmacsha256_key_common_string":
                C11839m.m70688i("QueryKeyManager", "ByNow obtain string key");
                break;
            default:
                C11839m.m70687e("QueryKeyManager", "ByNow bad branch");
                break;
        }
        return "";
    }

    /* renamed from: k */
    public final void m83032k(String str) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i("QueryKeyManager", "ByTask user not login.");
            return;
        }
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C11839m.m70688i("QueryKeyManager", "ByTask no network");
        }
        str.hashCode();
        switch (str) {
            case "rsa_key_common_trust_circle_exponent":
                C11839m.m70688i("QueryKeyManager", "ByTask obtain exponent key");
                m83014D();
                break;
            case "hmacsha256_key_common_file":
                C11839m.m70688i("QueryKeyManager", "ByTask obtain file key");
                m83046y();
                break;
            case "cbc_key_common_accountandbackup":
                C11839m.m70688i("QueryKeyManager", "ByTask obtain common account and backup key");
                m83043v();
                break;
            case "rsa_key_common_trust_circle_modulus":
                C11839m.m70688i("QueryKeyManager", "ByTask obtain modulus key");
                m83016F();
                break;
            case "hmacsha256_key_common_string":
                C11839m.m70688i("QueryKeyManager", "ByTask obtain string key");
                m83012B();
                break;
            default:
                C11839m.m70687e("QueryKeyManager", "ByTask bad branch");
                break;
        }
    }

    /* renamed from: l */
    public final String m83033l(String str) {
        String strM1364n;
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryKeyManager", "context is null");
            return "";
        }
        String strM1364n2 = C0212e0.m1364n(contextM1377a, "query_key", str, "");
        if (TextUtils.isEmpty(strM1364n2)) {
            C11839m.m70687e("QueryKeyManager", "sp key is empty");
            return "";
        }
        str.hashCode();
        if (str.equals("rsa_key_common_trust_circle_exponent")) {
            strM1364n = C0212e0.m1364n(contextM1377a, "query_key", "rsa_key_common_trust_circle_exponent_sha256", "");
        } else if (str.equals("rsa_key_common_trust_circle_modulus")) {
            strM1364n = C0212e0.m1364n(contextM1377a, "query_key", "rsa_key_common_trust_circle_modulus_sha256", "");
        } else {
            C11839m.m70687e("QueryKeyManager", "getKeyFromSP bad branch");
            strM1364n = "";
        }
        if (TextUtils.isEmpty(strM1364n)) {
            C11839m.m70689w("QueryKeyManager", "sp key SHA256 is empty");
            return "";
        }
        String strM68631a = C11477c.m68631a(strM1364n2);
        if (TextUtils.isEmpty(strM68631a)) {
            C11839m.m70687e("QueryKeyManager", "sp key keystore error");
            m83018H("sp key keystore error", str);
            return "";
        }
        String strM68631a2 = C11477c.m68631a(strM1364n);
        if (TextUtils.isEmpty(strM68631a2)) {
            C11839m.m70687e("QueryKeyManager", "sp key SHA256 keystore error");
            m83018H("sp key SHA256 keystore error", str);
            return "";
        }
        String strM1593f = C0227m.m1593f(strM68631a);
        if (TextUtils.isEmpty(strM1593f)) {
            C11839m.m70687e("QueryKeyManager", "sp key SHA256 compute error");
            m83018H("sp key SHA256 compute error", str);
            return "";
        }
        m83024b(str, strM68631a);
        if (strM68631a2.equals(C0227m.m1593f(strM1593f))) {
            C11839m.m70688i("QueryKeyManager", "get key success");
            return strM68631a;
        }
        C11839m.m70687e("QueryKeyManager", "key compare SHA256 fail");
        m83018H("key compare SHA256 fail", str);
        return "";
    }

    /* renamed from: m */
    public String m83034m(String str) {
        str.hashCode();
        switch (str) {
            case "rsa_key_common_trust_circle_exponent":
                if (!m83038q()) {
                    C11839m.m70688i("QueryKeyManager", "exponent key is empty, get by now");
                    break;
                } else {
                    return this.f62089f;
                }
            case "hmacsha256_key_common_file":
                if (!m83036o()) {
                    C11839m.m70688i("QueryKeyManager", "file key is empty, get by task");
                    break;
                } else {
                    return this.f62086c;
                }
            case "cbc_key_common_accountandbackup":
                if (!m83035n()) {
                    C11839m.m70688i("QueryKeyManager", "common account and backup key is empty, get by task");
                    break;
                } else {
                    return this.f62085b;
                }
            case "rsa_key_common_trust_circle_modulus":
                if (!m83039r()) {
                    C11839m.m70688i("QueryKeyManager", "modulus key is empty, get by now");
                    break;
                } else {
                    return this.f62088e;
                }
            case "hmacsha256_key_common_string":
                if (!m83037p()) {
                    C11839m.m70688i("QueryKeyManager", "string key is empty, get by task");
                    break;
                } else {
                    return this.f62087d;
                }
            default:
                C11839m.m70687e("QueryKeyManager", "getKeyByTask bad branch");
                return "";
        }
        return m83031j(str);
    }

    /* renamed from: n */
    public final boolean m83035n() {
        if (TextUtils.isEmpty(this.f62085b)) {
            C11839m.m70688i("QueryKeyManager", "common account and backup key is empty, get from sp");
            this.f62085b = m83028f();
        }
        return m83040s(this.f62085b, "local", "cbc_key_common_accountandbackup");
    }

    /* renamed from: o */
    public final boolean m83036o() {
        if (TextUtils.isEmpty(this.f62086c)) {
            C11839m.m70688i("QueryKeyManager", "file key is empty, get by sp");
            this.f62086c = m83029g();
        }
        return m83040s(this.f62086c, "local", "hmacsha256_key_common_file");
    }

    /* renamed from: p */
    public final boolean m83037p() {
        if (TextUtils.isEmpty(this.f62087d)) {
            C11839m.m70688i("QueryKeyManager", "string key is empty, get from sp");
            this.f62087d = m83030h();
        }
        return m83040s(this.f62087d, "local", "hmacsha256_key_common_string");
    }

    /* renamed from: q */
    public final boolean m83038q() {
        if (!TextUtils.isEmpty(this.f62089f)) {
            C11839m.m70688i("QueryKeyManager", "exponent key is not empty");
            return true;
        }
        String strM83033l = m83033l("rsa_key_common_trust_circle_exponent");
        this.f62089f = strM83033l;
        if (TextUtils.isEmpty(strM83033l)) {
            return false;
        }
        C11839m.m70688i("QueryKeyManager", "exponent key in sp is not empty");
        return true;
    }

    /* renamed from: r */
    public final boolean m83039r() {
        if (!TextUtils.isEmpty(this.f62088e)) {
            C11839m.m70688i("QueryKeyManager", "modulus key is not empty");
            return true;
        }
        String strM83033l = m83033l("rsa_key_common_trust_circle_modulus");
        this.f62088e = strM83033l;
        if (TextUtils.isEmpty(strM83033l)) {
            return false;
        }
        C11839m.m70688i("QueryKeyManager", "modulus key in sp is not empty");
        return true;
    }

    /* renamed from: s */
    public final boolean m83040s(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C11839m.m70688i("QueryKeyManager", "key is not empty");
        if (str.length() % 2 == 0) {
            return true;
        }
        String str4 = str3 + " key length is illegal, length is:" + str.length();
        if (!TextUtils.isEmpty(str2)) {
            str4 = str2 + str4;
        }
        C11839m.m70689w("QueryKeyManager", str4);
        m83017G(str3);
        m83018H(str4, str3);
        return false;
    }

    /* renamed from: t */
    public String m83041t() {
        String strM81153q = new C13475c(C11058a.m66627b("07025")).m81153q(9, 5);
        if (TextUtils.isEmpty(strM81153q)) {
            C11839m.m70687e("QueryKeyManager", "ByNow obtain common account and backup key fail");
            return "";
        }
        if (!m83040s(strM81153q, "server", "cbc_key_common_accountandbackup")) {
            return "";
        }
        this.f62085b = strM81153q;
        m83019I("cbc_key_common_accountandbackup", strM81153q);
        return strM81153q;
    }

    /* renamed from: u */
    public final synchronized String m83042u() {
        if (m83040s(this.f62085b, "local", "cbc_key_common_accountandbackup")) {
            return this.f62085b;
        }
        return m83041t();
    }

    /* renamed from: v */
    public final void m83043v() {
        C12515a.m75110o().m75175e(new C14029a(), true);
    }

    /* renamed from: w */
    public String m83044w() {
        String strM81153q = new C13475c(C11058a.m66627b("07025")).m81153q(100, 3);
        if (TextUtils.isEmpty(strM81153q)) {
            C11839m.m70687e("QueryKeyManager", "obtain file key fail");
            return "";
        }
        if (!m83040s(strM81153q, "server", "hmacsha256_key_common_file")) {
            C11839m.m70687e("QueryKeyManager", "obtained server file key is invalid");
            return "";
        }
        this.f62086c = strM81153q;
        m83019I("hmacsha256_key_common_file", strM81153q);
        return strM81153q;
    }

    /* renamed from: x */
    public final synchronized String m83045x() {
        if (m83040s(this.f62086c, "local", "hmacsha256_key_common_file")) {
            return this.f62086c;
        }
        C11839m.m70688i("QueryKeyManager", "ByNow obtain file key");
        return m83044w();
    }

    /* renamed from: y */
    public final void m83046y() {
        C12515a.m75110o().m75175e(new C14030b(), true);
    }

    /* renamed from: z */
    public String m83047z() {
        String strM81153q = new C13475c(C11058a.m66627b("07025")).m81153q(100, 4);
        if (TextUtils.isEmpty(strM81153q)) {
            C11839m.m70687e("QueryKeyManager", "ByNow obtain string key fail");
            return "";
        }
        if (!m83040s(strM81153q, "server", "hmacsha256_key_common_string")) {
            return "";
        }
        this.f62087d = strM81153q;
        m83019I("hmacsha256_key_common_string", strM81153q);
        return strM81153q;
    }

    public C13842a() {
        this.f62084a = 0L;
        this.f62085b = "";
        this.f62086c = "";
        this.f62087d = "";
        this.f62088e = "";
        this.f62089f = "";
        this.f62090g = C11058a.m66627b("07025");
    }
}
