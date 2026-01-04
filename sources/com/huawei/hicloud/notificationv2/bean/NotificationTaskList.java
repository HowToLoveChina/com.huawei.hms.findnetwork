package com.huawei.hicloud.notificationv2.bean;

import androidx.annotation.Keep;
import java.util.List;
import p586qp.InterfaceC12382a;
import p714vp.AbstractC13477b;

@Keep
@InterfaceC12382a(name = "NotificationTaskList")
/* loaded from: classes6.dex */
public class NotificationTaskList extends AbstractC13477b {
    List<NotificationTask> mNotificationTaskList;

    public List<NotificationTask> getNotificationTaskList() {
        return this.mNotificationTaskList;
    }

    public void setNotificationTaskList(List<NotificationTask> list) {
        this.mNotificationTaskList = list;
    }
}
