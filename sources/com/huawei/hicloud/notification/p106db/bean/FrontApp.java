package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class FrontApp {

    @SerializedName("application")
    private String application;

    @SerializedName("indexId")
    private String indexId;

    @SerializedName("name")
    private String name;

    @SerializedName("text")
    private String text;

    public String getApplication() {
        return this.application;
    }

    public String getIndexId() {
        return this.indexId;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public void setApplication(String str) {
        this.application = str;
    }

    public void setIndexId(String str) {
        this.indexId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
