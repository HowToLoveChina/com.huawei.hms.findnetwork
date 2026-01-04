package com.huawei.hianalytics.process;

import com.huawei.hianalytics.C4778g1;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class HaEvent {

    /* renamed from: a */
    public final long f21897a;

    /* renamed from: a */
    public final String f21898a;

    /* renamed from: a */
    public final JSONObject f21899a;

    public HaEvent(String str, JSONObject jSONObject, long j10) {
        this.f21897a = j10;
        this.f21898a = str;
        this.f21899a = jSONObject;
    }

    public static HaEvent create(String str, LinkedHashMap<String, String> linkedHashMap) {
        return new HaEvent(str, linkedHashMap == null ? new JSONObject() : C4778g1.m28886a(linkedHashMap), System.currentTimeMillis());
    }

    public static HaEvent create(String str, JSONObject jSONObject) {
        return new HaEvent(str, jSONObject, System.currentTimeMillis());
    }
}
