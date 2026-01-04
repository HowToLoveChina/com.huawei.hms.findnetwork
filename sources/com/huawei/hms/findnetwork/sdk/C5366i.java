package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotificationParams;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.i */
/* loaded from: classes8.dex */
public class C5366i extends BaseTaskApiCall<HmsClient, DisconnectNotificationParams, Void> {

    /* renamed from: a */
    public final FindNetworkCallback<Void> f24785a;

    public C5366i(DisconnectNotificationParams disconnectNotificationParams, FindNetworkCallback<Void> findNetworkCallback) {
        super("findnetwork.enableNewDisconnectNotification", disconnectNotificationParams);
        this.f24785a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        FindNetworkResult<Void> findNetworkResult = new FindNetworkResult<>();
        if (responseErrorCode.getStatusCode() == 0) {
            HmsFindSDKLog.m32127i("DisconnectNotifyModeApiCall", "DisconnectNotifyModeApiCall success");
            findNetworkResult.setRespCode(0);
            this.f24785a.onSuccess(findNetworkResult);
            return;
        }
        HmsFindSDKLog.m32127i("DisconnectNotifyModeApiCall", "fail code = " + responseErrorCode.getStatusCode());
        findNetworkResult.setRespCode(responseErrorCode.getStatusCode());
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        this.f24785a.onFail(findNetworkResult);
    }
}
