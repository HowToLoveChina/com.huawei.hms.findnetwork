package com.huawei.hms.p109a.p110a.p111a;

import com.huawei.hms.common.internal.bean.AbstractCpPickerClientInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.a.a.a.a */
/* loaded from: classes8.dex */
public class C5037a extends AbstractCpPickerClientInfo {
    /* renamed from: a */
    public static C5037a m30078a(String str) throws JSONException {
        return new C5037a().m30079a(new JSONObject(str));
    }

    @Override // com.huawei.hms.common.internal.bean.AbstractCpPickerClientInfo
    public String toString() {
        return "CpClientInfo{appId='" + this.f23520a + "', packageName='" + this.f23521b + "', hmsSdkVersion=" + this.f23522c + "', subAppId=" + this.f23523d + '}';
    }

    /* renamed from: a */
    private C5037a m30079a(JSONObject jSONObject) {
        this.f23520a = jSONObject.optString("appId", null);
        this.f23521b = jSONObject.optString("packageName", null);
        this.f23522c = jSONObject.optLong("hmsSdkVersion");
        this.f23523d = jSONObject.optString("subAppId", null);
        return this;
    }
}
