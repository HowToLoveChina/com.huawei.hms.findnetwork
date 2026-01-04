package com.huawei.android.hicloud.sync.contact;

import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import fk.C9722c;
import p015ak.C0208c0;
import p015ak.C0241z;
import p514o9.C11839m;
import p839zc.C14182a;

/* renamed from: com.huawei.android.hicloud.sync.contact.m */
/* loaded from: classes3.dex */
public class C2888m {

    /* renamed from: a */
    public static final String[] f12920a = {"\\;", "\\\\"};

    /* renamed from: a */
    public static boolean m17609a(String str) {
        int length = f12920a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.indexOf(f12920a[i10]) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m17610b(C2882g c2882g, String str, String str2) {
        if (m17627s(c2882g, str, str2)) {
            m17626r(c2882g, str, str2);
        }
    }

    /* renamed from: c */
    public static void m17611c(C2882g c2882g, String str, String str2) {
        int iIndexOf;
        if ("ADR;HOME:".equals(str)) {
            c2882g.m17542z1(m17632x(C2983l.m17911h(str2, ';')));
            return;
        }
        if ("ADR;HOME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17542z1(m17632x(C2983l.m17911h(C0208c0.m1139a(str2), ';')));
            return;
        }
        if ("ADR;WORK:".equals(str)) {
            c2882g.m17500n2(m17632x(C2983l.m17911h(str2, ';')));
            return;
        }
        if ("ADR;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17500n2(m17632x(C2983l.m17911h(C0208c0.m1139a(str2), ';')));
            return;
        }
        if ("ADR:".equals(str)) {
            c2882g.m17437R1(m17632x(C2983l.m17911h(str2, ';')));
            return;
        }
        if ("ADR;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17437R1(m17632x(C2983l.m17911h(C0208c0.m1139a(str2), ';')));
            return;
        }
        if ((str.startsWith("ADR;X-") || str.startsWith("ADR;X1-")) && (iIndexOf = str.indexOf("ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:")) > 0) {
            try {
                c2882g.m17488j1(C2983l.m17908e(str.startsWith("ADR;X-") ? str.substring(6, iIndexOf - 1) : str.substring(7, iIndexOf - 1)), m17632x(C2983l.m17911h(C0208c0.m1139a(str2), ';')));
            } catch (Exception unused) {
                C11839m.m70689w("ParseVCard", "x-label decode error");
            }
        }
    }

    /* renamed from: d */
    public static void m17612d(C2882g c2882g, String str, String str2) {
        if (!"X-CUSTOM-PARAM:".equals(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArrSplit = str2.split(";");
        if (strArrSplit.length > 0 && !TextUtils.isEmpty(strArrSplit[0])) {
            c2882g.m17479g2(C0241z.m1685c(strArrSplit[0]));
        }
        if (strArrSplit.length <= 1 || TextUtils.isEmpty(strArrSplit[1])) {
            return;
        }
        c2882g.m17407H1(C0241z.m1685c(strArrSplit[1]));
    }

    /* renamed from: e */
    public static void m17613e(C2882g c2882g, String str, String str2) {
        if ("BDAY:".equals(str)) {
            c2882g.m17470d1(str2);
            return;
        }
        if ("BDAY;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17470d1(C0208c0.m1139a(str2));
            return;
        }
        if ("X-BDAY-LUNAR:".equals(str)) {
            c2882g.m17530v2(C0208c0.m1139a(str2));
            return;
        }
        if ("X-CUSTOM-EVENT-1:".equals(str)) {
            c2882g.m17466b1(str2);
            return;
        }
        if ("X-CUSTOM-EVENT-2:".equals(str)) {
            c2882g.m17440S1(str2);
        } else if (str.startsWith("X-CUSTOM-EVENT-0;X-") || str.startsWith("X-CUSTOM-EVENT-0;X1-")) {
            try {
                c2882g.m17491k1(C2983l.m17908e(str.startsWith("X-CUSTOM-EVENT-0;X-") ? str.substring(19, str.length() - 1) : str.substring(20, str.length() - 1)), str2);
            } catch (Exception unused) {
                C11839m.m70689w("ParseVCard", "x-label decode error");
            }
        }
    }

    /* renamed from: f */
    public static void m17614f(C2882g c2882g, String str, String str2) {
        if (m17615g(c2882g, str, str2)) {
            m17616h(c2882g, str, str2);
        }
    }

    /* renamed from: g */
    public static boolean m17615g(C2882g c2882g, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "EMAIL;INTERNET;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17467b2(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "EMAIL;HOME:":
                c2882g.m17386A1(m17631w(str2));
                return false;
            case "EMAIL;INTERNET:":
                c2882g.m17467b2(m17631w(str2));
                return false;
            case "EMAIL;HOME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17386A1(m17631w(C0208c0.m1139a(str2)));
                return false;
            default:
                return true;
        }
    }

    /* renamed from: h */
    public static void m17616h(C2882g c2882g, String str, String str2) {
        int iIndexOf;
        if ("EMAIL;WORK:".equals(str)) {
            c2882g.m17502o2(m17631w(str2));
            return;
        }
        if ("EMAIL;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17502o2(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("EMAIL:".equals(str)) {
            c2882g.m17443T1(m17631w(str2));
            return;
        }
        if ("EMAIL;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17443T1(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ((str.startsWith("EMAIL;X-") || str.startsWith("EMAIL;X1-")) && (iIndexOf = str.indexOf("ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:")) > 0) {
            try {
                c2882g.m17501o1(C2983l.m17908e(str.startsWith("EMAIL;X-") ? str.substring(8, iIndexOf - 1) : str.substring(9, iIndexOf - 1)), m17631w(C0208c0.m1139a(str2)));
            } catch (Exception unused) {
                C11839m.m70689w("ParseVCard", "x-label decode error");
            }
        }
    }

    /* renamed from: i */
    public static void m17617i(C2882g c2882g, String str, String str2) {
        if (m17618j(c2882g, str, str2)) {
            m17619k(c2882g, str, str2);
        }
    }

    /* renamed from: j */
    public static boolean m17618j(C2882g c2882g, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "X-AIM:":
                c2882g.m17463a1(m17631w(str2));
                return false;
            case "X-ICQ:":
                c2882g.m17401F1(m17631w(str2));
                return false;
            case "X-MSN:":
                c2882g.m17428O1(m17631w(str2));
                return false;
            case "X-YAHOO:":
                c2882g.m17526u2(m17631w(str2));
                return false;
            case "X-ICQ;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17401F1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-JABBER:":
                c2882g.m17410I1(m17631w(str2));
                return false;
            case "X-AIM;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17463a1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-YAHOO;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17526u2(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-MSN;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17428O1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-JABBER;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17410I1(m17631w(C0208c0.m1139a(str2)));
                return false;
            default:
                return true;
        }
    }

    /* renamed from: k */
    public static void m17619k(C2882g c2882g, String str, String str2) {
        int iIndexOf;
        if ("X-QQ:".equals(str)) {
            c2882g.m17469c2(m17631w(str2));
            return;
        }
        if ("X-QQ;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17469c2(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("X-SKYPE-USERNAME:".equals(str)) {
            c2882g.m17474e2(m17631w(str2));
            return;
        }
        if ("X-SKYPE-USERNAME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17474e2(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("X-GOOGLE-TALK:".equals(str)) {
            c2882g.m17539y1(m17631w(str));
            return;
        }
        if ("X-GOOGLE-TALK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17539y1(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ((str.startsWith("X-CUSTOM-IM;X-") || str.startsWith("X-CUSTOM-IM;X1-")) && (iIndexOf = str.indexOf("ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:")) > 0) {
            try {
                c2882g.m17493l1(C2983l.m17908e(str.startsWith("X-CUSTOM-IM;X-") ? str.substring(14, iIndexOf - 1) : str.substring(15, iIndexOf - 1)), m17631w(C0208c0.m1139a(str2)));
            } catch (Exception unused) {
                C11839m.m70689w("ParseVCard", "x-label decode error");
            }
        }
    }

    /* renamed from: l */
    public static void m17620l(C2882g c2882g, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "X-PHONETIC;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                String[] strArrM17907d = C2983l.m17907d(C2983l.m17911h(C0208c0.m1139a(str2), ';'), 3);
                c2882g.m17452W1(m17631w(strArrM17907d[0]));
                c2882g.m17449V1(m17631w(strArrM17907d[1]));
                c2882g.m17455X1(m17631w(strArrM17907d[2]));
                break;
            case "X-NICKNAME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17431P1(m17631w(C0208c0.m1139a(str2)));
                break;
            case "N:":
                String[] strArrM17907d2 = C2983l.m17907d(C2983l.m17911h(str2, ';'), 5);
                c2882g.m17513r1(m17631w(strArrM17907d2[0]));
                c2882g.m17536x1(m17631w(strArrM17907d2[1]));
                c2882g.m17416K1(m17631w(strArrM17907d2[2]));
                c2882g.m17464a2(m17631w(strArrM17907d2[3]));
                c2882g.m17482h2(m17631w(strArrM17907d2[4]));
                break;
            case "N;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                String[] strArrM17907d3 = C2983l.m17907d(C2983l.m17911h(str2, ';'), 5);
                c2882g.m17513r1(C2983l.m17910g(strArrM17907d3[0]) ? "" : m17631w(C0208c0.m1139a(strArrM17907d3[0])));
                c2882g.m17536x1(C2983l.m17910g(strArrM17907d3[1]) ? "" : m17631w(C0208c0.m1139a(strArrM17907d3[1])));
                c2882g.m17416K1(C2983l.m17910g(strArrM17907d3[2]) ? "" : m17631w(C0208c0.m1139a(strArrM17907d3[2])));
                c2882g.m17464a2(C2983l.m17910g(strArrM17907d3[3]) ? "" : m17631w(C0208c0.m1139a(strArrM17907d3[3])));
                c2882g.m17482h2(C2983l.m17910g(strArrM17907d3[4]) ? "" : m17631w(C0208c0.m1139a(strArrM17907d3[4])));
                break;
            case "X-NICKNAME:":
                c2882g.m17431P1(m17631w(str2));
                break;
        }
    }

    /* renamed from: m */
    public static void m17621m(C2882g c2882g, String str, String str2) {
        if ("NOTE:".equals(str)) {
            c2882g.m17434Q1(m17631w(str2));
        } else if ("NOTE;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17434Q1(m17631w(C0208c0.m1139a(str2)));
        }
    }

    /* renamed from: n */
    public static void m17622n(C2882g c2882g, String str, String str2) {
        if ("ORG:".equals(str)) {
            c2882g.m17485i1(m17631w(C2983l.m17907d(C2983l.m17911h(str2, ';'), 1)[0]));
        } else if ("ORG;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17485i1(m17631w(C2983l.m17907d(C2983l.m17911h(C0208c0.m1139a(str2), ';'), 1)[0]));
        }
    }

    /* renamed from: o */
    public static void m17623o(C2882g c2882g, String str, String str2) {
        if (m17624p(c2882g, str, str2)) {
            m17625q(c2882g, str, str2);
        }
    }

    /* renamed from: p */
    public static boolean m17624p(C2882g c2882g, String str, String str2) {
        if ("TEL;PREF:".equals(str)) {
            c2882g.m17461Z1(m17631w(str2));
            return false;
        }
        if ("TEL;MSG:".equals(str)) {
            c2882g.m17425N1(m17631w(str2));
            return false;
        }
        if ("TEL;WORK;PREF:".equals(str) || "TEL;PREF;WORK:".equals(str)) {
            c2882g.m17518s2(m17631w(str2));
            return false;
        }
        if ("TEL:".equals(str) || "TEL;VOICE:".equals(str)) {
            c2882g.m17494l2(m17631w(str2));
            return false;
        }
        if (!str.startsWith("TEL;X-") && !str.startsWith("TEL;X1-")) {
            return true;
        }
        c2882g.m17496m1(C2983l.m17908e(str.startsWith("TEL;X-") ? str.substring(6, str.length() - 1) : str.substring(7, str.length() - 1)), m17631w(str2));
        return false;
    }

    /* renamed from: q */
    public static void m17625q(C2882g c2882g, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "TEL;PAGER:":
                c2882g.m17486i2(m17631w(str2));
                break;
            case "TEL;CELL:":
                c2882g.m17419L1(m17631w(str2));
                break;
            case "TEL;HOME:":
                c2882g.m17395D1(m17631w(str2));
                break;
            case "TEL;WORK:":
                c2882g.m17514r2(m17631w(str2));
                break;
            case "TEL;CELL;HOME:":
                c2882g.m17392C1(m17631w(str2));
                break;
            case "TEL;CELL;WORK:":
                c2882g.m17510q2(m17631w(str2));
                break;
            case "TEL;FAX:":
                c2882g.m17521t1(m17631w(str2));
                break;
            case "TEL;FAX;HOME:":
                c2882g.m17389B1(m17631w(str2));
                break;
            case "TEL;FAX;WORK:":
                c2882g.m17506p2(m17631w(str2));
                break;
        }
    }

    /* renamed from: r */
    public static void m17626r(C2882g c2882g, String str, String str2) {
        int iIndexOf;
        if ("X-CUSTOM-RELATION-10;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17481h1(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("X-CUSTOM-RELATION-11;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17404G1(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("X-CUSTOM-RELATION-12;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17509q1(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("X-CUSTOM-RELATION-13;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17471d2(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ("X-CUSTOM-RELATION-14;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17477f2(m17631w(C0208c0.m1139a(str2)));
            return;
        }
        if ((str.startsWith("X-CUSTOM-RELATION-0;X-") || str.startsWith("X-CUSTOM-RELATION-0;X1-")) && (iIndexOf = str.indexOf("ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:")) > 0) {
            try {
                c2882g.m17499n1(C2983l.m17908e(str.startsWith("X-CUSTOM-RELATION-0;X-") ? str.substring(22, iIndexOf - 1) : str.substring(23, iIndexOf - 1)), m17631w(C0208c0.m1139a(str2)));
            } catch (Exception unused) {
                C11839m.m70689w("ParseVCard", "x-label decode error");
            }
        }
    }

    /* renamed from: s */
    public static boolean m17627s(C2882g c2882g, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "X-CUSTOM-RELATION-3;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17476f1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-4;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17478g1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-5;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17517s1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-6;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17533w1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-7;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17413J1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-8;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17422M1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-9;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17446U1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-1;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17468c1(m17631w(C0208c0.m1139a(str2)));
                return false;
            case "X-CUSTOM-RELATION-2;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17473e1(m17631w(C0208c0.m1139a(str2)));
                return false;
            default:
                return true;
        }
    }

    /* renamed from: t */
    public static void m17628t(C2882g c2882g, String str, String str2) {
        if ("TITLE:".equals(str)) {
            c2882g.m17489j2(m17631w(str2));
        } else if ("TITLE;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            c2882g.m17489j2(m17631w(C0208c0.m1139a(str2)));
        }
    }

    /* renamed from: u */
    public static C2882g m17629u(String str) throws C9722c {
        if (str == null) {
            return null;
        }
        C2882g c2882g = new C2882g();
        int iIndexOf = str.indexOf("BEGIN:VCARD");
        if (iIndexOf == -1) {
            C11839m.m70688i("ParseVCard", "[parseVCard] vCardBegin = -1 ");
            return null;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf("\r\n", iIndexOf + 11);
        while (true) {
            if (iIndexOf2 == -1 || iIndexOf2 > length) {
                break;
            }
            int iIndexOf3 = str.indexOf(58, iIndexOf2);
            if (iIndexOf3 == -1) {
                C11839m.m70688i("ParseVCard", "[parseVCard] the newLine : is not found ");
            }
            int i10 = iIndexOf3 + 1;
            String strSubstring = str.substring(iIndexOf2 + 2, i10);
            int iIndexOf4 = str.indexOf("\r\n", i10);
            String strSubstring2 = str.substring(i10, iIndexOf4);
            if ("END:".equals(strSubstring)) {
                C11839m.m70686d("ParseVCard", "[parseVCard]  end the parse ");
                break;
            }
            m17620l(c2882g, strSubstring, strSubstring2);
            m17614f(c2882g, strSubstring, strSubstring2);
            m17623o(c2882g, strSubstring, strSubstring2);
            m17611c(c2882g, strSubstring, strSubstring2);
            m17622n(c2882g, strSubstring, strSubstring2);
            m17628t(c2882g, strSubstring, strSubstring2);
            m17621m(c2882g, strSubstring, strSubstring2);
            m17630v(c2882g, strSubstring, strSubstring2);
            m17617i(c2882g, strSubstring, strSubstring2);
            m17613e(c2882g, strSubstring, strSubstring2);
            if ("PHOTO;ENCODING=BASE64:".equals(strSubstring)) {
                try {
                    c2882g.m17458Y1(C14182a.m85048c(strSubstring2));
                } catch (Exception e10) {
                    C11839m.m70687e("ParseVCard", "cf.setPhoto Base64.decode error " + e10.toString());
                }
            } else if ("UID:".equals(strSubstring)) {
                c2882g.m17492k2(strSubstring2);
                if (C2983l.m17910g(strSubstring2) || strSubstring2.length() > 64) {
                    c2882g.m17492k2(C2879d.m17348e());
                }
            }
            m17610b(c2882g, strSubstring, strSubstring2);
            m17612d(c2882g, strSubstring, strSubstring2);
            iIndexOf2 = iIndexOf4;
        }
        return c2882g;
    }

    /* renamed from: v */
    public static void m17630v(C2882g c2882g, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "URL;HOME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17398E1(m17631w(C0208c0.m1139a(str2)));
                break;
            case "URL;HOME:":
                c2882g.m17398E1(m17631w(str2));
                break;
            case "URL;WORK:":
                c2882g.m17522t2(m17631w(str2));
                break;
            case "URL:":
                c2882g.m17497m2(m17631w(str2));
                break;
            case "URL;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17522t2(m17631w(C0208c0.m1139a(str2)));
                break;
            case "URL;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                c2882g.m17497m2(m17631w(C0208c0.m1139a(str2)));
                break;
        }
    }

    /* renamed from: w */
    public static String m17631w(String str) {
        return str == null ? "" : !m17609a(str) ? str : str.replace("\\\\", "\\").replace("\\;", ";");
    }

    /* renamed from: x */
    public static String[] m17632x(String[] strArr) {
        if (strArr == null) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = m17631w(strArr[i10]);
        }
        return strArr2;
    }
}
