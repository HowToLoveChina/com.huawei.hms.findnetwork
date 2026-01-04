package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.m */
/* loaded from: classes8.dex */
public class C5378m extends BaseTaskApiCall<HmsClient, FidRequestBean, FindNetworkResult<String>> {
    public C5378m(FidRequestBean fidRequestBean) {
        super("findnetwork.wear_enableFoundNotification", fidRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<String>> c8941i) {
        HmsFindSDKLog.m32127i("EnableFoundNotificationApiCall", "handleBusiness EnableFoundNotificationApiCall");
        FindNetworkResult<String> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setSrcTransId(getTransactionId());
        if (responseErrorCode.getErrorCode() != 0) {
            findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
            findNetworkResult.setDescription(responseErrorCode.getErrorReason());
            findNetworkResult.setData(str);
        }
        c8941i.m56658d(findNetworkResult);
    }
}
