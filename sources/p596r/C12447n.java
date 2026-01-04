package p596r;

import p561q.C12257d;
import p561q.C12258e;
import p561q.InterfaceC12262i;
import p596r.AbstractC12449p;
import p596r.C12439f;

/* renamed from: r.n */
/* loaded from: classes.dex */
public class C12447n extends AbstractC12449p {

    /* renamed from: k */
    public C12439f f57340k;

    /* renamed from: l */
    public C12440g f57341l;

    /* renamed from: r.n$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57342a;

        static {
            int[] iArr = new int[AbstractC12449p.b.values().length];
            f57342a = iArr;
            try {
                iArr[AbstractC12449p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57342a[AbstractC12449p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57342a[AbstractC12449p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C12447n(C12258e c12258e) {
        super(c12258e);
        C12439f c12439f = new C12439f(this);
        this.f57340k = c12439f;
        this.f57341l = null;
        this.f57364h.f57309e = C12439f.a.TOP;
        this.f57365i.f57309e = C12439f.a.BOTTOM;
        c12439f.f57309e = C12439f.a.BASELINE;
        this.f57362f = 1;
    }

    @Override // p596r.AbstractC12449p, p596r.InterfaceC12437d
    /* renamed from: a */
    public void mo74634a(InterfaceC12437d interfaceC12437d) {
        float f10;
        float fM73658x;
        float fM73658x2;
        int i10;
        int i11 = a.f57342a[this.f57366j.ordinal()];
        if (i11 == 1) {
            m74702p(interfaceC12437d);
        } else if (i11 == 2) {
            m74701o(interfaceC12437d);
        } else if (i11 == 3) {
            C12258e c12258e = this.f57358b;
            m74700n(interfaceC12437d, c12258e.f56736R, c12258e.f56740T, 1);
            return;
        }
        C12440g c12440g = this.f57361e;
        if (c12440g.f57307c && !c12440g.f57314j && this.f57360d == C12258e.b.MATCH_CONSTRAINT) {
            C12258e c12258e2 = this.f57358b;
            int i12 = c12258e2.f56794x;
            if (i12 == 2) {
                C12258e c12258eM73570M = c12258e2.m73570M();
                if (c12258eM73570M != null) {
                    if (c12258eM73570M.f56758f.f57361e.f57314j) {
                        this.f57361e.mo74659d((int) ((r7.f57311g * this.f57358b.f56710E) + 0.5f));
                    }
                }
            } else if (i12 == 3 && c12258e2.f56756e.f57361e.f57314j) {
                int iM73660y = c12258e2.m73660y();
                if (iM73660y == -1) {
                    C12258e c12258e3 = this.f57358b;
                    f10 = c12258e3.f56756e.f57361e.f57311g;
                    fM73658x = c12258e3.m73658x();
                } else if (iM73660y == 0) {
                    fM73658x2 = r7.f56756e.f57361e.f57311g * this.f57358b.m73658x();
                    i10 = (int) (fM73658x2 + 0.5f);
                    this.f57361e.mo74659d(i10);
                } else if (iM73660y != 1) {
                    i10 = 0;
                    this.f57361e.mo74659d(i10);
                } else {
                    C12258e c12258e4 = this.f57358b;
                    f10 = c12258e4.f56756e.f57361e.f57311g;
                    fM73658x = c12258e4.m73658x();
                }
                fM73658x2 = f10 / fM73658x;
                i10 = (int) (fM73658x2 + 0.5f);
                this.f57361e.mo74659d(i10);
            }
        }
        C12439f c12439f = this.f57364h;
        if (c12439f.f57307c) {
            C12439f c12439f2 = this.f57365i;
            if (c12439f2.f57307c) {
                if (c12439f.f57314j && c12439f2.f57314j && this.f57361e.f57314j) {
                    return;
                }
                if (!this.f57361e.f57314j && this.f57360d == C12258e.b.MATCH_CONSTRAINT) {
                    C12258e c12258e5 = this.f57358b;
                    if (c12258e5.f56792w == 0 && !c12258e5.m73630m0()) {
                        C12439f c12439f3 = this.f57364h.f57316l.get(0);
                        C12439f c12439f4 = this.f57365i.f57316l.get(0);
                        int i13 = c12439f3.f57311g;
                        C12439f c12439f5 = this.f57364h;
                        int i14 = i13 + c12439f5.f57310f;
                        int i15 = c12439f4.f57311g + this.f57365i.f57310f;
                        c12439f5.mo74659d(i14);
                        this.f57365i.mo74659d(i15);
                        this.f57361e.mo74659d(i15 - i14);
                        return;
                    }
                }
                if (!this.f57361e.f57314j && this.f57360d == C12258e.b.MATCH_CONSTRAINT && this.f57357a == 1 && this.f57364h.f57316l.size() > 0 && this.f57365i.f57316l.size() > 0) {
                    C12439f c12439f6 = this.f57364h.f57316l.get(0);
                    int i16 = (this.f57365i.f57316l.get(0).f57311g + this.f57365i.f57310f) - (c12439f6.f57311g + this.f57364h.f57310f);
                    C12440g c12440g2 = this.f57361e;
                    int i17 = c12440g2.f57326m;
                    if (i16 < i17) {
                        c12440g2.mo74659d(i16);
                    } else {
                        c12440g2.mo74659d(i17);
                    }
                }
                if (this.f57361e.f57314j && this.f57364h.f57316l.size() > 0 && this.f57365i.f57316l.size() > 0) {
                    C12439f c12439f7 = this.f57364h.f57316l.get(0);
                    C12439f c12439f8 = this.f57365i.f57316l.get(0);
                    int i18 = c12439f7.f57311g + this.f57364h.f57310f;
                    int i19 = c12439f8.f57311g + this.f57365i.f57310f;
                    float fM73584T = this.f57358b.m73584T();
                    if (c12439f7 == c12439f8) {
                        i18 = c12439f7.f57311g;
                        i19 = c12439f8.f57311g;
                        fM73584T = 0.5f;
                    }
                    this.f57364h.mo74659d((int) (i18 + 0.5f + (((i19 - i18) - this.f57361e.f57311g) * fM73584T)));
                    this.f57365i.mo74659d(this.f57364h.f57311g + this.f57361e.f57311g);
                }
            }
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: d */
    public void mo74635d() {
        C12258e c12258eM73570M;
        C12258e c12258eM73570M2;
        C12258e c12258e = this.f57358b;
        if (c12258e.f56748a) {
            this.f57361e.mo74659d(c12258e.m73662z());
        }
        if (!this.f57361e.f57314j) {
            this.f57360d = this.f57358b.m73588V();
            if (this.f57358b.m73600b0()) {
                this.f57341l = new C12434a(this);
            }
            C12258e.b bVar = this.f57360d;
            if (bVar != C12258e.b.MATCH_CONSTRAINT) {
                if (bVar == C12258e.b.MATCH_PARENT && (c12258eM73570M2 = this.f57358b.m73570M()) != null && c12258eM73570M2.m73588V() == C12258e.b.FIXED) {
                    int iM73662z = (c12258eM73570M2.m73662z() - this.f57358b.f56736R.m73529f()) - this.f57358b.f56740T.m73529f();
                    m74693b(this.f57364h, c12258eM73570M2.f56758f.f57364h, this.f57358b.f56736R.m73529f());
                    m74693b(this.f57365i, c12258eM73570M2.f56758f.f57365i, -this.f57358b.f56740T.m73529f());
                    this.f57361e.mo74659d(iM73662z);
                    return;
                }
                if (this.f57360d == C12258e.b.FIXED) {
                    this.f57361e.mo74659d(this.f57358b.m73662z());
                }
            }
        } else if (this.f57360d == C12258e.b.MATCH_PARENT && (c12258eM73570M = this.f57358b.m73570M()) != null && c12258eM73570M.m73588V() == C12258e.b.FIXED) {
            m74693b(this.f57364h, c12258eM73570M.f56758f.f57364h, this.f57358b.f56736R.m73529f());
            m74693b(this.f57365i, c12258eM73570M.f56758f.f57365i, -this.f57358b.f56740T.m73529f());
            return;
        }
        C12440g c12440g = this.f57361e;
        boolean z10 = c12440g.f57314j;
        if (z10) {
            C12258e c12258e2 = this.f57358b;
            if (c12258e2.f56748a) {
                C12257d[] c12257dArr = c12258e2.f56746Y;
                C12257d c12257d = c12257dArr[2];
                C12257d c12257d2 = c12257d.f56687f;
                if (c12257d2 != null && c12257dArr[3].f56687f != null) {
                    if (c12258e2.m73630m0()) {
                        this.f57364h.f57310f = this.f57358b.f56746Y[2].m73529f();
                        this.f57365i.f57310f = -this.f57358b.f56746Y[3].m73529f();
                    } else {
                        C12439f c12439fM74696h = m74696h(this.f57358b.f56746Y[2]);
                        if (c12439fM74696h != null) {
                            m74693b(this.f57364h, c12439fM74696h, this.f57358b.f56746Y[2].m73529f());
                        }
                        C12439f c12439fM74696h2 = m74696h(this.f57358b.f56746Y[3]);
                        if (c12439fM74696h2 != null) {
                            m74693b(this.f57365i, c12439fM74696h2, -this.f57358b.f56746Y[3].m73529f());
                        }
                        this.f57364h.f57306b = true;
                        this.f57365i.f57306b = true;
                    }
                    if (this.f57358b.m73600b0()) {
                        m74693b(this.f57340k, this.f57364h, this.f57358b.m73641r());
                        return;
                    }
                    return;
                }
                if (c12257d2 != null) {
                    C12439f c12439fM74696h3 = m74696h(c12257d);
                    if (c12439fM74696h3 != null) {
                        m74693b(this.f57364h, c12439fM74696h3, this.f57358b.f56746Y[2].m73529f());
                        m74693b(this.f57365i, this.f57364h, this.f57361e.f57311g);
                        if (this.f57358b.m73600b0()) {
                            m74693b(this.f57340k, this.f57364h, this.f57358b.m73641r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                C12257d c12257d3 = c12257dArr[3];
                if (c12257d3.f56687f != null) {
                    C12439f c12439fM74696h4 = m74696h(c12257d3);
                    if (c12439fM74696h4 != null) {
                        m74693b(this.f57365i, c12439fM74696h4, -this.f57358b.f56746Y[3].m73529f());
                        m74693b(this.f57364h, this.f57365i, -this.f57361e.f57311g);
                    }
                    if (this.f57358b.m73600b0()) {
                        m74693b(this.f57340k, this.f57364h, this.f57358b.m73641r());
                        return;
                    }
                    return;
                }
                C12257d c12257d4 = c12257dArr[4];
                if (c12257d4.f56687f != null) {
                    C12439f c12439fM74696h5 = m74696h(c12257d4);
                    if (c12439fM74696h5 != null) {
                        m74693b(this.f57340k, c12439fM74696h5, 0);
                        m74693b(this.f57364h, this.f57340k, -this.f57358b.m73641r());
                        m74693b(this.f57365i, this.f57364h, this.f57361e.f57311g);
                        return;
                    }
                    return;
                }
                if ((c12258e2 instanceof InterfaceC12262i) || c12258e2.m73570M() == null || this.f57358b.mo73639q(C12257d.a.CENTER).f56687f != null) {
                    return;
                }
                m74693b(this.f57364h, this.f57358b.m73570M().f56758f.f57364h, this.f57358b.m73598a0());
                m74693b(this.f57365i, this.f57364h, this.f57361e.f57311g);
                if (this.f57358b.m73600b0()) {
                    m74693b(this.f57340k, this.f57364h, this.f57358b.m73641r());
                    return;
                }
                return;
            }
        }
        if (z10 || this.f57360d != C12258e.b.MATCH_CONSTRAINT) {
            c12440g.m74657b(this);
        } else {
            C12258e c12258e3 = this.f57358b;
            int i10 = c12258e3.f56794x;
            if (i10 == 2) {
                C12258e c12258eM73570M3 = c12258e3.m73570M();
                if (c12258eM73570M3 != null) {
                    C12440g c12440g2 = c12258eM73570M3.f56758f.f57361e;
                    this.f57361e.f57316l.add(c12440g2);
                    c12440g2.f57315k.add(this.f57361e);
                    C12440g c12440g3 = this.f57361e;
                    c12440g3.f57306b = true;
                    c12440g3.f57315k.add(this.f57364h);
                    this.f57361e.f57315k.add(this.f57365i);
                }
            } else if (i10 == 3 && !c12258e3.m73630m0()) {
                C12258e c12258e4 = this.f57358b;
                if (c12258e4.f56792w != 3) {
                    C12440g c12440g4 = c12258e4.f56756e.f57361e;
                    this.f57361e.f57316l.add(c12440g4);
                    c12440g4.f57315k.add(this.f57361e);
                    C12440g c12440g5 = this.f57361e;
                    c12440g5.f57306b = true;
                    c12440g5.f57315k.add(this.f57364h);
                    this.f57361e.f57315k.add(this.f57365i);
                }
            }
        }
        C12258e c12258e5 = this.f57358b;
        C12257d[] c12257dArr2 = c12258e5.f56746Y;
        C12257d c12257d5 = c12257dArr2[2];
        C12257d c12257d6 = c12257d5.f56687f;
        if (c12257d6 != null && c12257dArr2[3].f56687f != null) {
            if (c12258e5.m73630m0()) {
                this.f57364h.f57310f = this.f57358b.f56746Y[2].m73529f();
                this.f57365i.f57310f = -this.f57358b.f56746Y[3].m73529f();
            } else {
                C12439f c12439fM74696h6 = m74696h(this.f57358b.f56746Y[2]);
                C12439f c12439fM74696h7 = m74696h(this.f57358b.f56746Y[3]);
                if (c12439fM74696h6 != null) {
                    c12439fM74696h6.m74657b(this);
                }
                if (c12439fM74696h7 != null) {
                    c12439fM74696h7.m74657b(this);
                }
                this.f57366j = AbstractC12449p.b.CENTER;
            }
            if (this.f57358b.m73600b0()) {
                m74694c(this.f57340k, this.f57364h, 1, this.f57341l);
            }
        } else if (c12257d6 != null) {
            C12439f c12439fM74696h8 = m74696h(c12257d5);
            if (c12439fM74696h8 != null) {
                m74693b(this.f57364h, c12439fM74696h8, this.f57358b.f56746Y[2].m73529f());
                m74694c(this.f57365i, this.f57364h, 1, this.f57361e);
                if (this.f57358b.m73600b0()) {
                    m74694c(this.f57340k, this.f57364h, 1, this.f57341l);
                }
                C12258e.b bVar2 = this.f57360d;
                C12258e.b bVar3 = C12258e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f57358b.m73658x() > 0.0f) {
                    C12445l c12445l = this.f57358b.f56756e;
                    if (c12445l.f57360d == bVar3) {
                        c12445l.f57361e.f57315k.add(this.f57361e);
                        this.f57361e.f57316l.add(this.f57358b.f56756e.f57361e);
                        this.f57361e.f57305a = this;
                    }
                }
            }
        } else {
            C12257d c12257d7 = c12257dArr2[3];
            if (c12257d7.f56687f != null) {
                C12439f c12439fM74696h9 = m74696h(c12257d7);
                if (c12439fM74696h9 != null) {
                    m74693b(this.f57365i, c12439fM74696h9, -this.f57358b.f56746Y[3].m73529f());
                    m74694c(this.f57364h, this.f57365i, -1, this.f57361e);
                    if (this.f57358b.m73600b0()) {
                        m74694c(this.f57340k, this.f57364h, 1, this.f57341l);
                    }
                }
            } else {
                C12257d c12257d8 = c12257dArr2[4];
                if (c12257d8.f56687f != null) {
                    C12439f c12439fM74696h10 = m74696h(c12257d8);
                    if (c12439fM74696h10 != null) {
                        m74693b(this.f57340k, c12439fM74696h10, 0);
                        m74694c(this.f57364h, this.f57340k, -1, this.f57341l);
                        m74694c(this.f57365i, this.f57364h, 1, this.f57361e);
                    }
                } else if (!(c12258e5 instanceof InterfaceC12262i) && c12258e5.m73570M() != null) {
                    m74693b(this.f57364h, this.f57358b.m73570M().f56758f.f57364h, this.f57358b.m73598a0());
                    m74694c(this.f57365i, this.f57364h, 1, this.f57361e);
                    if (this.f57358b.m73600b0()) {
                        m74694c(this.f57340k, this.f57364h, 1, this.f57341l);
                    }
                    C12258e.b bVar4 = this.f57360d;
                    C12258e.b bVar5 = C12258e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f57358b.m73658x() > 0.0f) {
                        C12445l c12445l2 = this.f57358b.f56756e;
                        if (c12445l2.f57360d == bVar5) {
                            c12445l2.f57361e.f57315k.add(this.f57361e);
                            this.f57361e.f57316l.add(this.f57358b.f56756e.f57361e);
                            this.f57361e.f57305a = this;
                        }
                    }
                }
            }
        }
        if (this.f57361e.f57316l.size() == 0) {
            this.f57361e.f57307c = true;
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: e */
    public void mo74636e() {
        C12439f c12439f = this.f57364h;
        if (c12439f.f57314j) {
            this.f57358b.m73646s1(c12439f.f57311g);
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: f */
    public void mo74637f() {
        this.f57359c = null;
        this.f57364h.m74658c();
        this.f57365i.m74658c();
        this.f57340k.m74658c();
        this.f57361e.m74658c();
        this.f57363g = false;
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: m */
    public boolean mo74639m() {
        return this.f57360d != C12258e.b.MATCH_CONSTRAINT || this.f57358b.f56794x == 0;
    }

    /* renamed from: q */
    public void m74682q() {
        this.f57363g = false;
        this.f57364h.m74658c();
        this.f57364h.f57314j = false;
        this.f57365i.m74658c();
        this.f57365i.f57314j = false;
        this.f57340k.m74658c();
        this.f57340k.f57314j = false;
        this.f57361e.f57314j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f57358b.m73653v();
    }
}
