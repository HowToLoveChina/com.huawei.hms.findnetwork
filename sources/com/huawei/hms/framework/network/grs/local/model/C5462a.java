package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.a */
/* loaded from: classes8.dex */
public class C5462a {

    /* renamed from: a */
    private String f25009a;

    /* renamed from: b */
    private long f25010b;

    /* renamed from: c */
    private final Map<String, C5464c> f25011c = new ConcurrentHashMap(16);

    /* renamed from: a */
    public C5464c m32337a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f25011c.get(str);
        }
        Logger.m32145w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    /* renamed from: b */
    public JSONObject m32341b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", TextUtils.isEmpty(this.f25009a) ? "" : this.f25009a);
        jSONObject.put("cacheControl", this.f25010b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f25011c.keySet().iterator();
        while (it.hasNext()) {
            C5464c c5464c = this.f25011c.get(it.next());
            if (c5464c != null) {
                jSONArray.put(c5464c.m32356c());
            }
        }
        Logger.m32141i("ApplicationBean", "local config save to sp, services count:" + jSONArray.length());
        jSONObject.put("services", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public String m32338a() {
        return this.f25009a;
    }

    /* renamed from: b */
    public void m32342b(String str) {
        this.f25009a = str;
    }

    /* renamed from: a */
    public void m32339a(long j10) {
        this.f25010b = j10;
    }

    /* renamed from: a */
    public void m32340a(String str, C5464c c5464c) {
        if (TextUtils.isEmpty(str) || c5464c == null) {
            return;
        }
        this.f25011c.put(str, c5464c);
    }
}
