package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.hwid.RevokeAccessResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.h */
/* loaded from: classes8.dex */
public class C5609h extends TaskApiCall<C5604c, Void> {
    public C5609h(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5604c c5604c, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        C5602as.m32910b("AccountCancelAuthorizationTaskApiCall", "AccountCancelAuthorizationTaskApiCall doExecute", true);
        C5607f.m32922a();
        if (responseErrorCode == null) {
            C5602as.m32910b("AccountCancelAuthorizationTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode != 0 && CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
            C5602as.m32910b("AccountCancelAuthorizationTaskApiCall", "apk version is low or is not exist.", true);
            Status status = new Status(errorCode, responseErrorCode.getErrorReason());
            C5598ao.m32897a(responseErrorCode, status);
            c8941i.m56657c(new ResolvableApiException(status));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
        } else {
            if ("{}".equals(str)) {
                C5602as.m32910b("AccountCancelAuthorizationTaskApiCall", "CancelAuthorization complete, body is null", true);
                c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
                return;
            }
            try {
                RevokeAccessResult revokeAccessResultFromJson = new RevokeAccessResult().fromJson(str);
                if (revokeAccessResultFromJson.isSuccess()) {
                    c8941i.m56658d(null);
                } else {
                    Status status2 = revokeAccessResultFromJson.getStatus();
                    c8941i.m56657c(new ApiException(new Status(status2.getStatusCode(), status2.getStatusMessage())));
                }
            } catch (JSONException e10) {
                C5602as.m32910b("AccountCancelAuthorizationTaskApiCall", "JSONException:" + e10.getClass().getSimpleName(), true);
                Status status3 = new Status(errorCode, responseErrorCode.getErrorReason());
                C5598ao.m32897a(responseErrorCode, status3);
                c8941i.m56657c(new ApiException(status3));
            }
        }
        if (c5604c != null) {
            HiAnalyticsClient.reportExit(c5604c.getContext(), getUri(), getTransactionId(), C5601ar.m32908a(errorCode), errorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
