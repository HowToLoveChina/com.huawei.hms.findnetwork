package com.huawei.hms.findnetwork.sdk;

import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceOtaProgress;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.x */
/* loaded from: classes8.dex */
public class C5408x extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public final SnRequestBean f24861a;

    /* renamed from: b */
    public final FindNetworkCallback<DeviceOtaProgress> f24862b;

    /* renamed from: com.huawei.hms.findnetwork.sdk.x$b */
    public static class b extends TypeToken<FindNetworkResult<DeviceOtaProgress>> {
        public b() {
        }
    }

    public C5408x(SnRequestBean snRequestBean, FindNetworkCallback<DeviceOtaProgress> findNetworkCallback) {
        super("findnetwork.manualOta", snRequestBean);
        this.f24861a = snRequestBean;
        this.f24862b = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall handleBusiness");
        if (this.f24862b == null) {
            HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall callback is null");
            return;
        }
        FindNetworkResult<DeviceOtaProgress> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
        if (findNetworkResult != null) {
            String connectTagSn = this.f24861a.getConnectTagSn();
            String sn2 = findNetworkResult.getData().getSn();
            HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall requestSn = " + MaskUtil.maskSn(connectTagSn) + ", upgradeSn = " + MaskUtil.maskSn(sn2) + ", code = " + findNetworkResult.getRespCode());
            if (findNetworkResult.getRespCode() == 907201155 && connectTagSn.equals(sn2)) {
                HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall onUpdate");
                this.f24862b.onUpdate(findNetworkResult);
                return;
            } else {
                if (findNetworkResult.getRespCode() == 0 && connectTagSn.equals(sn2)) {
                    HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall onSuccess");
                    this.f24862b.onSuccess(findNetworkResult);
                    return;
                }
                HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall onFail");
            }
        } else {
            HmsFindSDKLog.m32127i("ManualOtaApiCall", "ManualOtaApiCall result is null");
            findNetworkResult = new FindNetworkResult<>();
            findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
            findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        }
        this.f24862b.onFail(findNetworkResult);
    }
}
