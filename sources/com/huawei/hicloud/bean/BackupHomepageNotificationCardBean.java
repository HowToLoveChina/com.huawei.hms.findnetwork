package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class BackupHomepageNotificationCardBean {

    @SerializedName("notificationCards")
    private List<BackupHomepageNotificationCardItemBean> notificationCards;

    public List<BackupHomepageNotificationCardItemBean> getNotificationCards() {
        return this.notificationCards;
    }

    public void setNotificationCards(List<BackupHomepageNotificationCardItemBean> list) {
        this.notificationCards = list;
    }
}
