package com.huawei.hms.hatool;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.f0 */
/* loaded from: classes8.dex */
public class C5529f0 extends AbstractC5544k0 {

    /* renamed from: g */
    private String f25181g = "";

    @Override // com.huawei.hms.hatool.InterfaceC5557o1
    /* renamed from: a */
    public JSONObject mo32451a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f25235d);
        jSONObject.put("appid", this.f25232a);
        jSONObject.put("hmac", this.f25181g);
        jSONObject.put("chifer", this.f25237f);
        jSONObject.put("timestamp", this.f25233b);
        jSONObject.put("servicetag", this.f25234c);
        jSONObject.put("requestid", this.f25236e);
        return jSONObject;
    }

    /* renamed from: g */
    public void m32511g(String str) {
        this.f25181g = str;
    }
}
