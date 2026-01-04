package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import es.C9542g;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.o */
/* loaded from: classes8.dex */
public class C5740o extends AbstractC5696b<C5750r0, OfflineLocationResponse> {
    public C5740o(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<OfflineLocationResponse>) c8941i);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 7;
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<OfflineLocationResponse> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("GetOfflineLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, responseErrorCode.getErrorCode() == 0 ? (OfflineLocationResponse) C9542g.m59588a().fromJson(str, OfflineLocationResponse.class) : null);
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("GetOfflineLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "get last location doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("GetOfflineLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "get last location doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
