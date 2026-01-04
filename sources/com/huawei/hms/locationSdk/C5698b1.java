package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.mdc.AdsLocationManager;
import com.huawei.location.vdr.VdrManager;
import es.C9551p;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.b1 */
/* loaded from: classes8.dex */
public class C5698b1 extends AbstractC5696b<C5750r0, Void> {

    /* renamed from: d */
    private C5733l1 f25487d;

    public C5698b1(String str, String str2, String str3, C5733l1 c5733l1, String str4) {
        super(str, str2, str3, str4);
        this.f25487d = c5733l1;
        if (C9551p.m59641e("com.huawei.location.vdr.VdrManager")) {
            VdrManager.getInstance().unRegisterVdrLocationLis(this.f25487d.m33126h());
        }
        if (LocationRequestHelper.isNeedMdcLocation()) {
            AdsLocationManager.getInstance().removeLocationUpdates(this.f25487d.m33126h());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<Void>) c8941i);
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("RemoveLocationUpdatesTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            C5768x0.m33197b().m33202a(this.f25487d.m33121c());
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0 || responseErrorCode.getErrorCode() == 10104) {
                C5768x0.m33197b().mo33194c(this.f25487d);
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, null);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("RemoveLocationUpdatesTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
