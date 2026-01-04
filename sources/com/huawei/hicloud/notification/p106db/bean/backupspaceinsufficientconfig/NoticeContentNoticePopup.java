package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes6.dex */
public class NoticeContentNoticePopup extends NoticeContentNoticeNotification {

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_FIRST)
    private String buttonFirst;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_SECOND)
    private String buttonSecond;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_THIRD)
    private String buttonThird;

    public String getButtonFirst() {
        return this.buttonFirst;
    }

    public String getButtonSecond() {
        return this.buttonSecond;
    }

    public String getButtonThird() {
        return this.buttonThird;
    }

    public void setButtonFirst(String str) {
        this.buttonFirst = str;
    }

    public void setButtonSecond(String str) {
        this.buttonSecond = str;
    }

    public void setButtonThird(String str) {
        this.buttonThird = str;
    }
}
