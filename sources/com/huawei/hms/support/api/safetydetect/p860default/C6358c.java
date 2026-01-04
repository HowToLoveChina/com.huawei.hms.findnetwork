package com.huawei.hms.support.api.safetydetect.p860default;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.c */
/* loaded from: classes8.dex */
public class C6358c {

    /* renamed from: a */
    private String f29889a;

    public C6358c(String str) {
        this.f29889a = str;
    }

    /* renamed from: a */
    public String m36728a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.f29889a);
        } catch (JSONException e10) {
            Log.e("AntiFraudRequest", "Json conversion exception! " + e10.getMessage());
        }
        return jSONObject.toString();
    }
}
