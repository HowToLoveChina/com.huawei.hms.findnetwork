package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class HomepageSwitchNotice {

    /* renamed from: id */
    @SerializedName("id")
    private String f22654id;

    @SerializedName("mainText")
    private String mainText;

    @SerializedName("priority")
    private int priority;

    @SerializedName("title")
    private String title;

    public String getId() {
        return this.f22654id;
    }

    public String getMainText() {
        return this.mainText;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(String str) {
        this.f22654id = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
