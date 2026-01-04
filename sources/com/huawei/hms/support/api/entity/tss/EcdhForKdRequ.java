package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class EcdhForKdRequ extends BaseRequ {
    private static final String TAG = "EcdhForKdRequ";

    @Packed
    private String keyEnc;

    @Packed
    private String[] peerKey;

    public String getKeyEnc() {
        return this.keyEnc;
    }

    public String[] getPeerKey() {
        String[] strArr = this.peerKey;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public void setKeyEnc(String str) {
        this.keyEnc = str;
    }

    public void setPeerKey(String[] strArr) {
        if (strArr != null) {
            this.peerKey = (String[]) strArr.clone();
        } else {
            this.peerKey = new String[0];
        }
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("caller", str);
            jSONObject.put("keyEnc", this.keyEnc);
            JSONArray jSONArray = new JSONArray();
            if (this.peerKey != null) {
                int i10 = 0;
                while (true) {
                    String[] strArr = this.peerKey;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    jSONArray.put(strArr[i10]);
                    i10++;
                }
            }
            jSONObject.put("peerKey", jSONArray);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "EcdhForKdRequ toJson failed.");
        }
        return jSONObject.toString();
    }
}
