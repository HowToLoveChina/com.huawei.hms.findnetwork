package com.huawei.hianalytics.kit;

import com.huawei.hianalytics.C4806t0;
import com.huawei.hianalytics.C4812w0;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* loaded from: classes5.dex */
public class HiAnalyticsTaskApiCall extends TaskApiCall<C4806t0, C4812w0> {
    public HiAnalyticsTaskApiCall(String str, String str2) {
        super(str, str2);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(C4806t0 c4806t0, ResponseErrorCode responseErrorCode, String str, C8941i<C4812w0> c8941i) {
        if (responseErrorCode.getErrorCode() == 0) {
            c8941i.m56658d(new C4812w0(str));
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
