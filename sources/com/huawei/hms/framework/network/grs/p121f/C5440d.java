package com.huawei.hms.framework.network.grs.p121f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.C5462a;
import com.huawei.hms.framework.network.grs.local.model.C5463b;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.d */
/* loaded from: classes8.dex */
public class C5440d extends AbstractC5437a {
    public C5440d(Context context, String str, boolean z10) {
        this.f24927d = z10;
        if (m32209a(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.f24926c = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p121f.AbstractC5437a
    /* renamed from: b */
    public int mo32216b(String str) throws JSONException {
        this.f24924a = new C5462a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f24924a.m32342b(jSONObject.getString("name"));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    m32218b(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e10) {
            Logger.m32147w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p121f.AbstractC5437a
    /* renamed from: c */
    public int mo32219c(String str) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.f24925b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.m32138e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    C5463b c5463b = new C5463b();
                    c5463b.m32347b(jSONObject2.getString("id"));
                    c5463b.m32349c(jSONObject2.getString("name"));
                    c5463b.m32344a(jSONObject2.getString("description"));
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        Logger.m32145w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null && jSONArray2.length() != 0) {
                        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                            hashSet.add((String) jSONArray2.get(i11));
                        }
                        c5463b.m32345a(hashSet);
                        this.f24925b.add(c5463b);
                    }
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e10) {
            Logger.m32147w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p121f.AbstractC5437a
    /* renamed from: g */
    public int mo32225g(String str) {
        return m32224f(str);
    }

    public C5440d(boolean z10, boolean z11) {
        this.f24927d = z11;
        this.f24926c = z10;
    }
}
