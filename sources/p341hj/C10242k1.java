package p341hj;

import android.content.Context;
import android.os.Handler;
import com.huawei.cloud.pay.model.QuerySubOrderStatusResp;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p454lj.C11296s;

/* renamed from: hj.k1 */
/* loaded from: classes5.dex */
public class C10242k1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49636b;

    /* renamed from: c */
    public C11060c f49637c;

    /* renamed from: d */
    public String f49638d;

    /* renamed from: e */
    public Context f49639e;

    public C10242k1(Handler handler, C11060c c11060c, String str, Context context) {
        this.f49636b = handler;
        this.f49637c = c11060c;
        this.f49638d = str;
        this.f49639e = context;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            try {
                QuerySubOrderStatusResp querySubOrderStatusRespM61673h0 = C9948a.m61631C().m61673h0(this.f49637c, this.f49638d);
                this.f49637c.m66665u(String.valueOf(0));
                this.f49637c.m66635A("success");
                m63401h(querySubOrderStatusRespM61673h0);
                m63380f(this.f49636b, 2027, querySubOrderStatusRespM61673h0);
            } catch (C9721b e10) {
                C1442a.m8291w("QuerySubOrderStatusTask", "QuerySubOrderStatusTask err. " + e10.m60659c() + " " + e10.getMessage());
                C11060c c11060c = this.f49637c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060c.m66665u(sb2.toString());
                this.f49637c.m66635A(e10.getMessage());
                m63379e(this.f49636b, 2127, e10);
            }
        } finally {
            C11296s.m67816g0(this.f49639e);
        }
    }

    /* renamed from: h */
    public final void m63401h(QuerySubOrderStatusResp querySubOrderStatusResp) {
        if (querySubOrderStatusResp == null) {
            C1442a.m8291w("QuerySubOrderStatusTask", "refreshMemGradeRightListCache, cloudspace is null");
        } else {
            C11296s.m67808c0(querySubOrderStatusResp.getGradeRights());
        }
    }
}
