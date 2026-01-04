package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DataExportResp extends BaseResp {
    private String exportedData;

    public DataExportResp(String str) throws JSONException {
        this.exportedData = new JSONObject(str).getString("exportedData");
    }

    public String getExportedData() {
        return this.exportedData;
    }

    public void setExportedData(String str) {
        this.exportedData = str;
    }

    public String toString() {
        return "GetPublicKeyResp{exportedData=" + this.exportedData + '}';
    }
}
