package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.C4812w0;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.kit.HiAnalyticsClientImpl;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hmf.tasks.Task;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* renamed from: com.huawei.hianalytics.q0 */
/* loaded from: classes5.dex */
public class C4801q0 {

    /* renamed from: a */
    public static final C4801q0 f21908a = new C4801q0();

    /* renamed from: a */
    public long f21909a = 86400000;

    /* renamed from: a */
    public boolean f21910a;

    /* renamed from: b */
    public boolean f21911b;

    public C4801q0() {
        m29015a();
    }

    /* renamed from: a */
    public final void m29016a(int i10) {
        String str;
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        if (instanceByTag == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("$code", String.valueOf(i10));
        switch (i10) {
            case 401:
                str = "QoES request failed because device is not Huawei device";
                break;
            case 402:
                str = "QoES request failed because hms base is not exist";
                break;
            case 403:
                str = "QoES request failed because context is null";
                break;
            default:
                instanceByTag.onEvent(1, "$request_ha_config", linkedHashMap);
        }
        linkedHashMap.put("$message", str);
        instanceByTag.onEvent(1, "$request_ha_config", linkedHashMap);
    }

    /* renamed from: b */
    public synchronized void m29017b() {
        HiLog.m28809i("ConfigHandler", "start requestConfig");
        long jM28896a = C4785j.m28896a("global_v2", "ha_config_last_request_time", 0L);
        if (jM28896a > 0 && System.currentTimeMillis() - jM28896a <= this.f21909a) {
            HiLog.m28809i("ConfigHandler", "within request interval");
            return;
        }
        if (!C4785j.m28949f()) {
            m29016a(401);
            return;
        }
        if (!C4785j.m28951h()) {
            HiLog.m28807d("ConfigHandler", "not phone or pad");
            return;
        }
        if (!C4785j.m28935b()) {
            HiLog.m28807d("ConfigHandler", "not China Rom");
            return;
        }
        if (!C4814x0.m29057a(true)) {
            m29016a(402);
            return;
        }
        if (EnvUtils.getAppContext() == null) {
            m29016a(403);
            return;
        }
        try {
            HiAnalyticsClientImpl hiAnalyticsClientImpl = new HiAnalyticsClientImpl(EnvUtils.getAppContext(), new C4810v0());
            hiAnalyticsClientImpl.setApiLevel(1);
            hiAnalyticsClientImpl.setKitSdkVersion(302130500);
            hiAnalyticsClientImpl.getHaConfig(new C4804s0("get_ha_config", C4785j.m28939c())).addOnFailureListener(new InterfaceC8938f() { // from class: pj.e
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    HiLog.m28812w("ConfigHandler", "request ha config failed");
                }
            }).addOnSuccessListener(new InterfaceC8939g() { // from class: pj.f
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) throws JSONException {
                    this.f56358a.m29011a((C4812w0) obj);
                }
            }).addOnCompleteListener(new InterfaceC8937e() { // from class: pj.g
                @Override // p208cq.InterfaceC8937e
                public final void onComplete(Task task) throws JSONException {
                    this.f56359a.m29012a(task);
                }
            });
        } catch (Throwable th2) {
            HiLog.m28808e("ConfigHandler", "request ha config error: " + th2.getClass().getSimpleName());
        }
        C4785j.m28917a("global_v2", "ha_config_last_request_time", System.currentTimeMillis());
    }

    /* renamed from: a */
    public final synchronized void m29015a() {
        String strM28908a = C4785j.m28908a("global_v2", "ha_config", "");
        if (TextUtils.isEmpty(strM28908a)) {
            HiLog.m28809i("ConfigHandler", "ha config is empty");
            this.f21909a = 86400000L;
            this.f21910a = false;
            this.f21911b = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strM28908a);
            this.f21909a = jSONObject.optLong("requestInterval", 86400000L);
            this.f21910a = jSONObject.optBoolean("enableCheckTime", false);
            this.f21911b = jSONObject.optBoolean("enableCheckOaid", false);
        } catch (JSONException unused) {
            this.f21909a = 86400000L;
            this.f21910a = false;
            this.f21911b = false;
            HiLog.m28812w("ConfigHandler", "ha config failed");
        }
    }

    /* renamed from: a */
    public void m29011a(C4812w0 c4812w0) throws JSONException {
        String str;
        String str2 = c4812w0.f21973a;
        if (TextUtils.isEmpty(str2)) {
            HiLog.m28809i("ConfigHandler", "request ha config failed, rsp is empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.optInt("status") != 200) {
                str = "request ha config status code 500";
            } else {
                this.f21909a = jSONObject.optLong("requestInterval", 86400000L);
                this.f21910a = jSONObject.optBoolean("enableCheckTime", false);
                this.f21911b = jSONObject.optBoolean("enableCheckOaid", false);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("requestInterval", this.f21909a);
                jSONObject2.put("enableCheckTime", this.f21910a);
                jSONObject2.put("enableCheckOaid", this.f21911b);
                C4785j.m28918a("global_v2", "ha_config", jSONObject2.toString());
                str = "request ha config success";
            }
            HiLog.m28809i("ConfigHandler", str);
        } catch (JSONException unused) {
            HiLog.m28812w("ConfigHandler", "request ha config failed, exception occur");
        }
    }

    /* renamed from: a */
    public void m29012a(Task task) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (task.isSuccessful()) {
                jSONObject = new JSONObject(((C4812w0) task.getResult()).f21973a);
            } else {
                jSONObject.put("status", task.getException().getMessage());
            }
        } catch (JSONException unused) {
            HiLog.m28808e("ConfigHandler", "report request ha config");
        }
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        if (instanceByTag == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (TextUtils.isEmpty(jSONObject.optString("message"))) {
            linkedHashMap.put("$code", jSONObject.optString("status"));
        } else {
            linkedHashMap.put("$code", String.valueOf(jSONObject.optInt("status")));
            linkedHashMap.put("$message", jSONObject.optString("message"));
        }
        instanceByTag.onEvent(1, "$request_ha_config", linkedHashMap);
    }
}
