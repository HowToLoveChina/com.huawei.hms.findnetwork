package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.C5634a;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseReq;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.c */
/* loaded from: classes8.dex */
public class C5631c extends AbstractC5629a<C5642g, ConsumeOwnedPurchaseResult> {

    /* renamed from: a */
    private ConsumeOwnedPurchaseReq f25372a;

    public C5631c(String str, ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq, String str2, String str3) {
        super(str, JsonUtil.createJsonString(consumeOwnedPurchaseReq), str2, str3);
        this.f25372a = consumeOwnedPurchaseReq;
        if (m32983b()) {
            m32978a(4);
        }
    }

    /* renamed from: b */
    private boolean m32983b() {
        ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq = this.f25372a;
        if (consumeOwnedPurchaseReq == null || TextUtils.isEmpty(consumeOwnedPurchaseReq.getSignatureAlgorithm())) {
            return false;
        }
        HMSLog.m36988i("ConsumeOwnedPurchaseTaskApiCall", "Use the SHA256WithRSA/PSS algorithm.");
        return true;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public int mo32976a() {
        if (m32983b()) {
            return 50300000;
        }
        return super.mo32976a();
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<ConsumeOwnedPurchaseResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("ConsumeOwnedPurchaseTaskApiCall", "dealSuccess");
        C5634a c5634a = new C5634a();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, c5634a);
        }
        ConsumeOwnedPurchaseResult consumeOwnedPurchaseResult = new ConsumeOwnedPurchaseResult();
        consumeOwnedPurchaseResult.setReturnCode(c5634a.getReturnCode());
        consumeOwnedPurchaseResult.setErrMsg(c5634a.getErrMsg());
        consumeOwnedPurchaseResult.setConsumePurchaseData(c5634a.getConsumePurchaseData());
        consumeOwnedPurchaseResult.setDataSignature(c5634a.getDataSignature());
        consumeOwnedPurchaseResult.setSignatureAlgorithm(c5634a.getSignatureAlgorithm());
        consumeOwnedPurchaseResult.setStatus(new Status(responseErrorCode.getStatusCode(), responseErrorCode.getErrorReason()));
        c8941i.m56658d(consumeOwnedPurchaseResult);
    }
}
