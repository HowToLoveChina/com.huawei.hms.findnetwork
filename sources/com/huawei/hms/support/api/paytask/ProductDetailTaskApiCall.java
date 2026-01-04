package com.huawei.hms.support.api.paytask;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.ProductDetailResp;
import com.huawei.hms.support.api.pay.ProductDetailResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class ProductDetailTaskApiCall extends BasePayServiceTaskApiCall<PayHmsClient, ProductDetailResult> {
    public ProductDetailTaskApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.support.api.paytask.BasePayServiceTaskApiCall
    public void dealSuccess(C8941i<ProductDetailResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("ProductDetailTaskApiCall", "dealSuccess");
        ProductDetailResp productDetailResp = new ProductDetailResp();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, productDetailResp);
        }
        ProductDetailResult productDetailResult = new ProductDetailResult();
        productDetailResult.setProductList(productDetailResp.productList);
        productDetailResult.setStatus(new Status(productDetailResp.returnCode, productDetailResp.errMsg));
        productDetailResult.setFailList(productDetailResp.getFailList());
        productDetailResult.setProductList(productDetailResp.getProductList());
        productDetailResult.setRequestId(productDetailResp.getRequestId());
        c8941i.m56658d(productDetailResult);
    }
}
