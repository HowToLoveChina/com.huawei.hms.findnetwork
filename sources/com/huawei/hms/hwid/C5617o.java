package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.hwid.StartAssistLoginResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.o */
/* loaded from: classes8.dex */
public class C5617o extends TaskApiCall<C5604c, Void> {
    public C5617o(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5604c c5604c, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        C5602as.m32910b("AccountStartAssistLoginTaskApiCall", "AccountStartAssistLoginTaskApiCall doExecute", true);
        if (responseErrorCode == null) {
            C5602as.m32910b("AccountStartAssistLoginTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode != 0 && CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
            C5602as.m32910b("AccountStartAssistLoginTaskApiCall", "apk version is low or is not exist.", true);
            Status status = new Status(errorCode, responseErrorCode.getErrorReason());
            C5598ao.m32897a(responseErrorCode, status);
            c8941i.m56657c(new ResolvableApiException(status));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
        } else {
            if ("{}".equals(str)) {
                C5602as.m32910b("AccountStartAssistLoginTaskApiCall", "signIn complete, body is null", true);
                c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
                return;
            }
            try {
                StartAssistLoginResult startAssistLoginResultFromJson = new StartAssistLoginResult().fromJson(str);
                if (startAssistLoginResultFromJson.isSuccess()) {
                    c8941i.m56658d(null);
                } else {
                    c8941i.m56657c(new ApiException(startAssistLoginResultFromJson.getStatus()));
                }
            } catch (JSONException unused) {
                C5602as.m32911c("AccountStartAssistLoginTaskApiCall", "tartAssistLogin complete, but parser json exception", true);
                c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
            }
        }
        if (c5604c != null) {
            HiAnalyticsClient.reportExit(c5604c.getContext(), getUri(), getTransactionId(), C5601ar.m32908a(errorCode), errorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 14;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }
}
