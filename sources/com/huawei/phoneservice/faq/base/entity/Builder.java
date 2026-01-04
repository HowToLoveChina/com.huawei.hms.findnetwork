package com.huawei.phoneservice.faq.base.entity;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Builder {
    private static final String TAG = "Builder";
    private Map<String, String> map = new ConcurrentHashMap();

    private String getLanguageCode(String str, String str2) {
        if (str.contains("_")) {
            str = str.replace("_", "-");
        }
        if (!str.contains("-") || str.split("-").length <= 0) {
            return str;
        }
        if (str.split("-").length != 1 && !FaqStringUtil.isEmpty(str.split("-")[1])) {
            return str;
        }
        return str.split("-")[0] + "-" + str2;
    }

    private void setIsDeepLink() {
        Map<String, String> map;
        String str;
        if (!this.map.containsKey(FaqConstants.FAQ_IS_DEEPLICK) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_IS_DEEPLICK))) {
            map = this.map;
            str = "N";
        } else {
            map = this.map;
            str = map.get(FaqConstants.FAQ_IS_DEEPLICK);
        }
        map.put(FaqConstants.FAQ_IS_DEEPLICK, str);
    }

    public Map<String, String> build() {
        if (this.map.containsKey(FaqConstants.FAQ_EMUI_LANGUAGE)) {
            this.map.put(FaqConstants.FAQ_EMUI_LANGUAGE, getLanguageCode(this.map.get(FaqConstants.FAQ_EMUI_LANGUAGE), this.map.get("country")));
        }
        if (!this.map.containsKey(FaqConstants.FAQ_MODEL) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_MODEL))) {
            String model = FaqDeviceUtils.getModel();
            if (!TextUtils.isEmpty(model)) {
                this.map.put(FaqConstants.FAQ_MODEL, model);
            }
        }
        if (!this.map.containsKey(FaqConstants.FAQ_EMUIVERSION) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_EMUIVERSION))) {
            String emui = FaqDeviceUtils.getEmui();
            if (!TextUtils.isEmpty(emui)) {
                this.map.put(FaqConstants.FAQ_EMUIVERSION, emui);
            }
        }
        if (!this.map.containsKey(FaqConstants.FAQ_OSVERSION) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_OSVERSION))) {
            this.map.put(FaqConstants.FAQ_OSVERSION, FaqDeviceUtils.getAndroidVersion());
        }
        if ((!this.map.containsKey(FaqConstants.FAQ_LANGUAGE) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_LANGUAGE))) && !TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_EMUI_LANGUAGE))) {
            Map<String, String> map = this.map;
            map.put(FaqConstants.FAQ_LANGUAGE, map.get(FaqConstants.FAQ_EMUI_LANGUAGE));
        }
        setIsDeepLink();
        return this.map;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_EMUI_LANGUAGE)) || TextUtils.isEmpty(this.map.get("country")) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_CHANNEL)) || TextUtils.isEmpty(this.map.get("appVersion"));
    }

    public Builder set(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.map.put(str, str2);
        }
        return this;
    }

    public Builder setJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject.optString(next))) {
                    this.map.put(next, jSONObject.optString(next));
                }
            }
        } catch (JSONException unused) {
            Log.e(TAG, "  JSONException  ");
        }
        return this;
    }

    public Builder setUri(Uri uri) throws Throwable {
        try {
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(queryParameter)) {
                    this.map.put(str, queryParameter);
                }
            }
        } catch (UnsupportedOperationException | Exception e10) {
            FaqLogger.m51840e(TAG, e10.getMessage());
        }
        return this;
    }
}
