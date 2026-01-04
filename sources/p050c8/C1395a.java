package p050c8;

/* renamed from: c8.a */
/* loaded from: classes2.dex */
public class C1395a {

    /* renamed from: a */
    public String f5954a;

    /* renamed from: b */
    public int f5955b;

    /* renamed from: c */
    public long f5956c;

    /* renamed from: d */
    public int f5957d;

    /* renamed from: e */
    public int f5958e;

    /* renamed from: f */
    public int f5959f;

    /* renamed from: g */
    public int f5960g;

    /* renamed from: a */
    public void m7968a(int i10) {
        this.f5959f += i10;
    }

    /* renamed from: b */
    public void m7969b(int i10) {
        this.f5960g += i10;
    }

    /* renamed from: c */
    public void m7970c(int i10) {
        this.f5958e += i10;
    }

    /* renamed from: d */
    public void m7971d(int i10) {
        this.f5957d += i10;
    }

    /* renamed from: e */
    public String m7972e() {
        return this.f5954a;
    }

    /* renamed from: f */
    public int m7973f() {
        return this.f5959f;
    }

    /* renamed from: g */
    public int m7974g() {
        return this.f5960g;
    }

    /* renamed from: h */
    public int m7975h() {
        return this.f5958e;
    }

    /* renamed from: i */
    public int m7976i() {
        return this.f5957d;
    }

    /* renamed from: j */
    public long m7977j() {
        return this.f5956c;
    }

    /* renamed from: k */
    public int m7978k() {
        return this.f5955b;
    }

    /* renamed from: l */
    public boolean m7979l() {
        return this.f5957d == (this.f5958e + this.f5959f) + this.f5960g;
    }

    /* renamed from: m */
    public boolean m7980m() {
        return this.f5957d == this.f5958e;
    }

    /* renamed from: n */
    public void m7981n(int i10) {
        int i11 = this.f5957d - i10;
        this.f5957d = i11;
        if (i11 < 0) {
            this.f5957d = 0;
        }
    }

    /* renamed from: o */
    public void m7982o() {
        this.f5955b = 0;
        this.f5957d = 0;
        this.f5958e = 0;
        this.f5959f = 0;
        this.f5960g = 0;
        this.f5956c = 0L;
    }

    /* renamed from: p */
    public void m7983p() {
        this.f5959f = 0;
        this.f5960g = 0;
        this.f5956c = 0L;
    }

    /* renamed from: q */
    public void m7984q(String str) {
        this.f5954a = str;
    }

    /* renamed from: r */
    public void m7985r(long j10) {
        this.f5956c = j10;
    }

    /* renamed from: s */
    public void m7986s(int i10) {
        this.f5955b = i10;
    }

    public String toString() {
        return "UploadProgress{albumId='" + this.f5954a + "', uploadState=" + this.f5955b + ", uploadSpeed=" + this.f5956c + ", totalNum=" + this.f5957d + ", succeedNum=" + this.f5958e + ", failedNum=" + this.f5959f + ", pausedNum=" + this.f5960g + '}';
    }
}
