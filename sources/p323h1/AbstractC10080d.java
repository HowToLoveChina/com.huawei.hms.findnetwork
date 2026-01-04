package p323h1;

import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p481n1.C11595g;

/* renamed from: h1.d */
/* loaded from: classes.dex */
public abstract class AbstractC10080d implements InterfaceC10079c, Closeable {

    /* renamed from: q */
    public static final ThreadLocal<char[]> f49197q = new ThreadLocal<>();

    /* renamed from: r */
    public static final char[] f49198r = ("\"" + AbstractC9377a.f46780c + "\":\"").toCharArray();

    /* renamed from: s */
    public static final int[] f49199s = new int[103];

    /* renamed from: a */
    public int f49200a;

    /* renamed from: b */
    public int f49201b;

    /* renamed from: c */
    public int f49202c;

    /* renamed from: d */
    public char f49203d;

    /* renamed from: e */
    public int f49204e;

    /* renamed from: f */
    public int f49205f;

    /* renamed from: g */
    public char[] f49206g;

    /* renamed from: h */
    public int f49207h;

    /* renamed from: i */
    public int f49208i;

    /* renamed from: j */
    public boolean f49209j;

    /* renamed from: o */
    public String f49214o;

    /* renamed from: k */
    public Calendar f49210k = null;

    /* renamed from: l */
    public TimeZone f49211l = AbstractC9377a.f46778a;

    /* renamed from: m */
    public Locale f49212m = AbstractC9377a.f46779b;

    /* renamed from: n */
    public int f49213n = 0;

    /* renamed from: p */
    public int f49215p = 0;

    static {
        for (int i10 = 48; i10 <= 57; i10++) {
            f49199s[i10] = i10 - 48;
        }
        for (int i11 = 97; i11 <= 102; i11++) {
            f49199s[i11] = i11 - 87;
        }
        for (int i12 = 65; i12 <= 70; i12++) {
            f49199s[i12] = i12 - 55;
        }
    }

    public AbstractC10080d(int i10) {
        this.f49214o = null;
        this.f49202c = i10;
        if ((i10 & EnumC10078b.InitStringFieldAsEmpty.f49196a) != 0) {
            this.f49214o = "";
        }
        char[] cArr = f49197q.get();
        this.f49206g = cArr;
        if (cArr == null) {
            this.f49206g = new char[512];
        }
    }

    /* renamed from: J0 */
    public static boolean m62792J0(char c10) {
        return c10 <= ' ' && (c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b');
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* renamed from: P0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m62793P0(char[] r17, int r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.m62793P0(char[], int):java.lang.String");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: A */
    public final void mo62752A() {
        char next;
        char next2;
        this.f49208i = this.f49204e;
        this.f49209j = false;
        while (true) {
            char next3 = next();
            if (next3 == '\"') {
                this.f49200a = 4;
                this.f49203d = next();
                return;
            }
            if (next3 == 26) {
                if (mo62797I0()) {
                    throw new C9380d("unclosed string : " + next3);
                }
                m62802O0((char) 26);
            } else if (next3 == '\\') {
                if (!this.f49209j) {
                    this.f49209j = true;
                    int i10 = this.f49207h;
                    char[] cArr = this.f49206g;
                    if (i10 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i10 <= length) {
                            i10 = length;
                        }
                        char[] cArr2 = new char[i10];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f49206g = cArr2;
                    }
                    mo62822f(this.f49208i + 1, this.f49207h, this.f49206g);
                }
                char next4 = next();
                if (next4 == '\"') {
                    m62802O0('\"');
                } else if (next4 != '\'') {
                    if (next4 != 'F') {
                        if (next4 == '\\') {
                            m62802O0('\\');
                        } else if (next4 == 'b') {
                            m62802O0('\b');
                        } else if (next4 != 'f') {
                            if (next4 == 'n') {
                                m62802O0('\n');
                            } else if (next4 == 'r') {
                                m62802O0('\r');
                            } else if (next4 != 'x') {
                                switch (next4) {
                                    case '/':
                                        m62802O0(C5929g4.f26852n);
                                        break;
                                    case '0':
                                        m62802O0((char) 0);
                                        break;
                                    case '1':
                                        m62802O0((char) 1);
                                        break;
                                    case '2':
                                        m62802O0((char) 2);
                                        break;
                                    case '3':
                                        m62802O0((char) 3);
                                        break;
                                    case '4':
                                        m62802O0((char) 4);
                                        break;
                                    case '5':
                                        m62802O0((char) 5);
                                        break;
                                    case '6':
                                        m62802O0((char) 6);
                                        break;
                                    case '7':
                                        m62802O0((char) 7);
                                        break;
                                    default:
                                        switch (next4) {
                                            case 't':
                                                m62802O0('\t');
                                                break;
                                            case 'u':
                                                m62802O0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                m62802O0((char) 11);
                                                break;
                                            default:
                                                this.f49203d = next4;
                                                throw new C9380d("unclosed string : " + next4);
                                        }
                                }
                            } else {
                                next = next();
                                next2 = next();
                                boolean z10 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                boolean z11 = (next2 >= '0' && next2 <= '9') || (next2 >= 'a' && next2 <= 'f') || (next2 >= 'A' && next2 <= 'F');
                                if (z10 && z11) {
                                    int[] iArr = f49199s;
                                    m62802O0((char) ((iArr[next] * 16) + iArr[next2]));
                                }
                            }
                        }
                    }
                    m62802O0('\f');
                } else {
                    m62802O0('\'');
                }
            } else if (this.f49209j) {
                int i11 = this.f49207h;
                char[] cArr3 = this.f49206g;
                if (i11 == cArr3.length) {
                    m62802O0(next3);
                } else {
                    this.f49207h = i11 + 1;
                    cArr3[i11] = next3;
                }
            } else {
                this.f49207h++;
            }
        }
        throw new C9380d("invalid escape character \\x" + next + next2);
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: B */
    public final int mo62753B() {
        int i10;
        boolean z10;
        int i11 = 0;
        if (this.f49208i == -1) {
            this.f49208i = 0;
        }
        int i12 = this.f49208i;
        int i13 = this.f49207h + i12;
        if (mo62820e(i12) == '-') {
            i12++;
            i10 = Integer.MIN_VALUE;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i12 < i13) {
            i11 = -(mo62820e(i12) - '0');
            i12++;
        }
        while (i12 < i13) {
            int i14 = i12 + 1;
            char cMo62820e = mo62820e(i12);
            if (cMo62820e == 'L' || cMo62820e == 'S' || cMo62820e == 'B') {
                i12 = i14;
                break;
            }
            int i15 = cMo62820e - '0';
            if (i11 < -214748364) {
                throw new NumberFormatException(mo62757D0());
            }
            int i16 = i11 * 10;
            if (i16 < i10 + i15) {
                throw new NumberFormatException(mo62757D0());
            }
            i11 = i16 - i15;
            i12 = i14;
        }
        if (!z10) {
            return -i11;
        }
        if (i12 > this.f49208i + 1) {
            return i11;
        }
        throw new NumberFormatException(mo62757D0());
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: B0 */
    public final boolean mo62754B0() {
        return this.f49207h == 4 && mo62820e(this.f49208i + 1) == '$' && mo62820e(this.f49208i + 2) == 'r' && mo62820e(this.f49208i + 3) == 'e' && mo62820e(this.f49208i + 4) == 'f';
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: C */
    public final void mo62755C() {
        char c10;
        boolean z10;
        char c11;
        this.f49208i = this.f49204e;
        if (this.f49203d == '-') {
            this.f49207h++;
            next();
        }
        while (true) {
            c10 = this.f49203d;
            if (c10 < '0' || c10 > '9') {
                break;
            }
            this.f49207h++;
            next();
        }
        if (c10 == '.') {
            this.f49207h++;
            next();
            while (true) {
                char c12 = this.f49203d;
                if (c12 < '0' || c12 > '9') {
                    break;
                }
                this.f49207h++;
                next();
            }
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = this.f49207h;
        if (i10 > 65535) {
            throw new C9380d("scanNumber overflow");
        }
        char c13 = this.f49203d;
        if (c13 != 'L' && c13 != 'S' && c13 != 'B') {
            if (c13 == 'F' || c13 == 'D') {
                this.f49207h = i10 + 1;
                next();
            } else if (c13 == 'e' || c13 == 'E') {
                this.f49207h = i10 + 1;
                next();
                char c14 = this.f49203d;
                if (c14 == '+' || c14 == '-') {
                    this.f49207h++;
                    next();
                }
                while (true) {
                    c11 = this.f49203d;
                    if (c11 < '0' || c11 > '9') {
                        break;
                    }
                    this.f49207h++;
                    next();
                }
                if (c11 == 'D' || c11 == 'F') {
                    this.f49207h++;
                    next();
                }
            }
            this.f49200a = 3;
        }
        this.f49207h = i10 + 1;
        next();
        if (!z10) {
            this.f49200a = 2;
            return;
        }
        this.f49200a = 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x007b A[SYNTHETIC] */
    @Override // p323h1.InterfaceC10079c
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo62756D(int r11) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.mo62756D(int):void");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: D0 */
    public abstract String mo62757D0();

    @Override // p323h1.InterfaceC10079c
    /* renamed from: E */
    public Enum<?> mo62758E(Class<?> cls, C10086j c10086j, char c10) {
        String strM62827j1 = m62827j1(c10086j, c10);
        if (strM62827j1 == null) {
            return null;
        }
        return Enum.valueOf(cls, strM62827j1);
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: F */
    public abstract BigDecimal mo62759F();

    /* renamed from: F0 */
    public double m62794F0() {
        return Double.parseDouble(mo62757D0());
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: G */
    public int mo62760G(char c10) {
        int i10;
        int i11;
        char cMo62820e;
        this.f49213n = 0;
        char cMo62820e2 = mo62820e(this.f49204e);
        boolean z10 = cMo62820e2 == '\"';
        if (z10) {
            cMo62820e2 = mo62820e(this.f49204e + 1);
            i10 = 2;
        } else {
            i10 = 1;
        }
        boolean z11 = cMo62820e2 == '-';
        if (z11) {
            cMo62820e2 = mo62820e(this.f49204e + i10);
            i10++;
        }
        if (cMo62820e2 >= '0' && cMo62820e2 <= '9') {
            int i12 = cMo62820e2 - '0';
            while (true) {
                i11 = i10 + 1;
                cMo62820e = mo62820e(this.f49204e + i10);
                if (cMo62820e < '0' || cMo62820e > '9') {
                    break;
                }
                i12 = (i12 * 10) + (cMo62820e - '0');
                i10 = i11;
            }
            if (cMo62820e == '.') {
                this.f49213n = -1;
                return 0;
            }
            if (i12 < 0) {
                this.f49213n = -1;
                return 0;
            }
            while (cMo62820e != c10) {
                if (!m62792J0(cMo62820e)) {
                    this.f49213n = -1;
                    return z11 ? -i12 : i12;
                }
                char cMo62820e3 = mo62820e(this.f49204e + i11);
                i11++;
                cMo62820e = cMo62820e3;
            }
            int i13 = this.f49204e + i11;
            this.f49204e = i13;
            this.f49203d = mo62820e(i13);
            this.f49213n = 3;
            this.f49200a = 16;
            return z11 ? -i12 : i12;
        }
        if (cMo62820e2 != 'n' || mo62820e(this.f49204e + i10) != 'u' || mo62820e(this.f49204e + i10 + 1) != 'l' || mo62820e(this.f49204e + i10 + 2) != 'l') {
            this.f49213n = -1;
            return 0;
        }
        this.f49213n = 5;
        int i14 = i10 + 4;
        char cMo62820e4 = mo62820e(this.f49204e + i10 + 3);
        if (z10 && cMo62820e4 == '\"') {
            cMo62820e4 = mo62820e(this.f49204e + i14);
            i14 = i10 + 5;
        }
        while (cMo62820e4 != ',') {
            if (cMo62820e4 == ']') {
                int i15 = this.f49204e + i14;
                this.f49204e = i15;
                this.f49203d = mo62820e(i15);
                this.f49213n = 5;
                this.f49200a = 15;
                return 0;
            }
            if (!m62792J0(cMo62820e4)) {
                this.f49213n = -1;
                return 0;
            }
            cMo62820e4 = mo62820e(this.f49204e + i14);
            i14++;
        }
        int i16 = this.f49204e + i14;
        this.f49204e = i16;
        this.f49203d = mo62820e(i16);
        this.f49213n = 5;
        this.f49200a = 16;
        return 0;
    }

    /* renamed from: G0 */
    public Calendar m62795G0() {
        return this.f49210k;
    }

    /* renamed from: H0 */
    public abstract int mo62796H0(char c10, int i10);

    @Override // p323h1.InterfaceC10079c
    /* renamed from: I */
    public final void mo62762I(int i10) {
        m62801N0(':');
    }

    /* renamed from: I0 */
    public abstract boolean mo62797I0();

    @Override // p323h1.InterfaceC10079c
    /* renamed from: J */
    public abstract String mo62763J();

    /* renamed from: K0 */
    public void m62798K0(String str, Object... objArr) {
        this.f49200a = 1;
    }

    /* renamed from: L0 */
    public final boolean m62799L0(char[] cArr) {
        while (!mo62818d(cArr)) {
            if (!m62792J0(this.f49203d)) {
                return false;
            }
            next();
        }
        int length = this.f49204e + cArr.length;
        this.f49204e = length;
        char cMo62820e = mo62820e(length);
        this.f49203d = cMo62820e;
        if (cMo62820e == '{') {
            next();
            this.f49200a = 12;
        } else if (cMo62820e == '[') {
            next();
            this.f49200a = 14;
        } else if (cMo62820e == 'S' && mo62820e(this.f49204e + 1) == 'e' && mo62820e(this.f49204e + 2) == 't' && mo62820e(this.f49204e + 3) == '[') {
            int i10 = this.f49204e + 3;
            this.f49204e = i10;
            this.f49203d = mo62820e(i10);
            this.f49200a = 21;
        } else {
            mo62790z();
        }
        return true;
    }

    /* renamed from: M0 */
    public final void m62800M0() {
        while (m62792J0(this.f49203d)) {
            next();
        }
        char c10 = this.f49203d;
        if (c10 == '_' || c10 == '$' || Character.isLetter(c10)) {
            m62823f1();
        } else {
            mo62790z();
        }
    }

    /* renamed from: N0 */
    public final void m62801N0(char c10) {
        this.f49207h = 0;
        while (true) {
            char c11 = this.f49203d;
            if (c11 == c10) {
                next();
                mo62790z();
                return;
            }
            if (c11 != ' ' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                throw new C9380d("not match " + c10 + " - " + this.f49203d + ", info : " + mo62781t());
            }
            next();
        }
    }

    /* renamed from: O0 */
    public final void m62802O0(char c10) {
        int i10 = this.f49207h;
        char[] cArr = this.f49206g;
        if (i10 >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i10) {
                length = i10 + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f49206g = cArr2;
        }
        char[] cArr3 = this.f49206g;
        int i11 = this.f49207h;
        this.f49207h = i11 + 1;
        cArr3[i11] = c10;
    }

    /* renamed from: Q0 */
    public long m62803Q0(char[] cArr) {
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i10 = length + 1;
        if (mo62820e(this.f49204e + length) != '\"') {
            this.f49213n = -1;
            return 0L;
        }
        long j10 = -3750763034362895579L;
        while (true) {
            int i11 = i10 + 1;
            char cMo62820e = mo62820e(this.f49204e + i10);
            if (cMo62820e == '\"') {
                int i12 = i10 + 2;
                char cMo62820e2 = mo62820e(this.f49204e + i11);
                if (cMo62820e2 == ',') {
                    int i13 = this.f49204e + i12;
                    this.f49204e = i13;
                    this.f49203d = mo62820e(i13);
                    this.f49213n = 3;
                    return j10;
                }
                if (cMo62820e2 != '}') {
                    this.f49213n = -1;
                    return 0L;
                }
                int i14 = i10 + 3;
                char cMo62820e3 = mo62820e(this.f49204e + i12);
                if (cMo62820e3 == ',') {
                    this.f49200a = 16;
                    int i15 = this.f49204e + i14;
                    this.f49204e = i15;
                    this.f49203d = mo62820e(i15);
                } else if (cMo62820e3 == ']') {
                    this.f49200a = 15;
                    int i16 = this.f49204e + i14;
                    this.f49204e = i16;
                    this.f49203d = mo62820e(i16);
                } else if (cMo62820e3 == '}') {
                    this.f49200a = 13;
                    int i17 = this.f49204e + i14;
                    this.f49204e = i17;
                    this.f49203d = mo62820e(i17);
                } else {
                    if (cMo62820e3 != 26) {
                        this.f49213n = -1;
                        return 0L;
                    }
                    this.f49200a = 20;
                    this.f49204e += i10 + 2;
                    this.f49203d = (char) 26;
                }
                this.f49213n = 4;
                return j10;
            }
            j10 = (j10 ^ ((cMo62820e < 'A' || cMo62820e > 'Z') ? cMo62820e : cMo62820e + ' ')) * 1099511628211L;
            if (cMo62820e == '\\') {
                this.f49213n = -1;
                return 0L;
            }
            i10 = i11;
        }
    }

    /* renamed from: R0 */
    public final void m62804R0() {
        if (this.f49203d != 'f') {
            throw new C9380d("error parse false");
        }
        next();
        if (this.f49203d != 'a') {
            throw new C9380d("error parse false");
        }
        next();
        if (this.f49203d != 'l') {
            throw new C9380d("error parse false");
        }
        next();
        if (this.f49203d != 's') {
            throw new C9380d("error parse false");
        }
        next();
        if (this.f49203d != 'e') {
            throw new C9380d("error parse false");
        }
        next();
        char c10 = this.f49203d;
        if (c10 != ' ' && c10 != ',' && c10 != '}' && c10 != ']' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != 26 && c10 != '\f' && c10 != '\b' && c10 != ':' && c10 != '/') {
            throw new C9380d("scan false error");
        }
        this.f49200a = 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        r2 = false;
     */
    /* renamed from: S0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigInteger m62805S0(char[] r20) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.m62805S0(char[]):java.math.BigInteger");
    }

    /* renamed from: T0 */
    public boolean mo62806T0(char[] cArr) {
        int i10;
        boolean z10;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return false;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char cMo62820e = mo62820e(this.f49204e + length);
        if (cMo62820e == 't') {
            int i12 = length + 2;
            if (mo62820e(this.f49204e + i11) != 'r') {
                this.f49213n = -1;
                return false;
            }
            int i13 = length + 3;
            if (mo62820e(this.f49204e + i12) != 'u') {
                this.f49213n = -1;
                return false;
            }
            i10 = length + 4;
            if (mo62820e(this.f49204e + i13) != 'e') {
                this.f49213n = -1;
                return false;
            }
            z10 = true;
        } else {
            if (cMo62820e != 'f') {
                this.f49213n = -1;
                return false;
            }
            int i14 = length + 2;
            if (mo62820e(this.f49204e + i11) != 'a') {
                this.f49213n = -1;
                return false;
            }
            int i15 = length + 3;
            if (mo62820e(this.f49204e + i14) != 'l') {
                this.f49213n = -1;
                return false;
            }
            int i16 = length + 4;
            if (mo62820e(this.f49204e + i15) != 's') {
                this.f49213n = -1;
                return false;
            }
            i10 = length + 5;
            if (mo62820e(this.f49204e + i16) != 'e') {
                this.f49213n = -1;
                return false;
            }
            z10 = false;
        }
        int i17 = i10 + 1;
        char cMo62820e2 = mo62820e(this.f49204e + i10);
        if (cMo62820e2 == ',') {
            int i18 = this.f49204e + i17;
            this.f49204e = i18;
            this.f49203d = mo62820e(i18);
            this.f49213n = 3;
            this.f49200a = 16;
            return z10;
        }
        if (cMo62820e2 != '}') {
            this.f49213n = -1;
            return false;
        }
        int i19 = i10 + 2;
        char cMo62820e3 = mo62820e(this.f49204e + i17);
        if (cMo62820e3 == ',') {
            this.f49200a = 16;
            int i20 = this.f49204e + i19;
            this.f49204e = i20;
            this.f49203d = mo62820e(i20);
        } else if (cMo62820e3 == ']') {
            this.f49200a = 15;
            int i21 = this.f49204e + i19;
            this.f49204e = i21;
            this.f49203d = mo62820e(i21);
        } else if (cMo62820e3 == '}') {
            this.f49200a = 13;
            int i22 = this.f49204e + i19;
            this.f49204e = i22;
            this.f49203d = mo62820e(i22);
        } else {
            if (cMo62820e3 != 26) {
                this.f49213n = -1;
                return false;
            }
            this.f49200a = 20;
            this.f49204e += i10 + 1;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return z10;
    }

    /* renamed from: U0 */
    public Date mo62807U0(char[] cArr) {
        char cMo62820e;
        int i10;
        long j10;
        Date date;
        int i11;
        char cMo62820e2;
        boolean z10 = false;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return null;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char cMo62820e3 = mo62820e(this.f49204e + length);
        if (cMo62820e3 == '\"') {
            int iMo62796H0 = mo62796H0('\"', this.f49204e + cArr.length + 1);
            if (iMo62796H0 == -1) {
                throw new C9380d("unclosed str");
            }
            int length2 = this.f49204e + cArr.length + 1;
            String strMo62832o1 = mo62832o1(length2, iMo62796H0 - length2);
            if (strMo62832o1.indexOf(92) != -1) {
                while (true) {
                    int i13 = 0;
                    for (int i14 = iMo62796H0 - 1; i14 >= 0 && mo62820e(i14) == '\\'; i14--) {
                        i13++;
                    }
                    if (i13 % 2 == 0) {
                        break;
                    }
                    iMo62796H0 = mo62796H0('\"', iMo62796H0 + 1);
                }
                int i15 = this.f49204e;
                int length3 = iMo62796H0 - ((cArr.length + i15) + 1);
                strMo62832o1 = m62793P0(mo62833p1(i15 + cArr.length + 1, length3), length3);
            }
            int i16 = this.f49204e;
            int length4 = i12 + (iMo62796H0 - ((cArr.length + i16) + 1)) + 1;
            i10 = length4 + 1;
            cMo62820e = mo62820e(i16 + length4);
            C10082f c10082f = new C10082f(strMo62832o1);
            try {
                if (!c10082f.m62838u1(false)) {
                    this.f49213n = -1;
                    return null;
                }
                date = c10082f.m62795G0().getTime();
            } finally {
                c10082f.close();
            }
        } else {
            if (cMo62820e3 != '-' && (cMo62820e3 < '0' || cMo62820e3 > '9')) {
                this.f49213n = -1;
                return null;
            }
            if (cMo62820e3 == '-') {
                cMo62820e3 = mo62820e(this.f49204e + i12);
                i12 = length + 2;
                z10 = true;
            }
            if (cMo62820e3 < '0' || cMo62820e3 > '9') {
                cMo62820e = cMo62820e3;
                i10 = i12;
                j10 = 0;
            } else {
                j10 = cMo62820e3 - '0';
                while (true) {
                    i11 = i12 + 1;
                    cMo62820e2 = mo62820e(this.f49204e + i12);
                    if (cMo62820e2 < '0' || cMo62820e2 > '9') {
                        break;
                    }
                    j10 = (j10 * 10) + (cMo62820e2 - '0');
                    i12 = i11;
                }
                cMo62820e = cMo62820e2;
                i10 = i11;
            }
            if (j10 < 0) {
                this.f49213n = -1;
                return null;
            }
            if (z10) {
                j10 = -j10;
            }
            date = new Date(j10);
        }
        if (cMo62820e == ',') {
            int i17 = this.f49204e + i10;
            this.f49204e = i17;
            this.f49203d = mo62820e(i17);
            this.f49213n = 3;
            return date;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return null;
        }
        int i18 = i10 + 1;
        char cMo62820e4 = mo62820e(this.f49204e + i10);
        if (cMo62820e4 == ',') {
            this.f49200a = 16;
            int i19 = this.f49204e + i18;
            this.f49204e = i19;
            this.f49203d = mo62820e(i19);
        } else if (cMo62820e4 == ']') {
            this.f49200a = 15;
            int i20 = this.f49204e + i18;
            this.f49204e = i20;
            this.f49203d = mo62820e(i20);
        } else if (cMo62820e4 == '}') {
            this.f49200a = 13;
            int i21 = this.f49204e + i18;
            this.f49204e = i21;
            this.f49203d = mo62820e(i21);
        } else {
            if (cMo62820e4 != 26) {
                this.f49213n = -1;
                return null;
            }
            this.f49200a = 20;
            this.f49204e += i10;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return date;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: V */
    public TimeZone mo62764V() {
        return this.f49211l;
    }

    /* renamed from: V0 */
    public BigDecimal m62808V0(char[] cArr) {
        int i10;
        char cMo62820e;
        int length;
        int i11;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i12 = length2 + 1;
        char cMo62820e2 = mo62820e(this.f49204e + length2);
        boolean z10 = cMo62820e2 == '\"';
        if (z10) {
            cMo62820e2 = mo62820e(this.f49204e + i12);
            i12 = length2 + 2;
        }
        if (cMo62820e2 == '-') {
            cMo62820e2 = mo62820e(this.f49204e + i12);
            i12++;
        }
        if (cMo62820e2 < '0' || cMo62820e2 > '9') {
            if (cMo62820e2 != 'n' || mo62820e(this.f49204e + i12) != 'u' || mo62820e(this.f49204e + i12 + 1) != 'l' || mo62820e(this.f49204e + i12 + 2) != 'l') {
                this.f49213n = -1;
                return null;
            }
            this.f49213n = 5;
            int i13 = i12 + 4;
            char cMo62820e3 = mo62820e(this.f49204e + i12 + 3);
            if (z10 && cMo62820e3 == '\"') {
                cMo62820e3 = mo62820e(this.f49204e + i13);
                i13 = i12 + 5;
            }
            while (cMo62820e3 != ',') {
                if (cMo62820e3 == '}') {
                    int i14 = this.f49204e + i13;
                    this.f49204e = i14;
                    this.f49203d = mo62820e(i14);
                    this.f49213n = 5;
                    this.f49200a = 13;
                    return null;
                }
                if (!m62792J0(cMo62820e3)) {
                    this.f49213n = -1;
                    return null;
                }
                cMo62820e3 = mo62820e(this.f49204e + i13);
                i13++;
            }
            int i15 = this.f49204e + i13;
            this.f49204e = i15;
            this.f49203d = mo62820e(i15);
            this.f49213n = 5;
            this.f49200a = 16;
            return null;
        }
        while (true) {
            i10 = i12 + 1;
            cMo62820e = mo62820e(this.f49204e + i12);
            if (cMo62820e < '0' || cMo62820e > '9') {
                break;
            }
            i12 = i10;
        }
        if (cMo62820e == '.') {
            int i16 = i12 + 2;
            char cMo62820e4 = mo62820e(this.f49204e + i10);
            if (cMo62820e4 < '0' || cMo62820e4 > '9') {
                this.f49213n = -1;
                return null;
            }
            while (true) {
                i10 = i16 + 1;
                cMo62820e = mo62820e(this.f49204e + i16);
                if (cMo62820e < '0' || cMo62820e > '9') {
                    break;
                }
                i16 = i10;
            }
        }
        if (cMo62820e == 'e' || cMo62820e == 'E') {
            int i17 = i10 + 1;
            cMo62820e = mo62820e(this.f49204e + i10);
            if (cMo62820e == '+' || cMo62820e == '-') {
                i10 += 2;
                cMo62820e = mo62820e(this.f49204e + i17);
            } else {
                i10 = i17;
            }
            while (cMo62820e >= '0' && cMo62820e <= '9') {
                char cMo62820e5 = mo62820e(this.f49204e + i10);
                i10++;
                cMo62820e = cMo62820e5;
            }
        }
        if (!z10) {
            int i18 = this.f49204e;
            length = cArr.length + i18;
            i11 = ((i18 + i10) - length) - 1;
        } else {
            if (cMo62820e != '\"') {
                this.f49213n = -1;
                return null;
            }
            int i19 = i10 + 1;
            char cMo62820e6 = mo62820e(this.f49204e + i10);
            int i20 = this.f49204e;
            length = cArr.length + i20 + 1;
            i11 = ((i20 + i19) - length) - 2;
            i10 = i19;
            cMo62820e = cMo62820e6;
        }
        if (i11 > 65535) {
            throw new C9380d("scan decimal overflow");
        }
        char[] cArrMo62833p1 = mo62833p1(length, i11);
        BigDecimal bigDecimal = new BigDecimal(cArrMo62833p1, 0, cArrMo62833p1.length, MathContext.UNLIMITED);
        if (cMo62820e == ',') {
            int i21 = this.f49204e + i10;
            this.f49204e = i21;
            this.f49203d = mo62820e(i21);
            this.f49213n = 3;
            this.f49200a = 16;
            return bigDecimal;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return null;
        }
        int i22 = i10 + 1;
        char cMo62820e7 = mo62820e(this.f49204e + i10);
        if (cMo62820e7 == ',') {
            this.f49200a = 16;
            int i23 = this.f49204e + i22;
            this.f49204e = i23;
            this.f49203d = mo62820e(i23);
        } else if (cMo62820e7 == ']') {
            this.f49200a = 15;
            int i24 = this.f49204e + i22;
            this.f49204e = i24;
            this.f49203d = mo62820e(i24);
        } else if (cMo62820e7 == '}') {
            this.f49200a = 13;
            int i25 = this.f49204e + i22;
            this.f49204e = i25;
            this.f49203d = mo62820e(i25);
        } else {
            if (cMo62820e7 != 26) {
                this.f49213n = -1;
                return null;
            }
            this.f49200a = 20;
            this.f49204e += i10;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return bigDecimal;
    }

    /* renamed from: W0 */
    public final double m62809W0(char[] cArr) throws NumberFormatException {
        int i10;
        char cMo62820e;
        long j10;
        int length;
        int i11;
        double d10;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i12 = length2 + 1;
        char cMo62820e2 = mo62820e(this.f49204e + length2);
        boolean z10 = cMo62820e2 == '\"';
        if (z10) {
            cMo62820e2 = mo62820e(this.f49204e + i12);
            i12 = length2 + 2;
        }
        boolean z11 = cMo62820e2 == '-';
        if (z11) {
            cMo62820e2 = mo62820e(this.f49204e + i12);
            i12++;
        }
        if (cMo62820e2 < '0' || cMo62820e2 > '9') {
            if (cMo62820e2 != 'n' || mo62820e(this.f49204e + i12) != 'u' || mo62820e(this.f49204e + i12 + 1) != 'l' || mo62820e(this.f49204e + i12 + 2) != 'l') {
                this.f49213n = -1;
                return 0.0d;
            }
            this.f49213n = 5;
            int i13 = i12 + 4;
            char cMo62820e3 = mo62820e(this.f49204e + i12 + 3);
            if (z10 && cMo62820e3 == '\"') {
                cMo62820e3 = mo62820e(this.f49204e + i13);
                i13 = i12 + 5;
            }
            while (cMo62820e3 != ',') {
                if (cMo62820e3 == '}') {
                    int i14 = this.f49204e + i13;
                    this.f49204e = i14;
                    this.f49203d = mo62820e(i14);
                    this.f49213n = 5;
                    this.f49200a = 13;
                    return 0.0d;
                }
                if (!m62792J0(cMo62820e3)) {
                    this.f49213n = -1;
                    return 0.0d;
                }
                cMo62820e3 = mo62820e(this.f49204e + i13);
                i13++;
            }
            int i15 = this.f49204e + i13;
            this.f49204e = i15;
            this.f49203d = mo62820e(i15);
            this.f49213n = 5;
            this.f49200a = 16;
            return 0.0d;
        }
        long j11 = cMo62820e2 - '0';
        while (true) {
            i10 = i12 + 1;
            cMo62820e = mo62820e(this.f49204e + i12);
            if (cMo62820e < '0' || cMo62820e > '9') {
                break;
            }
            j11 = (j11 * 10) + (cMo62820e - '0');
            i12 = i10;
        }
        if (cMo62820e == '.') {
            int i16 = i12 + 2;
            char cMo62820e4 = mo62820e(this.f49204e + i10);
            if (cMo62820e4 < '0' || cMo62820e4 > '9') {
                this.f49213n = -1;
                return 0.0d;
            }
            j11 = (j11 * 10) + (cMo62820e4 - '0');
            j10 = 10;
            while (true) {
                i10 = i16 + 1;
                cMo62820e = mo62820e(this.f49204e + i16);
                if (cMo62820e < '0' || cMo62820e > '9') {
                    break;
                }
                j11 = (j11 * 10) + (cMo62820e - '0');
                j10 *= 10;
                i16 = i10;
            }
        } else {
            j10 = 1;
        }
        boolean z12 = cMo62820e == 'e' || cMo62820e == 'E';
        if (z12) {
            int i17 = i10 + 1;
            cMo62820e = mo62820e(this.f49204e + i10);
            if (cMo62820e == '+' || cMo62820e == '-') {
                i10 += 2;
                cMo62820e = mo62820e(this.f49204e + i17);
            } else {
                i10 = i17;
            }
            while (cMo62820e >= '0' && cMo62820e <= '9') {
                cMo62820e = mo62820e(this.f49204e + i10);
                i10++;
            }
        }
        if (!z10) {
            int i18 = this.f49204e;
            length = cArr.length + i18;
            i11 = ((i18 + i10) - length) - 1;
        } else {
            if (cMo62820e != '\"') {
                this.f49213n = -1;
                return 0.0d;
            }
            int i19 = i10 + 1;
            cMo62820e = mo62820e(this.f49204e + i10);
            int i20 = this.f49204e;
            length = cArr.length + i20 + 1;
            i11 = ((i20 + i19) - length) - 2;
            i10 = i19;
        }
        if (z12 || i11 >= 17) {
            d10 = Double.parseDouble(mo62832o1(length, i11));
        } else {
            d10 = j11 / j10;
            if (z11) {
                d10 = -d10;
            }
        }
        if (cMo62820e == ',') {
            int i21 = this.f49204e + i10;
            this.f49204e = i21;
            this.f49203d = mo62820e(i21);
            this.f49213n = 3;
            this.f49200a = 16;
            return d10;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return 0.0d;
        }
        int i22 = i10 + 1;
        char cMo62820e5 = mo62820e(this.f49204e + i10);
        if (cMo62820e5 == ',') {
            this.f49200a = 16;
            int i23 = this.f49204e + i22;
            this.f49204e = i23;
            this.f49203d = mo62820e(i23);
        } else if (cMo62820e5 == ']') {
            this.f49200a = 15;
            int i24 = this.f49204e + i22;
            this.f49204e = i24;
            this.f49203d = mo62820e(i24);
        } else if (cMo62820e5 == '}') {
            this.f49200a = 13;
            int i25 = this.f49204e + i22;
            this.f49204e = i25;
            this.f49203d = mo62820e(i25);
        } else {
            if (cMo62820e5 != 26) {
                this.f49213n = -1;
                return 0.0d;
            }
            this.f49200a = 20;
            this.f49204e += i10;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return d10;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: X */
    public final Number mo62765X() throws NumberFormatException {
        char c10;
        long j10;
        long j11;
        boolean z10 = false;
        if (this.f49208i == -1) {
            this.f49208i = 0;
        }
        int i10 = this.f49208i;
        int i11 = this.f49207h + i10;
        char cMo62820e = mo62820e(i11 - 1);
        if (cMo62820e == 'B') {
            i11--;
            c10 = 'B';
        } else if (cMo62820e == 'L') {
            i11--;
            c10 = 'L';
        } else if (cMo62820e != 'S') {
            c10 = ' ';
        } else {
            i11--;
            c10 = 'S';
        }
        if (mo62820e(this.f49208i) == '-') {
            i10++;
            j10 = Long.MIN_VALUE;
            z10 = true;
        } else {
            j10 = -9223372036854775807L;
        }
        if (i10 < i11) {
            j11 = -(mo62820e(i10) - '0');
            i10++;
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            int i12 = i10 + 1;
            int iMo62820e = mo62820e(i10) - '0';
            if (j11 < -922337203685477580L) {
                return new BigInteger(mo62757D0(), 10);
            }
            long j12 = j11 * 10;
            long j13 = iMo62820e;
            if (j12 < j10 + j13) {
                return new BigInteger(mo62757D0(), 10);
            }
            j11 = j12 - j13;
            i10 = i12;
        }
        if (!z10) {
            long j14 = -j11;
            return (j14 > 2147483647L || c10 == 'L') ? Long.valueOf(j14) : c10 == 'S' ? Short.valueOf((short) j14) : c10 == 'B' ? Byte.valueOf((byte) j14) : Integer.valueOf((int) j14);
        }
        if (i10 > this.f49208i + 1) {
            return (j11 < -2147483648L || c10 == 'L') ? Long.valueOf(j11) : c10 == 'S' ? Short.valueOf((short) j11) : c10 == 'B' ? Byte.valueOf((byte) j11) : Integer.valueOf((int) j11);
        }
        throw new C9380d("illegal number format : " + mo62757D0());
    }

    /* renamed from: X0 */
    public final float m62810X0(char[] cArr) throws NumberFormatException {
        int i10;
        char cMo62820e;
        long j10;
        int length;
        int i11;
        float f10;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i12 = length2 + 1;
        char cMo62820e2 = mo62820e(this.f49204e + length2);
        boolean z10 = cMo62820e2 == '\"';
        if (z10) {
            cMo62820e2 = mo62820e(this.f49204e + i12);
            i12 = length2 + 2;
        }
        boolean z11 = cMo62820e2 == '-';
        if (z11) {
            cMo62820e2 = mo62820e(this.f49204e + i12);
            i12++;
        }
        if (cMo62820e2 < '0' || cMo62820e2 > '9') {
            if (cMo62820e2 != 'n' || mo62820e(this.f49204e + i12) != 'u' || mo62820e(this.f49204e + i12 + 1) != 'l' || mo62820e(this.f49204e + i12 + 2) != 'l') {
                this.f49213n = -1;
                return 0.0f;
            }
            this.f49213n = 5;
            int i13 = i12 + 4;
            char cMo62820e3 = mo62820e(this.f49204e + i12 + 3);
            if (z10 && cMo62820e3 == '\"') {
                cMo62820e3 = mo62820e(this.f49204e + i13);
                i13 = i12 + 5;
            }
            while (cMo62820e3 != ',') {
                if (cMo62820e3 == '}') {
                    int i14 = this.f49204e + i13;
                    this.f49204e = i14;
                    this.f49203d = mo62820e(i14);
                    this.f49213n = 5;
                    this.f49200a = 13;
                    return 0.0f;
                }
                if (!m62792J0(cMo62820e3)) {
                    this.f49213n = -1;
                    return 0.0f;
                }
                cMo62820e3 = mo62820e(this.f49204e + i13);
                i13++;
            }
            int i15 = this.f49204e + i13;
            this.f49204e = i15;
            this.f49203d = mo62820e(i15);
            this.f49213n = 5;
            this.f49200a = 16;
            return 0.0f;
        }
        long j11 = cMo62820e2 - '0';
        while (true) {
            i10 = i12 + 1;
            cMo62820e = mo62820e(this.f49204e + i12);
            if (cMo62820e < '0' || cMo62820e > '9') {
                break;
            }
            j11 = (j11 * 10) + (cMo62820e - '0');
            i12 = i10;
        }
        if (cMo62820e == '.') {
            int i16 = i12 + 2;
            char cMo62820e4 = mo62820e(this.f49204e + i10);
            if (cMo62820e4 < '0' || cMo62820e4 > '9') {
                this.f49213n = -1;
                return 0.0f;
            }
            j11 = (j11 * 10) + (cMo62820e4 - '0');
            j10 = 10;
            while (true) {
                i10 = i16 + 1;
                cMo62820e = mo62820e(this.f49204e + i16);
                if (cMo62820e < '0' || cMo62820e > '9') {
                    break;
                }
                j11 = (j11 * 10) + (cMo62820e - '0');
                j10 *= 10;
                i16 = i10;
            }
        } else {
            j10 = 1;
        }
        boolean z12 = cMo62820e == 'e' || cMo62820e == 'E';
        if (z12) {
            int i17 = i10 + 1;
            cMo62820e = mo62820e(this.f49204e + i10);
            if (cMo62820e == '+' || cMo62820e == '-') {
                i10 += 2;
                cMo62820e = mo62820e(this.f49204e + i17);
            } else {
                i10 = i17;
            }
            while (cMo62820e >= '0' && cMo62820e <= '9') {
                char cMo62820e5 = mo62820e(this.f49204e + i10);
                i10++;
                cMo62820e = cMo62820e5;
            }
        }
        if (!z10) {
            int i18 = this.f49204e;
            length = cArr.length + i18;
            i11 = ((i18 + i10) - length) - 1;
        } else {
            if (cMo62820e != '\"') {
                this.f49213n = -1;
                return 0.0f;
            }
            int i19 = i10 + 1;
            cMo62820e = mo62820e(this.f49204e + i10);
            int i20 = this.f49204e;
            length = cArr.length + i20 + 1;
            i11 = ((i20 + i19) - length) - 2;
            i10 = i19;
        }
        if (z12 || i11 >= 17) {
            f10 = Float.parseFloat(mo62832o1(length, i11));
        } else {
            f10 = (float) (j11 / j10);
            if (z11) {
                f10 = -f10;
            }
        }
        if (cMo62820e == ',') {
            int i21 = this.f49204e + i10;
            this.f49204e = i21;
            this.f49203d = mo62820e(i21);
            this.f49213n = 3;
            this.f49200a = 16;
            return f10;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return 0.0f;
        }
        int i22 = i10 + 1;
        char cMo62820e6 = mo62820e(this.f49204e + i10);
        if (cMo62820e6 == ',') {
            this.f49200a = 16;
            int i23 = this.f49204e + i22;
            this.f49204e = i23;
            this.f49203d = mo62820e(i23);
        } else if (cMo62820e6 == ']') {
            this.f49200a = 15;
            int i24 = this.f49204e + i22;
            this.f49204e = i24;
            this.f49203d = mo62820e(i24);
        } else if (cMo62820e6 == '}') {
            this.f49200a = 13;
            int i25 = this.f49204e + i22;
            this.f49204e = i25;
            this.f49203d = mo62820e(i25);
        } else {
            if (cMo62820e6 != 26) {
                this.f49213n = -1;
                return 0.0f;
            }
            this.f49204e += i10;
            this.f49200a = 20;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return f10;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: Y */
    public float mo62766Y() throws NumberFormatException {
        char cCharAt;
        String strMo62757D0 = mo62757D0();
        float f10 = Float.parseFloat(strMo62757D0);
        if ((f10 != 0.0f && f10 != Float.POSITIVE_INFINITY) || (cCharAt = strMo62757D0.charAt(0)) <= '0' || cCharAt > '9') {
            return f10;
        }
        throw new C9380d("float overflow : " + strMo62757D0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009d, code lost:
    
        r19.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b6, code lost:
    
        r1 = r4;
        r19.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b9, code lost:
    
        return r1;
     */
    /* renamed from: Y0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] m62811Y0(char[] r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.m62811Y0(char[]):float[]");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: Z */
    public final String mo62767Z(C10086j c10086j, char c10) throws NumberFormatException {
        String strM62879c;
        this.f49208i = this.f49204e;
        this.f49207h = 0;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            char next = next();
            if (next == c10) {
                this.f49200a = 4;
                if (z10) {
                    strM62879c = c10086j.m62879c(this.f49206g, 0, this.f49207h, i10);
                } else {
                    int i11 = this.f49208i;
                    strM62879c = mo62814b(i11 == -1 ? 0 : i11 + 1, this.f49207h, i10, c10086j);
                }
                this.f49207h = 0;
                next();
                return strM62879c;
            }
            if (next == 26) {
                throw new C9380d("unclosed.str");
            }
            if (next == '\\') {
                if (!z10) {
                    int i12 = this.f49207h;
                    char[] cArr = this.f49206g;
                    if (i12 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i12 <= length) {
                            i12 = length;
                        }
                        char[] cArr2 = new char[i12];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f49206g = cArr2;
                    }
                    mo62816c(this.f49208i + 1, this.f49206g, 0, this.f49207h);
                    z10 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i10 = (i10 * 31) + 34;
                    m62802O0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i10 = (i10 * 31) + 92;
                            m62802O0('\\');
                        } else if (next2 == 'b') {
                            i10 = (i10 * 31) + 8;
                            m62802O0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i10 = (i10 * 31) + 10;
                                m62802O0('\n');
                            } else if (next2 == 'r') {
                                i10 = (i10 * 31) + 13;
                                m62802O0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i10 = (i10 * 31) + 47;
                                        m62802O0(C5929g4.f26852n);
                                        break;
                                    case '0':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 0);
                                        break;
                                    case '1':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 1);
                                        break;
                                    case '2':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 2);
                                        break;
                                    case '3':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 3);
                                        break;
                                    case '4':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 4);
                                        break;
                                    case '5':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 5);
                                        break;
                                    case '6':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 6);
                                        break;
                                    case '7':
                                        i10 = (i10 * 31) + next2;
                                        m62802O0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i10 = (i10 * 31) + 9;
                                                m62802O0('\t');
                                                break;
                                            case 'u':
                                                int i13 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i10 = (i10 * 31) + i13;
                                                m62802O0((char) i13);
                                                break;
                                            case 'v':
                                                i10 = (i10 * 31) + 11;
                                                m62802O0((char) 11);
                                                break;
                                            default:
                                                this.f49203d = next2;
                                                throw new C9380d("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.f49203d = next3;
                                char next4 = next();
                                this.f49203d = next4;
                                int[] iArr = f49199s;
                                char c11 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i10 = (i10 * 31) + c11;
                                m62802O0(c11);
                            }
                        }
                    }
                    i10 = (i10 * 31) + 12;
                    m62802O0('\f');
                } else {
                    i10 = (i10 * 31) + 39;
                    m62802O0('\'');
                }
            } else {
                i10 = (i10 * 31) + next;
                if (z10) {
                    int i14 = this.f49207h;
                    char[] cArr3 = this.f49206g;
                    if (i14 == cArr3.length) {
                        m62802O0(next);
                    } else {
                        this.f49207h = i14 + 1;
                        cArr3[i14] = next;
                    }
                } else {
                    this.f49207h++;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
    
        r21.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b4, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0135, code lost:
    
        r4 = r18 + 1;
        r1 = mo62820e(r21.f49204e + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0140, code lost:
    
        if (r2 == r3.length) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0142, code lost:
    
        r5 = new float[r2];
        r7 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014a, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x014c, code lost:
    
        if (r8 < r6.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014e, code lost:
    
        r5 = new float[(r6.length * 3) / 2][];
        java.lang.System.arraycopy(r3, r7, r5, r7, r2);
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0159, code lost:
    
        r5 = r8 + 1;
        r6[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015f, code lost:
    
        if (r1 != ',') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0161, code lost:
    
        r3 = mo62820e(r21.f49204e + r4);
        r2 = r18 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0170, code lost:
    
        if (r1 != ']') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0172, code lost:
    
        r2 = r18 + 2;
        r3 = mo62820e(r21.f49204e + r4);
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x017d, code lost:
    
        r3 = r1;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0193, code lost:
    
        r21.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0196, code lost:
    
        return null;
     */
    /* renamed from: Z0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] m62812Z0(char[] r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.m62812Z0(char[]):float[][]");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: a0 */
    public final int mo62768a0() {
        return this.f49200a;
    }

    /* renamed from: a1 */
    public int mo62813a1(char[] cArr) {
        int i10;
        char cMo62820e;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return 0;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char cMo62820e2 = mo62820e(this.f49204e + length);
        boolean z10 = cMo62820e2 == '-';
        if (z10) {
            cMo62820e2 = mo62820e(this.f49204e + i11);
            i11 = length + 2;
        }
        if (cMo62820e2 < '0' || cMo62820e2 > '9') {
            this.f49213n = -1;
            return 0;
        }
        int i12 = cMo62820e2 - '0';
        while (true) {
            i10 = i11 + 1;
            cMo62820e = mo62820e(this.f49204e + i11);
            if (cMo62820e < '0' || cMo62820e > '9') {
                break;
            }
            i12 = (i12 * 10) + (cMo62820e - '0');
            i11 = i10;
        }
        if (cMo62820e == '.') {
            this.f49213n = -1;
            return 0;
        }
        if ((i12 < 0 || i10 > cArr.length + 14) && !(i12 == Integer.MIN_VALUE && i10 == 17 && z10)) {
            this.f49213n = -1;
            return 0;
        }
        if (cMo62820e == ',') {
            int i13 = this.f49204e + i10;
            this.f49204e = i13;
            this.f49203d = mo62820e(i13);
            this.f49213n = 3;
            this.f49200a = 16;
            return z10 ? -i12 : i12;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return 0;
        }
        int i14 = i11 + 2;
        char cMo62820e3 = mo62820e(this.f49204e + i10);
        if (cMo62820e3 == ',') {
            this.f49200a = 16;
            int i15 = this.f49204e + i14;
            this.f49204e = i15;
            this.f49203d = mo62820e(i15);
        } else if (cMo62820e3 == ']') {
            this.f49200a = 15;
            int i16 = this.f49204e + i14;
            this.f49204e = i16;
            this.f49203d = mo62820e(i16);
        } else if (cMo62820e3 == '}') {
            this.f49200a = 13;
            int i17 = this.f49204e + i14;
            this.f49204e = i17;
            this.f49203d = mo62820e(i17);
        } else {
            if (cMo62820e3 != 26) {
                this.f49213n = -1;
                return 0;
            }
            this.f49200a = 20;
            this.f49204e += i11 + 1;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return z10 ? -i12 : i12;
    }

    /* renamed from: b */
    public abstract String mo62814b(int i10, int i11, int i12, C10086j c10086j);

    @Override // p323h1.InterfaceC10079c
    /* renamed from: b0 */
    public String mo62769b0(char c10) {
        this.f49213n = 0;
        char cMo62820e = mo62820e(this.f49204e);
        if (cMo62820e == 'n') {
            if (mo62820e(this.f49204e + 1) != 'u' || mo62820e(this.f49204e + 2) != 'l' || mo62820e(this.f49204e + 3) != 'l') {
                this.f49213n = -1;
                return null;
            }
            if (mo62820e(this.f49204e + 4) != c10) {
                this.f49213n = -1;
                return null;
            }
            int i10 = this.f49204e + 5;
            this.f49204e = i10;
            this.f49203d = mo62820e(i10);
            this.f49213n = 3;
            return null;
        }
        int i11 = 1;
        while (cMo62820e != '\"') {
            if (!m62792J0(cMo62820e)) {
                this.f49213n = -1;
                return m62831n1();
            }
            cMo62820e = mo62820e(this.f49204e + i11);
            i11++;
        }
        int i12 = this.f49204e + i11;
        int iMo62796H0 = mo62796H0('\"', i12);
        if (iMo62796H0 == -1) {
            throw new C9380d("unclosed str");
        }
        String strMo62832o1 = mo62832o1(this.f49204e + i11, iMo62796H0 - i12);
        if (strMo62832o1.indexOf(92) != -1) {
            while (true) {
                int i13 = 0;
                for (int i14 = iMo62796H0 - 1; i14 >= 0 && mo62820e(i14) == '\\'; i14--) {
                    i13++;
                }
                if (i13 % 2 == 0) {
                    break;
                }
                iMo62796H0 = mo62796H0('\"', iMo62796H0 + 1);
            }
            int i15 = iMo62796H0 - i12;
            strMo62832o1 = m62793P0(mo62833p1(this.f49204e + 1, i15), i15);
        }
        int i16 = i11 + (iMo62796H0 - i12) + 1;
        int i17 = i16 + 1;
        char cMo62820e2 = mo62820e(this.f49204e + i16);
        while (cMo62820e2 != c10) {
            if (!m62792J0(cMo62820e2)) {
                if (cMo62820e2 == ']') {
                    int i18 = this.f49204e + i17;
                    this.f49204e = i18;
                    this.f49203d = mo62820e(i18);
                    this.f49213n = -1;
                }
                return strMo62832o1;
            }
            cMo62820e2 = mo62820e(this.f49204e + i17);
            i17++;
        }
        int i19 = this.f49204e + i17;
        this.f49204e = i19;
        this.f49203d = mo62820e(i19);
        this.f49213n = 3;
        this.f49200a = 16;
        return strMo62832o1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x011c, code lost:
    
        r2 = r4;
        r18.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011f, code lost:
    
        return r2;
     */
    /* renamed from: b1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] m62815b1(char[] r19) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.m62815b1(char[]):int[]");
    }

    /* renamed from: c */
    public abstract void mo62816c(int i10, char[] cArr, int i11, int i12);

    @Override // p323h1.InterfaceC10079c
    /* renamed from: c0 */
    public int mo62770c0() {
        return this.f49202c;
    }

    /* renamed from: c1 */
    public long mo62817c1(char[] cArr) {
        int i10;
        char cMo62820e;
        boolean z10 = false;
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char cMo62820e2 = mo62820e(this.f49204e + length);
        if (cMo62820e2 == '-') {
            cMo62820e2 = mo62820e(this.f49204e + i11);
            i11 = length + 2;
            z10 = true;
        }
        if (cMo62820e2 < '0' || cMo62820e2 > '9') {
            this.f49213n = -1;
            return 0L;
        }
        long j10 = cMo62820e2 - '0';
        while (true) {
            i10 = i11 + 1;
            cMo62820e = mo62820e(this.f49204e + i11);
            if (cMo62820e < '0' || cMo62820e > '9') {
                break;
            }
            j10 = (j10 * 10) + (cMo62820e - '0');
            i11 = i10;
        }
        if (cMo62820e == '.') {
            this.f49213n = -1;
            return 0L;
        }
        if (i10 - cArr.length >= 21 || (j10 < 0 && !(j10 == Long.MIN_VALUE && z10))) {
            this.f49213n = -1;
            return 0L;
        }
        if (cMo62820e == ',') {
            int i12 = this.f49204e + i10;
            this.f49204e = i12;
            this.f49203d = mo62820e(i12);
            this.f49213n = 3;
            this.f49200a = 16;
            return z10 ? -j10 : j10;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return 0L;
        }
        int i13 = i11 + 2;
        char cMo62820e3 = mo62820e(this.f49204e + i10);
        if (cMo62820e3 == ',') {
            this.f49200a = 16;
            int i14 = this.f49204e + i13;
            this.f49204e = i14;
            this.f49203d = mo62820e(i14);
        } else if (cMo62820e3 == ']') {
            this.f49200a = 15;
            int i15 = this.f49204e + i13;
            this.f49204e = i15;
            this.f49203d = mo62820e(i15);
        } else if (cMo62820e3 == '}') {
            this.f49200a = 13;
            int i16 = this.f49204e + i13;
            this.f49204e = i16;
            this.f49203d = mo62820e(i16);
        } else {
            if (cMo62820e3 != 26) {
                this.f49213n = -1;
                return 0L;
            }
            this.f49200a = 20;
            this.f49204e += i11 + 1;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return z10 ? -j10 : j10;
    }

    @Override // p323h1.InterfaceC10079c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.f49206g;
        if (cArr.length <= 8192) {
            f49197q.set(cArr);
        }
        this.f49206g = null;
    }

    /* renamed from: d */
    public abstract boolean mo62818d(char[] cArr);

    /* renamed from: d1 */
    public String mo62819d1(char[] cArr) {
        this.f49213n = 0;
        if (!mo62818d(cArr)) {
            this.f49213n = -2;
            return m62831n1();
        }
        int length = cArr.length;
        int i10 = length + 1;
        if (mo62820e(this.f49204e + length) != '\"') {
            this.f49213n = -1;
            return m62831n1();
        }
        int iMo62796H0 = mo62796H0('\"', this.f49204e + cArr.length + 1);
        if (iMo62796H0 == -1) {
            throw new C9380d("unclosed str");
        }
        int length2 = this.f49204e + cArr.length + 1;
        String strMo62832o1 = mo62832o1(length2, iMo62796H0 - length2);
        if (strMo62832o1.indexOf(92) != -1) {
            while (true) {
                int i11 = 0;
                for (int i12 = iMo62796H0 - 1; i12 >= 0 && mo62820e(i12) == '\\'; i12--) {
                    i11++;
                }
                if (i11 % 2 == 0) {
                    break;
                }
                iMo62796H0 = mo62796H0('\"', iMo62796H0 + 1);
            }
            int i13 = this.f49204e;
            int length3 = iMo62796H0 - ((cArr.length + i13) + 1);
            strMo62832o1 = m62793P0(mo62833p1(i13 + cArr.length + 1, length3), length3);
        }
        int i14 = this.f49204e;
        int length4 = i10 + (iMo62796H0 - ((cArr.length + i14) + 1)) + 1;
        int i15 = length4 + 1;
        char cMo62820e = mo62820e(i14 + length4);
        if (cMo62820e == ',') {
            int i16 = this.f49204e + i15;
            this.f49204e = i16;
            this.f49203d = mo62820e(i16);
            this.f49213n = 3;
            return strMo62832o1;
        }
        if (cMo62820e != '}') {
            this.f49213n = -1;
            return m62831n1();
        }
        int i17 = length4 + 2;
        char cMo62820e2 = mo62820e(this.f49204e + i15);
        if (cMo62820e2 == ',') {
            this.f49200a = 16;
            int i18 = this.f49204e + i17;
            this.f49204e = i18;
            this.f49203d = mo62820e(i18);
        } else if (cMo62820e2 == ']') {
            this.f49200a = 15;
            int i19 = this.f49204e + i17;
            this.f49204e = i19;
            this.f49203d = mo62820e(i19);
        } else if (cMo62820e2 == '}') {
            this.f49200a = 13;
            int i20 = this.f49204e + i17;
            this.f49204e = i20;
            this.f49203d = mo62820e(i20);
        } else {
            if (cMo62820e2 != 26) {
                this.f49213n = -1;
                return m62831n1();
            }
            this.f49200a = 20;
            this.f49204e += length4 + 1;
            this.f49203d = (char) 26;
        }
        this.f49213n = 4;
        return strMo62832o1;
    }

    /* renamed from: e */
    public abstract char mo62820e(int i10);

    /* renamed from: e1 */
    public final void m62821e1() {
        char next;
        if (this.f49203d != 'x') {
            throw new C9380d("illegal state. " + this.f49203d);
        }
        next();
        if (this.f49203d != '\'') {
            throw new C9380d("illegal state. " + this.f49203d);
        }
        this.f49208i = this.f49204e;
        next();
        if (this.f49203d == '\'') {
            next();
            this.f49200a = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.f49207h++;
            }
        }
        if (next == '\'') {
            this.f49207h++;
            next();
            this.f49200a = 26;
        } else {
            throw new C9380d("illegal state. " + next);
        }
    }

    /* renamed from: f */
    public abstract void mo62822f(int i10, int i11, char[] cArr);

    /* renamed from: f1 */
    public final void m62823f1() {
        this.f49208i = this.f49204e - 1;
        this.f49209j = false;
        do {
            this.f49207h++;
            next();
        } while (Character.isLetterOrDigit(this.f49203d));
        String strMo62763J = mo62763J();
        if ("null".equalsIgnoreCase(strMo62763J)) {
            this.f49200a = 8;
            return;
        }
        if ("new".equals(strMo62763J)) {
            this.f49200a = 9;
            return;
        }
        if (FaqConstants.DISABLE_HA_REPORT.equals(strMo62763J)) {
            this.f49200a = 6;
            return;
        }
        if ("false".equals(strMo62763J)) {
            this.f49200a = 7;
            return;
        }
        if ("undefined".equals(strMo62763J)) {
            this.f49200a = 23;
            return;
        }
        if ("Set".equals(strMo62763J)) {
            this.f49200a = 21;
        } else if ("TreeSet".equals(strMo62763J)) {
            this.f49200a = 22;
        } else {
            this.f49200a = 18;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c4 -> B:51:0x00b3). Please report as a decompilation issue!!! */
    @Override // p323h1.InterfaceC10079c
    /* renamed from: g0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double mo62771g0(char r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.mo62771g0(char):double");
    }

    /* renamed from: g1 */
    public final void m62824g1() {
        m62825h1(true);
    }

    /* renamed from: h1 */
    public final void m62825h1(boolean z10) {
        if (this.f49203d != 'n') {
            throw new C9380d("error parse null or new");
        }
        next();
        char c10 = this.f49203d;
        if (c10 != 'u') {
            if (c10 != 'e') {
                throw new C9380d("error parse new");
            }
            next();
            if (this.f49203d != 'w') {
                throw new C9380d("error parse new");
            }
            next();
            char c11 = this.f49203d;
            if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && c11 != '\f' && c11 != '\b') {
                throw new C9380d("scan new error");
            }
            this.f49200a = 9;
            return;
        }
        next();
        if (this.f49203d != 'l') {
            throw new C9380d("error parse null");
        }
        next();
        if (this.f49203d != 'l') {
            throw new C9380d("error parse null");
        }
        next();
        char c12 = this.f49203d;
        if (c12 != ' ' && c12 != ',' && c12 != '}' && c12 != ']' && c12 != '\n' && c12 != '\r' && c12 != '\t' && c12 != 26 && ((c12 != ':' || !z10) && c12 != '\f' && c12 != '\b')) {
            throw new C9380d("scan null error");
        }
        this.f49200a = 8;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: i0 */
    public final String mo62772i0(C10086j c10086j) {
        mo62775n0();
        char c10 = this.f49203d;
        if (c10 == '\"') {
            return mo62767Z(c10086j, '\"');
        }
        if (c10 == '\'') {
            if (mo62788x0(EnumC10078b.AllowSingleQuotes)) {
                return mo62767Z(c10086j, '\'');
            }
            throw new C9380d("syntax error");
        }
        if (c10 == '}') {
            next();
            this.f49200a = 13;
            return null;
        }
        if (c10 == ',') {
            next();
            this.f49200a = 16;
            return null;
        }
        if (c10 == 26) {
            this.f49200a = 20;
            return null;
        }
        if (mo62788x0(EnumC10078b.AllowUnQuotedFieldNames)) {
            return mo62780s0(c10086j);
        }
        throw new C9380d("syntax error");
    }

    /* renamed from: i1 */
    public final void m62826i1() {
        char next;
        char next2;
        this.f49208i = this.f49204e;
        this.f49209j = false;
        while (true) {
            char next3 = next();
            if (next3 == '\'') {
                this.f49200a = 4;
                next();
                return;
            }
            if (next3 == 26) {
                if (mo62797I0()) {
                    throw new C9380d("unclosed single-quote string");
                }
                m62802O0((char) 26);
            } else if (next3 == '\\') {
                if (!this.f49209j) {
                    this.f49209j = true;
                    int i10 = this.f49207h;
                    char[] cArr = this.f49206g;
                    if (i10 > cArr.length) {
                        char[] cArr2 = new char[i10 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f49206g = cArr2;
                    }
                    mo62822f(this.f49208i + 1, this.f49207h, this.f49206g);
                }
                char next4 = next();
                if (next4 == '\"') {
                    m62802O0('\"');
                } else if (next4 != '\'') {
                    if (next4 != 'F') {
                        if (next4 == '\\') {
                            m62802O0('\\');
                        } else if (next4 == 'b') {
                            m62802O0('\b');
                        } else if (next4 != 'f') {
                            if (next4 == 'n') {
                                m62802O0('\n');
                            } else if (next4 == 'r') {
                                m62802O0('\r');
                            } else if (next4 != 'x') {
                                switch (next4) {
                                    case '/':
                                        m62802O0(C5929g4.f26852n);
                                        break;
                                    case '0':
                                        m62802O0((char) 0);
                                        break;
                                    case '1':
                                        m62802O0((char) 1);
                                        break;
                                    case '2':
                                        m62802O0((char) 2);
                                        break;
                                    case '3':
                                        m62802O0((char) 3);
                                        break;
                                    case '4':
                                        m62802O0((char) 4);
                                        break;
                                    case '5':
                                        m62802O0((char) 5);
                                        break;
                                    case '6':
                                        m62802O0((char) 6);
                                        break;
                                    case '7':
                                        m62802O0((char) 7);
                                        break;
                                    default:
                                        switch (next4) {
                                            case 't':
                                                m62802O0('\t');
                                                break;
                                            case 'u':
                                                m62802O0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                m62802O0((char) 11);
                                                break;
                                            default:
                                                this.f49203d = next4;
                                                throw new C9380d("unclosed single-quote string");
                                        }
                                }
                            } else {
                                next = next();
                                next2 = next();
                                boolean z10 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                boolean z11 = (next2 >= '0' && next2 <= '9') || (next2 >= 'a' && next2 <= 'f') || (next2 >= 'A' && next2 <= 'F');
                                if (z10 && z11) {
                                    int[] iArr = f49199s;
                                    m62802O0((char) ((iArr[next] * 16) + iArr[next2]));
                                }
                            }
                        }
                    }
                    m62802O0('\f');
                } else {
                    m62802O0('\'');
                }
            } else if (this.f49209j) {
                int i11 = this.f49207h;
                char[] cArr3 = this.f49206g;
                if (i11 == cArr3.length) {
                    m62802O0(next3);
                } else {
                    this.f49207h = i11 + 1;
                    cArr3[i11] = next3;
                }
            } else {
                this.f49207h++;
            }
        }
        throw new C9380d("invalid escape character \\x" + next + next2);
    }

    @Override // p323h1.InterfaceC10079c
    public final boolean isEnabled(int i10) {
        return (this.f49202c & i10) != 0;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: j0 */
    public final char mo62773j0() {
        return this.f49203d;
    }

    /* renamed from: j1 */
    public String m62827j1(C10086j c10086j, char c10) {
        int i10 = 0;
        this.f49213n = 0;
        char cMo62820e = mo62820e(this.f49204e);
        if (cMo62820e == 'n') {
            if (mo62820e(this.f49204e + 1) != 'u' || mo62820e(this.f49204e + 2) != 'l' || mo62820e(this.f49204e + 3) != 'l') {
                this.f49213n = -1;
                return null;
            }
            if (mo62820e(this.f49204e + 4) != c10) {
                this.f49213n = -1;
                return null;
            }
            int i11 = this.f49204e + 5;
            this.f49204e = i11;
            this.f49203d = mo62820e(i11);
            this.f49213n = 3;
            return null;
        }
        if (cMo62820e != '\"') {
            this.f49213n = -1;
            return null;
        }
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cMo62820e2 = mo62820e(this.f49204e + i12);
            if (cMo62820e2 == '\"') {
                int i14 = this.f49204e;
                int i15 = i14 + 1;
                String strMo62814b = mo62814b(i15, ((i14 + i13) - i15) - 1, i10, c10086j);
                int i16 = i12 + 2;
                char cMo62820e3 = mo62820e(this.f49204e + i13);
                while (cMo62820e3 != c10) {
                    if (!m62792J0(cMo62820e3)) {
                        this.f49213n = -1;
                        return strMo62814b;
                    }
                    cMo62820e3 = mo62820e(this.f49204e + i16);
                    i16++;
                }
                int i17 = this.f49204e + i16;
                this.f49204e = i17;
                this.f49203d = mo62820e(i17);
                this.f49213n = 3;
                return strMo62814b;
            }
            i10 = (i10 * 31) + cMo62820e2;
            if (cMo62820e2 == '\\') {
                this.f49213n = -1;
                return null;
            }
            i12 = i13;
        }
    }

    /* renamed from: k1 */
    public final void m62828k1() {
        if (this.f49203d != 't') {
            throw new C9380d("error parse true");
        }
        next();
        if (this.f49203d != 'r') {
            throw new C9380d("error parse true");
        }
        next();
        if (this.f49203d != 'u') {
            throw new C9380d("error parse true");
        }
        next();
        if (this.f49203d != 'e') {
            throw new C9380d("error parse true");
        }
        next();
        char c10 = this.f49203d;
        if (c10 != ' ' && c10 != ',' && c10 != '}' && c10 != ']' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != 26 && c10 != '\f' && c10 != '\b' && c10 != ':' && c10 != '/') {
            throw new C9380d("scan true error");
        }
        this.f49200a = 6;
    }

    /* renamed from: l1 */
    public void m62829l1(TimeZone timeZone) {
        this.f49211l = timeZone;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0099 -> B:40:0x0089). Please report as a decompilation issue!!! */
    @Override // p323h1.InterfaceC10079c
    /* renamed from: m0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal mo62774m0(char r18) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.mo62774m0(char):java.math.BigDecimal");
    }

    /* renamed from: m1 */
    public void m62830m1() {
        char c10;
        next();
        char c11 = this.f49203d;
        if (c11 == '/') {
            do {
                next();
                c10 = this.f49203d;
                if (c10 == '\n') {
                    next();
                    return;
                }
            } while (c10 != 26);
            return;
        }
        if (c11 != '*') {
            throw new C9380d("invalid comment");
        }
        next();
        while (true) {
            char c12 = this.f49203d;
            if (c12 == 26) {
                return;
            }
            if (c12 == '*') {
                next();
                if (this.f49203d == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: n0 */
    public final void mo62775n0() {
        while (true) {
            char c10 = this.f49203d;
            if (c10 > '/') {
                return;
            }
            if (c10 == ' ' || c10 == '\r' || c10 == '\n' || c10 == '\t' || c10 == '\f' || c10 == '\b') {
                next();
            } else if (c10 != '/') {
                return;
            } else {
                m62830m1();
            }
        }
    }

    /* renamed from: n1 */
    public final String m62831n1() {
        return this.f49214o;
    }

    @Override // p323h1.InterfaceC10079c
    public abstract char next();

    @Override // p323h1.InterfaceC10079c
    /* renamed from: o0 */
    public final void mo62776o0() {
        this.f49207h = 0;
    }

    /* renamed from: o1 */
    public abstract String mo62832o1(int i10, int i11);

    /* renamed from: p1 */
    public abstract char[] mo62833p1(int i10, int i11);

    @Override // p323h1.InterfaceC10079c
    /* renamed from: q0 */
    public long mo62777q0(char c10) {
        int i10;
        int i11;
        char cMo62820e;
        char c11;
        this.f49213n = 0;
        char cMo62820e2 = mo62820e(this.f49204e);
        boolean z10 = cMo62820e2 == '\"';
        if (z10) {
            cMo62820e2 = mo62820e(this.f49204e + 1);
            i10 = 2;
        } else {
            i10 = 1;
        }
        boolean z11 = cMo62820e2 == '-';
        if (z11) {
            cMo62820e2 = mo62820e(this.f49204e + i10);
            i10++;
        }
        if (cMo62820e2 >= '0') {
            char c12 = '9';
            if (cMo62820e2 <= '9') {
                long j10 = cMo62820e2 - '0';
                while (true) {
                    i11 = i10 + 1;
                    cMo62820e = mo62820e(this.f49204e + i10);
                    if (cMo62820e < '0' || cMo62820e > c12) {
                        break;
                    }
                    j10 = (j10 * 10) + (cMo62820e - '0');
                    i10 = i11;
                    c12 = '9';
                }
                if (cMo62820e == '.') {
                    this.f49213n = -1;
                    return 0L;
                }
                if (j10 < 0 && (j10 != Long.MIN_VALUE || !z11)) {
                    throw new NumberFormatException(mo62832o1(this.f49204e, i10));
                }
                if (!z10) {
                    c11 = c10;
                } else {
                    if (cMo62820e != '\"') {
                        this.f49213n = -1;
                        return 0L;
                    }
                    cMo62820e = mo62820e(this.f49204e + i11);
                    c11 = c10;
                    i11 = i10 + 2;
                }
                while (cMo62820e != c11) {
                    if (!m62792J0(cMo62820e)) {
                        this.f49213n = -1;
                        return j10;
                    }
                    cMo62820e = mo62820e(this.f49204e + i11);
                    i11++;
                }
                int i12 = this.f49204e + i11;
                this.f49204e = i12;
                this.f49203d = mo62820e(i12);
                this.f49213n = 3;
                this.f49200a = 16;
                return z11 ? -j10 : j10;
            }
        }
        if (cMo62820e2 != 'n' || mo62820e(this.f49204e + i10) != 'u' || mo62820e(this.f49204e + i10 + 1) != 'l' || mo62820e(this.f49204e + i10 + 2) != 'l') {
            this.f49213n = -1;
            return 0L;
        }
        this.f49213n = 5;
        int i13 = i10 + 4;
        char cMo62820e3 = mo62820e(this.f49204e + i10 + 3);
        if (z10 && cMo62820e3 == '\"') {
            cMo62820e3 = mo62820e(this.f49204e + i13);
            i13 = i10 + 5;
        }
        while (cMo62820e3 != ',') {
            if (cMo62820e3 == ']') {
                int i14 = this.f49204e + i13;
                this.f49204e = i14;
                this.f49203d = mo62820e(i14);
                this.f49213n = 5;
                this.f49200a = 15;
                return 0L;
            }
            if (!m62792J0(cMo62820e3)) {
                this.f49213n = -1;
                return 0L;
            }
            cMo62820e3 = mo62820e(this.f49204e + i13);
            i13++;
        }
        int i15 = this.f49204e + i13;
        this.f49204e = i15;
        this.f49203d = mo62820e(i15);
        this.f49213n = 5;
        this.f49200a = 16;
        return 0L;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: r0 */
    public final void mo62778r0() {
        m62801N0(':');
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: s */
    public final int mo62779s() {
        return this.f49201b;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: s0 */
    public final String mo62780s0(C10086j c10086j) {
        if (this.f49200a == 1 && this.f49201b == 0 && this.f49204e == 1) {
            this.f49204e = 0;
        }
        boolean[] zArr = C11595g.f53794d;
        int i10 = this.f49203d;
        if (i10 < zArr.length && !zArr[i10]) {
            throw new C9380d("illegal identifier : " + this.f49203d + mo62781t());
        }
        boolean[] zArr2 = C11595g.f53795e;
        this.f49208i = this.f49204e;
        this.f49207h = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i10 = (i10 * 31) + next;
            this.f49207h++;
        }
        this.f49203d = mo62820e(this.f49204e);
        this.f49200a = 18;
        if (this.f49207h == 4 && i10 == 3392903 && mo62820e(this.f49208i) == 'n' && mo62820e(this.f49208i + 1) == 'u' && mo62820e(this.f49208i + 2) == 'l' && mo62820e(this.f49208i + 3) == 'l') {
            return null;
        }
        return c10086j == null ? mo62832o1(this.f49208i, this.f49207h) : mo62814b(this.f49208i, this.f49207h, i10, c10086j);
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: t */
    public String mo62781t() {
        return "";
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: t0 */
    public final String mo62782t0() {
        return C10083g.m62844a(this.f49200a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // p323h1.InterfaceC10079c
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo62783u() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.f49208i
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L8
            r13.f49208i = r2
        L8:
            int r0 = r13.f49208i
            int r1 = r13.f49207h
            int r1 = r1 + r0
            char r3 = r13.mo62820e(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = r5
            goto L22
        L1d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L22:
            if (r0 >= r1) goto L30
            int r6 = r0 + 1
            char r0 = r13.mo62820e(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L2e:
            r0 = r6
            goto L32
        L30:
            r7 = 0
        L32:
            if (r0 >= r1) goto L73
            int r6 = r0 + 1
            char r0 = r13.mo62820e(r0)
            r9 = 76
            if (r0 == r9) goto L72
            r9 = 83
            if (r0 == r9) goto L72
            r9 = 66
            if (r0 != r9) goto L47
            goto L72
        L47:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L68
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r7 = r7 - r9
            goto L2e
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.mo62757D0()
            r0.<init>(r13)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.mo62757D0()
            r0.<init>(r13)
            throw r0
        L72:
            r0 = r6
        L73:
            if (r2 == 0) goto L85
            int r1 = r13.f49208i
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r7
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.mo62757D0()
            r0.<init>(r13)
            throw r0
        L85:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.mo62783u():long");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: u0 */
    public final Number mo62784u0(boolean z10) {
        char cMo62820e = mo62820e((this.f49208i + this.f49207h) - 1);
        try {
            return cMo62820e == 'F' ? Float.valueOf(Float.parseFloat(mo62757D0())) : cMo62820e == 'D' ? Double.valueOf(Double.parseDouble(mo62757D0())) : z10 ? mo62759F() : Double.valueOf(m62794F0());
        } catch (NumberFormatException e10) {
            throw new C9380d(e10.getMessage() + ", " + mo62781t());
        }
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: v */
    public String mo62785v(C10086j c10086j) {
        return null;
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: w */
    public boolean mo62786w() {
        int i10 = 0;
        while (true) {
            char cMo62820e = mo62820e(i10);
            if (cMo62820e == 26) {
                this.f49200a = 20;
                return true;
            }
            if (!m62792J0(cMo62820e)) {
                return false;
            }
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    @Override // p323h1.InterfaceC10079c
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo62787x(char r10) {
        /*
            r9 = this;
            r0 = 0
            r9.f49213n = r0
            int r1 = r9.f49204e
            char r1 = r9.mo62820e(r1)
            r2 = 116(0x74, float:1.63E-43)
            r3 = 5
            r4 = 101(0x65, float:1.42E-43)
            r5 = -1
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 != r2) goto L40
            int r1 = r9.f49204e
            int r1 = r1 + r8
            char r1 = r9.mo62820e(r1)
            r2 = 114(0x72, float:1.6E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.f49204e
            int r1 = r1 + r7
            char r1 = r9.mo62820e(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.f49204e
            int r1 = r1 + r6
            char r1 = r9.mo62820e(r1)
            if (r1 != r4) goto L3d
            int r0 = r9.f49204e
            int r0 = r0 + 4
            char r1 = r9.mo62820e(r0)
        L3b:
            r0 = r8
            goto L96
        L3d:
            r9.f49213n = r5
            return r0
        L40:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 != r2) goto L7b
            int r1 = r9.f49204e
            int r1 = r1 + r8
            char r1 = r9.mo62820e(r1)
            r2 = 97
            if (r1 != r2) goto L78
            int r1 = r9.f49204e
            int r1 = r1 + r7
            char r1 = r9.mo62820e(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L78
            int r1 = r9.f49204e
            int r1 = r1 + r6
            char r1 = r9.mo62820e(r1)
            r2 = 115(0x73, float:1.61E-43)
            if (r1 != r2) goto L78
            int r1 = r9.f49204e
            int r1 = r1 + 4
            char r1 = r9.mo62820e(r1)
            if (r1 != r4) goto L78
            int r1 = r9.f49204e
            int r1 = r1 + r3
            char r1 = r9.mo62820e(r1)
            r3 = 6
            goto L96
        L78:
            r9.f49213n = r5
            return r0
        L7b:
            r2 = 49
            if (r1 != r2) goto L88
            int r0 = r9.f49204e
            int r0 = r0 + r8
            char r1 = r9.mo62820e(r0)
            r3 = r7
            goto L3b
        L88:
            r2 = 48
            if (r1 != r2) goto L95
            int r1 = r9.f49204e
            int r1 = r1 + r8
            char r1 = r9.mo62820e(r1)
            r3 = r7
            goto L96
        L95:
            r3 = r8
        L96:
            if (r1 != r10) goto La6
            int r10 = r9.f49204e
            int r10 = r10 + r3
            r9.f49204e = r10
            char r10 = r9.mo62820e(r10)
            r9.f49203d = r10
            r9.f49213n = r6
            return r0
        La6:
            boolean r1 = m62792J0(r1)
            if (r1 == 0) goto Lb7
            int r1 = r9.f49204e
            int r2 = r3 + 1
            int r1 = r1 + r3
            char r1 = r9.mo62820e(r1)
            r3 = r2
            goto L96
        Lb7:
            r9.f49213n = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.mo62787x(char):boolean");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: x0 */
    public final boolean mo62788x0(EnumC10078b enumC10078b) {
        return isEnabled(enumC10078b.f49196a);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c5 -> B:51:0x00b4). Please report as a decompilation issue!!! */
    @Override // p323h1.InterfaceC10079c
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float mo62789y(char r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.AbstractC10080d.mo62789y(char):float");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: z */
    public final void mo62790z() {
        this.f49207h = 0;
        while (true) {
            this.f49201b = this.f49204e;
            char c10 = this.f49203d;
            if (c10 == '/') {
                m62830m1();
            } else {
                if (c10 == '\"') {
                    mo62752A();
                    return;
                }
                if (c10 == ',') {
                    next();
                    this.f49200a = 16;
                    return;
                }
                if (c10 >= '0' && c10 <= '9') {
                    mo62755C();
                    return;
                }
                if (c10 != '-') {
                    switch (c10) {
                        case '\b':
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                            next();
                            break;
                        case '\'':
                            if (!mo62788x0(EnumC10078b.AllowSingleQuotes)) {
                                throw new C9380d("Feature.AllowSingleQuotes is false");
                            }
                            m62826i1();
                            return;
                        case '(':
                            next();
                            this.f49200a = 10;
                            return;
                        case ')':
                            next();
                            this.f49200a = 11;
                            return;
                        case '+':
                            next();
                            mo62755C();
                            return;
                        case '.':
                            next();
                            this.f49200a = 25;
                            return;
                        case ':':
                            next();
                            this.f49200a = 17;
                            return;
                        case ';':
                            next();
                            this.f49200a = 24;
                            return;
                        case 'N':
                        case 'S':
                        case 'T':
                        case 'u':
                            m62823f1();
                            return;
                        case '[':
                            next();
                            this.f49200a = 14;
                            return;
                        case ']':
                            next();
                            this.f49200a = 15;
                            return;
                        case 'f':
                            m62804R0();
                            return;
                        case 'n':
                            m62824g1();
                            return;
                        case 't':
                            m62828k1();
                            return;
                        case 'x':
                            m62821e1();
                            return;
                        case '{':
                            next();
                            this.f49200a = 12;
                            return;
                        case '}':
                            next();
                            this.f49200a = 13;
                            return;
                        default:
                            if (mo62797I0()) {
                                if (this.f49200a == 20) {
                                    throw new C9380d("EOF error");
                                }
                                this.f49200a = 20;
                                int i10 = this.f49204e;
                                this.f49201b = i10;
                                this.f49205f = i10;
                                return;
                            }
                            char c11 = this.f49203d;
                            if (c11 > 31 && c11 != 127) {
                                m62798K0("illegal.char", String.valueOf((int) c11));
                                next();
                                return;
                            } else {
                                next();
                                break;
                            }
                            break;
                    }
                } else {
                    mo62755C();
                    return;
                }
            }
        }
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: z0 */
    public Locale mo62791z0() {
        return this.f49212m;
    }
}
