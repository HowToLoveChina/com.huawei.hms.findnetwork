package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class TaskCenterWindow {

    @SerializedName(NotifyConstants.ACTIVITY_POPUP)
    private ActivePopup activityPopup;

    @SerializedName("buttons")
    private List<PopUpWithActivityGoto> buttons = null;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage language;

    public ActivePopup getActivityPopup() {
        return this.activityPopup;
    }

    public List<PopUpWithActivityGoto> getButtons() {
        return this.buttons;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public void setActivityPopup(ActivePopup activePopup) {
        this.activityPopup = activePopup;
    }

    public void setButtons(List<PopUpWithActivityGoto> list) {
        this.buttons = list;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }
}
