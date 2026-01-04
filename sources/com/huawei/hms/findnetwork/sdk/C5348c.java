package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DevicePeriodRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.c */
/* loaded from: classes8.dex */
public class C5348c extends BaseTaskApiCall<HmsClient, DevicePeriodRequestBean, Void> {

    /* renamed from: a */
    public FindNetworkCallback<String> f24774a;

    public C5348c(DevicePeriodRequestBean devicePeriodRequestBean, FindNetworkCallback<String> findNetworkCallback) {
        super("findnetwork.calibrateDevicePeriod", devicePeriodRequestBean);
        this.f24774a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        int statusCode = responseErrorCode.getStatusCode();
        HmsFindSDKLog.m32127i("CalibrateDevicePeriodApiCall", "handleBusiness statusCode:" + statusCode + ", errorCode" + responseErrorCode.getErrorCode() + ", reason:" + responseErrorCode.getErrorReason());
        if (this.f24774a == null) {
            HmsFindSDKLog.m32128w("CalibrateDevicePeriodApiCall", "callback null");
            return;
        }
        FindNetworkResult<String> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setRespCode(statusCode);
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        if (statusCode != 0) {
            this.f24774a.onFail(findNetworkResult);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            findNetworkResult.setData(str);
            this.f24774a.onSuccess(findNetworkResult);
        }
    }
}
