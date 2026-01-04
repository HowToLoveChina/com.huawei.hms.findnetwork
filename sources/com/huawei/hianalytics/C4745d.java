package com.huawei.hianalytics;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.TransportHandlerFactory;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.framework.config.CipherType;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import eu.C9560a;
import gu.C10049c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.d */
/* loaded from: classes5.dex */
public class C4745d implements IMandatoryParameters {
    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public boolean checkDebugModeEnabled() {
        return C4785j.m28922a(EnvUtils.getAppContext());
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public List<String> getAllTags() {
        return HiAnalyticsManager.getAllTags();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getAppVer() {
        return C4782i.m28891a().m28893a().f21856h;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getCipherType() {
        return CipherType.AES_GCM;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getDebugModeUrl() {
        return C4785j.m28902a();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public byte[] getLoadWorkKey() {
        C4799p0 c4799p0M28983a = C4799p0.m28983a();
        if (c4799p0M28983a.f21895a == null) {
            c4799p0M28983a.f21895a = C10049c.m62477b(c4799p0M28983a.m28984a());
        }
        return c4799p0M28983a.f21895a;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getModel() {
        return Build.MODEL;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getProcessName() {
        return C4785j.m28930b(EnvUtils.getAppContext());
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public Pair<String, String> getRsaPublicKeyFromNetWork(String str, String str2) {
        String strM59677f;
        String strM28902a;
        String str3;
        String strM28946e = C4785j.m28946e();
        String str4 = "";
        if (TextUtils.isEmpty(strM28946e)) {
            strM28946e = C4785j.m28908a("Privacy_MY", "public_key_version", "");
            C4782i.m28891a().m28893a().f21868t = strM28946e;
        }
        if ("maint".equals(str2)) {
            strM59677f = C4782i.m28891a().m28893a().f21865q;
            if (TextUtils.isEmpty(strM59677f)) {
                strM59677f = C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", C4785j.m28908a("Privacy_MY", "public_key_maint", ""));
                C4782i.m28891a().m28893a().f21865q = strM59677f;
            }
        } else {
            strM59677f = C4782i.m28891a().m28893a().f21864p;
            if (TextUtils.isEmpty(strM59677f)) {
                strM59677f = C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", C4785j.m28908a("Privacy_MY", "public_key_oper", ""));
                C4782i.m28891a().m28893a().f21864p = strM59677f;
            }
        }
        if (TextUtils.isEmpty(strM59677f) || !"2.0".equals(strM28946e) || C4785j.m28920a()) {
            HashMap map = new HashMap();
            C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(str);
            String str5 = c4750e1M28892a != null ? c4750e1M28892a.f21710a : "";
            if (TextUtils.isEmpty(str5)) {
                C4790l c4790lM28893a = C4782i.m28891a().m28893a();
                str5 = TextUtils.isEmpty(c4790lM28893a.f21855g) ? c4790lM28893a.f21854f : c4790lM28893a.f21855g;
            }
            map.put("App-Id", str5);
            C4728a1 c4728a1M28900a = C4785j.m28900a(str, str2);
            Map<String, String> map2 = c4728a1M28900a != null ? c4728a1M28900a.f21623a : null;
            if (map2 != null) {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    if ("x-hasdk-pkg".equals(entry.getKey()) || "x-hasdk-token".equals(entry.getKey()) || "x-hasdk-clientid".equals(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (C4785j.m28922a(EnvUtils.getAppContext())) {
                strM28902a = C4785j.m28902a();
            } else {
                C4728a1 c4728a1M28900a2 = C4785j.m28900a(str, str2);
                strM28902a = c4728a1M28900a2 != null ? c4728a1M28900a2.f21631c : "";
            }
            if (TextUtils.isEmpty(strM28902a)) {
                HiLog.m28812w("GetPublicKey", "collectUrl is null, tag: " + str + ", type: " + str2);
            } else {
                String strReplace = "{url}/getPublicKey?keytype=4".replace("{url}", strM28902a);
                byte[] bArr = new byte[0];
                C4728a1 c4728a1M28900a3 = C4785j.m28900a(str, str2);
                Response responseExecute = TransportHandlerFactory.create(strReplace, map, bArr, c4728a1M28900a3 == null ? 1 : c4728a1M28900a3.f21629c).execute();
                if (responseExecute == null) {
                    str3 = "get pubKey response is null";
                } else if (responseExecute.getHttpCode() != 200) {
                    str3 = "get pubKey fail HttpCode: " + responseExecute.getHttpCode();
                } else {
                    String content = responseExecute.getContent();
                    if (!TextUtils.isEmpty(content)) {
                        try {
                            JSONObject jSONObject = new JSONObject(content);
                            String strOptString = jSONObject.optString("publicKey");
                            String strOptString2 = jSONObject.optString("publicKeyOM");
                            String strOptString3 = jSONObject.optString("pubkey_version");
                            String str6 = System.currentTimeMillis() + "";
                            String strOptString4 = jSONObject.optString("timeInterval");
                            String strOptString5 = jSONObject.optString("serverTime");
                            C4785j.m28918a("Privacy_MY", "public_key_oper", C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", strOptString));
                            C4785j.m28918a("Privacy_MY", "public_key_maint", C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", strOptString2));
                            C4785j.m28918a("Privacy_MY", "public_key_time_interval", strOptString4);
                            C4785j.m28918a("Privacy_MY", "public_key_time_last", str6);
                            C4785j.m28918a("Privacy_MY", "public_key_version", strOptString3);
                            if (!TextUtils.isEmpty(strOptString5)) {
                                long j10 = Long.parseLong(strOptString5) - System.currentTimeMillis();
                                C4785j.m28917a("global_v2", "public_key_abs_time", j10);
                                C4782i.m28891a().m28893a().f21850c = j10;
                            }
                            C4782i.m28891a().m28893a().f21864p = strOptString;
                            C4782i.m28891a().m28893a().f21865q = strOptString2;
                            C4782i.m28891a().m28893a().f21868t = strOptString3;
                            C4782i.m28891a().m28893a().f21867s = str6;
                            C4782i.m28891a().m28893a().f21866r = strOptString4;
                            if ("maint".equals(str2)) {
                                C4785j.f21833a = strOptString2;
                            } else {
                                C4785j.f21833a = strOptString;
                            }
                            HiLog.m28810si("GetPublicKey", "get pubKey success");
                        } catch (JSONException unused) {
                            HiLog.m28811sw("GetPublicKey", "get pubKey parse json failed");
                        }
                    }
                    str4 = C4785j.f21833a;
                }
                HiLog.m28811sw("GetPublicKey", str3);
                str4 = C4785j.f21833a;
            }
        } else {
            str4 = strM59677f;
        }
        return Pair.create(str4, C4785j.m28946e());
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public boolean isFlashKey() {
        long jM28896a = C4785j.m28896a("analytics_key", "flashKeyTime", -1L);
        if (jM28896a == -1) {
            jM28896a = C4785j.m28896a("Privacy_MY", "flashKeyTime", -1L);
        } else {
            C4785j.m28937b(EnvUtils.getAppContext(), "analytics_key");
        }
        return System.currentTimeMillis() - jM28896a > 1296000000;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public void refreshKey(String str, int i10) {
        C4799p0 c4799p0M28983a = C4799p0.m28983a();
        c4799p0M28983a.getClass();
        if (TextUtils.isEmpty(str) || i10 != 1) {
            return;
        }
        HiLog.m28810si("RootKeyManager", "generate a new local working key");
        c4799p0M28983a.f21896b = str;
        c4799p0M28983a.m28987a(c4799p0M28983a.m28985a(str));
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String rsaEncrypt(String str, String str2, String str3) {
        return C4779h.m28889a(str, str2, str3);
    }
}
