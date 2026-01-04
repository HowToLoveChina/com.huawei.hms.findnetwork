package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hwid.af */
/* loaded from: classes8.dex */
public class C5589af {

    /* renamed from: a */
    private String f25341a;

    public C5589af() {
    }

    /* renamed from: a */
    public String m32866a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f25341a);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C5602as.m32912d("ReadSmsInputBean", "toJson failed", true);
            return null;
        }
    }

    public C5589af(String str) {
        this.f25341a = str;
    }
}
