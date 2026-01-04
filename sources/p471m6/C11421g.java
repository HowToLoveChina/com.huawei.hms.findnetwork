package p471m6;

/* renamed from: m6.g */
/* loaded from: classes2.dex */
public class C11421g {

    /* renamed from: a */
    public int f53225a;

    /* renamed from: b */
    public int f53226b;

    /* renamed from: c */
    public int f53227c;

    /* renamed from: d */
    public int f53228d;

    /* renamed from: e */
    public long f53229e;

    /* renamed from: f */
    public long f53230f;

    /* renamed from: g */
    public long f53231g;

    /* renamed from: h */
    public int f53232h;

    /* renamed from: a */
    public final void m68416a() {
        long j10 = this.f53229e;
        if (j10 <= 0) {
            this.f53231g = 0L;
        } else {
            this.f53231g = (this.f53230f * 100) / j10;
        }
    }

    /* renamed from: b */
    public long m68417b() {
        return this.f53230f;
    }

    /* renamed from: c */
    public int m68418c() {
        return this.f53232h;
    }

    /* renamed from: d */
    public int m68419d() {
        return this.f53227c;
    }

    /* renamed from: e */
    public int m68420e() {
        return this.f53228d;
    }

    /* renamed from: f */
    public int m68421f() {
        return this.f53226b;
    }

    /* renamed from: g */
    public int m68422g() {
        return this.f53225a;
    }

    /* renamed from: h */
    public long m68423h() {
        return this.f53231g;
    }

    /* renamed from: i */
    public long m68424i() {
        return this.f53229e;
    }

    /* renamed from: j */
    public boolean m68425j() {
        return this.f53225a == this.f53226b;
    }

    /* renamed from: k */
    public void m68426k() {
        this.f53225a = 0;
        this.f53226b = 0;
        this.f53227c = 0;
        this.f53228d = 0;
        this.f53229e = 0L;
        this.f53230f = 0L;
        this.f53231g = 0L;
        this.f53232h = 0;
    }

    /* renamed from: l */
    public void m68427l(long j10) {
        this.f53230f = j10;
        m68416a();
    }

    /* renamed from: m */
    public void m68428m(int i10) {
        this.f53232h = i10;
    }

    /* renamed from: n */
    public void m68429n(int i10) {
        if (this.f53225a == this.f53226b + this.f53227c + this.f53228d) {
            this.f53232h = i10;
        }
    }

    /* renamed from: o */
    public void m68430o(int i10) {
        this.f53227c = i10;
    }

    /* renamed from: p */
    public void m68431p(int i10) {
        this.f53228d = i10;
    }

    /* renamed from: q */
    public void m68432q(int i10) {
        this.f53226b = i10;
    }

    /* renamed from: r */
    public void m68433r(int i10) {
        this.f53225a = i10;
    }

    /* renamed from: s */
    public void m68434s(long j10) {
        this.f53229e = j10;
        m68416a();
    }

    public String toString() {
        return "DownloadBean{totalNum=" + this.f53225a + ", succeedNum=" + this.f53226b + ", failedNum=" + this.f53227c + ", pausedNum=" + this.f53228d + ", totalSize=" + this.f53229e + ", downloadSize=" + this.f53230f + ", totalProgress=" + this.f53231g + ", downloadState=" + this.f53232h + '}';
    }
}
