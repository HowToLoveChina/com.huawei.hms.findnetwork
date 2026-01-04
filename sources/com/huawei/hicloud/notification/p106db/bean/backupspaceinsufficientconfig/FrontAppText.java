package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes6.dex */
public class FrontAppText {

    @SerializedName("frontapp_entrance_button")
    private String frontappEntranceButton;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.FRONT_APP_ENTRANCE_TEXT)
    private String frontappEntranceText;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_ENTRANCE_TEXT_SECOND)
    private String frontappEntranceTextSecond;

    @SerializedName("frontapp_entrance_title")
    private String frontappEntranceTitle;

    @SerializedName("frontapp_single_button")
    private String frontappSingleButton;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_SINGLE_TEXT)
    private String frontappSingleText;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_SINGLE_TITLE)
    private String frontappSingleTitle;

    public String getFrontappEntranceButton() {
        return this.frontappEntranceButton;
    }

    public String getFrontappEntranceText() {
        return this.frontappEntranceText;
    }

    public String getFrontappEntranceTextSecond() {
        return this.frontappEntranceTextSecond;
    }

    public String getFrontappEntranceTitle() {
        return this.frontappEntranceTitle;
    }

    public String getFrontappSingleButton() {
        return this.frontappSingleButton;
    }

    public String getFrontappSingleText() {
        return this.frontappSingleText;
    }

    public String getFrontappSingleTitle() {
        return this.frontappSingleTitle;
    }

    public void setFrontappEntranceButton(String str) {
        this.frontappEntranceButton = str;
    }

    public void setFrontappEntranceText(String str) {
        this.frontappEntranceText = str;
    }

    public void setFrontappEntranceTextSecond(String str) {
        this.frontappEntranceTextSecond = str;
    }

    public void setFrontappEntranceTitle(String str) {
        this.frontappEntranceTitle = str;
    }

    public void setFrontappSingleButton(String str) {
        this.frontappSingleButton = str;
    }

    public void setFrontappSingleText(String str) {
        this.frontappSingleText = str;
    }

    public void setFrontappSingleTitle(String str) {
        this.frontappSingleTitle = str;
    }
}
