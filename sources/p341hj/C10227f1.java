package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.QueryGiftableWelfaresResp;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.f1 */
/* loaded from: classes5.dex */
public class C10227f1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49585b;

    /* renamed from: c */
    public C11060c f49586c;

    public C10227f1(Handler handler, C11060c c11060c) {
        this.f49585b = handler;
        this.f49586c = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            QueryGiftableWelfaresResp queryGiftableWelfaresRespM61663c0 = C9948a.m61631C().m61663c0(this.f49586c);
            if (queryGiftableWelfaresRespM61663c0 == null) {
                m63380f(this.f49585b, 7054, null);
                return;
            }
            if (queryGiftableWelfaresRespM61663c0.getPickedWelfare() != null) {
                m63380f(this.f49585b, 7053, queryGiftableWelfaresRespM61663c0.getPickedWelfare());
            } else if (queryGiftableWelfaresRespM61663c0.getGiftableWelfare() != null) {
                m63380f(this.f49585b, 7052, queryGiftableWelfaresRespM61663c0.getGiftableWelfare());
            } else {
                m63380f(this.f49585b, 7054, null);
            }
        } catch (C9721b e10) {
            C1442a.m8291w("QueryGiftableWelfaresTask", "QueryGiftableWelfaresTask err. " + e10.m60659c() + " " + e10.getMessage());
            m63380f(this.f49585b, 7054, null);
        }
    }
}
