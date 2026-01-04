package com.huawei.hms.push.task;

import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class AttributionReportTask extends BaseVoidTask {
    public AttributionReportTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return AuthInternalPickerConstant.HMS_SDK_VERSION;
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.m36988i("AnalysisReportTask", "analysis report task,Operate succeed");
            c8941i.m56658d(null);
        } else {
            HMSLog.m36986e("AnalysisReportTask", "analysis report task,Operate failed with ret=" + responseErrorCode.getErrorCode());
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (errorEnumFromCode == ErrorEnum.ERROR_UNKNOWN) {
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            } else if (errorEnumFromCode == ErrorEnum.ERROR_NOT_IN_SERVICE) {
                new PushPreferences(pushClient.getContext(), "hwpush_local_config").saveLong("analysis_last_failed_time", Long.valueOf(System.currentTimeMillis()));
                c8941i.m56657c(errorEnumFromCode.toApiException());
            } else {
                c8941i.m56657c(errorEnumFromCode.toApiException());
            }
        }
        PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
    }
}
