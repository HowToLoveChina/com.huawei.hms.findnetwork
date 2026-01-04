package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.SignOutResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.ad */
/* loaded from: classes8.dex */
public class C5587ad extends TaskApiCall<C5623u, Void> {
    public C5587ad(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5623u c5623u, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode == null) {
            C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdSignOutTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        m32862a(responseErrorCode, str);
        int errorCode = responseErrorCode.getErrorCode();
        if (TextUtils.isEmpty(str)) {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        } else {
            try {
                SignOutResult signOutResultFromJson = new SignOutResult().fromJson(str);
                errorCode = signOutResultFromJson.getStatus().getStatusCode();
                if (signOutResultFromJson.isSuccess()) {
                    c8941i.m56658d(null);
                } else {
                    c8941i.m56657c(new ApiException(signOutResultFromJson.getStatus()));
                }
            } catch (JSONException unused) {
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        if (c5623u != null) {
            HiAnalyticsClient.reportExit(c5623u.getContext(), "hwid.signout", getTransactionId(), C5601ar.m32908a(errorCode), errorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    /* renamed from: a */
    private void m32862a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdSignOutTaskApiCall", sb2.toString(), true);
    }
}
