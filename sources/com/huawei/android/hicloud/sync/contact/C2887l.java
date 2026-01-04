package com.huawei.android.hicloud.sync.contact;

import com.huawei.android.hicloud.sync.syncutil.C2983l;
import p015ak.C0208c0;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.contact.l */
/* loaded from: classes3.dex */
public class C2887l {

    /* renamed from: a */
    public static final String[] f12919a = {"\\;", "\\\\"};

    /* renamed from: a */
    public static void m17600a(StringBuffer stringBuffer, String str, String str2) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append("\r\n");
    }

    /* renamed from: b */
    public static String m17601b(C2890o c2890o, boolean z10) {
        c2890o.m17688u();
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append("BEGIN:VCARD");
        stringBuffer.append("\r\n");
        stringBuffer.append("VERSION:2.1");
        stringBuffer.append("\r\n");
        m17600a(stringBuffer, "X-GROUPNAME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(c2890o.m17674g())));
        m17600a(stringBuffer, "X-MEMID:", C2886k.m17583b(c2890o.m17676i()));
        m17600a(stringBuffer, "UID:", c2890o.m17671d());
        if (z10) {
            m17600a(stringBuffer, "X-GUIDS:", C2886k.m17583b(c2890o.m17675h()));
        }
        stringBuffer.append("END:VCARD");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public static void m17602c(String str, C2890o c2890o) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 0) {
            return;
        }
        for (String str2 : strArrSplit) {
            c2890o.m17686s(str2);
        }
    }

    /* renamed from: d */
    public static void m17603d(String str, C2890o c2890o) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 0) {
            return;
        }
        for (String str2 : strArrSplit) {
            c2890o.m17687t(str2);
        }
    }

    /* renamed from: e */
    public static boolean m17604e(String str) {
        int length = f12919a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.indexOf(f12919a[i10]) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m17605f(C2890o c2890o, String str, String str2) {
        if ("X-GROUPNAME:".equals(str)) {
            c2890o.m17685r(str2);
            return false;
        }
        if (!"X-GROUPNAME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:".equals(str)) {
            return true;
        }
        c2890o.m17685r(m17608i(C0208c0.m1139a(str2)));
        return false;
    }

    /* renamed from: g */
    public static void m17606g(C2890o c2890o, String str, String str2) {
        str.hashCode();
        switch (str) {
            case "X-MEMID:":
                m17603d(str2, c2890o);
                C11839m.m70686d("ContactGroupUtil", "ParseVCard() group memid uuid =  " + c2890o.m17676i());
                break;
            case "X-MEMID;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:":
                m17603d(C0208c0.m1139a(str2), c2890o);
                break;
            case "UID:":
                if (!C2983l.m17910g(str2)) {
                    c2890o.m17680m(str2);
                    break;
                } else {
                    c2890o.m17680m(C2886k.m17595n());
                    C11839m.m70688i("ContactGroupUtil", "ParseVCard() contact group uid is null. Create a new uid:");
                    break;
                }
            case "X-GUIDS:":
                m17602c(C0208c0.m1139a(str2), c2890o);
                break;
        }
    }

    /* renamed from: h */
    public static C2890o m17607h(String str) {
        C11839m.m70686d("ContactGroupUtil", "[parseVCard] groud vCard parse start: ");
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf("BEGIN:VCARD");
        if (iIndexOf == -1) {
            C11839m.m70688i("ContactGroupUtil", "[parseVCard] groud vCard parse vCardBegin = -1 ");
            return null;
        }
        C2890o c2890o = new C2890o();
        int length = str.length();
        int iIndexOf2 = str.indexOf("\r\n", iIndexOf + 11);
        while (true) {
            if (iIndexOf2 == -1 || iIndexOf2 > length) {
                break;
            }
            int iIndexOf3 = str.indexOf(58, iIndexOf2);
            if (iIndexOf3 == -1) {
                C11839m.m70688i("ContactGroupUtil", "[parseVCard] wrong vcard ");
            }
            int i10 = iIndexOf3 + 1;
            String strSubstring = str.substring(iIndexOf2 + 2, i10);
            int iIndexOf4 = str.indexOf("\r\n", i10);
            if (i10 == -1) {
                C11839m.m70688i("ContactGroupUtil", "[parseVCard] wrong vcard ");
            }
            String strSubstring2 = str.substring(i10, iIndexOf4);
            if ("END:".equals(strSubstring)) {
                C11839m.m70686d("ContactGroupUtil", "[parseVCard] end parseVCard ");
                break;
            }
            if (m17605f(c2890o, strSubstring, strSubstring2)) {
                m17606g(c2890o, strSubstring, strSubstring2);
            }
            iIndexOf2 = iIndexOf4;
        }
        return c2890o;
    }

    /* renamed from: i */
    public static String m17608i(String str) {
        return str == null ? "" : !m17604e(str) ? str : str.replace("\\\\", "\\").replace("\\;", ";");
    }
}
