package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.f */
/* loaded from: classes8.dex */
public class C5357f extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback f24780a;

    public C5357f(SnRequestBean snRequestBean, FindNetworkCallback findNetworkCallback) {
        super("findnetwork.tag_createLongConnection", snRequestBean);
        this.f24780a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("ConnectTagApiCall", "ConnectTagApiCall handleBusiness");
        if (this.f24780a == null) {
            HmsFindSDKLog.m32127i("ConnectTagApiCall", "ConnectTagApiCall callback == null");
            return;
        }
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
        findNetworkResult.setData(str);
        HmsFindSDKLog.m32127i("ConnectTagApiCall", "result.getRespCode() == " + findNetworkResult.getRespCode());
        int statusCode = responseErrorCode.getStatusCode();
        FindNetworkCallback findNetworkCallback = this.f24780a;
        if (statusCode == 0) {
            findNetworkCallback.onSuccess(findNetworkResult);
        } else {
            findNetworkCallback.onFail(findNetworkResult);
        }
        c8941i.m56658d(null);
    }
}
