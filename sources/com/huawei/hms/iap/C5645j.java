package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.C5635b;
import com.huawei.hms.iap.entity.IsEnvReadyResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.j */
/* loaded from: classes8.dex */
public class C5645j extends AbstractC5629a<C5642g, IsEnvReadyResult> {
    public C5645j(String str, String str2, boolean z10) {
        super(str, JsonUtil.createJsonString(null), str2);
        if (z10) {
            setApiLevel(4);
        }
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<IsEnvReadyResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("IsEnvReadyTaskApiCall", "dealSuccess");
        IsEnvReadyResult isEnvReadyResult = new IsEnvReadyResult();
        C5635b c5635b = new C5635b();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, c5635b);
        }
        isEnvReadyResult.setReturnCode(c5635b.getReturnCode());
        isEnvReadyResult.setStatus(m32977a(responseErrorCode));
        isEnvReadyResult.setAccountFlag(c5635b.getAccountFlag());
        isEnvReadyResult.setCountry(c5635b.getCountry());
        isEnvReadyResult.setCarrierId(c5635b.getCarrierId());
        c8941i.m56658d(isEnvReadyResult);
    }
}
