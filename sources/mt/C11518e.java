package mt;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.ToLongFunction;
import p623rt.InterfaceC12625b;

/* renamed from: mt.e */
/* loaded from: classes5.dex */
public class C11518e implements InterfaceC12625b {

    /* renamed from: a */
    public C11519f f53433a;

    /* renamed from: b */
    public C11520g f53434b;

    /* renamed from: c */
    public int f53435c;

    /* renamed from: d */
    public int f53436d;

    /* renamed from: e */
    public int f53437e;

    /* renamed from: f */
    public double f53438f;

    /* renamed from: g */
    public double f53439g;

    /* renamed from: h */
    public String f53440h;

    public C11518e(C11519f c11519f, C11520g c11520g, int i10, int i11, double d10) {
        this.f53433a = c11519f == null ? new C11519f(0L, 0) : c11519f;
        this.f53434b = c11520g == null ? new C11520g(0.0d, 0.0d) : c11520g;
        this.f53436d = i10;
        this.f53437e = i11;
        this.f53438f = d10;
    }

    /* renamed from: f */
    public static /* synthetic */ int m68721f(C11518e c11518e, C11518e c11518e2) {
        return Double.compare(c11518e2.m68735o(), c11518e.m68735o());
    }

    /* renamed from: g */
    public static /* synthetic */ long m68722g(C11518e c11518e) {
        return c11518e.m68730j().m68739b();
    }

    /* renamed from: h */
    public static /* synthetic */ int m68723h(C11518e c11518e, C11518e c11518e2) {
        return Double.compare(c11518e2.m68731k(), c11518e.m68731k());
    }

    /* renamed from: i */
    public static /* synthetic */ int m68724i(C11518e c11518e, C11518e c11518e2) {
        return Long.compare(c11518e2.m68730j().m68739b(), c11518e.m68730j().m68739b());
    }

    /* renamed from: r */
    public static void m68725r(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.sort(new Comparator() { // from class: mt.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11518e.m68723h((C11518e) obj, (C11518e) obj2);
            }
        });
    }

    /* renamed from: s */
    public static void m68726s(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.sort(new Comparator() { // from class: mt.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11518e.m68721f((C11518e) obj, (C11518e) obj2);
            }
        });
    }

    /* renamed from: t */
    public static void m68727t(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.sort(Comparator.comparingLong(new ToLongFunction() { // from class: mt.a
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return C11518e.m68722g((C11518e) obj);
            }
        }));
    }

    /* renamed from: u */
    public static void m68728u(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.sort(new Comparator() { // from class: mt.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11518e.m68724i((C11518e) obj, (C11518e) obj2);
            }
        });
    }

    @Override // p623rt.InterfaceC12625b
    /* renamed from: a */
    public double[] mo68729a() {
        return new double[]{this.f53434b.m68750j(), this.f53434b.m68747g()};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11518e)) {
            return false;
        }
        C11518e c11518e = (C11518e) obj;
        boolean[] zArr = new boolean[2];
        zArr[0] = this.f53435c == c11518e.f53435c && this.f53436d == c11518e.f53436d && Objects.equals(this.f53433a, c11518e.f53433a);
        boolean z10 = this.f53437e == c11518e.f53437e && Objects.equals(this.f53434b, c11518e.f53434b) && Objects.equals(this.f53440h, c11518e.f53440h);
        zArr[1] = z10;
        return zArr[0] && z10 && Double.compare(c11518e.f53438f, this.f53438f) == 0;
    }

    public int hashCode() {
        return Objects.hash(this.f53433a, this.f53434b, Integer.valueOf(this.f53435c), Integer.valueOf(this.f53436d), Integer.valueOf(this.f53437e), Double.valueOf(this.f53438f), this.f53440h);
    }

    /* renamed from: j */
    public C11519f m68730j() {
        return this.f53433a;
    }

    /* renamed from: k */
    public double m68731k() {
        return this.f53438f;
    }

    /* renamed from: l */
    public int m68732l() {
        return this.f53435c;
    }

    /* renamed from: m */
    public String m68733m() {
        return this.f53440h;
    }

    /* renamed from: n */
    public C11520g m68734n() {
        return this.f53434b;
    }

    /* renamed from: o */
    public double m68735o() {
        return this.f53439g;
    }

    /* renamed from: p */
    public void m68736p(int i10) {
        this.f53435c = i10;
    }

    /* renamed from: q */
    public void m68737q(double d10) {
        this.f53439g = d10;
    }

    public String toString() {
        return "BleScanInfo{blueToothRecord=" + this.f53433a + ", lastLocation=" + this.f53434b + ", index=" + this.f53435c + ", arStatus=" + this.f53436d + ", stepCount=" + this.f53437e + ", confidence=" + this.f53438f + ", newConfidence=" + this.f53439g + ", kindTransID=" + this.f53440h + '}';
    }
}
