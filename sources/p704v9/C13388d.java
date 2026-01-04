package p704v9;

/* renamed from: v9.d */
/* loaded from: classes3.dex */
public class C13388d implements Comparable<C13388d> {

    /* renamed from: a */
    public int f60367a;

    /* renamed from: h */
    public long f60374h;

    /* renamed from: i */
    public int f60375i;

    /* renamed from: j */
    public int f60376j;

    /* renamed from: l */
    public long f60378l;

    /* renamed from: b */
    public String f60368b = "";

    /* renamed from: c */
    public String f60369c = "";

    /* renamed from: d */
    public String f60370d = "";

    /* renamed from: e */
    public String f60371e = "";

    /* renamed from: f */
    public String f60372f = "";

    /* renamed from: g */
    public String f60373g = "";

    /* renamed from: k */
    public long f60377k = -1;

    /* renamed from: m */
    public String f60379m = "";

    /* renamed from: n */
    public String f60380n = "";

    /* renamed from: o */
    public String f60381o = "";

    public C13388d(int i10) {
        this.f60367a = i10;
    }

    /* renamed from: A */
    public void m80442A(String str) {
        this.f60379m = str;
    }

    /* renamed from: B */
    public void m80443B(String str) {
        this.f60380n = str;
    }

    /* renamed from: C */
    public void m80444C(String str) {
        this.f60381o = str;
    }

    /* renamed from: D */
    public void m80445D(String str) {
        this.f60370d = str;
    }

    /* renamed from: E */
    public void m80446E(long j10) {
        this.f60378l = j10;
    }

    /* renamed from: F */
    public void m80447F(int i10) {
        this.f60375i = i10;
    }

    /* renamed from: G */
    public void m80448G(String str) {
        this.f60369c = str;
    }

    /* renamed from: H */
    public void m80449H(String str) {
        this.f60368b = str;
    }

    /* renamed from: I */
    public void m80450I(long j10) {
        this.f60374h = j10;
    }

    /* renamed from: J */
    public void m80451J(int i10) {
        this.f60376j = i10;
    }

    /* renamed from: K */
    public void m80452K(String str) {
        this.f60371e = str;
    }

    /* renamed from: L */
    public void m80453L(long j10) {
        this.f60377k = j10;
    }

    /* renamed from: M */
    public void m80454M(String str) {
        this.f60373g = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C13388d c13388d) {
        int i10 = this.f60375i;
        int i11 = c13388d.f60375i;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    /* renamed from: b */
    public String m80456b() {
        return this.f60372f;
    }

    /* renamed from: e */
    public String m80457e() {
        return this.f60379m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C13388d c13388d = (C13388d) obj;
        if (this.f60367a != c13388d.f60367a || this.f60375i != c13388d.f60375i || !this.f60368b.equals(c13388d.f60368b) || !this.f60369c.equals(c13388d.f60369c) || !this.f60370d.equals(c13388d.f60370d)) {
            return false;
        }
        m80451J(c13388d.f60376j);
        m80453L(c13388d.f60377k);
        m80446E(c13388d.f60378l);
        m80442A(c13388d.f60379m);
        return true;
    }

    /* renamed from: f */
    public String m80458f() {
        return this.f60380n;
    }

    /* renamed from: h */
    public String m80459h() {
        return this.f60381o;
    }

    public int hashCode() {
        return (((((((this.f60367a * 31) + this.f60368b.hashCode()) * 31) + this.f60369c.hashCode()) * 31) + this.f60370d.hashCode()) * 31) + this.f60375i;
    }

    /* renamed from: i */
    public int m80460i() {
        return this.f60367a;
    }

    /* renamed from: k */
    public String m80461k() {
        return this.f60370d;
    }

    /* renamed from: p */
    public long m80462p() {
        return this.f60378l;
    }

    /* renamed from: q */
    public int m80463q() {
        return this.f60375i;
    }

    /* renamed from: r */
    public String m80464r() {
        return this.f60369c;
    }

    /* renamed from: s */
    public String m80465s() {
        return this.f60368b;
    }

    /* renamed from: t */
    public long m80466t() {
        return this.f60374h;
    }

    /* renamed from: u */
    public int m80467u() {
        return this.f60376j;
    }

    /* renamed from: v */
    public String m80468v() {
        return this.f60371e;
    }

    /* renamed from: w */
    public long m80469w() {
        return this.f60377k;
    }

    /* renamed from: x */
    public String m80470x() {
        return this.f60373g;
    }

    /* renamed from: y */
    public void m80471y() {
        this.f60377k = -1L;
        this.f60376j = 0;
    }

    /* renamed from: z */
    public void m80472z(String str) {
        this.f60372f = str;
    }
}
