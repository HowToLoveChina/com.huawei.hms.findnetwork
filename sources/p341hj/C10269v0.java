package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.VouchersTaskInfo;
import dj.C9158a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p054cj.C1442a;

/* renamed from: hj.v0 */
/* loaded from: classes5.dex */
public class C10269v0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49734b;

    /* renamed from: c */
    public VouchersTaskInfo f49735c;

    /* renamed from: d */
    public CountDownLatch f49736d;

    public C10269v0(Handler handler, VouchersTaskInfo vouchersTaskInfo, CountDownLatch countDownLatch) {
        this.f49734b = handler;
        this.f49735c = vouchersTaskInfo;
        this.f49736d = countDownLatch;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            try {
                C9158a.m57503F().m57554s(this.f49734b, this.f49735c);
                C9158a.m57503F().m57528Z(this.f49734b);
                this.f49736d.await(5L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                C1442a.m8291w("ObtainVouchersTask", "ObtainVouchersTask is interrupted");
            } catch (Exception e10) {
                C1442a.m8291w("ObtainVouchersTask", "ObtainVouchersTask exception=" + e10.toString());
            }
        } finally {
            m63380f(this.f49734b, 6040, null);
        }
    }
}
