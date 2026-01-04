package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.MonthOrder;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.Map;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.s0 */
/* loaded from: classes5.dex */
public class C10263s0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49709b;

    /* renamed from: c */
    public String f49710c;

    /* renamed from: d */
    public C11060c f49711d;

    /* renamed from: e */
    public Map<String, String> f49712e;

    public C10263s0(Handler handler, String str, C11060c c11060c, Map<String, String> map) {
        this.f49709b = handler;
        this.f49710c = str;
        this.f49711d = c11060c;
        this.f49712e = map;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            MonthOrder monthOrderM61672h = C9948a.m61631C().m61672h(this.f49710c, this.f49711d, this.f49712e);
            this.f49711d.m66665u(String.valueOf(0));
            this.f49711d.m66635A("success");
            m63380f(this.f49709b, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, monthOrderM61672h);
        } catch (C9721b e10) {
            C1442a.m8291w("MonthOrderTask", "create month order err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49711d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49711d.m66635A(e10.getMessage());
            m63379e(this.f49709b, 2116, e10);
        }
    }
}
