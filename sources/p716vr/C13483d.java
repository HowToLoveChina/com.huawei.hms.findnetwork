package p716vr;

import as.C1016d;
import java.io.IOException;
import p688ur.C13244d;
import p688ur.C13245e;
import tr.C13063g;
import tr.C13065i;
import tr.InterfaceC13062f;

/* renamed from: vr.d */
/* loaded from: classes8.dex */
public class C13483d implements InterfaceC13062f {
    @Override // tr.InterfaceC13062f
    /* renamed from: a */
    public C13065i mo78788a(InterfaceC13062f.a aVar) throws C13245e, C13244d, IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1016d.m6181a("CallHttpSDKInterceptor", "RequestTask execute start");
        C13065i c13065iMo38453a = ((C13063g) aVar).m78790b().mo38453a(aVar.request());
        if (c13065iMo38453a == null) {
            return null;
        }
        return c13065iMo38453a.m78802l().m78816n(jCurrentTimeMillis).m78815m(System.currentTimeMillis()).m78811i();
    }
}
