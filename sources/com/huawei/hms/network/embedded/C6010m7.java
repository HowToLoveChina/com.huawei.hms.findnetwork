package com.huawei.hms.network.embedded;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.hms.network.embedded.m7 */
/* loaded from: classes8.dex */
public final class C6010m7 {

    /* renamed from: j */
    public static final char[] f27496j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: k */
    public static final String f27497k = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: l */
    public static final String f27498l = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: m */
    public static final String f27499m = " \"<>^`{}|/\\?#";

    /* renamed from: n */
    public static final String f27500n = "[]";

    /* renamed from: o */
    public static final String f27501o = " \"'<>#";

    /* renamed from: p */
    public static final String f27502p = " \"'<>#&=";

    /* renamed from: q */
    public static final String f27503q = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    /* renamed from: r */
    public static final String f27504r = "\\^`{|}";

    /* renamed from: s */
    public static final String f27505s = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    /* renamed from: t */
    public static final String f27506t = "";

    /* renamed from: u */
    public static final String f27507u = " \"#<>\\^`{|}";

    /* renamed from: a */
    public final String f27508a;

    /* renamed from: b */
    public final String f27509b;

    /* renamed from: c */
    public final String f27510c;

    /* renamed from: d */
    public final String f27511d;

    /* renamed from: e */
    public final int f27512e;

    /* renamed from: f */
    public final List<String> f27513f;

    /* renamed from: g */
    public final List<String> f27514g;

    /* renamed from: h */
    public final String f27515h;

    /* renamed from: i */
    public final String f27516i;

    /* renamed from: com.huawei.hms.network.embedded.m7$a */
    public static final class a {

        /* renamed from: i */
        public static final String f27517i = "Invalid URL host";

        /* renamed from: a */
        public String f27518a;

        /* renamed from: d */
        public String f27521d;

        /* renamed from: f */
        public final List<String> f27523f;

        /* renamed from: g */
        public List<String> f27524g;

        /* renamed from: h */
        public String f27525h;

        /* renamed from: b */
        public String f27519b = "";

        /* renamed from: c */
        public String f27520c = "";

        /* renamed from: e */
        public int f27522e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f27523f = arrayList;
            arrayList.add("");
        }

        /* renamed from: c */
        public static int m34817c(String str, int i10, int i11) {
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

        /* renamed from: e */
        public static int m34820e(String str, int i10, int i11) {
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

        /* renamed from: f */
        public static int m34821f(String str, int i10, int i11) {
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

        /* renamed from: r */
        private boolean m34822r(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: s */
        private boolean m34823s(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: t */
        private void m34824t(String str) {
            for (int size = this.f27524g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f27524g.get(size))) {
                    this.f27524g.remove(size + 1);
                    this.f27524g.remove(size);
                    if (this.f27524g.isEmpty()) {
                        this.f27524g = null;
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        public a m34825a(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f27522e = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        /* renamed from: b */
        public int m34831b() {
            int i10 = this.f27522e;
            return i10 != -1 ? i10 : C6010m7.m34780e(this.f27518a);
        }

        /* renamed from: d */
        public a m34839d(String str) {
            if (str != null) {
                return m34813a(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        /* renamed from: g */
        public a m34843g(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            }
            if (str.startsWith("/")) {
                m34819d(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        /* renamed from: h */
        public a m34844h(String str) {
            this.f27524g = str != null ? C6010m7.m34783h(C6010m7.m34771a(str, C6010m7.f27501o, true, false, true, true)) : null;
            return this;
        }

        /* renamed from: i */
        public a m34845i(String str) {
            if (str == null) {
                throw new NullPointerException("encodedUsername == null");
            }
            this.f27519b = C6010m7.m34771a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        /* renamed from: j */
        public a m34846j(String str) {
            this.f27525h = str != null ? C6010m7.m34771a(str, "", false, false, false, false) : null;
            return this;
        }

        /* renamed from: k */
        public a m34847k(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strM34814a = m34814a(str, 0, str.length());
            if (strM34814a != null) {
                this.f27521d = strM34814a;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: l */
        public a m34848l(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f27520c = C6010m7.m34771a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: m */
        public a m34849m(String str) {
            this.f27524g = str != null ? C6010m7.m34783h(C6010m7.m34771a(str, C6010m7.f27501o, false, false, true, true)) : null;
            return this;
        }

        /* renamed from: n */
        public a m34850n(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f27524g == null) {
                return this;
            }
            m34824t(C6010m7.m34771a(str, " \"'<>#&=", true, false, true, true));
            return this;
        }

        /* renamed from: o */
        public a m34851o(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f27524g == null) {
                return this;
            }
            m34824t(C6010m7.m34771a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        }

        /* renamed from: p */
        public a m34852p(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f27518a = str2;
            return this;
        }

        /* renamed from: q */
        public a m34853q(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f27519b = C6010m7.m34771a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            String str2 = this.f27518a;
            if (str2 != null) {
                sb2.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb2.append(str);
            if (!this.f27519b.isEmpty() || !this.f27520c.isEmpty()) {
                sb2.append(this.f27519b);
                if (!this.f27520c.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.f27520c);
                }
                sb2.append('@');
            }
            String str3 = this.f27521d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f27521d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f27521d);
                }
            }
            if (this.f27522e != -1 || this.f27518a != null) {
                int iM34831b = m34831b();
                String str4 = this.f27518a;
                if (str4 == null || iM34831b != C6010m7.m34780e(str4)) {
                    sb2.append(':');
                    sb2.append(iM34831b);
                }
            }
            C6010m7.m34779b(sb2, this.f27523f);
            if (this.f27524g != null) {
                sb2.append('?');
                C6010m7.m34777a(sb2, this.f27524g);
            }
            if (this.f27525h != null) {
                sb2.append('#');
                sb2.append(this.f27525h);
            }
            return sb2.toString();
        }

        /* renamed from: b */
        public static int m34816b(String str, int i10, int i11) throws NumberFormatException {
            int i12;
            try {
                i12 = Integer.parseInt(C6010m7.m34769a(str, i10, i11, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i12 <= 0 || i12 > 65535) {
                return -1;
            }
            return i12;
        }

        /* renamed from: a */
        public a m34826a(int i10, String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            String strM34769a = C6010m7.m34769a(str, 0, str.length(), C6010m7.f27499m, true, false, false, true, null);
            this.f27523f.set(i10, strM34769a);
            if (!m34822r(strM34769a) && !m34823s(strM34769a)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        /* renamed from: c */
        public a m34836c() {
            int size = this.f27523f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f27523f.set(i10, C6010m7.m34771a(this.f27523f.get(i10), C6010m7.f27500n, true, true, false, true));
            }
            List<String> list = this.f27524g;
            if (list != null) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str = this.f27524g.get(i11);
                    if (str != null) {
                        this.f27524g.set(i11, C6010m7.m34771a(str, C6010m7.f27504r, true, true, true, true));
                    }
                }
            }
            String str2 = this.f27525h;
            if (str2 != null) {
                this.f27525h = C6010m7.m34771a(str2, C6010m7.f27507u, true, true, false, false);
            }
            return this;
        }

        /* renamed from: d */
        public a m34840d(String str, String str2) {
            m34851o(str);
            m34835b(str, str2);
            return this;
        }

        /* renamed from: e */
        public a m34841e(String str) {
            this.f27525h = str != null ? C6010m7.m34771a(str, "", true, false, false, false) : null;
            return this;
        }

        /* renamed from: f */
        public a m34842f(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPassword == null");
            }
            this.f27520c = C6010m7.m34771a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        /* renamed from: d */
        private void m34818d() {
            if (!this.f27523f.remove(r0.size() - 1).isEmpty() || this.f27523f.isEmpty()) {
                this.f27523f.add("");
            } else {
                this.f27523f.set(r2.size() - 1, "");
            }
        }

        /* renamed from: a */
        public a m34827a(C6010m7 c6010m7, String str) throws NumberFormatException {
            int iM34230a;
            int i10;
            int iM34258b = C5920f8.m34258b(str, 0, str.length());
            int iM34264c = C5920f8.m34264c(str, iM34258b, str.length());
            int iM34820e = m34820e(str, iM34258b, iM34264c);
            if (iM34820e != -1) {
                if (str.regionMatches(true, iM34258b, "https:", 0, 6)) {
                    this.f27518a = "https";
                    iM34258b += 6;
                } else {
                    if (!str.regionMatches(true, iM34258b, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iM34820e) + "'");
                    }
                    this.f27518a = "http";
                    iM34258b += 5;
                }
            } else {
                if (c6010m7 == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f27518a = c6010m7.f27508a;
            }
            int iM34821f = m34821f(str, iM34258b, iM34264c);
            char c10 = '?';
            char c11 = '#';
            if (iM34821f >= 2 || c6010m7 == null || !c6010m7.f27508a.equals(this.f27518a)) {
                boolean z10 = false;
                boolean z11 = false;
                int i11 = iM34258b + iM34821f;
                while (true) {
                    iM34230a = C5920f8.m34230a(str, i11, iM34264c, "@/\\?#");
                    char cCharAt = iM34230a != iM34264c ? str.charAt(iM34230a) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c11 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c10) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (!z10) {
                            int iM34229a = C5920f8.m34229a(str, i11, iM34230a, ':');
                            i10 = iM34230a;
                            String strM34769a = C6010m7.m34769a(str, i11, iM34229a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                strM34769a = this.f27519b + "%40" + strM34769a;
                            }
                            this.f27519b = strM34769a;
                            if (iM34229a != i10) {
                                this.f27520c = C6010m7.m34769a(str, iM34229a + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        } else {
                            i10 = iM34230a;
                            this.f27520c += "%40" + C6010m7.m34769a(str, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i11 = i10 + 1;
                        c10 = '?';
                        c11 = '#';
                    }
                }
                int iM34817c = m34817c(str, i11, iM34230a);
                int i12 = iM34817c + 1;
                if (i12 < iM34230a) {
                    this.f27521d = m34814a(str, i11, iM34817c);
                    int iM34816b = m34816b(str, i12, iM34230a);
                    this.f27522e = iM34816b;
                    if (iM34816b == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i12, iM34230a) + '\"');
                    }
                } else {
                    this.f27521d = m34814a(str, i11, iM34817c);
                    this.f27522e = C6010m7.m34780e(this.f27518a);
                }
                if (this.f27521d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i11, iM34817c) + '\"');
                }
                iM34258b = iM34230a;
            } else {
                this.f27519b = c6010m7.m34795f();
                this.f27520c = c6010m7.m34787b();
                this.f27521d = c6010m7.f27511d;
                this.f27522e = c6010m7.f27512e;
                this.f27523f.clear();
                this.f27523f.addAll(c6010m7.m34793d());
                if (iM34258b == iM34264c || str.charAt(iM34258b) == '#') {
                    m34844h(c6010m7.m34794e());
                }
            }
            int iM34230a2 = C5920f8.m34230a(str, iM34258b, iM34264c, "?#");
            m34819d(str, iM34258b, iM34230a2);
            if (iM34230a2 < iM34264c && str.charAt(iM34230a2) == '?') {
                int iM34229a2 = C5920f8.m34229a(str, iM34230a2, iM34264c, '#');
                this.f27524g = C6010m7.m34783h(C6010m7.m34769a(str, iM34230a2 + 1, iM34229a2, C6010m7.f27501o, true, false, true, true, null));
                iM34230a2 = iM34229a2;
            }
            if (iM34230a2 < iM34264c && str.charAt(iM34230a2) == '#') {
                this.f27525h = C6010m7.m34769a(str, 1 + iM34230a2, iM34264c, "", true, false, false, false, null);
            }
            return this;
        }

        /* renamed from: b */
        public a m34832b(int i10) {
            this.f27523f.remove(i10);
            if (this.f27523f.isEmpty()) {
                this.f27523f.add("");
            }
            return this;
        }

        /* renamed from: c */
        public a m34837c(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            m34815a(str, 0, str.length(), false, false);
            return this;
        }

        /* renamed from: d */
        private void m34819d(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f27523f.clear();
                this.f27523f.add("");
                i10++;
            } else {
                List<String> list = this.f27523f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                if (i12 >= i11) {
                    return;
                }
                i10 = C5920f8.m34230a(str, i12, i11, "/\\");
                boolean z10 = i10 < i11;
                m34815a(str, i12, i10, z10, true);
                if (z10) {
                    i10++;
                }
            }
        }

        /* renamed from: a */
        public a m34828a(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            m34815a(str, 0, str.length(), false, true);
            return this;
        }

        /* renamed from: b */
        public a m34833b(int i10, String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            String strM34769a = C6010m7.m34769a(str, 0, str.length(), C6010m7.f27499m, false, false, false, true, null);
            if (!m34822r(strM34769a) && !m34823s(strM34769a)) {
                this.f27523f.set(i10, strM34769a);
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        /* renamed from: c */
        public a m34838c(String str, String str2) {
            m34850n(str);
            m34829a(str, str2);
            return this;
        }

        /* renamed from: a */
        public a m34829a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f27524g == null) {
                this.f27524g = new ArrayList();
            }
            this.f27524g.add(C6010m7.m34771a(str, " \"'<>#&=", true, false, true, true));
            this.f27524g.add(str2 != null ? C6010m7.m34771a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        /* renamed from: b */
        public a m34834b(String str) {
            if (str != null) {
                return m34813a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        /* renamed from: a */
        private a m34813a(String str, boolean z10) {
            int i10 = 0;
            do {
                int iM34230a = C5920f8.m34230a(str, i10, str.length(), "/\\");
                m34815a(str, i10, iM34230a, iM34230a < str.length(), z10);
                i10 = iM34230a + 1;
            } while (i10 <= str.length());
            return this;
        }

        /* renamed from: b */
        public a m34835b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f27524g == null) {
                this.f27524g = new ArrayList();
            }
            this.f27524g.add(C6010m7.m34771a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f27524g.add(str2 != null ? C6010m7.m34771a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        /* renamed from: a */
        public C6010m7 m34830a() {
            if (this.f27518a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f27521d != null) {
                return new C6010m7(this);
            }
            throw new IllegalStateException("host == null");
        }

        /* renamed from: a */
        public static String m34814a(String str, int i10, int i11) {
            return C5920f8.m34234a(C6010m7.m34770a(str, i10, i11, false));
        }

        /* renamed from: a */
        private void m34815a(String str, int i10, int i11, boolean z10, boolean z11) {
            String strM34769a = C6010m7.m34769a(str, i10, i11, C6010m7.f27499m, z11, false, false, true, null);
            if (m34822r(strM34769a)) {
                return;
            }
            if (m34823s(strM34769a)) {
                m34818d();
                return;
            }
            if (this.f27523f.get(r11.size() - 1).isEmpty()) {
                this.f27523f.set(r11.size() - 1, strM34769a);
            } else {
                this.f27523f.add(strM34769a);
            }
            if (z10) {
                this.f27523f.add("");
            }
        }
    }

    public C6010m7(a aVar) {
        this.f27508a = aVar.f27518a;
        this.f27509b = m34773a(aVar.f27519b, false);
        this.f27510c = m34773a(aVar.f27520c, false);
        this.f27511d = aVar.f27521d;
        this.f27512e = aVar.m34831b();
        this.f27513f = m34774a(aVar.f27523f, false);
        List<String> list = aVar.f27524g;
        this.f27514g = list != null ? m34774a(list, true) : null;
        String str = aVar.f27525h;
        this.f27515h = str != null ? m34773a(str, false) : null;
        this.f27516i = aVar.toString();
    }

    /* renamed from: e */
    public static int m34780e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return C5927g2.f26808n;
        }
        return -1;
    }

    /* renamed from: f */
    public static C6010m7 m34781f(String str) {
        return new a().m34827a((C6010m7) null, str).m34830a();
    }

    /* renamed from: g */
    public static C6010m7 m34782g(String str) {
        try {
            return m34781f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public a m34784a(String str) {
        try {
            return new a().m34827a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String m34787b() {
        if (this.f27510c.isEmpty()) {
            return "";
        }
        return this.f27516i.substring(this.f27516i.indexOf(58, this.f27508a.length() + 3) + 1, this.f27516i.indexOf(64));
    }

    /* renamed from: c */
    public String m34790c() {
        int iIndexOf = this.f27516i.indexOf(47, this.f27508a.length() + 3);
        String str = this.f27516i;
        return this.f27516i.substring(iIndexOf, C5920f8.m34230a(str, iIndexOf, str.length(), "?#"));
    }

    /* renamed from: d */
    public C6010m7 m34792d(String str) {
        a aVarM34784a = m34784a(str);
        if (aVarM34784a != null) {
            return aVarM34784a.m34830a();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C6010m7) && ((C6010m7) obj).f27516i.equals(this.f27516i);
    }

    /* renamed from: h */
    public String m34797h() {
        return this.f27511d;
    }

    public int hashCode() {
        return this.f27516i.hashCode();
    }

    /* renamed from: i */
    public boolean m34798i() {
        return this.f27508a.equals("https");
    }

    /* renamed from: j */
    public a m34799j() {
        a aVar = new a();
        aVar.f27518a = this.f27508a;
        aVar.f27519b = m34795f();
        aVar.f27520c = m34787b();
        aVar.f27521d = this.f27511d;
        aVar.f27522e = this.f27512e != m34780e(this.f27508a) ? this.f27512e : -1;
        aVar.f27523f.clear();
        aVar.f27523f.addAll(m34793d());
        aVar.m34844h(m34794e());
        aVar.f27525h = m34785a();
        return aVar;
    }

    /* renamed from: k */
    public String m34800k() {
        return this.f27510c;
    }

    /* renamed from: l */
    public List<String> m34801l() {
        return this.f27513f;
    }

    /* renamed from: m */
    public int m34802m() {
        return this.f27513f.size();
    }

    /* renamed from: n */
    public int m34803n() {
        return this.f27512e;
    }

    /* renamed from: o */
    public String m34804o() {
        if (this.f27514g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        m34777a(sb2, this.f27514g);
        return sb2.toString();
    }

    /* renamed from: p */
    public Set<String> m34805p() {
        if (this.f27514g == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f27514g.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            linkedHashSet.add(this.f27514g.get(i10));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: q */
    public int m34806q() {
        List<String> list = this.f27514g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    /* renamed from: r */
    public String m34807r() {
        return m34784a("/...").m34853q("").m34848l("").m34830a().toString();
    }

    /* renamed from: s */
    public String m34808s() {
        return this.f27508a;
    }

    /* renamed from: t */
    public String m34809t() {
        if (C5920f8.m34267e(this.f27511d)) {
            return null;
        }
        return PublicSuffixDatabase.m36398a().m36403a(this.f27511d);
    }

    public String toString() {
        return this.f27516i;
    }

    /* renamed from: u */
    public URI m34810u() {
        String string = m34799j().m34836c().toString();
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

    /* renamed from: v */
    public URL m34811v() {
        try {
            return new URL(this.f27516i);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: w */
    public String m34812w() {
        return this.f27509b;
    }

    /* renamed from: a */
    public static C6010m7 m34767a(URI uri) {
        return m34782g(uri.toString());
    }

    /* renamed from: h */
    public static List<String> m34783h(String str) {
        String strSubstring;
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
                strSubstring = null;
            } else {
                arrayList.add(str.substring(i10, iIndexOf2));
                strSubstring = str.substring(iIndexOf2 + 1, iIndexOf);
            }
            arrayList.add(strSubstring);
            i10 = iIndexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: b */
    public String m34788b(int i10) {
        List<String> list = this.f27514g;
        if (list != null) {
            return list.get((i10 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: c */
    public List<String> m34791c(String str) {
        if (this.f27514g == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f27514g.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            if (str.equals(this.f27514g.get(i10))) {
                arrayList.add(this.f27514g.get(i10 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: d */
    public List<String> m34793d() {
        int iIndexOf = this.f27516i.indexOf(47, this.f27508a.length() + 3);
        String str = this.f27516i;
        int iM34230a = C5920f8.m34230a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iM34230a) {
            int i10 = iIndexOf + 1;
            int iM34229a = C5920f8.m34229a(this.f27516i, i10, iM34230a, C5929g4.f26852n);
            arrayList.add(this.f27516i.substring(i10, iM34229a));
            iIndexOf = iM34229a;
        }
        return arrayList;
    }

    /* renamed from: e */
    public String m34794e() {
        if (this.f27514g == null) {
            return null;
        }
        int iIndexOf = this.f27516i.indexOf(63) + 1;
        String str = this.f27516i;
        return this.f27516i.substring(iIndexOf, C5920f8.m34229a(str, iIndexOf, str.length(), '#'));
    }

    /* renamed from: f */
    public String m34795f() {
        if (this.f27509b.isEmpty()) {
            return "";
        }
        int length = this.f27508a.length() + 3;
        String str = this.f27516i;
        return this.f27516i.substring(length, C5920f8.m34230a(str, length, str.length(), ":@"));
    }

    /* renamed from: g */
    public String m34796g() {
        return this.f27515h;
    }

    /* renamed from: a */
    public static C6010m7 m34768a(URL url) {
        return m34782g(url.toString());
    }

    /* renamed from: b */
    public String m34789b(String str) {
        List<String> list = this.f27514g;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            if (str.equals(this.f27514g.get(i10))) {
                return this.f27514g.get(i10 + 1);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static void m34779b(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(C5929g4.f26852n);
            sb2.append(list.get(i10));
        }
    }

    /* renamed from: a */
    public String m34785a() {
        if (this.f27515h == null) {
            return null;
        }
        return this.f27516i.substring(this.f27516i.indexOf(35) + 1);
    }

    /* renamed from: a */
    public String m34786a(int i10) {
        List<String> list = this.f27514g;
        if (list != null) {
            return list.get(i10 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: a */
    public static String m34769a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && z13)) {
                C5868bb c5868bb = new C5868bb();
                c5868bb.mo33935a(str, i10, iCharCount);
                m34775a(c5868bb, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                return c5868bb.mo33979o();
            }
            if (str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z10 || (z11 && !m34778a(str, iCharCount, i11)))) || (iCodePointAt == 43 && z12))) {
                C5868bb c5868bb2 = new C5868bb();
                c5868bb2.mo33935a(str, i10, iCharCount);
                m34775a(c5868bb2, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                return c5868bb2.mo33979o();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i10, i11);
    }

    /* renamed from: a */
    public static String m34770a(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                C5868bb c5868bb = new C5868bb();
                c5868bb.mo33935a(str, i10, i12);
                m34776a(c5868bb, str, i12, i11, z10);
                return c5868bb.mo33979o();
            }
        }
        return str.substring(i10, i11);
    }

    /* renamed from: a */
    public static String m34771a(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return m34769a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    /* renamed from: a */
    public static String m34772a(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        return m34769a(str, 0, str.length(), str2, z10, z11, z12, z13, charset);
    }

    /* renamed from: a */
    public static String m34773a(String str, boolean z10) {
        return m34770a(str, 0, str.length(), z10);
    }

    /* renamed from: a */
    private List<String> m34774a(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = list.get(i10);
            arrayList.add(str != null ? m34773a(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static void m34775a(C5868bb c5868bb, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        C5868bb c5868bb2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z12) {
                    c5868bb.mo33934a(z10 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z13) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z10 || (z11 && !m34778a(str, i10, i11)))))) {
                    if (c5868bb2 == null) {
                        c5868bb2 = new C5868bb();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        c5868bb2.mo33952c(iCodePointAt);
                    } else {
                        c5868bb2.mo33936a(str, i10, Character.charCount(iCodePointAt) + i10, charset);
                    }
                    while (!c5868bb2.mo33971i()) {
                        try {
                            byte b10 = c5868bb2.readByte();
                            c5868bb.writeByte(37);
                            char[] cArr = f27496j;
                            c5868bb.writeByte((int) cArr[((b10 & 255) >> 4) & 15]);
                            c5868bb.writeByte((int) cArr[b10 & BaseType.Obj]);
                        } catch (EOFException e10) {
                            throw new AssertionError(e10);
                        }
                    }
                } else {
                    c5868bb.mo33952c(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m34776a(com.huawei.hms.network.embedded.C5868bb r5, java.lang.String r6, int r7, int r8, boolean r9) {
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
            int r2 = com.huawei.hms.network.embedded.C5920f8.m34228a(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.huawei.hms.network.embedded.C5920f8.m34228a(r3)
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
            r5.mo33952c(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6010m7.m34776a(com.huawei.hms.network.embedded.bb, java.lang.String, int, int, boolean):void");
    }

    /* renamed from: a */
    public static void m34777a(StringBuilder sb2, List<String> list) {
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

    /* renamed from: a */
    public static boolean m34778a(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && C5920f8.m34228a(str.charAt(i10 + 1)) != -1 && C5920f8.m34228a(str.charAt(i12)) != -1;
    }
}
