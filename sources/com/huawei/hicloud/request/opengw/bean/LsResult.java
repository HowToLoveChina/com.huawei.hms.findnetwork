package com.huawei.hicloud.request.opengw.bean;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LsResult {
    private List<Map<String, Object>> childList = new ArrayList();
    private int errCode;
    private String errMsg;
    private String version;

    public List<Map<String, Object>> getChildList() {
        return this.childList;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getVersion() {
        return this.version;
    }

    public void setChildList(List<Map<String, Object>> list) {
        this.childList = list;
    }

    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
