package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DevicePeriodRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.s1 */
/* loaded from: classes8.dex */
public class C5398s1 extends BaseTaskApiCall<HmsClient, DevicePeriodRequestBean, Void> {

    /* renamed from: a */
    public FindNetworkCallback<String> f24851a;

    public C5398s1(DevicePeriodRequestBean devicePeriodRequestBean, FindNetworkCallback<String> findNetworkCallback) {
        super("findnetwork.verifyDevicePeriod", devicePeriodRequestBean);
        this.f24851a = findNetworkCallback;
    }

    /* renamed from: a */
    public final void m32097a(int i10) {
        this.f24851a.onFail(new FindNetworkResult<>(i10, "VerifyDevicePeriod callback fail", null));
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        String str2;
        HmsFindSDKLog.m32127i("VerifyDevicePeriodApiCall", "VerifyDevicePeriodApiCall handleBusiness");
        if (this.f24851a == null) {
            str2 = "VerifyDevicePeriodApiCall callback is null";
        } else {
            if (responseErrorCode != null) {
                HmsFindSDKLog.m32127i("VerifyDevicePeriodApiCall", "response.getStatusCode: " + responseErrorCode.getStatusCode() + ", response.getErrorReason(): " + responseErrorCode.getErrorReason());
                if (responseErrorCode.getStatusCode() == 0) {
                    m32098a(str);
                    return;
                } else {
                    m32097a(responseErrorCode.getStatusCode());
                    return;
                }
            }
            str2 = "response is null ";
        }
        HmsFindSDKLog.m32126e("VerifyDevicePeriodApiCall", str2);
    }

    /* renamed from: a */
    public final void m32098a(String str) {
        this.f24851a.onSuccess(new FindNetworkResult<>(0, "VerifyDevicePeriod callback success", str));
    }
}
