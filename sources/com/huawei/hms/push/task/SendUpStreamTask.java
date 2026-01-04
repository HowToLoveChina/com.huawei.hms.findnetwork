package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.C6299r;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {

    /* renamed from: a */
    private String f29722a;

    /* renamed from: b */
    private String f29723b;

    public SendUpStreamTask(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.f29722a = str4;
        this.f29723b = str5;
    }

    /* renamed from: a */
    private void m36605a(PushClient pushClient, ResponseErrorCode responseErrorCode) {
        HMSLog.m36988i("SendUpStreamTask", "receive upstream, msgId :" + this.f29723b + " , packageName = " + this.f29722a + " , errorCode = " + responseErrorCode.getErrorCode());
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.f29722a);
        Bundle bundle = new Bundle();
        bundle.putString("message_id", this.f29723b);
        bundle.putInt(VastAttribute.ERROR, responseErrorCode.getErrorCode());
        if (ErrorEnum.SUCCESS.getInternalCode() == responseErrorCode.getErrorCode()) {
            bundle.putString(RemoteMessageConst.MSGTYPE, "sent_message");
        } else {
            bundle.putString(RemoteMessageConst.MSGTYPE, "send_error");
        }
        if (new C6299r().m36598a(pushClient.getContext(), bundle, intent)) {
            HMSLog.m36988i("SendUpStreamTask", "receive upstream, start service success");
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
        } else {
            HMSLog.m36989w("SendUpStreamTask", "receive upstream, start service failed");
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, C8941i<BaseVoidTask> c8941i) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.m36988i("SendUpStreamTask", "send up stream task,Operate succeed");
            c8941i.m56658d(null);
        } else {
            HMSLog.m36986e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + responseErrorCode.getErrorCode());
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (errorEnumFromCode != ErrorEnum.ERROR_UNKNOWN) {
                c8941i.m56657c(errorEnumFromCode.toApiException());
            } else {
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        m36605a(pushClient, responseErrorCode);
    }
}
