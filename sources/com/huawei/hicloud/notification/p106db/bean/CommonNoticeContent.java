package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;

/* loaded from: classes6.dex */
public class CommonNoticeContent {
    private static final String TAG = "CommonNoticeContent";

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_FIRST)
    private String buttonFirst;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_SECOND)
    private String buttonSecond;
    private String contentType;
    private String description;

    @SerializedName("description_second")
    private String descriptionSecond;
    private String language;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String mainText;

    @SerializedName("main_text_second")
    private String mainTextSecond;

    @SerializedName("remind_mode")
    private String remindMode;

    @SerializedName("sub_title")
    private String subTitle;
    private String title;

    public String getButtonFirst() {
        return this.buttonFirst;
    }

    public String getButtonSecond() {
        return this.buttonSecond;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescriptionSecond() {
        return this.descriptionSecond;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getMainTextSecond() {
        return this.mainTextSecond;
    }

    public String getRemindMode() {
        return this.remindMode;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtonFirst(String str) {
        this.buttonFirst = str;
    }

    public void setButtonSecond(String str) {
        this.buttonSecond = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDescriptionSecond(String str) {
        this.descriptionSecond = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setMainTextSecond(String str) {
        this.mainTextSecond = str;
    }

    public void setRemindMode(String str) {
        this.remindMode = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
