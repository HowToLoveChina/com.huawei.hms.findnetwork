package p040bx;

/* renamed from: bx.i0 */
/* loaded from: classes9.dex */
public final class C1318i0 implements InterfaceC1339q0 {

    /* renamed from: a */
    public final boolean f5806a;

    public C1318i0(boolean z10) {
        this.f5806a = z10;
    }

    @Override // p040bx.InterfaceC1339q0
    /* renamed from: s */
    public boolean mo7726s() {
        return this.f5806a;
    }

    @Override // p040bx.InterfaceC1339q0
    /* renamed from: t */
    public C1304d1 mo7727t() {
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(mo7726s() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
