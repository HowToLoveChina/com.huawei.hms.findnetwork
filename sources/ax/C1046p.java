package ax;

import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kw.C11175g;
import kw.C11177h;
import kw.C11185l;
import kw.C11187n;
import kw.C11194u;
import p408jw.C10944j;
import p408jw.C10948n;
import p692uw.AbstractC13268k;
import p692uw.C13267j;
import p790xw.C13877f;
import p790xw.C13879h;
import p790xw.C13885n;
import tw.InterfaceC13090p;
import zw.C14399h;
import zw.InterfaceC14393b;

/* renamed from: ax.p */
/* loaded from: classes9.dex */
public class C1046p extends C1045o {

    /* renamed from: ax.p$a */
    public static final class a extends AbstractC13268k implements InterfaceC13090p<CharSequence, Integer, C10944j<? extends Integer, ? extends Integer>> {

        /* renamed from: b */
        public final /* synthetic */ List<String> f5115b;

        /* renamed from: c */
        public final /* synthetic */ boolean f5116c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> list, boolean z10) {
            super(2);
            this.f5115b = list;
            this.f5116c = z10;
        }

        @Override // tw.InterfaceC13090p
        /* renamed from: d */
        public /* bridge */ /* synthetic */ C10944j<? extends Integer, ? extends Integer> mo6288d(CharSequence charSequence, Integer num) {
            return m6289e(charSequence, num.intValue());
        }

        /* renamed from: e */
        public final C10944j<Integer, Integer> m6289e(CharSequence charSequence, int i10) {
            C13267j.m79677e(charSequence, "$this$$receiver");
            C10944j c10944jM6273l = C1046p.m6273l(charSequence, this.f5115b, i10, this.f5116c, false);
            if (c10944jM6273l != null) {
                return C10948n.m66075a(c10944jM6273l.m66068d(), Integer.valueOf(((String) c10944jM6273l.m66069e()).length()));
            }
            return null;
        }
    }

    /* renamed from: A */
    public static final List<String> m6264A(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return m6265B(charSequence, str, z10, i10);
            }
        }
        Iterable iterableM85626c = C14399h.m85626c(m6285x(charSequence, strArr, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(C11187n.m67182l(iterableM85626c, 10));
        Iterator it = iterableM85626c.iterator();
        while (it.hasNext()) {
            arrayList.add(m6267D(charSequence, (C13879h) it.next()));
        }
        return arrayList;
    }

    /* renamed from: B */
    public static final List<String> m6265B(CharSequence charSequence, String str, boolean z10, int i10) {
        m6287z(i10);
        int length = 0;
        int iM6275n = m6275n(charSequence, str, 0, z10);
        if (iM6275n == -1 || i10 == 1) {
            return C11185l.m67172b(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? C13885n.m83238c(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iM6275n).toString());
            length = str.length() + iM6275n;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iM6275n = m6275n(charSequence, str, length, z10);
        } while (iM6275n != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    /* renamed from: C */
    public static /* synthetic */ List m6266C(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return m6264A(charSequence, strArr, z10, i10);
    }

    /* renamed from: D */
    public static final String m6267D(CharSequence charSequence, C13879h c13879h) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(c13879h, "range");
        return charSequence.subSequence(c13879h.m83224h().intValue(), c13879h.m83223g().intValue() + 1).toString();
    }

    /* renamed from: E */
    public static final String m6268E(String str, char c10, String str2) {
        C13267j.m79677e(str, "<this>");
        C13267j.m79677e(str2, "missingDelimiterValue");
        int iM6281t = m6281t(str, c10, 0, false, 6, null);
        if (iM6281t == -1) {
            return str2;
        }
        String strSubstring = str.substring(iM6281t + 1, str.length());
        C13267j.m79676d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: F */
    public static /* synthetic */ String m6269F(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return m6268E(str, c10, str2);
    }

    /* renamed from: j */
    public static final boolean m6271j(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (m6278q(charSequence, (String) charSequence2, 0, z10, 2, null) < 0) {
                return false;
            }
        } else if (m6277p(charSequence, charSequence2, 0, charSequence.length(), z10, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    /* renamed from: k */
    public static /* synthetic */ boolean m6272k(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return m6271j(charSequence, charSequence2, z10);
    }

    /* renamed from: l */
    public static final C10944j<Integer, String> m6273l(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        Object next;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) C11194u.m67189s(collection);
            int iM6278q = !z11 ? m6278q(charSequence, str, i10, false, 4, null) : m6282u(charSequence, str, i10, false, 4, null);
            if (iM6278q < 0) {
                return null;
            }
            return C10948n.m66075a(Integer.valueOf(iM6278q), str);
        }
        C13877f c13879h = !z11 ? new C13879h(C13885n.m83236a(i10, 0), charSequence.length()) : C13885n.m83241f(C13885n.m83238c(i10, m6274m(charSequence)), 0);
        if (charSequence instanceof String) {
            int iM83216a = c13879h.m83216a();
            int iM83217b = c13879h.m83217b();
            int iM83218c = c13879h.m83218c();
            if ((iM83218c > 0 && iM83216a <= iM83217b) || (iM83218c < 0 && iM83217b <= iM83216a)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (C1045o.m6261f(str2, 0, (String) charSequence, iM83216a, str2.length(), z10)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iM83216a == iM83217b) {
                            break;
                        }
                        iM83216a += iM83218c;
                    } else {
                        return C10948n.m66075a(Integer.valueOf(iM83216a), str3);
                    }
                }
            }
        } else {
            int iM83216a2 = c13879h.m83216a();
            int iM83217b2 = c13879h.m83217b();
            int iM83218c2 = c13879h.m83218c();
            if ((iM83218c2 > 0 && iM83216a2 <= iM83217b2) || (iM83218c2 < 0 && iM83217b2 <= iM83216a2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (m6286y(str4, 0, charSequence, iM83216a2, str4.length(), z10)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iM83216a2 == iM83217b2) {
                            break;
                        }
                        iM83216a2 += iM83218c2;
                    } else {
                        return C10948n.m66075a(Integer.valueOf(iM83216a2), str5);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: m */
    public static final int m6274m(CharSequence charSequence) {
        C13267j.m79677e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    /* renamed from: n */
    public static final int m6275n(CharSequence charSequence, String str, int i10, boolean z10) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(str, ExtractOWiFiHelper.STING_NODE);
        return (z10 || !(charSequence instanceof String)) ? m6277p(charSequence, str, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(str, i10);
    }

    /* renamed from: o */
    public static final int m6276o(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        C13877f c13879h = !z11 ? new C13879h(C13885n.m83236a(i10, 0), C13885n.m83238c(i11, charSequence.length())) : C13885n.m83241f(C13885n.m83238c(i10, m6274m(charSequence)), C13885n.m83236a(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iM83216a = c13879h.m83216a();
            int iM83217b = c13879h.m83217b();
            int iM83218c = c13879h.m83218c();
            if ((iM83218c <= 0 || iM83216a > iM83217b) && (iM83218c >= 0 || iM83217b > iM83216a)) {
                return -1;
            }
            while (!C1045o.m6261f((String) charSequence2, 0, (String) charSequence, iM83216a, charSequence2.length(), z10)) {
                if (iM83216a == iM83217b) {
                    return -1;
                }
                iM83216a += iM83218c;
            }
            return iM83216a;
        }
        int iM83216a2 = c13879h.m83216a();
        int iM83217b2 = c13879h.m83217b();
        int iM83218c2 = c13879h.m83218c();
        if ((iM83218c2 <= 0 || iM83216a2 > iM83217b2) && (iM83218c2 >= 0 || iM83217b2 > iM83216a2)) {
            return -1;
        }
        while (!m6286y(charSequence2, 0, charSequence, iM83216a2, charSequence2.length(), z10)) {
            if (iM83216a2 == iM83217b2) {
                return -1;
            }
            iM83216a2 += iM83218c2;
        }
        return iM83216a2;
    }

    /* renamed from: p */
    public static /* synthetic */ int m6277p(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return m6276o(charSequence, charSequence2, i10, i11, z10, z11);
    }

    /* renamed from: q */
    public static /* synthetic */ int m6278q(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return m6275n(charSequence, str, i10, z10);
    }

    /* renamed from: r */
    public static final int m6279r(CharSequence charSequence, char c10, int i10, boolean z10) {
        C13267j.m79677e(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? m6283v(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    /* renamed from: s */
    public static final int m6280s(CharSequence charSequence, String str, int i10, boolean z10) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(str, ExtractOWiFiHelper.STING_NODE);
        return (z10 || !(charSequence instanceof String)) ? m6276o(charSequence, str, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(str, i10);
    }

    /* renamed from: t */
    public static /* synthetic */ int m6281t(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = m6274m(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return m6279r(charSequence, c10, i10, z10);
    }

    /* renamed from: u */
    public static /* synthetic */ int m6282u(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = m6274m(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return m6280s(charSequence, str, i10, z10);
    }

    /* renamed from: v */
    public static final int m6283v(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(C11177h.m67152l(cArr), i10);
        }
        for (int iM83238c = C13885n.m83238c(i10, m6274m(charSequence)); -1 < iM83238c; iM83238c--) {
            char cCharAt = charSequence.charAt(iM83238c);
            for (char c10 : cArr) {
                if (C1033c.m6240c(c10, cCharAt, z10)) {
                    return iM83238c;
                }
            }
        }
        return -1;
    }

    /* renamed from: w */
    public static final InterfaceC14393b<C13879h> m6284w(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        m6287z(i11);
        return new C1035e(charSequence, i10, i11, new a(C11175g.m67142b(strArr), z10));
    }

    /* renamed from: x */
    public static /* synthetic */ InterfaceC14393b m6285x(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return m6284w(charSequence, strArr, i10, z10, i11);
    }

    /* renamed from: y */
    public static final boolean m6286y(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        C13267j.m79677e(charSequence, "<this>");
        C13267j.m79677e(charSequence2, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!C1033c.m6240c(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: z */
    public static final void m6287z(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }
}
