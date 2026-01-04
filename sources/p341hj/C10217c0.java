package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.NotifyReq;
import com.huawei.cloud.pay.model.OrderResult;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p454lj.C11296s;

/* renamed from: hj.c0 */
/* loaded from: classes5.dex */
public class C10217c0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49547b;

    /* renamed from: c */
    public NotifyReq f49548c;

    /* renamed from: d */
    public C11060c f49549d;

    /* renamed from: e */
    public boolean f49550e;

    public C10217c0(Handler handler, NotifyReq notifyReq, C11060c c11060c, boolean z10) {
        this.f49547b = handler;
        this.f49548c = notifyReq;
        this.f49549d = c11060c;
        this.f49550e = z10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            OrderResult orderResultM61651T = C9948a.m61631C().m61651T(this.f49548c, this.f49549d);
            this.f49549d.m66665u(String.valueOf(0));
            this.f49549d.m66635A("success");
            if (this.f49550e) {
                m63364h(orderResultM61651T);
                m63380f(this.f49547b, FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, orderResultM61651T);
            }
        } catch (C9721b e10) {
            C1442a.m8291w("GetNotifyTask", "getNotify err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49549d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49549d.m66635A(e10.getMessage());
            if (this.f49550e) {
                m63379e(this.f49547b, 2106, e10);
            }
        }
    }

    /* renamed from: h */
    public final void m63364h(OrderResult orderResult) {
        if (orderResult == null) {
            C1442a.m8291w("GetNotifyTask", "refreshMemGradeRightListCache, cloudspace is null");
        } else {
            C11296s.m67808c0(orderResult.getGradeRights());
        }
    }
}
