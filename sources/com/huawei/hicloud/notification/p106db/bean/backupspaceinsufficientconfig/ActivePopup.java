package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;

/* loaded from: classes6.dex */
public class ActivePopup {

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_FIRST)
    private String buttonFirst;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_SECOND)
    private String buttonSecond;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String mainText;

    @SerializedName("title")
    private String title;

    public String getButtonFirst() {
        return this.buttonFirst;
    }

    public String getButtonSecond() {
        return this.buttonSecond;
    }

    public String getMainText() {
        return this.mainText;
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

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
