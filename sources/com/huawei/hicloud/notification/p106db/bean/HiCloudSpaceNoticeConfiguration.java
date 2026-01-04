package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class HiCloudSpaceNoticeConfiguration {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage commonLanguage;
    private List<SpaceNotification> notification;
    private List<NotificationWithActivity> notificationWithActivity;

    public CommonLanguage getCommonLanguage() {
        return this.commonLanguage;
    }

    public List<SpaceNotification> getNotification() {
        return this.notification;
    }

    public List<NotificationWithActivity> getNotificationWithActivity() {
        return this.notificationWithActivity;
    }

    public void setCommonLanguage(CommonLanguage commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    public void setNotification(List<SpaceNotification> list) {
        this.notification = list;
    }

    public void setNotificationWithActivity(List<NotificationWithActivity> list) {
        this.notificationWithActivity = list;
    }
}
