package p596r;

import p561q.C12258e;
import p561q.C12261h;

/* renamed from: r.j */
/* loaded from: classes.dex */
public class C12443j extends AbstractC12449p {
    public C12443j(C12258e c12258e) {
        super(c12258e);
        c12258e.f56756e.mo74637f();
        c12258e.f56758f.mo74637f();
        this.f57362f = ((C12261h) c12258e).m73763x1();
    }

    @Override // p596r.AbstractC12449p, p596r.InterfaceC12437d
    /* renamed from: a */
    public void mo74634a(InterfaceC12437d interfaceC12437d) {
        C12439f c12439f = this.f57364h;
        if (c12439f.f57307c && !c12439f.f57314j) {
            this.f57364h.mo74659d((int) ((c12439f.f57316l.get(0).f57311g * ((C12261h) this.f57358b).m73756A1()) + 0.5f));
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: d */
    public void mo74635d() {
        C12261h c12261h = (C12261h) this.f57358b;
        int iM73764y1 = c12261h.m73764y1();
        int iM73765z1 = c12261h.m73765z1();
        c12261h.m73756A1();
        if (c12261h.m73763x1() == 1) {
            if (iM73764y1 != -1) {
                this.f57364h.f57316l.add(this.f57358b.f56753c0.f56756e.f57364h);
                this.f57358b.f56753c0.f56756e.f57364h.f57315k.add(this.f57364h);
                this.f57364h.f57310f = iM73764y1;
            } else if (iM73765z1 != -1) {
                this.f57364h.f57316l.add(this.f57358b.f56753c0.f56756e.f57365i);
                this.f57358b.f56753c0.f56756e.f57365i.f57315k.add(this.f57364h);
                this.f57364h.f57310f = -iM73765z1;
            } else {
                C12439f c12439f = this.f57364h;
                c12439f.f57306b = true;
                c12439f.f57316l.add(this.f57358b.f56753c0.f56756e.f57365i);
                this.f57358b.f56753c0.f56756e.f57365i.f57315k.add(this.f57364h);
            }
            m74674q(this.f57358b.f56756e.f57364h);
            m74674q(this.f57358b.f56756e.f57365i);
            return;
        }
        if (iM73764y1 != -1) {
            this.f57364h.f57316l.add(this.f57358b.f56753c0.f56758f.f57364h);
            this.f57358b.f56753c0.f56758f.f57364h.f57315k.add(this.f57364h);
            this.f57364h.f57310f = iM73764y1;
        } else if (iM73765z1 != -1) {
            this.f57364h.f57316l.add(this.f57358b.f56753c0.f56758f.f57365i);
            this.f57358b.f56753c0.f56758f.f57365i.f57315k.add(this.f57364h);
            this.f57364h.f57310f = -iM73765z1;
        } else {
            C12439f c12439f2 = this.f57364h;
            c12439f2.f57306b = true;
            c12439f2.f57316l.add(this.f57358b.f56753c0.f56758f.f57365i);
            this.f57358b.f56753c0.f56758f.f57365i.f57315k.add(this.f57364h);
        }
        m74674q(this.f57358b.f56758f.f57364h);
        m74674q(this.f57358b.f56758f.f57365i);
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: e */
    public void mo74636e() {
        if (((C12261h) this.f57358b).m73763x1() == 1) {
            this.f57358b.m73643r1(this.f57364h.f57311g);
        } else {
            this.f57358b.m73646s1(this.f57364h.f57311g);
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: f */
    public void mo74637f() {
        this.f57364h.m74658c();
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: m */
    public boolean mo74639m() {
        return false;
    }

    /* renamed from: q */
    public final void m74674q(C12439f c12439f) {
        this.f57364h.f57315k.add(c12439f);
        c12439f.f57316l.add(this.f57364h);
    }
}
