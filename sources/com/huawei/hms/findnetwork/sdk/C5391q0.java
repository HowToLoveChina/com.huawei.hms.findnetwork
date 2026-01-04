package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.wear.ResultResponse;
import com.huawei.hms.findnetwork.comm.request.bean.wear.ShareDeviceRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.q0 */
/* loaded from: classes8.dex */
public class C5391q0 extends BaseTaskApiCall<HmsClient, ShareDeviceRequestBean, FindNetworkResult<String>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.q0$b */
    public static class b extends TypeToken<FindNetworkResult<ResultResponse>> {
        public b() {
        }
    }

    public C5391q0(ShareDeviceRequestBean shareDeviceRequestBean) {
        super("findnetwork.wear_sharingDevices", shareDeviceRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<String>> c8941i) {
        ApiException apiException;
        HmsFindSDKLog.m32127i("RequestSharingDeviceApiCall", "RequestSharingDeviceApiCall handleBusiness, transactionId = " + getTransactionId());
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("RequestSharingDeviceApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            FindNetworkResult findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
            if (findNetworkResult == null) {
                HmsFindSDKLog.m32127i("RequestSharingDeviceApiCall", "body parse error");
                apiException = new ApiException(new Status(-1, "body parse error"));
            } else {
                if (findNetworkResult.getRespCode() == 0) {
                    HmsFindSDKLog.m32127i("RequestSharingDeviceApiCall", "request sharing device response");
                    FindNetworkResult<String> findNetworkResult2 = new FindNetworkResult<>();
                    findNetworkResult2.setRespCode(findNetworkResult.getRespCode());
                    findNetworkResult2.setDescription(findNetworkResult.getDescription());
                    if (findNetworkResult.getData() != null) {
                        findNetworkResult2.setData(JsonUtils.object2Json((ResultResponse) findNetworkResult.getData()));
                    }
                    c8941i.m56658d(findNetworkResult2);
                    return;
                }
                HmsFindSDKLog.m32127i("RequestSharingDeviceApiCall", "result errorCode = " + findNetworkResult.getRespCode() + ", description = " + findNetworkResult.getDescription());
                apiException = new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription()));
            }
        }
        c8941i.m56657c(apiException);
    }
}
