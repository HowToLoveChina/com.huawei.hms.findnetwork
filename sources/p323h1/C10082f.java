package p323h1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p481n1.C11590b;
import p481n1.C11595g;

/* renamed from: h1.f */
/* loaded from: classes.dex */
public final class C10082f extends AbstractC10080d {

    /* renamed from: t */
    public final String f49220t;

    /* renamed from: u */
    public final int f49221u;

    public C10082f(String str) {
        this(str, AbstractC9377a.f46783f);
    }

    /* renamed from: q1 */
    public static boolean m62834q1(String str, int i10, char[] cArr) {
        int length = cArr.length;
        if (length + i10 > str.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (cArr[i11] != str.charAt(i10 + i11)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r1 */
    public static boolean m62835r1(char c10, char c11, char c12, char c13, char c14, char c15, int i10, int i11) {
        if (c10 >= '0' && c10 <= '9' && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9') {
            if (c14 == '0') {
                if (c15 < '1' || c15 > '9') {
                    return false;
                }
            } else if (c14 != '1' || (c15 != '0' && c15 != '1' && c15 != '2')) {
                return false;
            }
            if (i10 == 48) {
                return i11 >= 49 && i11 <= 57;
            }
            if (i10 != 49 && i10 != 50) {
                return i10 == 51 && (i11 == 48 || i11 == 49);
            }
            if (i11 >= 48 && i11 <= 57) {
                return true;
            }
        }
        return false;
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: D0 */
    public final String mo62757D0() {
        char cMo62820e = mo62820e((this.f49208i + this.f49207h) - 1);
        int i10 = this.f49207h;
        if (cMo62820e == 'L' || cMo62820e == 'S' || cMo62820e == 'B' || cMo62820e == 'F' || cMo62820e == 'D') {
            i10--;
        }
        return mo62832o1(this.f49208i, i10);
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: F */
    public final BigDecimal mo62759F() {
        char cMo62820e = mo62820e((this.f49208i + this.f49207h) - 1);
        int i10 = this.f49207h;
        if (cMo62820e == 'L' || cMo62820e == 'S' || cMo62820e == 'B' || cMo62820e == 'F' || cMo62820e == 'D') {
            i10--;
        }
        if (i10 > 65535) {
            throw new C9380d("decimal overflow");
        }
        int i11 = this.f49208i;
        char[] cArr = this.f49206g;
        if (i10 < cArr.length) {
            this.f49220t.getChars(i11, i11 + i10, cArr, 0);
            return new BigDecimal(this.f49206g, 0, i10, MathContext.UNLIMITED);
        }
        char[] cArr2 = new char[i10];
        this.f49220t.getChars(i11, i11 + i10, cArr2, 0);
        return new BigDecimal(cArr2, 0, i10, MathContext.UNLIMITED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x007e, code lost:
    
        if (r13 != '.') goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0080, code lost:
    
        r16.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0082, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0083, code lost:
    
        if (r7 == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0085, code lost:
    
        if (r13 == '\"') goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0087, code lost:
    
        r16.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0089, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x008a, code lost:
    
        r13 = mo62820e(r12);
        r12 = r3 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0091, code lost:
    
        if (r4 >= 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0093, code lost:
    
        r16.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0095, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0098, code lost:
    
        if (r13 != r17) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x009a, code lost:
    
        r16.f49204e = r12;
        r16.f49203d = mo62820e(r12);
        r16.f49213n = 3;
        r16.f49200a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00a7, code lost:
    
        if (r6 == false) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00aa, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00af, code lost:
    
        if (p323h1.AbstractC10080d.m62792J0(r13) == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00b1, code lost:
    
        r13 = mo62820e(r12);
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00b9, code lost:
    
        r16.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00bb, code lost:
    
        if (r6 == false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00be, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:?, code lost:
    
        return r4;
     */
    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo62760G(char r17) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.C10082f.mo62760G(char):int");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: H */
    public byte[] mo62761H() {
        if (this.f49200a != 26) {
            return !this.f49209j ? C11595g.m69208c(this.f49220t, this.f49208i + 1, this.f49207h) : C11595g.m69207b(new String(this.f49206g, 0, this.f49207h));
        }
        int i10 = this.f49208i + 1;
        int i11 = this.f49207h;
        if (i11 % 2 != 0) {
            throw new C9380d("illegal state. " + i11);
        }
        int i12 = i11 / 2;
        byte[] bArr = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 2) + i10;
            char cCharAt = this.f49220t.charAt(i14);
            char cCharAt2 = this.f49220t.charAt(i14 + 1);
            char c10 = '7';
            int i15 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 <= '9') {
                c10 = '0';
            }
            bArr[i13] = (byte) ((i15 << 4) | (cCharAt2 - c10));
        }
        return bArr;
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: H0 */
    public final int mo62796H0(char c10, int i10) {
        return this.f49220t.indexOf(c10, i10);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: I0 */
    public boolean mo62797I0() {
        int i10 = this.f49204e;
        int i11 = this.f49221u;
        if (i10 != i11) {
            return this.f49203d == 26 && i10 + 1 >= i11;
        }
        return true;
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: J */
    public final String mo62763J() {
        return !this.f49209j ? mo62832o1(this.f49208i + 1, this.f49207h) : new String(this.f49206g, 0, this.f49207h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x0151, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00f3 A[SYNTHETIC] */
    @Override // p323h1.AbstractC10080d
    /* renamed from: T0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo62806T0(char[] r12) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.C10082f.mo62806T0(char[]):boolean");
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: U0 */
    public Date mo62807U0(char[] cArr) {
        long j10;
        Date date;
        char cMo62820e;
        char cMo62820e2;
        boolean z10 = false;
        this.f49213n = 0;
        int i10 = this.f49204e;
        char c10 = this.f49203d;
        if (!m62834q1(this.f49220t, i10, cArr)) {
            this.f49213n = -2;
            return null;
        }
        int length = this.f49204e + cArr.length;
        int i11 = length + 1;
        char cMo62820e3 = mo62820e(length);
        if (cMo62820e3 == '\"') {
            int iMo62796H0 = mo62796H0('\"', i11);
            if (iMo62796H0 == -1) {
                throw new C9380d("unclosed str");
            }
            this.f49204e = i11;
            if (!m62839v1(false, iMo62796H0 - i11)) {
                this.f49204e = i10;
                this.f49213n = -1;
                return null;
            }
            date = this.f49210k.getTime();
            cMo62820e = mo62820e(iMo62796H0 + 1);
            this.f49204e = i10;
            while (cMo62820e != ',' && cMo62820e != '}') {
                if (!AbstractC10080d.m62792J0(cMo62820e)) {
                    this.f49213n = -1;
                    return null;
                }
                int i12 = iMo62796H0 + 1;
                char cMo62820e4 = mo62820e(iMo62796H0 + 2);
                iMo62796H0 = i12;
                cMo62820e = cMo62820e4;
            }
            this.f49204e = iMo62796H0 + 1;
            this.f49203d = cMo62820e;
        } else {
            char c11 = '9';
            char c12 = '0';
            if (cMo62820e3 != '-' && (cMo62820e3 < '0' || cMo62820e3 > '9')) {
                this.f49213n = -1;
                return null;
            }
            if (cMo62820e3 == '-') {
                cMo62820e3 = mo62820e(i11);
                i11 = length + 2;
                z10 = true;
            }
            if (cMo62820e3 < '0' || cMo62820e3 > '9') {
                j10 = 0;
            } else {
                long j11 = cMo62820e3 - '0';
                while (true) {
                    int i13 = i11 + 1;
                    cMo62820e2 = mo62820e(i11);
                    if (cMo62820e2 < c12 || cMo62820e2 > c11) {
                        break;
                    }
                    j11 = (j11 * 10) + (cMo62820e2 - '0');
                    i11 = i13;
                    c11 = '9';
                    c12 = '0';
                }
                if (cMo62820e2 == ',' || cMo62820e2 == '}') {
                    this.f49204e = i11;
                }
                long j12 = j11;
                cMo62820e3 = cMo62820e2;
                j10 = j12;
            }
            if (j10 < 0) {
                this.f49213n = -1;
                return null;
            }
            if (z10) {
                j10 = -j10;
            }
            date = new Date(j10);
            cMo62820e = cMo62820e3;
        }
        if (cMo62820e == ',') {
            int i14 = this.f49204e + 1;
            this.f49204e = i14;
            this.f49203d = mo62820e(i14);
            this.f49213n = 3;
            this.f49200a = 16;
            return date;
        }
        int i15 = this.f49204e + 1;
        this.f49204e = i15;
        char cMo62820e5 = mo62820e(i15);
        if (cMo62820e5 == ',') {
            this.f49200a = 16;
            int i16 = this.f49204e + 1;
            this.f49204e = i16;
            this.f49203d = mo62820e(i16);
        } else if (cMo62820e5 == ']') {
            this.f49200a = 15;
            int i17 = this.f49204e + 1;
            this.f49204e = i17;
            this.f49203d = mo62820e(i17);
        } else if (cMo62820e5 == '}') {
            this.f49200a = 13;
            int i18 = this.f49204e + 1;
            this.f49204e = i18;
            this.f49203d = mo62820e(i18);
        } else {
            if (cMo62820e5 != 26) {
                this.f49204e = i10;
                this.f49203d = c10;
                this.f49213n = -1;
                return null;
            }
            this.f49200a = 20;
        }
        this.f49213n = 4;
        return date;
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0063, code lost:
    
        if (r12 != '.') goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0065, code lost:
    
        r14.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0067, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0068, code lost:
    
        if (r4 >= 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x006a, code lost:
    
        r14.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x006c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x006d, code lost:
    
        if (r7 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x006f, code lost:
    
        if (r12 == '\"') goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0071, code lost:
    
        r14.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0073, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0074, code lost:
    
        r15 = r15 + 2;
        r12 = mo62820e(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x007f, code lost:
    
        if (r12 == ',') goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0081, code lost:
    
        if (r12 != '}') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0088, code lost:
    
        if (p323h1.AbstractC10080d.m62792J0(r12) == false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x008a, code lost:
    
        r15 = r11 + 1;
        r12 = mo62820e(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0091, code lost:
    
        r14.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0093, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0094, code lost:
    
        r14.f49204e = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x009a, code lost:
    
        if (r12 != ',') goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x009c, code lost:
    
        r14.f49204e = r11;
        r14.f49203d = mo62820e(r11);
        r14.f49213n = 3;
        r14.f49200a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00a9, code lost:
    
        if (r3 == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x00ac, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x00ad, code lost:
    
        if (r12 != '}') goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00af, code lost:
    
        r14.f49204e = r11;
        r8 = mo62820e(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00b5, code lost:
    
        if (r8 != ',') goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00b7, code lost:
    
        r14.f49200a = 16;
        r15 = r14.f49204e + 1;
        r14.f49204e = r15;
        r14.f49203d = mo62820e(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00c7, code lost:
    
        if (r8 != ']') goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x00c9, code lost:
    
        r14.f49200a = 15;
        r15 = r14.f49204e + 1;
        r14.f49204e = r15;
        r14.f49203d = mo62820e(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x00d9, code lost:
    
        if (r8 != '}') goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x00db, code lost:
    
        r14.f49200a = 13;
        r15 = r14.f49204e + 1;
        r14.f49204e = r15;
        r14.f49203d = mo62820e(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00ed, code lost:
    
        if (r8 != 26) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00ef, code lost:
    
        r14.f49200a = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00f3, code lost:
    
        r14.f49213n = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00fb, code lost:
    
        if (p323h1.AbstractC10080d.m62792J0(r8) == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00fd, code lost:
    
        r8 = r14.f49204e + 1;
        r14.f49204e = r8;
        r8 = mo62820e(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0107, code lost:
    
        r14.f49204e = r1;
        r14.f49203d = r2;
        r14.f49213n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x010d, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x010e, code lost:
    
        if (r3 == false) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0111, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:?, code lost:
    
        return r4;
     */
    @Override // p323h1.AbstractC10080d
    /* renamed from: a1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int mo62813a1(char[] r15) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.C10082f.mo62813a1(char[]):int");
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: b */
    public final String mo62814b(int i10, int i11, int i12, C10086j c10086j) {
        return c10086j.m62877a(this.f49220t, i10, i11, i12);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: c */
    public final void mo62816c(int i10, char[] cArr, int i11, int i12) {
        this.f49220t.getChars(i10, i12 + i10, cArr, i11);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: c1 */
    public long mo62817c1(char[] cArr) {
        int i10;
        char cMo62820e;
        boolean z10 = false;
        this.f49213n = 0;
        int i11 = this.f49204e;
        char c10 = this.f49203d;
        if (!m62834q1(this.f49220t, i11, cArr)) {
            this.f49213n = -2;
            return 0L;
        }
        int length = this.f49204e + cArr.length;
        int i12 = length + 1;
        char cMo62820e2 = mo62820e(length);
        boolean z11 = cMo62820e2 == '\"';
        if (z11) {
            cMo62820e2 = mo62820e(i12);
            i12 = length + 2;
        }
        if (cMo62820e2 == '-') {
            cMo62820e2 = mo62820e(i12);
            i12++;
            z10 = true;
        }
        if (cMo62820e2 < '0' || cMo62820e2 > '9') {
            this.f49204e = i11;
            this.f49203d = c10;
            this.f49213n = -1;
            return 0L;
        }
        long j10 = cMo62820e2 - '0';
        while (true) {
            i10 = i12 + 1;
            cMo62820e = mo62820e(i12);
            if (cMo62820e < '0' || cMo62820e > '9') {
                break;
            }
            j10 = (j10 * 10) + (cMo62820e - '0');
            i12 = i10;
        }
        if (cMo62820e == '.') {
            this.f49213n = -1;
            return 0L;
        }
        if (z11) {
            if (cMo62820e != '\"') {
                this.f49213n = -1;
                return 0L;
            }
            cMo62820e = mo62820e(i10);
            i10 = i12 + 2;
        }
        if (cMo62820e == ',' || cMo62820e == '}') {
            this.f49204e = i10 - 1;
        }
        if (j10 < 0 && (j10 != Long.MIN_VALUE || !z10)) {
            this.f49204e = i11;
            this.f49203d = c10;
            this.f49213n = -1;
            return 0L;
        }
        while (cMo62820e != ',') {
            if (cMo62820e == '}') {
                int i13 = 1;
                int i14 = this.f49204e + 1;
                this.f49204e = i14;
                char cMo62820e3 = mo62820e(i14);
                while (true) {
                    if (cMo62820e3 == ',') {
                        this.f49200a = 16;
                        int i15 = this.f49204e + i13;
                        this.f49204e = i15;
                        this.f49203d = mo62820e(i15);
                        break;
                    }
                    if (cMo62820e3 == ']') {
                        this.f49200a = 15;
                        int i16 = this.f49204e + i13;
                        this.f49204e = i16;
                        this.f49203d = mo62820e(i16);
                        break;
                    }
                    if (cMo62820e3 == '}') {
                        this.f49200a = 13;
                        int i17 = this.f49204e + i13;
                        this.f49204e = i17;
                        this.f49203d = mo62820e(i17);
                        break;
                    }
                    if (cMo62820e3 == 26) {
                        this.f49200a = 20;
                        break;
                    }
                    if (!AbstractC10080d.m62792J0(cMo62820e3)) {
                        this.f49204e = i11;
                        this.f49203d = c10;
                        this.f49213n = -1;
                        return 0L;
                    }
                    int i18 = this.f49204e + 1;
                    this.f49204e = i18;
                    cMo62820e3 = mo62820e(i18);
                    i13 = 1;
                }
                this.f49213n = 4;
                return z10 ? -j10 : j10;
            }
            if (!AbstractC10080d.m62792J0(cMo62820e)) {
                this.f49213n = -1;
                return 0L;
            }
            this.f49204e = i10;
            cMo62820e = mo62820e(i10);
            i10++;
        }
        int i19 = this.f49204e + 1;
        this.f49204e = i19;
        this.f49203d = mo62820e(i19);
        this.f49213n = 3;
        this.f49200a = 16;
        return z10 ? -j10 : j10;
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: d */
    public final boolean mo62818d(char[] cArr) {
        return m62834q1(this.f49220t, this.f49204e, cArr);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: d1 */
    public String mo62819d1(char[] cArr) {
        this.f49213n = 0;
        int i10 = this.f49204e;
        char c10 = this.f49203d;
        while (!m62834q1(this.f49220t, this.f49204e, cArr)) {
            if (!AbstractC10080d.m62792J0(this.f49203d)) {
                this.f49213n = -2;
                return m62831n1();
            }
            next();
            while (AbstractC10080d.m62792J0(this.f49203d)) {
                next();
            }
        }
        int length = this.f49204e + cArr.length;
        int i11 = length + 1;
        char cMo62820e = mo62820e(length);
        int i12 = 0;
        if (cMo62820e != '\"') {
            while (AbstractC10080d.m62792J0(cMo62820e)) {
                i12++;
                int i13 = i11 + 1;
                char cMo62820e2 = mo62820e(i11);
                i11 = i13;
                cMo62820e = cMo62820e2;
            }
            if (cMo62820e != '\"') {
                this.f49213n = -1;
                return m62831n1();
            }
        }
        int iMo62796H0 = mo62796H0('\"', i11);
        if (iMo62796H0 == -1) {
            throw new C9380d("unclosed str");
        }
        String strMo62832o1 = mo62832o1(i11, iMo62796H0 - i11);
        if (strMo62832o1.indexOf(92) != -1) {
            while (true) {
                int i14 = 0;
                for (int i15 = iMo62796H0 - 1; i15 >= 0 && mo62820e(i15) == '\\'; i15--) {
                    i14++;
                }
                if (i14 % 2 == 0) {
                    break;
                }
                iMo62796H0 = mo62796H0('\"', iMo62796H0 + 1);
            }
            int i16 = this.f49204e;
            int length2 = iMo62796H0 - (((cArr.length + i16) + 1) + i12);
            strMo62832o1 = AbstractC10080d.m62793P0(mo62833p1(i16 + cArr.length + 1 + i12, length2), length2);
        }
        if ((this.f49202c & EnumC10078b.TrimStringFieldValue.f49196a) != 0) {
            strMo62832o1 = strMo62832o1.trim();
        }
        char cMo62820e3 = mo62820e(iMo62796H0 + 1);
        while (cMo62820e3 != ',' && cMo62820e3 != '}') {
            if (!AbstractC10080d.m62792J0(cMo62820e3)) {
                this.f49213n = -1;
                return m62831n1();
            }
            char cMo62820e4 = mo62820e(iMo62796H0 + 2);
            iMo62796H0++;
            cMo62820e3 = cMo62820e4;
        }
        this.f49204e = iMo62796H0 + 1;
        this.f49203d = cMo62820e3;
        if (cMo62820e3 == ',') {
            int i17 = iMo62796H0 + 2;
            this.f49204e = i17;
            this.f49203d = mo62820e(i17);
            this.f49213n = 3;
            return strMo62832o1;
        }
        int i18 = iMo62796H0 + 2;
        this.f49204e = i18;
        char cMo62820e5 = mo62820e(i18);
        if (cMo62820e5 == ',') {
            this.f49200a = 16;
            int i19 = this.f49204e + 1;
            this.f49204e = i19;
            this.f49203d = mo62820e(i19);
        } else if (cMo62820e5 == ']') {
            this.f49200a = 15;
            int i20 = this.f49204e + 1;
            this.f49204e = i20;
            this.f49203d = mo62820e(i20);
        } else if (cMo62820e5 == '}') {
            this.f49200a = 13;
            int i21 = this.f49204e + 1;
            this.f49204e = i21;
            this.f49203d = mo62820e(i21);
        } else {
            if (cMo62820e5 != 26) {
                this.f49204e = i10;
                this.f49203d = c10;
                this.f49213n = -1;
                return m62831n1();
            }
            this.f49200a = 20;
        }
        this.f49213n = 4;
        return strMo62832o1;
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: e */
    public final char mo62820e(int i10) {
        if (i10 >= this.f49221u) {
            return (char) 26;
        }
        return this.f49220t.charAt(i10);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: f */
    public final void mo62822f(int i10, int i11, char[] cArr) {
        this.f49220t.getChars(i10, i11 + i10, cArr, 0);
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: g0 */
    public double mo62771g0(char c10) throws NumberFormatException {
        int i10;
        char cMo62820e;
        long j10;
        int i11;
        int i12;
        double d10;
        char cMo62820e2;
        this.f49213n = 0;
        int i13 = this.f49204e;
        int i14 = i13 + 1;
        char cMo62820e3 = mo62820e(i13);
        boolean z10 = cMo62820e3 == '\"';
        if (z10) {
            cMo62820e3 = mo62820e(i14);
            i14 = i13 + 2;
        }
        boolean z11 = cMo62820e3 == '-';
        if (z11) {
            cMo62820e3 = mo62820e(i14);
            i14++;
        }
        if (cMo62820e3 >= '0') {
            char c11 = '9';
            if (cMo62820e3 <= '9') {
                long j11 = cMo62820e3 - '0';
                while (true) {
                    i10 = i14 + 1;
                    cMo62820e = mo62820e(i14);
                    if (cMo62820e < '0' || cMo62820e > '9') {
                        break;
                    }
                    j11 = (j11 * 10) + (cMo62820e - '0');
                    i14 = i10;
                }
                if (cMo62820e == '.') {
                    int i15 = i14 + 2;
                    char cMo62820e4 = mo62820e(i10);
                    if (cMo62820e4 < '0' || cMo62820e4 > '9') {
                        this.f49213n = -1;
                        return 0.0d;
                    }
                    j11 = (j11 * 10) + (cMo62820e4 - '0');
                    long j12 = 10;
                    while (true) {
                        i10 = i15 + 1;
                        cMo62820e2 = mo62820e(i15);
                        if (cMo62820e2 < '0' || cMo62820e2 > c11) {
                            break;
                        }
                        j11 = (j11 * 10) + (cMo62820e2 - '0');
                        j12 *= 10;
                        i15 = i10;
                        c11 = '9';
                    }
                    long j13 = j12;
                    cMo62820e = cMo62820e2;
                    j10 = j13;
                } else {
                    j10 = 1;
                }
                boolean z12 = cMo62820e == 'e' || cMo62820e == 'E';
                if (z12) {
                    int i16 = i10 + 1;
                    char cMo62820e5 = mo62820e(i10);
                    if (cMo62820e5 == '+' || cMo62820e5 == '-') {
                        i10 += 2;
                        cMo62820e = mo62820e(i16);
                    } else {
                        i10 = i16;
                        cMo62820e = cMo62820e5;
                    }
                    while (cMo62820e >= '0' && cMo62820e <= '9') {
                        int i17 = i10 + 1;
                        char cMo62820e6 = mo62820e(i10);
                        i10 = i17;
                        cMo62820e = cMo62820e6;
                    }
                }
                if (!z10) {
                    i11 = this.f49204e;
                    i12 = (i10 - i11) - 1;
                } else {
                    if (cMo62820e != '\"') {
                        this.f49213n = -1;
                        return 0.0d;
                    }
                    int i18 = i10 + 1;
                    char cMo62820e7 = mo62820e(i10);
                    i11 = this.f49204e + 1;
                    i12 = (i18 - i11) - 2;
                    i10 = i18;
                    cMo62820e = cMo62820e7;
                }
                if (z12 || i12 >= 18) {
                    d10 = Double.parseDouble(mo62832o1(i11, i12));
                } else {
                    d10 = j11 / j10;
                    if (z11) {
                        d10 = -d10;
                    }
                }
                if (cMo62820e != c10) {
                    this.f49213n = -1;
                    return d10;
                }
                this.f49204e = i10;
                this.f49203d = mo62820e(i10);
                this.f49213n = 3;
                this.f49200a = 16;
                return d10;
            }
        }
        if (cMo62820e3 == 'n') {
            int i19 = i14 + 1;
            if (mo62820e(i14) == 'u') {
                int i20 = i14 + 2;
                if (mo62820e(i19) == 'l') {
                    int i21 = i14 + 3;
                    if (mo62820e(i20) == 'l') {
                        this.f49213n = 5;
                        int i22 = i14 + 4;
                        char cMo62820e8 = mo62820e(i21);
                        if (z10 && cMo62820e8 == '\"') {
                            cMo62820e8 = mo62820e(i22);
                            i22 = i14 + 5;
                        }
                        while (cMo62820e8 != ',') {
                            if (cMo62820e8 == ']') {
                                this.f49204e = i22;
                                this.f49203d = mo62820e(i22);
                                this.f49213n = 5;
                                this.f49200a = 15;
                                return 0.0d;
                            }
                            if (!AbstractC10080d.m62792J0(cMo62820e8)) {
                                this.f49213n = -1;
                                return 0.0d;
                            }
                            char cMo62820e9 = mo62820e(i22);
                            i22++;
                            cMo62820e8 = cMo62820e9;
                        }
                        this.f49204e = i22;
                        this.f49203d = mo62820e(i22);
                        this.f49213n = 5;
                        this.f49200a = 16;
                        return 0.0d;
                    }
                }
            }
        }
        this.f49213n = -1;
        return 0.0d;
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    public final char next() {
        int i10 = this.f49204e + 1;
        this.f49204e = i10;
        char cCharAt = i10 >= this.f49221u ? (char) 26 : this.f49220t.charAt(i10);
        this.f49203d = cCharAt;
        return cCharAt;
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: o1 */
    public final String mo62832o1(int i10, int i11) {
        if (!C11590b.f53767b) {
            return this.f49220t.substring(i10, i11 + i10);
        }
        char[] cArr = this.f49206g;
        if (i11 < cArr.length) {
            this.f49220t.getChars(i10, i10 + i11, cArr, 0);
            return new String(this.f49206g, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.f49220t.getChars(i10, i11 + i10, cArr2, 0);
        return new String(cArr2);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: p1 */
    public final char[] mo62833p1(int i10, int i11) {
        if (C11590b.f53767b) {
            char[] cArr = this.f49206g;
            if (i11 < cArr.length) {
                this.f49220t.getChars(i10, i11 + i10, cArr, 0);
                return this.f49206g;
            }
        }
        char[] cArr2 = new char[i11];
        this.f49220t.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: q0 */
    public long mo62777q0(char c10) {
        int i10;
        char cMo62820e;
        this.f49213n = 0;
        int i11 = this.f49204e;
        int i12 = i11 + 1;
        char cMo62820e2 = mo62820e(i11);
        boolean z10 = cMo62820e2 == '\"';
        if (z10) {
            cMo62820e2 = mo62820e(i12);
            i12 = i11 + 2;
        }
        boolean z11 = cMo62820e2 == '-';
        if (z11) {
            cMo62820e2 = mo62820e(i12);
            i12++;
        }
        if (cMo62820e2 >= '0' && cMo62820e2 <= '9') {
            long j10 = cMo62820e2 - '0';
            while (true) {
                i10 = i12 + 1;
                cMo62820e = mo62820e(i12);
                if (cMo62820e < '0' || cMo62820e > '9') {
                    break;
                }
                j10 = (j10 * 10) + (cMo62820e - '0');
                i12 = i10;
            }
            if (cMo62820e == '.') {
                this.f49213n = -1;
                return 0L;
            }
            if (z10) {
                if (cMo62820e != '\"') {
                    this.f49213n = -1;
                    return 0L;
                }
                cMo62820e = mo62820e(i10);
                i10 = i12 + 2;
            }
            if (j10 < 0 && (j10 != Long.MIN_VALUE || !z11)) {
                this.f49213n = -1;
                return 0L;
            }
            while (cMo62820e != c10) {
                if (!AbstractC10080d.m62792J0(cMo62820e)) {
                    this.f49213n = -1;
                    return j10;
                }
                cMo62820e = mo62820e(i10);
                i10++;
            }
            this.f49204e = i10;
            this.f49203d = mo62820e(i10);
            this.f49213n = 3;
            this.f49200a = 16;
            return z11 ? -j10 : j10;
        }
        if (cMo62820e2 == 'n') {
            int i13 = i12 + 1;
            if (mo62820e(i12) == 'u') {
                int i14 = i12 + 2;
                if (mo62820e(i13) == 'l') {
                    int i15 = i12 + 3;
                    if (mo62820e(i14) == 'l') {
                        this.f49213n = 5;
                        int i16 = i12 + 4;
                        char cMo62820e3 = mo62820e(i15);
                        if (z10 && cMo62820e3 == '\"') {
                            cMo62820e3 = mo62820e(i16);
                            i16 = i12 + 5;
                        }
                        while (cMo62820e3 != ',') {
                            if (cMo62820e3 == ']') {
                                this.f49204e = i16;
                                this.f49203d = mo62820e(i16);
                                this.f49213n = 5;
                                this.f49200a = 15;
                                return 0L;
                            }
                            if (!AbstractC10080d.m62792J0(cMo62820e3)) {
                                this.f49213n = -1;
                                return 0L;
                            }
                            char cMo62820e4 = mo62820e(i16);
                            i16++;
                            cMo62820e3 = cMo62820e4;
                        }
                        this.f49204e = i16;
                        this.f49203d = mo62820e(i16);
                        this.f49213n = 5;
                        this.f49200a = 16;
                        return 0L;
                    }
                }
            }
        }
        this.f49213n = -1;
        return 0L;
    }

    /* renamed from: s1 */
    public final boolean m62836s1(char c10, char c11, char c12, char c13, char c14, char c15) {
        if (c10 == '0') {
            if (c11 < '0' || c11 > '9') {
                return false;
            }
        } else {
            if (c10 != '1') {
                if (c10 == '2' && c11 >= '0' && c11 <= '4') {
                }
                return false;
            }
            if (c11 < '0' || c11 > '9') {
                return false;
            }
        }
        if (c12 < '0' || c12 > '5') {
            if (c12 != '6' || c13 != '0') {
                return false;
            }
        } else if (c13 < '0' || c13 > '9') {
            return false;
        }
        return (c14 < '0' || c14 > '5') ? c14 == '6' && c15 == '0' : c15 >= '0' && c15 <= '9';
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: t */
    public String mo62781t() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 1;
        int i11 = 1;
        int i12 = 0;
        while (i12 < this.f49204e) {
            if (this.f49220t.charAt(i12) == '\n') {
                i10++;
                i11 = 1;
            }
            i12++;
            i11++;
        }
        sb2.append("pos ");
        sb2.append(this.f49204e);
        sb2.append(", line ");
        sb2.append(i10);
        sb2.append(", column ");
        sb2.append(i11);
        if (this.f49220t.length() < 65535) {
            sb2.append(this.f49220t);
        } else {
            sb2.append(this.f49220t.substring(0, 65535));
        }
        return sb2.toString();
    }

    /* renamed from: t1 */
    public boolean m62837t1() {
        return m62838u1(true);
    }

    /* renamed from: u1 */
    public boolean m62838u1(boolean z10) {
        return m62839v1(z10, this.f49221u - this.f49204e);
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: v */
    public String mo62785v(C10086j c10086j) {
        int iIndexOf;
        if (!this.f49220t.startsWith("\"@type\":\"", this.f49204e) || (iIndexOf = this.f49220t.indexOf(34, this.f49204e + 9)) == -1) {
            return null;
        }
        int i10 = this.f49204e + 9;
        this.f49204e = i10;
        int iCharAt = 0;
        while (i10 < iIndexOf) {
            iCharAt = (iCharAt * 31) + this.f49220t.charAt(i10);
            i10++;
        }
        int i11 = this.f49204e;
        String strMo62814b = mo62814b(i11, iIndexOf - i11, iCharAt, c10086j);
        char cCharAt = this.f49220t.charAt(iIndexOf + 1);
        if (cCharAt != ',' && cCharAt != ']') {
            return null;
        }
        int i12 = iIndexOf + 2;
        this.f49204e = i12;
        this.f49203d = this.f49220t.charAt(i12);
        return strMo62814b;
    }

    /* renamed from: v1 */
    public final boolean m62839v1(boolean z10, int i10) throws NumberFormatException {
        int i11;
        boolean z11;
        char c10;
        char cMo62820e;
        char c11;
        char c12;
        char c13;
        int i12;
        int i13;
        int i14;
        int i15;
        char c14;
        char c15;
        char cMo62820e2;
        char c16;
        char c17;
        char c18;
        int i16;
        char c19;
        char c20;
        char c21;
        char c22;
        int i17;
        char c23;
        char c24;
        char c25;
        int i18;
        int i19;
        char cMo62820e3;
        char cMo62820e4;
        char cMo62820e5;
        char cMo62820e6;
        char cMo62820e7;
        char cMo62820e8;
        if (i10 < 8) {
            return false;
        }
        char cMo62820e9 = mo62820e(this.f49204e);
        char cMo62820e10 = mo62820e(this.f49204e + 1);
        char cMo62820e11 = mo62820e(this.f49204e + 2);
        int i20 = 3;
        char cMo62820e12 = mo62820e(this.f49204e + 3);
        char cMo62820e13 = mo62820e(this.f49204e + 4);
        int i21 = 5;
        char cMo62820e14 = mo62820e(this.f49204e + 5);
        char cMo62820e15 = mo62820e(this.f49204e + 6);
        char cMo62820e16 = mo62820e(this.f49204e + 7);
        if (!z10) {
            if (i10 > 13) {
                char cMo62820e17 = mo62820e((this.f49204e + i10) - 1);
                char cMo62820e18 = mo62820e((this.f49204e + i10) - 2);
                if (cMo62820e9 == '/' && cMo62820e10 == 'D' && cMo62820e11 == 'a' && cMo62820e12 == 't' && cMo62820e13 == 'e' && cMo62820e14 == '(' && cMo62820e17 == '/' && cMo62820e18 == ')') {
                    int i22 = -1;
                    for (int i23 = 6; i23 < i10; i23++) {
                        char cMo62820e19 = mo62820e(this.f49204e + i23);
                        if (cMo62820e19 != '+') {
                            if (cMo62820e19 < '0' || cMo62820e19 > '9') {
                                break;
                            }
                        } else {
                            i22 = i23;
                        }
                    }
                    if (i22 == -1) {
                        return false;
                    }
                    int i24 = this.f49204e;
                    int i25 = i24 + 6;
                    long j10 = Long.parseLong(mo62832o1(i25, (i24 + i22) - i25));
                    Calendar calendar = Calendar.getInstance(this.f49211l, this.f49212m);
                    this.f49210k = calendar;
                    calendar.setTimeInMillis(j10);
                    this.f49200a = 5;
                    return true;
                }
            }
            i21 = 5;
        }
        if (i10 == 8 || i10 == 14) {
            i11 = i21;
            z11 = false;
            c10 = ':';
        } else {
            if (!(i10 == 16 && ((cMo62820e8 = mo62820e(this.f49204e + 10)) == 'T' || cMo62820e8 == ' ')) && (i10 != 17 || mo62820e(this.f49204e + 6) == '-')) {
                if (i10 < 9) {
                    return false;
                }
                char cMo62820e20 = mo62820e(this.f49204e + 8);
                char cMo62820e21 = mo62820e(this.f49204e + 9);
                if ((cMo62820e13 == '-' && cMo62820e16 == '-') || (cMo62820e13 == '/' && cMo62820e16 == '/')) {
                    if (cMo62820e21 == ' ') {
                        c19 = cMo62820e14;
                        c20 = cMo62820e12;
                        c21 = cMo62820e9;
                        c22 = cMo62820e10;
                        c23 = '0';
                        i17 = 9;
                        cMo62820e10 = cMo62820e20;
                        c25 = cMo62820e15;
                        c24 = cMo62820e11;
                    } else {
                        c20 = cMo62820e12;
                        c21 = cMo62820e9;
                        i17 = 10;
                        c23 = cMo62820e20;
                        c25 = cMo62820e15;
                        c24 = cMo62820e11;
                        c19 = cMo62820e14;
                        c22 = cMo62820e10;
                        cMo62820e10 = cMo62820e21;
                    }
                } else if (cMo62820e13 == '-' && cMo62820e15 == '-') {
                    if (cMo62820e20 == ' ') {
                        c24 = cMo62820e11;
                        c25 = cMo62820e14;
                        c21 = cMo62820e9;
                        c22 = cMo62820e10;
                        c19 = '0';
                        i17 = 8;
                        cMo62820e10 = cMo62820e16;
                        c20 = cMo62820e12;
                        c23 = '0';
                    } else {
                        c24 = cMo62820e11;
                        c21 = cMo62820e9;
                        c19 = '0';
                        i17 = 9;
                        c25 = cMo62820e14;
                        c22 = cMo62820e10;
                        cMo62820e10 = cMo62820e20;
                        c23 = cMo62820e16;
                        c20 = cMo62820e12;
                    }
                } else if ((cMo62820e11 == '.' && cMo62820e14 == '.') || (cMo62820e11 == '-' && cMo62820e14 == '-')) {
                    c22 = cMo62820e16;
                    c20 = cMo62820e21;
                    c19 = cMo62820e12;
                    c23 = cMo62820e9;
                    i17 = 10;
                    c25 = cMo62820e13;
                    c21 = cMo62820e15;
                    c24 = cMo62820e20;
                } else if (cMo62820e20 == 'T') {
                    c19 = cMo62820e13;
                    c25 = cMo62820e14;
                    c21 = cMo62820e9;
                    c22 = cMo62820e10;
                    i17 = 8;
                    cMo62820e10 = cMo62820e16;
                    c20 = cMo62820e12;
                    c23 = cMo62820e15;
                    c24 = cMo62820e11;
                } else {
                    if (cMo62820e13 != 24180 && cMo62820e13 != 45380) {
                        return false;
                    }
                    if (cMo62820e16 != 26376 && cMo62820e16 != 50900) {
                        if (cMo62820e15 != 26376 && cMo62820e15 != 50900) {
                            return false;
                        }
                        if (cMo62820e20 == 26085 || cMo62820e20 == 51068) {
                            c24 = cMo62820e11;
                            c25 = cMo62820e14;
                            c21 = cMo62820e9;
                            c22 = cMo62820e10;
                            i17 = 10;
                            c19 = '0';
                            cMo62820e10 = cMo62820e16;
                            c20 = cMo62820e12;
                            c23 = '0';
                        } else {
                            if (cMo62820e21 != 26085 && cMo62820e21 != 51068) {
                                return false;
                            }
                            c24 = cMo62820e11;
                            c21 = cMo62820e9;
                            i17 = 10;
                            c19 = '0';
                            c25 = cMo62820e14;
                            c22 = cMo62820e10;
                            cMo62820e10 = cMo62820e20;
                            c23 = cMo62820e16;
                            c20 = cMo62820e12;
                        }
                    } else if (cMo62820e21 == 26085 || cMo62820e21 == 51068) {
                        c19 = cMo62820e14;
                        c20 = cMo62820e12;
                        c21 = cMo62820e9;
                        c22 = cMo62820e10;
                        i17 = 10;
                        c23 = '0';
                        cMo62820e10 = cMo62820e20;
                        c25 = cMo62820e15;
                        c24 = cMo62820e11;
                    } else {
                        if (mo62820e(this.f49204e + 10) != 26085 && mo62820e(this.f49204e + 10) != 51068) {
                            return false;
                        }
                        c20 = cMo62820e12;
                        c21 = cMo62820e9;
                        i17 = 11;
                        c23 = cMo62820e20;
                        c25 = cMo62820e15;
                        c24 = cMo62820e11;
                        c19 = cMo62820e14;
                        c22 = cMo62820e10;
                        cMo62820e10 = cMo62820e21;
                    }
                }
                if (!m62835r1(c21, c22, c24, c20, c19, c25, c23, cMo62820e10)) {
                    return false;
                }
                m62840w1(c21, c22, c24, c20, c19, c25, c23, cMo62820e10);
                char cMo62820e22 = mo62820e(this.f49204e + i17);
                char c26 = 'T';
                if (cMo62820e22 == 'T') {
                    if (i10 == 16 && i17 == 8 && mo62820e(this.f49204e + 15) == 'Z') {
                        char cMo62820e23 = mo62820e(this.f49204e + i17 + 1);
                        char cMo62820e24 = mo62820e(this.f49204e + i17 + 2);
                        char cMo62820e25 = mo62820e(this.f49204e + i17 + 3);
                        char cMo62820e26 = mo62820e(this.f49204e + i17 + 4);
                        char cMo62820e27 = mo62820e(this.f49204e + i17 + 5);
                        char cMo62820e28 = mo62820e(this.f49204e + i17 + 6);
                        if (!m62836s1(cMo62820e23, cMo62820e24, cMo62820e25, cMo62820e26, cMo62820e27, cMo62820e28)) {
                            return false;
                        }
                        m62841x1(cMo62820e23, cMo62820e24, cMo62820e25, cMo62820e26, cMo62820e27, cMo62820e28);
                        this.f49210k.set(14, 0);
                        if (this.f49210k.getTimeZone().getRawOffset() != 0) {
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.f49210k.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                            }
                        }
                        this.f49200a = 5;
                        return true;
                    }
                    c26 = 'T';
                }
                if (cMo62820e22 != c26 && (cMo62820e22 != ' ' || z10)) {
                    if (cMo62820e22 == '\"' || cMo62820e22 == 26 || cMo62820e22 == 26085 || cMo62820e22 == 51068) {
                        this.f49210k.set(11, 0);
                        this.f49210k.set(12, 0);
                        this.f49210k.set(13, 0);
                        this.f49210k.set(14, 0);
                        int i26 = this.f49204e + i17;
                        this.f49204e = i26;
                        this.f49203d = mo62820e(i26);
                        this.f49200a = 5;
                        return true;
                    }
                    if ((cMo62820e22 != '+' && cMo62820e22 != '-') || this.f49221u != i17 + 6 || mo62820e(this.f49204e + i17 + 3) != ':' || mo62820e(this.f49204e + i17 + 4) != '0' || mo62820e(this.f49204e + i17 + 5) != '0') {
                        return false;
                    }
                    m62841x1('0', '0', '0', '0', '0', '0');
                    this.f49210k.set(14, 0);
                    m62842y1(cMo62820e22, mo62820e(this.f49204e + i17 + 1), mo62820e(this.f49204e + i17 + 2));
                    return true;
                }
                if (i10 < i17 + 9 || mo62820e(this.f49204e + i17 + 3) != ':' || mo62820e(this.f49204e + i17 + 6) != ':') {
                    return false;
                }
                char cMo62820e29 = mo62820e(this.f49204e + i17 + 1);
                char cMo62820e30 = mo62820e(this.f49204e + i17 + 2);
                char cMo62820e31 = mo62820e(this.f49204e + i17 + 4);
                char cMo62820e32 = mo62820e(this.f49204e + i17 + 5);
                char cMo62820e33 = mo62820e(this.f49204e + i17 + 7);
                char cMo62820e34 = mo62820e(this.f49204e + i17 + 8);
                if (!m62836s1(cMo62820e29, cMo62820e30, cMo62820e31, cMo62820e32, cMo62820e33, cMo62820e34)) {
                    return false;
                }
                m62841x1(cMo62820e29, cMo62820e30, cMo62820e31, cMo62820e32, cMo62820e33, cMo62820e34);
                if (mo62820e(this.f49204e + i17 + 9) == '.') {
                    int i27 = i17 + 11;
                    if (i10 < i27 || (cMo62820e5 = mo62820e(this.f49204e + i17 + 10)) < '0' || cMo62820e5 > '9') {
                        return false;
                    }
                    int i28 = cMo62820e5 - '0';
                    if (i10 <= i27 || (cMo62820e7 = mo62820e(this.f49204e + i17 + 11)) < '0' || cMo62820e7 > '9') {
                        i18 = 1;
                    } else {
                        i28 = (i28 * 10) + (cMo62820e7 - '0');
                        i18 = 2;
                    }
                    if (i18 != 2 || (cMo62820e6 = mo62820e(this.f49204e + i17 + 12)) < '0' || cMo62820e6 > '9') {
                        i19 = i28;
                    } else {
                        i19 = (cMo62820e6 - '0') + (i28 * 10);
                        i18 = 3;
                    }
                } else {
                    i18 = -1;
                    i19 = 0;
                }
                this.f49210k.set(14, i19);
                char cMo62820e35 = mo62820e(this.f49204e + i17 + 10 + i18);
                if (cMo62820e35 == ' ') {
                    i18++;
                    cMo62820e35 = mo62820e(this.f49204e + i17 + 10 + i18);
                }
                char c27 = cMo62820e35;
                if (c27 == '+' || c27 == '-') {
                    char cMo62820e36 = mo62820e(this.f49204e + i17 + 10 + i18 + 1);
                    if (cMo62820e36 < '0' || cMo62820e36 > '1' || (cMo62820e3 = mo62820e(this.f49204e + i17 + 10 + i18 + 2)) < '0' || cMo62820e3 > '9') {
                        return false;
                    }
                    char cMo62820e37 = mo62820e(this.f49204e + i17 + 10 + i18 + 3);
                    char c28 = '3';
                    if (cMo62820e37 == ':') {
                        char cMo62820e38 = mo62820e(this.f49204e + i17 + 10 + i18 + 4);
                        cMo62820e4 = mo62820e(this.f49204e + i17 + 10 + i18 + 5);
                        if (cMo62820e38 == '4' && cMo62820e4 == '5') {
                            if (cMo62820e36 != '1' || (cMo62820e3 != '2' && cMo62820e3 != '3')) {
                                if (cMo62820e36 != '0') {
                                    return false;
                                }
                                if (cMo62820e3 != '5' && cMo62820e3 != '8') {
                                    return false;
                                }
                            }
                        } else if ((cMo62820e38 != '0' && cMo62820e38 != '3') || cMo62820e4 != '0') {
                            return false;
                        }
                        c28 = cMo62820e38;
                        i20 = 6;
                    } else {
                        if (cMo62820e37 == '0') {
                            char cMo62820e39 = mo62820e(this.f49204e + i17 + 10 + i18 + 4);
                            if (cMo62820e39 != '0' && cMo62820e39 != '3') {
                                return false;
                            }
                            c28 = cMo62820e39;
                        } else {
                            if (cMo62820e37 != '3' || mo62820e(this.f49204e + i17 + 10 + i18 + 4) != '0') {
                                if (cMo62820e37 == '4' && mo62820e(this.f49204e + i17 + 10 + i18 + 4) == '5') {
                                    cMo62820e4 = '5';
                                    i20 = 5;
                                    c28 = '4';
                                } else {
                                    c28 = '0';
                                }
                            }
                            cMo62820e4 = '0';
                        }
                        i20 = 5;
                        cMo62820e4 = '0';
                    }
                    m62843z1(c27, cMo62820e36, cMo62820e3, c28, cMo62820e4);
                } else if (c27 == 'Z') {
                    if (this.f49210k.getTimeZone().getRawOffset() != 0) {
                        String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                        if (availableIDs2.length > 0) {
                            this.f49210k.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                        }
                    }
                    i20 = 1;
                } else {
                    i20 = 0;
                }
                int i29 = i17 + 10 + i18 + i20;
                char cMo62820e40 = mo62820e(this.f49204e + i29);
                if (cMo62820e40 != 26 && cMo62820e40 != '\"') {
                    return false;
                }
                int i30 = this.f49204e + i29;
                this.f49204e = i30;
                this.f49203d = mo62820e(i30);
                this.f49200a = 5;
                return true;
            }
            z11 = false;
            c10 = ':';
            i11 = 5;
        }
        if (z10) {
            return z11;
        }
        char cMo62820e41 = mo62820e(this.f49204e + 8);
        boolean z12 = cMo62820e13 == '-' && cMo62820e16 == '-';
        boolean z13 = z12 && i10 == 16;
        boolean z14 = z12 && i10 == 17;
        if (z14 || z13) {
            cMo62820e = mo62820e(this.f49204e + 9);
            c11 = cMo62820e14;
            c12 = cMo62820e15;
            c13 = cMo62820e41;
        } else if (cMo62820e13 == '-' && cMo62820e15 == '-') {
            c12 = cMo62820e14;
            cMo62820e = cMo62820e16;
            c11 = '0';
            c13 = '0';
        } else {
            c11 = cMo62820e13;
            c12 = cMo62820e14;
            c13 = cMo62820e15;
            cMo62820e = cMo62820e16;
        }
        if (!m62835r1(cMo62820e9, cMo62820e10, cMo62820e11, cMo62820e12, c11, c12, c13, cMo62820e)) {
            return false;
        }
        m62840w1(cMo62820e9, cMo62820e10, cMo62820e11, cMo62820e12, c11, c12, c13, cMo62820e);
        if (i10 != 8) {
            char cMo62820e42 = mo62820e(this.f49204e + 9);
            char cMo62820e43 = mo62820e(this.f49204e + 10);
            char cMo62820e44 = mo62820e(this.f49204e + 11);
            char cMo62820e45 = mo62820e(this.f49204e + 12);
            char cMo62820e46 = mo62820e(this.f49204e + 13);
            if ((z14 && cMo62820e43 == 'T' && cMo62820e46 == c10 && mo62820e(this.f49204e + 16) == 'Z') || (z13 && ((cMo62820e43 == ' ' || cMo62820e43 == 'T') && cMo62820e46 == c10))) {
                char cMo62820e47 = mo62820e(this.f49204e + 14);
                cMo62820e2 = mo62820e(this.f49204e + 15);
                c15 = cMo62820e47;
                c17 = cMo62820e44;
                c14 = cMo62820e45;
                c18 = '0';
                c16 = '0';
            } else {
                c14 = cMo62820e42;
                c15 = cMo62820e43;
                cMo62820e2 = cMo62820e44;
                c16 = cMo62820e46;
                c17 = cMo62820e41;
                c18 = cMo62820e45;
            }
            if (!m62836s1(c17, c14, c15, cMo62820e2, c18, c16)) {
                return false;
            }
            if (i10 != 17 || z14) {
                i16 = 0;
            } else {
                char cMo62820e48 = mo62820e(this.f49204e + 14);
                char cMo62820e49 = mo62820e(this.f49204e + 15);
                char cMo62820e50 = mo62820e(this.f49204e + 16);
                if (cMo62820e48 < '0' || cMo62820e48 > '9' || cMo62820e49 < '0' || cMo62820e49 > '9' || cMo62820e50 < '0' || cMo62820e50 > '9') {
                    return false;
                }
                i16 = ((cMo62820e48 - '0') * 100) + ((cMo62820e49 - '0') * 10) + (cMo62820e50 - '0');
            }
            i13 = ((c18 - '0') * 10) + (c16 - '0');
            i15 = ((c17 - '0') * 10) + (c14 - '0');
            i14 = i16;
            i12 = ((c15 - '0') * 10) + (cMo62820e2 - '0');
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        this.f49210k.set(11, i15);
        this.f49210k.set(12, i12);
        this.f49210k.set(13, i13);
        this.f49210k.set(14, i14);
        this.f49200a = i11;
        return true;
    }

    /* renamed from: w1 */
    public final void m62840w1(char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17) {
        Calendar calendar = Calendar.getInstance(this.f49211l, this.f49212m);
        this.f49210k = calendar;
        calendar.set(1, ((c10 - '0') * 1000) + ((c11 - '0') * 100) + ((c12 - '0') * 10) + (c13 - '0'));
        this.f49210k.set(2, (((c14 - '0') * 10) + (c15 - '0')) - 1);
        this.f49210k.set(5, ((c16 - '0') * 10) + (c17 - '0'));
    }

    /* renamed from: x1 */
    public void m62841x1(char c10, char c11, char c12, char c13, char c14, char c15) {
        this.f49210k.set(11, ((c10 - '0') * 10) + (c11 - '0'));
        this.f49210k.set(12, ((c12 - '0') * 10) + (c13 - '0'));
        this.f49210k.set(13, ((c14 - '0') * 10) + (c15 - '0'));
    }

    /* renamed from: y1 */
    public void m62842y1(char c10, char c11, char c12) {
        m62843z1(c10, c11, c12, '0', '0');
    }

    /* renamed from: z1 */
    public void m62843z1(char c10, char c11, char c12, char c13, char c14) {
        int i10 = ((((c11 - '0') * 10) + (c12 - '0')) * 3600000) + ((((c13 - '0') * 10) + (c14 - '0')) * 60000);
        if (c10 == '-') {
            i10 = -i10;
        }
        if (this.f49210k.getTimeZone().getRawOffset() != i10) {
            this.f49210k.setTimeZone(new SimpleTimeZone(i10, Integer.toString(i10)));
        }
    }

    public C10082f(String str, int i10) {
        super(i10);
        this.f49220t = str;
        this.f49221u = str.length();
        this.f49204e = -1;
        next();
        if (this.f49203d == 65279) {
            next();
        }
    }
}
