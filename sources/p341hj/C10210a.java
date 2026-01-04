package p341hj;

import android.os.Bundle;
import android.os.Handler;
import com.huawei.cloud.pay.model.AcceptRightGiftResp;
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

/* renamed from: hj.a */
/* loaded from: classes5.dex */
public class C10210a extends AbstractC10259q0 {

    /* renamed from: a */
    public Handler f49534a;

    /* renamed from: b */
    public Map<String, String> f49535b;

    /* renamed from: c */
    public String f49536c;

    /* renamed from: d */
    public int f49537d;

    public C10210a(Handler handler, Map<String, String> map, String str, int i10) {
        this.f49534a = handler;
        this.f49535b = map;
        this.f49536c = str;
        this.f49537d = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07017"), "acceptRightGift", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        Map<String, String> map2 = this.f49535b;
        if (map2 != null) {
            map.put("requestCampInfo", map2.toString());
        }
        try {
            try {
                AcceptRightGiftResp acceptRightGiftRespM61658a = C9948a.m61631C().m61658a(this.f49535b, c11060cM66626a);
                Bundle bundle = new Bundle();
                bundle.putString("adPackageName", this.f49536c);
                bundle.putInt("retryCount", this.f49537d);
                m63428f(this.f49534a, 7009, acceptRightGiftRespM61658a, bundle);
                if (acceptRightGiftRespM61658a != null) {
                    map.put(TrackConstants$Opers.RESPONSE, acceptRightGiftRespM61658a.toString());
                }
            } catch (C9721b e10) {
                C1442a.m8289e("AcceptRightGiftTask", "acceptRightGift error: " + e10.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putString("adPackageName", this.f49536c);
                bundle2.putInt("retryCount", this.f49537d);
                m63426d(this.f49534a, 7010, e10, bundle2);
                map.put("responseError", e10.toString());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        }
    }
}
