package com.huawei.hms.hwid;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.ak */
/* loaded from: classes8.dex */
public class C5594ak extends TaskApiCall<C5592ai, Void> {
    public C5594ak(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(C5592ai c5592ai, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        C5590ag c5590agM32867b = C5590ag.m32867b(str);
        Integer numM32868a = c5590agM32867b.m32868a();
        String strM32871b = c5590agM32867b.m32871b();
        if (numM32868a == null) {
            numM32868a = Integer.valueOf(responseErrorCode.getErrorCode());
            strM32871b = responseErrorCode.getErrorReason();
        }
        if (m32876a(responseErrorCode, c5590agM32867b.m32868a())) {
            c8941i.m56658d(null);
        } else {
            c8941i.m56657c(new ApiException(new Status(numM32868a.intValue(), strM32871b)));
        }
        if (c5592ai != null) {
            HiAnalyticsClient.reportExit(c5592ai.getContext(), getUri(), getTransactionId(), C5601ar.m32908a(numM32868a.intValue()), numM32868a.intValue());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    /* renamed from: a */
    private boolean m32876a(ResponseErrorCode responseErrorCode, Integer num) {
        return num == null ? responseErrorCode.getStatusCode() == 0 : num.intValue() == 0;
    }
}
