package p225dd;

import java.util.Objects;

/* renamed from: dd.b */
/* loaded from: classes3.dex */
public class C9066b implements Comparable<C9066b> {

    /* renamed from: a */
    public String f45781a;

    /* renamed from: b */
    public int f45782b;

    /* renamed from: c */
    public String f45783c;

    /* renamed from: d */
    public long f45784d;

    /* renamed from: e */
    public long f45785e;

    /* renamed from: f */
    public int f45786f;

    /* renamed from: g */
    public String f45787g;

    /* renamed from: h */
    public String f45788h;

    /* renamed from: i */
    public String f45789i;

    /* renamed from: j */
    public String f45790j;

    /* renamed from: k */
    public String f45791k;

    /* renamed from: l */
    public String f45792l;

    /* renamed from: A */
    public C9066b m57167A(long j10) {
        this.f45784d = j10;
        return this;
    }

    /* renamed from: B */
    public C9066b m57168B(int i10) {
        this.f45786f = i10;
        return this;
    }

    /* renamed from: C */
    public C9066b m57169C(String str) {
        this.f45787g = str;
        return this;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C9066b c9066b) {
        return Integer.compare(this.f45782b, c9066b.f45782b);
    }

    /* renamed from: a0 */
    public int m57171a0() {
        return this.f45782b;
    }

    /* renamed from: b */
    public String m57172b() {
        String str = this.f45788h;
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public String m57173e() {
        String str = this.f45789i;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C9066b c9066b = (C9066b) obj;
        return this.f45782b == c9066b.f45782b && this.f45785e == c9066b.f45785e && Objects.equals(this.f45781a, c9066b.f45781a) && Objects.equals(this.f45783c, c9066b.f45783c) && Long.valueOf(this.f45784d).equals(Long.valueOf(c9066b.f45784d));
    }

    /* renamed from: f */
    public String m57174f() {
        String str = this.f45790j;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public String m57175h() {
        String str = this.f45791k;
        return str == null ? "" : str;
    }

    public int hashCode() {
        return Objects.hash(this.f45781a, Integer.valueOf(this.f45782b), this.f45783c, Long.valueOf(this.f45784d), Long.valueOf(this.f45785e));
    }

    /* renamed from: i */
    public String m57176i() {
        String str = this.f45792l;
        return str == null ? "" : str;
    }

    /* renamed from: k */
    public String m57177k() {
        return this.f45781a;
    }

    /* renamed from: p */
    public long m57178p() {
        return this.f45785e;
    }

    /* renamed from: q */
    public String m57179q() {
        return this.f45783c;
    }

    /* renamed from: r */
    public long m57180r() {
        return this.f45784d;
    }

    /* renamed from: s */
    public int m57181s() {
        return this.f45786f;
    }

    /* renamed from: t */
    public String m57182t() {
        return this.f45787g;
    }

    /* renamed from: u */
    public boolean m57183u() {
        int i10 = this.f45786f;
        return i10 >= 200 && i10 < 300;
    }

    /* renamed from: v */
    public C9066b m57184v(String str) {
        this.f45788h = str;
        return this;
    }

    /* renamed from: w */
    public C9066b m57185w(String str) {
        this.f45781a = str;
        return this;
    }

    /* renamed from: x */
    public C9066b m57186x(long j10) {
        this.f45785e = j10;
        return this;
    }

    /* renamed from: y */
    public C9066b m57187y(int i10) {
        this.f45782b = i10;
        return this;
    }

    /* renamed from: z */
    public C9066b m57188z(String str) {
        this.f45783c = str;
        return this;
    }
}
