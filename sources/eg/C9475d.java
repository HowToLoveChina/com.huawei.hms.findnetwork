package eg;

import bf.C1175a;
import gp.C10028c;
import io.C10582a;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p521og.C11877j;
import p709vj.C13452e;
import p809yg.C13981a;

/* renamed from: eg.d */
/* loaded from: classes4.dex */
public class C9475d extends AbstractC9478g {
    /* renamed from: c */
    public final void m59329c(Map<String, String> map) {
        if (!C10028c.m62183d0(C0213f.m1377a()).m62395t1("funcfg_find_my_phone_globe")) {
            C13981a.m83989i("PhoneFinderSwitchStatusTask", "phoneFinder not enable");
            return;
        }
        map.put("pf.main", C1175a.m7390l(C0213f.m1377a(), C13452e.m80781L().m80971t0()) ? "AUTO" : "DISABLED");
        map.put("pf.lowpower", C11877j.m71202D(C0213f.m1377a()) ? "AUTO" : "DISABLED");
        map.put("pf.sharelocate", C11877j.m71267g0(C0213f.m1377a()) ? "AUTO" : "DISABLED");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C13981a.m83989i("PhoneFinderSwitchStatusTask", "PhoneFinderSwitchStatusTask call");
        HashMap map = new HashMap();
        m59329c(map);
        new C10582a("").m64928b0(map, "2", null);
    }
}
