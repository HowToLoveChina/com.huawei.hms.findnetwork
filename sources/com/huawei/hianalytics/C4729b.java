package com.huawei.hianalytics;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.DeviceAttributeCollector;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import eu.C9560a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.b */
/* loaded from: classes5.dex */
public class C4729b implements DeviceAttributeCollector {

    /* renamed from: a */
    public final String f21643a;

    /* renamed from: b */
    public final String f21644b;

    public C4729b(String str, String str2) {
        this.f21643a = str;
        this.f21644b = str2;
    }

    /* renamed from: a */
    public String m28769a() {
        String str;
        String str2;
        C4793m0 c4793m0M28967a = C4793m0.m28967a();
        String str3 = this.f21643a;
        String str4 = this.f21644b;
        Context context = c4793m0M28967a.f21879a;
        C4731b1 c4731b1M28901a = C4785j.m28901a(str3, str4);
        if (c4731b1M28901a == null || (str = c4731b1M28901a.f21660c) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            C4731b1 c4731b1M28901a2 = C4785j.m28901a(str3, str4);
            return (c4731b1M28901a2 == null || (str2 = c4731b1M28901a2.f21660c) == null) ? "" : str2;
        }
        C4731b1 c4731b1M28901a3 = C4785j.m28901a(str3, str4);
        if (c4731b1M28901a3 == null || !c4731b1M28901a3.f21663d) {
            return "";
        }
        if (TextUtils.isEmpty(C4782i.m28891a().m28893a().f21853e)) {
            C4782i.m28891a().m28893a().f21853e = context != null ? Settings.Secure.getString(context.getContentResolver(), "android_id") : "";
        }
        return C4782i.m28891a().m28893a().f21853e;
    }

    /* renamed from: b */
    public final String m28771b() throws JSONException {
        if (!C4801q0.f21908a.f21911b) {
            return TextUtils.isEmpty(C4785j.m28907a(this.f21643a, this.f21644b)) ? "" : C4785j.m28907a(this.f21643a, this.f21644b);
        }
        String strM28908a = C4785j.m28908a("global_v2", m28772c(), "");
        String strM59677f = TextUtils.isEmpty(strM28908a) ? "" : C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", strM28908a);
        if (TextUtils.isEmpty(strM59677f)) {
            return strM59677f;
        }
        Pair<String, Boolean> pairM28899a = C4785j.m28899a(EnvUtils.getAppContext());
        if (strM59677f.equals(pairM28899a.first)) {
            return strM59677f;
        }
        String str = (String) pairM28899a.first;
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        if (instanceByTag != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("oaid_before", strM59677f);
                jSONObject.put("oaid_refresh", str);
                jSONObject.put("oaid_refresh_time", System.currentTimeMillis());
                instanceByTag.onEventSync(0, "107", jSONObject);
                instanceByTag.onReport(0);
            } catch (JSONException unused) {
                HiLog.m28808e("HADC", "JSONException occur");
            }
        }
        C4785j.m28918a("global_v2", m28772c(), C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", (String) pairM28899a.first));
        return (String) pairM28899a.first;
    }

    /* renamed from: c */
    public final String m28772c() {
        String strValueOf;
        int i10;
        if (this.f21644b.equals("oper")) {
            i10 = 0;
        } else {
            if (!this.f21644b.equals("maint")) {
                strValueOf = "";
                return this.f21643a + "_" + strValueOf + "_oaid";
            }
            i10 = 1;
        }
        strValueOf = String.valueOf(i10);
        return this.f21643a + "_" + strValueOf + "_oaid";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020d A[Catch: JSONException -> 0x0256, TryCatch #0 {JSONException -> 0x0256, blocks: (B:99:0x01b6, B:101:0x01ce, B:103:0x01da, B:105:0x01de, B:112:0x01f5, B:114:0x01fa, B:116:0x0203, B:118:0x020d, B:120:0x0211, B:127:0x0226, B:129:0x022b, B:131:0x0236, B:133:0x023c, B:134:0x023e, B:138:0x0249, B:140:0x024e, B:137:0x0245, B:123:0x0218, B:125:0x0222, B:108:0x01e5, B:110:0x01f1), top: B:144:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x023c A[Catch: JSONException -> 0x0256, TryCatch #0 {JSONException -> 0x0256, blocks: (B:99:0x01b6, B:101:0x01ce, B:103:0x01da, B:105:0x01de, B:112:0x01f5, B:114:0x01fa, B:116:0x0203, B:118:0x020d, B:120:0x0211, B:127:0x0226, B:129:0x022b, B:131:0x0236, B:133:0x023c, B:134:0x023e, B:138:0x0249, B:140:0x024e, B:137:0x0245, B:123:0x0218, B:125:0x0222, B:108:0x01e5, B:110:0x01f1), top: B:144:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0245 A[Catch: JSONException -> 0x0256, TryCatch #0 {JSONException -> 0x0256, blocks: (B:99:0x01b6, B:101:0x01ce, B:103:0x01da, B:105:0x01de, B:112:0x01f5, B:114:0x01fa, B:116:0x0203, B:118:0x020d, B:120:0x0211, B:127:0x0226, B:129:0x022b, B:131:0x0236, B:133:0x023c, B:134:0x023e, B:138:0x0249, B:140:0x024e, B:137:0x0245, B:123:0x0218, B:125:0x0222, B:108:0x01e5, B:110:0x01f1), top: B:144:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8 A[PHI: r10
  0x00c8: PHI (r10v14 java.lang.String) = (r10v13 java.lang.String), (r10v15 java.lang.String) binds: [B:41:0x00b5, B:43:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014a A[PHI: r10
  0x014a: PHI (r10v5 java.lang.String) = (r10v4 java.lang.String), (r10v4 java.lang.String), (r10v8 java.lang.String), (r10v8 java.lang.String) binds: [B:59:0x0124, B:61:0x0128, B:63:0x0132, B:65:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015e A[PHI: r10
  0x015e: PHI (r10v6 java.lang.String) = (r10v5 java.lang.String), (r10v7 java.lang.String) binds: [B:68:0x014c, B:70:0x0156] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017e  */
    @Override // com.huawei.hianalytics.framework.config.DeviceAttributeCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject doCollector(org.json.JSONObject r14) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4729b.doCollector(org.json.JSONObject):org.json.JSONObject");
    }

    /* renamed from: a */
    public final JSONObject m28770a() {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21643a, this.f21644b);
        String str = c4728a1M28900a != null ? c4728a1M28900a.f21641h : "";
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            HiLog.m28808e("HADC", "json exception, tag: " + this.f21643a + ", type: " + this.f21644b);
            return new JSONObject();
        }
    }
}
