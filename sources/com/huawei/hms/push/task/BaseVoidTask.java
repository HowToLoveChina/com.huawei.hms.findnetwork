package com.huawei.hms.push.task;

import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class BaseVoidTask extends TaskApiCall<PushClient, Void> {
    public BaseVoidTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.m36988i("BaseVoidTask", "Operate succeed");
            c8941i.m56658d(null);
        } else {
            HMSLog.m36986e("BaseVoidTask", "Operate failed with ret=" + responseErrorCode.getErrorCode());
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (errorEnumFromCode != ErrorEnum.ERROR_UNKNOWN) {
                c8941i.m56657c(errorEnumFromCode.toApiException());
            } else {
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
    }
}
