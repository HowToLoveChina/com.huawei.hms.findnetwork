package com.huawei.hicloud.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class App {

    /* renamed from: id */
    private String f22225id;
    private String userId;
    private String version;

    public String getId() {
        return this.f22225id;
    }

    public String getUserID() {
        return this.userId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setId(String str) {
        this.f22225id = str;
    }

    public void setUserID(String str) {
        this.userId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
