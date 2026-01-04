package com.huawei.hms.findnetwork.comm.request;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public abstract class BaseTaskApiCall<ClientT extends HmsClient, RequestT extends BaseRequestBean, ResultT> extends TaskApiCall<ClientT, ResultT> {
    private static final String TAG = "BaseTaskApiCall";

    public BaseTaskApiCall(String str, RequestT requestt) {
        super(str, JsonUtils.object2Json(requestt));
    }

    public ApiException getApiException(int i10) {
        return new ApiException(new Status(i10, ErrorCode.getStatusCode(i10)));
    }

    public FindNetworkConfigResult<RequestT> getConfigResult(int i10, String str) {
        FindNetworkConfigResult<RequestT> findNetworkConfigResult = new FindNetworkConfigResult<>();
        findNetworkConfigResult.setRespCode(i10);
        findNetworkConfigResult.setDescription(str);
        return findNetworkConfigResult;
    }

    public abstract void handleBusiness(ClientT clientt, ResponseErrorCode responseErrorCode, String str, C8941i<ResultT> c8941i);

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, C8941i<ResultT> c8941i) {
        if (responseErrorCode.getErrorCode() == 0) {
            HmsFindCommonLog.m31923d(TAG, "doExecute success");
        } else {
            HmsFindCommonLog.m31926w(TAG, "doExecute errorCode:" + responseErrorCode.getErrorCode() + ", msg:" + responseErrorCode.getErrorReason());
        }
        handleBusiness(clientt, responseErrorCode, str, c8941i);
    }
}
