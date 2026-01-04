package p341hj;

import android.os.Handler;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.x0 */
/* loaded from: classes5.dex */
public class C10273x0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49746b;

    /* renamed from: c */
    public String f49747c;

    /* renamed from: d */
    public C11060c f49748d;

    public C10273x0(Handler handler, String str, C11060c c11060c) {
        this.f49746b = handler;
        this.f49747c = str;
        this.f49748d = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            m63380f(this.f49746b, 7056, C9948a.m61631C().m61653V(this.f49747c, this.f49748d).getWelfareList().get(0));
        } catch (C9721b e10) {
            C1442a.m8291w("MonthSignTask", "QueryCardSupportTask err. " + e10.m60659c() + " " + e10.getMessage());
            m63379e(this.f49746b, 7055, e10);
        }
    }
}
