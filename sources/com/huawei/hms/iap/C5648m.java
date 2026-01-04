package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.C5639f;
import com.huawei.hms.iap.entity.ProductInfoResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.m */
/* loaded from: classes8.dex */
public class C5648m extends AbstractC5629a<C5642g, ProductInfoResult> {
    public C5648m(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<ProductInfoResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("ProductInfoTaskApiCall", "dealSuccess");
        C5639f c5639f = new C5639f();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, c5639f);
        }
        ProductInfoResult productInfoResult = new ProductInfoResult();
        productInfoResult.setReturnCode(c5639f.getReturnCode());
        productInfoResult.setErrMsg(c5639f.getErrMsg());
        productInfoResult.setProductInfoList(c5639f.getProductInfoList());
        productInfoResult.setStatus(new Status(responseErrorCode.getStatusCode(), responseErrorCode.getErrorReason()));
        c8941i.m56658d(productInfoResult);
    }
}
