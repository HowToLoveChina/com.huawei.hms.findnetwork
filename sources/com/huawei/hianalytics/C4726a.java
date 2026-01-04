package com.huawei.hianalytics;

import android.content.res.Configuration;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.framework.config.DeviceAttributeCollector;
import com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.RomAttributeCollector;
import com.huawei.openalliance.p169ad.constant.OsType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.a */
/* loaded from: classes5.dex */
public class C4726a implements ICollectorConfig {

    /* renamed from: a */
    public final C4790l f21615a = C4782i.m28891a().m28893a();

    /* renamed from: a */
    public final String f21616a;

    public C4726a(String str) {
        this.f21616a = str;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public long getAbsTime() {
        if (!C4801q0.f21908a.f21910a) {
            return 0L;
        }
        long jM28896a = C4782i.m28891a().m28893a().f21850c;
        if (jM28896a == 0) {
            jM28896a = C4785j.m28896a("global_v2", "public_key_abs_time", 0L);
            C4782i.m28891a().m28893a().f21850c = jM28896a;
        }
        if (Math.abs(jM28896a) > 604800000) {
            return jM28896a;
        }
        return 0L;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public String getAppId() {
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(this.f21616a);
        String str = c4750e1M28892a != null ? c4750e1M28892a.f21710a : "";
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        C4790l c4790l = this.f21615a;
        return TextUtils.isEmpty(c4790l.f21855g) ? c4790l.f21854f : c4790l.f21855g;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public String getCollectUrl(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        return c4728a1M28900a != null ? c4728a1M28900a.f21631c : "";
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public DeviceAttributeCollector getDeviceAttribute(String str) {
        return new C4729b(this.f21616a, str);
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public EvtHeaderAttributeCollector getEvtCustomHeader(String str, JSONObject jSONObject) {
        return new C4732c(jSONObject);
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public Map<String, String> getHttpHeader(String str) {
        HashMap map = new HashMap();
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        Map<String, String> map2 = c4728a1M28900a != null ? c4728a1M28900a.f21623a : null;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public int getMetricPolicy(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        if (c4728a1M28900a == null) {
            return 1;
        }
        return c4728a1M28900a.f21629c;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public String getPkgName() {
        return C4785j.m28939c();
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public RomAttributeCollector getRomAttribute(String str, String str2) {
        Pair pair;
        String str3;
        Locale locale;
        C4728a1 c4728a1M28826a;
        C4751f c4751f = new C4751f();
        C4790l c4790l = this.f21615a;
        int i10 = c4790l.f21844a;
        int i11 = c4790l.f21847b;
        if (i11 == 0 || i10 == 0) {
            DisplayMetrics displayMetrics = EnvUtils.getAppContext().getResources().getDisplayMetrics();
            i10 = displayMetrics.heightPixels;
            i11 = displayMetrics.widthPixels;
            C4790l c4790l2 = this.f21615a;
            c4790l2.f21844a = i10;
            c4790l2.f21847b = i11;
        }
        C4793m0 c4793m0M28967a = C4793m0.m28967a();
        String str4 = this.f21616a;
        c4793m0M28967a.getClass();
        C4750e1 c4750e1M28892a = C4782i.m28891a().m28892a(str4);
        String string = "";
        if (c4750e1M28892a == null || (c4728a1M28826a = c4750e1M28892a.m28826a(str)) == null || !c4728a1M28826a.f21624a) {
            pair = new Pair("", "");
        } else {
            String str5 = C4782i.m28891a().m28893a().f21859k;
            String str6 = C4782i.m28891a().m28893a().f21860l;
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6)) {
                TelephonyManager telephonyManager = (TelephonyManager) c4793m0M28967a.f21879a.getSystemService("phone");
                if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    pair = (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, "null") || networkOperator.length() <= 3) ? new Pair("", "") : new Pair(networkOperator.substring(0, 3), networkOperator.substring(3));
                } else {
                    pair = new Pair("", "");
                }
                C4782i.m28891a().m28893a().f21859k = (String) pair.first;
                C4782i.m28891a().m28893a().f21860l = (String) pair.second;
            } else {
                pair = new Pair(str5, str6);
            }
        }
        C4750e1 c4750e1M28892a2 = C4782i.m28891a().m28892a(this.f21616a);
        String str7 = c4750e1M28892a2 != null ? c4750e1M28892a2.f21715e : "";
        if (TextUtils.isEmpty(str7)) {
            c4751f.f21726i = "";
        } else {
            c4751f.f21726i = str7;
        }
        String strM28933b = C4785j.m28933b("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        if (TextUtils.isEmpty(strM28933b)) {
            strM28933b = Build.DISPLAY;
        }
        c4751f.f21717a = strM28933b;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f21615a.f21856h;
        }
        c4751f.f21722e = str2;
        C4790l c4790l3 = this.f21615a;
        String str8 = c4790l3.f21846a;
        if (str8 == null) {
            c4751f.f21719b = "";
        } else {
            c4751f.f21719b = str8;
        }
        c4751f.f21725h = "hianalytics";
        c4751f.f21723f = "3.2.13.500";
        c4751f.f21720c = Build.MODEL;
        c4751f.f21721d = c4790l3.f21854f;
        C4793m0 c4793m0M28967a2 = C4793m0.m28967a();
        c4751f.f21724g = ("oper".equals(str) || "maint".equals(str)) ? C4785j.m28905a(c4793m0M28967a2.f21879a, this.f21616a, str) : "";
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        String str9 = c4728a1M28900a != null ? c4728a1M28900a.f21637e : "";
        if (TextUtils.isEmpty(str9)) {
            c4751f.f21729l = "";
        } else {
            c4751f.f21729l = str9;
        }
        c4751f.f21734q = (String) pair.first;
        c4751f.f21735r = (String) pair.second;
        C4750e1 c4750e1M28892a3 = C4782i.m28891a().m28892a(this.f21616a);
        String str10 = c4750e1M28892a3 != null ? c4750e1M28892a3.f21712b : "";
        if (TextUtils.isEmpty(str10)) {
            c4751f.f21727j = "";
        } else {
            c4751f.f21727j = str10;
        }
        C4750e1 c4750e1M28892a4 = C4782i.m28891a().m28892a(this.f21616a);
        String str11 = c4750e1M28892a4 != null ? c4750e1M28892a4.f21713c : "";
        if (TextUtils.isEmpty(str11)) {
            c4751f.f21728k = "";
        } else {
            c4751f.f21728k = str11;
        }
        c4751f.f21731n = Build.VERSION.RELEASE;
        c4751f.f21716a = i10;
        c4751f.f21718b = i11;
        Configuration configuration = EnvUtils.getAppContext().getResources().getConfiguration();
        if (configuration != null && (locale = configuration.locale) != null) {
            string = locale.toString();
        }
        c4751f.f21733p = string;
        if (TextUtils.isEmpty(this.f21615a.f21869u)) {
            str3 = OsType.ANDROID;
        } else {
            c4751f.f21732o = this.f21615a.f21869u;
            str3 = "harmony";
        }
        c4751f.f21730m = str3;
        return c4751f;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public boolean getShortLinkEnabled(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        if (c4728a1M28900a == null) {
            return false;
        }
        return c4728a1M28900a.f21635d;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public String getUdid() {
        return C4785j.m28948f();
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public boolean isEnableSession(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        if (c4728a1M28900a != null) {
            return c4728a1M28900a.f21628b;
        }
        return false;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public boolean isLocalEncrypted(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        if (c4728a1M28900a != null) {
            Boolean bool = c4728a1M28900a.f21621a;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean bool2 = c4728a1M28900a.f21626b;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return true;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public boolean isUploadEncrypted(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21616a, str);
        if (c4728a1M28900a == null) {
            return true;
        }
        Boolean bool = c4728a1M28900a.f21621a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = c4728a1M28900a.f21630c;
        return bool2 != null ? bool2.booleanValue() : true ^ TextUtils.equals(str, "maint");
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public void requestConfig() {
        C4801q0.f21908a.m29017b();
    }
}
