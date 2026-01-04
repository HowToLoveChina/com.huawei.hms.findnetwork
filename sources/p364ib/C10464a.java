package p364ib;

import java.util.Map;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: ib.a */
/* loaded from: classes3.dex */
public class C10464a {

    /* renamed from: a */
    public C11060c f50445a;

    /* renamed from: ib.a$a */
    public static class a {

        /* renamed from: a */
        public static C10464a f50446a = new C10464a();
    }

    public C10464a() {
        m64289b();
    }

    /* renamed from: a */
    public static C10464a m64288a() {
        return a.f50446a;
    }

    /* renamed from: b */
    public void m64289b() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07015"), "07015", C13452e.m80781L().m80971t0());
        this.f50445a = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: c */
    public void m64290c(Map<String, String> map) {
        try {
            C13622a.m81969o(C0213f.m1377a(), this.f50445a, map);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareDownloadConfigReporter", "report exception:" + e10.toString());
        }
    }
}
