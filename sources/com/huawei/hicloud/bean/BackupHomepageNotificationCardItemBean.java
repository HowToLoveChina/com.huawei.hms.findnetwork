package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes6.dex */
public class BackupHomepageNotificationCardItemBean {

    @SerializedName("button")
    private String button;

    @SerializedName("content")
    private String content;

    @SerializedName(NotifyConstants.TYPE_DEEPLINK)
    private String deeplink;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    public String getButton() {
        return this.button;
    }

    public String getContent() {
        return this.content;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
