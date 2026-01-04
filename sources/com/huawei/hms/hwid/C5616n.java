package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.hwid.SignOutResult;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.n */
/* loaded from: classes8.dex */
public class C5616n extends TaskApiCall<C5604c, Void> {
    public C5616n(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5604c c5604c, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode == null) {
            C5602as.m32910b("[AccountSDK]AccountSignOutTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        m32948a(responseErrorCode, str);
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode != 0 && CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
            C5602as.m32910b("[AccountSDK]AccountSignOutTaskApiCall", "apk version is low or is not exist.", true);
            Status status = new Status(errorCode, responseErrorCode.getErrorReason());
            C5598ao.m32897a(responseErrorCode, status);
            c8941i.m56657c(new ResolvableApiException(status));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
            return;
        }
        if ("{}".equals(str)) {
            C5602as.m32910b("[AccountSDK]AccountSignOutTaskApiCall", "SignOut complete, body is null", true);
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
            return;
        }
        try {
            SignOutResult signOutResultFromJson = new SignOutResult().fromJson(str);
            if (signOutResultFromJson.isSuccess()) {
                c8941i.m56658d(null);
            } else {
                c8941i.m56657c(new ApiException(signOutResultFromJson.getStatus()));
            }
        } catch (JSONException e10) {
            C5602as.m32910b("[AccountSDK]AccountSignOutTaskApiCall", "JSONException:" + e10.getClass().getSimpleName(), true);
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    /* renamed from: a */
    private void m32948a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        C5602as.m32910b("[AccountSDK]AccountSignOutTaskApiCall", sb2.toString(), true);
    }
}
