package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p216d4.C9036w;
import p357i4.AbstractC10440e;
import p405jt.AbstractC10915a;

@DataKeep
/* loaded from: classes.dex */
public class AdCreativeContentRecord extends AbstractC10440e {
    private static final String TAG = "AdCreativeContentRecord";
    private String basicTargetTag;
    private String contentId;
    private String creativeLabel;
    private String deviceParam;
    String encryptEcpm;
    private String industryId1st;
    private String industryId2nd;
    private String metaData;
    private String monitor;
    private String priceType;
    private String tradeMode;
    private long uptime;

    public AdCreativeContentRecord() {
        this.uptime = System.currentTimeMillis();
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 2592000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "uptime<?";
    }

    /* renamed from: t */
    public final void m12458t(JSONObject jSONObject) {
        JSONArray jSONArrayM56987a;
        String strOptString;
        JSONObject jSONObjectM56990d = C9036w.m56990d(jSONObject.optString("creativeLabel"));
        jSONObject.optString("creativeLabel");
        if (jSONObjectM56990d == null || (jSONArrayM56987a = C9036w.m56987a(jSONObjectM56990d.optString("creativeCategory"))) == null) {
            return;
        }
        String strSubstring = null;
        try {
            strOptString = jSONArrayM56987a.getJSONObject(0).optString(Constants.AUTOCONTENT_CATEGORY);
        } catch (JSONException e10) {
            AbstractC10915a.m65979k(TAG, "getCategory exception %s", e10.getClass().getSimpleName());
            strOptString = null;
        }
        this.industryId1st = (strOptString == null || strOptString.length() < 4) ? null : strOptString.substring(0, 4);
        if (strOptString != null && strOptString.length() >= 8) {
            strSubstring = strOptString.substring(0, 8);
        }
        this.industryId2nd = strSubstring;
    }

    /* renamed from: u */
    public String m12459u() {
        return this.contentId;
    }

    /* renamed from: v */
    public String m12460v() {
        return this.metaData;
    }

    /* renamed from: w */
    public String m12461w() {
        return this.monitor;
    }

    /* renamed from: x */
    public String m12462x() {
        return this.tradeMode;
    }

    public AdCreativeContentRecord(JSONObject jSONObject) {
        this.uptime = System.currentTimeMillis();
        if (jSONObject != null) {
            this.contentId = jSONObject.optString("contentid");
            this.metaData = jSONObject.optString("metaData");
            this.monitor = jSONObject.optString(MapKeyNames.THIRD_MONITORS);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deviceAiParam");
            if (jSONObjectOptJSONObject != null) {
                this.tradeMode = jSONObjectOptJSONObject.optString("tradeMode");
                this.priceType = jSONObjectOptJSONObject.optString("priceType");
                this.deviceParam = jSONObjectOptJSONObject.toString();
                m12458t(jSONObjectOptJSONObject);
                this.creativeLabel = jSONObjectOptJSONObject.optString("creativeLabel");
                this.basicTargetTag = jSONObjectOptJSONObject.optString("basicTargetTag");
                this.encryptEcpm = jSONObjectOptJSONObject.optString("encryptEcpm");
            }
            this.uptime = System.currentTimeMillis();
        }
    }
}
