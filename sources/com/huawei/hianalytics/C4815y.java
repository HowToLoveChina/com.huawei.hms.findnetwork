package com.huawei.hianalytics;

import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.y */
/* loaded from: classes5.dex */
public class C4815y {

    /* renamed from: a */
    public long f21991a;

    /* renamed from: a */
    public String f21992a;

    /* renamed from: b */
    public String f21993b;

    /* renamed from: c */
    public String f21994c;

    /* renamed from: d */
    public String f21995d;

    public C4815y(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f21992a = jSONObject.optString("_id", "");
        this.f21993b = jSONObject.optString("item_id", "");
        this.f21994c = jSONObject.optString("metric_tag", "");
        this.f21991a = jSONObject.optLong("event_time", 0L);
        this.f21995d = jSONObject.optString("content_code", "");
    }
}
