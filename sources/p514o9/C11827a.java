package p514o9;

import android.text.TextUtils;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.util.Locale;
import p015ak.C0234s;
import p292fn.C9733f;
import p709vj.C13452e;
import p783xp.C13843a;
import tm.C13040c;

/* renamed from: o9.a */
/* loaded from: classes3.dex */
public class C11827a {
    /* renamed from: a */
    public static String m70476a() throws C9721b {
        return C13040c.m78609F().m78636a0();
    }

    /* renamed from: b */
    public static String m70477b() throws C9721b {
        return C13040c.m78609F().m78634Z();
    }

    /* renamed from: c */
    public static String m70478c() throws C9721b {
        return C13843a.m83101w(C13040c.m78609F().m78670w());
    }

    /* renamed from: d */
    public static String m70479d() {
        String strM80942m = C13452e.m80781L().m80942m();
        return TextUtils.isEmpty(strM80942m) ? "" : strM80942m.toUpperCase(Locale.US);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m70480e() {
        /*
            java.lang.String r0 = ""
            tm.c r1 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L21
            java.lang.String r1 = r1.m78672y()     // Catch: fk.C9721b -> L21
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch: fk.C9721b -> L1f
            java.lang.String r3 = "yyyyMMddHH"
            r2.<init>(r3)     // Catch: fk.C9721b -> L1f
            long r3 = java.lang.System.currentTimeMillis()     // Catch: fk.C9721b -> L1f
            java.util.Date r5 = new java.util.Date     // Catch: fk.C9721b -> L1f
            r5.<init>(r3)     // Catch: fk.C9721b -> L1f
            java.lang.String r0 = r2.format(r5)     // Catch: fk.C9721b -> L1f
            goto L3d
        L1f:
            r2 = move-exception
            goto L23
        L21:
            r2 = move-exception
            r1 = r0
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getOOBETermsAddress error "
            r3.append(r4)
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AddressUtil"
            p514o9.C11839m.m70687e(r3, r2)
        L3d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "oobe_terms"
            java.lang.String r1 = m70483h(r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L59
            return r1
        L59:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "?time="
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p514o9.C11827a.m70480e():java.lang.String");
    }

    /* renamed from: f */
    public static String m70481f() {
        String strM78669v = "";
        try {
            strM78669v = C13040c.m78609F().m78669v();
            C11839m.m70688i("AddressUtil", "getPrivacyStatementAddress");
            return strM78669v + m70483h(C13452e.m80781L().m80803F0().booleanValue() ? "privacy_statement_cn" : "privacy_statement");
        } catch (C9721b e10) {
            C11839m.m70687e("AddressUtil", "getPrivacyStatementAddress error " + e10.toString());
            return strM78669v;
        }
    }

    /* renamed from: g */
    public static String m70482g() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e("AddressUtil", "get privacy statement path, param map is empty");
            return "/terms/scope/huawei/cloud/privacy-statement-sdk.htm?";
        }
        if (!TextUtils.isEmpty(hiCloudSysParamMapM60757p.getPrivacyStatementPath())) {
            return hiCloudSysParamMapM60757p.getPrivacyStatementPath();
        }
        C11839m.m70687e("AddressUtil", "get privacy statement path string is empty");
        return "/terms/scope/huawei/cloud/privacy-statement-sdk.htm?";
    }

    /* renamed from: h */
    public static String m70483h(String str) {
        String strM70479d;
        strM70479d = m70479d();
        str.hashCode();
        switch (str) {
            case "oobe_terms":
                return "/minisite/cloudservice/cloud/package/agreements.zip";
            case "user_agreement":
                return "/legal/cloud/terms.htm?code=" + strM70479d + Constants.LANGUAGE + C0234s.m1635m();
            case "privacy_statement":
                return "/legal/cloud/privacy-statement.htm?code=" + strM70479d + Constants.LANGUAGE + C0234s.m1635m();
            case "cloud_service_agreement":
                return m70482g() + "code=" + strM70479d + "&branchid=0&language=" + C0234s.m1635m();
            case "user_agreement_cn":
                if (TextUtils.isEmpty(strM70479d)) {
                    strM70479d = "CN";
                }
                return "/legal/id/terms.htm?code=" + strM70479d + Constants.LANGUAGE + C0234s.m1634l();
            case "privacy_statement_cn":
                if (TextUtils.isEmpty(strM70479d)) {
                    strM70479d = "CN";
                }
                return "/legal/id/privacy-statement.htm?code=" + strM70479d + Constants.LANGUAGE + C0234s.m1634l();
            case "legal_privacy":
                return "/legal/privacy/statement.htm?country=" + strM70479d + Constants.LANGUAGE + C0234s.m1635m();
            default:
                return "";
        }
    }

    /* renamed from: i */
    public static String m70484i() {
        String strM78669v = "";
        try {
            strM78669v = C13040c.m78609F().m78669v();
            C11839m.m70688i("AddressUtil", "getUserAgreementAddress");
            return strM78669v + m70483h(C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement");
        } catch (C9721b e10) {
            C11839m.m70687e("AddressUtil", "getUserAgreementAddress error " + e10.toString());
            return strM78669v;
        }
    }
}
