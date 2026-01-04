package com.huawei.hms.findnetwork.comm.request;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class TextApiCall extends TaskApiCall<HmsClient, String> {
    private static final String TAG = "UniversalTaskApiCall";

    public TextApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<String> c8941i) {
        FindNetworkException findNetworkException;
        if (responseErrorCode.getErrorCode() != 0) {
            HmsFindCommonLog.m31924e(TAG, getUri() + " -" + responseErrorCode.getErrorCode() + " reason:" + responseErrorCode.getErrorReason());
            findNetworkException = new FindNetworkException(responseErrorCode.getErrorReason(), responseErrorCode.getErrorCode());
        } else {
            if (!TextUtils.isEmpty(str)) {
                c8941i.m56658d(str);
                return;
            }
            HmsFindCommonLog.m31926w(TAG, getUri() + " - no body");
            findNetworkException = new FindNetworkException("none body", responseErrorCode.getErrorCode());
        }
        c8941i.m56657c(findNetworkException);
    }
}
