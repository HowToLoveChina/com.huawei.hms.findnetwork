package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.k1 */
/* loaded from: classes8.dex */
public class C5374k1 extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {
    public C5374k1(SnRequestBean snRequestBean) {
        super("findnetwork.stopNearLinkNavigation", snRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode == null || c8941i == null) {
            HmsFindSDKLog.m32126e("StopNearLinkNavigateApiCall", "handleBusiness ignore, param invalid.");
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode == 0) {
            HmsFindSDKLog.m32127i("StopNearLinkNavigateApiCall", "StopNearLinkNavigation succeed.");
            c8941i.m56658d(null);
            return;
        }
        HmsFindSDKLog.m32126e("StopNearLinkNavigateApiCall", "StopNearLinkNavigation failed, errorCode:" + errorCode);
        c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
    }
}
