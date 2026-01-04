package com.huawei.hms.support.api.paytask;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.entity.pay.PayResp;
import com.huawei.hms.support.api.pay.PayResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class PayTaskApiCall extends BasePayServiceTaskApiCall<PayHmsClient, PayResult> {

    /* renamed from: a */
    private String f29851a;

    public PayTaskApiCall(String str, String str2, String str3) {
        super(str, str2);
        this.f29851a = str3;
        if (m36681a()) {
            setApiLevel(4);
        }
    }

    /* renamed from: a */
    private boolean m36681a() {
        if (TextUtils.isEmpty(this.f29851a)) {
            return false;
        }
        HMSLog.m36988i("PayTaskApiCall", "Use the SHA256WithRSA/PSS algorithm.");
        return true;
    }

    @Override // com.huawei.hms.support.api.paytask.BasePayServiceTaskApiCall
    public void dealSuccess(C8941i<PayResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("PayTaskApiCall", "dealSuccess");
        PayResp payResp = new PayResp();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, payResp);
        }
        PayResult payResult = new PayResult();
        payResult.setStatus(getStatus(responseErrorCode));
        c8941i.m56658d(payResult);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        if (m36681a()) {
            return 60000300;
        }
        return super.getMinApkVersion();
    }

    public PayTaskApiCall(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.f29851a = str4;
        if (m36681a()) {
            setApiLevel(4);
        }
    }
}
