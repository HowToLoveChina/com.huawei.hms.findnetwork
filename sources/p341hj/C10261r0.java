package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.MonthDetail;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.r0 */
/* loaded from: classes5.dex */
public class C10261r0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49701b;

    /* renamed from: c */
    public C11060c f49702c;

    /* renamed from: d */
    public int f49703d;

    /* renamed from: e */
    public String f49704e;

    public C10261r0(Handler handler, C11060c c11060c) {
        this.f49701b = handler;
        this.f49702c = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        MonthDetail monthDetailM61635D;
        try {
            int i10 = 2133;
            if (!TextUtils.isEmpty(this.f49704e)) {
                monthDetailM61635D = C9948a.m61631C().m61636E(this.f49702c, this.f49703d, this.f49704e);
            } else if (this.f49703d == 2) {
                monthDetailM61635D = C9948a.m61631C().m61636E(this.f49702c, 2, null);
            } else {
                monthDetailM61635D = C9948a.m61631C().m61635D(this.f49702c);
                i10 = FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
            }
            C1442a.m8290i("MonthDetailTask", "worryFree requestScheme: " + this.f49703d);
            this.f49702c.m66665u(String.valueOf(0));
            this.f49702c.m66635A("success");
            m63380f(this.f49701b, i10, monthDetailM61635D);
        } catch (C9721b e10) {
            C1442a.m8291w("MonthDetailTask", "month detail err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49702c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49702c.m66635A(e10.getMessage());
            m63379e(this.f49701b, (!TextUtils.isEmpty(this.f49704e) || this.f49703d == 2) ? 2132 : 2117, e10);
        }
    }

    public C10261r0(Handler handler, C11060c c11060c, int i10, String str) {
        this.f49701b = handler;
        this.f49702c = c11060c;
        this.f49703d = i10;
        this.f49704e = str;
    }
}
