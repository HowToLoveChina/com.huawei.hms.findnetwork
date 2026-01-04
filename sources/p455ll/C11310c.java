package p455ll;

import java.util.Objects;

/* renamed from: ll.c */
/* loaded from: classes6.dex */
public class C11310c implements Comparable<C11310c> {

    /* renamed from: a */
    public String f52976a;

    /* renamed from: b */
    public int f52977b;

    /* renamed from: c */
    public String f52978c;

    /* renamed from: d */
    public long f52979d;

    /* renamed from: e */
    public long f52980e;

    /* renamed from: f */
    public int f52981f;

    /* renamed from: g */
    public String f52982g;

    /* renamed from: h */
    public String f52983h;

    /* renamed from: i */
    public String f52984i;

    /* renamed from: j */
    public String f52985j;

    /* renamed from: k */
    public String f52986k;

    /* renamed from: A */
    public C11310c m67915A(int i10) {
        this.f52977b = i10;
        return this;
    }

    /* renamed from: B */
    public C11310c m67916B(String str) {
        this.f52978c = str;
        return this;
    }

    /* renamed from: C */
    public C11310c m67917C(long j10) {
        this.f52979d = j10;
        return this;
    }

    /* renamed from: D */
    public C11310c m67918D(int i10) {
        this.f52981f = i10;
        return this;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C11310c c11310c) {
        return Integer.compare(this.f52977b, c11310c.f52977b);
    }

    /* renamed from: a0 */
    public int m67920a0() {
        return this.f52977b;
    }

    /* renamed from: b */
    public String m67921b() {
        String str = this.f52982g;
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public String m67922e() {
        String str = this.f52983h;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C11310c c11310c = (C11310c) obj;
        return this.f52977b == c11310c.f52977b && this.f52980e == c11310c.f52980e && Objects.equals(this.f52976a, c11310c.f52976a) && Objects.equals(this.f52978c, c11310c.f52978c) && Long.valueOf(this.f52979d).equals(Long.valueOf(c11310c.f52979d));
    }

    /* renamed from: f */
    public String m67923f() {
        String str = this.f52984i;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public String m67924h() {
        String str = this.f52985j;
        return str == null ? "" : str;
    }

    public int hashCode() {
        return Objects.hash(this.f52976a, Integer.valueOf(this.f52977b), this.f52978c, Long.valueOf(this.f52979d), Long.valueOf(this.f52980e));
    }

    /* renamed from: i */
    public String m67925i() {
        String str = this.f52986k;
        return str == null ? "" : str;
    }

    /* renamed from: k */
    public String m67926k() {
        return this.f52976a;
    }

    /* renamed from: p */
    public long m67927p() {
        return this.f52980e;
    }

    /* renamed from: q */
    public String m67928q() {
        return this.f52978c;
    }

    /* renamed from: r */
    public long m67929r() {
        return this.f52979d;
    }

    /* renamed from: s */
    public int m67930s() {
        return this.f52981f;
    }

    /* renamed from: t */
    public C11310c m67931t(String str) {
        this.f52982g = str;
        return this;
    }

    /* renamed from: u */
    public C11310c m67932u(String str) {
        this.f52983h = str;
        return this;
    }

    /* renamed from: v */
    public C11310c m67933v(String str) {
        this.f52984i = str;
        return this;
    }

    /* renamed from: w */
    public C11310c m67934w(String str) {
        this.f52985j = str;
        return this;
    }

    /* renamed from: x */
    public C11310c m67935x(String str) {
        this.f52986k = str;
        return this;
    }

    /* renamed from: y */
    public C11310c m67936y(String str) {
        this.f52976a = str;
        return this;
    }

    /* renamed from: z */
    public C11310c m67937z(long j10) {
        this.f52980e = j10;
        return this;
    }
}
