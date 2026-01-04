package p341hj;

import android.os.Handler;
import com.huawei.android.hicloud.logic.threadpool.TaskHandle;
import fk.C9721b;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p054cj.C1442a;

/* renamed from: hj.t */
/* loaded from: classes5.dex */
public class C10264t extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49713b;

    /* renamed from: c */
    public List<String> f49714c;

    /* renamed from: d */
    public List<String> f49715d;

    public C10264t(Handler handler, List<String> list, List<String> list2) {
        this.f49713b = handler;
        this.f49714c = list;
        this.f49715d = list2;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            TaskHandle taskHandleM63381g = new C10262s(this.f49713b, this.f49714c, this.f49715d, countDownLatch).m63381g();
            if (countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                C1442a.m8290i("GetAvaVouchersTimerTask", "GetAvaVouchersTimerTask GetAvaVochersTask success.");
            } else {
                taskHandleM63381g.cancel();
                C1442a.m8289e("GetAvaVouchersTimerTask", "GetAvaVouchersTimerTask GetAvaVochersTask time out.");
                m63379e(this.f49713b, 6030, new C9721b(102, "GetAvaVouchersTimerTask GetAvaVochersTask time out 5s."));
            }
        } catch (InterruptedException e10) {
            C1442a.m8289e("GetAvaVouchersTimerTask", "GetAvaVouchersTimerTask InterruptedException : " + e10.toString());
        }
    }
}
