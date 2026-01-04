package com.huawei.hwcloudjs.service.auth.bean;

import android.text.TextUtils;
import com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6639c;
import com.huawei.hwcloudjs.p164f.C6659d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.service.auth.bean.b */
/* loaded from: classes8.dex */
public class C6666b extends AbstractC6639c {

    /* renamed from: c */
    private static final String f30908c = "AuthResponseBean";

    /* renamed from: d */
    private static final String f30909d = "NSP_STATUS";

    /* renamed from: e */
    private int f30910e = -1;

    /* renamed from: f */
    private List<String> f30911f;

    /* renamed from: g */
    private List<String> f30912g;

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6639c
    /* renamed from: a */
    public void mo37818a(String str, Map<String, String> map) {
        JSONArray jSONArrayOptJSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = map.get(f30909d);
            if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                try {
                    m37912c(Integer.parseInt(str2));
                    return;
                } catch (NumberFormatException unused) {
                    m37912c(-1);
                    return;
                }
            }
            m37912c(0);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("scopes");
            if (jSONArrayOptJSONArray2 != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArrayOptJSONArray2.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i10);
                        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions")) != null) {
                            int length2 = jSONArrayOptJSONArray.length();
                            for (int i11 = 0; i11 < length2; i11++) {
                                arrayList.add(jSONArrayOptJSONArray.getString(i11));
                            }
                        }
                    }
                    m37910a(arrayList);
                } catch (JSONException unused2) {
                    C6659d.m37881b(f30908c, "jsonArray JSONException", true);
                    return;
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("appAttr");
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("securityUrl");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                m37911b(Arrays.asList(strOptString.split("\\,")));
            }
        } catch (JSONException unused3) {
            C6659d.m37881b(f30908c, "resultObj JSONException", true);
        }
    }

    /* renamed from: b */
    public void m37911b(List<String> list) {
        this.f30912g = list;
    }

    /* renamed from: c */
    public void m37912c(int i10) {
        this.f30910e = i10;
    }

    /* renamed from: d */
    public List<String> m37913d() {
        return this.f30911f;
    }

    /* renamed from: e */
    public int m37914e() {
        return this.f30910e;
    }

    /* renamed from: f */
    public List<String> m37915f() {
        return this.f30912g;
    }

    /* renamed from: a */
    public void m37910a(List<String> list) {
        this.f30911f = list;
    }

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6639c
    /* renamed from: a */
    public String[] mo37819a() {
        return new String[]{f30909d};
    }
}
