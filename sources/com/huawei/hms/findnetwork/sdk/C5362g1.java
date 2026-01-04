package com.huawei.hms.findnetwork.sdk;

import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceOtaTargetVersion;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.g1 */
/* loaded from: classes8.dex */
public class C5362g1 extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback<DeviceOtaTargetVersion> f24783a;

    /* renamed from: com.huawei.hms.findnetwork.sdk.g1$b */
    public static class b extends TypeToken<FindNetworkResult<DeviceOtaTargetVersion>> {
        public b() {
        }
    }

    public C5362g1(SnRequestBean snRequestBean, FindNetworkCallback<DeviceOtaTargetVersion> findNetworkCallback) {
        super("findnetwork.startCheckOta", snRequestBean);
        this.f24783a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("StartOtaCheckApiCall", "StartOtaCheckApiCall handleBusiness");
        if (this.f24783a == null) {
            HmsFindSDKLog.m32127i("StartOtaCheckApiCall", "StartOtaCheckApiCall callback is null");
            return;
        }
        FindNetworkResult<DeviceOtaTargetVersion> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
        if (findNetworkResult == null) {
            HmsFindSDKLog.m32127i("StartOtaCheckApiCall", "StartOtaCheckApiCall result is null");
        } else {
            this.f24783a.onSuccess(findNetworkResult);
        }
    }
}
