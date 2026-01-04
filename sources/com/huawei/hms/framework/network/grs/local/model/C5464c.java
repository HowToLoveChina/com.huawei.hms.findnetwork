package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.c */
/* loaded from: classes8.dex */
public class C5464c {

    /* renamed from: a */
    private String f25016a;

    /* renamed from: b */
    private String f25017b;

    /* renamed from: c */
    private final Map<String, C5465d> f25018c = new ConcurrentHashMap(16);

    /* renamed from: d */
    private List<C5463b> f25019d = new ArrayList(16);

    /* renamed from: a */
    public C5465d m32350a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f25018c.get(str);
        }
        Logger.m32145w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    /* renamed from: b */
    public String m32354b() {
        return this.f25017b;
    }

    /* renamed from: c */
    public JSONObject m32356c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f25016a);
        jSONObject.put("routeBy", this.f25017b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f25018c.keySet().iterator();
        while (it.hasNext()) {
            C5465d c5465d = this.f25018c.get(it.next());
            if (c5465d != null) {
                jSONArray.put(c5465d.m32362c());
            }
        }
        jSONObject.put("servings", jSONArray);
        if (this.f25019d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<C5463b> it2 = this.f25019d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m32348c());
            }
            jSONObject.put("countryGroups", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public List<C5463b> m32351a() {
        return this.f25019d;
    }

    /* renamed from: b */
    public void m32355b(String str) {
        this.f25016a = str;
    }

    /* renamed from: c */
    public void m32357c(String str) {
        this.f25017b = str;
    }

    /* renamed from: a */
    public void m32352a(String str, C5465d c5465d) {
        if (TextUtils.isEmpty(str) || c5465d == null) {
            return;
        }
        this.f25018c.put(str, c5465d);
    }

    /* renamed from: a */
    public void m32353a(List<C5463b> list) {
        this.f25019d = list;
    }
}
