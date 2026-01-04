package com.huawei.hms.iap;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.entity.BaseReq;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseReq;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseResult;
import com.huawei.hms.iap.entity.IsEnvReadyReq;
import com.huawei.hms.iap.entity.IsEnvReadyResult;
import com.huawei.hms.iap.entity.IsSandboxActivatedReq;
import com.huawei.hms.iap.entity.IsSandboxActivatedResult;
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
import com.huawei.hms.iap.task.ConsumeOwnedPurchaseTask;
import com.huawei.hms.iap.task.CreatePurchaseTask;
import com.huawei.hms.iap.task.IsEnvReadyTask;
import com.huawei.hms.iap.task.ObtainOwnedPurchaseRecordTask;
import com.huawei.hms.iap.task.ObtainOwnedPurchasesTask;
import com.huawei.hms.iap.task.ProductInfoTask;
import com.huawei.hms.iap.util.C5661c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.iap.e */
/* loaded from: classes8.dex */
public class C5633e implements IapClient {

    /* renamed from: a */
    private Context f25379a;

    /* renamed from: b */
    private final String f25380b;

    public C5633e(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m32987a(BaseReq baseReq) throws JSONException {
        if (TextUtils.isEmpty(this.f25380b)) {
            HMSLog.m36986e("IapClientFullImpl", "addSceneAppId, appId is empty!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(baseReq.getReservedInfor());
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("accountInfo"));
            jSONObject2.put("subAppID", this.f25380b);
            jSONObject.put("accountInfo", jSONObject2.toString());
            baseReq.setReservedInfor(jSONObject.toString());
        } catch (JSONException unused) {
            HMSLog.m36986e("IapClientFullImpl", "addSceneAppId, JSONException");
        }
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ConsumeOwnedPurchaseResult> consumeOwnedPurchase(ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq) throws JSONException {
        Checker.checkNonNull(consumeOwnedPurchaseReq);
        m32987a(consumeOwnedPurchaseReq);
        return new ConsumeOwnedPurchaseTask(this.f25379a, consumeOwnedPurchaseReq);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<PurchaseIntentResult> createPurchaseIntent(PurchaseIntentReq purchaseIntentReq) throws JSONException {
        Checker.checkNonNull(purchaseIntentReq);
        m32987a(purchaseIntentReq);
        return new CreatePurchaseTask(this.f25379a, purchaseIntentReq);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<PurchaseIntentResult> createPurchaseIntentWithPrice(PurchaseIntentWithPriceReq purchaseIntentWithPriceReq) {
        throw new UnsupportedOperationException("createPurchaseIntentWithPrice");
    }

    @Override // com.huawei.hms.iap.IapClient
    public void enablePendingPurchase() {
        throw new UnsupportedOperationException("enablePendingPurchase");
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady() {
        throw new UnsupportedOperationException("isEnvReady");
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsSandboxActivatedResult> isSandboxActivated(IsSandboxActivatedReq isSandboxActivatedReq) {
        throw new UnsupportedOperationException("isSandboxActivated");
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<OwnedPurchasesResult> obtainOwnedPurchaseRecord(OwnedPurchasesReq ownedPurchasesReq) throws JSONException {
        Checker.checkNonNull(ownedPurchasesReq);
        m32987a(ownedPurchasesReq);
        return new ObtainOwnedPurchaseRecordTask(this.f25379a, ownedPurchasesReq);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<OwnedPurchasesResult> obtainOwnedPurchases(OwnedPurchasesReq ownedPurchasesReq) throws JSONException {
        Checker.checkNonNull(ownedPurchasesReq);
        m32987a(ownedPurchasesReq);
        return new ObtainOwnedPurchasesTask(this.f25379a, ownedPurchasesReq);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ProductInfoResult> obtainProductInfo(ProductInfoReq productInfoReq) throws JSONException {
        Checker.checkNonNull(productInfoReq);
        m32987a(productInfoReq);
        return new ProductInfoTask(this.f25379a, productInfoReq);
    }

    @Override // com.huawei.hms.iap.IapClient
    public PurchaseResultInfo parsePurchaseResultInfoFromIntent(Intent intent) {
        HMSLog.m36988i("IapClientFullImpl", "parsePurchaseResultInfoFromIntent");
        if (intent == null) {
            intent = new Intent();
        }
        PurchaseResultInfo purchaseResultInfo = new PurchaseResultInfo();
        purchaseResultInfo.setReturnCode(C5661c.m33025a(intent, "returnCode", 1));
        purchaseResultInfo.setErrMsg(C5661c.m33026a(intent, "errMsg"));
        purchaseResultInfo.setInAppPurchaseData(C5661c.m33026a(intent, "inAppPurchaseData"));
        purchaseResultInfo.setInAppDataSignature(C5661c.m33026a(intent, "inAppDataSignature"));
        purchaseResultInfo.setSignatureAlgorithm(C5661c.m33026a(intent, "signatureAlgorithm"));
        HMSLog.m36988i("IapClientFullImpl", "parsePurchaseResultInfoFromIntent:" + purchaseResultInfo.getReturnCode());
        return purchaseResultInfo;
    }

    @Override // com.huawei.hms.iap.IapClient
    public RedeemCodeResultInfo parseRedeemCodeResultInfoFromIntent(Intent intent) {
        throw new UnsupportedOperationException("parseRedeemCodeResultInfoFromIntent");
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ScanRedeemCodeResult> scanRedeemCode() {
        throw new UnsupportedOperationException("scanRedeemCode");
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<StartIapActivityResult> startIapActivity(StartIapActivityReq startIapActivityReq) {
        throw new UnsupportedOperationException("startIapActivity");
    }

    public C5633e(Context context, String str) {
        this.f25379a = context;
        this.f25380b = str;
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady(IsEnvReadyReq isEnvReadyReq) throws JSONException {
        Checker.checkNonNull(isEnvReadyReq);
        m32987a(isEnvReadyReq);
        return new IsEnvReadyTask(this.f25379a, isEnvReadyReq);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady(boolean z10) {
        throw new UnsupportedOperationException("isEnvReady");
    }
}
