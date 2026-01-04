package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.e */
/* loaded from: classes8.dex */
public class C5708e extends AbstractC5696b<C5750r0, Void> {
    public C5708e(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<Void>) c8941i);
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) throws ApiException {
        HMSLocationLog.m36662i("DisableBackgroundLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
        try {
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, null);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("DisableBackgroundLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "disable background location doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
