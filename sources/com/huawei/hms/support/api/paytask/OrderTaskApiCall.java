package com.huawei.hms.support.api.paytask;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.OrderResp;
import com.huawei.hms.support.api.pay.OrderResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class OrderTaskApiCall extends BasePayServiceTaskApiCall<PayHmsClient, OrderResult> {

    /* renamed from: a */
    private OrderRequest f29844a;

    public OrderTaskApiCall(String str, OrderRequest orderRequest, String str2) {
        super(str, JsonUtil.createJsonString(orderRequest), str2);
        this.f29844a = orderRequest;
        if (m36678a()) {
            setApiLevel(4);
        }
    }

    /* renamed from: a */
    private boolean m36678a() {
        OrderRequest orderRequest = this.f29844a;
        if (orderRequest == null || TextUtils.isEmpty(orderRequest.signatureAlgorithm)) {
            return false;
        }
        HMSLog.m36988i("OrderTaskApiCall", "Use the SHA256WithRSA/PSS algorithm.");
        return true;
    }

    @Override // com.huawei.hms.support.api.paytask.BasePayServiceTaskApiCall
    public void dealSuccess(C8941i<OrderResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("OrderTaskApiCall", "dealSuccess");
        OrderResp orderResp = new OrderResp();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, orderResp);
        }
        OrderResult orderResult = new OrderResult(orderResp);
        orderResult.setStatus(new Status(orderResp.getReturnCode(), orderResp.getReturnDesc()));
        c8941i.m56658d(orderResult);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        if (m36678a()) {
            return 60000300;
        }
        return super.getMinApkVersion();
    }
}
