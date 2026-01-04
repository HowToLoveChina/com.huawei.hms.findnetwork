package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KeyExportRequ extends BaseRequ {
    private static final String TAG = "KeyExportRequ";

    @Packed
    private String alias;

    @Packed
    private int exportType;

    @Packed
    private String trustCircleKeyVersion;

    @Packed
    private String uid;

    public String getAlias() {
        return this.alias;
    }

    public int getExportType() {
        return this.exportType;
    }

    public String getTrustCircleKeyVersion() {
        return this.trustCircleKeyVersion;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setExportType(int i10) {
        this.exportType = i10;
    }

    public void setTrustCircleKeyVersion(String str) {
        this.trustCircleKeyVersion = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("caller", str);
            jSONObject.put("alias", this.alias);
            jSONObject.put("exportType", this.exportType);
            jSONObject.put("uid", this.uid);
            jSONObject.put("trustCircleKeyVersion", this.trustCircleKeyVersion);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "KeyExportRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
