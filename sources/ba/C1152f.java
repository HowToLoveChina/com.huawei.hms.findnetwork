package ba;

import java.util.Map;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: ba.f */
/* loaded from: classes3.dex */
public class C1152f {

    /* renamed from: a */
    public C11060c f5432a;

    /* renamed from: ba.f$a */
    public static class a {

        /* renamed from: a */
        public static C1152f f5433a = new C1152f();
    }

    public C1152f() {
        m7226b();
    }

    /* renamed from: a */
    public static C1152f m7225a() {
        return a.f5433a;
    }

    /* renamed from: b */
    public void m7226b() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07015"), "07015", C13452e.m80781L().m80971t0());
        this.f5432a = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: c */
    public void m7227c(Map<String, String> map) {
        try {
            C13622a.m81969o(C0213f.m1377a(), this.f5432a, map);
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudActivesDownloadConfigReporter", "report exception:" + e10.toString());
        }
    }
}
