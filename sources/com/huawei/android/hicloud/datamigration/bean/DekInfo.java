package com.huawei.android.hicloud.datamigration.bean;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes3.dex */
public class DekInfo {
    private List<DekNode> dekList;
    private String service;
    private String table;
    private String userId;

    public List<DekNode> getDekList() {
        return this.dekList;
    }

    public String getService() {
        return this.service;
    }

    public String getTable() {
        return this.table;
    }

    public String getUserID() {
        return this.userId;
    }

    public void setDekList(List<DekNode> list) {
        this.dekList = list;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setTable(String str) {
        this.table = str;
    }

    public void setUserID(String str) {
        this.userId = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
