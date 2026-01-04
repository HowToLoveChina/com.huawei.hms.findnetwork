package com.huawei.hms.locationSdk;

import android.location.Location;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.k */
/* loaded from: classes8.dex */
public class C5728k extends AbstractC5696b<C5750r0, Location> {
    public C5728k(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<Location>) c8941i);
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<Location> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, LocationJsonUtil.convertLocation(responseErrorCode.getErrorCode() == 0 ? LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str)) : null));
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "get last location doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "get last location doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
