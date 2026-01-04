package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.RoadDataResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import es.C9542g;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.u1 */
/* loaded from: classes8.dex */
public class C5760u1 extends AbstractC5696b<C5753s0, RoadDataResult> {
    public C5760u1(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5753s0) anyClient, responseErrorCode, str, (C8941i<RoadDataResult>) c8941i);
    }

    public void doExecute(C5753s0 c5753s0, ResponseErrorCode responseErrorCode, String str, C8941i<RoadDataResult> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("SetRoadDataTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            int errorCode = responseErrorCode.getErrorCode();
            HMSLocationLog.m36662i("SetRoadDataTaskApiCall", ((AbstractC5696b) this).f25484a, "SetRoadDataTaskApiCall message start");
            RoadDataResult roadDataResult = new RoadDataResult();
            if (errorCode == 0) {
                roadDataResult = (RoadDataResult) C9542g.m59588a().fromJson(str, RoadDataResult.class);
            }
            roadDataResult.setStatus(new Status(errorCode));
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, roadDataResult);
            HMSLocationLog.m36657d("SetRoadDataTaskApiCall", ((AbstractC5696b) this).f25484a, "SetRoadData message success");
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("SetRoadDataTaskApiCall", ((AbstractC5696b) this).f25484a, "SetRoadData doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("SetRoadDataTaskApiCall", ((AbstractC5696b) this).f25484a, "SetRoadData doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
