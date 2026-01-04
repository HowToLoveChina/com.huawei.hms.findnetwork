package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.GetRecommendActivityResp;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import fk.C9721b;
import java.util.HashMap;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.e0 */
/* loaded from: classes5.dex */
public class C10223e0 extends AbstractC10259q0 {

    /* renamed from: a */
    public Handler f49569a;

    /* renamed from: b */
    public List<Integer> f49570b;

    /* renamed from: c */
    public int f49571c;

    public C10223e0(Handler handler, List<Integer> list, int i10) {
        this.f49569a = handler;
        this.f49570b = list;
        this.f49571c = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07023"), "getRecommendActivity", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        List<Integer> list = this.f49570b;
        if (list != null) {
            map.put("requestActivityTypeList", list.toString());
        }
        map.put("requestSource", String.valueOf(this.f49571c));
        try {
            try {
                GetRecommendActivityResp getRecommendActivityRespM61640I = C9948a.m61631C().m61640I(this.f49570b, this.f49571c, c11060cM66626a);
                List<Integer> list2 = this.f49570b;
                if (list2 == null || list2.get(0).intValue() != 4) {
                    m63427e(this.f49569a, 7016, getRecommendActivityRespM61640I);
                } else {
                    m63427e(this.f49569a, 7018, getRecommendActivityRespM61640I);
                }
                if (getRecommendActivityRespM61640I != null) {
                    map.put(TrackConstants$Opers.RESPONSE, getRecommendActivityRespM61640I.toString());
                }
            } catch (C9721b e10) {
                C1442a.m8289e("GetRecommendActivityTask", "getRecommendActivity error: " + e10.toString());
                List<Integer> list3 = this.f49570b;
                if (list3 == null || list3.get(0).intValue() != 4) {
                    m63425c(this.f49569a, 7017, e10);
                } else {
                    m63425c(this.f49569a, 7020, e10);
                }
                map.put("responseError", e10.toString());
            }
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Throwable th2) {
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
            throw th2;
        }
    }
}
