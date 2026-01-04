package com.huawei.hms.support.api.safetydetect.p860default;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.d0 */
/* loaded from: classes8.dex */
public class C6361d0 extends C6362e {

    /* renamed from: a */
    private String f29890a;

    public C6361d0(String str) {
        this.f29890a = str;
    }

    /* renamed from: a */
    public String m36731a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.f29890a);
        } catch (JSONException e10) {
            Log.e("UserDetectRequest", "Json conversion exception! " + e10.getMessage());
        }
        return jSONObject.toString();
    }
}
