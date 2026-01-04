package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupMemListResp;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsGetGroupMemListTaskApiCall extends TaskApiCall<SnsHmsClient, GetGroupMemListResp> {

    /* renamed from: a */
    SnsClient.Callback f29933a;

    /* renamed from: b */
    private String f29934b;

    /* renamed from: c */
    private SnsClientImpl f29935c;

    public SnsGetGroupMemListTaskApiCall(String str, String str2) {
        super(str, str2);
    }

    public SnsGetGroupMemListTaskApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29933a = callback;
        this.f29935c = snsClientImpl;
        this.f29934b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<GetGroupMemListResp> c8941i) throws IllegalArgumentException {
        String transactionId = getTransactionId();
        int statusCode = responseErrorCode.getStatusCode();
        int errorCode = responseErrorCode.getErrorCode();
        String errorReason = responseErrorCode.getErrorReason();
        this.f29935c.biReportExit(this.f29934b, transactionId, statusCode, errorCode);
        if (responseErrorCode.getErrorCode() == 0) {
            if (!TextUtils.isEmpty(str)) {
                IMessageEntity iMessageEntityJsonToEntity = JsonUtil.jsonToEntity(str, new GetGroupMemListResp());
                if (iMessageEntityJsonToEntity instanceof GetGroupMemListResp) {
                    c8941i.m56658d((GetGroupMemListResp) iMessageEntityJsonToEntity);
                }
            }
            SnsClient.Callback callback = this.f29933a;
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
        SnsClient.Callback callback2 = this.f29933a;
        if (callback2 != null) {
            callback2.notify("errorReason " + errorReason);
        }
    }
}
