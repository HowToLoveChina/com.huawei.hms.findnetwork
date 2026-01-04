package p561q;

import java.util.HashMap;
import p479n.C11574d;
import p479n.C11579i;
import p561q.C12257d;
import p561q.C12258e;

/* renamed from: q.h */
/* loaded from: classes.dex */
public class C12261h extends C12258e {

    /* renamed from: V0 */
    public float f56879V0 = -1.0f;

    /* renamed from: W0 */
    public int f56880W0 = -1;

    /* renamed from: X0 */
    public int f56881X0 = -1;

    /* renamed from: Y0 */
    public boolean f56882Y0 = true;

    /* renamed from: Z0 */
    public C12257d f56883Z0 = this.f56736R;

    /* renamed from: a1 */
    public int f56884a1 = 0;

    /* renamed from: b1 */
    public int f56885b1 = 0;

    /* renamed from: c1 */
    public boolean f56886c1;

    /* renamed from: q.h$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f56887a;

        static {
            int[] iArr = new int[C12257d.a.values().length];
            f56887a = iArr;
            try {
                iArr[C12257d.a.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56887a[C12257d.a.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56887a[C12257d.a.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56887a[C12257d.a.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56887a[C12257d.a.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f56887a[C12257d.a.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f56887a[C12257d.a.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f56887a[C12257d.a.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f56887a[C12257d.a.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public C12261h() {
        this.f56747Z.clear();
        this.f56747Z.add(this.f56883Z0);
        int length = this.f56746Y.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f56746Y[i10] = this.f56883Z0;
        }
    }

    /* renamed from: A1 */
    public float m73756A1() {
        return this.f56879V0;
    }

    /* renamed from: B1 */
    public void m73757B1(int i10) {
        this.f56883Z0.m73543t(i10);
        this.f56886c1 = true;
    }

    /* renamed from: C1 */
    public void m73758C1(int i10) {
        if (i10 > -1) {
            this.f56879V0 = -1.0f;
            this.f56880W0 = i10;
            this.f56881X0 = -1;
        }
    }

    /* renamed from: D1 */
    public void m73759D1(int i10) {
        if (i10 > -1) {
            this.f56879V0 = -1.0f;
            this.f56880W0 = -1;
            this.f56881X0 = i10;
        }
    }

    /* renamed from: E1 */
    public void m73760E1(float f10) {
        if (f10 > -1.0f) {
            this.f56879V0 = f10;
            this.f56880W0 = -1;
            this.f56881X0 = -1;
        }
    }

    /* renamed from: F1 */
    public void m73761F1(int i10) {
        if (this.f56884a1 == i10) {
            return;
        }
        this.f56884a1 = i10;
        this.f56747Z.clear();
        if (this.f56884a1 == 1) {
            this.f56883Z0 = this.f56734Q;
        } else {
            this.f56883Z0 = this.f56736R;
        }
        this.f56747Z.add(this.f56883Z0);
        int length = this.f56746Y.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f56746Y[i11] = this.f56883Z0;
        }
    }

    @Override // p561q.C12258e
    /* renamed from: g */
    public void mo73512g(C11574d c11574d, boolean z10) {
        C12259f c12259f = (C12259f) m73570M();
        if (c12259f == null) {
            return;
        }
        C12257d c12257dMo73639q = c12259f.mo73639q(C12257d.a.LEFT);
        C12257d c12257dMo73639q2 = c12259f.mo73639q(C12257d.a.RIGHT);
        C12258e c12258e = this.f56753c0;
        boolean z11 = c12258e != null && c12258e.f56751b0[0] == C12258e.b.WRAP_CONTENT;
        if (this.f56884a1 == 0) {
            c12257dMo73639q = c12259f.mo73639q(C12257d.a.TOP);
            c12257dMo73639q2 = c12259f.mo73639q(C12257d.a.BOTTOM);
            C12258e c12258e2 = this.f56753c0;
            z11 = c12258e2 != null && c12258e2.f56751b0[1] == C12258e.b.WRAP_CONTENT;
        }
        if (this.f56886c1 && this.f56883Z0.m73537n()) {
            C11579i c11579iM69108q = c11574d.m69108q(this.f56883Z0);
            c11574d.m69097f(c11579iM69108q, this.f56883Z0.m73528e());
            if (this.f56880W0 != -1) {
                if (z11) {
                    c11574d.m69099h(c11574d.m69108q(c12257dMo73639q2), c11579iM69108q, 0, 5);
                }
            } else if (this.f56881X0 != -1 && z11) {
                C11579i c11579iM69108q2 = c11574d.m69108q(c12257dMo73639q2);
                c11574d.m69099h(c11579iM69108q, c11574d.m69108q(c12257dMo73639q), 0, 5);
                c11574d.m69099h(c11579iM69108q2, c11579iM69108q, 0, 5);
            }
            this.f56886c1 = false;
            return;
        }
        if (this.f56880W0 != -1) {
            C11579i c11579iM69108q3 = c11574d.m69108q(this.f56883Z0);
            c11574d.m69096e(c11579iM69108q3, c11574d.m69108q(c12257dMo73639q), this.f56880W0, 8);
            if (z11) {
                c11574d.m69099h(c11574d.m69108q(c12257dMo73639q2), c11579iM69108q3, 0, 5);
                return;
            }
            return;
        }
        if (this.f56881X0 == -1) {
            if (this.f56879V0 != -1.0f) {
                c11574d.m69095d(C11574d.m69085s(c11574d, c11574d.m69108q(this.f56883Z0), c11574d.m69108q(c12257dMo73639q2), this.f56879V0));
                return;
            }
            return;
        }
        C11579i c11579iM69108q4 = c11574d.m69108q(this.f56883Z0);
        C11579i c11579iM69108q5 = c11574d.m69108q(c12257dMo73639q2);
        c11574d.m69096e(c11579iM69108q4, c11579iM69108q5, -this.f56881X0, 8);
        if (z11) {
            c11574d.m69099h(c11579iM69108q4, c11574d.m69108q(c12257dMo73639q), 0, 5);
            c11574d.m69099h(c11579iM69108q5, c11579iM69108q4, 0, 5);
        }
    }

    @Override // p561q.C12258e
    /* renamed from: h */
    public boolean mo73513h() {
        return true;
    }

    @Override // p561q.C12258e
    /* renamed from: n */
    public void mo73514n(C12258e c12258e, HashMap<C12258e, C12258e> map) {
        super.mo73514n(c12258e, map);
        C12261h c12261h = (C12261h) c12258e;
        this.f56879V0 = c12261h.f56879V0;
        this.f56880W0 = c12261h.f56880W0;
        this.f56881X0 = c12261h.f56881X0;
        this.f56882Y0 = c12261h.f56882Y0;
        m73761F1(c12261h.f56884a1);
    }

    @Override // p561q.C12258e
    /* renamed from: p0 */
    public boolean mo73515p0() {
        return this.f56886c1;
    }

    @Override // p561q.C12258e
    /* renamed from: q */
    public C12257d mo73639q(C12257d.a aVar) {
        int i10 = a.f56887a[aVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.f56884a1 == 1) {
                return this.f56883Z0;
            }
            return null;
        }
        if ((i10 == 3 || i10 == 4) && this.f56884a1 == 0) {
            return this.f56883Z0;
        }
        return null;
    }

    @Override // p561q.C12258e
    /* renamed from: q0 */
    public boolean mo73516q0() {
        return this.f56886c1;
    }

    @Override // p561q.C12258e
    /* renamed from: v1 */
    public void mo73655v1(C11574d c11574d, boolean z10) {
        if (m73570M() == null) {
            return;
        }
        int iM69114y = c11574d.m69114y(this.f56883Z0);
        if (this.f56884a1 == 1) {
            m73643r1(iM69114y);
            m73646s1(0);
            m73579Q0(m73570M().m73662z());
            m73638p1(0);
            return;
        }
        m73643r1(0);
        m73646s1(iM69114y);
        m73638p1(m73570M().m73594Y());
        m73579Q0(0);
    }

    /* renamed from: w1 */
    public C12257d m73762w1() {
        return this.f56883Z0;
    }

    /* renamed from: x1 */
    public int m73763x1() {
        return this.f56884a1;
    }

    /* renamed from: y1 */
    public int m73764y1() {
        return this.f56880W0;
    }

    /* renamed from: z1 */
    public int m73765z1() {
        return this.f56881X0;
    }
}
