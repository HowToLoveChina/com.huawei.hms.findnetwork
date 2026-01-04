package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class ExtraNoticeConfiguration {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage commonLanguage;
    private List<ExtraNotificationBean> notification;

    public CommonLanguage getCommonLanguage() {
        return this.commonLanguage;
    }

    public List<ExtraNotificationBean> getNotification() {
        return this.notification;
    }

    public void setCommonLanguage(CommonLanguage commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    public void setNotification(List<ExtraNotificationBean> list) {
        this.notification = list;
    }
}
