package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.az */
/* loaded from: classes8.dex */
public final class C5193az {

    /* renamed from: d */
    private static final char[] f23799d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f23800a;

    /* renamed from: b */
    final String f23801b;

    /* renamed from: c */
    final int f23802c;

    /* renamed from: e */
    private final String f23803e;

    /* renamed from: f */
    private final String f23804f;

    /* renamed from: g */
    private final List<String> f23805g;

    /* renamed from: h */
    private final List<String> f23806h;

    /* renamed from: i */
    private final String f23807i;

    /* renamed from: j */
    private final String f23808j;

    /* renamed from: com.huawei.hms.drive.az$a */
    public static final class a {

        /* renamed from: a */
        String f23809a;

        /* renamed from: d */
        String f23812d;

        /* renamed from: f */
        final List<String> f23814f;

        /* renamed from: g */
        List<String> f23815g;

        /* renamed from: h */
        String f23816h;

        /* renamed from: b */
        String f23810b = "";

        /* renamed from: c */
        String f23811c = "";

        /* renamed from: e */
        int f23813e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f23814f = arrayList;
            arrayList.add("");
        }

        /* renamed from: f */
        private boolean m30987f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: g */
        private boolean m30988g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: a */
        public a m30992a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f23809a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f23809a = "https";
            }
            return this;
        }

        /* renamed from: b */
        public a m30994b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f23810b = C5193az.m30953a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: c */
        public a m30995c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f23811c = C5193az.m30953a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: d */
        public a m30997d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strM30985e = m30985e(str, 0, str.length());
            if (strM30985e != null) {
                this.f23812d = strM30985e;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: e */
        public a m30998e(String str) {
            this.f23815g = str != null ? C5193az.m30960b(C5193az.m30953a(str, C6010m7.f27501o, true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.f23809a;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (!this.f23810b.isEmpty() || !this.f23811c.isEmpty()) {
                sb2.append(this.f23810b);
                if (!this.f23811c.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.f23811c);
                }
                sb2.append('@');
            }
            String str2 = this.f23812d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f23812d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f23812d);
                }
            }
            if (this.f23813e != -1 || this.f23809a != null) {
                int iM30989a = m30989a();
                String str3 = this.f23809a;
                if (str3 == null || iM30989a != C5193az.m30950a(str3)) {
                    sb2.append(':');
                    sb2.append(iM30989a);
                }
            }
            C5193az.m30958a(sb2, this.f23814f);
            if (this.f23815g != null) {
                sb2.append('?');
                C5193az.m30961b(sb2, this.f23815g);
            }
            if (this.f23816h != null) {
                sb2.append('#');
                sb2.append(this.f23816h);
            }
            return sb2.toString();
        }

        /* renamed from: f */
        private static int m30986f(String str, int i10, int i11) throws NumberFormatException {
            int i12;
            try {
                i12 = Integer.parseInt(C5193az.m30951a(str, i10, i11, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i12 <= 0 || i12 > 65535) {
                return -1;
            }
            return i12;
        }

        /* renamed from: b */
        public a m30993b() {
            int size = this.f23814f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f23814f.set(i10, C5193az.m30953a(this.f23814f.get(i10), C6010m7.f27500n, true, true, false, true));
            }
            List<String> list = this.f23815g;
            if (list != null) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str = this.f23815g.get(i11);
                    if (str != null) {
                        this.f23815g.set(i11, C5193az.m30953a(str, C6010m7.f27504r, true, true, true, true));
                    }
                }
            }
            String str2 = this.f23816h;
            if (str2 != null) {
                this.f23816h = C5193az.m30953a(str2, C6010m7.f27507u, true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public C5193az m30996c() {
            if (this.f23809a != null) {
                if (this.f23812d != null) {
                    return new C5193az(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* renamed from: e */
        private static String m30985e(String str, int i10, int i11) {
            return C5210bo.m31179a(C5193az.m30952a(str, i10, i11, false));
        }

        /* renamed from: d */
        private void m30984d() {
            if (this.f23814f.remove(r0.size() - 1).isEmpty() && !this.f23814f.isEmpty()) {
                this.f23814f.set(r2.size() - 1, "");
            } else {
                this.f23814f.add("");
            }
        }

        /* renamed from: a */
        public a m30990a(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f23813e = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        /* renamed from: c */
        private static int m30982c(String str, int i10, int i11) {
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

        /* renamed from: d */
        private static int m30983d(String str, int i10, int i11) {
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

        /* renamed from: a */
        public int m30989a() {
            int i10 = this.f23813e;
            return i10 != -1 ? i10 : C5193az.m30950a(this.f23809a);
        }

        /* renamed from: a */
        public a m30991a(C5193az c5193az, String str) throws NumberFormatException {
            int iM31175a;
            int i10;
            int iM31173a = C5210bo.m31173a(str, 0, str.length());
            int iM31201b = C5210bo.m31201b(str, iM31173a, str.length());
            int iM30981b = m30981b(str, iM31173a, iM31201b);
            if (iM30981b != -1) {
                if (str.regionMatches(true, iM31173a, "https:", 0, 6)) {
                    this.f23809a = "https";
                    iM31173a += 6;
                } else if (str.regionMatches(true, iM31173a, "http:", 0, 5)) {
                    this.f23809a = "http";
                    iM31173a += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iM30981b) + "'");
                }
            } else if (c5193az != null) {
                this.f23809a = c5193az.f23800a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int iM30982c = m30982c(str, iM31173a, iM31201b);
            char c10 = '?';
            char c11 = '#';
            if (iM30982c < 2 && c5193az != null && c5193az.f23800a.equals(this.f23809a)) {
                this.f23810b = c5193az.m30968d();
                this.f23811c = c5193az.m30969e();
                this.f23812d = c5193az.f23801b;
                this.f23813e = c5193az.f23802c;
                this.f23814f.clear();
                this.f23814f.addAll(c5193az.m30973i());
                if (iM31173a == iM31201b || str.charAt(iM31173a) == '#') {
                    m30998e(c5193az.m30974j());
                }
            } else {
                boolean z10 = false;
                boolean z11 = false;
                int i11 = iM31173a + iM30982c;
                while (true) {
                    iM31175a = C5210bo.m31175a(str, i11, iM31201b, "@/\\?#");
                    char cCharAt = iM31175a != iM31201b ? str.charAt(iM31175a) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c11 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c10) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (!z10) {
                            int iM31174a = C5210bo.m31174a(str, i11, iM31175a, ':');
                            i10 = iM31175a;
                            String strM30951a = C5193az.m30951a(str, i11, iM31174a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                strM30951a = this.f23810b + "%40" + strM30951a;
                            }
                            this.f23810b = strM30951a;
                            if (iM31174a != i10) {
                                this.f23811c = C5193az.m30951a(str, iM31174a + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        } else {
                            i10 = iM31175a;
                            this.f23811c += "%40" + C5193az.m30951a(str, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i11 = i10 + 1;
                    }
                    c10 = '?';
                    c11 = '#';
                }
                int iM30983d = m30983d(str, i11, iM31175a);
                int i12 = iM30983d + 1;
                if (i12 < iM31175a) {
                    this.f23812d = m30985e(str, i11, iM30983d);
                    int iM30986f = m30986f(str, i12, iM31175a);
                    this.f23813e = iM30986f;
                    if (iM30986f == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i12, iM31175a) + '\"');
                    }
                } else {
                    this.f23812d = m30985e(str, i11, iM30983d);
                    this.f23813e = C5193az.m30950a(this.f23809a);
                }
                if (this.f23812d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i11, iM30983d) + '\"');
                }
                iM31173a = iM31175a;
            }
            int iM31175a2 = C5210bo.m31175a(str, iM31173a, iM31201b, "?#");
            m30979a(str, iM31173a, iM31175a2);
            if (iM31175a2 < iM31201b && str.charAt(iM31175a2) == '?') {
                int iM31174a2 = C5210bo.m31174a(str, iM31175a2, iM31201b, '#');
                this.f23815g = C5193az.m30960b(C5193az.m30951a(str, iM31175a2 + 1, iM31174a2, C6010m7.f27501o, true, false, true, true, null));
                iM31175a2 = iM31174a2;
            }
            if (iM31175a2 < iM31201b && str.charAt(iM31175a2) == '#') {
                this.f23816h = C5193az.m30951a(str, 1 + iM31175a2, iM31201b, "", true, false, false, false, null);
            }
            return this;
        }

        /* renamed from: b */
        private static int m30981b(String str, int i10, int i11) {
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

        /* renamed from: a */
        private void m30979a(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt != '/' && cCharAt != '\\') {
                List<String> list = this.f23814f;
                list.set(list.size() - 1, "");
            } else {
                this.f23814f.clear();
                this.f23814f.add("");
                i10++;
            }
            while (true) {
                int i12 = i10;
                if (i12 >= i11) {
                    return;
                }
                i10 = C5210bo.m31175a(str, i12, i11, "/\\");
                boolean z10 = i10 < i11;
                m30980a(str, i12, i10, z10, true);
                if (z10) {
                    i10++;
                }
            }
        }

        /* renamed from: a */
        private void m30980a(String str, int i10, int i11, boolean z10, boolean z11) {
            String strM30951a = C5193az.m30951a(str, i10, i11, C6010m7.f27499m, z11, false, false, true, null);
            if (m30987f(strM30951a)) {
                return;
            }
            if (m30988g(strM30951a)) {
                m30984d();
                return;
            }
            if (this.f23814f.get(r11.size() - 1).isEmpty()) {
                this.f23814f.set(r11.size() - 1, strM30951a);
            } else {
                this.f23814f.add(strM30951a);
            }
            if (z10) {
                this.f23814f.add("");
            }
        }
    }

    public C5193az(a aVar) {
        this.f23800a = aVar.f23809a;
        this.f23803e = m30954a(aVar.f23810b, false);
        this.f23804f = m30954a(aVar.f23811c, false);
        this.f23801b = aVar.f23812d;
        this.f23802c = aVar.m30989a();
        this.f23805g = m30955a(aVar.f23814f, false);
        List<String> list = aVar.f23815g;
        this.f23806h = list != null ? m30955a(list, true) : null;
        String str = aVar.f23816h;
        this.f23807i = str != null ? m30954a(str, false) : null;
        this.f23808j = aVar.toString();
    }

    /* renamed from: a */
    public static void m30956a(C1054d c1054d, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        C1054d c1054d2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z12) {
                    c1054d.mo6329R(z10 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z13) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z10 || (z11 && !m30959a(str, i10, i11)))))) {
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
                            char[] cArr = f23799d;
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

    /* renamed from: b */
    public String m30964b() {
        return this.f23800a;
    }

    /* renamed from: c */
    public boolean m30966c() {
        return this.f23800a.equals("https");
    }

    /* renamed from: d */
    public String m30968d() {
        if (this.f23803e.isEmpty()) {
            return "";
        }
        int length = this.f23800a.length() + 3;
        String str = this.f23808j;
        return this.f23808j.substring(length, C5210bo.m31175a(str, length, str.length(), ":@"));
    }

    /* renamed from: e */
    public String m30969e() {
        if (this.f23804f.isEmpty()) {
            return "";
        }
        return this.f23808j.substring(this.f23808j.indexOf(58, this.f23800a.length() + 3) + 1, this.f23808j.indexOf(64));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5193az) && ((C5193az) obj).f23808j.equals(this.f23808j);
    }

    /* renamed from: f */
    public String m30970f() {
        return this.f23801b;
    }

    /* renamed from: g */
    public int m30971g() {
        return this.f23802c;
    }

    /* renamed from: h */
    public String m30972h() {
        int iIndexOf = this.f23808j.indexOf(47, this.f23800a.length() + 3);
        String str = this.f23808j;
        return this.f23808j.substring(iIndexOf, C5210bo.m31175a(str, iIndexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f23808j.hashCode();
    }

    /* renamed from: i */
    public List<String> m30973i() {
        int iIndexOf = this.f23808j.indexOf(47, this.f23800a.length() + 3);
        String str = this.f23808j;
        int iM31175a = C5210bo.m31175a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iM31175a) {
            int i10 = iIndexOf + 1;
            int iM31174a = C5210bo.m31174a(this.f23808j, i10, iM31175a, C5929g4.f26852n);
            arrayList.add(this.f23808j.substring(i10, iM31174a));
            iIndexOf = iM31174a;
        }
        return arrayList;
    }

    /* renamed from: j */
    public String m30974j() {
        if (this.f23806h == null) {
            return null;
        }
        int iIndexOf = this.f23808j.indexOf(63) + 1;
        String str = this.f23808j;
        return this.f23808j.substring(iIndexOf, C5210bo.m31174a(str, iIndexOf, str.length(), '#'));
    }

    /* renamed from: k */
    public String m30975k() {
        if (this.f23806h == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        m30961b(sb2, this.f23806h);
        return sb2.toString();
    }

    /* renamed from: l */
    public String m30976l() {
        if (this.f23807i == null) {
            return null;
        }
        return this.f23808j.substring(this.f23808j.indexOf(35) + 1);
    }

    /* renamed from: m */
    public String m30977m() {
        return m30967d("/...").m30994b("").m30995c("").m30996c().toString();
    }

    /* renamed from: n */
    public a m30978n() {
        a aVar = new a();
        aVar.f23809a = this.f23800a;
        aVar.f23810b = m30968d();
        aVar.f23811c = m30969e();
        aVar.f23812d = this.f23801b;
        aVar.f23813e = this.f23802c != m30950a(this.f23800a) ? this.f23802c : -1;
        aVar.f23814f.clear();
        aVar.f23814f.addAll(m30973i());
        aVar.m30998e(m30974j());
        aVar.f23816h = m30976l();
        return aVar;
    }

    public String toString() {
        return this.f23808j;
    }

    /* renamed from: b */
    public static void m30961b(StringBuilder sb2, List<String> list) {
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

    /* renamed from: c */
    public C5193az m30965c(String str) {
        a aVarM30967d = m30967d(str);
        if (aVarM30967d != null) {
            return aVarM30967d.m30996c();
        }
        return null;
    }

    /* renamed from: e */
    public static C5193az m30962e(String str) {
        return new a().m30991a(null, str).m30996c();
    }

    /* renamed from: d */
    public a m30967d(String str) {
        try {
            return new a().m30991a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static List<String> m30960b(String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int iIndexOf = str.indexOf(38, i10);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i10);
            if (iIndexOf2 != -1 && iIndexOf2 <= iIndexOf) {
                arrayList.add(str.substring(i10, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            } else {
                arrayList.add(str.substring(i10, iIndexOf));
                arrayList.add(null);
            }
            i10 = iIndexOf + 1;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m30957a(p022ay.C1054d r5, java.lang.String r6, int r7, int r8, boolean r9) {
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
            int r2 = com.huawei.hms.drive.C5210bo.m31172a(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.huawei.hms.drive.C5210bo.m31172a(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5193az.m30957a(ay.d, java.lang.String, int, int, boolean):void");
    }

    /* renamed from: a */
    public URI m30963a() {
        String string = m30978n().m30993b().toString();
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

    /* renamed from: a */
    public static int m30950a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return C5927g2.f26808n;
        }
        return -1;
    }

    /* renamed from: a */
    public static void m30958a(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(C5929g4.f26852n);
            sb2.append(list.get(i10));
        }
    }

    /* renamed from: a */
    public static String m30954a(String str, boolean z10) {
        return m30952a(str, 0, str.length(), z10);
    }

    /* renamed from: a */
    private List<String> m30955a(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = list.get(i10);
            arrayList.add(str != null ? m30954a(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static String m30952a(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                C1054d c1054d = new C1054d();
                c1054d.m6350q0(str, i10, i12);
                m30957a(c1054d, str, i12, i11, z10);
                return c1054d.m6319F();
            }
        }
        return str.substring(i10, i11);
    }

    /* renamed from: a */
    public static boolean m30959a(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && C5210bo.m31172a(str.charAt(i10 + 1)) != -1 && C5210bo.m31172a(str.charAt(i12)) != -1;
    }

    /* renamed from: a */
    public static String m30951a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z13)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z10 && (!z11 || m30959a(str, iCharCount, i11)))) && (iCodePointAt != 43 || !z12))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    C1054d c1054d = new C1054d();
                    c1054d.m6350q0(str, i10, iCharCount);
                    m30956a(c1054d, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                    return c1054d.m6319F();
                }
            } else {
                C1054d c1054d2 = new C1054d();
                c1054d2.m6350q0(str, i10, iCharCount);
                m30956a(c1054d2, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                return c1054d2.m6319F();
            }
        }
        return str.substring(i10, i11);
    }

    /* renamed from: a */
    public static String m30953a(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return m30951a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }
}
