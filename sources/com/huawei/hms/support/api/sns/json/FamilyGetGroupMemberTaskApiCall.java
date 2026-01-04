package com.huawei.hms.support.api.sns.json;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.GetFamilyGroupMemberResp;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class FamilyGetGroupMemberTaskApiCall extends TaskApiCall<SnsHmsClient, GetFamilyGroupMemberResp> {

    /* renamed from: a */
    private final FamilyClientImpl f29912a;

    /* renamed from: b */
    private final String f29913b;

    public FamilyGetGroupMemberTaskApiCall(String str, String str2, String str3, FamilyClientImpl familyClientImpl) {
        super(str, str2, str3);
        this.f29912a = familyClientImpl;
        this.f29913b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<GetFamilyGroupMemberResp> c8941i) {
        this.f29912a.biReportExit(this.f29913b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            c8941i.m56658d((GetFamilyGroupMemberResp) JsonUtil.jsonToEntity(str, new GetFamilyGroupMemberResp()));
        } else if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
