package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.MonthSign;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.u0 */
/* loaded from: classes5.dex */
public class C10267u0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49729b;

    /* renamed from: c */
    public String f49730c;

    /* renamed from: d */
    public C11060c f49731d;

    public C10267u0(Handler handler, String str, C11060c c11060c) {
        this.f49729b = handler;
        this.f49730c = str;
        this.f49731d = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            MonthSign monthSignM61641J = C9948a.m61631C().m61641J(this.f49730c, this.f49731d);
            this.f49731d.m66665u(String.valueOf(0));
            this.f49731d.m66635A("success");
            m63380f(this.f49729b, 2015, monthSignM61641J);
        } catch (C9721b e10) {
            C1442a.m8291w("MonthSignTask", "create month sign err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49731d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49731d.m66635A(e10.getMessage());
            m63379e(this.f49729b, 2115, e10);
        }
    }
}
