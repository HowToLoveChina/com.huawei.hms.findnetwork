package com.huawei.hms.push.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.C6283b;
import com.huawei.hms.push.SubscribeResult;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SubscribeNotificationTask extends TaskApiCall<PushClient, SubscribeResult> {

    /* renamed from: a */
    private Activity f29724a;

    public SubscribeNotificationTask(Activity activity, String str, SubscribeNotificationReq subscribeNotificationReq, String str2) {
        super(str, JsonUtil.createJsonString(subscribeNotificationReq), str2);
        this.f29724a = activity;
    }

    /* renamed from: a */
    private boolean m36607a(PushClient pushClient, ResponseErrorCode responseErrorCode) {
        Parcelable parcelable = responseErrorCode.getParcelable();
        if (!(parcelable instanceof Intent)) {
            HMSLog.m36986e("SubscribeNotificationTask", "not instance of intent");
            return false;
        }
        Intent intent = (Intent) parcelable;
        intent.putExtra("app_token", BaseUtils.getLocalToken(pushClient.getContext(), null));
        this.f29724a.startActivityForResult(intent, 1001);
        return true;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 6;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, C8941i<SubscribeResult> c8941i) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m36986e("SubscribeNotificationTask", "Notification subscribe failed, error code: " + responseErrorCode.getErrorCode());
            m36606a(responseErrorCode, c8941i);
        } else {
            SubscribeNotificationResp subscribeNotificationResp = (SubscribeNotificationResp) JsonUtil.jsonToEntity(str, new SubscribeNotificationResp());
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(subscribeNotificationResp.getRetCode());
            if (errorEnumFromCode != ErrorEnum.SUCCESS) {
                c8941i.m56657c(errorEnumFromCode.toApiException());
                HMSLog.m36986e("PushLogSC3004", "Notification Subscription failed, StatusCode:" + errorEnumFromCode.getExternalCode());
            } else if (!responseErrorCode.hasResolution()) {
                SubscribeResult subscribeResult = new SubscribeResult();
                subscribeResult.setSubscribedItems(C6283b.m36504a(subscribeNotificationResp.getSubscribeResults()));
                c8941i.m56658d(subscribeResult);
            } else if (m36607a(pushClient, responseErrorCode)) {
                c8941i.m56658d(new SubscribeResult());
            } else {
                c8941i.m56657c(ErrorEnum.ERROR_PUSH_INTERNAL_ERROR.toApiException());
            }
        }
        PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
    }

    /* renamed from: a */
    private void m36606a(ResponseErrorCode responseErrorCode, C8941i<SubscribeResult> c8941i) {
        ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (errorEnumFromCode != ErrorEnum.ERROR_UNKNOWN) {
            c8941i.m56657c(errorEnumFromCode.toApiException());
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
