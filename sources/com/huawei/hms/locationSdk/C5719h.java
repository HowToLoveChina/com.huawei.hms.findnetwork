package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import es.C9538c;
import java.util.List;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.h */
/* loaded from: classes8.dex */
public class C5719h extends AbstractC5696b<C5756t0, List<HWLocation>> {

    /* renamed from: d */
    private Context f25518d;

    public C5719h(Context context, String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f25518d = context;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5756t0) anyClient, responseErrorCode, str, (C8941i<List<HWLocation>>) c8941i);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        int iM59567f = C9538c.m59567f(this.f25518d);
        return (iM59567f == 0 || iM59567f == 1) ? 6 : 5;
    }

    public void doExecute(C5756t0 c5756t0, ResponseErrorCode responseErrorCode, String str, C8941i<List<HWLocation>> c8941i) throws ApiException {
        try {
            HMSLocationLog.m36662i("GetFromLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, responseErrorCode.getErrorCode() == 0 ? LocationJsonUtil.parseHwLocationsFromJsonObject(new JSONObject(str)) : null);
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("GetFromLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "getFromLocation doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("GetFromLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "getFromLocation doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
