package com.huawei.hms.iap;

import android.content.Intent;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.ScanRedeemCodeResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.q */
/* loaded from: classes8.dex */
public class C5652q extends AbstractC5629a<C5642g, ScanRedeemCodeResult> {
    public C5652q(String str, String str2) {
        super(str, JsonUtil.createJsonString(null), str2);
        setApiLevel(10);
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<ScanRedeemCodeResult> c8941i, ResponseErrorCode responseErrorCode, String str) {
        HMSLog.m36988i("ScanRedeemCodeTaskApiCall", "dealSuccess");
        if (responseErrorCode.getParcelable() instanceof Intent) {
            HMSLog.m36988i("ScanRedeemCodeTaskApiCall", "onResult and getParcelable is instanceof Intent");
            c8941i.m56658d(new ScanRedeemCodeResult((Intent) responseErrorCode.getParcelable()));
        } else {
            HMSLog.m36986e("ScanRedeemCodeTaskApiCall", "onResult success but no intent");
            c8941i.m56657c(new IapApiException(new Status(-1, "")));
        }
    }

    @Override // com.huawei.hms.iap.AbstractC5629a, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60900000;
    }
}
