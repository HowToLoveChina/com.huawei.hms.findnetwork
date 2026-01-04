package p596r;

import p596r.C12439f;

/* renamed from: r.g */
/* loaded from: classes.dex */
public class C12440g extends C12439f {

    /* renamed from: m */
    public int f57326m;

    public C12440g(AbstractC12449p abstractC12449p) {
        super(abstractC12449p);
        if (abstractC12449p instanceof C12445l) {
            this.f57309e = C12439f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f57309e = C12439f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // p596r.C12439f
    /* renamed from: d */
    public void mo74659d(int i10) {
        if (this.f57314j) {
            return;
        }
        this.f57314j = true;
        this.f57311g = i10;
        for (InterfaceC12437d interfaceC12437d : this.f57315k) {
            interfaceC12437d.mo74634a(interfaceC12437d);
        }
    }
}
