package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.AccessoryDetectResult;
import com.huawei.hms.findnetwork.comm.request.bean.GetFidRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.p */
/* loaded from: classes8.dex */
public class C5387p extends BaseTaskApiCall<HmsClient, GetFidRequestBean, Void> {

    /* renamed from: a */
    public FindNetworkCallback<AccessoryDetectResult> f24818a;

    public C5387p(GetFidRequestBean getFidRequestBean, FindNetworkCallback<AccessoryDetectResult> findNetworkCallback) {
        super("findnetwork.getDeviceFid", getFidRequestBean);
        this.f24818a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        AccessoryDetectResult accessoryDetectResult;
        int statusCode = responseErrorCode.getStatusCode();
        HmsFindSDKLog.m32127i("GetDeviceFidApiCall", "handleBusiness statusCode:" + statusCode + ", errorCode" + responseErrorCode.getErrorCode() + ", reason:" + responseErrorCode.getErrorReason());
        if (this.f24818a == null) {
            HmsFindSDKLog.m32128w("GetDeviceFidApiCall", "callback null");
            return;
        }
        FindNetworkResult<AccessoryDetectResult> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setRespCode(statusCode);
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        if (statusCode != 0) {
            this.f24818a.onFail(findNetworkResult);
        } else {
            if (TextUtils.isEmpty(str) || (accessoryDetectResult = (AccessoryDetectResult) JsonUtils.json2Object(str, AccessoryDetectResult.class)) == null) {
                return;
            }
            findNetworkResult.setData(accessoryDetectResult);
            this.f24818a.onSuccess(findNetworkResult);
        }
    }
}
