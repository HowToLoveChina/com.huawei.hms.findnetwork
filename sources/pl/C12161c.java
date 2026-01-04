package pl;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: pl.c */
/* loaded from: classes6.dex */
public class C12161c implements Serializable {
    private static final long serialVersionUID = -2336905440052637757L;

    /* renamed from: d */
    public long f56409d;

    /* renamed from: e */
    public long f56410e;

    /* renamed from: f */
    public long f56411f;

    /* renamed from: k */
    public int f56416k;

    /* renamed from: l */
    public long f56417l;

    /* renamed from: m */
    public long f56418m;

    /* renamed from: r */
    public int f56423r;

    /* renamed from: s */
    public long f56424s;

    /* renamed from: u */
    public long f56426u;

    /* renamed from: v */
    public long f56427v;

    /* renamed from: w */
    public long f56428w;

    /* renamed from: x */
    public long f56429x;

    /* renamed from: y */
    public long f56430y;

    /* renamed from: a */
    public String f56406a = "";

    /* renamed from: b */
    public String f56407b = "";

    /* renamed from: c */
    public String f56408c = "";

    /* renamed from: g */
    public String f56412g = "";

    /* renamed from: h */
    public String f56413h = "";

    /* renamed from: i */
    public String f56414i = "";

    /* renamed from: j */
    public String f56415j = "";

    /* renamed from: n */
    public String f56419n = "";

    /* renamed from: o */
    public String f56420o = "";

    /* renamed from: p */
    public String f56421p = "";

    /* renamed from: q */
    public String f56422q = "";

    /* renamed from: t */
    public String f56425t = "";

    /* renamed from: z */
    public String f56431z = "";

    /* renamed from: A */
    public String f56400A = "";

    /* renamed from: B */
    public String f56401B = "";

    /* renamed from: C */
    public String f56402C = "";

    /* renamed from: D */
    public String f56403D = "";

    /* renamed from: E */
    public String f56404E = "";

    /* renamed from: F */
    public String f56405F = "";

    /* renamed from: A */
    public String m72945A() {
        String str = this.f56414i;
        return str == null ? "" : str;
    }

    /* renamed from: B */
    public String m72946B() {
        String str = this.f56415j;
        return str == null ? "" : str;
    }

    /* renamed from: C */
    public long m72947C() {
        return this.f56410e;
    }

    /* renamed from: D */
    public String m72948D() {
        return this.f56408c;
    }

    /* renamed from: E */
    public long m72949E() {
        return this.f56411f;
    }

    /* renamed from: F */
    public String m72950F() {
        String str = this.f56407b;
        return str == null ? "" : str;
    }

    /* renamed from: G */
    public long m72951G() {
        return this.f56417l;
    }

    /* renamed from: H */
    public int m72952H() {
        return this.f56416k;
    }

    /* renamed from: I */
    public long m72953I() {
        return this.f56409d;
    }

    /* renamed from: J */
    public String m72954J() {
        String str = this.f56422q;
        return str == null ? "" : str;
    }

    /* renamed from: K */
    public boolean m72955K() {
        return this.f56426u == 1;
    }

    /* renamed from: L */
    public void m72956L(String str) {
        this.f56412g = str;
    }

    /* renamed from: M */
    public void m72957M(String str) {
        this.f56413h = str;
    }

    /* renamed from: N */
    public void m72958N(String str) {
        this.f56421p = str;
    }

    /* renamed from: O */
    public void m72959O(long j10) {
        this.f56426u = j10;
    }

    /* renamed from: P */
    public void m72960P(String str) {
        this.f56425t = str;
    }

    /* renamed from: Q */
    public void m72961Q(String str) {
        this.f56419n = str;
    }

    /* renamed from: R */
    public void m72962R(long j10) {
        this.f56424s = j10;
    }

    /* renamed from: S */
    public void m72963S(long j10) {
        this.f56418m = j10;
    }

    /* renamed from: T */
    public void m72964T(String str) {
        this.f56406a = str;
    }

    /* renamed from: U */
    public void m72965U(String str) {
        this.f56400A = str;
    }

    /* renamed from: V */
    public void m72966V(String str) {
        this.f56401B = str;
    }

    /* renamed from: W */
    public void m72967W(String str) {
        this.f56402C = str;
    }

    /* renamed from: X */
    public void m72968X(String str) {
        this.f56403D = str;
    }

    /* renamed from: Y */
    public void m72969Y(String str) {
        this.f56404E = str;
    }

    /* renamed from: Z */
    public void m72970Z(String str) {
        this.f56405F = str;
    }

    /* renamed from: a0 */
    public void m72971a0(long j10) {
        this.f56427v = j10;
    }

    /* renamed from: b */
    public void m72972b() {
        m73000p0(5L);
        m72996n0(0L);
        m72962R(0L);
        m72985h0("");
        m72986i0("");
        m72960P("");
        m72961Q("");
    }

    /* renamed from: b0 */
    public void m72973b0(long j10) {
        this.f56429x = j10;
    }

    /* renamed from: c */
    public String m72974c() {
        return this.f56412g;
    }

    /* renamed from: c0 */
    public void m72975c0(long j10) {
        this.f56428w = j10;
    }

    /* renamed from: d */
    public String m72976d() {
        return this.f56413h;
    }

    /* renamed from: d0 */
    public void m72977d0(long j10) {
        this.f56430y = j10;
    }

    /* renamed from: e */
    public String m72978e() {
        String str = this.f56421p;
        return str == null ? "" : str;
    }

    /* renamed from: e0 */
    public void m72979e0(String str) {
        this.f56431z = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C12161c c12161c = (C12161c) obj;
        return Objects.equals(this.f56406a, c12161c.f56406a) && Objects.equals(this.f56407b, c12161c.f56407b) && Objects.equals(this.f56412g, c12161c.f56412g);
    }

    /* renamed from: f */
    public long m72980f() {
        return this.f56426u;
    }

    /* renamed from: f0 */
    public void m72981f0(String str) {
        this.f56420o = str;
    }

    /* renamed from: g */
    public String m72982g() {
        String str = this.f56425t;
        return str == null ? "" : str;
    }

    /* renamed from: g0 */
    public void m72983g0(int i10) {
        this.f56423r = i10;
    }

    /* renamed from: h */
    public String m72984h() {
        String str = this.f56419n;
        return str == null ? "" : str;
    }

    /* renamed from: h0 */
    public void m72985h0(String str) {
        this.f56414i = str;
    }

    public int hashCode() {
        return Objects.hash(this.f56406a, this.f56407b, this.f56412g);
    }

    /* renamed from: i0 */
    public void m72986i0(String str) {
        this.f56415j = str;
    }

    /* renamed from: j */
    public long m72987j() {
        return this.f56424s;
    }

    /* renamed from: j0 */
    public void m72988j0(long j10) {
        this.f56410e = j10;
    }

    /* renamed from: k */
    public long m72989k() {
        return this.f56418m;
    }

    /* renamed from: k0 */
    public void m72990k0(String str) {
        this.f56408c = str;
    }

    /* renamed from: l */
    public String m72991l() {
        return this.f56406a;
    }

    /* renamed from: l0 */
    public void m72992l0(long j10) {
        this.f56411f = j10;
    }

    /* renamed from: m */
    public String m72993m() {
        String str = this.f56400A;
        return str == null ? "" : str;
    }

    /* renamed from: m0 */
    public void m72994m0(String str) {
        this.f56407b = str;
    }

    /* renamed from: n */
    public String m72995n() {
        String str = this.f56401B;
        return str == null ? "" : str;
    }

    /* renamed from: n0 */
    public void m72996n0(long j10) {
        this.f56417l = j10;
    }

    /* renamed from: o */
    public String m72997o() {
        String str = this.f56402C;
        return str == null ? "" : str;
    }

    /* renamed from: o0 */
    public void m72998o0(int i10) {
        this.f56416k = i10;
    }

    /* renamed from: p */
    public String m72999p() {
        String str = this.f56403D;
        return str == null ? "" : str;
    }

    /* renamed from: p0 */
    public void m73000p0(long j10) {
        this.f56409d = j10;
    }

    /* renamed from: q */
    public String m73001q() {
        String str = this.f56404E;
        return str == null ? "" : str;
    }

    /* renamed from: q0 */
    public void m73002q0(String str) {
        this.f56422q = str;
    }

    /* renamed from: r */
    public String m73003r() {
        String str = this.f56405F;
        return str == null ? "" : str;
    }

    /* renamed from: s */
    public long m73004s() {
        return this.f56427v;
    }

    /* renamed from: t */
    public long m73005t() {
        return this.f56429x;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    /* renamed from: u */
    public long m73006u() {
        return this.f56428w;
    }

    /* renamed from: v */
    public long m73007v() {
        return this.f56430y;
    }

    /* renamed from: w */
    public String m73008w() {
        String str = this.f56431z;
        return str == null ? "" : str;
    }

    /* renamed from: x */
    public String m73009x() {
        String str = this.f56420o;
        return str == null ? "" : str;
    }

    /* renamed from: y */
    public int m73010y() {
        return this.f56423r;
    }

    /* renamed from: z */
    public String m73011z() {
        return m72950F() + m72991l();
    }
}
