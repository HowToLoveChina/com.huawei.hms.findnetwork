package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.C5637d;
import com.huawei.hms.iap.entity.OwnedPurchasesReq;
import com.huawei.hms.iap.entity.OwnedPurchasesResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.l */
/* loaded from: classes8.dex */
public class C5647l extends AbstractC5629a<C5642g, OwnedPurchasesResult> {

    /* renamed from: a */
    private OwnedPurchasesReq f25440a;

    public C5647l(String str, OwnedPurchasesReq ownedPurchasesReq, String str2, String str3) {
        super(str, JsonUtil.createJsonString(ownedPurchasesReq), str2, str3);
        this.f25440a = ownedPurchasesReq;
        if (m32992b()) {
            m32978a(4);
        }
    }

    /* renamed from: b */
    private boolean m32992b() {
        OwnedPurchasesReq ownedPurchasesReq = this.f25440a;
        if (ownedPurchasesReq == null || TextUtils.isEmpty(ownedPurchasesReq.getSignatureAlgorithm())) {
            return false;
        }
        HMSLog.m36988i("OwnedPurchasesTaskApiCall", "Use the SHA256WithRSA/PSS algorithm.");
        return true;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public int mo32976a() {
        if (m32992b()) {
            return 50300000;
        }
        return super.mo32976a();
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<OwnedPurchasesResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("OwnedPurchasesTaskApiCall", "dealSuccess");
        C5637d c5637d = new C5637d();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, c5637d);
        }
        OwnedPurchasesResult ownedPurchasesResult = new OwnedPurchasesResult();
        ownedPurchasesResult.setReturnCode(c5637d.getReturnCode());
        ownedPurchasesResult.setErrMsg(c5637d.getErrMsg());
        ownedPurchasesResult.setContinuationToken(c5637d.getContinuationToken());
        ownedPurchasesResult.setItemList(c5637d.getItemList());
        ownedPurchasesResult.setInAppPurchaseDataList(c5637d.getInAppPurchaseDataList());
        ownedPurchasesResult.setInAppSignature(c5637d.getInAppSignatureList());
        ownedPurchasesResult.setStatus(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason()));
        ownedPurchasesResult.setPlacedInappPurchaseDataList(c5637d.getPlacedInappPurchaseDataList());
        ownedPurchasesResult.setPlacedInappSignatureList(c5637d.getPlacedInappSignatureList());
        ownedPurchasesResult.setSignatureAlgorithm(c5637d.getSignatureAlgorithm());
        c8941i.m56658d(ownedPurchasesResult);
    }
}
