package com.huawei.hms.support.api.safetydetect.p860default;

import android.util.Log;
import com.huawei.hms.core.aidl.annotation.Packed;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.x */
/* loaded from: classes8.dex */
public class C6383x extends C6362e {

    /* renamed from: a */
    @Packed
    private String f29900a;

    /* renamed from: b */
    @Packed
    private String f29901b;

    /* renamed from: c */
    @Packed
    private String f29902c;

    /* renamed from: d */
    @Packed
    private String f29903d;

    /* renamed from: e */
    @Packed
    private String[] f29904e;

    /* renamed from: f */
    @Packed
    private String f29905f;

    /* renamed from: a */
    public String m36760a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nonce", this.f29900a);
            jSONObject.put("appId", this.f29901b);
            jSONObject.put("alg", this.f29905f);
            jSONObject.put("packageName", this.f29902c);
            jSONObject.put("apkDigestSha256", this.f29903d);
            JSONArray jSONArray = new JSONArray();
            String[] strArr = this.f29904e;
            if (strArr != null) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("apkCertificateDigestSha256", jSONArray);
        } catch (JSONException e10) {
            Log.e("SysIntegrityReq", "Json conversion exception! " + e10.getMessage());
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public void m36763b(String str) {
        this.f29903d = str;
    }

    /* renamed from: c */
    public void m36764c(String str) {
        this.f29901b = str;
    }

    /* renamed from: d */
    public void m36765d(String str) {
        this.f29900a = str;
    }

    /* renamed from: e */
    public void m36766e(String str) {
        this.f29902c = str;
    }

    /* renamed from: a */
    public void m36761a(String str) {
        this.f29905f = str;
    }

    /* renamed from: a */
    public void m36762a(String[] strArr) {
        this.f29904e = strArr == null ? null : (String[]) strArr.clone();
    }
}
