package com.baidu.location.provider;

import java.util.Locale;

/* renamed from: com.baidu.location.provider.a */
/* loaded from: classes.dex */
public class C1538a {

    /* renamed from: a */
    public int f6707a;

    /* renamed from: b */
    public int f6708b;

    /* renamed from: c */
    public int f6709c;

    /* renamed from: d */
    public int f6710d;

    /* renamed from: e */
    public int f6711e;

    /* renamed from: f */
    public int f6712f;

    /* renamed from: g */
    public long f6713g;

    /* renamed from: h */
    public int f6714h;

    /* renamed from: i */
    public char f6715i;

    /* renamed from: j */
    public int f6716j;

    /* renamed from: k */
    public String f6717k;

    /* renamed from: l */
    private boolean f6718l;

    public C1538a() {
        this.f6707a = -1;
        this.f6708b = -1;
        this.f6709c = -1;
        this.f6710d = -1;
        this.f6711e = Integer.MAX_VALUE;
        this.f6712f = Integer.MAX_VALUE;
        this.f6713g = 0L;
        this.f6714h = -1;
        this.f6715i = '0';
        this.f6716j = Integer.MAX_VALUE;
        this.f6717k = null;
        this.f6718l = false;
        this.f6713g = System.currentTimeMillis();
    }

    /* renamed from: a */
    public boolean m8767a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.f6713g;
        return jCurrentTimeMillis - j10 > 0 && jCurrentTimeMillis - j10 < 3000;
    }

    /* renamed from: b */
    public boolean m8769b() {
        return this.f6707a > -1 && this.f6708b > 0;
    }

    /* renamed from: c */
    public boolean m8770c() {
        return this.f6707a == -1 && this.f6708b == -1 && this.f6710d == -1 && this.f6709c == -1;
    }

    /* renamed from: d */
    public boolean m8771d() {
        return this.f6707a > -1 && this.f6708b > -1 && this.f6710d == -1 && this.f6709c == -1;
    }

    /* renamed from: e */
    public boolean m8772e() {
        return this.f6707a > -1 && this.f6708b > -1 && this.f6710d > -1 && this.f6709c > -1;
    }

    /* renamed from: f */
    public void m8773f() {
        this.f6718l = true;
    }

    /* renamed from: g */
    public String m8774g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.f6708b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.f6707a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.f6710d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.f6709c + 203);
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public String m8775h() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(String.format(Locale.CHINA, "cell=%d|%d|%d|%d:%d", Integer.valueOf(this.f6709c), Integer.valueOf(this.f6710d), Integer.valueOf(this.f6707a), Integer.valueOf(this.f6708b), Integer.valueOf(this.f6714h)));
        return stringBuffer.toString();
    }

    /* renamed from: i */
    public String m8776i() {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(this.f6709c), Integer.valueOf(this.f6710d), Integer.valueOf(this.f6707a), Integer.valueOf(this.f6708b));
    }

    /* renamed from: j */
    public String m8777j() {
        int i10;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f6715i);
        Locale locale = Locale.CHINA;
        stringBuffer.append(String.format(locale, "&cl=%d|%d|%d|%d&cl_s=%d&cl_t=%d", Integer.valueOf(this.f6709c), Integer.valueOf(this.f6710d), Integer.valueOf(this.f6707a), Integer.valueOf(this.f6708b), Integer.valueOf(this.f6714h), Long.valueOf(this.f6713g)));
        if (this.f6716j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(this.f6716j);
        }
        if (this.f6718l) {
            stringBuffer.append("&newcl=1");
        }
        if (this.f6711e < Integer.MAX_VALUE && (i10 = this.f6712f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(locale, "&cdmall=%.6f|%.6f", Double.valueOf(i10 / 14400.0d), Double.valueOf(this.f6711e / 14400.0d)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: k */
    public String m8778k() {
        int i10;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.f6715i);
        Locale locale = Locale.CHINA;
        stringBuffer.append(String.format(locale, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6709c), Integer.valueOf(this.f6710d), Integer.valueOf(this.f6707a), Integer.valueOf(this.f6708b), Integer.valueOf(this.f6714h)));
        if (this.f6716j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.f6716j);
        }
        if (this.f6711e < Integer.MAX_VALUE && (i10 = this.f6712f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(locale, "&cdmall2=%.6f|%.6f", Double.valueOf(i10 / 14400.0d), Double.valueOf(this.f6711e / 14400.0d)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: l */
    public boolean m8779l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.f6713g;
        return jCurrentTimeMillis - j10 > 0 && jCurrentTimeMillis - j10 <= 300000;
    }

    public C1538a(int i10, int i11, int i12, int i13, int i14, char c10, int i15) {
        this.f6711e = Integer.MAX_VALUE;
        this.f6712f = Integer.MAX_VALUE;
        this.f6713g = 0L;
        this.f6716j = Integer.MAX_VALUE;
        this.f6717k = null;
        this.f6718l = false;
        this.f6707a = i10;
        this.f6708b = i11;
        this.f6709c = i12;
        this.f6710d = i13;
        this.f6714h = i14;
        this.f6715i = c10;
        this.f6713g = System.currentTimeMillis();
        this.f6716j = i15;
    }

    /* renamed from: a */
    public boolean m8768a(C1538a c1538a) {
        return this.f6707a == c1538a.f6707a && this.f6708b == c1538a.f6708b && this.f6710d == c1538a.f6710d && this.f6709c == c1538a.f6709c;
    }

    public C1538a(C1538a c1538a) {
        this(c1538a.f6707a, c1538a.f6708b, c1538a.f6709c, c1538a.f6710d, c1538a.f6714h, c1538a.f6715i, c1538a.f6716j);
        this.f6713g = c1538a.f6713g;
    }
}
