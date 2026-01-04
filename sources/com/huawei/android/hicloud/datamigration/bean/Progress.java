package com.huawei.android.hicloud.datamigration.bean;

import com.google.gson.Gson;

/* loaded from: classes3.dex */
public class Progress {
    private String cursor;
    private String location;
    private String service;
    private String table;
    private String userId;

    public String getCursor() {
        return this.cursor;
    }

    public String getLocation() {
        return this.location;
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

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setLocation(String str) {
        this.location = str;
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
