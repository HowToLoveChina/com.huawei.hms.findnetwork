package com.huawei.hms.iap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseReq;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseResult;
import com.huawei.hms.iap.entity.IsEnvReadyReq;
import com.huawei.hms.iap.entity.IsEnvReadyResult;
import com.huawei.hms.iap.entity.IsSandboxActivatedReq;
import com.huawei.hms.iap.entity.IsSandboxActivatedResult;
import com.huawei.hms.iap.entity.OrderStatusCode;
import com.huawei.hms.iap.entity.OwnedPurchasesReq;
import com.huawei.hms.iap.entity.OwnedPurchasesResult;
import com.huawei.hms.iap.entity.ProductInfoReq;
import com.huawei.hms.iap.entity.ProductInfoResult;
import com.huawei.hms.iap.entity.PurchaseIntentReq;
import com.huawei.hms.iap.entity.PurchaseIntentResult;
import com.huawei.hms.iap.entity.PurchaseIntentWithPriceReq;
import com.huawei.hms.iap.entity.PurchaseResultInfo;
import com.huawei.hms.iap.entity.RedeemCodeResultInfo;
import com.huawei.hms.iap.entity.ScanRedeemCodeResult;
import com.huawei.hms.iap.entity.StartIapActivityReq;
import com.huawei.hms.iap.entity.StartIapActivityResult;
import com.huawei.hms.iap.util.C5660b;
import com.huawei.hms.iap.util.C5661c;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.f */
/* loaded from: classes8.dex */
public class C5641f extends HuaweiApi<C5644i> implements IapClient {

    /* renamed from: a */
    private static final Api<C5644i> f25436a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_IAP);

    /* renamed from: b */
    private static C5644i f25437b = new C5644i();

    /* renamed from: c */
    private static boolean f25438c;

    /* renamed from: d */
    private String f25439d;

    public C5641f(Activity activity) {
        super(activity, f25436a, f25437b, (AbstractClientBuilder) new C5643h(), 61606301);
    }

    /* renamed from: a */
    private void m32988a(boolean z10, String str) throws JSONException {
        String strM33022a = C5660b.m33022a(this.f25439d, "productAppId", str);
        this.f25439d = strM33022a;
        this.f25439d = C5660b.m33022a(strM33022a, "isConsignment", Boolean.valueOf(z10));
        setApiLevel(10);
    }

    /* renamed from: b */
    private String m32990b(String str) {
        try {
            return new JSONObject(str).optString("transactionId", "");
        } catch (JSONException e10) {
            HMSLog.m36986e("IapClientImpl", "getTransactionId  exception :" + e10.getMessage());
            return "";
        }
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ConsumeOwnedPurchaseResult> consumeOwnedPurchase(ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq) {
        HMSLog.m36988i("IapClientImpl", "consumeOwnedPurchase");
        Checker.checkNonNull(consumeOwnedPurchaseReq);
        return doWrite(new C5631c("iap.consumePurchase", consumeOwnedPurchaseReq, this.f25439d, HiAnalyticsClient.reportEntry(getContext(), "iap.consumePurchase", 61606301)));
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<PurchaseIntentResult> createPurchaseIntent(PurchaseIntentReq purchaseIntentReq) throws JSONException {
        String strReportEntry;
        HiAnalyticsUtil hiAnalyticsUtil;
        Context context;
        String strM32990b;
        String str;
        HMSLog.m36988i("IapClientImpl", "createPurchaseIntent");
        Checker.checkNonNull(purchaseIntentReq);
        if (purchaseIntentReq.getPriceType() == 2) {
            strReportEntry = HiAnalyticsClient.reportEntry(getContext(), "iap.buy", 61606301);
            hiAnalyticsUtil = HiAnalyticsUtil.getInstance();
            context = getContext();
            strM32990b = m32990b(JsonUtil.createJsonString(purchaseIntentReq));
            str = HiAnalyticsConstant.KeyAndValue.START_SUB;
        } else {
            strReportEntry = HiAnalyticsClient.reportEntry(getContext(), "iap.buy", 61606301);
            hiAnalyticsUtil = HiAnalyticsUtil.getInstance();
            context = getContext();
            strM32990b = m32990b(JsonUtil.createJsonString(purchaseIntentReq));
            str = HiAnalyticsConstant.KeyAndValue.START_BUY;
        }
        hiAnalyticsUtil.onEvent(context, str, strM32990b);
        String strM33022a = C5660b.m33022a(this.f25439d, "enablePendingPurchases", Boolean.valueOf(f25438c));
        this.f25439d = strM33022a;
        return doWrite(new C5649n("iap.buy", purchaseIntentReq, strM33022a, strReportEntry));
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<PurchaseIntentResult> createPurchaseIntentWithPrice(PurchaseIntentWithPriceReq purchaseIntentWithPriceReq) throws JSONException {
        HMSLog.m36988i("IapClientImpl", "createPurchaseIntentWithPrice");
        Checker.checkNonNull(purchaseIntentWithPriceReq);
        if (!m32989a(purchaseIntentWithPriceReq.getReservedInfor())) {
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new IapApiException(new Status(OrderStatusCode.ORDER_STATE_PARAM_ERROR, "reservedInfor must be a JSON string")));
            return c8941i.m56656b();
        }
        HiAnalyticsUtil.getInstance().onEvent(getContext(), HiAnalyticsConstant.KeyAndValue.START_BUYWITHPRICE, m32990b(JsonUtil.createJsonString(purchaseIntentWithPriceReq)));
        String strReportEntry = HiAnalyticsClient.reportEntry(getContext(), "iap.buyWithPrice", 61606301);
        String strM33022a = C5660b.m33022a(this.f25439d, "enablePendingPurchases", Boolean.valueOf(f25438c));
        this.f25439d = strM33022a;
        return doWrite(new C5650o("iap.buyWithPrice", purchaseIntentWithPriceReq, strM33022a, strReportEntry));
    }

    @Override // com.huawei.hms.iap.IapClient
    public void enablePendingPurchase() {
        HMSLog.m36988i("IapClientImpl", "enablePendingPurchase");
        f25438c = true;
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady() {
        return isEnvReady(false);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsSandboxActivatedResult> isSandboxActivated(IsSandboxActivatedReq isSandboxActivatedReq) {
        Checker.checkNonNull(isSandboxActivatedReq);
        return doWrite(new C5646k("iap.isSandboxActivated", JsonUtil.createJsonString(isSandboxActivatedReq), this.f25439d, HiAnalyticsClient.reportEntry(getContext(), "iap.isSandboxActivated", 61606301)));
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<OwnedPurchasesResult> obtainOwnedPurchaseRecord(OwnedPurchasesReq ownedPurchasesReq) {
        HMSLog.m36988i("IapClientImpl", "obtainOwnedPurchaseRecord");
        Checker.checkNonNull(ownedPurchasesReq);
        return doWrite(new C5647l("iap.getPurchaseHistory", ownedPurchasesReq, this.f25439d, HiAnalyticsClient.reportEntry(getContext(), "iap.getPurchaseHistory", 61606301)));
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<OwnedPurchasesResult> obtainOwnedPurchases(OwnedPurchasesReq ownedPurchasesReq) {
        HMSLog.m36988i("IapClientImpl", "obtainOwnedPurchases");
        Checker.checkNonNull(ownedPurchasesReq);
        return doWrite(new C5647l("iap.getPurchase", ownedPurchasesReq, this.f25439d, HiAnalyticsClient.reportEntry(getContext(), "iap.getPurchase", 61606301)));
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ProductInfoResult> obtainProductInfo(ProductInfoReq productInfoReq) {
        HMSLog.m36988i("IapClientImpl", "obtainProductInfo");
        Checker.checkNonNull(productInfoReq);
        return doWrite(new C5648m("iap.getSkuDetails", JsonUtil.createJsonString(productInfoReq), this.f25439d, HiAnalyticsClient.reportEntry(getContext(), "iap.getSkuDetails", 61606301)));
    }

    @Override // com.huawei.hms.iap.IapClient
    public PurchaseResultInfo parsePurchaseResultInfoFromIntent(Intent intent) {
        HMSLog.m36988i("IapClientImpl", "parsePurchaseResultInfoFromIntent");
        if (intent == null) {
            intent = new Intent();
        }
        PurchaseResultInfo purchaseResultInfo = new PurchaseResultInfo();
        purchaseResultInfo.setReturnCode(C5661c.m33025a(intent, "returnCode", 1));
        purchaseResultInfo.setErrMsg(C5661c.m33026a(intent, "errMsg"));
        purchaseResultInfo.setInAppPurchaseData(C5661c.m33026a(intent, "inAppPurchaseData"));
        purchaseResultInfo.setInAppDataSignature(C5661c.m33026a(intent, "Signature"));
        purchaseResultInfo.setSignatureAlgorithm(C5661c.m33026a(intent, "signatureAlgorithm"));
        HMSLog.m36988i("IapClientImpl", "getBuyResultInfoFromIntent:" + purchaseResultInfo.getReturnCode());
        return purchaseResultInfo;
    }

    @Override // com.huawei.hms.iap.IapClient
    public RedeemCodeResultInfo parseRedeemCodeResultInfoFromIntent(Intent intent) {
        HMSLog.m36988i("IapClientImpl", "parseRedeemCodeResultInfoFromIntent");
        if (intent == null) {
            intent = new Intent();
        }
        RedeemCodeResultInfo redeemCodeResultInfo = new RedeemCodeResultInfo();
        redeemCodeResultInfo.setRedeemCode(C5661c.m33026a(intent, "redeemCode"));
        redeemCodeResultInfo.setReturnCode(C5661c.m33025a(intent, "returnCode", 1));
        HMSLog.m36988i("IapClientImpl", "parseRedeemCodeResultInfoFromIntent:" + redeemCodeResultInfo.getReturnCode());
        return redeemCodeResultInfo;
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ScanRedeemCodeResult> scanRedeemCode() {
        return doWrite(new C5652q("iap.scanRedeemCode", HiAnalyticsClient.reportEntry(getContext(), "iap.scanRedeemCode", 61606301)));
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<StartIapActivityResult> startIapActivity(StartIapActivityReq startIapActivityReq) {
        Checker.checkNonNull(startIapActivityReq);
        return doWrite(new C5653r("iap.startActivity", startIapActivityReq, this.f25439d, HiAnalyticsClient.reportEntry(getContext(), "iap.startActivity", 61606301)));
    }

    public C5641f(Activity activity, String str) {
        super(activity, f25436a, f25437b, (AbstractClientBuilder) new C5651p(), 61606301, str);
        setApiLevel(3);
    }

    /* renamed from: a */
    private boolean m32989a(String str) {
        if (str == null) {
            return true;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady(IsEnvReadyReq isEnvReadyReq) {
        throw new UnsupportedOperationException("isEnvReady");
    }

    public C5641f(Activity activity, String str, boolean z10) throws JSONException {
        super(activity, f25436a, f25437b, (AbstractClientBuilder) new C5643h(), 61606301);
        m32988a(z10, str);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady(boolean z10) {
        return doWrite(new C5645j("iap.isBillingSupported", HiAnalyticsClient.reportEntry(getContext(), "iap.isBillingSupported", 61606301), z10));
    }

    public C5641f(Context context) {
        super(context, f25436a, f25437b, new C5643h(), 61606301);
    }

    public C5641f(Context context, String str) {
        super(context, f25436a, f25437b, new C5651p(), 61606301, str);
        setApiLevel(3);
    }

    public C5641f(Context context, String str, boolean z10) throws JSONException {
        super(context, f25436a, f25437b, new C5643h(), 61606301);
        m32988a(z10, str);
    }
}
