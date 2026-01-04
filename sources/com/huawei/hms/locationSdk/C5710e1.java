package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.e1 */
/* loaded from: classes8.dex */
public class C5710e1 extends AbstractC5696b<C5747q0, Void> {

    /* renamed from: d */
    private C5702c1 f25508d;

    public C5710e1(String str, String str2, C5702c1 c5702c1) {
        super(str, str2, c5702c1.m33186a());
        this.f25508d = c5702c1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5747q0) anyClient, responseErrorCode, str, (C8941i<Void>) c8941i);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    public void doExecute(C5747q0 c5747q0, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("RequestActivityTransitionUpdatesTaskApiCall", ((AbstractC5696b) this).f25484a, "request activityTrans doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                C5706d1.m33063b().m33192a(this.f25508d);
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, null);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("RequestActivityTransitionUpdatesTaskApiCall", ((AbstractC5696b) this).f25484a, "request activityTrans doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
