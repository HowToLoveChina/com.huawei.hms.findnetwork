package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.AcceptSignGiftResp;
import com.huawei.cloud.pay.model.CampaignInfo;
import fk.C9721b;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p746wn.C13622a;

/* renamed from: hj.b */
/* loaded from: classes5.dex */
public class C10213b extends AbstractC10222e {

    /* renamed from: b */
    public C11060c f49541b;

    /* renamed from: c */
    public Handler f49542c;

    /* renamed from: d */
    public CampaignInfo f49543d;

    public C10213b(C11060c c11060c, Handler handler, CampaignInfo campaignInfo) {
        this.f49541b = c11060c;
        this.f49542c = handler;
        this.f49543d = campaignInfo;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            try {
                AcceptSignGiftResp acceptSignGiftRespM61660b = C9948a.m61631C().m61660b(this.f49541b, this.f49543d);
                this.f49541b.m66665u(String.valueOf(0));
                this.f49541b.m66635A("success");
                m63380f(this.f49542c, 7044, acceptSignGiftRespM61660b);
            } catch (C9721b e10) {
                C1442a.m8289e("AcceptSignGiftTask", "AcceptSignGiftTask err. " + e10.m60659c() + " " + e10.getMessage());
                C11060c c11060c = this.f49541b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060c.m66665u(sb2.toString());
                this.f49541b.m66635A(e10.getMessage());
                m63379e(this.f49542c, 7045, e10);
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), this.f49541b);
        }
    }
}
