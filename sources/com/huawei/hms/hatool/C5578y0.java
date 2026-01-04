package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.y0 */
/* loaded from: classes8.dex */
public class C5578y0 extends AbstractC5568t0 {

    /* renamed from: f */
    String f25325f;

    /* renamed from: g */
    String f25326g;

    /* renamed from: h */
    private String f25327h;

    @Override // com.huawei.hms.hatool.InterfaceC5557o1
    /* renamed from: a */
    public JSONObject mo32451a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f25327h);
        jSONObject.put("_emui_ver", this.f25308a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f25325f);
        jSONObject.put("_mnc", this.f25326g);
        jSONObject.put("_package_name", this.f25309b);
        jSONObject.put("_app_ver", this.f25310c);
        jSONObject.put("_lib_ver", "2.2.0.315");
        jSONObject.put("_channel", this.f25311d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f25312e);
        return jSONObject;
    }

    /* renamed from: f */
    public void m32825f(String str) {
        this.f25325f = str;
    }

    /* renamed from: g */
    public void m32826g(String str) {
        this.f25326g = str;
    }

    /* renamed from: h */
    public void m32827h(String str) {
        this.f25327h = str;
    }
}
