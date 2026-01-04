package com.huawei.hms.framework.network.grs.local.model;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.d */
/* loaded from: classes8.dex */
public class C5465d {

    /* renamed from: a */
    private String f25020a;

    /* renamed from: b */
    private Map<String, String> f25021b;

    /* renamed from: a */
    public Map<String, String> m32358a() {
        return this.f25021b;
    }

    /* renamed from: b */
    public String m32361b() {
        return this.f25020a;
    }

    /* renamed from: c */
    public JSONObject m32362c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("countryGroup", this.f25020a);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.f25021b.keySet()) {
            jSONObject2.put(str, this.f25021b.get(str));
        }
        jSONObject.put("addresses", jSONObject2);
        return jSONObject;
    }

    /* renamed from: a */
    public void m32359a(String str) {
        this.f25020a = str;
    }

    /* renamed from: a */
    public void m32360a(Map<String, String> map) {
        this.f25021b = map;
    }
}
