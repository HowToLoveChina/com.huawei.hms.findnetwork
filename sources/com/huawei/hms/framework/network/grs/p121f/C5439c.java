package com.huawei.hms.framework.network.grs.p121f;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.C5462a;
import com.huawei.hms.framework.network.grs.local.model.C5463b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.c */
/* loaded from: classes8.dex */
public class C5439c extends AbstractC5437a {
    public C5439c(Context context, boolean z10) {
        this.f24927d = z10;
        if (m32209a("grs_sdk_global_route_config.json", context) == 0) {
            this.f24926c = true;
        }
    }

    /* renamed from: a */
    public List<C5463b> m32235a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : m32234a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.p121f.AbstractC5437a
    /* renamed from: b */
    public int mo32216b(String str) throws JSONException {
        this.f24924a = new C5462a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            long j10 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f24924a.m32342b(string);
            this.f24924a.m32339a(j10);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e10) {
            Logger.m32147w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p121f.AbstractC5437a
    /* renamed from: c */
    public int mo32219c(String str) throws JSONException {
        JSONObject jSONObject;
        this.f24925b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.m32138e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() == 0) {
                return 0;
            }
            this.f24925b.addAll(m32234a(jSONObject));
            return 0;
        } catch (JSONException e10) {
            Logger.m32147w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x010d A[Catch: JSONException -> 0x0072, TryCatch #0 {JSONException -> 0x0072, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0024, B:8:0x003a, B:10:0x0043, B:11:0x0056, B:13:0x005c, B:15:0x006d, B:23:0x0087, B:24:0x009d, B:26:0x00a3, B:28:0x00b7, B:30:0x00bd, B:32:0x00ce, B:18:0x0075, B:20:0x007b, B:21:0x0080, B:33:0x00e2, B:35:0x00ed, B:39:0x00fc, B:41:0x0106, B:43:0x010d, B:44:0x0114, B:36:0x00f2, B:38:0x00f8, B:40:0x0101), top: B:49:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.p121f.AbstractC5437a
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int mo32225g(java.lang.String r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p121f.C5439c.mo32225g(java.lang.String):int");
    }

    /* renamed from: a */
    private List<C5463b> m32234a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                C5463b c5463b = new C5463b();
                c5463b.m32347b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                c5463b.m32349c(jSONObject2.getString("name"));
                c5463b.m32344a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.m32145w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        hashSet.add((String) jSONArray.get(i10));
                    }
                    c5463b.m32345a(hashSet);
                    arrayList.add(c5463b);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e10) {
            Logger.m32147w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return new ArrayList();
        }
    }
}
