package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.GetIMStatusResp;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsImStateApiCall extends TaskApiCall<SnsHmsClient, GetIMStatusResp> {

    /* renamed from: a */
    SnsClient.Callback f29945a;

    /* renamed from: b */
    private String f29946b;

    /* renamed from: c */
    private SnsClientImpl f29947c;

    public SnsImStateApiCall(String str, String str2) {
        super(str, str2);
    }

    public SnsImStateApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29945a = callback;
        this.f29947c = snsClientImpl;
        this.f29946b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<GetIMStatusResp> c8941i) {
        this.f29947c.biReportExit(this.f29946b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            if (!TextUtils.isEmpty(str)) {
                c8941i.m56658d((GetIMStatusResp) JsonUtil.jsonToEntity(str, new GetIMStatusResp()));
            }
            SnsClient.Callback callback = this.f29945a;
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
        SnsClient.Callback callback2 = this.f29945a;
        if (callback2 != null) {
            callback2.notify("error " + responseErrorCode.getErrorReason());
        }
    }
}
