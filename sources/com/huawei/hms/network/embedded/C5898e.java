package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.utils.CheckConfigUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.e */
/* loaded from: classes8.dex */
public class C5898e {

    /* renamed from: a */
    public static final String f26669a = "BaseConfig";
    public JSONObject configObj;

    public C5898e(String str) {
        try {
            this.configObj = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "call method set options occur JSONException");
        }
    }

    /* renamed from: a */
    private void m34107a(String str, Object obj) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            Logger.m32147w(f26669a, "network config key : %s is null", str);
            return;
        }
        try {
            if (!str.startsWith("core_")) {
                str = "core_" + str;
            }
            if (TextUtils.equals(str, PolicyNetworkService.GlobalConstants.ENABLE_IPV6)) {
                str = "core_enable_ipv6_preferred";
            }
            if (CheckConfigUtils.checkIsCorrect(str, obj)) {
                this.configObj.put(str, obj);
                return;
            }
            Logger.m32145w(f26669a, "Set value error, value of " + str + " is out of range.");
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "Set value error " + str);
        }
    }

    public void appendOption(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f26669a, "appendOption options == null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!this.configObj.has(next)) {
                    this.configObj.put(next, jSONObject.get(next));
                }
            }
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "appendOption error " + str);
        }
    }

    public String get(String str) throws JSONException {
        try {
            if (!this.configObj.has(str)) {
                return "";
            }
            Object obj = this.configObj.get(str);
            return obj instanceof String ? (String) obj : String.valueOf(obj);
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getInt error " + str);
            return "";
        }
    }

    public boolean getBoolean(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getBoolean(str);
            }
            return false;
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getBoolean error " + str);
            return false;
        }
    }

    public double getDouble(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getDouble(str);
            }
            return 0.0d;
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getDouble error " + str);
            return 0.0d;
        }
    }

    public int getInt(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getInt(str);
            }
            return 0;
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getInt error " + str);
            return 0;
        }
    }

    public long getLong(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getLong(str);
            }
            return 0L;
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getLong error " + str);
            return 0L;
        }
    }

    public Map<String, String> getMap(String str) {
        HashMap map = new HashMap();
        try {
            if (this.configObj.has(str)) {
                JSONObject jSONObject = new JSONObject(this.configObj.getString(str));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            }
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getmap error " + StringUtils.anonymizeMessage(str));
        }
        return map;
    }

    public String getString(String str) {
        try {
            return this.configObj.has(str) ? this.configObj.getString(str) : "";
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "getString error " + str);
            return "";
        }
    }

    public void setOption(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                m34107a(next.trim(), jSONObject.get(next));
            }
        } catch (JSONException unused) {
            Logger.m32145w(f26669a, "setOption error " + str);
        }
    }

    public void setValue(String str, double d10) throws JSONException {
        m34107a(str, Double.valueOf(d10));
    }

    public String toString() {
        return this.configObj.toString();
    }

    public void setValue(String str, int i10) throws JSONException {
        m34107a(str, Integer.valueOf(i10));
    }

    public void setValue(String str, long j10) throws JSONException {
        m34107a(str, Long.valueOf(j10));
    }

    public void setValue(String str, Object obj) throws JSONException {
        m34107a(str, obj);
    }

    public void setValue(String str, boolean z10) throws JSONException {
        m34107a(str, Boolean.valueOf(z10));
    }
}
