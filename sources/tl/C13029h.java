package tl;

/* renamed from: tl.h */
/* loaded from: classes6.dex */
public class C13029h implements Comparable<C13029h> {

    /* renamed from: A */
    public String f59299A;

    /* renamed from: a */
    public int f59300a;

    /* renamed from: b */
    public String f59301b;

    /* renamed from: c */
    public int f59302c;

    /* renamed from: d */
    public int f59303d;

    /* renamed from: e */
    public String f59304e;

    /* renamed from: f */
    public int f59305f;

    /* renamed from: g */
    public String f59306g = "";

    /* renamed from: h */
    public String f59307h;

    /* renamed from: i */
    public int f59308i;

    /* renamed from: j */
    public String f59309j;

    /* renamed from: k */
    public long f59310k;

    /* renamed from: l */
    public long f59311l;

    /* renamed from: m */
    public long f59312m;

    /* renamed from: n */
    public long f59313n;

    /* renamed from: o */
    public long f59314o;

    /* renamed from: p */
    public long f59315p;

    /* renamed from: q */
    public String f59316q;

    /* renamed from: r */
    public String f59317r;

    /* renamed from: s */
    public int f59318s;

    /* renamed from: t */
    public long f59319t;

    /* renamed from: u */
    public long f59320u;

    /* renamed from: v */
    public String f59321v;

    /* renamed from: w */
    public String f59322w;

    /* renamed from: x */
    public String f59323x;

    /* renamed from: y */
    public String f59324y;

    /* renamed from: z */
    public String f59325z;

    public C13029h(int i10, String str) {
        this.f59300a = i10;
        this.f59301b = str;
    }

    /* renamed from: A */
    public int m78435A() {
        return this.f59303d;
    }

    /* renamed from: B */
    public String m78436B() {
        return this.f59301b;
    }

    /* renamed from: C */
    public int m78437C() {
        return this.f59318s;
    }

    /* renamed from: D */
    public long m78438D() {
        return this.f59319t;
    }

    /* renamed from: E */
    public long m78439E() {
        return this.f59310k;
    }

    /* renamed from: F */
    public long m78440F() {
        return this.f59313n;
    }

    /* renamed from: G */
    public int m78441G() {
        return this.f59302c;
    }

    /* renamed from: H */
    public int m78442H() {
        return this.f59300a;
    }

    /* renamed from: I */
    public long m78443I() {
        return this.f59312m;
    }

    /* renamed from: J */
    public String m78444J() {
        String str = this.f59307h;
        return str == null ? "" : str;
    }

    /* renamed from: K */
    public long m78445K() {
        return this.f59311l;
    }

    /* renamed from: L */
    public void m78446L(String str) {
        this.f59316q = str;
    }

    /* renamed from: M */
    public void m78447M(long j10) {
        this.f59314o = j10;
    }

    /* renamed from: N */
    public void m78448N(String str) {
        this.f59306g = str;
    }

    /* renamed from: O */
    public void m78449O(long j10) {
        this.f59320u = j10;
    }

    /* renamed from: P */
    public void m78450P(long j10) {
        this.f59315p = j10;
    }

    /* renamed from: Q */
    public void m78451Q(String str) {
        this.f59317r = str;
    }

    /* renamed from: R */
    public void m78452R(String str) {
        this.f59309j = str;
    }

    /* renamed from: S */
    public void m78453S(int i10) {
        this.f59308i = i10;
    }

    /* renamed from: T */
    public void m78454T(String str) {
        this.f59321v = str;
    }

    /* renamed from: U */
    public void m78455U(String str) {
        this.f59322w = str;
    }

    /* renamed from: V */
    public void m78456V(String str) {
        this.f59323x = str;
    }

    /* renamed from: W */
    public void m78457W(String str) {
        this.f59324y = str;
    }

    /* renamed from: X */
    public void m78458X(String str) {
        this.f59325z = str;
    }

    /* renamed from: Y */
    public void m78459Y(String str) {
        this.f59299A = str;
    }

    /* renamed from: Z */
    public void m78460Z(String str) {
        this.f59304e = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C13029h c13029h) {
        long j10 = this.f59315p;
        long j11 = c13029h.f59315p;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }

    /* renamed from: b */
    public final boolean m78462b(C13029h c13029h) {
        if (this.f59305f != c13029h.f59305f || this.f59313n != c13029h.f59313n || this.f59314o != c13029h.f59314o || this.f59315p != c13029h.f59315p || this.f59319t != c13029h.f59319t) {
            return false;
        }
        String str = this.f59301b;
        if (str == null ? c13029h.f59301b != null : !str.equals(c13029h.f59301b)) {
            return false;
        }
        String str2 = this.f59304e;
        if (str2 == null ? c13029h.f59304e != null : !str2.equals(c13029h.f59304e)) {
            return false;
        }
        String str3 = this.f59307h;
        if (str3 != null) {
            if (str3.equals(c13029h.f59307h)) {
                return true;
            }
        } else if (c13029h.f59307h == null) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public String m78463e() {
        String str = this.f59316q;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && (obj instanceof C13029h)) {
            return m78462b((C13029h) obj);
        }
        return false;
    }

    /* renamed from: f */
    public long m78464f() {
        return this.f59314o;
    }

    /* renamed from: h */
    public String m78465h() {
        String str = this.f59306g;
        return str == null ? "" : str;
    }

    public int hashCode() {
        int i10 = this.f59300a * 31;
        String str = this.f59301b;
        int iHashCode = (((((i10 + (str != null ? str.hashCode() : 0)) * 31) + this.f59302c) * 31) + this.f59303d) * 31;
        String str2 = this.f59304e;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f59305f) * 31;
        String str3 = this.f59306g;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f59307h;
        int iHashCode4 = (((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f59308i) * 31;
        String str5 = this.f59309j;
        int iHashCode5 = str5 != null ? str5.hashCode() : 0;
        long j10 = this.f59310k;
        int i11 = (((iHashCode4 + iHashCode5) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f59311l;
        int i12 = (i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f59312m;
        int i13 = (i12 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.f59313n;
        int i14 = (i13 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f59314o;
        int i15 = (i14 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f59315p;
        int i16 = (i15 + ((int) (j15 ^ (j15 >>> 32)))) * 31;
        long j16 = this.f59319t;
        int i17 = (i16 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.f59320u;
        int i18 = (i17 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        String str6 = this.f59316q;
        int iHashCode6 = (i18 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f59317r;
        int iHashCode7 = (((iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.f59318s) * 31;
        String str8 = this.f59321v;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f59322w;
        int iHashCode9 = (iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f59323x;
        int iHashCode10 = (iHashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.f59324y;
        int iHashCode11 = (iHashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.f59325z;
        int iHashCode12 = (iHashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.f59299A;
        return iHashCode12 + (str13 != null ? str13.hashCode() : 0);
    }

    /* renamed from: i */
    public long m78466i() {
        return this.f59320u;
    }

    /* renamed from: i0 */
    public void m78467i0(int i10) {
        this.f59305f = i10;
    }

    /* renamed from: j0 */
    public void m78468j0(int i10) {
        this.f59303d = i10;
    }

    /* renamed from: k */
    public long m78469k() {
        return this.f59315p;
    }

    /* renamed from: m0 */
    public void m78470m0(int i10) {
        this.f59318s = i10;
    }

    /* renamed from: n0 */
    public void m78471n0(long j10) {
        this.f59319t = j10;
    }

    /* renamed from: p */
    public String m78472p() {
        String str = this.f59317r;
        return str == null ? "" : str;
    }

    /* renamed from: p0 */
    public void m78473p0(long j10) {
        this.f59310k = j10;
    }

    /* renamed from: q */
    public String m78474q() {
        String str = this.f59309j;
        return str == null ? "" : str;
    }

    /* renamed from: q0 */
    public void m78475q0(long j10) {
        this.f59313n = j10;
    }

    /* renamed from: r */
    public int m78476r() {
        return this.f59308i;
    }

    /* renamed from: r0 */
    public void m78477r0(int i10) {
        this.f59302c = i10;
    }

    /* renamed from: s */
    public String m78478s() {
        String str = this.f59321v;
        return str == null ? "" : str;
    }

    /* renamed from: s0 */
    public void m78479s0(int i10) {
        this.f59300a = i10;
    }

    /* renamed from: t */
    public String m78480t() {
        String str = this.f59322w;
        return str == null ? "" : str;
    }

    /* renamed from: t0 */
    public void m78481t0(long j10) {
        this.f59312m = j10;
    }

    /* renamed from: u */
    public String m78482u() {
        String str = this.f59323x;
        return str == null ? "" : str;
    }

    /* renamed from: u0 */
    public void m78483u0(String str) {
        this.f59307h = str;
    }

    /* renamed from: v */
    public String m78484v() {
        String str = this.f59324y;
        return str == null ? "" : str;
    }

    /* renamed from: v0 */
    public void m78485v0(long j10) {
        this.f59311l = j10;
    }

    /* renamed from: w */
    public String m78486w() {
        String str = this.f59325z;
        return str == null ? "" : str;
    }

    /* renamed from: x */
    public String m78487x() {
        String str = this.f59299A;
        return str == null ? "" : str;
    }

    /* renamed from: y */
    public String m78488y() {
        String str = this.f59304e;
        return str == null ? "" : str;
    }

    /* renamed from: z */
    public int m78489z() {
        return this.f59305f;
    }
}
