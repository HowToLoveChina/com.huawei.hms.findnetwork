package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.j1 */
/* loaded from: classes8.dex */
public class C5371j1 extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback f24787a;

    public C5371j1(SnRequestBean snRequestBean, FindNetworkCallback findNetworkCallback) {
        super("findnetwork.stop_navigate", snRequestBean);
        this.f24787a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("StopNavigateApiCall", "StopNavigateApiCall handleBusiness");
        if (this.f24787a == null) {
            HmsFindSDKLog.m32127i("StopNavigateApiCall", "StopNavigateApiCall callback == null");
            return;
        }
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setData(str);
        HmsFindSDKLog.m32127i("StopNavigateApiCall", "result.getRespCode() == " + findNetworkResult.getRespCode());
        int statusCode = responseErrorCode.getStatusCode();
        FindNetworkCallback findNetworkCallback = this.f24787a;
        if (statusCode == 0) {
            findNetworkCallback.onSuccess(findNetworkResult);
        } else {
            findNetworkCallback.onFail(findNetworkResult);
        }
        c8941i.m56658d(null);
    }
}
