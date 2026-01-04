package com.huawei.hms.support.api.sns.json;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.GetFamilyGroupInfoResp;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class FamilyGetGroupInfoTaskApiCall extends TaskApiCall<SnsHmsClient, GetFamilyGroupInfoResp> {

    /* renamed from: a */
    private final FamilyClientImpl f29910a;

    /* renamed from: b */
    private final String f29911b;

    public FamilyGetGroupInfoTaskApiCall(String str, String str2, String str3, FamilyClientImpl familyClientImpl) {
        super(str, str2, str3);
        this.f29910a = familyClientImpl;
        this.f29911b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<GetFamilyGroupInfoResp> c8941i) {
        this.f29910a.biReportExit(this.f29911b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            c8941i.m56658d((GetFamilyGroupInfoResp) JsonUtil.jsonToEntity(str, new GetFamilyGroupInfoResp()));
        } else if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
