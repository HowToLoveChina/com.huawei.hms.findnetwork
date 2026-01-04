package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.UserDataResp;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsGetUserDataApiCall extends TaskApiCall<SnsHmsClient, UserDataResp> {

    /* renamed from: a */
    SnsClient.Callback f29942a;

    /* renamed from: b */
    private String f29943b;

    /* renamed from: c */
    private SnsClientImpl f29944c;

    public SnsGetUserDataApiCall(String str, String str2) {
        super(str, str2);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 3;
    }

    public SnsGetUserDataApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29942a = callback;
        this.f29944c = snsClientImpl;
        this.f29943b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<UserDataResp> c8941i) throws IllegalArgumentException {
        this.f29944c.biReportExit(this.f29943b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            IMessageEntity iMessageEntityJsonToEntity = JsonUtil.jsonToEntity(str, new UserDataResp());
            if (iMessageEntityJsonToEntity instanceof UserDataResp) {
                c8941i.m56658d((UserDataResp) iMessageEntityJsonToEntity);
            }
            SnsClient.Callback callback = this.f29942a;
            if (callback != null) {
                callback.notify(str);
                return;
            }
            return;
        }
        if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
            return;
        }
        c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        SnsClient.Callback callback2 = this.f29942a;
        if (callback2 != null) {
            callback2.notify("error " + responseErrorCode.getErrorReason());
        }
    }
}
