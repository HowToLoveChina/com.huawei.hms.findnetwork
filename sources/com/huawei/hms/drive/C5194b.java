package com.huawei.hms.drive;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* renamed from: com.huawei.hms.drive.b */
/* loaded from: classes8.dex */
public class C5194b implements Closeable {

    /* renamed from: b */
    private final Reader f23818b;

    /* renamed from: i */
    private long f23825i;

    /* renamed from: j */
    private int f23826j;

    /* renamed from: k */
    private String f23827k;

    /* renamed from: l */
    private int[] f23828l;

    /* renamed from: n */
    private String[] f23830n;

    /* renamed from: o */
    private int[] f23831o;

    /* renamed from: c */
    private boolean f23819c = false;

    /* renamed from: d */
    private final char[] f23820d = new char[1024];

    /* renamed from: e */
    private int f23821e = 0;

    /* renamed from: f */
    private int f23822f = 0;

    /* renamed from: g */
    private int f23823g = 0;

    /* renamed from: h */
    private int f23824h = 0;

    /* renamed from: a */
    int f23817a = 0;

    /* renamed from: m */
    private int f23829m = 1;

    static {
        AbstractC5166a.f23567a = new AbstractC5166a() { // from class: com.huawei.hms.drive.b.1
        };
    }

    public C5194b(Reader reader) {
        int[] iArr = new int[32];
        this.f23828l = iArr;
        iArr[0] = 6;
        this.f23830n = new String[32];
        this.f23831o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f23818b = reader;
    }

    /* renamed from: n */
    private int m31008n() throws IOException {
        String str;
        String str2;
        int i10;
        char c10 = this.f23820d[this.f23821e];
        if (c10 == 't' || c10 == 'T') {
            str = FaqConstants.DISABLE_HA_REPORT;
            str2 = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str = "false";
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i10 = 7;
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f23821e + i11 >= this.f23822f && !m31005b(i11 + 1)) {
                return 0;
            }
            char c11 = this.f23820d[this.f23821e + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f23821e + length < this.f23822f || m31005b(length + 1)) && m31000a(this.f23820d[this.f23821e + length])) {
            return 0;
        }
        this.f23821e += length;
        this.f23817a = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (m31000a(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.f23825i = r11;
        r18.f23821e += r8;
        r18.f23817a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
    
        r18.f23826j = r8;
        r18.f23817a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m31009o() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5194b.m31009o():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        m31012r();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m31010p() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f23821e
            int r4 = r3 + r2
            int r5 = r6.f23822f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f23820d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.m31012r()
            goto L5c
        L4e:
            char[] r3 = r6.f23820d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.m31005b(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f23820d
            int r4 = r6.f23821e
            r0.append(r3, r4, r2)
            int r3 = r6.f23821e
            int r3 = r3 + r2
            r6.f23821e = r3
            r2 = 1
            boolean r2 = r6.m31005b(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f23820d
            int r3 = r6.f23821e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f23820d
            int r3 = r6.f23821e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f23821e
            int r2 = r2 + r1
            r6.f23821e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5194b.m31010p():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        m31012r();
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m31011q() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f23821e
            int r2 = r1 + r0
            int r3 = r4.f23822f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f23820d
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.m31012r()
        L4b:
            int r1 = r4.f23821e
            int r1 = r1 + r0
            r4.f23821e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f23821e = r1
            r0 = 1
            boolean r0 = r4.m31005b(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5194b.m31011q():void");
    }

    /* renamed from: r */
    private void m31012r() throws IOException {
        if (!this.f23819c) {
            throw m31003b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: s */
    private void m31013s() throws IOException {
        char c10;
        do {
            if (this.f23821e >= this.f23822f && !m31005b(1)) {
                return;
            }
            char[] cArr = this.f23820d;
            int i10 = this.f23821e;
            int i11 = i10 + 1;
            this.f23821e = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.f23823g++;
                this.f23824h = i11;
                return;
            }
        } while (c10 != '\r');
    }

    /* renamed from: t */
    private char m31014t() throws IOException {
        int i10;
        if (this.f23821e == this.f23822f && !m31005b(1)) {
            throw m31003b("Unterminated escape sequence");
        }
        char[] cArr = this.f23820d;
        int i11 = this.f23821e;
        int i12 = i11 + 1;
        this.f23821e = i12;
        char c10 = cArr[i11];
        if (c10 == '\n') {
            this.f23823g++;
            this.f23824h = i12;
        } else if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
            if (c10 == 'b') {
                return '\b';
            }
            if (c10 == 'f') {
                return '\f';
            }
            if (c10 == 'n') {
                return '\n';
            }
            if (c10 == 'r') {
                return '\r';
            }
            if (c10 == 't') {
                return '\t';
            }
            if (c10 != 'u') {
                throw m31003b("Invalid escape sequence");
            }
            if (i11 + 5 > this.f23822f && !m31005b(4)) {
                throw m31003b("Unterminated escape sequence");
            }
            int i13 = this.f23821e;
            int i14 = i13 + 4;
            char c11 = 0;
            while (i13 < i14) {
                char c12 = this.f23820d[i13];
                char c13 = (char) (c11 << 4);
                if (c12 >= '0' && c12 <= '9') {
                    i10 = c12 - '0';
                } else if (c12 >= 'a' && c12 <= 'f') {
                    i10 = c12 - 'W';
                } else {
                    if (c12 < 'A' || c12 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.f23820d, this.f23821e, 4));
                    }
                    i10 = c12 - '7';
                }
                c11 = (char) (c13 + i10);
                i13++;
            }
            this.f23821e += 4;
            return c11;
        }
        return c10;
    }

    /* renamed from: u */
    private void m31015u() throws IOException {
        m31002b(true);
        int i10 = this.f23821e;
        this.f23821e = i10 - 1;
        if (i10 + 4 <= this.f23822f || m31005b(5)) {
            int i11 = this.f23821e;
            char[] cArr = this.f23820d;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == '\n') {
                this.f23821e = i11 + 5;
            }
        }
    }

    /* renamed from: a */
    public final void m31017a(boolean z10) {
        this.f23819c = z10;
    }

    /* renamed from: b */
    public void m31018b() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + m31021e() + m31028l());
        }
        int i10 = this.f23829m;
        this.f23829m = i10 - 1;
        int[] iArr = this.f23831o;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f23817a = 0;
    }

    /* renamed from: c */
    public void m31019c() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f == 1) {
            m30999a(3);
            this.f23817a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + m31021e() + m31028l());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23817a = 0;
        this.f23828l[0] = 8;
        this.f23829m = 1;
        this.f23818b.close();
    }

    /* renamed from: d */
    public void m31020d() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + m31021e() + m31028l());
        }
        int i10 = this.f23829m;
        int i11 = i10 - 1;
        this.f23829m = i11;
        this.f23830n[i11] = null;
        int[] iArr = this.f23831o;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f23817a = 0;
    }

    /* renamed from: e */
    public EnumC5222c m31021e() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        switch (iM31022f) {
            case 1:
                return EnumC5222c.BEGIN_OBJECT;
            case 2:
                return EnumC5222c.END_OBJECT;
            case 3:
                return EnumC5222c.BEGIN_ARRAY;
            case 4:
                return EnumC5222c.END_ARRAY;
            case 5:
            case 6:
                return EnumC5222c.BOOLEAN;
            case 7:
                return EnumC5222c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return EnumC5222c.STRING;
            case 12:
            case 13:
            case 14:
                return EnumC5222c.NAME;
            case 15:
            case 16:
                return EnumC5222c.NUMBER;
            case 17:
                return EnumC5222c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: f */
    public int m31022f() throws IOException {
        int iM31002b;
        int[] iArr = this.f23828l;
        int i10 = this.f23829m;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int iM31002b2 = m31002b(true);
            if (iM31002b2 != 44) {
                if (iM31002b2 != 59) {
                    if (iM31002b2 != 93) {
                        throw m31003b("Unterminated array");
                    }
                    this.f23817a = 4;
                    return 4;
                }
                m31012r();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5 && (iM31002b = m31002b(true)) != 44) {
                    if (iM31002b != 59) {
                        if (iM31002b != 125) {
                            throw m31003b("Unterminated object");
                        }
                        this.f23817a = 2;
                        return 2;
                    }
                    m31012r();
                }
                int iM31002b3 = m31002b(true);
                if (iM31002b3 == 34) {
                    this.f23817a = 13;
                    return 13;
                }
                if (iM31002b3 == 39) {
                    m31012r();
                    this.f23817a = 12;
                    return 12;
                }
                if (iM31002b3 == 125) {
                    if (i11 == 5) {
                        throw m31003b("Expected name");
                    }
                    this.f23817a = 2;
                    return 2;
                }
                m31012r();
                this.f23821e--;
                if (!m31000a((char) iM31002b3)) {
                    throw m31003b("Expected name");
                }
                this.f23817a = 14;
                return 14;
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int iM31002b4 = m31002b(true);
                if (iM31002b4 != 58) {
                    if (iM31002b4 != 61) {
                        throw m31003b("Expected ':'");
                    }
                    m31012r();
                    if (this.f23821e < this.f23822f || m31005b(1)) {
                        char[] cArr = this.f23820d;
                        int i12 = this.f23821e;
                        if (cArr[i12] == '>') {
                            this.f23821e = i12 + 1;
                        }
                    }
                }
            } else if (i11 == 6) {
                if (this.f23819c) {
                    m31015u();
                }
                this.f23828l[this.f23829m - 1] = 7;
            } else if (i11 == 7) {
                if (m31002b(false) == -1) {
                    this.f23817a = 17;
                    return 17;
                }
                m31012r();
                this.f23821e--;
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iM31002b5 = m31002b(true);
        if (iM31002b5 == 34) {
            this.f23817a = 9;
            return 9;
        }
        if (iM31002b5 == 39) {
            m31012r();
            this.f23817a = 8;
            return 8;
        }
        if (iM31002b5 != 44 && iM31002b5 != 59) {
            if (iM31002b5 == 91) {
                this.f23817a = 3;
                return 3;
            }
            if (iM31002b5 != 93) {
                if (iM31002b5 == 123) {
                    this.f23817a = 1;
                    return 1;
                }
                this.f23821e--;
                int iM31008n = m31008n();
                if (iM31008n != 0) {
                    return iM31008n;
                }
                int iM31009o = m31009o();
                if (iM31009o != 0) {
                    return iM31009o;
                }
                if (!m31000a(this.f23820d[this.f23821e])) {
                    throw m31003b("Expected value");
                }
                m31012r();
                this.f23817a = 10;
                return 10;
            }
            if (i11 == 1) {
                this.f23817a = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw m31003b("Unexpected value");
        }
        m31012r();
        this.f23821e--;
        this.f23817a = 7;
        return 7;
    }

    /* renamed from: g */
    public String m31023g() throws IOException {
        String strM31004b;
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f == 14) {
            strM31004b = m31010p();
        } else if (iM31022f == 12) {
            strM31004b = m31004b('\'');
        } else {
            if (iM31022f != 13) {
                throw new IllegalStateException("Expected a name but was " + m31021e() + m31028l());
            }
            strM31004b = m31004b('\"');
        }
        this.f23817a = 0;
        this.f23830n[this.f23829m - 1] = strM31004b;
        return strM31004b;
    }

    /* renamed from: h */
    public String m31024h() throws IOException {
        String str;
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f == 10) {
            str = m31010p();
        } else if (iM31022f == 8) {
            str = m31004b('\'');
        } else if (iM31022f == 9) {
            str = m31004b('\"');
        } else if (iM31022f == 11) {
            str = this.f23827k;
            this.f23827k = null;
        } else if (iM31022f == 15) {
            str = Long.toString(this.f23825i);
        } else {
            if (iM31022f != 16) {
                throw new IllegalStateException("Expected a string but was " + m31021e() + m31028l());
            }
            str = new String(this.f23820d, this.f23821e, this.f23826j);
            this.f23821e += this.f23826j;
        }
        this.f23817a = 0;
        int[] iArr = this.f23831o;
        int i10 = this.f23829m - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    /* renamed from: i */
    public boolean m31025i() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f == 5) {
            this.f23817a = 0;
            int[] iArr = this.f23831o;
            int i10 = this.f23829m - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iM31022f == 6) {
            this.f23817a = 0;
            int[] iArr2 = this.f23831o;
            int i11 = this.f23829m - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + m31021e() + m31028l());
    }

    /* renamed from: j */
    public void m31026j() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f == 7) {
            this.f23817a = 0;
            int[] iArr = this.f23831o;
            int i10 = this.f23829m - 1;
            iArr[i10] = iArr[i10] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + m31021e() + m31028l());
    }

    /* renamed from: k */
    public void m31027k() throws IOException {
        int i10 = 0;
        do {
            int iM31022f = this.f23817a;
            if (iM31022f == 0) {
                iM31022f = m31022f();
            }
            if (iM31022f == 3) {
                m30999a(1);
            } else if (iM31022f == 1) {
                m30999a(3);
            } else if (iM31022f == 4 || iM31022f == 2) {
                this.f23829m--;
                i10--;
                this.f23817a = 0;
            } else {
                if (iM31022f == 14 || iM31022f == 10) {
                    m31011q();
                } else if (iM31022f == 8 || iM31022f == 12) {
                    m31007c('\'');
                } else if (iM31022f == 9 || iM31022f == 13) {
                    m31007c('\"');
                } else if (iM31022f == 16) {
                    this.f23821e += this.f23826j;
                }
                this.f23817a = 0;
            }
            i10++;
            this.f23817a = 0;
        } while (i10 != 0);
        int[] iArr = this.f23831o;
        int i11 = this.f23829m;
        int i12 = i11 - 1;
        iArr[i12] = iArr[i12] + 1;
        this.f23830n[i11 - 1] = "null";
    }

    /* renamed from: l */
    public String m31028l() {
        return " at line " + (this.f23823g + 1) + " column " + ((this.f23821e - this.f23824h) + 1) + " path " + m31029m();
    }

    /* renamed from: m */
    public String m31029m() {
        return m31006c(false);
    }

    public String toString() {
        return getClass().getSimpleName() + m31028l();
    }

    /* renamed from: a */
    public void m31016a() throws IOException {
        int iM31022f = this.f23817a;
        if (iM31022f == 0) {
            iM31022f = m31022f();
        }
        if (iM31022f == 3) {
            m30999a(1);
            this.f23831o[this.f23829m - 1] = 0;
            this.f23817a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + m31021e() + m31028l());
        }
    }

    /* renamed from: c */
    private void m31007c(char c10) throws IOException {
        char[] cArr = this.f23820d;
        do {
            int i10 = this.f23821e;
            int i11 = this.f23822f;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f23821e = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f23821e = i12;
                    m31014t();
                    i10 = this.f23821e;
                    i11 = this.f23822f;
                } else {
                    if (c11 == '\n') {
                        this.f23823g++;
                        this.f23824h = i12;
                    }
                    i10 = i12;
                }
            }
            this.f23821e = i10;
        } while (m31005b(1));
        throw m31003b("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f23821e = r2;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m31004b(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f23820d
            r1 = 0
        L3:
            int r2 = r9.f23821e
            int r3 = r9.f23822f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f23821e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r9 = new java.lang.String
            r9.<init>(r0, r3, r7)
            return r9
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r9 = r1.toString()
            return r9
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.f23821e = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.m31014t()
            r1.append(r2)
            int r2 = r9.f23821e
            int r3 = r9.f23822f
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f23823g
            int r2 = r2 + r6
            r9.f23823g = r2
            r9.f23824h = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f23821e = r2
            boolean r2 = r9.m31005b(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r9 = r9.m31003b(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5194b.m31004b(char):java.lang.String");
    }

    /* renamed from: a */
    private boolean m31000a(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m31012r();
        return false;
    }

    /* renamed from: a */
    private void m30999a(int i10) {
        int i11 = this.f23829m;
        int[] iArr = this.f23828l;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f23828l = Arrays.copyOf(iArr, i12);
            this.f23831o = Arrays.copyOf(this.f23831o, i12);
            this.f23830n = (String[]) Arrays.copyOf(this.f23830n, i12);
        }
        int[] iArr2 = this.f23828l;
        int i13 = this.f23829m;
        this.f23829m = i13 + 1;
        iArr2[i13] = i10;
    }

    /* renamed from: a */
    private boolean m31001a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f23821e + length > this.f23822f && !m31005b(length)) {
                return false;
            }
            char[] cArr = this.f23820d;
            int i10 = this.f23821e;
            if (cArr[i10] != '\n') {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f23820d[this.f23821e + i11] != str.charAt(i11)) {
                        break;
                    }
                }
                return true;
            }
            this.f23823g++;
            this.f23824h = i10 + 1;
            this.f23821e++;
        }
    }

    /* renamed from: c */
    private String m31006c(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f23829m;
            if (i10 < i11) {
                int i12 = this.f23828l[i10];
                if (i12 == 1 || i12 == 2) {
                    int i13 = this.f23831o[i10];
                    if (z10 && i13 > 0 && i10 == i11 - 1) {
                        i13--;
                    }
                    sb2.append('[');
                    sb2.append(i13);
                    sb2.append(']');
                } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                    sb2.append('.');
                    String str = this.f23830n[i10];
                    if (str != null) {
                        sb2.append(str);
                    }
                }
                i10++;
            } else {
                return sb2.toString();
            }
        }
    }

    /* renamed from: b */
    private boolean m31005b(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f23820d;
        int i13 = this.f23824h;
        int i14 = this.f23821e;
        this.f23824h = i13 - i14;
        int i15 = this.f23822f;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f23822f = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f23822f = 0;
        }
        this.f23821e = 0;
        do {
            Reader reader = this.f23818b;
            int i17 = this.f23822f;
            int i18 = reader.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f23822f + i18;
            this.f23822f = i11;
            if (this.f23823g == 0 && (i12 = this.f23824h) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f23821e++;
                this.f23824h = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    /* renamed from: b */
    private int m31002b(boolean z10) throws IOException {
        char[] cArr = this.f23820d;
        int i10 = this.f23821e;
        int i11 = this.f23822f;
        while (true) {
            if (i10 == i11) {
                this.f23821e = i10;
                if (!m31005b(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + m31028l());
                }
                i10 = this.f23821e;
                i11 = this.f23822f;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.f23823g++;
                this.f23824h = i12;
            } else if (c10 != ' ' && c10 != '\r' && c10 != '\t') {
                if (c10 == '/') {
                    this.f23821e = i12;
                    if (i12 == i11) {
                        this.f23821e = i10;
                        boolean zM31005b = m31005b(2);
                        this.f23821e++;
                        if (!zM31005b) {
                            return c10;
                        }
                    }
                    m31012r();
                    int i13 = this.f23821e;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f23821e = i13 + 1;
                        if (m31001a("*/")) {
                            i10 = this.f23821e + 2;
                            i11 = this.f23822f;
                        } else {
                            throw m31003b("Unterminated comment");
                        }
                    } else {
                        if (c11 != '/') {
                            return c10;
                        }
                        this.f23821e = i13 + 1;
                        m31013s();
                        i10 = this.f23821e;
                        i11 = this.f23822f;
                    }
                } else if (c10 == '#') {
                    this.f23821e = i12;
                    m31012r();
                    m31013s();
                    i10 = this.f23821e;
                    i11 = this.f23822f;
                } else {
                    this.f23821e = i12;
                    return c10;
                }
            }
            i10 = i12;
        }
    }

    /* renamed from: b */
    private IOException m31003b(String str) throws IOException {
        throw new C5278e(str + m31028l());
    }
}
