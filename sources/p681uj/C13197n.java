package p681uj;

import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.api.pay.HuaweiPay;
import com.huawei.hms.support.api.pay.PayResult;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: uj.n */
/* loaded from: classes5.dex */
public class C13197n {

    /* renamed from: a */
    public static C13197n f59812a = new C13197n();

    /* renamed from: uj.n$a */
    public class a extends c {
        public a(WithholdRequest withholdRequest, ResultCallback resultCallback) {
            super(withholdRequest, resultCallback);
        }
    }

    /* renamed from: uj.n$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public PayReq f59814a;

        /* renamed from: b */
        public ResultCallback<PayResult> f59815b;

        public b(PayReq payReq, ResultCallback<PayResult> resultCallback) {
            this.f59814a = payReq;
            this.f59815b = resultCallback;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13192i c13192iM79258g = C13192i.m79258g();
            HuaweiApiClient huaweiApiClientM79260e = c13192iM79258g.m79260e();
            if (huaweiApiClientM79260e != null) {
                try {
                    HuaweiPay.HuaweiPayApi.pay(huaweiApiClientM79260e, this.f59814a).setResultCallback(this.f59815b);
                } finally {
                    c13192iM79258g.m79261f();
                }
            } else {
                BaseLogger.m28731e("HmsHwPay", "pay failed: connect to hms failed.");
                PayResult payResult = new PayResult();
                payResult.setStatus(Status.FAILURE);
                this.f59815b.onResult(payResult);
            }
        }
    }

    /* renamed from: uj.n$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public WithholdRequest f59816a;

        /* renamed from: b */
        public ResultCallback<PayResult> f59817b;

        public c(WithholdRequest withholdRequest, ResultCallback<PayResult> resultCallback) {
            this.f59816a = withholdRequest;
            this.f59817b = resultCallback;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13192i c13192iM79258g = C13192i.m79258g();
            HuaweiApiClient huaweiApiClientM79260e = c13192iM79258g.m79260e();
            if (huaweiApiClientM79260e != null) {
                try {
                    HuaweiPay.HuaweiPayApi.addWithholdingPlan(huaweiApiClientM79260e, this.f59816a).setResultCallback(this.f59817b);
                } finally {
                    c13192iM79258g.m79261f();
                }
            } else {
                BaseLogger.m28731e("HmsHwPay", "Withhold failed: connect to hms failed.");
                PayResult payResult = new PayResult();
                payResult.setStatus(Status.FAILURE);
                this.f59817b.onResult(payResult);
            }
        }
    }

    /* renamed from: a */
    public static C13197n m79381a() {
        return f59812a;
    }

    /* renamed from: b */
    public void m79382b(PayReq payReq, ResultCallback<PayResult> resultCallback) {
        C12515a.m75110o().m75172d(new b(payReq, resultCallback));
    }

    /* renamed from: c */
    public void m79383c(WithholdRequest withholdRequest, ResultCallback<PayResult> resultCallback) {
        C12515a.m75110o().m75172d(new a(withholdRequest, resultCallback));
    }
}
