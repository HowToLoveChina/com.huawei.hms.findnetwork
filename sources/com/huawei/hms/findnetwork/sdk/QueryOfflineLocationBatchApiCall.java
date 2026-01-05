package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidBatchRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.OfflineLocationBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.List;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.k0 */
/* loaded from: classes8.dex */
public class QueryOfflineLocationBatchApiCall extends BaseTaskApiCall<HmsClient, FidBatchRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback<List<OfflineLocationBean>> f24788a;

    public QueryOfflineLocationBatchApiCall(FidBatchRequestBean fidBatchRequestBean, FindNetworkCallback<List<OfflineLocationBean>> findNetworkCallback) {
        super("findnetwork.wear_queryOfflineLocationBatch", fidBatchRequestBean);
        this.f24788a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("QueryOfflineLocationBatchApiCall", "handleBusiness QueryOfflineLocationApiCall");
        FindNetworkResult<List<OfflineLocationBean>> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setSrcTransId(getTransactionId());
        if (responseErrorCode.getErrorCode() != 0 || TextUtils.isEmpty(str)) {
            findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
            findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        } else {
            findNetworkResult.setData(JsonUtils.getObjectList(str, OfflineLocationBean.class));
        }
        this.f24788a.onUpdate(findNetworkResult);
    }
}
