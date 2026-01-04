package p703v8;

import java.util.Map;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: v8.m */
/* loaded from: classes2.dex */
public class C13376m {

    /* renamed from: b */
    public static final C13376m f60294b = new C13376m();

    /* renamed from: a */
    public C11060c f60295a;

    public C13376m() {
        m80303b();
    }

    /* renamed from: a */
    public static C13376m m80302a() {
        return f60294b;
    }

    /* renamed from: b */
    public final void m80303b() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07016"), "07016", C13452e.m80781L().m80971t0());
        this.f60295a = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: c */
    public void m80304c(Map<String, String> map) {
        try {
            C13622a.m81969o(C0213f.m1377a(), this.f60295a, map);
        } catch (Exception e10) {
            C11839m.m70687e("QuotaInfoReporter", "report exception:" + e10.toString());
        }
    }
}
