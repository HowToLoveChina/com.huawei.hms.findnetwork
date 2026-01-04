package p455ll;

import java.util.Objects;

/* renamed from: ll.e */
/* loaded from: classes6.dex */
public class C11312e implements Comparable<C11312e> {

    /* renamed from: a */
    public String f52987a;

    /* renamed from: b */
    public int f52988b;

    /* renamed from: c */
    public String f52989c;

    /* renamed from: d */
    public String f52990d;

    /* renamed from: e */
    public Long f52991e;

    /* renamed from: f */
    public long f52992f;

    /* renamed from: g */
    public int f52993g;

    /* renamed from: h */
    public String f52994h;

    /* renamed from: i */
    public long f52995i = -1;

    /* renamed from: j */
    public String f52996j;

    /* renamed from: k */
    public String f52997k;

    /* renamed from: l */
    public String f52998l;

    /* renamed from: m */
    public String f52999m;

    /* renamed from: n */
    public String f53000n;

    /* renamed from: A */
    public C11312e m67944A(String str) {
        this.f53000n = str;
        return this;
    }

    /* renamed from: B */
    public C11312e m67945B(String str) {
        this.f52990d = str;
        return this;
    }

    /* renamed from: C */
    public C11312e m67946C(String str) {
        this.f52987a = str;
        return this;
    }

    /* renamed from: D */
    public C11312e m67947D(long j10) {
        this.f52992f = j10;
        return this;
    }

    /* renamed from: E */
    public C11312e m67948E(int i10) {
        this.f52988b = i10;
        return this;
    }

    /* renamed from: F */
    public C11312e m67949F(String str) {
        this.f52989c = str;
        return this;
    }

    /* renamed from: G */
    public C11312e m67950G(String str) {
        this.f52994h = str;
        return this;
    }

    /* renamed from: H */
    public C11312e m67951H(Long l10) {
        this.f52991e = l10;
        return this;
    }

    /* renamed from: I */
    public C11312e m67952I(int i10) {
        this.f52993g = i10;
        return this;
    }

    /* renamed from: J */
    public C11312e m67953J(long j10) {
        this.f52995i = j10;
        return this;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C11312e c11312e) {
        return Integer.compare(this.f52988b, c11312e.f52988b);
    }

    /* renamed from: a0 */
    public int m67955a0() {
        return this.f52988b;
    }

    /* renamed from: b */
    public String m67956b() {
        String str = this.f52996j;
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public String m67957e() {
        String str = this.f52997k;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C11312e c11312e = (C11312e) obj;
        return this.f52988b == c11312e.f52988b && this.f52992f == c11312e.f52992f && Objects.equals(this.f52987a, c11312e.f52987a) && Objects.equals(this.f52989c, c11312e.f52989c) && Objects.equals(this.f52991e, c11312e.f52991e);
    }

    /* renamed from: f */
    public String m67958f() {
        String str = this.f52998l;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public String m67959h() {
        String str = this.f52999m;
        return str == null ? "" : str;
    }

    public int hashCode() {
        return Objects.hash(this.f52987a, Integer.valueOf(this.f52988b), this.f52989c, this.f52991e, Long.valueOf(this.f52992f));
    }

    /* renamed from: i */
    public String m67960i() {
        String str = this.f53000n;
        return str == null ? "" : str;
    }

    /* renamed from: k */
    public String m67961k() {
        String str = this.f52990d;
        return str == null ? "" : str;
    }

    /* renamed from: p */
    public String m67962p() {
        String str = this.f52987a;
        return str == null ? "" : str;
    }

    /* renamed from: q */
    public long m67963q() {
        return this.f52992f;
    }

    /* renamed from: r */
    public String m67964r() {
        String str = this.f52989c;
        return str == null ? "" : str;
    }

    /* renamed from: s */
    public String m67965s() {
        String str = this.f52994h;
        return str == null ? "" : str;
    }

    /* renamed from: t */
    public Long m67966t() {
        return this.f52991e;
    }

    /* renamed from: u */
    public int m67967u() {
        return this.f52993g;
    }

    /* renamed from: v */
    public long m67968v() {
        return this.f52995i;
    }

    /* renamed from: w */
    public C11312e m67969w(String str) {
        this.f52996j = str;
        return this;
    }

    /* renamed from: x */
    public C11312e m67970x(String str) {
        this.f52997k = str;
        return this;
    }

    /* renamed from: y */
    public C11312e m67971y(String str) {
        this.f52998l = str;
        return this;
    }

    /* renamed from: z */
    public C11312e m67972z(String str) {
        this.f52999m = str;
        return this;
    }
}
