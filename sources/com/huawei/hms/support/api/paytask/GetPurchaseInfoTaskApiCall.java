package com.huawei.hms.support.api.paytask;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoResp;
import com.huawei.hms.support.api.pay.PurchaseInfoResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class GetPurchaseInfoTaskApiCall extends BasePayServiceTaskApiCall<PayHmsClient, PurchaseInfoResult> {
    public GetPurchaseInfoTaskApiCall(String str, String str2) {
        super(str, str2);
        setApiLevel(99);
    }

    @Override // com.huawei.hms.support.api.paytask.BasePayServiceTaskApiCall
    public void dealSuccess(C8941i<PurchaseInfoResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("GetPurchaseInfoTaskApiCall", "dealSuccess");
        PurchaseInfoResp purchaseInfoResp = new PurchaseInfoResp();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, purchaseInfoResp);
        }
        PurchaseInfoResult purchaseInfoResult = new PurchaseInfoResult(purchaseInfoResp);
        Status status = new Status(responseErrorCode.getStatusCode(), responseErrorCode.getErrorReason());
        purchaseInfoResult.setStatus(status);
        purchaseInfoResult.setStatus(status);
        c8941i.m56658d(purchaseInfoResult);
    }
}
