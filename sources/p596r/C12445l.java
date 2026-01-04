package p596r;

import p561q.C12257d;
import p561q.C12258e;
import p561q.InterfaceC12262i;
import p596r.AbstractC12449p;
import p596r.C12439f;

/* renamed from: r.l */
/* loaded from: classes.dex */
public class C12445l extends AbstractC12449p {

    /* renamed from: k */
    public static int[] f57330k = new int[2];

    /* renamed from: r.l$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57331a;

        static {
            int[] iArr = new int[AbstractC12449p.b.values().length];
            f57331a = iArr;
            try {
                iArr[AbstractC12449p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57331a[AbstractC12449p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57331a[AbstractC12449p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C12445l(C12258e c12258e) {
        super(c12258e);
        this.f57364h.f57309e = C12439f.a.LEFT;
        this.f57365i.f57309e = C12439f.a.RIGHT;
        this.f57362f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:314:0x02df  */
    @Override // p596r.AbstractC12449p, p596r.InterfaceC12437d
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo74634a(p596r.InterfaceC12437d r17) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p596r.C12445l.mo74634a(r.d):void");
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: d */
    public void mo74635d() {
        C12258e c12258eM73570M;
        C12258e c12258eM73570M2;
        C12258e c12258e = this.f57358b;
        if (c12258e.f56748a) {
            this.f57361e.mo74659d(c12258e.m73594Y());
        }
        if (this.f57361e.f57314j) {
            C12258e.b bVar = this.f57360d;
            C12258e.b bVar2 = C12258e.b.MATCH_PARENT;
            if (bVar == bVar2 && (c12258eM73570M = this.f57358b.m73570M()) != null && (c12258eM73570M.m73550C() == C12258e.b.FIXED || c12258eM73570M.m73550C() == bVar2)) {
                m74693b(this.f57364h, c12258eM73570M.f56756e.f57364h, this.f57358b.f56734Q.m73529f());
                m74693b(this.f57365i, c12258eM73570M.f56756e.f57365i, -this.f57358b.f56738S.m73529f());
                return;
            }
        } else {
            C12258e.b bVarM73550C = this.f57358b.m73550C();
            this.f57360d = bVarM73550C;
            if (bVarM73550C != C12258e.b.MATCH_CONSTRAINT) {
                C12258e.b bVar3 = C12258e.b.MATCH_PARENT;
                if (bVarM73550C == bVar3 && (c12258eM73570M2 = this.f57358b.m73570M()) != null && (c12258eM73570M2.m73550C() == C12258e.b.FIXED || c12258eM73570M2.m73550C() == bVar3)) {
                    int iM73594Y = (c12258eM73570M2.m73594Y() - this.f57358b.f56734Q.m73529f()) - this.f57358b.f56738S.m73529f();
                    m74693b(this.f57364h, c12258eM73570M2.f56756e.f57364h, this.f57358b.f56734Q.m73529f());
                    m74693b(this.f57365i, c12258eM73570M2.f56756e.f57365i, -this.f57358b.f56738S.m73529f());
                    this.f57361e.mo74659d(iM73594Y);
                    return;
                }
                if (this.f57360d == C12258e.b.FIXED) {
                    this.f57361e.mo74659d(this.f57358b.m73594Y());
                }
            }
        }
        C12440g c12440g = this.f57361e;
        if (c12440g.f57314j) {
            C12258e c12258e2 = this.f57358b;
            if (c12258e2.f56748a) {
                C12257d[] c12257dArr = c12258e2.f56746Y;
                C12257d c12257d = c12257dArr[0];
                C12257d c12257d2 = c12257d.f56687f;
                if (c12257d2 != null && c12257dArr[1].f56687f != null) {
                    if (c12258e2.m73624k0()) {
                        this.f57364h.f57310f = this.f57358b.f56746Y[0].m73529f();
                        this.f57365i.f57310f = -this.f57358b.f56746Y[1].m73529f();
                        return;
                    }
                    C12439f c12439fM74696h = m74696h(this.f57358b.f56746Y[0]);
                    if (c12439fM74696h != null) {
                        m74693b(this.f57364h, c12439fM74696h, this.f57358b.f56746Y[0].m73529f());
                    }
                    C12439f c12439fM74696h2 = m74696h(this.f57358b.f56746Y[1]);
                    if (c12439fM74696h2 != null) {
                        m74693b(this.f57365i, c12439fM74696h2, -this.f57358b.f56746Y[1].m73529f());
                    }
                    this.f57364h.f57306b = true;
                    this.f57365i.f57306b = true;
                    return;
                }
                if (c12257d2 != null) {
                    C12439f c12439fM74696h3 = m74696h(c12257d);
                    if (c12439fM74696h3 != null) {
                        m74693b(this.f57364h, c12439fM74696h3, this.f57358b.f56746Y[0].m73529f());
                        m74693b(this.f57365i, this.f57364h, this.f57361e.f57311g);
                        return;
                    }
                    return;
                }
                C12257d c12257d3 = c12257dArr[1];
                if (c12257d3.f56687f != null) {
                    C12439f c12439fM74696h4 = m74696h(c12257d3);
                    if (c12439fM74696h4 != null) {
                        m74693b(this.f57365i, c12439fM74696h4, -this.f57358b.f56746Y[1].m73529f());
                        m74693b(this.f57364h, this.f57365i, -this.f57361e.f57311g);
                        return;
                    }
                    return;
                }
                if ((c12258e2 instanceof InterfaceC12262i) || c12258e2.m73570M() == null || this.f57358b.mo73639q(C12257d.a.CENTER).f56687f != null) {
                    return;
                }
                m74693b(this.f57364h, this.f57358b.m73570M().f56756e.f57364h, this.f57358b.m73596Z());
                m74693b(this.f57365i, this.f57364h, this.f57361e.f57311g);
                return;
            }
        }
        if (this.f57360d == C12258e.b.MATCH_CONSTRAINT) {
            C12258e c12258e3 = this.f57358b;
            int i10 = c12258e3.f56792w;
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
            } else if (i10 == 3) {
                if (c12258e3.f56794x == 3) {
                    this.f57364h.f57305a = this;
                    this.f57365i.f57305a = this;
                    C12447n c12447n = c12258e3.f56758f;
                    c12447n.f57364h.f57305a = this;
                    c12447n.f57365i.f57305a = this;
                    c12440g.f57305a = this;
                    if (c12258e3.m73630m0()) {
                        this.f57361e.f57316l.add(this.f57358b.f56758f.f57361e);
                        this.f57358b.f56758f.f57361e.f57315k.add(this.f57361e);
                        C12447n c12447n2 = this.f57358b.f56758f;
                        c12447n2.f57361e.f57305a = this;
                        this.f57361e.f57316l.add(c12447n2.f57364h);
                        this.f57361e.f57316l.add(this.f57358b.f56758f.f57365i);
                        this.f57358b.f56758f.f57364h.f57315k.add(this.f57361e);
                        this.f57358b.f56758f.f57365i.f57315k.add(this.f57361e);
                    } else if (this.f57358b.m73624k0()) {
                        this.f57358b.f56758f.f57361e.f57316l.add(this.f57361e);
                        this.f57361e.f57315k.add(this.f57358b.f56758f.f57361e);
                    } else {
                        this.f57358b.f56758f.f57361e.f57316l.add(this.f57361e);
                    }
                } else {
                    C12440g c12440g4 = c12258e3.f56758f.f57361e;
                    c12440g.f57316l.add(c12440g4);
                    c12440g4.f57315k.add(this.f57361e);
                    this.f57358b.f56758f.f57364h.f57315k.add(this.f57361e);
                    this.f57358b.f56758f.f57365i.f57315k.add(this.f57361e);
                    C12440g c12440g5 = this.f57361e;
                    c12440g5.f57306b = true;
                    c12440g5.f57315k.add(this.f57364h);
                    this.f57361e.f57315k.add(this.f57365i);
                    this.f57364h.f57316l.add(this.f57361e);
                    this.f57365i.f57316l.add(this.f57361e);
                }
            }
        }
        C12258e c12258e4 = this.f57358b;
        C12257d[] c12257dArr2 = c12258e4.f56746Y;
        C12257d c12257d4 = c12257dArr2[0];
        C12257d c12257d5 = c12257d4.f56687f;
        if (c12257d5 != null && c12257dArr2[1].f56687f != null) {
            if (c12258e4.m73624k0()) {
                this.f57364h.f57310f = this.f57358b.f56746Y[0].m73529f();
                this.f57365i.f57310f = -this.f57358b.f56746Y[1].m73529f();
                return;
            }
            C12439f c12439fM74696h5 = m74696h(this.f57358b.f56746Y[0]);
            C12439f c12439fM74696h6 = m74696h(this.f57358b.f56746Y[1]);
            if (c12439fM74696h5 != null) {
                c12439fM74696h5.m74657b(this);
            }
            if (c12439fM74696h6 != null) {
                c12439fM74696h6.m74657b(this);
            }
            this.f57366j = AbstractC12449p.b.CENTER;
            return;
        }
        if (c12257d5 != null) {
            C12439f c12439fM74696h7 = m74696h(c12257d4);
            if (c12439fM74696h7 != null) {
                m74693b(this.f57364h, c12439fM74696h7, this.f57358b.f56746Y[0].m73529f());
                m74694c(this.f57365i, this.f57364h, 1, this.f57361e);
                return;
            }
            return;
        }
        C12257d c12257d6 = c12257dArr2[1];
        if (c12257d6.f56687f != null) {
            C12439f c12439fM74696h8 = m74696h(c12257d6);
            if (c12439fM74696h8 != null) {
                m74693b(this.f57365i, c12439fM74696h8, -this.f57358b.f56746Y[1].m73529f());
                m74694c(this.f57364h, this.f57365i, -1, this.f57361e);
                return;
            }
            return;
        }
        if ((c12258e4 instanceof InterfaceC12262i) || c12258e4.m73570M() == null) {
            return;
        }
        m74693b(this.f57364h, this.f57358b.m73570M().f56756e.f57364h, this.f57358b.m73596Z());
        m74694c(this.f57365i, this.f57364h, 1, this.f57361e);
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: e */
    public void mo74636e() {
        C12439f c12439f = this.f57364h;
        if (c12439f.f57314j) {
            this.f57358b.m73643r1(c12439f.f57311g);
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: f */
    public void mo74637f() {
        this.f57359c = null;
        this.f57364h.m74658c();
        this.f57365i.m74658c();
        this.f57361e.m74658c();
        this.f57363g = false;
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: m */
    public boolean mo74639m() {
        return this.f57360d != C12258e.b.MATCH_CONSTRAINT || this.f57358b.f56792w == 0;
    }

    /* renamed from: q */
    public final void m74676q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    /* renamed from: r */
    public void m74677r() {
        this.f57363g = false;
        this.f57364h.m74658c();
        this.f57364h.f57314j = false;
        this.f57365i.m74658c();
        this.f57365i.f57314j = false;
        this.f57361e.f57314j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f57358b.m73653v();
    }
}
