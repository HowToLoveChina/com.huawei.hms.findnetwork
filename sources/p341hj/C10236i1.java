package p341hj;

import android.os.Handler;
import fk.C9721b;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.i1 */
/* loaded from: classes5.dex */
public class C10236i1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49611b;

    public C10236i1(Handler handler) {
        this.f49611b = handler;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06021"), "queryPickedWelfares", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                m63380f(this.f49611b, 6038, C9948a.m61631C().m61667e0(c11060cM66626a));
            } catch (C9721b e10) {
                C1442a.m8291w("QueryPickedWelfaresTask", "queryPickedWelfaresTask err. " + e10.m60659c() + " " + e10.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(e10.getMessage());
                m63379e(this.f49611b, 6039, e10);
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }
}
