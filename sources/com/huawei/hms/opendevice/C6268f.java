package com.huawei.hms.opendevice;

import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.opendevice.f */
/* loaded from: classes8.dex */
public class C6268f extends TaskApiCall<PushClient, Void> {

    /* renamed from: a */
    private DeleteTokenReq f29579a;

    public C6268f(String str, DeleteTokenReq deleteTokenReq, String str2) {
        super(str, JsonUtil.createJsonString(deleteTokenReq), str2);
        this.f29579a = deleteTokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode.getErrorCode() == 0) {
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
            if (errorEnumFromCode != ErrorEnum.SUCCESS) {
                c8941i.m56657c(errorEnumFromCode.toApiException());
                return;
            } else {
                c8941i.m56658d(null);
                C6270h.m36431a(pushClient.getContext(), getUri(), responseErrorCode);
                return;
            }
        }
        HMSLog.m36986e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
        ErrorEnum errorEnumFromCode2 = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (errorEnumFromCode2 != ErrorEnum.ERROR_UNKNOWN) {
            c8941i.m56657c(errorEnumFromCode2.toApiException());
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f29579a.isMultiSender() ? 50004300 : 30000000;
    }
}
