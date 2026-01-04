package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DataImportRequ extends BaseRequ {
    private static final String TAG = "KeyImportRequ";

    @Packed
    private int exportType;

    @Packed
    private String exportedData;

    @Packed
    private String uid;

    public int getExportType() {
        return this.exportType;
    }

    public String getExportedData() {
        return this.exportedData;
    }

    public String getUid() {
        return this.uid;
    }

    public void setExportType(int i10) {
        this.exportType = i10;
    }

    public void setExportedData(String str) {
        this.exportedData = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exportedData", this.exportedData);
            jSONObject.put("exportType", this.exportType);
            jSONObject.put("uid", this.uid);
            jSONObject.put("caller", str);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "DataImportRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
