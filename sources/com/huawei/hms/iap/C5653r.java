package com.huawei.hms.iap;

import android.content.Intent;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.StartIapActivityReq;
import com.huawei.hms.iap.entity.StartIapActivityResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.r */
/* loaded from: classes8.dex */
public class C5653r extends AbstractC5629a<C5642g, StartIapActivityResult> {

    /* renamed from: a */
    private StartIapActivityReq f25443a;

    public C5653r(String str, StartIapActivityReq startIapActivityReq, String str2, String str3) {
        super(str, JsonUtil.createJsonString(startIapActivityReq), str2, str3);
        this.f25443a = startIapActivityReq;
        if (m33003b()) {
            HMSLog.m36988i("StartIapActivityTaskApiCall", "StartIapActivityTaskApiCall, setApiLevel 5");
            m32978a(5);
        }
    }

    /* renamed from: b */
    private boolean m33003b() {
        StartIapActivityReq startIapActivityReq = this.f25443a;
        return startIapActivityReq != null && startIapActivityReq.getType() == 1;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public int mo32976a() {
        return m33003b() ? 60000000 : 40004000;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<StartIapActivityResult> c8941i, ResponseErrorCode responseErrorCode, String str) {
        HMSLog.m36988i("StartIapActivityTaskApiCall", "dealSuccess");
        if (responseErrorCode.getParcelable() instanceof Intent) {
            HMSLog.m36988i("StartIapActivityTaskApiCall", "onResult, getParcelable is instanceof Intent");
            c8941i.m56658d(new StartIapActivityResult((Intent) responseErrorCode.getParcelable()));
        } else {
            HMSLog.m36986e("StartIapActivityTaskApiCall", "onResult, success but no intent");
            c8941i.m56657c(new IapApiException(new Status(-1, "")));
        }
    }
}
