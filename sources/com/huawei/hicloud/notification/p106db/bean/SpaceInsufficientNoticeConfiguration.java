package com.huawei.hicloud.notification.p106db.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class SpaceInsufficientNoticeConfiguration {
    private List<SpaceNotification> notification;
    private List<NotificationWithActivity> notificationWithActivity;
    private List<NotificationWithActivity> notificationWithTaskCenter;

    public List<SpaceNotification> getNotification() {
        return this.notification;
    }

    public List<NotificationWithActivity> getNotificationWithActivity() {
        return this.notificationWithActivity;
    }

    public List<NotificationWithActivity> getNotificationWithTaskCenter() {
        return this.notificationWithTaskCenter;
    }

    public void setNotification(List<SpaceNotification> list) {
        this.notification = list;
    }

    public void setNotificationWithActivity(List<NotificationWithActivity> list) {
        this.notificationWithActivity = list;
    }

    public void setNotificationWithTaskCenter(List<NotificationWithActivity> list) {
        this.notificationWithTaskCenter = list;
    }
}
