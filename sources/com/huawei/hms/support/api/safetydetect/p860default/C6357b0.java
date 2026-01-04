package com.huawei.hms.support.api.safetydetect.p860default;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.b0 */
/* loaded from: classes8.dex */
public class C6357b0 extends C6362e {

    /* renamed from: d */
    private static final String f29885d = "b0";

    /* renamed from: a */
    private String f29886a;

    /* renamed from: b */
    private String f29887b;

    /* renamed from: c */
    private int[] f29888c;

    public C6357b0(String str, String str2, int... iArr) {
        this.f29886a = str;
        this.f29887b = str2;
        this.f29888c = iArr;
    }

    /* renamed from: a */
    public String m36727a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f29886a);
            jSONObject.put("appId", this.f29887b);
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.f29888c;
            if (iArr != null) {
                for (int i10 : iArr) {
                    jSONArray.put(i10);
                }
            }
            jSONObject.put("threatTypes", jSONArray);
        } catch (JSONException e10) {
            Log.e(f29885d, "Json conversion exception! " + e10.getMessage());
        }
        return jSONObject.toString();
    }
}
