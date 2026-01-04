package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NoticeWithActivityGoto {

    @SerializedName("deeplink_uri")
    private String deeplinkUri;

    @SerializedName("noti_type")
    private String notiType;

    @SerializedName("noti_uri")
    private String notiUri;

    public String getDeeplinkUri() {
        return this.deeplinkUri;
    }

    public String getNotiType() {
        return this.notiType;
    }

    public String getNotiUri() {
        return this.notiUri;
    }

    public void setDeeplinkUri(String str) {
        this.deeplinkUri = str;
    }

    public void setNotiType(String str) {
        this.notiType = str;
    }

    public void setNotiUri(String str) {
        this.notiUri = str;
    }
}
