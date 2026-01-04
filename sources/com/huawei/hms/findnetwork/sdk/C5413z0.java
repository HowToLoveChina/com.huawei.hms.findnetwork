package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.AccessoryDetectResult;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.z0 */
/* loaded from: classes8.dex */
public class C5413z0 extends BaseTaskApiCall<HmsClient, BaseRequestBean, Void> {

    /* renamed from: a */
    public FindNetworkCallback<AccessoryDetectResult> f24873a;

    public C5413z0(BaseRequestBean baseRequestBean, FindNetworkCallback<AccessoryDetectResult> findNetworkCallback) {
        super("findnetwork.startAccessoryDetect", baseRequestBean);
        this.f24873a = findNetworkCallback;
    }

    /* renamed from: a */
    public final void m32123a(ResponseErrorCode responseErrorCode) {
        FindNetworkResult<AccessoryDetectResult> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setRespCode(responseErrorCode.getStatusCode());
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setData(null);
        this.f24873a.onFail(findNetworkResult);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        String str2;
        if (this.f24873a == null) {
            str2 = "handleBusiness ignore, callback is null.";
        } else {
            if (responseErrorCode != null) {
                HmsFindSDKLog.m32127i("StartAccessoryDetectApiCall", "handleBusiness, code:" + responseErrorCode.getStatusCode() + ":" + responseErrorCode.getErrorReason());
                if (responseErrorCode.getStatusCode() == 0) {
                    m32124a((AccessoryDetectResult) JsonUtils.json2Object(str, AccessoryDetectResult.class));
                    return;
                } else {
                    m32123a(responseErrorCode);
                    return;
                }
            }
            str2 = "handleBusiness ignore, response is null.";
        }
        HmsFindSDKLog.m32126e("StartAccessoryDetectApiCall", str2);
    }

    /* renamed from: a */
    public final void m32124a(AccessoryDetectResult accessoryDetectResult) {
        FindNetworkResult<AccessoryDetectResult> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setRespCode(0);
        findNetworkResult.setData(accessoryDetectResult);
        this.f24873a.onSuccess(findNetworkResult);
    }
}
