package com.huawei.hms.framework.network.restclient.config;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BaseConfig {
    private static final String TAG = "BaseConfig";
    public JSONObject configObj;

    public BaseConfig(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.configObj = new JSONObject();
            } else {
                this.configObj = new JSONObject(str);
            }
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "call method set options occur JSONException");
        }
    }

    public boolean getBoolean(String str, boolean z10) {
        try {
            return this.configObj.has(str) ? this.configObj.getBoolean(str) : z10;
        } catch (JSONException unused) {
            return z10;
        }
    }

    public double getDouble(String str, double d10) {
        try {
            return this.configObj.has(str) ? this.configObj.getDouble(str) : d10;
        } catch (JSONException unused) {
            return d10;
        }
    }

    public int getInt(String str, int i10) {
        try {
            return this.configObj.has(str) ? this.configObj.getInt(str) : i10;
        } catch (JSONException unused) {
            return i10;
        }
    }

    public long getLong(String str, long j10) {
        try {
            return this.configObj.has(str) ? this.configObj.getLong(str) : j10;
        } catch (JSONException unused) {
            return j10;
        }
    }

    public Map<String, String> getMap(String str) throws JSONException {
        HashMap map = new HashMap();
        try {
            if (this.configObj.has(str)) {
                JSONObject jSONObject = this.configObj.getJSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            }
        } catch (JSONException unused) {
            Logger.m32141i("BaseConfig", "get map error " + str);
        }
        return map;
    }

    public String getString(String str, String str2) {
        try {
            return this.configObj.has(str) ? this.configObj.getString(str) : str2;
        } catch (JSONException unused) {
            return str2;
        }
    }

    public void setOption(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.configObj.put(next, jSONObject.getString(next));
            }
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "setOption error " + str);
        }
    }

    public void setValue(String str, int i10) throws JSONException {
        try {
            this.configObj.put(str, i10);
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "setValue error " + str);
        }
    }

    public String toString() {
        return this.configObj.toString();
    }

    public void setValue(String str, double d10) throws JSONException {
        try {
            this.configObj.put(str, d10);
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, boolean z10) throws JSONException {
        try {
            this.configObj.put(str, z10);
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, long j10) throws JSONException {
        try {
            this.configObj.put(str, j10);
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, Object obj) throws JSONException {
        try {
            this.configObj.put(str, obj);
        } catch (JSONException unused) {
            Logger.m32145w("BaseConfig", "setValue error " + str);
        }
    }
}
