package p341hj;

import android.os.Handler;
import android.os.Message;
import com.huawei.cloud.pay.model.MonthDetail;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.UserPackage;
import dj.C9158a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p054cj.C1442a;
import p429kk.C11060c;

/* renamed from: hj.f0 */
/* loaded from: classes5.dex */
public class C10226f0 extends AbstractC10222e {

    /* renamed from: b */
    public CountDownLatch f49576b;

    /* renamed from: c */
    public final C11060c f49577c;

    /* renamed from: d */
    public final Handler f49578d;

    /* renamed from: e */
    public final String f49579e;

    /* renamed from: f */
    public UserPackage f49580f;

    /* renamed from: g */
    public MonthDetail f49581g;

    /* renamed from: h */
    public final TerminationRetentionData f49582h = new TerminationRetentionData();

    /* renamed from: i */
    public Handler f49583i = new a();

    /* renamed from: hj.f0$a */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1442a.m8290i("GetRetentionInfoTask", "retentionInfoHandler , what = " + message.what);
            int i10 = message.what;
            if (i10 == 2001) {
                C10226f0.this.m63389o(message.obj);
                return;
            }
            if (i10 == 2101) {
                C1442a.m8289e("GetRetentionInfoTask", "GET_USERPACKAGE_FAILED , errCode = " + message.arg1);
                C10226f0.this.m63387m();
                return;
            }
            if (i10 == 2132) {
                C1442a.m8289e("GetRetentionInfoTask", "GETMONTHPAY_FAILED_WORRY_FREE , errCode = " + message.arg1);
                C10226f0.this.m63387m();
                return;
            }
            if (i10 == 2133) {
                C10226f0.this.m63388n(message.obj);
                return;
            }
            C1442a.m8289e("GetRetentionInfoTask", "invalid type = " + message.what + " errCode = " + message.arg1);
            C10226f0.this.m63387m();
        }
    }

    public C10226f0(C11060c c11060c, Handler handler, String str) {
        this.f49577c = c11060c;
        this.f49578d = handler;
        this.f49579e = str;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        this.f49576b = new CountDownLatch(2);
        C9158a.m57503F().m57517O(this.f49583i, this.f49577c, false, true, "GetRetentionInfoTask");
        C9158a.m57503F().m57526X(this.f49583i, this.f49577c, -1, this.f49579e);
        try {
            if (this.f49576b.await(5000L, TimeUnit.MILLISECONDS)) {
                C1442a.m8290i("GetRetentionInfoTask", "GetRetentionInfoTask all task success");
            } else {
                C1442a.m8289e("GetRetentionInfoTask", "GetRetentionInfoTask request timeout");
                m63387m();
            }
        } catch (InterruptedException e10) {
            C1442a.m8289e("GetRetentionInfoTask", "GetRetentionInfoTask exception:" + e10.getMessage());
            m63387m();
        }
    }

    /* renamed from: k */
    public final void m63385k() {
        CountDownLatch countDownLatch = this.f49576b;
        if (countDownLatch == null) {
            C1442a.m8289e("GetRetentionInfoTask", "clearCountDown,countDownLatch is null.");
            return;
        }
        long count = countDownLatch.getCount();
        if (count <= 0) {
            C1442a.m8289e("GetRetentionInfoTask", "clearCountDown,count <= 0.");
            return;
        }
        for (long j10 = 0; j10 < count; j10++) {
            this.f49576b.countDown();
        }
    }

    /* renamed from: l */
    public final void m63386l() {
        if (m63391q()) {
            C1442a.m8290i("GetRetentionInfoTask", "dealAllRespose start");
            m63385k();
            if (this.f49581g.getCurProductType() == 12) {
                this.f49582h.setDialogType(7054);
            }
            m63390p();
        }
    }

    /* renamed from: m */
    public final void m63387m() {
        C1442a.m8289e("GetRetentionInfoTask", "dealGetInfoErr");
        m63385k();
        Handler handler = this.f49578d;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 7060;
            this.f49578d.sendMessage(messageObtainMessage);
        } else {
            C1442a.m8289e("GetRetentionInfoTask", "dealGetInfoErr , callbackHandler is null.");
        }
        Handler handler2 = this.f49583i;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: n */
    public final void m63388n(Object obj) {
        if (!(obj instanceof MonthDetail)) {
            C1442a.m8289e("GetRetentionInfoTask", "dealGetMonthPaySuccess , obj is null.");
            m63387m();
            return;
        }
        MonthDetail monthDetail = (MonthDetail) obj;
        this.f49581g = monthDetail;
        this.f49582h.setProductType(monthDetail.getCurProductType());
        this.f49582h.setMonthDetail(this.f49581g);
        m63386l();
    }

    /* renamed from: o */
    public final void m63389o(Object obj) {
        if (!(obj instanceof UserPackage)) {
            C1442a.m8289e("GetRetentionInfoTask", "dealGetUserPackageSuccess , obj is null.");
            m63387m();
        } else {
            UserPackage userPackage = (UserPackage) obj;
            this.f49580f = userPackage;
            this.f49582h.setUserPackage(userPackage);
            m63386l();
        }
    }

    /* renamed from: p */
    public final void m63390p() {
        C1442a.m8290i("GetRetentionInfoTask", "finishCallback");
        Handler handler = this.f49578d;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 7061;
            messageObtainMessage.obj = this.f49582h;
            this.f49578d.sendMessage(messageObtainMessage);
        } else {
            C1442a.m8289e("GetRetentionInfoTask", "finishCallback , callbackHandler is null.");
        }
        Handler handler2 = this.f49583i;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: q */
    public final boolean m63391q() {
        if (this.f49580f == null) {
            C1442a.m8289e("GetRetentionInfoTask", "data is not ok , userPackage is null.");
            return false;
        }
        if (this.f49581g != null) {
            return true;
        }
        C1442a.m8289e("GetRetentionInfoTask", "data is not ok , monthDetail is null.");
        return false;
    }
}
