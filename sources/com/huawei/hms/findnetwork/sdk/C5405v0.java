package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SetFindeeModeRequestBean;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.v0 */
/* loaded from: classes8.dex */
public class C5405v0 extends BaseTaskApiCall<HmsClient, SetFindeeModeRequestBean, Void> {
    public C5405v0(SetFindeeModeRequestBean setFindeeModeRequestBean) {
        super("findnetwork.setFindeeMode", setFindeeModeRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode == null || c8941i == null) {
            HmsFindSDKLog.m32128w("SetFindeeModeApiCall", "SetFindeeMode ignore, param invalid.");
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode == 0) {
            HmsFindSDKLog.m32127i("SetFindeeModeApiCall", "SetFindeeMode CODE_SUCCESS");
            c8941i.m56658d(null);
            return;
        }
        HmsFindSDKLog.m32126e("SetFindeeModeApiCall", "SetFindeeMode failed, errorCode:" + errorCode);
        c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
    }
}
