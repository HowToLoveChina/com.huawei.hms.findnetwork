package p596r;

import java.util.Iterator;
import p561q.C12254a;
import p561q.C12258e;
import p596r.C12439f;

/* renamed from: r.k */
/* loaded from: classes.dex */
public class C12444k extends AbstractC12449p {
    public C12444k(C12258e c12258e) {
        super(c12258e);
    }

    /* renamed from: q */
    private void m74675q(C12439f c12439f) {
        this.f57364h.f57315k.add(c12439f);
        c12439f.f57316l.add(this.f57364h);
    }

    @Override // p596r.AbstractC12449p, p596r.InterfaceC12437d
    /* renamed from: a */
    public void mo74634a(InterfaceC12437d interfaceC12437d) {
        C12254a c12254a = (C12254a) this.f57358b;
        int iM73505A1 = c12254a.m73505A1();
        Iterator<C12439f> it = this.f57364h.f57316l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = it.next().f57311g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (iM73505A1 == 0 || iM73505A1 == 2) {
            this.f57364h.mo74659d(i11 + c12254a.m73506B1());
        } else {
            this.f57364h.mo74659d(i10 + c12254a.m73506B1());
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: d */
    public void mo74635d() {
        C12258e c12258e = this.f57358b;
        if (c12258e instanceof C12254a) {
            this.f57364h.f57306b = true;
            C12254a c12254a = (C12254a) c12258e;
            int iM73505A1 = c12254a.m73505A1();
            boolean zM73518z1 = c12254a.m73518z1();
            int i10 = 0;
            if (iM73505A1 == 0) {
                this.f57364h.f57309e = C12439f.a.LEFT;
                while (i10 < c12254a.f56889W0) {
                    C12258e c12258e2 = c12254a.f56888V0[i10];
                    if (zM73518z1 || c12258e2.m73592X() != 8) {
                        C12439f c12439f = c12258e2.f56756e.f57364h;
                        c12439f.f57315k.add(this.f57364h);
                        this.f57364h.f57316l.add(c12439f);
                    }
                    i10++;
                }
                m74675q(this.f57358b.f56756e.f57364h);
                m74675q(this.f57358b.f56756e.f57365i);
                return;
            }
            if (iM73505A1 == 1) {
                this.f57364h.f57309e = C12439f.a.RIGHT;
                while (i10 < c12254a.f56889W0) {
                    C12258e c12258e3 = c12254a.f56888V0[i10];
                    if (zM73518z1 || c12258e3.m73592X() != 8) {
                        C12439f c12439f2 = c12258e3.f56756e.f57365i;
                        c12439f2.f57315k.add(this.f57364h);
                        this.f57364h.f57316l.add(c12439f2);
                    }
                    i10++;
                }
                m74675q(this.f57358b.f56756e.f57364h);
                m74675q(this.f57358b.f56756e.f57365i);
                return;
            }
            if (iM73505A1 == 2) {
                this.f57364h.f57309e = C12439f.a.TOP;
                while (i10 < c12254a.f56889W0) {
                    C12258e c12258e4 = c12254a.f56888V0[i10];
                    if (zM73518z1 || c12258e4.m73592X() != 8) {
                        C12439f c12439f3 = c12258e4.f56758f.f57364h;
                        c12439f3.f57315k.add(this.f57364h);
                        this.f57364h.f57316l.add(c12439f3);
                    }
                    i10++;
                }
                m74675q(this.f57358b.f56758f.f57364h);
                m74675q(this.f57358b.f56758f.f57365i);
                return;
            }
            if (iM73505A1 != 3) {
                return;
            }
            this.f57364h.f57309e = C12439f.a.BOTTOM;
            while (i10 < c12254a.f56889W0) {
                C12258e c12258e5 = c12254a.f56888V0[i10];
                if (zM73518z1 || c12258e5.m73592X() != 8) {
                    C12439f c12439f4 = c12258e5.f56758f.f57365i;
                    c12439f4.f57315k.add(this.f57364h);
                    this.f57364h.f57316l.add(c12439f4);
                }
                i10++;
            }
            m74675q(this.f57358b.f56758f.f57364h);
            m74675q(this.f57358b.f56758f.f57365i);
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: e */
    public void mo74636e() {
        C12258e c12258e = this.f57358b;
        if (c12258e instanceof C12254a) {
            int iM73505A1 = ((C12254a) c12258e).m73505A1();
            if (iM73505A1 == 0 || iM73505A1 == 1) {
                this.f57358b.m73643r1(this.f57364h.f57311g);
            } else {
                this.f57358b.m73646s1(this.f57364h.f57311g);
            }
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: f */
    public void mo74637f() {
        this.f57359c = null;
        this.f57364h.m74658c();
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: m */
    public boolean mo74639m() {
        return false;
    }
}
