package p341hj;

import android.os.Handler;
import fk.C9721b;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.s */
/* loaded from: classes5.dex */
public class C10262s extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49705b;

    /* renamed from: c */
    public List<String> f49706c;

    /* renamed from: d */
    public List<String> f49707d;

    /* renamed from: e */
    public CountDownLatch f49708e;

    public C10262s(Handler handler, List<String> list, List<String> list2) {
        this.f49705b = handler;
        this.f49706c = list;
        this.f49707d = list2;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06010"), "getAvaVouchers", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                m63380f(this.f49705b, 6029, C9948a.m61631C().m61695t(c11060cM66626a, this.f49706c, this.f49707d));
            } catch (C9721b e10) {
                C1442a.m8291w("GetAvaVochersTask", "GetAvaVochersTask err. " + e10.m60659c() + " " + e10.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(e10.getMessage());
                m63379e(this.f49705b, 6030, e10);
                CountDownLatch countDownLatch = this.f49708e;
                if (countDownLatch != null) {
                }
            }
        } finally {
            CountDownLatch countDownLatch2 = this.f49708e;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    public C10262s(Handler handler, List<String> list, List<String> list2, CountDownLatch countDownLatch) {
        this.f49705b = handler;
        this.f49706c = list;
        this.f49707d = list2;
        this.f49708e = countDownLatch;
    }
}
