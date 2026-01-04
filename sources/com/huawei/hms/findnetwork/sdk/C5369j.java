package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotifyStatusBean;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.j */
/* loaded from: classes8.dex */
public class C5369j extends BaseTaskApiCall<HmsClient, DisconnectNotifyStatusBean, Void> {
    public C5369j(DisconnectNotifyStatusBean disconnectNotifyStatusBean) {
        super("findnetwork.enableDisconnectNotification", disconnectNotifyStatusBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode.getStatusCode() == 0) {
            HmsFindSDKLog.m32127i("DisconnectNotifyStatusApiCall", "success");
            c8941i.m56658d(null);
            return;
        }
        HmsFindSDKLog.m32126e("DisconnectNotifyStatusApiCall", "fail code = " + responseErrorCode.getStatusCode());
        HmsFindSDKLog.m32126e("DisconnectNotifyStatusApiCall", "fail reason = " + responseErrorCode.getErrorReason());
        c8941i.m56657c(new ApiException(new Status(responseErrorCode.getStatusCode())));
    }
}
