package tn;

import fk.C9721b;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p709vj.C13452e;

/* renamed from: tn.e */
/* loaded from: classes6.dex */
public class C13047e extends AbstractC12367d {

    /* renamed from: a */
    public boolean f59375a;

    /* renamed from: b */
    public String f59376b;

    public C13047e(boolean z10, String str) {
        this.f59375a = z10;
        this.f59376b = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("unzip_result", this.f59375a + "");
        linkedHashMap.put("unzip_reason", this.f59376b);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07057"), "07057", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B("operation_gzip_analyse_key");
        c11060cM66626a.m66665u("0");
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        }
    }
}
