package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.bean.BtMeasureResult;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.a1 */
/* loaded from: classes8.dex */
public class C5344a1 extends BaseTaskApiCall<HmsClient, BaseRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback f24761a;

    public C5344a1(BaseRequestBean baseRequestBean, FindNetworkCallback findNetworkCallback) {
        super("findnetwork.startBTMeasure", baseRequestBean);
        this.f24761a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setRespCode(responseErrorCode.getStatusCode());
        HmsFindSDKLog.m32125d("StartBTMeasureApiCall", "handleBusiness statusCode:" + responseErrorCode.getStatusCode());
        if (responseErrorCode.getStatusCode() == 0) {
            this.f24761a.onSuccess(findNetworkResult);
        } else if (responseErrorCode.getStatusCode() == 907201007) {
            findNetworkResult.setData((BtMeasureResult) JsonUtils.json2Object(str, BtMeasureResult.class));
            this.f24761a.onUpdate(findNetworkResult);
        } else {
            this.f24761a.onFail(findNetworkResult);
        }
        c8941i.m56658d(null);
    }
}
