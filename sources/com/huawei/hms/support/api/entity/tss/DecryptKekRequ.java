package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DecryptKekRequ extends BaseRequ {
    private static final String TAG = "DecryptKekRequ";
    private String kek;

    public DecryptKekRequ() {
    }

    public String getKek() {
        return this.kek;
    }

    public void setKek(String str) {
        this.kek = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("kek", this.kek);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "json error");
        }
        return jSONObject.toString();
    }

    public DecryptKekRequ(String str) throws JSONException {
        this.kek = new JSONObject(str).optString("kek");
    }
}
