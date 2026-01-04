package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hwid.b */
/* loaded from: classes8.dex */
public class C5603b extends AbstractC5596am {
    /* renamed from: a */
    public static C5603b m32913a(String str) throws JSONException {
        return new C5603b().m32914a(new JSONObject(str));
    }

    /* renamed from: a */
    public C5603b m32914a(JSONObject jSONObject) {
        this.f25344a = jSONObject.optString("appId", null);
        this.f25345b = jSONObject.optString("packageName", null);
        this.f25346c = jSONObject.optLong("hmsSdkVersion");
        this.f25347d = jSONObject.optString("subAppId", null);
        return this;
    }
}
