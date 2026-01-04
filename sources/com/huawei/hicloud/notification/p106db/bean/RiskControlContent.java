package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class RiskControlContent {

    @SerializedName("confirm_content")
    private String confirmContent;

    @SerializedName("confirm_desciption")
    private String confirmDes;

    @SerializedName("confirm_title")
    private String confirmTitle;

    @SerializedName("exit_content")
    private String exitContent;

    @SerializedName("exit_title")
    private String exitTitle;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String language;

    @SerializedName("notification_content")
    private String notificationContent;

    @SerializedName("notification_title")
    private String notificationTitle;

    @SerializedName("reconfirm_button_left")
    private String reconfirmButtonLeft;

    @SerializedName("reconfirm_button_right")
    private String reconfirmButtonRight;

    @SerializedName("reconfirm_content")
    private String reconfirmContent;

    public String getConfirmContent() {
        return this.confirmContent;
    }

    public String getConfirmDes() {
        return this.confirmDes;
    }

    public String getConfirmTitle() {
        return this.confirmTitle;
    }

    public String getExitContent() {
        return this.exitContent;
    }

    public String getExitTitle() {
        return this.exitTitle;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getNotificationContent() {
        return this.notificationContent;
    }

    public String getNotificationTitle() {
        return this.notificationTitle;
    }

    public String getReconfirmButtonLeft() {
        return this.reconfirmButtonLeft;
    }

    public String getReconfirmButtonRight() {
        return this.reconfirmButtonRight;
    }

    public String getReconfirmContent() {
        return this.reconfirmContent;
    }

    public void setConfirmContent(String str) {
        this.confirmContent = str;
    }

    public void setConfirmDes(String str) {
        this.confirmDes = str;
    }

    public void setConfirmTitle(String str) {
        this.confirmTitle = str;
    }

    public void setExitContent(String str) {
        this.exitContent = str;
    }

    public void setExitTitle(String str) {
        this.exitTitle = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setNotificationContent(String str) {
        this.notificationContent = str;
    }

    public void setNotificationTitle(String str) {
        this.notificationTitle = str;
    }

    public void setReconfirmButtonLeft(String str) {
        this.reconfirmButtonLeft = str;
    }

    public void setReconfirmButtonRight(String str) {
        this.reconfirmButtonRight = str;
    }

    public void setReconfirmContent(String str) {
        this.reconfirmContent = str;
    }
}
