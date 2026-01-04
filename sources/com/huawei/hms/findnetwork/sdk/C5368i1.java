package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.i1 */
/* loaded from: classes8.dex */
public class C5368i1 extends BaseTaskApiCall<HmsClient, BaseRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback f24786a;

    public C5368i1(BaseRequestBean baseRequestBean, FindNetworkCallback findNetworkCallback) {
        super("findnetwork.stopBTMeasure", baseRequestBean);
        this.f24786a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("StopBTMeasureApiCall", "StopBTMeasureApiCall handleBusiness");
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
        findNetworkResult.setData(str);
        HmsFindSDKLog.m32127i("StopBTMeasureApiCall", "result.getRespCode() == " + findNetworkResult.getRespCode());
        int statusCode = responseErrorCode.getStatusCode();
        FindNetworkCallback findNetworkCallback = this.f24786a;
        if (statusCode == 0) {
            findNetworkCallback.onSuccess(findNetworkResult);
        } else {
            findNetworkCallback.onFail(findNetworkResult);
        }
        c8941i.m56658d(null);
    }
}
