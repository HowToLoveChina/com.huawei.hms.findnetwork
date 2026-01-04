package com.huawei.hms.support.api.paytask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.pay.HwWalletInfoRequest;
import com.huawei.hms.support.api.entity.pay.InternalPayRequest;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.PayNaming;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoInnerRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoRequest;
import com.huawei.hms.support.api.entity.pay.WalletUiIntentReq;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.api.pay.GetWalletUiIntentResult;
import com.huawei.hms.support.api.pay.HwWalletInfoResult;
import com.huawei.hms.support.api.pay.OrderResult;
import com.huawei.hms.support.api.pay.PayResult;
import com.huawei.hms.support.api.pay.PayResultInfo;
import com.huawei.hms.support.api.pay.ProductDetailResult;
import com.huawei.hms.support.api.pay.ProductPayResultInfo;
import com.huawei.hms.support.api.pay.PurchaseInfoResult;
import com.huawei.hms.support.api.pay.util.C6345a;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class PayClientImpl extends HuaweiApi<PayOptions> implements PayClient {

    /* renamed from: a */
    private static final Api<PayOptions> f29849a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_PAY);

    /* renamed from: b */
    private static PayOptions f29850b = new PayOptions();

    public PayClientImpl(Activity activity) {
        super(activity, f29849a, f29850b, (AbstractClientBuilder) new PayHmsClientBuilder(), 61606301);
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> addWithholdingPlan(WithholdRequest withholdRequest) {
        HMSLog.m36988i("PayClientImpl", "addWithholdingPlan");
        Checker.checkNonNull(withholdRequest);
        return doWrite(new PayTaskApiCall(PayNaming.withhold, JsonUtil.createJsonString(withholdRequest), HiAnalyticsClient.reportEntry(getContext(), PayNaming.withhold, 61606301), withholdRequest.signatureAlgorithm));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<OrderResult> getOrderDetail(OrderRequest orderRequest) {
        HMSLog.m36988i("PayClientImpl", "getOrderDetail");
        Checker.checkNonNull(orderRequest);
        return doWrite(new OrderTaskApiCall(PayNaming.getOrderDetail, orderRequest, HiAnalyticsClient.reportEntry(getContext(), PayNaming.getOrderDetail, 61606301)));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public PayResultInfo getPayResultInfoFromIntent(Intent intent) {
        HMSLog.m36988i("PayClientImpl", "getPayResultInfoFromIntent");
        if (intent == null) {
            HMSLog.m36986e("PayClientImpl", "getPayResultInfoFromIntent, mIntent is null");
            return null;
        }
        PayResultInfo payResultInfo = new PayResultInfo();
        payResultInfo.setReturnCode(C6345a.m36675a(intent, "returnCode", 1));
        payResultInfo.setErrMsg(C6345a.m36677a(intent, "errMsg"));
        payResultInfo.setUserName(C6345a.m36677a(intent, HwPayConstant.KEY_USER_NAME));
        payResultInfo.setOrderID(C6345a.m36677a(intent, "orderID"));
        payResultInfo.setRequestId(C6345a.m36677a(intent, "requestId"));
        payResultInfo.setWithholdID(C6345a.m36677a(intent, "withholdID"));
        payResultInfo.setAmount(C6345a.m36677a(intent, HwPayConstant.KEY_AMOUNT));
        payResultInfo.setTime(C6345a.m36677a(intent, "time"));
        payResultInfo.setCountry(C6345a.m36677a(intent, "country"));
        payResultInfo.setCurrency(C6345a.m36677a(intent, HwPayConstant.KEY_CURRENCY));
        payResultInfo.setSign(C6345a.m36677a(intent, HwPayConstant.KEY_SIGN));
        payResultInfo.setNewSign(C6345a.m36677a(intent, "newSign"));
        payResultInfo.setSignatureAlgorithm(C6345a.m36677a(intent, "signatureAlgorithm"));
        HMSLog.m36988i("PayClientImpl", "final pay result info::" + payResultInfo.getReturnCode());
        return payResultInfo;
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<ProductDetailResult> getProductDetails(ProductDetailRequest productDetailRequest) {
        HMSLog.m36988i("PayClientImpl", "getProductDetails");
        Checker.checkNonNull(productDetailRequest);
        return doWrite(new ProductDetailTaskApiCall(PayNaming.productdetail, JsonUtil.createJsonString(productDetailRequest), HiAnalyticsClient.reportEntry(getContext(), PayNaming.productdetail, 61606301)));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public ProductPayResultInfo getProductPayResultFromIntent(Intent intent) {
        HMSLog.m36988i("PayClientImpl", "getProductPayResultFromIntent");
        if (intent == null) {
            HMSLog.m36986e("PayClientImpl", "getProductPayResultFromIntent, mIntent is null");
            return null;
        }
        ProductPayResultInfo productPayResultInfo = new ProductPayResultInfo();
        productPayResultInfo.setReturnCode(C6345a.m36675a(intent, "returnCode", 1));
        productPayResultInfo.setOrderID(C6345a.m36677a(intent, "orderID"));
        productPayResultInfo.setErrMsg(C6345a.m36677a(intent, "errMsg"));
        productPayResultInfo.setProductNo(C6345a.m36677a(intent, HwPayConstant.KEY_PRODUCT_NO));
        productPayResultInfo.setMicrosAmount(C6345a.m36676a(intent, "microsAmount", 0L));
        productPayResultInfo.setTime(C6345a.m36677a(intent, "time"));
        productPayResultInfo.setCountry(C6345a.m36677a(intent, "country"));
        productPayResultInfo.setCurrency(C6345a.m36677a(intent, HwPayConstant.KEY_CURRENCY));
        productPayResultInfo.setRequestId(C6345a.m36677a(intent, "requestId"));
        productPayResultInfo.setMerchantId(C6345a.m36677a(intent, HwPayConstant.KEY_MERCHANTID));
        productPayResultInfo.setSign(C6345a.m36677a(intent, HwPayConstant.KEY_SIGN));
        productPayResultInfo.setNewSign(C6345a.m36677a(intent, "newSign"));
        productPayResultInfo.setSignatureAlgorithm(C6345a.m36677a(intent, "signatureAlgorithm"));
        HMSLog.m36988i("PayClientImpl", "final product pay result info::" + productPayResultInfo.getReturnCode());
        return productPayResultInfo;
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PurchaseInfoResult> getPurchaseInfo(PurchaseInfoRequest purchaseInfoRequest) {
        HMSLog.m36988i("PayClientImpl", "getPurchaseInfo");
        Checker.checkNonNull(purchaseInfoRequest);
        return doWrite(new GetPurchaseInfoTaskApiCall(PayNaming.purchaseinfo, JsonUtil.createJsonString(new PurchaseInfoInnerRequest(purchaseInfoRequest))));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<GetWalletUiIntentResult> getWalletUiIntent(int i10) {
        HMSLog.m36988i("PayClientImpl", "getWalletUiIntent");
        WalletUiIntentReq walletUiIntentReq = new WalletUiIntentReq();
        walletUiIntentReq.setType(i10);
        Checker.checkNonNull(walletUiIntentReq);
        return doWrite(new GetWalletUiIntentTaskApiCall(PayNaming.getwalletintent, JsonUtil.createJsonString(walletUiIntentReq), i10));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> internalPay(InternalPayRequest internalPayRequest) {
        HMSLog.m36988i("PayClientImpl", "internalPay");
        Checker.checkNonNull(internalPayRequest);
        return doWrite(new PayTaskApiCall(PayNaming.internalPay, JsonUtil.createJsonString(internalPayRequest), internalPayRequest.signType));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> pay(PayReq payReq) {
        HMSLog.m36988i("PayClientImpl", "pay");
        Checker.checkNonNull(payReq);
        return doWrite(new PayTaskApiCall(PayNaming.pay, JsonUtil.createJsonString(payReq), HiAnalyticsClient.reportEntry(getContext(), PayNaming.pay, 61606301), payReq.signatureAlgorithm));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<PayResult> productPay(ProductPayRequest productPayRequest) {
        HMSLog.m36988i("PayClientImpl", "productPay");
        Checker.checkNonNull(productPayRequest);
        return doWrite(new PayTaskApiCall(PayNaming.pms, JsonUtil.createJsonString(productPayRequest), HiAnalyticsClient.reportEntry(getContext(), PayNaming.pms, 61606301), productPayRequest.signatureAlgorithm));
    }

    @Override // com.huawei.hms.support.api.paytask.PayClient
    public Task<HwWalletInfoResult> queryWalletInfo(HwWalletInfoRequest hwWalletInfoRequest) {
        HMSLog.m36988i("PayClientImpl", "queryWalletInfo");
        Checker.checkNonNull(hwWalletInfoRequest);
        return doWrite(new HwWalletInfoTaskApiCall(PayNaming.walletQuery, JsonUtil.createJsonString(hwWalletInfoRequest)));
    }

    public PayClientImpl(Context context) {
        super(context, f29849a, f29850b, new PayHmsClientBuilder(), 61606301);
    }
}
