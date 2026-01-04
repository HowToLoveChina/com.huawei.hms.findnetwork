package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SendHeartBeatRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.s0 */
/* loaded from: classes8.dex */
public class C5397s0 extends BaseTaskApiCall<HmsClient, SendHeartBeatRequestBean, FindNetworkResult> {
    public C5397s0(SendHeartBeatRequestBean sendHeartBeatRequestBean) {
        super("findnetwork.sendHeartBeat", sendHeartBeatRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult> c8941i) {
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setData(str);
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() != 0) {
            C5399t.m32099a().m32104b();
            HmsFindSDKLog.m32126e("SendHeartBeatApiCall", "FindNetwork Kit response error");
        }
        c8941i.m56658d(findNetworkResult);
    }
}
