package com.huawei.location;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.client.Status;
import com.huawei.location.req.CheckLocationSettingsReq;
import com.huawei.location.resp.CheckLocationSettingsResp;
import com.huawei.location.resp.StatusCheck;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9542g;
import es.C9545j;
import is.C10606c;
import org.json.JSONException;
import org.json.JSONObject;
import p531or.C11991a;
import p589qs.C12392a;
import p854zs.C14374c;

/* loaded from: classes8.dex */
public class CheckSettingsTaskCall extends BaseApiRequest {
    private static final String LOCATION_SETTING_REQUEST = "locationSettingsRequest";
    private static final String TAG = "CheckLocationSettingsApi";

    private CheckLocationSettingsResp changeResponse(C12392a c12392a) {
        CheckLocationSettingsResp checkLocationSettingsResp = new CheckLocationSettingsResp();
        StatusCheck statusCheck = new StatusCheck();
        statusCheck.setStatusCode(c12392a.m74471a().getStatusCode());
        statusCheck.setStatusMessage(c12392a.m74471a().getStatusMessage());
        checkLocationSettingsResp.setStatusCheck(statusCheck);
        checkLocationSettingsResp.setLocationSettingsStates(c12392a.m74472b());
        return checkLocationSettingsResp;
    }

    private void parseCheckSettingJson(CheckLocationSettingsReq checkLocationSettingsReq, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            checkLocationSettingsReq.setTid(jSONObject.getString("locTransactionId"));
            checkLocationSettingsReq.setPackageName(jSONObject.getString("packageName"));
            String string = jSONObject.getString(LOCATION_SETTING_REQUEST);
            if (TextUtils.isEmpty(string)) {
                C1016d.m6183c(TAG, "parseCheckSettingString locationSettingsRequest is null");
            }
            JSONObject jSONObject2 = new JSONObject(string);
            checkLocationSettingsReq.setAlwaysShow(jSONObject2.getBoolean("alwaysShow"));
            checkLocationSettingsReq.setNeedBle(jSONObject2.getBoolean("needBle"));
        } catch (JSONException unused) {
            C1016d.m6186f(TAG, "parseCheckSettingString JSONException");
        }
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) throws JSONException {
        C1016d.m6186f(TAG, "onRequest json begin");
        CheckLocationSettingsReq checkLocationSettingsReq = new CheckLocationSettingsReq();
        parseCheckSettingJson(checkLocationSettingsReq, str);
        C10606c.m65019d().getClass();
        LocationSettingsStates locationSettingsStates = new LocationSettingsStates();
        boolean zM85587e = C14374c.m85587e("gps");
        boolean zM85587e2 = C14374c.m85587e("network");
        locationSettingsStates.setGnssUsable(zM85587e);
        locationSettingsStates.setGnssPresent(zM85587e);
        locationSettingsStates.setGpsUsable(zM85587e);
        locationSettingsStates.setGpsPresent(zM85587e);
        locationSettingsStates.setHmsLocationUsable(false);
        locationSettingsStates.setHMSLocationPresent(false);
        locationSettingsStates.setNetworkLocationUsable(zM85587e2);
        locationSettingsStates.setNetworkLocationPresent(zM85587e2);
        boolean zM59603d = C9545j.m59603d(C11991a.m72145a());
        locationSettingsStates.setLocationUsable(zM59603d);
        locationSettingsStates.setLocationPresent(zM59603d);
        if (checkLocationSettingsReq.isNeedBle()) {
            locationSettingsStates.setBlePresent(C9545j.m59601b(C11991a.m72145a()));
            locationSettingsStates.setBleUsable(C9545j.m59605f(C11991a.m72145a()) || C9545j.m59602c(C11991a.m72145a()));
        } else {
            locationSettingsStates.setBleUsable(false);
            locationSettingsStates.setBlePresent(false);
        }
        C12392a c12392a = new C12392a();
        c12392a.m74474d(Status.SUCCESS);
        c12392a.m74473c(locationSettingsStates);
        onComplete(new RouterResponse(C9542g.m59588a().toJson(changeResponse(c12392a)), new StatusInfo(0, 0, "SUCCESS")));
        this.reportBuilder.m85578d("Location_checkSettings");
        this.reportBuilder.m85581g(checkLocationSettingsReq);
        this.reportBuilder.m85579e().m85574b("0");
    }
}
