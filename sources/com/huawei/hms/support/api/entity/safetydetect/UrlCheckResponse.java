package com.huawei.hms.support.api.entity.safetydetect;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class UrlCheckResponse {
    private List<UrlCheckThreat> urlCheckThreats;

    public UrlCheckResponse(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.urlCheckThreats = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONObject("rtdResults").getJSONArray("threatType");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.urlCheckThreats.add(new UrlCheckThreat(jSONArray.getInt(i10)));
        }
    }

    public List<UrlCheckThreat> getUrlCheckResponse() {
        return this.urlCheckThreats;
    }
}
