package p341hj;

import android.os.Handler;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.t0 */
/* loaded from: classes5.dex */
public class C10265t0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49716b;

    /* renamed from: c */
    public C11060c f49717c;

    /* renamed from: d */
    public boolean f49718d;

    public C10265t0(Handler handler, C11060c c11060c) {
        this.f49716b = handler;
        this.f49717c = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            if (this.f49718d) {
                C9948a.m61631C().m61668f(this.f49717c);
            } else {
                C9948a.m61631C().m61666e(this.f49717c);
            }
            this.f49717c.m66665u(String.valueOf(0));
            this.f49717c.m66635A("success");
            m63380f(this.f49716b, FamilyShareConstants.MessageCode.GET_USERPACKAGE_FOR_INVITE_FAMILY_MEMBER, null);
        } catch (C9721b e10) {
            C1442a.m8291w("MonthPayCancelTask", "cancel month pay err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49717c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49717c.m66635A(e10.getMessage());
            m63379e(this.f49716b, 2119, e10);
        }
    }

    public C10265t0(Handler handler, C11060c c11060c, boolean z10) {
        this.f49716b = handler;
        this.f49717c = c11060c;
        this.f49718d = z10;
    }
}
