package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.RomAttributeCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.f */
/* loaded from: classes5.dex */
public class C4751f implements RomAttributeCollector {

    /* renamed from: a */
    public int f21716a;

    /* renamed from: a */
    public String f21717a;

    /* renamed from: b */
    public int f21718b;

    /* renamed from: b */
    public String f21719b;

    /* renamed from: c */
    public String f21720c;

    /* renamed from: d */
    public String f21721d;

    /* renamed from: e */
    public String f21722e;

    /* renamed from: f */
    public String f21723f;

    /* renamed from: g */
    public String f21724g;

    /* renamed from: h */
    public String f21725h;

    /* renamed from: i */
    public String f21726i;

    /* renamed from: j */
    public String f21727j;

    /* renamed from: k */
    public String f21728k;

    /* renamed from: l */
    public String f21729l;

    /* renamed from: m */
    public String f21730m;

    /* renamed from: n */
    public String f21731n;

    /* renamed from: o */
    public String f21732o;

    /* renamed from: p */
    public String f21733p;

    /* renamed from: q */
    public String f21734q;

    /* renamed from: r */
    public String f21735r;

    @Override // com.huawei.hianalytics.framework.config.RomAttributeCollector
    public JSONObject doCollector() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_rom_ver", this.f21717a);
            jSONObject.put("_emui_ver", this.f21719b);
            jSONObject.put("_model", this.f21720c);
            jSONObject.put("_package_name", this.f21721d);
            jSONObject.put("_app_ver", this.f21722e);
            jSONObject.put("_lib_ver", this.f21723f);
            jSONObject.put("_lib_name", this.f21725h);
            jSONObject.put("_channel", this.f21724g);
            jSONObject.put("_manufacturer", this.f21726i);
            jSONObject.put("_oaid_tracking_flag", this.f21729l);
            jSONObject.put("_app_brand", this.f21727j);
            jSONObject.put("_brand", this.f21728k);
            jSONObject.put("_mcc", this.f21734q);
            jSONObject.put("_mnc", this.f21735r);
            jSONObject.put("_os", this.f21730m);
            jSONObject.put("_os_ver", this.f21731n);
            jSONObject.put("_screen_height", this.f21716a);
            jSONObject.put("_screen_width", this.f21718b);
            jSONObject.put("_language", this.f21733p);
            jSONObject.put("_hm_version", this.f21732o);
        } catch (Exception unused) {
            HiLog.m28808e("OpennessRomCollector", "json exception");
        }
        return jSONObject;
    }
}
