package p341hj;

import android.content.Context;
import android.os.Handler;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CreateFreeOrderResp;
import fk.C9721b;
import java.math.BigDecimal;
import java.util.Map;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p454lj.C11296s;

/* renamed from: hj.i */
/* loaded from: classes5.dex */
public class C10234i extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49600b;

    /* renamed from: c */
    public C11060c f49601c;

    /* renamed from: d */
    public String f49602d;

    /* renamed from: e */
    public Context f49603e;

    /* renamed from: f */
    public ChannelInfo f49604f;

    /* renamed from: g */
    public Map<String, String> f49605g;

    /* renamed from: h */
    public BigDecimal f49606h;

    public C10234i(Handler handler, C11060c c11060c, String str, Context context, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        this.f49600b = handler;
        this.f49601c = c11060c;
        this.f49602d = str;
        this.f49603e = context;
        this.f49604f = channelInfo;
        this.f49605g = map;
        this.f49606h = bigDecimal;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            try {
                CreateFreeOrderResp createFreeOrderRespM61670g = C9948a.m61631C().m61670g(this.f49601c, this.f49602d, this.f49604f, this.f49605g, this.f49606h);
                this.f49601c.m66665u(String.valueOf(0));
                this.f49601c.m66635A("success");
                m63393h(createFreeOrderRespM61670g);
                m63380f(this.f49600b, 2026, createFreeOrderRespM61670g);
            } catch (C9721b e10) {
                C1442a.m8291w("CreateFreeOrderTask", "CreateFreeOrderTask err. " + e10.m60659c() + " " + e10.getMessage());
                C11060c c11060c = this.f49601c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060c.m66665u(sb2.toString());
                this.f49601c.m66635A(e10.getMessage());
                m63379e(this.f49600b, 2126, e10);
            }
        } finally {
            C11296s.m67816g0(this.f49603e);
        }
    }

    /* renamed from: h */
    public final void m63393h(CreateFreeOrderResp createFreeOrderResp) {
        if (createFreeOrderResp == null) {
            C1442a.m8291w("CreateFreeOrderTask", "refreshMemGradeRightListCache, cloudspace is null");
        } else {
            C11296s.m67808c0(createFreeOrderResp.getGradeRights());
        }
    }
}
