package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hianalytics.core.storage.Event;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.b1 */
/* loaded from: classes8.dex */
public class C5518b1 implements InterfaceC5557o1 {

    /* renamed from: a */
    private String f25157a;

    /* renamed from: b */
    private String f25158b;

    /* renamed from: c */
    private String f25159c;

    /* renamed from: d */
    private String f25160d;

    /* renamed from: e */
    private String f25161e;

    /* renamed from: f */
    private String f25162f;

    @Override // com.huawei.hms.hatool.InterfaceC5557o1
    /* renamed from: a */
    public JSONObject mo32451a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f25157a);
        jSONObject.put(Event.EventConstants.RECORD_TIME, this.f25160d);
        jSONObject.put("event", this.f25158b);
        jSONObject.put(Event.EventConstants.SESSION_NAME, this.f25161e);
        jSONObject.put(Event.EventConstants.IS_FIRST_SESSION, this.f25162f);
        if (TextUtils.isEmpty(this.f25159c)) {
            return null;
        }
        jSONObject.put(Event.EventConstants.PROPERTIES, new JSONObject(this.f25159c));
        return jSONObject;
    }

    /* renamed from: b */
    public String m32454b() {
        return this.f25160d;
    }

    /* renamed from: c */
    public String m32456c() {
        return this.f25157a;
    }

    /* renamed from: d */
    public JSONObject m32458d() throws JSONException {
        JSONObject jSONObjectMo32451a = mo32451a();
        jSONObjectMo32451a.put(Event.EventConstants.PROPERTIES, C5552n.m32654b(this.f25159c, C5556o0.m32677d().m32681a()));
        return jSONObjectMo32451a;
    }

    /* renamed from: e */
    public void m32460e(String str) {
        this.f25162f = str;
    }

    /* renamed from: f */
    public void m32461f(String str) {
        this.f25161e = str;
    }

    /* renamed from: a */
    public void m32452a(String str) {
        this.f25159c = str;
    }

    /* renamed from: b */
    public void m32455b(String str) {
        this.f25158b = str;
    }

    /* renamed from: c */
    public void m32457c(String str) {
        this.f25160d = str;
    }

    /* renamed from: d */
    public void m32459d(String str) {
        this.f25157a = str;
    }

    /* renamed from: a */
    public void m32453a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f25158b = jSONObject.optString("event");
        this.f25159c = C5552n.m32652a(jSONObject.optString(Event.EventConstants.PROPERTIES), C5556o0.m32677d().m32681a());
        this.f25157a = jSONObject.optString("type");
        this.f25160d = jSONObject.optString(Event.EventConstants.RECORD_TIME);
        this.f25161e = jSONObject.optString(Event.EventConstants.SESSION_NAME);
        this.f25162f = jSONObject.optString(Event.EventConstants.IS_FIRST_SESSION);
    }
}
