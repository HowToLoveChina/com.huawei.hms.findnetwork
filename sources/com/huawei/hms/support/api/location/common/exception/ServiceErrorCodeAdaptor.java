package com.huawei.hms.support.api.location.common.exception;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class ServiceErrorCodeAdaptor<TResult> {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "ServiceErrorCodeAdaptor";
    private static volatile ServiceErrorCodeAdaptor instance;

    public static ServiceErrorCodeAdaptor getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new ServiceErrorCodeAdaptor();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void setTaskByServiceErrorCode(C8941i<TResult> c8941i, ResponseErrorCode responseErrorCode, TResult tresult) throws Exception {
        int i10 = 10000;
        if (c8941i == null || responseErrorCode == null) {
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
        int errorCode = responseErrorCode.getErrorCode();
        String errorReason = responseErrorCode.getErrorReason();
        HMSLog.m36988i(TAG, "set task by error code:" + responseErrorCode.getErrorCode() + ",reason:" + responseErrorCode.getErrorReason());
        if (responseErrorCode.getErrorCode() < 10000 || responseErrorCode.getErrorCode() > 10099) {
            i10 = errorCode;
        } else {
            errorReason = LocationStatusCode.getStatusCodeString(10000);
        }
        if (i10 == 0) {
            c8941i.m56658d(tresult);
        } else if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
        } else {
            c8941i.m56657c(new ApiException(new Status(i10, errorReason)));
        }
    }
}
