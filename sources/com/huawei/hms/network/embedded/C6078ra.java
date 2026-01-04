package com.huawei.hms.network.embedded;

import javax.security.auth.x500.X500Principal;

/* renamed from: com.huawei.hms.network.embedded.ra */
/* loaded from: classes8.dex */
public final class C6078ra {

    /* renamed from: a */
    public final String f28122a;

    /* renamed from: b */
    public final int f28123b;

    /* renamed from: c */
    public int f28124c;

    /* renamed from: d */
    public int f28125d;

    /* renamed from: e */
    public int f28126e;

    /* renamed from: f */
    public int f28127f;

    /* renamed from: g */
    public char[] f28128g;

    public C6078ra(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f28122a = name;
        this.f28123b = name.length();
    }

    /* renamed from: a */
    private int m35231a(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.f28123b) {
            throw new IllegalStateException("Malformed DN: " + this.f28122a);
        }
        char[] cArr = this.f28128g;
        char c10 = cArr[i10];
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i11 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f28122a);
            }
            i11 = c10 - '7';
        }
        char c11 = cArr[i13];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f28122a);
            }
            i12 = c11 - '7';
        }
        return (i11 << 4) + i12;
    }

    /* renamed from: b */
    private char m35233b() {
        int i10 = this.f28124c + 1;
        this.f28124c = i10;
        if (i10 == this.f28123b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f28122a);
        }
        char c10 = this.f28128g[i10];
        if (c10 != ' ' && c10 != '%' && c10 != '\\' && c10 != '_' && c10 != '\"' && c10 != '#') {
            switch (c10) {
                default:
                    switch (c10) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return m35234c();
                    }
                case '*':
                case '+':
                case ',':
                    return c10;
            }
        }
        return c10;
    }

    /* renamed from: c */
    private char m35234c() {
        int i10;
        int i11;
        int iM35231a = m35231a(this.f28124c);
        this.f28124c++;
        if (iM35231a < 128) {
            return (char) iM35231a;
        }
        if (iM35231a < 192 || iM35231a > 247) {
            return '?';
        }
        if (iM35231a <= 223) {
            i10 = iM35231a & 31;
            i11 = 1;
        } else if (iM35231a <= 239) {
            i10 = iM35231a & 15;
            i11 = 2;
        } else {
            i10 = iM35231a & 7;
            i11 = 3;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f28124c;
            int i14 = i13 + 1;
            this.f28124c = i14;
            if (i14 == this.f28123b || this.f28128g[i14] != '\\') {
                return '?';
            }
            int i15 = i13 + 2;
            this.f28124c = i15;
            int iM35231a2 = m35231a(i15);
            this.f28124c++;
            if ((iM35231a2 & 192) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (iM35231a2 & 63);
        }
        return (char) i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        r6.f28126e = r0;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m35235d() {
        /*
            r6 = this;
            int r0 = r6.f28124c
            int r1 = r0 + 4
            int r2 = r6.f28123b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L90
            r6.f28125d = r0
        Lc:
            int r0 = r0 + 1
            r6.f28124c = r0
            int r0 = r6.f28124c
            int r1 = r6.f28123b
            if (r0 == r1) goto L4c
            char[] r1 = r6.f28128g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L4c
            r4 = 44
            if (r2 == r4) goto L4c
            r4 = 59
            if (r2 != r4) goto L27
            goto L4c
        L27:
            r4 = 32
            if (r2 != r4) goto L3e
            r6.f28126e = r0
        L2d:
            int r0 = r0 + 1
            r6.f28124c = r0
            int r0 = r6.f28124c
            int r1 = r6.f28123b
            if (r0 >= r1) goto L4e
            char[] r1 = r6.f28128g
            char r1 = r1[r0]
            if (r1 != r4) goto L4e
            goto L2d
        L3e:
            r4 = 65
            if (r2 < r4) goto Lc
            r4 = 70
            if (r2 > r4) goto Lc
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
            goto Lc
        L4c:
            r6.f28126e = r0
        L4e:
            int r0 = r6.f28126e
            int r1 = r6.f28125d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L79
            r2 = r0 & 1
            if (r2 == 0) goto L79
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L61:
            if (r4 >= r2) goto L6f
            int r5 = r6.m35231a(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L61
        L6f:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f28128g
            int r6 = r6.f28125d
            r1.<init>(r2, r6, r0)
            return r1
        L79:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r6 = r6.f28122a
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L90:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r6 = r6.f28122a
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6078ra.m35235d():java.lang.String");
    }

    /* renamed from: e */
    private String m35236e() {
        int i10;
        int i11;
        int i12;
        char c10;
        char c11;
        char c12;
        int i13;
        int i14;
        char c13;
        char c14;
        while (true) {
            i10 = this.f28124c;
            i11 = this.f28123b;
            if (i10 >= i11 || this.f28128g[i10] != ' ') {
                break;
            }
            this.f28124c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f28125d = i10;
        do {
            this.f28124c = i10 + 1;
            i10 = this.f28124c;
            i12 = this.f28123b;
            if (i10 >= i12 || (c14 = this.f28128g[i10]) == '=') {
                break;
            }
        } while (c14 != ' ');
        if (i10 >= i12) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f28122a);
        }
        this.f28126e = i10;
        if (this.f28128g[i10] == ' ') {
            while (true) {
                i13 = this.f28124c;
                i14 = this.f28123b;
                if (i13 >= i14 || (c13 = this.f28128g[i13]) == '=' || c13 != ' ') {
                    break;
                }
                this.f28124c = i13 + 1;
            }
            if (this.f28128g[i13] != '=' || i13 == i14) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f28122a);
            }
        }
        int i15 = this.f28124c;
        do {
            this.f28124c = i15 + 1;
            i15 = this.f28124c;
            if (i15 >= this.f28123b) {
                break;
            }
        } while (this.f28128g[i15] == ' ');
        int i16 = this.f28126e;
        int i17 = this.f28125d;
        if (i16 - i17 > 4) {
            char[] cArr = this.f28128g;
            if (cArr[i17 + 3] == '.' && (((c10 = cArr[i17]) == 'O' || c10 == 'o') && (((c11 = cArr[i17 + 1]) == 'I' || c11 == 'i') && ((c12 = cArr[i17 + 2]) == 'D' || c12 == 'd')))) {
                this.f28125d = i17 + 4;
            }
        }
        char[] cArr2 = this.f28128g;
        int i18 = this.f28125d;
        return new String(cArr2, i18, i16 - i18);
    }

    /* renamed from: f */
    private String m35237f() {
        int i10 = this.f28124c + 1;
        this.f28124c = i10;
        this.f28125d = i10;
        while (true) {
            this.f28126e = i10;
            int i11 = this.f28124c;
            if (i11 == this.f28123b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f28122a);
            }
            char[] cArr = this.f28128g;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                do {
                    i11++;
                    this.f28124c = i11;
                    if (i11 >= this.f28123b) {
                        break;
                    }
                } while (this.f28128g[i11] == ' ');
                char[] cArr2 = this.f28128g;
                int i12 = this.f28125d;
                return new String(cArr2, i12, this.f28126e - i12);
            }
            if (c10 == '\\') {
                cArr[this.f28126e] = m35233b();
            } else {
                cArr[this.f28126e] = c10;
            }
            this.f28124c++;
            i10 = this.f28126e + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        r2 = r8.f28125d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        return new java.lang.String(r1, r2, r8.f28126e - r2);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m35232a() {
        /*
            r8 = this;
            int r0 = r8.f28124c
            r8.f28125d = r0
            r8.f28126e = r0
        L6:
            int r0 = r8.f28124c
            int r1 = r8.f28123b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f28128g
            int r2 = r8.f28125d
            int r8 = r8.f28126e
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        L19:
            char[] r1 = r8.f28128g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L58
            if (r2 == r5) goto L4d
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L4d
            if (r2 == r3) goto L4d
            int r3 = r8.f28126e
            int r4 = r3 + 1
            r8.f28126e = r4
            r1[r3] = r2
        L39:
            int r0 = r0 + 1
            r8.f28124c = r0
            goto L6
        L3e:
            int r0 = r8.f28126e
            int r2 = r0 + 1
            r8.f28126e = r2
            char r2 = r8.m35233b()
            r1[r0] = r2
            int r0 = r8.f28124c
            goto L39
        L4d:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f28125d
            int r8 = r8.f28126e
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        L58:
            int r2 = r8.f28126e
            r8.f28127f = r2
            int r0 = r0 + 1
            r8.f28124c = r0
            int r0 = r2 + 1
            r8.f28126e = r0
            r1[r2] = r6
        L66:
            int r0 = r8.f28124c
            int r1 = r8.f28123b
            if (r0 >= r1) goto L7f
            char[] r2 = r8.f28128g
            char r7 = r2[r0]
            if (r7 != r6) goto L7f
            int r1 = r8.f28126e
            int r7 = r1 + 1
            r8.f28126e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f28124c = r0
            goto L66
        L7f:
            if (r0 == r1) goto L8b
            char[] r1 = r8.f28128g
            char r0 = r1[r0]
            if (r0 == r3) goto L8b
            if (r0 == r4) goto L8b
            if (r0 != r5) goto L6
        L8b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f28128g
            int r2 = r8.f28125d
            int r8 = r8.f28127f
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6078ra.m35232a():java.lang.String");
    }

    /* renamed from: a */
    public String m35238a(String str) {
        this.f28124c = 0;
        this.f28125d = 0;
        this.f28126e = 0;
        this.f28127f = 0;
        this.f28128g = this.f28122a.toCharArray();
        String strM35236e = m35236e();
        if (strM35236e == null) {
            return null;
        }
        do {
            int i10 = this.f28124c;
            if (i10 == this.f28123b) {
                return null;
            }
            char c10 = this.f28128g[i10];
            String strM35232a = c10 != '\"' ? c10 != '#' ? (c10 == '+' || c10 == ',' || c10 == ';') ? "" : m35232a() : m35235d() : m35237f();
            if (str.equalsIgnoreCase(strM35236e)) {
                return strM35232a;
            }
            int i11 = this.f28124c;
            if (i11 >= this.f28123b) {
                return null;
            }
            char c11 = this.f28128g[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f28122a);
            }
            this.f28124c = i11 + 1;
            strM35236e = m35236e();
        } while (strM35236e != null);
        throw new IllegalStateException("Malformed DN: " + this.f28122a);
    }
}
