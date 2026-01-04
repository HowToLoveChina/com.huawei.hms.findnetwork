package com.huawei.hms.framework.network.grs.local.model;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.b */
/* loaded from: classes8.dex */
public class C5463b {

    /* renamed from: a */
    private String f25012a;

    /* renamed from: b */
    private String f25013b;

    /* renamed from: c */
    private Set<String> f25014c;

    /* renamed from: d */
    private String f25015d;

    /* renamed from: a */
    public Set<String> m32343a() {
        return this.f25014c;
    }

    /* renamed from: b */
    public String m32346b() {
        return this.f25012a;
    }

    /* renamed from: c */
    public JSONObject m32348c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f25012a);
        jSONObject.put("name", this.f25013b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f25014c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("countries", jSONArray);
        jSONObject.put("description", this.f25015d);
        return jSONObject;
    }

    /* renamed from: a */
    public void m32344a(String str) {
        this.f25015d = str;
    }

    /* renamed from: b */
    public void m32347b(String str) {
        this.f25012a = str;
    }

    /* renamed from: c */
    public void m32349c(String str) {
        this.f25013b = str;
    }

    /* renamed from: a */
    public void m32345a(Set<String> set) {
        this.f25014c = set;
    }
}
