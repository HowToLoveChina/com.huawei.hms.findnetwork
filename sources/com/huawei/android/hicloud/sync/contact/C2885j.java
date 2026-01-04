package com.huawei.android.hicloud.sync.contact;

import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import fk.C9722c;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import p015ak.C0208c0;
import p839zc.C14182a;

/* renamed from: com.huawei.android.hicloud.sync.contact.j */
/* loaded from: classes3.dex */
public class C2885j {

    /* renamed from: com.huawei.android.hicloud.sync.contact.j$a */
    public static class a implements Comparator<String[]>, Serializable {
        private static final long serialVersionUID = 1;

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(String[] strArr, String[] strArr2) {
            return strArr[0].compareToIgnoreCase(strArr2[0]);
        }
    }

    /* renamed from: a */
    public static void m17567a(StringBuffer stringBuffer, String str, ArrayList<String[]> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (!C2879d.m17349f(next)) {
                C2879d.m17344a(stringBuffer, str, m17578l(next));
            }
        }
    }

    /* renamed from: b */
    public static void m17568b(ArrayList<String> arrayList, StringBuffer stringBuffer, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            C2879d.m17344a(stringBuffer, str, C0208c0.m1143e(C2983l.m17912i(it.next())));
        }
    }

    /* renamed from: c */
    public static void m17569c(StringBuffer stringBuffer, String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            C2879d.m17344a(stringBuffer, str, C0208c0.m1143e(C2983l.m17912i(it.next())));
        }
    }

    /* renamed from: d */
    public static void m17570d(C2882g c2882g, StringBuffer stringBuffer) {
        m17567a(stringBuffer, "ADR;HOME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17426O());
        m17567a(stringBuffer, "ADR;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17427O0());
        m17567a(stringBuffer, "ADR;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17516s0());
        ArrayList<Map<String, String[]>> arrayListM17540z = c2882g.m17540z();
        if (arrayListM17540z == null || arrayListM17540z.size() <= 0) {
            return;
        }
        Iterator<Map<String, String[]>> it = arrayListM17540z.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, String[]> entry : it.next().entrySet()) {
                if (!C2879d.m17349f(entry.getValue()) && !C2879d.m17349f(new String[]{entry.getKey()})) {
                    C2879d.m17344a(stringBuffer, "ADR;X1-" + C2983l.m17909f(entry.getKey()) + ";ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", m17578l(entry.getValue()));
                }
            }
        }
    }

    /* renamed from: e */
    public static void m17571e(C2882g c2882g, StringBuffer stringBuffer) {
        m17569c(stringBuffer, "EMAIL;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17391C0());
        m17569c(stringBuffer, "EMAIL;HOME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17429P());
        m17569c(stringBuffer, "EMAIL;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17430P0());
        m17569c(stringBuffer, "EMAIL;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17524u0());
        ArrayList<String[]> arrayListM17396E = c2882g.m17396E();
        if (arrayListM17396E == null || arrayListM17396E.size() <= 0) {
            return;
        }
        Collections.sort(arrayListM17396E, new a());
        Iterator<String[]> it = arrayListM17396E.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (!TextUtils.isEmpty(next[0])) {
                C2879d.m17344a(stringBuffer, "EMAIL;X1-" + C2983l.m17909f(next[0]) + ";ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", m17578l(new String[]{next[1]}));
            }
        }
    }

    /* renamed from: f */
    public static void m17572f(C2882g c2882g, StringBuffer stringBuffer) {
        m17579m(stringBuffer, "X-AIM;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17490k());
        m17579m(stringBuffer, "X-ICQ;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17444U());
        m17579m(stringBuffer, "X-JABBER;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17453X());
        m17579m(stringBuffer, "X-MSN;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17504p0());
        m17579m(stringBuffer, "X-YAHOO;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17448V0());
        m17579m(stringBuffer, "X-QQ;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17394D0());
        m17579m(stringBuffer, "X-SKYPE-USERNAME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17400F0());
        m17579m(stringBuffer, "X-GOOGLE-TALK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", c2882g.m17420M());
        ArrayList<String[]> arrayListM17387B = c2882g.m17387B();
        if (arrayListM17387B == null || arrayListM17387B.size() <= 0) {
            return;
        }
        Collections.sort(arrayListM17387B, new a());
        Iterator<String[]> it = arrayListM17387B.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (!TextUtils.isEmpty(next[0])) {
                C2879d.m17344a(stringBuffer, "X-CUSTOM-IM;X1-" + C2983l.m17909f(next[0]) + ";ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", m17578l(new String[]{next[1]}));
            }
        }
    }

    /* renamed from: g */
    public static void m17573g(C2882g c2882g, StringBuffer stringBuffer) {
        boolean z10;
        String str;
        String strM17912i;
        String str2;
        String strM17912i2;
        String strM1143e;
        String strM1143e2;
        boolean z11 = true;
        String strM1143e3 = "";
        if (C2983l.m17910g(c2882g.m17405H())) {
            z10 = false;
            str = "";
            strM17912i = str;
        } else {
            String strM1143e4 = C0208c0.m1143e(C2983l.m17912i(c2882g.m17405H()));
            strM17912i = C2983l.m17912i(c2882g.m17405H());
            str = strM1143e4;
            z10 = true;
        }
        if (C2983l.m17910g(c2882g.m17417L())) {
            str2 = "";
            strM17912i2 = str2;
        } else {
            String strM1143e5 = C0208c0.m1143e(C2983l.m17912i(c2882g.m17417L()));
            strM17912i2 = C2983l.m17912i(c2882g.m17417L());
            str2 = strM1143e5;
            z10 = true;
        }
        if (C2983l.m17910g(c2882g.m17484i0())) {
            strM1143e = "";
        } else {
            strM1143e = C0208c0.m1143e(C2983l.m17912i(c2882g.m17484i0()));
            z10 = true;
        }
        if (C2983l.m17910g(c2882g.m17388B0())) {
            strM1143e2 = "";
        } else {
            strM1143e2 = C0208c0.m1143e(C2983l.m17912i(c2882g.m17388B0()));
            z10 = true;
        }
        if (C2983l.m17910g(c2882g.m17409I0())) {
            z11 = z10;
        } else {
            strM1143e3 = C0208c0.m1143e(C2983l.m17912i(c2882g.m17409I0()));
        }
        if (z11) {
            stringBuffer.append("N;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
            stringBuffer.append(str);
            stringBuffer.append(";");
            stringBuffer.append(str2);
            stringBuffer.append(";");
            stringBuffer.append(strM1143e);
            stringBuffer.append(";");
            stringBuffer.append(strM1143e2);
            stringBuffer.append(";");
            stringBuffer.append(strM1143e3);
            stringBuffer.append("\r\n");
            if (C2983l.m17910g(str)) {
                C2879d.m17344a(stringBuffer, "FN;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", str2);
                return;
            }
            if (C2983l.m17910g(str2)) {
                C2879d.m17344a(stringBuffer, "FN;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", str);
                return;
            }
            C2879d.m17344a(stringBuffer, "FN;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(strM17912i2 + " " + strM17912i)));
        }
    }

    /* renamed from: h */
    public static void m17574h(C2882g c2882g, StringBuffer stringBuffer) {
        ArrayList<String[]> arrayListM17390C = c2882g.m17390C();
        if (arrayListM17390C != null && arrayListM17390C.size() > 0) {
            Collections.sort(arrayListM17390C, new a());
            Iterator<String[]> it = arrayListM17390C.iterator();
            while (it.hasNext()) {
                String[] next = it.next();
                if (!TextUtils.isEmpty(next[0])) {
                    C2879d.m17344a(stringBuffer, "TEL;X1-" + C2983l.m17909f(next[0]) + ":", C2983l.m17912i(next[1]));
                }
            }
        }
        m17580n(stringBuffer, "TEL;CELL:", c2882g.m17487j0());
        m17580n(stringBuffer, "TEL;CELL;HOME:", c2882g.m17435R());
        m17580n(stringBuffer, "TEL;CELL;WORK:", c2882g.m17436R0());
        m17580n(stringBuffer, "TEL;HOME:", c2882g.m17438S());
        m17580n(stringBuffer, "TEL;WORK:", c2882g.m17439S0());
        m17580n(stringBuffer, "TEL;PREF:", c2882g.m17385A0());
        m17580n(stringBuffer, "TEL;VOICE:", c2882g.m17421M0());
        m17580n(stringBuffer, "TEL;WORK;PREF:", c2882g.m17442T0());
        m17580n(stringBuffer, "TEL;MSG:", c2882g.m17498n0());
        m17580n(stringBuffer, "TEL;FAX:", c2882g.m17411J());
        m17580n(stringBuffer, "TEL;FAX;HOME:", c2882g.m17432Q());
        m17580n(stringBuffer, "TEL;PAGER:", c2882g.m17412J0());
        m17580n(stringBuffer, "TEL;FAX;WORK:", c2882g.m17433Q0());
    }

    /* renamed from: i */
    public static void m17575i(C2882g c2882g, StringBuffer stringBuffer) {
        String strM1143e = C2983l.m17910g(c2882g.m17532w0()) ? "" : C0208c0.m1143e(C2983l.m17912i(c2882g.m17532w0()));
        String strM1143e2 = C2983l.m17910g(c2882g.m17538y0()) ? "" : C0208c0.m1143e(C2983l.m17912i(c2882g.m17538y0()));
        String strM1143e3 = C2983l.m17910g(c2882g.m17535x0()) ? "" : C0208c0.m1143e(C2983l.m17912i(c2882g.m17535x0()));
        if (C2983l.m17910g(strM1143e) && C2983l.m17910g(strM1143e2) && C2983l.m17910g(strM1143e3)) {
            return;
        }
        stringBuffer.append("X-PHONETIC;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        stringBuffer.append(strM1143e3);
        stringBuffer.append(";");
        stringBuffer.append(strM1143e);
        stringBuffer.append(";");
        stringBuffer.append(strM1143e2);
        stringBuffer.append("\r\n");
    }

    /* renamed from: j */
    public static void m17576j(C2882g c2882g, StringBuffer stringBuffer) {
        m17568b(c2882g.m17515s(), stringBuffer, "X-CUSTOM-RELATION-1;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17523u(), stringBuffer, "X-CUSTOM-RELATION-2;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17527v(), stringBuffer, "X-CUSTOM-RELATION-3;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17531w(), stringBuffer, "X-CUSTOM-RELATION-4;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17408I(), stringBuffer, "X-CUSTOM-RELATION-5;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17414K(), stringBuffer, "X-CUSTOM-RELATION-6;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17456Y(), stringBuffer, "X-CUSTOM-RELATION-7;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17495m0(), stringBuffer, "X-CUSTOM-RELATION-8;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17528v0(), stringBuffer, "X-CUSTOM-RELATION-9;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17534x(), stringBuffer, "X-CUSTOM-RELATION-10;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17447V(), stringBuffer, "X-CUSTOM-RELATION-11;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17402G(), stringBuffer, "X-CUSTOM-RELATION-12;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17397E0(), stringBuffer, "X-CUSTOM-RELATION-13;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        m17568b(c2882g.m17403G0(), stringBuffer, "X-CUSTOM-RELATION-14;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
        ArrayList<String[]> arrayListM17393D = c2882g.m17393D();
        if (arrayListM17393D == null || arrayListM17393D.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17393D.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (!TextUtils.isEmpty(next[0])) {
                C2879d.m17344a(stringBuffer, "X-CUSTOM-RELATION-0;X1-" + C2983l.m17909f(next[0]) + ";ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(next[1])));
            }
        }
    }

    /* renamed from: k */
    public static String m17577k(C2882g c2882g) throws C9722c {
        StringBuffer stringBuffer = new StringBuffer(2048);
        stringBuffer.append("BEGIN:VCARD");
        stringBuffer.append("\r\n");
        stringBuffer.append("VERSION:2.1");
        stringBuffer.append("\r\n");
        m17573g(c2882g, stringBuffer);
        m17575i(c2882g, stringBuffer);
        m17574h(c2882g, stringBuffer);
        m17571e(c2882g, stringBuffer);
        m17570d(c2882g, stringBuffer);
        if (!C2983l.m17910g(c2882g.m17537y())) {
            C2879d.m17344a(stringBuffer, "ORG;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(c2882g.m17537y())));
        }
        C2879d.m17344a(stringBuffer, "TITLE;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(c2882g.m17415K0())));
        m17572f(c2882g, stringBuffer);
        C2879d.m17344a(stringBuffer, "NOTE;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(c2882g.m17512r0())));
        C2879d.m17344a(stringBuffer, "X-NICKNAME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(c2882g.m17508q0())));
        C2879d.m17346c(c2882g, stringBuffer);
        C2879d.m17345b(c2882g, stringBuffer);
        m17576j(c2882g, stringBuffer);
        C2879d.m17344a(stringBuffer, "X-CUSTOM-PARAM:", String.valueOf(c2882g.m17406H0()) + ";" + String.valueOf(c2882g.m17450W()));
        C2879d.m17344a(stringBuffer, "UID:", c2882g.m17418L0());
        C2879d.m17344a(stringBuffer, "PHOTO;ENCODING=BASE64:", new String(C14182a.m85052g(c2882g.m17541z0()), Charset.defaultCharset()));
        stringBuffer.append("END:VCARD");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }

    /* renamed from: l */
    public static String m17578l(String[] strArr) {
        StringBuilder sb2 = new StringBuilder(256);
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(C2983l.m17910g(strArr[i10]) ? "" : C0208c0.m1143e(C2983l.m17912i(strArr[i10])));
            if (i10 != length - 1) {
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    /* renamed from: m */
    public static void m17579m(StringBuffer stringBuffer, String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            C2879d.m17344a(stringBuffer, str, C0208c0.m1143e(C2983l.m17912i(it.next())));
        }
    }

    /* renamed from: n */
    public static void m17580n(StringBuffer stringBuffer, String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            C2879d.m17344a(stringBuffer, str, C2983l.m17912i(it.next()));
        }
    }
}
