package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.UserUnreadMsg;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsGetUserCountApiCall extends TaskApiCall<SnsHmsClient, UserUnreadMsg> {

    /* renamed from: a */
    SnsClient.Callback f29939a;

    /* renamed from: b */
    private String f29940b;

    /* renamed from: c */
    private SnsClientImpl f29941c;

    public SnsGetUserCountApiCall(String str, String str2) {
        super(str, str2);
    }

    public SnsGetUserCountApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29939a = callback;
        this.f29941c = snsClientImpl;
        this.f29940b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<UserUnreadMsg> c8941i) throws IllegalArgumentException {
        String transactionId = getTransactionId();
        int statusCode = responseErrorCode.getStatusCode();
        int errorCode = responseErrorCode.getErrorCode();
        String errorReason = responseErrorCode.getErrorReason();
        this.f29941c.biReportExit(this.f29940b, transactionId, statusCode, errorCode);
        if (responseErrorCode.getErrorCode() == 0) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            IMessageEntity iMessageEntityJsonToEntity = JsonUtil.jsonToEntity(str, new UserUnreadMsg());
            if (iMessageEntityJsonToEntity instanceof UserUnreadMsg) {
                c8941i.m56658d((UserUnreadMsg) iMessageEntityJsonToEntity);
            }
            SnsClient.Callback callback = this.f29939a;
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
        c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), errorReason)));
        SnsClient.Callback callback2 = this.f29939a;
        if (callback2 != null) {
            callback2.notify("error " + errorReason);
        }
    }
}
