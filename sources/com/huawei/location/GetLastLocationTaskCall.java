package com.huawei.location;

import android.location.Location;
import as.C1016d;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationRequest;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9542g;
import is.C10606c;
import org.json.JSONException;
import org.json.JSONObject;
import p531or.C11991a;
import p622rr.C12619b;
import p854zs.C14374c;
import p854zs.C14375d;

/* loaded from: classes8.dex */
public class GetLastLocationTaskCall extends BaseApiRequest {
    private static final String TAG = "GetLastLocationApi";

    private String buildRpt(GetLastLocationRequest getLastLocationRequest) throws JSONException {
        C1016d.m6186f(TAG, "buildRpt:" + C9542g.m59588a().toJson(getLastLocationRequest));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("needAddress", getLastLocationRequest.getNeedAddress());
            return jSONObject.toString();
        } catch (JSONException unused) {
            C1016d.m6183c(TAG, "buildRpt failed by exception");
            return "";
        }
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest GetLastLocationTaskCall");
        GetLastLocationRequest getLastLocationRequest = new GetLastLocationRequest(C11991a.m72145a());
        this.apiName = "Location_getLocation";
        try {
            checkApproximatelyPermission();
            C10606c.m65019d().getClass();
            Location locationM65018b = C10606c.m65018b();
            StatusInfo statusInfo = new StatusInfo(0, 0, "");
            GetLastLocationResponse getLastLocationResponse = new GetLastLocationResponse();
            C14375d.m85589b(str, getLastLocationRequest);
            getLastLocationResponse.setLocation(locationM65018b);
            doExecute(new RouterResponse(C14374c.m85583a(getLastLocationResponse), statusInfo));
            this.reportBuilder.m85577c(buildRpt(getLastLocationRequest));
        } catch (C12619b e10) {
            this.errorCode = String.valueOf(e10.m76135b());
            onRequestFail(e10.m76135b(), e10.getMessage());
        } catch (Exception unused) {
            this.errorCode = String.valueOf(10000);
            onRequestFail(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        report(getLastLocationRequest);
    }
}
