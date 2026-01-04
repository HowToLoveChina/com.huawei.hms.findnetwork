package p305g1;

import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C6010m7;

/* renamed from: g1.j */
/* loaded from: classes.dex */
public class C9845j {

    /* renamed from: e */
    public static final C9845j f48385e = new C9845j(0, null, 1443168256, 1);

    /* renamed from: f */
    public static final C9845j f48386f = new C9845j(1, null, 1509950721, 1);

    /* renamed from: g */
    public static final C9845j f48387g = new C9845j(2, null, 1124075009, 1);

    /* renamed from: h */
    public static final C9845j f48388h = new C9845j(3, null, 1107297537, 1);

    /* renamed from: i */
    public static final C9845j f48389i = new C9845j(4, null, 1392510721, 1);

    /* renamed from: j */
    public static final C9845j f48390j = new C9845j(5, null, 1224736769, 1);

    /* renamed from: k */
    public static final C9845j f48391k = new C9845j(6, null, 1174536705, 1);

    /* renamed from: l */
    public static final C9845j f48392l = new C9845j(7, null, 1241579778, 1);

    /* renamed from: m */
    public static final C9845j f48393m = new C9845j(8, null, 1141048066, 1);

    /* renamed from: a */
    public final int f48394a;

    /* renamed from: b */
    public final char[] f48395b;

    /* renamed from: c */
    public final int f48396c;

    /* renamed from: d */
    public final int f48397d;

    public C9845j(int i10, char[] cArr, int i11, int i12) {
        this.f48394a = i10;
        this.f48395b = cArr;
        this.f48396c = i11;
        this.f48397d = i12;
    }

    /* renamed from: a */
    public static C9845j[] m61195a(String str) {
        char[] charArray = str.toCharArray();
        int i10 = 1;
        int i11 = 1;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1;
            char c10 = charArray[i11];
            if (c10 == ')') {
                break;
            }
            if (c10 == 'L') {
                while (true) {
                    i11 = i13 + 1;
                    if (charArray[i13] == ';') {
                        break;
                    }
                    i13 = i11;
                }
                i12++;
            } else {
                if (c10 != '[') {
                    i12++;
                }
                i11 = i13;
            }
        }
        C9845j[] c9845jArr = new C9845j[i12];
        int i14 = 0;
        while (charArray[i10] != ')') {
            C9845j c9845jM61198h = m61198h(charArray, i10);
            c9845jArr[i14] = c9845jM61198h;
            i10 += c9845jM61198h.f48397d + (c9845jM61198h.f48394a == 10 ? 2 : 0);
            i14++;
        }
        return c9845jArr;
    }

    /* renamed from: b */
    public static int m61196b(String str) {
        int i10;
        int i11 = 1;
        int i12 = 1;
        int i13 = 1;
        while (true) {
            i10 = i12 + 1;
            char cCharAt = str.charAt(i12);
            if (cCharAt == ')') {
                break;
            }
            if (cCharAt == 'L') {
                while (true) {
                    i12 = i10 + 1;
                    if (str.charAt(i10) == ';') {
                        break;
                    }
                    i10 = i12;
                }
                i13++;
            } else {
                i13 = (cCharAt == 'D' || cCharAt == 'J') ? i13 + 2 : i13 + 1;
                i12 = i10;
            }
        }
        char cCharAt2 = str.charAt(i10);
        int i14 = i13 << 2;
        if (cCharAt2 == 'V') {
            i11 = 0;
        } else if (cCharAt2 == 'D' || cCharAt2 == 'J') {
            i11 = 2;
        }
        return i14 | i11;
    }

    /* renamed from: g */
    public static C9845j m61197g(String str) {
        return m61198h(str.toCharArray(), 0);
    }

    /* renamed from: h */
    public static C9845j m61198h(char[] cArr, int i10) {
        char c10;
        char c11 = cArr[i10];
        if (c11 == 'F') {
            return f48391k;
        }
        if (c11 == 'S') {
            return f48389i;
        }
        if (c11 == 'V') {
            return f48385e;
        }
        if (c11 == 'I') {
            return f48390j;
        }
        if (c11 == 'J') {
            return f48392l;
        }
        if (c11 == 'Z') {
            return f48386f;
        }
        if (c11 != '[') {
            switch (c11) {
                case 'B':
                    return f48388h;
                case 'C':
                    return f48387g;
                case 'D':
                    return f48393m;
                default:
                    int i11 = 1;
                    while (cArr[i10 + i11] != ';') {
                        i11++;
                    }
                    return new C9845j(10, cArr, i10 + 1, i11 - 1);
            }
        }
        int i12 = 1;
        while (true) {
            c10 = cArr[i10 + i12];
            if (c10 != '[') {
                break;
            }
            i12++;
        }
        if (c10 == 'L') {
            do {
                i12++;
            } while (cArr[i10 + i12] != ';');
        }
        return new C9845j(9, cArr, i10, i12 + 1);
    }

    /* renamed from: c */
    public String m61199c() {
        switch (this.f48394a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb2 = new StringBuilder(m61198h(this.f48395b, this.f48396c + m61201e()).m61199c());
                for (int iM61201e = m61201e(); iM61201e > 0; iM61201e--) {
                    sb2.append(C6010m7.f27500n);
                }
                return sb2.toString();
            default:
                return new String(this.f48395b, this.f48396c, this.f48397d).replace(C5929g4.f26852n, '.');
        }
    }

    /* renamed from: d */
    public String m61200d() {
        return new String(this.f48395b, this.f48396c, this.f48397d);
    }

    /* renamed from: e */
    public final int m61201e() {
        int i10 = 1;
        while (this.f48395b[this.f48396c + i10] == '[') {
            i10++;
        }
        return i10;
    }

    /* renamed from: f */
    public String m61202f() {
        return new String(this.f48395b, this.f48396c, this.f48397d);
    }
}
