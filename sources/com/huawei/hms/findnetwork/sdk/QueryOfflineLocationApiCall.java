package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.OfflineLocationBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.j0 */
/* loaded from: classes8.dex */
public class QueryOfflineLocationApiCall extends BaseTaskApiCall<HmsClient, FidRequestBean, FindNetworkResult<OfflineLocationBean>> {
    public QueryOfflineLocationApiCall(FidRequestBean fidRequestBean) {
        super("findnetwork.wear_queryOfflineLocation", fidRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<OfflineLocationBean>> c8941i) {
        HmsFindSDKLog.m32127i("QueryOfflineLocationApiCall", "handleBusiness QueryOfflineLocationApiCall");
        FindNetworkResult<OfflineLocationBean> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setSrcTransId(getTransactionId());
        if (responseErrorCode.getErrorCode() != 0 || TextUtils.isEmpty(str)) {
            findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
            findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        } else {
            findNetworkResult.setData((OfflineLocationBean) JsonUtils.json2Object(str, OfflineLocationBean.class));
        }
        c8941i.m56658d(findNetworkResult);
    }
}
