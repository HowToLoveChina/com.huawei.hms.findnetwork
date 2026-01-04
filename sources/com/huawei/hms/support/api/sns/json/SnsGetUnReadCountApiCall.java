package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.UnreadMsg;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsGetUnReadCountApiCall extends TaskApiCall<SnsHmsClient, UnreadMsg> {

    /* renamed from: a */
    SnsClient.Callback f29936a;

    /* renamed from: b */
    private String f29937b;

    /* renamed from: c */
    private SnsClientImpl f29938c;

    public SnsGetUnReadCountApiCall(String str, String str2) {
        super(str, str2);
    }

    public SnsGetUnReadCountApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29936a = callback;
        this.f29938c = snsClientImpl;
        this.f29937b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<UnreadMsg> c8941i) throws IllegalArgumentException {
        this.f29938c.biReportExit(this.f29937b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            if (!TextUtils.isEmpty(str)) {
                IMessageEntity iMessageEntityJsonToEntity = JsonUtil.jsonToEntity(str, new UnreadMsg());
                if (iMessageEntityJsonToEntity instanceof UnreadMsg) {
                    c8941i.m56658d((UnreadMsg) iMessageEntityJsonToEntity);
                }
            }
            SnsClient.Callback callback = this.f29936a;
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
        String errorReason = responseErrorCode.getErrorReason();
        c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), errorReason)));
        SnsClient.Callback callback2 = this.f29936a;
        if (callback2 != null) {
            callback2.notify("error " + errorReason);
        }
    }
}
