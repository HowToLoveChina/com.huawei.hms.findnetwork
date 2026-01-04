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

/* renamed from: hj.b0 */
/* loaded from: classes5.dex */
public class C10214b0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49544b;

    /* renamed from: c */
    public String f49545c;

    public C10214b0(Handler handler, String str) {
        this.f49544b = handler;
        this.f49545c = str;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06008"), "getGradeRightDetail", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                m63380f(this.f49544b, 6021, C9948a.m61631C().m61634B(c11060cM66626a, this.f49545c, 0));
            } catch (C9721b e10) {
                C1442a.m8291w("GetGradeRightDetailTask", "getAvailablePackages err. " + e10.m60659c() + " " + e10.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(e10.getMessage());
                m63379e(this.f49544b, 6022, e10);
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }
}
