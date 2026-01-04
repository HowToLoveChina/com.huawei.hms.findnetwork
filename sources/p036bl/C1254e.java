package p036bl;

import cl.EnumC1453h;
import cl.InterfaceC1452g;
import je.C10790h;
import p261el.C9500a;
import p514o9.C11839m;

/* renamed from: bl.e */
/* loaded from: classes6.dex */
public class C1254e implements InterfaceC1452g {
    @Override // cl.InterfaceC1452g
    public EnumC1453h identity() {
        return EnumC1453h.AGD;
    }

    @Override // cl.InterfaceC1452g
    /* renamed from: l */
    public void mo7504l(String str, boolean z10, boolean z11, int i10) throws InterruptedException {
        C11839m.m70688i("AGRestorePrepareProcessor", "prepare with traceId");
        C10790h.m65663k(i10 == 1 ? C9500a.m59440d() : C9500a.m59439c(), str, z10);
    }
}
