package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PopUpWithActivityGoto {

    @SerializedName("code")
    private String code;

    @SerializedName("deeplink_uri")
    private String deeplinkUri;

    @SerializedName("popup_type")
    private String popupType;

    @SerializedName("popup_uri")
    private String popupUri;

    @SerializedName("position")
    private Integer position;

    public String getCode() {
        return this.code;
    }

    public String getDeeplinkUri() {
        return this.deeplinkUri;
    }

    public String getPopupType() {
        return this.popupType;
    }

    public String getPopupUri() {
        return this.popupUri;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDeeplinkUri(String str) {
        this.deeplinkUri = str;
    }

    public void setPopupType(String str) {
        this.popupType = str;
    }

    public void setPopupUri(String str) {
        this.popupUri = str;
    }

    public void setPosition(Integer num) {
        this.position = num;
    }
}
