package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.config.BaseGoto;

/* loaded from: classes6.dex */
public class NoticeGoto extends BaseGoto {

    @SerializedName("goto_button_which")
    private String gotoButtonWhich;

    @SerializedName("noti_deeplink")
    private String notiDeeplink;

    @SerializedName("noti_type")
    private String notiType;

    @SerializedName("noti_uri")
    private String notiUri;

    @SerializedName("popup_deeplink")
    private String popupDeeplink;

    @SerializedName("popup_type")
    private String popupType;

    @SerializedName("popup_uri")
    private String popupUri;

    public String getGotoButtonWhich() {
        return this.gotoButtonWhich;
    }

    public String getNotiDeeplink() {
        return this.notiDeeplink;
    }

    public String getNotiType() {
        return this.notiType;
    }

    public String getNotiUri() {
        return this.notiUri;
    }

    public String getPopupDeeplink() {
        return this.popupDeeplink;
    }

    public String getPopupType() {
        return this.popupType;
    }

    public String getPopupUri() {
        return this.popupUri;
    }

    public void setGotoButtonWhich(String str) {
        this.gotoButtonWhich = str;
    }

    public void setNotiDeeplink(String str) {
        this.notiDeeplink = str;
    }

    public void setNotiType(String str) {
        this.notiType = str;
    }

    public void setNotiUri(String str) {
        this.notiUri = str;
    }

    public void setPopupDeeplink(String str) {
        this.popupDeeplink = str;
    }

    public void setPopupType(String str) {
        this.popupType = str;
    }

    public void setPopupUri(String str) {
        this.popupUri = str;
    }
}
