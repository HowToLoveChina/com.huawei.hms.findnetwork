package p212d0;

import android.text.SpannableStringBuilder;
import com.google.flatbuffers.reflection.BaseType;
import java.util.Locale;

/* renamed from: d0.a */
/* loaded from: classes.dex */
public final class C8969a {

    /* renamed from: d */
    public static final InterfaceC8972d f45481d;

    /* renamed from: e */
    public static final String f45482e;

    /* renamed from: f */
    public static final String f45483f;

    /* renamed from: g */
    public static final C8969a f45484g;

    /* renamed from: h */
    public static final C8969a f45485h;

    /* renamed from: a */
    public final boolean f45486a;

    /* renamed from: b */
    public final int f45487b;

    /* renamed from: c */
    public final InterfaceC8972d f45488c;

    /* renamed from: d0.a$a */
    public static final class a {

        /* renamed from: a */
        public boolean f45489a;

        /* renamed from: b */
        public int f45490b;

        /* renamed from: c */
        public InterfaceC8972d f45491c;

        public a() {
            m56757c(C8969a.m56747e(Locale.getDefault()));
        }

        /* renamed from: b */
        public static C8969a m56755b(boolean z10) {
            return z10 ? C8969a.f45485h : C8969a.f45484g;
        }

        /* renamed from: a */
        public C8969a m56756a() {
            return (this.f45490b == 2 && this.f45491c == C8969a.f45481d) ? m56755b(this.f45489a) : new C8969a(this.f45489a, this.f45490b, this.f45491c);
        }

        /* renamed from: c */
        public final void m56757c(boolean z10) {
            this.f45489a = z10;
            this.f45491c = C8969a.f45481d;
            this.f45490b = 2;
        }
    }

    /* renamed from: d0.a$b */
    public static class b {

        /* renamed from: f */
        public static final byte[] f45492f = new byte[1792];

        /* renamed from: a */
        public final CharSequence f45493a;

        /* renamed from: b */
        public final boolean f45494b;

        /* renamed from: c */
        public final int f45495c;

        /* renamed from: d */
        public int f45496d;

        /* renamed from: e */
        public char f45497e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f45492f[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f45493a = charSequence;
            this.f45494b = z10;
            this.f45495c = charSequence.length();
        }

        /* renamed from: c */
        public static byte m56758c(char c10) {
            return c10 < 1792 ? f45492f[c10] : Character.getDirectionality(c10);
        }

        /* renamed from: a */
        public byte m56759a() {
            char cCharAt = this.f45493a.charAt(this.f45496d - 1);
            this.f45497e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f45493a, this.f45496d);
                this.f45496d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f45496d--;
            byte bM56758c = m56758c(this.f45497e);
            if (!this.f45494b) {
                return bM56758c;
            }
            char c10 = this.f45497e;
            return c10 == '>' ? m56765h() : c10 == ';' ? m56763f() : bM56758c;
        }

        /* renamed from: b */
        public byte m56760b() {
            char cCharAt = this.f45493a.charAt(this.f45496d);
            this.f45497e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f45493a, this.f45496d);
                this.f45496d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f45496d++;
            byte bM56758c = m56758c(this.f45497e);
            if (!this.f45494b) {
                return bM56758c;
            }
            char c10 = this.f45497e;
            return c10 == '<' ? m56766i() : c10 == '&' ? m56764g() : bM56758c;
        }

        /* renamed from: d */
        public int m56761d() {
            this.f45496d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f45496d < this.f45495c && i10 == 0) {
                byte bM56760b = m56760b();
                if (bM56760b != 0) {
                    if (bM56760b == 1 || bM56760b == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (bM56760b != 9) {
                        switch (bM56760b) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f45496d > 0) {
                switch (m56759a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        /* renamed from: e */
        public int m56762e() {
            this.f45496d = this.f45495c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f45496d > 0) {
                    byte bM56759a = m56759a();
                    if (bM56759a != 0) {
                        if (bM56759a == 1 || bM56759a == 2) {
                            if (i10 == 0) {
                                return 1;
                            }
                            if (i11 == 0) {
                                break;
                            }
                        } else if (bM56759a != 9) {
                            switch (bM56759a) {
                                case 14:
                                case 15:
                                    if (i11 == i10) {
                                        return -1;
                                    }
                                    i10--;
                                    break;
                                case 16:
                                case 17:
                                    if (i11 == i10) {
                                        return 1;
                                    }
                                    i10--;
                                    break;
                                case 18:
                                    i10++;
                                    break;
                                default:
                                    if (i11 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i10 == 0) {
                            return -1;
                        }
                        if (i11 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }

        /* renamed from: f */
        public final byte m56763f() {
            char cCharAt;
            int i10 = this.f45496d;
            do {
                int i11 = this.f45496d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f45493a;
                int i12 = i11 - 1;
                this.f45496d = i12;
                cCharAt = charSequence.charAt(i12);
                this.f45497e = cCharAt;
                if (cCharAt == '&') {
                    return BaseType.Double;
                }
            } while (cCharAt != ';');
            this.f45496d = i10;
            this.f45497e = ';';
            return (byte) 13;
        }

        /* renamed from: g */
        public final byte m56764g() {
            char cCharAt;
            do {
                int i10 = this.f45496d;
                if (i10 >= this.f45495c) {
                    return BaseType.Double;
                }
                CharSequence charSequence = this.f45493a;
                this.f45496d = i10 + 1;
                cCharAt = charSequence.charAt(i10);
                this.f45497e = cCharAt;
            } while (cCharAt != ';');
            return BaseType.Double;
        }

        /* renamed from: h */
        public final byte m56765h() {
            char cCharAt;
            int i10 = this.f45496d;
            while (true) {
                int i11 = this.f45496d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f45493a;
                int i12 = i11 - 1;
                this.f45496d = i12;
                char cCharAt2 = charSequence.charAt(i12);
                this.f45497e = cCharAt2;
                if (cCharAt2 == '<') {
                    return BaseType.Double;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i13 = this.f45496d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f45493a;
                            int i14 = i13 - 1;
                            this.f45496d = i14;
                            cCharAt = charSequence2.charAt(i14);
                            this.f45497e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f45496d = i10;
            this.f45497e = '>';
            return (byte) 13;
        }

        /* renamed from: i */
        public final byte m56766i() {
            char cCharAt;
            int i10 = this.f45496d;
            while (true) {
                int i11 = this.f45496d;
                if (i11 >= this.f45495c) {
                    this.f45496d = i10;
                    this.f45497e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f45493a;
                this.f45496d = i11 + 1;
                char cCharAt2 = charSequence.charAt(i11);
                this.f45497e = cCharAt2;
                if (cCharAt2 == '>') {
                    return BaseType.Double;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i12 = this.f45496d;
                        if (i12 < this.f45495c) {
                            CharSequence charSequence2 = this.f45493a;
                            this.f45496d = i12 + 1;
                            cCharAt = charSequence2.charAt(i12);
                            this.f45497e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        InterfaceC8972d interfaceC8972d = C8973e.f45508c;
        f45481d = interfaceC8972d;
        f45482e = Character.toString((char) 8206);
        f45483f = Character.toString((char) 8207);
        f45484g = new C8969a(false, 2, interfaceC8972d);
        f45485h = new C8969a(true, 2, interfaceC8972d);
    }

    public C8969a(boolean z10, int i10, InterfaceC8972d interfaceC8972d) {
        this.f45486a = z10;
        this.f45487b = i10;
        this.f45488c = interfaceC8972d;
    }

    /* renamed from: a */
    public static int m56744a(CharSequence charSequence) {
        return new b(charSequence, false).m56761d();
    }

    /* renamed from: b */
    public static int m56745b(CharSequence charSequence) {
        return new b(charSequence, false).m56762e();
    }

    /* renamed from: c */
    public static C8969a m56746c() {
        return new a().m56756a();
    }

    /* renamed from: e */
    public static boolean m56747e(Locale locale) {
        return C8974f.m56783a(locale) == 1;
    }

    /* renamed from: d */
    public boolean m56748d() {
        return (this.f45487b & 2) != 0;
    }

    /* renamed from: f */
    public final String m56749f(CharSequence charSequence, InterfaceC8972d interfaceC8972d) {
        boolean zMo56777a = interfaceC8972d.mo56777a(charSequence, 0, charSequence.length());
        return (this.f45486a || !(zMo56777a || m56745b(charSequence) == 1)) ? this.f45486a ? (!zMo56777a || m56745b(charSequence) == -1) ? f45483f : "" : "" : f45482e;
    }

    /* renamed from: g */
    public final String m56750g(CharSequence charSequence, InterfaceC8972d interfaceC8972d) {
        boolean zMo56777a = interfaceC8972d.mo56777a(charSequence, 0, charSequence.length());
        return (this.f45486a || !(zMo56777a || m56744a(charSequence) == 1)) ? this.f45486a ? (!zMo56777a || m56744a(charSequence) == -1) ? f45483f : "" : "" : f45482e;
    }

    /* renamed from: h */
    public CharSequence m56751h(CharSequence charSequence) {
        return m56752i(charSequence, this.f45488c, true);
    }

    /* renamed from: i */
    public CharSequence m56752i(CharSequence charSequence, InterfaceC8972d interfaceC8972d, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean zMo56777a = interfaceC8972d.mo56777a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m56748d() && z10) {
            spannableStringBuilder.append((CharSequence) m56750g(charSequence, zMo56777a ? C8973e.f45507b : C8973e.f45506a));
        }
        if (zMo56777a != this.f45486a) {
            spannableStringBuilder.append(zMo56777a ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) m56749f(charSequence, zMo56777a ? C8973e.f45507b : C8973e.f45506a));
        }
        return spannableStringBuilder;
    }

    /* renamed from: j */
    public String m56753j(String str) {
        return m56754k(str, this.f45488c, true);
    }

    /* renamed from: k */
    public String m56754k(String str, InterfaceC8972d interfaceC8972d, boolean z10) {
        if (str == null) {
            return null;
        }
        return m56752i(str, interfaceC8972d, z10).toString();
    }
}
