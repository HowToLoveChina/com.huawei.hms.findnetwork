package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import fk.C9721b;
import p015ak.C0213f;
import p015ak.C0234s;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p454lj.C11282e;
import p709vj.C13452e;

/* renamed from: hj.y */
/* loaded from: classes5.dex */
public class C10274y extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49749b;

    /* renamed from: c */
    public C11060c f49750c;

    /* renamed from: d */
    public boolean f49751d;

    public C10274y(Handler handler, C11060c c11060c, boolean z10) {
        this.f49749b = handler;
        this.f49750c = c11060c;
        this.f49751d = z10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            GetClientUIConfigResp getClientUIConfigRespM61703z = C9948a.m61631C().m61703z(this.f49750c);
            this.f49750c.m66665u(String.valueOf(0));
            this.f49750c.m66635A("success");
            if (this.f49751d) {
                C11282e.m67709b(C0213f.m1377a()).m67716h("get_client_ui_config_cache_key", new Gson().toJson(getClientUIConfigRespM61703z));
            }
            if (!TextUtils.isEmpty(getClientUIConfigRespM61703z.getPromotionCardTitle())) {
                C13452e.m80781L().m80863U1(getClientUIConfigRespM61703z.getPromotionCardTitle());
                C13452e.m80781L().m80867V1(C0234s.m1632j());
            }
            m63380f(this.f49749b, 2002, getClientUIConfigRespM61703z);
        } catch (C9721b e10) {
            C1442a.m8291w("GetClientUIConfigTask", "get ui params err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49750c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49750c.m66635A(e10.getMessage());
            if (this.f49751d) {
                String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_client_ui_config_cache_key");
                if (!TextUtils.isEmpty(strM67711c)) {
                    C1442a.m8291w("GetClientUIConfigTask", "GetClientUIConfigTask get info faild, use cache. ");
                    try {
                        m63380f(this.f49749b, 2002, new Gson().fromJson(strM67711c, GetClientUIConfigResp.class));
                        return;
                    } catch (JsonSyntaxException e11) {
                        C1442a.m8289e("GetClientUIConfigTask", "GetClientUIConfigTask get info json faild : " + e11.getMessage());
                        m63379e(this.f49749b, 2102, e10);
                    }
                }
            }
            m63379e(this.f49749b, 2102, e10);
        }
    }
}
