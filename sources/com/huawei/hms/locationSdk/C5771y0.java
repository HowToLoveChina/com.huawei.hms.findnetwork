package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.y0 */
/* loaded from: classes8.dex */
public class C5771y0 extends AbstractC5696b<C5747q0, Void> {

    /* renamed from: d */
    private C5702c1 f25604d;

    public C5771y0(String str, String str2, C5702c1 c5702c1) {
        super(str, str2, c5702c1.m33186a());
        this.f25604d = c5702c1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5747q0) anyClient, responseErrorCode, str, (C8941i<Void>) c8941i);
    }

    public void doExecute(C5747q0 c5747q0, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) throws ApiException {
        try {
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                C5706d1.m33063b().mo33194c(this.f25604d);
            }
            HMSLocationLog.m36662i("RemoveActivityTransitionUpdatesTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, null);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("RemoveActivityTransitionUpdatesTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
