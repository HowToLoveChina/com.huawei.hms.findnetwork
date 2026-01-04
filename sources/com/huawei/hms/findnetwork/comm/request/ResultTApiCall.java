package com.huawei.hms.findnetwork.comm.request;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class ResultTApiCall<ResultT> extends TaskApiCall<HmsClient, ResultT> {
    private static final String TAG = "ResultTApiCall";

    public ResultTApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public ResultT handleBusiness(String str) throws FindNetworkException {
        return null;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<ResultT> c8941i) {
        if (handleBusiness(hmsClient, responseErrorCode, str, c8941i)) {
            HmsFindCommonLog.m31925i(TAG, "handleBusiness over");
            return;
        }
        if (responseErrorCode.getErrorCode() != 0) {
            HmsFindCommonLog.m31924e(TAG, getUri() + " -" + responseErrorCode.getErrorCode() + " reason:" + responseErrorCode.getErrorReason());
            e = new FindNetworkException(responseErrorCode.getErrorReason(), responseErrorCode.getErrorCode());
        } else if (TextUtils.isEmpty(str)) {
            HmsFindCommonLog.m31926w(TAG, getUri() + " - no body");
            e = new FindNetworkException("none body", responseErrorCode.getErrorCode());
        } else {
            try {
                c8941i.m56658d(handleBusiness(str));
                return;
            } catch (FindNetworkException e10) {
                e = e10;
            }
        }
        c8941i.m56657c(e);
    }

    public boolean handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<ResultT> c8941i) {
        HmsFindCommonLog.m31925i(TAG, getUri() + "#" + responseErrorCode.getTransactionId() + " status:" + responseErrorCode.getStatusCode() + " Response:" + responseErrorCode.getErrorCode() + " - " + responseErrorCode.getErrorReason());
        return false;
    }
}
