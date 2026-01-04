package com.huawei.hicloud.request.basic.bean;

import com.google.gson.Gson;
import java.util.Map;

/* loaded from: classes6.dex */
public class BasicReportSwitchReq extends BasicBaseReq {
    private Map<String, String> swStatusMap;

    public BasicReportSwitchReq(Map<String, String> map, String str) {
        super("changeDeviceSwitchReq");
        if ("2".equals(str)) {
            this.info = "reportDeviceSwitchReq";
        }
        this.swStatusMap = map;
    }

    public Map<String, String> getSwStatusMap() {
        return this.swStatusMap;
    }

    public void setSwStatusMap(Map<String, String> map) {
        this.swStatusMap = map;
    }

    @Override // com.huawei.hicloud.request.basic.bean.BasicBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }
}
