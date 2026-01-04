package com.huawei.hms.locationSdk;

import com.huawei.hms.api.HuaweiApiAvailability;
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

/* renamed from: com.huawei.hms.locationSdk.n1 */
/* loaded from: classes8.dex */
public class C5739n1 extends AbstractC5696b<C5750r0, Void> {

    /* renamed from: d */
    private C5733l1 f25552d;

    public C5739n1(String str, String str2, String str3, C5733l1 c5733l1, String str4) {
        super(str, str2, str3, str4);
        this.f25552d = c5733l1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<Void>) c8941i);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) throws ApiException {
        HMSLocationLog.m36662i("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
        try {
            if (responseErrorCode == null) {
                C5768x0.m33197b().mo33194c(this.f25552d);
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                JSONObject jSONObject = new JSONObject(str);
                C5733l1 c5733l1 = this.f25552d;
                if (c5733l1 != null && c5733l1.m33122d() != null) {
                    if (jSONObject.has("locationResult")) {
                        int size = LocationJsonUtil.parseLocationResultFromJsonObject(jSONObject).getLocations().size();
                        int iM33125g = this.f25552d.m33125g();
                        HMSLocationLog.m36662i("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "modify numUpdates with callback, numUpdates:" + iM33125g + " , locationSize:" + size);
                        if (iM33125g > 0 && iM33125g >= size) {
                            if (iM33125g == size) {
                                HMSLocationLog.m36662i("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "modify numUpdates last need remove request");
                                C5758u.m33173b(c5750r0.getContext(), (C5765w0) null).mo33066a(this.f25552d.m33119b());
                            } else {
                                HMSLocationLog.m36662i("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "numUpdates greater than locationSize");
                            }
                            C5768x0.m33197b().m33201a(this.f25552d, iM33125g - size);
                            return;
                        }
                        HMSLocationLog.m36662i("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "modify numUpdates exception need remove request");
                        C5758u.m33173b(c5750r0.getContext(), (C5765w0) null).mo33066a(this.f25552d.m33119b());
                        return;
                    }
                    if (jSONObject.has("locationAvailability")) {
                        return;
                    } else {
                        C5768x0.m33197b().mo33195d(this.f25552d);
                    }
                }
                HMSLocationLog.m36660e("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "INTERNAL_ERROR : doExecute requestLocationUpdatesCache is null");
                return;
            }
            C5768x0.m33197b().mo33194c(this.f25552d);
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, null);
        } catch (ApiException e10) {
            C5768x0.m33197b().mo33194c(this.f25552d);
            HMSLocationLog.m36660e("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            C5768x0.m33197b().mo33194c(this.f25552d);
            HMSLocationLog.m36660e("RequestLocationUpdatesWithIntentTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
