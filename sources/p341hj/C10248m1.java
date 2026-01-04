package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.ReportCampaignResp;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import fk.C9721b;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.m1 */
/* loaded from: classes5.dex */
public class C10248m1 extends AbstractC10259q0 {

    /* renamed from: a */
    public Handler f49657a;

    /* renamed from: b */
    public Map<String, String> f49658b;

    public C10248m1(Handler handler, Map<String, String> map) {
        this.f49657a = handler;
        this.f49658b = map;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07017"), "reportCampaign", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        Map<String, String> map2 = this.f49658b;
        if (map2 != null) {
            map.put("requestCampInfo", map2.toString());
        }
        try {
            try {
                ReportCampaignResp reportCampaignRespM61681l0 = C9948a.m61631C().m61681l0(this.f49658b, c11060cM66626a);
                m63427e(this.f49657a, 7005, reportCampaignRespM61681l0);
                if (reportCampaignRespM61681l0 != null) {
                    map.put(TrackConstants$Opers.RESPONSE, reportCampaignRespM61681l0.toString());
                }
            } catch (C9721b e10) {
                C1442a.m8289e("ReportCampaignDownloadTask", "reportCampaign download error: " + e10.toString());
                m63425c(this.f49657a, 7006, e10);
                map.put("responseError", e10.toString());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        }
    }
}
