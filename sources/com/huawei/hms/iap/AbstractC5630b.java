package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.C5640g;
import com.huawei.hms.iap.entity.PurchaseIntentResult;
import com.huawei.hms.iap.util.C5660b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.b */
/* loaded from: classes8.dex */
public abstract class AbstractC5630b extends AbstractC5629a<C5642g, PurchaseIntentResult> {
    public AbstractC5630b(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<PurchaseIntentResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("BasePurchaseIntentTaskApiCall", "dealSuccess");
        C5640g c5640g = new C5640g();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, c5640g);
        }
        PurchaseIntentResult purchaseIntentResult = new PurchaseIntentResult();
        purchaseIntentResult.setReturnCode(c5640g.getReturnCode());
        purchaseIntentResult.setErrMsg(c5640g.getErrMsg());
        purchaseIntentResult.setPaymentData(c5640g.getPaymentData());
        purchaseIntentResult.setPaymentSignature(c5640g.getPaymentSignature());
        purchaseIntentResult.setSignatureAlgorithm(c5640g.getSignatureAlgorithm());
        purchaseIntentResult.setStatus(m32977a(responseErrorCode));
        c8941i.m56658d(purchaseIntentResult);
    }

    /* renamed from: a */
    public boolean m32982a(String str) {
        return "entrusted".equals(C5660b.m33024c(C5660b.m33024c(str, "PayTypePolicy"), "DefaultPayment"));
    }
}
