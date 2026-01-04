package com.huawei.hms.framework.network.restclient.dnkeeper;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.g */
/* loaded from: classes8.dex */
public abstract class AbstractC5486g {

    /* renamed from: c */
    private static final String f25117c = "DefaultDNKeeperCallable";

    /* renamed from: a */
    protected List<String> f25118a;

    /* renamed from: b */
    protected String f25119b;

    /* renamed from: a */
    public void m32399a(PLSharedPreferences pLSharedPreferences) throws JSONException {
        try {
            List<String> list = this.f25118a;
            if (list != null && !list.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "A");
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < this.f25118a.size(); i10++) {
                    C5485f.m32396a(jSONArray, i10, "A", this.f25118a.get(i10), 0L);
                }
                jSONObject.put(DnsResult.KEY_ADDRESSLIST, jSONArray);
                jSONObject.put("createTime", System.currentTimeMillis());
                if (pLSharedPreferences != null) {
                    pLSharedPreferences.putString(this.f25119b, jSONObject.toString());
                }
                Logger.m32141i(f25117c, "dnkeeper ip result");
            }
        } catch (JSONException e10) {
            Logger.m32146w(f25117c, "fail to JSONException:", e10);
        }
    }

    /* renamed from: a */
    public void m32400a(DnsResult dnsResult, String str, PLSharedPreferences pLSharedPreferences) throws JSONException {
        List<DnsResult.Address> addressList = dnsResult.getAddressList();
        if (addressList == null || addressList.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", dnsResult.getType());
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < addressList.size(); i10++) {
                C5485f.m32396a(jSONArray, i10, addressList.get(i10).getType(), addressList.get(i10).getValue(), addressList.get(i10).getTtl());
            }
            jSONObject.put(DnsResult.KEY_ADDRESSLIST, jSONArray);
            jSONObject.put("createTime", dnsResult.getCreateTime());
            if (pLSharedPreferences != null) {
                pLSharedPreferences.putString(str, jSONObject.toString());
            }
        } catch (JSONException e10) {
            Logger.m32146w(f25117c, "fail to JSONException:", e10);
        }
    }
}
