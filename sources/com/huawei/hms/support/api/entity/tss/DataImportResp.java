package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DataImportResp extends BaseResp {
    private String data;

    public DataImportResp(String str) throws JSONException {
        this.data = new JSONObject(str).getString("data");
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String toString() {
        return "DataImportResp{data=" + this.data + '}';
    }
}
