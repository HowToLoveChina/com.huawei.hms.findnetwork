package p596r;

import p561q.C12257d;
import p561q.C12258e;

/* renamed from: r.p */
/* loaded from: classes.dex */
public abstract class AbstractC12449p implements InterfaceC12437d {

    /* renamed from: a */
    public int f57357a;

    /* renamed from: b */
    public C12258e f57358b;

    /* renamed from: c */
    public C12446m f57359c;

    /* renamed from: d */
    public C12258e.b f57360d;

    /* renamed from: e */
    public C12440g f57361e = new C12440g(this);

    /* renamed from: f */
    public int f57362f = 0;

    /* renamed from: g */
    public boolean f57363g = false;

    /* renamed from: h */
    public C12439f f57364h = new C12439f(this);

    /* renamed from: i */
    public C12439f f57365i = new C12439f(this);

    /* renamed from: j */
    public b f57366j = b.NONE;

    /* renamed from: r.p$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57367a;

        static {
            int[] iArr = new int[C12257d.a.values().length];
            f57367a = iArr;
            try {
                iArr[C12257d.a.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57367a[C12257d.a.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57367a[C12257d.a.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f57367a[C12257d.a.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f57367a[C12257d.a.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: r.p$b */
    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public AbstractC12449p(C12258e c12258e) {
        this.f57358b = c12258e;
    }

    @Override // p596r.InterfaceC12437d
    /* renamed from: a */
    public void mo74634a(InterfaceC12437d interfaceC12437d) {
    }

    /* renamed from: b */
    public final void m74693b(C12439f c12439f, C12439f c12439f2, int i10) {
        c12439f.f57316l.add(c12439f2);
        c12439f.f57310f = i10;
        c12439f2.f57315k.add(c12439f);
    }

    /* renamed from: c */
    public final void m74694c(C12439f c12439f, C12439f c12439f2, int i10, C12440g c12440g) {
        c12439f.f57316l.add(c12439f2);
        c12439f.f57316l.add(this.f57361e);
        c12439f.f57312h = i10;
        c12439f.f57313i = c12440g;
        c12439f2.f57315k.add(c12439f);
        c12440g.f57315k.add(c12439f);
    }

    /* renamed from: d */
    public abstract void mo74635d();

    /* renamed from: e */
    public abstract void mo74636e();

    /* renamed from: f */
    public abstract void mo74637f();

    /* renamed from: g */
    public final int m74695g(int i10, int i11) {
        int iMax;
        if (i11 == 0) {
            C12258e c12258e = this.f57358b;
            int i12 = c12258e.f56702A;
            iMax = Math.max(c12258e.f56798z, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        } else {
            C12258e c12258e2 = this.f57358b;
            int i13 = c12258e2.f56708D;
            iMax = Math.max(c12258e2.f56706C, i10);
            if (i13 > 0) {
                iMax = Math.min(i13, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        }
        return iMax;
    }

    /* renamed from: h */
    public final C12439f m74696h(C12257d c12257d) {
        C12257d c12257d2 = c12257d.f56687f;
        if (c12257d2 == null) {
            return null;
        }
        C12258e c12258e = c12257d2.f56685d;
        int i10 = a.f57367a[c12257d2.f56686e.ordinal()];
        if (i10 == 1) {
            return c12258e.f56756e.f57364h;
        }
        if (i10 == 2) {
            return c12258e.f56756e.f57365i;
        }
        if (i10 == 3) {
            return c12258e.f56758f.f57364h;
        }
        if (i10 == 4) {
            return c12258e.f56758f.f57340k;
        }
        if (i10 != 5) {
            return null;
        }
        return c12258e.f56758f.f57365i;
    }

    /* renamed from: i */
    public final C12439f m74697i(C12257d c12257d, int i10) {
        C12257d c12257d2 = c12257d.f56687f;
        if (c12257d2 == null) {
            return null;
        }
        C12258e c12258e = c12257d2.f56685d;
        AbstractC12449p abstractC12449p = i10 == 0 ? c12258e.f56756e : c12258e.f56758f;
        int i11 = a.f57367a[c12257d2.f56686e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return abstractC12449p.f57365i;
        }
        return abstractC12449p.f57364h;
    }

    /* renamed from: j */
    public long mo74638j() {
        if (this.f57361e.f57314j) {
            return r2.f57311g;
        }
        return 0L;
    }

    /* renamed from: k */
    public boolean m74698k() {
        return this.f57363g;
    }

    /* renamed from: l */
    public final void m74699l(int i10, int i11) {
        int i12 = this.f57357a;
        if (i12 == 0) {
            this.f57361e.mo74659d(m74695g(i11, i10));
            return;
        }
        if (i12 == 1) {
            this.f57361e.mo74659d(Math.min(m74695g(this.f57361e.f57326m, i10), i11));
            return;
        }
        if (i12 == 2) {
            C12258e c12258eM73570M = this.f57358b.m73570M();
            if (c12258eM73570M != null) {
                if ((i10 == 0 ? c12258eM73570M.f56756e : c12258eM73570M.f56758f).f57361e.f57314j) {
                    this.f57361e.mo74659d(m74695g((int) ((r9.f57311g * (i10 == 0 ? this.f57358b.f56704B : this.f57358b.f56710E)) + 0.5f), i10));
                    return;
                }
                return;
            }
            return;
        }
        if (i12 != 3) {
            return;
        }
        C12258e c12258e = this.f57358b;
        AbstractC12449p abstractC12449p = c12258e.f56756e;
        C12258e.b bVar = abstractC12449p.f57360d;
        C12258e.b bVar2 = C12258e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && abstractC12449p.f57357a == 3) {
            C12447n c12447n = c12258e.f56758f;
            if (c12447n.f57360d == bVar2 && c12447n.f57357a == 3) {
                return;
            }
        }
        if (i10 == 0) {
            abstractC12449p = c12258e.f56758f;
        }
        if (abstractC12449p.f57361e.f57314j) {
            float fM73658x = c12258e.m73658x();
            this.f57361e.mo74659d(i10 == 1 ? (int) ((abstractC12449p.f57361e.f57311g / fM73658x) + 0.5f) : (int) ((fM73658x * abstractC12449p.f57361e.f57311g) + 0.5f));
        }
    }

    /* renamed from: m */
    public abstract boolean mo74639m();

    /* renamed from: n */
    public void m74700n(InterfaceC12437d interfaceC12437d, C12257d c12257d, C12257d c12257d2, int i10) {
        C12439f c12439fM74696h = m74696h(c12257d);
        C12439f c12439fM74696h2 = m74696h(c12257d2);
        if (c12439fM74696h.f57314j && c12439fM74696h2.f57314j) {
            int iM73529f = c12439fM74696h.f57311g + c12257d.m73529f();
            int iM73529f2 = c12439fM74696h2.f57311g - c12257d2.m73529f();
            int i11 = iM73529f2 - iM73529f;
            if (!this.f57361e.f57314j && this.f57360d == C12258e.b.MATCH_CONSTRAINT) {
                m74699l(i10, i11);
            }
            C12440g c12440g = this.f57361e;
            if (c12440g.f57314j) {
                if (c12440g.f57311g == i11) {
                    this.f57364h.mo74659d(iM73529f);
                    this.f57365i.mo74659d(iM73529f2);
                    return;
                }
                float fM73546A = i10 == 0 ? this.f57358b.m73546A() : this.f57358b.m73584T();
                if (c12439fM74696h == c12439fM74696h2) {
                    iM73529f = c12439fM74696h.f57311g;
                    iM73529f2 = c12439fM74696h2.f57311g;
                    fM73546A = 0.5f;
                }
                this.f57364h.mo74659d((int) (iM73529f + 0.5f + (((iM73529f2 - iM73529f) - this.f57361e.f57311g) * fM73546A)));
                this.f57365i.mo74659d(this.f57364h.f57311g + this.f57361e.f57311g);
            }
        }
    }

    /* renamed from: o */
    public void m74701o(InterfaceC12437d interfaceC12437d) {
    }

    /* renamed from: p */
    public void m74702p(InterfaceC12437d interfaceC12437d) {
    }
}
