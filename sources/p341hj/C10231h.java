package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.CardPayReq;
import com.huawei.cloud.pay.model.CardPayResp;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.h */
/* loaded from: classes5.dex */
public class C10231h extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49592b;

    /* renamed from: c */
    public String f49593c;

    /* renamed from: d */
    public String f49594d;

    /* renamed from: e */
    public C11060c f49595e;

    /* renamed from: f */
    public Long f49596f;

    /* renamed from: g */
    public Integer f49597g;

    public C10231h(Handler handler, String str, String str2, C11060c c11060c) {
        this.f49592b = handler;
        this.f49593c = str;
        this.f49594d = str2;
        this.f49595e = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            CardPayResp cardPayRespM61652U = (this.f49597g == null || this.f49596f == null) ? C9948a.m61631C().m61652U(new CardPayReq(this.f49593c, this.f49594d), this.f49595e) : C9948a.m61631C().m61652U(new CardPayReq(this.f49593c, this.f49594d, this.f49596f.longValue(), this.f49597g.intValue()), this.f49595e);
            this.f49595e.m66665u(String.valueOf(0));
            this.f49595e.m66635A("success");
            m63380f(this.f49592b, 2009, cardPayRespM61652U);
        } catch (C9721b e10) {
            C1442a.m8291w("CreateCardTask", "card pay err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49595e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49595e.m66635A(e10.getMessage());
            m63379e(this.f49592b, 2109, e10);
        }
    }

    public C10231h(Handler handler, String str, String str2, C11060c c11060c, long j10, int i10) {
        this.f49592b = handler;
        this.f49593c = str;
        this.f49594d = str2;
        this.f49595e = c11060c;
        this.f49596f = Long.valueOf(j10);
        this.f49597g = Integer.valueOf(i10);
    }
}
