package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AssistTokenResult;
import com.huawei.hms.support.account.result.GetAssistTokenResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.p */
/* loaded from: classes8.dex */
public class C5618p extends TaskApiCall<C5604c, AssistTokenResult> {
    public C5618p(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5604c c5604c, ResponseErrorCode responseErrorCode, String str, C8941i<AssistTokenResult> c8941i) {
        if (responseErrorCode == null) {
            C5602as.m32910b("[AccountSDK]GetAssistTokenTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        if (TextUtils.isEmpty(str) || "{}".equals(str)) {
            C5602as.m32910b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken complete, response or body is null, failed", true);
            m32951a(c5604c, errorCode);
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        try {
            AssistTokenResult assistTokenResult = new AssistTokenResult();
            GetAssistTokenResult getAssistTokenResultFromJson = new GetAssistTokenResult().fromJson(str);
            if (getAssistTokenResultFromJson.isSuccess()) {
                C5602as.m32910b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken success", true);
                m32951a(c5604c, errorCode);
                assistTokenResult.setAssistToken(getAssistTokenResultFromJson.getAssistToken());
                c8941i.m56658d(assistTokenResult);
            } else {
                C5602as.m32910b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken failed", true);
                m32951a(c5604c, errorCode);
                c8941i.m56657c(new ApiException(getAssistTokenResultFromJson.getStatus()));
            }
        } catch (JSONException unused) {
            C5602as.m32912d("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken complete, but parser json exception", true);
            m32951a(c5604c, errorCode);
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
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

    /* renamed from: a */
    private void m32951a(C5604c c5604c, int i10) {
        if (c5604c != null) {
            HiAnalyticsClient.reportExit(c5604c.getContext(), AccountNaming.getAssistToken, getTransactionId(), C5601ar.m32908a(i10), i10);
        }
    }
}
