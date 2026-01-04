package okhttp3;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C6010m7;
import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p022ay.C1054d;
import sx.C12875e;

/* renamed from: okhttp3.y */
/* loaded from: classes9.dex */
public final class C11958y {

    /* renamed from: j */
    public static final char[] f55667j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final String f55668a;

    /* renamed from: b */
    public final String f55669b;

    /* renamed from: c */
    public final String f55670c;

    /* renamed from: d */
    public final String f55671d;

    /* renamed from: e */
    public final int f55672e;

    /* renamed from: f */
    public final List<String> f55673f;

    /* renamed from: g */
    public final List<String> f55674g;

    /* renamed from: h */
    public final String f55675h;

    /* renamed from: i */
    public final String f55676i;

    /* renamed from: okhttp3.y$a */
    public static final class a {

        /* renamed from: a */
        public String f55677a;

        /* renamed from: d */
        public String f55680d;

        /* renamed from: f */
        public final List<String> f55682f;

        /* renamed from: g */
        public List<String> f55683g;

        /* renamed from: h */
        public String f55684h;

        /* renamed from: b */
        public String f55678b = "";

        /* renamed from: c */
        public String f55679c = "";

        /* renamed from: e */
        public int f55681e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f55682f = arrayList;
            arrayList.add("");
        }

        /* renamed from: b */
        public static String m71912b(String str, int i10, int i11) {
            return C12875e.m77247d(C11958y.m71890r(str, i10, i11, false));
        }

        /* renamed from: i */
        public static int m71913i(String str, int i10, int i11) throws NumberFormatException {
            int i12;
            try {
                i12 = Integer.parseInt(C11958y.m71883a(str, i10, i11, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i12 <= 0 || i12 > 65535) {
                return -1;
            }
            return i12;
        }

        /* renamed from: m */
        public static int m71914m(String str, int i10, int i11) {
            while (i10 < i11) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == ':') {
                    return i10;
                }
                if (cCharAt == '[') {
                    do {
                        i10++;
                        if (i10 < i11) {
                        }
                    } while (str.charAt(i10) != ']');
                }
                i10++;
            }
            return i11;
        }

        /* renamed from: r */
        public static int m71915r(String str, int i10, int i11) {
            if (i11 - i10 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i10);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: s */
        public static int m71916s(String str, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                char cCharAt = str.charAt(i10);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i12++;
                i10++;
            }
            return i12;
        }

        /* renamed from: a */
        public C11958y m71917a() {
            if (this.f55677a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f55680d != null) {
                return new C11958y(this);
            }
            throw new IllegalStateException("host == null");
        }

        /* renamed from: c */
        public int m71918c() {
            int i10 = this.f55681e;
            return i10 != -1 ? i10 : C11958y.m71886d(this.f55677a);
        }

        /* renamed from: d */
        public a m71919d(String str) {
            this.f55683g = str != null ? C11958y.m71894y(C11958y.m71884b(str, C6010m7.f27501o, true, false, true, true)) : null;
            return this;
        }

        /* renamed from: e */
        public a m71920e(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strM71912b = m71912b(str, 0, str.length());
            if (strM71912b != null) {
                this.f55680d = strM71912b;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: f */
        public final boolean m71921f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: g */
        public final boolean m71922g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: h */
        public a m71923h(C11958y c11958y, String str) throws NumberFormatException {
            int iM77258o;
            int i10;
            int iM77237H = C12875e.m77237H(str, 0, str.length());
            int iM77238I = C12875e.m77238I(str, iM77237H, str.length());
            int iM71915r = m71915r(str, iM77237H, iM77238I);
            if (iM71915r != -1) {
                if (str.regionMatches(true, iM77237H, "https:", 0, 6)) {
                    this.f55677a = "https";
                    iM77237H += 6;
                } else {
                    if (!str.regionMatches(true, iM77237H, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iM71915r) + "'");
                    }
                    this.f55677a = "http";
                    iM77237H += 5;
                }
            } else {
                if (c11958y == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f55677a = c11958y.f55668a;
            }
            int iM71916s = m71916s(str, iM77237H, iM77238I);
            char c10 = '?';
            char c11 = '#';
            if (iM71916s >= 2 || c11958y == null || !c11958y.f55668a.equals(this.f55677a)) {
                boolean z10 = false;
                boolean z11 = false;
                int i11 = iM77237H + iM71916s;
                while (true) {
                    iM77258o = C12875e.m77258o(str, i11, iM77238I, "@/\\?#");
                    char cCharAt = iM77258o != iM77238I ? str.charAt(iM77258o) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c11 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c10) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (z10) {
                            i10 = iM77258o;
                            this.f55679c += "%40" + C11958y.m71883a(str, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iM77257n = C12875e.m77257n(str, i11, iM77258o, ':');
                            i10 = iM77258o;
                            String strM71883a = C11958y.m71883a(str, i11, iM77257n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                strM71883a = this.f55678b + "%40" + strM71883a;
                            }
                            this.f55678b = strM71883a;
                            if (iM77257n != i10) {
                                this.f55679c = C11958y.m71883a(str, iM77257n + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        }
                        i11 = i10 + 1;
                    }
                    c10 = '?';
                    c11 = '#';
                }
                int iM71914m = m71914m(str, i11, iM77258o);
                int i12 = iM71914m + 1;
                if (i12 < iM77258o) {
                    this.f55680d = m71912b(str, i11, iM71914m);
                    int iM71913i = m71913i(str, i12, iM77258o);
                    this.f55681e = iM71913i;
                    if (iM71913i == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i12, iM77258o) + '\"');
                    }
                } else {
                    this.f55680d = m71912b(str, i11, iM71914m);
                    this.f55681e = C11958y.m71886d(this.f55677a);
                }
                if (this.f55680d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i11, iM71914m) + '\"');
                }
                iM77237H = iM77258o;
            } else {
                this.f55678b = c11958y.m71903j();
                this.f55679c = c11958y.m71899f();
                this.f55680d = c11958y.f55671d;
                this.f55681e = c11958y.f55672e;
                this.f55682f.clear();
                this.f55682f.addAll(c11958y.m71901h());
                if (iM77237H == iM77238I || str.charAt(iM77237H) == '#') {
                    m71919d(c11958y.m71902i());
                }
            }
            int iM77258o2 = C12875e.m77258o(str, iM77237H, iM77238I, "?#");
            m71929p(str, iM77237H, iM77258o2);
            if (iM77258o2 < iM77238I && str.charAt(iM77258o2) == '?') {
                int iM77257n2 = C12875e.m77257n(str, iM77258o2, iM77238I, '#');
                this.f55683g = C11958y.m71894y(C11958y.m71883a(str, iM77258o2 + 1, iM77257n2, C6010m7.f27501o, true, false, true, true, null));
                iM77258o2 = iM77257n2;
            }
            if (iM77258o2 < iM77238I && str.charAt(iM77258o2) == '#') {
                this.f55684h = C11958y.m71883a(str, 1 + iM77258o2, iM77238I, "", true, false, false, false, null);
            }
            return this;
        }

        /* renamed from: j */
        public a m71924j(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f55679c = C11958y.m71884b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: k */
        public final void m71925k() {
            if (!this.f55682f.remove(r0.size() - 1).isEmpty() || this.f55682f.isEmpty()) {
                this.f55682f.add("");
            } else {
                this.f55682f.set(r2.size() - 1, "");
            }
        }

        /* renamed from: l */
        public a m71926l(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f55681e = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        /* renamed from: n */
        public final void m71927n(String str, int i10, int i11, boolean z10, boolean z11) {
            String strM71883a = C11958y.m71883a(str, i10, i11, C6010m7.f27499m, z11, false, false, true, null);
            if (m71921f(strM71883a)) {
                return;
            }
            if (m71922g(strM71883a)) {
                m71925k();
                return;
            }
            if (this.f55682f.get(r11.size() - 1).isEmpty()) {
                this.f55682f.set(r11.size() - 1, strM71883a);
            } else {
                this.f55682f.add(strM71883a);
            }
            if (z10) {
                this.f55682f.add("");
            }
        }

        /* renamed from: o */
        public a m71928o() {
            int size = this.f55682f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f55682f.set(i10, C11958y.m71884b(this.f55682f.get(i10), C6010m7.f27500n, true, true, false, true));
            }
            List<String> list = this.f55683g;
            if (list != null) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str = this.f55683g.get(i11);
                    if (str != null) {
                        this.f55683g.set(i11, C11958y.m71884b(str, C6010m7.f27504r, true, true, true, true));
                    }
                }
            }
            String str2 = this.f55684h;
            if (str2 != null) {
                this.f55684h = C11958y.m71884b(str2, C6010m7.f27507u, true, true, false, false);
            }
            return this;
        }

        /* renamed from: p */
        public final void m71929p(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f55682f.clear();
                this.f55682f.add("");
                i10++;
            } else {
                List<String> list = this.f55682f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                if (i12 >= i11) {
                    return;
                }
                i10 = C12875e.m77258o(str, i12, i11, "/\\");
                boolean z10 = i10 < i11;
                m71927n(str, i12, i10, z10, true);
                if (z10) {
                    i10++;
                }
            }
        }

        /* renamed from: q */
        public a m71930q(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f55677a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f55677a = "https";
            }
            return this;
        }

        /* renamed from: t */
        public a m71931t(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f55678b = C11958y.m71884b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.f55677a;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (!this.f55678b.isEmpty() || !this.f55679c.isEmpty()) {
                sb2.append(this.f55678b);
                if (!this.f55679c.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.f55679c);
                }
                sb2.append('@');
            }
            String str2 = this.f55680d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f55680d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f55680d);
                }
            }
            if (this.f55681e != -1 || this.f55677a != null) {
                int iM71918c = m71918c();
                String str3 = this.f55677a;
                if (str3 == null || iM71918c != C11958y.m71886d(str3)) {
                    sb2.append(':');
                    sb2.append(iM71918c);
                }
            }
            C11958y.m71889q(sb2, this.f55682f);
            if (this.f55683g != null) {
                sb2.append('?');
                C11958y.m71888n(sb2, this.f55683g);
            }
            if (this.f55684h != null) {
                sb2.append('#');
                sb2.append(this.f55684h);
            }
            return sb2.toString();
        }
    }

    public C11958y(a aVar) {
        this.f55668a = aVar.f55677a;
        this.f55669b = m71891s(aVar.f55678b, false);
        this.f55670c = m71891s(aVar.f55679c, false);
        this.f55671d = aVar.f55680d;
        this.f55672e = aVar.m71918c();
        this.f55673f = m71908t(aVar.f55682f, false);
        List<String> list = aVar.f55683g;
        this.f55674g = list != null ? m71908t(list, true) : null;
        String str = aVar.f55684h;
        this.f55675h = str != null ? m71891s(str, false) : null;
        this.f55676i = aVar.toString();
    }

    /* renamed from: a */
    public static String m71883a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && z13)) {
                C1054d c1054d = new C1054d();
                c1054d.m6350q0(str, i10, iCharCount);
                m71885c(c1054d, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                return c1054d.m6319F();
            }
            if (str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z10 || (z11 && !m71893v(str, iCharCount, i11)))) || (iCodePointAt == 43 && z12))) {
                C1054d c1054d2 = new C1054d();
                c1054d2.m6350q0(str, i10, iCharCount);
                m71885c(c1054d2, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                return c1054d2.m6319F();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i10, i11);
    }

    /* renamed from: b */
    public static String m71884b(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return m71883a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    /* renamed from: c */
    public static void m71885c(C1054d c1054d, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        C1054d c1054d2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z12) {
                    c1054d.mo6329R(z10 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z13) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z10 || (z11 && !m71893v(str, i10, i11)))))) {
                    if (c1054d2 == null) {
                        c1054d2 = new C1054d();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        c1054d2.m6351r0(iCodePointAt);
                    } else {
                        c1054d2.m6348n0(str, i10, Character.charCount(iCodePointAt) + i10, charset);
                    }
                    while (!c1054d2.mo6325M()) {
                        try {
                            byte b10 = c1054d2.readByte();
                            c1054d.writeByte(37);
                            char[] cArr = f55667j;
                            c1054d.writeByte(cArr[((b10 & 255) >> 4) & 15]);
                            c1054d.writeByte(cArr[b10 & BaseType.Obj]);
                        } catch (EOFException e10) {
                            throw new AssertionError(e10);
                        }
                    }
                } else {
                    c1054d.m6351r0(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    /* renamed from: d */
    public static int m71886d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return C5927g2.f26808n;
        }
        return -1;
    }

    /* renamed from: k */
    public static C11958y m71887k(String str) {
        return new a().m71923h(null, str).m71917a();
    }

    /* renamed from: n */
    public static void m71888n(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            String str = list.get(i10);
            String str2 = list.get(i10 + 1);
            if (i10 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    /* renamed from: q */
    public static void m71889q(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(C5929g4.f26852n);
            sb2.append(list.get(i10));
        }
    }

    /* renamed from: r */
    public static String m71890r(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                C1054d c1054d = new C1054d();
                c1054d.m6350q0(str, i10, i12);
                m71892u(c1054d, str, i12, i11, z10);
                return c1054d.m6319F();
            }
        }
        return str.substring(i10, i11);
    }

    /* renamed from: s */
    public static String m71891s(String str, boolean z10) {
        return m71890r(str, 0, str.length(), z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0039  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m71892u(p022ay.C1054d r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = sx.C12875e.m77254k(r2)
            char r3 = r6.charAt(r1)
            int r3 = sx.C12875e.m77254k(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.m6351r0(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C11958y.m71892u(ay.d, java.lang.String, int, int, boolean):void");
    }

    /* renamed from: v */
    public static boolean m71893v(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && C12875e.m77254k(str.charAt(i10 + 1)) != -1 && C12875e.m77254k(str.charAt(i12)) != -1;
    }

    /* renamed from: y */
    public static List<String> m71894y(String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int iIndexOf = str.indexOf(38, i10);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i10);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i10, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i10, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i10 = iIndexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: A */
    public C11958y m71895A(String str) {
        a aVarM71907p = m71907p(str);
        if (aVarM71907p != null) {
            return aVarM71907p.m71917a();
        }
        return null;
    }

    /* renamed from: B */
    public String m71896B() {
        return this.f55668a;
    }

    /* renamed from: C */
    public URI m71897C() {
        String string = m71906o().m71928o().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* renamed from: e */
    public String m71898e() {
        if (this.f55675h == null) {
            return null;
        }
        return this.f55676i.substring(this.f55676i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11958y) && ((C11958y) obj).f55676i.equals(this.f55676i);
    }

    /* renamed from: f */
    public String m71899f() {
        if (this.f55670c.isEmpty()) {
            return "";
        }
        return this.f55676i.substring(this.f55676i.indexOf(58, this.f55668a.length() + 3) + 1, this.f55676i.indexOf(64));
    }

    /* renamed from: g */
    public String m71900g() {
        int iIndexOf = this.f55676i.indexOf(47, this.f55668a.length() + 3);
        String str = this.f55676i;
        return this.f55676i.substring(iIndexOf, C12875e.m77258o(str, iIndexOf, str.length(), "?#"));
    }

    /* renamed from: h */
    public List<String> m71901h() {
        int iIndexOf = this.f55676i.indexOf(47, this.f55668a.length() + 3);
        String str = this.f55676i;
        int iM77258o = C12875e.m77258o(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iM77258o) {
            int i10 = iIndexOf + 1;
            int iM77257n = C12875e.m77257n(this.f55676i, i10, iM77258o, C5929g4.f26852n);
            arrayList.add(this.f55676i.substring(i10, iM77257n));
            iIndexOf = iM77257n;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f55676i.hashCode();
    }

    /* renamed from: i */
    public String m71902i() {
        if (this.f55674g == null) {
            return null;
        }
        int iIndexOf = this.f55676i.indexOf(63) + 1;
        String str = this.f55676i;
        return this.f55676i.substring(iIndexOf, C12875e.m77257n(str, iIndexOf, str.length(), '#'));
    }

    /* renamed from: j */
    public String m71903j() {
        if (this.f55669b.isEmpty()) {
            return "";
        }
        int length = this.f55668a.length() + 3;
        String str = this.f55676i;
        return this.f55676i.substring(length, C12875e.m77258o(str, length, str.length(), ":@"));
    }

    /* renamed from: l */
    public String m71904l() {
        return this.f55671d;
    }

    /* renamed from: m */
    public boolean m71905m() {
        return this.f55668a.equals("https");
    }

    /* renamed from: o */
    public a m71906o() {
        a aVar = new a();
        aVar.f55677a = this.f55668a;
        aVar.f55678b = m71903j();
        aVar.f55679c = m71899f();
        aVar.f55680d = this.f55671d;
        aVar.f55681e = this.f55672e != m71886d(this.f55668a) ? this.f55672e : -1;
        aVar.f55682f.clear();
        aVar.f55682f.addAll(m71901h());
        aVar.m71919d(m71902i());
        aVar.f55684h = m71898e();
        return aVar;
    }

    /* renamed from: p */
    public a m71907p(String str) {
        try {
            return new a().m71923h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: t */
    public final List<String> m71908t(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = list.get(i10);
            arrayList.add(str != null ? m71891s(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String toString() {
        return this.f55676i;
    }

    /* renamed from: w */
    public int m71909w() {
        return this.f55672e;
    }

    /* renamed from: x */
    public String m71910x() {
        if (this.f55674g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        m71888n(sb2, this.f55674g);
        return sb2.toString();
    }

    /* renamed from: z */
    public String m71911z() {
        return m71907p("/...").m71931t("").m71924j("").m71917a().toString();
    }
}
