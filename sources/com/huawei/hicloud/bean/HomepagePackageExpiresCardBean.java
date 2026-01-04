package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class HomepagePackageExpiresCardBean {

    @SerializedName("items")
    private List<HomepagePackageExpiresCardItemBean> items;

    @SerializedName("title")
    private String title;

    @SerializedName("trigger")
    private String trigger;

    @SerializedName("type")
    private String type;

    public List<HomepagePackageExpiresCardItemBean> getItems() {
        return this.items;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public String getType() {
        return this.type;
    }

    public void setItems(List<HomepagePackageExpiresCardItemBean> list) {
        this.items = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
