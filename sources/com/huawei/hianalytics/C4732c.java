package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.c */
/* loaded from: classes5.dex */
public class C4732c implements EvtHeaderAttributeCollector {

    /* renamed from: a */
    public final JSONObject f21664a;

    public C4732c(JSONObject jSONObject) {
        this.f21664a = jSONObject;
    }

    @Override // com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector
    public JSONObject doCollector(JSONObject jSONObject, int i10) throws JSONException {
        if (this.f21664a == null) {
            return null;
        }
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.f21664a.put(next, jSONObject.getString(next));
                }
            } catch (Exception unused) {
                HiLog.m28808e("HAHC", "json exception");
            }
        }
        this.f21664a.put("hmac", "");
        return this.f21664a;
    }
}
