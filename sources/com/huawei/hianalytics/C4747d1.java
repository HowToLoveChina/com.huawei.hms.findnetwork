package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.framework.HAFrameworkInstance;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.utils.JsonUtils;
import com.huawei.hianalytics.process.HaEvent;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.openalliance.p169ad.p171db.bean.EventMonitorRecord;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import eu.C9560a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.d1 */
/* loaded from: classes5.dex */
public class C4747d1 implements HiAnalyticsInstance {

    /* renamed from: a */
    public long f21700a;

    /* renamed from: a */
    public C4750e1 f21701a = new C4750e1();

    /* renamed from: a */
    public HAFrameworkInstance f21702a;

    /* renamed from: a */
    public ICallback f21703a;

    /* renamed from: a */
    public final String f21704a;

    public C4747d1(String str) {
        this.f21704a = str;
        try {
            this.f21702a = new HAFrameworkInstance.Builder().setStorageHandler(C4794n.m28969a(EnvUtils.getAppContext())).setStoragePolicy(new C4748e(str)).setCollectorConfig(new C4726a(str)).setMandatoryParameters(new C4745d()).build(str);
        } catch (Exception unused) {
            HiLog.m28808e("HAImpl", "init HAImpl create frameworkInstance failed");
        }
    }

    /* renamed from: a */
    public final String m28819a(int i10) {
        return i10 != 0 ? i10 != 1 ? "allType" : "maint" : "oper";
    }

    /* renamed from: b */
    public final JSONObject m28824b(LinkedHashMap<String, String> linkedHashMap) {
        return C4785j.m28928a(linkedHashMap) ? C4778g1.m28886a(linkedHashMap) : new JSONObject();
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void clearData() {
        this.f21702a.clearCacheDataByTag();
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void disableAutoReport() {
        C4816y0 c4816y0M29058a = C4816y0.m29058a();
        String str = this.f21704a;
        c4816y0M29058a.getClass();
        C4816y0.f21997a.remove(str);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public String getCollectUrl() {
        C4750e1 c4750e1 = this.f21701a;
        C4728a1 c4728a1 = c4750e1.f21711b;
        String str = c4728a1 != null ? c4728a1.f21631c : "";
        C4728a1 c4728a12 = c4750e1.f21709a;
        String str2 = c4728a12 != null ? c4728a12.f21631c : "";
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) ? "" : (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? TextUtils.isEmpty(str) ? str2 : str : "";
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public String getOAID(int i10) {
        return C4785j.m28907a(this.f21704a, m28819a(i10));
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public String getUDID(int i10) {
        C4728a1 c4728a1M28818a = m28818a(i10);
        if (c4728a1M28818a == null) {
            HiLog.m28811sw("DeviceUtil", "config is null");
            return "";
        }
        C4731b1 c4731b1M28744a = c4728a1M28818a.m28744a();
        String str = c4731b1M28744a.f21658b;
        String str2 = str != null ? str : "";
        return (TextUtils.isEmpty(str2) && c4731b1M28744a.f21661c) ? C4785j.m28948f() : str2;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public String getUUID(int i10) {
        C4793m0 c4793m0M28967a = C4793m0.m28967a();
        String str = this.f21704a;
        String strM28819a = m28819a(i10);
        c4793m0M28967a.getClass();
        return C4785j.m28932b(str, strM28819a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void newInstanceUUID() {
        String strM28908a = C4785j.m28908a("global_v2", this.f21704a, "");
        if (TextUtils.isEmpty(strM28908a)) {
            strM28908a = UUID.randomUUID().toString().replace("-", "");
            C4785j.m28918a("global_v2", this.f21704a, strM28908a);
        } else if (strM28908a.length() > 32) {
            String strM59677f = C9560a.m59677f("HiAnalytics_Sdk_Uuid_Sp_Key", strM28908a);
            if (!TextUtils.isEmpty(strM59677f)) {
                C4785j.m28918a("global_v2", this.f21704a, strM59677f);
                strM28908a = strM59677f;
            }
        }
        C4750e1 c4750e1 = this.f21701a;
        C4728a1 c4728a1 = c4750e1.f21711b;
        if (c4728a1 != null) {
            c4728a1.f21622a = strM28908a;
        }
        C4728a1 c4728a12 = c4750e1.f21709a;
        if (c4728a12 != null) {
            c4728a12.f21622a = strM28908a;
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onBackground(long j10) {
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        onEvent(i10, str, m28824b(linkedHashMap));
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEventSync(int i10, String str, JSONObject jSONObject) {
        HiLog.m28810si("HAImpl", "onEventSync. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
        if (m28823a(i10, str)) {
            return;
        }
        this.f21702a.onEventSync(m28819a(i10), str, jSONObject);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onForeground(long j10) {
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onPause(Context context) throws JSONException {
        onPause(context, (LinkedHashMap<String, String>) null);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onReport(Context context, int i10) {
        onReport(i10);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onResume(Context context) throws JSONException {
        onResume(context, (LinkedHashMap<String, String>) null);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3) {
        HiLog.m28810si("HAImpl", "onStreamEvent Ex. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
        if (m28823a(i10, str)) {
            return;
        }
        this.f21702a.onStreamEvent(m28819a(i10), str, m28824b(linkedHashMap), m28820a(linkedHashMap2), m28820a(linkedHashMap3), this.f21703a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void refresh(int i10, HiAnalyticsConfig hiAnalyticsConfig) {
        HiAnalyticsConfig hiAnalyticsConfig2;
        C4747d1 c4747d1M28954a;
        if (hiAnalyticsConfig == null) {
            HiLog.m28810si("HAImpl", "config is null. tag: " + this.f21704a + ", type: " + i10);
            hiAnalyticsConfig2 = null;
        } else {
            hiAnalyticsConfig2 = new HiAnalyticsConfig(hiAnalyticsConfig);
        }
        if (i10 == 0) {
            m28825b(hiAnalyticsConfig2);
        } else if (i10 != 1) {
            HiLog.m28811sw("HAImpl", "wrong type. tag: " + this.f21704a);
        } else {
            m28821a(hiAnalyticsConfig2);
        }
        if (hiAnalyticsConfig2 != null && hiAnalyticsConfig2.f21900a != null && (c4747d1M28954a = C4788k.m28953a().m28954a("ha_default_collection")) != null) {
            HiAnalyticsConfig hiAnalyticsConfigBuild = new HiAnalyticsConfig.Builder().setCollectURL(hiAnalyticsConfig2.f21900a.f21631c).setHttpHeader(hiAnalyticsConfig2.f21900a.f21623a).setAutoReportThresholdSize(100).build();
            if (i10 == 0) {
                c4747d1M28954a.m28825b(hiAnalyticsConfigBuild);
            } else if (i10 != 1) {
                HiLog.m28809i("HACU", "wrong type");
            } else {
                c4747d1M28954a.m28821a(hiAnalyticsConfigBuild);
            }
        }
        C4785j.m28913a(i10, hiAnalyticsConfig2);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setAccountBrandId(String str) {
        if (!C4785j.m28925a("accountBrandId", str, 256)) {
            str = "";
        }
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(this.f21704a);
        if (c4750e1M28892a == null) {
            return;
        }
        c4750e1M28892a.f21714d = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setAppBrandId(String str) {
        if (!C4785j.m28925a("appBrandId", str, 256)) {
            str = "";
        }
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(this.f21704a);
        if (c4750e1M28892a == null) {
            return;
        }
        c4750e1M28892a.f21712b = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setAppid(String str) {
        if (!C4785j.m28926a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}")) {
            str = "";
        }
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(this.f21704a);
        if (c4750e1M28892a == null) {
            return;
        }
        c4750e1M28892a.f21710a = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setCallback(ICallback iCallback) {
        if (iCallback == null) {
            return;
        }
        this.f21703a = iCallback;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setCommonProp(int i10, Map<String, String> map) {
        if (!C4785j.m28928a(map)) {
            HiLog.m28811sw("HAImpl", "common prop error. tag: " + this.f21704a + ", type: " + i10);
            return;
        }
        JSONObject jSONObject = new JSONObject(map);
        C4728a1 c4728a1M28818a = m28818a(i10);
        if (c4728a1M28818a != null) {
            c4728a1M28818a.f21641h = String.valueOf(jSONObject);
            return;
        }
        HiLog.m28811sw("HAImpl", "no related config found. tag: " + this.f21704a + ", type: " + i10);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setHandsetManufacturer(String str) {
        if (!C4785j.m28925a("handsetManufacturer", str, 256)) {
            str = "";
        }
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(this.f21704a);
        if (c4750e1M28892a == null) {
            return;
        }
        c4750e1M28892a.f21715e = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setHansetBrandId(String str) {
        if (!C4785j.m28925a("hansetBrandId", str, 256)) {
            str = "";
        }
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(this.f21704a);
        if (c4750e1M28892a == null) {
            return;
        }
        c4750e1M28892a.f21713c = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setOAID(int i10, String str) {
        C4728a1 c4728a1M28818a = m28818a(i10);
        if (c4728a1M28818a == null) {
            HiLog.m28811sw("HAImpl", "no related config found. tag: " + this.f21704a + ", type: " + i10);
            return;
        }
        if (!C4785j.m28925a("oaid", str, 4096)) {
            str = "";
        }
        c4728a1M28818a.f21634d = str;
        if (TextUtils.isEmpty(str)) {
            C4785j.m28918a("global_v2", this.f21704a + "_" + i10 + "_oaid", "");
            return;
        }
        C4785j.m28918a("global_v2", this.f21704a + "_" + i10 + "_oaid", C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", str));
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setOAIDTrackingFlag(int i10, boolean z10) {
        C4728a1 c4728a1M28818a = m28818a(i10);
        if (c4728a1M28818a != null) {
            c4728a1M28818a.f21637e = z10 ? FaqConstants.DISABLE_HA_REPORT : "false";
            return;
        }
        HiLog.m28811sw("HAImpl", "no related config found. tag: " + this.f21704a + ", type: " + i10);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setUpid(int i10, String str) {
        C4728a1 c4728a1M28818a = m28818a(i10);
        if (c4728a1M28818a != null) {
            if (!C4785j.m28925a("upid", str, 4096)) {
                str = "";
            }
            c4728a1M28818a.f21639f = str;
        } else {
            HiLog.m28811sw("HAImpl", "no related config found. tag: " + this.f21704a + ", type: " + i10);
        }
    }

    /* renamed from: a */
    public final JSONObject m28820a(LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM28909a = C4785j.m28909a(linkedHashMap, 10, 128L, 512L, "x_");
        return linkedHashMapM28909a == null ? new JSONObject() : C4778g1.m28886a(linkedHashMapM28909a);
    }

    /* renamed from: b */
    public void m28825b(HiAnalyticsConfig hiAnalyticsConfig) {
        if (hiAnalyticsConfig != null) {
            this.f21701a.f21711b = hiAnalyticsConfig.f21900a;
            return;
        }
        this.f21701a.f21711b = null;
        HiLog.m28812w("HAImpl", "config for oper is null, tag: " + this.f21704a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3) {
        HiLog.m28810si("HAImpl", "onEventEx. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
        if (m28823a(i10, str)) {
            return;
        }
        this.f21702a.onEvent(m28819a(i10), str, m28824b(linkedHashMap), m28820a(linkedHashMap2), m28820a(linkedHashMap3), this.f21703a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onPause(String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        m28822a(str, linkedHashMap, "$AppOnPause", "OnPause");
        this.f21700a = 0L;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onReport(int i10) {
        HiLog.m28810si("HAImpl", "onReport. tag:" + this.f21704a + ", type:" + i10);
        if (C4787j1.f21836a.m28952a()) {
            this.f21702a.onReport(m28819a(i10));
            return;
        }
        HiLog.m28811sw("HAImpl", "user locked. tag: " + this.f21704a + ", type: " + i10);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onResume(String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        m28822a(str, linkedHashMap, "$AppOnResume", "OnResume");
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i10, String str, JSONObject jSONObject) {
        HiLog.m28810si("HAImpl", "onStreamEvent. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
        if (m28823a(i10, str)) {
            return;
        }
        this.f21702a.onStreamEvent(m28819a(i10), str, jSONObject, this.f21703a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i10, String str, JSONObject jSONObject) {
        HiLog.m28810si("HAImpl", "onEvent. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
        if (m28823a(i10, str)) {
            return;
        }
        this.f21702a.onEvent(m28819a(i10), str, jSONObject, this.f21703a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        if (context != null) {
            m28822a(context.getClass().getCanonicalName(), linkedHashMap, "$AppOnPause", "OnPause");
            this.f21700a = 0L;
        } else {
            HiLog.m28811sw("HAImpl", "context is null. tag: " + this.f21704a);
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        if (context != null) {
            m28822a(context.getClass().getCanonicalName(), linkedHashMap, "$AppOnResume", "OnResume");
            return;
        }
        HiLog.m28811sw("HAImpl", "context is null. tag: " + this.f21704a);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject jSONObjectM28824b = m28824b(linkedHashMap);
        HiLog.m28810si("HAImpl", "onStreamEvent. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
        if (m28823a(i10, str)) {
            return;
        }
        this.f21702a.onStreamEvent(m28819a(i10), str, jSONObjectM28824b, this.f21703a);
    }

    /* renamed from: a */
    public final C4728a1 m28818a(int i10) {
        if (i10 == 0) {
            return this.f21701a.f21711b;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f21701a.f21709a;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(Context context, String str, String str2) throws JSONException {
        if (!C4785j.m28925a("value", str2, 65536)) {
            HiLog.m28811sw("HAImpl", "value error. tag: " + this.f21704a);
            str2 = "";
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "_constants", str2);
        onEvent(0, str, jSONObject);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i10, List<HaEvent> list) throws JSONException {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() > 100) {
            HiLog.m28812w("HAImpl", "events size more than 100. tag: " + this.f21704a + ", type: " + i10);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HaEvent haEvent = (HaEvent) it.next();
            if (haEvent != null && !(true ^ C4785j.m28925a(EventMonitorRecord.EVENT_ID, haEvent.f21898a, 256))) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("event", haEvent.f21898a);
                    jSONObject.put(Event.EventConstants.PROPERTIES, haEvent.f21899a);
                    jSONObject.put(Event.EventConstants.RECORD_TIME, haEvent.f21897a);
                } catch (JSONException unused) {
                }
                jSONArray.put(jSONObject);
            }
        }
        if (jSONArray.length() == 0) {
            return;
        }
        if (jSONArray.length() == 1) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
            onEvent(i10, jSONObjectOptJSONObject.optString("event"), jSONObjectOptJSONObject.optJSONObject(Event.EventConstants.PROPERTIES));
        } else {
            JSONObject jSONObject2 = new JSONObject();
            JsonUtils.put(jSONObject2, Event.EventConstants.EVENTS, jSONArray);
            JsonUtils.put(jSONObject2, Event.EventConstants.SUB_COUNT, Integer.valueOf(jSONArray.length()));
            onEvent(i10, Event.EventConstants.EVENT_ID_AGGREGATE, jSONObject2);
        }
    }

    /* renamed from: a */
    public final boolean m28823a(int i10, String str) {
        if (!C4787j1.f21836a.m28952a()) {
            HiLog.m28811sw("HAImpl", "user locked. tag: " + this.f21704a + ", type: " + i10);
            return true;
        }
        if (!C4785j.m28925a(EventMonitorRecord.EVENT_ID, str, 256)) {
            HiLog.m28811sw("HAImpl", "eventId error. tag:" + this.f21704a + ", type:" + i10 + ", eventId:" + str);
            return true;
        }
        if (this.f21702a != null) {
            return false;
        }
        HiLog.m28811sw("HAImpl", "framework instance is null. tag:" + this.f21704a + ", type:" + i10);
        return true;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        onEvent(0, str, m28824b(linkedHashMap));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(1:9)(11:10|(1:12)|14|(1:16)|(1:18)(1:19)|30|20|(1:22)|23|26|27)|13|14|(0)|(0)(0)|30|20|(0)|23|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        com.huawei.hianalytics.core.log.HiLog.m28808e("BasicEvents", "json exception");
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[Catch: JSONException -> 0x0056, TryCatch #0 {JSONException -> 0x0056, blocks: (B:20:0x0045, B:22:0x004b, B:23:0x0050), top: B:30:0x0045 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m28822a(java.lang.String r7, java.util.LinkedHashMap<java.lang.String, java.lang.String> r8, java.lang.String r9, java.lang.String r10) throws org.json.JSONException {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L62
            java.lang.String r0 = "viewName"
            java.lang.String r1 = "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}"
            boolean r0 = com.huawei.hianalytics.C4785j.m28926a(r0, r7, r1)
            if (r0 != 0) goto L11
            goto L62
        L11:
            java.lang.String r0 = "OnResume"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "OnPause"
            if (r0 == 0) goto L22
            long r2 = java.lang.System.currentTimeMillis()
            r6.f21700a = r2
            goto L30
        L22:
            boolean r0 = r1.equals(r10)
            if (r0 == 0) goto L30
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r6.f21700a
            long r2 = r2 - r4
            goto L32
        L30:
            r2 = 0
        L32:
            boolean r0 = com.huawei.hianalytics.C4785j.m28928a(r8)
            if (r0 != 0) goto L39
            r8 = 0
        L39:
            if (r8 != 0) goto L41
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            goto L45
        L41:
            org.json.JSONObject r8 = com.huawei.hianalytics.C4778g1.m28886a(r8)
        L45:
            boolean r10 = r1.equals(r10)     // Catch: org.json.JSONException -> L56
            if (r10 == 0) goto L50
            java.lang.String r10 = "_event_duration"
            r8.put(r10, r2)     // Catch: org.json.JSONException -> L56
        L50:
            java.lang.String r10 = "_activity_name"
            r8.put(r10, r7)     // Catch: org.json.JSONException -> L56
            goto L5d
        L56:
            java.lang.String r7 = "BasicEvents"
            java.lang.String r10 = "json exception"
            com.huawei.hianalytics.core.log.HiLog.m28808e(r7, r10)
        L5d:
            r7 = 0
            r6.onEvent(r7, r9, r8)
            return
        L62:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "viewName error. tag: "
            r7.append(r8)
            java.lang.String r6 = r6.f21704a
            r7.append(r6)
            java.lang.String r6 = ", type: "
            r7.append(r6)
            r7.append(r10)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "HAImpl"
            com.huawei.hianalytics.core.log.HiLog.m28811sw(r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4747d1.m28822a(java.lang.String, java.util.LinkedHashMap, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public void m28821a(HiAnalyticsConfig hiAnalyticsConfig) {
        if (hiAnalyticsConfig == null) {
            HiLog.m28812w("HAImpl", "config for maint is null, tag: " + this.f21704a);
            this.f21701a.f21709a = null;
            return;
        }
        this.f21701a.f21709a = hiAnalyticsConfig.f21900a;
    }
}
