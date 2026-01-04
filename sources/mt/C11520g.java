package mt;

import java.util.Objects;

/* renamed from: mt.g */
/* loaded from: classes5.dex */
public class C11520g {

    /* renamed from: a */
    public long f53445a;

    /* renamed from: b */
    public double f53446b;

    /* renamed from: c */
    public double f53447c;

    /* renamed from: d */
    public float f53448d;

    /* renamed from: e */
    public float f53449e;

    /* renamed from: f */
    public float f53450f;

    /* renamed from: g */
    public int f53451g;

    /* renamed from: h */
    public int f53452h;

    /* renamed from: i */
    public int f53453i;

    /* renamed from: j */
    public int f53454j;

    /* renamed from: k */
    public int f53455k;

    /* renamed from: l */
    public String f53456l;

    /* renamed from: m */
    public String f53457m;

    /* renamed from: n */
    public boolean f53458n;

    public C11520g(double d10, double d11) {
        this(d10, d11, 0.0f, 0, -1);
    }

    /* renamed from: a */
    public float m68741a() {
        return this.f53448d;
    }

    /* renamed from: b */
    public float m68742b() {
        return this.f53450f;
    }

    /* renamed from: c */
    public String m68743c() {
        return this.f53457m;
    }

    /* renamed from: d */
    public int m68744d() {
        return this.f53454j;
    }

    /* renamed from: e */
    public int m68745e() {
        return this.f53455k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11520g)) {
            return false;
        }
        C11520g c11520g = (C11520g) obj;
        boolean[] zArr = new boolean[5];
        zArr[0] = this.f53445a == c11520g.f53445a && Double.compare(c11520g.f53447c, this.f53447c) == 0 && Double.compare(c11520g.f53446b, this.f53446b) == 0;
        zArr[1] = Float.compare(c11520g.f53448d, this.f53448d) == 0 && Float.compare(c11520g.f53449e, this.f53449e) == 0 && Float.compare(c11520g.f53450f, this.f53450f) == 0;
        zArr[2] = this.f53451g == c11520g.f53451g && this.f53452h == c11520g.f53452h && this.f53453i == c11520g.f53453i;
        boolean z10 = this.f53454j == c11520g.f53454j && this.f53455k == c11520g.f53455k && Objects.equals(this.f53457m, c11520g.f53457m);
        zArr[3] = z10;
        boolean z11 = this.f53458n == c11520g.f53458n && zArr[0] && zArr[1];
        zArr[4] = z11;
        return zArr[2] && z10 && z11;
    }

    /* renamed from: f */
    public String m68746f() {
        return this.f53456l;
    }

    /* renamed from: g */
    public double m68747g() {
        return this.f53447c;
    }

    /* renamed from: h */
    public int m68748h() {
        return this.f53452h;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f53445a), Double.valueOf(this.f53447c), Double.valueOf(this.f53446b), Float.valueOf(this.f53448d), Float.valueOf(this.f53449e), Float.valueOf(this.f53450f), Integer.valueOf(this.f53451g), Integer.valueOf(this.f53452h), Integer.valueOf(this.f53453i), this.f53457m, Integer.valueOf(this.f53454j), Integer.valueOf(this.f53455k), Boolean.valueOf(this.f53458n));
    }

    /* renamed from: i */
    public int m68749i() {
        return this.f53451g;
    }

    /* renamed from: j */
    public double m68750j() {
        return this.f53446b;
    }

    /* renamed from: k */
    public float m68751k() {
        return this.f53449e;
    }

    /* renamed from: l */
    public long m68752l() {
        return this.f53445a;
    }

    /* renamed from: m */
    public boolean m68753m() {
        return this.f53458n;
    }

    /* renamed from: n */
    public int m68754n() {
        return this.f53453i;
    }

    /* renamed from: o */
    public void m68755o(float f10) {
        this.f53448d = f10;
    }

    /* renamed from: p */
    public void m68756p(String str) {
        this.f53457m = str;
    }

    /* renamed from: q */
    public void m68757q(boolean z10) {
        this.f53458n = z10;
    }

    /* renamed from: r */
    public void m68758r(int i10) {
        this.f53454j = i10;
    }

    /* renamed from: s */
    public void m68759s(int i10) {
        this.f53455k = i10;
    }

    /* renamed from: t */
    public void m68760t(String str) {
        this.f53456l = str;
    }

    public String toString() {
        return "LastLocation{timeStamp = " + this.f53445a + ", lat = " + this.f53447c + ", lon = " + this.f53446b + ", acc = " + this.f53448d + ", speed = " + this.f53449e + ", bearing = " + this.f53450f + ", locationType = " + this.f53451g + ", locationSourceType = " + this.f53452h + ", indoor = " + this.f53453i + ", buildingId = " + this.f53457m + ", floor = " + this.f53454j + ", floorAcc = " + this.f53455k + ", isEnu = " + this.f53458n + "}";
    }

    /* renamed from: u */
    public void m68761u(double d10) {
        this.f53447c = d10;
    }

    /* renamed from: v */
    public void m68762v(double d10) {
        this.f53446b = d10;
    }

    public C11520g(double d10, double d11, float f10, int i10, int i11) {
        this.f53454j = -100;
        this.f53455k = 50;
        this.f53446b = d10;
        this.f53447c = d11;
        this.f53448d = f10;
        this.f53451g = i10;
        this.f53452h = i11;
    }
}
