package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.openalliance.p169ad.constant.Constants;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.aa */
/* loaded from: classes8.dex */
public class C5584aa extends TaskApiCall<C5623u, Void> {
    public C5584aa(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5623u c5623u, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode == null) {
            C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdDeleteAuthInfoTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        m32859a(responseErrorCode, str);
        if (TextUtils.isEmpty(str)) {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        } else if (responseErrorCode.getErrorCode() == 0) {
            c8941i.m56658d(null);
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return Constants.HMS_VERSION_CODE_40000300;
    }

    /* renamed from: a */
    private void m32859a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdDeleteAuthInfoTaskApiCall", sb2.toString(), true);
    }
}
