package p341hj;

import com.huawei.cloud.pay.model.Response;
import fk.C9721b;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9949b;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.g */
/* loaded from: classes5.dex */
public class C10228g extends AbstractC10222e {

    /* renamed from: b */
    public final String f49587b;

    /* renamed from: c */
    public final a f49588c;

    /* renamed from: hj.g$a */
    public interface a {
        /* renamed from: a */
        void mo63392a(Response response);

        void onError(String str);
    }

    public C10228g(String str, a aVar) {
        this.f49587b = str;
        this.f49588c = aVar;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C1442a.m8288d("CampaignReportAfterMsgTask", "CampaignReportAfterMsgTask, reqBody: " + this.f49587b);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06023"), "/reportAfterMsg", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                this.f49588c.mo63392a(C9949b.m61704j().m61706b(c11060cM66626a, this.f49587b));
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignReportAfterMsgTask", "CampaignReportAfterMsgTask error:" + e10.getMessage());
                c11060cM66626a.m66665u("114_" + e10.m60659c());
                c11060cM66626a.m66635A(e10.getMessage());
                this.f49588c.onError(e10.getMessage());
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }
}
