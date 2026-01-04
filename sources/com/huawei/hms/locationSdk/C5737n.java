package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.n */
/* loaded from: classes8.dex */
public class C5737n extends AbstractC5696b<C5753s0, NavigationResult> {

    /* renamed from: d */
    private int f25551d;

    public C5737n(String str, String str2, String str3, int i10) {
        super(str, str2, str3);
        this.f25551d = i10;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5753s0) anyClient, responseErrorCode, str, (C8941i<NavigationResult>) c8941i);
    }

    public void doExecute(C5753s0 c5753s0, ResponseErrorCode responseErrorCode, String str, C8941i<NavigationResult> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("GetNavigationContextStateTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            int errorCode = responseErrorCode.getErrorCode();
            HMSLocationLog.m36657d("GetNavigationContextStateTaskApiCall", ((AbstractC5696b) this).f25484a, "getNavigationContextState message start");
            NavigationResult navigationResult = new NavigationResult();
            if (errorCode == 0) {
                JSONObject jSONObject = new JSONObject(str);
                navigationResult.setState(jSONObject.getInt("environment"));
                navigationResult.setPossibility(jSONObject.getInt("confidence"));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, navigationResult);
            HMSLocationLog.m36657d("GetNavigationContextStateTaskApiCall", ((AbstractC5696b) this).f25484a, "getNavigationContextState message success");
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("GetNavigationContextStateTaskApiCall", ((AbstractC5696b) this).f25484a, "get navi doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("GetNavigationContextStateTaskApiCall", ((AbstractC5696b) this).f25484a, "get navi doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
