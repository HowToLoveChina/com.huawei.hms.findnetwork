package p381j1;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p481n1.C11595g;
import p481n1.C11600l;
import p481n1.C11601m;

/* renamed from: j1.d1 */
/* loaded from: classes.dex */
public final class C10650d1 extends Writer {

    /* renamed from: s */
    public static final ThreadLocal<char[]> f51189s = new ThreadLocal<>();

    /* renamed from: t */
    public static final ThreadLocal<byte[]> f51190t = new ThreadLocal<>();

    /* renamed from: u */
    public static final char[] f51191u = ":true".toCharArray();

    /* renamed from: v */
    public static final char[] f51192v = ":false".toCharArray();

    /* renamed from: w */
    public static int f51193w;

    /* renamed from: x */
    public static final int f51194x;

    /* renamed from: a */
    public char[] f51195a;

    /* renamed from: b */
    public int f51196b;

    /* renamed from: c */
    public int f51197c;

    /* renamed from: d */
    public final Writer f51198d;

    /* renamed from: e */
    public boolean f51199e;

    /* renamed from: f */
    public boolean f51200f;

    /* renamed from: g */
    public boolean f51201g;

    /* renamed from: h */
    public boolean f51202h;

    /* renamed from: i */
    public boolean f51203i;

    /* renamed from: j */
    public boolean f51204j;

    /* renamed from: k */
    public boolean f51205k;

    /* renamed from: l */
    public boolean f51206l;

    /* renamed from: m */
    public boolean f51207m;

    /* renamed from: n */
    public boolean f51208n;

    /* renamed from: o */
    public char f51209o;

    /* renamed from: p */
    public int f51210p;

    /* renamed from: q */
    public boolean f51211q;

    /* renamed from: r */
    public long f51212r;

    static {
        int i10;
        f51193w = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        try {
            String strM69213h = C11595g.m69213h("fastjson.serializer_buffer_threshold");
            if (strM69213h != null && strM69213h.length() > 0 && (i10 = Integer.parseInt(strM69213h)) >= 64 && i10 <= 65536) {
                f51193w = i10 * 1024;
            }
        } catch (Throwable unused) {
        }
        f51194x = EnumC10653e1.UseSingleQuotes.f51248a | EnumC10653e1.BrowserCompatible.f51248a | EnumC10653e1.PrettyFormat.f51248a | EnumC10653e1.WriteEnumUsingToString.f51248a | EnumC10653e1.WriteNonStringValueAsString.f51248a | EnumC10653e1.WriteSlashAsSpecial.f51248a | EnumC10653e1.IgnoreErrorGetter.f51248a | EnumC10653e1.WriteClassName.f51248a | EnumC10653e1.NotWriteDefaultValue.f51248a;
    }

    public C10650d1() {
        this(null);
    }

    /* renamed from: A */
    public void m65208A(Enum<?> r22) {
        if (r22 == null) {
            m65222a0();
            return;
        }
        String string = (!this.f51206l || this.f51207m) ? this.f51207m ? r22.toString() : null : r22.name();
        if (string == null) {
            m65219X(r22.ordinal());
            return;
        }
        int i10 = m65237w(EnumC10653e1.UseSingleQuotes) ? 39 : 34;
        write(i10);
        write(string);
        write(i10);
    }

    /* renamed from: B */
    public void m65209B(String str) {
        m65210C(str, false);
    }

    /* renamed from: C */
    public void m65210C(String str, boolean z10) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.f51199e) {
            if (!this.f51200f) {
                m65220Y(str);
                return;
            } else {
                m65231m0(str);
                write(58);
                return;
            }
        }
        if (this.f51200f) {
            m65230j0(str, ':');
            return;
        }
        int i10 = 0;
        boolean z11 = str.length() == 0;
        while (true) {
            if (i10 < str.length()) {
                char cCharAt = str.charAt(i10);
                if ((cCharAt < '@' && (this.f51212r & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                    break;
                } else {
                    i10++;
                }
            } else if (!z11) {
                write(str);
                write(58);
                return;
            }
        }
        m65230j0(str, ':');
    }

    /* renamed from: D */
    public void m65211D(char c10, String str, double d10) throws IOException {
        write(c10);
        m65209B(str);
        m65240z(d10, false);
    }

    /* renamed from: E */
    public void m65212E(char c10, String str, int i10) {
        if (i10 == Integer.MIN_VALUE || !this.f51200f) {
            write(c10);
            m65209B(str);
            m65219X(i10);
            return;
        }
        int iM69216k = i10 < 0 ? C11595g.m69216k(-i10) + 1 : C11595g.m69216k(i10);
        int length = str.length();
        int i11 = this.f51196b + length + 4 + iM69216k;
        if (i11 > this.f51195a.length) {
            if (this.f51198d != null) {
                write(c10);
                m65209B(str);
                m65219X(i10);
                return;
            }
            m65235u(i11);
        }
        int i12 = this.f51196b;
        this.f51196b = i11;
        char[] cArr = this.f51195a;
        cArr[i12] = c10;
        int i13 = i12 + length;
        cArr[i12 + 1] = this.f51209o;
        str.getChars(0, length, cArr, i12 + 2);
        char[] cArr2 = this.f51195a;
        cArr2[i13 + 2] = this.f51209o;
        cArr2[i13 + 3] = ':';
        C11595g.m69211f(i10, this.f51196b, cArr2);
    }

    /* renamed from: F */
    public void m65213F(char c10, String str, long j10) {
        if (j10 == Long.MIN_VALUE || !this.f51200f || m65236v(EnumC10653e1.BrowserCompatible.f51248a)) {
            write(c10);
            m65209B(str);
            m65221Z(j10);
            return;
        }
        int iM69217l = j10 < 0 ? C11595g.m69217l(-j10) + 1 : C11595g.m69217l(j10);
        int length = str.length();
        int i10 = this.f51196b + length + 4 + iM69217l;
        if (i10 > this.f51195a.length) {
            if (this.f51198d != null) {
                write(c10);
                m65209B(str);
                m65221Z(j10);
                return;
            }
            m65235u(i10);
        }
        int i11 = this.f51196b;
        this.f51196b = i10;
        char[] cArr = this.f51195a;
        cArr[i11] = c10;
        int i12 = i11 + length;
        cArr[i11 + 1] = this.f51209o;
        str.getChars(0, length, cArr, i11 + 2);
        char[] cArr2 = this.f51195a;
        cArr2[i12 + 2] = this.f51209o;
        cArr2[i12 + 3] = ':';
        C11595g.m69212g(j10, this.f51196b, cArr2);
    }

    /* renamed from: G */
    public void m65214G(char c10, String str, String str2) {
        if (!this.f51200f) {
            write(c10);
            m65209B(str);
            if (str2 == null) {
                m65222a0();
                return;
            } else {
                m65228g0(str2);
                return;
            }
        }
        if (this.f51199e) {
            write(c10);
            m65209B(str);
            if (str2 == null) {
                m65222a0();
                return;
            } else {
                m65228g0(str2);
                return;
            }
        }
        if (!m65237w(EnumC10653e1.BrowserCompatible)) {
            m65216I(c10, str, str2);
            return;
        }
        write(c10);
        m65230j0(str, ':');
        m65230j0(str2, (char) 0);
    }

    /* renamed from: H */
    public void m65215H(char c10, String str, BigDecimal bigDecimal) {
        write(c10);
        m65209B(str);
        if (bigDecimal == null) {
            m65222a0();
        } else {
            int iScale = bigDecimal.scale();
            write((!m65237w(EnumC10653e1.WriteBigDecimalAsPlain) || iScale < -100 || iScale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009d A[PHI: r1 r4 r6 r9 r10
  0x009d: PHI (r1v50 int) = (r1v41 int), (r1v3 int) binds: [B:53:0x00d6, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
  0x009d: PHI (r4v21 int) = (r4v20 int), (r4v23 int) binds: [B:53:0x00d6, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
  0x009d: PHI (r6v7 char) = (r6v6 char), (r6v9 char) binds: [B:53:0x00d6, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
  0x009d: PHI (r9v11 int) = (r9v10 int), (r9v13 int) binds: [B:53:0x00d6, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
  0x009d: PHI (r10v13 int) = (r10v3 int), (r10v15 int) binds: [B:53:0x00d6, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m65216I(char r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10650d1.m65216I(char, java.lang.String, java.lang.String):void");
    }

    /* renamed from: J */
    public void m65217J(float f10, boolean z10) throws IOException {
        if (f10 != f10 || f10 == Float.POSITIVE_INFINITY || f10 == Float.NEGATIVE_INFINITY) {
            m65222a0();
            return;
        }
        int i10 = this.f51196b + 15;
        if (i10 > this.f51195a.length) {
            if (this.f51198d != null) {
                String strM69238b = C11601m.m69238b(f10);
                write(strM69238b, 0, strM69238b.length());
                if (z10 && m65237w(EnumC10653e1.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            m65235u(i10);
        }
        this.f51196b += C11601m.m69237a(f10, this.f51195a, this.f51196b);
        if (z10 && m65237w(EnumC10653e1.WriteClassName)) {
            write(70);
        }
    }

    /* renamed from: V */
    public void m65218V(byte[] bArr) {
        int length = this.f51196b + (bArr.length * 2) + 3;
        if (length > this.f51195a.length) {
            m65235u(length);
        }
        char[] cArr = this.f51195a;
        int i10 = this.f51196b;
        cArr[i10] = 'x';
        this.f51196b = i10 + 2;
        cArr[i10 + 1] = '\'';
        for (byte b10 : bArr) {
            int i11 = (b10 & 255) >> 4;
            int i12 = b10 & BaseType.Obj;
            char[] cArr2 = this.f51195a;
            int i13 = this.f51196b;
            int i14 = i13 + 1;
            this.f51196b = i14;
            int i15 = 55;
            cArr2[i13] = (char) (i11 + (i11 < 10 ? 48 : 55));
            this.f51196b = i13 + 2;
            if (i12 < 10) {
                i15 = 48;
            }
            cArr2[i14] = (char) (i12 + i15);
        }
        char[] cArr3 = this.f51195a;
        int i16 = this.f51196b;
        this.f51196b = i16 + 1;
        cArr3[i16] = '\'';
    }

    /* renamed from: X */
    public void m65219X(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iM69216k = i10 < 0 ? C11595g.m69216k(-i10) + 1 : C11595g.m69216k(i10);
        int i11 = this.f51196b + iM69216k;
        if (i11 > this.f51195a.length) {
            if (this.f51198d != null) {
                char[] cArr = new char[iM69216k];
                C11595g.m69211f(i10, iM69216k, cArr);
                write(cArr, 0, iM69216k);
                return;
            }
            m65235u(i11);
        }
        C11595g.m69211f(i10, i11, this.f51195a);
        this.f51196b = i11;
    }

    /* renamed from: Y */
    public final void m65220Y(String str) {
        byte[] bArr = C11595g.f53797g;
        int length = str.length();
        boolean z10 = true;
        int i10 = this.f51196b + length + 1;
        int i11 = 0;
        if (i10 > this.f51195a.length) {
            if (this.f51198d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i12 = 0;
                while (true) {
                    if (i12 < length) {
                        char cCharAt = str.charAt(i12);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i12++;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    write(39);
                }
                while (i11 < length) {
                    char cCharAt2 = str.charAt(i11);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(C11595g.f53800j[cCharAt2]);
                    }
                    i11++;
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
            m65235u(i10);
        }
        if (length == 0) {
            int i13 = this.f51196b;
            if (i13 + 3 > this.f51195a.length) {
                m65235u(i13 + 3);
            }
            char[] cArr = this.f51195a;
            int i14 = this.f51196b;
            cArr[i14] = '\'';
            cArr[i14 + 1] = '\'';
            this.f51196b = i14 + 3;
            cArr[i14 + 2] = ':';
            return;
        }
        int i15 = this.f51196b;
        int i16 = i15 + length;
        str.getChars(0, length, this.f51195a, i15);
        this.f51196b = i10;
        int i17 = i15;
        boolean z11 = false;
        while (i17 < i16) {
            char[] cArr2 = this.f51195a;
            char c10 = cArr2[i17];
            if (c10 < bArr.length && bArr[c10] != 0) {
                if (z11) {
                    i10++;
                    if (i10 > cArr2.length) {
                        m65235u(i10);
                    }
                    this.f51196b = i10;
                    char[] cArr3 = this.f51195a;
                    int i18 = i17 + 1;
                    System.arraycopy(cArr3, i18, cArr3, i17 + 2, i16 - i17);
                    char[] cArr4 = this.f51195a;
                    cArr4[i17] = '\\';
                    cArr4[i18] = C11595g.f53800j[c10];
                    i16++;
                    i17 = i18;
                } else {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        m65235u(i10);
                    }
                    this.f51196b = i10;
                    char[] cArr5 = this.f51195a;
                    int i19 = i17 + 1;
                    System.arraycopy(cArr5, i19, cArr5, i17 + 3, (i16 - i17) - 1);
                    char[] cArr6 = this.f51195a;
                    System.arraycopy(cArr6, i11, cArr6, 1, i17);
                    char[] cArr7 = this.f51195a;
                    cArr7[i15] = '\'';
                    cArr7[i19] = '\\';
                    i17 += 2;
                    cArr7[i17] = C11595g.f53800j[c10];
                    i16 += 2;
                    cArr7[this.f51196b - 2] = '\'';
                    z11 = true;
                }
            }
            i17++;
            i11 = 0;
        }
        this.f51195a[i10 - 1] = ':';
    }

    /* renamed from: Z */
    public void m65221Z(long j10) {
        boolean z10 = m65237w(EnumC10653e1.BrowserCompatible) && !m65237w(EnumC10653e1.WriteClassName) && (j10 > 9007199254740991L || j10 < -9007199254740991L);
        if (j10 == Long.MIN_VALUE) {
            if (z10) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iM69217l = j10 < 0 ? C11595g.m69217l(-j10) + 1 : C11595g.m69217l(j10);
        int i10 = this.f51196b + iM69217l;
        if (z10) {
            i10 += 2;
        }
        if (i10 > this.f51195a.length) {
            if (this.f51198d != null) {
                char[] cArr = new char[iM69217l];
                C11595g.m69212g(j10, iM69217l, cArr);
                if (!z10) {
                    write(cArr, 0, iM69217l);
                    return;
                }
                write(34);
                write(cArr, 0, iM69217l);
                write(34);
                return;
            }
            m65235u(i10);
        }
        if (z10) {
            char[] cArr2 = this.f51195a;
            cArr2[this.f51196b] = '\"';
            int i11 = i10 - 1;
            C11595g.m69212g(j10, i11, cArr2);
            this.f51195a[i11] = '\"';
        } else {
            C11595g.m69212g(j10, i10, this.f51195a);
        }
        this.f51196b = i10;
    }

    /* renamed from: a0 */
    public void m65222a0() {
        write("null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C10650d1 append(char c10) {
        write(c10);
        return this;
    }

    /* renamed from: b0 */
    public void m65224b0(int i10, int i11) {
        if ((i10 & i11) == 0 && (this.f51197c & i11) == 0) {
            m65222a0();
            return;
        }
        int i12 = EnumC10653e1.WriteMapNullValue.f51248a;
        if ((i10 & i12) != 0 && (i10 & (~i12) & EnumC10653e1.f51221G) == 0) {
            m65222a0();
            return;
        }
        if (i11 == EnumC10653e1.WriteNullListAsEmpty.f51248a) {
            write(C6010m7.f27500n);
            return;
        }
        if (i11 == EnumC10653e1.WriteNullStringAsEmpty.f51248a) {
            m65228g0("");
            return;
        }
        if (i11 == EnumC10653e1.WriteNullBooleanAsFalse.f51248a) {
            write("false");
        } else if (i11 == EnumC10653e1.WriteNullNumberAsZero.f51248a) {
            write(48);
        } else {
            m65222a0();
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C10650d1 append(CharSequence charSequence) throws IOException {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    /* renamed from: c0 */
    public void m65226c0(EnumC10653e1 enumC10653e1) {
        m65224b0(0, enumC10653e1.f51248a);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f51198d != null && this.f51196b > 0) {
            flush();
        }
        char[] cArr = this.f51195a;
        if (cArr.length <= f51193w) {
            f51189s.set(cArr);
        }
        this.f51195a = null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C10650d1 append(CharSequence charSequence, int i10, int i11) throws IOException {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i10, i11).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        Writer writer = this.f51198d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f51195a, 0, this.f51196b);
            this.f51198d.flush();
            this.f51196b = 0;
        } catch (IOException e10) {
            throw new C9380d(e10.getMessage(), e10);
        }
    }

    /* renamed from: g0 */
    public void m65228g0(String str) {
        if (this.f51199e) {
            m65231m0(str);
        } else {
            m65230j0(str, (char) 0);
        }
    }

    /* renamed from: i0 */
    public void m65229i0(char[] cArr) {
        if (this.f51199e) {
            m65232n0(cArr);
        } else {
            m65230j0(new String(cArr), (char) 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x02b3 A[PHI: r5 r9 r11 r15
  0x02b3: PHI (r5v27 int) = (r5v25 int), (r5v29 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r9v22 int) = (r9v15 int), (r9v3 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r11v14 int) = (r11v12 int), (r11v16 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r15v13 int) = (r15v2 int), (r15v15 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /* renamed from: j0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m65230j0(java.lang.String r23, char r24) {
        /*
            Method dump skipped, instructions count: 1345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10650d1.m65230j0(java.lang.String, char):void");
    }

    /* renamed from: m0 */
    public void m65231m0(String str) {
        int i10 = 0;
        if (str == null) {
            int i11 = this.f51196b + 4;
            if (i11 > this.f51195a.length) {
                m65235u(i11);
            }
            "null".getChars(0, 4, this.f51195a, this.f51196b);
            this.f51196b = i11;
            return;
        }
        int length = str.length();
        int i12 = this.f51196b + length + 2;
        if (i12 > this.f51195a.length) {
            if (this.f51198d != null) {
                write(39);
                while (i10 < str.length()) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && m65237w(EnumC10653e1.WriteSlashAsSpecial))) {
                        write(92);
                        write(C11595g.f53800j[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            m65235u(i12);
        }
        int i13 = this.f51196b;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.f51195a;
        cArr[i13] = '\'';
        str.getChars(0, length, cArr, i14);
        this.f51196b = i12;
        int i16 = -1;
        char c10 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c11 = this.f51195a[i17];
            if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && m65237w(EnumC10653e1.WriteSlashAsSpecial))) {
                i10++;
                i16 = i17;
                c10 = c11;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.f51195a.length) {
            m65235u(i18);
        }
        this.f51196b = i18;
        if (i10 == 1) {
            char[] cArr2 = this.f51195a;
            int i19 = i16 + 1;
            System.arraycopy(cArr2, i19, cArr2, i16 + 2, (i15 - i16) - 1);
            char[] cArr3 = this.f51195a;
            cArr3[i16] = '\\';
            cArr3[i19] = C11595g.f53800j[c10];
        } else if (i10 > 1) {
            char[] cArr4 = this.f51195a;
            int i20 = i16 + 1;
            System.arraycopy(cArr4, i20, cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.f51195a;
            cArr5[i16] = '\\';
            cArr5[i20] = C11595g.f53800j[c10];
            int i21 = i15 + 1;
            for (int i22 = i16 - 1; i22 >= i14; i22--) {
                char c12 = this.f51195a[i22];
                if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && m65237w(EnumC10653e1.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f51195a;
                    int i23 = i22 + 1;
                    System.arraycopy(cArr6, i23, cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.f51195a;
                    cArr7[i22] = '\\';
                    cArr7[i23] = C11595g.f53800j[c12];
                    i21++;
                }
            }
        }
        this.f51195a[this.f51196b - 1] = '\'';
    }

    /* renamed from: n0 */
    public void m65232n0(char[] cArr) {
        int i10 = 0;
        if (cArr == null) {
            int i11 = this.f51196b + 4;
            if (i11 > this.f51195a.length) {
                m65235u(i11);
            }
            "null".getChars(0, 4, this.f51195a, this.f51196b);
            this.f51196b = i11;
            return;
        }
        int length = cArr.length;
        int i12 = this.f51196b + length + 2;
        if (i12 > this.f51195a.length) {
            if (this.f51198d != null) {
                write(39);
                while (i10 < cArr.length) {
                    char c10 = cArr[i10];
                    if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && m65237w(EnumC10653e1.WriteSlashAsSpecial))) {
                        write(92);
                        write(C11595g.f53800j[c10]);
                    } else {
                        write(c10);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            m65235u(i12);
        }
        int i13 = this.f51196b;
        int i14 = i13 + 1;
        int i15 = length + i14;
        char[] cArr2 = this.f51195a;
        cArr2[i13] = '\'';
        System.arraycopy(cArr, 0, cArr2, i14, cArr.length);
        this.f51196b = i12;
        int i16 = -1;
        char c11 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c12 = this.f51195a[i17];
            if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && m65237w(EnumC10653e1.WriteSlashAsSpecial))) {
                i10++;
                i16 = i17;
                c11 = c12;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.f51195a.length) {
            m65235u(i18);
        }
        this.f51196b = i18;
        if (i10 == 1) {
            char[] cArr3 = this.f51195a;
            int i19 = i16 + 1;
            System.arraycopy(cArr3, i19, cArr3, i16 + 2, (i15 - i16) - 1);
            char[] cArr4 = this.f51195a;
            cArr4[i16] = '\\';
            cArr4[i19] = C11595g.f53800j[c11];
        } else if (i10 > 1) {
            char[] cArr5 = this.f51195a;
            int i20 = i16 + 1;
            System.arraycopy(cArr5, i20, cArr5, i16 + 2, (i15 - i16) - 1);
            char[] cArr6 = this.f51195a;
            cArr6[i16] = '\\';
            cArr6[i20] = C11595g.f53800j[c11];
            int i21 = i15 + 1;
            for (int i22 = i16 - 1; i22 >= i14; i22--) {
                char c13 = this.f51195a[i22];
                if (c13 <= '\r' || c13 == '\\' || c13 == '\'' || (c13 == '/' && m65237w(EnumC10653e1.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.f51195a;
                    int i23 = i22 + 1;
                    System.arraycopy(cArr7, i23, cArr7, i22 + 2, (i21 - i22) - 1);
                    char[] cArr8 = this.f51195a;
                    cArr8[i22] = '\\';
                    cArr8[i23] = C11595g.f53800j[c13];
                    i21++;
                }
            }
        }
        this.f51195a[this.f51196b - 1] = '\'';
    }

    /* renamed from: s */
    public void m65233s() {
        int i10 = this.f51197c;
        boolean z10 = (EnumC10653e1.QuoteFieldNames.f51248a & i10) != 0;
        this.f51200f = z10;
        boolean z11 = (EnumC10653e1.UseSingleQuotes.f51248a & i10) != 0;
        this.f51199e = z11;
        this.f51201g = (EnumC10653e1.SortField.f51248a & i10) != 0;
        this.f51202h = (EnumC10653e1.DisableCircularReferenceDetect.f51248a & i10) != 0;
        boolean z12 = (EnumC10653e1.BeanToArray.f51248a & i10) != 0;
        this.f51203i = z12;
        this.f51204j = (EnumC10653e1.WriteNonStringValueAsString.f51248a & i10) != 0;
        this.f51205k = (EnumC10653e1.NotWriteDefaultValue.f51248a & i10) != 0;
        boolean z13 = (EnumC10653e1.WriteEnumUsingName.f51248a & i10) != 0;
        this.f51206l = z13;
        this.f51207m = (EnumC10653e1.WriteEnumUsingToString.f51248a & i10) != 0;
        this.f51208n = z10 && (f51194x & i10) == 0 && (z12 || z13);
        this.f51209o = z11 ? '\'' : '\"';
        boolean z14 = (EnumC10653e1.BrowserSecure.f51248a & i10) != 0;
        this.f51211q = z14;
        this.f51212r = z14 ? 5764610843043954687L : (i10 & EnumC10653e1.WriteSlashAsSpecial.f51248a) != 0 ? 140758963191807L : 21474836479L;
    }

    /* renamed from: t */
    public void m65234t(EnumC10653e1 enumC10653e1, boolean z10) {
        if (z10) {
            int iM65244b = this.f51197c | enumC10653e1.m65244b();
            this.f51197c = iM65244b;
            EnumC10653e1 enumC10653e12 = EnumC10653e1.WriteEnumUsingToString;
            if (enumC10653e1 == enumC10653e12) {
                this.f51197c = (~EnumC10653e1.WriteEnumUsingName.m65244b()) & iM65244b;
            } else if (enumC10653e1 == EnumC10653e1.WriteEnumUsingName) {
                this.f51197c = (~enumC10653e12.m65244b()) & iM65244b;
            }
        } else {
            this.f51197c = (~enumC10653e1.m65244b()) & this.f51197c;
        }
        m65233s();
    }

    public String toString() {
        return new String(this.f51195a, 0, this.f51196b);
    }

    /* renamed from: u */
    public void m65235u(int i10) {
        ThreadLocal<char[]> threadLocal;
        char[] cArr;
        int i11 = this.f51210p;
        if (i11 != -1 && i10 >= i11) {
            throw new C9380d("serialize exceeded MAX_OUTPUT_LENGTH=" + this.f51210p + ", minimumCapacity=" + i10);
        }
        char[] cArr2 = this.f51195a;
        int length = cArr2.length + (cArr2.length >> 1) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr3 = new char[i10];
        System.arraycopy(cArr2, 0, cArr3, 0, this.f51196b);
        if (this.f51195a.length < f51193w && ((cArr = (threadLocal = f51189s).get()) == null || cArr.length < this.f51195a.length)) {
            threadLocal.set(this.f51195a);
        }
        this.f51195a = cArr3;
    }

    /* renamed from: v */
    public boolean m65236v(int i10) {
        return (this.f51197c & i10) != 0;
    }

    /* renamed from: w */
    public boolean m65237w(EnumC10653e1 enumC10653e1) {
        return (this.f51197c & enumC10653e1.f51248a) != 0;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            m65222a0();
        } else {
            write(str, 0, str.length());
        }
    }

    /* renamed from: x */
    public void m65238x(boolean z10) {
        if (z10) {
            write(FaqConstants.DISABLE_HA_REPORT);
        } else {
            write("false");
        }
    }

    /* renamed from: y */
    public void m65239y(byte[] bArr) {
        if (m65236v(EnumC10653e1.WriteClassName.f51248a)) {
            m65218V(bArr);
            return;
        }
        int length = bArr.length;
        boolean z10 = this.f51199e;
        char c10 = z10 ? '\'' : '\"';
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = C11595g.f53806p;
        int i10 = (length / 3) * 3;
        int i11 = length - 1;
        int i12 = this.f51196b;
        int i13 = (((i11 / 3) + 1) << 2) + i12;
        int i14 = i13 + 2;
        if (i14 > this.f51195a.length) {
            if (this.f51198d != null) {
                write(c10);
                int i15 = 0;
                while (i15 < i10) {
                    int i16 = i15 + 2;
                    int i17 = ((bArr[i15 + 1] & 255) << 8) | ((bArr[i15] & 255) << 16);
                    i15 += 3;
                    int i18 = i17 | (bArr[i16] & 255);
                    write(cArr[(i18 >>> 18) & 63]);
                    write(cArr[(i18 >>> 12) & 63]);
                    write(cArr[(i18 >>> 6) & 63]);
                    write(cArr[i18 & 63]);
                }
                int i19 = length - i10;
                if (i19 > 0) {
                    int i20 = ((bArr[i10] & 255) << 10) | (i19 == 2 ? (bArr[i11] & 255) << 2 : 0);
                    write(cArr[i20 >> 12]);
                    write(cArr[(i20 >>> 6) & 63]);
                    write(i19 == 2 ? cArr[i20 & 63] : '=');
                    write(61);
                }
                write(c10);
                return;
            }
            m65235u(i14);
        }
        this.f51196b = i14;
        int i21 = i12 + 1;
        this.f51195a[i12] = c10;
        int i22 = 0;
        while (i22 < i10) {
            int i23 = i22 + 2;
            int i24 = ((bArr[i22 + 1] & 255) << 8) | ((bArr[i22] & 255) << 16);
            i22 += 3;
            int i25 = i24 | (bArr[i23] & 255);
            char[] cArr2 = this.f51195a;
            cArr2[i21] = cArr[(i25 >>> 18) & 63];
            cArr2[i21 + 1] = cArr[(i25 >>> 12) & 63];
            int i26 = i21 + 3;
            cArr2[i21 + 2] = cArr[(i25 >>> 6) & 63];
            i21 += 4;
            cArr2[i26] = cArr[i25 & 63];
        }
        int i27 = length - i10;
        if (i27 > 0) {
            int i28 = ((bArr[i10] & 255) << 10) | (i27 == 2 ? (bArr[i11] & 255) << 2 : 0);
            char[] cArr3 = this.f51195a;
            cArr3[i13 - 3] = cArr[i28 >> 12];
            cArr3[i13 - 2] = cArr[(i28 >>> 6) & 63];
            cArr3[i13 - 1] = i27 == 2 ? cArr[i28 & 63] : '=';
            cArr3[i13] = '=';
        }
        this.f51195a[i13 + 1] = c10;
    }

    /* renamed from: z */
    public void m65240z(double d10, boolean z10) throws IOException {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            m65222a0();
            return;
        }
        int i10 = this.f51196b + 24;
        if (i10 > this.f51195a.length) {
            if (this.f51198d != null) {
                String strM69236b = C11600l.m69236b(d10);
                write(strM69236b, 0, strM69236b.length());
                if (z10 && m65237w(EnumC10653e1.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            m65235u(i10);
        }
        this.f51196b += C11600l.m69235a(d10, this.f51195a, this.f51196b);
        if (z10 && m65237w(EnumC10653e1.WriteClassName)) {
            write(68);
        }
    }

    public C10650d1(Writer writer) {
        this(writer, AbstractC9377a.f46784g, EnumC10653e1.f51220F);
    }

    public C10650d1(Writer writer, int i10, EnumC10653e1... enumC10653e1Arr) {
        this.f51210p = -1;
        this.f51198d = writer;
        ThreadLocal<char[]> threadLocal = f51189s;
        char[] cArr = threadLocal.get();
        this.f51195a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.f51195a = new char[2048];
        }
        for (EnumC10653e1 enumC10653e1 : enumC10653e1Arr) {
            i10 |= enumC10653e1.m65244b();
        }
        this.f51197c = i10;
        m65233s();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) throws IOException {
        int i12;
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) > cArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.f51196b + i11;
        if (i13 > this.f51195a.length) {
            if (this.f51198d == null) {
                m65235u(i13);
            } else {
                do {
                    char[] cArr2 = this.f51195a;
                    int length = cArr2.length;
                    int i14 = this.f51196b;
                    int i15 = length - i14;
                    System.arraycopy(cArr, i10, cArr2, i14, i15);
                    this.f51196b = this.f51195a.length;
                    flush();
                    i11 -= i15;
                    i10 += i15;
                } while (i11 > this.f51195a.length);
                i13 = i11;
            }
        }
        System.arraycopy(cArr, i10, this.f51195a, this.f51196b, i11);
        this.f51196b = i13;
    }

    @Override // java.io.Writer
    public void write(int i10) {
        int i11 = 1;
        int i12 = this.f51196b + 1;
        if (i12 <= this.f51195a.length) {
            i11 = i12;
        } else if (this.f51198d == null) {
            m65235u(i12);
            i11 = i12;
        } else {
            flush();
        }
        this.f51195a[this.f51196b] = (char) i10;
        this.f51196b = i11;
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f51196b + i11;
        if (i13 > this.f51195a.length) {
            if (this.f51198d == null) {
                m65235u(i13);
            } else {
                while (true) {
                    char[] cArr = this.f51195a;
                    int length = cArr.length;
                    int i14 = this.f51196b;
                    int i15 = length - i14;
                    i12 = i10 + i15;
                    str.getChars(i10, i12, cArr, i14);
                    this.f51196b = this.f51195a.length;
                    flush();
                    i11 -= i15;
                    if (i11 <= this.f51195a.length) {
                        break;
                    } else {
                        i10 = i12;
                    }
                }
                i13 = i11;
                i10 = i12;
            }
        }
        str.getChars(i10, i11 + i10, this.f51195a, this.f51196b);
        this.f51196b = i13;
    }
}
