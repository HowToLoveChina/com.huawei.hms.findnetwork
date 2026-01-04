package com.huawei.hms.support.api.paytask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.iap.util.C5659a;
import com.huawei.hms.support.api.entity.pay.HwWalletInfoRequest;
import com.huawei.hms.support.api.entity.pay.InternalPayRequest;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoRequest;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.api.pay.GetWalletUiIntentResult;
import com.huawei.hms.support.api.pay.HwWalletInfoResult;
import com.huawei.hms.support.api.pay.OrderResult;
import com.huawei.hms.support.api.pay.PayResult;
import com.huawei.hms.support.api.pay.PayResultInfo;
import com.huawei.hms.support.api.pay.ProductDetailResult;
import com.huawei.hms.support.api.pay.ProductPayResultInfo;
import com.huawei.hms.support.api.pay.PurchaseInfoResult;
import com.huawei.hms.support.api.paytask.fullsdk.FailureTask;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class PayClientEntryImpl implements PayClient {

    /* renamed from: a */
    private WeakReference<Context> f29845a;

    /* renamed from: b */
    private PayClientImpl f29846b;

    /* renamed from: c */
    private PayClientFullImpl f29847c;

    public PayClientEntryImpl(Activity activity) {
        this.f29845a = new WeakReference<>(activity);
    }

    /* renamed from: a */
    private PayClientImpl m36679a() {
        if (this.f29846b == null) {
            Context context = this.f29845a.get();
            if (context == null) {
                HMSLog.m36986e("PayClientImpl", "getPayClientImpl context is null.");
                return null;
            }
            this.f29846b = context instanceof Activity ? new PayClientImpl((Activity) context) : new PayClientImpl(context);
        }
        return this.f29846b;
    }

    /* renamed from: b */
    private PayClientFullImpl m36680b() {
        if (this.f29847c == null) {
            Context context = this.f29845a.get();
            if (context == null) {
                HMSLog.m36986e("PayClientImpl", "getPayClientFullImpl context is null.");
                return null;
            }
            this.f29847c = new PayClientFullImpl(context);
        }
        return this.f29847c;
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> addWithholdingPlan(WithholdRequest withholdRequest) {
        Checker.checkNonNull(withholdRequest);
        Context context = this.f29845a.get();
        if (context == null) {
            return new FailureTask();
        }
        if (C5659a.m33015a(context, withholdRequest.reservedInfor, withholdRequest.country, withholdRequest.currency, "Withhold")) {
            HMSLog.m36988i("PayClientImpl", "withhold with Full SDK branch.");
            PayClientFullImpl payClientFullImplM36680b = m36680b();
            return payClientFullImplM36680b != null ? payClientFullImplM36680b.addWithholdingPlan(withholdRequest) : new FailureTask();
        }
        HMSLog.m36988i("PayClientImpl", "withhold with IAP SDK branch.");
        PayClientImpl payClientImplM36679a = m36679a();
        return payClientImplM36679a != null ? payClientImplM36679a.addWithholdingPlan(withholdRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<OrderResult> getOrderDetail(OrderRequest orderRequest) {
        Checker.checkNonNull(orderRequest);
        Context context = this.f29845a.get();
        if (context == null) {
            return new FailureTask();
        }
        if (!C5659a.m33014a(context, orderRequest.reservedInfor, "GetOrderDetail")) {
            PayClientImpl payClientImplM36679a = m36679a();
            return payClientImplM36679a != null ? payClientImplM36679a.getOrderDetail(orderRequest) : new FailureTask();
        }
        HMSLog.m36988i("PayClientImpl", "getOrderDetail with Full SDK branch.");
        PayClientFullImpl payClientFullImplM36680b = m36680b();
        return payClientFullImplM36680b != null ? payClientFullImplM36680b.getOrderDetail(orderRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public PayResultInfo getPayResultInfoFromIntent(Intent intent) {
        Checker.checkNonNull(intent);
        PayClientImpl payClientImplM36679a = m36679a();
        if (payClientImplM36679a != null) {
            return payClientImplM36679a.getPayResultInfoFromIntent(intent);
        }
        return null;
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<ProductDetailResult> getProductDetails(ProductDetailRequest productDetailRequest) {
        Checker.checkNonNull(productDetailRequest);
        Context context = this.f29845a.get();
        if (context == null) {
            return new FailureTask();
        }
        if (!C5659a.m33014a(context, productDetailRequest.reservedInfor, "Productdetail")) {
            PayClientImpl payClientImplM36679a = m36679a();
            return payClientImplM36679a != null ? payClientImplM36679a.getProductDetails(productDetailRequest) : new FailureTask();
        }
        HMSLog.m36988i("PayClientImpl", "getProductDetails with Full SDK branch.");
        PayClientFullImpl payClientFullImplM36680b = m36680b();
        return payClientFullImplM36680b != null ? payClientFullImplM36680b.getProductDetails(productDetailRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public ProductPayResultInfo getProductPayResultFromIntent(Intent intent) {
        Checker.checkNonNull(intent);
        PayClientImpl payClientImplM36679a = m36679a();
        if (payClientImplM36679a != null) {
            return payClientImplM36679a.getProductPayResultFromIntent(intent);
        }
        return null;
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PurchaseInfoResult> getPurchaseInfo(PurchaseInfoRequest purchaseInfoRequest) {
        Checker.checkNonNull(purchaseInfoRequest);
        Context context = this.f29845a.get();
        if (context == null) {
            return new FailureTask();
        }
        if (!C5659a.m33014a(context, purchaseInfoRequest.reservedInfor, "Purchaseinfo")) {
            PayClientImpl payClientImplM36679a = m36679a();
            return payClientImplM36679a != null ? payClientImplM36679a.getPurchaseInfo(purchaseInfoRequest) : new FailureTask();
        }
        HMSLog.m36988i("PayClientImpl", "getProductDetails with Full SDK branch.");
        PayClientFullImpl payClientFullImplM36680b = m36680b();
        return payClientFullImplM36680b != null ? payClientFullImplM36680b.getPurchaseInfo(purchaseInfoRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<GetWalletUiIntentResult> getWalletUiIntent(int i10) {
        PayClientImpl payClientImplM36679a = m36679a();
        return payClientImplM36679a != null ? payClientImplM36679a.getWalletUiIntent(i10) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> internalPay(InternalPayRequest internalPayRequest) {
        Checker.checkNonNull(internalPayRequest);
        PayClientImpl payClientImplM36679a = m36679a();
        return payClientImplM36679a != null ? payClientImplM36679a.internalPay(internalPayRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> pay(PayReq payReq) {
        Checker.checkNonNull(payReq);
        Context context = this.f29845a.get();
        if (context == null) {
            return new FailureTask();
        }
        if (C5659a.m33015a(context, payReq.reservedInfor, payReq.country, payReq.currency, "Pay")) {
            HMSLog.m36988i("PayClientImpl", "pay with Full SDK branch.");
            PayClientFullImpl payClientFullImplM36680b = m36680b();
            return payClientFullImplM36680b != null ? payClientFullImplM36680b.pay(payReq) : new FailureTask();
        }
        HMSLog.m36988i("PayClientImpl", "pay with IAP SDK branch.");
        PayClientImpl payClientImplM36679a = m36679a();
        return payClientImplM36679a != null ? payClientImplM36679a.pay(payReq) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> productPay(ProductPayRequest productPayRequest) {
        Checker.checkNonNull(productPayRequest);
        Context context = this.f29845a.get();
        if (context == null) {
            return new FailureTask();
        }
        if (!C5659a.m33014a(context, productPayRequest.reservedInfor, "ProductPay")) {
            PayClientImpl payClientImplM36679a = m36679a();
            return payClientImplM36679a != null ? payClientImplM36679a.productPay(productPayRequest) : new FailureTask();
        }
        HMSLog.m36988i("PayClientImpl", "productPay with Full SDK branch.");
        PayClientFullImpl payClientFullImplM36680b = m36680b();
        return payClientFullImplM36680b != null ? payClientFullImplM36680b.productPay(productPayRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<HwWalletInfoResult> queryWalletInfo(HwWalletInfoRequest hwWalletInfoRequest) {
        Checker.checkNonNull(hwWalletInfoRequest);
        PayClientImpl payClientImplM36679a = m36679a();
        return payClientImplM36679a != null ? payClientImplM36679a.queryWalletInfo(hwWalletInfoRequest) : new FailureTask();
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public void setSubAppId(String str) {
        PayClientImpl payClientImplM36679a = m36679a();
        if (payClientImplM36679a == null) {
            HMSLog.m36986e("PayClientImpl", "setSubAppId payClient is null");
            return;
        }
        try {
            payClientImplM36679a.setSubAppId(str);
        } catch (ApiException unused) {
            HMSLog.m36983d("PayClientImpl", "setSubAppId fail");
        }
    }

    public PayClientEntryImpl(Context context) {
        this.f29845a = new WeakReference<>(context);
    }
}
