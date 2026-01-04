package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.Response;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p709vj.C13452e;

/* renamed from: hj.e1 */
/* loaded from: classes5.dex */
public class C10224e1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49572b;

    /* renamed from: c */
    public C11060c f49573c;

    public C10224e1(Handler handler, C11060c c11060c) {
        this.f49572b = handler;
        this.f49573c = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            Response responseM61661b0 = C9948a.m61631C().m61661b0(this.f49573c);
            C13452e.m80781L().m80937k2(true);
            m63380f(this.f49572b, 2023, responseM61661b0);
        } catch (C9721b e10) {
            C1442a.m8291w("QueryCardSupportTask", "QueryCardSupportTask err. " + e10.m60659c() + " " + e10.getMessage());
            C13452e.m80781L().m80937k2(false);
            this.f49573c.m66665u("114_" + e10.m60659c());
            this.f49573c.m66635A(e10.getMessage());
            m63379e(this.f49572b, 2123, e10);
        }
    }
}
