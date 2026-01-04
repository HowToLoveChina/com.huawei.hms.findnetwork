package p305g1;

/* renamed from: g1.c */
/* loaded from: classes.dex */
public class C9838c {

    /* renamed from: a */
    public int f48335a;

    /* renamed from: b */
    public int f48336b;

    /* renamed from: c */
    public final C9836a f48337c;

    /* renamed from: d */
    public C9840e[] f48338d;

    /* renamed from: e */
    public int f48339e;

    /* renamed from: f */
    public final C9840e f48340f;

    /* renamed from: g */
    public final C9840e f48341g;

    /* renamed from: h */
    public final C9840e f48342h;

    /* renamed from: i */
    public int f48343i;

    /* renamed from: j */
    public int f48344j;

    /* renamed from: k */
    public String f48345k;

    /* renamed from: l */
    public int f48346l;

    /* renamed from: m */
    public int f48347m;

    /* renamed from: n */
    public int[] f48348n;

    /* renamed from: o */
    public C9839d f48349o;

    /* renamed from: p */
    public C9839d f48350p;

    /* renamed from: q */
    public C9844i f48351q;

    /* renamed from: r */
    public C9844i f48352r;

    public C9838c() {
        this(0);
    }

    /* renamed from: a */
    public final C9840e m61159a(C9840e c9840e) {
        C9840e[] c9840eArr = this.f48338d;
        C9840e c9840e2 = c9840eArr[c9840e.f48364h % c9840eArr.length];
        while (c9840e2 != null && (c9840e2.f48358b != c9840e.f48358b || !c9840e.m61173a(c9840e2))) {
            c9840e2 = c9840e2.f48365i;
        }
        return c9840e2;
    }

    /* renamed from: b */
    public C9840e m61160b(String str) {
        this.f48341g.m61175c(7, str, null, null);
        C9840e c9840eM61159a = m61159a(this.f48341g);
        if (c9840eM61159a != null) {
            return c9840eM61159a;
        }
        this.f48337c.m61146c(7, m61166h(str));
        int i10 = this.f48336b;
        this.f48336b = i10 + 1;
        C9840e c9840e = new C9840e(i10, this.f48341g);
        m61167i(c9840e);
        return c9840e;
    }

    /* renamed from: c */
    public C9840e m61161c(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return m61165g((String) obj);
            }
            if (obj instanceof C9845j) {
                C9845j c9845j = (C9845j) obj;
                return m61160b(c9845j.f48394a == 10 ? c9845j.m61202f() : c9845j.m61200d());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f48340f.m61174b(iIntValue);
        C9840e c9840eM61159a = m61159a(this.f48340f);
        if (c9840eM61159a != null) {
            return c9840eM61159a;
        }
        this.f48337c.m61147d(3).m61149f(iIntValue);
        int i10 = this.f48336b;
        this.f48336b = i10 + 1;
        C9840e c9840e = new C9840e(i10, this.f48340f);
        m61167i(c9840e);
        return c9840e;
    }

    /* renamed from: d */
    public C9840e m61162d(String str, String str2, String str3) {
        this.f48342h.m61175c(9, str, str2, str3);
        C9840e c9840eM61159a = m61159a(this.f48342h);
        if (c9840eM61159a != null) {
            return c9840eM61159a;
        }
        int i10 = m61160b(str).f48357a;
        this.f48337c.m61146c(9, i10).m61150g(m61164f(str2, str3).f48357a);
        int i11 = this.f48336b;
        this.f48336b = i11 + 1;
        C9840e c9840e = new C9840e(i11, this.f48342h);
        m61167i(c9840e);
        return c9840e;
    }

    /* renamed from: e */
    public C9840e m61163e(String str, String str2, String str3, boolean z10) {
        int i10 = z10 ? 11 : 10;
        this.f48342h.m61175c(i10, str, str2, str3);
        C9840e c9840eM61159a = m61159a(this.f48342h);
        if (c9840eM61159a != null) {
            return c9840eM61159a;
        }
        this.f48337c.m61146c(i10, m61160b(str).f48357a).m61150g(m61164f(str2, str3).f48357a);
        int i11 = this.f48336b;
        this.f48336b = i11 + 1;
        C9840e c9840e = new C9840e(i11, this.f48342h);
        m61167i(c9840e);
        return c9840e;
    }

    /* renamed from: f */
    public C9840e m61164f(String str, String str2) {
        this.f48341g.m61175c(12, str, str2, null);
        C9840e c9840eM61159a = m61159a(this.f48341g);
        if (c9840eM61159a != null) {
            return c9840eM61159a;
        }
        int iM61166h = m61166h(str);
        this.f48337c.m61146c(12, iM61166h).m61150g(m61166h(str2));
        int i10 = this.f48336b;
        this.f48336b = i10 + 1;
        C9840e c9840e = new C9840e(i10, this.f48341g);
        m61167i(c9840e);
        return c9840e;
    }

    /* renamed from: g */
    public final C9840e m61165g(String str) {
        this.f48341g.m61175c(8, str, null, null);
        C9840e c9840eM61159a = m61159a(this.f48341g);
        if (c9840eM61159a != null) {
            return c9840eM61159a;
        }
        this.f48337c.m61146c(8, m61166h(str));
        int i10 = this.f48336b;
        this.f48336b = i10 + 1;
        C9840e c9840e = new C9840e(i10, this.f48341g);
        m61167i(c9840e);
        return c9840e;
    }

    /* renamed from: h */
    public int m61166h(String str) {
        this.f48340f.m61175c(1, str, null, null);
        C9840e c9840eM61159a = m61159a(this.f48340f);
        if (c9840eM61159a == null) {
            this.f48337c.m61147d(1).m61151h(str);
            int i10 = this.f48336b;
            this.f48336b = i10 + 1;
            c9840eM61159a = new C9840e(i10, this.f48340f);
            m61167i(c9840eM61159a);
        }
        return c9840eM61159a.f48357a;
    }

    /* renamed from: i */
    public final void m61167i(C9840e c9840e) {
        if (this.f48336b > this.f48339e) {
            int length = this.f48338d.length;
            int i10 = (length * 2) + 1;
            C9840e[] c9840eArr = new C9840e[i10];
            for (int i11 = length - 1; i11 >= 0; i11--) {
                C9840e c9840e2 = this.f48338d[i11];
                while (c9840e2 != null) {
                    int i12 = c9840e2.f48364h % i10;
                    C9840e c9840e3 = c9840e2.f48365i;
                    c9840e2.f48365i = c9840eArr[i12];
                    c9840eArr[i12] = c9840e2;
                    c9840e2 = c9840e3;
                }
            }
            this.f48338d = c9840eArr;
            this.f48339e = (int) (i10 * 0.75d);
        }
        int i13 = c9840e.f48364h;
        C9840e[] c9840eArr2 = this.f48338d;
        int length2 = i13 % c9840eArr2.length;
        c9840e.f48365i = c9840eArr2[length2];
        c9840eArr2[length2] = c9840e;
    }

    /* renamed from: j */
    public byte[] m61168j() {
        int iM61193m = (this.f48347m * 2) + 24;
        int i10 = 0;
        for (C9839d c9839d = this.f48349o; c9839d != null; c9839d = c9839d.f48353a) {
            i10++;
            iM61193m += c9839d.m61170a();
        }
        int i11 = 0;
        for (C9844i c9844i = this.f48351q; c9844i != null; c9844i = c9844i.f48375a) {
            i11++;
            iM61193m += c9844i.m61193m();
        }
        C9836a c9836a = new C9836a(iM61193m + this.f48337c.f48328b);
        c9836a.m61149f(-889275714).m61149f(this.f48335a);
        C9836a c9836aM61150g = c9836a.m61150g(this.f48336b);
        C9836a c9836a2 = this.f48337c;
        c9836aM61150g.m61148e(c9836a2.f48327a, 0, c9836a2.f48328b);
        c9836a.m61150g(this.f48343i & (-393217)).m61150g(this.f48344j).m61150g(this.f48346l);
        c9836a.m61150g(this.f48347m);
        for (int i12 = 0; i12 < this.f48347m; i12++) {
            c9836a.m61150g(this.f48348n[i12]);
        }
        c9836a.m61150g(i10);
        for (C9839d c9839d2 = this.f48349o; c9839d2 != null; c9839d2 = c9839d2.f48353a) {
            c9839d2.m61171b(c9836a);
        }
        c9836a.m61150g(i11);
        for (C9844i c9844i2 = this.f48351q; c9844i2 != null; c9844i2 = c9844i2.f48375a) {
            c9844i2.m61194n(c9836a);
        }
        c9836a.m61150g(0);
        return c9836a.f48327a;
    }

    /* renamed from: k */
    public void m61169k(int i10, int i11, String str, String str2, String[] strArr) {
        this.f48335a = i10;
        this.f48343i = i11;
        this.f48344j = m61160b(str).f48357a;
        this.f48345k = str;
        this.f48346l = str2 == null ? 0 : m61160b(str2).f48357a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f48347m = length;
        this.f48348n = new int[length];
        for (int i12 = 0; i12 < this.f48347m; i12++) {
            this.f48348n[i12] = m61160b(strArr[i12]).f48357a;
        }
    }

    public C9838c(int i10) {
        this.f48336b = 1;
        this.f48337c = new C9836a();
        this.f48338d = new C9840e[256];
        this.f48339e = (int) (r5.length * 0.75d);
        this.f48340f = new C9840e();
        this.f48341g = new C9840e();
        this.f48342h = new C9840e();
    }
}
