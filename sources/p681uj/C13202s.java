package p681uj;

import fk.C9721b;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import tn.InterfaceC13043a;

/* renamed from: uj.s */
/* loaded from: classes5.dex */
public class C13202s extends AbstractC12367d {

    /* renamed from: a */
    public String f59830a;

    /* renamed from: b */
    public String f59831b;

    public C13202s(String str, String str2) {
        this.f59830a = str;
        this.f59831b = str2;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", this.f59830a);
        linkedHashMap.put("module_cmd", this.f59831b);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07044"), "07044", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B("operation_at");
        c11060cM66626a.m66665u("0");
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        }
    }
}
