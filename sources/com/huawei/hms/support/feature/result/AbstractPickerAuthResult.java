package com.huawei.hms.support.feature.result;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class AbstractPickerAuthResult extends Result {
    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public void jsonToSuper(Map<Integer, Integer> map, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("statusCode");
        if (map.get(Integer.valueOf(iOptInt)) != null) {
            iOptInt = map.get(Integer.valueOf(iOptInt)).intValue();
        }
        setStatus(new Status(iOptInt, jSONObjectOptJSONObject.optString(AccountPickerCommonConstant.KEY_STATUS_MESSAGE, null)));
    }

    public JSONObject superToJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (getStatus() != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("statusCode", getStatus().getStatusCode());
            if (getStatus().getStatusMessage() != null) {
                jSONObject2.put(AccountPickerCommonConstant.KEY_STATUS_MESSAGE, getStatus().getStatusMessage());
            }
            jSONObject.put("status", jSONObject2);
        }
        return jSONObject;
    }
}
