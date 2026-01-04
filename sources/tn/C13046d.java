package tn;

import fk.C9721b;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p709vj.C13452e;

/* renamed from: tn.d */
/* loaded from: classes6.dex */
public class C13046d extends AbstractC12367d {

    /* renamed from: a */
    public String f59374a;

    public C13046d(String str) {
        this.f59374a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("accept_type_key", this.f59374a);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07058"), "07058", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B("operation_accept_type_analyse_key");
        c11060cM66626a.m66665u("0");
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        }
    }
}
