package com.huawei.hms.support.api.pay;

import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.ErrorResultImpl;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.pay.GamePayReq;
import com.huawei.hms.support.api.entity.pay.GameProductPayReq;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.pay.HwWalletInfoRequest;
import com.huawei.hms.support.api.entity.pay.HwWalletInoResp;
import com.huawei.hms.support.api.entity.pay.InternalPayRequest;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.OrderResp;
import com.huawei.hms.support.api.entity.pay.PayNaming;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.PayResp;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductDetailResp;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoInnerRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoResp;
import com.huawei.hms.support.api.entity.pay.WalletIntentResp;
import com.huawei.hms.support.api.entity.pay.WalletUiIntentReq;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.api.pay.util.C6345a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class HuaweiPayApiImpl implements HuaweiPayApi {

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$a */
    public static class C6336a extends PendingResultImpl<OrderResult, OrderResp> {
        public C6336a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OrderResult onComplete(OrderResp orderResp) {
            if (orderResp == null) {
                HMSLog.m36986e("HuaweiPayApiImpl", "order resp is null or orderResp.returnCode is null");
                return null;
            }
            HMSLog.m36988i("HuaweiPayApiImpl", "getOrderDetail resp :" + orderResp.getReturnCode());
            OrderResult orderResult = new OrderResult(orderResp);
            orderResult.setStatus(new Status(orderResp.getReturnCode(), orderResp.getReturnDesc()));
            return orderResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$b */
    public static class C6337b extends ErrorResultImpl<PurchaseInfoResult> {
        public C6337b(int i10) {
            super(i10);
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$c */
    public static class C6338c extends PendingResultImpl<PurchaseInfoResult, PurchaseInfoResp> {
        public C6338c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PurchaseInfoResult onComplete(PurchaseInfoResp purchaseInfoResp) {
            if (purchaseInfoResp == null) {
                HMSLog.m36986e("HuaweiPayApiImpl", "order resp is null or orderResp.returnCode is null");
                return null;
            }
            HMSLog.m36988i("HuaweiPayApiImpl", "getPurchaseInfo resp :" + purchaseInfoResp.getRtnCode());
            return new PurchaseInfoResult(purchaseInfoResp);
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$d */
    public static class C6339d extends ErrorResultImpl<GetWalletUiIntentResult> {
        public C6339d(int i10) {
            super(i10);
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$e */
    public static class C6340e extends ErrorResultImpl<PayResult> {
        public C6340e(int i10) {
            super(i10);
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$f */
    public static class C6341f extends PendingResultImpl<PayResult, PayResp> {
        public C6341f(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PayResult onComplete(PayResp payResp) {
            if (payResp == null) {
                HMSLog.m36986e("HuaweiPayApiImpl", "pay resp is null");
                return null;
            }
            HMSLog.m36988i("HuaweiPayApiImpl", "pay resp :" + payResp.retCode);
            PayResult payResult = new PayResult();
            payResult.setStatus(HuaweiPayApiImpl.m36668b(payResp));
            return payResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$g */
    public static class C6342g extends PendingResultImpl<ProductDetailResult, ProductDetailResp> {
        public C6342g(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProductDetailResult onComplete(ProductDetailResp productDetailResp) {
            if (productDetailResp == null) {
                HMSLog.m36986e("HuaweiPayApiImpl", "produuctDetailResp is null");
                return null;
            }
            HMSLog.m36988i("HuaweiPayApiImpl", "produuctDetail resp :" + productDetailResp.returnCode);
            ProductDetailResult productDetailResult = new ProductDetailResult();
            productDetailResult.setStatus(new Status(productDetailResp.returnCode, productDetailResp.errMsg));
            productDetailResult.setFailList(productDetailResp.getFailList());
            productDetailResult.setProductList(productDetailResp.getProductList());
            productDetailResult.setRequestId(productDetailResp.getRequestId());
            return productDetailResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$h */
    public static class C6343h extends ErrorResultImpl<HwWalletInfoResult> {
        public C6343h(int i10) {
            super(i10);
        }
    }

    /* renamed from: com.huawei.hms.support.api.pay.HuaweiPayApiImpl$i */
    public static class C6344i extends PendingResultImpl<HwWalletInfoResult, HwWalletInoResp> {
        public C6344i(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HwWalletInfoResult onComplete(HwWalletInoResp hwWalletInoResp) {
            if (hwWalletInoResp == null || hwWalletInoResp.getCommonStatus() == null) {
                HMSLog.m36986e("HuaweiPayApiImpl", "HwWalletInfoResult resp is null");
                return null;
            }
            Status commonStatus = hwWalletInoResp.getCommonStatus();
            HMSLog.m36988i("HuaweiPayApiImpl", "HwWalletInoResp resp code :" + commonStatus.getStatusCode());
            HMSLog.m36988i("HuaweiPayApiImpl", "HwWalletInoResp resp msg :" + commonStatus.getStatusMessage());
            HwWalletInfoResult hwWalletInfoResult = new HwWalletInfoResult();
            hwWalletInfoResult.setStatus(new Status(commonStatus.getStatusCode(), commonStatus.getStatusMessage(), commonStatus.getResolution()));
            hwWalletInfoResult.setResult(hwWalletInoResp.getResult());
            return hwWalletInfoResult;
        }
    }

    /* renamed from: a */
    private static PendingResultImpl<GetWalletUiIntentResult, WalletIntentResp> m36666a(HuaweiApiClient huaweiApiClient, WalletUiIntentReq walletUiIntentReq) {
        return new PendingResultImpl<GetWalletUiIntentResult, WalletIntentResp>(huaweiApiClient, PayNaming.getwalletintent, walletUiIntentReq) { // from class: com.huawei.hms.support.api.pay.HuaweiPayApiImpl.1
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GetWalletUiIntentResult onComplete(WalletIntentResp walletIntentResp) {
                if (walletIntentResp == null || walletIntentResp.getCommonStatus() == null) {
                    HMSLog.m36986e("HuaweiPayApiImpl", "WalletUiIntentReq resp is null");
                    return null;
                }
                Status commonStatus = walletIntentResp.getCommonStatus();
                GetWalletUiIntentResult getWalletUiIntentResult = new GetWalletUiIntentResult();
                getWalletUiIntentResult.setStatus(new Status(commonStatus.getStatusCode(), commonStatus.getStatusMessage(), commonStatus.getResolution()));
                getWalletUiIntentResult.setPendingIntent(walletIntentResp.getPendingIntent());
                HMSLog.m36988i("HuaweiPayApiImpl", "getWalletUiIntent onComplete");
                return getWalletUiIntentResult;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Status m36668b(PayResp payResp) {
        if (payResp.intent != null) {
            HMSLog.m36988i("HuaweiPayApiImpl", "getStatus, resp intent");
            return new Status(payResp.retCode, (String) null, payResp.intent);
        }
        if (payResp.getPendingIntent() != null) {
            HMSLog.m36988i("HuaweiPayApiImpl", "getStatus, resp pendingIntent");
            return new Status(payResp.retCode, (String) null, payResp.getPendingIntent());
        }
        HMSLog.m36988i("HuaweiPayApiImpl", "getStatus, resp null");
        return new Status(payResp.retCode, null);
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<PayResult> addWithholdingPlan(HuaweiApiClient huaweiApiClient, WithholdRequest withholdRequest) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter addWithholdingPlan");
        return Util.getHmsVersion(huaweiApiClient.getContext()) < 20504000 ? new C6340e(CommonCode.ErrorCode.HMS_VERSION_CONFIGER_INVALID) : new C6341f(huaweiApiClient, PayNaming.withhold, withholdRequest);
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<OrderResult> getOrderDetail(HuaweiApiClient huaweiApiClient, OrderRequest orderRequest) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter getOrderDetail");
        return new C6336a(huaweiApiClient, PayNaming.getOrderDetail, orderRequest);
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PayResultInfo getPayResultInfoFromIntent(Intent intent) {
        if (intent == null) {
            HMSLog.m36986e("HuaweiPayApiImpl", "getPayResultInfoFromIntent intent is null");
            return null;
        }
        PayResultInfo payResultInfo = new PayResultInfo();
        payResultInfo.setReturnCode(C6345a.m36675a(intent, "returnCode", 1));
        payResultInfo.setUserName(C6345a.m36677a(intent, HwPayConstant.KEY_USER_NAME));
        payResultInfo.setOrderID(C6345a.m36677a(intent, "orderID"));
        payResultInfo.setAmount(C6345a.m36677a(intent, HwPayConstant.KEY_AMOUNT));
        payResultInfo.setCountry(C6345a.m36677a(intent, "country"));
        payResultInfo.setCurrency(C6345a.m36677a(intent, HwPayConstant.KEY_CURRENCY));
        payResultInfo.setWithholdID(C6345a.m36677a(intent, "withholdID"));
        payResultInfo.setRequestId(C6345a.m36677a(intent, "requestId"));
        payResultInfo.setErrMsg(C6345a.m36677a(intent, "errMsg"));
        payResultInfo.setTime(C6345a.m36677a(intent, "time"));
        payResultInfo.setSign(C6345a.m36677a(intent, HwPayConstant.KEY_SIGN));
        payResultInfo.setNewSign(C6345a.m36677a(intent, "newSign"));
        payResultInfo.setSignatureAlgorithm(C6345a.m36677a(intent, "signatureAlgorithm"));
        HMSLog.m36988i("HuaweiPayApiImpl", "final pay result info::" + payResultInfo.getReturnCode());
        return payResultInfo;
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<ProductDetailResult> getProductDetails(HuaweiApiClient huaweiApiClient, ProductDetailRequest productDetailRequest) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter getProductDetails");
        return new C6342g(huaweiApiClient, PayNaming.productdetail, productDetailRequest);
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public ProductPayResultInfo getProductPayResultFromIntent(Intent intent) {
        if (intent == null) {
            HMSLog.m36986e("HuaweiPayApiImpl", "getProductPayResultFromIntent intent is null");
            return null;
        }
        ProductPayResultInfo productPayResultInfo = new ProductPayResultInfo();
        productPayResultInfo.setReturnCode(C6345a.m36675a(intent, "returnCode", 1));
        productPayResultInfo.setOrderID(C6345a.m36677a(intent, "orderID"));
        productPayResultInfo.setErrMsg(C6345a.m36677a(intent, "errMsg"));
        productPayResultInfo.setProductNo(C6345a.m36677a(intent, HwPayConstant.KEY_PRODUCT_NO));
        productPayResultInfo.setMicrosAmount(C6345a.m36676a(intent, "microsAmount", 0L));
        productPayResultInfo.setCurrency(C6345a.m36677a(intent, HwPayConstant.KEY_CURRENCY));
        productPayResultInfo.setRequestId(C6345a.m36677a(intent, "requestId"));
        productPayResultInfo.setMerchantId(C6345a.m36677a(intent, HwPayConstant.KEY_MERCHANTID));
        productPayResultInfo.setTime(C6345a.m36677a(intent, "time"));
        productPayResultInfo.setCountry(C6345a.m36677a(intent, "country"));
        productPayResultInfo.setSign(C6345a.m36677a(intent, HwPayConstant.KEY_SIGN));
        productPayResultInfo.setNewSign(C6345a.m36677a(intent, "newSign"));
        productPayResultInfo.setSignatureAlgorithm(C6345a.m36677a(intent, "signatureAlgorithm"));
        HMSLog.m36988i("HuaweiPayApiImpl", "final product pay result info::" + productPayResultInfo.getReturnCode());
        return productPayResultInfo;
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<PurchaseInfoResult> getPurchaseInfo(HuaweiApiClient huaweiApiClient, PurchaseInfoRequest purchaseInfoRequest) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter getPurchaseInfo");
        return Util.getHmsVersion(huaweiApiClient.getContext()) < 20601000 ? new C6337b(CommonCode.ErrorCode.HMS_VERSION_CONFIGER_INVALID) : new C6338c(huaweiApiClient, PayNaming.purchaseinfo, new PurchaseInfoInnerRequest(purchaseInfoRequest));
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<GetWalletUiIntentResult> getWalletUiIntent(HuaweiApiClient huaweiApiClient, int i10) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter getWalletUiIntent type:" + i10);
        if (Util.getHmsVersion(huaweiApiClient.getContext()) < 20602000) {
            return new C6339d(CommonCode.ErrorCode.HMS_VERSION_CONFIGER_INVALID);
        }
        WalletUiIntentReq walletUiIntentReq = new WalletUiIntentReq();
        walletUiIntentReq.setType(i10);
        return m36666a(huaweiApiClient, walletUiIntentReq);
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<PayResult> internalPay(HuaweiApiClient huaweiApiClient, InternalPayRequest internalPayRequest) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter internalPay");
        return Util.getHmsVersion(huaweiApiClient.getContext()) < 20601000 ? new C6340e(CommonCode.ErrorCode.HMS_VERSION_CONFIGER_INVALID) : new C6341f(huaweiApiClient, PayNaming.internalPay, internalPayRequest);
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<PayResult> pay(HuaweiApiClient huaweiApiClient, PayReq payReq) throws JSONException {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter pay");
        HiAnalyticsUtil.getInstance().onEvent(huaweiApiClient.getContext().getApplicationContext(), HiAnalyticsConstant.KeyAndValue.START_PAY, payReq.requestId);
        return new C6341f(huaweiApiClient, PayNaming.pay, new GamePayReq(payReq, huaweiApiClient.getCpID()));
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<PayResult> productPay(HuaweiApiClient huaweiApiClient, ProductPayRequest productPayRequest) throws JSONException {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter productPay");
        HiAnalyticsUtil.getInstance().onEvent(huaweiApiClient.getContext().getApplicationContext(), HiAnalyticsConstant.KeyAndValue.START_PAY, productPayRequest.requestId);
        return new C6341f(huaweiApiClient, PayNaming.pms, new GameProductPayReq(productPayRequest, huaweiApiClient.getCpID()));
    }

    @Override // com.huawei.hms.support.api.pay.HuaweiPayApi
    public PendingResult<HwWalletInfoResult> queryWalletInfo(HuaweiApiClient huaweiApiClient, HwWalletInfoRequest hwWalletInfoRequest) {
        HMSLog.m36988i("HuaweiPayApiImpl", "Enter queryWalletInfo");
        return Util.getHmsVersion(huaweiApiClient.getContext()) < 20602000 ? new C6343h(CommonCode.ErrorCode.HMS_VERSION_CONFIGER_INVALID) : new C6344i(huaweiApiClient, PayNaming.walletQuery, hwWalletInfoRequest);
    }
}
