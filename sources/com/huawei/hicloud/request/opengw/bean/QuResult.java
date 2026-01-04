package com.huawei.hicloud.request.opengw.bean;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class QuResult {
    private String cursor;
    private List<Map<String, Object>> fileList;

    public String getCursor() {
        return this.cursor;
    }

    public List<Map<String, Object>> getFileList() {
        return this.fileList;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setFileList(List<Map<String, Object>> list) {
        this.fileList = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
