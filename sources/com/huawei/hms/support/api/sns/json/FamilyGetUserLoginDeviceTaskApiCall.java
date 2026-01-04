package com.huawei.hms.support.api.sns.json;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.GetUserLoginDeviceResp;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class FamilyGetUserLoginDeviceTaskApiCall extends TaskApiCall<SnsHmsClient, GetUserLoginDeviceResp> {

    /* renamed from: a */
    private final FamilyClientImpl f29916a;

    /* renamed from: b */
    private final String f29917b;

    public FamilyGetUserLoginDeviceTaskApiCall(String str, String str2, String str3, FamilyClientImpl familyClientImpl) {
        super(str, str2, str3);
        this.f29916a = familyClientImpl;
        this.f29917b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<GetUserLoginDeviceResp> c8941i) {
        this.f29916a.biReportExit(this.f29917b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            c8941i.m56658d((GetUserLoginDeviceResp) JsonUtil.jsonToEntity(str, new GetUserLoginDeviceResp()));
        } else if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
