package com.huawei.hms.drive;

import com.huawei.hms.drive.C5298t;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.drive.r */
/* loaded from: classes8.dex */
public abstract class AbstractC5296r {

    /* renamed from: a */
    protected List<String> f24550a;

    /* renamed from: b */
    protected String f24551b;

    /* renamed from: a */
    public void m31788a(C5298t c5298t, String str, PLSharedPreferences pLSharedPreferences) throws JSONException {
        List<C5298t.a> listM31803b = c5298t.m31803b();
        if (listM31803b == null || listM31803b.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", c5298t.m31798a());
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < listM31803b.size(); i10++) {
                C5295q.m31785a(jSONArray, i10, listM31803b.get(i10).m31807a(), listM31803b.get(i10).m31808b(), listM31803b.get(i10).m31809c());
            }
            jSONObject.put(DnsResult.KEY_ADDRESSLIST, jSONArray);
            jSONObject.put("createTime", c5298t.m31804c());
            if (pLSharedPreferences != null) {
                pLSharedPreferences.putString(str, jSONObject.toString());
            }
        } catch (JSONException e10) {
            Logger.m32146w("DefaultDNKeeperCallable", "fail to JSONException:", e10);
        }
    }

    /* renamed from: a */
    public void m31789a(PLSharedPreferences pLSharedPreferences) throws JSONException {
        try {
            List<String> list = this.f24550a;
            if (list != null && !list.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "A");
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < this.f24550a.size(); i10++) {
                    C5295q.m31785a(jSONArray, i10, "A", this.f24550a.get(i10), 0L);
                }
                jSONObject.put(DnsResult.KEY_ADDRESSLIST, jSONArray);
                jSONObject.put("createTime", System.currentTimeMillis());
                if (pLSharedPreferences != null) {
                    pLSharedPreferences.putString(this.f24551b, jSONObject.toString());
                }
                Logger.m32141i("DefaultDNKeeperCallable", "dnkeeper ip result");
            }
        } catch (JSONException e10) {
            Logger.m32146w("DefaultDNKeeperCallable", "fail to JSONException:", e10);
        }
    }
}
