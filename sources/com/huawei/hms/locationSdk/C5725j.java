package com.huawei.hms.locationSdk;

import as.C1016d;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.Map;
import org.json.JSONObject;
import p208cq.C8941i;
import p295fs.C9768b;
import p295fs.C9769c;

/* renamed from: com.huawei.hms.locationSdk.j */
/* loaded from: classes8.dex */
public class C5725j extends AbstractC5696b<C5750r0, HWLocation> {

    /* renamed from: d */
    private int f25524d;

    public C5725j(String str, String str2, String str3, String str4, int i10) {
        super(str, str2, str3, str4);
        this.f25524d = i10;
    }

    /* renamed from: a */
    private void m33106a(HWLocation hWLocation) {
        int i10 = this.f25524d;
        if (1 != i10) {
            if (i10 == 0) {
                C1016d.m6181a("GetLastLocationTaskApiCall", "ConvertCoord-- current coordinateType is 0 --no conversion");
                return;
            } else {
                HMSLocationLog.m36662i("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "ConvertCoord-- current coordinateType is unKnown --return 84");
                return;
            }
        }
        Map<String, Object> extraInfo = hWLocation.getExtraInfo();
        if (extraInfo.containsKey(Constant.LOCATION_SOURCE_TYPE) && m33040a(((Integer) extraInfo.get(Constant.LOCATION_SOURCE_TYPE)).intValue())) {
            HMSLocationLog.m36662i("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "RTK position, no conversion required");
            return;
        }
        C9769c c9769cM60797a = C9768b.m60797a(hWLocation.getLatitude(), hWLocation.getLongitude(), 1);
        if (c9769cM60797a == null) {
            hWLocation.setCoordinateType(0);
            HMSLocationLog.m36660e("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "ConvertCoord-- result is null,reset the coordinateType to 0");
        } else {
            hWLocation.setCoordinateType(1);
            hWLocation.setLatitude(c9769cM60797a.m60801a());
            hWLocation.setLongitude(c9769cM60797a.m60802b());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<HWLocation>) c8941i);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<HWLocation> c8941i) throws ApiException {
        HWLocation locationFromJsonObject;
        try {
            HMSLocationLog.m36662i("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                locationFromJsonObject = LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str));
                if (locationFromJsonObject != null) {
                    m33106a(locationFromJsonObject);
                }
            } else {
                locationFromJsonObject = null;
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, locationFromJsonObject);
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "get last locationEn doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("GetLastLocationTaskApiCall", ((AbstractC5696b) this).f25484a, "get last locationEn doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
