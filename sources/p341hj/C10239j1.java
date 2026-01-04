package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.QuerySignStatusResp;
import com.huawei.cloud.pay.model.VoucherInfo;
import fk.C9721b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.j1 */
/* loaded from: classes5.dex */
public class C10239j1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49624b;

    /* renamed from: c */
    public C11060c f49625c;

    /* renamed from: d */
    public String f49626d;

    /* renamed from: e */
    public int f49627e;

    /* renamed from: f */
    public List<VoucherInfo> f49628f;

    /* renamed from: g */
    public ChannelInfo f49629g;

    /* renamed from: h */
    public Map<String, String> f49630h;

    /* renamed from: i */
    public BigDecimal f49631i;

    public C10239j1(Handler handler, C11060c c11060c, String str, int i10, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        this.f49624b = handler;
        this.f49625c = c11060c;
        this.f49626d = str;
        this.f49627e = i10;
        this.f49628f = new ArrayList();
        this.f49629g = channelInfo;
        this.f49630h = map;
        this.f49631i = bigDecimal;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            QuerySignStatusResp querySignStatusRespM61671g0 = C9948a.m61631C().m61671g0(this.f49625c, this.f49626d, this.f49627e, 1, this.f49628f, this.f49629g, this.f49630h, this.f49631i);
            this.f49625c.m66665u(String.valueOf(0));
            this.f49625c.m66635A("success");
            m63380f(this.f49624b, 2025, querySignStatusRespM61671g0);
        } catch (C9721b e10) {
            C1442a.m8291w("QuerySignStatusTask", "querySignStatusTask err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49625c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49625c.m66635A(e10.getMessage());
            m63379e(this.f49624b, 2125, e10);
        }
    }

    public C10239j1(Handler handler, C11060c c11060c, String str, int i10, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        this.f49624b = handler;
        this.f49625c = c11060c;
        this.f49626d = str;
        this.f49627e = i10;
        this.f49628f = list;
        this.f49629g = channelInfo;
        this.f49630h = map;
        this.f49631i = bigDecimal;
    }
}
