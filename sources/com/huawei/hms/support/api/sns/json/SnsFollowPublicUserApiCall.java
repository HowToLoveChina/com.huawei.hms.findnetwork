package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.FollowPublicUserResp;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsFollowPublicUserApiCall extends TaskApiCall<SnsHmsClient, FollowPublicUserResp> {

    /* renamed from: a */
    SnsClient.Callback f29924a;

    /* renamed from: b */
    private String f29925b;

    /* renamed from: c */
    private SnsClientImpl f29926c;

    public SnsFollowPublicUserApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29924a = callback;
        this.f29926c = snsClientImpl;
        this.f29925b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 2;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FollowPublicUserResp> c8941i) {
        String transactionId = getTransactionId();
        int statusCode = responseErrorCode.getStatusCode();
        int errorCode = responseErrorCode.getErrorCode();
        this.f29926c.biReportExit(this.f29925b, transactionId, statusCode, errorCode);
        if (errorCode == 0) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c8941i.m56658d((FollowPublicUserResp) JsonUtil.jsonToEntity(str, new FollowPublicUserResp()));
        } else {
            if (responseErrorCode.hasResolution()) {
                c8941i.m56657c(new ResolvableApiException(responseErrorCode));
                return;
            }
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            this.f29924a.notify("error: " + responseErrorCode.getErrorReason());
        }
    }
}
