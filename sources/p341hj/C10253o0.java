package p341hj;

import android.os.Handler;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import fk.C9721b;
import io.C10582a;
import p054cj.C1442a;
import p429kk.C11060c;

/* renamed from: hj.o0 */
/* loaded from: classes5.dex */
public class C10253o0 extends AbstractC10222e {

    /* renamed from: b */
    public C11060c f49671b;

    /* renamed from: c */
    public Handler f49672c;

    public C10253o0(C11060c c11060c, Handler handler) {
        this.f49671b = c11060c;
        this.f49672c = handler;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            C1442a.m8290i("GetUserRegisterTask", "GetUserRegisterTask start.");
            GetUserRegisterResp getUserRegisterRespM64942k = new C10582a(this.f49671b.m66661q()).m64942k();
            this.f49671b.m66665u(String.valueOf(0));
            this.f49671b.m66635A("success");
            C1442a.m8290i("GetUserRegisterTask", "GetUserRegisterTask success.");
            m63380f(this.f49672c, 6007, getUserRegisterRespM64942k);
        } catch (C9721b e10) {
            C1442a.m8291w("GetUserRegisterTask", "GetUserRegisterTask fail.");
            this.f49671b.m66665u("114_" + e10.m60659c());
            this.f49671b.m66635A(e10.getMessage());
            m63379e(this.f49672c, 6008, e10);
        }
    }
}
