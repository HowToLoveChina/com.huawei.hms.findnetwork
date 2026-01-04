package com.huawei.hicloud.request.basic.bean;

import com.google.gson.Gson;
import java.util.Map;

/* loaded from: classes6.dex */
public class BasicSwitchRegisterReq extends BasicBaseReq {
    private Map<String, String> swStatusMap;
    private String uploadMode;

    public BasicSwitchRegisterReq(Map<String, String> map, String str) {
        super("BasicSwitchRegisterReq");
        this.swStatusMap = map;
        this.uploadMode = str;
    }

    public Map<String, String> getSwStatusMap() {
        return this.swStatusMap;
    }

    public String getUploadMode() {
        return this.uploadMode;
    }

    public void setSwStatusMap(Map<String, String> map) {
        this.swStatusMap = map;
    }

    public void setUploadMode(String str) {
        this.uploadMode = str;
    }

    @Override // com.huawei.hicloud.request.basic.bean.BasicBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }
}
