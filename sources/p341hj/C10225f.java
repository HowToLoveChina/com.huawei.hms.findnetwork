package p341hj;

import android.os.Handler;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;

/* renamed from: hj.f */
/* loaded from: classes5.dex */
public class C10225f extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49574b;

    /* renamed from: c */
    public int f49575c;

    public C10225f(Handler handler, int i10) {
        this.f49574b = handler;
        this.f49575c = i10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            C11060c c11060c = new C11060c();
            c11060c.m66664t("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            m63380f(this.f49574b, 6013, C9948a.m61631C().m61664d(this.f49575c, c11060c));
        } catch (C9721b e10) {
            C1442a.m8289e("CalRefundFeeTask", "calrefundfee err:" + e10.m60659c());
            m63379e(this.f49574b, 6014, e10);
        }
    }
}
