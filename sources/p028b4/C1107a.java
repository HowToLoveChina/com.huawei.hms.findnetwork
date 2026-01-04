package p028b4;

import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C6051p9;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.math.BigInteger;

/* renamed from: b4.a */
/* loaded from: classes.dex */
public final class C1107a {

    /* renamed from: g */
    public static final c f5260g;

    /* renamed from: h */
    public static final char[] f5261h;

    /* renamed from: i */
    public static final int[] f5262i;

    /* renamed from: a */
    public final int f5263a;

    /* renamed from: b */
    public final String f5264b;

    /* renamed from: c */
    public int f5265c;

    /* renamed from: d */
    public boolean[] f5266d;

    /* renamed from: e */
    public StringBuilder f5267e;

    /* renamed from: f */
    public int f5268f;

    /* renamed from: b4.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5269a;

        static {
            int[] iArr = new int[b.values().length];
            f5269a = iArr;
            try {
                iArr[b.BEFORE_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5269a[b.BEFORE_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5269a[b.BEFORE_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5269a[b.AFTER_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5269a[b.START_MAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5269a[b.START_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5269a[b.AFTER_ELEMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5269a[b.AFTER_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: b4.a$b */
    public enum b {
        START_ARRAY,
        BEFORE_ELEMENT,
        AFTER_ELEMENT,
        START_MAP,
        BEFORE_KEY,
        AFTER_KEY,
        BEFORE_VALUE,
        AFTER_VALUE
    }

    /* renamed from: b4.a$c */
    public static final class c extends Exception {
        private static final long serialVersionUID = 783239978717247850L;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        c cVar = new c(null);
        f5260g = cVar;
        cVar.setStackTrace(new StackTraceElement[0]);
        f5261h = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f5262i = new int[]{-1, -1, 63, 39, 31, 27, 24, 22, 21, 19, 18, 18, 17, 17, 16, 16, 15};
    }

    public C1107a(String str, int i10) {
        this.f5263a = Math.min(Math.max(1, i10), 4096);
        this.f5264b = str == null ? "null" : str;
    }

    /* renamed from: A */
    public static int m6588A(String str, int i10) {
        int i11;
        if (i10 < 0) {
            return 0;
        }
        int i12 = 1;
        while (true) {
            if (i12 >= 6 || (i11 = i10 - i12) < 0) {
                break;
            }
            if (str.charAt(i11) == '\\') {
                int i13 = 1;
                while (true) {
                    int i14 = i11 - i13;
                    if (i14 < 0 || str.charAt(i14) != '\\') {
                        break;
                    }
                    i13++;
                }
                if ((i13 & 1) == 1) {
                    int iM6597z = m6597z(str, i11);
                    if ((iM6597z >>> 16) - 1 == i12) {
                        return iM6597z;
                    }
                }
            } else {
                i12++;
            }
        }
        return str.charAt(i10) | 0;
    }

    /* renamed from: c */
    public static boolean m6589c(StringBuilder sb2, int i10, int i11) throws NumberFormatException {
        int i12;
        int i13;
        int i14;
        int i15;
        char c10;
        char cCharAt;
        char cCharAt2;
        int i16 = i10 + (sb2.charAt(i10) == '-' ? 1 : 0);
        int i17 = i16;
        while (i17 < i11 && '0' <= (cCharAt2 = sb2.charAt(i17)) && cCharAt2 <= '9') {
            i17++;
        }
        if (i17 != i11 && '.' == sb2.charAt(i17)) {
            do {
                i17++;
                if (i17 >= i11 || '0' > (cCharAt = sb2.charAt(i17))) {
                    break;
                }
            } while (cCharAt <= '9');
        }
        if (i17 == i11) {
            i12 = i11;
        } else {
            i12 = i17 + 1;
            if (sb2.charAt(i12) == '+') {
                i12 = i17 + 2;
            }
        }
        if (i11 == i12) {
            i13 = 0;
        } else {
            try {
                i13 = Integer.parseInt(sb2.substring(i12, i11), 10);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        int i18 = i16;
        int i19 = i18;
        boolean z10 = false;
        int i20 = 0;
        boolean z11 = true;
        while (i18 < i17) {
            char cCharAt3 = sb2.charAt(i18);
            if (cCharAt3 == '.') {
                if (z11) {
                    i20 = 0;
                }
                z10 = true;
            } else {
                if ((!z11 || cCharAt3 != '0') && !z10) {
                    i13++;
                }
                if (cCharAt3 == '0') {
                    i20++;
                } else {
                    if (z11) {
                        if (z10) {
                            i13 -= i20;
                        }
                        i14 = i13;
                        i15 = 0;
                    } else {
                        int i21 = i20;
                        i14 = i13;
                        i15 = i21;
                    }
                    while (true) {
                        if (i15 == 0 && cCharAt3 == 0) {
                            break;
                        }
                        if (i15 == 0) {
                            c10 = 0;
                        } else {
                            i15--;
                            c10 = cCharAt3;
                            cCharAt3 = '0';
                        }
                        sb2.setCharAt(i19, cCharAt3);
                        cCharAt3 = c10;
                        i19++;
                    }
                    z11 = false;
                    int i22 = i14;
                    i20 = i15;
                    i13 = i22;
                }
            }
            i18++;
        }
        sb2.setLength(i19);
        int i23 = i19 - i16;
        if (z11) {
            sb2.setLength(i10);
            sb2.append('0');
            return true;
        }
        if (i23 <= i13 && i13 <= 21) {
            while (i23 < i13) {
                sb2.append('0');
                i23++;
            }
        } else if (i13 > 0 && i13 <= 21) {
            sb2.insert(i16 + i13, '.');
        } else if (-6 >= i13 || i13 > 0) {
            if (i23 != 1) {
                sb2.insert(i16 + 1, '.');
            }
            int i24 = i13 - 1;
            sb2.append('e');
            sb2.append(i24 >= 0 ? '+' : '-');
            sb2.append(Math.abs(i24));
        } else {
            sb2.insert(i16, "0.000000".substring(0, 2 - i13));
        }
        return true;
    }

    /* renamed from: g */
    public static int m6590g(String str, int i10) {
        int i11;
        char cCharAt = str.charAt(i10);
        int iIndexOf = i10;
        do {
            iIndexOf = str.indexOf(cCharAt, iIndexOf + 1);
            if (iIndexOf < 0) {
                return str.length();
            }
            i11 = iIndexOf;
            while (i11 > i10 && str.charAt(i11 - 1) == '\\') {
                i11--;
            }
        } while (((iIndexOf - i11) & 1) != 0);
        return iIndexOf + 1;
    }

    /* renamed from: h */
    public static int m6591h(char c10) {
        int i10 = c10 | ' ';
        return i10 - (i10 <= 57 ? 48 : 87);
    }

    /* renamed from: k */
    public static boolean m6592k(char c10) {
        if ('0' <= c10 && c10 <= '9') {
            return true;
        }
        int i10 = c10 | ' ';
        return 97 <= i10 && i10 <= 102;
    }

    /* renamed from: o */
    public static boolean m6593o(char c10) {
        return '0' <= c10 && c10 <= '7';
    }

    /* renamed from: u */
    public static int m6594u(String str, int i10) {
        int i11 = i10;
        while (i11 >= 0 && str.charAt(i11) == '\\') {
            i11--;
        }
        return i10 - i11;
    }

    /* renamed from: v */
    public static String m6595v(String str) {
        return m6596w(str, 64);
    }

    /* renamed from: w */
    public static String m6596w(String str, int i10) throws c {
        C1107a c1107a = new C1107a(str, i10);
        c1107a.m6613x();
        return c1107a.toString();
    }

    /* renamed from: z */
    public static int m6597z(String str, int i10) {
        int length = str.length();
        int iCharAt = 0;
        if (i10 >= length) {
            return 0;
        }
        char cCharAt = str.charAt(i10);
        if (cCharAt != '\\') {
            return cCharAt | 0;
        }
        int i11 = i10 + 1;
        if (i11 == length) {
            return 65536;
        }
        char cCharAt2 = str.charAt(i11);
        if (cCharAt2 == 'b') {
            return 131080;
        }
        if (cCharAt2 == 'f') {
            return 131084;
        }
        if (cCharAt2 == 'n') {
            return 131082;
        }
        if (cCharAt2 == 'r') {
            return 131085;
        }
        if (cCharAt2 != 'x') {
            switch (cCharAt2) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    int i12 = i10 + 2;
                    if (i12 < length && m6593o(str.charAt(i12))) {
                        i12 = i10 + 3;
                        if (cCharAt2 <= '3' && i12 < length && m6593o(str.charAt(i12))) {
                            i12 = i10 + 4;
                        }
                    }
                    while (i11 < i12) {
                        iCharAt = (iCharAt << 3) | (str.charAt(i11) - '0');
                        i11++;
                    }
                    return ((i12 - i10) << 16) | iCharAt;
                default:
                    switch (cCharAt2) {
                        case 't':
                            return 131081;
                        case 'u':
                            int i13 = i10 + 5;
                            if (i13 < length) {
                                char cCharAt3 = str.charAt(i10 + 2);
                                char cCharAt4 = str.charAt(i10 + 3);
                                char cCharAt5 = str.charAt(i10 + 4);
                                char cCharAt6 = str.charAt(i13);
                                if (m6592k(cCharAt3) && m6592k(cCharAt4) && m6592k(cCharAt5) && m6592k(cCharAt6)) {
                                    return m6591h(cCharAt6) | (m6591h(cCharAt5) << 4) | (m6591h(cCharAt3) << 12) | ARImageMetadata.HOT_PIXEL_MODE | (m6591h(cCharAt4) << 8);
                                }
                            }
                            break;
                        case 'v':
                            return 131080;
                    }
            }
        } else {
            int i14 = i10 + 3;
            if (i14 < length) {
                char cCharAt7 = str.charAt(i10 + 2);
                char cCharAt8 = str.charAt(i14);
                if (m6592k(cCharAt7) && m6592k(cCharAt8)) {
                    return m6591h(cCharAt8) | (m6591h(cCharAt7) << 4) | C6051p9.f27764p;
                }
            }
        }
        return 0 | cCharAt2;
    }

    /* renamed from: a */
    public final void m6598a(int i10, int i11) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return;
            }
            int i12 = (i10 >>> (i11 * 4)) & 15;
            this.f5267e.append((char) (i12 + (i12 < 10 ? 48 : 87)));
        }
    }

    /* renamed from: b */
    public final boolean m6599b(int i10, int i11) {
        m6600d(i10, i10);
        int length = this.f5267e.length();
        m6609q(i10, i11);
        m6600d(i11, i11);
        return m6589c(this.f5267e, length, this.f5267e.length());
    }

    /* renamed from: d */
    public final void m6600d(int i10, int i11) {
        if (this.f5267e == null) {
            this.f5267e = new StringBuilder(this.f5264b.length() + 16);
        }
        this.f5267e.append((CharSequence) this.f5264b, this.f5268f, i10);
        this.f5268f = i11;
    }

    /* renamed from: e */
    public final void m6601e(int i10) {
        while (true) {
            int i11 = i10 - 1;
            if (i11 >= this.f5268f) {
                char cCharAt = this.f5264b.charAt(i11);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                    if (cCharAt == ',') {
                        m6600d(i11, i10);
                        return;
                    }
                    throw new AssertionError("" + this.f5264b.charAt(i11));
                }
                i10 = i11;
            } else {
                int length = this.f5267e.length();
                while (true) {
                    length--;
                    if (length < 0) {
                        throw new AssertionError("Trailing comma not found in " + this.f5264b + " or " + ((Object) this.f5267e));
                    }
                    char cCharAt2 = this.f5267e.charAt(length);
                    if (cCharAt2 != '\t' && cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ') {
                        if (cCharAt2 == ',') {
                            this.f5267e.setLength(length);
                            return;
                        }
                        throw new AssertionError("" + this.f5267e.charAt(length));
                    }
                }
            }
        }
    }

    /* renamed from: f */
    public final int m6602f(int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = this.f5264b.charAt(i10);
            if ('0' > cCharAt || cCharAt > '9') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: i */
    public final void m6603i(int i10, char c10) {
        m6610r(i10, i10, c10);
    }

    /* renamed from: j */
    public final void m6604j(int i10, String str) {
        m6611s(i10, i10, str);
    }

    /* renamed from: l */
    public final boolean m6605l(int i10) {
        return m6592k(this.f5264b.charAt(i10));
    }

    /* renamed from: m */
    public final boolean m6606m(int i10) {
        char cCharAt = this.f5264b.charAt(i10);
        return cCharAt <= ' ' || cCharAt == '\"' || cCharAt == ',' || cCharAt == ':' || cCharAt == '[' || cCharAt == ']' || cCharAt == '{' || cCharAt == '}';
    }

    /* renamed from: n */
    public final boolean m6607n(int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 5) {
            return "false".regionMatches(0, this.f5264b, i10, i12);
        }
        if (i12 == 4) {
            return "null".regionMatches(0, this.f5264b, i10, i12) || FaqConstants.DISABLE_HA_REPORT.regionMatches(0, this.f5264b, i10, i12);
        }
        return false;
    }

    /* renamed from: p */
    public final boolean m6608p(int i10) {
        return m6593o(this.f5264b.charAt(i10));
    }

    /* renamed from: q */
    public final void m6609q(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        char cCharAt;
        if (i10 < i11) {
            char cCharAt2 = this.f5264b.charAt(i10);
            if (cCharAt2 == '+') {
                int i16 = i10 + 1;
                m6600d(i10, i16);
                i10 = i16;
            } else if (cCharAt2 == '-') {
                i10++;
            }
        }
        int iM6602f = m6602f(i10, i11);
        if (i10 == iM6602f) {
            m6603i(i10, '0');
        } else if ('0' == this.f5264b.charAt(i10)) {
            int i17 = iM6602f - i10;
            int i18 = 16;
            int iMax = 0;
            boolean z10 = true;
            if (i17 == 1 && iM6602f < i11 && 120 == (this.f5264b.charAt(iM6602f) | ' ')) {
                int i19 = iM6602f + 1;
                int i20 = i19;
                while (i20 < i11) {
                    char cCharAt3 = this.f5264b.charAt(i20);
                    if ('0' > cCharAt3 || cCharAt3 > '9') {
                        char c10 = (char) (cCharAt3 | ' ');
                        if ('a' > c10 || c10 > 'f') {
                            break;
                        } else {
                            i15 = c10 - 'W';
                        }
                    } else {
                        i15 = cCharAt3 - '0';
                    }
                    iMax = Math.max(i15, iMax);
                    i20++;
                }
                i13 = iMax;
                i14 = 16;
                int i21 = i20;
                i12 = i19;
                iM6602f = i21;
            } else if (i17 > 1) {
                for (int i22 = i10; i22 < iM6602f; i22++) {
                    int iCharAt = this.f5264b.charAt(i22) - '0';
                    if (iCharAt < 0) {
                        break;
                    }
                    iMax = Math.max(iCharAt, iMax);
                }
                i13 = iMax;
                i14 = 8;
                i12 = i10;
            } else {
                i12 = -1;
                z10 = false;
                i13 = 0;
                i14 = 10;
            }
            if (z10) {
                m6600d(i10, iM6602f);
                String strSubstring = this.f5264b.substring(i12, iM6602f);
                int length = strSubstring.length();
                if (i14 > i13) {
                    i18 = i14;
                } else if (i13 <= 10) {
                    i18 = 10;
                }
                if (length == 0) {
                    this.f5267e.append('0');
                } else if (f5262i[i18] >= length) {
                    this.f5267e.append(Long.parseLong(strSubstring, i18));
                } else {
                    this.f5267e.append(new BigInteger(strSubstring, i18));
                }
            }
        }
        if (iM6602f < i11 && this.f5264b.charAt(iM6602f) == '.') {
            int i23 = iM6602f + 1;
            int iM6602f2 = m6602f(i23, i11);
            if (iM6602f2 == i23) {
                m6603i(i23, '0');
            }
            iM6602f = iM6602f2;
        }
        if (iM6602f < i11 && 101 == (this.f5264b.charAt(iM6602f) | ' ')) {
            int i24 = iM6602f + 1;
            if (i24 < i11 && ((cCharAt = this.f5264b.charAt(i24)) == '+' || cCharAt == '-')) {
                i24 = iM6602f + 2;
            }
            iM6602f = m6602f(i24, i11);
            if (iM6602f == i24) {
                m6603i(i24, '0');
            }
        }
        if (iM6602f != i11) {
            m6600d(iM6602f, i11);
        }
    }

    /* renamed from: r */
    public final void m6610r(int i10, int i11, char c10) {
        m6600d(i10, i11);
        this.f5267e.append(c10);
    }

    /* renamed from: s */
    public final void m6611s(int i10, int i11, String str) {
        m6600d(i10, i11);
        this.f5267e.append(str);
    }

    /* renamed from: t */
    public final b m6612t(int i10, b bVar, boolean z10) throws c {
        switch (a.f5269a[bVar.ordinal()]) {
            case 1:
                return b.AFTER_VALUE;
            case 2:
            case 6:
                return b.AFTER_ELEMENT;
            case 3:
            case 5:
                if (z10) {
                    return b.AFTER_KEY;
                }
                m6604j(i10, "\"\":");
                return b.AFTER_VALUE;
            case 4:
                m6603i(i10, ':');
                return b.AFTER_VALUE;
            case 7:
                if (this.f5265c == 0) {
                    throw f5260g;
                }
                m6603i(i10, ',');
                return b.AFTER_ELEMENT;
            case 8:
                if (z10) {
                    m6603i(i10, ',');
                    return b.AFTER_KEY;
                }
                m6604j(i10, ",\"\":");
                return b.AFTER_VALUE;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        StringBuilder sb2 = this.f5267e;
        return sb2 != null ? sb2.toString() : this.f5264b;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0050. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010b A[Catch: c -> 0x022d, TryCatch #0 {c -> 0x022d, blocks: (B:5:0x001e, B:26:0x0050, B:30:0x0060, B:47:0x0088, B:49:0x0093, B:50:0x009a, B:60:0x00ae, B:67:0x00bd, B:70:0x00c4, B:72:0x00c9, B:74:0x00d3, B:75:0x00d5, B:77:0x00d9, B:79:0x00e0, B:85:0x00fb, B:80:0x00e7, B:82:0x00ed, B:84:0x00f3, B:87:0x0100, B:176:0x021a, B:162:0x01ea, B:90:0x010b, B:92:0x010f, B:93:0x011a, B:105:0x0139, B:110:0x014b, B:111:0x0150, B:113:0x0154, B:116:0x015d, B:117:0x0160, B:102:0x012e, B:103:0x0132, B:104:0x0136, B:119:0x0164, B:121:0x016c, B:125:0x0177, B:127:0x0183, B:128:0x0186, B:130:0x018b, B:132:0x0190, B:133:0x0193, B:134:0x019a, B:136:0x019f, B:140:0x01ac, B:142:0x01b0, B:151:0x01c7, B:159:0x01e3, B:152:0x01ca, B:154:0x01ce, B:155:0x01d0, B:157:0x01d9, B:161:0x01e7, B:163:0x01ed, B:165:0x01f2, B:166:0x01fa, B:168:0x01fe, B:169:0x0201, B:170:0x0204, B:171:0x020a, B:172:0x0210, B:173:0x0216, B:174:0x0218), top: B:217:0x001e }] */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6613x() throws p028b4.C1107a.c {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p028b4.C1107a.m6613x():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a A[PHI: r6
  0x006a: PHI (r6v33 int) = (r6v31 int), (r6v49 int) binds: [B:84:0x0125, B:38:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080 A[LOOP:1: B:44:0x007c->B:46:0x0080, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0100  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6614y(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p028b4.C1107a.m6614y(int, int):void");
    }
}
